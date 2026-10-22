package com.baidu.mapauto.auth.store;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.mapauto.auth.base.d;

/* JADX INFO: loaded from: classes39.dex */
public final class a implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SharedPreferences f31933a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SharedPreferences.Editor f31934b;

    public a(Context r100) {
        SharedPreferences.Editor r101 = null;
        if (r100 != null) goto L5;
        SharedPreferences r102 = null;
    L6:
        this.f31933a = r102;
        if (r102 == null) goto L10;
        r101 = r102.edit();
    L10:
        this.f31934b = r101;
        return;
    L5:
        r102 = r100.getSharedPreferences("license_auth", 0);
        goto L6
    }
}
