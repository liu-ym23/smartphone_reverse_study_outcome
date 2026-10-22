package com.fasterxml.jackson.databind.util;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class LRUMap<K, V> implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final transient int f4508a;

    /* renamed from: b, reason: collision with root package name */
    public final transient ConcurrentHashMap<K, V> f4509b;

    /* renamed from: c, reason: collision with root package name */
    public transient int f4510c;

    public LRUMap(int i10, int i11) {
        this.f4509b = new ConcurrentHashMap<>(i10, 0.8f, 4);
        this.f4508a = i11;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        this.f4510c = objectInputStream.readInt();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(this.f4510c);
    }

    public final void a(Serializable serializable, Object obj) {
        if (this.f4509b.size() >= this.f4508a) {
            synchronized (this) {
                if (this.f4509b.size() >= this.f4508a) {
                    this.f4509b.clear();
                }
            }
        }
        this.f4509b.put(serializable, obj);
    }

    public final Object b(Serializable serializable, Object obj) {
        if (this.f4509b.size() >= this.f4508a) {
            synchronized (this) {
                if (this.f4509b.size() >= this.f4508a) {
                    this.f4509b.clear();
                }
            }
        }
        return this.f4509b.putIfAbsent(obj, serializable);
    }

    public Object readResolve() {
        int i10 = this.f4510c;
        return new LRUMap(i10, i10);
    }
}
