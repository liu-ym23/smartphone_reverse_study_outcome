package a6;

import com.google.protobuf.x0;
import com.google.protobuf.y0;
import ia.g0;
import o4.t1;
import o4.t2;
import o4.y1;
import p.h0;

/* loaded from: classes.dex */
public final class r extends i7.i implements p7.n {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f363f;

    /* renamed from: g, reason: collision with root package name */
    public int f364g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Object f365h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ r(Object obj, g7.d dVar, int i2) {
        super(2, dVar);
        this.f363f = i2;
        this.f365h = obj;
    }

    @Override // i7.a
    public final g7.d create(Object obj, g7.d dVar) {
        switch (this.f363f) {
            case 0:
                return new r((a4.p) this.f365h, dVar, 0);
            case 1:
                return new r((c1.x) this.f365h, dVar, 1);
            case 2:
                return new r((a3.b) this.f365h, dVar, 2);
            case 3:
                return new r((m5.h) this.f365h, dVar, 3);
            case 4:
                return new r((m5.j) this.f365h, dVar, 4);
            case 5:
                return new r((o.v) this.f365h, dVar, 5);
            case 6:
                return new r((o.b0) this.f365h, dVar, 6);
            case 7:
                return new r((t1) this.f365h, dVar, 7);
            case 8:
                return new r((t2) this.f365h, dVar, 8);
            case 9:
                return new r((o5.e) this.f365h, dVar, 9);
            case 10:
                return new r((h0) this.f365h, dVar, 10);
            case 11:
                return new r((t4.g) this.f365h, dVar, 11);
            case 12:
                return new r((u4.h) this.f365h, dVar, 12);
            case 13:
                return new r((c6.l) this.f365h, dVar, 13);
            case y0.EDITION_FIELD_NUMBER /* 14 */:
                return new r((v4.p) this.f365h, dVar, 14);
            case x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
                return new r((String) this.f365h, dVar, 15);
            case 16:
                return new r((g0) this.f365h, dVar, 16);
            default:
                return new r((y1) this.f365h, dVar, 17);
        }
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) throws Throwable {
        ia.b0 b0Var = (ia.b0) obj;
        g7.d dVar = (g7.d) obj2;
        switch (this.f363f) {
            case 8:
                ((r) create(b0Var, dVar)).invokeSuspend(c7.r.f1986a);
                break;
        }
        return ((r) create(b0Var, dVar)).invokeSuspend(c7.r.f1986a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0270  */
    /* JADX WARN: Type inference failed for: r2v7, types: [i7.i, p7.n] */
    @Override // i7.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 992
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a6.r.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
