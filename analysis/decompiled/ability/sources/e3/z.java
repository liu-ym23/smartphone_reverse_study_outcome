package e3;

import android.graphics.Matrix;
import android.graphics.Path;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public final class z {

    /* renamed from: a, reason: collision with root package name */
    public float f4376a;
    public float b;
    public float c;
    public float d;
    public float e;
    public float f;
    public final ArrayList g = new ArrayList();
    public final ArrayList h = new ArrayList();

    public z() {
        d(0.0f, 0.0f, 270.0f, 0.0f);
    }

    public final void a(float f) {
        float f7 = this.e;
        if (f7 == f) {
            return;
        }
        float f9 = ((f - f7) + 360.0f) % 360.0f;
        if (f9 > 180.0f) {
            return;
        }
        float f10 = this.c;
        float f11 = this.d;
        v vVar = new v(f10, f11, f10, f11);
        vVar.f = this.e;
        vVar.g = f9;
        this.h.add(new t(vVar));
        this.e = f;
    }

    public final void b(Matrix matrix, Path path) {
        ArrayList arrayList = this.g;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((x) arrayList.get(i)).a(matrix, path);
        }
    }

    public final void c(float f, float f7) {
        w wVar = new w();
        wVar.b = f;
        wVar.c = f7;
        this.g.add(wVar);
        u uVar = new u(wVar, this.c, this.d);
        float fB = uVar.b() + 270.0f;
        float fB2 = uVar.b() + 270.0f;
        a(fB);
        this.h.add(uVar);
        this.e = fB2;
        this.c = f;
        this.d = f7;
    }

    public final void d(float f, float f7, float f9, float f10) {
        this.f4376a = f;
        this.b = f7;
        this.c = f;
        this.d = f7;
        this.e = f9;
        this.f = (f9 + f10) % 360.0f;
        this.g.clear();
        this.h.clear();
    }
}
