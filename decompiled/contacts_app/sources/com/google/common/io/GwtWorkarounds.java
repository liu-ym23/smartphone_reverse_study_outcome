package com.google.common.io;

import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

/* JADX INFO: loaded from: classes2.dex */
final class GwtWorkarounds {

    interface ByteInput {
        void close() throws IOException;

        int read() throws IOException;
    }

    interface ByteOutput {
        void close() throws IOException;

        void flush() throws IOException;

        void write(byte r1) throws IOException;
    }

    interface CharInput {
        void close() throws IOException;

        int read() throws IOException;
    }

    interface CharOutput {
        void close() throws IOException;

        void flush() throws IOException;

        void write(char r1) throws IOException;
    }

    private GwtWorkarounds() {
    }

    static CharInput asCharInput(final Reader r1) {
        Preconditions.checkNotNull(r1);
        return new AnonymousClass1(r1);
    }

    static CharInput asCharInput(final CharSequence r1) {
        Preconditions.checkNotNull(r1);
        return new AnonymousClass2(r1);
    }

    static InputStream asInputStream(final ByteInput r1) {
        Preconditions.checkNotNull(r1);
        return new AnonymousClass3(r1);
    }

    static OutputStream asOutputStream(final ByteOutput r1) {
        Preconditions.checkNotNull(r1);
        return new AnonymousClass4(r1);
    }

    static CharOutput asCharOutput(final Writer r1) {
        Preconditions.checkNotNull(r1);
        return new AnonymousClass5(r1);
    }

    static CharOutput stringBuilderOutput(int r1) {
        final StringBuilder r0 = new StringBuilder(r1);
        return new AnonymousClass6(r0);
    }
}
