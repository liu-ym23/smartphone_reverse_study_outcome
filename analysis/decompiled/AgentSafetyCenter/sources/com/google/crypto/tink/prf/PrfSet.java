package com.google.crypto.tink.prf;

import java.util.Map;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class PrfSet {
    public byte[] computePrimary(byte[] bArr, int i) {
        return getPrfs().get(Integer.valueOf(getPrimaryId())).compute(bArr, i);
    }

    public abstract Map<Integer, Prf> getPrfs();

    public abstract int getPrimaryId();
}
