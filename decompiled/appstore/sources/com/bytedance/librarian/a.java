package com.bytedance.librarian;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Context f7681a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile String f7682b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static b f7683c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Object f7684d = null;

    static {
        f7684d = new Object();
    }

    public static void a(String r10, Context r11) {
        b(r10, false, true, r11);
    }

    public static void b(String r10, boolean r11, boolean r12, Context r13) {
        if (r12 == true) goto L4;
    L6:
        LibrarianImpl r14 = LibrarianImpl.f7661m;
        if (r14 == null) goto L9;
        r14.m(r10, r11);
        return;
    L9:
        b r15 = f7683c;
        if (r15 == null) goto L12;
        r15.e(r10);
        return;
    L12:
        System.loadLibrary(r10);
        return;
    L4:
        if (f7681a != null) goto L6;
        f7681a = r13;
        goto L6
    }
}
