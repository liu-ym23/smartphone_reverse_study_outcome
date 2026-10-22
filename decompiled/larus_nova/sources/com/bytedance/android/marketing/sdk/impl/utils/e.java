package com.bytedance.android.marketing.sdk.impl.utils;

import com.ss.android.common.lib.AppLogNewUtils;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f162816a = 0;

    static {
    }

    public static JSONObject a(Long r100, Long r101, Long r102) {
        JSONObject r103 = new JSONObject();
        if (r100 == null) goto L5;
        long r104 = r100.longValue();
    L7:
        if (r104 <= 0) goto L9;
        r103.put("omth_native_start_time", r100);
    L9:
        if (r101 == null) goto L11;
        long r105 = r101.longValue();
    L13:
        if (r105 <= 0) goto L15;
        r103.put("omth_native_handle_time", r101);
    L15:
        if (r102 == null) goto L17;
        long r106 = r102.longValue();
    L19:
        if (r106 <= 0) goto L21;
        r103.put("omth_native_end_time", r102);
    L21:
        return r103;
    L17:
        r106 = 0;
        goto L19
    L11:
        r105 = 0;
        goto L13
    L5:
        r104 = 0;
        goto L7
    }

    public static void b(JSONObject r100, String r101, String r102) {
        if (r101 != null) goto L4;
    L9:
        r101 = null;
    L10:
        r100.putOpt("service_page_name", r101);
        r100.put("load_entry_type", r102);
        return;
    L4:
        if (r101.length() <= 0) goto L6;
        boolean r103 = true;
    L7:
        if (r103 == false) goto L9;
    L6:
        r103 = false;
        goto L7
    }

    public static void f(long r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r103, "loadEntryType");
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L5
        h(r100, r101, r102, r103);     // Catch: Throwable -> L5
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L14:
        g(r100, r101, r102, r103);     // Catch: Throwable -> L9
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return;
    L5:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L14
    }

    public static void g(long r100, String r101, String r102, String r103) {
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L4
        JSONObject r105 = new JSONObject();     // Catch: Throwable -> L4
        r105.put("stage", "omth_native_start");     // Catch: Throwable -> L4
        r105.putOpt("resource_slot", r101);     // Catch: Throwable -> L4
        b(r105, r102, r103);     // Catch: Throwable -> L4
        JSONObject r106 = new JSONObject();     // Catch: Throwable -> L4
        r106.put("omth_native_start_time", r100);     // Catch: Throwable -> L4
        c.a("omth_render_action", r105, r106, 48);     // Catch: Throwable -> L4
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    public static void h(long r100, String r101, String r102, String r103) {
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L4
        JSONObject r105 = new JSONObject();     // Catch: Throwable -> L4
        r105.put("stage", "omth_native_start");     // Catch: Throwable -> L4
        r105.put("omth_native_start_time", r100);     // Catch: Throwable -> L4
        r105.putOpt("resource_slot", r101);     // Catch: Throwable -> L4
        b(r105, r102, r103);     // Catch: Throwable -> L4
        AppLogNewUtils.onEventV3("omth_render_action", r105);     // Catch: Throwable -> L4
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    public static void d(long r210, Long r211, String r212, String r213, String r214, String r215, String r216) {
        Intrinsics.checkNotNullParameter(r216, "loadEntryType");
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L9
        JSONObject r101 = new JSONObject();     // Catch: Throwable -> L9
        r101.put("stage", "omth_native_handle");     // Catch: Throwable -> L9
        r101.put("omth_native_handle_time", r210);     // Catch: Throwable -> L9
        r101.putOpt("resource_slot", r212);     // Catch: Throwable -> L9
        r101.putOpt("plan_id", r213);     // Catch: Throwable -> L9
        r101.putOpt("log_id", r214);     // Catch: Throwable -> L9
        b(r101, r215, r216);     // Catch: Throwable -> L9
        if (r211 != null) goto L6;
    L11:
        String r102 = "omth_render_action";
        AppLogNewUtils.onEventV3(r102, r101);     // Catch: Throwable -> L14
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L14
    L26:
        JSONObject r103 = new JSONObject();     // Catch: Throwable -> L23
        r103.put("stage", "omth_native_handle");     // Catch: Throwable -> L23
        r103.putOpt("resource_slot", r212);     // Catch: Throwable -> L23
        r103.putOpt("plan_id", r213);     // Catch: Throwable -> L23
        r103.putOpt("log_id", r214);     // Catch: Throwable -> L23
        b(r103, r215, r216);     // Catch: Throwable -> L23
        JSONObject r104 = new JSONObject();     // Catch: Throwable -> L23
        r104.put("omth_native_handle_time", r210);     // Catch: Throwable -> L23
        if (r211 != null) goto L19;
    L21:
        c.a(r102, r103, r104, 48);     // Catch: Throwable -> L23
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L23
        return;
    L19:
        if (r211.longValue() <= 0) goto L21;
        r104.put("omth_native_start_time", r211.longValue());     // Catch: Throwable -> L23
        r104.put("omth_native_handle_duration", r210 - r211.longValue());     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return;
    L14:
        th = th;
    L15:
        Result.Companion r106 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L26
    L6:
        if (r211.longValue() <= 0) goto L11;
        r101.put("omth_native_start_time", r211.longValue());     // Catch: Throwable -> L9
        r101.put("omth_native_handle_duration", r210 - r211.longValue());     // Catch: Throwable -> L9
    L9:
        th = th;
        r102 = "omth_render_action";
        goto L15
    }

    public static void e(String r210, String r211, String r212, String r310, String r311, String r312, String r313) {
        Intrinsics.checkNotNullParameter(r313, "loadEntryType");
        String[] r100 = new String[4];
        if (r311 != null) goto L5;
    L10:
        String r110 = null;
    L11:
        r100[0] = r110;
        if (r210 != null) goto L14;
    L22:
        String r111 = null;
    L23:
        r100[1] = r111;
        if (r211 != null) goto L26;
    L34:
        String r112 = null;
    L35:
        r100[2] = r112;
        if (r212 != null) goto L38;
    L46:
        String r113 = null;
    L47:
        r100[3] = r113;
        List r101 = CollectionsKt.listOfNotNull(r100);
        if ((!r101.isEmpty()) == true) goto L51;
        r101 = null;
    L51:
        if (r101 == null) goto L53;
        String r114 = CollectionsKt.joinToString$default(r101, ", ", null, null, 0, null, null, 62, null);
    L65:
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L56
        JSONObject r103 = new JSONObject();     // Catch: Throwable -> L56
        r103.putOpt("resource_slot", r210);     // Catch: Throwable -> L56
        r103.putOpt("plan_id", r211);     // Catch: Throwable -> L56
        r103.putOpt("log_id", r212);     // Catch: Throwable -> L56
        r103.putOpt("error_type", r310);     // Catch: Throwable -> L56
        r103.putOpt("error_msg", r114);     // Catch: Throwable -> L56
        b(r103, r312, r313);     // Catch: Throwable -> L56
        AppLogNewUtils.onEventV3("omth_render_error", r103);     // Catch: Throwable -> L56
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L56
    L63:
        JSONObject r104 = new JSONObject();     // Catch: Throwable -> L60
        r104.putOpt("resource_slot", r210);     // Catch: Throwable -> L60
        r104.putOpt("plan_id", r211);     // Catch: Throwable -> L60
        r104.putOpt("log_id", r212);     // Catch: Throwable -> L60
        r104.putOpt("error_type", r310);     // Catch: Throwable -> L60
        r104.putOpt("error_msg", r114);     // Catch: Throwable -> L60
        b(r104, r312, r313);     // Catch: Throwable -> L60
        c.a("omth_render_error", r104, null, 56);     // Catch: Throwable -> L60
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L60
        return;
    L60:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return;
    L56:
        th = move-exception;
        Result.Companion r115 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L63
    L53:
        r114 = null;
        goto L65
    L38:
        if (r212.length() <= 0) goto L40;
        boolean r116 = true;
    L41:
        if (r116 == false) goto L43;
        String r117 = r212;
    L44:
        if (r117 == null) goto L46;
        r113 = "log_id=".concat(r117);
        goto L47
    L43:
        r117 = null;
        goto L44
    L40:
        r116 = false;
        goto L41
    L26:
        if (r211.length() <= 0) goto L28;
        boolean r118 = true;
    L29:
        if (r118 == false) goto L31;
        String r119 = r211;
    L32:
        if (r119 == null) goto L34;
        r112 = "plan_id=".concat(r119);
        goto L35
    L31:
        r119 = null;
        goto L32
    L28:
        r118 = false;
        goto L29
    L14:
        if (r210.length() <= 0) goto L16;
        boolean r120 = true;
    L17:
        if (r120 == false) goto L19;
        String r121 = r210;
    L20:
        if (r121 == null) goto L22;
        r111 = "rit=".concat(r121);
        goto L23
    L19:
        r121 = null;
        goto L20
    L16:
        r120 = false;
        goto L17
    L5:
        if (r311.length() <= 0) goto L7;
        boolean r122 = true;
    L8:
        if (r122 == false) goto L10;
        r110 = r311;
        goto L11
    L7:
        r122 = false;
        goto L8
    }

    public static void c(long r210, Long r211, Long r212, String r213, String r214, String r215, String r310, String r311) {
        Intrinsics.checkNotNullParameter(r311, "loadEntryType");
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L30
        JSONObject r101 = new JSONObject();     // Catch: Throwable -> L30
        r101.put("stage", "omth_native_end");     // Catch: Throwable -> L30
        r101.put("omth_native_end_time", r210);     // Catch: Throwable -> L30
        r101.putOpt("resource_slot", r213);     // Catch: Throwable -> L30
        r101.putOpt("plan_id", r214);     // Catch: Throwable -> L30
        r101.putOpt("log_id", r215);     // Catch: Throwable -> L30
        b(r101, r310, r311);     // Catch: Throwable -> L30
        if (r211 != null) goto L50;
    L24:
        String r216 = "omth_native_handle_time";
        String r102 = "omth_native_handle_duration";
    L25:
        String r103 = "omth_render_action";
        AppLogNewUtils.onEventV3(r103, r101);     // Catch: Throwable -> L28
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L28
    L52:
        JSONObject r104 = new JSONObject();     // Catch: Throwable -> L47
        r104.put("stage", "omth_native_end");     // Catch: Throwable -> L47
        r104.putOpt("resource_slot", r213);     // Catch: Throwable -> L47
        r104.putOpt("plan_id", r214);     // Catch: Throwable -> L47
        r104.putOpt("log_id", r215);     // Catch: Throwable -> L47
        b(r104, r310, r311);     // Catch: Throwable -> L47
        JSONObject r105 = new JSONObject();     // Catch: Throwable -> L47
        r105.put("omth_native_end_time", r210);     // Catch: Throwable -> L47
        if (r211 != null) goto L36;
    L45:
        c.a(r103, r104, r105, 48);     // Catch: Throwable -> L47
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L47
        return;
    L36:
        if (r211.longValue() <= 0) goto L45;
        r105.put("omth_native_start_time", r211.longValue());     // Catch: Throwable -> L47
        if (r210 <= 0) goto L40;
        r105.put("omth_native_end_time", r210);     // Catch: Throwable -> L47
    L40:
        if (r212 != null) goto L42;
    L44:
        r105.put(r102, r210 - r211.longValue());     // Catch: Throwable -> L47
        goto L45
    L42:
        if (r212.longValue() <= 0) goto L44;
        String r106 = r216;
        r105.put(r106, r212.longValue());     // Catch: Throwable -> L47
    L47:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return;
    L28:
        th = th;
    L32:
        Result.Companion r108 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L52
    L50:
    L22:
        th = th;
        r216 = "omth_native_handle_time";
        r102 = "omth_native_handle_duration";
    L21:
        r103 = "omth_render_action";
        goto L32
    L6:
        if (r211.longValue() <= 0) goto L24;
        r101.put("omth_native_start_time", r211.longValue());     // Catch: Throwable -> L22
        if (r210 <= 0) goto L11;
        r101.put("omth_native_end_time", r210);     // Catch: Throwable -> L30
    L11:
        if (r212 != null) goto L13;
    L16:
        r216 = "omth_native_handle_time";
        r102 = "omth_native_handle_duration";
        r101.put(r102, r210 - r211.longValue());     // Catch: Throwable -> L20
    L20:
        th = th;
        goto L21
    L13:
        if (r212.longValue() <= 0) goto L16;
        r101.put("omth_native_handle_time", r212.longValue());     // Catch: Throwable -> L22
    L30:
        th = th;
        r216 = "omth_native_handle_time";
        r103 = "omth_render_action";
        r102 = "omth_native_handle_duration";
        goto L32
    }
}
