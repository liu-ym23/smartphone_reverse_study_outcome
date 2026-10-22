package com.google.android.material.transition.platform;

/* JADX INFO: compiled from: FadeModeEvaluators.java */
/* JADX INFO: loaded from: classes2.dex */
class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f13748a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final a f13749b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final a f13750c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final a f13751d = null;

    static {
        f13748a = new AnonymousClass1();
        f13749b = new AnonymousClass2();
        f13750c = new AnonymousClass3();
        f13751d = new AnonymousClass4();
    }

    static a a(int r2, boolean r3) {
        if (r2 != 0) goto L4;
        if (r3 == false) goto L22;
        return f13748a;
    L22:
        return f13749b;
    L4:
        if (r2 != 1) goto L6;
        if (r3 == false) goto L18;
        return f13749b;
    L18:
        return f13748a;
    L6:
        if (r2 == 2) goto L14;
        if (r2 != 3) goto L12;
        return f13751d;
    L12:
        throw new IllegalArgumentException("Invalid fade mode: " + r2);
    L14:
        return f13750c;
    }
}
