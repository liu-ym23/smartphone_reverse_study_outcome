package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.Handle;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.unit.IntSize;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a\u001e\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001H\u0000\u001a\u001e\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\b0\u0007\"\u0004\b\u0000\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\u0007H\u0002\u001a*\u0010\t\u001a\u00020\u00052\u0018\u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000b0\u00072\u0006\u0010\r\u001a\u00020\u000eH\u0001\u001a\u001f\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a'\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001a\u0010\u001b\u001a\f\u0010\u001c\u001a\u00020\u0005*\u00020\u000eH\u0000\u001a\u001b\u0010\u001d\u001a\u00020\u001e*\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u0010H\u0000¢\u0006\u0004\b \u0010!\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"merge", "Landroidx/compose/foundation/text/selection/Selection;", "lhs", "rhs", "invertedInfiniteRect", "Landroidx/compose/ui/geometry/Rect;", "firstAndLast", "", ExifInterface.GPS_DIRECTION_TRUE, "getSelectedRegionRect", "selectableSubSelectionPairs", "Lkotlin/Pair;", "Landroidx/compose/foundation/text/selection/Selectable;", "containerCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "calculateSelectionMagnifierCenterAndroid", "Landroidx/compose/ui/geometry/Offset;", "manager", "Landroidx/compose/foundation/text/selection/SelectionManager;", "magnifierSize", "Landroidx/compose/ui/unit/IntSize;", "calculateSelectionMagnifierCenterAndroid-O0kMr_c", "(Landroidx/compose/foundation/text/selection/SelectionManager;J)J", "getMagnifierCenter", "anchor", "Landroidx/compose/foundation/text/selection/Selection$AnchorInfo;", "getMagnifierCenter-JVtK1S4", "(Landroidx/compose/foundation/text/selection/SelectionManager;JLandroidx/compose/foundation/text/selection/Selection$AnchorInfo;)J", "visibleBounds", "containsInclusive", "", "offset", "containsInclusive-Uv8p0NA", "(Landroidx/compose/ui/geometry/Rect;J)Z", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class SelectionManagerKt {
    private static final Rect invertedInfiniteRect = null;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r100 = new int[Handle.values().length];
            r100[Handle.SelectionStart.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[Handle.SelectionEnd.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[Handle.Cursor.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r100;
        }
    }

    static {
        invertedInfiniteRect = new Rect(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY);
    }

    public static final /* synthetic */ Rect access$getInvertedInfiniteRect$p() {
        return invertedInfiniteRect;
    }

    public static final /* synthetic */ List access$firstAndLast(List r100) {
        return firstAndLast(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <T> List<T> firstAndLast(List<? extends T> r100) {
        int r101 = r100.size();
        if (r101 != 0) goto L5;
        return r100;
    L5:
        if (r101 != 1) goto L7;
        return r100;
    L7:
        return CollectionsKt.listOf(new Object[]{CollectionsKt.first(r100), CollectionsKt.last(r100)});
    }

    public static final Rect visibleBounds(LayoutCoordinates r100) {
        Rect r101 = LayoutCoordinatesKt.boundsInWindow(r100);
        return RectKt.m4620Rect0a9Yr6o(r100.mo6267windowToLocalMKHz9U(r101.m4617getTopLeftF1C5BW0()), r100.mo6267windowToLocalMKHz9U(r101.m4611getBottomRightF1C5BW0()));
    }

    /* JADX INFO: renamed from: calculateSelectionMagnifierCenterAndroid-O0kMr_c, reason: not valid java name */
    public static final long m1485calculateSelectionMagnifierCenterAndroidO0kMr_c(SelectionManager r100, long r101) {
        Selection r102 = r100.getSelection();
        if (r102 == null) goto L5;
        Handle r103 = r100.getDraggingHandle();
        if (r103 != null) goto L9;
        int r104 = -1;
    L10:
        if (r104 == (-1)) goto L25;
        if (r104 == 1) goto L23;
        if (r104 == 2) goto L26;
        if (r104 == 3) goto L20;
        throw new NoWhenBranchMatchedException();
    L20:
        throw new IllegalStateException("SelectionContainer does not support cursor".toString());
    L26:
        return m1487getMagnifierCenterJVtK1S4(r100, r101, r102.getEnd());
    L23:
        return m1487getMagnifierCenterJVtK1S4(r100, r101, r102.getStart());
    L25:
        return Offset.Companion.m4597getUnspecifiedF1C5BW0();
    L9:
        r104 = WhenMappings.$EnumSwitchMapping$0[r103.ordinal()];
        goto L10
    L5:
        return Offset.Companion.m4597getUnspecifiedF1C5BW0();
    }

    /* JADX INFO: renamed from: containsInclusive-Uv8p0NA, reason: not valid java name */
    public static final boolean m1486containsInclusiveUv8p0NA(Rect r100, long r101) {
        float r102 = r100.getLeft();
        float r103 = r100.getRight();
        float r104 = Float.intBitsToFloat((int) (r101 >> 32));
        if (r102 <= r104) goto L5;
    L7:
        boolean r105 = false;
    L8:
        if (r105 == false) goto L17;
        float r106 = r100.getTop();
        float r107 = r100.getBottom();
        float r108 = Float.intBitsToFloat((int) (r101 & BodyPartID.bodyIdMax));
        if (r106 <= r108) goto L12;
    L14:
        boolean r109 = false;
    L15:
        if (r109 == false) goto L17;
        return true;
    L12:
        if (r108 > r107) goto L14;
        r109 = true;
    L17:
        return false;
    L5:
        if (r104 > r103) goto L7;
        r105 = true;
        goto L8
    }

    public static final Rect getSelectedRegionRect(List<? extends Pair<? extends Selectable, Selection>> r110, LayoutCoordinates r111) {
        List<? extends Pair<? extends Selectable, Selection>> r100 = r110;
        if (r110.isEmpty() == true) goto L5;
        Rect r101 = invertedInfiniteRect;
        float r102 = r101.component1();
        float r103 = r101.component2();
        float r104 = r101.component3();
        float r105 = r101.component4();
        int r106 = r100.size();
        char r107 = 0;
        int r108 = 0;
    L7:
        if (r108 >= r106) goto L24;
        Pair r109 = (Pair) ListProtector.get(r100, r108);
        Selectable r112 = (Selectable) r109.component1();
        Selection r113 = (Selection) r109.component2();
        int r114 = r113.getStart().getOffset();
        int r115 = r113.getEnd().getOffset();
        if (r114 == r115) goto L21;
        LayoutCoordinates r116 = r112.getLayoutCoordinates();
        if (r116 == null) goto L21;
        int r117 = Math.min(r114, r115);
        int r118 = Math.max(r114, r115) - 1;
        if (r117 != r118) goto L16;
        int[] r119 = new int[1];
        r119[r107] = r117;
    L17:
        Rect r120 = invertedInfiniteRect;
        float r121 = r120.component1();
        float r122 = r120.component2();
        float r123 = r120.component3();
        float r124 = r120.component4();
        int r125 = r119.length;
        int r126 = 0;
    L18:
        if (r126 >= r125) goto L20;
        int r127 = r106;
        Rect r128 = r112.getBoundingBox(r119[r126]);
        r121 = Math.min(r121, r128.getLeft());
        r122 = Math.min(r122, r128.getTop());
        r123 = Math.max(r123, r128.getRight());
        r124 = Math.max(r124, r128.getBottom());
        r126 = r126 + 1;
        r106 = r127;
        r125 = r125;
        goto L18
    L20:
        int r129 = r106;
        long r130 = Offset.m4574constructorimpl((Float.floatToRawIntBits(r121) << 32) | (((long) Float.floatToRawIntBits(r122)) & BodyPartID.bodyIdMax));
        long r131 = Float.floatToRawIntBits(r123);
        float r132 = r103;
        long r133 = Offset.m4574constructorimpl((((long) Float.floatToRawIntBits(r124)) & BodyPartID.bodyIdMax) | (r131 << 32));
        long r134 = r111.mo6259localPositionOfR5De75A(r116, r130);
        long r135 = r111.mo6259localPositionOfR5De75A(r116, r133);
        r102 = Math.min(r102, Float.intBitsToFloat((int) (r134 >> 32)));
        float r136 = Math.min(r132, Float.intBitsToFloat((int) (r134 & BodyPartID.bodyIdMax)));
        float r137 = Math.max(r104, Float.intBitsToFloat((int) (r135 >> 32)));
        r105 = Math.max(r105, Float.intBitsToFloat((int) (r135 & BodyPartID.bodyIdMax)));
        r104 = r137;
        r103 = r136;
    L22:
        r108 = r108 + 1;
        r100 = r110;
        r106 = r129;
        r107 = 0;
        goto L7
    L16:
        int[] r138 = new int[2];
        r138[r107] = r117;
        r138[1] = r118;
        r119 = r138;
    L21:
        r129 = r106;
        r103 = r103;
        r104 = r104;
        goto L22
    L24:
        return new Rect(r102, r103, r104, r105);
    L5:
        return invertedInfiniteRect;
    }

    public static final Selection merge(Selection r100, Selection r101) {
        if (r100 == null) goto L8;
        Selection r102 = r100.merge(r101);
        if (r102 != null) goto L7;
        return r101;
    L7:
        return r102;
    L8:
        return r101;
    }

    /* JADX INFO: renamed from: getMagnifierCenter-JVtK1S4, reason: not valid java name */
    private static final long m1487getMagnifierCenterJVtK1S4(SelectionManager r110, long r111, Selection.AnchorInfo r112) {
        Selectable r100 = r110.getAnchorSelectable$foundation_release(r112);
        if (r100 == null) goto L5;
        LayoutCoordinates r101 = r110.getContainerLayoutCoordinates();
        if (r101 == null) goto L9;
        LayoutCoordinates r102 = r100.getLayoutCoordinates();
        if (r102 == null) goto L13;
        int r113 = r112.getOffset();
        if (r113 > r100.getLastVisibleOffset()) goto L17;
        Offset r114 = r110.m1476getCurrentDragPosition_m7T9E();
        Intrinsics.checkNotNull(r114);
        float r103 = Float.intBitsToFloat((int) (r102.mo6259localPositionOfR5De75A(r101, r114.m4592unboximpl()) >> 32));
        long r104 = r100.mo1441getRangeOfLineContainingjx7JFs(r113);
        boolean r105 = true;
        if (TextRange.m6992getCollapsedimpl(r104) == false) goto L21;
        float r106 = r100.getLineLeft(r113);
    L23:
        if (r106 != (-1.0f)) goto L25;
        boolean r107 = true;
    L26:
        if (r107 == false) goto L30;
        return Offset.Companion.m4597getUnspecifiedF1C5BW0();
    L30:
        if (IntSize.m7717equalsimpl0(r111, IntSize.Companion.m7724getZeroYbymL2g()) == false) goto L32;
    L35:
        float r115 = r100.getCenterYForOffset(r113);
        if (r115 == (-1.0f)) goto L39;
        r105 = false;
    L39:
        if (r105 == false) goto L43;
        return Offset.Companion.m4597getUnspecifiedF1C5BW0();
    L43:
        return r101.mo6259localPositionOfR5De75A(r102, Offset.m4574constructorimpl((Float.floatToRawIntBits(r106) << 32) | (BodyPartID.bodyIdMax & ((long) Float.floatToRawIntBits(r115)))));
    L32:
        if (Math.abs(r103 - r106) <= (((int) (r111 >> 32)) / 2)) goto L35;
        return Offset.Companion.m4597getUnspecifiedF1C5BW0();
    L25:
        r107 = false;
        goto L26
    L21:
        float r108 = r100.getLineLeft(TextRange.m6998getStartimpl(r104));
        float r109 = r100.getLineRight(TextRange.m6993getEndimpl(r104) - 1);
        r106 = RangesKt.coerceIn(r103, Math.min(r108, r109), Math.max(r108, r109));
        goto L23
    L17:
        return Offset.Companion.m4597getUnspecifiedF1C5BW0();
    L13:
        return Offset.Companion.m4597getUnspecifiedF1C5BW0();
    L9:
        return Offset.Companion.m4597getUnspecifiedF1C5BW0();
    L5:
        return Offset.Companion.m4597getUnspecifiedF1C5BW0();
    }
}
