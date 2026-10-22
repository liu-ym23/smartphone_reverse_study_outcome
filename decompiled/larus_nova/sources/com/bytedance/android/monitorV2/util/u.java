package com.bytedance.android.monitorV2.util;

import com.bytedance.mt.protector.impl.PatternProtector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes12.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f163257a = null;

    static {
        f163257a = PatternProtector.compile("/(data|user|local_file)/.+?/([^\\/]+?)/\\d{5}\\d+/res/([^?]+)");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.lang.CharSequence, java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v13 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9 */
    public static String a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "fullUrl");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L20
        if (StringsKt.startsWith$default(r100, "http", false, 2, null) == false) goto L6;
        r100 = CollectionsKt.first(StringsKt.split$default(r100, new String[]{"?"}, false, 0, 6, null));     // Catch: Throwable -> L20
    L18:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L20
        ?? r102 = r100;
    L23:
        return (String) r102;
    L6:
        boolean r103 = StringsKt.startsWith$default(r100, "/data", false, 2, null);     // Catch: Throwable -> L20
        r100 = r100;
        if (r103 == false) goto L18;
        Matcher r104 = f163257a.matcher(r100);     // Catch: Throwable -> L20
        if (r104.find() == false) goto L12;
        String r105 = r104.group(2);     // Catch: Throwable -> L20
        String r106 = r104.group(3);     // Catch: Throwable -> L20
    L13:
        r100 = r100;
        if ((!StringsKt.isBlank(r105)) == false) goto L18;
        r100 = r100;
        if ((!StringsKt.isBlank(r106)) == false) goto L18;
        r100 = "lynxview://" + r105 + '/' + r106;     // Catch: Throwable -> L20
        goto L18
    L12:
        r105 = "";
        r106 = "";
    L20:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        r102 = r100;
        goto L23
    }
}
