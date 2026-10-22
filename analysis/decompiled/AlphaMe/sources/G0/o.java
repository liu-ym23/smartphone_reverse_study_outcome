package G0;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import com.airbnb.lottie.v;
import com.stepos.alphame.utils.Property;
import f1.AbstractC0557a;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class o implements H0.a, k, m {

    /* renamed from: a, reason: collision with root package name */
    public final Path f552a = new Path();

    /* renamed from: b, reason: collision with root package name */
    public final RectF f553b = new RectF();

    /* renamed from: c, reason: collision with root package name */
    public final String f554c;

    /* renamed from: d, reason: collision with root package name */
    public final v f555d;

    /* renamed from: e, reason: collision with root package name */
    public final H0.b f556e;

    /* renamed from: f, reason: collision with root package name */
    public final H0.b f557f;

    /* renamed from: g, reason: collision with root package name */
    public final H0.c f558g;

    /* renamed from: h, reason: collision with root package name */
    public s f559h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f560i;

    public o(v vVar, M0.b bVar, L0.j jVar) {
        int i4 = jVar.f1185a;
        this.f554c = jVar.f1186b;
        this.f555d = vVar;
        H0.b bVarC = jVar.f1188d.c();
        this.f556e = bVarC;
        H0.b bVarC2 = ((K0.a) jVar.f1189e).c();
        this.f557f = bVarC2;
        H0.b bVarC3 = jVar.f1187c.c();
        this.f558g = (H0.c) bVarC3;
        bVar.c(bVarC);
        bVar.c(bVarC2);
        bVar.c(bVarC3);
        bVarC.a(this);
        bVarC2.a(this);
        bVarC3.a(this);
    }

    @Override // H0.a
    public final void a() {
        this.f560i = false;
        this.f555d.invalidateSelf();
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
                    this.f559h = sVar;
                    sVar.c(this);
                }
            }
            i4++;
        }
    }

    @Override // G0.m
    public final Path e() {
        boolean z4 = this.f560i;
        Path path = this.f552a;
        if (z4) {
            return path;
        }
        path.reset();
        PointF pointF = (PointF) this.f557f.e();
        float f4 = pointF.x / 2.0f;
        float f5 = pointF.y / 2.0f;
        H0.c cVar = this.f558g;
        float fFloatValue = cVar == null ? 0.0f : ((Float) cVar.e()).floatValue();
        float fMin = Math.min(f4, f5);
        if (fFloatValue > fMin) {
            fFloatValue = fMin;
        }
        PointF pointF2 = (PointF) this.f556e.e();
        path.moveTo(pointF2.x + f4, (pointF2.y - f5) + fFloatValue);
        path.lineTo(pointF2.x + f4, (pointF2.y + f5) - fFloatValue);
        RectF rectF = this.f553b;
        if (fFloatValue > Property.DEFAULT_FLOAT_VALUE) {
            float f6 = pointF2.x + f4;
            float f7 = fFloatValue * 2.0f;
            float f8 = pointF2.y + f5;
            rectF.set(f6 - f7, f8 - f7, f6, f8);
            path.arcTo(rectF, Property.DEFAULT_FLOAT_VALUE, 90.0f, false);
        }
        path.lineTo((pointF2.x - f4) + fFloatValue, pointF2.y + f5);
        if (fFloatValue > Property.DEFAULT_FLOAT_VALUE) {
            float f9 = pointF2.x - f4;
            float f10 = pointF2.y + f5;
            float f11 = fFloatValue * 2.0f;
            rectF.set(f9, f10 - f11, f11 + f9, f10);
            path.arcTo(rectF, 90.0f, 90.0f, false);
        }
        path.lineTo(pointF2.x - f4, (pointF2.y - f5) + fFloatValue);
        if (fFloatValue > Property.DEFAULT_FLOAT_VALUE) {
            float f12 = pointF2.x - f4;
            float f13 = pointF2.y - f5;
            float f14 = fFloatValue * 2.0f;
            rectF.set(f12, f13, f12 + f14, f14 + f13);
            path.arcTo(rectF, 180.0f, 90.0f, false);
        }
        path.lineTo((pointF2.x + f4) - fFloatValue, pointF2.y - f5);
        if (fFloatValue > Property.DEFAULT_FLOAT_VALUE) {
            float f15 = pointF2.x + f4;
            float f16 = fFloatValue * 2.0f;
            float f17 = pointF2.y - f5;
            rectF.set(f15 - f16, f17, f15, f16 + f17);
            path.arcTo(rectF, 270.0f, 90.0f, false);
        }
        path.close();
        P0.c.b(path, this.f559h);
        this.f560i = true;
        return path;
    }

    @Override // J0.f
    public final void f(Object obj, Q0.b bVar) {
    }

    @Override // J0.f
    public final void g(J0.e eVar, int i4, ArrayList arrayList, J0.e eVar2) {
        AbstractC0557a.X(eVar, i4, arrayList, eVar2, this);
    }

    @Override // G0.c
    public final String getName() {
        return this.f554c;
    }
}
