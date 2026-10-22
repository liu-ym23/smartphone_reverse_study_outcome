package ld;

import android.R;
import android.util.StateSet;
import com.obric.oui.graphic.BlendMode;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int[] f21934d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final com.obric.oui.color.b[] f21935e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int[][] f21936a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.obric.oui.color.b[][] f21937b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.obric.oui.color.b[] f21938c;

    static {
        f21934d = new int[]{R.attr.state_enabled};
        f21935e = new com.obric.oui.color.b[]{new com.obric.oui.color.b(0, BlendMode.SRC_OVER)};
    }

    public b(int[][] r10, com.obric.oui.color.b[][] r11, com.obric.oui.color.b[] r12) {
        if (r10.length != r11.length) goto L11;
        if (r10.length == 0) goto L9;
        this.f21936a = r10;
        this.f21937b = r11;
        this.f21938c = r12;
        return;
    L9:
        throw new IllegalArgumentException("stateSpecs must not be empty");
    L11:
        throw new IllegalArgumentException("stateSpecs.size(" + r10.length + ") must equal configs.size(" + r11.length + ")");
    }

    public static com.obric.oui.color.b[] a(com.obric.oui.color.b[] r10, com.obric.oui.color.b r11) {
        com.obric.oui.color.b[] r12 = (com.obric.oui.color.b[]) Arrays.copyOf(r10, r10.length + 1);
        r12[r10.length] = r11;
        return r12;
    }

    public static com.obric.oui.color.b[] b(com.obric.oui.color.b[] r10) {
        com.obric.oui.color.b[] r11 = new com.obric.oui.color.b[r10.length];
        int r12 = 0;
    L4:
        if (r12 >= r10.length) goto L6;
        r11[r12] = r10[r12].d();
        r12 = r12 + 1;
        goto L4
    L6:
        return r11;
    }

    public static com.obric.oui.color.b[] e(com.obric.oui.color.b[] r10, com.obric.oui.color.b[] r11, float r12) {
        return com.obric.oui.color.b.k(r10, r11, r12);
    }

    public static int[][] g() {
        return new int[][]{new int[]{R.attr.state_pressed, R.attr.state_checked}, new int[]{R.attr.state_hovered, R.attr.state_checked}, new int[]{R.attr.state_pressed, R.attr.state_activated}, new int[]{R.attr.state_hovered, R.attr.state_activated}, new int[]{R.attr.state_pressed}, new int[]{R.attr.state_hovered}, new int[]{R.attr.state_checked}, new int[]{R.attr.state_activated}, new int[]{-16842910}, new int[]{R.attr.state_enabled}};
    }

    public static b h(int[][] r10, com.obric.oui.color.b[][] r11) {
        if (r10.length != r11.length) goto L21;
        if (r10.length == 0) goto L19;
        int r12 = 0;
    L8:
        if (r12 >= r10.length) goto L13;
        if (r10[r12].length == 0) goto L11;
        r12 = r12 + 1;
        goto L8
    L11:
        com.obric.oui.color.b[] r13 = r11[r12];
    L14:
        if (r13 != null) goto L17;
        r13 = r11[0];
    L17:
        return new b(r10, r11, r13);
    L13:
        r13 = null;
        goto L14
    L19:
        throw new IllegalArgumentException("states must not be empty");
    L21:
        throw new IllegalArgumentException("states.size(" + r10.length + ") must equal configs.size(" + r11.length + ")");
    }

    public static b i(com.obric.oui.color.b[] r10, com.obric.oui.color.b[] r11, com.obric.oui.color.b r12) {
        return j(r10, r11, r12, f21935e[0]);
    }

    public static b j(com.obric.oui.color.b[] r10, com.obric.oui.color.b[] r11, com.obric.oui.color.b r12, com.obric.oui.color.b r13) {
        return k(r10, r11, r12, r13, f21935e[0]);
    }

    public static b k(com.obric.oui.color.b[] r10, com.obric.oui.color.b[] r11, com.obric.oui.color.b r12, com.obric.oui.color.b r13, com.obric.oui.color.b r14) {
        return l(r10, r11, r12, r13, r14, r14);
    }

    public static b l(com.obric.oui.color.b[] r14, com.obric.oui.color.b[] r15, com.obric.oui.color.b r16, com.obric.oui.color.b r17, com.obric.oui.color.b r18, com.obric.oui.color.b r19) {
        com.obric.oui.color.b r10 = new com.obric.oui.color.b(0, r16.h());
        com.obric.oui.color.b[] r13 = a(r14, r10);
        com.obric.oui.color.b[] r12 = a(r15, r10);
        com.obric.oui.color.b[] r11 = a(r14, r18);
        com.obric.oui.color.b[] r110 = a(r14, r19);
        com.obric.oui.color.b[] r20 = a(r14, r16);
        com.obric.oui.color.b[] r21 = a(r14, r17);
        return new b(g(), new com.obric.oui.color.b[][]{r110, r110, r11, r11, r20, r21, r110, r11, r12, r13}, r14);
    }

    public static b m(com.obric.oui.color.b[] r10) {
        return new b(new int[][]{f21934d}, new com.obric.oui.color.b[][]{r10}, r10);
    }

    public b c() {
        int[][] r10 = new int[this.f21936a.length][];
        int r11 = 0;
        int r12 = 0;
    L3:
        int[][] r13 = this.f21936a;
        if (r12 >= r13.length) goto L6;
        int[] r14 = r13[r12];
        r10[r12] = Arrays.copyOf(r14, r14.length);
        r12 = r12 + 1;
        goto L3
    L6:
        com.obric.oui.color.b[][] r15 = new com.obric.oui.color.b[this.f21937b.length][];
    L7:
        com.obric.oui.color.b[][] r16 = this.f21937b;
        if (r11 >= r16.length) goto L11;
        r15[r11] = b(r16[r11]);
        r11 = r11 + 1;
        goto L7
    L11:
        return new b(r10, r15, b(this.f21938c));
    }

    public com.obric.oui.color.b[] d(int[] r10, com.obric.oui.color.b[] r11) {
        int r12 = 0;
    L3:
        int[][] r13 = this.f21936a;
        if (r12 >= r13.length) goto L10;
        if (StateSet.stateSetMatches(r13[r12], r10) == true) goto L8;
        r12 = r12 + 1;
        goto L3
    L8:
        return this.f21937b[r12];
    L10:
        return r11;
    }

    public com.obric.oui.color.b[] f() {
        return this.f21938c;
    }
}
