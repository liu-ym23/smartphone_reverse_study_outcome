package y9;

import aa.r;
import aa.t;
import aa.u;
import android.content.Context;
import android.util.Log;
import android.view.View;
import java.lang.invoke.VarHandle;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public View f16049a;

    /* renamed from: b, reason: collision with root package name */
    public ArrayList f16050b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f16051c;

    /* renamed from: d, reason: collision with root package name */
    public float f16052d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f16053e;

    public final void a(b bVar) {
        ArrayList arrayList = this.f16050b;
        bVar.getClass();
        float f5 = this.f16049a.getResources().getDisplayMetrics().density;
        if (!this.f16053e) {
            this.f16052d = bVar.f16033a * f5;
        }
        aa.f fVar = new aa.f();
        bVar.f16034b.invoke(fVar, Float.valueOf(f5));
        e eVar = new e();
        eVar.f16047a = l.f16062a;
        eVar.f16048b = fVar;
        VarHandle.storeStoreFence();
        arrayList.add(eVar);
        u uVar = new u();
        bVar.f16035c.invoke(uVar, Float.valueOf(f5));
        e eVar2 = new e();
        eVar2.f16047a = l.f16063b;
        eVar2.f16048b = uVar;
        VarHandle.storeStoreFence();
        arrayList.add(eVar2);
        r rVar = new r();
        bVar.f16036d.invoke(rVar, Float.valueOf(f5));
        e eVar3 = new e();
        eVar3.f16047a = l.f16064c;
        eVar3.f16048b = rVar;
        VarHandle.storeStoreFence();
        arrayList.add(eVar3);
        t tVar = new t();
        bVar.f16037e.invoke(tVar, Float.valueOf(f5));
        e eVar4 = new e();
        eVar4.f16047a = l.f16065d;
        eVar4.f16048b = tVar;
        VarHandle.storeStoreFence();
        arrayList.add(eVar4);
        aa.d dVar = new aa.d();
        bVar.f16038f.invoke(dVar, Float.valueOf(f5));
        e eVar5 = new e();
        eVar5.f16047a = l.f16066e;
        eVar5.f16048b = dVar;
        VarHandle.storeStoreFence();
        arrayList.add(eVar5);
    }

    public final void b(g gVar, xb.l lVar) {
        gVar.getClass();
        j jVarO = gVar.o();
        lVar.invoke(jVarO);
        ArrayList arrayList = this.f16050b;
        e eVar = new e();
        eVar.f16047a = gVar;
        eVar.f16048b = jVarO;
        VarHandle.storeStoreFence();
        arrayList.add(eVar);
    }

    public final i c() {
        d dVarI;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = this.f16050b;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            int i3 = i + 1;
            e eVar = (e) arrayList2.get(i);
            View view = this.f16049a;
            eVar.getClass();
            view.getClass();
            g gVar = eVar.f16047a;
            Context context = view.getContext();
            context.getClass();
            if (gVar.k(context)) {
                try {
                    View view2 = this.f16049a;
                    boolean z10 = this.f16051c;
                    float f5 = this.f16052d;
                    view2.getClass();
                    j jVar = eVar.f16048b;
                    jVar.f16058a = z10;
                    jVar.f16059b = f5;
                    dVarI = eVar.f16047a.i(view2, jVar);
                } catch (Exception e10) {
                    x9.a[] aVarArr = x9.a.f15597c;
                    Log.e("MotionKit/".concat("Core"), "FX operation failed", e10);
                    dVarI = null;
                }
                g gVar2 = eVar.f16047a;
                if (dVarI == null) {
                    Log.w("MotionKitMaterial", "能力 " + gVar2.getId() + " 绑定失败，静默降级跳过");
                } else {
                    String id2 = gVar2.getId();
                    h hVar = new h();
                    hVar.f16054a = id2;
                    hVar.f16055b = dVarI;
                    VarHandle.storeStoreFence();
                    arrayList.add(hVar);
                }
            } else {
                Log.i("MotionKitMaterial", "能力 " + eVar.f16047a.getId() + " 当前设备不支持，静默降级跳过");
            }
            i = i3;
        }
        this.f16050b.clear();
        if (this.f16051c) {
            z9.f fVar = z9.f.f16523a;
            View view3 = this.f16049a;
            float f10 = this.f16052d;
            synchronized (fVar) {
                view3.getClass();
                z9.e eVar2 = (z9.e) z9.f.f16527e.get(view3);
                if (eVar2 != null) {
                    z9.c cVar = new z9.c();
                    cVar.f16516c = f10;
                    VarHandle.storeStoreFence();
                    eVar2.a(cVar);
                }
            }
        } else {
            z9.i iVar = z9.i.f16559a;
            View view4 = this.f16049a;
            float f11 = this.f16052d;
            synchronized (iVar) {
                view4.getClass();
                z9.h hVar2 = (z9.h) z9.i.f16565g.get(view4);
                if (hVar2 != null) {
                    z9.g gVar3 = hVar2.f16558c;
                    gVar3.getClass();
                    gVar3.f16532b = f11;
                    if (z9.i.f16566h > 0) {
                        z9.i.i.add(hVar2);
                    } else {
                        hVar2.b();
                    }
                }
            }
        }
        if (this.f16051c) {
            z9.f fVar2 = z9.f.f16523a;
            View view5 = this.f16049a;
            synchronized (fVar2) {
                view5.getClass();
                z9.e eVar3 = (z9.e) z9.f.f16527e.get(view5);
                if (eVar3 != null) {
                    t0.d dVar = new t0.d(12);
                    VarHandle.storeStoreFence();
                    eVar3.a(dVar);
                }
            }
        } else {
            z9.i iVar2 = z9.i.f16559a;
            View view6 = this.f16049a;
            synchronized (iVar2) {
                view6.getClass();
                z9.h hVar3 = (z9.h) z9.i.f16565g.get(view6);
                if (hVar3 != null) {
                    hVar3.f16558c.getClass();
                    if (z9.i.f16566h > 0) {
                        z9.i.i.add(hVar3);
                    } else {
                        hVar3.b();
                    }
                }
            }
        }
        Log.i("MotionKitMaterial", "commit: 完成，生效能力数=" + arrayList.size() + " [" + kb.l.B0(arrayList, ",", null, null, new t0.d(9), 30) + "]");
        View view7 = this.f16049a;
        boolean z11 = this.f16051c;
        view7.getClass();
        i iVar3 = new i();
        iVar3.f16056a = z11;
        new WeakReference(view7);
        iVar3.f16057b = arrayList;
        VarHandle.storeStoreFence();
        return iVar3;
    }
}
