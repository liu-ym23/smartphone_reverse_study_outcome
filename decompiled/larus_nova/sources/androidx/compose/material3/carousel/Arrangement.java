package androidx.compose.material3.carousel;

import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0001\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0005H\u0002J\u0006\u0010\u0019\u001a\u00020\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010¨\u0006\u001b"}, d2 = {"Landroidx/compose/material3/carousel/Arrangement;", "", "priority", "", "smallSize", "", "smallCount", "mediumSize", "mediumCount", "largeSize", "largeCount", "<init>", "(IFIFIFI)V", "getSmallSize", "()F", "getSmallCount", "()I", "getMediumSize", "getMediumCount", "getLargeSize", "getLargeCount", "isValid", "", ChameleonOpenTracker.ParamKey.COST, "targetLargeSize", "itemCount", "Companion", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Arrangement {
    public static final int $stable = 0;
    public static final Companion Companion = null;
    private static final float MediumItemFlexPercentage = 0.1f;
    private final int largeCount;
    private final float largeSize;
    private final int mediumCount;
    private final float mediumSize;
    private final int priority;
    private final int smallCount;
    private final float smallSize;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JX\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u000eJ`\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u0005H\u0002J0\u0010\u001c\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u0015H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Landroidx/compose/material3/carousel/Arrangement$Companion;", "", "<init>", "()V", "MediumItemFlexPercentage", "", "findLowestCostArrangement", "Landroidx/compose/material3/carousel/Arrangement;", "availableSpace", "itemSpacing", "targetSmallSize", "minSmallSize", "maxSmallSize", "smallCounts", "", "targetMediumSize", "mediumCounts", "targetLargeSize", "largeCounts", "fit", "priority", "", "smallCount", "smallSize", "mediumCount", "mediumSize", "largeCount", "largeSize", "calculateLargeSize", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        private final float calculateLargeSize(float r100, int r101, float r102, int r103, int r104) {
            float r105 = r103 / 2.0f;
            return (r100 - ((r101 + r105) * r102)) / (r104 + r105);
        }

        public final Arrangement findLowestCostArrangement(float r210, float r211, float r310, float r311, float r312, int[] r313, float r314, int[] r315, float r316, int[] r317) {
            int r110 = r317.length;
            Arrangement r100 = null;
            int r101 = 1;
            int r111 = 0;
        L3:
            if (r111 >= r110) goto L24;
            int r112 = r317[r111];
            int r113 = r315.length;
            int r114 = 0;
        L5:
            if (r114 >= r113) goto L23;
            int r115 = r315[r114];
            int r102 = r313.length;
            Arrangement r103 = r100;
            int r212 = r101;
            int r104 = 0;
        L7:
            if (r104 >= r102) goto L22;
            int r105 = r313[r104];
            int r213 = r104;
            Arrangement r106 = r103;
            int r214 = r102;
            int r215 = r114;
            int r216 = r113;
            int r217 = r111;
            int r218 = r110;
            Arrangement r107 = fit(r212, r210, r211, r105, r310, r311, r312, r115, r314, r112, r316);
            if (r106 == null) goto L15;
            if (Arrangement.access$cost(r107, r316) < Arrangement.access$cost(r106, r316)) goto L15;
            r103 = r106;
        L21:
            r212 = r212 + 1;
            r104 = r213 + 1;
            r313 = r313;
            r102 = r214;
            r114 = r215;
            r113 = r216;
            r111 = r217;
            r110 = r218;
        L15:
            if (Arrangement.access$cost(r107, r316) != 0.0f) goto L17;
            boolean r108 = true;
        L18:
            if (r108 == true) goto L19;
            r103 = r107;
            goto L21
        L19:
            return r107;
        L17:
            r108 = false;
            goto L18
        L22:
            r114 = r114 + 1;
            r100 = r103;
            r101 = r212;
            r313 = r313;
            goto L5
        L23:
            r111 = r111 + 1;
            goto L3
        L24:
            return r100;
        }

        private final Arrangement fit(int r110, float r111, float r112, int r113, float r114, float r210, float r211, int r212, float r213, int r214, float r215) {
            boolean r100 = true;
            float r101 = r111 - ((((r214 + r212) + r113) - 1) * r112);
            float r102 = RangesKt.coerceIn(r114, r210, r211);
            float r115 = r214;
            float r116 = r212;
            float r103 = r113;
            float r104 = r101 - (((r215 * r115) + (r213 * r116)) + (r102 * r103));
            if (r113 > 0) goto L5;
        L8:
            if (r113 > 0) goto L10;
        L12:
            if (r113 <= 0) goto L14;
            float r117 = r102;
        L15:
            float r105 = calculateLargeSize(r101, r113, r117, r212, r214);
            float r106 = (r105 + r117) / 2.0f;
            if (r212 <= 0) goto L27;
            if (r105 == r215) goto L21;
            r100 = false;
        L21:
            if (r100 == true) goto L27;
            float r107 = (r215 - r105) * r115;
            float r108 = Math.min(Math.abs(r107), (0.1f * r106) * r116);
            if (r107 <= 0.0f) goto L25;
            r106 = r106 - (r108 / r116);
            r105 = r105 + (r108 / r115);
            goto L27
        L25:
            r106 = r106 + (r108 / r116);
            r105 = r105 - (r108 / r115);
        L27:
            return new Arrangement(r110, r117, r113, r106, r212, r105, r214);
        L14:
            r117 = 0.0f;
            goto L15
        L10:
            if (r104 >= 0.0f) goto L12;
            float r109 = Math.max(r104 / r103, r210 - r102);
        L7:
            r102 = r102 + r109;
            goto L12
        L5:
            if (r104 <= 0.0f) goto L8;
            r109 = Math.min(r104 / r103, r211 - r102);
            goto L7
        }
    }

    static {
        Companion = new Companion(null);
    }

    private final boolean isValid() {
        int r100 = this.largeCount;
        if (r100 > 0) goto L5;
    L14:
        if (r100 > 0) goto L16;
    L21:
        return true;
    L16:
        if (this.smallCount <= 0) goto L21;
        if (this.largeSize <= this.smallSize) goto L24;
        return true;
    L24:
        return false;
    L5:
        if (this.smallCount <= 0) goto L14;
        if (this.mediumCount <= 0) goto L14;
        float r101 = this.largeSize;
        float r102 = this.mediumSize;
        if (r101 > r102) goto L11;
        return false;
    L11:
        if (r102 <= this.smallSize) goto L23;
        return true;
    L23:
        return false;
    }

    public final int itemCount() {
        return (this.largeCount + this.mediumCount) + this.smallCount;
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

    private final float cost(float r100) {
        if (isValid() == true) goto L7;
        return Float.MAX_VALUE;
    L7:
        return Math.abs(r100 - this.largeSize) * this.priority;
    }

    public static final /* synthetic */ float access$cost(Arrangement r100, float r101) {
        return r100.cost(r101);
    }

    public Arrangement(int r100, float r101, int r102, float r103, int r104, float r105, int r106) {
        this.priority = r100;
        this.smallSize = r101;
        this.smallCount = r102;
        this.mediumSize = r103;
        this.mediumCount = r104;
        this.largeSize = r105;
        this.largeCount = r106;
    }
}
