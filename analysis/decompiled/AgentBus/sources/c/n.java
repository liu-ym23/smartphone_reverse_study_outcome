package c;

import java.util.LinkedHashSet;

/* loaded from: classes.dex */
public final class n extends d3.f {

    /* renamed from: c, reason: collision with root package name */
    public final i5.f f1710c;

    public n(o oVar) {
        i5.f fVar = new i5.f(new m(oVar));
        if (((LinkedHashSet) fVar.f4656j).add(this)) {
            ((d3.g) fVar.f4654h).a(fVar, this, -1);
        }
        this.f1710c = fVar;
    }

    @Override // d3.f
    public final void b(boolean z4) {
    }
}
