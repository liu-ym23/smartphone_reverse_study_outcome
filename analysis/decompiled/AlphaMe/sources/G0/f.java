package G0;

import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.v;
import com.airbnb.lottie.z;
import com.stepos.alphame.utils.Property;
import f1.AbstractC0557a;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class f implements m, H0.a, k {

    /* renamed from: a, reason: collision with root package name */
    public final Path f491a = new Path();

    /* renamed from: b, reason: collision with root package name */
    public final String f492b;

    /* renamed from: c, reason: collision with root package name */
    public final v f493c;

    /* renamed from: d, reason: collision with root package name */
    public final H0.b f494d;

    /* renamed from: e, reason: collision with root package name */
    public final H0.b f495e;

    /* renamed from: f, reason: collision with root package name */
    public final L0.a f496f;

    /* renamed from: g, reason: collision with root package name */
    public s f497g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f498h;

    public f(v vVar, M0.b bVar, L0.a aVar) {
        this.f492b = aVar.f1147a;
        this.f493c = vVar;
        H0.b bVarC = aVar.f1149c.c();
        this.f494d = bVarC;
        H0.b bVarC2 = aVar.f1148b.c();
        this.f495e = bVarC2;
        this.f496f = aVar;
        bVar.c(bVarC);
        bVar.c(bVarC2);
        bVarC.a(this);
        bVarC2.a(this);
    }

    @Override // H0.a
    public final void a() {
        this.f498h = false;
        this.f493c.invalidateSelf();
    }

    @Override // G0.c
    public final void b(List list, List list2) {
        int i4 = 0;
        while (true) {
            ArrayList arrayList = (ArrayList) list;
            if (i4 >= arrayList.size()) {
                return;
            }
            c cVar = (c) arrayList.get(i4);
            if (cVar instanceof s) {
                s sVar = (s) cVar;
                if (sVar.f580b == 1) {
                    this.f497g = sVar;
                    sVar.c(this);
                }
            }
            i4++;
        }
    }

    @Override // G0.m
    public final Path e() {
        boolean z4 = this.f498h;
        Path path = this.f491a;
        if (z4) {
            return path;
        }
        path.reset();
        PointF pointF = (PointF) this.f494d.e();
        float f4 = pointF.x / 2.0f;
        float f5 = pointF.y / 2.0f;
        float f6 = f4 * 0.55228f;
        float f7 = f5 * 0.55228f;
        path.reset();
        if (this.f496f.f1150d) {
            float f8 = -f5;
            path.moveTo(Property.DEFAULT_FLOAT_VALUE, f8);
            float f9 = Property.DEFAULT_FLOAT_VALUE - f6;
            float f10 = -f4;
            float f11 = Property.DEFAULT_FLOAT_VALUE - f7;
            path.cubicTo(f9, f8, f10, f11, f10, Property.DEFAULT_FLOAT_VALUE);
            float f12 = f7 + Property.DEFAULT_FLOAT_VALUE;
            path.cubicTo(f10, f12, f9, f5, Property.DEFAULT_FLOAT_VALUE, f5);
            float f13 = f6 + Property.DEFAULT_FLOAT_VALUE;
            path.cubicTo(f13, f5, f4, f12, f4, Property.DEFAULT_FLOAT_VALUE);
            path.cubicTo(f4, f11, f13, f8, Property.DEFAULT_FLOAT_VALUE, f8);
        } else {
            float f14 = -f5;
            path.moveTo(Property.DEFAULT_FLOAT_VALUE, f14);
            float f15 = f6 + Property.DEFAULT_FLOAT_VALUE;
            float f16 = Property.DEFAULT_FLOAT_VALUE - f7;
            path.cubicTo(f15, f14, f4, f16, f4, Property.DEFAULT_FLOAT_VALUE);
            float f17 = f7 + Property.DEFAULT_FLOAT_VALUE;
            path.cubicTo(f4, f17, f15, f5, Property.DEFAULT_FLOAT_VALUE, f5);
            float f18 = Property.DEFAULT_FLOAT_VALUE - f6;
            float f19 = -f4;
            path.cubicTo(f18, f5, f19, f17, f19, Property.DEFAULT_FLOAT_VALUE);
            path.cubicTo(f19, f16, f18, f14, Property.DEFAULT_FLOAT_VALUE, f14);
        }
        PointF pointF2 = (PointF) this.f495e.e();
        path.offset(pointF2.x, pointF2.y);
        path.close();
        P0.c.b(path, this.f497g);
        this.f498h = true;
        return path;
    }

    @Override // J0.f
    public final void f(Object obj, Q0.b bVar) {
        if (obj == z.f4590c) {
            this.f494d.i(bVar);
        } else if (obj == z.f4591d) {
            this.f495e.i(bVar);
        }
    }

    @Override // J0.f
    public final void g(J0.e eVar, int i4, ArrayList arrayList, J0.e eVar2) {
        AbstractC0557a.X(eVar, i4, arrayList, eVar2, this);
    }

    @Override // G0.c
    public final String getName() {
        return this.f492b;
    }
}
