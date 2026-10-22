package com.bytedance.android.livesdkapi.jsb;

import android.view.View;
import java.util.Set;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\b\u0017\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0005H&J\b\u0010\n\u001a\u00020\u0003H&J\b\u0010\u000b\u001a\u00020\u0003H&J\b\u0010\f\u001a\u00020\u0003H&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH&J\b\u0010\u0010\u001a\u00020\u0003H&J\"\u0010\u0011\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0007H&J\b\u0010\u0015\u001a\u00020\u0003H&J\b\u0010\u0016\u001a\u00020\u0003H&J\u001e\u0010\u0017\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00052\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00070\u0019H&J\u0018\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0007H&J\b\u0010\u001b\u001a\u00020\u0003H&J\b\u0010\u001c\u001a\u00020\u0003H&J\u0018\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0007H&J\b\u0010\u001e\u001a\u00020\u0003H&J&\u0010\u001f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010 \u001a\u0004\u0018\u00010\u00072\b\u0010!\u001a\u0004\u0018\u00010\u0007H&J\u001a\u0010\"\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010#\u001a\u00020\u000fH&J\u0012\u0010$\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\b\u0010%\u001a\u00020\u0003H&J\b\u0010&\u001a\u00020\u0003H&J\b\u0010'\u001a\u00020\u0003H&J\b\u0010(\u001a\u00020\u0003H&J \u0010)\u001a\u00020\u00032\u0006\u0010*\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u000fH&J\b\u0010-\u001a\u00020\u0003H&J\b\u0010.\u001a\u00020\u0003H&J\b\u0010/\u001a\u00020\u0003H&¨\u00060"}, d2 = {"Lcom/bytedance/android/livesdkapi/jsb/IExternalAnnieLifecycle;", "", "onAttachView", "", "view", "Landroid/view/View;", "hybridType", "", "onBeforeCreateRenderData", "hybridView", "onBeforeGlobalPropsInitialize", "onBeforeInitialPropsInitialize", "onBeforeJsbRegister", "onBeforeLynxEnvInitialize", "coldInit", "", "onBeforeOpenContainer", "onContainerError", "errorCode", "", "errorMessage", "onContainerInitEnd", "onContainerInitStart", "onCreateRenderData", "stateKeys", "", "onFallback", "onGlobalPropsInitialized", "onInitialPropsInitialized", "onInnerFallback", "onJsbRegistered", "onLoadFail", "url", "reason", "onLoadStart", "isOffline", "onLoadSuccess", "onLynxEnvInitialized", "onPrepareComponentEnd", "onPrepareComponentStart", "onPrepareInitDataEnd", "onPrepareInitDataStart", "scheme", "fallbackUrl", "isFallback", "onPrepareTemplateEnd", "onPrepareTemplateStart", "onRelease", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IExternalAnnieLifecycle {
    void onAttachView(View r100, String r101);

    void onBeforeCreateRenderData(View r100);

    void onBeforeGlobalPropsInitialize();

    void onBeforeInitialPropsInitialize();

    void onBeforeJsbRegister();

    void onBeforeLynxEnvInitialize(boolean r100);

    void onBeforeOpenContainer();

    void onContainerError(View r100, int r101, String r102);

    void onContainerInitEnd();

    void onContainerInitStart();

    void onCreateRenderData(View r100, Set<String> r101);

    boolean onFallback(int r100, String r101);

    void onGlobalPropsInitialized();

    void onInitialPropsInitialized();

    void onInnerFallback(int r100, String r101);

    void onJsbRegistered();

    void onLoadFail(View r100, String r101, String r102);

    void onLoadStart(View r100, boolean r101);

    void onLoadSuccess(View r100);

    void onLynxEnvInitialized();

    void onPrepareComponentEnd();

    void onPrepareComponentStart();

    void onPrepareInitDataEnd();

    void onPrepareInitDataStart(String r100, String r101, boolean r102);

    void onPrepareTemplateEnd();

    void onPrepareTemplateStart();

    void onRelease();
}
