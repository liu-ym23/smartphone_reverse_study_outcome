package com.airbnb.lottie;

import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set<String> f24776a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f24777b;

    static {
        f24776a = new HashSet();
        f24777b = 0;
    }

    public static void a() {
        int r100 = f24777b;
        if (r100 <= 0) goto L6;
        f24777b = r100 - 1;
        return;
    }

    public static void b(String r100) {
        Set<String> r101 = f24776a;
        if (((HashSet) r101).contains(r100) == false) goto L5;
        return;
    L5:
        ((HashSet) r101).add(r100);
    }
}
