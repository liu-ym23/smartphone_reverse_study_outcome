package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.S;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.T;
import java.io.IOException;

/* loaded from: classes2.dex */
public abstract class T<MessageType extends T<MessageType, BuilderType>, BuilderType extends S<MessageType, BuilderType>> implements InterfaceC1720h1 {
    protected int zza = 0;

    public int b(InterfaceC1791z1 interfaceC1791z1) {
        throw null;
    }

    public final byte[] c() {
        try {
            int iA = a();
            byte[] bArr = new byte[iA];
            C1731k0 c1731k0 = new C1731k0(bArr, 0, iA);
            d(c1731k0);
            c1731k0.c();
            return bArr;
        } catch (IOException e10) {
            throw new RuntimeException("Serializing " + getClass().getName() + " to a byte array threw an IOException (should never happen).", e10);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.InterfaceC1720h1
    public final zzdf i() {
        try {
            int iA = a();
            zzdf zzdfVar = zzdf.f20159b;
            byte[] bArr = new byte[iA];
            C1731k0 c1731k0 = new C1731k0(bArr, 0, iA);
            d(c1731k0);
            c1731k0.c();
            return new zzde(bArr);
        } catch (IOException e10) {
            throw new RuntimeException("Serializing " + getClass().getName() + " to a ByteString threw an IOException (should never happen).", e10);
        }
    }
}
