package com.obric.oui.view;

import android.graphics.Insets;
import android.graphics.Rect;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: Insets.java */
/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f36820a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f36821b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f36822c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f36823d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f36824e;

    static {
        f36820a = new b(0, 0, 0, 0);
    }

    private b(int r1, int r2, int r3, int r4) {
        this.f36821b = r1;
        this.f36822c = r2;
        this.f36823d = r3;
        this.f36824e = r4;
    }

    public static b a(int r1, int r2, int r3, int r4) {
        if (r1 != 0) goto L9;
        if (r2 != 0) goto L9;
        if (r3 != 0) goto L9;
        if (r4 != 0) goto L9;
        return f36820a;
    L9:
        return new b(r1, r2, r3, r4);
    }

    public static b a(Rect r3) {
        return a(r3.left, r3.top, r3.right, r3.bottom);
    }

    public static b a(b r4, b r5) {
        return a(Math.max(r4.f36821b, r5.f36821b), Math.max(r4.f36822c, r5.f36822c), Math.max(r4.f36823d, r5.f36823d), Math.max(r4.f36824e, r5.f36824e));
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L23:
        return false;
    L8:
        if (getClass() != r5.getClass()) goto L23;
        b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
        if (this.f36824e == r6.f36824e) goto L14;
        return false;
    L14:
        if (this.f36821b == r6.f36821b) goto L17;
        return false;
    L17:
        if (this.f36823d == r6.f36823d) goto L20;
        return false;
    L20:
        if (this.f36822c == r6.f36822c) goto L22;
        return false;
    L22:
        return true;
    }

    public int hashCode() {
        return (((((this.f36821b * 31) + this.f36822c) * 31) + this.f36823d) * 31) + this.f36824e;
    }

    public String toString() {
        return "Insets{left=" + this.f36821b + ", top=" + this.f36822c + ", right=" + this.f36823d + ", bottom=" + this.f36824e + '}';
    }

    public static b a(Insets r3) {
        return a(r3.left, r3.top, r3.right, r3.bottom);
    }

    public Insets a() {
        return Insets.of(this.f36821b, this.f36822c, this.f36823d, this.f36824e);
    }
}
