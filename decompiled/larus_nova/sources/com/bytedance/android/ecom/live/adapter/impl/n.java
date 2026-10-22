package com.bytedance.android.ecom.live.adapter.impl;

import android.app.Application;
import android.content.SharedPreferences;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class n implements mj.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SharedPreferences f51181a;

    public n() {
    }

    @Override // mj.a
    public final List<String> a(String r100, List<String> r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "default");
        return r101;
    }

    @Override // mj.a
    public final void b(String r100, List<String> r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
    }

    public final SharedPreferences f() {
        if (this.f51181a != null) goto L10;
        Application r100 = jc1.a.b();
        if (r100 == null) goto L7;
        SharedPreferences r101 = r100.getSharedPreferences("ec-sdk-saas", 0);
    L8:
        this.f51181a = r101;
        goto L10
    L7:
        r101 = null;
    L10:
        return this.f51181a;
    }

    @Override // mj.a
    public final void erase(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        SharedPreferences r101 = f();
        if (r101 == null) goto L8;
        SharedPreferences.Editor r102 = r101.edit();
        if (r102 == null) goto L9;
        r102.remove(r100);
        return;
    L9:
        return;
    }

    @Override // mj.a
    public final void c(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        SharedPreferences r102 = f();
        if (r102 == null) goto L10;
        SharedPreferences.Editor r103 = r102.edit();
        if (r103 == null) goto L11;
        SharedPreferences.Editor r104 = r103.putBoolean(r100, r101);
        if (r104 == null) goto L12;
        r104.apply();
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // mj.a
    public final void d(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        SharedPreferences r102 = f();
        if (r102 == null) goto L10;
        SharedPreferences.Editor r103 = r102.edit();
        if (r103 == null) goto L11;
        SharedPreferences.Editor r104 = r103.putInt(r100, r101);
        if (r104 == null) goto L12;
        r104.apply();
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // mj.a
    public final void e(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        SharedPreferences r102 = f();
        if (r102 == null) goto L10;
        SharedPreferences.Editor r103 = r102.edit();
        if (r103 == null) goto L11;
        SharedPreferences.Editor r104 = r103.putLong(r100, r101);
        if (r104 == null) goto L12;
        r104.apply();
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // mj.a
    public final boolean getBoolean(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        SharedPreferences r102 = f();
        if (r102 != null) goto L5;
        return r101;
    L5:
        return r102.getBoolean(r100, r101);
    }

    @Override // mj.a
    public final int getInt(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        SharedPreferences r102 = f();
        if (r102 != null) goto L5;
        return r101;
    L5:
        return r102.getInt(r100, r101);
    }

    @Override // mj.a
    public final long getLong(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        SharedPreferences r102 = f();
        if (r102 != null) goto L5;
        return r101;
    L5:
        return r102.getLong(r100, r101);
    }

    @Override // mj.a
    public final String getString(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "default");
        SharedPreferences r102 = f();
        if (r102 == null) goto L9;
        String r103 = r102.getString(r100, r101);
        if (r103 != null) goto L8;
        return r101;
    L8:
        return r103;
    L9:
        return r101;
    }

    @Override // mj.a
    public final void putString(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        SharedPreferences r102 = f();
        if (r102 == null) goto L10;
        SharedPreferences.Editor r103 = r102.edit();
        if (r103 == null) goto L11;
        SharedPreferences.Editor r104 = r103.putString(r100, r101);
        if (r104 == null) goto L12;
        r104.apply();
        return;
    L12:
        return;
    L11:
        return;
    }
}
