package com.bytedance.android.ec.core.hybrid.bridges;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import com.bytedance.android.ec.model.response.ECFloatWindowInfo;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/ec/core/hybrid/bridges/ECVerifyReport;", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECVerifyReport extends ECBaseBridgeMethod {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f44141e;

    public static final class a {
    }

    static {
    }

    public ECVerifyReport() {
        this.f44141e = "ecVerifyReport";
    }

    @Override // com.bytedance.android.ec.model.hybrid.IECBridgeMethod
    public final String getName() {
        return this.f44141e;
    }

    @Override // com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod
    public final void c(final JSONObject r410, final ECBaseBridgeMethod.a r411) {
        String r110 = ECFloatWindowInfo.INFO_TYPE_ATTRIBUTE;
        String r111 = "owner";
        String r112 = "level";
        String r113 = "msg";
        String r114 = "name";
        String r100 = PerfLog.PARAM_KEY_CONTEXT_ID;
        String r101 = "params";
        Intrinsics.checkNotNullParameter(r410, "params");
        Intrinsics.checkNotNullParameter(r411, "iReturn");
        JSONObject r102 = r410.optJSONObject("errorContent");     // Catch: Exception -> L25
        if (r102 == null) goto L23;
        JSONArray r103 = r102.optJSONArray("errorList");     // Catch: Exception -> L25
        if (r103 != null) goto L34;
    L18:
        ECBaseBridgeMethod.a r104 = r411;
        String r105 = null;
        r104.onSuccess(null);     // Catch: Exception -> L21
        return;
    L21:
        e = e;
    L27:
        ECExceptionMonitor.e(e);
    L28:
        r104.onFailed(0, r105);
        return;
    L34:
    L14:
        e = e;
        r104 = r411;
    L16:
        r105 = null;
        goto L27
    L8:
        if (r103.length() <= 0) goto L18;
        UUID r106 = UUID.randomUUID();     // Catch: Exception -> L14
        int r107 = ECSdk.f48106a;     // Catch: Exception -> L14
        pi.b r108 = (pi.b) ECSdk.a(pi.b.class);     // Catch: Exception -> L14
        if (r108 == null) goto L18;
        String r109 = r102.optString("params");     // Catch: Exception -> L14
        String r115 = r102.optString(PerfLog.PARAM_KEY_CONTEXT_ID);     // Catch: Exception -> L14
        String r116 = r102.optString("errorEvent");     // Catch: Exception -> L14
        ih.a.f489761d.getClass();     // Catch: Exception -> L14
        ih.a.f489759b.getClass();     // Catch: Exception -> L14
        JSONObject r117 = ih.a.b();     // Catch: Exception -> L14
        final StringBuilder r210 = new StringBuilder();     // Catch: Exception -> L14
        final StringBuilder r211 = new StringBuilder();     // Catch: Exception -> L14
        final StringBuilder r212 = new StringBuilder();     // Catch: Exception -> L14
        Ref.IntRef r118 = new Ref.IntRef();     // Catch: Exception -> L14
        JSONObject r119 = r102;
        r118.element = 1;     // Catch: Exception -> L14
        int r120 = r103.length();     // Catch: Exception -> L14
        Ref.IntRef r121 = r118;
        int r122 = 0;
    L12:
        if (r122 >= r120) goto L17;
        int r213 = r120;
        JSONObject r123 = JSONArrayProtectorUtils.getJSONObject(r103, r122);     // Catch: Exception -> L14
        final JSONArray r214 = r103;
        String r124 = r123.optString(r114);     // Catch: Exception -> L14
        int r215 = r122;
        String r125 = r123.optString(r113);     // Catch: Exception -> L14
        final pi.b r216 = r108;
        final int r126 = r123.optInt(r112);     // Catch: Exception -> L14
        final JSONObject r217 = r117;
        final String r127 = r123.optString(r111);     // Catch: Exception -> L14
        final String r218 = r115;
        final String r128 = r123.optString("errorType");     // Catch: Exception -> L14
        final String r129 = r123.optString(r110);     // Catch: Exception -> L14
        String r219 = r100;
        JSONObject r130 = new JSONObject();     // Catch: Exception -> L14
        final String r310 = r109;
        r130.put("error_event", r116);     // Catch: Exception -> L14
        r130.put(r111, r127);     // Catch: Exception -> L14
        r130.put(r113, r125);     // Catch: Exception -> L14
        r130.put(r114, r124);     // Catch: Exception -> L14
        r130.put("error_id", r106);     // Catch: Exception -> L14
        r130.put(r112, r126);     // Catch: Exception -> L14
        r130.put("error_type", r128);     // Catch: Exception -> L14
        r130.put(r110, r129);     // Catch: Exception -> L14
        Unit r131 = Unit.INSTANCE;     // Catch: Exception -> L14
        JSONObject r132 = new JSONObject();     // Catch: Exception -> L14
        r132.put(r101, r310);     // Catch: Exception -> L14
        final String r220 = r116;
        r132.put(r219, r218);     // Catch: Exception -> L14
        r132.put("btm_chain", r217);     // Catch: Exception -> L14
        final UUID r133 = r106;
        r216.monitorEvent("ecom_vmsdk_check_param", r130, null, r132);     // Catch: Exception -> L14
        final JSONObject r221 = r119;
        String r311 = r113;
        final Ref.IntRef r134 = r121;
        com.bytedance.android.ec.sdk.helper.l.a(new ECVerifyReport$handle$$inlined$let$lambda$1(r128, r127, r129, r126, r216, r220, r310, r218, r217, r134, r211, r210, r212, r221, r214, r133, r410, r411));     // Catch: Exception -> L14
        r122 = r215 + 1;     // Catch: Exception -> L14
        r103 = r214;
        r119 = r221;
        r120 = r213;
        r121 = r121;
        r115 = r218;
        r116 = r220;
        r108 = r216;
        r109 = r310;
        r100 = r219;
        r106 = r133;
        r101 = r101;
        r114 = r114;
        r113 = r311;
        r112 = r112;
        r111 = r111;
        r110 = r110;
        r117 = r217;
        goto L12
    L17:
        final JSONObject r412 = r117;
        final UUID r312 = r106;
        final JSONArray r135 = r103;
        final String r222 = r115;
        final String r223 = r116;
        final JSONObject r224 = r119;
        com.bytedance.android.ec.sdk.helper.l.a(new ECVerifyReport$handle$$inlined$let$lambda$2(r223, r210, r412, r222, r211, r212, r224, r135, r312, r410, r411));     // Catch: Exception -> L14
        goto L18
    L23:
        r104 = r411;
        r105 = null;
    L25:
        e = e;
        r104 = r411;
        goto L16
    }
}
