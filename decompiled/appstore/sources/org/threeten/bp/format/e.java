package org.threeten.bp.format;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes4.dex */
public final class e {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final e f23207e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ConcurrentMap f23208f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final char f23209a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final char f23210b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final char f23211c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final char f23212d;

    static {
        f23207e = new e('0', '+', '-', '.');
        f23208f = new ConcurrentHashMap(16, 0.75f, 2);
    }

    public e(char r10, char r11, char r12, char r13) {
        this.f23209a = r10;
        this.f23210b = r11;
        this.f23211c = r12;
        this.f23212d = r13;
    }

    public String a(String r10) {
        char r11 = this.f23209a;
        if (r11 != '0') goto L5;
        return r10;
    L5:
        int r12 = r11 - '0';
        char[] r13 = r10.toCharArray();
        int r14 = 0;
    L7:
        if (r14 >= r13.length) goto L10;
        r13[r14] = (char) (r13[r14] + r12);
        r14 = r14 + 1;
        goto L7
    L10:
        return new String(r13);
    }

    public int b(char r10) {
        int r11 = r10 - this.f23209a;
        if (r11 >= 0) goto L5;
    L7:
        return -1;
    L5:
        if (r11 > 9) goto L7;
        return r11;
    }

    public char c() {
        return this.f23212d;
    }

    public char d() {
        return this.f23211c;
    }

    public char e() {
        return this.f23210b;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof e) == false) goto L18;
        e r11 = (e) r10;
        if (this.f23209a != r11.f23209a) goto L17;
        if (this.f23210b != r11.f23210b) goto L17;
        if (this.f23211c != r11.f23211c) goto L17;
        if (this.f23212d != r11.f23212d) goto L17;
        return true;
    L17:
        return false;
    L18:
        return false;
    }

    public char f() {
        return this.f23209a;
    }

    public int hashCode() {
        return ((this.f23209a + this.f23210b) + this.f23211c) + this.f23212d;
    }

    public String toString() {
        return "DecimalStyle[" + this.f23209a + this.f23210b + this.f23211c + this.f23212d + "]";
    }
}
