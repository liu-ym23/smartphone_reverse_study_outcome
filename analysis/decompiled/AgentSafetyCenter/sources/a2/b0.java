package a2;

import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class b0 {

    /* renamed from: a, reason: collision with root package name */
    public static final Comparator[] f35a;

    /* renamed from: b, reason: collision with root package name */
    public static final t f36b;

    static {
        Comparator[] comparatorArr = new Comparator[2];
        int i = 0;
        int i3 = 0;
        while (i3 < 2) {
            e eVar = i3 == 0 ? e.f40g : e.f39f;
            z zVar = new z(i);
            zVar.f151f = eVar;
            VarHandle.storeStoreFence();
            a0 a0Var = new a0(i);
            a0Var.f32f = zVar;
            VarHandle.storeStoreFence();
            comparatorArr[i3] = a0Var;
            i3++;
        }
        f35a = comparatorArr;
        f36b = t.f115w;
    }

    public static final void a(p pVar, ArrayList arrayList, m mVar, m mVar2, p.u uVar) {
        k kVar = pVar.f88d;
        Object objG = kVar.f75c.g(u.f128m);
        if (objG == null) {
            objG = Boolean.FALSE;
        }
        boolean zBooleanValue = ((Boolean) objG).booleanValue();
        if ((zBooleanValue || ((Boolean) mVar2.invoke(pVar)).booleanValue()) && ((Boolean) mVar.invoke(pVar)).booleanValue()) {
            arrayList.add(pVar);
        }
        if (zBooleanValue) {
            uVar.h(pVar.f91g, b(pVar, mVar, mVar2, p.j(7, pVar)));
            return;
        }
        List listJ = p.j(7, pVar);
        int size = listJ.size();
        for (int i = 0; i < size; i++) {
            a((p) listJ.get(i), arrayList, mVar, mVar2, uVar);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00d5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.util.ArrayList b(a2.p r17, a2.m r18, a2.m r19, java.util.List r20) {
        /*
            Method dump skipped, instructions count: 366
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.b0.b(a2.p, a2.m, a2.m, java.util.List):java.util.ArrayList");
    }
}
