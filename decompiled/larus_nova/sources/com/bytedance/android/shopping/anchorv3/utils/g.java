package com.bytedance.android.shopping.anchorv3.utils;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.model.ECAdLogExtra;
import com.bytedance.android.ec.model.response.anchorv3.AdInfoStruct;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.anchorv3.guessulike.model.ItemCardLiveStruct;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f165309a = 0;

    public g() {
    }

    static {
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static void d(String r100, AdInfoStruct r101) {
        Intrinsics.checkNotNullParameter(r100, "trackLabel");
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L32
        Unit r103 = null;
        ArrayList r104 = null;
        r104 = null;
        r104 = null;
        r103 = null;
        r103 = null;
        if (r101 == null) goto L6;
        String r105 = r101.getRawData();     // Catch: Throwable -> L32
    L7:
        String r106 = a2.d(r105);     // Catch: Throwable -> L32
        if (r106 == null) goto L30;
        JSONObject r107 = com.bytedance.android.shopping.extensions.k.w(r106);     // Catch: Throwable -> L32
        if (r107 == null) goto L30;
        JSONObject r108 = r107.optJSONObject("raw_ad_data");     // Catch: Throwable -> L32
        if (r108 == null) goto L30;
        int r109 = r100.hashCode();     // Catch: Throwable -> L32
        int r110 = 0;
        if (r109 == 3529469) goto L24;
        if (r109 == 94750088) goto L19;
    L29:
        com.bytedance.android.ec.sdk.helper.g.f48122a.d(r100, r104, Long.valueOf(r108.optLong("creative_id")), r108.optString("log_extra"));     // Catch: Throwable -> L32
        r103 = Unit.INSTANCE;     // Catch: Throwable -> L32
        goto L30
    L19:
        if (r100.equals("click") == false) goto L29;
        JSONArray r111 = r108.optJSONArray("click_track_url_list");     // Catch: Throwable -> L32
        ArrayList r112 = new ArrayList();     // Catch: Throwable -> L32
        int r113 = r111.length();     // Catch: Throwable -> L32
    L21:
        if (r110 >= r113) goto L28;
        r112.add(JSONArrayProtectorUtils.getString(r111, r110));     // Catch: Throwable -> L32
        r110 = r110 + 1;     // Catch: Throwable -> L32
    L28:
        r104 = r112;
        goto L29
    L24:
        if (r100.equals("show") == false) goto L29;
        JSONArray r114 = r108.optJSONArray("track_url_list");     // Catch: Throwable -> L32
        r112 = new ArrayList();     // Catch: Throwable -> L32
        int r115 = r114.length();     // Catch: Throwable -> L32
    L26:
        if (r110 >= r115) goto L28;
        r112.add(JSONArrayProtectorUtils.getString(r114, r110));     // Catch: Throwable -> L32
        r110 = r110 + 1;     // Catch: Throwable -> L32
    L30:
        Object r116 = Result.m9449constructorimpl(r103);     // Catch: Throwable -> L32
    L34:
        Throwable r117 = Result.m9452exceptionOrNullimpl(r116);
        if (r117 == null) goto L42;
        ECExceptionMonitor.e(r117);
        return;
    L42:
        return;
    L6:
        r105 = null;
    L32:
        th = move-exception;
        Result.Companion r118 = Result.Companion;
        r116 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L34
    }

    public static void c(String r110, j63.c r111, Long r112, String r113) {
        Intrinsics.checkNotNullParameter(r110, "label");
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L34
        HashMap r101 = new HashMap();     // Catch: Throwable -> L34
        if (r111 == null) goto L15;
        ItemCardLiveStruct r102 = r111.b();     // Catch: Throwable -> L34
        if (r102 == null) goto L15;
        String r103 = r102.getUid();     // Catch: Throwable -> L34
        if (r103 != null) goto L11;
        r103 = "";
    L11:
        r101.put("anchor_id", r103);     // Catch: Throwable -> L34
        String r104 = r102.getRoomId();     // Catch: Throwable -> L34
        if (r104 != null) goto L14;
        r104 = "";
    L14:
        r101.put("room_id", r104);     // Catch: Throwable -> L34
    L15:
        Unit r105 = null;
        if (r111 == null) goto L20;
        AdInfoStruct r114 = r111.a();     // Catch: Throwable -> L34
        if (r114 == null) goto L20;
        String r115 = r114.getRawData();     // Catch: Throwable -> L34
    L21:
        String r116 = a2.d(r115);     // Catch: Throwable -> L34
        if (r116 == null) goto L32;
        JSONObject r117 = com.bytedance.android.shopping.extensions.k.w(r116);     // Catch: Throwable -> L34
        if (r117 == null) goto L32;
        JSONObject r118 = r117.optJSONObject("raw_ad_data");     // Catch: Throwable -> L34
        if (r118 == null) goto L32;
        int r106 = l.f165312a;     // Catch: Throwable -> L34
        String r107 = r118.optString("creative_id");     // Catch: Throwable -> L34
        long r108 = r118.optLong("group_id");     // Catch: Throwable -> L34
        JSONObject r119 = l.b(r118.optString("log_extra"), l.a("", r101), r113, r112);     // Catch: Throwable -> L34
        Intrinsics.checkNotNullParameter(r110, "label");     // Catch: Throwable -> L34
        Intrinsics.checkNotNullParameter(r107, "value");     // Catch: Throwable -> L34
        Intrinsics.checkNotNullParameter(r119, "extra");     // Catch: Throwable -> L34
        Context r109 = ECAppInfoService.f48114e.getApplicationContext();     // Catch: Throwable -> L34
        if (r109 == null) goto L31;
        com.bytedance.android.ec.sdk.helper.g.f48122a.b(r109, "feed_ad", r110, r107, r108, r119);     // Catch: Throwable -> L34
    L31:
        r105 = Unit.INSTANCE;     // Catch: Throwable -> L34
    L32:
        Object r120 = Result.m9449constructorimpl(r105);     // Catch: Throwable -> L34
    L36:
        Throwable r121 = Result.m9452exceptionOrNullimpl(r120);
        if (r121 == null) goto L42;
        ECExceptionMonitor.e(r121);
        return;
    L42:
        return;
    L20:
        r115 = null;
    L34:
        th = move-exception;
        Result.Companion r122 = Result.Companion;
        r120 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L36
    }

    public static void a(ECAdLogExtra r100, String r101, int r102, long r103, long r104, String r105) {
        Intrinsics.checkNotNullParameter(r100, "adLogExtra");
        Intrinsics.checkNotNullParameter(r101, "promotionId");
        Intrinsics.checkNotNullParameter(r105, "label");
        HashMap r106 = new HashMap();
        r106.put(com.bytedance.android.ec.core.event.a.KEY_COMMODITY_ID, r101);
        r106.put(com.bytedance.android.ec.core.event.a.KEY_COMMODITY_TYPE, String.valueOf(r102));
        r106.put("commodity_price", Long.valueOf(r103));
        r106.put("click_buy_time", Long.valueOf(System.currentTimeMillis()));
        r106.put("commodity_duration", Long.valueOf(r104));
        String r107 = "large_stabilization";
        if ((!TextUtils.isEmpty("large_stabilization")) == true) goto L6;
        r107 = null;
    L6:
        if (r107 == null) goto L8;
        r106.put("page_source", r107);
    L8:
        int r108 = l.f165312a;
        JSONObject r109 = l.b(r100.getLogExtra(), l.a(r100.getAdExtraData(), r106), null, null);
        String r110 = r100.getCreativeId().toString();
        Long r111 = StringsKt.toLongOrNull(r100.getGroupId());
        if (r111 == null) goto L11;
        long r112 = r111.longValue();
    L12:
        l.d(r105, r110, r112, r109);
        return;
    L11:
        r112 = 0;
        goto L12
    }

    public static void b(String r100, ECAdLogExtra r101, String r102, int r103, Long r104, Long r105, String r106) {
        HashMap r107 = new HashMap();
        r107.put(com.bytedance.android.ec.core.event.a.KEY_COMMODITY_ID, r102);
        r107.put(com.bytedance.android.ec.core.event.a.KEY_COMMODITY_TYPE, String.valueOf(r103));
        if (r104 == null) goto L5;
        r107.put("commodity_price", Long.valueOf(r104.longValue()));
    L5:
        if (r105 == null) goto L8;
        r107.put("commodity_duration", Long.valueOf(r105.longValue()));
    L8:
        if (r106 != null) goto L10;
    L15:
        int r108 = l.f165312a;
        String r109 = r101.getCreativeId().toString();
        Long r110 = StringsKt.toLongOrNull(r101.getGroupId());
        if (r110 == null) goto L18;
        long r111 = r110.longValue();
    L19:
        l.d(r100, r109, r111, l.b(r101.getLogExtra(), l.a(r101.getAdExtraData(), r107), null, null));
        return;
    L18:
        r111 = 0;
        goto L19
    L10:
        if ((!TextUtils.isEmpty(r106)) == true) goto L13;
        r106 = null;
    L13:
        if (r106 == null) goto L15;
        r107.put("page_source", r106);
        goto L15
    }
}
