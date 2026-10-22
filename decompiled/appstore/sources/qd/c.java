package qd;

import android.graphics.LinearGradient;
import android.text.TextUtils;
import java.util.Arrays;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CharSequence f23644a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CharSequence f23645b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final char[] f23646c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float[] f23647d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f23648e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextUtils.TruncateAt f23649f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f23650g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f23651h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f23652i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public LinearGradient f23653j;

    public c(CharSequence r10, CharSequence r11, char[] r12, float[] r13, float r14, TextUtils.TruncateAt r15, float r16, float r17, float r18, LinearGradient r19) {
        q.g(r10, "text");
        q.g(r11, "displayText");
        q.g(r12, "chars");
        q.g(r13, "widths");
        this.f23644a = r10;
        this.f23645b = r11;
        this.f23646c = r12;
        this.f23647d = r13;
        this.f23648e = r14;
        this.f23649f = r15;
        this.f23650g = r16;
        this.f23651h = r17;
        this.f23652i = r18;
        this.f23653j = r19;
    }

    public final float a() {
        return this.f23652i;
    }

    public final float b() {
        return this.f23651h;
    }

    public final char[] c() {
        return this.f23646c;
    }

    public final float d() {
        return this.f23648e;
    }

    public final TextUtils.TruncateAt e() {
        return this.f23649f;
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof c) == true) goto L8;
        return false;
    L8:
        c r11 = (c) r10;
        if (q.b(this.f23644a, r11.f23644a) == false) goto L30;
        if (q.b(this.f23645b, r11.f23645b) == false) goto L30;
        if (Arrays.equals(this.f23646c, r11.f23646c) == false) goto L30;
        if (Arrays.equals(this.f23647d, r11.f23647d) == false) goto L30;
        if (this.f23648e != r11.f23648e) goto L30;
        if (this.f23649f != r11.f23649f) goto L30;
        if (this.f23650g != r11.f23650g) goto L30;
        if (this.f23651h != r11.f23651h) goto L30;
        if (this.f23652i != r11.f23652i) goto L30;
        if (q.b(this.f23653j, r11.f23653j) == false) goto L30;
        return true;
    L30:
        return false;
    }

    public final LinearGradient f() {
        return this.f23653j;
    }

    public final CharSequence g() {
        return this.f23644a;
    }

    public final float h() {
        return this.f23650g;
    }

    public int hashCode() {
        int r10 = ((((((((this.f23644a.hashCode() * 31) + this.f23645b.hashCode()) * 31) + Arrays.hashCode(this.f23646c)) * 31) + Arrays.hashCode(this.f23647d)) * 31) + Float.hashCode(this.f23648e)) * 31;
        TextUtils.TruncateAt r11 = this.f23649f;
        int r12 = 0;
        if (r11 != null) goto L5;
        int r13 = 0;
    L6:
        int r14 = (((((((r10 + r13) * 31) + Float.hashCode(this.f23650g)) * 31) + Float.hashCode(this.f23651h)) * 31) + Float.hashCode(this.f23652i)) * 31;
        LinearGradient r15 = this.f23653j;
        if (r15 == null) goto L11;
        r12 = r15.hashCode();
    L11:
        return r14 + r12;
    L5:
        r13 = r11.hashCode();
        goto L6
    }

    public final void i(float r10) {
        this.f23652i = r10;
    }

    public final void j(float r10) {
        this.f23651h = r10;
    }

    public final void k(LinearGradient r10) {
        this.f23653j = r10;
    }

    public String toString() {
        return "TextLayoutCache(text=" + this.f23644a + ", displayText=" + this.f23645b + ", chars=" + Arrays.toString(this.f23646c) + ", widths=" + Arrays.toString(this.f23647d) + ", contentWidth=" + this.f23648e + ", ellipsize=" + this.f23649f + ", textSizePx=" + this.f23650g + ", baseTotalWidth=" + this.f23651h + ", baseStartX=" + this.f23652i + ", gradientShader=" + this.f23653j + ')';
    }
}
