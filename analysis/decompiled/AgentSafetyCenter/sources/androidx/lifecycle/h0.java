package androidx.lifecycle;

import com.google.crypto.tink.aead.internal.InsecureNonceXChaCha20;
import com.stepos.agentsafetycenter.AgentSafetyApplication;
import com.stepos.agentsafetycenter.sync.MidnightSyncWorker;
import com.stepos.policy.sdk.bean.PolicyBasicListVO;
import g9.j1;
import java.time.LocalDate;
import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class h0 extends pb.i implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f1391c;

    /* renamed from: f, reason: collision with root package name */
    public int f1392f;

    /* renamed from: g, reason: collision with root package name */
    public Object f1393g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Object f1394h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h0(List list, int i, xb.l lVar, nb.c cVar) {
        super(2, cVar);
        this.f1391c = 25;
        this.f1393g = list;
        this.f1392f = i;
        this.f1394h = lVar;
    }

    @Override // pb.a
    public final nb.c create(Object obj, nb.c cVar) {
        switch (this.f1391c) {
            case 0:
                h0 h0Var = new h0((xb.p) this.f1394h, cVar, 0);
                h0Var.f1393g = obj;
                return h0Var;
            case 1:
                return new h0((String[]) this.f1394h, (androidx.room.g) null, cVar);
            case 2:
                return new h0((androidx.room.n0) this.f1393g, (xb.a) this.f1394h, cVar, 2);
            case 3:
                h0 h0Var2 = new h0((e9.h) this.f1394h, cVar, 3);
                h0Var2.f1393g = obj;
                return h0Var2;
            case 4:
                h0 h0Var3 = new h0((g0.q) this.f1394h, cVar, 4);
                h0Var3.f1393g = obj;
                return h0Var3;
            case 5:
                return new h0((ed.e) this.f1393g, (s.h) this.f1394h, cVar, 5);
            case 6:
                return new h0((g9.p0) this.f1393g, (String) this.f1394h, cVar, 6);
            case 7:
                return new h0((j1) this.f1394h, cVar, 7);
            case 8:
                return new h0((v.k) this.f1393g, (u0.q) this.f1394h, cVar, 8);
            case 9:
                h0 h0Var4 = new h0((i9.b0) this.f1394h, cVar, 9);
                h0Var4.f1393g = obj;
                return h0Var4;
            case 10:
                return new h0((i9.b0) this.f1393g, (String) this.f1394h, cVar, 10);
            case 11:
                return new h0((AgentSafetyApplication) this.f1394h, cVar, 11);
            case 12:
                h0 h0Var5 = new h0((MidnightSyncWorker) this.f1394h, cVar, 12);
                h0Var5.f1393g = obj;
                return h0Var5;
            case 13:
                return new h0((l5.e) this.f1393g, (mc.r) this.f1394h, cVar, 13);
            case 14:
                h0 h0Var6 = new h0((m5.b) this.f1394h, cVar, 14);
                h0Var6.f1393g = obj;
                return h0Var6;
            case 15:
                return new h0((m8.k0) this.f1393g, (s8.t) this.f1394h, cVar, 15);
            case 16:
                return new h0((m8.k0) this.f1393g, (k8.a) this.f1394h, cVar, 16);
            case 17:
                return new h0((m8.k0) this.f1393g, (xb.l) this.f1394h, cVar, 17);
            case 18:
                return new h0((m8.k0) this.f1393g, (LocalDate) this.f1394h, cVar, 18);
            case 19:
                h0 h0Var7 = new h0((m8.k0) this.f1394h, cVar, 19);
                h0Var7.f1393g = obj;
                return h0Var7;
            case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL /* 20 */:
                return new h0((xb.p) this.f1394h, this.f1393g, cVar, 20);
            case PolicyBasicListVO.TYPE_ID_LIST_ICON_SMALL_WITH_SUBTITLE /* 21 */:
                return new h0((xb.p) this.f1394h, this.f1393g, cVar, 21);
            case PolicyBasicListVO.TYPE_ID_LIST_ICON_MIDDLE /* 22 */:
                h0 h0Var8 = new h0((oc.e) this.f1394h, cVar, 22);
                h0Var8.f1393g = obj;
                return h0Var8;
            case PolicyBasicListVO.TYPE_ID_LIST_ICON_LARGE /* 23 */:
                h0 h0Var9 = new h0((oc.f) this.f1394h, cVar, 23);
                h0Var9.f1393g = obj;
                return h0Var9;
            case InsecureNonceXChaCha20.NONCE_SIZE_IN_BYTES /* 24 */:
                h0 h0Var10 = new h0((nc.h) this.f1394h, cVar, 24);
                h0Var10.f1393g = obj;
                return h0Var10;
            case PolicyBasicListVO.TYPE_ID_LIST_AVATAR /* 25 */:
                return new h0((List) this.f1393g, this.f1392f, (xb.l) this.f1394h, cVar);
            case PolicyBasicListVO.TYPE_ID_LIST_AVATAR_WITH_SUBTITLE /* 26 */:
                return new h0((v.k) this.f1393g, (v.h) this.f1394h, cVar, 26);
            case PolicyBasicListVO.TYPE_ID_LIST_AVATAR_WITH_DESC /* 27 */:
                return new h0((v.k) this.f1393g, (v.i) this.f1394h, cVar, 27);
            case 28:
                h0 h0Var11 = new h0((t.d) this.f1394h, cVar, 28);
                h0Var11.f1393g = obj;
                return h0Var11;
            default:
                h0 h0Var12 = new h0((t.f) this.f1394h, cVar, 29);
                h0Var12.f1393g = obj;
                return h0Var12;
        }
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) throws Throwable {
        switch (this.f1391c) {
            case 1:
                ((h0) create((kc.t) obj, (nb.c) obj2)).invokeSuspend(jb.v.f6774a);
                break;
            case PolicyBasicListVO.TYPE_ID_LIST_AVATAR /* 25 */:
                h0 h0Var = (h0) create((kc.t) obj, (nb.c) obj2);
                jb.v vVar = jb.v.f6774a;
                h0Var.invokeSuspend(vVar);
                break;
        }
        return ((h0) create((o1.w) obj, (nb.c) obj2)).invokeSuspend(jb.v.f6774a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:259:0x057b, code lost:
    
        if (r0.k(r5, r1, r2, r8, java.lang.System.currentTimeMillis(), r13) == r9) goto L260;
     */
    /* JADX WARN: Code restructure failed: missing block: B:286:0x05f0, code lost:
    
        if (r1.n(r13) != r0) goto L288;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:235:0x0491  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x04c7 A[PHI: r1
      0x04c7: PHI (r1v41 java.lang.Object) = (r1v40 java.lang.Object), (r1v51 java.lang.Object) binds: [B:240:0x04c3, B:224:0x0447] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:244:0x04cb  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x04e8  */
    /* JADX WARN: Removed duplicated region for block: B:284:0x05e7  */
    /* JADX WARN: Removed duplicated region for block: B:330:0x0701  */
    /* JADX WARN: Removed duplicated region for block: B:333:0x0713  */
    /* JADX WARN: Type inference failed for: r0v54, types: [jb.h] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:331:0x070f -> B:325:0x06ee). Please report as a decompilation issue!!! */
    @Override // pb.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 2312
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.h0.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ h0(Object obj, nb.c cVar, int i) {
        super(2, cVar);
        this.f1391c = i;
        this.f1394h = obj;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ h0(Object obj, Object obj2, nb.c cVar, int i) {
        super(2, cVar);
        this.f1391c = i;
        this.f1393g = obj;
        this.f1394h = obj2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ h0(xb.p pVar, Object obj, nb.c cVar, int i) {
        super(2, cVar);
        this.f1391c = i;
        this.f1394h = pVar;
        this.f1393g = obj;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h0(String[] strArr, androidx.room.g gVar, nb.c cVar) {
        super(2, cVar);
        this.f1391c = 1;
        this.f1394h = strArr;
    }
}
