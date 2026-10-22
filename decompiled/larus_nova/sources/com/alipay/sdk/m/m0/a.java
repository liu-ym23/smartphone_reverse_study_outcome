package com.alipay.sdk.m.m0;

import android.content.Context;
import android.content.SharedPreferences;
import com.alipay.sdk.m.l0.f;

/* JADX INFO: loaded from: classes28.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f25600a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SharedPreferences f25601b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SharedPreferences.Editor f25602c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Context f25603d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f25604e;

    private void b() {
        if (this.f25602c != null) goto L8;
        SharedPreferences r100 = this.f25601b;
        if (r100 == null) goto L9;
        this.f25602c = r100.edit();
        return;
    L9:
        return;
    }

    public boolean a() {
        long r100 = System.currentTimeMillis();
        SharedPreferences.Editor r101 = this.f25602c;
        if (r101 != null) goto L5;
    L12:
        boolean r102 = true;
    L14:
        if (this.f25601b == null) goto L18;
        Context r103 = this.f25603d;
        if (r103 == null) goto L18;
        this.f25601b = r103.getSharedPreferences(this.f25600a, 0);
    L18:
        return r102;
    L5:
        if (this.f25604e == true) goto L10;
        if (this.f25601b == null) goto L10;
        r101.putLong("t", r100);
    L10:
        if (this.f25602c.commit() == true) goto L12;
        r102 = false;
        goto L14
    }

    public String a(String r100) {
        SharedPreferences r101 = this.f25601b;
        if (r101 == null) goto L7;
        String r102 = r101.getString(r100, "");
        if (f.m8017a(r102) == true) goto L7;
        return r102;
    L7:
        return "";
    }

    public void b(String r100) {
        if (f.m8017a(r100) == false) goto L5;
        return;
    L5:
        if (r100.equals("t") == true) goto L11;
        b();
        SharedPreferences.Editor r101 = this.f25602c;
        if (r101 == null) goto L12;
        r101.remove(r100);
        return;
    L12:
        return;
    }

    public void a(String r100, String r101) {
        if (f.m8017a(r100) == false) goto L5;
        return;
    L5:
        if (r100.equals("t") == true) goto L11;
        b();
        SharedPreferences.Editor r102 = this.f25602c;
        if (r102 == null) goto L12;
        r102.putString(r100, r101);
        return;
    L12:
        return;
    }

    public a(Context r100, String r101, String r102, boolean r103, boolean r104) {
        this.f25601b = null;
        this.f25602c = null;
        this.f25604e = r104;
        this.f25600a = r102;
        this.f25603d = r100;
        if (r100 == null) goto L6;
        this.f25601b = r100.getSharedPreferences(r102, 0);
        return;
    }
}
