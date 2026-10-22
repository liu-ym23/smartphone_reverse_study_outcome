package com.bytedance.android.live.impl.utils;

import com.bytedance.common.utility.Logger;
import j40.c0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes45.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f69317a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f69318b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f69319c = null;

    public a() {
    }

    static {
        f69317a = c0.f497176a.getValue().getLogEnable();
        f69318b = "LFM-Feature";
        f69319c = "LFM-";
    }

    public static void a(String r100, Function0 r101) {
        Intrinsics.checkNotNullParameter(r101, "msg");
        if (f69317a == false) goto L12;
        if (r100 != null) goto L6;
        r100 = f69318b;
    L10:
        Logger.d(r100, (String) r101.invoke());
        return;
    L6:
        String r102 = f69319c;
        if (StringsKt.startsWith$default(r100, r102, false, 2, null) == true) goto L10;
        r100 = r102 + r100;
        goto L10
    }

    public static void c(String r100, Function0 r101) {
        Intrinsics.checkNotNullParameter(r101, "msg");
        if (f69317a == false) goto L10;
        String r102 = f69319c;
        if (StringsKt.startsWith$default(r100, r102, false, 2, null) == true) goto L8;
        r100 = r102 + r100;
    L8:
        Logger.i(r100, (String) r101.invoke());
        return;
    }

    public static void d(String r100, Function0 r101) {
        Intrinsics.checkNotNullParameter(r101, "msg");
        if (f69317a == false) goto L12;
        if (r100 != null) goto L6;
        r100 = f69318b;
    L10:
        Logger.w(r100, (String) r101.invoke());
        return;
    L6:
        String r102 = f69319c;
        if (StringsKt.startsWith$default(r100, r102, false, 2, null) == true) goto L10;
        r100 = r102 + r100;
        goto L10
    }

    public static void b(String r100, Function0 r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r101, "msg");
        if (f69317a == false) goto L12;
        if (r100 != null) goto L6;
        r100 = f69318b;
    L10:
        Logger.e(r100, (String) r101.invoke(), r102);
        return;
    L6:
        String r103 = f69319c;
        if (StringsKt.startsWith$default(r100, r103, false, 2, null) == true) goto L10;
        r100 = r103 + r100;
        goto L10
    }
}
