package com.bytedance.apm.block;

import com.bytedance.apm.util.ListUtils;
import java.util.ConcurrentModificationException;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public abstract class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static HashSet f6398a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f6399b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f6400c;

    static {
        f6398a = new HashSet();
        f6399b = "";
        f6400c = true;
    }

    public static void a(String r10) {
        f6400c = true;
        f6398a.add(r10);
    }

    public static String b() {
        if (f6400c == false) goto L6;
        f6399b = ListUtils.c(f6398a, ",");     // Catch: ConcurrentModificationException -> L7
        f6400c = false;     // Catch: ConcurrentModificationException -> L7
    L6:
        return f6399b;
    }

    public static void c(String r10) {
        f6400c = true;
        f6398a.remove(r10);
    }
}
