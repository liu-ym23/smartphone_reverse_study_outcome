package com.bytedance.android.monitorV2.webview.ttweb;

import com.bytedance.android.monitorV2.webview.j;
import com.bytedance.lynx.webview.glue.IWebViewExtension;
import com.bytedance.lynx.webview.glue.sdk113.IPerformanceTimingListenersdk113;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class c implements IWebViewExtension.PerformanceTimingListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f163386a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f163387b;

    @Override // com.bytedance.lynx.webview.glue.sdk113.IPerformanceTimingListenersdk113
    public final void onBodyParsing() {
    }

    @Override // com.bytedance.lynx.webview.glue.sdk112.IPerformanceTimingListenersdk112
    public final void onCustomTagNotify(String r100) {
    }

    @Override // com.bytedance.lynx.webview.glue.sdk111.IPerformanceTimingListenersdk111
    public final void onDOMContentLoaded() {
    }

    @Override // com.bytedance.lynx.webview.glue.sdk113.IPerformanceTimingListenersdk113
    public final void onFirstImagePaint() {
    }

    @Override // com.bytedance.lynx.webview.glue.sdk111.IPerformanceTimingListenersdk111
    public final void onFirstMeaningfulPaint() {
    }

    @Override // com.bytedance.lynx.webview.glue.sdk112.IPerformanceTimingListenersdk112
    public final void onFirstScreenPaint() {
    }

    @Override // com.bytedance.lynx.webview.glue.sdk113.IPerformanceTimingListenersdk113
    public final /* synthetic */ void onGetJavaScriptStackTrace(String r100) {
        IPerformanceTimingListenersdk113.CC.$default$onGetJavaScriptStackTrace(this, r100);
    }

    @Override // com.bytedance.lynx.webview.glue.sdk113.IPerformanceTimingListenersdk113
    public final void onIframeLoaded(String r100) {
    }

    @Override // com.bytedance.lynx.webview.glue.sdk113.IPerformanceTimingListenersdk113
    public final /* synthetic */ void onImageTimelineInfo(String r100) {
        IPerformanceTimingListenersdk113.CC.$default$onImageTimelineInfo(this, r100);
    }

    @Override // com.bytedance.lynx.webview.glue.sdk113.IPerformanceTimingListenersdk113
    public final void onJSError(String r100) {
    }

    @Override // com.bytedance.lynx.webview.glue.sdk113.IPerformanceTimingListenersdk113
    public final void onNetFinish() {
    }

    @Override // com.bytedance.lynx.webview.glue.sdk112.IPerformanceTimingListenersdk112
    public final void onReceivedResponse(String r100) {
    }

    @Override // com.bytedance.lynx.webview.glue.sdk112.IPerformanceTimingListenersdk112, com.bytedance.lynx.webview.glue.sdk113.IPerformanceTimingListenersdk113
    public final void onReceivedSpecialEvent(String r100) {
    }

    @Override // com.bytedance.lynx.webview.glue.sdk113.IPerformanceTimingListenersdk113
    public final /* synthetic */ void onScrollingSmoothnessInfo(String r100) {
        IPerformanceTimingListenersdk113.CC.$default$onScrollingSmoothnessInfo(this, r100);
    }

    @Override // com.bytedance.lynx.webview.glue.sdk111.IPerformanceTimingListenersdk111
    public final void onFirstContentfulPaint() {
        nz2.b.a(this.f163387b, "onFirstContentfulPaint");
        this.f163386a.a();
    }

    public c(j r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.f163386a = r100;
        this.f163387b = "TTWebViewTimingImpl";
    }
}
