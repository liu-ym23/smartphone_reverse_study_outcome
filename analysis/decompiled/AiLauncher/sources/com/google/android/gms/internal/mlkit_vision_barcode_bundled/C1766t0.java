package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.io.IOException;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.mlkit_vision_barcode_bundled.t0, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1766t0 extends AbstractC1762s0 {
    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.AbstractC1762s0
    public final void a(Object obj) {
        ((C0) obj).zzb.g();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.AbstractC1762s0
    public final void b(Z1 z12, Map.Entry entry) throws IOException {
        D0 d02 = (D0) entry.getKey();
        zzhf zzhfVar = zzhf.zza;
        switch (d02.f20012b.ordinal()) {
            case 0:
                z12.k(d02.f20011a, ((Double) entry.getValue()).doubleValue());
                break;
            case 1:
                z12.D(d02.f20011a, ((Float) entry.getValue()).floatValue());
                break;
            case 2:
                z12.e(d02.f20011a, ((Long) entry.getValue()).longValue());
                break;
            case 3:
                z12.K(d02.f20011a, ((Long) entry.getValue()).longValue());
                break;
            case 4:
                z12.i(d02.f20011a, ((Integer) entry.getValue()).intValue());
                break;
            case 5:
                z12.I(d02.f20011a, ((Long) entry.getValue()).longValue());
                break;
            case 6:
                z12.v(d02.f20011a, ((Integer) entry.getValue()).intValue());
                break;
            case 7:
                z12.c(d02.f20011a, ((Boolean) entry.getValue()).booleanValue());
                break;
            case 8:
                z12.b(d02.f20011a, (String) entry.getValue());
                break;
            case 9:
                z12.C(d02.f20011a, entry.getValue(), C1752p1.a().b(entry.getValue().getClass()));
                break;
            case 10:
                z12.d(d02.f20011a, entry.getValue(), C1752p1.a().b(entry.getValue().getClass()));
                break;
            case 11:
                z12.j(d02.f20011a, (zzdf) entry.getValue());
                break;
            case 12:
                z12.t(d02.f20011a, ((Integer) entry.getValue()).intValue());
                break;
            case 13:
                z12.i(d02.f20011a, ((Integer) entry.getValue()).intValue());
                break;
            case 14:
                z12.o(d02.f20011a, ((Integer) entry.getValue()).intValue());
                break;
            case 15:
                z12.y(d02.f20011a, ((Long) entry.getValue()).longValue());
                break;
            case 16:
                z12.q(d02.f20011a, ((Integer) entry.getValue()).intValue());
                break;
            case 17:
                z12.l(d02.f20011a, ((Long) entry.getValue()).longValue());
                break;
        }
    }
}
