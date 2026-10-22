package a9;

import aa.r;
import aa.t;
import com.fasterxml.jackson.core.JsonPointer;
import java.lang.invoke.VarHandle;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import jb.v;
import k0.w1;
import k0.y;
import k0.z1;
import kc.x0;
import nc.t0;
import p.g0;
import p.z;
import s8.m1;
import u0.s;
import u0.w;
import xc.c0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class e implements xb.l {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f256c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f257f;

    public /* synthetic */ e(int i) {
        this.f256c = i;
    }

    @Override // xb.l
    public final Object invoke(Object obj) {
        switch (this.f256c) {
            case 0:
                Set set = (Set) this.f257f;
                l lVar = (l) obj;
                lVar.getClass();
                String str = lVar.f284b;
                Set<String> set2 = set;
                if ((set2 instanceof Collection) && set2.isEmpty()) {
                    z = false;
                } else {
                    for (String str2 : set2) {
                        if (!str.equals(str2)) {
                            str2.getClass();
                            String strN = k0.a.n(hc.h.x0(str2, JsonPointer.SEPARATOR), "/");
                            if (str.equals(str2) || hc.o.U(str, strN, false)) {
                            }
                        }
                    }
                    z = false;
                }
                return Boolean.valueOf(z);
            case 1:
                Class cls = (Class) this.f257f;
                obj.getClass();
                z9.f fVar = z9.f.f16523a;
                Class cls2 = z9.f.i;
                Class cls3 = z9.f.f16530h;
                z9.f.b(obj, "setGlassText", new Class[]{cls2, cls3, cls3}, Boolean.FALSE, Float.valueOf(96.0f), Float.valueOf(0.0f));
                if (cls != null) {
                    z9.f.b(obj, "setPathProvider", new Class[]{cls}, null);
                }
                return v.f6774a;
            case 2:
                r rVar = (r) this.f257f;
                obj.getClass();
                z9.f fVar2 = z9.f.f16523a;
                Class cls4 = z9.f.i;
                Class cls5 = z9.f.f16529g;
                Class cls6 = z9.f.f16530h;
                Class[] clsArr = {cls4, cls5, cls6, cls6, cls6, cls6};
                rVar.getClass();
                Boolean bool = Boolean.TRUE;
                Integer numValueOf = Integer.valueOf(rVar.f358c);
                Float fValueOf = Float.valueOf(rVar.f359d);
                Float fValueOf2 = Float.valueOf(0.0f);
                z9.f.b(obj, "setInnerShadow", clsArr, bool, numValueOf, fValueOf, fValueOf2, fValueOf2, Float.valueOf(rVar.f360e));
                return v.f6774a;
            case 3:
                t tVar = (t) this.f257f;
                obj.getClass();
                z9.f fVar3 = z9.f.f16523a;
                Class cls7 = z9.f.i;
                Class cls8 = z9.f.f16530h;
                Class[] clsArr2 = {cls7, cls8, cls8};
                tVar.getClass();
                Boolean bool2 = Boolean.TRUE;
                float f5 = tVar.f363c;
                if (f5 < 0.0f) {
                    f5 = 0.0f;
                }
                Float fValueOf3 = Float.valueOf(f5);
                float f10 = tVar.f364d;
                z9.f.b(obj, "setRefraction", clsArr2, bool2, fValueOf3, Float.valueOf(f10 >= 0.0f ? f10 : 0.0f));
                z9.f.b(obj, "setRefractionDepth", new Class[]{cls8}, Float.valueOf(tVar.f366f));
                z9.f.b(obj, "setDispersion", new Class[]{cls8}, Float.valueOf(tVar.f365e));
                return v.f6774a;
            case 4:
                ab.a aVar = (ab.a) this.f257f;
                y9.f fVar4 = (y9.f) obj;
                fVar4.getClass();
                return aVar.b(fVar4);
            case 5:
                p5.r rVar2 = (p5.r) this.f257f;
                ((x4.a) obj).getClass();
                return rVar2.call();
            case 6:
                androidx.room.q qVar = (androidx.room.q) this.f257f;
                z4.c cVar = (z4.c) obj;
                cVar.getClass();
                qVar.f1604g = cVar;
                return v.f6774a;
            case 7:
                g2.r rVar3 = (g2.r) obj;
                return ((g2.e) this.f257f).a(new g2.r(null, rVar3.f4262b, rVar3.f4263c, rVar3.f4264d, rVar3.f4265e)).f4266c;
            case 8:
                ((y) this.f257f).y(obj);
                return v.f6774a;
            case 9:
                z1 z1Var = (z1) this.f257f;
                Throwable th = (Throwable) obj;
                CancellationException cancellationException = new CancellationException("Recomposer effect job completed");
                cancellationException.initCause(th);
                synchronized (z1Var.f7156b) {
                    try {
                        x0 x0Var = z1Var.f7157c;
                        if (x0Var != null) {
                            t0 t0Var = z1Var.f7173t;
                            w1 w1Var = w1.f7101f;
                            t0Var.getClass();
                            t0Var.g(null, w1Var);
                            x0Var.e(cancellationException);
                            z1Var.f7170q = null;
                            aa.g gVar = new aa.g(6);
                            gVar.f319f = z1Var;
                            gVar.f320g = th;
                            VarHandle.storeStoreFence();
                            x0Var.g(gVar);
                        } else {
                            z1Var.f7158d = cancellationException;
                            t0 t0Var2 = z1Var.f7173t;
                            w1 w1Var2 = w1.f7100c;
                            t0Var2.getClass();
                            t0Var2.g(null, w1Var2);
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                return v.f6774a;
            case 10:
                g0 g0Var = (g0) this.f257f;
                if (obj instanceof w) {
                    ((w) obj).f(4);
                }
                g0Var.a(obj);
                return v.f6774a;
            case 11:
                return obj == ((jb.n) this.f257f) ? "(this Collection)" : String.valueOf(obj);
            case 12:
                p0.b bVar = (p0.b) this.f257f;
                Map.Entry entry = (Map.Entry) obj;
                entry.getClass();
                StringBuilder sb2 = new StringBuilder();
                Object key = entry.getKey();
                sb2.append(key == bVar ? "(this Map)" : String.valueOf(key));
                sb2.append('=');
                Object value = entry.getValue();
                sb2.append(value != bVar ? String.valueOf(value) : "(this Map)");
                return sb2.toString();
            case 13:
                DateTimeFormatter dateTimeFormatter = (DateTimeFormatter) this.f257f;
                m1 m1Var = (m1) obj;
                m1Var.getClass();
                String str3 = m1Var.i;
                if (str3 != null) {
                    return str3;
                }
                long j10 = m1Var.f11795d;
                return j10 > 0 ? dateTimeFormatter.format(Instant.ofEpochMilli(j10)) : m1Var.f11792a;
            case 14:
                ((sc.c) this.f257f).e(null);
                return v.f6774a;
            case 15:
                t0.g gVar2 = ((t0.e) this.f257f).f13115g;
                return Boolean.valueOf(gVar2 != null ? gVar2.a(obj) : true);
            case 16:
                u0.t tVar2 = (u0.t) this.f257f;
                synchronized (tVar2.f13706g) {
                    s sVar = tVar2.i;
                    sVar.getClass();
                    Object obj2 = sVar.f13690b;
                    obj2.getClass();
                    int i = sVar.f13692d;
                    z zVar = sVar.f13691c;
                    if (zVar == null) {
                        zVar = new z();
                        sVar.f13691c = zVar;
                        sVar.f13694f.m(obj2, zVar);
                    }
                    sVar.c(obj, i, obj2, zVar);
                }
                return v.f6774a;
            case 17:
                vc.f fVar5 = (vc.f) this.f257f;
                int iIntValue = ((Integer) obj).intValue();
                return fVar5.f14887e[iIntValue] + ": " + fVar5.f14888f[iIntValue].a();
            case 18:
                ((w5.e) this.f257f).f15256o = true;
                return v.f6774a;
            case 19:
                c0 c0Var = (c0) this.f257f;
                int iIntValue2 = ((Integer) obj).intValue();
                return c0Var.f15615e[iIntValue2] + ": " + c0Var.f(iIntValue2).a();
            default:
                return Boolean.valueOf(!((LinkedHashSet) this.f257f).contains((String) obj));
        }
    }
}
