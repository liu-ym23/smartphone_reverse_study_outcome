package androidx.core.graphics;

import android.graphics.Insets;
import android.graphics.Rect;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: Insets.java */
/* JADX INFO: loaded from: classes.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f1209a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1210b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f1211c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f1212d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f1213e;

    /* JADX INFO: compiled from: Insets.java */
    static class a {
        static Insets a(int r0, int r1, int r2, int r3) {
            return Insets.of(r0, r1, r2, r3);
        }
    }

    static {
        f1209a = new g(0, 0, 0, 0);
    }

    private g(int r1, int r2, int r3, int r4) {
        this.f1210b = r1;
        this.f1211c = r2;
        this.f1212d = r3;
        this.f1213e = r4;
    }

    public static g a(int r1, int r2, int r3, int r4) {
        if (r1 != 0) goto L9;
        if (r2 != 0) goto L9;
        if (r3 != 0) goto L9;
        if (r4 != 0) goto L9;
        return f1209a;
    L9:
        return new g(r1, r2, r3, r4);
    }

    public static g a(Rect r3) {
        return a(r3.left, r3.top, r3.right, r3.bottom);
    }

    public static g a(g r4, g r5) {
        return a(Math.max(r4.f1210b, r5.f1210b), Math.max(r4.f1211c, r5.f1211c), Math.max(r4.f1212d, r5.f1212d), Math.max(r4.f1213e, r5.f1213e));
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
        g r6 = (g) ZeusTransformUtils.preCheckCast(r5, g.class, "com.obric.aiagent.plugin");
        if (this.f1213e == r6.f1213e) goto L14;
        return false;
    L14:
        if (this.f1210b == r6.f1210b) goto L17;
        return false;
    L17:
        if (this.f1212d == r6.f1212d) goto L20;
        return false;
    L20:
        if (this.f1211c == r6.f1211c) goto L22;
        return false;
    L22:
        return true;
    }

    public int hashCode() {
        return (((((this.f1210b * 31) + this.f1211c) * 31) + this.f1212d) * 31) + this.f1213e;
    }

    public String toString() {
        return "Insets{left=" + this.f1210b + ", top=" + this.f1211c + ", right=" + this.f1212d + ", bottom=" + this.f1213e + '}';
    }

    public static g a(Insets r3) {
        return a(r3.left, r3.top, r3.right, r3.bottom);
    }

    public Insets a() {
        return a.a(this.f1210b, this.f1211c, this.f1212d, this.f1213e);
    }
}
