package com.google.common.base;

import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public class Joiner {
    private final String separator;

    public static final class MapJoiner {
        private final Joiner joiner;
        private final String keyValueSeparator;

        /* synthetic */ MapJoiner(Joiner r1, String r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        private MapJoiner(Joiner r1, String r2) {
            this.joiner = r1;
            this.keyValueSeparator = (String) Preconditions.checkNotNull(r2);
        }

        public <A extends Appendable> A appendTo(A r1, Map<?, ?> r2) throws IOException {
            return (A) appendTo(r1, r2.entrySet());
        }

        public StringBuilder appendTo(StringBuilder r1, Map<?, ?> r2) {
            return appendTo(r1, r2.entrySet());
        }

        public String join(Map<?, ?> r1) {
            return join(r1.entrySet());
        }

        public <A extends Appendable> A appendTo(A r1, Iterable<? extends Map.Entry<?, ?>> r2) throws IOException {
            return (A) appendTo(r1, r2.iterator());
        }

        public <A extends Appendable> A appendTo(A r4, Iterator<? extends Map.Entry<?, ?>> r5) throws IOException {
            Preconditions.checkNotNull(r4);
            if (r5.hasNext() == false) goto L8;
            Map.Entry<?, ?> r0 = r5.next();
            r4.append(this.joiner.toString(r0.getKey()));
            r4.append(this.keyValueSeparator);
            r4.append(this.joiner.toString(r0.getValue()));
        L6:
            if (r5.hasNext() == false) goto L8;
            r4.append(Joiner.access$100(this.joiner));
            Map.Entry<?, ?> r1 = r5.next();
            r4.append(this.joiner.toString(r1.getKey()));
            r4.append(this.keyValueSeparator);
            r4.append(this.joiner.toString(r1.getValue()));
        L8:
            return r4;
        }

        public StringBuilder appendTo(StringBuilder r1, Iterable<? extends Map.Entry<?, ?>> r2) {
            return appendTo(r1, r2.iterator());
        }

        public StringBuilder appendTo(StringBuilder r1, Iterator<? extends Map.Entry<?, ?>> r2) {
            appendTo(r1, r2);     // Catch: IOException -> L4
            return r1;
        L4:
            e = move-exception;
            throw new AssertionError(e);
        }

        public String join(Iterable<? extends Map.Entry<?, ?>> r1) {
            return join(r1.iterator());
        }

        public String join(Iterator<? extends Map.Entry<?, ?>> r2) {
            return appendTo(new StringBuilder(), r2).toString();
        }

        @CheckReturnValue
        public MapJoiner useForNull(String r3) {
            return new MapJoiner(this.joiner.useForNull(r3), this.keyValueSeparator);
        }
    }

    /* synthetic */ Joiner(Joiner r1, AnonymousClass1 r2) {
        this(r1);
    }

    static /* synthetic */ String access$100(Joiner r0) {
        return r0.separator;
    }

    public static Joiner on(String r1) {
        return new Joiner(r1);
    }

    public static Joiner on(char r1) {
        return new Joiner(String.valueOf(r1));
    }

    private Joiner(String r1) {
        this.separator = (String) Preconditions.checkNotNull(r1);
    }

    private Joiner(Joiner r1) {
        this.separator = r1.separator;
    }

    public <A extends Appendable> A appendTo(A r1, Iterable<?> r2) throws IOException {
        return (A) appendTo(r1, r2.iterator());
    }

    public <A extends Appendable> A appendTo(A r2, Iterator<?> r3) throws IOException {
        Preconditions.checkNotNull(r2);
        if (r3.hasNext() == false) goto L8;
        r2.append(toString(r3.next()));
    L6:
        if (r3.hasNext() == false) goto L8;
        r2.append(this.separator);
        r2.append(toString(r3.next()));
    L8:
        return r2;
    }

    public final <A extends Appendable> A appendTo(A r1, Object[] r2) throws IOException {
        return (A) appendTo(r1, Arrays.asList(r2));
    }

    public final <A extends Appendable> A appendTo(A r1, @Nullable Object r2, @Nullable Object r3, Object... r4) throws IOException {
        return (A) appendTo(r1, iterable(r2, r3, r4));
    }

    public final StringBuilder appendTo(StringBuilder r1, Iterable<?> r2) {
        return appendTo(r1, r2.iterator());
    }

    public final StringBuilder appendTo(StringBuilder r1, Iterator<?> r2) {
        appendTo(r1, r2);     // Catch: IOException -> L4
        return r1;
    L4:
        e = move-exception;
        throw new AssertionError(e);
    }

    public final StringBuilder appendTo(StringBuilder r1, Object[] r2) {
        return appendTo(r1, Arrays.asList(r2));
    }

    public final StringBuilder appendTo(StringBuilder r1, @Nullable Object r2, @Nullable Object r3, Object... r4) {
        return appendTo(r1, iterable(r2, r3, r4));
    }

    public final String join(Iterable<?> r1) {
        return join(r1.iterator());
    }

    public final String join(Iterator<?> r2) {
        return appendTo(new StringBuilder(), r2).toString();
    }

    public final String join(Object[] r1) {
        return join(Arrays.asList(r1));
    }

    public final String join(@Nullable Object r1, @Nullable Object r2, Object... r3) {
        return join(iterable(r1, r2, r3));
    }

    @CheckReturnValue
    public Joiner useForNull(final String r2) {
        Preconditions.checkNotNull(r2);
        return new AnonymousClass1(this, this, r2);
    }

    @CheckReturnValue
    public Joiner skipNulls() {
        return new AnonymousClass2(this, this);
    }

    @CheckReturnValue
    public MapJoiner withKeyValueSeparator(String r3) {
        return new MapJoiner(this, r3, null);
    }

    CharSequence toString(Object r1) {
        Preconditions.checkNotNull(r1);
        if ((r1 instanceof CharSequence) == false) goto L6;
        return (CharSequence) r1;
    L6:
        return r1.toString();
    }

    private static Iterable<Object> iterable(final Object r1, final Object r2, final Object[] r3) {
        Preconditions.checkNotNull(r3);
        return new AnonymousClass3(r3, r1, r2);
    }
}
