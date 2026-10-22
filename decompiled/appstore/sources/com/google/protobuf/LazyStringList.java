package com.google.protobuf;

import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface LazyStringList extends ProtocolStringList {
    void add(ByteString r10);

    void add(byte[] r10);

    boolean addAllByteArray(Collection<byte[]> r10);

    boolean addAllByteString(Collection<? extends ByteString> r10);

    List<byte[]> asByteArrayList();

    byte[] getByteArray(int r10);

    ByteString getByteString(int r10);

    Object getRaw(int r10);

    List<?> getUnderlyingElements();

    LazyStringList getUnmodifiableView();

    void mergeFrom(LazyStringList r10);

    void set(int r10, ByteString r11);

    void set(int r10, byte[] r11);
}
