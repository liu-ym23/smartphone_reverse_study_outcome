package com.google.common.io;

import com.google.common.base.Preconditions;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public abstract class CharSink {
    public abstract Writer openStream() throws IOException;

    protected CharSink() {
    }

    public Writer openBufferedStream() throws IOException {
        Writer r1 = openStream();
        if ((r1 instanceof BufferedWriter) == false) goto L6;
        return (BufferedWriter) r1;
    L6:
        return new BufferedWriter(r1);
    }

    public void write(CharSequence r2) throws IOException {
        Preconditions.checkNotNull(r2);
        Closer r0 = Closer.create();
        Writer r1 = (Writer) r0.register(openStream());     // Catch: Throwable -> L6
        r1.append(r2);     // Catch: Throwable -> L6
        r1.flush();     // Catch: Throwable -> L6
        r0.close();
        return;
    L6:
        th = move-exception;
    L9:
        th = move-exception;
        r0.close();
        throw th;
    L8:
        throw r0.rethrow(th);     // Catch: Throwable -> L9
    }

    public void writeLines(Iterable<? extends CharSequence> r2) throws IOException {
        writeLines(r2, System.getProperty("line.separator"));
    }

    public void writeLines(Iterable<? extends CharSequence> r3, String r4) throws IOException {
        Preconditions.checkNotNull(r3);
        Preconditions.checkNotNull(r4);
        Closer r0 = Closer.create();
        Writer r2 = (Writer) r0.register(openBufferedStream());     // Catch: Throwable -> L10
        Iterator<? extends CharSequence> r5 = r3.iterator();     // Catch: Throwable -> L10
    L5:
        if (r5.hasNext() == false) goto L7;
        r2.append(r5.next()).append(r4);     // Catch: Throwable -> L10
        goto L5
    L7:
        r2.flush();     // Catch: Throwable -> L10
        r0.close();
        return;
    L10:
        th = move-exception;
    L13:
        th = move-exception;
        r0.close();
        throw th;
    L12:
        throw r0.rethrow(th);     // Catch: Throwable -> L13
    }

    public long writeFrom(Readable r4) throws IOException {
        Preconditions.checkNotNull(r4);
        Closer r0 = Closer.create();
        Writer r3 = (Writer) r0.register(openStream());     // Catch: Throwable -> L6
        long r1 = CharStreams.copy(r4, r3);     // Catch: Throwable -> L6
        r3.flush();     // Catch: Throwable -> L6
        r0.close();
        return r1;
    L6:
        th = move-exception;
    L9:
        th = move-exception;
        r0.close();
        throw th;
    L8:
        throw r0.rethrow(th);     // Catch: Throwable -> L9
    }
}
