package com.android.ttcjpaysdk.ktextension;

import android.net.Uri;
import android.util.Log;
import com.bytedance.caijing.sdk.infra.base.api.alog.ALogService;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ve4.a;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u001a=\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00012*\u0010\u0002\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u00040\u0003\"\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0002\u0010\u0005\u001a.\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\u001a\u0010\b\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0018\u00010\n0\t\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u0001\u001a \u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0018\u00010\n\u001a\n\u0010\u000e\u001a\u00020\u0001*\u00020\u0001\u001a\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u0001*\u00020\u00012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00010\u0011\u001a\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u0001*\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u0001\u001a\f\u0010\u0013\u001a\u0004\u0018\u00010\u0001*\u00020\u0001\u001a\n\u0010\u0014\u001a\u00020\u0007*\u00020\u0001\u001a\f\u0010\u0015\u001a\u0004\u0018\u00010\u0001*\u00020\u0001\u001a\f\u0010\u0016\u001a\u0004\u0018\u00010\u0017*\u00020\u0001¨\u0006\u0018"}, d2 = {"appendQueryParameter", "", "pairs", "", "Lkotlin/Pair;", "(Ljava/lang/String;[Lkotlin/Pair;)Ljava/lang/String;", "cover", "", "getAppendParams", "Lkotlin/Function0;", "", "key", "value", "map", "clearQuery", "filterQuery", "queryNames", "", "getQueryParameter", "host", "isNetUrl", "path", "toUri", "Landroid/net/Uri;", "cj-host-service-api_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class CJSchemaExtensionKt {
    public static final String clearQuery(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        return UriProtector.parse(r100).buildUpon().clearQuery().build().toString();
    L5:
        th = move-exception;
        Result.Companion r102 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return r100;
    }

    public static final String host(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L7
        Uri r102 = UriProtector.parse(r100);     // Catch: Throwable -> L7
        if (r102 == null) goto L12;
        return r102.getHost();
    L12:
        return null;
    L7:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return null;
    }

    public static final boolean isNetUrl(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L9
        List r102 = CollectionsKt.listOf(new String[]{"http", "https"});     // Catch: Throwable -> L9
        Uri r103 = UriProtector.parse(r100);     // Catch: Throwable -> L9
        if (r103 == null) goto L6;
        String r104 = r103.getScheme();     // Catch: Throwable -> L9
    L7:
        return CollectionsKt.contains(r102, r104);
    L6:
        r104 = null;
    L9:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return false;
    }

    public static final String path(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L7
        Uri r102 = UriProtector.parse(r100);     // Catch: Throwable -> L7
        if (r102 == null) goto L12;
        return r102.getPath();
    L12:
        return null;
    L7:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return null;
    }

    public static final Uri toUri(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        return UriProtector.parse(r100);
    L5:
        th = move-exception;
        Result.Companion r102 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return null;
    }

    public static final String appendQueryParameter(String r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L33
        Uri r103 = UriProtector.parse(r100);     // Catch: Throwable -> L33
        String r104 = null;
        if (r103.isHierarchical() == true) goto L7;
        r103 = null;
    L7:
        if (r103 == null) goto L29;
        Uri.Builder r105 = r103.buildUpon();     // Catch: Throwable -> L33
        if (r105 == null) goto L29;
        if (r101 == null) goto L26;
        LinkedHashMap r106 = new LinkedHashMap();     // Catch: Throwable -> L33
        Iterator<Map.Entry<String, String>> r107 = r101.entrySet().iterator();     // Catch: Throwable -> L33
    L13:
        if (r107.hasNext() == false) goto L22;
        Map.Entry<String, String> r108 = r107.next();     // Catch: Throwable -> L33
        boolean r109 = true;
        if ((!StringsKt.isBlank(r108.getKey())) == true) goto L17;
    L19:
        r109 = false;
    L20:
        if (r109 == false) goto L13;
        r106.put(r108.getKey(), r108.getValue());     // Catch: Throwable -> L33
        goto L13
    L17:
        if ((!StringsKt.isBlank(r108.getValue())) == false) goto L19;
    L22:
        Iterator r110 = r106.entrySet().iterator();     // Catch: Throwable -> L33
    L24:
        if (r110.hasNext() == false) goto L26;
        Map.Entry r111 = (Map.Entry) r110.next();     // Catch: Throwable -> L33
        r105.appendQueryParameter((String) r111.getKey(), (String) r111.getValue());     // Catch: Throwable -> L33
    L26:
        Uri r112 = r105.build();     // Catch: Throwable -> L33
        if (r112 == null) goto L29;
        r104 = r112.toString();     // Catch: Throwable -> L33
    L29:
        if (r104 != null) goto L32;
        return r100;
    L32:
        return r104;
    L33:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        Throwable r114 = Result.m9452exceptionOrNullimpl(Result.m9449constructorimpl(ResultKt.createFailure(th)));
        if (r114 == null) goto L39;
        a.f554342a.getClass();
        ALogService r115 = (ALogService) a.a(ALogService.class);
        if (r115 == null) goto L39;
        r115.e("String.appendQueryParameter", Log.getStackTraceString(r114));
    L39:
        return r100;
    }

    public static final String filterQuery(String r110, List<String> r111) {
        Intrinsics.checkNotNullParameter(r110, "<this>");
        Intrinsics.checkNotNullParameter(r111, "queryNames");
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L27
        Uri r112 = UriProtector.parse(r110);     // Catch: Throwable -> L27
        String r101 = r112.getQuery();     // Catch: Throwable -> L27
        if (r101 == null) goto L24;
        List r102 = StringsKt.split$default(r101, new String[]{"&"}, false, 0, 6, null);     // Catch: Throwable -> L27
        if (r102 == null) goto L24;
        ArrayList r103 = new ArrayList();     // Catch: Throwable -> L27
        Iterator r104 = r102.iterator();     // Catch: Throwable -> L27
    L9:
        if (r104.hasNext() == false) goto L23;
        Object r105 = r104.next();     // Catch: Throwable -> L27
        String r106 = (String) r105;     // Catch: Throwable -> L27
        List<String> r107 = r111;     // Catch: Throwable -> L27
        boolean r108 = false;
        if ((r107 instanceof Collection) == true) goto L13;
    L15:
        Iterator<T> r109 = r107.iterator();     // Catch: Throwable -> L27
    L17:
        if (r109.hasNext() == false) goto L21;
        if (StringsKt.startsWith$default(r106, ((String) r109.next()) + com.alipay.sdk.m.n.a.f25612h, false, 2, null) == false) goto L17;
        r108 = true;
    L21:
        if (r108 == true) goto L9;
        r103.add(r105);     // Catch: Throwable -> L27
        goto L9
    L13:
        if (r107.isEmpty() == false) goto L15;
    L23:
        String r113 = CollectionsKt.joinToString$default(r103, "&", null, null, 0, null, null, 62, null);     // Catch: Throwable -> L27
    L25:
        return r112.buildUpon().encodedQuery(r113).build().toString();
    L24:
        r113 = null;
    L27:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return null;
    }

    public static final String getQueryParameter(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "key");
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L15
        Uri r103 = UriProtector.parse(r100);     // Catch: Throwable -> L15
        if (r103.isHierarchical() == false) goto L8;
        boolean r104 = true;
        if ((!StringsKt.isBlank(r101)) == false) goto L8;
    L9:
        if (r104 == true) goto L12;
        r103 = null;
    L12:
        if (r103 == null) goto L24;
        return UriProtector.getQueryParameter(r103, r101);
    L24:
        return null;
    L8:
        r104 = false;
    L15:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Throwable r106 = Result.m9452exceptionOrNullimpl(Result.m9449constructorimpl(ResultKt.createFailure(th)));
        if (r106 == null) goto L21;
        a.f554342a.getClass();
        ALogService r107 = (ALogService) a.a(ALogService.class);
        if (r107 == null) goto L21;
        r107.e("String.getQueryParameter", Log.getStackTraceString(r106));
    L21:
        return null;
    }

    public static final String appendQueryParameter(String r100, Pair<String, String>... r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "pairs");
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L5
        return appendQueryParameter(r100, MapsKt.mapOf((Pair[]) Arrays.copyOf(r101, r101.length)));
    L5:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return null;
    }

    public static final String appendQueryParameter(String r110, boolean r111, Function0<? extends Map<String, String>> r112) {
        Intrinsics.checkNotNullParameter(r110, "<this>");
        Intrinsics.checkNotNullParameter(r112, "getAppendParams");
        Map<String, String> r113 = r112.invoke();
        if (r113 != null) goto L5;
        return r110;
    L5:
        Set<String> r100 = r113.keySet();
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L54
        Uri r102 = UriProtector.parse(r110);     // Catch: Throwable -> L54
        String r103 = null;
        if (r102.isHierarchical() == false) goto L9;
        Uri r104 = r102;
    L10:
        if (r104 == null) goto L50;
        Uri.Builder r105 = r104.buildUpon();     // Catch: Throwable -> L54
        if (r105 == null) goto L50;
        Set<String> r106 = UriProtector.getQueryParameterNames(r102);     // Catch: Throwable -> L54
        if (r111 == false) goto L27;
        r105.clearQuery();     // Catch: Throwable -> L54
        if (r106 == null) goto L27;
        ArrayList r107 = new ArrayList();     // Catch: Throwable -> L54
        Iterator<T> r108 = r106.iterator();     // Catch: Throwable -> L54
    L19:
        if (r108.hasNext() == false) goto L23;
        Object r109 = r108.next();     // Catch: Throwable -> L54
        if ((!r100.contains((String) r109)) == false) goto L19;
        r107.add(r109);     // Catch: Throwable -> L54
        goto L19
    L23:
        Iterator r114 = r107.iterator();     // Catch: Throwable -> L54
    L25:
        if (r114.hasNext() == false) goto L27;
        String r115 = (String) r114.next();     // Catch: Throwable -> L54
        r105.appendQueryParameter(r115, UriProtector.getQueryParameter(r102, r115));     // Catch: Throwable -> L54
    L27:
        LinkedHashMap r116 = new LinkedHashMap();     // Catch: Throwable -> L54
        Iterator<Map.Entry<String, String>> r117 = r113.entrySet().iterator();     // Catch: Throwable -> L54
    L29:
        if (r117.hasNext() == false) goto L43;
        Map.Entry<String, String> r118 = r117.next();     // Catch: Throwable -> L54
        if (r111 == true) goto L36;
        if (r111 == false) goto L34;
    L40:
        boolean r119 = false;
    L41:
        if (r119 == false) goto L29;
        r116.put(r118.getKey(), r118.getValue());     // Catch: Throwable -> L54
        goto L29
    L34:
        if (r106.contains(r118.getKey()) == true) goto L40;
    L36:
        if ((!StringsKt.isBlank(r118.getKey())) == false) goto L40;
        if ((!StringsKt.isBlank(r118.getValue())) == false) goto L40;
        r119 = true;
        goto L41
    L43:
        Iterator r120 = r116.entrySet().iterator();     // Catch: Throwable -> L54
    L45:
        if (r120.hasNext() == false) goto L47;
        Map.Entry r121 = (Map.Entry) r120.next();     // Catch: Throwable -> L54
        r105.appendQueryParameter((String) r121.getKey(), (String) r121.getValue());     // Catch: Throwable -> L54
        goto L45
    L47:
        Uri r122 = r105.build();     // Catch: Throwable -> L54
        if (r122 == null) goto L50;
        r103 = r122.toString();     // Catch: Throwable -> L54
    L50:
        if (r103 != null) goto L53;
        return r110;
    L53:
        return r103;
    L9:
        r104 = null;
    L54:
        th = move-exception;
        Result.Companion r123 = Result.Companion;
        Throwable r124 = Result.m9452exceptionOrNullimpl(Result.m9449constructorimpl(ResultKt.createFailure(th)));
        if (r124 == null) goto L60;
        a.f554342a.getClass();
        ALogService r125 = (ALogService) a.a(ALogService.class);
        if (r125 == null) goto L60;
        r125.e("String.appendQueryParameter", Log.getStackTraceString(r124));
    L60:
        return r110;
    }

    public static final String appendQueryParameter(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter(r102, "value");
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L27
        Uri r104 = UriProtector.parse(r100);     // Catch: Throwable -> L27
        if (r104.isHierarchical() == false) goto L10;
        boolean r105 = true;
        if ((!StringsKt.isBlank(r101)) == false) goto L10;
        if ((!StringsKt.isBlank(r102)) == false) goto L10;
    L11:
        String r106 = null;
        if (r105 == true) goto L15;
        r104 = null;
    L15:
        if (r104 == null) goto L23;
        Uri.Builder r107 = r104.buildUpon();     // Catch: Throwable -> L27
        if (r107 == null) goto L23;
        Uri.Builder r108 = r107.appendQueryParameter(r101, r102);     // Catch: Throwable -> L27
        if (r108 == null) goto L23;
        Uri r109 = r108.build();     // Catch: Throwable -> L27
        if (r109 == null) goto L23;
        r106 = r109.toString();     // Catch: Throwable -> L27
    L23:
        if (r106 != null) goto L26;
        return r100;
    L26:
        return r106;
    L10:
        r105 = false;
    L27:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        Throwable r111 = Result.m9452exceptionOrNullimpl(Result.m9449constructorimpl(ResultKt.createFailure(th)));
        if (r111 == null) goto L33;
        a.f554342a.getClass();
        ALogService r112 = (ALogService) a.a(ALogService.class);
        if (r112 == null) goto L33;
        r112.e("String.appendQueryParameter", Log.getStackTraceString(r111));
    L33:
        return r100;
    }
}
