package com.bytedance.android.btm.bridge.method;

import com.bytedance.android.btm.bridge.HybridContainerContextManager;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f42100a = 0;

    static {
    }

    public static void a(XCoreBridgeMethod r100, XBridgeMethod.Callback r101, String r102) {
        XCoreBridgeMethod.onFailure$default(r100, r101, 0, r102, null, 8, null);
    }

    public static void b(XCoreBridgeMethod r100, XBridgeMethod.Callback r101, Map r110) {
        Lazy r102 = HybridContainerContextManager.f42079a;
        g66.c r103 = r100.getContextProviderFactory();
        String r104 = "unkown";
        if (r103 == null) goto L12;
        int r105 = ((List) HybridContainerContextManager.f42079a.getValue()).size();
        int r106 = 0;
        String r107 = "unkown";
    L5:
        if (r106 >= r105) goto L10;
        r107 = ((com.bytedance.android.btm.bridge.b) ListProtector.get((List) HybridContainerContextManager.f42079a.getValue(), r106)).getHybridContainerType(r103);
        if ((!Intrinsics.areEqual(r107, "unkown")) == true) goto L10;
        r106 = r106 + 1;
    L10:
        r104 = r107;
    L12:
        if (Intrinsics.areEqual(r104, "live") == false) goto L14;
    L17:
        LinkedHashMap r108 = new LinkedHashMap();
        r108.put("data", r110);
        Map r109 = r108;
    L18:
        XCoreBridgeMethod.onSuccess$default(r100, r101, r109, null, 4, null);
        return;
    L14:
        if (Intrinsics.areEqual(r104, "anniex_live") == true) goto L17;
        r109 = r110;
        goto L18
    }
}
