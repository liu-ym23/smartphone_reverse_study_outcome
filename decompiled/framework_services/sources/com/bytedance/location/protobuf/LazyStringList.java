package com.bytedance.location.protobuf;

import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface LazyStringList extends ProtocolStringList {
    void add(ByteString r1);

    void add(byte[] r1);

    boolean addAllByteArray(Collection<byte[]> r1);

    boolean addAllByteString(Collection<? extends ByteString> r1);

    List<byte[]> asByteArrayList();

    byte[] getByteArray(int r1);

    ByteString getByteString(int r1);

    Object getRaw(int r1);

    List<?> getUnderlyingElements();

    LazyStringList getUnmodifiableView();

    void mergeFrom(LazyStringList r1);

    void set(int r1, ByteString r2);

    void set(int r1, byte[] r2);
}
