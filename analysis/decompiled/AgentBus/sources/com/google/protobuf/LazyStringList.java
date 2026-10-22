package com.google.protobuf;

import java.util.Collection;
import java.util.List;

/* loaded from: classes.dex */
public interface LazyStringList extends List {
    void add(l lVar);

    void add(byte[] bArr);

    boolean addAllByteArray(Collection<byte[]> collection);

    boolean addAllByteString(Collection<? extends l> collection);

    List<byte[]> asByteArrayList();

    /* synthetic */ List asByteStringList();

    byte[] getByteArray(int i2);

    l getByteString(int i2);

    Object getRaw(int i2);

    List<?> getUnderlyingElements();

    LazyStringList getUnmodifiableView();

    void mergeFrom(LazyStringList lazyStringList);

    void set(int i2, l lVar);

    void set(int i2, byte[] bArr);
}
