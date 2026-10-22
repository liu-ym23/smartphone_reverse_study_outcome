package com.android.server.apphibernation;

import android.util.proto.ProtoInputStream;
import android.util.proto.ProtoOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
interface ProtoReadWriter<T> {
    T readFromProto(ProtoInputStream r1) throws IOException;

    void writeToProto(ProtoOutputStream r1, T r2);
}
