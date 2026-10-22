package com.google.crypto.tink.prf;

import com.google.crypto.tink.Key;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class PrfKey extends Key {
    @Override // com.google.crypto.tink.Key
    public abstract PrfParameters getParameters();
}
