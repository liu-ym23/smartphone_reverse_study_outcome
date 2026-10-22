package com.google.crypto.tink;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
@Deprecated
/* loaded from: classes.dex */
public interface Catalogue<P> {
    KeyManager<P> getKeyManager(String str, String str2, int i);

    PrimitiveWrapper<?, P> getPrimitiveWrapper();
}
