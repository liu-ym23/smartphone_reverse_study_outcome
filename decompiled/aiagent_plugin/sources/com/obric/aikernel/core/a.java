package com.obric.aikernel.core;

import com.obric.aikernel.sdk.AIKernelConfig;
import d.h.b.o;

/* JADX INFO: compiled from: DataHolder.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f22349a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static AIKernelConfig f22350b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f22351c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f22352d;

    private a() {
    }

    public final AIKernelConfig a() {
        return f22350b;
    }

    public final void a(AIKernelConfig r1) {
        f22350b = r1;
    }

    static {
        f22349a = new a();
        f22351c = "";
    }

    public final void a(String r1) {
        o.e(r1, "<set-?>");
        f22351c = r1;
    }

    public final String b() {
        return f22351c;
    }

    public final void a(boolean r1) {
        f22352d = r1;
    }

    public final boolean c() {
        return f22352d;
    }
}
