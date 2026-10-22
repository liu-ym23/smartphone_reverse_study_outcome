package j1;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import b0.c3;
import com.stepos.agentbus.R;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/* loaded from: classes.dex */
public abstract class q0 {

    /* renamed from: a, reason: collision with root package name */
    public static final b0.e0 f5299a = new b0.e0(l0.f5220h);

    /* renamed from: b, reason: collision with root package name */
    public static final c3 f5300b = new c3(l0.f5221i);

    /* renamed from: c, reason: collision with root package name */
    public static final c3 f5301c;

    /* renamed from: d, reason: collision with root package name */
    public static final c3 f5302d;

    /* renamed from: e, reason: collision with root package name */
    public static final c3 f5303e;

    static {
        s7.a.H(new b0.d0(0));
        f5301c = new c3(l0.f5222j);
        f5302d = new c3(l0.f5223k);
        f5303e = new c3(l0.f5224l);
    }

    public static final void a(y yVar, p7.n nVar, b0.p pVar, int i2) {
        b0.f1 f1Var;
        LinkedHashMap linkedHashMap;
        boolean z4;
        pVar.T(-520299287);
        int i10 = (pVar.h(yVar) ? 4 : 2) | i2 | (pVar.h(nVar) ? 32 : 16);
        if (pVar.L(i10 & 1, (i10 & 19) != 18)) {
            Context context = yVar.getContext();
            Object objJ = pVar.J();
            Object obj = b0.k.f1229a;
            if (objJ == obj) {
                objJ = b0.b.n(new Configuration(context.getResources().getConfiguration()));
                pVar.b0(objJ);
            }
            b0.f1 f1Var2 = (b0.f1) objJ;
            Object objJ2 = pVar.J();
            if (objJ2 == obj) {
                objJ2 = new c1.w(9, f1Var2);
                pVar.b0(objJ2);
            }
            yVar.setConfigurationChangeObserver((p7.k) objJ2);
            Object objJ3 = pVar.J();
            if (objJ3 == obj) {
                objJ3 = new u0();
                pVar.b0(objJ3);
            }
            u0 u0Var = (u0) objJ3;
            q viewTreeOwners = yVar.getViewTreeOwners();
            if (viewTreeOwners == null) {
                throw new IllegalStateException("Called when the ViewTreeOwnersAvailability is not yet in Available state");
            }
            i3.e eVar = viewTreeOwners.f5298b;
            Object objJ4 = pVar.J();
            if (objJ4 == obj) {
                Object parent = yVar.getParent();
                q7.k.c(parent, "null cannot be cast to non-null type android.view.View");
                View view = (View) parent;
                Object tag = view.getTag(R.id.compose_view_saveable_id_tag);
                String strValueOf = tag instanceof String ? (String) tag : null;
                if (strValueOf == null) {
                    strValueOf = String.valueOf(view.getId());
                }
                String str = k0.c.class.getSimpleName() + ':' + strValueOf;
                q6.b bVar = (q6.b) ((c.i) eVar).f1687i.f8787g;
                Bundle bundleY0 = bVar.y0(str);
                if (bundleY0 != null) {
                    linkedHashMap = new LinkedHashMap();
                    for (String str2 : bundleY0.keySet()) {
                        ArrayList parcelableArrayList = bundleY0.getParcelableArrayList(str2);
                        q7.k.c(parcelableArrayList, "null cannot be cast to non-null type java.util.ArrayList<kotlin.Any?>");
                        linkedHashMap.put(str2, parcelableArrayList);
                        f1Var2 = f1Var2;
                    }
                } else {
                    linkedHashMap = null;
                }
                f1Var = f1Var2;
                c3 c3Var = k0.e.f5573a;
                k0.d dVar = new k0.d(linkedHashMap);
                try {
                    bVar.M0(str, new a3.a(2, dVar));
                    z4 = true;
                } catch (IllegalArgumentException unused) {
                    z4 = false;
                }
                Object i1Var = new i1(dVar, new j1(z4, bVar, str));
                pVar.b0(i1Var);
                objJ4 = i1Var;
            } else {
                f1Var = f1Var2;
            }
            Object obj2 = (i1) objJ4;
            boolean zH = pVar.h(obj2);
            Object objJ5 = pVar.J();
            if (zH || objJ5 == obj) {
                objJ5 = new c1.w(10, obj2);
                pVar.b0(objJ5);
            }
            b0.b.d(c7.r.f1986a, (p7.k) objJ5, pVar);
            Object objJ6 = pVar.J();
            if (objJ6 == obj) {
                if (Build.VERSION.SDK_INT < 31 || !((Vibrator) context.getSystemService(Vibrator.class)).areAllPrimitivesSupported(1, 7, 2)) {
                    objJ6 = new h1();
                } else {
                    yVar.getView();
                    objJ6 = new h1();
                }
                pVar.b0(objJ6);
            }
            y0.a aVar = (y0.a) objJ6;
            Configuration configuration = (Configuration) f1Var.getValue();
            Object objJ7 = pVar.J();
            if (objJ7 == obj) {
                objJ7 = new n1.a();
                pVar.b0(objJ7);
            }
            n1.a aVar2 = (n1.a) objJ7;
            Object objJ8 = pVar.J();
            Object obj3 = objJ8;
            if (objJ8 == obj) {
                Configuration configuration2 = new Configuration();
                if (configuration != null) {
                    configuration2.setTo(configuration);
                }
                pVar.b0(configuration2);
                obj3 = configuration2;
            }
            Configuration configuration3 = (Configuration) obj3;
            Object objJ9 = pVar.J();
            if (objJ9 == obj) {
                objJ9 = new o0(configuration3, aVar2);
                pVar.b0(objJ9);
            }
            o0 o0Var = (o0) objJ9;
            boolean zH2 = pVar.h(context);
            Object objJ10 = pVar.J();
            if (zH2 || objJ10 == obj) {
                objJ10 = new g1.y(2, context, o0Var);
                pVar.b0(objJ10);
            }
            b0.b.d(aVar2, (p7.k) objJ10, pVar);
            Object objJ11 = pVar.J();
            if (objJ11 == obj) {
                objJ11 = new n1.b();
                pVar.b0(objJ11);
            }
            n1.b bVar2 = (n1.b) objJ11;
            Object objJ12 = pVar.J();
            if (objJ12 == obj) {
                objJ12 = new p0(bVar2);
                pVar.b0(objJ12);
            }
            p0 p0Var = (p0) objJ12;
            boolean zH3 = pVar.h(context);
            Object objJ13 = pVar.J();
            if (zH3 || objJ13 == obj) {
                objJ13 = new g1.y(3, context, p0Var);
                pVar.b0(objJ13);
            }
            b0.b.d(bVar2, (p7.k) objJ13, pVar);
            b0.w1 w1Var = g1.f5188v;
            b0.b.b(new b0.x1[]{f5299a.a((Configuration) f1Var.getValue()), f5300b.a(context), z2.f.f11798a.a(viewTreeOwners.f5297a), j3.a.f5397a.a(eVar), k0.e.f5573a.a(obj2), f5303e.a(yVar.getView()), f5301c.a(aVar2), f5302d.a(bVar2), w1Var.a(Boolean.valueOf(((Boolean) pVar.j(w1Var)).booleanValue() | yVar.getScrollCaptureInProgress$ui_release())), g1.f5178l.a(aVar)}, j0.i.d(1059770793, new n0((Object) yVar, (Object) u0Var, (Object) nVar, 0), pVar), pVar, 56);
        } else {
            pVar.O();
        }
        b0.z1 z1VarS = pVar.s();
        if (z1VarS != null) {
            z1VarS.f1444d = new h9.b(yVar, nVar, i2, 2);
        }
    }

    public static final void b(String str) {
        throw new IllegalStateException(("CompositionLocal " + str + " not present").toString());
    }
}
