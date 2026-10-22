package org.c.a.j;

import java.util.Arrays;

/* JADX INFO: compiled from: Constant.java */
/* JADX INFO: loaded from: classes5.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f40482a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f40483b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f40484c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f40485d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f40486e = null;
    public static final a f = null;
    public static final a g = null;
    boolean[] h;
    boolean i;
    private String j;

    static {
        f40482a = new a("\n\u0085\u2028\u2029");
        f40483b = new a("\u0000\r\n\u0085\u2028\u2029");
        f40484c = new a(" \u0000\r\n\u0085\u2028\u2029");
        f40485d = new a("\t \u0000\r\n\u0085\u2028\u2029");
        f40486e = new a("\u0000 \t");
        f = new a("abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-_-;/?:@&=+$,_.!~*'()[]%");
        g = new a("abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-_");
    }

    private a(String r7) {
        boolean[] r1 = new boolean[128];
        this.h = r1;
        int r2 = 0;
        this.i = false;
        Arrays.fill(r1, false);
        StringBuilder r3 = new StringBuilder();
    L4:
        if (r2 >= r7.length()) goto L11;
        int r4 = r7.codePointAt(r2);
        if (r4 >= 128) goto L8;
        this.h[r4] = true;
    L9:
        r2 = r2 + 1;
        goto L4
    L8:
        r3.appendCodePoint(r4);
        goto L9
    L11:
        if (r3.length() <= 0) goto L17;
        this.i = true;
        this.j = r3.toString();
        return;
    }

    public boolean a(int r3) {
        if (r3 >= 128) goto L6;
        return this.h[r3];
    L6:
        if (this.i == true) goto L8;
        return false;
    L8:
        if (this.j.indexOf(r3, 0) == (-1)) goto L13;
        return true;
    L13:
        return false;
    }

    public boolean b(int r1) {
        return !a(r1);
    }

    public boolean a(int r2, String r3) {
        if (a(r2) == false) goto L5;
    L6:
        return true;
    L5:
        if (r3.indexOf(r2, 0) != (-1)) goto L6;
        return false;
    }

    public boolean b(int r1, String r2) {
        return !a(r1, r2);
    }
}
