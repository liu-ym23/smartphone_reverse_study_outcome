package com.bytedance.android.live.revenue.common;

import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f90829a = 0;

    static {
    }

    public static long a(File r100) {
        Intrinsics.checkNotNullParameter(r100, "fileOrDirectory");
        long r101 = 0;
        if (r100.exists() == true) goto L6;
        return 0;
    L6:
        if (r100.isDirectory() == false) goto L17;
        File[] r102 = r100.listFiles();
        if (r102 == null) goto L21;
        int r103 = r102.length;
        int r104 = 0;
    L10:
        if (r104 >= r103) goto L22;
        File r105 = r102[r104];
        if (r105.isDirectory() == false) goto L14;
        long r106 = a(r105);
    L15:
        r101 = r101 + r106;
        r104 = r104 + 1;
        goto L10
    L14:
        r106 = r105.length();
        goto L15
    L22:
        return r101;
    L21:
        return 0;
    L17:
        return r100.length();
    }

    public static boolean b(File r100) {
        Intrinsics.checkNotNullParameter(r100, "fileOrDirectory");
        if (r100.isDirectory() == false) goto L23;
        File[] r101 = r100.listFiles();
        if (r101 == null) goto L21;
        int r102 = 0;
        if (r101.length != 0) goto L9;
        boolean r103 = true;
    L10:
        if (r103 == true) goto L21;
        int r104 = r101.length;
    L13:
        if (r102 >= r104) goto L27;
        File r105 = r101[r102];
        if (r105.isDirectory() == false) goto L17;
        b(r105);
    L18:
        r102 = r102 + 1;
        goto L13
    L17:
        r105.delete();
        goto L18
    L27:
        return r100.delete();
    L9:
        r103 = false;
    L21:
        return r100.delete();
    L23:
        return r100.delete();
    }
}
