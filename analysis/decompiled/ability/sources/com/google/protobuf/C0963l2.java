package com.google.protobuf;

import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.google.protobuf.l2, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0963l2 {
    public static final C0963l2 c = new C0963l2();
    public final ConcurrentHashMap b = new ConcurrentHashMap();

    /* renamed from: a, reason: collision with root package name */
    public final F1 f2928a = new F1();

    public final InterfaceC0979p2 a(Class cls) {
        InterfaceC0979p2 interfaceC0979p2X;
        Class cls2;
        AbstractC0989s1.a(cls, "messageType");
        ConcurrentHashMap concurrentHashMap = this.b;
        InterfaceC0979p2 interfaceC0979p2 = (InterfaceC0979p2) concurrentHashMap.get(cls);
        if (interfaceC0979p2 != null) {
            return interfaceC0979p2;
        }
        F1 f12 = this.f2928a;
        f12.getClass();
        Class cls3 = AbstractC0983q2.f2936a;
        if (!GeneratedMessageLite.class.isAssignableFrom(cls) && (cls2 = AbstractC0983q2.f2936a) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessageV3 or GeneratedMessageLite");
        }
        U1 u1MessageInfoFor = ((E1) f12.b).messageInfoFor(cls);
        if (u1MessageInfoFor.isMessageSetWireFormat()) {
            if (GeneratedMessageLite.class.isAssignableFrom(cls)) {
                interfaceC0979p2X = new C0935e2(AbstractC0983q2.c, V0.f2877a, u1MessageInfoFor.getDefaultInstance());
            } else {
                H2 h22 = AbstractC0983q2.b;
                S0 s0 = V0.b;
                if (s0 == null) {
                    throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
                }
                interfaceC0979p2X = new C0935e2(h22, s0, u1MessageInfoFor.getDefaultInstance());
            }
        } else if (GeneratedMessageLite.class.isAssignableFrom(cls)) {
            interfaceC0979p2X = u1MessageInfoFor.getSyntax().ordinal() != 1 ? C0931d2.x(u1MessageInfoFor, AbstractC0951i2.b, A1.b, AbstractC0983q2.c, V0.f2877a, T1.b) : C0931d2.x(u1MessageInfoFor, AbstractC0951i2.b, A1.b, AbstractC0983q2.c, null, T1.b);
        } else if (u1MessageInfoFor.getSyntax().ordinal() != 1) {
            InterfaceC0939f2 interfaceC0939f2 = AbstractC0951i2.f2924a;
            C1013y1 c1013y1 = A1.f2756a;
            H2 h23 = AbstractC0983q2.b;
            S0 s02 = V0.b;
            if (s02 == null) {
                throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
            }
            interfaceC0979p2X = C0931d2.x(u1MessageInfoFor, interfaceC0939f2, c1013y1, h23, s02, T1.f2876a);
        } else {
            interfaceC0979p2X = C0931d2.x(u1MessageInfoFor, AbstractC0951i2.f2924a, A1.f2756a, AbstractC0983q2.b, null, T1.f2876a);
        }
        InterfaceC0979p2 interfaceC0979p22 = (InterfaceC0979p2) concurrentHashMap.putIfAbsent(cls, interfaceC0979p2X);
        return interfaceC0979p22 != null ? interfaceC0979p22 : interfaceC0979p2X;
    }
}
