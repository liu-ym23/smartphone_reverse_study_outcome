package a1;

import H.h;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public static final M9.f f1629a;

    static {
        M9.f fVar = new M9.f();
        fVar.f981a = new AtomicBoolean(false);
        try {
            fVar.f = S0.b.h(h.f711a);
        } catch (Throwable unused) {
        }
        K1.a aVar = (K1.a) fVar.f;
        d dVar = new d();
        dVar.f1630a = new AtomicBoolean(false);
        dVar.c = aVar;
        fVar.c = dVar;
        K1.a aVar2 = (K1.a) fVar.f;
        e eVar = new e();
        eVar.f1632j = true;
        eVar.b = new AtomicBoolean(false);
        eVar.f1631a = dVar;
        eVar.i = aVar2;
        fVar.b = eVar;
        f1629a = fVar;
    }
}
