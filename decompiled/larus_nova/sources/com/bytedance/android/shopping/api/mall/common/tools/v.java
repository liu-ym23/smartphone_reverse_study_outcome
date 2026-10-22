package com.bytedance.android.shopping.api.mall.common.tools;

import android.net.Uri;
import com.byted.cast.linkcommon.cybergarage.xml.XML;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes13.dex */
public final class v {
    public static final Map<String, String> f(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        Object r101 = null;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L33
        HashMap r103 = new HashMap();     // Catch: Throwable -> L33
        Iterator<T> r104 = UriProtector.getQueryParameterNames(r100).iterator();     // Catch: Throwable -> L33
    L5:
        if (r104.hasNext() == false) goto L31;
        String r105 = (String) r104.next();     // Catch: Throwable -> L33
        if (r105 != null) goto L9;
    L12:
        boolean r106 = true;
    L13:
        if (r106 == true) goto L5;
        List<String> r107 = UriProtector.getQueryParameters(r100, r105);     // Catch: Throwable -> L33
        ListIterator<String> r108 = r107.listIterator(r107.size());     // Catch: Throwable -> L33
    L16:
        if (r108.hasPrevious() == false) goto L27;
        String r109 = r108.previous();     // Catch: Throwable -> L33
        String r110 = r109;     // Catch: Throwable -> L33
        if (r110 != null) goto L20;
    L23:
        boolean r111 = true;
    L25:
        if ((!r111) == false) goto L16;
    L28:
        String r112 = r109;     // Catch: Throwable -> L33
        if (r112 == null) goto L5;
        String r113 = (String) r103.put(r105, r112);     // Catch: Throwable -> L33
        goto L5
    L20:
        if (StringsKt.isBlank(r110) == true) goto L23;
        r111 = false;
        goto L25
    L27:
        r109 = null;
        goto L28
    L9:
        if (StringsKt.isBlank(r105) == true) goto L12;
        r106 = false;
        goto L13
    L31:
        Object r114 = Result.m9449constructorimpl(r103);     // Catch: Throwable -> L33
    L36:
        if (Result.m9455isFailureimpl(r114) == true) goto L39;
        r101 = r114;
    L39:
        HashMap r115 = (HashMap) r101;
        if (r115 == null) goto L43;
        return r115;
    L43:
        return new HashMap();
    L33:
        th = move-exception;
        Result.Companion r116 = Result.Companion;
        r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L36
    }

    public static final String h(String r100) {
        Intrinsics.checkNotNullParameter(r100, "link");
        if (StringsKt.startsWith$default(r100, "http", false, 2, null) == true) goto L6;
        return r100;
    L6:
        return "aweme://webview?url=" + URLEncoder.encode(r100, XML.CHARSET_UTF8);
    }

    public static final String c(String r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        Intrinsics.checkNotNullParameter(r101, "params");
        Uri r102 = UriProtector.parse(r100);
        LinkedHashMap r103 = new LinkedHashMap();
        r103.putAll(f(r102));
        LinkedHashMap r104 = new LinkedHashMap();
        Iterator<Map.Entry<String, String>> r105 = r101.entrySet().iterator();
    L4:
        if (r105.hasNext() == false) goto L19;
        Map.Entry<String, String> r106 = r105.next();
        boolean r107 = true;
        if (r106.getKey().length() <= 0) goto L8;
        boolean r108 = true;
    L9:
        if (r108 == true) goto L11;
    L16:
        r107 = false;
    L17:
        if (r107 == false) goto L4;
        r104.put(r106.getKey(), r106.getValue());
        goto L4
    L11:
        if (r106.getValue().length() <= 0) goto L13;
        boolean r109 = true;
    L14:
        if (r109 == false) goto L16;
    L13:
        r109 = false;
        goto L14
    L8:
        r108 = false;
        goto L9
    L19:
        r103.putAll(r104);
        SetsKt.plus(r101.entrySet(), f(r102).entrySet());
        Uri.Builder r110 = r102.buildUpon().clearQuery();
        Iterator r111 = r103.entrySet().iterator();
    L21:
        if (r111.hasNext() == false) goto L24;
        Map.Entry r112 = (Map.Entry) r111.next();
        r110.appendQueryParameter((String) r112.getKey(), (String) r112.getValue());
        goto L21
    L24:
        return r110.build().toString();
    }

    public static final String d(String r100, Map<String, String> r110) {
        Intrinsics.checkNotNullParameter(r100, "link");
        Intrinsics.checkNotNullParameter(r110, "params");
        if (StringsKt.startsWith$default(r100, "http", false, 2, null) == false) goto L9;
        Intrinsics.checkNotNullParameter(r100, "link");
        Intrinsics.checkNotNullParameter(r110, "params");
        if (StringsKt.startsWith$default(r100, "http", false, 2, null) == true) goto L8;
        return r100;
    L8:
        return c(r100, r110);
    L9:
        String r101 = g(UriProtector.parse(r100), "url");
        if (r101 != null) goto L13;
        r101 = "";
    L13:
        if (StringsKt.isBlank(r101) == true) goto L21;
        Intrinsics.checkNotNullParameter(r101, "link");
        Intrinsics.checkNotNullParameter(r110, "params");
        if (StringsKt.startsWith$default(r101, "http", false, 2, null) == false) goto L19;
        r101 = c(r101, r110);
    L19:
        return c(r100, MapsKt.mapOf(TuplesKt.to("url", r101)));
    L21:
        return r100;
    }

    public static final String g(Uri r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$getQueryParameterSafely");
        Intrinsics.checkNotNullParameter(r101, "key");
        if (r100.isHierarchical() == true) goto L6;
        r100 = null;
    L6:
        if (r100 != null) goto L8;
        return null;
    L8:
        return UriProtector.getQueryParameter(r100, r101);
    }

    public static String a(Map r100, String r110, String r111) {
        Intrinsics.checkNotNullParameter(r110, "schema");
        Intrinsics.checkNotNullParameter(r111, "pageName");
        String r101 = null;
        if (r100 == null) goto L7;
        Object r102 = r100.get("history_path");
        if (r102 == null) goto L7;
        String r103 = r102.toString();
    L8:
        if (r100 == null) goto L12;
        Object r104 = r100.get("enter_from");
        if (r104 == null) goto L12;
        r101 = r104.toString();
    L12:
        String r105 = "";
        if (r101 != null) goto L15;
        r101 = "";
    L15:
        if (r103 != null) goto L17;
        r103 = "";
    L17:
        Intrinsics.checkNotNullParameter(r110, "schema");
        Intrinsics.checkNotNullParameter(r101, "enterFrom");
        Intrinsics.checkNotNullParameter(r111, "pageName");
        Intrinsics.checkNotNullParameter(r103, "historyPath");
        boolean r106 = false;
        if (r103.length() != 0) goto L21;
        boolean r107 = true;
    L22:
        if (r107 == true) goto L26;
        r101 = r103;
    L26:
        if (r101.length() <= 0) goto L28;
        boolean r108 = true;
    L29:
        if (r108 == true) goto L31;
    L36:
        Uri r109 = UriProtector.parse(r110);     // Catch: Exception -> L65
        HashMap r112 = (HashMap) f(r109);     // Catch: Exception -> L65
        r112.put("history_path", r111);     // Catch: Exception -> L65
        CharSequence r113 = (CharSequence) r112.get("url");     // Catch: Exception -> L65
        if (r113 != null) goto L39;
    L42:
        boolean r114 = true;
    L43:
        if (r114 == true) goto L48;
        String r115 = (String) r112.get("url");     // Catch: Exception -> L65
        if (r115 != null) goto L47;
        r115 = "";
    L47:
        r112.put("url", d(r115, MapsKt.mapOf(TuplesKt.to("history_path", r111))));     // Catch: Exception -> L65
    L48:
        CharSequence r116 = (CharSequence) r112.get("surl");     // Catch: Exception -> L65
        if (r116 != null) goto L51;
    L52:
        r106 = true;
    L53:
        if (r106 == true) goto L59;
        String r117 = (String) r112.get("surl");     // Catch: Exception -> L65
        if (r117 == null) goto L58;
        r105 = r117;
    L58:
        r112.put("surl", d(r105, MapsKt.mapOf(TuplesKt.to("history_path", r111))));     // Catch: Exception -> L65
    L59:
        Uri.Builder r118 = r109.buildUpon().clearQuery();     // Catch: Exception -> L65
        Iterator r119 = r112.entrySet().iterator();     // Catch: Exception -> L65
    L61:
        if (r119.hasNext() == false) goto L63;
        Map.Entry r120 = (Map.Entry) r119.next();     // Catch: Exception -> L65
        r118.appendQueryParameter((String) r120.getKey(), (String) r120.getValue());     // Catch: Exception -> L65
        goto L61
    L63:
        return r118.build().toString();
    L51:
        if (StringsKt.isBlank(r116) == false) goto L53;
    L39:
        if (StringsKt.isBlank(r113) == true) goto L42;
        r114 = false;
        goto L43
    L31:
        if (r111.length() <= 0) goto L33;
        boolean r121 = true;
    L34:
        if (r121 == false) goto L36;
        r111 = e(r101, r111, 3);     // Catch: Exception -> L65
        goto L36
    L33:
        r121 = false;
        goto L34
    L28:
        r108 = false;
        goto L29
    L21:
        r107 = false;
    L65:
        e = move-exception;
        b0.l("com.bytedance.android.shopping.mall.homepage.tools addHistoryPath", e);
        return r110;
    L7:
        r103 = null;
        goto L8
    }

    public static final String e(String r100, String r110, int r111) {
        Intrinsics.checkNotNullParameter(r100, "historyPath");
        Intrinsics.checkNotNullParameter(r110, "enterFrom");
        List r101 = CollectionsKt.toMutableList(StringsKt.split$default(r100, new String[]{"__"}, false, 0, 6, null));
        if (r101.size() < r111) goto L5;
        ListProtector.remove(r101, 0);
    L5:
        r101.add(r110);
        return CollectionsKt.joinToString$default(r101, "__", null, null, 0, null, null, 62, null);
    }

    public static final String b(String r110, Map<String, String> r111, boolean r112, boolean r113) {
        Intrinsics.checkNotNullParameter(r110, "link");
        boolean r100 = true;
        if (r110.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L67;
        if (r111 != null) goto L9;
    L12:
        boolean r102 = true;
    L13:
        if (r102 == true) goto L69;
        if (StringsKt.startsWith$default(r110, "http", false, 2, null) == true) goto L18;
        Uri r103 = UriProtector.parse(r110);     // Catch: Exception -> L65
        String r104 = g(r103, "url");     // Catch: Exception -> L65
        if (r104 != null) goto L22;
    L25:
        boolean r114 = true;
    L26:
        if (r114 == true) goto L29;
        Map r115 = MapsKt.toMutableMap(r111);     // Catch: Exception -> L65
        r115.put("url", c(Uri.decode(r104), r111));     // Catch: Exception -> L65
        Unit r116 = Unit.INSTANCE;     // Catch: Exception -> L65
        return c(r110, r115);
    L29:
        if (r112 == true) goto L31;
        String r117 = g(r103, "anchor_url");     // Catch: Exception -> L65
        if (r117 != null) goto L35;
    L38:
        boolean r105 = true;
    L39:
        if (r105 == false) goto L41;
        String r118 = g(r103, "api_url");     // Catch: Exception -> L65
        if (r118 != null) goto L45;
    L48:
        boolean r106 = true;
    L49:
        if (r106 == false) goto L51;
        String r119 = g(r103, "surl");     // Catch: Exception -> L65
        if (StringsKt.startsWith$default(r110, "sslocal://polaris/lynx", false, 2, null) == false) goto L62;
        if (r119 != null) goto L56;
    L59:
        if (r100 == true) goto L62;
        return c(r110, MapsKt.mapOf(TuplesKt.to("surl", c(r119, r111))));
    L56:
        if (r119.length() == 0) goto L59;
        r100 = false;
    L62:
        if (r113 == true) goto L64;
        return r110;
    L64:
        return c(r110, r111);
    L51:
        return c(r110, MapsKt.mapOf(TuplesKt.to("api_url", c(r118, r111))));
    L45:
        if (r118.length() == 0) goto L48;
        r106 = false;
        goto L49
    L41:
        return c(r110, MapsKt.mapOf(TuplesKt.to("anchor_url", c(r117, r111))));
    L35:
        if (r117.length() == 0) goto L38;
        r105 = false;
        goto L39
    L31:
        return c(r110, r111);
    L22:
        if (r104.length() == 0) goto L25;
        r114 = false;
        goto L26
    L18:
        return c(r110, r111);
    L70:
        return r110;
    L69:
        return r110;
    L9:
        if (r111.isEmpty() == true) goto L12;
        r102 = false;
        goto L13
    L67:
        return r110;
    L5:
        r101 = false;
        goto L6
    }
}
