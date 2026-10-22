package com.google.crypto.tink.internal;

import com.google.crypto.tink.shaded.protobuf.MessageLite;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class PrimitiveFactory<PrimitiveT, KeyProtoT extends MessageLite> {
    private final Class<PrimitiveT> clazz;

    public PrimitiveFactory(Class<PrimitiveT> cls) {
        this.clazz = cls;
    }

    public abstract PrimitiveT getPrimitive(KeyProtoT keyprotot);

    public final Class<PrimitiveT> getPrimitiveClass() {
        return this.clazz;
    }
}
