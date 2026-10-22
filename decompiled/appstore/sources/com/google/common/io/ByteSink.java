package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes3.dex */
@GwtIncompatible
public abstract class ByteSink {

    /* JADX INFO: renamed from: com.google.common.io.ByteSink$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public final class AsCharSink extends CharSink {
        private final Charset charset;
        final /* synthetic */ ByteSink this$0;

        public /* synthetic */ AsCharSink(ByteSink r10, Charset r11, AnonymousClass1 r12) {
            this(r10, r11);
        }

        @Override // com.google.common.io.CharSink
        public Writer openStream() throws IOException {
            return new OutputStreamWriter(this.this$0.openStream(), this.charset);
        }

        public String toString() {
            return this.this$0.toString() + ".asCharSink(" + this.charset + ")";
        }

        private AsCharSink(ByteSink r10, Charset r11) {
            this.this$0 = r10;
            this.charset = (Charset) Preconditions.checkNotNull(r11);
        }
    }

    public ByteSink() {
    }

    public CharSink asCharSink(Charset r10) {
        return new AsCharSink(this, r10, null);
    }

    public OutputStream openBufferedStream() throws IOException {
        OutputStream r10 = openStream();
        if ((r10 instanceof BufferedOutputStream) == false) goto L6;
        return (BufferedOutputStream) r10;
    L6:
        return new BufferedOutputStream(r10);
    }

    public abstract OutputStream openStream() throws IOException;

    public void write(byte[] r10) throws IOException {
        Preconditions.checkNotNull(r10);
        Closer r11 = Closer.create();
        OutputStream r12 = (OutputStream) r11.register(openStream());     // Catch: Throwable -> L6
        r12.write(r10);     // Catch: Throwable -> L6
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
    public long writeFrom(InputStream r10) throws IOException {
        Preconditions.checkNotNull(r10);
        Closer r11 = Closer.create();
        OutputStream r12 = (OutputStream) r11.register(openStream());     // Catch: Throwable -> L6
        long r13 = ByteStreams.copy(r10, r12);     // Catch: Throwable -> L6
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
}
