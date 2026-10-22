package com.bytedance.android.ec.core.hybrid.bridges;

import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
@XBridgeMethod(name = "mall.deliveryRecord")
public final class ECMallDeliveryRecordXMethod extends f {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f44118d;

    public final s83.h a() {
        return (s83.h) this.f44118d.getValue();
    }

    public ECMallDeliveryRecordXMethod() {
        this.f44118d = LazyKt.lazy(ECMallDeliveryRecordXMethod$monitorServer$2.INSTANCE);
    }

    public final void b(String r100, CompletionBlock<f.c> r101) {
        r101.onFailure(0, r100, (XBaseResultModel) ne7.e.c(Reflection.getOrCreateKotlinClass(f.c.class)));
    }

    public final void c(CompletionBlock<f.c> r100, Map<String, ? extends Object> r101) {
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L10
        JSONObject r103 = new JSONObject();     // Catch: Throwable -> L10
        if (r101 == null) goto L8;
        Iterator<Map.Entry<String, ? extends Object>> r104 = r101.entrySet().iterator();     // Catch: Throwable -> L10
    L6:
        if (r104.hasNext() == false) goto L8;
        Map.Entry<String, ? extends Object> r105 = r104.next();     // Catch: Throwable -> L10
        r103.putOpt(r105.getKey(), r105.getValue());     // Catch: Throwable -> L10
    L8:
        f.c r106 = (f.c) ne7.e.c(Reflection.getOrCreateKotlinClass(f.c.class));     // Catch: Throwable -> L10
        r106.setDeliveryInfo(r103);     // Catch: Throwable -> L10
        CompletionBlock.DefaultImpls.onSuccess$default(r100, r106, null, 2, null);     // Catch: Throwable -> L10
        Object r107 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L10
    L12:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);
        if (r108 == null) goto L19;
        b("getRecord failed: " + r108.getMessage(), r100);
        return;
    L19:
        return;
    L10:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L12
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r110, XBaseParamModel r111, CompletionBlock r112) {
        f.b r113 = (f.b) r111;
        Intrinsics.checkNotNullParameter(r110, "bridgeContext");
        Intrinsics.checkNotNullParameter(r113, "params");
        Intrinsics.checkNotNullParameter(r112, "callback");
        String r114 = r113.getActionType();
        String r100 = r113.getSessionID();
        boolean r101 = false;
        if (r114.length() != 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L8;
    L115:
        b("actionType or sessionId is null", r112);
        return;
    L8:
        if (r100.length() != 0) goto L10;
        boolean r103 = true;
    L11:
        if (r103 == true) goto L115;
        Object r104 = r113.getDeliveryRecord();
        Map r105 = null;
        if ((r104 instanceof JSONObject) == false) goto L17;
        JSONObject r106 = (JSONObject) r104;
    L38:
        LinkedHashMap r107 = new LinkedHashMap();
        if (r106 == null) goto L46;
        Iterator<String> r108 = r106.keys();
        if (r108 == null) goto L46;
    L43:
        if (r108.hasNext() == false) goto L46;
        String r109 = r108.next();
        r107.put(r109, r106.opt(r109));
    L46:
        switch(r114.hashCode()) {
            case -1246914851: goto L84;
            case -235365105: goto L73;
            case 96417: goto L64;
            case 102230: goto L58;
            case 1919834714: goto L49;
            default: goto L113;
        };
    L113:
        b("actionType is error", r112);
        return;
    L49:
        if (r114.equals("publishTTI") == false) goto L113;
        s83.h r115 = a();
        if (r115 == null) goto L53;
        r115.a();
    L53:
        s83.h r116 = a();
        if (r116 == null) goto L56;
        r105 = r116.c();
    L56:
        c(r112, r105);
        return;
    L58:
        if (r114.equals(MonitorConstants.CONNECT_TYPE_GET) == false) goto L113;
        s83.h r117 = a();
        if (r117 == null) goto L62;
        r105 = r117.c();
    L62:
        c(r112, r105);
        return;
    L64:
        if (r114.equals("add") == false) goto L113;
        s83.h r118 = a();
        if (r118 == null) goto L68;
        r118.d();
    L68:
        s83.h r119 = a();
        if (r119 == null) goto L71;
        r105 = r119.c();
    L71:
        c(r112, r105);
        return;
    L73:
        if (r114.equals("publish") == false) goto L113;
        Boolean r120 = r113.isSuccess();
        s83.h r121 = a();
        if (r121 == null) goto L79;
        if (r120 == null) goto L78;
        r120.booleanValue();
    L78:
        r121.b();
    L79:
        s83.h r122 = a();
        if (r122 == null) goto L82;
        r105 = r122.c();
    L82:
        c(r112, r105);
        return;
    L84:
        if (r114.equals("addStage") == false) goto L113;
        String r123 = r113.getDeliveryStage();
        if (r123 != null) goto L89;
        r123 = "";
    L89:
        if (r123.length() != 0) goto L91;
        r101 = true;
    L91:
        if (r101 == false) goto L93;
        b("deliveryStage is empty", r112);
        return;
    L93:
        Long r124 = r113.getTimestamp();
        if (r124 == null) goto L96;
        long r125 = r124.longValue();
    L97:
        LinkedHashMap r126 = new LinkedHashMap();
        if (r106 == null) goto L106;
        Iterator<String> r127 = r106.keys();
        if (r127 == null) goto L106;
    L102:
        if (r127.hasNext() == false) goto L106;
        String r128 = r127.next();
        Object r129 = r106.opt(r128);
        if (r129 == null) goto L102;
        r126.put(r128, r129);
    L106:
        r126.put("delivery_session_id", r100);
        int r130 = ECSdk.f48106a;
        s83.g r131 = (s83.g) ECSdk.a(s83.g.class);
        if (r131 == null) goto L109;
        r131.H(r123, r125, r126);
    L109:
        s83.h r132 = a();
        if (r132 == null) goto L112;
        r105 = r132.c();
    L112:
        c(r112, r105);
        return;
    L96:
        r125 = System.currentTimeMillis();
        goto L97
    L17:
        if ((r104 instanceof Map) == false) goto L36;
        JSONObject r133 = new JSONObject();
        Set r134 = ((Map) r104).entrySet();
        ArrayList r135 = new ArrayList();
        Iterator r136 = r134.iterator();
    L20:
        if (r136.hasNext() == false) goto L24;
        Object r137 = r136.next();
        if ((((Map.Entry) r137).getKey() instanceof String) == false) goto L20;
        r135.add(r137);
        goto L20
    L24:
        Iterator r138 = r135.iterator();
    L26:
        if (r138.hasNext() == false) goto L35;
        Map.Entry r139 = (Map.Entry) r138.next();
        Object r140 = r139.getKey();
        if (r140 == null) goto L34;
        r133.putOpt((String) r140, r139.getValue());     // Catch: Exception -> L32
        goto L26
    L34:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    L35:
        r106 = r133;
        goto L38
    L36:
        if (r104 != null) goto L114;
        r106 = null;
        goto L38
    L114:
        b("deliveryRecord type not supported: ".concat(r104.getClass().getSimpleName()), r112);
        return;
    L10:
        r103 = false;
        goto L11
    L5:
        r102 = false;
        goto L6
    }
}
