package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Ascii;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtIncompatible
public abstract class CharSource {

    public final class AsByteSource extends ByteSource {
        final Charset charset;
        final /* synthetic */ CharSource this$0;

        public AsByteSource(CharSource r10, Charset r11) {
            this.this$0 = r10;
            this.charset = (Charset) Preconditions.checkNotNull(r11);
        }

        @Override // com.google.common.io.ByteSource
        public CharSource asCharSource(Charset r10) {
            if (r10.equals(this.charset) == false) goto L7;
            return this.this$0;
        L7:
            return super.asCharSource(r10);
        }

        @Override // com.google.common.io.ByteSource
        public InputStream openStream() throws IOException {
            return new ReaderInputStream(this.this$0.openStream(), this.charset, 8192);
        }

        public String toString() {
            return this.this$0.toString() + ".asByteSource(" + this.charset + ")";
        }
    }

    public static class CharSequenceCharSource extends CharSource {
        private static final Splitter LINE_SPLITTER = null;
        protected final CharSequence seq;

        static {
            LINE_SPLITTER = Splitter.onPattern("\r\n|\n|\r");
        }

        public CharSequenceCharSource(CharSequence r10) {
            this.seq = (CharSequence) Preconditions.checkNotNull(r10);
        }

        public static /* synthetic */ Splitter access$100() {
            return LINE_SPLITTER;
        }

        private Iterator<String> linesIterator() {
            return new AnonymousClass1(this);
        }

        @Override // com.google.common.io.CharSource
        public boolean isEmpty() {
            if (this.seq.length() != 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.google.common.io.CharSource
        public long length() {
            return this.seq.length();
        }

        @Override // com.google.common.io.CharSource
        public Optional<Long> lengthIfKnown() {
            return Optional.of(Long.valueOf(this.seq.length()));
        }

        @Override // com.google.common.io.CharSource
        public Reader openStream() {
            return new CharSequenceReader(this.seq);
        }

        @Override // com.google.common.io.CharSource
        public String read() {
            return this.seq.toString();
        }

        @Override // com.google.common.io.CharSource
        public String readFirstLine() {
            Iterator<String> r10 = linesIterator();
            if (r10.hasNext() == true) goto L7;
            return null;
        L7:
            return r10.next();
        }

        @Override // com.google.common.io.CharSource
        public ImmutableList<String> readLines() {
            return ImmutableList.copyOf(linesIterator());
        }

        public String toString() {
            return "CharSource.wrap(" + Ascii.truncate(this.seq, 30, "...") + ")";
        }

        @Override // com.google.common.io.CharSource
        public <T> T readLines(LineProcessor<T> r10) throws IOException {
            Iterator<String> r11 = linesIterator();
        L4:
            if (r11.hasNext() == false) goto L8;
            if (r10.processLine(r11.next()) == true) goto L4;
        L8:
            return r10.getResult();
        }
    }

    public static final class ConcatenatedCharSource extends CharSource {
        private final Iterable<? extends CharSource> sources;

        public ConcatenatedCharSource(Iterable<? extends CharSource> r10) {
            this.sources = (Iterable) Preconditions.checkNotNull(r10);
        }

        @Override // com.google.common.io.CharSource
        public boolean isEmpty() throws IOException {
            Iterator<? extends CharSource> r10 = this.sources.iterator();
        L4:
            if (r10.hasNext() == false) goto L9;
            if (r10.next().isEmpty() == true) goto L4;
            return false;
        L9:
            return true;
        }

        @Override // com.google.common.io.CharSource
        public long length() throws IOException {
            Iterator<? extends CharSource> r10 = this.sources.iterator();
            long r11 = 0;
        L4:
            if (r10.hasNext() == false) goto L6;
            r11 = r11 + r10.next().length();
            goto L4
        L6:
            return r11;
        }

        @Override // com.google.common.io.CharSource
        public Optional<Long> lengthIfKnown() {
            Iterator<? extends CharSource> r10 = this.sources.iterator();
            long r11 = 0;
        L4:
            if (r10.hasNext() == false) goto L11;
            Optional<Long> r12 = r10.next().lengthIfKnown();
            if (r12.isPresent() == false) goto L8;
            r11 = r11 + r12.get().longValue();
            goto L4
        L8:
            return Optional.absent();
        L11:
            return Optional.of(Long.valueOf(r11));
        }

        @Override // com.google.common.io.CharSource
        public Reader openStream() throws IOException {
            return new MultiReader(this.sources.iterator());
        }

        public String toString() {
            return "CharSource.concat(" + this.sources + ")";
        }
    }

    public static final class EmptyCharSource extends StringCharSource {
        private static final EmptyCharSource INSTANCE = null;

        static {
            INSTANCE = new EmptyCharSource();
        }

        private EmptyCharSource() {
            super("");
        }

        public static /* synthetic */ EmptyCharSource access$000() {
            return INSTANCE;
        }

        @Override // com.google.common.io.CharSource.CharSequenceCharSource
        public String toString() {
            return "CharSource.empty()";
        }
    }

    public static class StringCharSource extends CharSequenceCharSource {
        public StringCharSource(String r10) {
            super(r10);
        }

        @Override // com.google.common.io.CharSource
        public long copyTo(Appendable r10) throws IOException {
            r10.append(this.seq);
            return this.seq.length();
        }

        @Override // com.google.common.io.CharSource.CharSequenceCharSource, com.google.common.io.CharSource
        public Reader openStream() {
            return new StringReader((String) this.seq);
        }

        @Override // com.google.common.io.CharSource
        public long copyTo(CharSink r10) throws IOException {
            Preconditions.checkNotNull(r10);
            Closer r11 = Closer.create();
            ((Writer) r11.register(r10.openStream())).write((String) this.seq);     // Catch: Throwable -> L6
            long r12 = this.seq.length();     // Catch: Throwable -> L6
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

    public CharSource() {
    }

    public static CharSource concat(Iterable<? extends CharSource> r10) {
        return new ConcatenatedCharSource(r10);
    }

    private long countBySkipping(Reader r10) throws IOException {
        long r11 = 0;
    L3:
        long r12 = r10.skip(Long.MAX_VALUE);
        if (r12 == 0) goto L6;
        r11 = r11 + r12;
        goto L3
    L6:
        return r11;
    }

    public static CharSource empty() {
        return EmptyCharSource.access$000();
    }

    public static CharSource wrap(CharSequence r10) {
        if ((r10 instanceof String) == false) goto L6;
        return new StringCharSource((String) r10);
    L6:
        return new CharSequenceCharSource(r10);
    }

    @Beta
    public ByteSource asByteSource(Charset r10) {
        return new AsByteSource(this, r10);
    }

    @CanIgnoreReturnValue
    public long copyTo(Appendable r10) throws IOException {
        Preconditions.checkNotNull(r10);
        Closer r11 = Closer.create();
        long r12 = CharStreams.copy((Reader) r11.register(openStream()), r10);     // Catch: Throwable -> L6
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

    public boolean isEmpty() throws IOException {
        Optional<Long> r10 = lengthIfKnown();
        boolean r11 = false;
        if (r10.isPresent() == true) goto L5;
        Closer r12 = Closer.create();
        if (((Reader) r12.register(openStream())).read() != (-1)) goto L13;
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

    @Beta
    public long length() throws IOException {
        Optional<Long> r10 = lengthIfKnown();
        if (r10.isPresent() == true) goto L5;
        Closer r11 = Closer.create();
        long r12 = countBySkipping((Reader) r11.register(openStream()));     // Catch: Throwable -> L10
        r11.close();
        return r12;
    L10:
        th = move-exception;
    L13:
        th = move-exception;
        r11.close();
        throw th;
    L12:
        throw r11.rethrow(th);     // Catch: Throwable -> L13
    L5:
        return r10.get().longValue();
    }

    @Beta
    public Optional<Long> lengthIfKnown() {
        return Optional.absent();
    }

    public BufferedReader openBufferedStream() throws IOException {
        Reader r10 = openStream();
        if ((r10 instanceof BufferedReader) == false) goto L6;
        return (BufferedReader) r10;
    L6:
        return new BufferedReader(r10);
    }

    public abstract Reader openStream() throws IOException;

    public String read() throws IOException {
        Closer r10 = Closer.create();
        String r11 = CharStreams.toString((Reader) r10.register(openStream()));     // Catch: Throwable -> L6
        r10.close();
        return r11;
    L6:
        th = move-exception;
    L9:
        th = move-exception;
        r10.close();
        throw th;
    L8:
        throw r10.rethrow(th);     // Catch: Throwable -> L9
    }

    @NullableDecl
    public String readFirstLine() throws IOException {
        Closer r10 = Closer.create();
        String r11 = ((BufferedReader) r10.register(openBufferedStream())).readLine();     // Catch: Throwable -> L6
        r10.close();
        return r11;
    L6:
        th = move-exception;
    L9:
        th = move-exception;
        r10.close();
        throw th;
    L8:
        throw r10.rethrow(th);     // Catch: Throwable -> L9
    }

    public ImmutableList<String> readLines() throws IOException {
        Closer r10 = Closer.create();
        BufferedReader r11 = (BufferedReader) r10.register(openBufferedStream());     // Catch: Throwable -> L7
        ArrayList r12 = Lists.newArrayList();     // Catch: Throwable -> L7
    L4:
        String r13 = r11.readLine();     // Catch: Throwable -> L7
        if (r13 == null) goto L9;
        r12.add(r13);     // Catch: Throwable -> L7
        goto L4
    L9:
        ImmutableList<String> r14 = ImmutableList.copyOf(r12);     // Catch: Throwable -> L7
        r10.close();
        return r14;
    L7:
        th = move-exception;
    L14:
        th = move-exception;
        r10.close();
        throw th;
    L13:
        throw r10.rethrow(th);     // Catch: Throwable -> L14
    }

    public static CharSource concat(Iterator<? extends CharSource> r10) {
        return concat(ImmutableList.copyOf(r10));
    }

    public static CharSource concat(CharSource... r10) {
        return concat(ImmutableList.copyOf(r10));
    }

    @CanIgnoreReturnValue
    public long copyTo(CharSink r10) throws IOException {
        Preconditions.checkNotNull(r10);
        Closer r11 = Closer.create();
        long r12 = CharStreams.copy((Reader) r11.register(openStream()), (Writer) r11.register(r10.openStream()));     // Catch: Throwable -> L6
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
    public <T> T readLines(LineProcessor<T> r10) throws IOException {
        Preconditions.checkNotNull(r10);
        Closer r11 = Closer.create();
        T r12 = (T) CharStreams.readLines((Reader) r11.register(openStream()), r10);
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
