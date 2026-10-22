package androidx.compose.material3.carousel;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.e;

@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005H\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\u0006\u0010\u0018\u001a\u00020\u0003R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000f¨\u0006\u001a"}, d2 = {"Landroidx/compose/material3/carousel/Arrangement;", "", "priority", "", "smallSize", "", "smallCount", "mediumSize", "mediumCount", "largeSize", "largeCount", "(IFIFIFI)V", "getLargeCount", "()I", "getLargeSize", "()F", "getMediumCount", "getMediumSize", "getSmallCount", "getSmallSize", "cost", "targetLargeSize", "isValid", "", "itemCount", "Companion", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Arrangement {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final float MediumItemFlexPercentage = 0.1f;
    private final int largeCount;
    private final float largeSize;
    private final int mediumCount;
    private final float mediumSize;
    private final int priority;
    private final int smallCount;
    private final float smallSize;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J0\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0002JX\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0013J`\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Landroidx/compose/material3/carousel/Arrangement$Companion;", "", "()V", "MediumItemFlexPercentage", "", "calculateLargeSize", "availableSpace", "smallCount", "", "smallSize", "mediumCount", "largeCount", "findLowestCostArrangement", "Landroidx/compose/material3/carousel/Arrangement;", "itemSpacing", "targetSmallSize", "minSmallSize", "maxSmallSize", "smallCounts", "", "targetMediumSize", "mediumCounts", "targetLargeSize", "largeCounts", "fit", "priority", "mediumSize", "largeSize", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        private final float calculateLargeSize(float availableSpace, int smallCount, float smallSize, int mediumCount, int largeCount) {
            float f = smallCount;
            float f7 = mediumCount / 2.0f;
            return (availableSpace - ((f + f7) * smallSize)) / (largeCount + f7);
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x003e  */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0042  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0069  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x0071  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private final androidx.compose.material3.carousel.Arrangement fit(int r9, float r10, float r11, int r12, float r13, float r14, float r15, int r16, float r17, int r18, float r19) {
            /*
                r8 = this;
                r4 = r16
                r5 = r18
                int r0 = r5 + r4
                int r0 = r0 + r12
                int r0 = r0 + (-1)
                float r0 = (float) r0
                float r0 = r0 * r11
                float r1 = r10 - r0
                float r10 = g1.AbstractC1451a.t(r13, r14, r15)
                float r11 = (float) r5
                float r0 = r19 * r11
                float r6 = (float) r4
                float r2 = r17 * r6
                float r2 = r2 + r0
                float r0 = (float) r12
                float r3 = r10 * r0
                float r3 = r3 + r2
                float r2 = r1 - r3
                r7 = 0
                if (r12 <= 0) goto L2e
                int r3 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
                if (r3 <= 0) goto L2e
                float r2 = r2 / r0
                float r0 = r15 - r10
                float r0 = java.lang.Math.min(r2, r0)
            L2c:
                float r10 = r10 + r0
                goto L3c
            L2e:
                if (r12 <= 0) goto L3c
                int r3 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
                if (r3 >= 0) goto L3c
                float r2 = r2 / r0
                float r0 = r14 - r10
                float r0 = java.lang.Math.max(r2, r0)
                goto L2c
            L3c:
                if (r12 <= 0) goto L42
                r3 = r10
            L3f:
                r0 = r8
                r2 = r12
                goto L44
            L42:
                r3 = r7
                goto L3f
            L44:
                float r8 = r0.calculateLargeSize(r1, r2, r3, r4, r5)
                r2 = r3
                float r3 = r8 + r2
                r10 = 1073741824(0x40000000, float:2.0)
                float r3 = r3 / r10
                if (r16 <= 0) goto L6e
                int r10 = (r8 > r19 ? 1 : (r8 == r19 ? 0 : -1))
                if (r10 != 0) goto L55
                goto L6e
            L55:
                float r10 = r19 - r8
                float r10 = r10 * r11
                r0 = 1036831949(0x3dcccccd, float:0.1)
                float r0 = r0 * r3
                float r0 = r0 * r6
                float r1 = java.lang.Math.abs(r10)
                float r0 = java.lang.Math.min(r1, r0)
                int r10 = (r10 > r7 ? 1 : (r10 == r7 ? 0 : -1))
                if (r10 <= 0) goto L71
                float r10 = r0 / r6
                float r3 = r3 - r10
                float r0 = r0 / r11
                float r8 = r8 + r0
            L6e:
                r6 = r8
                r4 = r3
                goto L77
            L71:
                float r10 = r0 / r6
                float r3 = r3 + r10
                float r0 = r0 / r11
                float r8 = r8 - r0
                goto L6e
            L77:
                androidx.compose.material3.carousel.Arrangement r0 = new androidx.compose.material3.carousel.Arrangement
                r1 = r9
                r3 = r12
                r5 = r16
                r7 = r18
                r0.<init>(r1, r2, r3, r4, r5, r6, r7)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.carousel.Arrangement.Companion.fit(int, float, float, int, float, float, float, int, float, int, float):androidx.compose.material3.carousel.Arrangement");
        }

        public final Arrangement findLowestCostArrangement(float availableSpace, float itemSpacing, float targetSmallSize, float minSmallSize, float maxSmallSize, int[] smallCounts, float targetMediumSize, int[] mediumCounts, float targetLargeSize, int[] largeCounts) {
            int[] iArr = smallCounts;
            int length = largeCounts.length;
            Arrangement arrangement = null;
            int i = 1;
            int i6 = 0;
            while (i6 < length) {
                int i10 = largeCounts[i6];
                int length2 = mediumCounts.length;
                int i11 = 0;
                while (i11 < length2) {
                    int i12 = mediumCounts[i11];
                    int length3 = iArr.length;
                    int i13 = 0;
                    while (i13 < length3) {
                        int i14 = i11;
                        int i15 = iArr[i13];
                        Arrangement arrangement2 = arrangement;
                        int i16 = i6;
                        int i17 = length2;
                        int i18 = length3;
                        int i19 = i13;
                        Arrangement arrangementFit = fit(i, availableSpace, itemSpacing, i15, targetSmallSize, minSmallSize, maxSmallSize, i12, targetMediumSize, i10, targetLargeSize);
                        if (arrangement2 != null && arrangementFit.cost(targetLargeSize) >= arrangement2.cost(targetLargeSize)) {
                            arrangement = arrangement2;
                        } else {
                            if (arrangementFit.cost(targetLargeSize) == 0.0f) {
                                return arrangementFit;
                            }
                            arrangement = arrangementFit;
                        }
                        i++;
                        i13 = i19 + 1;
                        iArr = smallCounts;
                        i6 = i16;
                        length2 = i17;
                        i11 = i14;
                        length3 = i18;
                    }
                    i11++;
                    iArr = smallCounts;
                }
                i6++;
                iArr = smallCounts;
            }
            return arrangement;
        }

        private Companion() {
        }
    }

    public Arrangement(int i, float f, int i6, float f7, int i10, float f9, int i11) {
        this.priority = i;
        this.smallSize = f;
        this.smallCount = i6;
        this.mediumSize = f7;
        this.mediumCount = i10;
        this.largeSize = f9;
        this.largeCount = i11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float cost(float targetLargeSize) {
        if (isValid()) {
            return Math.abs(targetLargeSize - this.largeSize) * this.priority;
        }
        return Float.MAX_VALUE;
    }

    private final boolean isValid() {
        int i = this.largeCount;
        if (i <= 0 || this.smallCount <= 0 || this.mediumCount <= 0) {
            return i <= 0 || this.smallCount <= 0 || this.largeSize > this.smallSize;
        }
        float f = this.largeSize;
        float f7 = this.mediumSize;
        return f > f7 && f7 > this.smallSize;
    }

    public final int getLargeCount() {
        return this.largeCount;
    }

    public final float getLargeSize() {
        return this.largeSize;
    }

    public final int getMediumCount() {
        return this.mediumCount;
    }

    public final float getMediumSize() {
        return this.mediumSize;
    }

    public final int getSmallCount() {
        return this.smallCount;
    }

    public final float getSmallSize() {
        return this.smallSize;
    }

    public final int itemCount() {
        return this.largeCount + this.mediumCount + this.smallCount;
    }
}
