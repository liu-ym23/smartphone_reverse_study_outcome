package com.bytedance.android.anniex.lite.utils;

import android.net.Uri;
import com.bytedance.android.anniex.scene.settings.SwitchCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile String f40953a;

    public static final Long a(Uri r100, String r101, m16.b r102) {
        if (r100 != null) goto L5;
    L24:
        return null;
    L5:
        if (((Boolean) SwitchCenter.f41321m0.getValue()).booleanValue() == true) goto L7;
        return null;
    L7:
        boolean r103 = false;
        if (r101 != null) goto L10;
    L12:
        boolean r104 = false;
    L13:
        if (r102 == null) goto L15;
        a r105 = (a) r102.c(a.class);
    L16:
        if (r105 == null) goto L18;
        r103 = true;
    L18:
        if (r104 == true) goto L21;
        if (r103 == false) goto L24;
    L21:
        if (SwitchCenter.a(r100) == false) goto L24;
        return Long.valueOf(((Number) SwitchCenter.f41323n0.getValue()).longValue());
    L15:
        r105 = null;
        goto L16
    L10:
        if (Intrinsics.areEqual(f40953a, r101) == false) goto L12;
        r104 = true;
        goto L13
    }
}
