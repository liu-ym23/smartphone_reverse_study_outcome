package s4;

import androidx.room.c0;
import androidx.room.d0;
import androidx.room.u;
import jb.v;
import pb.i;
import xb.l;
import xb.p;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c extends i implements p {

    /* renamed from: c, reason: collision with root package name */
    public c0 f11377c;

    /* renamed from: f, reason: collision with root package name */
    public int f11378f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f11379g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ boolean f11380h;
    public final /* synthetic */ boolean i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ u f11381j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ l f11382k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(u uVar, nb.c cVar, l lVar, boolean z10, boolean z11) {
        super(2, cVar);
        this.f11380h = z10;
        this.i = z11;
        this.f11381j = uVar;
        this.f11382k = lVar;
    }

    @Override // pb.a
    public final nb.c create(Object obj, nb.c cVar) {
        c cVar2 = new c(this.f11381j, cVar, this.f11382k, this.f11380h, this.i);
        cVar2.f11379g = obj;
        return cVar2;
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        return ((c) create((d0) obj, (nb.c) obj2)).invokeSuspend(v.f6774a);
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00b4 A[PHI: r1 r12
      0x00b4: PHI (r1v11 androidx.room.d0) = (r1v8 androidx.room.d0), (r1v16 androidx.room.d0) binds: [B:42:0x00b1, B:11:0x0026] A[DONT_GENERATE, DONT_INLINE]
      0x00b4: PHI (r12v18 java.lang.Object) = (r12v16 java.lang.Object), (r12v0 java.lang.Object) binds: [B:42:0x00b1, B:11:0x0026] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00da A[RETURN] */
    @Override // pb.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            Method dump skipped, instructions count: 233
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: s4.c.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
