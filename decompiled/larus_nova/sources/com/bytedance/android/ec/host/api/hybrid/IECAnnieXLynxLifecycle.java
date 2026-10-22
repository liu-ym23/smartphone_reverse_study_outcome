package com.bytedance.android.ec.host.api.hybrid;

import android.net.Uri;
import android.view.View;
import com.alipay.sdk.m.p.e;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.lark.chat.core.dependency.ForwardDependency$ForwardLocation;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001:\u0001-J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\u001c\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\tH&J\u0012\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH&J$\u0010\u0010\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H&J\u001a\u0010\u0015\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u001c\u0010\u0016\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J$\u0010\u0017\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0011\u001a\u00020\u0012H&J\u001c\u0010\u001a\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u0014H&J\u0012\u0010\u001c\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u001c\u0010\u001d\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H&J\u0012\u0010\u001e\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0018\u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\"H&J\u001e\u0010#\u001a\u00020\u00032\u0014\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0001\u0018\u00010%H&J>\u0010&\u001a\u00020\u00032\u0014\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0001\u0018\u00010%2\u0014\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020(\u0018\u00010%2\b\u0010)\u001a\u0004\u0018\u00010\u0014H&J\u001c\u0010*\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\tH&J\u0012\u0010+\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0014\u0010,\u001a\u0004\u0018\u00010\u00142\b\u0010\u001b\u001a\u0004\u0018\u00010\u0014H&¨\u0006."}, d2 = {"Lcom/bytedance/android/ec/host/api/hybrid/IECAnnieXLynxLifecycle;", "", "onDataUpdated", "", "annieXLynxView", "Landroid/view/View;", LiveCommonConstants.REASON_ON_DEDTROY, "onFirstLoadPerfReady", "pref", "Lorg/json/JSONObject;", "onFirstScreen", "onLoadFail", "uri", "Landroid/net/Uri;", "e", "", "onLoadFailed", "errorCode", "", "errorMsg", "", "onLoadStart", "onLoadUriSuccess", "onModuleMethodInvoked", EventConstant.Key.MODULE, e.f25671s, "onPageStart", "url", "onPageUpdate", "onReceivedError", "onRuntimeReady", "onTemplateReady", "resFrom", "isFromMemory", "", "onTimingSetup", "timingInfo", "", "onTimingUpdate", "updateTiming", "", ForwardDependency$ForwardLocation.FLAG, "onUpdatePerfReady", "onViewDetached", "shouldRedirectImageUrl", "Base", "ec-host-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IECAnnieXLynxLifecycle {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\u001c\u0010\b\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J$\u0010\u0011\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u001a\u0010\u0016\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u001c\u0010\u0017\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J$\u0010\u0018\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u001c\u0010\u001b\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u001c\u001a\u0004\u0018\u00010\u0015H\u0016J\u0012\u0010\u001d\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u001c\u0010\u001e\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0012\u0010\u001f\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0018\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020#H\u0016J\u001e\u0010$\u001a\u00020\u00042\u0014\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020'\u0018\u00010&H\u0016J>\u0010(\u001a\u00020\u00042\u0014\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020'\u0018\u00010&2\u0014\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020*\u0018\u00010&2\b\u0010+\u001a\u0004\u0018\u00010\u0015H\u0016J\u001c\u0010,\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010-\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0014\u0010.\u001a\u0004\u0018\u00010\u00152\b\u0010\u001c\u001a\u0004\u0018\u00010\u0015H\u0016¨\u0006/"}, d2 = {"Lcom/bytedance/android/ec/host/api/hybrid/IECAnnieXLynxLifecycle$Base;", "Lcom/bytedance/android/ec/host/api/hybrid/IECAnnieXLynxLifecycle;", "()V", "onDataUpdated", "", "annieXLynxView", "Landroid/view/View;", LiveCommonConstants.REASON_ON_DEDTROY, "onFirstLoadPerfReady", "pref", "Lorg/json/JSONObject;", "onFirstScreen", "onLoadFail", "uri", "Landroid/net/Uri;", "e", "", "onLoadFailed", "errorCode", "", "errorMsg", "", "onLoadStart", "onLoadUriSuccess", "onModuleMethodInvoked", EventConstant.Key.MODULE, e.f25671s, "onPageStart", "url", "onPageUpdate", "onReceivedError", "onRuntimeReady", "onTemplateReady", "resFrom", "isFromMemory", "", "onTimingSetup", "timingInfo", "", "", "onTimingUpdate", "updateTiming", "", ForwardDependency$ForwardLocation.FLAG, "onUpdatePerfReady", "onViewDetached", "shouldRedirectImageUrl", "ec-host-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static class Base implements IECAnnieXLynxLifecycle {
        public Base() {
        }

        @Override // com.bytedance.android.ec.host.api.hybrid.IECAnnieXLynxLifecycle
        public void onDataUpdated(View r100) {
        }

        @Override // com.bytedance.android.ec.host.api.hybrid.IECAnnieXLynxLifecycle
        public void onDestroy() {
        }

        @Override // com.bytedance.android.ec.host.api.hybrid.IECAnnieXLynxLifecycle
        public void onFirstLoadPerfReady(View r100, JSONObject r101) {
        }

        @Override // com.bytedance.android.ec.host.api.hybrid.IECAnnieXLynxLifecycle
        public void onFirstScreen(View r100) {
        }

        @Override // com.bytedance.android.ec.host.api.hybrid.IECAnnieXLynxLifecycle
        public void onLoadFail(Uri r100, Throwable r101) {
            Intrinsics.checkNotNullParameter(r100, "uri");
            Intrinsics.checkNotNullParameter(r101, "e");
        }

        @Override // com.bytedance.android.ec.host.api.hybrid.IECAnnieXLynxLifecycle
        public void onLoadFailed(View r100, int r101, String r102) {
        }

        @Override // com.bytedance.android.ec.host.api.hybrid.IECAnnieXLynxLifecycle
        public void onLoadStart(Uri r100, View r101) {
            Intrinsics.checkNotNullParameter(r100, "uri");
        }

        @Override // com.bytedance.android.ec.host.api.hybrid.IECAnnieXLynxLifecycle
        public void onLoadUriSuccess(Uri r100, View r101) {
        }

        @Override // com.bytedance.android.ec.host.api.hybrid.IECAnnieXLynxLifecycle
        public void onModuleMethodInvoked(String r100, String r101, int r102) {
        }

        @Override // com.bytedance.android.ec.host.api.hybrid.IECAnnieXLynxLifecycle
        public void onPageStart(View r100, String r101) {
        }

        @Override // com.bytedance.android.ec.host.api.hybrid.IECAnnieXLynxLifecycle
        public void onPageUpdate(View r100) {
        }

        @Override // com.bytedance.android.ec.host.api.hybrid.IECAnnieXLynxLifecycle
        public void onReceivedError(View r100, String r101) {
        }

        @Override // com.bytedance.android.ec.host.api.hybrid.IECAnnieXLynxLifecycle
        public void onRuntimeReady(View r100) {
        }

        @Override // com.bytedance.android.ec.host.api.hybrid.IECAnnieXLynxLifecycle
        public void onTemplateReady(String r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "resFrom");
        }

        @Override // com.bytedance.android.ec.host.api.hybrid.IECAnnieXLynxLifecycle
        public void onTimingSetup(Map<String, Object> r100) {
        }

        @Override // com.bytedance.android.ec.host.api.hybrid.IECAnnieXLynxLifecycle
        public void onTimingUpdate(Map<String, Object> r100, Map<String, Long> r101, String r102) {
        }

        @Override // com.bytedance.android.ec.host.api.hybrid.IECAnnieXLynxLifecycle
        public void onUpdatePerfReady(View r100, JSONObject r101) {
        }

        @Override // com.bytedance.android.ec.host.api.hybrid.IECAnnieXLynxLifecycle
        public void onViewDetached(View r100) {
        }

        @Override // com.bytedance.android.ec.host.api.hybrid.IECAnnieXLynxLifecycle
        public String shouldRedirectImageUrl(String r100) {
            return null;
        }
    }

    void onDataUpdated(View r100);

    void onDestroy();

    void onFirstLoadPerfReady(View r100, JSONObject r101);

    void onFirstScreen(View r100);

    void onLoadFail(Uri r100, Throwable r101);

    void onLoadFailed(View r100, int r101, String r102);

    void onLoadStart(Uri r100, View r101);

    void onLoadUriSuccess(Uri r100, View r101);

    void onModuleMethodInvoked(String r100, String r101, int r102);

    void onPageStart(View r100, String r101);

    void onPageUpdate(View r100);

    void onReceivedError(View r100, String r101);

    void onRuntimeReady(View r100);

    void onTemplateReady(String r100, boolean r101);

    void onTimingSetup(Map<String, Object> r100);

    void onTimingUpdate(Map<String, Object> r100, Map<String, Long> r101, String r102);

    void onUpdatePerfReady(View r100, JSONObject r101);

    void onViewDetached(View r100);

    String shouldRedirectImageUrl(String r100);
}
