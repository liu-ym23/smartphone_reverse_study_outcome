package ld;

import android.R;
import android.util.StateSet;
import com.obric.oui.color.k0;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public final class d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int[] f21941d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int[][] f21942a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k0[] f21943b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final k0 f21944c;

    static {
        f21941d = new int[]{R.attr.state_enabled};
    }

    public d(int[][] r10, k0[] r11, k0 r12) {
        if (r10.length != r11.length) goto L11;
        if (r10.length == 0) goto L9;
        this.f21942a = r10;
        this.f21943b = r11;
        this.f21944c = r12;
        return;
    L9:
        throw new IllegalArgumentException("stateSpecs must not be empty");
    L11:
        throw new IllegalArgumentException("stateSpecs.size(" + r10.length + ") must equal strokes.size(" + r11.length + ")");
    }

    public static k0 c(k0 r10, k0 r11, float r12) {
        return k0.f(r10, r11, r12);
    }

    public static d e(k0 r10, k0 r11, k0 r12, k0 r13, k0 r14, k0 r15) {
        if (f(r10, r11) == false) goto L15;
        if (f(r10, r12) == false) goto L15;
        if (f(r10, r13) == false) goto L15;
        if (f(r10, r14) == false) goto L15;
        if (f(r10, r15) == false) goto L15;
        return g(r10);
    L15:
        return new d(new int[][]{new int[]{R.attr.state_pressed}, new int[]{R.attr.state_hovered}, new int[]{R.attr.state_checked}, new int[]{R.attr.state_activated}, new int[]{-16842910}, new int[]{R.attr.state_enabled}}, new k0[]{r13, r14, r12, r11, r15, r10}, r10);
    }

    public static boolean f(k0 r10, k0 r11) {
        if (r10 != r11) goto L6;
        return true;
    L6:
        if (r10 == null) goto L18;
        if (r11 == null) goto L18;
        if (r10.e() != r11.e()) goto L17;
        if (r10.d() != r11.d()) goto L17;
        if (r10.c() != r11.c()) goto L17;
        return true;
    L17:
        return false;
    L18:
        return false;
    }

    public static d g(k0 r10) {
        return new d(new int[][]{f21941d}, new k0[]{r10}, r10);
    }

    public d a() {
        int[][] r10 = new int[this.f21942a.length][];
        int r11 = 0;
        int r12 = 0;
    L3:
        int[][] r13 = this.f21942a;
        if (r12 >= r13.length) goto L6;
        int[] r14 = r13[r12];
        r10[r12] = Arrays.copyOf(r14, r14.length);
        r12 = r12 + 1;
        goto L3
    L6:
        k0[] r15 = new k0[this.f21943b.length];
    L7:
        k0[] r16 = this.f21943b;
        if (r11 >= r16.length) goto L11;
        r15[r11] = k0.b(r16[r11]);
        r11 = r11 + 1;
        goto L7
    L11:
        return new d(r10, r15, k0.b(this.f21944c));
    }

    public k0 b(int[] r10, k0 r11) {
        int r12 = 0;
    L3:
        int[][] r13 = this.f21942a;
        if (r12 >= r13.length) goto L10;
        if (StateSet.stateSetMatches(r13[r12], r10) == true) goto L8;
        r12 = r12 + 1;
        goto L3
    L8:
        return this.f21943b[r12];
    L10:
        return r11;
    }

    public k0 d() {
        return this.f21944c;
    }
}
