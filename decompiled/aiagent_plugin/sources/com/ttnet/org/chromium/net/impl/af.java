package com.ttnet.org.chromium.net.impl;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: UrlRequestBase.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class af extends com.ttnet.org.chromium.net.i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final /* synthetic */ boolean f38104b = true;

    static {
    }

    public abstract void a(com.ttnet.org.chromium.net.ag r1, Executor r2);

    public abstract void b(String r1);

    public abstract void c(String r1, String r2);

    public abstract void d(int r1);

    public abstract void e(int r1);

    public abstract void f(int r1);

    public abstract void g(int r1);

    public af() {
    }

    public static int h(int r1) {
        if (f38104b == true) goto L10;
        if (r1 < 0) goto L9;
        if (r1 <= 15) goto L10;
    L9:
        throw new AssertionError();
    L10:
        switch(r1) {
            case 0: goto L41;
            case 1: goto L39;
            case 2: goto L37;
            case 3: goto L35;
            case 4: goto L33;
            case 5: goto L12;
            case 6: goto L31;
            case 7: goto L29;
            case 8: goto L27;
            case 9: goto L25;
            case 10: goto L23;
            case 11: goto L21;
            case 12: goto L19;
            case 13: goto L17;
            case 14: goto L15;
            case 15: goto L13;
            default: goto L12;
        };
    L13:
        return 14;
    L15:
        return 13;
    L17:
        return 12;
    L19:
        return 11;
    L21:
        return 10;
    L23:
        return 9;
    L25:
        return 8;
    L27:
        return 7;
    L29:
        return 6;
    L31:
        return 5;
    L33:
        return 4;
    L35:
        return 3;
    L37:
        return 2;
    L39:
        return 1;
    L41:
        return 0;
    L12:
        throw new IllegalArgumentException("No request status found.");
    }
}
