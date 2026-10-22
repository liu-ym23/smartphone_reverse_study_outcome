package t0;

import ad.o;
import android.os.Bundle;
import androidx.lifecycle.z;
import com.fasterxml.jackson.core.ErrorReportConfiguration;
import e9.a0;
import java.lang.invoke.VarHandle;
import java.util.LinkedHashMap;
import java.util.Map;
import jb.v;
import k0.m;
import k0.s;
import k0.t1;
import k0.v1;
import p.f0;
import p.n0;
import p5.u;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e implements c {
    public static final u i = l.a(new k8.d(22), new d(0));

    /* renamed from: c, reason: collision with root package name */
    public final Map f13113c;

    /* renamed from: f, reason: collision with root package name */
    public final f0 f13114f;

    /* renamed from: g, reason: collision with root package name */
    public g f13115g;

    /* renamed from: h, reason: collision with root package name */
    public final a9.e f13116h;

    public e(Map map) {
        this.f13113c = map;
        long[] jArr = n0.f9597a;
        this.f13114f = new f0();
        a9.e eVar = new a9.e(15);
        eVar.f257f = this;
        VarHandle.storeStoreFence();
        this.f13116h = eVar;
    }

    @Override // t0.c
    public final void e(Object obj, s0.c cVar, s sVar, int i3) {
        int i10;
        sVar.Z(533563200);
        if ((i3 & 6) == 0) {
            i10 = (sVar.h(obj) ? 4 : 2) | i3;
        } else {
            i10 = i3;
        }
        int i11 = 16;
        if ((i3 & 48) == 0) {
            i10 |= sVar.h(cVar) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i10 |= sVar.h(this) ? ErrorReportConfiguration.DEFAULT_MAX_ERROR_TOKEN_LENGTH : 128;
        }
        if (sVar.P(i10 & 1, (i10 & 147) != 146)) {
            sVar.a0(obj);
            Object objM = sVar.M();
            Object obj2 = m.f6974a;
            if (objM == obj2) {
                a9.e eVar = this.f13116h;
                if (!((Boolean) eVar.invoke(obj)).booleanValue()) {
                    o.l("Type of the key ", obj, " is not supported. On Android you can only use types which can be stored inside the Bundle.");
                    return;
                }
                h hVarA = i.a((Map) this.f13113c.get(obj), eVar);
                j jVar = new j();
                jVar.f13121c = hVarA;
                ab.e eVar2 = new ab.e(i11);
                eVar2.f393f = jVar;
                VarHandle.storeStoreFence();
                v4.b bVar = new v4.b();
                bVar.f14764a = jVar;
                bVar.f14765b = eVar2;
                bVar.f14766c = new r2.i(22);
                bVar.f14767d = new LinkedHashMap();
                bVar.f14771h = true;
                VarHandle.storeStoreFence();
                t4.e eVar3 = new t4.e();
                eVar3.f13169a = bVar;
                t4.d dVar = new t4.d();
                dVar.f13167a = bVar;
                VarHandle.storeStoreFence();
                eVar3.f13170b = dVar;
                VarHandle.storeStoreFence();
                jVar.f13122f = eVar3;
                jVar.f13123g = new z(jVar, false);
                jVar.f13124h = dVar;
                Object objC = hVarA.c("androidx.savedstate.SavedStateRegistry");
                eVar3.a(objC instanceof Bundle ? (Bundle) objC : null);
                ab.e eVar4 = new ab.e(15);
                eVar4.f393f = jVar;
                VarHandle.storeStoreFence();
                hVarA.d("androidx.savedstate.SavedStateRegistry", eVar4);
                VarHandle.storeStoreFence();
                sVar.i0(jVar);
                objM = jVar;
            }
            Object obj3 = (j) objM;
            int i12 = 8;
            k0.z.b(new t1[]{i.f13120a.a(obj3), u4.a.f14046a.a(obj3)}, cVar, sVar, (i10 & 112) | 8);
            boolean zH = sVar.h(this) | sVar.h(obj) | sVar.h(obj3);
            Object objM2 = sVar.M();
            Object obj4 = objM2;
            if (zH || objM2 == obj2) {
                aa.j jVar2 = new aa.j(i12);
                jVar2.f326f = this;
                jVar2.f328h = obj;
                jVar2.f327g = obj3;
                VarHandle.storeStoreFence();
                sVar.i0(jVar2);
                obj4 = jVar2;
            }
            k0.z.d(v.f6774a, (xb.l) obj4, sVar);
            sVar.t();
        } else {
            sVar.S();
        }
        v1 v1VarS = sVar.s();
        if (v1VarS != null) {
            a0 a0Var = new a0(3);
            a0Var.f3614g = this;
            a0Var.f3615h = obj;
            a0Var.i = cVar;
            a0Var.f3613f = i3;
            VarHandle.storeStoreFence();
            v1VarS.f7091d = a0Var;
        }
    }

    @Override // t0.c
    public final void f(Object obj) {
        if (this.f13114f.k(obj) == null) {
            this.f13113c.remove(obj);
        }
    }
}
