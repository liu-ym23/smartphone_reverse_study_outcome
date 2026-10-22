package y1;

import android.graphics.Matrix;
import android.graphics.Path;
import com.stepos.alphame.utils.Property;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class x {

    /* renamed from: a, reason: collision with root package name */
    public float f16315a;

    /* renamed from: b, reason: collision with root package name */
    public float f16316b;

    /* renamed from: c, reason: collision with root package name */
    public float f16317c;

    /* renamed from: d, reason: collision with root package name */
    public float f16318d;

    /* renamed from: e, reason: collision with root package name */
    public float f16319e;

    /* renamed from: f, reason: collision with root package name */
    public float f16320f;

    /* renamed from: g, reason: collision with root package name */
    public final ArrayList f16321g = new ArrayList();

    /* renamed from: h, reason: collision with root package name */
    public final ArrayList f16322h = new ArrayList();

    public x() {
        d(Property.DEFAULT_FLOAT_VALUE, 270.0f, Property.DEFAULT_FLOAT_VALUE);
    }

    public final void a(float f4) {
        float f5 = this.f16319e;
        if (f5 == f4) {
            return;
        }
        float f6 = ((f4 - f5) + 360.0f) % 360.0f;
        if (f6 > 180.0f) {
            return;
        }
        float f7 = this.f16317c;
        float f8 = this.f16318d;
        t tVar = new t(f7, f8, f7, f8);
        tVar.f16308f = this.f16319e;
        tVar.f16309g = f6;
        this.f16322h.add(new r(tVar));
        this.f16319e = f4;
    }

    public final void b(Matrix matrix, Path path) {
        ArrayList arrayList = this.f16321g;
        int size = arrayList.size();
        for (int i4 = 0; i4 < size; i4++) {
            ((v) arrayList.get(i4)).a(matrix, path);
        }
    }

    public final void c(float f4, float f5) {
        u uVar = new u();
        uVar.f16310b = f4;
        uVar.f16311c = f5;
        this.f16321g.add(uVar);
        s sVar = new s(uVar, this.f16317c, this.f16318d);
        float fB = sVar.b() + 270.0f;
        float fB2 = sVar.b() + 270.0f;
        a(fB);
        this.f16322h.add(sVar);
        this.f16319e = fB2;
        this.f16317c = f4;
        this.f16318d = f5;
    }

    public final void d(float f4, float f5, float f6) {
        this.f16315a = Property.DEFAULT_FLOAT_VALUE;
        this.f16316b = f4;
        this.f16317c = Property.DEFAULT_FLOAT_VALUE;
        this.f16318d = f4;
        this.f16319e = f5;
        this.f16320f = (f5 + f6) % 360.0f;
        this.f16321g.clear();
        this.f16322h.clear();
    }
}
