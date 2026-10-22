package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
public final class C1 extends J1 {
    public C1() {
        super(null);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.J1
    public final void b() {
        if (!m()) {
            for (int i10 = 0; i10 < d(); i10++) {
                ((InterfaceC1774v0) ((D1) i(i10)).a()).zzg();
            }
            Iterator it = e().iterator();
            while (it.hasNext()) {
                ((InterfaceC1774v0) ((Map.Entry) it.next()).getKey()).zzg();
            }
        }
        super.b();
    }
}
