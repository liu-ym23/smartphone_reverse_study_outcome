package com.bytedance.crash.runtime;

import android.text.TextUtils;

/* JADX INFO: compiled from: SettingManager.java */
/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f7749a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f7750b;

    public e() {
        this.f7750b = -1;
    }

    public void a(String r1) {
        this.f7749a = r1;
    }

    public String a() {
        if (TextUtils.isEmpty(this.f7749a) == false) goto L6;
        this.f7749a = "0";
    L6:
        return this.f7749a;
    }

    public boolean b() {
        if (TextUtils.isEmpty(this.f7749a) == false) goto L5;
    L7:
        return false;
    L5:
        if ("0".equals(this.f7749a) == true) goto L7;
        return true;
    }
}
