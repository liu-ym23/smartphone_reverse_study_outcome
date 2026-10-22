package org.apache.commons.compress.compressors.lz77support;

/* JADX INFO: loaded from: classes3.dex */
public final class Parameters {
    public static final int TRUE_MIN_BACK_REFERENCE_LENGTH = 3;
    private final boolean lazyMatching;
    private final int lazyThreshold;
    private final int maxBackReferenceLength;
    private final int maxCandidates;
    private final int maxLiteralLength;
    private final int maxOffset;
    private final int minBackReferenceLength;
    private final int niceBackReferenceLength;
    private final int windowSize;

    /* JADX INFO: renamed from: org.apache.commons.compress.compressors.lz77support.Parameters$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {
        private Boolean lazyMatches;
        private Integer lazyThreshold;
        private int maxBackReferenceLength;
        private Integer maxCandidates;
        private int maxLiteralLength;
        private int maxOffset;
        private int minBackReferenceLength;
        private Integer niceBackReferenceLength;
        private final int windowSize;

        /* synthetic */ Builder(int x0, AnonymousClass1 x1) {
            this(x0);
        }

        private Builder(int windowSize) {
            if (windowSize < 2) goto L9;
            if (Parameters.access$100(windowSize) == false) goto L9;
            this.windowSize = windowSize;
            this.minBackReferenceLength = 3;
            this.maxBackReferenceLength = windowSize - 1;
            this.maxOffset = windowSize - 1;
            this.maxLiteralLength = windowSize;
            return;
        L9:
            throw new IllegalArgumentException("windowSize must be a power of two");
        }

        public Builder withMinBackReferenceLength(int minBackReferenceLength) {
            this.minBackReferenceLength = Math.max(3, minBackReferenceLength);
            if (this.windowSize < this.minBackReferenceLength) goto L9;
            if (this.maxBackReferenceLength >= this.minBackReferenceLength) goto L7;
            this.maxBackReferenceLength = this.minBackReferenceLength;
        L7:
            return this;
        L9:
            throw new IllegalArgumentException("minBackReferenceLength can't be bigger than windowSize");
        }

        public Builder withMaxBackReferenceLength(int maxBackReferenceLength) {
            if (maxBackReferenceLength >= this.minBackReferenceLength) goto L5;
            int r0 = this.minBackReferenceLength;
        L6:
            this.maxBackReferenceLength = r0;
            return this;
        L5:
            r0 = Math.min(maxBackReferenceLength, this.windowSize - 1);
            goto L6
        }

        public Builder withMaxOffset(int maxOffset) {
            int r1 = this.windowSize - 1;
            if (maxOffset < 1) goto L6;
            r1 = Math.min(maxOffset, r1);
        L6:
            this.maxOffset = r1;
            return this;
        }

        public Builder withMaxLiteralLength(int maxLiteralLength) {
            if (maxLiteralLength >= 1) goto L5;
            int r0 = this.windowSize;
        L6:
            this.maxLiteralLength = r0;
            return this;
        L5:
            r0 = Math.min(maxLiteralLength, this.windowSize);
            goto L6
        }

        public Builder withNiceBackReferenceLength(int niceLen) {
            this.niceBackReferenceLength = Integer.valueOf(niceLen);
            return this;
        }

        public Builder withMaxNumberOfCandidates(int maxCandidates) {
            this.maxCandidates = Integer.valueOf(maxCandidates);
            return this;
        }

        public Builder withLazyMatching(boolean lazy) {
            this.lazyMatches = Boolean.valueOf(lazy);
            return this;
        }

        public Builder withLazyThreshold(int threshold) {
            this.lazyThreshold = Integer.valueOf(threshold);
            return this;
        }

        public Builder tunedForSpeed() {
            this.niceBackReferenceLength = Integer.valueOf(Math.max(this.minBackReferenceLength, this.maxBackReferenceLength / 8));
            this.maxCandidates = Integer.valueOf(Math.max(32, this.windowSize / 1024));
            this.lazyMatches = false;
            this.lazyThreshold = Integer.valueOf(this.minBackReferenceLength);
            return this;
        }

        public Builder tunedForCompressionRatio() {
            Integer r0 = Integer.valueOf(this.maxBackReferenceLength);
            this.lazyThreshold = r0;
            this.niceBackReferenceLength = r0;
            this.maxCandidates = Integer.valueOf(Math.max(32, this.windowSize / 16));
            this.lazyMatches = true;
            return this;
        }

        public Parameters build() {
            if (this.niceBackReferenceLength == null) goto L5;
            int r0 = this.niceBackReferenceLength.intValue();
        L6:
            int niceLen = r0;
            if (this.maxCandidates == null) goto L10;
            int r1 = this.maxCandidates.intValue();
        L9:
            int candidates = r1;
            if (this.lazyMatches != null) goto L14;
        L18:
            boolean r2 = true;
        L17:
            boolean lazy = r2;
            if (lazy == true) goto L21;
            int r3 = this.minBackReferenceLength;
        L23:
            int threshold = r3;
        L27:
            return new Parameters(this.windowSize, this.minBackReferenceLength, this.maxBackReferenceLength, this.maxOffset, this.maxLiteralLength, niceLen, candidates, lazy, threshold, null);
        L21:
            if (this.lazyThreshold == null) goto L24;
            r3 = this.lazyThreshold.intValue();
            goto L23
        L24:
            threshold = niceLen;
            goto L27
        L14:
            if (this.lazyMatches.booleanValue() == true) goto L18;
            r2 = false;
            goto L17
        L10:
            r1 = Math.max(256, this.windowSize / 128);
            goto L9
        L5:
            r0 = Math.max(this.minBackReferenceLength, this.maxBackReferenceLength / 2);
            goto L6
        }
    }

    /* synthetic */ Parameters(int x0, int x1, int x2, int x3, int x4, int x5, int x6, boolean x7, int x8, AnonymousClass1 x9) {
        this(x0, x1, x2, x3, x4, x5, x6, x7, x8);
    }

    static /* synthetic */ boolean access$100(int x0) {
        return isPowerOfTwo(x0);
    }

    public static Builder builder(int windowSize) {
        return new Builder(windowSize, null);
    }

    private Parameters(int windowSize, int minBackReferenceLength, int maxBackReferenceLength, int maxOffset, int maxLiteralLength, int niceBackReferenceLength, int maxCandidates, boolean lazyMatching, int lazyThreshold) {
        this.windowSize = windowSize;
        this.minBackReferenceLength = minBackReferenceLength;
        this.maxBackReferenceLength = maxBackReferenceLength;
        this.maxOffset = maxOffset;
        this.maxLiteralLength = maxLiteralLength;
        this.niceBackReferenceLength = niceBackReferenceLength;
        this.maxCandidates = maxCandidates;
        this.lazyMatching = lazyMatching;
        this.lazyThreshold = lazyThreshold;
    }

    public int getWindowSize() {
        return this.windowSize;
    }

    public int getMinBackReferenceLength() {
        return this.minBackReferenceLength;
    }

    public int getMaxBackReferenceLength() {
        return this.maxBackReferenceLength;
    }

    public int getMaxOffset() {
        return this.maxOffset;
    }

    public int getMaxLiteralLength() {
        return this.maxLiteralLength;
    }

    public int getNiceBackReferenceLength() {
        return this.niceBackReferenceLength;
    }

    public int getMaxCandidates() {
        return this.maxCandidates;
    }

    public boolean getLazyMatching() {
        return this.lazyMatching;
    }

    public int getLazyMatchingThreshold() {
        return this.lazyThreshold;
    }

    private static final boolean isPowerOfTwo(int x) {
        if (((x - 1) & x) != 0) goto L5;
        return true;
    L5:
        return false;
    }
}
