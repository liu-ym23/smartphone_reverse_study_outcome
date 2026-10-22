package d5;

import android.graphics.Paint;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class i extends l {

    /* renamed from: d, reason: collision with root package name */
    public b2.a f3210d;

    /* renamed from: e, reason: collision with root package name */
    public float f3211e;

    /* renamed from: f, reason: collision with root package name */
    public b2.a f3212f;

    /* renamed from: g, reason: collision with root package name */
    public float f3213g;

    /* renamed from: h, reason: collision with root package name */
    public float f3214h;
    public float i;

    /* renamed from: j, reason: collision with root package name */
    public float f3215j;

    /* renamed from: k, reason: collision with root package name */
    public float f3216k;

    /* renamed from: l, reason: collision with root package name */
    public Paint.Cap f3217l;

    /* renamed from: m, reason: collision with root package name */
    public Paint.Join f3218m;

    /* renamed from: n, reason: collision with root package name */
    public float f3219n;

    @Override // d5.k
    public final boolean a() {
        return this.f3212f.i() || this.f3210d.i();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001e  */
    @Override // d5.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean b(int[] r6) {
        /*
            r5 = this;
            b2.a r0 = r5.f3212f
            boolean r1 = r0.i()
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L1e
            java.lang.Object r1 = r0.f1862d
            android.content.res.ColorStateList r1 = (android.content.res.ColorStateList) r1
            int r4 = r1.getDefaultColor()
            int r1 = r1.getColorForState(r6, r4)
            int r4 = r0.f1860b
            if (r1 == r4) goto L1e
            r0.f1860b = r1
            r0 = r2
            goto L1f
        L1e:
            r0 = r3
        L1f:
            b2.a r5 = r5.f3210d
            boolean r1 = r5.i()
            if (r1 == 0) goto L3a
            java.lang.Object r1 = r5.f1862d
            android.content.res.ColorStateList r1 = (android.content.res.ColorStateList) r1
            int r4 = r1.getDefaultColor()
            int r6 = r1.getColorForState(r6, r4)
            int r1 = r5.f1860b
            if (r6 == r1) goto L3a
            r5.f1860b = r6
            goto L3b
        L3a:
            r2 = r3
        L3b:
            r5 = r0 | r2
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: d5.i.b(int[]):boolean");
    }

    public float getFillAlpha() {
        return this.f3214h;
    }

    public int getFillColor() {
        return this.f3212f.f1860b;
    }

    public float getStrokeAlpha() {
        return this.f3213g;
    }

    public int getStrokeColor() {
        return this.f3210d.f1860b;
    }

    public float getStrokeWidth() {
        return this.f3211e;
    }

    public float getTrimPathEnd() {
        return this.f3215j;
    }

    public float getTrimPathOffset() {
        return this.f3216k;
    }

    public float getTrimPathStart() {
        return this.i;
    }

    public void setFillAlpha(float f5) {
        this.f3214h = f5;
    }

    public void setFillColor(int i) {
        this.f3212f.f1860b = i;
    }

    public void setStrokeAlpha(float f5) {
        this.f3213g = f5;
    }

    public void setStrokeColor(int i) {
        this.f3210d.f1860b = i;
    }

    public void setStrokeWidth(float f5) {
        this.f3211e = f5;
    }

    public void setTrimPathEnd(float f5) {
        this.f3215j = f5;
    }

    public void setTrimPathOffset(float f5) {
        this.f3216k = f5;
    }

    public void setTrimPathStart(float f5) {
        this.i = f5;
    }
}
