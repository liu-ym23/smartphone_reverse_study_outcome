package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtIncompatible
class MultiReader extends Reader {

    @NullableDecl
    private Reader current;
    private final Iterator<? extends CharSource> it;

    public MultiReader(Iterator<? extends CharSource> r10) throws IOException {
        this.it = r10;
        advance();
    }

    private void advance() throws IOException {
        close();
        if (this.it.hasNext() == false) goto L6;
        this.current = this.it.next().openStream();
        return;
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Reader r10 = this.current;
        if (r10 != null) goto L11;
        return;
    L11:
        r10.close();     // Catch: Throwable -> L7
        this.current = null;
        return;
    L7:
        th = move-exception;
        this.current = null;
        throw th;
    }

    @Override // java.io.Reader
    public int read(@NullableDecl char[] r10, int r11, int r12) throws IOException {
        Reader r13 = this.current;
        if (r13 != null) goto L5;
        return -1;
    L5:
        int r14 = r13.read(r10, r11, r12);
        if (r14 != (-1)) goto L9;
        advance();
        return read(r10, r11, r12);
    L9:
        return r14;
    }

    @Override // java.io.Reader
    public boolean ready() throws IOException {
        Reader r10 = this.current;
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.ready() == false) goto L7;
        return true;
    }

    @Override // java.io.Reader
    public long skip(long r10) throws IOException {
        if (r10 < 0) goto L5;
        boolean r11 = true;
    L6:
        Preconditions.checkArgument(r11, "n is negative");
        if (r10 <= 0) goto L14;
    L8:
        Reader r12 = this.current;
        if (r12 == null) goto L14;
        long r13 = r12.skip(r10);
        if (r13 > 0) goto L12;
        advance();
        goto L8
    L12:
        return r13;
    L14:
        return 0;
    L5:
        r11 = false;
        goto L6
    }
}
