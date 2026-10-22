package v4;

import ia.b0;

/* loaded from: classes.dex */
public final class f extends i7.i implements p7.n {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f10405f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ k f10406g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ f(k kVar, g7.d dVar, int i2) {
        super(2, dVar);
        this.f10405f = i2;
        this.f10406g = kVar;
    }

    @Override // i7.a
    public final g7.d create(Object obj, g7.d dVar) {
        switch (this.f10405f) {
            case 0:
                return new f(this.f10406g, dVar, 0);
            case 1:
                return new f(this.f10406g, dVar, 1);
            case 2:
                return new f(this.f10406g, dVar, 2);
            case 3:
                return new f(this.f10406g, dVar, 3);
            case 4:
                return new f(this.f10406g, dVar, 4);
            default:
                return new f(this.f10406g, dVar, 5);
        }
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        b0 b0Var = (b0) obj;
        g7.d dVar = (g7.d) obj2;
        switch (this.f10405f) {
            case 0:
                f fVar = (f) create(b0Var, dVar);
                c7.r rVar = c7.r.f1986a;
                fVar.invokeSuspend(rVar);
                break;
        }
        return ((f) create(b0Var, dVar)).invokeSuspend(c7.r.f1986a);
    }

    /* JADX WARN: Removed duplicated region for block: B:156:0x037e A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0383 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:167:0x03ba  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x03c0 A[Catch: all -> 0x03b7, TryCatch #4 {all -> 0x03b7, blocks: (B:164:0x0395, B:169:0x03c0, B:170:0x03dd, B:173:0x03e3, B:175:0x03f6, B:178:0x040b, B:179:0x0410), top: B:255:0x0395 }] */
    /* JADX WARN: Removed duplicated region for block: B:172:0x03e1  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0409 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:213:0x059a  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x0395 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // i7.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r28) {
        /*
            Method dump skipped, instructions count: 1702
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: v4.f.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
