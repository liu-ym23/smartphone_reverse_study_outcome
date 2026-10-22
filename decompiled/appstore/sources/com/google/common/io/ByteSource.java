package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Ascii;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.hash.Funnels;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hasher;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
@GwtIncompatible
public abstract class ByteSource {

    public class AsCharSource extends CharSource {
        final Charset charset;
        final /* synthetic */ ByteSource this$0;

        public AsCharSource(ByteSource r10, Charset r11) {
            this.this$0 = r10;
            this.charset = (Charset) Preconditions.checkNotNull(r11);
        }

        @Override // com.google.common.io.CharSource
        public ByteSource asByteSource(Charset r10) {
            if (r10.equals(this.charset) == false) goto L7;
            return this.this$0;
        L7:
            return super.asByteSource(r10);
        }

        @Override // com.google.common.io.CharSource
        public Reader openStream() throws IOException {
            return new InputStreamReader(this.this$0.openStream(), this.charset);
        }

        @Override // com.google.common.io.CharSource
        public String read() throws IOException {
            return new String(this.this$0.read(), this.charset);
        }

        public String toString() {
            return this.this$0.toString() + ".asCharSource(" + this.charset + ")";
        }
    }

    public static class ByteArrayByteSource extends ByteSource {
        final byte[] bytes;
        final int length;
        final int offset;

        public ByteArrayByteSource(byte[] r10) {
            this(r10, 0, r10.length);
        }

        @Override // com.google.common.io.ByteSource
        public long copyTo(OutputStream r10) throws IOException {
            r10.write(this.bytes, this.offset, this.length);
            return this.length;
        }

        @Override // com.google.common.io.ByteSource
        public HashCode hash(HashFunction r10) throws IOException {
            return r10.hashBytes(this.bytes, this.offset, this.length);
        }

        @Override // com.google.common.io.ByteSource
        public boolean isEmpty() {
            if (this.length != 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.common.io.ByteSource
        public InputStream openBufferedStream() throws IOException {
            return openStream();
        }

        @Override // com.google.common.io.ByteSource
        public InputStream openStream() {
            return new ByteArrayInputStream(this.bytes, this.offset, this.length);
        }

        @Override // com.google.common.io.ByteSource
        public byte[] read() {
            byte[] r10 = this.bytes;
            int r11 = this.offset;
            return Arrays.copyOfRange(r10, r11, this.length + r11);
        }

        @Override // com.google.common.io.ByteSource
        public long size() {
            return this.length;
        }

        @Override // com.google.common.io.ByteSource
        public Optional<Long> sizeIfKnown() {
            return Optional.of(Long.valueOf(this.length));
        }

        @Override // com.google.common.io.ByteSource
        public ByteSource slice(long r10, long r11) {
            boolean r12 = false;
            if (r10 < 0) goto L5;
            boolean r13 = true;
        L6:
            Preconditions.checkArgument(r13, "offset (%s) may not be negative", r10);
            if (r11 < 0) goto L9;
            r12 = true;
        L9:
            Preconditions.checkArgument(r12, "length (%s) may not be negative", r11);
            long r14 = Math.min(r10, this.length);
            long r15 = Math.min(r11, ((long) this.length) - r14);
            return new ByteArrayByteSource(this.bytes, this.offset + ((int) r14), (int) r15);
        L5:
            r13 = false;
            goto L6
        }

        public String toString() {
            return "ByteSource.wrap(" + Ascii.truncate(BaseEncoding.base16().encode(this.bytes, this.offset, this.length), 30, "...") + ")";
        }

        public ByteArrayByteSource(byte[] r10, int r11, int r12) {
            this.bytes = r10;
            this.offset = r11;
            this.length = r12;
        }

        @Override // com.google.common.io.ByteSource
        public <T> T read(ByteProcessor<T> r10) throws IOException {
            r10.processBytes(this.bytes, this.offset, this.length);
            return r10.getResult();
        }
    }

    public static final class ConcatenatedByteSource extends ByteSource {
        final Iterable<? extends ByteSource> sources;

        public ConcatenatedByteSource(Iterable<? extends ByteSource> r10) {
            this.sources = (Iterable) Preconditions.checkNotNull(r10);
        }

        @Override // com.google.common.io.ByteSource
        public boolean isEmpty() throws IOException {
            Iterator<? extends ByteSource> r10 = this.sources.iterator();
        L4:
            if (r10.hasNext() == false) goto L9;
            if (r10.next().isEmpty() == true) goto L4;
            return false;
        L9:
            return true;
        }

        @Override // com.google.common.io.ByteSource
        public InputStream openStream() throws IOException {
            return new MultiInputStream(this.sources.iterator());
        }

        @Override // com.google.common.io.ByteSource
        public long size() throws IOException {
            Iterator<? extends ByteSource> r10 = this.sources.iterator();
            long r11 = 0;
        L4:
            if (r10.hasNext() == false) goto L9;
            r11 = r11 + r10.next().size();
            if (r11 >= 0) goto L4;
            return Long.MAX_VALUE;
        L9:
            return r11;
        }

        @Override // com.google.common.io.ByteSource
        public Optional<Long> sizeIfKnown() {
            Iterable<? extends ByteSource> r10 = this.sources;
            if ((r10 instanceof Collection) == false) goto L5;
            Iterator<? extends ByteSource> r11 = r10.iterator();
            long r12 = 0;
        L8:
            if (r11.hasNext() == false) goto L18;
            Optional<Long> r13 = r11.next().sizeIfKnown();
            if (r13.isPresent() == false) goto L12;
            r12 = r12 + r13.get().longValue();
            if (r12 >= 0) goto L8;
            return Optional.of(Long.MAX_VALUE);
        L12:
            return Optional.absent();
        L18:
            return Optional.of(Long.valueOf(r12));
        L5:
            return Optional.absent();
        }

        public String toString() {
            return "ByteSource.concat(" + this.sources + ")";
        }
    }

    public static final class EmptyByteSource extends ByteArrayByteSource {
        static final EmptyByteSource INSTANCE = null;

        static {
            INSTANCE = new EmptyByteSource();
        }

        public EmptyByteSource() {
            super(new byte[0]);
        }

        @Override // com.google.common.io.ByteSource
        public CharSource asCharSource(Charset r10) {
            Preconditions.checkNotNull(r10);
            return CharSource.empty();
        }

        @Override // com.google.common.io.ByteSource.ByteArrayByteSource, com.google.common.io.ByteSource
        public byte[] read() {
            return this.bytes;
        }

        @Override // com.google.common.io.ByteSource.ByteArrayByteSource
        public String toString() {
            return "ByteSource.empty()";
        }
    }

    public final class SlicedByteSource extends ByteSource {
        final long length;
        final long offset;
        final /* synthetic */ ByteSource this$0;

        public SlicedByteSource(ByteSource r10, long r11, long r12) {
            this.this$0 = r10;
            boolean r13 = false;
            if (r11 < 0) goto L5;
            boolean r14 = true;
        L6:
            Preconditions.checkArgument(r14, "offset (%s) may not be negative", r11);
            if (r12 < 0) goto L9;
            r13 = true;
        L9:
            Preconditions.checkArgument(r13, "length (%s) may not be negative", r12);
            this.offset = r11;
            this.length = r12;
            return;
        L5:
            r14 = false;
            goto L6
        }

        private InputStream sliceStream(InputStream r10) throws IOException {
            long r11 = this.offset;
            if (r11 <= 0) goto L17;
            if (ByteStreams.skipUpTo(r10, r11) >= this.offset) goto L17;
            r10.close();
            return new ByteArrayInputStream(new byte[0]);
        L9:
            th = move-exception;
            Closer r12 = Closer.create();
            r12.register(r10);
        L13:
            th = move-exception;
            r12.close();
            throw th;
        L12:
            throw r12.rethrow(th);     // Catch: Throwable -> L13
        L17:
            return ByteStreams.limit(r10, this.length);
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

        @Override // com.google.common.io.ByteSource
        public InputStream openBufferedStream() throws IOException {
            return sliceStream(this.this$0.openBufferedStream());
        }

        @Override // com.google.common.io.ByteSource
        public InputStream openStream() throws IOException {
            return sliceStream(this.this$0.openStream());
        }

        @Override // com.google.common.io.ByteSource
        public Optional<Long> sizeIfKnown() {
            Optional<Long> r10 = this.this$0.sizeIfKnown();
            if (r10.isPresent() == false) goto L7;
            long r11 = r10.get().longValue();
            long r12 = Math.min(this.offset, r11);
            return Optional.of(Long.valueOf(Math.min(this.length, r11 - r12)));
        L7:
            return Optional.absent();
        }

        @Override // com.google.common.io.ByteSource
        public ByteSource slice(long r10, long r11) {
            boolean r12 = false;
            if (r10 < 0) goto L5;
            boolean r13 = true;
        L6:
            Preconditions.checkArgument(r13, "offset (%s) may not be negative", r10);
            if (r11 < 0) goto L9;
            r12 = true;
        L9:
            Preconditions.checkArgument(r12, "length (%s) may not be negative", r11);
            return this.this$0.slice(this.offset + r10, Math.min(r11, this.length - r10));
        L5:
            r13 = false;
            goto L6
        }

        public String toString() {
            return this.this$0.toString() + ".slice(" + this.offset + ", " + this.length + ")";
        }
    }

    public ByteSource() {
    }

    public static ByteSource concat(Iterable<? extends ByteSource> r10) {
        return new ConcatenatedByteSource(r10);
    }

    private long countBySkipping(InputStream r10) throws IOException {
        long r11 = 0;
    L3:
        long r12 = ByteStreams.skipUpTo(r10, 2147483647L);
        if (r12 <= 0) goto L6;
        r11 = r11 + r12;
        goto L3
    L6:
        return r11;
    }

    public static ByteSource empty() {
        return EmptyByteSource.INSTANCE;
    }

    public static ByteSource wrap(byte[] r10) {
        return new ByteArrayByteSource(r10);
    }

    public CharSource asCharSource(Charset r10) {
        return new AsCharSource(this, r10);
    }

    public boolean contentEquals(ByteSource r10) throws IOException {
        Preconditions.checkNotNull(r10);
        byte[] r11 = ByteStreams.createBuffer();
        byte[] r12 = ByteStreams.createBuffer();
        Closer r13 = Closer.create();
        InputStream r14 = (InputStream) r13.register(openStream());     // Catch: Throwable -> L13
        InputStream r15 = (InputStream) r13.register(r10.openStream());     // Catch: Throwable -> L13
    L4:
        int r16 = ByteStreams.read(r14, r11, 0, r11.length);     // Catch: Throwable -> L13
        if (r16 != ByteStreams.read(r15, r12, 0, r12.length)) goto L15;
        if (Arrays.equals(r11, r12) == false) goto L15;
        if (r16 == r11.length) goto L4;
        r13.close();
        return true;
    L15:
        r13.close();
        return false;
    L13:
        th = move-exception;
    L19:
        th = move-exception;
        r13.close();
        throw th;
    L18:
        throw r13.rethrow(th);     // Catch: Throwable -> L19
    }

    @CanIgnoreReturnValue
    public long copyTo(OutputStream r10) throws IOException {
        Preconditions.checkNotNull(r10);
        Closer r11 = Closer.create();
        long r12 = ByteStreams.copy((InputStream) r11.register(openStream()), r10);     // Catch: Throwable -> L6
        r11.close();
        return r12;
    L6:
        th = move-exception;
    L9:
        th = move-exception;
        r11.close();
        throw th;
    L8:
        throw r11.rethrow(th);     // Catch: Throwable -> L9
    }

    public HashCode hash(HashFunction r10) throws IOException {
        Hasher r11 = r10.newHasher();
        copyTo(Funnels.asOutputStream(r11));
        return r11.hash();
    }

    public boolean isEmpty() throws IOException {
        Optional<Long> r10 = sizeIfKnown();
        boolean r11 = false;
        if (r10.isPresent() == true) goto L5;
        Closer r12 = Closer.create();
        if (((InputStream) r12.register(openStream())).read() != (-1)) goto L13;
        r11 = true;
    L13:
        r12.close();
        return r11;
    L15:
        th = move-exception;
    L18:
        th = move-exception;
        r12.close();
        throw th;
    L17:
        throw r12.rethrow(th);     // Catch: Throwable -> L18
    L5:
        if (r10.get().longValue() == 0) goto L7;
        return false;
    L7:
        return true;
    }

    public InputStream openBufferedStream() throws IOException {
        InputStream r10 = openStream();
        if ((r10 instanceof BufferedInputStream) == false) goto L6;
        return (BufferedInputStream) r10;
    L6:
        return new BufferedInputStream(r10);
    }

    public abstract InputStream openStream() throws IOException;

    public byte[] read() throws IOException {
        Closer r10 = Closer.create();
        InputStream r11 = (InputStream) r10.register(openStream());     // Catch: Throwable -> L6
        Optional<Long> r12 = sizeIfKnown();     // Catch: Throwable -> L6
        if (r12.isPresent() == false) goto L8;
        byte[] r13 = ByteStreams.toByteArray(r11, r12.get().longValue());     // Catch: Throwable -> L6
    L9:
        r10.close();
        return r13;
    L8:
        r13 = ByteStreams.toByteArray(r11);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
    L13:
        th = move-exception;
        r10.close();
        throw th;
    L12:
        throw r10.rethrow(th);     // Catch: Throwable -> L13
    }

    public long size() throws IOException {
        Optional<Long> r10 = sizeIfKnown();
        if (r10.isPresent() == true) goto L5;
        Closer r11 = Closer.create();
        long r12 = countBySkipping((InputStream) r11.register(openStream()));     // Catch: Throwable -> L10 IOException -> L13
        r11.close();
        return r12;
    L13:
        r11.close();
        Closer r13 = Closer.create();
        long r14 = ByteStreams.exhaust((InputStream) r13.register(openStream()));     // Catch: Throwable -> L17
        r13.close();
        return r14;
    L17:
        th = move-exception;
    L20:
        th = move-exception;
        r13.close();
        throw th;
    L19:
        throw r13.rethrow(th);     // Catch: Throwable -> L20
    L10:
        th = move-exception;
        r11.close();
        throw th;
    L5:
        return r10.get().longValue();
    }

    @Beta
    public Optional<Long> sizeIfKnown() {
        return Optional.absent();
    }

    public ByteSource slice(long r10, long r11) {
        return new SlicedByteSource(this, r10, r11);
    }

    public static ByteSource concat(Iterator<? extends ByteSource> r10) {
        return concat(ImmutableList.copyOf(r10));
    }

    public static ByteSource concat(ByteSource... r10) {
        return concat(ImmutableList.copyOf(r10));
    }

    @CanIgnoreReturnValue
    public long copyTo(ByteSink r10) throws IOException {
        Preconditions.checkNotNull(r10);
        Closer r11 = Closer.create();
        long r12 = ByteStreams.copy((InputStream) r11.register(openStream()), (OutputStream) r11.register(r10.openStream()));     // Catch: Throwable -> L6
        r11.close();
        return r12;
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
    @Beta
    public <T> T read(ByteProcessor<T> r10) throws IOException {
        Preconditions.checkNotNull(r10);
        Closer r11 = Closer.create();
        T r12 = (T) ByteStreams.readBytes((InputStream) r11.register(openStream()), r10);
        r11.close();
        return r12;
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
