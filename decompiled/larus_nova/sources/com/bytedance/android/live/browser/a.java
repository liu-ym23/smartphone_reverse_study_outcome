package com.bytedance.android.live.browser;

import android.view.View;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.live.core.monitor.BaseMonitor;
import com.bytedance.android.live.core.monitor.LiveTraceSchemaMonitor;
import com.bytedance.android.livesdkapi.jsb.IExternalAnnieLifecycle;
import com.bytedance.android.livesdkapi.monitor.ILiveHybridMonitor;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class a extends b7.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IExternalAnnieLifecycle f62574a;

    @Override // b7.a, b7.b
    public final void onBeforeGlobalPropsInitialize() {
        IExternalAnnieLifecycle r100 = this.f62574a;
        if (r100 == null) goto L6;
        r100.onBeforeGlobalPropsInitialize();
        return;
    }

    @Override // b7.a, b7.b
    public final void onBeforeInitialPropsInitialize() {
        IExternalAnnieLifecycle r100 = this.f62574a;
        if (r100 == null) goto L6;
        r100.onBeforeInitialPropsInitialize();
        return;
    }

    @Override // b7.a, b7.b
    public final void onBeforeJsbRegister() {
        IExternalAnnieLifecycle r100 = this.f62574a;
        if (r100 == null) goto L6;
        r100.onBeforeJsbRegister();
        return;
    }

    @Override // b7.a, b7.b
    public final void onBeforeOpenContainer() {
        IExternalAnnieLifecycle r100 = this.f62574a;
        if (r100 == null) goto L6;
        r100.onBeforeOpenContainer();
        return;
    }

    @Override // b7.a, b7.b
    public final void onContainerInitEnd() {
        IExternalAnnieLifecycle r100 = this.f62574a;
        if (r100 == null) goto L6;
        r100.onContainerInitEnd();
        return;
    }

    @Override // b7.a, b7.b
    public final void onContainerInitStart() {
        IExternalAnnieLifecycle r100 = this.f62574a;
        if (r100 == null) goto L6;
        r100.onContainerInitStart();
        return;
    }

    @Override // b7.a, b7.b
    public final void onGlobalPropsInitialized() {
        IExternalAnnieLifecycle r100 = this.f62574a;
        if (r100 == null) goto L6;
        r100.onGlobalPropsInitialized();
        return;
    }

    @Override // b7.a, b7.b
    public final void onInitialPropsInitialized() {
        IExternalAnnieLifecycle r100 = this.f62574a;
        if (r100 == null) goto L6;
        r100.onInitialPropsInitialized();
        return;
    }

    @Override // b7.a, b7.b
    public final void onJsbRegistered() {
        IExternalAnnieLifecycle r100 = this.f62574a;
        if (r100 == null) goto L6;
        r100.onJsbRegistered();
        return;
    }

    @Override // b7.a, b7.b
    public final void onLynxEnvInitialized() {
        IExternalAnnieLifecycle r100 = this.f62574a;
        if (r100 == null) goto L6;
        r100.onLynxEnvInitialized();
        return;
    }

    @Override // b7.a, b7.b
    public final void onPrepareComponentEnd() {
        IExternalAnnieLifecycle r100 = this.f62574a;
        if (r100 == null) goto L6;
        r100.onPrepareComponentEnd();
        return;
    }

    @Override // b7.a, b7.b
    public final void onPrepareComponentStart() {
        IExternalAnnieLifecycle r100 = this.f62574a;
        if (r100 == null) goto L6;
        r100.onPrepareComponentStart();
        return;
    }

    @Override // b7.a, b7.b
    public final void onPrepareInitDataEnd() {
        IExternalAnnieLifecycle r100 = this.f62574a;
        if (r100 == null) goto L6;
        r100.onPrepareInitDataEnd();
        return;
    }

    @Override // b7.a, b7.b
    public final void onPrepareTemplateStart() {
        IExternalAnnieLifecycle r100 = this.f62574a;
        if (r100 == null) goto L6;
        r100.onPrepareTemplateStart();
        return;
    }

    @Override // b7.a, b7.b
    public final void onRelease() {
        IExternalAnnieLifecycle r100 = this.f62574a;
        if (r100 == null) goto L5;
        r100.onRelease();
    L5:
        y50.i.m(ILiveHybridMonitor.ContainerType.ANNIE, null, null, "AnnieLifecycleProxy.onRelease()", 0, null, null, 102);
    }

    public a(IExternalAnnieLifecycle r100) {
        this.f62574a = r100;
    }

    @Override // b7.a, b7.b
    public final void onBeforeCreateRenderData(View r100) {
        Intrinsics.checkNotNullParameter(r100, "hybridView");
        IExternalAnnieLifecycle r101 = this.f62574a;
        if (r101 == null) goto L6;
        r101.onBeforeCreateRenderData(r100);
        return;
    }

    @Override // b7.a, b7.b
    public final void onBeforeLynxEnvInitialize(boolean r100) {
        IExternalAnnieLifecycle r101 = this.f62574a;
        if (r101 == null) goto L6;
        r101.onBeforeLynxEnvInitialize(r100);
        return;
    }

    @Override // b7.a, b7.b
    public final void onLoadSuccess(View r110) {
        IExternalAnnieLifecycle r100 = this.f62574a;
        if (r100 == null) goto L5;
        r100.onLoadSuccess(r110);
    L5:
        BaseMonitor.MonitorEventModule r101 = BaseMonitor.MonitorEventModule.HYBRID;
        LiveTraceSchemaMonitor.Status r102 = LiveTraceSchemaMonitor.Status.SUCCESS;
        JSONObject r103 = new JSONObject();
        r103.put("hybrid_type", LiveTraceSchemaMonitor.HybridType.ANNIE);
        Unit r104 = Unit.INSTANCE;
        LiveTraceSchemaMonitor.l(r101, r102, "Annie页面加载成功", "", "AnnieLifecycleProxy", r103);
        y50.i.m(ILiveHybridMonitor.ContainerType.ANNIE, null, null, "AnnieLifecycleProxy.onLoadSuccess()", 0, null, null, 102);
    }

    @Override // b7.a, b7.b
    public final void onPrepareTemplateEnd(boolean r100) {
        IExternalAnnieLifecycle r101 = this.f62574a;
        if (r101 == null) goto L6;
        r101.onPrepareTemplateEnd();
        return;
    }

    @Override // b7.a, b7.b
    public final void onCreateRenderData(View r100, Set<String> r101) {
        Intrinsics.checkNotNullParameter(r100, "hybridView");
        Intrinsics.checkNotNullParameter(r101, "stateKeys");
        IExternalAnnieLifecycle r102 = this.f62574a;
        if (r102 == null) goto L6;
        r102.onCreateRenderData(r100, r101);
        return;
    }

    @Override // b7.a, b7.b
    public final boolean onFallback(int r110, String r111) {
        Intrinsics.checkNotNullParameter(r111, "errorMessage");
        BaseMonitor.MonitorEventModule r100 = BaseMonitor.MonitorEventModule.HYBRID;
        LiveTraceSchemaMonitor.Status r101 = LiveTraceSchemaMonitor.Status.HYBRID_ANNIE_LOAD_FAIL;
        JSONObject r102 = new JSONObject();
        r102.put("hybrid_type", LiveTraceSchemaMonitor.HybridType.ANNIE);
        Unit r103 = Unit.INSTANCE;
        LiveTraceSchemaMonitor.l(r100, r101, "Annie页面加载失败：onFallback", "", "AnnieLifecycleProxy", r102);
        JSONObject r104 = new JSONObject();
        r104.put("errorCode", r110);
        y50.i.m(ILiveHybridMonitor.ContainerType.ANNIE, null, null, "AnnieLifecycleProxy.onFallback()", 1, r111, r104, 6);
        IExternalAnnieLifecycle r105 = this.f62574a;
        if (r105 != null) goto L7;
        return false;
    L7:
        return r105.onFallback(r110, r111);
    }

    @Override // b7.a, b7.b
    public final void onInnerFallback(int r110, String r111) {
        Intrinsics.checkNotNullParameter(r111, "errorMessage");
        IExternalAnnieLifecycle r100 = this.f62574a;
        if (r100 == null) goto L5;
        r100.onInnerFallback(r110, r111);
    L5:
        JSONObject r101 = new JSONObject();
        r101.put("errorCode", r110);
        Unit r112 = Unit.INSTANCE;
        y50.i.m(ILiveHybridMonitor.ContainerType.ANNIE, null, null, "AnnieLifecycleProxy#onInnerFallback()", 1, r111, r101, 6);
    }

    @Override // b7.a, b7.b
    public final void onLoadStart(View r110, boolean r111) {
        IExternalAnnieLifecycle r100 = this.f62574a;
        if (r100 == null) goto L5;
        r100.onLoadStart(r110, r111);
    L5:
        y50.i.m(ILiveHybridMonitor.ContainerType.ANNIE, null, null, "AnnieLifecycleProxy.onLoadStart()", 0, null, null, 102);
    }

    @Override // b7.a, b7.b
    public final void onAttachView(View r100, IHybridComponent.HybridType r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "hybridType");
        IExternalAnnieLifecycle r103 = this.f62574a;
        if (r103 == null) goto L6;
        r103.onAttachView(r100, r101.getHybridName());
        return;
    }

    @Override // b7.a, b7.b
    public final void onContainerError(View r110, int r111, String r112) {
        Intrinsics.checkNotNullParameter(r112, "errorMessage");
        IExternalAnnieLifecycle r100 = this.f62574a;
        if (r100 == null) goto L5;
        r100.onContainerError(r110, r111, r112);
    L5:
        JSONObject r101 = new JSONObject();
        r101.put("errorCode", r111);
        Unit r113 = Unit.INSTANCE;
        y50.i.m(ILiveHybridMonitor.ContainerType.ANNIE, null, null, "AnnieLifecycleProxy.onFallback()", 1, r112, r101, 6);
    }

    @Override // b7.a, b7.b
    public final void onLoadFail(View r110, String r111, String r112) {
        String r100 = "";
        if (r112 != null) goto L5;
        String r101 = "";
    L6:
        JSONObject r102 = new JSONObject();
        if (r111 == null) goto L10;
        r100 = r111;
    L10:
        r102.put("url", r100);
        Unit r103 = Unit.INSTANCE;
        y50.i.m(ILiveHybridMonitor.ContainerType.ANNIE, null, null, "AnnieLifecycleProxy.onLoadFail()", 1, r101, r102, 6);
        IExternalAnnieLifecycle r104 = this.f62574a;
        if (r104 == null) goto L14;
        r104.onLoadFail(r110, r111, r112);
        return;
    L14:
        return;
    L5:
        r101 = r112;
        goto L6
    }

    @Override // b7.a, b7.b
    public final void onPrepareInitDataStart(String r110, String r111, boolean r112) {
        Intrinsics.checkNotNullParameter(r110, "scheme");
        Intrinsics.checkNotNullParameter(r111, "fallbackUrl");
        IExternalAnnieLifecycle r100 = this.f62574a;
        if (r100 == null) goto L5;
        r100.onPrepareInitDataStart(r110, r111, r112);
    L5:
        JSONObject r101 = new JSONObject();
        r101.put("fallbackUrl", r111);
        r101.put("isFallback", r112);
        Unit r113 = Unit.INSTANCE;
        y50.i.m(ILiveHybridMonitor.ContainerType.ANNIE, r110, null, "AnnieLifecycleProxy.onPrepareInitDataStart()", r112 ? 1 : 0, null, r101, 36);
    }
}
