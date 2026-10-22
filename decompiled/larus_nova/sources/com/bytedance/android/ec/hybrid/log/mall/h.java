package com.bytedance.android.ec.hybrid.log.mall;

import com.bytedance.android.livehostapi.platform.base.IBaseHostPerformanceMonitor;
import com.bytedance.keva.Keva;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class h implements l {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f47481d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f47482e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile long f47483a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BlockingQueue<b> f47484b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f47485c;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f47486a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final p f47487b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f47488c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Function0<String> f47489d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final long f47490e;

        public b() {
            throw null;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof b) == false) goto L16;
            b r101 = (b) r100;
            if (this.f47486a == r101.f47486a) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f47487b, r101.f47487b) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.f47488c, r101.f47488c) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f47489d, r101.f47489d) == true) goto L14;
            return false;
        L14:
            if (this.f47490e == r101.f47490e) goto L25;
            return false;
        L25:
            return true;
        L16:
            return false;
        }

        public final int hashCode() {
            int r100 = this.f47486a * 31;
            p r101 = this.f47487b;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = r101.hashCode();
        L6:
            int r104 = (r100 + r103) * 31;
            String r105 = this.f47488c;
            if (r105 == null) goto L9;
            int r106 = r105.hashCode();
        L10:
            int r107 = (r104 + r106) * 31;
            Function0<String> r108 = this.f47489d;
            if (r108 == null) goto L13;
            r102 = r108.hashCode();
        L13:
            long r109 = this.f47490e;
            return ((r107 + r102) * 31) + ((int) (r109 ^ (r109 >>> 32)));
        L9:
            r106 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        public final String toString() {
            return "LogItem(logInfo=" + this.f47486a + ", scene=" + this.f47487b + ", message=" + this.f47488c + ", messageLambda=" + this.f47489d + ", timeStamp=" + this.f47490e + ")";
        }

        public b(int r100, p r101, String r102, Function0 r103) {
            long r104 = System.currentTimeMillis();
            Intrinsics.checkNotNullParameter(r101, "scene");
            this.f47486a = r100;
            this.f47487b = r101;
            this.f47488c = r102;
            this.f47489d = r103;
            this.f47490e = r104;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h f47491a;

        public c(h r100) {
            this.f47491a = r100;
        }

        public final void a() {
            h r100 = this.f47491a;
            r100.getClass();
            ArrayList r101 = new ArrayList();     // Catch: Throwable -> L23
            ((LinkedBlockingQueue) r100.f47484b).drainTo(r101);     // Catch: Throwable -> L23
            Iterator r102 = r101.iterator();     // Catch: Throwable -> L23
        L4:
            if (r102.hasNext() == false) goto L21;
            b r103 = (b) r102.next();     // Catch: Throwable -> L23
            String r104 = r103.f47488c;     // Catch: Throwable -> L23
            if (r104 != null) goto L12;
            Function0<String> r105 = r103.f47489d;     // Catch: Throwable -> L23
            if (r105 == null) goto L11;
            r104 = r105.invoke();     // Catch: Throwable -> L23
            goto L12
        L11:
            r104 = null;
        L12:
            if (r104 != null) goto L14;
        L17:
            boolean r106 = true;
        L18:
            if (r106 == true) goto L4;
            Lazy r107 = ECMallLogUtil.f47441a;     // Catch: Throwable -> L23
            ECMallLogUtil.e(r103.f47486a, r103.f47487b, r104, null, String.valueOf(r103.f47490e));     // Catch: Throwable -> L23
            goto L4
        L14:
            if (r104.length() == 0) goto L17;
            r106 = false;
            goto L18
        L21:
            r100.f47483a = System.currentTimeMillis();
            r100.f47485c.set(false);
            return;
        L23:
            th = move-exception;
            r100.f47483a = System.currentTimeMillis();
            r100.f47485c.set(false);
            throw th;
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
    }

    static {
        f47481d = Keva.getRepo(IBaseHostPerformanceMonitor.AB_REPO_COLD_BOOT, 0).getInt("legou_mall_batch_size", 100);
        f47482e = Keva.getRepo(IBaseHostPerformanceMonitor.AB_REPO_COLD_BOOT, 0).getInt("legou_mall_time_window", 100);
    }

    public final void g() {
        if (((LinkedBlockingQueue) this.f47484b).size() < f47481d) goto L5;
        boolean r100 = true;
    L7:
        if ((System.currentTimeMillis() - this.f47483a) <= f47482e) goto L9;
        boolean r101 = true;
    L10:
        if (r100 == true) goto L13;
        if (r101 == true) goto L13;
        return;
    L13:
        if (this.f47485c.compareAndSet(false, true) == false) goto L17;
        com.bytedance.android.ec.hybrid.a.i(new c(this));
        return;
    L17:
        return;
    L9:
        r101 = false;
        goto L10
    L5:
        r100 = false;
        goto L7
    }

    public h() {
        this.f47484b = new LinkedBlockingQueue();
        this.f47485c = new AtomicBoolean(false);
    }

    @Override // com.bytedance.android.ec.hybrid.log.mall.l
    public final void a(p r100, Function0<String> r101) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "message");
        BlockingQueue<b> r102 = this.f47484b;
        LinkedBlockingQueue r103 = (LinkedBlockingQueue) r102;
        r103.offer(new b(4, r100, null, r101));
        g();
    }

    @Override // com.bytedance.android.ec.hybrid.log.mall.l
    public final void b(p r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "message");
        f(5, r100, r101);
    }

    @Override // com.bytedance.android.ec.hybrid.log.mall.l
    public final void c(p r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "message");
        f(4, r100, r101);
    }

    @Override // com.bytedance.android.ec.hybrid.log.mall.l
    public final void d(p r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "message");
        f(6, r100, r101);
    }

    @Override // com.bytedance.android.ec.hybrid.log.mall.l
    public final void e(p r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "message");
        f(3, r100, r101);
    }

    public final void f(int r100, p r101, String r102) {
        BlockingQueue<b> r103 = this.f47484b;
        LinkedBlockingQueue r104 = (LinkedBlockingQueue) r103;
        r104.offer(new b(r100, r101, r102, null));
        g();
    }
}
