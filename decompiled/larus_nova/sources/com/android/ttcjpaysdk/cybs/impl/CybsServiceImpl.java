package com.android.ttcjpaysdk.cybs.impl;

import android.content.Context;
import android.webkit.WebView;
import com.android.ttcjpaysdk.base.router.CJPayRouterAPI;
import com.android.ttcjpaysdk.base.service.ICJPayCybsService;
import com.android.ttcjpaysdk.cybs.ui.StepUpIFrameActivity;
import com.android.ttcjpaysdk.cybs.utils.DeviceFingerUtils;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J(\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\nH\u0016J(\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016¨\u0006\u0016"}, d2 = {"Lcom/android/ttcjpaysdk/cybs/impl/CybsServiceImpl;", "Lcom/android/ttcjpaysdk/base/service/ICJPayCybsService;", "()V", "getBrowserDeviceFinger", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "callback", "Lcom/android/ttcjpaysdk/base/service/ICJPayCybsService$DeviceFingerResultCallback;", "getPackageName", "", "startDDCIFrame", "webView", "Landroid/webkit/WebView;", "url", "token", "Lcom/android/ttcjpaysdk/base/service/ICJPayCybsService$DDCResultCallback;", "startDMIFrame", "uniqueSessionId", "startStepUpIFrame", "hashCode", "", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CybsServiceImpl implements ICJPayCybsService {
    @Override // com.android.ttcjpaysdk.base.service.ICJPayService
    public String getPackageName() {
        return "com.android.ttcjpaysdk.base.cybs";
    }

    public CybsServiceImpl() {
    }

    @Override // com.android.ttcjpaysdk.base.service.ICJPayCybsService
    public void getBrowserDeviceFinger(Context r100, ICJPayCybsService.DeviceFingerResultCallback r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "callback");
        DeviceFingerUtils.INSTANCE.collentBrowserDeviceFinger(r100, r101);
    }

    @Override // com.android.ttcjpaysdk.base.service.ICJPayCybsService
    public void startDMIFrame(WebView r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "webView");
        Intrinsics.checkNotNullParameter(r101, "uniqueSessionId");
        DeviceFingerUtils.INSTANCE.collectDMDeviceFinger(r100, r101);
    }

    @Override // com.android.ttcjpaysdk.base.service.ICJPayCybsService
    public void startDDCIFrame(WebView r100, String r101, String r102, ICJPayCybsService.DDCResultCallback r103) {
        Intrinsics.checkNotNullParameter(r100, "webView");
        Intrinsics.checkNotNullParameter(r101, "url");
        Intrinsics.checkNotNullParameter(r102, "token");
        Intrinsics.checkNotNullParameter(r103, "callback");
        DeviceFingerUtils.INSTANCE.collectDDCFor3DS(r100, r101, r102, r103);
    }

    @Override // com.android.ttcjpaysdk.base.service.ICJPayCybsService
    public void startStepUpIFrame(Context r100, String r101, String r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "url");
        Intrinsics.checkNotNullParameter(r102, "token");
        CJPayRouterAPI.getInstance().build(StepUpIFrameActivity.class).withInt("eventToken", r103).withString("url", r101).withString("token", r102).withAnimationType(1).navigation(r100);
    }
}
