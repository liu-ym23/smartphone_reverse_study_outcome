package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible
public class Joiner {
    private final String separator;

    public static final class MapJoiner {
        private final Joiner joiner;
        private final String keyValueSeparator;

        public /* synthetic */ MapJoiner(Joiner r10, String r11, AnonymousClass1 r12) {
            this(r10, r11);
        }

        @CanIgnoreReturnValue
        public <A extends Appendable> A appendTo(A r10, Map<?, ?> r11) throws IOException {
            return (A) appendTo(r10, r11.entrySet());
        }

        public String join(Map<?, ?> r10) {
            return join(r10.entrySet());
        }

        public MapJoiner useForNull(String r10) {
            return new MapJoiner(this.joiner.useForNull(r10), this.keyValueSeparator);
        }

        private MapJoiner(Joiner r10, String r11) {
            this.joiner = r10;
            this.keyValueSeparator = (String) Preconditions.checkNotNull(r11);
        }

        @CanIgnoreReturnValue
        public StringBuilder appendTo(StringBuilder r10, Map<?, ?> r11) {
            return appendTo(r10, r11.entrySet());
        }

        @Beta
        public String join(Iterable<? extends Map.Entry<?, ?>> r10) {
            return join(r10.iterator());
        }

        @CanIgnoreReturnValue
        @Beta
        public <A extends Appendable> A appendTo(A r10, Iterable<? extends Map.Entry<?, ?>> r11) throws IOException {
            return (A) appendTo(r10, r11.iterator());
        }

        @Beta
        public String join(Iterator<? extends Map.Entry<?, ?>> r10) {
            return appendTo(new StringBuilder(), r10).toString();
        }

        @CanIgnoreReturnValue
        @Beta
        public <A extends Appendable> A appendTo(A r10, Iterator<? extends Map.Entry<?, ?>> r11) throws IOException {
            Preconditions.checkNotNull(r10);
            if (r11.hasNext() == false) goto L8;
            Map.Entry<?, ?> r12 = r11.next();
            r10.append(this.joiner.toString(r12.getKey()));
            r10.append(this.keyValueSeparator);
            r10.append(this.joiner.toString(r12.getValue()));
        L6:
            if (r11.hasNext() == false) goto L8;
            r10.append(Joiner.access$100(this.joiner));
            Map.Entry<?, ?> r13 = r11.next();
            r10.append(this.joiner.toString(r13.getKey()));
            r10.append(this.keyValueSeparator);
            r10.append(this.joiner.toString(r13.getValue()));
        L8:
            return r10;
        }

        @CanIgnoreReturnValue
        @Beta
        public StringBuilder appendTo(StringBuilder r10, Iterable<? extends Map.Entry<?, ?>> r11) {
            return appendTo(r10, r11.iterator());
        }

        @CanIgnoreReturnValue
        @Beta
        public StringBuilder appendTo(StringBuilder r10, Iterator<? extends Map.Entry<?, ?>> r11) {
            appendTo(r10, r11);     // Catch: IOException -> L4
            return r10;
        L4:
            e = move-exception;
            throw new AssertionError(e);
        }
    }

    public /* synthetic */ Joiner(Joiner r10, AnonymousClass1 r11) {
        this(r10);
    }

    public static /* synthetic */ String access$100(Joiner r10) {
        return r10.separator;
    }

    private static Iterable<Object> iterable(final Object r10, final Object r11, final Object[] r12) {
        Preconditions.checkNotNull(r12);
        return new AnonymousClass3(r12, r10, r11);
    }

    public static Joiner on(String r10) {
        return new Joiner(r10);
    }

    @CanIgnoreReturnValue
    public <A extends Appendable> A appendTo(A r10, Iterable<?> r11) throws IOException {
        return (A) appendTo(r10, r11.iterator());
    }

    public final String join(Iterable<?> r10) {
        return join(r10.iterator());
    }

    public Joiner skipNulls() {
        return new AnonymousClass2(this, this);
    }

    public CharSequence toString(Object r10) {
        Preconditions.checkNotNull(r10);
        if ((r10 instanceof CharSequence) == false) goto L6;
        return (CharSequence) r10;
    L6:
        return r10.toString();
    }

    public Joiner useForNull(final String r10) {
        Preconditions.checkNotNull(r10);
        return new AnonymousClass1(this, this, r10);
    }

    public MapJoiner withKeyValueSeparator(char r10) {
        return withKeyValueSeparator(String.valueOf(r10));
    }

    private Joiner(String r10) {
        this.separator = (String) Preconditions.checkNotNull(r10);
    }

    public static Joiner on(char r10) {
        return new Joiner(String.valueOf(r10));
    }

    @CanIgnoreReturnValue
    public <A extends Appendable> A appendTo(A r10, Iterator<?> r11) throws IOException {
        Preconditions.checkNotNull(r10);
        if (r11.hasNext() == false) goto L8;
        r10.append(toString(r11.next()));
    L6:
        if (r11.hasNext() == false) goto L8;
        r10.append(this.separator);
        r10.append(toString(r11.next()));
    L8:
        return r10;
    }

    public final String join(Iterator<?> r10) {
        return appendTo(new StringBuilder(), r10).toString();
    }

    public MapJoiner withKeyValueSeparator(String r10) {
        return new MapJoiner(this, r10, null);
    }

    public final String join(Object[] r10) {
        return join(Arrays.asList(r10));
    }

    private Joiner(Joiner r10) {
        this.separator = r10.separator;
    }

    public final String join(@NullableDecl Object r10, @NullableDecl Object r11, Object... r12) {
        return join(iterable(r10, r11, r12));
    }

    @CanIgnoreReturnValue
    public final <A extends Appendable> A appendTo(A r10, Object[] r11) throws IOException {
        return (A) appendTo(r10, Arrays.asList(r11));
    }

    @CanIgnoreReturnValue
    public final <A extends Appendable> A appendTo(A r10, @NullableDecl Object r11, @NullableDecl Object r12, Object... r13) throws IOException {
        return (A) appendTo(r10, iterable(r11, r12, r13));
    }

    @CanIgnoreReturnValue
    public final StringBuilder appendTo(StringBuilder r10, Iterable<?> r11) {
        return appendTo(r10, r11.iterator());
    }

    @CanIgnoreReturnValue
    public final StringBuilder appendTo(StringBuilder r10, Iterator<?> r11) {
        appendTo(r10, r11);     // Catch: IOException -> L4
        return r10;
    L4:
        e = move-exception;
        throw new AssertionError(e);
    }

    @CanIgnoreReturnValue
    public final StringBuilder appendTo(StringBuilder r10, Object[] r11) {
        return appendTo(r10, Arrays.asList(r11));
    }

    @CanIgnoreReturnValue
    public final StringBuilder appendTo(StringBuilder r10, @NullableDecl Object r11, @NullableDecl Object r12, Object... r13) {
        return appendTo(r10, iterable(r11, r12, r13));
    }
}
