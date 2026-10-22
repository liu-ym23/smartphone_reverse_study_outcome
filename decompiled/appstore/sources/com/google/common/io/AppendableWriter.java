package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtIncompatible
class AppendableWriter extends Writer {
    private boolean closed;
    private final Appendable target;

    public AppendableWriter(Appendable r10) {
        this.target = (Appendable) Preconditions.checkNotNull(r10);
    }

    private void checkNotClosed() throws IOException {
        if (this.closed == true) goto L6;
        return;
    L6:
        throw new IOException("Cannot write to a closed writer.");
    }

    @Override // java.io.Writer, java.lang.Appendable
    public /* bridge */ /* synthetic */ Appendable append(char r10) throws IOException {
        return append(r10);
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.closed = true;
        Appendable r10 = this.target;
        if ((r10 instanceof Closeable) == false) goto L6;
        ((Closeable) r10).close();
        return;
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() throws IOException {
        checkNotClosed();
        Appendable r10 = this.target;
        if ((r10 instanceof Flushable) == false) goto L6;
        ((Flushable) r10).flush();
        return;
    }

    @Override // java.io.Writer
    public void write(char[] r10, int r11, int r12) throws IOException {
        checkNotClosed();
        this.target.append(new String(r10, r11, r12));
    }

    @Override // java.io.Writer, java.lang.Appendable
    public /* bridge */ /* synthetic */ Appendable append(@NullableDecl CharSequence r10) throws IOException {
        return append(r10);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public /* bridge */ /* synthetic */ Appendable append(@NullableDecl CharSequence r10, int r11, int r12) throws IOException {
        return append(r10, r11, r12);
    }

    @Override // java.io.Writer
    public void write(int r10) throws IOException {
        checkNotClosed();
        this.target.append((char) r10);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(char r10) throws IOException {
        checkNotClosed();
        this.target.append(r10);
        return this;
    }

    @Override // java.io.Writer
    public void write(@NullableDecl String r10) throws IOException {
        checkNotClosed();
        this.target.append(r10);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(@NullableDecl CharSequence r10) throws IOException {
        checkNotClosed();
        this.target.append(r10);
        return this;
    }

    @Override // java.io.Writer
    public void write(@NullableDecl String r10, int r11, int r12) throws IOException {
        checkNotClosed();
        this.target.append(r10, r11, r12 + r11);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(@NullableDecl CharSequence r10, int r11, int r12) throws IOException {
        checkNotClosed();
        this.target.append(r10, r11, r12);
        return this;
    }
}
