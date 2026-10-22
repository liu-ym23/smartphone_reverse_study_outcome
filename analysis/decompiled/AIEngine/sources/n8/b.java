package n8;

import lb.n;
import zb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b implements l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10650a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ okhttp3.internal.connection.d f10651b;

    public /* synthetic */ b(Object obj, okhttp3.internal.connection.d dVar, int i10) {
        this.f10650a = i10;
        this.f10651b = dVar;
    }

    @Override // zb.l
    public final Object invoke(Object obj) {
        int i10 = this.f10650a;
        okhttp3.internal.connection.d dVar = this.f10651b;
        switch (i10) {
            case 0:
                try {
                    dVar.cancel();
                    n nVar = n.f10413a;
                } catch (Throwable th) {
                    kotlin.c.a(th);
                }
                break;
            default:
                try {
                    dVar.cancel();
                    n nVar2 = n.f10413a;
                } catch (Throwable th2) {
                    kotlin.c.a(th2);
                }
                break;
        }
        return n.f10413a;
    }
}
