package k0;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class y1 extends pb.i implements xb.q {

    /* renamed from: c, reason: collision with root package name */
    public List f7141c;

    /* renamed from: f, reason: collision with root package name */
    public List f7142f;

    /* renamed from: g, reason: collision with root package name */
    public List f7143g;

    /* renamed from: h, reason: collision with root package name */
    public p.g0 f7144h;
    public p.g0 i;

    /* renamed from: j, reason: collision with root package name */
    public p.g0 f7145j;

    /* renamed from: k, reason: collision with root package name */
    public Set f7146k;

    /* renamed from: l, reason: collision with root package name */
    public p.g0 f7147l;

    /* renamed from: m, reason: collision with root package name */
    public int f7148m;

    /* renamed from: n, reason: collision with root package name */
    public /* synthetic */ z0 f7149n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ z1 f7150o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y1(z1 z1Var, nb.c cVar) {
        super(3, cVar);
        this.f7150o = z1Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00fd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void a(k0.z1 r22, java.util.List r23, java.util.List r24, java.util.List r25, p.g0 r26, p.g0 r27, p.g0 r28, p.g0 r29) {
        /*
            Method dump skipped, instructions count: 265
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k0.y1.a(k0.z1, java.util.List, java.util.List, java.util.List, p.g0, p.g0, p.g0, p.g0):void");
    }

    public static final void d(List list, z1 z1Var) {
        list.clear();
        synchronized (z1Var.f7156b) {
            try {
                ArrayList arrayList = z1Var.f7163j;
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    list.add((b1) arrayList.get(i));
                }
                z1Var.f7163j.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // xb.q
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        y1 y1Var = new y1(this.f7150o, (nb.c) obj3);
        y1Var.f7149n = (z0) obj2;
        y1Var.invokeSuspend(jb.v.f6774a);
        return ob.a.f9351c;
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x0139, code lost:
    
        if (r2.C(r14, r0) == r1) goto L40;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00a2 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01d5  */
    /* JADX WARN: Type inference failed for: r10v4, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r10v6, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r11v4, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r11v6, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r12v4, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r12v6, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.util.Set] */
    /* JADX WARN: Type inference failed for: r6v8, types: [java.util.Set] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x0139 -> B:41:0x013c). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:59:0x01d5 -> B:11:0x009d). Please report as a decompilation issue!!! */
    @Override // pb.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r21) {
        /*
            Method dump skipped, instructions count: 474
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k0.y1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
