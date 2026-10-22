package p0;

import android.graphics.Paint;
import androidx.annotation.ColorInt;

/* loaded from: classes.dex */
public final class h extends k {

    /* renamed from: e, reason: collision with root package name */
    public C.d f13858e;

    /* renamed from: f, reason: collision with root package name */
    public float f13859f;

    /* renamed from: g, reason: collision with root package name */
    public C.d f13860g;

    /* renamed from: h, reason: collision with root package name */
    public float f13861h;

    /* renamed from: i, reason: collision with root package name */
    public float f13862i;

    /* renamed from: j, reason: collision with root package name */
    public float f13863j;

    /* renamed from: k, reason: collision with root package name */
    public float f13864k;

    /* renamed from: l, reason: collision with root package name */
    public float f13865l;

    /* renamed from: m, reason: collision with root package name */
    public Paint.Cap f13866m;

    /* renamed from: n, reason: collision with root package name */
    public Paint.Join f13867n;

    /* renamed from: o, reason: collision with root package name */
    public float f13868o;

    @Override // p0.j
    public final boolean a() {
        return this.f13860g.b() || this.f13858e.b();
    }

    @Override // p0.j
    public final boolean b(int[] iArr) {
        return this.f13858e.c(iArr) | this.f13860g.c(iArr);
    }

    public float getFillAlpha() {
        return this.f13862i;
    }

    @ColorInt
    public int getFillColor() {
        return this.f13860g.f251a;
    }

    public float getStrokeAlpha() {
        return this.f13861h;
    }

    @ColorInt
    public int getStrokeColor() {
        return this.f13858e.f251a;
    }

    public float getStrokeWidth() {
        return this.f13859f;
    }

    public float getTrimPathEnd() {
        return this.f13864k;
    }

    public float getTrimPathOffset() {
        return this.f13865l;
    }

    public float getTrimPathStart() {
        return this.f13863j;
    }

    public void setFillAlpha(float f4) {
        this.f13862i = f4;
    }

    public void setFillColor(int i4) {
        this.f13860g.f251a = i4;
    }

    public void setStrokeAlpha(float f4) {
        this.f13861h = f4;
    }

    public void setStrokeColor(int i4) {
        this.f13858e.f251a = i4;
    }

    public void setStrokeWidth(float f4) {
        this.f13859f = f4;
    }

    public void setTrimPathEnd(float f4) {
        this.f13864k = f4;
    }

    public void setTrimPathOffset(float f4) {
        this.f13865l = f4;
    }

    public void setTrimPathStart(float f4) {
        this.f13863j = f4;
    }
}
