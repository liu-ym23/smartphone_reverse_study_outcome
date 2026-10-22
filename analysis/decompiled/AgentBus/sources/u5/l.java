package u5;

import ia.b0;
import java.io.PrintWriter;
import w7.e0;

/* loaded from: classes.dex */
public final class l extends i7.i implements p7.n {

    /* renamed from: f, reason: collision with root package name */
    public int f10143f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f10144g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ t f10145h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ s f10146i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ PrintWriter f10147j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(t tVar, s sVar, PrintWriter printWriter, g7.d dVar) {
        super(2, dVar);
        this.f10145h = tVar;
        this.f10146i = sVar;
        this.f10147j = printWriter;
    }

    @Override // i7.a
    public final g7.d create(Object obj, g7.d dVar) {
        l lVar = new l(this.f10145h, this.f10146i, this.f10147j, dVar);
        lVar.f10144g = obj;
        return lVar;
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        return ((l) create((b0) obj, (g7.d) obj2)).invokeSuspend(c7.r.f1986a);
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        h7.a aVar = h7.a.f4212f;
        int i2 = this.f10143f;
        PrintWriter printWriter = this.f10147j;
        try {
            if (i2 == 0) {
                e0.N(obj);
                b0 b0Var = (b0) this.f10144g;
                la.e0 e0Var = this.f10145h.f10191n;
                la.g gVar = new la.g(7, this.f10146i, printWriter);
                this.f10144g = b0Var;
                this.f10143f = 1;
                if (e0Var.f5914f.x(gVar, this) == aVar) {
                    return aVar;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                e0.N(obj);
            }
        } catch (Throwable unused) {
        }
        try {
            printWriter.close();
        } catch (Throwable th) {
            e0.n(th);
        }
        return c7.r.f1986a;
    }
}
