package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* loaded from: classes2.dex */
public class B0 extends A0 implements InterfaceC1724i1 {
    public B0(C0 c02) {
        super(c02);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.A0
    public final void s() {
        super.s();
        if (((C0) this.f20007b).zzb != C1778w0.d()) {
            C0 c02 = (C0) this.f20007b;
            c02.zzb = c02.zzb.clone();
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.A0
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public final C0 G() {
        if (!((C0) this.f20007b).C()) {
            return (C0) this.f20007b;
        }
        ((C0) this.f20007b).zzb.g();
        return (C0) super.G();
    }
}
