package com.bytedance.android.ec.core.anchorv3;

import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import com.bytedance.android.ec.core.utils.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class PdpTaskManager {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Handler f43777k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final a f43778l = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f43779a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f43780b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f43781c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile boolean f43782d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<q> f43783e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f43784f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile boolean f43785g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile boolean f43786h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public MessageQueue.IdleHandler f43787i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f43788j;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PdpTaskManager f43789a;

        public b(PdpTaskManager r100) {
            this.f43789a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            PdpTaskManager.d(this.f43789a, 3, null, 6);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PdpTaskManager f43790a;

        public c(PdpTaskManager r100) {
            this.f43790a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            PdpTaskManager.d(this.f43790a, 4, null, 6);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public final void e() {
        this.f43779a = true;
        if (PdpMessageOpt.b() == true) goto L5;
        f(new PdpTaskManager$endReportFirstFrame$1(this));
        return;
    L5:
        f(new PdpTaskManager$endReportFirstFrame$2(this));
    }

    static {
        f43778l = new a();
        PthreadHandlerThreadV2 r100 = new PthreadHandlerThreadV2("PdpAsyncTask");
        ThreadMethodProxy.start(r100);
        f43777k = new Handler(r100.getLooper());
    }

    public PdpTaskManager() {
        this.f43783e = new ArrayList();
    }

    public static void f(Runnable r100) {
        if (Intrinsics.areEqual(ThreadMethodProxy.currentThread(), ThreadMethodProxy.getLooperThread(Looper.getMainLooper())) == false) goto L5;
        r100.run();
        return;
    L5:
        Lazy r101 = UIUtils.f45548a;
        UIUtils.c().post(r100);
    }

    public final void b(String r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.f43788j = r100;
        boolean r101 = PdpMessageOpt.f43751a;
        Function1<Boolean, Unit> r102 = new PdpTaskManager$configSessionId$1(this);
        Intrinsics.checkNotNullParameter(r102, "endCallback");
        if (Intrinsics.areEqual(r100, PdpMessageOpt.f43753c) == false) goto L10;
        BasePdpMessageOptWorker r103 = PdpMessageOpt.f43754d;
        if (r103 == null) goto L11;
        Intrinsics.checkNotNullParameter(r102, "callback");
        ((ArrayList) r103.f43748e).add(r102);
        return;
    L11:
        return;
    }

    public final synchronized void g(q r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "task");     // Catch: Throwable -> L9
        if (this.f43780b == false) goto L6;
        r100.a();     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
        return;
    L6:
        a(r100, 0);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    public final synchronized void h(q r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "task");     // Catch: Throwable -> L9
        if (this.f43782d == false) goto L6;
        r100.a();     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
        return;
    L6:
        a(r100, 2);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    public final void a(q r100, int r101) {
        monitor-enter(this);
        r100.f43821d = r101;     // Catch: Throwable -> L6
        ((ArrayList) this.f43783e).add(r100);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final void i(q r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "task");
        if (r101 == false) goto L5;
    L6:
        if (r101 == true) goto L8;
    L10:
        if (r101 == false) goto L12;
        a(r100, 4);
    L14:
        if (this.f43786h == false) goto L17;
        f(new b(this));
    L17:
        if (this.f43785g == false) goto L21;
        f(new c(this));
        return;
    L21:
        return;
    L12:
        a(r100, 3);
        goto L14
    L8:
        if (this.f43785g == false) goto L10;
    L9:
        r100.a();
        return;
    L5:
        if (this.f43786h == true) goto L9;
        goto L6
    }

    public final void c(int r100, Function1<? super q, Unit> r101, Function0<Unit> r102) {
        ArrayList r103 = new ArrayList();
        monitor-enter(this);
        Iterator r104 = ((ArrayList) this.f43783e).iterator();     // Catch: Throwable -> L22
    L6:
        if (r104.hasNext() == false) goto L10;
        q r105 = (q) r104.next();     // Catch: Throwable -> L22
        if (r105.f43821d != r100) goto L6;
        r103.add(r105);     // Catch: Throwable -> L22
        r104.remove();     // Catch: Throwable -> L22
        goto L6
    L10:
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L22
        monitor-exit(this);
        Iterator r107 = r103.iterator();
    L14:
        if (r107.hasNext() == false) goto L19;
        q r108 = (q) r107.next();
        if (r101 != null) goto L17;
        r108.a();
        goto L14
    L17:
        r101.invoke(r108);
        goto L14
    L19:
        if (r102 == null) goto L38;
        Unit r109 = r102.invoke();
        return;
    L38:
        return;
    L22:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void d(PdpTaskManager r100, int r101, Function0 r102, int r103) {
        if ((r103 & 4) == 0) goto L5;
        r102 = null;
    L5:
        r100.c(r101, null, r102);
    }
}
