package com.obric.oui.c;

import android.R;
import android.util.StateSet;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;

/* JADX INFO: compiled from: BlendConfigStateListCore.java */
/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f34319a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final com.obric.oui.color.b[] f34320b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int[][] f34321c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.obric.oui.color.b[][] f34322d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.obric.oui.color.b[] f34323e;

    static {
        f34319a = new int[]{R.attr.state_enabled};
        f34320b = new com.obric.oui.color.b[]{new com.obric.oui.color.b(0, com.obric.oui.a.a.f33929d)};
    }

    private b(int[][] r3, com.obric.oui.color.b[][] r4, com.obric.oui.color.b[] r5) {
        if (r3.length != r4.length) goto L11;
        if (r3.length == 0) goto L9;
        this.f34321c = r3;
        this.f34322d = r4;
        this.f34323e = r5;
        return;
    L9:
        throw new IllegalArgumentException("stateSpecs must not be empty");
    L11:
        throw new IllegalArgumentException("stateSpecs.size(" + r3.length + ") must equal configs.size(" + r4.length + ")");
    }

    public com.obric.oui.color.b[] a() {
        return this.f34323e;
    }

    public b b() {
        int[][] r0 = new int[this.f34321c.length][];
        int r1 = 0;
        int r2 = 0;
    L3:
        int[][] r3 = this.f34321c;
        if (r2 >= r3.length) goto L6;
        r0[r2] = Arrays.copyOf(r3[r2], r3[r2].length);
        r2 = r2 + 1;
        goto L3
    L6:
        com.obric.oui.color.b[][] r4 = new com.obric.oui.color.b[this.f34322d.length][];
    L7:
        com.obric.oui.color.b[][] r5 = this.f34322d;
        if (r1 >= r5.length) goto L11;
        r4[r1] = a(r5[r1]);
        r1 = r1 + 1;
        goto L7
    L11:
        return new b(r0, r4, a(this.f34323e));
    }

    public com.obric.oui.color.b[] a(int[] r4, com.obric.oui.color.b[] r5) {
        int r0 = 0;
    L3:
        int[][] r1 = this.f34321c;
        if (r0 >= r1.length) goto L10;
        if (StateSet.stateSetMatches(r1[r0], r4) == true) goto L8;
        r0 = r0 + 1;
        goto L3
    L8:
        return this.f34322d[r0];
    L10:
        return r5;
    }

    public static com.obric.oui.color.b[] a(com.obric.oui.color.b[] r0, com.obric.oui.color.b[] r1, float r2) {
        return com.obric.oui.color.b.a(r0, r1, r2);
    }

    public static b a(com.obric.oui.color.b[] r2, com.obric.oui.color.b[] r3, com.obric.oui.color.b r4) {
        return a(r2, r3, r4, f34320b[0]);
    }

    public static b a(com.obric.oui.color.b[] r2, com.obric.oui.color.b[] r3, com.obric.oui.color.b r4, com.obric.oui.color.b r5) {
        return a(r2, r3, r4, r5, f34320b[0]);
    }

    public static b a(com.obric.oui.color.b[] r6, com.obric.oui.color.b[] r7, com.obric.oui.color.b r8, com.obric.oui.color.b r9, com.obric.oui.color.b r10) {
        return a(r6, r7, r8, r9, r10, r10);
    }

    public static b a(com.obric.oui.color.b[] r4, com.obric.oui.color.b[] r5, com.obric.oui.color.b r6, com.obric.oui.color.b r7, com.obric.oui.color.b r8, com.obric.oui.color.b r9) {
        com.obric.oui.color.b r0 = new com.obric.oui.color.b(0, r6.b());
        com.obric.oui.color.b[] r1 = a(r4, r0);
        com.obric.oui.color.b[] r10 = a(r5, r0);
        com.obric.oui.color.b[] r11 = a(r4, r8);
        com.obric.oui.color.b[] r12 = a(r4, r9);
        com.obric.oui.color.b[] r13 = a(r4, r6);
        com.obric.oui.color.b[] r14 = a(r4, r7);
        return new b(c(), new com.obric.oui.color.b[][]{r12, r12, r11, r11, r13, r14, r12, r11, r10, r1}, r4);
    }

    private static int[][] c() {
        return new int[][]{new int[]{R.attr.state_pressed, R.attr.state_checked}, new int[]{R.attr.state_hovered, R.attr.state_checked}, new int[]{R.attr.state_pressed, R.attr.state_activated}, new int[]{R.attr.state_hovered, R.attr.state_activated}, new int[]{R.attr.state_pressed}, new int[]{R.attr.state_hovered}, new int[]{R.attr.state_checked}, new int[]{R.attr.state_activated}, new int[]{-16842910}, new int[]{R.attr.state_enabled}};
    }

    private static com.obric.oui.color.b[] a(com.obric.oui.color.b[] r3, com.obric.oui.color.b r4) {
        com.obric.oui.color.b[] r0 = (com.obric.oui.color.b[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r3, r3.length + 1), com.obric.oui.color.b[].class, "com.obric.aiagent.plugin");
        r0[r3.length] = r4;
        return r0;
    }

    private static com.obric.oui.color.b[] a(com.obric.oui.color.b[] r3) {
        com.obric.oui.color.b[] r0 = new com.obric.oui.color.b[r3.length];
        int r1 = 0;
    L4:
        if (r1 >= r3.length) goto L6;
        r0[r1] = r3[r1].c();
        r1 = r1 + 1;
        goto L4
    L6:
        return r0;
    }
}
