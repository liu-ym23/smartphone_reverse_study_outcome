package com.obric.oui.c;

import android.R;
import android.util.StateSet;
import com.obric.oui.color.f;
import java.util.Arrays;

/* JADX INFO: compiled from: StrokeStateListCore.java */
/* JADX INFO: loaded from: classes4.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f34326a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int[][] f34327b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final f[] f34328c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final f f34329d;

    static {
        f34326a = new int[]{R.attr.state_enabled};
    }

    private d(int[][] r3, f[] r4, f r5) {
        if (r3.length != r4.length) goto L11;
        if (r3.length == 0) goto L9;
        this.f34327b = r3;
        this.f34328c = r4;
        this.f34329d = r5;
        return;
    L9:
        throw new IllegalArgumentException("stateSpecs must not be empty");
    L11:
        throw new IllegalArgumentException("stateSpecs.size(" + r3.length + ") must equal strokes.size(" + r4.length + ")");
    }

    public f a() {
        return this.f34329d;
    }

    public d b() {
        int[][] r0 = new int[this.f34327b.length][];
        int r1 = 0;
        int r2 = 0;
    L3:
        int[][] r3 = this.f34327b;
        if (r2 >= r3.length) goto L6;
        r0[r2] = Arrays.copyOf(r3[r2], r3[r2].length);
        r2 = r2 + 1;
        goto L3
    L6:
        f[] r4 = new f[this.f34328c.length];
    L7:
        f[] r5 = this.f34328c;
        if (r1 >= r5.length) goto L11;
        r4[r1] = f.a(r5[r1]);
        r1 = r1 + 1;
        goto L7
    L11:
        return new d(r0, r4, f.a(this.f34329d));
    }

    public f a(int[] r4, f r5) {
        int r0 = 0;
    L3:
        int[][] r1 = this.f34327b;
        if (r0 >= r1.length) goto L10;
        if (StateSet.stateSetMatches(r1[r0], r4) == true) goto L8;
        r0 = r0 + 1;
        goto L3
    L8:
        return this.f34328c[r0];
    L10:
        return r5;
    }

    public static f a(f r0, f r1, float r2) {
        return f.a(r0, r1, r2);
    }
}
