package a2;

import android.graphics.Typeface;
import android.text.Spannable;
import p7.o;
import s1.a0;
import u1.b;
import u5.h;
import v1.e;
import v1.i;
import v1.j;
import v1.k;
import v1.p;
import v1.r;
import z1.c;
import z1.d;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements o {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f157f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Object f158g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Object f159h;

    public /* synthetic */ a(int i2, Object obj, Object obj2) {
        this.f157f = i2;
        this.f158g = obj;
        this.f159h = obj2;
    }

    @Override // p7.o
    public final Object j(Object obj, Object obj2, Object obj3) {
        Typeface typeface;
        switch (this.f157f) {
            case 0:
                Spannable spannable = (Spannable) this.f158g;
                c cVar = (c) this.f159h;
                a0 a0Var = (a0) obj;
                int iIntValue = ((Integer) obj2).intValue();
                int iIntValue2 = ((Integer) obj3).intValue();
                p pVar = a0Var.f9215f;
                k kVar = a0Var.f9212c;
                if (kVar == null) {
                    kVar = k.f10358h;
                }
                i iVar = a0Var.f9213d;
                int i2 = iVar != null ? iVar.f10355a : 0;
                j jVar = a0Var.f9214e;
                int i10 = jVar != null ? jVar.f10356a : 65535;
                d dVar = cVar.f11757f;
                r rVarB = ((e) dVar.f11762j).b(pVar, kVar, i2, i10);
                if (rVarB instanceof r) {
                    Object obj4 = rVarB.f10376f;
                    q7.k.c(obj4, "null cannot be cast to non-null type android.graphics.Typeface");
                    typeface = (Typeface) obj4;
                } else {
                    h hVar = new h(rVarB, dVar.f11767o);
                    dVar.f11767o = hVar;
                    Object obj5 = hVar.f10131c;
                    q7.k.c(obj5, "null cannot be cast to non-null type android.graphics.Typeface");
                    typeface = (Typeface) obj5;
                }
                spannable.setSpan(new b(1, typeface), iIntValue, iIntValue2, 33);
                break;
            default:
                ra.d dVar2 = (ra.d) this.f158g;
                ra.c cVar2 = (ra.c) this.f159h;
                ra.d.f9117h.set(dVar2, cVar2.f9115g);
                dVar2.e(cVar2.f9115g);
                break;
        }
        return c7.r.f1986a;
    }
}
