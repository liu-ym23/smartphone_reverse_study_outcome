package com.bytedance.android.annie.xbridge.mix;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.webkit.WebView;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.cn.PlatformType;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class p implements IBDXBridgeContext {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o f40178a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f40179b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f40180c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f40181d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final PlatformType f40182e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final a f40183f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ CallContext f40184g;

    public static final class a implements ue7.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CallContext f40185a;

        public a(CallContext r100) {
            this.f40185a = r100;
        }

        @Override // ue7.d
        public final void a(String r100, Map<String, ? extends Object> r101) {
            Intrinsics.checkNotNullParameter(r100, "eventName");
            this.f40185a.b(r100, r101);
        }
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXContainerContext
    public final <T> T getService(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        return null;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXContainerContext
    public final View getEngineView() {
        return this.f40184g.f249269d;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXContainerContext
    public final Activity getOwnerActivity() {
        Context r100 = this.f40184g.getContext();
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type android.app.Activity");
        return (Activity) r100;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext
    public final le7.a<?> getBridgeCall() {
        return this.f40178a;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext
    public final String getCallId() {
        return this.f40179b;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXContainerContext
    public final String getContainerID() {
        return this.f40180c;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXContainerContext
    public final ue7.d getJsEventDelegate() {
        return this.f40183f;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXContainerContext
    public final String getNamespace() {
        return this.f40181d;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXContainerContext
    public final PlatformType getPlatformType() {
        return this.f40182e;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext
    public final void setCallId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f40179b = r100;
    }

    public p(o r100, CallContext r101) {
        this.f40184g = r101;
        this.f40178a = r100;
        this.f40179b = "bridgeCall.jsb2.id";
        this.f40180c = String.valueOf(r101.getContext().hashCode());
        this.f40181d = "webcast";
        List<String> r102 = s.f40190a;
        if ((r101.f249269d instanceof WebView) == false) goto L5;
        PlatformType r103 = PlatformType.WEB;
    L6:
        this.f40182e = r103;
        this.f40183f = new a(r101);
        return;
    L5:
        r103 = PlatformType.LYNX;
        goto L6
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IBDXContainerContext
    public final void sendEvent(String r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        this.f40183f.a(r100, r101);
    }
}
