package com.google.android.gms.common.internal;

import android.util.Log;

/* renamed from: com.google.android.gms.common.internal.g, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1666g {

    /* renamed from: a, reason: collision with root package name */
    public final String f19828a;

    /* renamed from: b, reason: collision with root package name */
    public final String f19829b;

    public C1666g(String str, String str2) {
        C1669j.l(str, "log tag cannot be null");
        C1669j.c(str.length() <= 23, "tag \"%s\" is longer than the %d character maximum", str, 23);
        this.f19828a = str;
        this.f19829b = (str2 == null || str2.length() <= 0) ? null : str2;
    }

    public boolean a(int i10) {
        return Log.isLoggable(this.f19828a, i10);
    }

    public void b(String str, String str2) {
        if (a(3)) {
            Log.d(str, g(str2));
        }
    }

    public void c(String str, String str2) {
        if (a(6)) {
            Log.e(str, g(str2));
        }
    }

    public void d(String str, String str2, Throwable th) {
        if (a(6)) {
            Log.e(str, g(str2), th);
        }
    }

    public void e(String str, String str2) {
        if (a(2)) {
            Log.v(str, g(str2));
        }
    }

    public void f(String str, String str2) {
        if (a(5)) {
            Log.w(str, g(str2));
        }
    }

    public final String g(String str) {
        String str2 = this.f19829b;
        return str2 == null ? str : str2.concat(str);
    }
}
