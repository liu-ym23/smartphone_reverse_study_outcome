package com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.video;

import android.view.View;
import com.bytedance.android.ec.core.utils.UIUtils;
import com.bytedance.android.ui.ec.widget.photodraweeview.ExtensionsKt;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import ti.k;

/* JADX INFO: loaded from: classes12.dex */
public final class a implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VideoCtrlContainerComponent f166801a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f166802b;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.video.a$a, reason: collision with other inner class name */
    public static final class RunnableC2518a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f166803a;

        public RunnableC2518a(a r100) {
            this.f166803a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f166803a.f166801a.c(1);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // ti.k
    public final void b() {
        Intrinsics.checkNotNullParameter("", "errorMessage");
        Intrinsics.checkNotNullParameter("", "errorMessage");
    }

    @Override // ti.k
    public final void onFirstScreen(View r100) {
        Intrinsics.checkNotNullParameter(r100, "lynxView");
        Intrinsics.checkNotNullParameter(r100, "lynxView");
    }

    @Override // ti.k
    public final void onLoadSuccess(View r100) {
        Intrinsics.checkNotNullParameter(r100, "lynxView");
        Intrinsics.checkNotNullParameter(r100, "lynxView");
        dm.a.a("VideoCtrlContainerComponent").i("createAndCacheLynxComponent load success lynxUrl = " + this.f166802b);
        Lazy r101 = UIUtils.f45548a;
        UIUtils.c().postDelayed(new RunnableC2518a(this), 300);
        this.f166801a.f166800f.onLoadSuccess();
    }

    @Override // ti.k
    public final void onRuntimeReady(View r100) {
        Intrinsics.checkNotNullParameter(r100, "lynxView");
        Intrinsics.checkNotNullParameter(r100, "lynxView");
    }

    public a(VideoCtrlContainerComponent r100, String r101) {
        this.f166801a = r100;
        this.f166802b = r101;
    }

    @Override // ti.k
    public final void g(View r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r100, "view");
    }

    @Override // ti.k
    public final void onLoadFailed(View r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "lynxView");
        Intrinsics.checkNotNullParameter(r100, "lynxView");
        dm.a.a("VideoCtrlContainerComponent").b("createAndCacheLynxComponent load failed lynxUrl = " + this.f166802b + ", errMsg = " + r101, null);
        this.f166801a.b().removeAllViews();
        ExtensionsKt.gone(this.f166801a.b());
        this.f166801a.f166800f.a(r101);
    }

    @Override // ti.k
    public final void onPageStart(View r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "lynxView");
        Intrinsics.checkNotNullParameter(r100, "lynxView");
    }

    @Override // ti.k
    public final void s(View r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r100, "view");
    }
}
