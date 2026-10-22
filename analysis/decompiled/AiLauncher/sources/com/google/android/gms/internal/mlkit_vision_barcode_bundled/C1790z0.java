package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* renamed from: com.google.android.gms.internal.mlkit_vision_barcode_bundled.z0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1790z0 implements InterfaceC1712f1 {

    /* renamed from: a, reason: collision with root package name */
    public static final C1790z0 f20154a = new C1790z0();

    public static C1790z0 c() {
        return f20154a;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.InterfaceC1712f1
    public final InterfaceC1707e1 a(Class cls) {
        if (!F0.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Unsupported message type: ".concat(cls.getName()));
        }
        try {
            return (InterfaceC1707e1) F0.n(cls.asSubclass(F0.class)).F(3, null, null);
        } catch (Exception e10) {
            throw new RuntimeException("Unable to get message info for ".concat(cls.getName()), e10);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.InterfaceC1712f1
    public final boolean b(Class cls) {
        return F0.class.isAssignableFrom(cls);
    }
}
