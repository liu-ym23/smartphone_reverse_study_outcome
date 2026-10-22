package y4;

import android.os.Build;
import w7.e0;

/* loaded from: classes.dex */
public final class g extends i7.i implements p7.k {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f11565f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ h f11566g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ g(h hVar, g7.d dVar, int i2) {
        super(1, dVar);
        this.f11565f = i2;
        this.f11566g = hVar;
    }

    @Override // i7.a
    public final g7.d create(g7.d dVar) {
        switch (this.f11565f) {
            case 0:
                return new g(this.f11566g, dVar, 0);
            case 1:
                return new g(this.f11566g, dVar, 1);
            default:
                return new g(this.f11566g, dVar, 2);
        }
    }

    @Override // p7.k
    public final Object invoke(Object obj) {
        g7.d dVar = (g7.d) obj;
        switch (this.f11565f) {
        }
        return ((g) create(dVar)).invokeSuspend(c7.r.f1986a);
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objN;
        int i2 = this.f11565f;
        h hVar = this.f11566g;
        switch (i2) {
            case 0:
                h7.a aVar = h7.a.f4212f;
                e0.N(obj);
                String strE = e0.E(hVar.f11567a.getApplicationContext());
                return strE == null ? "" : strE;
            case 1:
                h7.a aVar2 = h7.a.f4212f;
                e0.N(obj);
                String str = Build.MODEL;
                if (str == null) {
                    str = "unknown";
                }
                c7.j jVar = new c7.j("device_model", str);
                try {
                    objN = n7.o.p();
                } catch (Throwable th) {
                    objN = e0.n(th);
                }
                return d7.e0.U(jVar, new c7.j("os_version", objN instanceof c7.l ? "" : objN));
            default:
                h7.a aVar3 = h7.a.f4212f;
                e0.N(obj);
                String strE2 = e0.E(hVar.f11567a.getApplicationContext());
                return strE2 == null ? "" : strE2;
        }
    }
}
