package com.bytedance.android.ec.core.hybrid.utils;

import android.webkit.WebView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class i implements pd.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ti.k f44311a;

    public i(ti.k r100) {
        this.f44311a = r100;
    }

    @Override // pd.i
    public final void onPageFinished(WebView r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "webView");
        ti.k r102 = this.f44311a;
        if (r102 == null) goto L6;
        r102.g(r100, r101);
        return;
    }

    @Override // pd.i
    public final void onPageStarted(WebView r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "webView");
        ti.k r102 = this.f44311a;
        if (r102 == null) goto L6;
        r102.onPageStart(r100, r101);
        return;
    }

    @Override // pd.i
    public final void onReceivedError(WebView r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "webView");
        ti.k r103 = this.f44311a;
        if (r103 == null) goto L6;
        r103.s(r100, r101, r102);
        return;
    }
}
