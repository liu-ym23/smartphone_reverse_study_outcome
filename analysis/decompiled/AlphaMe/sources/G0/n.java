package G0;

import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.v;
import com.airbnb.lottie.z;
import com.stepos.alphame.utils.Property;
import f1.AbstractC0557a;
import java.util.ArrayList;
import java.util.List;
import s.AbstractC0831a;

/* loaded from: classes.dex */
public final class n implements m, H0.a, k {

    /* renamed from: a, reason: collision with root package name */
    public final Path f539a = new Path();

    /* renamed from: b, reason: collision with root package name */
    public final String f540b;

    /* renamed from: c, reason: collision with root package name */
    public final v f541c;

    /* renamed from: d, reason: collision with root package name */
    public final L0.i f542d;

    /* renamed from: e, reason: collision with root package name */
    public final H0.c f543e;

    /* renamed from: f, reason: collision with root package name */
    public final H0.b f544f;

    /* renamed from: g, reason: collision with root package name */
    public final H0.c f545g;

    /* renamed from: h, reason: collision with root package name */
    public final H0.c f546h;

    /* renamed from: i, reason: collision with root package name */
    public final H0.c f547i;

    /* renamed from: j, reason: collision with root package name */
    public final H0.c f548j;

    /* renamed from: k, reason: collision with root package name */
    public final H0.c f549k;

    /* renamed from: l, reason: collision with root package name */
    public s f550l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f551m;

    public n(v vVar, M0.b bVar, L0.d dVar) {
        this.f541c = vVar;
        int i4 = dVar.f1153a;
        this.f540b = dVar.f1154b;
        L0.i iVar = (L0.i) dVar.f1157e;
        this.f542d = iVar;
        H0.b bVarC = dVar.f1155c.c();
        this.f543e = (H0.c) bVarC;
        H0.b bVarC2 = ((K0.d) dVar.f1158f).c();
        this.f544f = bVarC2;
        H0.b bVarC3 = dVar.f1156d.c();
        this.f545g = (H0.c) bVarC3;
        H0.b bVarC4 = ((K0.b) dVar.f1160h).c();
        this.f547i = (H0.c) bVarC4;
        H0.b bVarC5 = ((K0.b) dVar.f1162j).c();
        this.f549k = (H0.c) bVarC5;
        L0.i iVar2 = L0.i.Star;
        if (iVar == iVar2) {
            this.f546h = (H0.c) ((K0.b) dVar.f1159g).c();
            this.f548j = (H0.c) ((K0.b) dVar.f1161i).c();
        } else {
            this.f546h = null;
            this.f548j = null;
        }
        bVar.c(bVarC);
        bVar.c(bVarC2);
        bVar.c(bVarC3);
        bVar.c(bVarC4);
        bVar.c(bVarC5);
        if (iVar == iVar2) {
            bVar.c(this.f546h);
            bVar.c(this.f548j);
        }
        bVarC.a(this);
        bVarC2.a(this);
        bVarC3.a(this);
        bVarC4.a(this);
        bVarC5.a(this);
        if (iVar == iVar2) {
            this.f546h.a(this);
            this.f548j.a(this);
        }
    }

    @Override // H0.a
    public final void a() {
        this.f551m = false;
        this.f541c.invalidateSelf();
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
                    this.f550l = sVar;
                    sVar.c(this);
                }
            }
            i4++;
        }
    }

    @Override // G0.m
    public final Path e() {
        float f4;
        double d4;
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        float f11;
        float f12;
        float f13;
        float f14;
        float f15;
        n nVar;
        H0.b bVar;
        float f16;
        double d5;
        double d6;
        n nVar2 = this;
        boolean z4 = nVar2.f551m;
        Path path = nVar2.f539a;
        if (z4) {
            return path;
        }
        path.reset();
        int iOrdinal = nVar2.f542d.ordinal();
        H0.b bVar2 = nVar2.f544f;
        H0.c cVar = nVar2.f547i;
        H0.c cVar2 = nVar2.f549k;
        H0.c cVar3 = nVar2.f545g;
        H0.c cVar4 = nVar2.f543e;
        if (iOrdinal == 0) {
            float fFloatValue = ((Float) cVar4.e()).floatValue();
            double radians = Math.toRadians((cVar3 != null ? ((Float) cVar3.e()).floatValue() : 0.0d) - 90.0d);
            double d7 = fFloatValue;
            float f17 = (float) (6.283185307179586d / d7);
            float f18 = f17 / 2.0f;
            float f19 = fFloatValue - ((int) fFloatValue);
            if (f19 != Property.DEFAULT_FLOAT_VALUE) {
                radians += (1.0f - f19) * f18;
            }
            float fFloatValue2 = ((Float) cVar.e()).floatValue();
            n nVar3 = this;
            float fFloatValue3 = ((Float) nVar3.f546h.e()).floatValue();
            H0.c cVar5 = nVar3.f548j;
            float fFloatValue4 = cVar5 != null ? ((Float) cVar5.e()).floatValue() / 100.0f : Property.DEFAULT_FLOAT_VALUE;
            float fFloatValue5 = cVar2 != null ? ((Float) cVar2.e()).floatValue() / 100.0f : Property.DEFAULT_FLOAT_VALUE;
            if (f19 != Property.DEFAULT_FLOAT_VALUE) {
                float fC = AbstractC0831a.c(fFloatValue2, fFloatValue3, f19, fFloatValue3);
                double d8 = fC;
                float fCos = (float) (Math.cos(radians) * d8);
                float fSin = (float) (d8 * Math.sin(radians));
                path.moveTo(fCos, fSin);
                d4 = radians + ((f17 * f19) / 2.0f);
                f6 = fCos;
                f7 = fC;
                f5 = fSin;
                f4 = f18;
            } else {
                double d9 = fFloatValue2;
                float fCos2 = (float) (Math.cos(radians) * d9);
                float fSin2 = (float) (d9 * Math.sin(radians));
                path.moveTo(fCos2, fSin2);
                f4 = f18;
                d4 = radians + f4;
                f5 = fSin2;
                f6 = fCos2;
                f7 = Property.DEFAULT_FLOAT_VALUE;
            }
            double dCeil = Math.ceil(d7) * 2.0d;
            double d10 = d4;
            float f20 = fFloatValue3;
            int i4 = 0;
            boolean z5 = false;
            while (true) {
                double d11 = i4;
                if (d11 >= dCeil) {
                    break;
                }
                float f21 = z5 ? fFloatValue2 : f20;
                float f22 = (f7 == Property.DEFAULT_FLOAT_VALUE || d11 != dCeil - 2.0d) ? f4 : (f17 * f19) / 2.0f;
                if (f7 == Property.DEFAULT_FLOAT_VALUE || d11 != dCeil - 1.0d) {
                    f8 = f22;
                    f9 = f21;
                    f10 = fFloatValue2;
                } else {
                    f8 = f22;
                    f10 = fFloatValue2;
                    f9 = f7;
                }
                double d12 = f9;
                float f23 = f17;
                float f24 = f7;
                float fCos3 = (float) (Math.cos(d10) * d12);
                float fSin3 = (float) (d12 * Math.sin(d10));
                if (fFloatValue4 == Property.DEFAULT_FLOAT_VALUE && fFloatValue5 == Property.DEFAULT_FLOAT_VALUE) {
                    path.lineTo(fCos3, fSin3);
                    f11 = fSin3;
                    f12 = f4;
                    f14 = f20;
                    f13 = f8;
                    f15 = f19;
                    nVar = this;
                } else {
                    float f25 = f5;
                    double dAtan2 = (float) (Math.atan2(f5, f6) - 1.5707963267948966d);
                    float fCos4 = (float) Math.cos(dAtan2);
                    float fSin4 = (float) Math.sin(dAtan2);
                    f11 = fSin3;
                    f12 = f4;
                    double dAtan22 = (float) (Math.atan2(fSin3, fCos3) - 1.5707963267948966d);
                    float fCos5 = (float) Math.cos(dAtan22);
                    float fSin5 = (float) Math.sin(dAtan22);
                    float f26 = z5 ? fFloatValue4 : fFloatValue5;
                    float f27 = z5 ? fFloatValue5 : fFloatValue4;
                    float f28 = (z5 ? f20 : f10) * f26 * 0.47829f;
                    float f29 = fCos4 * f28;
                    float f30 = f28 * fSin4;
                    float f31 = (z5 ? f10 : f20) * f27 * 0.47829f;
                    float f32 = fCos5 * f31;
                    float f33 = f31 * fSin5;
                    if (f19 != Property.DEFAULT_FLOAT_VALUE) {
                        if (i4 == 0) {
                            f29 *= f19;
                            f30 *= f19;
                        } else if (d11 == dCeil - 1.0d) {
                            f32 *= f19;
                            f33 *= f19;
                        }
                    }
                    f13 = f8;
                    f14 = f20;
                    f15 = f19;
                    nVar = this;
                    path.cubicTo(f6 - f29, f25 - f30, f32 + fCos3, f11 + f33, fCos3, f11);
                }
                d10 += f13;
                z5 = !z5;
                i4++;
                nVar3 = nVar;
                f6 = fCos3;
                f19 = f15;
                fFloatValue2 = f10;
                f17 = f23;
                f4 = f12;
                f5 = f11;
                f20 = f14;
                f7 = f24;
            }
            nVar2 = nVar3;
            PointF pointF = (PointF) bVar2.e();
            path.offset(pointF.x, pointF.y);
            path.close();
        } else if (iOrdinal == 1) {
            int iFloor = (int) Math.floor(((Float) cVar4.e()).floatValue());
            if (cVar3 == null) {
                bVar = bVar2;
            } else {
                bVar = bVar2;
                dFloatValue = ((Float) cVar3.e()).floatValue();
            }
            double radians2 = Math.toRadians(dFloatValue - 90.0d);
            double d13 = iFloor;
            float fFloatValue6 = ((Float) cVar2.e()).floatValue() / 100.0f;
            float fFloatValue7 = ((Float) cVar.e()).floatValue();
            double d14 = fFloatValue7;
            float fCos6 = (float) (Math.cos(radians2) * d14);
            float fSin6 = (float) (Math.sin(radians2) * d14);
            path.moveTo(fCos6, fSin6);
            double d15 = (float) (6.283185307179586d / d13);
            double d16 = radians2 + d15;
            double dCeil2 = Math.ceil(d13);
            int i5 = 0;
            while (i5 < dCeil2) {
                float fCos7 = (float) (Math.cos(d16) * d14);
                int i6 = i5;
                float fSin7 = (float) (Math.sin(d16) * d14);
                if (fFloatValue6 != Property.DEFAULT_FLOAT_VALUE) {
                    double d17 = d14;
                    double dAtan23 = (float) (Math.atan2(fSin6, fCos6) - 1.5707963267948966d);
                    float fCos8 = (float) Math.cos(dAtan23);
                    float fSin8 = (float) Math.sin(dAtan23);
                    d5 = d16;
                    double dAtan24 = (float) (Math.atan2(fSin7, fCos7) - 1.5707963267948966d);
                    float f34 = fFloatValue7 * fFloatValue6 * 0.25f;
                    d6 = d17;
                    f16 = fFloatValue7;
                    path.cubicTo(fCos6 - (fCos8 * f34), fSin6 - (fSin8 * f34), fCos7 + (((float) Math.cos(dAtan24)) * f34), (f34 * ((float) Math.sin(dAtan24))) + fSin7, fCos7, fSin7);
                } else {
                    f16 = fFloatValue7;
                    d5 = d16;
                    d6 = d14;
                    path.lineTo(fCos7, fSin7);
                }
                fSin6 = fSin7;
                fFloatValue7 = f16;
                i5 = i6 + 1;
                d14 = d6;
                d16 = d5 + d15;
                fCos6 = fCos7;
            }
            PointF pointF2 = (PointF) bVar.e();
            path.offset(pointF2.x, pointF2.y);
            path.close();
            nVar2 = this;
        }
        path.close();
        P0.c.b(path, nVar2.f550l);
        nVar2.f551m = true;
        return path;
    }

    @Override // J0.f
    public final void f(Object obj, Q0.b bVar) {
        H0.c cVar;
        H0.c cVar2;
        if (obj == z.f4598k) {
            this.f543e.i(bVar);
            return;
        }
        if (obj == z.f4599l) {
            this.f545g.i(bVar);
            return;
        }
        if (obj == z.f4591d) {
            this.f544f.i(bVar);
            return;
        }
        if (obj == z.f4600m && (cVar2 = this.f546h) != null) {
            cVar2.i(bVar);
            return;
        }
        if (obj == z.f4601n) {
            this.f547i.i(bVar);
            return;
        }
        if (obj == z.f4602o && (cVar = this.f548j) != null) {
            cVar.i(bVar);
        } else if (obj == z.f4603p) {
            this.f549k.i(bVar);
        }
    }

    @Override // J0.f
    public final void g(J0.e eVar, int i4, ArrayList arrayList, J0.e eVar2) {
        AbstractC0557a.X(eVar, i4, arrayList, eVar2, this);
    }

    @Override // G0.c
    public final String getName() {
        return this.f540b;
    }
}
