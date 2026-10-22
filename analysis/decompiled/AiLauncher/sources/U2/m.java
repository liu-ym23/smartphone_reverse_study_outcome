package U2;

import U2.b;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import com.google.android.material.R$drawable;

/* loaded from: classes2.dex */
public final class m<S extends b> extends j {

    /* renamed from: r, reason: collision with root package name */
    public k<S> f6284r;

    /* renamed from: s, reason: collision with root package name */
    public l<ObjectAnimator> f6285s;

    /* renamed from: t, reason: collision with root package name */
    public Drawable f6286t;

    public m(Context context, b bVar, k<S> kVar, l<ObjectAnimator> lVar) {
        super(context, bVar);
        A(kVar);
        z(lVar);
    }

    public static m<f> v(Context context, f fVar, c cVar) {
        m<f> mVar = new m<>(context, fVar, cVar, fVar.f6226o == 1 ? new e(context, fVar) : new d(fVar));
        mVar.B(q1.f.b(context.getResources(), R$drawable.ic_mtrl_arrow_circle, null));
        return mVar;
    }

    public void A(k<S> kVar) {
        this.f6284r = kVar;
    }

    public void B(Drawable drawable) {
        this.f6286t = drawable;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00d9  */
    @Override // android.graphics.drawable.Drawable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void draw(android.graphics.Canvas r14) {
        /*
            Method dump skipped, instructions count: 290
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: U2.m.draw(android.graphics.Canvas):void");
    }

    @Override // U2.j, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getAlpha() {
        return super.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f6284r.e();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f6284r.f();
    }

    @Override // U2.j, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getOpacity() {
        return super.getOpacity();
    }

    @Override // U2.j, android.graphics.drawable.Animatable
    public /* bridge */ /* synthetic */ boolean isRunning() {
        return super.isRunning();
    }

    @Override // U2.j
    public /* bridge */ /* synthetic */ boolean j() {
        return super.j();
    }

    @Override // U2.j
    public /* bridge */ /* synthetic */ boolean l() {
        return super.l();
    }

    @Override // U2.j
    public /* bridge */ /* synthetic */ boolean m() {
        return super.m();
    }

    @Override // U2.j
    public /* bridge */ /* synthetic */ void o(q1.b bVar) {
        super.o(bVar);
    }

    @Override // U2.j
    public /* bridge */ /* synthetic */ boolean s(boolean z10, boolean z11, boolean z12) {
        return super.s(z10, z11, z12);
    }

    @Override // U2.j, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setAlpha(int i10) {
        super.setAlpha(i10);
    }

    @Override // U2.j, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(ColorFilter colorFilter) {
        super.setColorFilter(colorFilter);
    }

    @Override // U2.j, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setVisible(boolean z10, boolean z11) {
        return super.setVisible(z10, z11);
    }

    @Override // U2.j, android.graphics.drawable.Animatable
    public /* bridge */ /* synthetic */ void start() {
        super.start();
    }

    @Override // U2.j, android.graphics.drawable.Animatable
    public /* bridge */ /* synthetic */ void stop() {
        super.stop();
    }

    @Override // U2.j
    public boolean t(boolean z10, boolean z11, boolean z12) {
        Drawable drawable;
        boolean zT = super.t(z10, z11, z12);
        if (y() && (drawable = this.f6286t) != null) {
            return drawable.setVisible(z10, z11);
        }
        if (!isRunning()) {
            this.f6285s.a();
        }
        if (!z10 || !z12) {
            return zT;
        }
        this.f6285s.g();
        return zT;
    }

    @Override // U2.j
    public /* bridge */ /* synthetic */ boolean u(q1.b bVar) {
        return super.u(bVar);
    }

    public l<ObjectAnimator> w() {
        return this.f6285s;
    }

    public k<S> x() {
        return this.f6284r;
    }

    public final boolean y() {
        a aVar = this.f6249c;
        return aVar != null && aVar.a(this.f6247a.getContentResolver()) == 0.0f;
    }

    public void z(l<ObjectAnimator> lVar) {
        this.f6285s = lVar;
        lVar.e(this);
    }
}
