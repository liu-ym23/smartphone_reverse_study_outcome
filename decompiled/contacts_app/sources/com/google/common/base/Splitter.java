package com.google.common.base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import javax.annotation.CheckReturnValue;

/* JADX INFO: loaded from: classes2.dex */
public final class Splitter {
    private final int limit;
    private final boolean omitEmptyStrings;
    private final Strategy strategy;
    private final CharMatcher trimmer;

    public static final class MapSplitter {
        private static final String INVALID_ENTRY_MESSAGE = "Chunk [%s] is not a valid entry";
        private final Splitter entrySplitter;
        private final Splitter outerSplitter;

        /* synthetic */ MapSplitter(Splitter r1, Splitter r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        private MapSplitter(Splitter r1, Splitter r2) {
            this.outerSplitter = r1;
            this.entrySplitter = (Splitter) Preconditions.checkNotNull(r2);
        }

        public Map<String, String> split(CharSequence r11) {
            LinkedHashMap r0 = new LinkedHashMap();
            Iterator<String> r12 = this.outerSplitter.split(r11).iterator();
        L4:
            if (r12.hasNext() == false) goto L7;
            String r1 = r12.next();
            Iterator r2 = Splitter.access$000(this.entrySplitter, r1);
            Preconditions.checkArgument(r2.hasNext(), INVALID_ENTRY_MESSAGE, new Object[]{r1});
            String r3 = (String) r2.next();
            Preconditions.checkArgument(!r0.containsKey(r3), "Duplicate key [%s] found.", new Object[]{r3});
            Preconditions.checkArgument(r2.hasNext(), INVALID_ENTRY_MESSAGE, new Object[]{r1});
            r0.put(r3, (String) r2.next());
            Preconditions.checkArgument(!r2.hasNext(), INVALID_ENTRY_MESSAGE, new Object[]{r1});
            goto L4
        L7:
            return Collections.unmodifiableMap(r0);
        }
    }

    private static abstract class SplittingIterator extends AbstractIterator<String> {
        int limit;
        int offset;
        final boolean omitEmptyStrings;
        final CharSequence toSplit;
        final CharMatcher trimmer;

        abstract int separatorEnd(int r1);

        abstract int separatorStart(int r1);

        @Override // com.google.common.base.AbstractIterator
        protected /* bridge */ /* synthetic */ String computeNext() {
            return computeNext2();
        }

        protected SplittingIterator(Splitter r2, CharSequence r3) {
            this.offset = 0;
            this.trimmer = Splitter.access$200(r2);
            this.omitEmptyStrings = Splitter.access$300(r2);
            this.limit = Splitter.access$400(r2);
            this.toSplit = r3;
        }

        @Override // com.google.common.base.AbstractIterator
        /* JADX INFO: renamed from: computeNext, reason: avoid collision after fix types in other method */
        protected String computeNext2() {
            int r0 = this.offset;
        L3:
            int r1 = this.offset;
            if (r1 == (-1)) goto L37;
            int r2 = separatorStart(r1);
            if (r2 != (-1)) goto L8;
            r2 = this.toSplit.length();
            this.offset = -1;
        L9:
            int r3 = this.offset;
            if (r3 == r0) goto L11;
        L14:
            if (r0 >= r2) goto L18;
            if (this.trimmer.matches(this.toSplit.charAt(r0)) == false) goto L18;
            r0 = r0 + 1;
        L18:
            if (r2 <= r0) goto L23;
            if (this.trimmer.matches(this.toSplit.charAt(r2 - 1)) == false) goto L23;
            r2 = r2 - 1;
        L23:
            if (this.omitEmptyStrings == false) goto L26;
            if (r0 != r2) goto L26;
            r0 = this.offset;
        L26:
            int r4 = this.limit;
            if (r4 != 1) goto L33;
            r2 = this.toSplit.length();
            this.offset = -1;
        L29:
            if (r2 <= r0) goto L35;
            if (this.trimmer.matches(this.toSplit.charAt(r2 - 1)) == false) goto L35;
            r2 = r2 - 1;
        L35:
            return this.toSplit.subSequence(r0, r2).toString();
        L33:
            this.limit = r4 - 1;
            goto L35
        L11:
            int r5 = r3 + 1;
            this.offset = r5;
            if (r5 < this.toSplit.length()) goto L3;
            this.offset = -1;
            goto L3
        L8:
            this.offset = separatorEnd(r2);
            goto L9
        L37:
            return endOfData();
        }
    }

    private interface Strategy {
        Iterator<String> iterator(Splitter r1, CharSequence r2);
    }

    static /* synthetic */ Iterator access$000(Splitter r0, CharSequence r1) {
        return r0.splittingIterator(r1);
    }

    static /* synthetic */ CharMatcher access$200(Splitter r0) {
        return r0.trimmer;
    }

    static /* synthetic */ boolean access$300(Splitter r0) {
        return r0.omitEmptyStrings;
    }

    static /* synthetic */ int access$400(Splitter r0) {
        return r0.limit;
    }

    private Splitter(Strategy r4) {
        this(r4, false, CharMatcher.NONE, Integer.MAX_VALUE);
    }

    private Splitter(Strategy r1, boolean r2, CharMatcher r3, int r4) {
        this.strategy = r1;
        this.omitEmptyStrings = r2;
        this.trimmer = r3;
        this.limit = r4;
    }

    public static Splitter on(char r0) {
        return on(CharMatcher.is(r0));
    }

    public static Splitter on(final CharMatcher r2) {
        Preconditions.checkNotNull(r2);
        return new Splitter(new AnonymousClass1(r2));
    }

    public static Splitter on(final String r2) {
        if (r2.length() == 0) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkArgument(r0, "The separator may not be the empty string.");
        return new Splitter(new AnonymousClass2(r2));
    L5:
        r0 = false;
        goto L6
    }

    public static Splitter on(final Pattern r3) {
        Preconditions.checkNotNull(r3);
        Preconditions.checkArgument(!r3.matcher("").matches(), "The pattern may not match the empty string: %s", new Object[]{r3});
        return new Splitter(new AnonymousClass3(r3));
    }

    public static Splitter onPattern(String r0) {
        return on(Pattern.compile(r0));
    }

    public static Splitter fixedLength(final int r2) {
        if (r2 <= 0) goto L4;
        boolean r0 = true;
    L5:
        Preconditions.checkArgument(r0, "The length may not be less than 1");
        return new Splitter(new AnonymousClass4(r2));
    L4:
        r0 = false;
        goto L5
    }

    @CheckReturnValue
    public Splitter omitEmptyStrings() {
        return new Splitter(this.strategy, true, this.trimmer, this.limit);
    }

    @CheckReturnValue
    public Splitter limit(int r5) {
        if (r5 <= 0) goto L5;
        boolean r2 = true;
    L6:
        Preconditions.checkArgument(r2, "must be greater than zero: %s", new Object[]{Integer.valueOf(r5)});
        return new Splitter(this.strategy, this.omitEmptyStrings, this.trimmer, r5);
    L5:
        r2 = false;
        goto L6
    }

    @CheckReturnValue
    public Splitter trimResults() {
        return trimResults(CharMatcher.WHITESPACE);
    }

    @CheckReturnValue
    public Splitter trimResults(CharMatcher r4) {
        Preconditions.checkNotNull(r4);
        return new Splitter(this.strategy, this.omitEmptyStrings, r4, this.limit);
    }

    public Iterable<String> split(final CharSequence r2) {
        Preconditions.checkNotNull(r2);
        return new AnonymousClass5(this, r2);
    }

    private Iterator<String> splittingIterator(CharSequence r2) {
        return this.strategy.iterator(this, r2);
    }

    public List<String> splitToList(CharSequence r2) {
        Preconditions.checkNotNull(r2);
        Iterator<String> r1 = splittingIterator(r2);
        ArrayList r3 = new ArrayList();
    L4:
        if (r1.hasNext() == false) goto L7;
        r3.add(r1.next());
        goto L4
    L7:
        return Collections.unmodifiableList(r3);
    }

    @CheckReturnValue
    public MapSplitter withKeyValueSeparator(String r1) {
        return withKeyValueSeparator(on(r1));
    }

    @CheckReturnValue
    public MapSplitter withKeyValueSeparator(char r1) {
        return withKeyValueSeparator(on(r1));
    }

    @CheckReturnValue
    public MapSplitter withKeyValueSeparator(Splitter r3) {
        return new MapSplitter(this, r3, null);
    }
}
