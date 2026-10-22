package com.bytedance.android.live.room.discovery;

import android.webkit.WebView;
import com.bytedance.android.live.browser.IBrowserService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class q0 implements IBrowserService.PageErrorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TopLeftActivityBannerWidget f99582a;

    public q0(TopLeftActivityBannerWidget r100) {
        this.f99582a = r100;
    }

    @Override // com.bytedance.android.live.browser.IBrowserService.PageErrorListener, com.bytedance.android.live.browser.IBaseBrowserService.PageErrorListener
    public final void onReceiveError(WebView r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "webView");
        Intrinsics.checkNotNullParameter(r101, "url");
        Intrinsics.checkNotNullParameter(r102, "msg");
        this.f99582a.contentView.setVisibility(4);
    }
}
