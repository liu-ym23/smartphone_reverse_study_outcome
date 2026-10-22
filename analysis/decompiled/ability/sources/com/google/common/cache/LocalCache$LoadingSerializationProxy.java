package com.google.common.cache;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import l3.InterfaceC1661e;

/* loaded from: classes3.dex */
final class LocalCache$LoadingSerializationProxy<K, V> extends LocalCache$ManualSerializationProxy<K, V> implements InterfaceC1661e, Serializable {
    public transient InterfaceC1661e n;

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.n = b().a(this.l);
    }

    private Object readResolve() {
        return this.n;
    }
}
