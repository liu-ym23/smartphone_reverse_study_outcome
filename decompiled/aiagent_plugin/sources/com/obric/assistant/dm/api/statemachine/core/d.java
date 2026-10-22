package com.obric.assistant.dm.api.statemachine.core;

import com.obric.agent.complextask.IComplexTaskService;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.assistant.dm.api.statemachine.core.DMEvent;
import com.obric.assistant.dm.api.statemachine.core.State;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.aa;
import d.h.b.h;
import d.h.b.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: compiled from: StateMachine.kt */
/* JADX INFO: loaded from: classes3.dex */
public class d<S extends State, E extends DMEvent> {
    private static final String TAG = "StateMachine";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f22469a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f22470b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private S f22471c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ReentrantReadWriteLock f22472d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ConcurrentHashMap<String, List<f<S, E>>> f22473e;
    private final CopyOnWriteArrayList<e<S>> f;

    /* JADX INFO: compiled from: StateMachine.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        f22469a = new a(null);
    }

    /* JADX INFO: renamed from: lambda$f7CZl3Y-OHih7PAat7RBKTdkNbc, reason: not valid java name */
    public static /* synthetic */ List m408lambda$f7CZl3YOHih7PAat7RBKTdkNbc(String r0) {
        return a(r0);
    }

    public static /* synthetic */ List lambda$hRF1fiEUg2eqVM8mqzQvbhzdBPE(d.h.a.b r0, Object r1) {
        return a(r0, r1);
    }

    public d(S r2, String r3) {
        o.e(r2, "initialState");
        o.e(r3, "name");
        this.f22470b = r3;
        this.f22471c = r2;
        this.f22472d = new ReentrantReadWriteLock();
        this.f22473e = new ConcurrentHashMap();
        this.f = new CopyOnWriteArrayList();
    }

    public final S a() {
        ReentrantReadWriteLock.ReadLock r0 = this.f22472d.readLock();
        r0.lock();
        S r1 = this.f22471c;     // Catch: Throwable -> L6
        r0.unlock();
        return r1;
    L6:
        th = move-exception;
        r0.unlock();
        throw th;
    }

    public final boolean a(S r10, DMEvent r11) {
        o.e(r10, "newState");
        ReentrantReadWriteLock r0 = this.f22472d;
        ReentrantReadWriteLock.ReadLock r1 = r0.readLock();
        int r3 = 0;
        if (r0.getWriteHoldCount() != 0) goto L5;
        int r2 = r0.getReadHoldCount();
    L6:
        int r4 = 0;
    L7:
        if (r4 >= r2) goto L9;
        r1.unlock();
        r4 = r4 + 1;
        goto L7
    L9:
        ReentrantReadWriteLock.WriteLock r5 = r0.writeLock();
        r5.lock();
        S r6 = this.f22471c;     // Catch: Throwable -> L19
        if (o.a(r6, r10) == false) goto L13;
        boolean r9 = false;
    L15:
        if (r3 >= r2) goto L17;
        r1.lock();
        r3 = r3 + 1;
        goto L15
    L17:
        r5.unlock();
        return r9;
    L13:
        this.f22471c = r10;     // Catch: Throwable -> L19
        ILogDepend.Companion.i(TAG, '[' + this.f22470b + "] State replaced: " + r6.getStateName() + " -> " + r10.getStateName());     // Catch: Throwable -> L19
        a(r6, r10, r11);     // Catch: Throwable -> L19
        r9 = true;
    L19:
        th = move-exception;
    L20:
        if (r3 >= r2) goto L22;
        r1.lock();
        r3 = r3 + 1;
        goto L20
    L22:
        r5.unlock();
        throw th;
    L5:
        r2 = 0;
        goto L6
    }

    public final void a(f<S, E> r6) {
        f r7 = (f) ZeusTransformUtils.wrapperContextForParams(r6, f.class, "com.obric.aiagent.plugin");
        o.e(r7, "transition");
        String r0 = a(r7.a(), r7.c());
        ConcurrentHashMap<String, List<f<S, E>>> r2 = this.f22473e;
        final $$Lambda$d$f7CZl3YOHih7PAat7RBKTdkNbc r3 = $$Lambda$d$f7CZl3YOHih7PAat7RBKTdkNbc.INSTANCE;
        ((List) ZeusTransformUtils.preCheckCast(r2.computeIfAbsent(r0, new $$Lambda$d$hRF1fiEUg2eqVM8mqzQvbhzdBPE(r3)), List.class, "com.obric.aiagent.plugin")).add(r7);
        ILogDepend.Companion.d(TAG, '[' + this.f22470b + "] Added transition: " + r7.a().getSimpleName() + " -> " + r7.b().getSimpleName() + " on " + r7.c().getSimpleName());
    }

    private static final List a(d.h.a.b r2, Object r3) {
        return (List) ZeusTransformUtils.preCheckCast(((d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r2, d.h.a.b.class, "com.obric.aiagent.plugin")).invoke(r3), List.class, "com.obric.aiagent.plugin");
    }

    private static final List a(String r2) {
        o.e(r2, "it");
        return (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
    }

    public final void a(e<S> r4) {
        e<S> r5 = (e) ZeusTransformUtils.wrapperContextForParams(r4, e.class, "com.obric.aiagent.plugin");
        o.e(r5, "listener");
        this.f.add(r5);
        ILogDepend.Companion.d(TAG, '[' + this.f22470b + "] Added listener: " + aa.b(r5.getClass()).b());
    }

    public boolean a(E r15) {
        o.e(r15, "event");
        ReentrantReadWriteLock r2 = this.f22472d;
        ReentrantReadWriteLock.ReadLock r3 = r2.readLock();
        int r5 = 0;
        if (r2.getWriteHoldCount() != 0) goto L5;
        int r4 = r2.getReadHoldCount();
    L6:
        int r6 = 0;
    L7:
        if (r6 >= r4) goto L9;
        r3.unlock();
        r6 = r6 + 1;
        goto L7
    L9:
        ReentrantReadWriteLock.WriteLock r7 = r2.writeLock();
        r7.lock();
        S r8 = this.f22471c;     // Catch: Throwable -> L40
        List r9 = (List) ZeusTransformUtils.preCheckCast(this.f22473e.get(a(r8.getClass(), r15.getClass())), List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L40
        if (r9 != null) goto L13;
        r9 = p.b();     // Catch: Throwable -> L40
    L13:
        ILogDepend.Companion.i(TAG, '[' + this.f22470b + "] Handling event: " + r15.getEventName() + " in state: " + r8.getStateName());     // Catch: Throwable -> L40
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Throwable -> L40
    L15:
        if (r10.hasNext() == false) goto L26;
        Object r11 = r10.next();     // Catch: Throwable -> L40
        boolean r12 = ((f) ZeusTransformUtils.preCheckCast(r11, f.class, "com.obric.aiagent.plugin")).a(r8, r15);     // Catch: Exception -> L19 Throwable -> L40
    L24:
        if (r12 == false) goto L15;
    L27:
        f r13 = (f) ZeusTransformUtils.preCheckCast(r11, f.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L40
        if (r13 != null) goto L46;
        IComplexTaskService r14 = (IComplexTaskService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IComplexTaskService.class), IComplexTaskService.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L40
        if (r14 != null) goto L34;
    L31:
        boolean r16 = false;
    L36:
        if (r5 >= r4) goto L38;
        r3.lock();
        r5 = r5 + 1;
        goto L36
    L38:
        r7.unlock();
        return r16;
    L34:
        r14.reportChangeTransitionFailed(r8.getStateName(), r15.getEventName());     // Catch: Throwable -> L40
        goto L31
    L46:
        r13.c(r8, r15);     // Catch: Exception -> L45 Throwable -> L40
        S r1 = (S) r13.b(r8, r15);
        S r17 = this.f22471c;     // Catch: Exception -> L45 Throwable -> L40
        this.f22471c = r1;     // Catch: Exception -> L45 Throwable -> L40
        ILogDepend.Companion.i(TAG, '[' + this.f22470b + "] State transition: " + r17.getStateName() + " -> " + r1.getStateName());     // Catch: Exception -> L45 Throwable -> L40
        r13.a(r17, r1, r15);     // Catch: Exception -> L45 Throwable -> L40
        a(r17, r1, r15);     // Catch: Exception -> L45 Throwable -> L40
        r16 = true;
    L19:
        e = move-exception;
        ILogDepend.Companion.e(TAG, '[' + this.f22470b + "] Error checking transition: " + e.getMessage(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L40
        IComplexTaskService r18 = (IComplexTaskService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IComplexTaskService.class), IComplexTaskService.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L40
        if (r18 == null) goto L23;
        r18.reportChangeTransitionFailed(r8.getStateName(), r15.getEventName());     // Catch: Throwable -> L40
    L23:
        a(r8, r15, e);     // Catch: Throwable -> L40
        r12 = false;
        goto L24
    L26:
        r11 = null;
    L40:
        th = move-exception;
    L41:
        if (r5 >= r4) goto L43;
        r3.lock();
        r5 = r5 + 1;
        goto L41
    L43:
        r7.unlock();
        throw th;
    L5:
        r4 = 0;
        goto L6
    }

    private final String a(Class<?> r1, Class<?> r2) {
        return r1.getSimpleName() + '_' + r2.getSimpleName();
    }

    private final void a(S r7, S r8, DMEvent r9) {
        if (o.a(r7, r8) == false) goto L5;
        return;
    L5:
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(this.f, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L7:
        if (r0.hasNext() == false) goto L13;
        ((e) ZeusTransformUtils.preCheckCast(r0.next(), e.class, "com.obric.aiagent.plugin")).a(r7, r8, r9);     // Catch: Exception -> L11
    L11:
        e = move-exception;
        ILogDepend.Companion.e(TAG, '[' + this.f22470b + "] Error notifying listener: " + e.getMessage(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        goto L7
    }

    private final void a(S r7, DMEvent r8, Exception r9) {
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(this.f, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        ((e) ZeusTransformUtils.preCheckCast(r0.next(), e.class, "com.obric.aiagent.plugin")).a(r7, r8, r9);     // Catch: Exception -> L8
    L8:
        e = move-exception;
        ILogDepend.Companion.e(TAG, '[' + this.f22470b + "] Error notifying transition failed listener: " + e.getMessage(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        goto L4
    }

    public final void b() {
        this.f.clear();
    }
}
