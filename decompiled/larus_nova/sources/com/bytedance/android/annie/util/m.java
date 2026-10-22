package com.bytedance.android.annie.util;

import android.app.Activity;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes43.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f40066a = 0;

    static {
    }

    public static boolean c() {
        if (p.f40070a.getResources().getConfiguration().orientation != 2) goto L5;
        return true;
    L5:
        return false;
    }

    @JvmStatic
    public static final boolean a(Activity r100) {
        if (r100 != null) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == true) goto L23;
        if (r100 != null) goto L11;
    L13:
        boolean r102 = false;
    L14:
        if (r102 == true) goto L23;
        if (r100 != null) goto L17;
    L19:
        boolean r103 = false;
    L20:
        if (r103 == true) goto L23;
        return false;
    L17:
        if (r100.getRequestedOrientation() != 6) goto L19;
        r103 = true;
        goto L20
    L11:
        if (r100.getRequestedOrientation() != 8) goto L13;
        r102 = true;
    L23:
        return true;
    L5:
        if (r100.getRequestedOrientation() != 0) goto L7;
        r101 = true;
        goto L8
    }

    public static boolean b(int r100) {
        if (com.bytedance.android.annie.ng.g.b().f39658b.f522318c == true) goto L5;
        if (r100 != 0) goto L11;
        return true;
    L11:
        if (r100 != 6) goto L13;
        return true;
    L13:
        if (r100 == 8) goto L19;
        return false;
    L19:
        return true;
    L5:
        if (p.f40070a.getResources().getConfiguration().orientation == 2) goto L16;
        return false;
    L16:
        return true;
    }
}
