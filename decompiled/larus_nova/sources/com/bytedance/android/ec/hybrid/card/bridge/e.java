package com.bytedance.android.ec.hybrid.card.bridge;

import com.bytedance.android.ec.hybrid.card.event.ECEventCenter;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes44.dex */
public final class e implements IDLXBridgeMethod, com.bytedance.sdk.xbridge.cn.protocol.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f46414a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IDLXBridgeMethod.Access f46415b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final IDLXBridgeMethod.Compatibility f46416c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f46417d;

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
        return this.f46415b;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final IDLXBridgeMethod.Compatibility getCompatibility() {
        return this.f46416c;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f46414a;
    }

    public e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "sceneID");
        this.f46417d = r100;
        this.f46414a = "ec.clearEvent";
        this.f46415b = IDLXBridgeMethod.Access.PUBLIC;
        this.f46416c = IDLXBridgeMethod.Compatibility.Compatible;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final void realHandle(IBDXBridgeContext r110, Map<String, ? extends Object> r111, IDLXBridgeMethod.a r112) {
        Intrinsics.checkNotNullParameter(r110, "bridgeContext");
        Intrinsics.checkNotNullParameter(r111, "params");
        Intrinsics.checkNotNullParameter(r112, "callback");
        Object r100 = r111.get("eventName");
        Object r101 = null;
        if ((r100 instanceof String) == true) goto L5;
        r100 = null;
    L5:
        String r102 = (String) r100;
        if (r102 != null) goto L8;
    L11:
        boolean r103 = true;
    L13:
        if (r103 == false) goto L16;
        r112.invoke(MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("code", 0)}));
        return;
    L16:
        String r104 = this.f46417d;
        Object r105 = r111.get("isSticky");
        if ((r105 instanceof Boolean) == true) goto L19;
        r105 = null;
    L19:
        Boolean r106 = (Boolean) r105;
        Object r107 = r111.get("timestampLower");
        if ((r107 instanceof Long) == true) goto L22;
        r107 = null;
    L22:
        Long r108 = (Long) r107;
        Object r113 = r111.get("timestampUpper");
        if ((r113 instanceof Long) == false) goto L26;
        r101 = r113;
    L26:
        Lazy r114 = ECEventCenter.f46471a;
        Intrinsics.checkNotNullParameter(r102, "eventName");
        Intrinsics.checkNotNullParameter(r104, "sceneId");
        ECEventCenter.d().h(r102, r104, r106, r108, (Long) r101);
        r112.invoke(MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("code", 1)}));
        return;
    L8:
        if (StringsKt.isBlank(r102) == true) goto L11;
        r103 = false;
        goto L13
    }
}
