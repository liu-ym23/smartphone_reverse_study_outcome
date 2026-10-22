package p;

import java.util.List;
import o4.t1;
import o4.y1;

/* loaded from: classes.dex */
public final class v extends i7.i implements p7.n {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f8190f;

    /* renamed from: g, reason: collision with root package name */
    public int f8191g;

    /* renamed from: h, reason: collision with root package name */
    public Object f8192h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ Object f8193i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ v(Object obj, g7.d dVar, int i2) {
        super(2, dVar);
        this.f8190f = i2;
        this.f8193i = obj;
    }

    /* JADX WARN: Type inference failed for: r0v8, types: [i7.i, p7.n] */
    @Override // i7.a
    public final g7.d create(Object obj, g7.d dVar) {
        switch (this.f8190f) {
            case 0:
                v vVar = new v((s0) this.f8193i, dVar, 0);
                vVar.f8192h = obj;
                return vVar;
            case 1:
                return new v((p5.h) this.f8192h, (d5.e) this.f8193i, dVar, 1);
            case 2:
                return new v((s.d) this.f8192h, (eb.k) this.f8193i, dVar, 2);
            case 3:
                v vVar2 = new v((List) this.f8193i, dVar, 3);
                vVar2.f8192h = obj;
                return vVar2;
            case 4:
                return new v((p7.n) this.f8192h, (s2.c) this.f8193i, dVar);
            case 5:
                return new v((i5.f) this.f8193i, dVar, 5);
            case 6:
                return new v((x4.i) this.f8192h, (v4.k) this.f8193i, dVar, 6);
            case 7:
                return new v((c.i) this.f8192h, (v4.k) this.f8193i, dVar, 7);
            case 8:
                v vVar3 = new v((x.p) this.f8193i, dVar, 8);
                vVar3.f8192h = obj;
                return vVar3;
            case 9:
                return new v((c1.o) this.f8192h, (n.h) this.f8193i, dVar, 9);
            case 10:
                return new v((x4.i) this.f8192h, (byte[]) this.f8193i, dVar, 10);
            case 11:
                return new v((q.i) this.f8192h, (l0.q) this.f8193i, dVar, 11);
            case 12:
                v vVar4 = new v((y1) this.f8193i, dVar, 12);
                vVar4.f8192h = obj;
                return vVar4;
            case 13:
                return new v((y1) this.f8192h, (List) this.f8193i, dVar, 13);
            case com.google.protobuf.y0.EDITION_FIELD_NUMBER /* 14 */:
                return new v((t1) this.f8192h, (y1) this.f8193i, dVar, 14);
            default:
                v vVar5 = new v((y4.t) this.f8193i, dVar, 15);
                vVar5.f8192h = obj;
                return vVar5;
        }
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) throws Throwable {
        switch (this.f8190f) {
            case 0:
                return ((v) create((c1.q) obj, (g7.d) obj2)).invokeSuspend(c7.r.f1986a);
            case 1:
                return ((v) create((ia.b0) obj, (g7.d) obj2)).invokeSuspend(c7.r.f1986a);
            case 2:
                return ((v) create((ia.b0) obj, (g7.d) obj2)).invokeSuspend(c7.r.f1986a);
            case 3:
                return ((v) create((s2.i) obj, (g7.d) obj2)).invokeSuspend(c7.r.f1986a);
            case 4:
                return ((v) create((ia.b0) obj, (g7.d) obj2)).invokeSuspend(c7.r.f1986a);
            case 5:
                return ((v) create((ia.b0) obj, (g7.d) obj2)).invokeSuspend(c7.r.f1986a);
            case 6:
                ((v) create((ia.b0) obj, (g7.d) obj2)).invokeSuspend(c7.r.f1986a);
                return h7.a.f4212f;
            case 7:
                return ((v) create((ia.b0) obj, (g7.d) obj2)).invokeSuspend(c7.r.f1986a);
            case 8:
                return ((v) create((ia.b0) obj, (g7.d) obj2)).invokeSuspend(c7.r.f1986a);
            case 9:
                return ((v) create((ia.b0) obj, (g7.d) obj2)).invokeSuspend(c7.r.f1986a);
            case 10:
                return ((v) create((ia.b0) obj, (g7.d) obj2)).invokeSuspend(c7.r.f1986a);
            case 11:
                return ((v) create((ia.b0) obj, (g7.d) obj2)).invokeSuspend(c7.r.f1986a);
            case 12:
                return ((v) create((k5.h) obj, (g7.d) obj2)).invokeSuspend(c7.r.f1986a);
            case 13:
                return ((v) create((ia.b0) obj, (g7.d) obj2)).invokeSuspend(c7.r.f1986a);
            case com.google.protobuf.y0.EDITION_FIELD_NUMBER /* 14 */:
                return ((v) create((ia.b0) obj, (g7.d) obj2)).invokeSuspend(c7.r.f1986a);
            default:
                return ((v) create((o4.k0) obj, (g7.d) obj2)).invokeSuspend(c7.r.f1986a);
        }
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /* JADX WARN: Removed duplicated region for block: B:214:0x047b  */
    /* JADX WARN: Removed duplicated region for block: B:319:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:320:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v18, types: [i7.i, p7.n] */
    /* JADX WARN: Type inference failed for: r5v47, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:210:0x046a -> B:212:0x046d). Please report as a decompilation issue!!! */
    @Override // i7.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1568
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p.v.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ v(Object obj, Object obj2, g7.d dVar, int i2) {
        super(2, dVar);
        this.f8190f = i2;
        this.f8192h = obj;
        this.f8193i = obj2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public v(p7.n nVar, s2.c cVar, g7.d dVar) {
        super(2, dVar);
        this.f8190f = 4;
        this.f8192h = (i7.i) nVar;
        this.f8193i = cVar;
    }
}
