package com.google.common.util.concurrent;

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
import com.google.common.collect.Multimaps;
import com.google.common.collect.Multiset;
import com.google.common.collect.Ordering;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.UnmodifiableIterator;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public final class ServiceManager {
    private static final ListenerCallQueue.Callback<Listener> HEALTHY_CALLBACK = null;
    private static final ListenerCallQueue.Callback<Listener> STOPPED_CALLBACK = null;
    private static final Logger logger = null;
    private final ImmutableList<Service> services;
    private final ServiceManagerState state;

    private static final class EmptyServiceManagerWarning extends Throwable {
        private EmptyServiceManagerWarning() {
        }

        /* synthetic */ EmptyServiceManagerWarning(AnonymousClass1 r1) {
            this();
        }
    }

    public static abstract class Listener {
        public void failure(Service r1) {
        }

        public void healthy() {
        }

        public void stopped() {
        }

        public Listener() {
        }
    }

    private static final class NoOpService extends AbstractService {
        private NoOpService() {
        }

        /* synthetic */ NoOpService(AnonymousClass1 r1) {
            this();
        }

        @Override // com.google.common.util.concurrent.AbstractService
        protected void doStart() {
            notifyStarted();
        }

        @Override // com.google.common.util.concurrent.AbstractService
        protected void doStop() {
            notifyStopped();
        }
    }

    private static final class ServiceListener extends Service.Listener {
        final Service service;
        final WeakReference<ServiceManagerState> state;

        ServiceListener(Service r1, WeakReference<ServiceManagerState> r2) {
            this.service = r1;
            this.state = r2;
        }

        @Override // com.google.common.util.concurrent.Service.Listener
        public void starting() {
            ServiceManagerState r0 = this.state.get();
            if (r0 == null) goto L8;
            r0.transitionService(this.service, Service.State.NEW, Service.State.STARTING);
            if ((this.service instanceof NoOpService) == true) goto L9;
            ServiceManager.access$200().log(Level.FINE, "Starting {0}.", this.service);
            return;
        L9:
            return;
        }

        @Override // com.google.common.util.concurrent.Service.Listener
        public void running() {
            ServiceManagerState r0 = this.state.get();
            if (r0 == null) goto L6;
            r0.transitionService(this.service, Service.State.STARTING, Service.State.RUNNING);
            return;
        }

        @Override // com.google.common.util.concurrent.Service.Listener
        public void stopping(Service.State r3) {
            ServiceManagerState r0 = this.state.get();
            if (r0 == null) goto L6;
            r0.transitionService(this.service, r3, Service.State.STOPPING);
            return;
        }

        @Override // com.google.common.util.concurrent.Service.Listener
        public void terminated(Service.State r7) {
            ServiceManagerState r0 = this.state.get();
            if (r0 != null) goto L5;
            return;
        L5:
            if ((this.service instanceof NoOpService) == true) goto L7;
            ServiceManager.access$200().log(Level.FINE, "Service {0} has terminated. Previous state was: {1}", new Object[]{this.service, r7});
        L7:
            r0.transitionService(this.service, r7, Service.State.TERMINATED);
        }

        @Override // com.google.common.util.concurrent.Service.Listener
        public void failed(Service.State r6, Throwable r7) {
            ServiceManagerState r0 = this.state.get();
            if (r0 != null) goto L5;
            return;
        L5:
            if ((this.service instanceof NoOpService) == true) goto L7;
            ServiceManager.access$200().log(Level.SEVERE, "Service " + this.service + " has failed in the " + r6 + " state.", r7);
        L7:
            r0.transitionService(this.service, r6, Service.State.FAILED);
        }
    }

    private static final class ServiceManagerState {
        final Monitor.Guard awaitHealthGuard;
        final List<ListenerCallQueue<Listener>> listeners;
        final Monitor monitor;
        final int numberOfServices;
        boolean ready;
        final SetMultimap<Service.State, Service> servicesByState;
        final Map<Service, Stopwatch> startupTimers;
        final Multiset<Service.State> states;
        final Monitor.Guard stoppedGuard;
        boolean transitioned;

        ServiceManagerState(ImmutableCollection<Service> r4) {
            final Monitor r0 = new Monitor();
            this.monitor = r0;
            SetMultimap<Service.State, Service> r1 = Multimaps.newSetMultimap(new EnumMap(Service.State.class), new AnonymousClass1(this));
            this.servicesByState = r1;
            this.states = r1.keys();
            this.startupTimers = Maps.newIdentityHashMap();
            this.awaitHealthGuard = new AnonymousClass2(this, r0);
            this.stoppedGuard = new AnonymousClass3(this, r0);
            this.listeners = Collections.synchronizedList(new ArrayList());
            this.numberOfServices = r4.size();
            r1.putAll(Service.State.NEW, r4);
        }

        void tryStartTiming(Service r3) {
            this.monitor.enter();
        L8:
            th = move-exception;
            this.monitor.leave();
            throw th;
        L4:
            if (this.startupTimers.get(r3) != null) goto L6;
            this.startupTimers.put(r3, Stopwatch.createStarted());     // Catch: Throwable -> L8
        L6:
            this.monitor.leave();
        }

        void markReady() {
            this.monitor.enter();
        L16:
            th = move-exception;
            this.monitor.leave();
            throw th;
        L4:
            if (this.transitioned == true) goto L8;
            this.ready = true;     // Catch: Throwable -> L16
            this.monitor.leave();
            return;
        L8:
            ArrayList r0 = Lists.newArrayList();     // Catch: Throwable -> L16
            UnmodifiableIterator<Service> r1 = servicesByState().values().iterator();     // Catch: Throwable -> L16
        L10:
            if (r1.hasNext() == false) goto L15;
            Service r2 = r1.next();     // Catch: Throwable -> L16
            if (r2.state() == Service.State.NEW) goto L10;
            r0.add(r2);     // Catch: Throwable -> L16
            goto L10
        L15:
            throw new IllegalArgumentException("Services started transitioning asynchronously before the ServiceManager was constructed: " + r0);     // Catch: Throwable -> L16
        }

        void addListener(Listener r3, Executor r4) {
            Preconditions.checkNotNull(r3, "listener");
            Preconditions.checkNotNull(r4, "executor");
            this.monitor.enter();
        L8:
            th = move-exception;
            this.monitor.leave();
            throw th;
        L4:
            if (this.stoppedGuard.isSatisfied() == true) goto L6;
            this.listeners.add(new ListenerCallQueue(r3, r4));     // Catch: Throwable -> L8
        L6:
            this.monitor.leave();
        }

        void awaitHealthy() {
            this.monitor.enterWhenUninterruptibly(this.awaitHealthGuard);
            checkHealthy();     // Catch: Throwable -> L6
            this.monitor.leave();
            return;
        L6:
            th = move-exception;
            this.monitor.leave();
            throw th;
        }

        void awaitHealthy(long r4, TimeUnit r6) throws TimeoutException {
            this.monitor.enter();
        L10:
            th = move-exception;
            this.monitor.leave();
            throw th;
        L4:
            if (this.monitor.waitForUninterruptibly(this.awaitHealthGuard, r4, r6) == false) goto L9;
            checkHealthy();     // Catch: Throwable -> L10
            this.monitor.leave();
            return;
        L9:
            throw new TimeoutException("Timeout waiting for the services to become healthy. The following services have not started: " + Multimaps.filterKeys(this.servicesByState, Predicates.in(ImmutableSet.of(Service.State.NEW, Service.State.STARTING))));     // Catch: Throwable -> L10
        }

        void awaitStopped() {
            this.monitor.enterWhenUninterruptibly(this.stoppedGuard);
            this.monitor.leave();
        }

        void awaitStopped(long r4, TimeUnit r6) throws TimeoutException {
            this.monitor.enter();
        L9:
            th = move-exception;
            this.monitor.leave();
            throw th;
        L4:
            if (this.monitor.waitForUninterruptibly(this.stoppedGuard, r4, r6) == false) goto L8;
            this.monitor.leave();
            return;
        L8:
            throw new TimeoutException("Timeout waiting for the services to stop. The following services have not stopped: " + Multimaps.filterKeys(this.servicesByState, Predicates.not(Predicates.in(ImmutableSet.of(Service.State.TERMINATED, Service.State.FAILED)))));     // Catch: Throwable -> L9
        }

        ImmutableMultimap<Service.State, Service> servicesByState() {
            ImmutableSetMultimap.Builder r0 = ImmutableSetMultimap.builder();
            this.monitor.enter();
            Iterator<Map.Entry<Service.State, Service>> r1 = this.servicesByState.entries().iterator();     // Catch: Throwable -> L12
        L5:
            if (r1.hasNext() == false) goto L10;
            Map.Entry<Service.State, Service> r2 = r1.next();     // Catch: Throwable -> L12
            if ((r2.getValue() instanceof NoOpService) == true) goto L5;
            r0.put(r2.getKey(), r2.getValue());     // Catch: Throwable -> L12
            goto L5
        L10:
            this.monitor.leave();
            return r0.build();
        L12:
            th = move-exception;
            this.monitor.leave();
            throw th;
        }

        ImmutableMap<Service, Long> startupTimes() {
            this.monitor.enter();
            ArrayList r0 = Lists.newArrayListWithCapacity(this.startupTimers.size());     // Catch: Throwable -> L18
            Iterator<Map.Entry<Service, Stopwatch>> r1 = this.startupTimers.entrySet().iterator();     // Catch: Throwable -> L18
        L5:
            if (r1.hasNext() == false) goto L12;
            Map.Entry<Service, Stopwatch> r2 = r1.next();     // Catch: Throwable -> L18
            Service r3 = r2.getKey();     // Catch: Throwable -> L18
            Stopwatch r4 = r2.getValue();     // Catch: Throwable -> L18
            if (r4.isRunning() == true) goto L5;
            if ((r3 instanceof NoOpService) == true) goto L5;
            r0.add(Maps.immutableEntry(r3, Long.valueOf(r4.elapsed(TimeUnit.MILLISECONDS))));     // Catch: Throwable -> L18
            goto L5
        L12:
            this.monitor.leave();
            Collections.sort(r0, Ordering.natural().onResultOf(new AnonymousClass4(this)));
            ImmutableMap.Builder r6 = ImmutableMap.builder();
            Iterator r5 = r0.iterator();
        L14:
            if (r5.hasNext() == false) goto L17;
            r6.put((Map.Entry) r5.next());
            goto L14
        L17:
            return r6.build();
        L18:
            th = move-exception;
            this.monitor.leave();
            throw th;
        }

        void transitionService(Service r7, Service.State r8, Service.State r9) {
            Preconditions.checkNotNull(r7);
            if (r8 == r9) goto L5;
            boolean r2 = true;
        L6:
            Preconditions.checkArgument(r2);
            this.monitor.enter();
            this.transitioned = true;     // Catch: Throwable -> L32
            if (this.ready == true) goto L11;
            this.monitor.leave();
            executeListeners();
            return;
        L11:
            Preconditions.checkState(this.servicesByState.remove(r8, r7), "Service %s not at the expected location in the state map %s", new Object[]{r7, r8});     // Catch: Throwable -> L32
            Preconditions.checkState(this.servicesByState.put(r9, r7), "Service %s in the state map unexpectedly at %s", new Object[]{r7, r9});     // Catch: Throwable -> L32
            Stopwatch r10 = this.startupTimers.get(r7);     // Catch: Throwable -> L32
            if (r10 != null) goto L15;
            r10 = Stopwatch.createStarted();     // Catch: Throwable -> L32
            this.startupTimers.put(r7, r10);     // Catch: Throwable -> L32
        L15:
            if (r9.compareTo(Service.State.RUNNING) < 0) goto L22;
            if (r10.isRunning() == false) goto L22;
            r10.stop();     // Catch: Throwable -> L32
            if ((r7 instanceof NoOpService) == true) goto L22;
            ServiceManager.access$200().log(Level.FINE, "Started {0} in {1}.", new Object[]{r7, r10});     // Catch: Throwable -> L32
        L22:
            if (r9 != Service.State.FAILED) goto L25;
            fireFailedListeners(r7);     // Catch: Throwable -> L32
        L25:
            if (this.states.count(Service.State.RUNNING) != this.numberOfServices) goto L28;
            fireHealthyListeners();     // Catch: Throwable -> L32
        L30:
            this.monitor.leave();
            executeListeners();
            return;
        L28:
            if ((this.states.count(Service.State.TERMINATED) + this.states.count(Service.State.FAILED)) != this.numberOfServices) goto L30;
            fireStoppedListeners();     // Catch: Throwable -> L32
        L32:
            th = move-exception;
            this.monitor.leave();
            executeListeners();
            throw th;
        L5:
            r2 = false;
            goto L6
        }

        void fireStoppedListeners() {
            ServiceManager.access$300().enqueueOn(this.listeners);
        }

        void fireHealthyListeners() {
            ServiceManager.access$400().enqueueOn(this.listeners);
        }

        void fireFailedListeners(final Service r4) {
            final String r1 = "failed({service=" + r4 + "})";
            new AnonymousClass5(this, r1, r4).enqueueOn(this.listeners);
        }

        void executeListeners() {
            Preconditions.checkState(!this.monitor.isOccupiedByCurrentThread(), "It is incorrect to execute listeners with the monitor held.");
            int r0 = 0;
        L4:
            if (r0 >= this.listeners.size()) goto L6;
            this.listeners.get(r0).execute();
            r0 = r0 + 1;
            goto L4
        }

        void checkHealthy() {
            if (this.states.count(Service.State.RUNNING) != this.numberOfServices) goto L6;
            return;
        L6:
            throw new IllegalStateException("Expected to be healthy after starting. The following services are not running: " + Multimaps.filterKeys(this.servicesByState, Predicates.not(Predicates.equalTo(Service.State.RUNNING))));
        }
    }

    static /* synthetic */ Logger access$200() {
        return logger;
    }

    static /* synthetic */ ListenerCallQueue.Callback access$300() {
        return STOPPED_CALLBACK;
    }

    static /* synthetic */ ListenerCallQueue.Callback access$400() {
        return HEALTHY_CALLBACK;
    }

    static {
        logger = Logger.getLogger(ServiceManager.class.getName());
        final String r1 = "healthy()";
        HEALTHY_CALLBACK = new AnonymousClass1(r1);
        final String r2 = "stopped()";
        STOPPED_CALLBACK = new AnonymousClass2(r2);
    }

    public ServiceManager(Iterable<? extends Service> r7) {
        ImmutableList<Service> r8 = ImmutableList.copyOf(r7);
        if (r8.isEmpty() == false) goto L5;
        AnonymousClass1 r2 = null;
        logger.log(Level.WARNING, "ServiceManager configured with no services.  Is your application configured properly?", new EmptyServiceManagerWarning(r2));
        r8 = ImmutableList.of(new NoOpService(r2));
    L5:
        ServiceManagerState r0 = new ServiceManagerState(r8);
        this.state = r0;
        this.services = r8;
        WeakReference r1 = new WeakReference(r0);
        UnmodifiableIterator<Service> r9 = r8.iterator();
    L7:
        if (r9.hasNext() == false) goto L13;
        Service r3 = r9.next();
        r3.addListener(new ServiceListener(r3, r1), MoreExecutors.directExecutor());
        if (r3.state() != Service.State.NEW) goto L11;
        boolean r4 = true;
    L12:
        Preconditions.checkArgument(r4, "Can only manage NEW services, %s", new Object[]{r3});
        goto L7
    L11:
        r4 = false;
        goto L12
    L13:
        this.state.markReady();
    }

    public void addListener(Listener r1, Executor r2) {
        this.state.addListener(r1, r2);
    }

    public void addListener(Listener r2) {
        this.state.addListener(r2, MoreExecutors.directExecutor());
    }

    public ServiceManager startAsync() {
        UnmodifiableIterator<Service> r0 = this.services.iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        Service r1 = r0.next();
        Service.State r2 = r1.state();
        if (r2 != Service.State.NEW) goto L8;
        boolean r3 = true;
    L9:
        Preconditions.checkState(r3, "Service %s is %s, cannot start it.", new Object[]{r1, r2});
        goto L4
    L8:
        r3 = false;
        goto L9
    L10:
        UnmodifiableIterator<Service> r4 = this.services.iterator();
    L12:
        if (r4.hasNext() == false) goto L18;
        Service r5 = r4.next();
        this.state.tryStartTiming(r5);     // Catch: IllegalStateException -> L16
        r5.startAsync();     // Catch: IllegalStateException -> L16
    L16:
        e = move-exception;
        logger.log(Level.WARNING, "Unable to start Service " + r5, e);
        goto L12
    L18:
        return this;
    }

    public void awaitHealthy() {
        this.state.awaitHealthy();
    }

    public void awaitHealthy(long r1, TimeUnit r3) throws TimeoutException {
        this.state.awaitHealthy(r1, r3);
    }

    public ServiceManager stopAsync() {
        UnmodifiableIterator<Service> r0 = this.services.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().stopAsync();
        goto L4
    L6:
        return this;
    }

    public void awaitStopped() {
        this.state.awaitStopped();
    }

    public void awaitStopped(long r1, TimeUnit r3) throws TimeoutException {
        this.state.awaitStopped(r1, r3);
    }

    public boolean isHealthy() {
        UnmodifiableIterator<Service> r1 = this.services.iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        if (r1.next().isRunning() == true) goto L4;
        return false;
    L9:
        return true;
    }

    public ImmutableMultimap<Service.State, Service> servicesByState() {
        return this.state.servicesByState();
    }

    public ImmutableMap<Service, Long> startupTimes() {
        return this.state.startupTimes();
    }

    public String toString() {
        return MoreObjects.toStringHelper(ServiceManager.class).add("services", Collections2.filter(this.services, Predicates.not(Predicates.instanceOf(NoOpService.class)))).toString();
    }
}
