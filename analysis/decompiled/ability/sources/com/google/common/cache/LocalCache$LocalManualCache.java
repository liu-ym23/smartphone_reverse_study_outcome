package com.google.common.cache;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import l3.InterfaceC1657a;

/* loaded from: classes3.dex */
class LocalCache$LocalManualCache<K, V> implements InterfaceC1657a, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final e f2726a;

    public LocalCache$LocalManualCache(e eVar) {
        this.f2726a = eVar;
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use ManualSerializationProxy");
    }

    @Override // l3.InterfaceC1657a
    public final void a(Object obj, String str) {
        this.f2726a.put(str, obj);
    }

    public Object writeReplace() {
        return new LocalCache$ManualSerializationProxy(this.f2726a);
    }
}
