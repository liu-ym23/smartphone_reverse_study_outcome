package com.bytedance.android.btm.bridge;

import android.text.TextUtils;
import android.view.View;
import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.inner.ALogger;
import com.bytedance.android.btm.api.inner.g;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.btm.bridge.method.j;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import com.ss.ttvideoengine.DataLoaderHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class BtmBridgeProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f42076a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final cd.c f42077b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final BtmBridgeProvider f42078c = null;

    static {
        f42076a = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(Reflection.getOrCreateKotlinClass(BtmBridgeProvider.class), "hybridContainerContext", "getHybridContainerContext()Lcom/bytedance/android/btm/bridge/IHybridContainerContext;"))};
        f42078c = new BtmBridgeProvider();
        f42077b = new cd.c(BtmBridgeProvider$hybridContainerContext$2.INSTANCE);
    }

    public BtmBridgeProvider() {
    }

    public static BtmItemBuilder a(JSONObject r100, View r110, final String r111) {
        if (r111 != null) goto L5;
        r111 = r100.optString("btm");
    L5:
        Object r101 = null;
        if (TextUtils.isEmpty(r111) == false) goto L8;
        return null;
    L8:
        ArrayList r102 = new ArrayList();
        JSONArray r103 = r100.optJSONArray("target_pages");
        if (r103 == null) goto L13;
        int r104 = r103.length();
        int r105 = 0;
    L11:
        if (r105 >= r104) goto L13;
        r102.add(r103.optString(r105));
        r105 = r105 + 1;
    L13:
        Object r106 = r100.opt("bcm_description");
        if (r106 != null) goto L16;
    L25:
        final boolean r107 = r100.optBoolean("enter_new_page", false);
        if (r110 != null) goto L28;
        g.a.a(BtmSDK.INSTANCE.getService().getMonitor(), DataLoaderHelper.DATALOADER_KEY_INT_CHECK_CACHE_DIR, null, null, new BtmBridgeProvider$createBtmBuilder$2(r111, r107), 30);
    L28:
        BtmItemBuilder r108 = new BtmItemBuilder(r111, Boolean.valueOf(r107)).withView(r110);
        r108.internalSetUnitParams("description", r101);
        return r108.setTargetPagesBtm(r102);
    L16:
        if ((r106 instanceof JSONObject) == false) goto L18;
        BcmParams.a r109 = BcmParams.Companion;
        Map<String, Object> r112 = cd.a.e((JSONObject) r106);
        r109.getClass();
        r101 = BcmParams.a.c(r112);
        goto L25
    L18:
        boolean r113 = r106 instanceof Map;
        if (r113 == false) goto L25;
        BcmParams.a r114 = BcmParams.Companion;
        if (r113 == false) goto L24;
        r101 = r106;
    L24:
        r114.getClass();
        r101 = BcmParams.a.c((Map) r101);
        goto L25
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v4, types: [T, java.lang.Object, java.lang.String] */
    public static void c(final JSONObject r110, final View r111, Function3 r112) {
        final String r113 = r110.optString("btm");
        ALogger.c(ALogger.f41996d, "FE_createBtmChain", new BtmBridgeProvider$createBtmChain$2(r110));
        if (TextUtils.isEmpty(r113.toString()) == false) goto L6;
        r112.invoke(Boolean.FALSE, null, "createBtmChain must have a btm param");
        return;
    L6:
        final BtmItemBuilder r100 = a(r110, r111, r113);
        final Ref.ObjectRef r114 = new Ref.ObjectRef();
        r114.element = null;
        if (r100 == null) goto L15;
        final com.bytedance.android.btm.api.model.c r101 = r100.build();
        BtmSDK r102 = BtmSDK.INSTANCE;
        ?? r103 = r102.createBtmId(r101);
        r114.element = r103;
        if (r111 == null) goto L15;
        if (Intrinsics.areEqual(r103, "") == false) goto L15;
        g.a.a(r102.getService().getMonitor(), DataLoaderHelper.DATALOADER_KEY_INT_NET_LOG_MAX_SIZE, r113, null, new BtmBridgeProvider$createBtmChain$$inlined$apply$lambda$1(r101, r100, r114, r111, r113), 28);
    L15:
        if (r110.optBoolean("add_btm_chain") == false) goto L17;
        int r104 = r110.optInt("chain_length", 10);
    L18:
        BtmSDK r105 = BtmSDK.INSTANCE;
        Map<String, Object> r106 = r105.getService().generateBtmEventParams((String) r114.element, r104, null);
        if (r106 != null) goto L21;
    L24:
        boolean r107 = true;
    L25:
        if (r107 == false) goto L27;
        g.a.b(r105.getService().getMonitor(), 1112, null, null, false, 30);
    L27:
        LinkedHashMap r108 = new LinkedHashMap();
        Iterator<Map.Entry<String, Object>> r109 = r106.entrySet().iterator();
    L29:
        if (r109.hasNext() == false) goto L37;
        Map.Entry<String, Object> r115 = r109.next();
        if (r115.getValue() == null) goto L29;
        String r116 = r115.getKey();
        Object r117 = r115.getValue();
        if (r117 != null) goto L35;
        Intrinsics.throwNpe();
    L35:
        r108.put(r116, r117);
        goto L29
    L37:
        if (r110.optBoolean("enter_new_page", false) == false) goto L43;
        String r118 = (String) r114.element;
        if (r118 == null) goto L43;
        if (r118 != null) goto L42;
        Intrinsics.throwNpe();
    L42:
        r108.put("btm_enter_page", r118);
    L43:
        r112.invoke(Boolean.TRUE, r108, "");
        return;
    L21:
        if (r106.isEmpty() == true) goto L24;
        r107 = false;
        goto L25
    L17:
        r104 = 0;
        goto L18
    }

    public static void b(XReadableMap r100, final XBridgeMethod.Callback r101, g66.c r102, final XCoreBridgeMethod r103) {
        if (r102 != null) goto L10;
        View r104 = null;
    L5:
        c(cd.a.c(r100.toMap()), r104, new BtmBridgeProvider$createBtmChain$1(r103, r101));     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        int r105 = j.f42100a;
        j.a(r103, r101, "Exception：" + e.getMessage());
        return;
    L10:
        r104 = HybridContainerContextManager.c(r102);     // Catch: Exception -> L7
        goto L5
    }
}
