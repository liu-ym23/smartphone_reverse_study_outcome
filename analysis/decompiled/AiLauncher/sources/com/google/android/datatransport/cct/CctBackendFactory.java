package com.google.android.datatransport.cct;

import androidx.annotation.Keep;
import c2.C1492d;
import f2.AbstractC4051f;
import f2.InterfaceC4048c;
import f2.k;

@Keep
/* loaded from: classes2.dex */
public class CctBackendFactory implements InterfaceC4048c {
    @Override // f2.InterfaceC4048c
    public k create(AbstractC4051f abstractC4051f) {
        return new C1492d(abstractC4051f.b(), abstractC4051f.e(), abstractC4051f.d());
    }
}
