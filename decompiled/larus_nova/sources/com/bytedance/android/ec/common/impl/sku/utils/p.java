package com.bytedance.android.ec.common.impl.sku.utils;

import android.view.Choreographer;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.common.impl.sku.SkuViewModel;
import com.bytedance.android.ec.common.impl.sku.model.SkuInfoVO;
import com.bytedance.android.ec.model.sku.OrderComponent;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.services.apm.api.EnsureManager;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.kiwi.presenter.QContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f43366a = 0;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SkuViewModel f43367a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ QContext f43368b;

        public a(SkuViewModel r100, QContext r101) {
            this.f43367a = r100;
            this.f43368b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            int r100 = p.f43366a;     // Catch: Throwable -> L4
            p.a(this.f43367a, this.f43368b);     // Catch: Throwable -> L4
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
        public final /* synthetic */ SkuViewModel f43369a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ QContext f43370b;

        public b(SkuViewModel r100, QContext r101) {
            this.f43369a = r100;
            this.f43370b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            int r100 = p.f43366a;     // Catch: Throwable -> L4
            p.a(this.f43369a, this.f43370b);     // Catch: Throwable -> L4
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
    }

    public static String c(SkuViewModel r100) {
        Intrinsics.checkNotNullParameter(r100, "viewModel");
        SkuInfoVO r101 = r100.getSkuInfo().a();
        if (r101 == null) goto L8;
        OrderComponent r102 = r101.getOrderComponent();
        if (r102 == null) goto L8;
        String r103 = r102.getOrderUrl();
        if (r103 == null) goto L8;
    L11:
        Intrinsics.checkNotNullParameter(r103, "url");
        if (StringsKt.contains$default(r103, "webcast_webview", false, 2, null) == true) goto L14;
        return null;
    L14:
        return r103;
    L8:
        r103 = r100.getSkuParams().getH5Url();
        if (r103 != null) goto L11;
        r103 = "";
        goto L11
    }

    public static void a(SkuViewModel r110, QContext r111) {
        String r100 = c(r110);     // Catch: Throwable -> L15
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L11;
        return;
    L11:
        boolean r102 = ECServiceManager.f42805a;     // Catch: Throwable -> L15
        pd.e r103 = ((IAdapterService) ECServiceManager.c(IAdapterService.class)).getIExternaHybridService();     // Catch: Throwable -> L15
        String r104 = b(r100, r110.getSkuParams().isLiveSkuCheck(), 1);     // Catch: Throwable -> L15
        if (r103 == null) goto L20;
        r103.prerenderAnnieWithSchema(r111.c(), r104, "webcast", 600, "onidle", null);     // Catch: Throwable -> L15
        return;
    L20:
        return;
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
    L15:
        th = move-exception;
        EnsureManager.ensureNotReachHere(th);
    }

    public static void d(SkuViewModel r100, QContext r101) {
        Intrinsics.checkNotNullParameter(r100, "viewModel");
        Intrinsics.checkNotNullParameter(r101, "qContext");
        String r102 = UriProtector.getQueryParameter(UriProtector.parse(c(r100)), "prerender_type");     // Catch: Throwable -> L5
    L7:
        if (r102 != null) goto L10;
        return;
    L10:
        switch(r102.hashCode()) {
            case 49: goto L19;
            case 50: goto L16;
            case 51: goto L13;
            default: goto L30;
        };
    L30:
        return;
    L13:
        if (r102.equals("3") == false) goto L24;
        r100.registerSkuNextChangeCallback(new b(r100, r101));
        return;
    L24:
        return;
    L16:
        if (r102.equals("2") == false) goto L26;
        f r103 = new f(new a(r100, r101));
        Intrinsics.checkNotNullParameter(r103, "runner");
        Choreographer.getInstance().postFrameCallback(new o(r103));
        return;
    L26:
        return;
    L19:
        if (r102.equals("1") == false) goto L28;
        a(r100, r101);
        return;
    L28:
        return;
    L5:
        th = move-exception;
        EnsureManager.ensureNotReachHere(th);
        r102 = "0";
        goto L7
    }

    public static String b(String r100, boolean r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "url");
        if (r101 == false) goto L5;
        String r103 = "buy_now_yata_pre_render_live";
    L7:
        return jg.e.b(jg.e.b(r100, "prerender_cache_key", r103), "is_pre_render", String.valueOf(r102));
    L5:
        r103 = "buy_now_yata_pre_render_pdp";
        goto L7
    }
}
