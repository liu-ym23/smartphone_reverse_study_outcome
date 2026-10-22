package com.bytedance.android.annie.pia;

import android.graphics.Bitmap;
import android.os.Build;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.bytedance.ies.web.jsbridge2.l0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class d extends com.bytedance.android.annie.card.web.e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h47.a f39728b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final l0 f39729c;

    @Override // com.bytedance.android.annie.card.web.e
    public final void y() {
        this.f39728b.onDestroy();
    }

    public d(h47.a r100) {
        Intrinsics.checkNotNullParameter(r100, "innerLifeCycle");
        super(null);
        this.f39728b = r100;
        this.f39729c = new l0();
    }

    @Override // com.bytedance.android.annie.card.web.e
    public final void A(WebView r100) {
        Intrinsics.checkNotNullParameter(r100, "webView");
        this.f39728b.a(r100);
    }

    @Override // com.bytedance.android.annie.card.web.e
    public final void f(String r100, ValueCallback<String> r101) {
        this.f39729c.E(r100);
    }

    @Override // com.bytedance.android.annie.card.web.e, com.bytedance.android.annie.card.base.b
    public final void g(View r100, String r101) {
        if (r101 == null) goto L5;
        this.f39728b.onLoadFinish();
        return;
    }

    @Override // com.bytedance.android.annie.card.web.e
    public final void s(WebView r100, String r101) {
        if (r101 == null) goto L4;
        this.f39728b.loadUrl(r101);
    L4:
        this.f39729c.s(r100, r101);
    }

    @Override // com.bytedance.android.annie.card.web.e
    public final void v(WebView r100, WebResourceRequest r101, WebResourceResponse r102) {
        if (r101 != null) goto L4;
        return;
    L4:
        if (Build.VERSION.SDK_INT >= 23) goto L6;
        return;
    L6:
        if (r101.isForMainFrame() == false) goto L15;
        if (r102 != null) goto L10;
        this.f39728b.b();
        return;
    L10:
        h47.a r103 = this.f39728b;
        r102.getStatusCode();
        r102.getReasonPhrase();
        r103.b();
        return;
    }

    @Override // com.bytedance.android.annie.card.web.e, com.bytedance.android.annie.card.base.b
    public final void k(View r100, String r101, Bitmap r102, boolean r103) {
        if (r101 == null) goto L5;
        this.f39728b.onLoadStart();
        return;
    }
}
