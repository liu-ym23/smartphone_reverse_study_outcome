package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002Bu\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\u0006\u0010\u0010\u001a\u00020\u0004\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0006\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00000\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\u0012\u0010(\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0004H\u0016J\u0017\u0010<\u001a\u0002092\u0006\u0010\u0003\u001a\u00020\u0004H\u0016¢\u0006\u0004\b=\u0010>J\u001e\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020\u00042\u0006\u0010B\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\u0004J(\u0010?\u001a\u00020@2\u0006\u0010C\u001a\u00020\u00042\u0006\u0010D\u001a\u00020\u00042\u0006\u0010E\u001a\u00020\u00042\u0006\u0010F\u001a\u00020\u0004H\u0016J\u001e\u0010H\u001a\u00020@2\u0006\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020\u000bJ\u000e\u0010N\u001a\u00020@2\u0006\u0010/\u001a\u00020\u0004J\u0016\u0010O\u001a\u00020@2\u0006\u0010P\u001a\u00020\u00042\u0006\u0010Q\u001a\u00020\u000bJ(\u0010U\u001a\u000209*\u0002092\u0012\u0010V\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040WH\u0082\b¢\u0006\u0004\bX\u0010YJ\b\u0010Z\u001a\u00020[H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u001cR\u0014\u0010\r\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0019R\u0014\u0010\u000e\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0019R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001bR\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00000\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\u00020\u0015X\u0096\u0004¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b \u0010!R\u001a\u0010#\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001c\"\u0004\b$\u0010%R\u0014\u0010&\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b'\u0010\u0019R\u0011\u0010)\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0019R\u0014\u0010+\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u0019R\u0011\u0010-\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u0019R\u000e\u0010/\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00102\u001a\u00020\u000bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u001c\"\u0004\b4\u0010%R\u0016\u00105\u001a\u000206X\u0096\u0004¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b7\u0010!R \u0010:\u001a\u0002092\u0006\u00108\u001a\u000209@RX\u0096\u000e¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b;\u0010!R\u0011\u0010C\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\bG\u0010\u0019R\u0018\u0010A\u001a\u00020\u0004*\u0002098BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bR\u0010SR\u0019\u0010)\u001a\u00020\u0004*\u00020\t8Â\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b*\u0010T¨\u0006\\"}, d2 = {"Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasuredItem;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemInfo;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItem;", "index", "", "key", "", "placeables", "", "Landroidx/compose/ui/layout/Placeable;", "isVertical", "", "spacing", "lane", "span", "beforeContentPadding", "afterContentPadding", "contentType", "animator", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "<init>", "(ILjava/lang/Object;Ljava/util/List;ZIIIIILjava/lang/Object;Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getIndex", "()I", "getKey", "()Ljava/lang/Object;", "()Z", "getLane", "getSpan", "getContentType", "getConstraints-msEJaDk", "()J", "J", "isVisible", "setVisible", "(Z)V", "placeablesCount", "getPlaceablesCount", "getParentData", "mainAxisSize", "getMainAxisSize", "mainAxisSizeWithSpacings", "getMainAxisSizeWithSpacings", "crossAxisSize", "getCrossAxisSize", "mainAxisLayoutSize", "minMainAxisOffset", "maxMainAxisOffset", "nonScrollableItem", "getNonScrollableItem", "setNonScrollableItem", "size", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g", "value", "Landroidx/compose/ui/unit/IntOffset;", "offset", "getOffset-nOcc-ac", "getOffset", "getOffset-Bjo55l4", "(I)J", "position", "", "mainAxis", "crossAxis", "mainAxisOffset", "crossAxisOffset", "layoutWidth", "layoutHeight", "getMainAxisOffset", "place", "scope", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureContext;", "isLookingAhead", "updateMainAxisLayoutSize", "applyScrollDelta", "delta", "updateAnimations", "getMainAxis--gyyYBs", "(J)I", "(Landroidx/compose/ui/layout/Placeable;)I", "copy", "mainAxisMap", "Lkotlin/Function1;", "copy-4Tuh3kE", "(JLkotlin/jvm/functions/Function1;)J", "toString", "", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LazyStaggeredGridMeasuredItem implements LazyStaggeredGridItemInfo, LazyLayoutMeasuredItem {
    public static final int $stable = 8;
    private final int afterContentPadding;
    private final LazyLayoutItemAnimator<LazyStaggeredGridMeasuredItem> animator;
    private final int beforeContentPadding;
    private final long constraints;
    private final Object contentType;
    private final int crossAxisSize;
    private final int index;
    private final boolean isVertical;
    private boolean isVisible;
    private final Object key;
    private final int lane;
    private int mainAxisLayoutSize;
    private final int mainAxisSize;
    private final int mainAxisSizeWithSpacings;
    private int maxMainAxisOffset;
    private int minMainAxisOffset;
    private boolean nonScrollableItem;
    private long offset;
    private final List<Placeable> placeables;
    private final long size;
    private final int span;

    public /* synthetic */ LazyStaggeredGridMeasuredItem(int r100, Object r101, List r102, boolean r103, int r104, int r105, int r106, int r107, int r108, Object r110, LazyLayoutItemAnimator r111, long r112, DefaultConstructorMarker r113) {
        this(r100, r101, r102, r103, r104, r105, r106, r107, r108, r110, r111, r112);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public int getPlaceablesCount() {
        return this.placeables.size();
    }

    public final int getMainAxisOffset() {
        if (isVertical() == true) goto L6;
        return IntOffset.m7676getXimpl(mo935getOffsetnOccac());
    L6:
        return IntOffset.m7677getYimpl(mo935getOffsetnOccac());
    }

    public String toString() {
        return super.toString();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    /* JADX INFO: renamed from: getConstraints-msEJaDk */
    public long mo840getConstraintsmsEJaDk() {
        return this.constraints;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo
    public Object getContentType() {
        return this.contentType;
    }

    public final int getCrossAxisSize() {
        return this.crossAxisSize;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo, androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public int getIndex() {
        return this.index;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo, androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public Object getKey() {
        return this.key;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo, androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public int getLane() {
        return this.lane;
    }

    public final int getMainAxisSize() {
        return this.mainAxisSize;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public int getMainAxisSizeWithSpacings() {
        return this.mainAxisSizeWithSpacings;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public boolean getNonScrollableItem() {
        return this.nonScrollableItem;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo
    /* JADX INFO: renamed from: getOffset-nOcc-ac */
    public long mo935getOffsetnOccac() {
        return this.offset;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemInfo
    /* JADX INFO: renamed from: getSize-YbymL2g */
    public long mo936getSizeYbymL2g() {
        return this.size;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public int getSpan() {
        return this.span;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public boolean isVertical() {
        return this.isVertical;
    }

    public final boolean isVisible() {
        return this.isVisible;
    }

    /* JADX INFO: renamed from: getMainAxis--gyyYBs, reason: not valid java name */
    private final int m952getMainAxisgyyYBs(long r100) {
        if (isVertical() == false) goto L6;
        return IntOffset.m7677getYimpl(r100);
    L6:
        return IntOffset.m7676getXimpl(r100);
    }

    private final int getMainAxisSize(Placeable r100) {
        if (isVertical() == false) goto L6;
        return r100.getHeight();
    L6:
        return r100.getWidth();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    /* JADX INFO: renamed from: getOffset-Bjo55l4 */
    public long mo841getOffsetBjo55l4(int r100) {
        return mo935getOffsetnOccac();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public Object getParentData(int r100) {
        return ((Placeable) ListProtector.get(this.placeables, r100)).getParentData();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public void setNonScrollableItem(boolean r100) {
        this.nonScrollableItem = r100;
    }

    public final void setVisible(boolean r100) {
        this.isVisible = r100;
    }

    public final void updateMainAxisLayoutSize(int r100) {
        this.mainAxisLayoutSize = r100;
        this.maxMainAxisOffset = r100 + this.afterContentPadding;
    }

    /* JADX INFO: renamed from: copy-4Tuh3kE, reason: not valid java name */
    private final long m951copy4Tuh3kE(long r100, Function1<? super Integer, Integer> r101) {
        if (isVertical() == false) goto L5;
        int r102 = IntOffset.m7676getXimpl(r100);
    L6:
        boolean r103 = isVertical();
        int r104 = IntOffset.m7677getYimpl(r100);
        if (r103 == false) goto L10;
        r104 = r101.invoke(Integer.valueOf(r104)).intValue();
    L10:
        return IntOffset.m7670constructorimpl((((long) r102) << 32) | (((long) r104) & BodyPartID.bodyIdMax));
    L5:
        r102 = r101.invoke(Integer.valueOf(IntOffset.m7676getXimpl(r100))).intValue();
        goto L6
    }

    public final void applyScrollDelta(int r110, boolean r111) {
        if (getNonScrollableItem() == false) goto L5;
        return;
    L5:
        long r100 = mo935getOffsetnOccac();
        if (isVertical() == false) goto L8;
        int r101 = IntOffset.m7676getXimpl(r100);
    L9:
        boolean r102 = isVertical();
        int r103 = IntOffset.m7677getYimpl(r100);
        if (r102 == false) goto L12;
        r103 = r103 + r110;
    L12:
        this.offset = IntOffset.m7670constructorimpl((((long) r101) << 32) | (((long) r103) & BodyPartID.bodyIdMax));
        if (r111 == false) goto L27;
        int r112 = getPlaceablesCount();
        int r104 = 0;
    L15:
        if (r104 >= r112) goto L31;
        LazyLayoutItemAnimation r105 = this.animator.getAnimation(getKey(), r104);
        if (r105 == null) goto L26;
        long r106 = r105.m888getRawOffsetnOccac();
        if (isVertical() == false) goto L21;
        int r107 = IntOffset.m7676getXimpl(r106);
    L22:
        boolean r108 = isVertical();
        int r109 = IntOffset.m7677getYimpl(r106);
        if (r108 == false) goto L25;
        r109 = Integer.valueOf(r109 + r110).intValue();
    L25:
        long r113 = ((long) r109) & BodyPartID.bodyIdMax;
        r105.m891setRawOffsetgyyYBs(IntOffset.m7670constructorimpl(r113 | (((long) r107) << 32)));
        goto L26
    L21:
        r107 = Integer.valueOf(IntOffset.m7676getXimpl(r106) + r110).intValue();
    L26:
        r104 = r104 + 1;
        goto L15
    L31:
        return;
    L27:
        return;
    L8:
        r101 = IntOffset.m7676getXimpl(r100) + r110;
        goto L9
    }

    public final void place(Placeable.PlacementScope r110, LazyStaggeredGridMeasureContext r111, boolean r112) {
        int r100 = 0;
        if (this.mainAxisLayoutSize == Integer.MIN_VALUE) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L8;
        InlineClassHelperKt.throwIllegalArgumentException("position() should be called first");
    L8:
        List<Placeable> r102 = this.placeables;
        int r103 = r102.size();
    L9:
        if (r100 >= r103) goto L61;
        Placeable r104 = (Placeable) ListProtector.get(r102, r100);
        int r105 = this.minMainAxisOffset;
        if (isVertical() == false) goto L13;
        int r106 = r104.getHeight();
    L14:
        int r107 = r105 - r106;
        int r108 = this.maxMainAxisOffset;
        long r109 = mo935getOffsetnOccac();
        LazyLayoutItemAnimation r113 = this.animator.getAnimation(getKey(), r100);
        if (r113 == null) goto L33;
        if (r112 == false) goto L19;
        r113.m890setLookaheadOffsetgyyYBs(r109);
    L32:
        GraphicsLayer r114 = r113.getLayer();
    L35:
        if (r111.getReverseLayout() == true) goto L37;
    L53:
        long r115 = IntOffset.m7680plusqkQi6aY(r109, r111.m940getContentOffsetnOccac());
        if (r112 == true) goto L57;
        if (r113 == null) goto L57;
        r113.m889setFinalOffsetgyyYBs(r115);
    L57:
        if (r114 == null) goto L59;
        Placeable.PlacementScope.m6330placeRelativeWithLayeraW9wM$default(r110, r104, r115, r114, 0.0f, 4, null);
    L60:
        r100 = r100 + 1;
        goto L9
    L59:
        Placeable.PlacementScope.m6329placeRelativeWithLayeraW9wM$default(r110, r104, r115, 0.0f, null, 6, null);
        goto L60
    L37:
        if (isVertical() == false) goto L39;
        int r116 = IntOffset.m7676getXimpl(r109);
    L45:
        if (isVertical() == false) goto L51;
        int r117 = IntOffset.m7677getYimpl(r109);
        int r118 = this.mainAxisLayoutSize - r117;
        if (isVertical() == false) goto L49;
        int r119 = r104.getHeight();
    L50:
        int r120 = r118 - r119;
    L52:
        long r121 = ((long) r120) & BodyPartID.bodyIdMax;
        r109 = IntOffset.m7670constructorimpl(r121 | (((long) r116) << 32));
        goto L53
    L49:
        r119 = r104.getWidth();
        goto L50
    L51:
        r120 = IntOffset.m7677getYimpl(r109);
        goto L52
    L39:
        int r122 = IntOffset.m7676getXimpl(r109);
        int r123 = this.mainAxisLayoutSize - r122;
        if (isVertical() == false) goto L42;
        int r124 = r104.getHeight();
    L43:
        r116 = r123 - r124;
        goto L45
    L42:
        r124 = r104.getWidth();
        goto L43
    L19:
        if (IntOffset.m7675equalsimpl0(r113.m886getLookaheadOffsetnOccac(), LazyLayoutItemAnimation.Companion.m892getNotInitializednOccac()) == true) goto L21;
        long r125 = r113.m886getLookaheadOffsetnOccac();
    L22:
        long r126 = IntOffset.m7680plusqkQi6aY(r125, r113.m887getPlacementDeltanOccac());
        if (m952getMainAxisgyyYBs(r109) > r107) goto L27;
        if (m952getMainAxisgyyYBs(r126) > r107) goto L27;
    L30:
        r113.cancelPlacementAnimation();
    L31:
        r109 = r126;
    L27:
        if (m952getMainAxisgyyYBs(r109) < r108) goto L31;
        if (m952getMainAxisgyyYBs(r126) < r108) goto L31;
    L21:
        r125 = r109;
        goto L22
    L33:
        r114 = null;
        goto L35
    L13:
        r106 = r104.getWidth();
        goto L14
    L61:
        return;
    L5:
        r101 = false;
        goto L6
    }

    public final void position(int r100, int r101, int r102) {
        this.mainAxisLayoutSize = r102;
        this.minMainAxisOffset = -this.beforeContentPadding;
        this.maxMainAxisOffset = r102 + this.afterContentPadding;
        if (isVertical() == false) goto L5;
        long r103 = IntOffset.m7670constructorimpl((((long) r101) << 32) | (BodyPartID.bodyIdMax & ((long) r100)));
    L6:
        this.offset = r103;
        return;
    L5:
        long r104 = ((long) r100) << 32;
        r103 = IntOffset.m7670constructorimpl((((long) r101) & BodyPartID.bodyIdMax) | r104);
        goto L6
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItem
    public void position(int r100, int r101, int r102, int r103) {
        if (isVertical() == false) goto L5;
        r102 = r103;
    L5:
        position(r100, r101, r102);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private LazyStaggeredGridMeasuredItem(int r100, Object r101, List<? extends Placeable> r102, boolean r103, int r104, int r105, int r106, int r107, int r108, Object r110, LazyLayoutItemAnimator<LazyStaggeredGridMeasuredItem> r111, long r112) {
        this.index = r100;
        this.key = r101;
        this.placeables = r102;
        this.isVertical = r103;
        this.lane = r105;
        this.span = r106;
        this.beforeContentPadding = r107;
        this.afterContentPadding = r108;
        this.contentType = r110;
        this.animator = r111;
        this.constraints = r112;
        int r109 = 1;
        this.isVisible = true;
        int r113 = 0;
        if (r102.isEmpty() == false) goto L5;
        int r114 = 0;
    L20:
        this.mainAxisSize = r114;
        this.mainAxisSizeWithSpacings = RangesKt.coerceAtLeast(r114 + r104, 0);
        List<Placeable> r115 = this.placeables;
        if (r115.isEmpty() == true) goto L38;
        Placeable r116 = (Placeable) ListProtector.get(r115, 0);
        if (isVertical() == false) goto L26;
        int r117 = r116.getWidth();
    L27:
        int r118 = CollectionsKt.getLastIndex(r115);
        if (1 > r118) goto L37;
    L29:
        Placeable r119 = (Placeable) ListProtector.get(r115, r109);
        if (isVertical() == false) goto L32;
        int r120 = r119.getWidth();
    L33:
        if (r120 <= r117) goto L35;
        r117 = r120;
    L35:
        if (r109 == r118) goto L37;
        r109 = r109 + 1;
        goto L29
    L32:
        r120 = r119.getHeight();
    L37:
        r113 = r117;
        goto L38
    L26:
        r117 = r116.getHeight();
    L38:
        this.crossAxisSize = r113;
        this.mainAxisLayoutSize = Integer.MIN_VALUE;
        if (isVertical() == false) goto L41;
        long r121 = ((long) r113) << 32;
        long r122 = IntSize.m7714constructorimpl((((long) this.mainAxisSize) & BodyPartID.bodyIdMax) | r121);
    L42:
        this.size = r122;
        this.offset = IntOffset.Companion.m7687getZeronOccac();
        return;
    L41:
        long r123 = ((long) this.mainAxisSize) << 32;
        r122 = IntSize.m7714constructorimpl((((long) r113) & BodyPartID.bodyIdMax) | r123);
        goto L42
    L5:
        Placeable r124 = (Placeable) ListProtector.get(r102, 0);
        if (isVertical() == false) goto L8;
        r114 = r124.getHeight();
    L9:
        int r125 = CollectionsKt.getLastIndex(r102);
        if (1 > r125) goto L20;
        int r126 = 1;
    L12:
        Placeable r127 = (Placeable) ListProtector.get(r102, r126);
        if (isVertical() == false) goto L15;
        int r128 = r127.getHeight();
    L16:
        if (r128 <= r114) goto L18;
        r114 = r128;
    L18:
        if (r126 == r125) goto L20;
        r126 = r126 + 1;
        goto L12
    L15:
        r128 = r127.getWidth();
        goto L16
    L8:
        r114 = r124.getWidth();
        goto L9
    }
}
