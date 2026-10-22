package H0;

import android.graphics.PointF;
import java.util.ArrayList;
import java.util.Collections;

/* loaded from: classes.dex */
public final class i extends b {

    /* renamed from: g, reason: collision with root package name */
    public final PointF f703g;

    /* renamed from: h, reason: collision with root package name */
    public final b f704h;

    /* renamed from: i, reason: collision with root package name */
    public final b f705i;

    public i(c cVar, c cVar2) {
        super(Collections.emptyList());
        this.f703g = new PointF();
        this.f704h = cVar;
        this.f705i = cVar2;
        h(this.f690d);
    }

    @Override // H0.b
    public final Object e() {
        return this.f703g;
    }

    @Override // H0.b
    public final Object f(Q0.a aVar, float f4) {
        return this.f703g;
    }

    @Override // H0.b
    public final void h(float f4) {
        b bVar = this.f704h;
        bVar.h(f4);
        b bVar2 = this.f705i;
        bVar2.h(f4);
        this.f703g.set(((Float) bVar.e()).floatValue(), ((Float) bVar2.e()).floatValue());
        int i4 = 0;
        while (true) {
            ArrayList arrayList = this.f687a;
            if (i4 >= arrayList.size()) {
                return;
            }
            ((a) arrayList.get(i4)).a();
            i4++;
        }
    }
}
