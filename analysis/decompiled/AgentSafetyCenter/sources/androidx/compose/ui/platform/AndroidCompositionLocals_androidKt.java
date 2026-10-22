package androidx.compose.ui.platform;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import androidx.room.c;
import b0.f;
import com.stepos.agentsafetycenter.R;
import h0.k;
import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import jb.v;
import k0.c1;
import k0.e0;
import k0.f0;
import k0.m;
import k0.s;
import k0.s1;
import k0.s2;
import k0.t1;
import k0.v1;
import k0.z;
import k1.a;
import p.u;
import t0.g;
import t0.h;
import t0.i;
import t4.d;
import u.p0;
import v1.a1;
import v1.b1;
import v1.d1;
import v1.h0;
import v1.i0;
import v1.j0;
import v1.k0;
import v1.n;
import v1.o0;
import v1.t;
import xb.l;
import xb.p;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class AndroidCompositionLocals_androidKt {

    /* renamed from: a, reason: collision with root package name */
    public static final e0 f981a = z.n(h0.f14432f);

    /* renamed from: b, reason: collision with root package name */
    public static final s2 f982b = new s2(h0.f14433g);

    /* renamed from: c, reason: collision with root package name */
    public static final e0 f983c;

    /* renamed from: d, reason: collision with root package name */
    public static final s2 f984d;

    /* renamed from: e, reason: collision with root package name */
    public static final s2 f985e;

    /* renamed from: f, reason: collision with root package name */
    public static final s2 f986f;

    static {
        n nVar = n.i;
        e0 e0Var = new e0(0, new c(14));
        f0 f0Var = new f0();
        f0Var.f6898a = nVar;
        VarHandle.storeStoreFence();
        e0Var.f6880c = f0Var;
        VarHandle.storeStoreFence();
        f983c = e0Var;
        f984d = new s2(h0.f14434h);
        f985e = new s2(h0.i);
        f986f = new s2(h0.f14435j);
    }

    public static final void a(t tVar, p pVar, s sVar, int i) {
        LinkedHashMap linkedHashMap;
        boolean z10;
        sVar.Z(-520299287);
        int i3 = (sVar.h(tVar) ? 4 : 2) | i | (sVar.h(pVar) ? 32 : 16);
        if (sVar.P(i3 & 1, (i3 & 19) != 18)) {
            Context context = tVar.getContext();
            Object objM = sVar.M();
            Object obj = m.f6974a;
            if (objM == obj) {
                objM = z.v(new Configuration(context.getResources().getConfiguration()));
                sVar.i0(objM);
            }
            c1 c1Var = (c1) objM;
            Object objM2 = sVar.M();
            if (objM2 == obj) {
                objM2 = new f(c1Var, 3);
                sVar.i0(objM2);
            }
            tVar.setConfigurationChangeObserver((l) objM2);
            Object objM3 = sVar.M();
            Object obj2 = objM3;
            if (objM3 == obj) {
                o0 o0Var = new o0();
                o0Var.f14518a = context;
                VarHandle.storeStoreFence();
                sVar.i0(o0Var);
                obj2 = o0Var;
            }
            o0 o0Var2 = (o0) obj2;
            v1.m viewTreeOwners = tVar.getViewTreeOwners();
            if (viewTreeOwners == null) {
                od.f.e("Called when the ViewTreeOwnersAvailability is not yet in Available state");
                return;
            }
            t4.f fVar = viewTreeOwners.f14491b;
            Object objM4 = sVar.M();
            if (objM4 == obj) {
                Object parent = tVar.getParent();
                parent.getClass();
                View view = (View) parent;
                Object tag = view.getTag(R.id.compose_view_saveable_id_tag);
                String strValueOf = tag instanceof String ? (String) tag : null;
                if (strValueOf == null) {
                    strValueOf = String.valueOf(view.getId());
                }
                String str = g.class.getSimpleName() + ':' + strValueOf;
                d savedStateRegistry = fVar.getSavedStateRegistry();
                Bundle bundleA = savedStateRegistry.a(str);
                if (bundleA != null) {
                    linkedHashMap = new LinkedHashMap();
                    for (String str2 : bundleA.keySet()) {
                        ArrayList parcelableArrayList = bundleA.getParcelableArrayList(str2);
                        parcelableArrayList.getClass();
                        linkedHashMap.put(str2, parcelableArrayList);
                    }
                } else {
                    linkedHashMap = null;
                }
                h hVarA = i.a(linkedHashMap, n.f14507j);
                try {
                    androidx.activity.f fVar2 = new androidx.activity.f(2);
                    fVar2.f672b = hVarA;
                    VarHandle.storeStoreFence();
                    savedStateRegistry.c(str, fVar2);
                    z10 = true;
                } catch (IllegalArgumentException unused) {
                    z10 = false;
                }
                d1 d1Var = new d1(z10, savedStateRegistry, str);
                v1.c1 c1Var2 = new v1.c1();
                c1Var2.f14390c = hVarA;
                c1Var2.f14391f = d1Var;
                VarHandle.storeStoreFence();
                sVar.i0(c1Var2);
                objM4 = c1Var2;
            }
            Object obj3 = (v1.c1) objM4;
            boolean zH = sVar.h(obj3);
            Object objM5 = sVar.M();
            if (zH || objM5 == obj) {
                objM5 = new a2.m(obj3, 24);
                sVar.i0(objM5);
            }
            z.d(v.f6774a, (l) objM5, sVar);
            Object objM6 = sVar.M();
            if (objM6 == obj) {
                if (((Vibrator) context.getSystemService(Vibrator.class)).areAllPrimitivesSupported(1, 7, 2)) {
                    tVar.getView();
                    objM6 = new b1();
                } else {
                    objM6 = new b1();
                }
                sVar.i0(objM6);
            }
            a aVar = (a) objM6;
            Configuration configuration = (Configuration) c1Var.getValue();
            Object objM7 = sVar.M();
            Object obj4 = objM7;
            if (objM7 == obj) {
                y1.c cVar = new y1.c();
                cVar.f15879a = new HashMap();
                VarHandle.storeStoreFence();
                sVar.i0(cVar);
                obj4 = cVar;
            }
            y1.c cVar2 = (y1.c) obj4;
            Object objM8 = sVar.M();
            Object obj5 = objM8;
            if (objM8 == obj) {
                Configuration configuration2 = new Configuration();
                if (configuration != null) {
                    configuration2.setTo(configuration);
                }
                sVar.i0(configuration2);
                obj5 = configuration2;
            }
            Configuration configuration3 = (Configuration) obj5;
            Object objM9 = sVar.M();
            Object obj6 = objM9;
            if (objM9 == obj) {
                j0 j0Var = new j0();
                j0Var.f14481c = configuration3;
                j0Var.f14482f = cVar2;
                VarHandle.storeStoreFence();
                sVar.i0(j0Var);
                obj6 = j0Var;
            }
            j0 j0Var2 = (j0) obj6;
            boolean zH2 = sVar.h(context);
            Object objM10 = sVar.M();
            if (zH2 || objM10 == obj) {
                objM10 = new i0(0, context, j0Var2);
                sVar.i0(objM10);
            }
            z.d(cVar2, (l) objM10, sVar);
            Object objM11 = sVar.M();
            Object obj7 = objM11;
            if (objM11 == obj) {
                y1.d dVar = new y1.d();
                dVar.f15880a = new u();
                VarHandle.storeStoreFence();
                sVar.i0(dVar);
                obj7 = dVar;
            }
            y1.d dVar2 = (y1.d) obj7;
            Object objM12 = sVar.M();
            Object obj8 = objM12;
            if (objM12 == obj) {
                k0 k0Var = new k0();
                k0Var.f14485c = dVar2;
                VarHandle.storeStoreFence();
                sVar.i0(k0Var);
                obj8 = k0Var;
            }
            k0 k0Var2 = (k0) obj8;
            boolean zH3 = sVar.h(context);
            Object objM13 = sVar.M();
            if (zH3 || objM13 == obj) {
                objM13 = new i0(1, context, k0Var2);
                sVar.i0(objM13);
            }
            z.d(dVar2, (l) objM13, sVar);
            s1 s1Var = a1.f14376v;
            z.b(new t1[]{f981a.a((Configuration) c1Var.getValue()), f982b.a(context), f4.c.f3915a.a(viewTreeOwners.f14490a), u4.a.f14046a.a(fVar), i.f13120a.a(obj3), f986f.a(tVar.getView()), f984d.a(cVar2), f985e.a(dVar2), s1Var.a(Boolean.valueOf(((Boolean) sVar.j(s1Var)).booleanValue() | tVar.getScrollCaptureInProgress$ui_release())), a1.f14366l.a(aVar)}, s0.h.d(1059770793, new p0(tVar, o0Var2, pVar, 1), sVar), sVar, 56);
        } else {
            sVar.S();
        }
        v1 v1VarS = sVar.s();
        if (v1VarS != null) {
            v1VarS.f7091d = new k(tVar, pVar, i, 7);
        }
    }

    public static final void b(String str) {
        throw new IllegalStateException(("CompositionLocal " + str + " not present").toString());
    }

    public static final s1 getLocalLifecycleOwner() {
        return f4.c.f3915a;
    }
}
