package u4;

import V3.v;
import i4.InterfaceC0772l;
import j4.w;
import x4.O;
import x4.x;

/* renamed from: u4.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1172j<E> extends C1164b<E> {

    /* renamed from: n, reason: collision with root package name */
    private final int f22969n;

    /* renamed from: o, reason: collision with root package name */
    private final EnumC1163a f22970o;

    public C1172j(int i5, EnumC1163a enumC1163a, InterfaceC0772l<? super E, v> interfaceC0772l) {
        super(i5, interfaceC0772l);
        this.f22969n = i5;
        this.f22970o = enumC1163a;
        if (enumC1163a == EnumC1163a.f22914a) {
            throw new IllegalArgumentException(("This implementation does not support suspension for senders, use " + w.b(C1164b.class).b() + " instead").toString());
        }
        if (i5 >= 1) {
            return;
        }
        throw new IllegalArgumentException(("Buffered channel capacity must be at least 1, but " + i5 + " was specified").toString());
    }

    private final Object H0(E e6, boolean z5) {
        InterfaceC0772l<E, v> interfaceC0772l;
        O oD;
        Object objD = super.d(e6);
        if (C1168f.i(objD) || C1168f.h(objD)) {
            return objD;
        }
        if (!z5 || (interfaceC0772l = this.f22929c) == null || (oD = x.d(interfaceC0772l, e6, null, 2, null)) == null) {
            return C1168f.f22963b.c(v.f5542a);
        }
        throw oD;
    }

    private final Object I0(E e6, boolean z5) {
        return this.f22970o == EnumC1163a.f22916c ? H0(e6, z5) : x0(e6);
    }

    @Override // u4.C1164b
    protected boolean b0() {
        return this.f22970o == EnumC1163a.f22915b;
    }

    @Override // u4.C1164b, u4.InterfaceC1175m
    public Object d(E e6) {
        return I0(e6, false);
    }
}
