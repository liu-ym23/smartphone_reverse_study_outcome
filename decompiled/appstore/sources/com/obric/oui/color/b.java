package com.obric.oui.color;

import android.graphics.Color;
import com.obric.oui.graphic.BlendMode;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f12898c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f12899a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f12900b;

    static {
        f12898c = new b(0, BlendMode.SRC_OVER);
    }

    public b(int r10, int r11) {
        this.f12899a = r10;
        this.f12900b = r11;
    }

    public static int a(int r10, int r11, float r12) {
        float r13 = 1.0f - r12;
        return Color.argb((int) ((Color.alpha(r10) * r13) + (Color.alpha(r11) * r12)), (int) ((Color.red(r10) * r13) + (Color.red(r11) * r12)), (int) ((Color.green(r10) * r13) + (Color.green(r11) * r12)), (int) ((Color.blue(r10) * r13) + (Color.blue(r11) * r12)));
    }

    public static float b(float r10, float r11, float r12) {
        return Math.max(r11, Math.min(r12, r10));
    }

    public static b[] c(b[] r10) {
        b[] r11 = new b[r10.length];
        int r12 = 0;
    L4:
        if (r12 >= r10.length) goto L6;
        b r13 = r10[r12];
        r11[r12] = new b(r13.f12899a, r13.f12900b);
        r12 = r12 + 1;
        goto L4
    L6:
        return r11;
    }

    public static b e(b r10) {
        if (r10 != null) goto L6;
        return null;
    L6:
        return new b(r10.f12899a, r10.f12900b);
    }

    public static b[] f(b[] r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        b[] r11 = new b[r10.length];
        int r12 = 0;
    L7:
        if (r12 >= r10.length) goto L9;
        r11[r12] = e(r10[r12]);
        r12 = r12 + 1;
        goto L7
    L9:
        return r11;
    }

    public static b[] g(int[] r10) {
        int r11 = 0;
        if (r10 == null) goto L15;
        if (r10.length == 0) goto L15;
        if ((r10.length % 2) != 0) goto L15;
        b[] r12 = new b[r10.length / 2];
        int r13 = 0;
    L11:
        if (r11 >= (r10.length - 1)) goto L13;
        r12[r13] = new b(r10[r11], BlendMode.mapToLegacyObricBlend(r10[r11 + 1]));
        r11 = r11 + 2;
        r13 = r13 + 1;
        goto L11
    L13:
        return r12;
    L15:
        return new b[0];
    }

    public static b j(b r10, b r11, float r12) {
        float r13 = b(r12, 0.0f, 1.0f);
        if (r13 > 0.0f) goto L7;
        return new b(r10.f12899a, r10.f12900b);
    L7:
        if (r13 >= 1.0f) goto L9;
        int r14 = a(r10.f12899a, r11.f12899a, r13);
        int r15 = r10.f12900b;
        int r16 = r11.f12900b;
        if (r15 == r16) goto L18;
        if (r13 < 0.5f) goto L18;
        r15 = r16;
    L18:
        return new b(r14, r15);
    L9:
        return new b(r11.f12899a, r11.f12900b);
    }

    public static b[] k(b[] r10, b[] r11, float r12) {
        float r13 = b(r12, 0.0f, 1.0f);
        if (r13 > 0.0f) goto L7;
        return c(r10);
    L7:
        if (r13 >= 1.0f) goto L9;
        int r14 = Math.max(r10.length, r11.length);
        int r15 = 0;
        if (r14 == 0) goto L13;
        b[] r16 = l(r10, r14);
        b[] r17 = l(r11, r14);
        b[] r18 = new b[r14];
    L15:
        if (r15 >= r14) goto L17;
        r18[r15] = j(r16[r15], r17[r15], r13);
        r15 = r15 + 1;
        goto L15
    L17:
        return r18;
    L13:
        return new b[0];
    L9:
        return c(r11);
    }

    public static b[] l(b[] r10, int r11) {
        if (r10.length != r11) goto L5;
        return r10;
    L5:
        b[] r12 = (b[]) Arrays.copyOf(r10, r11);
        int r13 = r10.length;
    L6:
        if (r13 >= r11) goto L8;
        r12[r13] = new b(0, BlendMode.SRC_OVER);
        r13 = r13 + 1;
        goto L6
    L8:
        return r12;
    }

    public b d() {
        return e(this);
    }

    public int h() {
        return this.f12900b;
    }

    public int i() {
        return this.f12899a;
    }

    public String toString() {
        return String.format(Locale.US, "BlendConfig#%d(color=#%08X, blendMode=%d)", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(this.f12899a), Integer.valueOf(this.f12900b)});
    }

    public b(int r10, BlendMode r11) {
        this(r10, BlendMode.mapToLegacyObricBlend(r11));
    }
}
