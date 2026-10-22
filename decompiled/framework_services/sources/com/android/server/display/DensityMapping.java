package com.android.server.display;

import java.util.Arrays;
import java.util.Comparator;

/* JADX INFO: loaded from: classes2.dex */
public class DensityMapping {
    private final Entry[] mSortedDensityMappingEntries;

    static class Entry {
        public static final Entry ZEROES = null;
        public final int density;
        public final int squaredDiagonal;

        static {
            ZEROES = new Entry(0, 0, 0);
        }

        Entry(int width, int height, int density) {
            this.squaredDiagonal = (width * width) + (height * height);
            this.density = density;
        }

        public String toString() {
            return "DensityMappingEntry{squaredDiagonal=" + this.squaredDiagonal + ", density=" + this.density + '}';
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$-j39bLw_6ZVkuWnoffRSo_bQpEc, reason: not valid java name */
    public static /* synthetic */ int m3611$r8$lambda$j39bLw_6ZVkuWnoffRSo_bQpEc(Entry r0) {
        return lambda$new$0(r0);
    }

    static DensityMapping createByOwning(Entry[] densityMappingEntries) {
        return new DensityMapping(densityMappingEntries);
    }

    private DensityMapping(Entry[] densityMappingEntries) {
        Arrays.sort(densityMappingEntries, Comparator.comparingInt(new DensityMapping$$ExternalSyntheticLambda0()));
        this.mSortedDensityMappingEntries = densityMappingEntries;
        verifyDensityMapping(this.mSortedDensityMappingEntries);
    }

    private static /* synthetic */ int lambda$new$0(Entry entry) {
        return entry.squaredDiagonal;
    }

    public int getDensityForResolution(int width, int height) {
        int squaredDiagonal = (width * width) + (height * height);
        Entry left = Entry.ZEROES;
        Entry right = null;
        Entry[] r3 = this.mSortedDensityMappingEntries;
        int r4 = r3.length;
        int r5 = 0;
    L4:
        if (r5 >= r4) goto L10;
        Entry entry = r3[r5];
        if (entry.squaredDiagonal > squaredDiagonal) goto L8;
        left = entry;
        r5 = r5 + 1;
        goto L4
    L8:
        right = entry;
    L10:
        if (left.squaredDiagonal == squaredDiagonal) goto L12;
        if (right != null) goto L15;
        right = left;
        left = Entry.ZEROES;
    L15:
        double leftDiagonal = Math.sqrt(left.squaredDiagonal);
        double rightDiagonal = Math.sqrt(right.squaredDiagonal);
        double diagonal = Math.sqrt(squaredDiagonal);
        return (int) Math.round((((diagonal - leftDiagonal) * ((double) (right.density - left.density))) / (rightDiagonal - leftDiagonal)) + ((double) left.density));
    L12:
        return left.density;
    }

    private static void verifyDensityMapping(Entry[] sortedEntries) {
        int i = 1;
    L4:
        if (i >= sortedEntries.length) goto L15;
        Entry prev = sortedEntries[i - 1];
        Entry curr = sortedEntries[i];
        if (prev.squaredDiagonal == curr.squaredDiagonal) goto L13;
        if (prev.density > curr.density) goto L11;
        i = i + 1;
        goto L4
    L11:
        throw new IllegalStateException("Found two entries in the density mapping with increasing diagonal but decreasing density: " + prev + ", " + curr);
    L13:
        throw new IllegalStateException("Found two entries in the density mapping with the same diagonal: " + prev + ", " + curr);
    }

    public String toString() {
        return "DensityMapping{mDensityMappingEntries=" + Arrays.toString(this.mSortedDensityMappingEntries) + '}';
    }
}
