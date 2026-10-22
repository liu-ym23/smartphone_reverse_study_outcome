package com.bytedance.android.ec.core.hybrid.prefetch;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.effectmanager.effect.model.ComposerHelper;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class t {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f44259j = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f44260a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f44261b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, String> f44262c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, String> f44263d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, String> f44264e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f44265f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f44266g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final e f44267h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f44268i;

    public static final class a {
        public static Map a(JSONObject r210, Uri r211, JSONObject r212, Map r213) {
            if (r210 == null) goto L5;
            String r100 = UriProtector.getQueryParameter(r211, "url");     // Catch: Exception -> L126
            if (r100 == null) goto L13;
            Uri r101 = UriProtector.parse(r100);     // Catch: Exception -> L126
            if (r101 != null) goto L12;
            r101 = null;
        L12:
            Uri r102 = r101;
        L14:
            LinkedHashMap r103 = new LinkedHashMap();
            Iterator<String> r104 = r210.keys();
        L16:
            if (r104.hasNext() == false) goto L123;
            String r105 = r104.next();
            JSONObject r106 = r210.optJSONObject(r105);
            if (r106 == null) goto L16;
            String r110 = r106.optString("type");
            if (r110 == null) goto L118;
            boolean r111 = true;
            switch(r110.hashCode()) {
                case -892481938: goto L116;
                case -577482631: goto L87;
                case -319903276: goto L78;
                case -214617395: goto L39;
                case 107944136: goto L27;
                default: goto L118;
            };
        L27:
            if (r110.equals("query") == false) goto L118;
            String r112 = r106.optString("value");
            if (r112 != null) goto L31;
            r112 = r105;
        L31:
            String r113 = UriProtector.getQueryParameter(r211, r112);
            if (r113 == null) goto L34;
            r103.put(r105, r113);
            goto L118
        L34:
            if (r102 == null) goto L118;
            String r114 = UriProtector.getQueryParameter(r102, r112);
            if (r114 == null) goto L118;
            r103.put(r105, r114);
            goto L118
        L39:
            if (r110.equals("query-json") == false) goto L118;
            String r115 = r106.optString("value");
            if (r115 == null) goto L118;
            List r116 = StringsKt.split$default(r115, new String[]{"."}, false, 0, 6, null);
            if ((!r116.isEmpty()) == false) goto L118;
            if (r102 == null) goto L46;
            String r117 = UriProtector.getQueryParameter(r102, (String) CollectionsKt.first(r116));
        L47:
            if (r117 != null) goto L49;
            r117 = UriProtector.getQueryParameter(r211, (String) CollectionsKt.first(r116));
        L49:
            if (r117 == null) goto L118;
            String r118 = (String) CollectionsKt.last(r116);
            int r107 = t.f44259j;
            Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L72
            if (1 < r116.size()) goto L54;
            String r109 = r117.toString();     // Catch: Throwable -> L72
        L74:
            if (r109 == null) goto L76;
            r103.put(CollectionsKt.last(r116), r109);
        L76:
            r105 = r118;
            goto L118
        L54:
            int r119 = r116.size();     // Catch: Throwable -> L72
            Object r120 = r117;
            String r121 = null;
            int r122 = 1;
        L55:
            if (r122 >= r119) goto L71;
            String r123 = (String) ListProtector.get(r116, r122);     // Catch: Throwable -> L72
            if ((r120 instanceof String) == true) goto L127;
        L62:
            int r124 = r119;
        L64:
            if ((r120 instanceof JSONObject) == false) goto L71;
            r120 = ((JSONObject) r120).opt(r123);     // Catch: Throwable -> L72
            if (r120 == null) goto L70;
            if (r122 != (r116.size() - 1)) goto L70;
            r121 = r120.toString();     // Catch: Throwable -> L72
        L70:
            r122 = r122 + 1;
            r119 = r124;
            goto L55
        L127:
            r124 = r119;
            r120 = new JSONObject((String) r120);     // Catch: JSONException -> L124 Throwable -> L72
        L71:
            r109 = r121;
        L72:
            th = move-exception;
            Result.Companion r125 = Result.Companion;
            Result.m9449constructorimpl(ResultKt.createFailure(th));
            r109 = null;
            goto L74
        L46:
            r117 = null;
            goto L47
        L78:
            if (r110.equals("global_props") == false) goto L118;
            String r126 = r106.optString("value");
            if (r126 != null) goto L82;
            r126 = r105;
        L82:
            if (r212 == null) goto L118;
            String r127 = r212.optString(r126);
            if (r127 == null) goto L118;
            r103.put(r105, r127);
            goto L118
        L87:
            if (r110.equals("ec_common_params") == false) goto L118;
            String r128 = r106.optString("value");
            if (r128 != null) goto L91;
            r128 = r105;
        L91:
            if (r213 == null) goto L94;
            String r129 = (String) ((LinkedHashMap) r213).get(r128);
            if (r129 == null) goto L94;
        L106:
            if (r129 != null) goto L108;
        L111:
            if (r111 == true) goto L118;
            if (r213 == null) goto L114;
            String r130 = (String) r213.put(r128, r129);
        L114:
            r103.put(r128, r129);
            goto L118
        L108:
            if (StringsKt.isBlank(r129) == true) goto L111;
            r111 = false;
        L94:
            ConcurrentHashMap<String, NativePrefetch> r131 = NativePrefetchUtil.f44218a;
            if (r128 != null) goto L98;
        L105:
            r129 = null;
            goto L106
        L98:
            if (r128.hashCode() != (-503038523)) goto L105;
            if (r128.equals("webcast_gps_access") == false) goto L105;
            boolean r132 = ECServiceManager.f42805a;
            Integer r133 = ((s83.g) ECServiceManager.c(s83.g.class)).getLocationPermissionParam();
            if (r133 == null) goto L105;
            r129 = String.valueOf(r133.intValue());
            goto L106
        L116:
            if (r110.equals("static") == false) goto L118;
            r103.put(r105, r106.optString("value"));
        L118:
            String r134 = r106.optString(ComposerHelper.COMPOSER_DEFAULT_VALUE);
            if (r103.get(r105) != null) goto L16;
            if (TextUtils.isEmpty(r134) == true) goto L16;
            r103.put(r105, r134);
            goto L16
        L123:
            return r103;
        L13:
            r102 = null;
            goto L14
        L5:
            return MapsKt.emptyMap();
        }
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof t) == false) goto L24;
        t r101 = (t) r100;
        if (Intrinsics.areEqual(this.f44260a, r101.f44260a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f44261b, r101.f44261b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f44262c, r101.f44262c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f44263d, r101.f44263d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f44264e, r101.f44264e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f44265f, r101.f44265f) == true) goto L18;
        return false;
    L18:
        if (this.f44266g == r101.f44266g) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f44267h, r101.f44267h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f44268i, r101.f44268i) == true) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14, types: [int] */
    /* JADX WARN: Type inference failed for: r2v16, types: [int] */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v28 */
    public final int hashCode() {
        String r100 = this.f44260a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f44261b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Map<String, String> r107 = this.f44262c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Map<String, String> r110 = this.f44263d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Map<String, String> r113 = this.f44264e;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f44265f;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        boolean r119 = this.f44266g;
        ?? r120 = r119;
        if (r119 == false) goto L29;
        r120 = 1;
    L29:
        int r121 = (r118 + r120) * 31;
        e r122 = this.f44267h;
        if (r122 == null) goto L32;
        int r123 = r122.hashCode();
    L33:
        int r124 = (r121 + r123) * 31;
        String r125 = this.f44268i;
        if (r125 == null) goto L37;
        r101 = r125.hashCode();
    L37:
        return r124 + r101;
    L32:
        r123 = 0;
        goto L33
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "NativeRequestConfig(apiUrl=" + this.f44260a + ", method=" + this.f44261b + ", headerMap=" + this.f44262c + ", queryMap=" + this.f44263d + ", bodyMap=" + this.f44264e + ", interruptFlag=" + this.f44265f + ", enableNetPerfTiming=" + this.f44266g + ", imagePreloadConfig=" + this.f44267h + ", apiKey=" + this.f44268i + ")";
    }

    public t(String r100, String r101, Map<String, String> r102, Map<String, String> r103, Map<String, String> r104, String r105, boolean r106, e r107, String r110) {
        Intrinsics.checkNotNullParameter(r100, "apiUrl");
        Intrinsics.checkNotNullParameter(r101, com.alipay.sdk.m.p.e.f25671s);
        this.f44260a = r100;
        this.f44261b = r101;
        this.f44262c = r102;
        this.f44263d = r103;
        this.f44264e = r104;
        this.f44265f = r105;
        this.f44266g = r106;
        this.f44267h = r107;
        this.f44268i = r110;
    }
}
