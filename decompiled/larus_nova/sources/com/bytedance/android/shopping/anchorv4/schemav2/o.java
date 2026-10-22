package com.bytedance.android.shopping.anchorv4.schemav2;

import android.content.Context;
import com.bytedance.android.ec.common.api.debugtool.IVisitUnit;
import com.bytedance.android.ec.common.api.debugtool.VisitActions;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.monitor.ECProcessMonitor;
import com.bytedance.android.ec.core.monitor.listener.ActionRateListener;
import com.bytedance.android.ec.core.utils.x0;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.shopping.anchorv4.log.AdLogUtils;
import com.bytedance.android.shopping.anchorv4.params.V4NativeParams;
import com.bytedance.mira.log.MiraMonitor;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import java.util.Set;
import jd3.d0;
import jd3.e0;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class o {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f167440b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f167441a;

    public static final class a {
    }

    static {
    }

    public static com.bytedance.android.ec.core.monitor.listener.d b() {
        Set<String> r100 = ECProcessMonitor.f45118a;
        return ECProcessMonitor.o();
    }

    public o(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f167441a = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(Pair r100) {
        Intrinsics.checkNotNullParameter(r100, "param");
        b().b(new Pair[]{r100});
    }

    public static void c(PdpSchemaProcessor r100) {
        String r101 = r100.i().e();
        Pair[] r102 = new Pair[4];
        String r103 = r100.g().f167372d;
        String r104 = "";
        if (r103 != null) goto L5;
        r103 = "";
    L5:
        r102[0] = TuplesKt.to("enter_from", r103);
        String r105 = r100.m().f167435h;
        if (r105 != null) goto L8;
        r105 = "";
    L8:
        r102[1] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_SHOP_ID, r105);
        String r106 = r100.m().f167431d;
        if (r106 != null) goto L11;
        r106 = "";
    L11:
        r102[2] = TuplesKt.to("product_id", r106);
        String r107 = r100.f().f167370f;
        if (r107 == null) goto L15;
        r104 = r107;
    L15:
        r102[3] = TuplesKt.to("room_id", r104);
        Map r108 = MapsKt.mutableMapOf(r102);
        if (r101 == null) goto L19;
        s83.g r109 = AdLogUtils.f167035a;
        AdLogUtils.q(r101, r100.k().f167423e.optString("log_extra"), r108);
        return;
    }

    public static void e(String r100, final PdpSchemaProcessor r101, V4NativeParams r102) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        Intrinsics.checkNotNullParameter(r101, "schema");
        Intrinsics.checkNotNullParameter(r102, "nativeParams");
        String r103 = r101.i().e();
        if (r103 == null) goto L32;
        s83.g r104 = AdLogUtils.f167035a;
        AdLogUtils.o(r103, r101.k().f167423e.optString("log_extra"));
    L32:
        JSONObject r105 = x0.a(r101.j());     // Catch: Exception -> L14
        if (r102.getFullMode() == false) goto L9;
        String r106 = "full";
    L12:
        r105.put("pdp_type", r106);     // Catch: Exception -> L14
    L16:
        Map<String, String> r107 = com.bytedance.android.ec.core.monitor.k.f45162a;
        int r108 = ECSdk.f48106a;
        pi.b r109 = (pi.b) ECSdk.a(pi.b.class);
        if (r109 == null) goto L30;
        r109.monitorEvent("ec_perf_page_start_product_detail", r105, null, null);
    L30:
        JSONObject r110 = new JSONObject();     // Catch: Exception -> L21
        r110.put(MiraMonitor.SCHEMA_V2, 1);     // Catch: Exception -> L21
        r110.put("enter_from", r102.getSourcePage());     // Catch: Exception -> L21
        r110.put(com.bytedance.android.ec.core.event.a.KEY_STORE_TYPE, r101.k().f167422d.optString(com.bytedance.android.ec.core.event.a.KEY_STORE_TYPE));     // Catch: Exception -> L21
        r110.put("creative_id", r101.i().e());     // Catch: Exception -> L21
    L23:
        com.bytedance.android.ec.core.monitor.listener.d r111 = b();
        if (r110 != null) goto L26;
        r110 = new JSONObject();
    L26:
        ActionRateListener.c(r111, r110, null, false, 6);
        int r112 = ECSdk.f48106a;
        IVisitUnit r113 = (IVisitUnit) ECSdk.a(IVisitUnit.class);
        if (r113 == null) goto L34;
        r113.hookToDirectCall(VisitActions.PDP_IN_NEW_URL.getKey(), new PdpStarterTrackListener$onInitParams$1(r101));
        return;
    L34:
        return;
    L21:
        e = move-exception;
        ECExceptionMonitor.e(e);
        r110 = null;
        goto L23
    L9:
        if (r102.getFromLive() == false) goto L11;
        r106 = "live";
        goto L12
    L11:
        r106 = "video";
    L14:
        e = move-exception;
        ECExceptionMonitor.e(e);
        r105 = new JSONObject();
        goto L16
    }

    public final void d(PdpSchemaProcessor r100, int r101, String r102, Boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        b().j(r101, r102);
        c(r100);
        int r104 = com.bytedance.android.shopping.anchorv3.track.b.f165294a;
        Context r105 = this.f167441a;
        Intrinsics.checkNotNullParameter(r100, "pdpSchemaGenerator");
        d0 r106 = new d0();
        r106.f498274a = null;
        r106.f498275b = r102;
        r106.f498276c = r100;
        com.bytedance.android.shopping.anchorv3.track.c.b(r106, r105);
        if (Intrinsics.areEqual(r103, Boolean.TRUE) == false) goto L6;
        Context r107 = this.f167441a;
        Integer r108 = Integer.valueOf(r101);
        Intrinsics.checkNotNullParameter(r100, "schemaProcessor");
        e0 r109 = new e0();
        r109.f498294a = r108;
        r109.f498295b = r102;
        r109.f498297d = r100;
        r109.f498296c = null;
        com.bytedance.android.shopping.anchorv3.track.c.b(r109, r107);
        return;
    }

    public final void f(PdpSchemaProcessor r100, int r101, String r102, String r103, Boolean r104) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        int r105 = com.bytedance.android.shopping.anchorv3.track.b.f165294a;
        Context r106 = this.f167441a;
        Integer r107 = Integer.valueOf(r101);
        Intrinsics.checkNotNullParameter(r100, "pdpSchemaGenerator");
        d0 r108 = new d0();
        r108.f498274a = r107;
        r108.f498275b = r102;
        r108.f498276c = r100;
        com.bytedance.android.shopping.anchorv3.track.c.b(r108, r106);
        if (Intrinsics.areEqual(r104, Boolean.TRUE) == false) goto L5;
        Context r109 = this.f167441a;
        Integer r110 = Integer.valueOf(r101);
        Intrinsics.checkNotNullParameter(r100, "schemaProcessor");
        e0 r111 = new e0();
        r111.f498294a = r110;
        r111.f498295b = r102;
        r111.f498297d = r100;
        r111.f498296c = r103;
        com.bytedance.android.shopping.anchorv3.track.c.b(r111, r109);
    L5:
        b().j(r101, r102);
        c(r100);
    }
}
