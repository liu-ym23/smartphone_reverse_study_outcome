package u4;

import V3.v;
import i4.InterfaceC0772l;

/* renamed from: u4.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1167e {
    public static final <E> InterfaceC1166d<E> a(int i5, EnumC1163a enumC1163a, InterfaceC0772l<? super E, v> interfaceC0772l) {
        if (i5 == -2) {
            return enumC1163a == EnumC1163a.f22914a ? new C1164b(InterfaceC1166d.f22960a.a(), interfaceC0772l) : new C1172j(1, enumC1163a, interfaceC0772l);
        }
        if (i5 != -1) {
            return i5 != 0 ? i5 != Integer.MAX_VALUE ? enumC1163a == EnumC1163a.f22914a ? new C1164b(i5, interfaceC0772l) : new C1172j(i5, enumC1163a, interfaceC0772l) : new C1164b(Integer.MAX_VALUE, interfaceC0772l) : enumC1163a == EnumC1163a.f22914a ? new C1164b(0, interfaceC0772l) : new C1172j(1, enumC1163a, interfaceC0772l);
        }
        if (enumC1163a == EnumC1163a.f22914a) {
            return new C1172j(1, EnumC1163a.f22915b, interfaceC0772l);
        }
        throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow");
    }

    public static /* synthetic */ InterfaceC1166d b(int i5, EnumC1163a enumC1163a, InterfaceC0772l interfaceC0772l, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i5 = 0;
        }
        if ((i6 & 2) != 0) {
            enumC1163a = EnumC1163a.f22914a;
        }
        if ((i6 & 4) != 0) {
            interfaceC0772l = null;
        }
        return a(i5, enumC1163a, interfaceC0772l);
    }
}
