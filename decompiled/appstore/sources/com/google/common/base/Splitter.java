package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import kotlinx.coroutines.channels.Channel;

/* JADX INFO: loaded from: classes3.dex */
@GwtCompatible(emulated = true)
public final class Splitter {
    private final int limit;
    private final boolean omitEmptyStrings;
    private final Strategy strategy;
    private final CharMatcher trimmer;

    @Beta
    public static final class MapSplitter {
        private static final String INVALID_ENTRY_MESSAGE = "Chunk [%s] is not a valid entry";
        private final Splitter entrySplitter;
        private final Splitter outerSplitter;

        public /* synthetic */ MapSplitter(Splitter r10, Splitter r11, AnonymousClass1 r12) {
            this(r10, r11);
        }

        public Map<String, String> split(CharSequence r10) {
            LinkedHashMap r11 = new LinkedHashMap();
            Iterator<String> r12 = this.outerSplitter.split(r10).iterator();
        L4:
            if (r12.hasNext() == false) goto L7;
            String r13 = r12.next();
            Iterator r14 = Splitter.access$000(this.entrySplitter, r13);
            Preconditions.checkArgument(r14.hasNext(), INVALID_ENTRY_MESSAGE, r13);
            String r15 = (String) r14.next();
            Preconditions.checkArgument(!r11.containsKey(r15), "Duplicate key [%s] found.", r15);
            Preconditions.checkArgument(r14.hasNext(), INVALID_ENTRY_MESSAGE, r13);
            r11.put(r15, (String) r14.next());
            Preconditions.checkArgument(!r14.hasNext(), INVALID_ENTRY_MESSAGE, r13);
            goto L4
        L7:
            return Collections.unmodifiableMap(r11);
        }

        private MapSplitter(Splitter r10, Splitter r11) {
            this.outerSplitter = r10;
            this.entrySplitter = (Splitter) Preconditions.checkNotNull(r11);
        }
    }

    public static abstract class SplittingIterator extends AbstractIterator<String> {
        int limit;
        int offset;
        final boolean omitEmptyStrings;
        final CharSequence toSplit;
        final CharMatcher trimmer;

        public SplittingIterator(Splitter r10, CharSequence r11) {
            this.offset = 0;
            this.trimmer = Splitter.access$200(r10);
            this.omitEmptyStrings = Splitter.access$300(r10);
            this.limit = Splitter.access$400(r10);
            this.toSplit = r11;
        }

        @Override // com.google.common.base.AbstractIterator
        public /* bridge */ /* synthetic */ String computeNext() {
            return computeNext2();
        }

        public abstract int separatorEnd(int r10);

        public abstract int separatorStart(int r10);

        @Override // com.google.common.base.AbstractIterator
        /* JADX INFO: renamed from: computeNext, reason: avoid collision after fix types in other method */
        public String computeNext2() {
            int r10 = this.offset;
        L3:
            int r11 = this.offset;
            if (r11 == (-1)) goto L37;
            int r12 = separatorStart(r11);
            if (r12 != (-1)) goto L8;
            r12 = this.toSplit.length();
            this.offset = -1;
        L9:
            int r13 = this.offset;
            if (r13 == r10) goto L11;
        L14:
            if (r10 >= r12) goto L18;
            if (this.trimmer.matches(this.toSplit.charAt(r10)) == false) goto L18;
            r10 = r10 + 1;
        L18:
            if (r12 <= r10) goto L23;
            if (this.trimmer.matches(this.toSplit.charAt(r12 - 1)) == false) goto L23;
            r12 = r12 - 1;
        L23:
            if (this.omitEmptyStrings == false) goto L26;
            if (r10 != r12) goto L26;
            r10 = this.offset;
        L26:
            int r14 = this.limit;
            if (r14 != 1) goto L33;
            r12 = this.toSplit.length();
            this.offset = -1;
        L29:
            if (r12 <= r10) goto L35;
            if (this.trimmer.matches(this.toSplit.charAt(r12 - 1)) == false) goto L35;
            r12 = r12 - 1;
        L35:
            return this.toSplit.subSequence(r10, r12).toString();
        L33:
            this.limit = r14 - 1;
            goto L35
        L11:
            int r15 = r13 + 1;
            this.offset = r15;
            if (r15 <= this.toSplit.length()) goto L3;
            this.offset = -1;
            goto L3
        L8:
            this.offset = separatorEnd(r12);
            goto L9
        L37:
            return endOfData();
        }
    }

    public interface Strategy {
        Iterator<String> iterator(Splitter r10, CharSequence r11);
    }

    private Splitter(Strategy r10) {
        this(r10, false, CharMatcher.none(), Channel.UNLIMITED);
    }

    public static /* synthetic */ Iterator access$000(Splitter r10, CharSequence r11) {
        return r10.splittingIterator(r11);
    }

    public static /* synthetic */ CharMatcher access$200(Splitter r10) {
        return r10.trimmer;
    }

    public static /* synthetic */ boolean access$300(Splitter r10) {
        return r10.omitEmptyStrings;
    }

    public static /* synthetic */ int access$400(Splitter r10) {
        return r10.limit;
    }

    public static Splitter fixedLength(final int r10) {
        if (r10 <= 0) goto L4;
        boolean r11 = true;
    L5:
        Preconditions.checkArgument(r11, "The length may not be less than 1");
        return new Splitter(new AnonymousClass4(r10));
    L4:
        r11 = false;
        goto L5
    }

    public static Splitter on(char r10) {
        return on(CharMatcher.is(r10));
    }

    @GwtIncompatible
    public static Splitter onPattern(String r10) {
        return on(Platform.compilePattern(r10));
    }

    private Iterator<String> splittingIterator(CharSequence r10) {
        return this.strategy.iterator(this, r10);
    }

    public Splitter limit(int r10) {
        if (r10 <= 0) goto L4;
        boolean r11 = true;
    L5:
        Preconditions.checkArgument(r11, "must be greater than zero: %s", r10);
        return new Splitter(this.strategy, this.omitEmptyStrings, this.trimmer, r10);
    L4:
        r11 = false;
        goto L5
    }

    public Splitter omitEmptyStrings() {
        return new Splitter(this.strategy, true, this.trimmer, this.limit);
    }

    public Iterable<String> split(final CharSequence r10) {
        Preconditions.checkNotNull(r10);
        return new AnonymousClass5(this, r10);
    }

    public List<String> splitToList(CharSequence r10) {
        Preconditions.checkNotNull(r10);
        Iterator<String> r11 = splittingIterator(r10);
        ArrayList r12 = new ArrayList();
    L4:
        if (r11.hasNext() == false) goto L7;
        r12.add(r11.next());
        goto L4
    L7:
        return Collections.unmodifiableList(r12);
    }

    public Splitter trimResults() {
        return trimResults(CharMatcher.whitespace());
    }

    @Beta
    public MapSplitter withKeyValueSeparator(String r10) {
        return withKeyValueSeparator(on(r10));
    }

    private Splitter(Strategy r10, boolean r11, CharMatcher r12, int r13) {
        this.strategy = r10;
        this.omitEmptyStrings = r11;
        this.trimmer = r12;
        this.limit = r13;
    }

    public static Splitter on(final CharMatcher r10) {
        Preconditions.checkNotNull(r10);
        return new Splitter(new AnonymousClass1(r10));
    }

    public Splitter trimResults(CharMatcher r10) {
        Preconditions.checkNotNull(r10);
        return new Splitter(this.strategy, this.omitEmptyStrings, r10, this.limit);
    }

    @Beta
    public MapSplitter withKeyValueSeparator(char r10) {
        return withKeyValueSeparator(on(r10));
    }

    @Beta
    public MapSplitter withKeyValueSeparator(Splitter r10) {
        return new MapSplitter(this, r10, null);
    }

    public static Splitter on(final String r10) {
        if (r10.length() == 0) goto L5;
        boolean r11 = true;
    L6:
        Preconditions.checkArgument(r11, "The separator may not be the empty string.");
        if (r10.length() != 1) goto L11;
        return on(r10.charAt(0));
    L11:
        return new Splitter(new AnonymousClass2(r10));
    L5:
        r11 = false;
        goto L6
    }

    @GwtIncompatible
    public static Splitter on(Pattern r10) {
        return on(new JdkPattern(r10));
    }

    private static Splitter on(final CommonPattern r10) {
        Preconditions.checkArgument(!r10.matcher("").matches(), "The pattern may not match the empty string: %s", r10);
        return new Splitter(new AnonymousClass3(r10));
    }
}
