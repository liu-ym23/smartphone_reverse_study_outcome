package androidx.compose.foundation.layout;

import C7.r;
import D7.v;
import H4.o;
import S7.k;
import Y7.e;
import Y7.f;
import androidx.collection.IntIntPair;
import androidx.collection.IntObjectMapKt;
import androidx.collection.MutableIntList;
import androidx.collection.MutableIntObjectMap;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.CrossAxisAlignment;
import androidx.compose.foundation.layout.FlowLayoutBuildingBlocks;
import androidx.compose.foundation.layout.FlowLayoutOverflow;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.MultiContentMeasurePolicy;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import g1.AbstractC1451a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$ObjectRef;

@Metadata(d1 = {"\u0000Î\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u001ad\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\t2\u0017\u0010\u000f\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\u0007¢\u0006\u0004\b\u0010\u0010\u0011\u001ad\u0010\u0015\u001a\u00020\r2\b\b\u0002\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00132\u0017\u0010\u000f\u001a\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\u0007¢\u0006\u0004\b\u0015\u0010\u0016\u001a'\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0006H\u0001¢\u0006\u0004\b\u0019\u0010\u001a\u001a7\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001bH\u0001¢\u0006\u0004\b\u001e\u0010\u001f\u001a'\u0010 \u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0006H\u0001¢\u0006\u0004\b \u0010!\u001a7\u0010\"\u001a\u00020\u001d2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001bH\u0001¢\u0006\u0004\b\"\u0010#\u001aU\u0010+\u001a\u00020\u00062\f\u0010&\u001a\b\u0012\u0004\u0012\u00020%0$2\u001e\u0010(\u001a\u001a\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060'2\u0006\u0010)\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0002¢\u0006\u0004\b+\u0010,\u001a\u008d\u0001\u0010/\u001a\u00020\u00062\f\u0010&\u001a\b\u0012\u0004\u0012\u00020%0$2\u001e\u0010(\u001a\u001a\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060'2\u001e\u0010-\u001a\u001a\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060'2\u0006\u0010)\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u001bH\u0002¢\u0006\u0004\b/\u00100\u001a]\u00106\u001a\u0002052\f\u0010&\u001a\b\u0012\u0004\u0012\u00020%0$2\u0006\u00102\u001a\u0002012\u0006\u00103\u001a\u0002012\u0006\u00104\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u001bH\u0002¢\u0006\u0004\b6\u00107\u001a\u008d\u0001\u00106\u001a\u0002052\f\u0010&\u001a\b\u0012\u0004\u0012\u00020%0$2\u001e\u0010(\u001a\u001a\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060'2\u001e\u0010-\u001a\u001a\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060'2\u0006\u00104\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u001bH\u0002¢\u0006\u0004\b6\u00108\u001a\\\u0010G\u001a\u00020D*\u0002092\u0006\u0010;\u001a\u00020:2\f\u0010>\u001a\b\u0012\u0004\u0012\u00020=0<2\u0006\u0010@\u001a\u00020?2\u0006\u0010A\u001a\u00020?2\u0006\u0010C\u001a\u00020B2\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u001bH\u0000ø\u0001\u0000¢\u0006\u0004\bE\u0010F\u001a%\u0010J\u001a\u0004\u0018\u00010=*\b\u0012\u0004\u0012\u00020=0<2\b\u0010I\u001a\u0004\u0018\u00010HH\u0002¢\u0006\u0004\bJ\u0010K\u001a#\u0010N\u001a\u00020\u0006*\u00020%2\u0006\u0010M\u001a\u00020L2\u0006\u0010-\u001a\u00020\u0006H\u0000¢\u0006\u0004\bN\u0010O\u001a#\u0010P\u001a\u00020\u0006*\u00020%2\u0006\u0010M\u001a\u00020L2\u0006\u0010(\u001a\u00020\u0006H\u0000¢\u0006\u0004\bP\u0010O\u001a<\u0010V\u001a\u000205*\u00020=2\u0006\u0010;\u001a\u00020:2\u0006\u0010C\u001a\u00020Q2\u0014\u0010S\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010R\u0012\u0004\u0012\u00020\r0\u000bH\u0000ø\u0001\u0000¢\u0006\u0004\bT\u0010U\u001aT\u0010_\u001a\u00020D*\u0002092\u0006\u0010C\u001a\u00020B2\u0006\u0010W\u001a\u00020\u00062\u0006\u0010X\u001a\u00020\u00062\u0006\u00103\u001a\u0002012\f\u0010Z\u001a\b\u0012\u0004\u0012\u00020D0Y2\u0006\u0010[\u001a\u00020:2\u0006\u0010\\\u001a\u000201H\u0000ø\u0001\u0000¢\u0006\u0004\b]\u0010^\"\u001a\u0010a\u001a\u00020`8\u0000X\u0080\u0004¢\u0006\f\n\u0004\ba\u0010b\u001a\u0004\bc\u0010d\"\u001a\u0010e\u001a\u00020`8\u0000X\u0080\u0004¢\u0006\f\n\u0004\be\u0010b\u001a\u0004\bf\u0010d\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006g"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "verticalArrangement", "", "maxItemsInEachRow", "maxLines", "Landroidx/compose/foundation/layout/FlowRowOverflow;", "overflow", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/FlowRowScope;", "LC7/r;", "Landroidx/compose/runtime/Composable;", "content", "FlowRow", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;IILandroidx/compose/foundation/layout/FlowRowOverflow;LS7/o;Landroidx/compose/runtime/Composer;II)V", "maxItemsInEachColumn", "Landroidx/compose/foundation/layout/FlowColumnOverflow;", "Landroidx/compose/foundation/layout/FlowColumnScope;", "FlowColumn", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;IILandroidx/compose/foundation/layout/FlowColumnOverflow;LS7/o;Landroidx/compose/runtime/Composer;II)V", "maxItemsInMainAxis", "Landroidx/compose/ui/layout/MeasurePolicy;", "rowMeasurementHelper", "(Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;ILandroidx/compose/runtime/Composer;I)Landroidx/compose/ui/layout/MeasurePolicy;", "Landroidx/compose/foundation/layout/FlowLayoutOverflowState;", "overflowState", "Landroidx/compose/ui/layout/MultiContentMeasurePolicy;", "rowMeasurementMultiContentHelper", "(Landroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/foundation/layout/Arrangement$Vertical;IILandroidx/compose/foundation/layout/FlowLayoutOverflowState;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/layout/MultiContentMeasurePolicy;", "columnMeasurementHelper", "(Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;ILandroidx/compose/runtime/Composer;I)Landroidx/compose/ui/layout/MeasurePolicy;", "columnMeasurementMultiContentHelper", "(Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;IILandroidx/compose/foundation/layout/FlowLayoutOverflowState;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/layout/MultiContentMeasurePolicy;", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "children", "Lkotlin/Function3;", "mainAxisSize", "crossAxisAvailable", "mainAxisSpacing", "maxIntrinsicMainAxisSize", "(Ljava/util/List;LS7/o;III)I", "crossAxisSize", "crossAxisSpacing", "minIntrinsicMainAxisSize", "(Ljava/util/List;LS7/o;LS7/o;IIIIILandroidx/compose/foundation/layout/FlowLayoutOverflowState;)I", "", "mainAxisSizes", "crossAxisSizes", "mainAxisAvailable", "Landroidx/collection/IntIntPair;", "intrinsicCrossAxisSize", "(Ljava/util/List;[I[IIIIIILandroidx/compose/foundation/layout/FlowLayoutOverflowState;)J", "(Ljava/util/List;LS7/o;LS7/o;IIIIILandroidx/compose/foundation/layout/FlowLayoutOverflowState;)J", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/foundation/layout/FlowLineMeasurePolicy;", "measurePolicy", "", "Landroidx/compose/ui/layout/Measurable;", "measurablesIterator", "Landroidx/compose/ui/unit/Dp;", "mainAxisSpacingDp", "crossAxisSpacingDp", "Landroidx/compose/foundation/layout/OrientationIndependentConstraints;", "constraints", "Landroidx/compose/ui/layout/MeasureResult;", "breakDownItems-di9J0FM", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/foundation/layout/FlowLineMeasurePolicy;Ljava/util/Iterator;FFJIILandroidx/compose/foundation/layout/FlowLayoutOverflowState;)Landroidx/compose/ui/layout/MeasureResult;", "breakDownItems", "Landroidx/compose/foundation/layout/FlowLineInfo;", "info", "safeNext", "(Ljava/util/Iterator;Landroidx/compose/foundation/layout/FlowLineInfo;)Landroidx/compose/ui/layout/Measurable;", "", "isHorizontal", "mainAxisMin", "(Landroidx/compose/ui/layout/IntrinsicMeasurable;ZI)I", "crossAxisMin", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/layout/Placeable;", "storePlaceable", "measureAndCache-rqJ1uqs", "(Landroidx/compose/ui/layout/Measurable;Landroidx/compose/foundation/layout/FlowLineMeasurePolicy;JLS7/k;)J", "measureAndCache", "mainAxisTotalSize", "crossAxisTotalSize", "Landroidx/compose/runtime/collection/MutableVector;", "items", "measureHelper", "outPosition", "placeHelper-BmaY500", "(Landroidx/compose/ui/layout/MeasureScope;JII[ILandroidx/compose/runtime/collection/MutableVector;Landroidx/compose/foundation/layout/FlowLineMeasurePolicy;[I)Landroidx/compose/ui/layout/MeasureResult;", "placeHelper", "Landroidx/compose/foundation/layout/CrossAxisAlignment;", "CROSS_AXIS_ALIGNMENT_TOP", "Landroidx/compose/foundation/layout/CrossAxisAlignment;", "getCROSS_AXIS_ALIGNMENT_TOP", "()Landroidx/compose/foundation/layout/CrossAxisAlignment;", "CROSS_AXIS_ALIGNMENT_START", "getCROSS_AXIS_ALIGNMENT_START", "foundation-layout_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class FlowLayoutKt {
    private static final CrossAxisAlignment CROSS_AXIS_ALIGNMENT_START;
    private static final CrossAxisAlignment CROSS_AXIS_ALIGNMENT_TOP;

    static {
        CrossAxisAlignment.Companion companion = CrossAxisAlignment.INSTANCE;
        Alignment.Companion companion2 = Alignment.INSTANCE;
        CROSS_AXIS_ALIGNMENT_TOP = companion.vertical$foundation_layout_release(companion2.getTop());
        CROSS_AXIS_ALIGNMENT_START = companion.horizontal$foundation_layout_release(companion2.getStart());
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:153:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0114  */
    @androidx.compose.runtime.Composable
    @androidx.compose.foundation.layout.ExperimentalLayoutApi
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void FlowColumn(androidx.compose.ui.Modifier r18, androidx.compose.foundation.layout.Arrangement.Vertical r19, androidx.compose.foundation.layout.Arrangement.Horizontal r20, int r21, int r22, androidx.compose.foundation.layout.FlowColumnOverflow r23, final S7.o r24, androidx.compose.runtime.Composer r25, final int r26, final int r27) {
        /*
            Method dump skipped, instructions count: 568
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.layout.FlowLayoutKt.FlowColumn(androidx.compose.ui.Modifier, androidx.compose.foundation.layout.Arrangement$Vertical, androidx.compose.foundation.layout.Arrangement$Horizontal, int, int, androidx.compose.foundation.layout.FlowColumnOverflow, S7.o, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:153:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0114  */
    @androidx.compose.runtime.Composable
    @androidx.compose.foundation.layout.ExperimentalLayoutApi
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void FlowRow(androidx.compose.ui.Modifier r18, androidx.compose.foundation.layout.Arrangement.Horizontal r19, androidx.compose.foundation.layout.Arrangement.Vertical r20, int r21, int r22, androidx.compose.foundation.layout.FlowRowOverflow r23, final S7.o r24, androidx.compose.runtime.Composer r25, final int r26, final int r27) {
        /*
            Method dump skipped, instructions count: 568
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.layout.FlowLayoutKt.FlowRow(androidx.compose.ui.Modifier, androidx.compose.foundation.layout.Arrangement$Horizontal, androidx.compose.foundation.layout.Arrangement$Vertical, int, int, androidx.compose.foundation.layout.FlowRowOverflow, S7.o, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: breakDownItems-di9J0FM, reason: not valid java name */
    public static final MeasureResult m625breakDownItemsdi9J0FM(MeasureScope measureScope, FlowLineMeasurePolicy flowLineMeasurePolicy, Iterator<? extends Measurable> it, float f, float f7, long j5, int i, int i6, FlowLayoutOverflowState flowLayoutOverflowState) {
        int i10;
        FlowLayoutBuildingBlocks.WrapEllipsisInfo wrapEllipsisInfo;
        MutableIntObjectMap mutableIntObjectMap;
        int i11;
        int i12;
        MeasureScope measureScope2;
        FlowLineMeasurePolicy flowLineMeasurePolicy2;
        int[] iArr;
        int[] iArr2;
        long j6;
        int height;
        int width;
        int i13;
        MutableIntObjectMap mutableIntObjectMap2;
        int i14;
        MutableIntList mutableIntList;
        MutableIntList mutableIntList2;
        int i15;
        FlowLayoutBuildingBlocks.WrapEllipsisInfo wrapEllipsisInfo2;
        int i16;
        int i17;
        int i18;
        MeasureScope measureScope3 = measureScope;
        FlowLineMeasurePolicy flowLineMeasurePolicy3 = flowLineMeasurePolicy;
        Iterator<? extends Measurable> it2 = it;
        MutableVector mutableVector = new MutableVector(new MeasureResult[16], 0);
        int iM6797getMaxWidthimpl = Constraints.m6797getMaxWidthimpl(j5);
        int iM6799getMinWidthimpl = Constraints.m6799getMinWidthimpl(j5);
        int iM6796getMaxHeightimpl = Constraints.m6796getMaxHeightimpl(j5);
        MutableIntObjectMap mutableIntObjectMapMutableIntObjectMapOf = IntObjectMapKt.mutableIntObjectMapOf();
        ArrayList arrayList = new ArrayList();
        int iCeil = (int) Math.ceil(measureScope3.mo381toPx0680j_4(f));
        int iCeil2 = (int) Math.ceil(measureScope3.mo381toPx0680j_4(f7));
        long jM667constructorimpl = OrientationIndependentConstraints.m667constructorimpl(0, iM6797getMaxWidthimpl, 0, iM6796getMaxHeightimpl);
        long jM682toBoxConstraintsOenEA2s = OrientationIndependentConstraints.m682toBoxConstraintsOenEA2s(OrientationIndependentConstraints.m671copyyUG9Ft0$default(jM667constructorimpl, 0, 0, 0, 0, 14, null), flowLineMeasurePolicy3.isHorizontal() ? LayoutOrientation.Horizontal : LayoutOrientation.Vertical);
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        FlowLineInfo flowLineInfo = it2 instanceof ContextualFlowItemIterator ? new FlowLineInfo(0, 0, measureScope3.mo378toDpu2uoSUM(iM6797getMaxWidthimpl), measureScope3.mo378toDpu2uoSUM(iM6796getMaxHeightimpl), null) : null;
        Measurable measurableSafeNext = !it2.hasNext() ? null : safeNext(it2, flowLineInfo);
        IntIntPair intIntPairM20boximpl = measurableSafeNext != null ? IntIntPair.m20boximpl(m626measureAndCacherqJ1uqs(measurableSafeNext, flowLineMeasurePolicy3, jM682toBoxConstraintsOenEA2s, new k() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$breakDownItems$nextSize$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Placeable) obj);
                return r.f317a;
            }

            public final void invoke(Placeable placeable) {
                ref$ObjectRef.f4920a = placeable;
            }
        })) : null;
        Integer numValueOf = intIntPairM20boximpl != null ? Integer.valueOf(IntIntPair.m27getFirstimpl(intIntPairM20boximpl.getPackedValue())) : null;
        Integer numValueOf2 = intIntPairM20boximpl != null ? Integer.valueOf(IntIntPair.m28getSecondimpl(intIntPairM20boximpl.getPackedValue())) : null;
        Integer num = numValueOf;
        Measurable measurable = measurableSafeNext;
        MutableIntList mutableIntList3 = new MutableIntList(0, 1, null);
        MutableIntList mutableIntList4 = new MutableIntList(0, 1, null);
        FlowLineInfo flowLineInfo2 = flowLineInfo;
        FlowLayoutBuildingBlocks flowLayoutBuildingBlocks = new FlowLayoutBuildingBlocks(i, flowLayoutOverflowState, j5, i6, iCeil, iCeil2, null);
        FlowLayoutBuildingBlocks.WrapInfo wrapInfoM623getWrapInfoOpUlnko = flowLayoutBuildingBlocks.m623getWrapInfoOpUlnko(it2.hasNext(), 0, IntIntPair.m23constructorimpl(iM6797getMaxWidthimpl, iM6796getMaxHeightimpl), intIntPairM20boximpl, 0, 0, 0, false, false);
        if (wrapInfoM623getWrapInfoOpUlnko.getIsLastItemInContainer()) {
            wrapEllipsisInfo = flowLayoutBuildingBlocks.getWrapEllipsisInfo(wrapInfoM623getWrapInfoOpUlnko, intIntPairM20boximpl != null, -1, 0, iM6797getMaxWidthimpl, 0);
            i10 = iM6797getMaxWidthimpl;
        } else {
            i10 = iM6797getMaxWidthimpl;
            wrapEllipsisInfo = null;
        }
        Integer numValueOf3 = num;
        FlowLayoutBuildingBlocks.WrapEllipsisInfo wrapEllipsisInfo3 = wrapEllipsisInfo;
        FlowLayoutBuildingBlocks.WrapInfo wrapInfo = wrapInfoM623getWrapInfoOpUlnko;
        int i19 = 0;
        int i20 = iM6799getMinWidthimpl;
        Measurable measurableSafeNext2 = measurable;
        int i21 = 0;
        int i22 = 0;
        int i23 = 0;
        int i24 = 0;
        MutableIntList mutableIntList5 = mutableIntList3;
        int i25 = iM6796getMaxHeightimpl;
        int i26 = i10;
        int i27 = 0;
        while (!wrapInfo.getIsLastItemInContainer() && measurableSafeNext2 != null) {
            kotlin.jvm.internal.k.c(numValueOf3);
            int iIntValue = numValueOf3.intValue();
            kotlin.jvm.internal.k.c(numValueOf2);
            MutableIntList mutableIntList6 = mutableIntList4;
            int i28 = i10;
            int i29 = i22 + iIntValue;
            int iMax = Math.max(i27, numValueOf2.intValue());
            int i30 = i26 - iIntValue;
            int i31 = i21 + 1;
            int i32 = i20;
            flowLayoutOverflowState.setItemShown$foundation_layout_release(i31);
            arrayList.add(measurableSafeNext2);
            mutableIntObjectMapMutableIntObjectMapOf.set(i21, ref$ObjectRef.f4920a);
            int i33 = i31 - i23;
            boolean z10 = i33 < i;
            if (flowLineInfo2 != null) {
                if (z10) {
                    i13 = i33;
                    i16 = i19;
                } else {
                    i13 = i33;
                    i16 = i19 + 1;
                }
                int i34 = z10 ? i13 : 0;
                if (z10) {
                    int i35 = i30 - iCeil;
                    if (i35 < 0) {
                        i35 = 0;
                    }
                    i17 = i35;
                } else {
                    i17 = i28;
                }
                float fMo378toDpu2uoSUM = measureScope3.mo378toDpu2uoSUM(i17);
                if (z10) {
                    mutableIntObjectMap2 = mutableIntObjectMapMutableIntObjectMapOf;
                    i18 = i25;
                } else {
                    int i36 = (i25 - iMax) - iCeil2;
                    if (i36 < 0) {
                        i36 = 0;
                    }
                    mutableIntObjectMap2 = mutableIntObjectMapMutableIntObjectMapOf;
                    i18 = i36;
                }
                flowLineInfo2.m636update4j6BHR0$foundation_layout_release(i16, i34, fMo378toDpu2uoSUM, measureScope3.mo378toDpu2uoSUM(i18));
            } else {
                i13 = i33;
                mutableIntObjectMap2 = mutableIntObjectMapMutableIntObjectMapOf;
            }
            measurableSafeNext2 = !it2.hasNext() ? null : safeNext(it2, flowLineInfo2);
            IntIntPair intIntPairM20boximpl2 = null;
            ref$ObjectRef.f4920a = null;
            IntIntPair intIntPairM20boximpl3 = measurableSafeNext2 != null ? IntIntPair.m20boximpl(m626measureAndCacherqJ1uqs(measurableSafeNext2, flowLineMeasurePolicy3, jM682toBoxConstraintsOenEA2s, new k() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$breakDownItems$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // S7.k
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((Placeable) obj);
                    return r.f317a;
                }

                public final void invoke(Placeable placeable) {
                    ref$ObjectRef.f4920a = placeable;
                }
            })) : null;
            Integer numValueOf4 = intIntPairM20boximpl3 != null ? Integer.valueOf(IntIntPair.m27getFirstimpl(intIntPairM20boximpl3.getPackedValue()) + iCeil) : null;
            numValueOf2 = intIntPairM20boximpl3 != null ? Integer.valueOf(IntIntPair.m28getSecondimpl(intIntPairM20boximpl3.getPackedValue())) : null;
            boolean zHasNext = it2.hasNext();
            int i37 = i19;
            long jM23constructorimpl = IntIntPair.m23constructorimpl(i30, i25);
            if (intIntPairM20boximpl3 != null) {
                kotlin.jvm.internal.k.c(numValueOf4);
                int iIntValue2 = numValueOf4.intValue();
                kotlin.jvm.internal.k.c(numValueOf2);
                intIntPairM20boximpl2 = IntIntPair.m20boximpl(IntIntPair.m23constructorimpl(iIntValue2, numValueOf2.intValue()));
            }
            FlowLayoutBuildingBlocks.WrapInfo wrapInfoM623getWrapInfoOpUlnko2 = flowLayoutBuildingBlocks.m623getWrapInfoOpUlnko(zHasNext, i13, jM23constructorimpl, intIntPairM20boximpl2, i37, i24, iMax, false, false);
            if (wrapInfoM623getWrapInfoOpUlnko2.getIsLastItemInLine()) {
                int iMin = Math.min(Math.max(i32, i29), i28);
                int i38 = i24 + iMax;
                FlowLayoutBuildingBlocks.WrapEllipsisInfo wrapEllipsisInfo4 = flowLayoutBuildingBlocks.getWrapEllipsisInfo(wrapInfoM623getWrapInfoOpUlnko2, intIntPairM20boximpl3 != null, i37, i38, i30, i13);
                mutableIntList = mutableIntList6;
                mutableIntList.add(iMax);
                int i39 = (iM6796getMaxHeightimpl - i38) - iCeil2;
                MutableIntList mutableIntList7 = mutableIntList5;
                mutableIntList7.add(i31);
                i19 = i37 + 1;
                numValueOf3 = numValueOf4 != null ? Integer.valueOf(numValueOf4.intValue() - iCeil) : null;
                i26 = i28;
                i28 = i26;
                i23 = i31;
                i24 = i38 + iCeil2;
                i15 = 0;
                i14 = iMin;
                i25 = i39;
                wrapEllipsisInfo2 = wrapEllipsisInfo4;
                mutableIntList2 = mutableIntList7;
                i29 = 0;
            } else {
                i14 = i32;
                mutableIntList = mutableIntList6;
                mutableIntList2 = mutableIntList5;
                numValueOf3 = numValueOf4;
                i26 = i30;
                i19 = i37;
                i15 = iMax;
                wrapEllipsisInfo2 = wrapEllipsisInfo3;
            }
            wrapEllipsisInfo3 = wrapEllipsisInfo2;
            mutableIntList5 = mutableIntList2;
            i27 = i15;
            i20 = i14;
            i21 = i31;
            wrapInfo = wrapInfoM623getWrapInfoOpUlnko2;
            it2 = it;
            mutableIntList4 = mutableIntList;
            mutableIntObjectMapMutableIntObjectMapOf = mutableIntObjectMap2;
            i22 = i29;
            i10 = i28;
        }
        MutableIntObjectMap mutableIntObjectMap3 = mutableIntObjectMapMutableIntObjectMapOf;
        int i40 = i20;
        MutableIntList mutableIntList8 = mutableIntList4;
        MutableIntList mutableIntList9 = mutableIntList5;
        if (wrapEllipsisInfo3 != null) {
            arrayList.add(wrapEllipsisInfo3.getEllipsis());
            mutableIntObjectMap = mutableIntObjectMap3;
            mutableIntObjectMap.set(arrayList.size() - 1, wrapEllipsisInfo3.getPlaceable());
            int i41 = mutableIntList9._size - 1;
            if (wrapEllipsisInfo3.getPlaceEllipsisOnLastContentLine()) {
                int size = mutableIntList9.getSize() - 1;
                mutableIntList8.set(i41, Math.max(mutableIntList8.get(i41), IntIntPair.m28getSecondimpl(wrapEllipsisInfo3.getEllipsisSize())));
                mutableIntList9.set(size, mutableIntList9.last() + 1);
            } else {
                mutableIntList8.add(IntIntPair.m28getSecondimpl(wrapEllipsisInfo3.getEllipsisSize()));
                mutableIntList9.add(mutableIntList9.last() + 1);
            }
        } else {
            mutableIntObjectMap = mutableIntObjectMap3;
        }
        int size2 = arrayList.size();
        Placeable[] placeableArr = new Placeable[size2];
        for (int i42 = 0; i42 < size2; i42++) {
            placeableArr[i42] = mutableIntObjectMap.get(i42);
        }
        int size3 = mutableIntList9.getSize();
        int[] iArr3 = new int[size3];
        for (int i43 = 0; i43 < size3; i43++) {
            iArr3[i43] = 0;
        }
        int size4 = mutableIntList9.getSize();
        int[] iArr4 = new int[size4];
        for (int i44 = 0; i44 < size4; i44++) {
            iArr4[i44] = 0;
        }
        int[] iArr5 = mutableIntList9.content;
        int i45 = mutableIntList9._size;
        int iMax2 = i40;
        int i46 = 0;
        int i47 = 0;
        int i48 = 0;
        while (i47 < i45) {
            int i49 = iArr5[i47];
            MutableIntList mutableIntList10 = mutableIntList8;
            int i50 = mutableIntList10.get(i47);
            FlowLineMeasurePolicy flowLineMeasurePolicy4 = flowLineMeasurePolicy3;
            ArrayList arrayList2 = arrayList;
            MeasureResult measureResultMeasure = RowColumnMeasurePolicyKt.measure(flowLineMeasurePolicy4, iMax2, Constraints.m6798getMinHeightimpl(jM667constructorimpl), Constraints.m6797getMaxWidthimpl(jM667constructorimpl), i50, iCeil, measureScope3, arrayList2, placeableArr, i46, i49, iArr3, i47);
            if (flowLineMeasurePolicy.isHorizontal()) {
                height = measureResultMeasure.getWidth();
                width = measureResultMeasure.getHeight();
            } else {
                height = measureResultMeasure.getHeight();
                width = measureResultMeasure.getWidth();
            }
            iArr4[i47] = width;
            i48 += width;
            iMax2 = Math.max(iMax2, height);
            mutableVector.add(measureResultMeasure);
            i47++;
            arrayList = arrayList2;
            i46 = i49;
            mutableIntList8 = mutableIntList10;
            measureScope3 = measureScope;
            flowLineMeasurePolicy3 = flowLineMeasurePolicy;
        }
        if (mutableVector.isEmpty()) {
            i11 = 0;
            i12 = 0;
            measureScope2 = measureScope;
            flowLineMeasurePolicy2 = flowLineMeasurePolicy;
            j6 = j5;
            iArr = iArr3;
            iArr2 = iArr4;
        } else {
            i11 = iMax2;
            i12 = i48;
            measureScope2 = measureScope;
            flowLineMeasurePolicy2 = flowLineMeasurePolicy;
            iArr = iArr3;
            iArr2 = iArr4;
            j6 = j5;
        }
        return m627placeHelperBmaY500(measureScope2, j6, i11, i12, iArr2, mutableVector, flowLineMeasurePolicy2, iArr);
    }

    @Composable
    public static final MeasurePolicy columnMeasurementHelper(Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, int i, Composer composer, int i6) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2013098357, i6, -1, "androidx.compose.foundation.layout.columnMeasurementHelper (FlowLayout.kt:442)");
        }
        boolean z10 = ((((i6 & 14) ^ 6) > 4 && composer.changed(vertical)) || (i6 & 6) == 4) | ((((i6 & 112) ^ 48) > 32 && composer.changed(horizontal)) || (i6 & 48) == 32) | ((((i6 & 896) ^ 384) > 256 && composer.changed(i)) || (i6 & 384) == 256);
        Object objRememberedValue = composer.rememberedValue();
        if (z10 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            final FlowMeasurePolicy flowMeasurePolicy = new FlowMeasurePolicy(false, horizontal, vertical, vertical.getSpacing(), CROSS_AXIS_ALIGNMENT_START, horizontal.getSpacing(), i, Integer.MAX_VALUE, FlowRowOverflow.INSTANCE.getVisible().createOverflowState$foundation_layout_release(), null);
            objRememberedValue = new MeasurePolicy() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$columnMeasurementHelper$1$1
                @Override // androidx.compose.ui.layout.MeasurePolicy
                /* renamed from: measure-3p2s80s */
                public final MeasureResult mo37measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j5) {
                    return flowMeasurePolicy.mo648measure3p2s80s(measureScope, o.M(list), j5);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        MeasurePolicy measurePolicy = (MeasurePolicy) objRememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return measurePolicy;
    }

    @Composable
    public static final MultiContentMeasurePolicy columnMeasurementMultiContentHelper(Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, int i, int i6, FlowLayoutOverflowState flowLayoutOverflowState, Composer composer, int i10) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(748776953, i10, -1, "androidx.compose.foundation.layout.columnMeasurementMultiContentHelper (FlowLayout.kt:474)");
        }
        boolean zChanged = ((((i10 & 14) ^ 6) > 4 && composer.changed(vertical)) || (i10 & 6) == 4) | ((((i10 & 112) ^ 48) > 32 && composer.changed(horizontal)) || (i10 & 48) == 32) | ((((i10 & 896) ^ 384) > 256 && composer.changed(i)) || (i10 & 384) == 256) | ((((i10 & 7168) ^ 3072) > 2048 && composer.changed(i6)) || (i10 & 3072) == 2048) | composer.changed(flowLayoutOverflowState);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            FlowMeasurePolicy flowMeasurePolicy = new FlowMeasurePolicy(false, horizontal, vertical, vertical.getSpacing(), CROSS_AXIS_ALIGNMENT_START, horizontal.getSpacing(), i, i6, flowLayoutOverflowState, null);
            composer.updateRememberedValue(flowMeasurePolicy);
            objRememberedValue = flowMeasurePolicy;
        }
        FlowMeasurePolicy flowMeasurePolicy2 = (FlowMeasurePolicy) objRememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return flowMeasurePolicy2;
    }

    public static final int crossAxisMin(IntrinsicMeasurable intrinsicMeasurable, boolean z10, int i) {
        return z10 ? intrinsicMeasurable.minIntrinsicHeight(i) : intrinsicMeasurable.minIntrinsicWidth(i);
    }

    public static final CrossAxisAlignment getCROSS_AXIS_ALIGNMENT_START() {
        return CROSS_AXIS_ALIGNMENT_START;
    }

    public static final CrossAxisAlignment getCROSS_AXIS_ALIGNMENT_TOP() {
        return CROSS_AXIS_ALIGNMENT_TOP;
    }

    private static final long intrinsicCrossAxisSize(List<? extends IntrinsicMeasurable> list, final int[] iArr, final int[] iArr2, int i, int i6, int i10, int i11, int i12, FlowLayoutOverflowState flowLayoutOverflowState) {
        return intrinsicCrossAxisSize(list, new S7.o() { // from class: androidx.compose.foundation.layout.FlowLayoutKt.intrinsicCrossAxisSize.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // S7.o
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return invoke((IntrinsicMeasurable) obj, ((Number) obj2).intValue(), ((Number) obj3).intValue());
            }

            public final Integer invoke(IntrinsicMeasurable intrinsicMeasurable, int i13, int i14) {
                return Integer.valueOf(iArr[i13]);
            }
        }, new S7.o() { // from class: androidx.compose.foundation.layout.FlowLayoutKt.intrinsicCrossAxisSize.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // S7.o
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return invoke((IntrinsicMeasurable) obj, ((Number) obj2).intValue(), ((Number) obj3).intValue());
            }

            public final Integer invoke(IntrinsicMeasurable intrinsicMeasurable, int i13, int i14) {
                return Integer.valueOf(iArr2[i13]);
            }
        }, i, i6, i10, i11, i12, flowLayoutOverflowState);
    }

    public static final int mainAxisMin(IntrinsicMeasurable intrinsicMeasurable, boolean z10, int i) {
        return z10 ? intrinsicMeasurable.minIntrinsicWidth(i) : intrinsicMeasurable.minIntrinsicHeight(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int maxIntrinsicMainAxisSize(List<? extends IntrinsicMeasurable> list, S7.o oVar, int i, int i6, int i10) {
        int size = list.size();
        int i11 = 0;
        int iMax = 0;
        int i12 = 0;
        int i13 = 0;
        while (i11 < size) {
            int iIntValue = ((Number) oVar.invoke(list.get(i11), Integer.valueOf(i11), Integer.valueOf(i))).intValue() + i6;
            int i14 = i11 + 1;
            if (i14 - i12 == i10 || i14 == list.size()) {
                iMax = Math.max(iMax, (i13 + iIntValue) - i6);
                i13 = 0;
                i12 = i11;
            } else {
                i13 += iIntValue;
            }
            i11 = i14;
        }
        return iMax;
    }

    /* renamed from: measureAndCache-rqJ1uqs, reason: not valid java name */
    public static final long m626measureAndCacherqJ1uqs(Measurable measurable, FlowLineMeasurePolicy flowLineMeasurePolicy, long j5, k kVar) {
        FlowLayoutData flowLayoutData;
        if (RowColumnImplKt.getWeight(RowColumnImplKt.getRowColumnParentData(measurable)) == 0.0f) {
            RowColumnParentData rowColumnParentData = RowColumnImplKt.getRowColumnParentData(measurable);
            if (((rowColumnParentData == null || (flowLayoutData = rowColumnParentData.getFlowLayoutData()) == null) ? null : Float.valueOf(flowLayoutData.getFillCrossAxisFraction())) == null) {
                Placeable placeableMo5549measureBRTryo0 = measurable.mo5549measureBRTryo0(j5);
                kVar.invoke(placeableMo5549measureBRTryo0);
                return IntIntPair.m23constructorimpl(flowLineMeasurePolicy.mainAxisSize(placeableMo5549measureBRTryo0), flowLineMeasurePolicy.crossAxisSize(placeableMo5549measureBRTryo0));
            }
        }
        int iMainAxisMin = mainAxisMin(measurable, flowLineMeasurePolicy.isHorizontal(), Integer.MAX_VALUE);
        return IntIntPair.m23constructorimpl(iMainAxisMin, crossAxisMin(measurable, flowLineMeasurePolicy.isHorizontal(), iMainAxisMin));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int minIntrinsicMainAxisSize(List<? extends IntrinsicMeasurable> list, S7.o oVar, S7.o oVar2, int i, int i6, int i10, int i11, int i12, FlowLayoutOverflowState flowLayoutOverflowState) {
        int i13 = i11;
        int i14 = i12;
        if (list.isEmpty()) {
            return 0;
        }
        int size = list.size();
        int[] iArr = new int[size];
        for (int i15 = 0; i15 < size; i15++) {
            iArr[i15] = 0;
        }
        int size2 = list.size();
        int[] iArr2 = new int[size2];
        for (int i16 = 0; i16 < size2; i16++) {
            iArr2[i16] = 0;
        }
        int size3 = list.size();
        for (int i17 = 0; i17 < size3; i17++) {
            IntrinsicMeasurable intrinsicMeasurable = list.get(i17);
            int iIntValue = ((Number) oVar.invoke(intrinsicMeasurable, Integer.valueOf(i17), Integer.valueOf(i))).intValue();
            iArr[i17] = iIntValue;
            iArr2[i17] = ((Number) oVar2.invoke(intrinsicMeasurable, Integer.valueOf(i17), Integer.valueOf(iIntValue))).intValue();
        }
        List<? extends IntrinsicMeasurable> list2 = list;
        int i18 = Integer.MAX_VALUE;
        if (i14 != Integer.MAX_VALUE && i13 != Integer.MAX_VALUE) {
            i18 = i13 * i14;
        }
        int iMin = Math.min(i18 - (((i18 >= list2.size() || !(flowLayoutOverflowState.getType$foundation_layout_release() == FlowLayoutOverflow.OverflowType.ExpandIndicator || flowLayoutOverflowState.getType$foundation_layout_release() == FlowLayoutOverflow.OverflowType.ExpandOrCollapseIndicator)) && (i18 < list2.size() || i14 < flowLayoutOverflowState.getMinLinesToShowCollapse$foundation_layout_release() || flowLayoutOverflowState.getType$foundation_layout_release() != FlowLayoutOverflow.OverflowType.ExpandOrCollapseIndicator)) ? 0 : 1), list2.size());
        int i19 = 0;
        for (int i20 = 0; i20 < size; i20++) {
            i19 += iArr[i20];
        }
        int size4 = ((list2.size() - 1) * i6) + i19;
        if (size2 == 0) {
            throw new NoSuchElementException();
        }
        int iM27getFirstimpl = iArr2[0];
        e it = new f(1, size2 - 1, 1).iterator();
        while (it.c) {
            int i21 = iArr2[it.nextInt()];
            if (iM27getFirstimpl < i21) {
                iM27getFirstimpl = i21;
            }
        }
        if (size == 0) {
            throw new NoSuchElementException();
        }
        int i22 = iArr[0];
        e it2 = new f(1, size - 1, 1).iterator();
        while (it2.c) {
            int i23 = iArr[it2.nextInt()];
            if (i22 < i23) {
                i22 = i23;
            }
        }
        int i24 = i22;
        int i25 = size4;
        while (i24 <= i25 && iM27getFirstimpl != i) {
            int i26 = (i24 + i25) / 2;
            long jIntrinsicCrossAxisSize = intrinsicCrossAxisSize(list2, iArr, iArr2, i26, i6, i10, i13, i14, flowLayoutOverflowState);
            iM27getFirstimpl = IntIntPair.m27getFirstimpl(jIntrinsicCrossAxisSize);
            int iM28getSecondimpl = IntIntPair.m28getSecondimpl(jIntrinsicCrossAxisSize);
            if (iM27getFirstimpl > i || iM28getSecondimpl < iMin) {
                i24 = i26 + 1;
                if (i24 > i25) {
                    return i24;
                }
            } else {
                if (iM27getFirstimpl >= i) {
                    return i26;
                }
                i25 = i26 - 1;
            }
            list2 = list;
            i13 = i11;
            i14 = i12;
            size4 = i26;
        }
        return size4;
    }

    /* renamed from: placeHelper-BmaY500, reason: not valid java name */
    public static final MeasureResult m627placeHelperBmaY500(MeasureScope measureScope, long j5, int i, int i6, int[] iArr, final MutableVector<MeasureResult> mutableVector, FlowLineMeasurePolicy flowLineMeasurePolicy, int[] iArr2) {
        int iU;
        int i10;
        int i11;
        boolean zIsHorizontal = flowLineMeasurePolicy.isHorizontal();
        Arrangement.Vertical verticalArrangement = flowLineMeasurePolicy.getVerticalArrangement();
        Arrangement.Horizontal horizontalArrangement = flowLineMeasurePolicy.getHorizontalArrangement();
        if (zIsHorizontal) {
            if (verticalArrangement == null) {
                throw new IllegalArgumentException("null verticalArrangement");
            }
            iU = AbstractC1451a.u(((mutableVector.getSize() - 1) * measureScope.mo375roundToPx0680j_4(verticalArrangement.getSpacing())) + i6, Constraints.m6798getMinHeightimpl(j5), Constraints.m6796getMaxHeightimpl(j5));
            verticalArrangement.arrange(measureScope, iU, iArr, iArr2);
        } else {
            if (horizontalArrangement == null) {
                throw new IllegalArgumentException("null horizontalArrangement");
            }
            int iU2 = AbstractC1451a.u(((mutableVector.getSize() - 1) * measureScope.mo375roundToPx0680j_4(horizontalArrangement.getSpacing())) + i6, Constraints.m6798getMinHeightimpl(j5), Constraints.m6796getMaxHeightimpl(j5));
            horizontalArrangement.arrange(measureScope, iU2, iArr, measureScope.getLayoutDirection(), iArr2);
            iU = iU2;
        }
        int iU3 = AbstractC1451a.u(i, Constraints.m6799getMinWidthimpl(j5), Constraints.m6797getMaxWidthimpl(j5));
        if (zIsHorizontal) {
            i11 = iU3;
            i10 = iU;
        } else {
            i10 = iU3;
            i11 = iU;
        }
        return MeasureScope.layout$default(measureScope, i11, i10, null, new k() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$placeHelper$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Placeable.PlacementScope) obj);
                return r.f317a;
            }

            public final void invoke(Placeable.PlacementScope placementScope) {
                MutableVector<MeasureResult> mutableVector2 = mutableVector;
                int size = mutableVector2.getSize();
                if (size > 0) {
                    MeasureResult[] content = mutableVector2.getContent();
                    int i12 = 0;
                    do {
                        content[i12].placeChildren();
                        i12++;
                    } while (i12 < size);
                }
            }
        }, 4, null);
    }

    @Composable
    public static final MeasurePolicy rowMeasurementHelper(Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, int i, Composer composer, int i6) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1479255111, i6, -1, "androidx.compose.foundation.layout.rowMeasurementHelper (FlowLayout.kt:379)");
        }
        boolean z10 = ((((i6 & 14) ^ 6) > 4 && composer.changed(horizontal)) || (i6 & 6) == 4) | ((((i6 & 112) ^ 48) > 32 && composer.changed(vertical)) || (i6 & 48) == 32) | ((((i6 & 896) ^ 384) > 256 && composer.changed(i)) || (i6 & 384) == 256);
        Object objRememberedValue = composer.rememberedValue();
        if (z10 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            final FlowMeasurePolicy flowMeasurePolicy = new FlowMeasurePolicy(true, horizontal, vertical, horizontal.getSpacing(), CROSS_AXIS_ALIGNMENT_TOP, vertical.getSpacing(), i, Integer.MAX_VALUE, FlowRowOverflow.INSTANCE.getVisible().createOverflowState$foundation_layout_release(), null);
            objRememberedValue = new MeasurePolicy() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$rowMeasurementHelper$1$1
                @Override // androidx.compose.ui.layout.MeasurePolicy
                /* renamed from: measure-3p2s80s */
                public final MeasureResult mo37measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j5) {
                    return flowMeasurePolicy.mo648measure3p2s80s(measureScope, o.M(list), j5);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        MeasurePolicy measurePolicy = (MeasurePolicy) objRememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return measurePolicy;
    }

    @Composable
    public static final MultiContentMeasurePolicy rowMeasurementMultiContentHelper(Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, int i, int i6, FlowLayoutOverflowState flowLayoutOverflowState, Composer composer, int i10) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2134502475, i10, -1, "androidx.compose.foundation.layout.rowMeasurementMultiContentHelper (FlowLayout.kt:413)");
        }
        boolean zChanged = ((((i10 & 14) ^ 6) > 4 && composer.changed(horizontal)) || (i10 & 6) == 4) | ((((i10 & 112) ^ 48) > 32 && composer.changed(vertical)) || (i10 & 48) == 32) | ((((i10 & 896) ^ 384) > 256 && composer.changed(i)) || (i10 & 384) == 256) | ((((i10 & 7168) ^ 3072) > 2048 && composer.changed(i6)) || (i10 & 3072) == 2048) | composer.changed(flowLayoutOverflowState);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            FlowMeasurePolicy flowMeasurePolicy = new FlowMeasurePolicy(true, horizontal, vertical, horizontal.getSpacing(), CROSS_AXIS_ALIGNMENT_TOP, vertical.getSpacing(), i, i6, flowLayoutOverflowState, null);
            composer.updateRememberedValue(flowMeasurePolicy);
            objRememberedValue = flowMeasurePolicy;
        }
        FlowMeasurePolicy flowMeasurePolicy2 = (FlowMeasurePolicy) objRememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return flowMeasurePolicy2;
    }

    private static final Measurable safeNext(Iterator<? extends Measurable> it, FlowLineInfo flowLineInfo) {
        try {
            if (!(it instanceof ContextualFlowItemIterator)) {
                return it.next();
            }
            kotlin.jvm.internal.k.c(flowLineInfo);
            return ((ContextualFlowItemIterator) it).getNext$foundation_layout_release(flowLineInfo);
        } catch (ArrayIndexOutOfBoundsException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long intrinsicCrossAxisSize(List<? extends IntrinsicMeasurable> list, S7.o oVar, S7.o oVar2, int i, int i6, int i10, int i11, int i12, FlowLayoutOverflowState flowLayoutOverflowState) {
        int i13;
        if (list.isEmpty()) {
            return IntIntPair.m23constructorimpl(0, 0);
        }
        FlowLayoutBuildingBlocks flowLayoutBuildingBlocks = new FlowLayoutBuildingBlocks(i11, flowLayoutOverflowState, OrientationIndependentConstraints.m667constructorimpl(0, i, 0, Integer.MAX_VALUE), i12, i6, i10, null);
        IntrinsicMeasurable intrinsicMeasurable = (IntrinsicMeasurable) v.D0(0, list);
        int iIntValue = intrinsicMeasurable != null ? ((Number) oVar2.invoke(intrinsicMeasurable, 0, Integer.valueOf(i))).intValue() : 0;
        int iIntValue2 = intrinsicMeasurable != null ? ((Number) oVar.invoke(intrinsicMeasurable, 0, Integer.valueOf(iIntValue))).intValue() : 0;
        int i14 = 0;
        int iMax = 0;
        if (flowLayoutBuildingBlocks.m623getWrapInfoOpUlnko(list.size() > 1, 0, IntIntPair.m23constructorimpl(i, Integer.MAX_VALUE), intrinsicMeasurable == null ? null : IntIntPair.m20boximpl(IntIntPair.m23constructorimpl(iIntValue2, iIntValue)), 0, 0, 0, false, false).getIsLastItemInContainer()) {
            IntIntPair intIntPairM628ellipsisSizeF35zmw$foundation_layout_release = flowLayoutOverflowState.m628ellipsisSizeF35zmw$foundation_layout_release(intrinsicMeasurable != null, 0, 0);
            return IntIntPair.m23constructorimpl(intIntPairM628ellipsisSizeF35zmw$foundation_layout_release != null ? IntIntPair.m28getSecondimpl(intIntPairM628ellipsisSizeF35zmw$foundation_layout_release.getPackedValue()) : 0, 0);
        }
        int size = list.size();
        int i15 = i;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        while (true) {
            int i20 = iMax;
            if (i16 >= size) {
                i13 = i17;
                break;
            }
            int i21 = i15 - iIntValue2;
            int i22 = i16 + 1;
            iMax = Math.max(i20, iIntValue);
            IntrinsicMeasurable intrinsicMeasurable2 = (IntrinsicMeasurable) v.D0(i22, list);
            int iIntValue3 = intrinsicMeasurable2 != null ? ((Number) oVar2.invoke(intrinsicMeasurable2, Integer.valueOf(i22), Integer.valueOf(i))).intValue() : 0;
            int iIntValue4 = intrinsicMeasurable2 != null ? ((Number) oVar.invoke(intrinsicMeasurable2, Integer.valueOf(i22), Integer.valueOf(iIntValue3))).intValue() + i6 : 0;
            int i23 = i22 - i18;
            i13 = i22;
            int i24 = i19;
            FlowLayoutBuildingBlocks.WrapInfo wrapInfoM623getWrapInfoOpUlnko = flowLayoutBuildingBlocks.m623getWrapInfoOpUlnko(i16 + 2 < list.size(), i23, IntIntPair.m23constructorimpl(i21, Integer.MAX_VALUE), intrinsicMeasurable2 == null ? null : IntIntPair.m20boximpl(IntIntPair.m23constructorimpl(iIntValue4, iIntValue3)), i24, i14, iMax, false, false);
            if (wrapInfoM623getWrapInfoOpUlnko.getIsLastItemInLine()) {
                int iM28getSecondimpl = iMax + i10 + i14;
                FlowLayoutBuildingBlocks.WrapEllipsisInfo wrapEllipsisInfo = flowLayoutBuildingBlocks.getWrapEllipsisInfo(wrapInfoM623getWrapInfoOpUlnko, intrinsicMeasurable2 != null, i24, iM28getSecondimpl, i21, i23);
                iIntValue4 -= i6;
                i19 = i24 + 1;
                if (wrapInfoM623getWrapInfoOpUlnko.getIsLastItemInContainer()) {
                    if (wrapEllipsisInfo != null) {
                        long ellipsisSize = wrapEllipsisInfo.getEllipsisSize();
                        if (!wrapEllipsisInfo.getPlaceEllipsisOnLastContentLine()) {
                            iM28getSecondimpl = IntIntPair.m28getSecondimpl(ellipsisSize) + i10 + iM28getSecondimpl;
                        }
                    }
                    i14 = iM28getSecondimpl;
                } else {
                    i15 = i;
                    i18 = i13;
                    i14 = iM28getSecondimpl;
                    iMax = 0;
                }
            } else {
                i15 = i21;
                i19 = i24;
            }
            iIntValue2 = iIntValue4;
            iIntValue = iIntValue3;
            i16 = i13;
            i17 = i16;
        }
        return IntIntPair.m23constructorimpl(i14 - i10, i13);
    }
}
