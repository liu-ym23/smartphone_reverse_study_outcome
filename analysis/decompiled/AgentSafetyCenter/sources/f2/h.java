package f2;

import android.graphics.Paint;
import android.text.style.LineHeightSpan;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class h implements LineHeightSpan {

    /* renamed from: c, reason: collision with root package name */
    public final float f3877c;

    /* renamed from: f, reason: collision with root package name */
    public final int f3878f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f3879g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f3880h;
    public final float i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f3881j;

    /* renamed from: k, reason: collision with root package name */
    public int f3882k = Integer.MIN_VALUE;

    /* renamed from: l, reason: collision with root package name */
    public int f3883l = Integer.MIN_VALUE;

    /* renamed from: m, reason: collision with root package name */
    public int f3884m = Integer.MIN_VALUE;

    /* renamed from: n, reason: collision with root package name */
    public int f3885n = Integer.MIN_VALUE;

    /* renamed from: o, reason: collision with root package name */
    public int f3886o;

    /* renamed from: p, reason: collision with root package name */
    public int f3887p;

    public h(float f5, int i, boolean z10, boolean z11, float f10, boolean z12) {
        this.f3877c = f5;
        this.f3878f = i;
        this.f3879g = z10;
        this.f3880h = z11;
        this.i = f10;
        this.f3881j = z12;
        if ((0.0f > f10 || f10 > 1.0f) && f10 != -1.0f) {
            i2.a.b("topRatio should be in [0..1] range or -1");
        }
    }

    @Override // android.text.style.LineHeightSpan
    public final void chooseHeight(CharSequence charSequence, int i, int i3, int i10, int i11, Paint.FontMetricsInt fontMetricsInt) {
        int i12 = fontMetricsInt.descent;
        int i13 = fontMetricsInt.ascent;
        if (i12 - i13 <= 0) {
            return;
        }
        boolean z10 = i == 0;
        boolean z11 = i3 == this.f3878f;
        boolean z12 = this.f3880h;
        boolean z13 = this.f3879g;
        if (z10 && z11 && z13 && z12) {
            return;
        }
        if (this.f3882k == Integer.MIN_VALUE) {
            int i14 = i12 - i13;
            int iCeil = (int) Math.ceil(this.f3877c);
            int i15 = iCeil - i14;
            if (!this.f3881j || i15 > 0) {
                float fAbs = this.i;
                if (fAbs == -1.0f) {
                    fAbs = Math.abs(fontMetricsInt.ascent) / (fontMetricsInt.descent - fontMetricsInt.ascent);
                }
                int iCeil2 = (int) (i15 <= 0 ? Math.ceil(i15 * fAbs) : Math.ceil((1.0f - fAbs) * i15));
                int i16 = fontMetricsInt.descent;
                int i17 = iCeil2 + i16;
                this.f3884m = i17;
                int i18 = i17 - iCeil;
                this.f3883l = i18;
                if (z13) {
                    i18 = fontMetricsInt.ascent;
                }
                this.f3882k = i18;
                if (z12) {
                    i17 = i16;
                }
                this.f3885n = i17;
                this.f3886o = fontMetricsInt.ascent - i18;
                this.f3887p = i17 - i16;
            } else {
                int i19 = fontMetricsInt.ascent;
                this.f3883l = i19;
                int i20 = fontMetricsInt.descent;
                this.f3884m = i20;
                this.f3882k = i19;
                this.f3885n = i20;
                this.f3886o = 0;
                this.f3887p = 0;
            }
        }
        fontMetricsInt.ascent = z10 ? this.f3882k : this.f3883l;
        fontMetricsInt.descent = z11 ? this.f3885n : this.f3884m;
    }
}
