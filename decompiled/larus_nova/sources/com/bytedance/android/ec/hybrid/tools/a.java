package com.bytedance.android.ec.hybrid.tools;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.android.ec.hybrid.ECMallConfigs;
import com.bytedance.android.ec.hybrid.monitor.HybridAppInfoService;
import com.bytedance.geckox.GeckoGlobalConfig;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes44.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f47630a = null;

    public a() {
    }

    static {
        f47630a = new a();
    }

    public static String b(String r110) {
        Object r100 = null;
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L50
        Context r102 = HybridAppInfoService.f47545p.getApplicationContext();     // Catch: Throwable -> L50
        if (r102 == null) goto L62;
        AssetManager r103 = r102.getAssets();     // Catch: Throwable -> L50
        if (r103 == null) goto L63;
        com.bytedance.geckox.b r104 = com.bytedance.geckox.b.a.f245076a;     // Catch: Throwable -> L50
        GeckoGlobalConfig r105 = com.bytedance.geckox.b.a();     // Catch: Throwable -> L50
        if (r105 == null) goto L11;
        GeckoGlobalConfig.ENVType r106 = r105.getEnv();     // Catch: Throwable -> L50
    L13:
        if (r106 != GeckoGlobalConfig.ENVType.PROD) goto L15;
        String r107 = "CDN_VERSION_PROD_";
    L16:
        String r108 = r107;
        String[] r111 = r103.list("offline/" + r110);     // Catch: Throwable -> L50
        boolean r109 = false;
        if (r111 != null) goto L19;
    L33:
        ArrayList r112 = null;
    L34:
        if (r112 != null) goto L36;
    L39:
        boolean r113 = true;
    L40:
        if (r113 == false) goto L42;
        return null;
    L42:
        if (r112.size() != 1) goto L65;
        String r114 = StringsKt.replace$default((String) ListProtector.get(r112, 0), r108, "", false, 4, null);     // Catch: Throwable -> L50
        if (r114.length() <= 0) goto L47;
        r109 = true;
    L47:
        if (r109 == true) goto L49;
        return null;
    L49:
        return r114;
    L65:
        return null;
    L36:
        if (r112.isEmpty() == true) goto L39;
        r113 = false;
        goto L40
    L19:
        if (r111.length != 0) goto L21;
        boolean r115 = true;
    L23:
        if ((!r115) == true) goto L26;
        r111 = null;
    L26:
        if (r111 == null) goto L33;
        r112 = new ArrayList();     // Catch: Throwable -> L50
        int r116 = r111.length;     // Catch: Throwable -> L50
        int r117 = 0;
    L28:
        if (r117 >= r116) goto L34;
        String r118 = r111[r117];     // Catch: Throwable -> L50
        if (StringsKt.startsWith(r118, r108, true) == false) goto L32;
        r112.add(r118);     // Catch: Throwable -> L50
    L32:
        r117 = r117 + 1;     // Catch: Throwable -> L50
        goto L28
    L21:
        r115 = false;
        goto L23
    L15:
        r107 = "CDN_VERSION_TEST_";
        goto L16
    L11:
        r106 = null;
        goto L13
    L63:
        return null;
    L62:
        return null;
    L50:
        th = move-exception;
        Result.Companion r119 = Result.Companion;
        Object r120 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9455isFailureimpl(r120) == true) goto L56;
        r100 = r120;
    L56:
        return (String) r100;
    }

    public static String a(String r210, String r211, String r212) {
        Intrinsics.checkNotNullParameter(r210, "accessKey");
        Intrinsics.checkNotNullParameter(r211, "channel");
        Intrinsics.checkNotNullParameter(r212, "schema");
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L117
        ECMallConfigs r101 = ECMallConfigs.INSTANCE;     // Catch: Throwable -> L117
        if (r101.getLegouBuiltinResourceEnable() == true) goto L6;
        return r212;
    L6:
        boolean r102 = true;
        if (r210.length() != 0) goto L9;
        boolean r103 = true;
    L10:
        if (r103 == false) goto L12;
    L116:
        return r212;
    L12:
        if (r211.length() != 0) goto L14;
        boolean r104 = true;
    L15:
        if (r104 == true) goto L116;
        if (r212.length() != 0) goto L19;
        boolean r105 = true;
    L20:
        if (r105 == true) goto L116;
        Uri r106 = UriProtector.parse(r212);     // Catch: Throwable -> L117
        if (Intrinsics.areEqual(UriProtector.getQueryParameter(r106, "disable_builtin_resource"), "1") == false) goto L25;
        return r212;
    L25:
        String r110 = "surl";
        String r111 = UriProtector.getQueryParameter(r106, "surl");     // Catch: Throwable -> L117
        if (r111 != null) goto L28;
    L35:
        r110 = "url";
        r111 = UriProtector.getQueryParameter(r106, "url");     // Catch: Throwable -> L117
        if (r111 != null) goto L38;
    L43:
        r111 = null;
    L44:
        if (r111 != null) goto L46;
    L49:
        boolean r112 = true;
    L50:
        if (r112 == false) goto L52;
        return r212;
    L52:
        String r113 = UriProtector.parse(r111).getPath();     // Catch: Throwable -> L117
        if (r113 == null) goto L116;
        if (r113.length() <= 0) goto L57;
        boolean r114 = true;
    L58:
        if (r114 == false) goto L60;
        String r115 = r113;
    L61:
        if (r115 == null) goto L116;
        if (StringsKt.contains$default(r115, HTTP.URL_DEFAULT + r211 + '/', false, 2, null) == true) goto L66;
        return r212;
    L66:
        String[] r116 = new String[1];     // Catch: Throwable -> L117
        r116[0] = HTTP.URL_DEFAULT + r211 + '/';     // Catch: Throwable -> L80
        List r107 = StringsKt.split$default(r115, r116, false, 0, 6, null);     // Catch: Throwable -> L80
        if (r107.size() == 2) goto L70;
        return r212;
    L70:
        Object r108 = ListProtector.get(r107, 1);     // Catch: Throwable -> L80
        String r109 = (String) r108;     // Catch: Throwable -> L80
        if (r109.length() <= 0) goto L73;
        boolean r117 = true;
    L74:
        if (r117 == true) goto L76;
        String r118 = null;
    L83:
        boolean r119 = false;
    L84:
        if (r119 == true) goto L87;
        r108 = r118;
    L87:
        String r120 = (String) r108;     // Catch: Throwable -> L104
        if (r120 != null) goto L90;
        return r212;
    L90:
        String r121 = UriProtector.getQueryParameter(r106, "restrict_cdn_version");     // Catch: Throwable -> L104
        if (r121 != null) goto L93;
    L98:
        r121 = r118;
    L100:
        if (r101.getLegouRestrictCDNVersionEnable() == true) goto L102;
        if (r121 != null) goto L102;
    L114:
        Object r122 = Result.m9449constructorimpl(r106.buildUpon().appendQueryParameter("accessKey", r210).appendQueryParameter("channel", r211).appendQueryParameter("bundle", r120).build().toString());     // Catch: Throwable -> L104
    L121:
        if (Result.m9455isFailureimpl(r122) == false) goto L123;
        Object r123 = r118;
    L124:
        String r124 = (String) r123;
        if (r124 != null) goto L128;
        return r212;
    L128:
        return r124;
    L123:
        r123 = r122;
    L104:
        th = th;
    L119:
        Result.Companion r125 = Result.Companion;
        r122 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L102:
        if (r121 != null) goto L106;
        r121 = b(r211);     // Catch: Throwable -> L104
    L106:
        if (r121 != null) goto L108;
    L111:
        if (r102 == true) goto L114;
        r106 = w36.a.b(r106, r110).buildUpon().appendQueryParameter(r110, UriProtector.parse(r111).buildUpon().appendQueryParameter("versionId", r121).toString()).build();     // Catch: Throwable -> L104
        goto L114
    L108:
        if (r121.length() == 0) goto L111;
        r102 = false;
        goto L111
    L93:
        if (r121.length() <= 0) goto L95;
        boolean r126 = true;
    L96:
        if (r126 == false) goto L98;
    L95:
        r126 = false;
        goto L96
    L76:
        r118 = null;
        if (StringsKt.endsWith$default(r109, ".js", false, 2, null) == false) goto L83;
        r119 = true;
        goto L84
    L73:
        r117 = false;
    L80:
        th = th;
        r118 = null;
        goto L119
    L60:
        r115 = null;
        goto L61
    L57:
        r114 = false;
        goto L58
    L46:
        if (r111.length() == 0) goto L49;
        r112 = false;
        goto L50
    L38:
        if (r111.length() <= 0) goto L40;
        boolean r127 = true;
    L41:
        if (r127 == false) goto L43;
    L40:
        r127 = false;
        goto L41
    L28:
        if (r111.length() <= 0) goto L30;
        boolean r128 = true;
    L31:
        if (r128 == true) goto L34;
        r111 = null;
    L34:
        if (r111 != null) goto L44;
    L30:
        r128 = false;
        goto L31
    L19:
        r105 = false;
        goto L20
    L14:
        r104 = false;
        goto L15
    L9:
        r103 = false;
    L117:
        th = th;
        r118 = null;
        goto L119
    }
}
