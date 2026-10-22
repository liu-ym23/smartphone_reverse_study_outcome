package com.bytedance.android.shopping.deepfeed.ui.vh;

import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.shopping.deepfeed.event.DeepFeedProductEventTracker;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class p implements com.bytedance.android.ecom.arch.slice.render.context.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DeepFeedProductSlcVH f173856a;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ uc3.f f173857a;

        public a(uc3.f r100) {
            this.f173857a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            uc3.f r100 = this.f173857a;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.b(System.currentTimeMillis());     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ uc3.f f173858a;

        public b(uc3.f r100) {
            this.f173858a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            uc3.f r100 = this.f173858a;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            r100.h(System.currentTimeMillis());     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ p f173859a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ uc3.f f173860b;

        public c(p r100, uc3.f r101) {
            this.f173859a = r100;
            this.f173860b = r101;
        }

        public final void a() {
            uc3.f r100 = this.f173860b;
            if (r100 == null) goto L5;
            r100.g(System.currentTimeMillis());
        L5:
            com.bytedance.android.shopping.deepfeed.data.repo.l r101 = this.f173859a.f173856a.i4().getResp();
            if (r101 != null) goto L8;
            return;
        L8:
            if (r101.f173236l == true) goto L21;
            uc3.f r102 = this.f173860b;
            if (r102 == null) goto L16;
            Map<String, ? extends Object> r103 = r102.a();
            if (r103 == null) goto L16;
            DeepFeedProductEventTracker r104 = this.f173859a.f173856a.i4().getEventTracker();
            if (r104 == null) goto L16;
            Intrinsics.checkNotNullParameter(r103, "data");
            r104.doEventAction("ec_perf_duration_mall_deep_feed", r103);
        L16:
            com.bytedance.android.shopping.deepfeed.data.repo.l r105 = this.f173859a.f173856a.i4().getResp();
            if (r105 == null) goto L22;
            r105.f173236l = true;
            return;
        L22:
            return;
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

    public p(DeepFeedProductSlcVH r100) {
        this.f173856a = r100;
    }

    @Override // com.bytedance.android.ecom.arch.slice.render.context.a
    public final void a(SlcTemplateContext r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "templateContext");
        this.f173856a.getClass();
        if (Intrinsics.areEqual(null, r101) == false) goto L28;
        if (r102 != null) goto L29;
        com.bytedance.android.shopping.deepfeed.data.repo.l r103 = this.f173856a.i4().getResp();
        if (r103 == null) goto L8;
        uc3.f r104 = r103.g();
    L9:
        DeepFeedProductSlcVH r105 = this.f173856a;
        if (r105.R == false) goto L15;
        r105.R = false;
        if (r104 == null) goto L14;
        r104.e(System.currentTimeMillis());
    L14:
        this.f173856a.f173754p.post(new a(r104));
    L15:
        DeepFeedProductSlcVH r106 = this.f173856a;
        if (r106.S == false) goto L21;
        r106.S = false;
        if (r104 == null) goto L20;
        r104.i(System.currentTimeMillis());
    L20:
        this.f173856a.f173754p.post(new b(r104));
    L21:
        DeepFeedProductSlcVH r107 = this.f173856a;
        if (r107.T == false) goto L30;
        r107.T = false;
        if (r104 == null) goto L26;
        r104.d(System.currentTimeMillis());
    L26:
        this.f173856a.f173754p.post(new c(this, r104));
        return;
    L30:
        return;
    L8:
        r104 = null;
        goto L9
    L29:
        return;
    }
}
