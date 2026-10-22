package H0;

import android.view.animation.Interpolator;
import com.stepos.alphame.utils.Property;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: c, reason: collision with root package name */
    public final List f689c;

    /* renamed from: e, reason: collision with root package name */
    public Q0.b f691e;

    /* renamed from: f, reason: collision with root package name */
    public Q0.a f692f;

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f687a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public boolean f688b = false;

    /* renamed from: d, reason: collision with root package name */
    public float f690d = Property.DEFAULT_FLOAT_VALUE;

    public b(List list) {
        this.f689c = list;
    }

    public final void a(a aVar) {
        this.f687a.add(aVar);
    }

    public final Q0.a b() {
        Q0.a aVar = this.f692f;
        if (aVar != null) {
            float f4 = this.f690d;
            if (f4 >= aVar.b() && f4 < aVar.a()) {
                return this.f692f;
            }
        }
        List list = this.f689c;
        Q0.a aVar2 = (Q0.a) B0.g.h(list, 1);
        if (this.f690d < aVar2.b()) {
            for (int size = list.size() - 1; size >= 0; size--) {
                aVar2 = (Q0.a) list.get(size);
                float f5 = this.f690d;
                if (f5 >= aVar2.b() && f5 < aVar2.a()) {
                    break;
                }
            }
        }
        this.f692f = aVar2;
        return aVar2;
    }

    public float c() {
        List list = this.f689c;
        if (list.isEmpty()) {
            return 1.0f;
        }
        return ((Q0.a) B0.g.h(list, 1)).a();
    }

    public final float d() {
        if (this.f688b) {
            return Property.DEFAULT_FLOAT_VALUE;
        }
        Q0.a aVarB = b();
        return aVarB.f1629d == null ? Property.DEFAULT_FLOAT_VALUE : (this.f690d - aVarB.b()) / (aVarB.a() - aVarB.b());
    }

    public Object e() {
        Q0.a aVarB = b();
        Interpolator interpolator = b().f1629d;
        return f(aVarB, interpolator == null ? Property.DEFAULT_FLOAT_VALUE : interpolator.getInterpolation(d()));
    }

    public abstract Object f(Q0.a aVar, float f4);

    public void g() {
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

    public void h(float f4) {
        List list = this.f689c;
        if (f4 < (list.isEmpty() ? 0.0f : ((Q0.a) list.get(0)).b())) {
            f4 = list.isEmpty() ? 0.0f : ((Q0.a) list.get(0)).b();
        } else if (f4 > c()) {
            f4 = c();
        }
        if (f4 == this.f690d) {
            return;
        }
        this.f690d = f4;
        g();
    }

    public final void i(Q0.b bVar) {
        Q0.b bVar2 = this.f691e;
        if (bVar2 != null) {
            bVar2.getClass();
        }
        this.f691e = bVar;
    }
}
