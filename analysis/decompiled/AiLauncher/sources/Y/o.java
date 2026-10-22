package Y;

import J.InterfaceC0857l;
import Y.f;
import g3.InterfaceFutureC4095a;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* loaded from: classes.dex */
public class o extends androidx.camera.core.impl.o {

    /* renamed from: c, reason: collision with root package name */
    public final f.a f6985c;

    public o(androidx.camera.core.impl.h hVar, f.a aVar) {
        super(hVar);
        this.f6985c = aVar;
    }

    @Override // androidx.camera.core.impl.o, androidx.camera.core.impl.h
    public InterfaceFutureC4095a<List<Void>> c(final List<androidx.camera.core.impl.l> list, int i10, int i11) {
        B0.h.b(list.size() == 1, "Only support one capture config.");
        final InterfaceFutureC4095a<InterfaceC0857l> interfaceFutureC4095aG = g(i10, 1);
        return O.f.c(Collections.singletonList(O.d.b(interfaceFutureC4095aG).f(new O.a() { // from class: Y.l
            @Override // O.a
            public final InterfaceFutureC4095a apply(Object obj) {
                return ((InterfaceC0857l) interfaceFutureC4095aG.get()).a();
            }
        }, N.a.a()).f(new O.a() { // from class: Y.m
            @Override // O.a
            public final InterfaceFutureC4095a apply(Object obj) {
                o oVar = this.f6982a;
                List list2 = list;
                return oVar.f6985c.a(oVar.m((androidx.camera.core.impl.l) list2.get(0)), oVar.n((androidx.camera.core.impl.l) list2.get(0)));
            }
        }, N.a.a()).f(new O.a() { // from class: Y.n
            @Override // O.a
            public final InterfaceFutureC4095a apply(Object obj) {
                return ((InterfaceC0857l) interfaceFutureC4095aG.get()).b();
            }
        }, N.a.a())));
    }

    public final int m(androidx.camera.core.impl.l lVar) {
        Integer num = (Integer) lVar.f().g(androidx.camera.core.impl.l.f11442j, 100);
        Objects.requireNonNull(num);
        return num.intValue();
    }

    public final int n(androidx.camera.core.impl.l lVar) {
        Integer num = (Integer) lVar.f().g(androidx.camera.core.impl.l.f11441i, 0);
        Objects.requireNonNull(num);
        return num.intValue();
    }
}
