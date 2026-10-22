package com.google.common.cache;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import l3.InterfaceC1661e;

/* loaded from: classes3.dex */
class LocalCache$LocalLoadingCache<K, V> extends LocalCache$LocalManualCache<K, V> implements InterfaceC1661e {
    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use LoadingSerializationProxy");
    }

    @Override // com.google.common.cache.LocalCache$LocalManualCache
    public Object writeReplace() {
        return new LocalCache$LoadingSerializationProxy(this.f2726a);
    }
}
