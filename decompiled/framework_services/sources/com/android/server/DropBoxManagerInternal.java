package com.android.server;

import java.io.Closeable;
import java.io.FileDescriptor;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public abstract class DropBoxManagerInternal {

    public interface EntrySource extends Closeable {
        void writeTo(FileDescriptor r1) throws IOException;

        default long length() {
            return 0;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        default void close() throws IOException {
        }
    }

    public abstract void addEntry(String r1, EntrySource r2, int r3);

    public DropBoxManagerInternal() {
    }
}
