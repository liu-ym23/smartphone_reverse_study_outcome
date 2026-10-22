package com.bytedance.android.ec.hybrid.list.bridge;

import android.app.Activity;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.sdk.xbridge.cn.protocol.h;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import yj.s;

/* JADX INFO: loaded from: classes44.dex */
public final class SaasAuthenticationBridge implements IDLXBridgeMethod, h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f47001c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IDLXBridgeMethod.Access f47002a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IDLXBridgeMethod.Compatibility f47003b;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final boolean canRunInBackground() {
        return false;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return "ec.saas.authentication";
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.h
    public final void release() {
    }

    public SaasAuthenticationBridge() {
        this.f47002a = IDLXBridgeMethod.Access.PUBLIC;
        this.f47003b = IDLXBridgeMethod.Compatibility.Compatible;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Access getAccess() {
        return this.f47002a;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Compatibility getCompatibility() {
        return this.f47003b;
    }

    public static void a(IDLXBridgeMethod.a r100, int r101) {
        LinkedHashMap r102 = new LinkedHashMap();
        r102.put("code", 1);
        Pair[] r103 = new Pair[3];
        r103[0] = TuplesKt.to("status", Integer.valueOf(r101));
        IHybridHostService r104 = com.bytedance.android.ec.hybrid.a.h();
        String r105 = "";
        if (r104 == null) goto L8;
        s r106 = r104.getIHybridHostUserService();
        if (r106 == null) goto L8;
        String r107 = r106.getAccessToken();
        if (r107 == null) goto L8;
    L9:
        r103[1] = TuplesKt.to("authorization", "Bearer ".concat(r107));
        IHybridHostService r108 = com.bytedance.android.ec.hybrid.a.h();
        if (r108 == null) goto L17;
        s r109 = r108.getIHybridHostUserService();
        if (r109 == null) goto L17;
        String r110 = r109.getCurrentUserId();
        if (r110 == null) goto L17;
        r105 = r110;
    L17:
        r103[2] = TuplesKt.to("openId", r105);
        r102.put("data", MapsKt.mapOf(r103));
        Unit r111 = Unit.INSTANCE;
        r100.invoke(r102);
        return;
    L8:
        r107 = "";
        goto L9
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final void realHandle(IBDXBridgeContext r100, Map<String, ? extends Object> r110, final IDLXBridgeMethod.a r111) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r110, "params");
        Intrinsics.checkNotNullParameter(r111, "callback");
        Object r112 = r110.get("source");
        String r101 = null;
        if ((r112 instanceof String) == true) goto L5;
        r112 = null;
    L5:
        String r113 = (String) r112;
        if (r113 != null) goto L8;
        r113 = "";
    L8:
        final String r102 = r113;
        int r114 = com.bytedance.forest.utils.h.f244547a;
        IHybridHostService r115 = com.bytedance.android.ec.hybrid.a.h();
        if (r115 == null) goto L14;
        s r116 = r115.getIHybridHostUserService();
        if (r116 == null) goto L14;
        r101 = r116.getAccessToken();
    L14:
        if (com.bytedance.forest.utils.h.a(r101) == false) goto L17;
        a(r111, 0);
        return;
    L17:
        Activity r103 = r100.getOwnerActivity();
        if (r103 == null) goto L25;
        IHybridHostService r104 = com.bytedance.android.ec.hybrid.a.h();
        if (r104 == null) goto L26;
        s r105 = r104.getIHybridHostUserService();
        if (r105 == null) goto L27;
        r105.e(r103, r102, "", new SaasAuthenticationBridge$realHandle$$inlined$let$lambda$1(this, r102, r111), new SaasAuthenticationBridge$realHandle$$inlined$let$lambda$2(this, r102, r111));
        return;
    L27:
        return;
    L26:
        return;
    }
}
