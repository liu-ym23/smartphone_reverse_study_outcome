package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* renamed from: com.google.android.gms.internal.mlkit_vision_barcode_bundled.p1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1752p1 {

    /* renamed from: c, reason: collision with root package name */
    public static final C1752p1 f20120c = new C1752p1();

    /* renamed from: b, reason: collision with root package name */
    public final ConcurrentMap f20122b = new ConcurrentHashMap();

    /* renamed from: a, reason: collision with root package name */
    public final A1 f20121a = new C1687a1();

    public static C1752p1 a() {
        return f20120c;
    }

    public final InterfaceC1791z1 b(Class cls) {
        N0.c(cls, "messageType");
        InterfaceC1791z1 interfaceC1791z1 = (InterfaceC1791z1) this.f20122b.get(cls);
        if (interfaceC1791z1 != null) {
            return interfaceC1791z1;
        }
        InterfaceC1791z1 interfaceC1791z1A = this.f20121a.a(cls);
        N0.c(cls, "messageType");
        InterfaceC1791z1 interfaceC1791z12 = (InterfaceC1791z1) this.f20122b.putIfAbsent(cls, interfaceC1791z1A);
        return interfaceC1791z12 == null ? interfaceC1791z1A : interfaceC1791z12;
    }
}
