package com.bytedance.android.gamecp.common.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes44.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f57249a = 0;

    static {
    }

    public static String a(String r100) {
        String r101 = "";
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return "";
    L5:
        String r102 = UriProtector.parse(r100).getLastPathSegment();
        if (TextUtils.isEmpty(r102) == true) goto L9;
        r101 = r102;
    L9:
        Intrinsics.checkNotNull(r101);
        if (StringsKt.endsWith$default(r101, ".apk", false, 2, null) == false) goto L12;
        return r101;
    L12:
        return r101 + ".apk";
    }

    public static boolean b(Context r100, String r101, int r102) {
        if (r101 == null) goto L11;
        if (r100 == null) goto L11;
        if (r102 <= 0) goto L11;
        PackageInfo r103 = r100.getPackageManager().getPackageInfo(r101, 1);     // Catch: PackageManager.NameNotFoundException -> L13
        if (r103 == null) goto L11;
        if (r102 > r103.versionCode) goto L11;
        return true;
    L11:
        return false;
    }
}
