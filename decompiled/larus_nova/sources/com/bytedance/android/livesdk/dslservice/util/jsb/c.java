package com.bytedance.android.livesdk.dslservice.util.jsb;

import android.app.Activity;
import android.view.View;
import com.bytedance.sdk.xbridge.cn.PlatformType;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.huawei.hms.api.FailedBinderCallBack;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class c implements IBDXBridgeContext {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final le7.a<?> f122983a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f122984b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f122985c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ue7.d f122986d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f122987e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final PlatformType f122988f;

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXContainerContext
    public final View getEngineView() {
        return null;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXContainerContext
    public final Activity getOwnerActivity() {
        return null;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXContainerContext
    public final <T> T getService(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        return null;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXContainerContext
    public final void sendEvent(String r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext
    public final le7.a<?> getBridgeCall() {
        return this.f122983a;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext
    public final String getCallId() {
        return this.f122984b;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXContainerContext
    public final String getContainerID() {
        return this.f122985c;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXContainerContext
    public final ue7.d getJsEventDelegate() {
        return this.f122986d;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXContainerContext
    public final String getNamespace() {
        return this.f122987e;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXContainerContext
    public final PlatformType getPlatformType() {
        return this.f122988f;
    }

    public c(e r100) {
        d r101 = new d();
        PlatformType r102 = PlatformType.LYNX;
        Intrinsics.checkNotNullParameter(r100, "bridgeCall");
        Intrinsics.checkNotNullParameter("", FailedBinderCallBack.CALLER_ID);
        Intrinsics.checkNotNullParameter("", "containerID");
        Intrinsics.checkNotNullParameter(r101, "jsEventDelegate");
        Intrinsics.checkNotNullParameter("webcast", "namespace");
        Intrinsics.checkNotNullParameter(r102, Keys.API_PARAM_KEY_PLATFORM_TYPE);
        this.f122983a = r100;
        this.f122984b = "";
        this.f122985c = "";
        this.f122986d = r101;
        this.f122987e = "webcast";
        this.f122988f = r102;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext
    public final void setCallId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f122984b = r100;
    }
}
