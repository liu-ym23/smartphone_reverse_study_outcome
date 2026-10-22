package com.bytedance.android.ec.core.monitor;

import android.util.Log;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.lark.pb.space.drive.v1.CoverDownloadInfo;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttvideoengine.selector.strategy.GearStrategy;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f45144a = 0;

    public static final class a<V> implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ HashMap f45145a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f45146b;

        public a(HashMap r100, String r101) {
            this.f45145a = r100;
            this.f45146b = r101;
        }

        @Override // java.util.concurrent.Callable
        public final Object call() {
            this.f45145a.put("data_type", com.bytedance.android.ec.core.event.a.VALUE_DATA_TYPE);     // Catch: Throwable -> L9
            this.f45145a.put(com.bytedance.android.ec.core.event.a.KEY_EVENT_ORIGIN_FEATURE, com.bytedance.android.ec.core.event.a.VALUE_TEMAI);     // Catch: Throwable -> L9
            com.bytedance.android.ec.sdk.helper.g r100 = com.bytedance.android.ec.sdk.helper.g.f48122a;     // Catch: Throwable -> L9
            String r101 = this.f45146b;     // Catch: Throwable -> L9
            Map r102 = this.f45145a;     // Catch: Throwable -> L9
            if ((r102 instanceof Map) == true) goto L5;
            r102 = null;
        L5:
            if (r102 != null) goto L7;
            r102 = MapsKt.emptyMap();     // Catch: Throwable -> L9
        L7:
            r100.logV3(r101, new JSONObject(r102));     // Catch: Throwable -> L9
            return Unit.INSTANCE;
        L9:
            th = move-exception;
            return Integer.valueOf(Log.w("ECBusinessMonitor", "post event failed: " + this.f45146b, th));
        }
    }

    public d() {
    }

    static {
    }

    public static void f(String r100) {
        ECAppInfoService r101 = ECAppInfoService.f48114e;
        if (r101.isDebug() == false) goto L5;
    L6:
        com.bytedance.android.ec.sdk.helper.j.c("EC_BUSINESS_MONITOR_TOAST", r100);
        return;
    L5:
        if (r101.isLocalTest() == true) goto L6;
    }

    public static void b(String r100, HashMap r101) {
        Intrinsics.checkNotNullParameter(r100, "errorKeyName");
        Intrinsics.checkNotNullParameter("presence", "checkRule");
        Intrinsics.checkNotNullParameter("ec_similar_product_page", "scene");
        if (com.bytedance.android.ec.core.opt.ab.t.a() == 1) goto L5;
        return;
    L5:
        f("ec_similar_product_page 的schema中的" + r100 + " 字段缺失，请排查一下问题，若误报或有任何问题可联系lizheng.222");
        HashMap r102 = new HashMap();
        r102.put("error_key_name", r100);
        r102.put("validation_rule", "presence");
        r102.put(GearStrategy.GEAR_STRATEGY_KEY_ERROR_DESC, "缺失");
        if (r101 == null) goto L8;
        r102.putAll(r101);
    L8:
        e("iesec_schema_error_event", r102);
    }

    public static void e(String r100, HashMap r101) {
        ECAppInfoService r102 = ECAppInfoService.f48114e;
        if (r102.isDebug() == false) goto L5;
        return;
    L5:
        if (r102.isLocalTest() == true) goto L9;
        Single.fromCallable(new a(r101, r100)).subscribeOn(Schedulers.io()).subscribe();
        return;
    }

    public static void a(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "path");
        Intrinsics.checkNotNullParameter(r101, "logId");
        Intrinsics.checkNotNullParameter(r102, "errorKeyName");
        Intrinsics.checkNotNullParameter("presence", "checkRule");
        if (com.bytedance.android.ec.core.opt.ab.t.a() != 1) goto L7;
        f(r100 + " 接口中的" + r102 + " 字段缺失，请排查一下问题，若误报或有任何问题可联系相应的研发同学");
        HashMap r103 = new HashMap();
        r103.put("api_path", r100);
        r103.put("log_id", r101);
        r103.put("error_key_name", r102);
        r103.put("validation_rule", "presence");
        r103.put(GearStrategy.GEAR_STRATEGY_KEY_ERROR_DESC, "");
        e("iesec_api_response_error_event", r103);
        return;
    }

    public static void d(String r100, String r101, String r102, String r103, JSONObject r104) {
        Intrinsics.checkNotNullParameter(r100, "errorKeyName");
        Intrinsics.checkNotNullParameter(r101, "checkRule");
        Intrinsics.checkNotNullParameter(r103, "scene");
        Intrinsics.checkNotNullParameter(r104, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (com.bytedance.android.ec.core.opt.ab.t.a() == 1) goto L6;
        return;
    L6:
        if (r102 != null) goto L25;
        int r105 = r101.hashCode();
        if (r105 == (-1276666629)) goto L21;
        if (r105 == (-907987551)) goto L18;
        if (r105 == 96757556) goto L15;
    L23:
        String r106 = "不符合校验规则";
    L24:
        String r107 = r103 + " 的schema中" + r100 + " 字段" + r106;
    L26:
        f(r107 + "，请保留现场，排查一下问题，有任何问题可联系zhaojunjie.passaway");
        HashMap r108 = new HashMap();
        r108.put("error_key_name", r100);
        r108.put("validation_rule", r101);
        r108.put(GearStrategy.GEAR_STRATEGY_KEY_ERROR_DESC, r107);
        r108.put("scene", r103);
        r108.put(PerfLog.PARAM_KEY_CONTEXT_ID, r104.toString());
        e("iesec_schema_error_event", r108);
        return;
    L15:
        if (r101.equals(CoverDownloadInfo.DEFAULT_POLICY) == false) goto L23;
        r106 = "传值不一致";
        goto L24
    L18:
        if (r101.equals("schema") == false) goto L23;
        r106 = "协议错误";
        goto L24
    L21:
        if (r101.equals("presence") == false) goto L23;
        r106 = "缺失";
        goto L24
    L25:
        r107 = r103 + " 的schema中" + r102;
        goto L26
    }

    public static void c(String r100, String r101, String r102, String r103, String r104, String r105, int r110) {
        if ((r110 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r110 & 32) == 0) goto L8;
        r105 = null;
    L8:
        Intrinsics.checkNotNullParameter(r101, "destPage");
        Intrinsics.checkNotNullParameter(r102, "schema");
        Intrinsics.checkNotNullParameter(r103, "errorKeyName");
        Intrinsics.checkNotNullParameter(r104, "checkRule");
        if (com.bytedance.android.ec.core.opt.ab.t.a() != 1) goto L40;
        int r106 = r104.hashCode();
        if (r106 == (-1276666629)) goto L25;
        if (r106 == (-907987551)) goto L22;
        if (r106 == 96757556) goto L19;
    L27:
        String r107 = "不符合校验规则";
    L29:
        if (r105 == null) goto L31;
        f(r101 + " 的schema中" + r105 + "，请排查一下问题，若误报或有任何问题可联系相应的研发同学");
    L32:
        HashMap r108 = new HashMap();
        if (r100 != null) goto L35;
        r100 = "";
    L35:
        r108.put("source_page", r100);
        r108.put("dest_page", r101);
        r108.put("schema", r102);
        r108.put("error_key_name", r103);
        r108.put("validation_rule", r104);
        if (r105 != null) goto L38;
        r105 = "";
    L38:
        r108.put(GearStrategy.GEAR_STRATEGY_KEY_ERROR_DESC, r105);
        e("iesec_schema_error_event", r108);
        return;
    L31:
        f(r101 + " 的schema中的" + r103 + " 字段" + r107 + "，请排查一下问题，若误报或有任何问题可联系相应的研发同学");
        goto L32
    L19:
        if (r104.equals(CoverDownloadInfo.DEFAULT_POLICY) == false) goto L27;
        r107 = "传值不一致";
        goto L29
    L22:
        if (r104.equals("schema") == false) goto L27;
        r107 = "协议错误";
        goto L29
    L25:
        if (r104.equals("presence") == false) goto L27;
        r107 = "缺失";
        goto L29
    }
}
