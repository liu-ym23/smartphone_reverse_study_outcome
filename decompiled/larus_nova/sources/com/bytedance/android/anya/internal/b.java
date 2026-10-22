package com.bytedance.android.anya.internal;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.anya.q0;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.Maybe;
import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Action;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class b extends j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ReentrantLock f41642b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ExecutorService f41643c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Handler f41644d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LinkedList<a> f41645e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final CompositeDisposable f41646f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile boolean f41647g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile Boolean f41648h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile boolean f41649i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile boolean f41650j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f41651k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f41652l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Scheduler f41653m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f41654n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f41655o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f41656p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final mb.b f41657q;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Function0<Unit> f41658a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f41659b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f41660c;

        public a(Function0<Unit> r100, boolean r101, int r102) {
            this.f41658a = r100;
            this.f41659b = r101;
            this.f41660c = r102;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.anya.internal.b$b, reason: collision with other inner class name */
    public static final class C0766b {
    }

    public final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final LinkedList<Function0<Unit>> f41661a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Function0<Unit> f41662b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ b f41663c;

        public final void a() {
            final Function0<Unit> r100 = this.f41662b;
            if (r100 == null) goto L28;
            LinkedList<Function0<Unit>> r101 = this.f41661a;
            final ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
            Iterator<T> r103 = r101.iterator();
        L6:
            if (r103.hasNext() == false) goto L8;
            r102.add(new a((Function0) r103.next(), false, 0));
            goto L6
        L8:
            final b r104 = this.f41663c;
            LinkedList<a> r105 = r104.f41645e;
            monitor-enter(r105);
        L25:
            th = move-exception;
            throw th;
        L11:
            if (r104.f41649i == false) goto L13;
            r104.f41645e.addAll(r102);     // Catch: Throwable -> L25
            r104.I("commit " + r102.size() + " actions within init barrier");     // Catch: Throwable -> L25
        L22:
            Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L25
            monitor-exit(r105);
            return;
        L13:
            Function0<Unit> r107 = new AnyaExecutor$commitBatchAction$$inlined$synchronized$lambda$1(r104, r102, r100);     // Catch: Throwable -> L25
            if (r104.f41647g == false) goto L16;
        L21:
            r104.f41645e.add(new a(r107, false, 1));     // Catch: Throwable -> L25
            r104.f41645e.addAll(r102);     // Catch: Throwable -> L25
            r104.f41645e.add(new a(AnyaExecutor$commitBatchAction$1$1.INSTANCE, false, 2));     // Catch: Throwable -> L25
            r104.F("commit " + r102.size() + " actions to queue, " + r104.E(), null);     // Catch: Throwable -> L25
            goto L22
        L16:
            if ((!r104.f41645e.isEmpty()) == true) goto L21;
            if (Intrinsics.areEqual(r104.f41648h, Boolean.TRUE) == true) goto L21;
            r104.f41645e.addAll(r102);     // Catch: Throwable -> L25
            r104.f41645e.add(new a(AnyaExecutor$commitBatchAction$1$2.INSTANCE, false, 2));     // Catch: Throwable -> L25
            r104.F("commit consume " + r102.size() + " actions immediately, " + r104.E(), null);     // Catch: Throwable -> L25
            r104.q(r107, false);     // Catch: Throwable -> L25
            goto L22
        L28:
            this.f41663c.F("diff callback is null", null);
        }

        public c(b r100) {
            this.f41663c = r100;
            this.f41661a = new LinkedList();
        }
    }

    public final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Disposable f41664a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Function0<Unit> f41665b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ b f41666c;

        public final void a() {
            System.currentTimeMillis();
            b r100 = this.f41666c;
            long r101 = r100.f41651k;
            String r102 = r100.f41654n;
            r100.f41651k = 0;
            long r103 = System.currentTimeMillis();
        L4:
            if (this.f41666c.f41642b.tryLock() == false) goto L4;
            this.f41665b.invoke();     // Catch: Throwable -> L23 Exception -> L25
            mb.b r104 = this.f41666c.f41657q;     // Catch: Throwable -> L23 Exception -> L25
            if (r104 == null) goto L10;
            r104.a(r103);     // Catch: Throwable -> L23 Exception -> L25
        L10:
            LinkedList<a> r105 = this.f41666c.f41645e;
            monitor-enter(r105);
        L20:
            th = move-exception;
            throw th;
        L13:
            if (q0.f41747b == false) goto L17;
            Disposable r106 = this.f41664a;     // Catch: Throwable -> L20
            if (r106 == null) goto L17;
            this.f41666c.f41646f.remove(r106);     // Catch: Throwable -> L20
        L17:
            b r107 = this.f41666c;     // Catch: Throwable -> L20
            r107.f41648h = Boolean.FALSE;     // Catch: Throwable -> L20
            this.f41666c.f41647g = false;     // Catch: Throwable -> L20
            this.f41666c.f41642b.unlock();     // Catch: Throwable -> L20
            b.n(this.f41666c);     // Catch: Throwable -> L20
            Unit r108 = Unit.INSTANCE;     // Catch: Throwable -> L20
            monitor-exit(r105);
        L19:
            String r109 = this.f41666c.f41654n;
            return;
        L23:
            th = move-exception;
            monitor-enter(this.f41666c.f41645e);
        L52:
            th = move-exception;
            throw th;
        L44:
            if (q0.f41747b == false) goto L48;
            Disposable r110 = this.f41664a;     // Catch: Throwable -> L52
            if (r110 == null) goto L48;
            this.f41666c.f41646f.remove(r110);     // Catch: Throwable -> L52
        L48:
            b r111 = this.f41666c;     // Catch: Throwable -> L52
            r111.f41648h = Boolean.FALSE;     // Catch: Throwable -> L52
            this.f41666c.f41647g = false;     // Catch: Throwable -> L52
            this.f41666c.f41642b.unlock();     // Catch: Throwable -> L52
            b.n(this.f41666c);     // Catch: Throwable -> L52
            Unit r112 = Unit.INSTANCE;     // Catch: Throwable -> L52
            String r113 = this.f41666c.f41654n;
            throw th;
        L25:
            e = move-exception;
            this.f41666c.F("ui action exception", e);     // Catch: Throwable -> L23
            monitor-enter(this.f41666c.f41645e);
        L38:
            th = move-exception;
            throw th;
        L30:
            if (q0.f41747b == false) goto L34;
            Disposable r114 = this.f41664a;     // Catch: Throwable -> L38
            if (r114 == null) goto L34;
            this.f41666c.f41646f.remove(r114);     // Catch: Throwable -> L38
        L34:
            b r115 = this.f41666c;     // Catch: Throwable -> L38
            r115.f41648h = Boolean.FALSE;     // Catch: Throwable -> L38
            this.f41666c.f41647g = false;     // Catch: Throwable -> L38
            this.f41666c.f41642b.unlock();     // Catch: Throwable -> L38
            b.n(this.f41666c);     // Catch: Throwable -> L38
            Unit r116 = Unit.INSTANCE;     // Catch: Throwable -> L38
            goto L19
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public d(b r100, Function0<Unit> r101) {
            this.f41666c = r100;
            this.f41665b = r101;
        }
    }

    public final class e implements Callable<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Disposable f41667a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Function0<Unit> f41668b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ b f41669c;

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public void call2() {
            long r100 = System.currentTimeMillis();
        L4:
            if (this.f41669c.f41642b.tryLock() == false) goto L4;
            Objects.toString(ThreadMethodProxy.currentThread());     // Catch: Throwable -> L24 Exception -> L26
            String r101 = this.f41669c.f41654n;     // Catch: Throwable -> L24 Exception -> L26
            this.f41668b.invoke();     // Catch: Throwable -> L24 Exception -> L26
            mb.b r102 = this.f41669c.f41657q;     // Catch: Throwable -> L24 Exception -> L26
            if (r102 == null) goto L10;
            r102.b(r100);     // Catch: Throwable -> L24 Exception -> L26
        L10:
            LinkedList<a> r103 = this.f41669c.f41645e;
            monitor-enter(r103);
        L21:
            th = move-exception;
            throw th;
        L13:
            if (q0.f41747b == false) goto L17;
            Disposable r104 = this.f41667a;     // Catch: Throwable -> L21
            if (r104 == null) goto L17;
            this.f41669c.f41646f.remove(r104);     // Catch: Throwable -> L21
        L17:
            b r105 = this.f41669c;     // Catch: Throwable -> L21
            r105.f41648h = Boolean.TRUE;     // Catch: Throwable -> L21
            this.f41669c.f41647g = false;     // Catch: Throwable -> L21
            this.f41669c.f41642b.unlock();     // Catch: Throwable -> L21
            b.n(this.f41669c);     // Catch: Throwable -> L21
            Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L21
            monitor-exit(r103);
            b r107 = this.f41669c;
            String r108 = r107.f41654n;
        L20:
            r107.f41651k = System.currentTimeMillis();
            return;
        L26:
            e = move-exception;
            this.f41669c.F("worker action exception", e);     // Catch: Throwable -> L24
            monitor-enter(this.f41669c.f41645e);
        L39:
            th = move-exception;
            throw th;
        L31:
            if (q0.f41747b == false) goto L35;
            Disposable r109 = this.f41667a;     // Catch: Throwable -> L39
            if (r109 == null) goto L35;
            this.f41669c.f41646f.remove(r109);     // Catch: Throwable -> L39
        L35:
            b r110 = this.f41669c;     // Catch: Throwable -> L39
            r110.f41648h = Boolean.TRUE;     // Catch: Throwable -> L39
            this.f41669c.f41647g = false;     // Catch: Throwable -> L39
            this.f41669c.f41642b.unlock();     // Catch: Throwable -> L39
            b.n(this.f41669c);     // Catch: Throwable -> L39
            Unit r111 = Unit.INSTANCE;     // Catch: Throwable -> L39
            r107 = this.f41669c;
            String r112 = r107.f41654n;
        L24:
            th = move-exception;
            monitor-enter(this.f41669c.f41645e);
        L53:
            th = move-exception;
            throw th;
        L45:
            if (q0.f41747b == false) goto L49;
            Disposable r113 = this.f41667a;     // Catch: Throwable -> L53
            if (r113 == null) goto L49;
            this.f41669c.f41646f.remove(r113);     // Catch: Throwable -> L53
        L49:
            b r114 = this.f41669c;     // Catch: Throwable -> L53
            r114.f41648h = Boolean.TRUE;     // Catch: Throwable -> L53
            this.f41669c.f41647g = false;     // Catch: Throwable -> L53
            this.f41669c.f41642b.unlock();     // Catch: Throwable -> L53
            b.n(this.f41669c);     // Catch: Throwable -> L53
            Unit r115 = Unit.INSTANCE;     // Catch: Throwable -> L53
            b r116 = this.f41669c;
            String r117 = r116.f41654n;
            r116.f41651k = System.currentTimeMillis();
            throw th;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Unit call() {
            call2();
            return Unit.INSTANCE;
        }

        public e(b r100, Function0<Unit> r101) {
            this.f41669c = r100;
            this.f41668b = r101;
        }
    }

    public static final class f implements Action {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f41670a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f41671b;

        public f(b r100, d r101) {
            this.f41670a = r100;
            this.f41671b = r101;
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            this.f41670a.f41644d.removeCallbacks(this.f41671b);
        }
    }

    static {
    }

    public final String E() {
        StringBuilder r100 = new StringBuilder("Executor" + ((String) this.f41652l.getValue()) + '{');
        if (this.f41649i == false) goto L6;
        r100.append("initBarrier=" + this.f41649i + ',');
    L6:
        if (this.f41650j == false) goto L8;
        r100.append("batchReducing=" + this.f41650j + ',');
    L8:
        r100.append("consuming=" + this.f41647g + ',');
        r100.append("nextJobShouldBeOnUI=" + this.f41648h + ',');
        StringBuilder r101 = new StringBuilder("actionQueue=");
        r101.append(this.f41645e.size());
        r100.append(r101.toString());
        if (this.f41642b.isLocked() == false) goto L11;
        r100.append(",lock=" + this.f41642b);
    L11:
        r100.append(com.alipay.sdk.m.u.i.f25855d);
        return r100.toString();
    }

    @Override // com.bytedance.android.anya.internal.j
    public final void k() {
        I("dispose " + E());
    L4:
        if (this.f41642b.tryLock() == false) goto L4;
        this.f41646f.clear();     // Catch: Throwable -> L19
        ExecutorService r100 = this.f41643c;     // Catch: Throwable -> L19
        if (r100 == null) goto L9;
        r100.shutdown();     // Catch: Throwable -> L19
    L9:
        this.f41644d.removeCallbacksAndMessages(null);     // Catch: Throwable -> L19
        LinkedList<a> r101 = this.f41645e;     // Catch: Throwable -> L19
        monitor-enter(r101);     // Catch: Throwable -> L19
        this.f41645e.clear();     // Catch: Throwable -> L16
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L16
        monitor-exit(r101);     // Catch: Throwable -> L19
        this.f41647g = false;     // Catch: Throwable -> L19
        this.f41648h = null;     // Catch: Throwable -> L19
        this.f41642b.unlock();
        return;
    L16:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        this.f41642b.unlock();
        throw th;
    }

    public static final void n(b r100) {
        if (r100.f41647g == false) goto L5;
        return;
    L5:
        if (r100.f41645e.isEmpty() == false) goto L8;
        return;
    L8:
        if (r100.f41648h != null) goto L10;
        a r101 = r100.f41645e.pollFirst();
        r100.q(r101.f41658a, r101.f41659b);
        return;
    L10:
        Iterator<a> r102 = r100.f41645e.iterator();
    L12:
        if (r102.hasNext() == false) goto L16;
        a r103 = r102.next();
        if (Intrinsics.areEqual(Boolean.valueOf(r103.f41659b), r100.f41648h) == false) goto L12;
        r102.remove();
    L17:
        if (r103 == null) goto L27;
        r100.q(r103.f41658a, r103.f41659b);
        return;
    L27:
        return;
    L16:
        r103 = null;
        goto L17
    }

    public final void I(String r100) {
        mb.c r101 = mb.a.f512756a;
        String r102 = this.f41654n + ' ' + r100;
        mb.c r103 = mb.a.f512756a;
        if (r103 == null) goto L6;
        r103.logW("ttlive_anya_executor", r102);
        return;
    }

    public final void R(Function0<Unit> r100) {
        if (this.f41649i == false) goto L12;
        LinkedList<a> r101 = this.f41645e;
        monitor-enter(r101);
        this.f41645e.add(new a(r100, false, 0));     // Catch: Throwable -> L9
        monitor-exit(r101);
        return;
    L9:
        th = move-exception;
        throw th;
    L12:
        L(r100, false);
    }

    public final void F(String r100, Exception r101) {
        mb.c r102 = mb.a.f512756a;
        String r103 = this.f41654n + ' ' + r100;
        mb.c r104 = mb.a.f512756a;
        if (r104 == null) goto L6;
        r104.a(r103, r101);
        return;
    }

    public final void K(boolean r100, Function0<Unit> r101) {
        I("batch reduce start, " + E());
        LinkedList<a> r102 = this.f41645e;
        monitor-enter(r102);
        ArrayList r103 = new ArrayList();     // Catch: Throwable -> L43
        Iterator<a> r104 = this.f41645e.iterator();     // Catch: Throwable -> L43
    L6:
        if (r104.hasNext() == false) goto L13;
        a r105 = r104.next();     // Catch: Throwable -> L43
        if (r105.f41659b == false) goto L10;
        F("unexpected ui action in batch", null);     // Catch: Throwable -> L43
    L12:
        if (r105.f41660c != 2) goto L6;
    L10:
        r103.add(r105);     // Catch: Throwable -> L43
    L13:
        r103.size();     // Catch: Throwable -> L43
        Iterator r106 = r103.iterator();     // Catch: Throwable -> L43
    L15:
        if (r106.hasNext() == false) goto L17;
        ((a) r106.next()).f41658a.invoke();     // Catch: Throwable -> L43
        goto L15
    L17:
        this.f41645e.removeAll(r103);     // Catch: Throwable -> L43
        monitor-exit(r102);
        boolean r107 = true;
        if (r100 == true) goto L22;
    L35:
        StringBuilder r108 = new StringBuilder("batch reduce finished, notify diff ");
        if (r101 != null) goto L39;
        r107 = false;
    L39:
        r108.append(r107);
        r108.append(", ");
        r108.append(E());
        F(r108.toString(), null);
        if (r101 == null) goto L60;
        Unit r109 = r101.invoke();
        return;
    L60:
        return;
    L22:
        if ((!this.f41645e.isEmpty()) == false) goto L35;
    L23:
        LinkedList<a> r110 = this.f41645e;
        ArrayList r111 = new ArrayList();
        Iterator<T> r112 = r110.iterator();
    L25:
        if (r112.hasNext() == false) goto L29;
        Object r113 = r112.next();
        if ((!((a) r113).f41659b) == false) goto L25;
        r111.add(r113);
        goto L25
    L29:
        I("handle extra init barrier actions, size=" + r111.size());
        Iterator r114 = r111.iterator();
    L31:
        if (r114.hasNext() == false) goto L33;
        ((a) r114.next()).f41658a.invoke();
        goto L31
    L33:
        this.f41645e.removeAll(r111);
        F("handle extra init barrier actions done, currentQueueSize=" + this.f41645e.size(), null);
        CollectionsKt.removeAll(this.f41645e, AnyaExecutor$handleInitBarrierActions$2.INSTANCE);
        if ((!this.f41645e.isEmpty()) == true) goto L23;
    L43:
        th = move-exception;
        throw th;
    }

    public final void L(Function0 r100, boolean r101) {
        LinkedList<a> r102 = this.f41645e;
        monitor-enter(r102);
    L18:
        th = move-exception;
        throw th;
    L5:
        if (this.f41647g == false) goto L7;
    L15:
        this.f41645e.add(new a(r100, r101, 0));     // Catch: Throwable -> L18
        StringBuilder r103 = new StringBuilder("append action ui=");     // Catch: Throwable -> L18
        r103.append(r101);     // Catch: Throwable -> L18
        r103.append(' ');     // Catch: Throwable -> L18
        r103.append(E());     // Catch: Throwable -> L18
    L16:
        monitor-exit(r102);
        return;
    L7:
        if (this.f41645e.isEmpty() == false) goto L15;
        Boolean r104 = this.f41648h;     // Catch: Throwable -> L18
        if (r101 == true) goto L11;
        boolean r105 = true;
    L13:
        if ((!Intrinsics.areEqual(r104, Boolean.valueOf(r105))) == false) goto L15;
        q(r100, r101);     // Catch: Throwable -> L18
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L18
        goto L16
    L11:
        r105 = false;
        goto L13
    }

    public final void q(Function0<Unit> r100, boolean r101) {
        this.f41647g = true;
        if (r101 == false) goto L8;
        d r102 = new d(this, r100);
        CompositeDisposable r103 = this.f41646f;
        Disposable r104 = Disposables.fromAction(new f(this, r102));
        r102.f41664a = r104;
        r103.add(r104);
        if (this.f41656p == 1) goto L7;
        this.f41644d.post(r102);
        return;
    L7:
        this.f41644d.postAtTime(r102, 2);
        return;
    L8:
        e r105 = new e(this, r100);
        if (this.f41655o != 1) goto L13;
        ExecutorService r106 = this.f41643c;
        if (r106 == null) goto L17;
        r106.submit(r105);
        return;
    L17:
        return;
    L13:
        Disposable r107 = Maybe.fromCallable(r105).subscribeOn(this.f41653m).subscribe();
        r105.f41667a = r107;
        CompositeDisposable r108 = this.f41646f;
        Handler r109 = v.f41726a;
        r108.add(r107);
    }

    public b(Scheduler r100, String r101, int r102, mb.b r103) {
        this.f41653m = r100;
        this.f41654n = r101;
        this.f41655o = 0;
        this.f41656p = r102;
        this.f41657q = r103;
        this.f41642b = new ReentrantLock(true);
        this.f41643c = null;
        this.f41644d = new Handler(Looper.getMainLooper());
        this.f41645e = new LinkedList();
        this.f41646f = new CompositeDisposable();
        this.f41652l = LazyKt.lazy(new AnyaExecutor$objLabel$2(this));
    }
}
