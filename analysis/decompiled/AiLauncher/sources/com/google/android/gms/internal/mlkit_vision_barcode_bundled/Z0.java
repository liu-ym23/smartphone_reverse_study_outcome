package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* loaded from: classes2.dex */
public final class Z0 implements InterfaceC1712f1 {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC1712f1[] f20075a;

    public Z0(InterfaceC1712f1... interfaceC1712f1Arr) {
        this.f20075a = interfaceC1712f1Arr;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.InterfaceC1712f1
    public final InterfaceC1707e1 a(Class cls) {
        for (int i10 = 0; i10 < 2; i10++) {
            InterfaceC1712f1 interfaceC1712f1 = this.f20075a[i10];
            if (interfaceC1712f1.b(cls)) {
                return interfaceC1712f1.a(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(cls.getName()));
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.InterfaceC1712f1
    public final boolean b(Class cls) {
        for (int i10 = 0; i10 < 2; i10++) {
            if (this.f20075a[i10].b(cls)) {
                return true;
            }
        }
        return false;
    }
}
