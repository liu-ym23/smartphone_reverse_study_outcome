package com.google.android.material.transition;

/* JADX INFO: compiled from: FadeModeEvaluators.java */
/* JADX INFO: loaded from: classes2.dex */
class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f13714a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final a f13715b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final a f13716c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final a f13717d = null;

    static {
        f13714a = new AnonymousClass1();
        f13715b = new AnonymousClass2();
        f13716c = new AnonymousClass3();
        f13717d = new AnonymousClass4();
    }

    static a a(int r2, boolean r3) {
        if (r2 != 0) goto L4;
        if (r3 == false) goto L22;
        return f13714a;
    L22:
        return f13715b;
    L4:
        if (r2 != 1) goto L6;
        if (r3 == false) goto L18;
        return f13715b;
    L18:
        return f13714a;
    L6:
        if (r2 == 2) goto L14;
        if (r2 != 3) goto L12;
        return f13717d;
    L12:
        throw new IllegalArgumentException("Invalid fade mode: " + r2);
    L14:
        return f13716c;
    }
}
