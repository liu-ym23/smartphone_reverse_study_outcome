package com.android.ttcjpaysdk.base.ktextension;

import android.net.Uri;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.bytedance.caijing.sdk.infra.base.core.CJContext;
import com.bytedance.caijing.sdk.infra.base.event.CJReporter;
import com.bytedance.caijing.sdk.infra.base.logger.CJLogger;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0003\u001a=\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00012*\u0010\u0002\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u00040\u0003\"\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0002\u0010\u0005\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0001\u001a \u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t\u001a\n\u0010\n\u001a\u00020\u0001*\u00020\u0001\u001a\u0014\u0010\u000b\u001a\u0004\u0018\u00010\u0001*\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001¨\u0006\f"}, d2 = {"appendQueryParameter", "", "pairs", "", "Lkotlin/Pair;", "(Ljava/lang/String;[Lkotlin/Pair;)Ljava/lang/String;", "key", "value", "map", "", "clearQuery", "getQueryParameter", "base-context_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class CJSchemaExtensionKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final String clearQuery(String r110) {
        Intrinsics.checkNotNullParameter(r110, "<this>");
        boolean r100 = r110 instanceof ICJTag;
        String r101 = "runCatching";
        if (r100 == false) goto L8;
        String r102 = ((ICJTag) r110).CJTag();
        if (r102 == null) goto L8;
        if (StringsKt.isBlank(r102) == true) goto L8;
    L10:
        if (StringsKt.isBlank(r102) == false) goto L18;
        if (r100 == false) goto L19;
        String r103 = ((ICJTag) r110).CJTag();
        if (r103 == null) goto L19;
        if (StringsKt.isBlank(r103) == true) goto L19;
        r101 = r103;
    L19:
        String r104 = CollectionsKt.joinToString$default(ArraysKt.take(ThreadMethodProxy.currentThread().getStackTrace(), 5), "\n ", null, null, 0, null, null, 62, null);
        CJLogger.a(r101, "Debug\n " + CollectionsKt.joinToString$default(ArraysKt.take(ThreadMethodProxy.currentThread().getStackTrace(), 10), "\n ", null, null, 0, null, null, 62, null));
        long r105 = System.currentTimeMillis();
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L22
        return UriProtector.parse(r110).buildUpon().clearQuery().build().toString();
    L22:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        Object r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        String r111 = null;
        if (Result.m9456isSuccessimpl(r108) == false) goto L26;
        CJLogger.d(r101, "onSuccess\n " + r104);
        Object r112 = r108;
        boolean r109 = true;
    L27:
        Throwable r113 = Result.m9452exceptionOrNullimpl(r108);
        if (r113 == null) goto L30;
        CJBasicCommonUtils.reportCatchException("CJResult#unknown", r113);
        CJLogger.c(r101, "onFailure", r113);
        r109 = false;
    L31:
        long r114 = System.currentTimeMillis() - r105;
        CJLogger.d(r101, "is_success: " + r109 + ", duration: " + r114);
        CJReporter r115 = CJReporter.f202294a;
        Set<String> r116 = CJContext.f202254w;
        String r117 = "";
        CJContext r118 = CJContext.c.a(r102, "", "", new HashMap());
        Pair[] r119 = new Pair[5];
        r119[0] = TuplesKt.to("tag", r102);
        r119[1] = TuplesKt.to("is_success", KtSafeMethodExtensionKt.tf(r109, "1", "0"));
        if (r113 == null) goto L34;
        r111 = r113.getMessage();
    L34:
        if (r111 == null) goto L37;
        r117 = r111;
    L37:
        r119[2] = TuplesKt.to("error_msg", r117);
        r119[3] = TuplesKt.to("trace", r104);
        r119[4] = TuplesKt.to("duration", Long.valueOf(r114));
        CJReporter.o(r118, "cjpay_run_catch_result", MapsKt.mapOf(r119));
        new CJResult(r112, r109, r113);
        return r110;
    L30:
        r113 = null;
        goto L31
    L26:
        r112 = null;
        r109 = false;
        goto L27
    L18:
        r101 = r102;
    L8:
        r102 = "runCatching";
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final String appendQueryParameter(String r110, Pair<String, String>... r111) {
        Intrinsics.checkNotNullParameter(r110, "<this>");
        Intrinsics.checkNotNullParameter(r111, "pairs");
        boolean r100 = r110 instanceof ICJTag;
        String r101 = "runCatching";
        if (r100 == false) goto L8;
        String r102 = ((ICJTag) r110).CJTag();
        if (r102 == null) goto L8;
        if (StringsKt.isBlank(r102) == true) goto L8;
    L10:
        if (StringsKt.isBlank(r102) == false) goto L18;
        if (r100 == false) goto L19;
        String r103 = ((ICJTag) r110).CJTag();
        if (r103 == null) goto L19;
        if (StringsKt.isBlank(r103) == true) goto L19;
        r101 = r103;
    L19:
        String r104 = CollectionsKt.joinToString$default(ArraysKt.take(ThreadMethodProxy.currentThread().getStackTrace(), 5), "\n ", null, null, 0, null, null, 62, null);
        CJLogger.a(r101, "Debug\n " + CollectionsKt.joinToString$default(ArraysKt.take(ThreadMethodProxy.currentThread().getStackTrace(), 10), "\n ", null, null, 0, null, null, 62, null));
        long r105 = System.currentTimeMillis();
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L22
        return appendQueryParameter(r110, MapsKt.mapOf((Pair[]) Arrays.copyOf(r111, r111.length)));
    L22:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        Object r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        if (Result.m9456isSuccessimpl(r108) == false) goto L26;
        CJLogger.d(r101, "onSuccess\n " + r104);
        Object r112 = r108;
        boolean r109 = true;
    L27:
        Throwable r113 = Result.m9452exceptionOrNullimpl(r108);
        if (r113 == null) goto L30;
        CJBasicCommonUtils.reportCatchException("CJResult#unknown", r113);
        CJLogger.c(r101, "onFailure", r113);
        r109 = false;
    L31:
        long r114 = System.currentTimeMillis() - r105;
        CJLogger.d(r101, "is_success: " + r109 + ", duration: " + r114);
        CJReporter r115 = CJReporter.f202294a;
        Set<String> r116 = CJContext.f202254w;
        String r117 = "";
        CJContext r118 = CJContext.c.a(r102, "", "", new HashMap());
        Pair[] r119 = new Pair[5];
        r119[0] = TuplesKt.to("tag", r102);
        r119[1] = TuplesKt.to("is_success", KtSafeMethodExtensionKt.tf(r109, "1", "0"));
        if (r113 == null) goto L34;
        String r120 = r113.getMessage();
    L35:
        if (r120 == null) goto L38;
        r117 = r120;
    L38:
        r119[2] = TuplesKt.to("error_msg", r117);
        r119[3] = TuplesKt.to("trace", r104);
        r119[4] = TuplesKt.to("duration", Long.valueOf(r114));
        CJReporter.o(r118, "cjpay_run_catch_result", MapsKt.mapOf(r119));
        new CJResult(r112, r109, r113);
        return null;
    L34:
        r120 = null;
        goto L35
    L30:
        r113 = null;
        goto L31
    L26:
        r112 = null;
        r109 = false;
        goto L27
    L18:
        r101 = r102;
    L8:
        r102 = "runCatching";
        goto L10
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
        if (r103 == null) goto L22;
        return UriProtector.getQueryParameter(r103, r101);
    L22:
        return null;
    L8:
        r104 = false;
    L15:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Throwable r106 = Result.m9452exceptionOrNullimpl(Result.m9449constructorimpl(ResultKt.createFailure(th)));
        if (r106 == null) goto L19;
        CJBasicCommonUtils.reportCatchException("CJSchemaExtension#unknown", r106);
        CJLogger.c("String.getQueryParameter", "", r106);
    L19:
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
        if (r114 == null) goto L37;
        CJBasicCommonUtils.reportCatchException("CJSchemaExtension#unknown", r114);
        CJLogger.c("String.appendQueryParameter", "", r114);
    L37:
        return r100;
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
        if (r111 == null) goto L31;
        CJBasicCommonUtils.reportCatchException("CJSchemaExtension#unknown", r111);
        CJLogger.c("String.appendQueryParameter", "", r111);
    L31:
        return r100;
    }
}
