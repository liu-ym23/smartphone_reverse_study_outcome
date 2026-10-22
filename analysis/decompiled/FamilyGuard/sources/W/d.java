package W;

import X.j;
import androidx.lifecycle.T;
import androidx.lifecycle.U;
import androidx.lifecycle.W;
import j4.k;
import p4.InterfaceC0929b;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private final W f5715a;

    /* renamed from: b, reason: collision with root package name */
    private final U.c f5716b;

    /* renamed from: c, reason: collision with root package name */
    private final a f5717c;

    public d(W w5, U.c cVar, a aVar) {
        k.g(w5, "store");
        k.g(cVar, "factory");
        k.g(aVar, "extras");
        this.f5715a = w5;
        this.f5716b = cVar;
        this.f5717c = aVar;
    }

    public static /* synthetic */ T b(d dVar, InterfaceC0929b interfaceC0929b, String str, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            str = j.f5773a.c(interfaceC0929b);
        }
        return dVar.a(interfaceC0929b, str);
    }

    public final <T extends T> T a(InterfaceC0929b<T> interfaceC0929b, String str) {
        k.g(interfaceC0929b, "modelClass");
        k.g(str, "key");
        T t5 = (T) this.f5715a.b(str);
        if (!interfaceC0929b.c(t5)) {
            b bVar = new b(this.f5717c);
            bVar.c(j.a.f5774a, str);
            T t6 = (T) e.a(this.f5716b, interfaceC0929b, bVar);
            this.f5715a.d(str, t6);
            return t6;
        }
        Object obj = this.f5716b;
        if (obj instanceof U.e) {
            k.d(t5);
            ((U.e) obj).d(t5);
        }
        k.e(t5, "null cannot be cast to non-null type T of androidx.lifecycle.viewmodel.ViewModelProviderImpl.getViewModel");
        return t5;
    }
}
