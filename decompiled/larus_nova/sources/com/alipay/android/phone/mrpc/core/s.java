package com.alipay.android.phone.mrpc.core;

import android.content.Context;

/* JADX INFO: loaded from: classes28.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Boolean f25068a;

    public static final boolean a(Context r100) {
        Boolean r101 = f25068a;
        if (r101 == null) goto L14;
        return r101.booleanValue();
    L14:
    L13:
        return false;
    L8:
        if ((r100.getPackageManager().getApplicationInfo(r100.getPackageName(), 0).flags & 2) == 0) goto L10;
        boolean r102 = true;
    L11:
        Boolean r103 = Boolean.valueOf(r102);     // Catch: Exception -> L13
        f25068a = r103;     // Catch: Exception -> L13
        return r103.booleanValue();
    L10:
        r102 = false;
        goto L11
    }
}
