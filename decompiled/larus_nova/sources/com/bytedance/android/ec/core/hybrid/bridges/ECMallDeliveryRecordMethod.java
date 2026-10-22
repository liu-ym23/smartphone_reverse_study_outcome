package com.bytedance.android.ec.core.hybrid.bridges;

import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/ec/core/hybrid/bridges/ECMallDeliveryRecordMethod;", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod;", "<init>", "()V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECMallDeliveryRecordMethod extends ECBaseBridgeMethod {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f44117e;

    public final s83.h d() {
        return (s83.h) this.f44117e.getValue();
    }

    @Override // com.bytedance.android.ec.model.hybrid.IECBridgeMethod
    public final String getName() {
        return "mall.deliveryRecord";
    }

    public ECMallDeliveryRecordMethod() {
        this.f44117e = LazyKt.lazy(ECMallDeliveryRecordMethod$monitorServer$2.INSTANCE);
    }

    public static void e(ECBaseBridgeMethod.a r100, Map r101) {
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L10
        JSONObject r103 = new JSONObject();     // Catch: Throwable -> L10
        JSONObject r104 = new JSONObject();     // Catch: Throwable -> L10
        if (r101 == null) goto L8;
        Iterator r105 = r101.entrySet().iterator();     // Catch: Throwable -> L10
    L6:
        if (r105.hasNext() == false) goto L8;
        Map.Entry r106 = (Map.Entry) r105.next();     // Catch: Throwable -> L10
        r104.putOpt((String) r106.getKey(), r106.getValue());     // Catch: Throwable -> L10
    L8:
        r103.putOpt("deliveryInfo", r104);     // Catch: Throwable -> L10
        r100.a(r103);     // Catch: Throwable -> L10
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    @Override // com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod
    public final void c(JSONObject r110, ECBaseBridgeMethod.a r111) {
        Intrinsics.checkNotNullParameter(r110, "params");
        Intrinsics.checkNotNullParameter(r111, "iReturn");
        String r100 = r110.optString(ReportConstant.COMMON_ACTION_TYPE);
        String r101 = r110.optString("sessionID");
        boolean r102 = true;
        if (r100.length() != 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L8;
    L101:
        r111.onFailed(0, "actionType or sessionId is null");
        return;
    L8:
        if (r101.length() != 0) goto L10;
        boolean r104 = true;
    L11:
        if (r104 == true) goto L101;
        JSONObject r105 = r110.optJSONObject("deliveryRecord");
        LinkedHashMap r106 = new LinkedHashMap();
        if (r105 == null) goto L20;
        Iterator<String> r107 = r105.keys();
        if (r107 == null) goto L20;
    L18:
        if (r107.hasNext() == false) goto L20;
        String r108 = r107.next();
        r106.put(r108, r105.opt(r108));
    L20:
        Map r109 = null;
        switch(r100.hashCode()) {
            case -1246914851: goto L62;
            case -235365105: goto L48;
            case 96417: goto L39;
            case 102230: goto L33;
            case 1919834714: goto L24;
            default: goto L99;
        };
    L99:
        r111.onFailed(0, "actionType is error");
        return;
    L24:
        if (r100.equals("publishTTI") == false) goto L99;
        s83.h r112 = d();
        if (r112 == null) goto L28;
        r112.a();
    L28:
        s83.h r113 = d();
        if (r113 == null) goto L31;
        r109 = r113.c();
    L31:
        e(r111, r109);
        return;
    L33:
        if (r100.equals(MonitorConstants.CONNECT_TYPE_GET) == false) goto L99;
        s83.h r114 = d();
        if (r114 == null) goto L37;
        r109 = r114.c();
    L37:
        e(r111, r109);
        return;
    L39:
        if (r100.equals("add") == false) goto L99;
        s83.h r115 = d();
        if (r115 == null) goto L43;
        r115.d();
    L43:
        s83.h r116 = d();
        if (r116 == null) goto L46;
        r109 = r116.c();
    L46:
        e(r111, r109);
        return;
    L48:
        if (r100.equals("publish") == false) goto L99;
        Object r117 = r110.get("isSuccess");
        if ((r117 instanceof Boolean) == true) goto L52;
        r117 = null;
    L52:
        Boolean r118 = (Boolean) r117;
        s83.h r119 = d();
        if (r119 == null) goto L57;
        if (r118 == null) goto L56;
        r118.booleanValue();
    L56:
        r119.b();
    L57:
        s83.h r120 = d();
        if (r120 == null) goto L60;
        r109 = r120.c();
    L60:
        e(r111, r109);
        return;
    L62:
        if (r100.equals("addStage") == false) goto L99;
        Object r121 = r110.get("deliveryStage");
        if ((r121 instanceof String) == true) goto L66;
        r121 = null;
    L66:
        String r122 = (String) r121;
        if (r122 != null) goto L70;
        r122 = "";
    L70:
        if (r122.length() == 0) goto L73;
        r102 = false;
    L73:
        if (r102 == false) goto L76;
        r111.onFailed(0, "deliveryStage is empty");
        return;
    L76:
        Object r123 = r110.get("timestamp");
        if ((r123 instanceof Long) == true) goto L79;
        r123 = null;
    L79:
        Long r124 = (Long) r123;
        if (r124 == null) goto L82;
        long r125 = r124.longValue();
    L83:
        LinkedHashMap r126 = new LinkedHashMap();
        if (r105 == null) goto L92;
        Iterator<String> r127 = r105.keys();
        if (r127 == null) goto L92;
    L88:
        if (r127.hasNext() == false) goto L92;
        String r128 = r127.next();
        Object r129 = r105.opt(r128);
        if (r129 == null) goto L88;
        r126.put(r128, r129);
    L92:
        r126.put("delivery_session_id", r101);
        int r130 = ECSdk.f48106a;
        s83.g r131 = (s83.g) ECSdk.a(s83.g.class);
        if (r131 == null) goto L95;
        r131.H(r122, r125, r126);
    L95:
        s83.h r132 = d();
        if (r132 == null) goto L98;
        r109 = r132.c();
    L98:
        e(r111, r109);
        return;
    L82:
        r125 = System.currentTimeMillis();
        goto L83
    L10:
        r104 = false;
        goto L11
    L5:
        r103 = false;
        goto L6
    }
}
