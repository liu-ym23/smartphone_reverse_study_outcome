package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicates;
import com.google.common.base.Stopwatch;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSetMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.MultimapBuilder;
import com.google.common.collect.Multimaps;
import com.google.common.collect.Multiset;
import com.google.common.collect.Ordering;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.UnmodifiableIterator;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes3.dex */
@Beta
@GwtIncompatible
public final class ServiceManager {
    private static final ListenerCallQueue.Event<Listener> HEALTHY_EVENT = null;
    private static final ListenerCallQueue.Event<Listener> STOPPED_EVENT = null;
    private static final Logger logger = null;
    private final ImmutableList<Service> services;
    private final ServiceManagerState state;

    public static final class EmptyServiceManagerWarning extends Throwable {
        private EmptyServiceManagerWarning() {
        }

        public /* synthetic */ EmptyServiceManagerWarning(AnonymousClass1 r10) {
            this();
        }
    }

    @Beta
    public static abstract class Listener {
        public Listener() {
        }

        public void failure(Service r10) {
        }

        public void healthy() {
        }

        public void stopped() {
        }
    }

    public static final class NoOpService extends AbstractService {
        private NoOpService() {
        }

        @Override // com.google.common.util.concurrent.AbstractService
        public void doStart() {
            notifyStarted();
        }

        @Override // com.google.common.util.concurrent.AbstractService
        public void doStop() {
            notifyStopped();
        }

        public /* synthetic */ NoOpService(AnonymousClass1 r10) {
            this();
        }
    }

    public static final class ServiceListener extends Service.Listener {
        final Service service;
        final WeakReference<ServiceManagerState> state;

        public ServiceListener(Service r10, WeakReference<ServiceManagerState> r11) {
            this.service = r10;
            this.state = r11;
        }

        @Override // com.google.common.util.concurrent.Service.Listener
        public void failed(Service.State r10, Throwable r11) {
            ServiceManagerState r12 = this.state.get();
            if (r12 != null) goto L5;
            return;
        L5:
            if ((this.service instanceof NoOpService) == true) goto L7;
            ServiceManager.access$200().log(Level.SEVERE, "Service " + this.service + " has failed in the " + r10 + " state.", r11);
        L7:
            r12.transitionService(this.service, r10, Service.State.FAILED);
        }

        @Override // com.google.common.util.concurrent.Service.Listener
        public void running() {
            ServiceManagerState r10 = this.state.get();
            if (r10 == null) goto L6;
            r10.transitionService(this.service, Service.State.STARTING, Service.State.RUNNING);
            return;
        }

        @Override // com.google.common.util.concurrent.Service.Listener
        public void starting() {
            ServiceManagerState r10 = this.state.get();
            if (r10 == null) goto L8;
            r10.transitionService(this.service, Service.State.NEW, Service.State.STARTING);
            if ((this.service instanceof NoOpService) == true) goto L9;
            ServiceManager.access$200().log(Level.FINE, "Starting {0}.", this.service);
            return;
        L9:
            return;
        }

        @Override // com.google.common.util.concurrent.Service.Listener
        public void stopping(Service.State r10) {
            ServiceManagerState r11 = this.state.get();
            if (r11 == null) goto L6;
            r11.transitionService(this.service, r10, Service.State.STOPPING);
            return;
        }

        @Override // com.google.common.util.concurrent.Service.Listener
        public void terminated(Service.State r10) {
            ServiceManagerState r11 = this.state.get();
            if (r11 != null) goto L5;
            return;
        L5:
            if ((this.service instanceof NoOpService) == true) goto L7;
            ServiceManager.access$200().log(Level.FINE, "Service {0} has terminated. Previous state was: {1}", new Object[]{this.service, r10});
        L7:
            r11.transitionService(this.service, r10, Service.State.TERMINATED);
        }
    }

    public static final class ServiceManagerState {
        final Monitor.Guard awaitHealthGuard;
        final ListenerCallQueue<Listener> listeners;
        final Monitor monitor;
        final int numberOfServices;

        @GuardedBy("monitor")
        boolean ready;

        @GuardedBy("monitor")
        final SetMultimap<Service.State, Service> servicesByState;

        @GuardedBy("monitor")
        final Map<Service, Stopwatch> startupTimers;

        @GuardedBy("monitor")
        final Multiset<Service.State> states;
        final Monitor.Guard stoppedGuard;

        @GuardedBy("monitor")
        boolean transitioned;

        public final class AwaitHealthGuard extends Monitor.Guard {
            final /* synthetic */ ServiceManagerState this$0;

            public AwaitHealthGuard(ServiceManagerState r10) {
                this.this$0 = r10;
                super(r10.monitor);
            }

            @Override // com.google.common.util.concurrent.Monitor.Guard
            @GuardedBy("ServiceManagerState.this.monitor")
            public boolean isSatisfied() {
                int r10 = this.this$0.states.count(Service.State.RUNNING);
                ServiceManagerState r11 = this.this$0;
                if (r10 != r11.numberOfServices) goto L5;
            L12:
                return true;
            L5:
                if (r11.states.contains(Service.State.STOPPING) == true) goto L12;
                if (this.this$0.states.contains(Service.State.TERMINATED) == true) goto L12;
                if (this.this$0.states.contains(Service.State.FAILED) == true) goto L12;
                return false;
            }
        }

        public final class StoppedGuard extends Monitor.Guard {
            final /* synthetic */ ServiceManagerState this$0;

            public StoppedGuard(ServiceManagerState r10) {
                this.this$0 = r10;
                super(r10.monitor);
            }

            @Override // com.google.common.util.concurrent.Monitor.Guard
            @GuardedBy("ServiceManagerState.this.monitor")
            public boolean isSatisfied() {
                if ((this.this$0.states.count(Service.State.TERMINATED) + this.this$0.states.count(Service.State.FAILED)) != this.this$0.numberOfServices) goto L5;
                return true;
            L5:
                return false;
            }
        }

        public ServiceManagerState(ImmutableCollection<Service> r10) {
            this.monitor = new Monitor();
            SetMultimap<Service.State, Service> r11 = MultimapBuilder.enumKeys(Service.State.class).linkedHashSetValues().build();
            this.servicesByState = r11;
            this.states = r11.keys();
            this.startupTimers = Maps.newIdentityHashMap();
            this.awaitHealthGuard = new AwaitHealthGuard(this);
            this.stoppedGuard = new StoppedGuard(this);
            this.listeners = new ListenerCallQueue();
            this.numberOfServices = r10.size();
            r11.putAll(Service.State.NEW, r10);
        }

        public void addListener(Listener r10, Executor r11) {
            this.listeners.addListener(r10, r11);
        }

        public void awaitHealthy() {
            this.monitor.enterWhenUninterruptibly(this.awaitHealthGuard);
            checkHealthy();     // Catch: Throwable -> L6
            this.monitor.leave();
            return;
        L6:
            th = move-exception;
            this.monitor.leave();
            throw th;
        }

        public void awaitStopped() {
            this.monitor.enterWhenUninterruptibly(this.stoppedGuard);
            this.monitor.leave();
        }

        @GuardedBy("monitor")
        public void checkHealthy() {
            Multiset<Service.State> r10 = this.states;
            Service.State r11 = Service.State.RUNNING;
            if (r10.count(r11) != this.numberOfServices) goto L6;
            return;
        L6:
            throw new IllegalStateException("Expected to be healthy after starting. The following services are not running: " + Multimaps.filterKeys(this.servicesByState, Predicates.not(Predicates.equalTo(r11))));
        }

        public void dispatchListenerEvents() {
            Preconditions.checkState(!this.monitor.isOccupiedByCurrentThread(), "It is incorrect to execute listeners with the monitor held.");
            this.listeners.dispatch();
        }

        public void enqueueFailedEvent(final Service r10) {
            this.listeners.enqueue(new AnonymousClass2(this, r10));
        }

        public void enqueueHealthyEvent() {
            this.listeners.enqueue(ServiceManager.access$400());
        }

        public void enqueueStoppedEvent() {
            this.listeners.enqueue(ServiceManager.access$300());
        }

        public void markReady() {
            this.monitor.enter();
        L8:
            th = move-exception;
            this.monitor.leave();
            throw th;
        L4:
            if (this.transitioned == true) goto L10;
            this.ready = true;     // Catch: Throwable -> L8
            this.monitor.leave();
            return;
        L10:
            ArrayList r10 = Lists.newArrayList();     // Catch: Throwable -> L8
            UnmodifiableIterator<Service> r11 = servicesByState().values().iterator();     // Catch: Throwable -> L8
        L12:
            if (r11.hasNext() == false) goto L17;
            Service r12 = r11.next();     // Catch: Throwable -> L8
            if (r12.state() == Service.State.NEW) goto L12;
            r10.add(r12);     // Catch: Throwable -> L8
            goto L12
        L17:
            throw new IllegalArgumentException("Services started transitioning asynchronously before the ServiceManager was constructed: " + r10);     // Catch: Throwable -> L8
        }

        public ImmutableMultimap<Service.State, Service> servicesByState() {
            ImmutableSetMultimap.Builder r10 = ImmutableSetMultimap.builder();
            this.monitor.enter();
            Iterator<Map.Entry<Service.State, Service>> r11 = this.servicesByState.entries().iterator();     // Catch: Throwable -> L10
        L5:
            if (r11.hasNext() == false) goto L12;
            Map.Entry<Service.State, Service> r12 = r11.next();     // Catch: Throwable -> L10
            if ((r12.getValue() instanceof NoOpService) == true) goto L5;
            r10.put(r12);     // Catch: Throwable -> L10
            goto L5
        L12:
            this.monitor.leave();
            return r10.build();
        L10:
            th = move-exception;
            this.monitor.leave();
            throw th;
        }

        public ImmutableMap<Service, Long> startupTimes() {
            this.monitor.enter();
            ArrayList r10 = Lists.newArrayListWithCapacity(this.startupTimers.size());     // Catch: Throwable -> L12
            Iterator<Map.Entry<Service, Stopwatch>> r11 = this.startupTimers.entrySet().iterator();     // Catch: Throwable -> L12
        L5:
            if (r11.hasNext() == false) goto L14;
            Map.Entry<Service, Stopwatch> r12 = r11.next();     // Catch: Throwable -> L12
            Service r13 = r12.getKey();     // Catch: Throwable -> L12
            Stopwatch r14 = r12.getValue();     // Catch: Throwable -> L12
            if (r14.isRunning() == true) goto L5;
            if ((r13 instanceof NoOpService) == true) goto L5;
            r10.add(Maps.immutableEntry(r13, Long.valueOf(r14.elapsed(TimeUnit.MILLISECONDS))));     // Catch: Throwable -> L12
            goto L5
        L14:
            this.monitor.leave();
            Collections.sort(r10, Ordering.natural().onResultOf(new AnonymousClass1(this)));
            return ImmutableMap.copyOf(r10);
        L12:
            th = move-exception;
            this.monitor.leave();
            throw th;
        }

        public void transitionService(Service r10, Service.State r11, Service.State r12) {
            Preconditions.checkNotNull(r10);
            if (r11 == r12) goto L5;
            boolean r13 = true;
        L6:
            Preconditions.checkArgument(r13);
            this.monitor.enter();
            this.transitioned = true;     // Catch: Throwable -> L14
            if (this.ready == true) goto L11;
            this.monitor.leave();
            dispatchListenerEvents();
            return;
        L11:
            Preconditions.checkState(this.servicesByState.remove(r11, r10), "Service %s not at the expected location in the state map %s", r10, r11);     // Catch: Throwable -> L14
            Preconditions.checkState(this.servicesByState.put(r12, r10), "Service %s in the state map unexpectedly at %s", r10, r12);     // Catch: Throwable -> L14
            Stopwatch r14 = this.startupTimers.get(r10);     // Catch: Throwable -> L14
            if (r14 != null) goto L16;
            r14 = Stopwatch.createStarted();     // Catch: Throwable -> L14
            this.startupTimers.put(r10, r14);     // Catch: Throwable -> L14
        L16:
            Service.State r15 = Service.State.RUNNING;     // Catch: Throwable -> L14
            if (r12.compareTo(r15) >= 0) goto L19;
        L23:
            Service.State r16 = Service.State.FAILED;     // Catch: Throwable -> L14
            if (r12 != r16) goto L27;
            enqueueFailedEvent(r10);     // Catch: Throwable -> L14
        L27:
            if (this.states.count(r15) != this.numberOfServices) goto L30;
            enqueueHealthyEvent();     // Catch: Throwable -> L14
        L32:
            this.monitor.leave();
            dispatchListenerEvents();
            return;
        L30:
            if ((this.states.count(Service.State.TERMINATED) + this.states.count(r16)) != this.numberOfServices) goto L32;
            enqueueStoppedEvent();     // Catch: Throwable -> L14
            goto L32
        L19:
            if (r14.isRunning() == false) goto L23;
            r14.stop();     // Catch: Throwable -> L14
            if ((r10 instanceof NoOpService) == true) goto L23;
            ServiceManager.access$200().log(Level.FINE, "Started {0} in {1}.", new Object[]{r10, r14});     // Catch: Throwable -> L14
        L14:
            th = move-exception;
            this.monitor.leave();
            dispatchListenerEvents();
            throw th;
        L5:
            r13 = false;
            goto L6
        }

        public void tryStartTiming(Service r10) {
            this.monitor.enter();
        L7:
            th = move-exception;
            this.monitor.leave();
            throw th;
        L4:
            if (this.startupTimers.get(r10) != null) goto L9;
            this.startupTimers.put(r10, Stopwatch.createStarted());     // Catch: Throwable -> L7
        L9:
            this.monitor.leave();
        }

        public void awaitStopped(long r10, TimeUnit r11) throws TimeoutException {
            this.monitor.enter();
        L9:
            th = move-exception;
            this.monitor.leave();
            throw th;
        L4:
            if (this.monitor.waitForUninterruptibly(this.stoppedGuard, r10, r11) == false) goto L8;
            this.monitor.leave();
            return;
        L8:
            throw new TimeoutException("Timeout waiting for the services to stop. The following services have not stopped: " + Multimaps.filterKeys(this.servicesByState, Predicates.not(Predicates.in(EnumSet.of(Service.State.TERMINATED, Service.State.FAILED)))));     // Catch: Throwable -> L9
        }

        public void awaitHealthy(long r10, TimeUnit r11) throws TimeoutException {
            this.monitor.enter();
        L8:
            th = move-exception;
            this.monitor.leave();
            throw th;
        L4:
            if (this.monitor.waitForUninterruptibly(this.awaitHealthGuard, r10, r11) == false) goto L11;
            checkHealthy();     // Catch: Throwable -> L8
            this.monitor.leave();
            return;
        L11:
            throw new TimeoutException("Timeout waiting for the services to become healthy. The following services have not started: " + Multimaps.filterKeys(this.servicesByState, Predicates.in(ImmutableSet.of(Service.State.NEW, Service.State.STARTING))));     // Catch: Throwable -> L8
        }
    }

    static {
        logger = Logger.getLogger(ServiceManager.class.getName());
        HEALTHY_EVENT = new AnonymousClass1();
        STOPPED_EVENT = new AnonymousClass2();
    }

    public ServiceManager(Iterable<? extends Service> r10) {
        ImmutableList<Service> r11 = ImmutableList.copyOf(r10);
        if (r11.isEmpty() == false) goto L5;
        AnonymousClass1 r12 = null;
        logger.log(Level.WARNING, "ServiceManager configured with no services.  Is your application configured properly?", new EmptyServiceManagerWarning(r12));
        r11 = ImmutableList.of(new NoOpService(r12));
    L5:
        ServiceManagerState r13 = new ServiceManagerState(r11);
        this.state = r13;
        this.services = r11;
        WeakReference r14 = new WeakReference(r13);
        UnmodifiableIterator<Service> r15 = r11.iterator();
    L7:
        if (r15.hasNext() == false) goto L13;
        Service r16 = r15.next();
        r16.addListener(new ServiceListener(r16, r14), MoreExecutors.directExecutor());
        if (r16.state() != Service.State.NEW) goto L11;
        boolean r17 = true;
    L12:
        Preconditions.checkArgument(r17, "Can only manage NEW services, %s", r16);
        goto L7
    L11:
        r17 = false;
        goto L12
    L13:
        this.state.markReady();
    }

    public static /* synthetic */ Logger access$200() {
        return logger;
    }

    public static /* synthetic */ ListenerCallQueue.Event access$300() {
        return STOPPED_EVENT;
    }

    public static /* synthetic */ ListenerCallQueue.Event access$400() {
        return HEALTHY_EVENT;
    }

    public void addListener(Listener r10, Executor r11) {
        this.state.addListener(r10, r11);
    }

    public void awaitHealthy() {
        this.state.awaitHealthy();
    }

    public void awaitStopped() {
        this.state.awaitStopped();
    }

    public boolean isHealthy() {
        UnmodifiableIterator<Service> r10 = this.services.iterator();
    L4:
        if (r10.hasNext() == false) goto L9;
        if (r10.next().isRunning() == true) goto L4;
        return false;
    L9:
        return true;
    }

    public ImmutableMultimap<Service.State, Service> servicesByState() {
        return this.state.servicesByState();
    }

    @CanIgnoreReturnValue
    public ServiceManager startAsync() {
        UnmodifiableIterator<Service> r10 = this.services.iterator();
    L4:
        if (r10.hasNext() == false) goto L10;
        Service r11 = r10.next();
        Service.State r12 = r11.state();
        if (r12 != Service.State.NEW) goto L8;
        boolean r13 = true;
    L9:
        Preconditions.checkState(r13, "Service %s is %s, cannot start it.", r11, r12);
        goto L4
    L8:
        r13 = false;
        goto L9
    L10:
        UnmodifiableIterator<Service> r14 = this.services.iterator();
    L12:
        if (r14.hasNext() == false) goto L18;
        Service r15 = r14.next();
        this.state.tryStartTiming(r15);     // Catch: IllegalStateException -> L16
        r15.startAsync();     // Catch: IllegalStateException -> L16
    L16:
        e = move-exception;
        logger.log(Level.WARNING, "Unable to start Service " + r15, e);
        goto L12
    L18:
        return this;
    }

    public ImmutableMap<Service, Long> startupTimes() {
        return this.state.startupTimes();
    }

    @CanIgnoreReturnValue
    public ServiceManager stopAsync() {
        UnmodifiableIterator<Service> r10 = this.services.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        r10.next().stopAsync();
        goto L4
    L6:
        return this;
    }

    public String toString() {
        return MoreObjects.toStringHelper(ServiceManager.class).add("services", Collections2.filter(this.services, Predicates.not(Predicates.instanceOf(NoOpService.class)))).toString();
    }

    public void addListener(Listener r10) {
        this.state.addListener(r10, MoreExecutors.directExecutor());
    }

    public void awaitHealthy(long r10, TimeUnit r11) throws TimeoutException {
        this.state.awaitHealthy(r10, r11);
    }

    public void awaitStopped(long r10, TimeUnit r11) throws TimeoutException {
        this.state.awaitStopped(r10, r11);
    }
}
