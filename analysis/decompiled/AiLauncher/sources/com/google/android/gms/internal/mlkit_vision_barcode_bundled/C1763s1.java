package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.util.NoSuchElementException;

/* renamed from: com.google.android.gms.internal.mlkit_vision_barcode_bundled.s1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1763s1 extends AbstractC1696c0 {

    /* renamed from: a, reason: collision with root package name */
    public final C1783x1 f20136a;

    /* renamed from: b, reason: collision with root package name */
    public InterfaceC1706e0 f20137b = a();

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzgd f20138c;

    public C1763s1(zzgd zzgdVar) {
        this.f20138c = zzgdVar;
        this.f20136a = new C1783x1(zzgdVar, null);
    }

    public final InterfaceC1706e0 a() {
        C1783x1 c1783x1 = this.f20136a;
        if (c1783x1.hasNext()) {
            return c1783x1.next().iterator();
        }
        return null;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f20137b != null;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.InterfaceC1706e0
    public final byte zza() {
        InterfaceC1706e0 interfaceC1706e0 = this.f20137b;
        if (interfaceC1706e0 == null) {
            throw new NoSuchElementException();
        }
        byte bZza = interfaceC1706e0.zza();
        if (!this.f20137b.hasNext()) {
            this.f20137b = a();
        }
        return bZza;
    }
}
