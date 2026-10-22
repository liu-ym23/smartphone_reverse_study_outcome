package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.Reader;
import java.nio.CharBuffer;
import java.util.LinkedList;
import java.util.Queue;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@Beta
@GwtIncompatible
public final class LineReader {
    private final char[] buf;
    private final CharBuffer cbuf;
    private final LineBuffer lineBuf;
    private final Queue<String> lines;
    private final Readable readable;

    @NullableDecl
    private final Reader reader;

    public LineReader(Readable r10) {
        CharBuffer r11 = CharStreams.createBuffer();
        this.cbuf = r11;
        this.buf = r11.array();
        this.lines = new LinkedList();
        this.lineBuf = new AnonymousClass1(this);
        this.readable = (Readable) Preconditions.checkNotNull(r10);
        if ((r10 instanceof Reader) == false) goto L5;
        Reader r12 = (Reader) r10;
    L6:
        this.reader = r12;
        return;
    L5:
        r12 = null;
        goto L6
    }

    public static /* synthetic */ Queue access$000(LineReader r10) {
        return r10.lines;
    }

    @CanIgnoreReturnValue
    public String readLine() throws IOException {
    L3:
        if (this.lines.peek() != null) goto L13;
        this.cbuf.clear();
        Reader r10 = this.reader;
        if (r10 == null) goto L7;
        char[] r11 = this.buf;
        int r12 = r10.read(r11, 0, r11.length);
    L9:
        if (r12 == (-1)) goto L10;
        this.lineBuf.add(this.buf, 0, r12);
        goto L3
    L10:
        this.lineBuf.finish();
        goto L13
    L7:
        r12 = this.readable.read(this.cbuf);
    L13:
        return this.lines.poll();
    }
}
