package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
@GwtIncompatible
public abstract class CharSink {
    public CharSink() {
    }

    public Writer openBufferedStream() throws IOException {
        Writer r10 = openStream();
        if ((r10 instanceof BufferedWriter) == false) goto L6;
        return (BufferedWriter) r10;
    L6:
        return new BufferedWriter(r10);
    }

    public abstract Writer openStream() throws IOException;

    public void write(CharSequence r10) throws IOException {
        Preconditions.checkNotNull(r10);
        Closer r11 = Closer.create();
        Writer r12 = (Writer) r11.register(openStream());     // Catch: Throwable -> L6
        r12.append(r10);     // Catch: Throwable -> L6
        r12.flush();     // Catch: Throwable -> L6
        r11.close();
        return;
    L6:
        th = move-exception;
    L9:
        th = move-exception;
        r11.close();
        throw th;
    L8:
        throw r11.rethrow(th);     // Catch: Throwable -> L9
    }

    @CanIgnoreReturnValue
    public long writeFrom(Readable r10) throws IOException {
        Preconditions.checkNotNull(r10);
        Closer r11 = Closer.create();
        Writer r12 = (Writer) r11.register(openStream());     // Catch: Throwable -> L6
        long r13 = CharStreams.copy(r10, r12);     // Catch: Throwable -> L6
        r12.flush();     // Catch: Throwable -> L6
        r11.close();
        return r13;
    L6:
        th = move-exception;
    L9:
        th = move-exception;
        r11.close();
        throw th;
    L8:
        throw r11.rethrow(th);     // Catch: Throwable -> L9
    }

    public void writeLines(Iterable<? extends CharSequence> r10) throws IOException {
        writeLines(r10, System.getProperty("line.separator"));
    }

    public void writeLines(Iterable<? extends CharSequence> r10, String r11) throws IOException {
        Preconditions.checkNotNull(r10);
        Preconditions.checkNotNull(r11);
        Closer r12 = Closer.create();
        Writer r13 = (Writer) r12.register(openBufferedStream());     // Catch: Throwable -> L7
        Iterator<? extends CharSequence> r14 = r10.iterator();     // Catch: Throwable -> L7
    L5:
        if (r14.hasNext() == false) goto L9;
        r13.append(r14.next()).append(r11);     // Catch: Throwable -> L7
        goto L5
    L9:
        r13.flush();     // Catch: Throwable -> L7
        r12.close();
        return;
    L7:
        th = move-exception;
    L14:
        th = move-exception;
        r12.close();
        throw th;
    L13:
        throw r12.rethrow(th);     // Catch: Throwable -> L14
    }
}
