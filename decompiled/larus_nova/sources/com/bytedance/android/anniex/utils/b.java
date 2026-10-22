package com.bytedance.android.anniex.utils;

import android.net.Uri;
import com.bytedance.android.anniex.base.depend.AnnieXRuntime;
import com.bytedance.salamander.anniex.AnnieXSL;

/* JADX INFO: loaded from: classes43.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f41399a = 0;

    static {
    }

    public static void a(Uri r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        AnnieXSL.a r101 = AnnieXSL.Companion;
        String r102 = r100.toString();
        r101.getClass();
        if (AnnieXSL.a.a(r102) == false) goto L8;
        AnnieXRuntime.b().getClass();
        AnnieXRuntime.b().getClass();
        return;
    }
}
