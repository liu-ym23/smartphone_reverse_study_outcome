package com.google.protobuf;

import java.util.List;

/* renamed from: com.google.protobuf.z1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1017z1 extends A1 {
    @Override // com.google.protobuf.A1
    public final void a(Object obj, long j5) {
        ((AbstractC0940g) ((InterfaceC0985r1) W2.c.k(obj, j5))).makeImmutable();
    }

    @Override // com.google.protobuf.A1
    public final void b(Object obj, Object obj2, long j5) {
        V2 v22 = W2.c;
        InterfaceC0985r1 interfaceC0985r1MutableCopyWithCapacity = (InterfaceC0985r1) v22.k(obj, j5);
        InterfaceC0985r1 interfaceC0985r1 = (InterfaceC0985r1) v22.k(obj2, j5);
        int size = interfaceC0985r1MutableCopyWithCapacity.size();
        int size2 = interfaceC0985r1.size();
        if (size > 0 && size2 > 0) {
            if (!((AbstractC0940g) interfaceC0985r1MutableCopyWithCapacity).f2920a) {
                interfaceC0985r1MutableCopyWithCapacity = interfaceC0985r1MutableCopyWithCapacity.mutableCopyWithCapacity(size2 + size);
            }
            interfaceC0985r1MutableCopyWithCapacity.addAll(interfaceC0985r1);
        }
        if (size > 0) {
            interfaceC0985r1 = interfaceC0985r1MutableCopyWithCapacity;
        }
        W2.p(obj, j5, interfaceC0985r1);
    }

    @Override // com.google.protobuf.A1
    public final List c(Object obj, long j5) {
        InterfaceC0985r1 interfaceC0985r1 = (InterfaceC0985r1) W2.c.k(obj, j5);
        if (((AbstractC0940g) interfaceC0985r1).f2920a) {
            return interfaceC0985r1;
        }
        int size = interfaceC0985r1.size();
        InterfaceC0985r1 interfaceC0985r1MutableCopyWithCapacity = interfaceC0985r1.mutableCopyWithCapacity(size == 0 ? 10 : size * 2);
        W2.p(obj, j5, interfaceC0985r1MutableCopyWithCapacity);
        return interfaceC0985r1MutableCopyWithCapacity;
    }
}
