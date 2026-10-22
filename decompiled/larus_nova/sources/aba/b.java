package aba;

import android.view.SurfaceControl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final b f2514f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2515a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f2516b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f2517c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f2518d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SurfaceControl f2519e;

    public static final class a {
    }

    public b() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.f2515a == r101.f2515a) goto L12;
        return false;
    L12:
        if (this.f2516b == r101.f2516b) goto L15;
        return false;
    L15:
        if (this.f2517c == r101.f2517c) goto L18;
        return false;
    L18:
        if (this.f2518d == r101.f2518d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f2519e, r101.f2519e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f2515a * 31) + this.f2516b) * 31) + this.f2517c) * 31;
        if (this.f2518d == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = (r100 + r101) * 31;
        SurfaceControl r103 = this.f2519e;
        if (r103 != null) goto L9;
        int r104 = 0;
    L11:
        return r102 + r104;
    L9:
        r104 = r103.hashCode();
        goto L11
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "ObricChildListeningSurfaceSnapshot(generation=" + this.f2515a + ", displayId=" + this.f2516b + ", windowType=" + this.f2517c + ", expectsRelativeLayer=" + this.f2518d + ", surface=" + this.f2519e + ')';
    }

    static {
        f2514f = new b(0);
    }

    public /* synthetic */ b(int r100) {
        this(-1, -1, 0, false, null);
    }

    public b(int r100, int r101, int r102, boolean r103, SurfaceControl r104) {
        this.f2515a = r100;
        this.f2516b = r101;
        this.f2517c = r102;
        this.f2518d = r103;
        this.f2519e = r104;
    }
}
