package com.bytedance.apm.block;

import java.util.ConcurrentModificationException;
import java.util.HashSet;

/* JADX INFO: compiled from: FluencySceneManager.java */
/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static HashSet<String> f4364a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f4365b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f4366c;

    static {
        f4364a = new HashSet();
        f4365b = "";
        f4366c = true;
    }

    public static String a() {
        if (f4366c == false) goto L6;
        f4365b = com.bytedance.apm.util.j.a(f4364a, ",");     // Catch: ConcurrentModificationException -> L7
        f4366c = false;     // Catch: ConcurrentModificationException -> L7
    L6:
        return f4365b;
    }

    public static void a(String r1) {
        f4366c = true;
        f4364a.add(r1);
    }

    public static void b(String r1) {
        f4366c = true;
        f4364a.remove(r1);
    }
}
