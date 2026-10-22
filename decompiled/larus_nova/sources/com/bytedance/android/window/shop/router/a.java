package com.bytedance.android.window.shop.router;

import android.net.Uri;
import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.base.settings.d;
import com.bytedance.android.ec.core.opt.ab.n;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.services.apm.api.EnsureManager;
import com.huawei.hms.framework.common.ContainerUtils;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f189649a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, String> f189650b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Uri f189651c;

    public a(Uri r110) {
        Intrinsics.checkNotNullParameter(r110, "uri");
        this.f189651c = r110;
        int r111 = yq3.a.f568739a;
        int r112 = n.f45241a;
        Object r100 = 0;
        int r101 = com.bytedance.android.ec.base.settings.a.f42813a;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L160
        Object r103 = null;
        Object r104 = d.f42818c.get("window_opt_uri_parse");     // Catch: Throwable -> L54
        if (r104 != null) goto L9;
    L51:
        Object r105 = null;
    L52:
        Object r106 = Result.m9449constructorimpl(r105);     // Catch: Throwable -> L54
    L56:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);     // Catch: Throwable -> L160
        if (r107 == null) goto L60;
        EnsureManager.ensureNotReachHere(r107);     // Catch: Throwable -> L160
    L60:
        if (Result.m9455isFailureimpl(r106) == false) goto L63;
        r106 = null;
    L63:
        if ((r106 instanceof Integer) == true) goto L65;
        r106 = null;
    L65:
        Object r108 = (Integer) r106;     // Catch: Throwable -> L160
        if (r108 != null) goto L72;
        Object r109 = d.f42816a.get("window_opt_uri_parse");     // Catch: Throwable -> L160
        if ((r109 instanceof Integer) == true) goto L71;
        r109 = null;
    L71:
        r108 = (Integer) r109;     // Catch: Throwable -> L160
    L72:
        if (r108 != null) goto L169;
        int r113 = com.bytedance.android.ec.base.settings.c.f42815a;     // Catch: Throwable -> L160
        Object r114 = d.f42818c.get("window_opt_uri_parse");     // Catch: Throwable -> L124
        if (r114 != null) goto L79;
    L121:
        Object r115 = null;
    L122:
        Object r116 = Result.m9449constructorimpl(r115);     // Catch: Throwable -> L124
    L126:
        Throwable r117 = Result.m9452exceptionOrNullimpl(r116);     // Catch: Throwable -> L150
        if (r117 == null) goto L130;
        EnsureManager.ensureNotReachHere(r117);     // Catch: Throwable -> L150
    L130:
        if (Result.m9455isFailureimpl(r116) == false) goto L133;
        r116 = null;
    L133:
        if ((r116 instanceof Integer) == true) goto L135;
        r116 = null;
    L135:
        r108 = (Integer) r116;     // Catch: Throwable -> L150
        if (r108 != null) goto L158;
        IHybridHostService r118 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L150
        if (r118 == null) goto L141;
        Object r119 = r118.getHostABValue("window_opt_uri_parse", r100);     // Catch: Throwable -> L150
    L142:
        if (r119 != null) goto L144;
    L149:
        r108 = r100;
        goto L158
    L144:
        if ((r119 instanceof Integer) == false) goto L147;
        r103 = r119;
    L147:
        Object r120 = (Integer) r103;     // Catch: Throwable -> L150
        if (r120 == null) goto L149;
    L157:
        r108 = r120;
        goto L158
    L141:
        r119 = null;
    L158:
        d.d("window_opt_uri_parse", r108);     // Catch: Throwable -> L160
        goto L169
    L79:
        if ((r114 instanceof Integer) == true) goto L81;
        Object r121 = null;
    L82:
        r115 = (Integer) r121;     // Catch: Throwable -> L124
        if (r115 != null) goto L122;
        if ((r114 instanceof Number) == false) goto L109;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L94;
        Float r122 = Float.valueOf(((Number) r114).floatValue());     // Catch: Throwable -> L124
        if ((r122 instanceof Integer) == true) goto L92;
        r122 = null;
    L92:
        r115 = (Integer) r122;     // Catch: Throwable -> L124
        goto L122
    L94:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L100;
        Double r123 = Double.valueOf(((Number) r114).doubleValue());     // Catch: Throwable -> L124
        if ((r123 instanceof Integer) == true) goto L98;
        r123 = null;
    L98:
        r115 = (Integer) r123;     // Catch: Throwable -> L124
        goto L122
    L100:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L103;
        r115 = Integer.valueOf(((Number) r114).intValue());     // Catch: Throwable -> L124
        goto L122
    L103:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L109;
        Long r124 = Long.valueOf(((Number) r114).longValue());     // Catch: Throwable -> L124
        if ((r124 instanceof Integer) == true) goto L107;
        r124 = null;
    L107:
        r115 = (Integer) r124;     // Catch: Throwable -> L124
    L109:
        if ((r114 instanceof JSONObject) == false) goto L111;
    L205:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L117
        Object r125 = SDKSettingsCacheManager.a().fromJson(r114.toString(), Integer.class);     // Catch: Throwable -> L117
        if ((r125 instanceof Integer) == true) goto L115;
        r125 = null;
    L115:
        Object r126 = Result.m9449constructorimpl((Integer) r125);     // Catch: Throwable -> L117
    L119:
        r115 = r126;
        if (Result.m9455isFailureimpl(r115) == false) goto L122;
    L117:
        th = move-exception;
        Result.Companion r127 = Result.Companion;     // Catch: Throwable -> L124
        r126 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L124
        goto L119
    L111:
        if ((r114 instanceof JSONArray) == false) goto L121;
    L81:
        r121 = r114;
    L150:
        th = move-exception;
        Result.Companion r128 = Result.Companion;     // Catch: Throwable -> L160
        r120 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L160
        Throwable r129 = Result.m9452exceptionOrNullimpl(r120);     // Catch: Throwable -> L160
        if (r129 == null) goto L155;
        EnsureManager.ensureNotReachHere(r129);     // Catch: Throwable -> L160
    L155:
        if (Result.m9455isFailureimpl(r120) == false) goto L157;
        r120 = r100;
    L124:
        th = move-exception;
        Result.Companion r130 = Result.Companion;     // Catch: Throwable -> L150
        r116 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L150
    L169:
        boolean r131 = true;
        if (((Number) r108).intValue() == 1) goto L173;
        r131 = false;
    L173:
        this.f189649a = r131;
        if (r131 == false) goto L192;
        Uri r132 = this.f189651c;
        Intrinsics.checkNotNullParameter(r132, "$this$quickGetQueryMap");
        String r133 = r132.getEncodedQuery();     // Catch: Exception -> L190
        if (r133 != null) goto L179;
        Map<String, String> r134 = new HashMap();     // Catch: Exception -> L190
    L193:
        this.f189650b = r134;
        return;
    L179:
        r134 = new LinkedHashMap();     // Catch: Exception -> L190
        Object[] r135 = StringsKt.split$default(r133, new String[]{"&"}, false, 0, 6, null).toArray(new String[0]);     // Catch: Exception -> L190
        if (r135 == null) goto L189;
        String[] r136 = (String[]) r135;     // Catch: Exception -> L190
        int r137 = r136.length;     // Catch: Exception -> L190
        int r138 = 0;
    L182:
        if (r138 >= r137) goto L193;
        String r139 = r136[r138];     // Catch: Exception -> L190
        int r140 = StringsKt.indexOf$default(r139, ContainerUtils.KEY_VALUE_DELIMITER, 0, false, 6, null);     // Catch: Exception -> L190
        if (r139 == null) goto L187;
        r134.put(Uri.decode(r139.substring(0, r140)), Uri.decode(r139.substring(r140 + 1)));     // Catch: Exception -> L190
        r138 = r138 + 1;     // Catch: Exception -> L190
        goto L182
    L187:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");     // Catch: Exception -> L190
    L189:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");     // Catch: Exception -> L190
    L190:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e.toString());
        r134 = new HashMap();
        goto L193
    L192:
        r134 = new LinkedHashMap();
        goto L193
    L9:
        if ((r104 instanceof Integer) == true) goto L11;
        Object r141 = null;
    L12:
        r105 = (Integer) r141;     // Catch: Throwable -> L54
        if (r105 != null) goto L52;
        if ((r104 instanceof Number) == false) goto L39;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L24;
        Float r142 = Float.valueOf(((Number) r104).floatValue());     // Catch: Throwable -> L54
        if ((r142 instanceof Integer) == true) goto L22;
        r142 = null;
    L22:
        r105 = (Integer) r142;     // Catch: Throwable -> L54
        goto L52
    L24:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L30;
        Double r143 = Double.valueOf(((Number) r104).doubleValue());     // Catch: Throwable -> L54
        if ((r143 instanceof Integer) == true) goto L28;
        r143 = null;
    L28:
        r105 = (Integer) r143;     // Catch: Throwable -> L54
        goto L52
    L30:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L33;
        r105 = Integer.valueOf(((Number) r104).intValue());     // Catch: Throwable -> L54
        goto L52
    L33:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L39;
        Long r144 = Long.valueOf(((Number) r104).longValue());     // Catch: Throwable -> L54
        if ((r144 instanceof Integer) == true) goto L37;
        r144 = null;
    L37:
        r105 = (Integer) r144;     // Catch: Throwable -> L54
    L39:
        if ((r104 instanceof JSONObject) == false) goto L41;
    L203:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L47
        Object r145 = SDKSettingsCacheManager.a().fromJson(r104.toString(), Integer.class);     // Catch: Throwable -> L47
        if ((r145 instanceof Integer) == true) goto L45;
        r145 = null;
    L45:
        Object r146 = Result.m9449constructorimpl((Integer) r145);     // Catch: Throwable -> L47
    L49:
        r105 = r146;
        if (Result.m9455isFailureimpl(r105) == false) goto L52;
    L47:
        th = move-exception;
        Result.Companion r147 = Result.Companion;     // Catch: Throwable -> L54
        r146 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L54
        goto L49
    L41:
        if ((r104 instanceof JSONArray) == false) goto L51;
    L11:
        r141 = r104;
    L54:
        th = move-exception;
        Result.Companion r148 = Result.Companion;     // Catch: Throwable -> L160
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L160
    L160:
        th = move-exception;
        Result.Companion r149 = Result.Companion;
        Object r150 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r151 = Result.m9452exceptionOrNullimpl(r150);
        if (r151 == null) goto L165;
        EnsureManager.ensureNotReachHere(r151);
    L165:
        if (Result.m9455isFailureimpl(r150) == true) goto L168;
        r100 = r150;
    L168:
        r108 = r100;
        goto L169
    }

    public final String a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        if (this.f189649a == false) goto L9;
        if ((!this.f189650b.isEmpty()) == false) goto L9;
        return this.f189650b.get(r100);
    L9:
        return UriProtector.getQueryParameter(this.f189651c, r100);
    }
}
