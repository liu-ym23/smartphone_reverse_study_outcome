package com.bytedance.android.ec.core.utils;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f45664a = 0;

    static {
    }

    public static String a(String r100, Map r101) {
        Uri r102 = UriProtector.parse(r100);     // Catch: Exception -> L12
        Uri r103 = UriProtector.parse(UriProtector.getQueryParameter(r102, "url"));     // Catch: Exception -> L12
        if (r103 == null) goto L16;
        if (r101 == null) goto L10;
        Iterator r104 = r101.entrySet().iterator();     // Catch: Exception -> L12
    L8:
        if (r104.hasNext() == false) goto L10;
        Map.Entry r105 = (Map.Entry) r104.next();     // Catch: Exception -> L12
        r103 = e(r103, (String) r105.getKey(), (String) r105.getValue());     // Catch: Exception -> L12
    L10:
        return String.valueOf(e(r102, "url", r103.toString()));
    L16:
        return r100;
    L17:
        return r100;
    }

    public static String b(String r100, Map r101) {
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L12
        Uri r103 = UriProtector.parse(r100);     // Catch: Throwable -> L12
        if (r101 == null) goto L10;
        Iterator r104 = r101.entrySet().iterator();     // Catch: Throwable -> L12
    L6:
        if (r104.hasNext() == false) goto L9;
        Map.Entry r105 = (Map.Entry) r104.next();     // Catch: Throwable -> L12
        r103 = e(r103, (String) r105.getKey(), (String) r105.getValue());     // Catch: Throwable -> L12
        goto L6
    L9:
        return r103.toString();
    L10:
        Object r106 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L12
    L14:
        Result.m9452exceptionOrNullimpl(r106);
        return r100;
    L12:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L14
    }

    public static Uri f(Uri r100, Map r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$replaceOrAppendParameters");
        Intrinsics.checkNotNullParameter(r101, "paramsMap");
        Set<String> r102 = UriProtector.getQueryParameterNames(r100);
        Uri.Builder r103 = r100.buildUpon().clearQuery();
        Iterator<T> r104 = r102.iterator();
    L4:
        if (r104.hasNext() == false) goto L9;
        String r105 = (String) r104.next();
        if (r101.containsKey(r105) == true) goto L7;
        r103.appendQueryParameter(r105, UriProtector.getQueryParameter(r100, r105));
        goto L4
    L7:
        r103.appendQueryParameter(r105, (String) r101.get(r105));
        r101.remove(r105);
        goto L4
    L9:
        Iterator r106 = r101.entrySet().iterator();
    L11:
        if (r106.hasNext() == false) goto L14;
        Map.Entry r107 = (Map.Entry) r106.next();
        r103.appendQueryParameter((String) r107.getKey(), (String) r107.getValue());
        goto L11
    L14:
        return r103.build();
    }

    public static String c(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "originKey");
        Intrinsics.checkNotNullParameter(r102, "originValue");
        String r103 = Uri.encode(r101);
        String r104 = Uri.encode(r102);
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return r100;
    L5:
        if (TextUtils.isEmpty(r103) == false) goto L7;
        return r100;
    L7:
        return new Regex("(" + r103 + "=[^&]*)").replace(r100, r103 + com.alipay.sdk.m.n.a.f25612h + r104);
    }

    public static String d(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter(r102, "value");
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return r100;
    L5:
        if (TextUtils.isEmpty(r101) == false) goto L7;
        return r100;
    L7:
        if (StringsKt.contains$default(r100, r101, false, 2, null) == true) goto L17;
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "key");
        Intrinsics.checkNotNullParameter(r102, "value");
        if (TextUtils.isEmpty(r100) == false) goto L12;
        return r100;
    L12:
        if (TextUtils.isEmpty(r101) == false) goto L14;
        return r100;
    L14:
        return UriProtector.parse(r100).buildUpon().appendQueryParameter(r101, r102).toString();
    L17:
        return c(r100, r101, r102);
    }

    public static Uri e(Uri r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        if (r101 == null) goto L25;
        if (r102 == null) goto L25;
        Uri.Builder r103 = r100.buildUpon();
    L23:
        e = move-exception;
        ECExceptionMonitor.f(e, "error uri: " + r100);
        goto L25
    L8:
        if (TextUtils.isEmpty(UriProtector.getQueryParameter(r100, r101)) == false) goto L10;
        r103.appendQueryParameter(r101, r102);     // Catch: Exception -> L23
    L22:
        return r103.build();
    L10:
        r103.clearQuery();     // Catch: Exception -> L23
        Iterator<String> r104 = UriProtector.getQueryParameterNames(r100).iterator();     // Catch: Exception -> L23
    L12:
        if (r104.hasNext() == false) goto L22;
        String r105 = r104.next();     // Catch: Exception -> L23
        if ((!Intrinsics.areEqual(r105, r101)) == true) goto L15;
        r103.appendQueryParameter(r105, r102);     // Catch: Exception -> L23
        goto L12
    L15:
        Iterator<String> r106 = UriProtector.getQueryParameters(r100, r105).iterator();     // Catch: Exception -> L23
    L17:
        if (r106.hasNext() == false) goto L12;
        r103.appendQueryParameter(r105, r106.next());     // Catch: Exception -> L23
    L25:
        return r100;
    }

    public static String g(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "url");
        return String.valueOf(e(UriProtector.parse(r100), r101, r102));
    }
}
