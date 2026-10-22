package com.bytedance.android.ec.hybrid.log.mall;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class f implements l {

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ p f47473a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f47474b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Thread f47475c;

        public a(p r100, String r101, Thread r102) {
            this.f47473a = r100;
            this.f47474b = r101;
            this.f47475c = r102;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Lazy r100 = ECMallLogUtil.f47441a;     // Catch: Throwable -> L4
            ECMallLogUtil.f(4, this.f47473a, this.f47474b, this.f47475c, 16);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ p f47476a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function0 f47477b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Thread f47478c;

        public b(p r100, Function0 r101, Thread r102) {
            this.f47476a = r100;
            this.f47477b = r101;
            this.f47478c = r102;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Lazy r100 = ECMallLogUtil.f47441a;     // Catch: Throwable -> L4
            ECMallLogUtil.f(4, this.f47476a, (String) this.f47477b.invoke(), this.f47478c, 16);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public f() {
    }

    @Override // com.bytedance.android.ec.hybrid.log.mall.l
    public final void a(p r100, Function0<String> r101) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "message");
        com.bytedance.android.ec.hybrid.a.i(new b(r100, r101, ThreadMethodProxy.currentThread()));
    }

    @Override // com.bytedance.android.ec.hybrid.log.mall.l
    public final void b(p r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "message");
        ECMallLogUtil.f(5, r100, r101, null, 24);
    }

    @Override // com.bytedance.android.ec.hybrid.log.mall.l
    public final void c(p r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "message");
        com.bytedance.android.ec.hybrid.a.i(new a(r100, r101, ThreadMethodProxy.currentThread()));
    }

    @Override // com.bytedance.android.ec.hybrid.log.mall.l
    public final void d(p r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "message");
        ECMallLogUtil.f(6, r100, r101, null, 24);
    }

    @Override // com.bytedance.android.ec.hybrid.log.mall.l
    public final void e(p r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "message");
        ECMallLogUtil.f(3, r100, r101, null, 24);
    }
}
