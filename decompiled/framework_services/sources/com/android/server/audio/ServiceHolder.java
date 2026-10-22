package com.android.server.audio;

import android.os.IBinder;
import android.os.IInterface;
import android.os.IServiceCallback;
import android.os.RemoteException;
import android.util.Log;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
public class ServiceHolder<I extends IInterface> implements IBinder.DeathRecipient {
    private final Function<? super IBinder, ? extends I> mCastFunction;
    private final Executor mExecutor;
    private final Set<Consumer<I>> mOnDeathTasks;
    private final Set<Consumer<I>> mOnStartTasks;
    private final AtomicReference<I> mService;
    private final IServiceCallback mServiceListener;
    private final String mServiceName;
    private final ServiceProviderFacade mServiceProvider;
    private final String mTag;

    public interface ServiceProviderFacade {
        IBinder checkService(String r1);

        void registerForNotifications(String r1, IServiceCallback r2);

        IBinder waitForService(String r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$FyV02pxhdgnfX1I6jqJTZEz-NV4, reason: not valid java name */
    public static /* synthetic */ void m2183$r8$lambda$FyV02pxhdgnfX1I6jqJTZEzNV4(Consumer r0, IInterface r1) {
        lambda$onServiceInited$2(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$Rpc5tugFjoOuuCPd1bNQArZZ9gg(Consumer r0, IInterface r1) {
        lambda$attemptClear$1(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$xJ2R2EH0DbZY1SSX__xoFcZLp5o(Consumer r0, IInterface r1) {
        lambda$registerOnStartTask$0(r0, r1);
    }

    /* JADX INFO: renamed from: -$$Nest$monServiceInited, reason: not valid java name */
    static /* bridge */ /* synthetic */ IInterface m2184$$Nest$monServiceInited(ServiceHolder r0, IBinder r1) {
        return r0.onServiceInited(r1);
    }

    public ServiceHolder(String serviceName, Function<? super IBinder, ? extends I> castFunction, Executor executor) {
        this(serviceName, castFunction, executor, new AnonymousClass2());
    }

    public ServiceHolder(String serviceName, Function<? super IBinder, ? extends I> castFunction, Executor executor, ServiceProviderFacade provider) {
        this.mService = new AtomicReference();
        this.mOnStartTasks = ConcurrentHashMap.newKeySet();
        this.mOnDeathTasks = ConcurrentHashMap.newKeySet();
        this.mServiceListener = new AnonymousClass1(this);
        serviceName.getClass();
        this.mServiceName = serviceName;
        castFunction.getClass();
        this.mCastFunction = castFunction;
        executor.getClass();
        this.mExecutor = executor;
        provider.getClass();
        this.mServiceProvider = provider;
        this.mTag = "ServiceHolder: " + serviceName;
        this.mServiceProvider.registerForNotifications(this.mServiceName, this.mServiceListener);
    }

    public void registerOnStartTask(final Consumer<I> task) {
        this.mOnStartTasks.add(task);
        final I i = this.mService.get();
        if (i == null) goto L6;
        this.mExecutor.execute(new ServiceHolder$$ExternalSyntheticLambda1(task, i));
        return;
    }

    private static /* synthetic */ void lambda$registerOnStartTask$0(Consumer task, IInterface i) {
        task.accept(i);
    }

    public void unregisterOnStartTask(Consumer<I> task) {
        this.mOnStartTasks.remove(task);
    }

    public void registerOnDeathTask(Consumer<I> task) {
        this.mOnDeathTasks.add(task);
    }

    public void unregisterOnDeathTask(Consumer<I> task) {
        this.mOnDeathTasks.remove(task);
    }

    @Override // android.os.IBinder.DeathRecipient
    public void binderDied(IBinder who) {
        attemptClear(who);
    }

    @Override // android.os.IBinder.DeathRecipient
    public void binderDied() {
        throw new AssertionError("Wrong binderDied called, this should never happen");
    }

    public void attemptClear(IBinder who) {
        final I current = this.mService.get();
        if (current != null) goto L5;
        return;
    L5:
        if (Objects.equals(current.asBinder(), who) == true) goto L7;
        return;
    L7:
        if (this.mService.compareAndSet(current, null) == false) goto L15;
        who.unlinkToDeath(this, 0);
        Iterator<Consumer<I>> r1 = this.mOnDeathTasks.iterator();
    L10:
        if (r1.hasNext() == false) goto L16;
        final Consumer<I> r = r1.next();
        this.mExecutor.execute(new ServiceHolder$$ExternalSyntheticLambda0(r, current));
        goto L10
    L16:
        return;
    }

    private static /* synthetic */ void lambda$attemptClear$1(Consumer r, IInterface current) {
        r.accept(current);
    }

    public I checkService() {
        I r0 = this.mService.get();
        if (r0 == null) goto L5;
        return r0;
    L5:
        IBinder r1 = this.mServiceProvider.checkService(this.mServiceName);
        if (r1 != null) goto L10;
        return null;
    L10:
        return (I) onServiceInited(r1);
    }

    public I waitForService() {
        I r0 = this.mService.get();
        if (r0 == null) goto L6;
        return r0;
    L6:
        return (I) onServiceInited(this.mServiceProvider.waitForService(this.mServiceName));
    }

    private I onServiceInited(IBinder who) {
        final I service = this.mCastFunction.apply(who);
        service.getClass();
        if (this.mService.compareAndSet(null, service) == true) goto L5;
        return service;
    L5:
        Iterator<Consumer<I>> r1 = this.mOnStartTasks.iterator();
    L7:
        if (r1.hasNext() == false) goto L15;
        final Consumer<I> r = r1.next();
        this.mExecutor.execute(new ServiceHolder$$ExternalSyntheticLambda2(r, service));
        goto L7
    L15:
        who.linkToDeath(this, 0);     // Catch: RemoteException -> L12
    L14:
        return service;
    L13:
        Log.e(this.mTag, "Immediate service death. Service crash-looping");
        attemptClear(who);
        goto L14
    }

    private static /* synthetic */ void lambda$onServiceInited$2(Consumer r, IInterface service) {
        r.accept(service);
    }
}
