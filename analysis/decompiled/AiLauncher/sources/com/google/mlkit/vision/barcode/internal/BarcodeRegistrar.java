package com.google.mlkit.vision.barcode.internal;

import com.google.android.gms.internal.mlkit_vision_barcode.zzcs;
import h3.C4127c;
import h3.C4139o;
import h3.InterfaceC4128d;
import h3.InterfaceC4131g;
import h3.InterfaceC4132h;
import java.util.List;
import r3.C5210d;
import r3.C5214h;
import w3.C5729f;
import w3.C5731h;

/* loaded from: classes2.dex */
public class BarcodeRegistrar implements InterfaceC4132h {
    @Override // h3.InterfaceC4132h
    public final List a() {
        return zzcs.l(C4127c.a(C5731h.class).b(C4139o.g(C5214h.class)).d(new InterfaceC4131g() { // from class: w3.c
            @Override // h3.InterfaceC4131g
            public final Object a(InterfaceC4128d interfaceC4128d) {
                return new C5731h((C5214h) interfaceC4128d.get(C5214h.class));
            }
        }).c(), C4127c.a(C5729f.class).b(C4139o.g(C5731h.class)).b(C4139o.g(C5210d.class)).b(C4139o.g(C5214h.class)).d(new InterfaceC4131g() { // from class: w3.d
            @Override // h3.InterfaceC4131g
            public final Object a(InterfaceC4128d interfaceC4128d) {
                return new C5729f((C5731h) interfaceC4128d.get(C5731h.class), (C5210d) interfaceC4128d.get(C5210d.class), (C5214h) interfaceC4128d.get(C5214h.class));
            }
        }).c());
    }
}
