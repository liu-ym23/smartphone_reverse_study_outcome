package e8;

import d7.r;
import f8.z;
import i8.x;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class f extends q7.m implements p7.k {

    /* renamed from: h, reason: collision with root package name */
    public static final f f3138h = new f(1);

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f3139g = 0;

    public /* synthetic */ f(int i2) {
        super(i2);
    }

    @Override // p7.k
    public final Object invoke(Object obj) {
        boolean z4 = false;
        switch (this.f3139g) {
            case 0:
                z zVar = (z) obj;
                q7.k.e(zVar, "module");
                List list = (List) n7.b.q(((x) zVar.z(g.f3142f)).f4898j, x.f4895m[0]);
                ArrayList arrayList = new ArrayList();
                for (Object obj2 : list) {
                    if (obj2 instanceof s9.c) {
                        arrayList.add(obj2);
                    }
                }
                return (s9.c) r.N0(arrayList);
            default:
                f8.c cVar = (f8.c) obj;
                if (cVar.getKind() == 1) {
                    f8.j jVarP = cVar.p();
                    q7.k.c(jVarP, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                    String str = d.f3123a;
                    if (d.f3132j.containsKey(h9.f.g((f8.e) jVarP))) {
                        z4 = true;
                    }
                }
                return Boolean.valueOf(z4);
        }
    }

    public f(o oVar) {
        super(1);
    }
}
