package w1;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class g extends t1.h {

    /* renamed from: r, reason: collision with root package name */
    public final RectF f6098r;

    public g(t1.n nVar, RectF rectF) {
        super(nVar);
        this.f6098r = rectF;
    }

    @Override // t1.h, android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable() {
        h hVar = new h(this);
        hVar.E = this;
        hVar.invalidateSelf();
        return hVar;
    }

    public g(g gVar) {
        super(gVar);
        this.f6098r = gVar.f6098r;
    }
}
