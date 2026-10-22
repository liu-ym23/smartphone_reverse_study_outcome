package u1;

import android.graphics.Paint;
import android.text.style.LineHeightSpan;

/* loaded from: classes.dex */
public final class h implements LineHeightSpan {

    /* renamed from: f, reason: collision with root package name */
    public final float f9937f;

    /* renamed from: g, reason: collision with root package name */
    public final int f9938g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f9939h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f9940i;

    /* renamed from: j, reason: collision with root package name */
    public final float f9941j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f9942k;

    /* renamed from: l, reason: collision with root package name */
    public int f9943l = Integer.MIN_VALUE;

    /* renamed from: m, reason: collision with root package name */
    public int f9944m = Integer.MIN_VALUE;

    /* renamed from: n, reason: collision with root package name */
    public int f9945n = Integer.MIN_VALUE;

    /* renamed from: o, reason: collision with root package name */
    public int f9946o = Integer.MIN_VALUE;

    /* renamed from: p, reason: collision with root package name */
    public int f9947p;

    /* renamed from: q, reason: collision with root package name */
    public int f9948q;

    public h(float f10, int i2, boolean z4, boolean z10, float f11, boolean z11) {
        this.f9937f = f10;
        this.f9938g = i2;
        this.f9939h = z4;
        this.f9940i = z10;
        this.f9941j = f11;
        this.f9942k = z11;
        if ((0.0f > f11 || f11 > 1.0f) && f11 != -1.0f) {
            x1.a.b("topRatio should be in [0..1] range or -1");
        }
    }

    @Override // android.text.style.LineHeightSpan
    public final void chooseHeight(CharSequence charSequence, int i2, int i10, int i11, int i12, Paint.FontMetricsInt fontMetricsInt) {
        int i13 = fontMetricsInt.descent;
        int i14 = fontMetricsInt.ascent;
        if (i13 - i14 <= 0) {
            return;
        }
        boolean z4 = i2 == 0;
        boolean z10 = i10 == this.f9938g;
        boolean z11 = this.f9940i;
        boolean z12 = this.f9939h;
        if (z4 && z10 && z12 && z11) {
            return;
        }
        if (this.f9943l == Integer.MIN_VALUE) {
            int i15 = i13 - i14;
            int iCeil = (int) Math.ceil(this.f9937f);
            int i16 = iCeil - i15;
            if (!this.f9942k || i16 > 0) {
                float fAbs = this.f9941j;
                if (fAbs == -1.0f) {
                    fAbs = Math.abs(fontMetricsInt.ascent) / (fontMetricsInt.descent - fontMetricsInt.ascent);
                }
                int iCeil2 = (int) (i16 <= 0 ? Math.ceil(i16 * fAbs) : Math.ceil((1.0f - fAbs) * i16));
                int i17 = fontMetricsInt.descent;
                int i18 = iCeil2 + i17;
                this.f9945n = i18;
                int i19 = i18 - iCeil;
                this.f9944m = i19;
                if (z12) {
                    i19 = fontMetricsInt.ascent;
                }
                this.f9943l = i19;
                if (z11) {
                    i18 = i17;
                }
                this.f9946o = i18;
                this.f9947p = fontMetricsInt.ascent - i19;
                this.f9948q = i18 - i17;
            } else {
                int i20 = fontMetricsInt.ascent;
                this.f9944m = i20;
                int i21 = fontMetricsInt.descent;
                this.f9945n = i21;
                this.f9943l = i20;
                this.f9946o = i21;
                this.f9947p = 0;
                this.f9948q = 0;
            }
        }
        fontMetricsInt.ascent = z4 ? this.f9943l : this.f9944m;
        fontMetricsInt.descent = z10 ? this.f9946o : this.f9945n;
    }
}
