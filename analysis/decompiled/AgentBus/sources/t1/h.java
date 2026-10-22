package t1;

import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;

/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final TextPaint f9687a;

    /* renamed from: b, reason: collision with root package name */
    public final TextUtils.TruncateAt f9688b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f9689c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f9690d;

    /* renamed from: e, reason: collision with root package name */
    public final Layout f9691e;

    /* renamed from: f, reason: collision with root package name */
    public final int f9692f;

    /* renamed from: g, reason: collision with root package name */
    public final int f9693g;

    /* renamed from: h, reason: collision with root package name */
    public final int f9694h;

    /* renamed from: i, reason: collision with root package name */
    public final float f9695i;

    /* renamed from: j, reason: collision with root package name */
    public final float f9696j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f9697k;

    /* renamed from: l, reason: collision with root package name */
    public final Paint.FontMetricsInt f9698l;

    /* renamed from: m, reason: collision with root package name */
    public final int f9699m;

    /* renamed from: n, reason: collision with root package name */
    public final u1.h[] f9700n;

    /* renamed from: o, reason: collision with root package name */
    public final Rect f9701o = new Rect();

    /* renamed from: p, reason: collision with root package name */
    public a3.b f9702p;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x023f A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0244  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x02cb  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01d8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public h(java.lang.CharSequence r24, float r25, android.text.TextPaint r26, int r27, android.text.TextUtils.TruncateAt r28, int r29, boolean r30, int r31, int r32, int r33, int r34, int r35, int r36, t1.d r37) {
        /*
            Method dump skipped, instructions count: 762
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: t1.h.<init>(java.lang.CharSequence, float, android.text.TextPaint, int, android.text.TextUtils$TruncateAt, int, boolean, int, int, int, int, int, int, t1.d):void");
    }

    public final int a() {
        boolean z4 = this.f9690d;
        Layout layout = this.f9691e;
        return (z4 ? layout.getLineBottom(this.f9692f - 1) : layout.getHeight()) + this.f9693g + this.f9694h + this.f9699m;
    }

    public final a3.b b() {
        a3.b bVar = this.f9702p;
        if (bVar != null) {
            return bVar;
        }
        a3.b bVar2 = new a3.b(this.f9691e);
        this.f9702p = bVar2;
        return bVar2;
    }

    public final float c(int i2) {
        Paint.FontMetricsInt fontMetricsInt;
        return this.f9693g + ((i2 != this.f9692f + (-1) || (fontMetricsInt = this.f9698l) == null) ? this.f9691e.getLineBaseline(i2) : f(i2) - fontMetricsInt.ascent);
    }

    public final float d(int i2) {
        Paint.FontMetricsInt fontMetricsInt;
        int i10 = this.f9692f;
        int i11 = i10 - 1;
        Layout layout = this.f9691e;
        if (i2 != i11 || (fontMetricsInt = this.f9698l) == null) {
            return this.f9693g + layout.getLineBottom(i2) + (i2 == i10 + (-1) ? this.f9694h : 0);
        }
        return layout.getLineBottom(i2 - 1) + fontMetricsInt.bottom;
    }

    public final int e(int i2) {
        g gVar = i.f9703a;
        Layout layout = this.f9691e;
        return (layout.getEllipsisCount(i2) <= 0 || this.f9688b != TextUtils.TruncateAt.END) ? layout.getLineEnd(i2) : layout.getText().length();
    }

    public final float f(int i2) {
        return this.f9691e.getLineTop(i2) + (i2 == 0 ? 0 : this.f9693g);
    }

    public final float g(int i2, boolean z4) {
        return (this.f9691e.getLineForOffset(i2) == this.f9692f - 1 ? this.f9695i + this.f9696j : 0.0f) + b().j(i2, true, z4);
    }

    public final float h(int i2, boolean z4) {
        return (this.f9691e.getLineForOffset(i2) == this.f9692f + (-1) ? this.f9695i + this.f9696j : 0.0f) + b().j(i2, false, z4);
    }
}
