package com.google.common.io;

import com.google.common.base.Ascii;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.hash.Funnels;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hasher;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ByteSource {
    private static final int BUF_SIZE = 4096;
    private static final byte[] countBuffer = null;

    /* JADX INFO: renamed from: com.google.common.io.ByteSource$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private final class AsCharSource extends CharSource {
        private final Charset charset;
        final /* synthetic */ ByteSource this$0;

        /* synthetic */ AsCharSource(ByteSource r1, Charset r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        private AsCharSource(ByteSource r1, Charset r2) {
            this.this$0 = r1;
            this.charset = (Charset) Preconditions.checkNotNull(r2);
        }

        @Override // com.google.common.io.CharSource
        public Reader openStream() throws IOException {
            return new InputStreamReader(this.this$0.openStream(), this.charset);
        }

        public String toString() {
            return this.this$0.toString() + ".asCharSource(" + this.charset + ")";
        }
    }

    private static class ByteArrayByteSource extends ByteSource {
        protected final byte[] bytes;

        protected ByteArrayByteSource(byte[] r1) {
            this.bytes = (byte[]) Preconditions.checkNotNull(r1);
        }

        @Override // com.google.common.io.ByteSource
        public InputStream openStream() {
            return new ByteArrayInputStream(this.bytes);
        }

        @Override // com.google.common.io.ByteSource
        public InputStream openBufferedStream() throws IOException {
            return openStream();
        }

        @Override // com.google.common.io.ByteSource
        public boolean isEmpty() {
            if (this.bytes.length != 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.common.io.ByteSource
        public long size() {
            return this.bytes.length;
        }

        @Override // com.google.common.io.ByteSource
        public byte[] read() {
            return (byte[]) this.bytes.clone();
        }

        @Override // com.google.common.io.ByteSource
        public long copyTo(OutputStream r2) throws IOException {
            r2.write(this.bytes);
            return this.bytes.length;
        }

        @Override // com.google.common.io.ByteSource
        public <T> T read(ByteProcessor<T> r3) throws IOException {
            byte[] r2 = this.bytes;
            r3.processBytes(r2, 0, r2.length);
            return r3.getResult();
        }

        @Override // com.google.common.io.ByteSource
        public HashCode hash(HashFunction r1) throws IOException {
            return r1.hashBytes(this.bytes);
        }

        public String toString() {
            return "ByteSource.wrap(" + Ascii.truncate(BaseEncoding.base16().encode(this.bytes), 30, "...") + ")";
        }
    }

    private static final class ConcatenatedByteSource extends ByteSource {
        private final Iterable<? extends ByteSource> sources;

        ConcatenatedByteSource(Iterable<? extends ByteSource> r1) {
            this.sources = (Iterable) Preconditions.checkNotNull(r1);
        }

        @Override // com.google.common.io.ByteSource
        public InputStream openStream() throws IOException {
            return new MultiInputStream(this.sources.iterator());
        }

        @Override // com.google.common.io.ByteSource
        public boolean isEmpty() throws IOException {
            Iterator<? extends ByteSource> r1 = this.sources.iterator();
        L4:
            if (r1.hasNext() == false) goto L9;
            if (r1.next().isEmpty() == true) goto L4;
            return false;
        L9:
            return true;
        }

        @Override // com.google.common.io.ByteSource
        public long size() throws IOException {
            Iterator<? extends ByteSource> r4 = this.sources.iterator();
            long r0 = 0;
        L4:
            if (r4.hasNext() == false) goto L6;
            r0 = r0 + r4.next().size();
            goto L4
        L6:
            return r0;
        }

        public String toString() {
            return "ByteSource.concat(" + this.sources + ")";
        }
    }

    private static final class EmptyByteSource extends ByteArrayByteSource {
        private static final EmptyByteSource INSTANCE = null;

        @Override // com.google.common.io.ByteSource.ByteArrayByteSource
        public String toString() {
            return "ByteSource.empty()";
        }

        static /* synthetic */ EmptyByteSource access$200() {
            return INSTANCE;
        }

        static {
            INSTANCE = new EmptyByteSource();
        }

        private EmptyByteSource() {
            super(new byte[0]);
        }

        @Override // com.google.common.io.ByteSource
        public CharSource asCharSource(Charset r1) {
            Preconditions.checkNotNull(r1);
            return CharSource.empty();
        }

        @Override // com.google.common.io.ByteSource.ByteArrayByteSource, com.google.common.io.ByteSource
        public byte[] read() {
            return this.bytes;
        }
    }

    private final class SlicedByteSource extends ByteSource {
        private final long length;
        private final long offset;
        final /* synthetic */ ByteSource this$0;

        /* synthetic */ SlicedByteSource(ByteSource r1, long r2, long r4, AnonymousClass1 r6) {
            this(r1, r2, r4);
        }

        private SlicedByteSource(ByteSource r7, long r8, long r10) {
            this.this$0 = r7;
            if (r8 < 0) goto L5;
            boolean r9 = true;
        L6:
            Preconditions.checkArgument(r9, "offset (%s) may not be negative", new Object[]{Long.valueOf(r8)});
            if (r10 < 0) goto L9;
            boolean r11 = true;
        L10:
            Preconditions.checkArgument(r11, "length (%s) may not be negative", new Object[]{Long.valueOf(r10)});
            this.offset = r8;
            this.length = r10;
            return;
        L9:
            r11 = false;
            goto L10
        L5:
            r9 = false;
            goto L6
        }

        @Override // com.google.common.io.ByteSource
        public InputStream openStream() throws IOException {
            return sliceStream(this.this$0.openStream());
        }

        @Override // com.google.common.io.ByteSource
        public InputStream openBufferedStream() throws IOException {
            return sliceStream(this.this$0.openBufferedStream());
        }

        private InputStream sliceStream(InputStream r5) throws IOException {
            long r0 = this.offset;
            if (r0 <= 0) goto L14;
            ByteStreams.skipFully(r5, r0);     // Catch: Throwable -> L6
        L6:
            th = move-exception;
            Closer r1 = Closer.create();
            r1.register(r5);
        L10:
            th = move-exception;
            r1.close();
            throw th;
        L9:
            throw r1.rethrow(th);     // Catch: Throwable -> L10
        L14:
            return ByteStreams.limit(r5, this.length);
        }

        @Override // com.google.common.io.ByteSource
        public ByteSource slice(long r8, long r10) {
            if (r8 < 0) goto L5;
            boolean r2 = true;
        L6:
            Preconditions.checkArgument(r2, "offset (%s) may not be negative", new Object[]{Long.valueOf(r8)});
            if (r10 < 0) goto L9;
            boolean r0 = true;
        L10:
            Preconditions.checkArgument(r0, "length (%s) may not be negative", new Object[]{Long.valueOf(r10)});
            return this.this$0.slice(this.offset + r8, Math.min(r10, this.length - r8));
        L9:
            r0 = false;
            goto L10
        L5:
            r2 = false;
            goto L6
        }

        @Override // com.google.common.io.ByteSource
        public boolean isEmpty() throws IOException {
            if (this.length != 0) goto L5;
        L8:
            return true;
        L5:
            if (super.isEmpty() == true) goto L8;
            return false;
        }

        public String toString() {
            return this.this$0.toString() + ".slice(" + this.offset + ", " + this.length + ")";
        }
    }

    public abstract InputStream openStream() throws IOException;

    protected ByteSource() {
    }

    public CharSource asCharSource(Charset r3) {
        return new AsCharSource(this, r3, null);
    }

    public InputStream openBufferedStream() throws IOException {
        InputStream r1 = openStream();
        if ((r1 instanceof BufferedInputStream) == false) goto L6;
        return (BufferedInputStream) r1;
    L6:
        return new BufferedInputStream(r1);
    }

    public ByteSource slice(long r9, long r11) {
        return new SlicedByteSource(this, r9, r11, null);
    }

    public boolean isEmpty() throws IOException {
        Closer r0 = Closer.create();
        if (((InputStream) r0.register(openStream())).read() != (-1)) goto L7;
        boolean r2 = true;
    L8:
        r0.close();
        return r2;
    L7:
        r2 = false;
    L10:
        th = move-exception;
    L13:
        th = move-exception;
        r0.close();
        throw th;
    L12:
        throw r0.rethrow(th);     // Catch: Throwable -> L13
    }

    public long size() throws IOException {
        Closer r0 = Closer.create();
        long r1 = countBySkipping((InputStream) r0.register(openStream()));     // Catch: Throwable -> L6 IOException -> L9
        r0.close();
        return r1;
    L9:
        r0.close();
        Closer r2 = Closer.create();
        long r3 = countByReading((InputStream) r2.register(openStream()));     // Catch: Throwable -> L13
        r2.close();
        return r3;
    L13:
        th = move-exception;
    L16:
        th = move-exception;
        r2.close();
        throw th;
    L15:
        throw r2.rethrow(th);     // Catch: Throwable -> L16
    L6:
        th = move-exception;
        r0.close();
        throw th;
    }

    private long countBySkipping(InputStream r7) throws IOException {
        long r2 = 0;
    L3:
        long r4 = r7.skip(Math.min(r7.available(), Integer.MAX_VALUE));
        if (r4 > 0) goto L16;
        if (r7.read() == (-1)) goto L7;
        if (r2 == 0) goto L11;
    L15:
        r4 = 1;
        goto L16
    L11:
        if (r7.available() != 0) goto L15;
        throw new IOException();
    L7:
        return r2;
    L16:
        r2 = r2 + r4;
        goto L3
    }

    static {
        countBuffer = new byte[4096];
    }

    private long countByReading(InputStream r7) throws IOException {
        long r0 = 0;
    L3:
        long r2 = r7.read(countBuffer);
        if (r2 == (-1)) goto L6;
        r0 = r0 + r2;
        goto L3
    L6:
        return r0;
    }

    public long copyTo(OutputStream r2) throws IOException {
        Preconditions.checkNotNull(r2);
        Closer r0 = Closer.create();
        long r1 = ByteStreams.copy((InputStream) r0.register(openStream()), r2);     // Catch: Throwable -> L6
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

    public long copyTo(ByteSink r2) throws IOException {
        Preconditions.checkNotNull(r2);
        Closer r0 = Closer.create();
        long r1 = ByteStreams.copy((InputStream) r0.register(openStream()), (OutputStream) r0.register(r2.openStream()));     // Catch: Throwable -> L6
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

    public byte[] read() throws IOException {
        Closer r0 = Closer.create();
        byte[] r1 = ByteStreams.toByteArray((InputStream) r0.register(openStream()));     // Catch: Throwable -> L6
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

    public <T> T read(ByteProcessor<T> r2) throws IOException {
        Preconditions.checkNotNull(r2);
        Closer r0 = Closer.create();
        T r1 = (T) ByteStreams.readBytes((InputStream) r0.register(openStream()), r2);
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

    public HashCode hash(HashFunction r2) throws IOException {
        Hasher r3 = r2.newHasher();
        copyTo(Funnels.asOutputStream(r3));
        return r3.hash();
    }

    public boolean contentEquals(ByteSource r8) throws IOException {
        Preconditions.checkNotNull(r8);
        byte[] r1 = new byte[4096];
        byte[] r2 = new byte[4096];
        Closer r3 = Closer.create();
        InputStream r7 = (InputStream) r3.register(openStream());     // Catch: Throwable -> L14
        InputStream r9 = (InputStream) r3.register(r8.openStream());     // Catch: Throwable -> L14
    L4:
        int r5 = ByteStreams.read(r7, r1, 0, 4096);     // Catch: Throwable -> L14
        if (r5 != ByteStreams.read(r9, r2, 0, 4096)) goto L12;
        if (Arrays.equals(r1, r2) == false) goto L12;
        if (r5 == 4096) goto L4;
        r3.close();
        return true;
    L12:
        r3.close();
        return false;
    L14:
        th = move-exception;
    L17:
        th = move-exception;
        r3.close();
        throw th;
    L16:
        throw r3.rethrow(th);     // Catch: Throwable -> L17
    }

    public static ByteSource concat(Iterable<? extends ByteSource> r1) {
        return new ConcatenatedByteSource(r1);
    }

    public static ByteSource concat(Iterator<? extends ByteSource> r0) {
        return concat(ImmutableList.copyOf(r0));
    }

    public static ByteSource concat(ByteSource... r0) {
        return concat(ImmutableList.copyOf(r0));
    }

    public static ByteSource wrap(byte[] r1) {
        return new ByteArrayByteSource(r1);
    }

    public static ByteSource empty() {
        return EmptyByteSource.access$200();
    }
}
