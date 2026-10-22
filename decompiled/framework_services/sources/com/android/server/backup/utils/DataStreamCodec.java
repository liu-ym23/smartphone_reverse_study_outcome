package com.android.server.backup.utils;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public interface DataStreamCodec<T> {
    T deserialize(DataInputStream r1) throws IOException;

    void serialize(T r1, DataOutputStream r2) throws IOException;
}
