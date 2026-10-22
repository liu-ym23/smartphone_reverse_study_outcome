package com.android.server.backup.utils;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class DataStreamFileCodec<T> {
    private final DataStreamCodec<T> mCodec;
    private final File mFile;

    public DataStreamFileCodec(File file, DataStreamCodec<T> codec) {
        this.mFile = file;
        this.mCodec = codec;
    }

    public T deserialize() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(this.mFile);
        DataInputStream dataInputStream = new DataInputStream(fileInputStream);     // Catch: Throwable -> L8
        T r2 = this.mCodec.deserialize(dataInputStream);     // Catch: Throwable -> L10
        dataInputStream.close();     // Catch: Throwable -> L8
        fileInputStream.close();
        return r2;
    L10:
        th = move-exception;
        dataInputStream.close();     // Catch: Throwable -> L13
    L15:
        throw th;     // Catch: Throwable -> L8
    L13:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        fileInputStream.close();     // Catch: Throwable -> L18
    L20:
        throw th;
    L18:
        th = move-exception;
        th.addSuppressed(th);
        goto L20
    }

    public void serialize(T t) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(this.mFile);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);     // Catch: Throwable -> L10
        DataOutputStream dataOutputStream = new DataOutputStream(bufferedOutputStream);     // Catch: Throwable -> L12
        this.mCodec.serialize(t, dataOutputStream);     // Catch: Throwable -> L14
        dataOutputStream.flush();     // Catch: Throwable -> L14
        dataOutputStream.close();     // Catch: Throwable -> L12
        bufferedOutputStream.close();     // Catch: Throwable -> L10
        fileOutputStream.close();
        return;
    L14:
        th = move-exception;
        dataOutputStream.close();     // Catch: Throwable -> L17
    L19:
        throw th;     // Catch: Throwable -> L12
    L17:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        bufferedOutputStream.close();     // Catch: Throwable -> L22
    L24:
        throw th;     // Catch: Throwable -> L10
    L22:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        fileOutputStream.close();     // Catch: Throwable -> L27
    L29:
        throw th;
    L27:
        th = move-exception;
        th.addSuppressed(th);
        goto L29
    }
}
