package androidx.compose.material3.carousel;

import androidx.collection.FloatList;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\b\u0001\u0018\u0000 -2\u00020\u0001:\u0001-BM\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\f\u0010\rB1\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\f\u0010\u000eJ'\u0010$\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\b2\u0006\u0010&\u001a\u00020\b2\b\b\u0002\u0010'\u001a\u00020!H\u0000¢\u0006\u0002\b(J\u0013\u0010)\u001a\u00020!2\b\u0010*\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010+\u001a\u00020,H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\n\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0011\u0010\u000b\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u000e\u0010\u0019\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u001e\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0015R\u0011\u0010 \u001a\u00020!¢\u0006\b\n\u0000\u001a\u0004\b \u0010\"R\u0016\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Landroidx/compose/material3/carousel/Strategy;", "", "defaultKeylines", "Landroidx/compose/material3/carousel/KeylineList;", "startKeylineSteps", "", "endKeylineSteps", "availableSpace", "", "itemSpacing", "beforeContentPadding", "afterContentPadding", "<init>", "(Landroidx/compose/material3/carousel/KeylineList;Ljava/util/List;Ljava/util/List;FFFF)V", "(Landroidx/compose/material3/carousel/KeylineList;FFFF)V", "getDefaultKeylines", "()Landroidx/compose/material3/carousel/KeylineList;", "getStartKeylineSteps", "()Ljava/util/List;", "getEndKeylineSteps", "getAvailableSpace", "()F", "getItemSpacing", "getBeforeContentPadding", "getAfterContentPadding", "startShiftDistance", "endShiftDistance", "startShiftPoints", "Landroidx/collection/FloatList;", "endShiftPoints", "itemMainAxisSize", "getItemMainAxisSize", "isValid", "", "()Z", "lastStartAndEndKeylineListSteps", "getKeylineListForScrollOffset", "scrollOffset", "maxScrollOffset", "roundToNearestStep", "getKeylineListForScrollOffset$material3", "equals", "other", "hashCode", "", "Companion", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Strategy {
    public static final int $stable = 0;
    public static final Companion Companion = null;
    private static final Strategy Empty = null;
    private final float afterContentPadding;
    private final float availableSpace;
    private final float beforeContentPadding;
    private final KeylineList defaultKeylines;
    private final List<KeylineList> endKeylineSteps;
    private final float endShiftDistance;
    private final FloatList endShiftPoints;
    private final boolean isValid;
    private final float itemSpacing;
    private List<KeylineList> lastStartAndEndKeylineListSteps;
    private final List<KeylineList> startKeylineSteps;
    private final float startShiftDistance;
    private final FloatList startShiftPoints;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/material3/carousel/Strategy$Companion;", "", "<init>", "()V", "Empty", "Landroidx/compose/material3/carousel/Strategy;", "getEmpty", "()Landroidx/compose/material3/carousel/Strategy;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final Strategy getEmpty() {
            return Strategy.access$getEmpty$cp();
        }
    }

    static {
        Companion = new Companion(null);
        $stable = 8;
        Empty = new Strategy(KeylineListKt.emptyKeylineList(), CollectionsKt.emptyList(), CollectionsKt.emptyList(), 0.0f, 0.0f, 0.0f, 0.0f);
    }

    public final float getItemMainAxisSize() {
        return this.defaultKeylines.getFirstFocal().getSize();
    }

    public int hashCode() {
        boolean r100 = this.isValid;
        int r101 = 1231;
        if (r100 == true) goto L8;
        if (r100 == true) goto L13;
        return 1237;
    L13:
        return 1231;
    L8:
        if (r100 == true) goto L12;
        r101 = 1237;
    L12:
        return (((((((((((((((((((r101 * 31) + Float.floatToIntBits(this.availableSpace)) * 31) + Float.floatToIntBits(this.itemSpacing)) * 31) + Float.floatToIntBits(this.beforeContentPadding)) * 31) + Float.floatToIntBits(this.afterContentPadding)) * 31) + Float.floatToIntBits(getItemMainAxisSize())) * 31) + Float.floatToIntBits(this.startShiftDistance)) * 31) + Float.floatToIntBits(this.endShiftDistance)) * 31) + this.startShiftPoints.hashCode()) * 31) + this.endShiftPoints.hashCode()) * 31) + this.defaultKeylines.hashCode();
    }

    public static final /* synthetic */ Strategy access$getEmpty$cp() {
        return Empty;
    }

    public final float getAfterContentPadding() {
        return this.afterContentPadding;
    }

    public final float getAvailableSpace() {
        return this.availableSpace;
    }

    public final float getBeforeContentPadding() {
        return this.beforeContentPadding;
    }

    public final KeylineList getDefaultKeylines() {
        return this.defaultKeylines;
    }

    public final List<KeylineList> getEndKeylineSteps() {
        return this.endKeylineSteps;
    }

    public final float getItemSpacing() {
        return this.itemSpacing;
    }

    public final List<KeylineList> getStartKeylineSteps() {
        return this.startKeylineSteps;
    }

    public final boolean isValid() {
        return this.isValid;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof Strategy) == true) goto L8;
        return false;
    L8:
        boolean r101 = this.isValid;
        if (r101 == false) goto L11;
    L13:
        Strategy r102 = (Strategy) r100;
        if (r101 == r102.isValid) goto L17;
        return false;
    L17:
        if (this.availableSpace != r102.availableSpace) goto L19;
        boolean r103 = true;
    L20:
        if (r103 == true) goto L23;
        return false;
    L23:
        if (this.itemSpacing != r102.itemSpacing) goto L25;
        boolean r104 = true;
    L26:
        if (r104 == true) goto L29;
        return false;
    L29:
        if (this.beforeContentPadding != r102.beforeContentPadding) goto L31;
        boolean r105 = true;
    L32:
        if (r105 == true) goto L35;
        return false;
    L35:
        if (this.afterContentPadding != r102.afterContentPadding) goto L37;
        boolean r106 = true;
    L38:
        if (r106 == true) goto L41;
        return false;
    L41:
        if (getItemMainAxisSize() != r102.getItemMainAxisSize()) goto L43;
        boolean r107 = true;
    L44:
        if (r107 == true) goto L47;
        return false;
    L47:
        if (this.startShiftDistance != r102.startShiftDistance) goto L49;
        boolean r108 = true;
    L50:
        if (r108 == true) goto L53;
        return false;
    L53:
        if (this.endShiftDistance != r102.endShiftDistance) goto L55;
        boolean r109 = true;
    L56:
        if (r109 == true) goto L59;
        return false;
    L59:
        if (Intrinsics.areEqual(this.startShiftPoints, r102.startShiftPoints) == true) goto L62;
        return false;
    L62:
        if (Intrinsics.areEqual(this.endShiftPoints, r102.endShiftPoints) == true) goto L65;
        return false;
    L65:
        if (Intrinsics.areEqual(this.defaultKeylines, r102.defaultKeylines) == true) goto L67;
        return false;
    L67:
        return true;
    L55:
        r109 = false;
        goto L56
    L49:
        r108 = false;
        goto L50
    L43:
        r107 = false;
        goto L44
    L37:
        r106 = false;
        goto L38
    L31:
        r105 = false;
        goto L32
    L25:
        r104 = false;
        goto L26
    L19:
        r103 = false;
        goto L20
    L11:
        if (((Strategy) r100).isValid == true) goto L13;
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final KeylineList getKeylineListForScrollOffset$material3(float r110, float r111, boolean r112) {
        float r113 = Math.max(0.0f, r110);
        float r100 = this.startShiftDistance;
        float r101 = Math.max(0.0f, r111 - this.endShiftDistance);
        if (r100 <= r113) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == true) goto L10;
        float r103 = StrategyKt.access$lerp(1.0f, 0.0f, 0.0f, r100, r113);
        FloatList r104 = this.startShiftPoints;
        List<KeylineList> r105 = this.startKeylineSteps;
        if (r113 <= r101) goto L23;
        r103 = StrategyKt.access$lerp(0.0f, 1.0f, r101, r111, r113);
        r104 = this.endShiftPoints;
        r105 = this.endKeylineSteps;
        if (r101 >= 0.01f) goto L23;
        if (this.startKeylineSteps.size() != 2) goto L23;
        if (this.endKeylineSteps.size() != 2) goto L23;
        if (this.lastStartAndEndKeylineListSteps != null) goto L22;
        this.lastStartAndEndKeylineListSteps = CollectionsKt.listOf(new KeylineList[]{CollectionsKt.last(this.startKeylineSteps), CollectionsKt.last(this.endKeylineSteps)});
    L22:
        r105 = this.lastStartAndEndKeylineListSteps;
        Intrinsics.checkNotNull(r105);
    L23:
        ShiftPointRange r114 = StrategyKt.access$getShiftPointRange(r105.size(), r104, r103);
        if (r112 == false) goto L32;
        if (MathKt.roundToInt(r114.getSteppedInterpolation()) != 0) goto L28;
        int r115 = r114.getFromStepIndex();
    L30:
        return (KeylineList) ListProtector.get(r105, r115);
    L28:
        r115 = r114.getToStepIndex();
        goto L30
    L32:
        return KeylineListKt.lerp((KeylineList) ListProtector.get(r105, r114.getFromStepIndex()), (KeylineList) ListProtector.get(r105, r114.getToStepIndex()), r114.getSteppedInterpolation());
    L10:
        return this.defaultKeylines;
    L5:
        if (r113 > r101) goto L7;
        r102 = true;
        goto L8
    }

    public Strategy(KeylineList r100, float r110, float r111, float r112, float r113) {
        this(r100, StrategyKt.access$getStartKeylineSteps(r100, r110, r111, r112), StrategyKt.access$getEndKeylineSteps(r100, r110, r111, r113), r110, r111, r112, r113);
    }

    public static /* synthetic */ KeylineList getKeylineListForScrollOffset$material3$default(Strategy r100, float r101, float r102, boolean r103, int r104, Object r105) {
        if ((r104 & 4) == 0) goto L6;
        r103 = false;
    L6:
        return r100.getKeylineListForScrollOffset$material3(r101, r102, r103);
    }

    private Strategy(KeylineList r100, List<KeylineList> r101, List<KeylineList> r102, float r103, float r104, float r105, float r106) {
        this.defaultKeylines = r100;
        this.startKeylineSteps = r101;
        this.endKeylineSteps = r102;
        this.availableSpace = r103;
        this.itemSpacing = r104;
        this.beforeContentPadding = r105;
        this.afterContentPadding = r106;
        float r107 = StrategyKt.access$getStartShiftDistance(r101, r105);
        this.startShiftDistance = r107;
        float r108 = StrategyKt.access$getEndShiftDistance(r102, r106);
        this.endShiftDistance = r108;
        boolean r109 = true;
        this.startShiftPoints = StrategyKt.access$getStepInterpolationPoints(r107, r101, true);
        this.endShiftPoints = StrategyKt.access$getStepInterpolationPoints(r108, r102, false);
        if ((!r100.isEmpty()) == true) goto L5;
    L15:
        r109 = false;
    L16:
        this.isValid = r109;
        return;
    L5:
        if (r103 != 0.0f) goto L7;
        boolean r110 = true;
    L8:
        if (r110 == true) goto L15;
        if (getItemMainAxisSize() != 0.0f) goto L12;
        boolean r111 = true;
    L13:
        if (r111 == true) goto L15;
    L12:
        r111 = false;
        goto L13
    L7:
        r110 = false;
        goto L8
    }
}
