package j9;

import java.lang.invoke.VarHandle;
import java.util.LinkedHashSet;
import java.util.Set;
import k0.c1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class f implements xb.l {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f6661c;

    /* renamed from: f, reason: collision with root package name */
    public Object f6662f;

    public /* synthetic */ f(int i) {
        this.f6661c = i;
    }

    @Override // xb.l
    public final Object invoke(Object obj) {
        LinkedHashSet linkedHashSet;
        boolean z10;
        long j10;
        switch (this.f6661c) {
            case 0:
                String str = (String) obj;
                str.getClass();
                c1 c1Var = (c1) this.f6662f;
                if (((Set) c1Var.getValue()).contains(str)) {
                    Set set = (Set) c1Var.getValue();
                    set.getClass();
                    linkedHashSet = new LinkedHashSet(kb.x.L(set.size()));
                    boolean z11 = false;
                    for (Object obj2 : set) {
                        if (z11 || !yb.k.a(obj2, str)) {
                            z10 = true;
                        } else {
                            z11 = true;
                            z10 = false;
                        }
                        if (z10) {
                            linkedHashSet.add(obj2);
                        }
                    }
                } else {
                    Set set2 = (Set) c1Var.getValue();
                    set2.getClass();
                    linkedHashSet = new LinkedHashSet(kb.x.L(set2.size() + 1));
                    linkedHashSet.addAll(set2);
                    linkedHashSet.add(str);
                }
                c1Var.setValue(linkedHashSet);
                return jb.v.f6774a;
            case 1:
                kc.g gVar = (kc.g) this.f6662f;
                jb.v vVar = jb.v.f6774a;
                gVar.resumeWith(vVar);
                return vVar;
            case 2:
                boolean zBooleanValue = ((Boolean) obj).booleanValue();
                o1.z zVar = (o1.z) this.f6662f;
                if (zVar != null) {
                    zVar.f9106g = zBooleanValue;
                }
                return jb.v.f6774a;
            default:
                u0.k kVar = (u0.k) obj;
                synchronized (u0.m.f13676c) {
                    j10 = u0.m.f13678e;
                    u0.m.f13678e = 1 + j10;
                }
                xb.l lVar = (xb.l) this.f6662f;
                u0.e eVar = new u0.e(j10, kVar);
                eVar.f13650e = lVar;
                eVar.f13651f = 1;
                VarHandle.storeStoreFence();
                return eVar;
        }
    }
}
