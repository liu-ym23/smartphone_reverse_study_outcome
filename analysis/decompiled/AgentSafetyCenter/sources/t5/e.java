package t5;

import android.view.View;
import java.util.List;
import jb.v;
import k0.z1;
import kc.t;
import nc.r0;
import pb.i;
import u.t0;
import u5.l;
import v1.l1;
import v3.z;
import xb.p;
import y8.u;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e extends i implements p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f13181c;

    /* renamed from: f, reason: collision with root package name */
    public int f13182f;

    /* renamed from: g, reason: collision with root package name */
    public Object f13183g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Object f13184h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public e(p pVar, v3.c cVar, nb.c cVar2) {
        super(2, cVar2);
        this.f13181c = 6;
        this.f13183g = (i) pVar;
        this.f13184h = cVar;
    }

    /* JADX WARN: Type inference failed for: r0v11, types: [pb.i, xb.p] */
    @Override // pb.a
    public final nb.c create(Object obj, nb.c cVar) {
        switch (this.f13181c) {
            case 0:
                return new e((g) this.f13183g, (e6.i) this.f13184h, cVar, 0);
            case 1:
                e eVar = new e((t0) this.f13184h, cVar, 1);
                eVar.f13183g = obj;
                return eVar;
            case 2:
                e eVar2 = new e((l) this.f13184h, cVar, 2);
                eVar2.f13183g = obj;
                return eVar2;
            case 3:
                return new e((z1) this.f13183g, (View) this.f13184h, cVar, 3);
            case 4:
                return new e((r0) this.f13183g, (l1) this.f13184h, cVar, 4);
            case 5:
                e eVar3 = new e((List) this.f13184h, cVar, 5);
                eVar3.f13183g = obj;
                return eVar3;
            case 6:
                return new e((p) this.f13183g, (v3.c) this.f13184h, cVar);
            case 7:
                e eVar4 = new e((z) this.f13184h, cVar, 7);
                eVar4.f13183g = obj;
                return eVar4;
            case 8:
                return new e((p5.i) this.f13184h, cVar, 8);
            case 9:
                e eVar5 = new e((x8.c) this.f13184h, cVar, 9);
                eVar5.f13183g = obj;
                return eVar5;
            case 10:
                e eVar6 = new e((u) this.f13184h, cVar, 10);
                eVar6.f13183g = obj;
                return eVar6;
            case 11:
                return new e((z.d) this.f13183g, (ed.l) this.f13184h, cVar, 11);
            default:
                return new e((z1.d) this.f13183g, (Runnable) this.f13184h, cVar, 12);
        }
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) throws Exception {
        switch (this.f13181c) {
            case 4:
                ((e) create((t) obj, (nb.c) obj2)).invokeSuspend(v.f6774a);
                break;
        }
        return ((e) create((t) obj, (nb.c) obj2)).invokeSuspend(v.f6774a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:77:0x0181, code lost:
    
        if (r2.invoke(r3, r19) != r0) goto L79;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0179 A[PHI: r2 r3
      0x0179: PHI (r2v29 t5.e) = (r2v35 t5.e), (r2v42 t5.e) binds: [B:74:0x0176, B:70:0x0140] A[DONT_GENERATE, DONT_INLINE]
      0x0179: PHI (r3v11 java.lang.Object) = (r3v14 java.lang.Object), (r3v15 java.lang.Object) binds: [B:74:0x0176, B:70:0x0140] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Type inference failed for: r2v19, types: [pb.i, xb.p] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:77:0x0181 -> B:79:0x0185). Please report as a decompilation issue!!! */
    @Override // pb.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r20) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 1042
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: t5.e.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e(Object obj, nb.c cVar, int i) {
        super(2, cVar);
        this.f13181c = i;
        this.f13184h = obj;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e(Object obj, Object obj2, nb.c cVar, int i) {
        super(2, cVar);
        this.f13181c = i;
        this.f13183g = obj;
        this.f13184h = obj2;
    }
}
