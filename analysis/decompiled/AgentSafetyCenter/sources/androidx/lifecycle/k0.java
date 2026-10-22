package androidx.lifecycle;

import android.graphics.Bitmap;
import java.util.ArrayList;
import java.util.List;
import k0.y1;
import k0.z1;
import u.o1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class k0 extends pb.i implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f1406c;

    /* renamed from: f, reason: collision with root package name */
    public int f1407f;

    /* renamed from: g, reason: collision with root package name */
    public Object f1408g;

    /* renamed from: h, reason: collision with root package name */
    public Object f1409h;
    public /* synthetic */ Object i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Object f1410j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ Object f1411k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ k0(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, nb.c cVar, int i) {
        super(2, cVar);
        this.f1406c = i;
        this.f1408g = obj;
        this.f1409h = obj2;
        this.i = obj3;
        this.f1410j = obj4;
        this.f1411k = obj5;
    }

    @Override // pb.a
    public final nb.c create(Object obj, nb.c cVar) {
        int i = this.f1406c;
        Object obj2 = this.f1411k;
        Object obj3 = this.f1410j;
        switch (i) {
            case 0:
                q qVar = (q) this.i;
                p pVar = p.f1418c;
                return new k0(qVar, (kc.t) obj3, (f4.b) obj2, cVar);
            case 1:
                k0 k0Var = new k0((z1) this.i, (y1) obj3, (k0.z0) obj2, cVar);
                k0Var.f1409h = obj;
                return k0Var;
            case 2:
                return new k0((s8.d1) this.f1408g, (List) this.f1409h, (xb.l) this.i, (List) obj3, (xb.l) obj2, cVar, 2);
            case 3:
                return new k0((e6.i) this.f1408g, (t5.g) this.f1409h, (f6.g) this.i, (t5.c) obj3, (Bitmap) obj2, cVar, 3);
            case 4:
                k0 k0Var2 = new k0((o1) this.f1409h, (u.i) this.i, (u.d) obj3, (kc.x0) obj2, cVar, 4);
                k0Var2.f1408g = obj;
                return k0Var2;
            case 5:
                k0 k0Var3 = new k0((o1.w) this.f1409h, (t.q) this.i, (a2.m) obj3, (u.i0) obj2, cVar, 5);
                k0Var3.f1408g = obj;
                return k0Var3;
            default:
                k0 k0Var4 = new k0((List) obj3, (ArrayList) obj2, cVar);
                k0Var4.i = obj;
                return k0Var4;
        }
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f1406c) {
            case 0:
                return ((k0) create((kc.t) obj, (nb.c) obj2)).invokeSuspend(jb.v.f6774a);
            case 1:
                return ((k0) create((kc.t) obj, (nb.c) obj2)).invokeSuspend(jb.v.f6774a);
            case 2:
                return ((k0) create((kc.t) obj, (nb.c) obj2)).invokeSuspend(jb.v.f6774a);
            case 3:
                return ((k0) create((kc.t) obj, (nb.c) obj2)).invokeSuspend(jb.v.f6774a);
            case 4:
                return ((k0) create((u.y0) obj, (nb.c) obj2)).invokeSuspend(jb.v.f6774a);
            case 5:
                return ((k0) create((kc.t) obj, (nb.c) obj2)).invokeSuspend(jb.v.f6774a);
            default:
                return ((k0) create(obj, (nb.c) obj2)).invokeSuspend(jb.v.f6774a);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:235:?, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x017b, code lost:
    
        if (r14.invoke(r13) == r1) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0196, code lost:
    
        if (r14.invoke(r13) == r1) goto L78;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:192:0x03c2  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x03cb  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x03dc  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x03e5  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x02f9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:216:0x02ce A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:221:0x028b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:240:? A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r8v5, types: [pc.t] */
    @Override // pb.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1018
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.k0.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k0(q qVar, kc.t tVar, f4.b bVar, nb.c cVar) {
        super(2, cVar);
        this.f1406c = 0;
        p pVar = p.f1418c;
        this.i = qVar;
        this.f1410j = tVar;
        this.f1411k = bVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ k0(Object obj, Object obj2, Object obj3, Object obj4, nb.c cVar, int i) {
        super(2, cVar);
        this.f1406c = i;
        this.f1409h = obj;
        this.i = obj2;
        this.f1410j = obj3;
        this.f1411k = obj4;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k0(List list, ArrayList arrayList, nb.c cVar) {
        super(2, cVar);
        this.f1406c = 6;
        this.f1410j = list;
        this.f1411k = arrayList;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k0(z1 z1Var, y1 y1Var, k0.z0 z0Var, nb.c cVar) {
        super(2, cVar);
        this.f1406c = 1;
        this.i = z1Var;
        this.f1410j = y1Var;
        this.f1411k = z0Var;
    }
}
