package com.google.common.io;

import com.google.common.base.Ascii;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public abstract class CharSource {

    private static class CharSequenceCharSource extends CharSource {
        private static final Splitter LINE_SPLITTER = null;
        private final CharSequence seq;

        static /* synthetic */ CharSequence access$100(CharSequenceCharSource r0) {
            return r0.seq;
        }

        static /* synthetic */ Splitter access$200() {
            return LINE_SPLITTER;
        }

        static {
            LINE_SPLITTER = Splitter.on(Pattern.compile("\r\n|\n|\r"));
        }

        protected CharSequenceCharSource(CharSequence r1) {
            this.seq = (CharSequence) Preconditions.checkNotNull(r1);
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
        public boolean isEmpty() {
            if (this.seq.length() != 0) goto L5;
            return true;
        L5:
            return false;
        }

        private Iterable<String> lines() {
            return new AnonymousClass1(this);
        }

        @Override // com.google.common.io.CharSource
        public String readFirstLine() {
            Iterator<String> r1 = lines().iterator();
            if (r1.hasNext() == true) goto L7;
            return null;
        L7:
            return r1.next();
        }

        @Override // com.google.common.io.CharSource
        public ImmutableList<String> readLines() {
            return ImmutableList.copyOf(lines());
        }

        @Override // com.google.common.io.CharSource
        public <T> T readLines(LineProcessor<T> r2) throws IOException {
            Iterator<String> r1 = lines().iterator();
        L4:
            if (r1.hasNext() == false) goto L8;
            if (r2.processLine(r1.next()) == true) goto L4;
        L8:
            return r2.getResult();
        }

        public String toString() {
            return "CharSource.wrap(" + Ascii.truncate(this.seq, 30, "...") + ")";
        }
    }

    private static final class ConcatenatedCharSource extends CharSource {
        private final Iterable<? extends CharSource> sources;

        ConcatenatedCharSource(Iterable<? extends CharSource> r1) {
            this.sources = (Iterable) Preconditions.checkNotNull(r1);
        }

        @Override // com.google.common.io.CharSource
        public Reader openStream() throws IOException {
            return new MultiReader(this.sources.iterator());
        }

        @Override // com.google.common.io.CharSource
        public boolean isEmpty() throws IOException {
            Iterator<? extends CharSource> r1 = this.sources.iterator();
        L4:
            if (r1.hasNext() == false) goto L9;
            if (r1.next().isEmpty() == true) goto L4;
            return false;
        L9:
            return true;
        }

        public String toString() {
            return "CharSource.concat(" + this.sources + ")";
        }
    }

    private static final class EmptyCharSource extends CharSequenceCharSource {
        private static final EmptyCharSource INSTANCE = null;

        @Override // com.google.common.io.CharSource.CharSequenceCharSource
        public String toString() {
            return "CharSource.empty()";
        }

        static /* synthetic */ EmptyCharSource access$000() {
            return INSTANCE;
        }

        static {
            INSTANCE = new EmptyCharSource();
        }

        private EmptyCharSource() {
            super("");
        }
    }

    public abstract Reader openStream() throws IOException;

    protected CharSource() {
    }

    public BufferedReader openBufferedStream() throws IOException {
        Reader r1 = openStream();
        if ((r1 instanceof BufferedReader) == false) goto L6;
        return (BufferedReader) r1;
    L6:
        return new BufferedReader(r1);
    }

    public long copyTo(Appendable r2) throws IOException {
        Preconditions.checkNotNull(r2);
        Closer r0 = Closer.create();
        long r1 = CharStreams.copy((Reader) r0.register(openStream()), r2);     // Catch: Throwable -> L6
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

    public long copyTo(CharSink r2) throws IOException {
        Preconditions.checkNotNull(r2);
        Closer r0 = Closer.create();
        long r1 = CharStreams.copy((Reader) r0.register(openStream()), (Writer) r0.register(r2.openStream()));     // Catch: Throwable -> L6
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

    public String read() throws IOException {
        Closer r0 = Closer.create();
        String r1 = CharStreams.toString((Reader) r0.register(openStream()));     // Catch: Throwable -> L6
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

    @Nullable
    public String readFirstLine() throws IOException {
        Closer r0 = Closer.create();
        String r1 = ((BufferedReader) r0.register(openBufferedStream())).readLine();     // Catch: Throwable -> L6
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

    public ImmutableList<String> readLines() throws IOException {
        Closer r0 = Closer.create();
        BufferedReader r3 = (BufferedReader) r0.register(openBufferedStream());     // Catch: Throwable -> L10
        ArrayList r1 = Lists.newArrayList();     // Catch: Throwable -> L10
    L4:
        String r2 = r3.readLine();     // Catch: Throwable -> L10
        if (r2 == null) goto L7;
        r1.add(r2);     // Catch: Throwable -> L10
        goto L4
    L7:
        ImmutableList<String> r4 = ImmutableList.copyOf(r1);     // Catch: Throwable -> L10
        r0.close();
        return r4;
    L10:
        th = move-exception;
    L13:
        th = move-exception;
        r0.close();
        throw th;
    L12:
        throw r0.rethrow(th);     // Catch: Throwable -> L13
    }

    public <T> T readLines(LineProcessor<T> r2) throws IOException {
        Preconditions.checkNotNull(r2);
        Closer r0 = Closer.create();
        T r1 = (T) CharStreams.readLines((Reader) r0.register(openStream()), r2);
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

    public boolean isEmpty() throws IOException {
        Closer r0 = Closer.create();
        if (((Reader) r0.register(openStream())).read() != (-1)) goto L7;
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

    public static CharSource concat(Iterable<? extends CharSource> r1) {
        return new ConcatenatedCharSource(r1);
    }

    public static CharSource concat(Iterator<? extends CharSource> r0) {
        return concat(ImmutableList.copyOf(r0));
    }

    public static CharSource concat(CharSource... r0) {
        return concat(ImmutableList.copyOf(r0));
    }

    public static CharSource wrap(CharSequence r1) {
        return new CharSequenceCharSource(r1);
    }

    public static CharSource empty() {
        return EmptyCharSource.access$000();
    }
}
