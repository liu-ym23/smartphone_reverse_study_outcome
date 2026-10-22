package com.bytedance.android.ec.hybrid.card.bridge;

import android.view.View;
import com.bytedance.android.btm.api.inner.ALogger;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ecom.bcm.track.api.EcomBcmTracker;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class AppendEntranceInfoBridge implements IDLXBridgeMethod, com.bytedance.sdk.xbridge.cn.protocol.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f46386a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IDLXBridgeMethod.Access f46387b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final IDLXBridgeMethod.Compatibility f46388c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<View> f46389d;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final boolean canRunInBackground() {
        return false;
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.h
    public final void release() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f46387b;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Compatibility getCompatibility() {
        return this.f46388c;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f46386a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AppendEntranceInfoBridge(Function0<? extends View> r100) {
        Intrinsics.checkNotNullParameter(r100, "obtainViewHandler");
        this.f46389d = r100;
        this.f46386a = "appendEntranceInfo";
        this.f46387b = IDLXBridgeMethod.Access.PUBLIC;
        this.f46388c = IDLXBridgeMethod.Compatibility.Compatible;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final void realHandle(IBDXBridgeContext r100, final Map<String, ? extends Object> r101, IDLXBridgeMethod.a r102) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        Object r103 = r101.get(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO);
        String r104 = null;
        if (r103 == null) goto L5;
        String r105 = r103.toString();
    L6:
        ALogger.c(ALogger.f41996d, "FE_appendEntranceInfo", new AnonymousClass1(r101));
        LinkedHashMap r106 = new LinkedHashMap();
        JSONObject r107 = new JSONObject(r105);     // Catch: Exception -> L9
    L10:
        JSONObject r108 = EcomBcmTracker.c(PageFinder.via(this.f46389d.invoke()), r107);     // Catch: Exception -> L15
        if (r108 == null) goto L13;
        r104 = r108.toString();     // Catch: Exception -> L15
    L13:
        r106.put(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO, r104);     // Catch: Exception -> L15
    L17:
        LinkedHashMap r109 = new LinkedHashMap();
        r109.put("code", 1);
        r109.put("data", r106);
        r102.invoke(r109);
        return;
    L9:
        r107 = new JSONObject();     // Catch: Exception -> L15
    L15:
        e = move-exception;
        ALogger.c(ALogger.f41996d, "FE_appendEntranceInfo", new AnonymousClass3(e));
        r106.put(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO, r105);
        goto L17
    L5:
        r105 = null;
        goto L6
    }
}
