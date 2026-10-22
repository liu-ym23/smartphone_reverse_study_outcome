package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.util.NoSuchElementException;

/* renamed from: com.google.android.gms.internal.mlkit_vision_barcode_bundled.b0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1691b0 extends AbstractC1696c0 {

    /* renamed from: a, reason: collision with root package name */
    public int f20078a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final int f20079b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzdf f20080c;

    public C1691b0(zzdf zzdfVar) {
        this.f20080c = zzdfVar;
        this.f20079b = zzdfVar.f();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f20078a < this.f20079b;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.InterfaceC1706e0
    public final byte zza() {
        int i10 = this.f20078a;
        if (i10 >= this.f20079b) {
            throw new NoSuchElementException();
        }
        this.f20078a = i10 + 1;
        return this.f20080c.c(i10);
    }
}
