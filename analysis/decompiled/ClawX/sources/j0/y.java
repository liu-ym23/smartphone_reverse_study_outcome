package j0;

import java.io.Serializable;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class y extends h5.i implements p5.l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3464a = 1;

    /* renamed from: b, reason: collision with root package name */
    public int f3465b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ c0 f3466c;
    public Object d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f3467e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Serializable f3468f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public y(c0 c0Var, f5.h hVar, p5.p pVar, f5.c cVar) {
        super(1, cVar);
        this.f3466c = c0Var;
        this.f3467e = hVar;
        this.f3468f = (h5.i) pVar;
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [h5.i, p5.p] */
    @Override // h5.a
    public final f5.c create(f5.c cVar) {
        switch (this.f3464a) {
            case 0:
                return new y((kotlin.jvm.internal.y) this.f3467e, this.f3466c, (kotlin.jvm.internal.w) this.f3468f, cVar);
            default:
                return new y(this.f3466c, (f5.h) this.f3467e, (p5.p) this.f3468f, cVar);
        }
    }

    @Override // p5.l
    public final Object invoke(Object obj) {
        f5.c cVar = (f5.c) obj;
        switch (this.f3464a) {
        }
        return ((y) create(cVar)).invokeSuspend(b5.a0.f883a);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x007b  */
    /* JADX WARN: Type inference failed for: r7v2, types: [h5.i, p5.p] */
    @Override // h5.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            Method dump skipped, instructions count: 268
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j0.y.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(kotlin.jvm.internal.y yVar, c0 c0Var, kotlin.jvm.internal.w wVar, f5.c cVar) {
        super(1, cVar);
        this.f3467e = yVar;
        this.f3466c = c0Var;
        this.f3468f = wVar;
    }
}
