package r2;

import jb.v;
import kc.t;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e extends pb.i implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public int f10377c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ boolean f10378f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ h f10379g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ long f10380h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(boolean z10, h hVar, long j10, nb.c cVar) {
        super(2, cVar);
        this.f10378f = z10;
        this.f10379g = hVar;
        this.f10380h = j10;
    }

    @Override // pb.a
    public final nb.c create(Object obj, nb.c cVar) {
        return new e(this.f10378f, this.f10379g, this.f10380h, cVar);
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        return ((e) create((t) obj, (nb.c) obj2)).invokeSuspend(v.f6774a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0031, code lost:
    
        if (r11 == r0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0045, code lost:
    
        if (r11 == r0) goto L18;
     */
    @Override // pb.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) {
        /*
            r10 = this;
            ob.a r0 = ob.a.f9351c
            int r1 = r10.f10377c
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1b
            if (r1 == r3) goto L17
            if (r1 != r2) goto L10
            id.c.I(r11)
            goto L48
        L10:
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            od.f.e(r10)
            r10 = 0
            return r10
        L17:
            id.c.I(r11)
            goto L34
        L1b:
            id.c.I(r11)
            r2.h r11 = r10.f10379g
            n1.d r4 = r11.f10387c
            boolean r11 = r10.f10378f
            if (r11 != 0) goto L3a
            r10.f10377c = r3
            r5 = 0
            long r7 = r10.f10380h
            r9 = r10
            java.lang.Object r11 = r4.a(r5, r7, r9)
            if (r11 != r0) goto L34
            goto L47
        L34:
            o2.p r11 = (o2.p) r11
            r11.getClass()
            goto L4d
        L3a:
            r9 = r10
            r9.f10377c = r2
            long r5 = r9.f10380h
            r7 = 0
            java.lang.Object r11 = r4.a(r5, r7, r9)
            if (r11 != r0) goto L48
        L47:
            return r0
        L48:
            o2.p r11 = (o2.p) r11
            r11.getClass()
        L4d:
            jb.v r10 = jb.v.f6774a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: r2.e.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
