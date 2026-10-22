package androidx.compose.ui.layout;

import S7.k;
import androidx.compose.foundation.b;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.node.MotionReferencePlacementDelegate;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.mdisdk.capability.model.WindowStateInfo;
import g1.AbstractC1451a;
import kotlin.Metadata;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\b'\u0018\u00002\u00020\u0001:\u0001,B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J5\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0004\u0018\u00010\nH$¢\u0006\u0004\b\r\u0010\u000eJ'\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0014¢\u0006\u0004\b\r\u0010\u0012R$\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00138\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R$\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00138\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0019\u0010\u0016\u001a\u0004\b\u001a\u0010\u0018R*\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0014\u001a\u00020\u001b8\u0004@DX\u0084\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R*\u0010#\u001a\u00020\"2\u0006\u0010\u0014\u001a\u00020\"8\u0004@DX\u0084\u000e¢\u0006\u0012\n\u0004\b#\u0010\u001d\u001a\u0004\b$\u0010\u001f\"\u0004\b%\u0010!R$\u0010&\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00068\u0004@BX\u0084\u000e¢\u0006\f\n\u0004\b&\u0010\u001d\u001a\u0004\b'\u0010\u001fR\u0014\u0010)\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b(\u0010\u0018R\u0014\u0010+\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b*\u0010\u0018¨\u0006-"}, d2 = {"Landroidx/compose/ui/layout/Placeable;", "Landroidx/compose/ui/layout/Measured;", AppAgent.CONSTRUCT, "()V", "LC7/r;", "onMeasuredSizeChanged", "Landroidx/compose/ui/unit/IntOffset;", "position", "", "zIndex", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "layerBlock", "placeAt-f8xVGno", "(JFLS7/k;)V", "placeAt", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", WindowStateInfo.KEY_LAYER, "(JFLandroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "", "value", "width", "I", "getWidth", "()I", "height", "getHeight", "Landroidx/compose/ui/unit/IntSize;", "measuredSize", "J", "getMeasuredSize-YbymL2g", "()J", "setMeasuredSize-ozmzZPI", "(J)V", "Landroidx/compose/ui/unit/Constraints;", "measurementConstraints", "getMeasurementConstraints-msEJaDk", "setMeasurementConstraints-BRTryo0", "apparentToRealOffset", "getApparentToRealOffset-nOcc-ac", "getMeasuredWidth", "measuredWidth", "getMeasuredHeight", "measuredHeight", "PlacementScope", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class Placeable implements Measured {
    public static final int $stable = 8;
    private int height;
    private long measuredSize;
    private int width;
    private long measurementConstraints = PlaceableKt.DefaultConstraints;
    private long apparentToRealOffset = IntOffset.INSTANCE.m6983getZeronOccac();

    public Placeable() {
        long j5 = 0;
        this.measuredSize = IntSize.m7010constructorimpl((j5 & 4294967295L) | (j5 << 32));
    }

    private final void onMeasuredSizeChanged() {
        this.width = AbstractC1451a.u((int) (this.measuredSize >> 32), Constraints.m6799getMinWidthimpl(this.measurementConstraints), Constraints.m6797getMaxWidthimpl(this.measurementConstraints));
        this.height = AbstractC1451a.u((int) (this.measuredSize & 4294967295L), Constraints.m6798getMinHeightimpl(this.measurementConstraints), Constraints.m6796getMaxHeightimpl(this.measurementConstraints));
        int i = this.width;
        long j5 = this.measuredSize;
        this.apparentToRealOffset = IntOffset.m6966constructorimpl((((i - ((int) (j5 >> 32))) / 2) << 32) | (4294967295L & ((r0 - ((int) (j5 & 4294967295L))) / 2)));
    }

    /* renamed from: getApparentToRealOffset-nOcc-ac, reason: not valid java name and from getter */
    public final long getApparentToRealOffset() {
        return this.apparentToRealOffset;
    }

    public final int getHeight() {
        return this.height;
    }

    @Override // androidx.compose.ui.layout.Measured
    public int getMeasuredHeight() {
        return (int) (this.measuredSize & 4294967295L);
    }

    /* renamed from: getMeasuredSize-YbymL2g, reason: not valid java name and from getter */
    public final long getMeasuredSize() {
        return this.measuredSize;
    }

    @Override // androidx.compose.ui.layout.Measured
    public int getMeasuredWidth() {
        return (int) (this.measuredSize >> 32);
    }

    /* renamed from: getMeasurementConstraints-msEJaDk, reason: not valid java name and from getter */
    public final long getMeasurementConstraints() {
        return this.measurementConstraints;
    }

    public final int getWidth() {
        return this.width;
    }

    /* renamed from: placeAt-f8xVGno */
    public abstract void mo5550placeAtf8xVGno(long position, float zIndex, k layerBlock);

    /* renamed from: placeAt-f8xVGno, reason: not valid java name */
    public void mo5614placeAtf8xVGno(long position, float zIndex, GraphicsLayer layer) {
        mo5550placeAtf8xVGno(position, zIndex, (k) null);
    }

    /* renamed from: setMeasuredSize-ozmzZPI, reason: not valid java name */
    public final void m5615setMeasuredSizeozmzZPI(long j5) {
        if (IntSize.m7013equalsimpl0(this.measuredSize, j5)) {
            return;
        }
        this.measuredSize = j5;
        onMeasuredSizeChanged();
    }

    /* renamed from: setMeasurementConstraints-BRTryo0, reason: not valid java name */
    public final void m5616setMeasurementConstraintsBRTryo0(long j5) {
        if (Constraints.m6790equalsimpl0(this.measurementConstraints, j5)) {
            return;
        }
        this.measurementConstraints = j5;
        onMeasuredSizeChanged();
    }

    @StabilityInferred(parameters = 1)
    @Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\u0007\u001a\u00020\u0005*\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\u0010\u001a\u00020\r*\u00020\t2\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\u0005¢\u0006\u0004\b\u000e\u0010\u000fJ+\u0010\u0010\u001a\u00020\r*\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\b\b\u0002\u0010\f\u001a\u00020\u0005¢\u0006\u0004\b\u0010\u0010\u0014J+\u0010\u0015\u001a\u00020\r*\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\b\b\u0002\u0010\f\u001a\u00020\u0005¢\u0006\u0004\b\u0015\u0010\u0014J#\u0010\u0015\u001a\u00020\r*\u00020\t2\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\u0005¢\u0006\u0004\b\u0016\u0010\u000fJ9\u0010\u001c\u001a\u00020\r*\u00020\t2\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\u00052\u0014\b\u0002\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\r0\u0017¢\u0006\u0004\b\u001a\u0010\u001bJA\u0010\u001c\u001a\u00020\r*\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\b\b\u0002\u0010\f\u001a\u00020\u00052\u0014\b\u0002\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\r0\u0017¢\u0006\u0004\b\u001c\u0010\u001dJA\u0010\u001e\u001a\u00020\r*\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\b\b\u0002\u0010\f\u001a\u00020\u00052\u0014\b\u0002\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\r0\u0017¢\u0006\u0004\b\u001e\u0010\u001dJ9\u0010\u001e\u001a\u00020\r*\u00020\t2\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\u00052\u0014\b\u0002\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\r0\u0017¢\u0006\u0004\b\u001f\u0010\u001bJ3\u0010\u001e\u001a\u00020\r*\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010!\u001a\u00020 2\b\b\u0002\u0010\f\u001a\u00020\u0005¢\u0006\u0004\b\u001e\u0010\"J+\u0010\u001e\u001a\u00020\r*\u00020\t2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010!\u001a\u00020 2\b\b\u0002\u0010\f\u001a\u00020\u0005¢\u0006\u0004\b\u001f\u0010#J3\u0010\u001c\u001a\u00020\r*\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010!\u001a\u00020 2\b\b\u0002\u0010\f\u001a\u00020\u0005¢\u0006\u0004\b\u001c\u0010\"J+\u0010\u001c\u001a\u00020\r*\u00020\t2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010!\u001a\u00020 2\b\b\u0002\u0010\f\u001a\u00020\u0005¢\u0006\u0004\b\u001a\u0010#J<\u0010%\u001a\u00020\r*\u00020\t2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00052\u0016\b\b\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\r\u0018\u00010\u0017H\u0080\b¢\u0006\u0004\b$\u0010\u001bJ,\u0010%\u001a\u00020\r*\u00020\t2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010!\u001a\u00020 H\u0080\b¢\u0006\u0004\b$\u0010&J<\u0010(\u001a\u00020\r*\u00020\t2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00052\u0016\b\b\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\r\u0018\u00010\u0017H\u0080\b¢\u0006\u0004\b'\u0010\u001bJ,\u0010(\u001a\u00020\r*\u00020\t2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010!\u001a\u00020 H\u0080\b¢\u0006\u0004\b'\u0010&J!\u0010*\u001a\u00020\r2\u0012\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\r0\u0017¢\u0006\u0004\b*\u0010+J\u0013\u0010,\u001a\u00020\r*\u00020\tH\u0002¢\u0006\u0004\b,\u0010-R\u0016\u0010/\u001a\u00020.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0014\u00103\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b1\u00102R\u0014\u00105\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b4\u00102R\u0014\u00108\u001a\u00020\u00118$X¤\u0004¢\u0006\u0006\u001a\u0004\b6\u00107R\u0014\u0010<\u001a\u0002098$X¤\u0004¢\u0006\u0006\u001a\u0004\b:\u0010;R\u0016\u0010@\u001a\u0004\u0018\u00010=8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b>\u0010?¨\u0006A"}, d2 = {"Landroidx/compose/ui/layout/Placeable$PlacementScope;", "Landroidx/compose/ui/unit/Density;", AppAgent.CONSTRUCT, "()V", "Landroidx/compose/ui/layout/Ruler;", "", "defaultValue", "current", "(Landroidx/compose/ui/layout/Ruler;F)F", "Landroidx/compose/ui/layout/Placeable;", "Landroidx/compose/ui/unit/IntOffset;", "position", "zIndex", "LC7/r;", "placeRelative-70tqf50", "(Landroidx/compose/ui/layout/Placeable;JF)V", "placeRelative", "", "x", "y", "(Landroidx/compose/ui/layout/Placeable;IIF)V", "place", "place-70tqf50", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "layerBlock", "placeRelativeWithLayer-aW-9-wM", "(Landroidx/compose/ui/layout/Placeable;JFLS7/k;)V", "placeRelativeWithLayer", "(Landroidx/compose/ui/layout/Placeable;IIFLS7/k;)V", "placeWithLayer", "placeWithLayer-aW-9-wM", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", WindowStateInfo.KEY_LAYER, "(Landroidx/compose/ui/layout/Placeable;IILandroidx/compose/ui/graphics/layer/GraphicsLayer;F)V", "(Landroidx/compose/ui/layout/Placeable;JLandroidx/compose/ui/graphics/layer/GraphicsLayer;F)V", "placeAutoMirrored-aW-9-wM$ui_release", "placeAutoMirrored", "(Landroidx/compose/ui/layout/Placeable;JFLandroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "placeApparentToRealOffset-aW-9-wM$ui_release", "placeApparentToRealOffset", "block", "withMotionFrameOfReferencePlacement", "(LS7/k;)V", "handleMotionFrameOfReferencePlacement", "(Landroidx/compose/ui/layout/Placeable;)V", "", "motionFrameOfReferencePlacement", "Z", "getDensity", "()F", "density", "getFontScale", "fontScale", "getParentWidth", "()I", "parentWidth", "Landroidx/compose/ui/unit/LayoutDirection;", "getParentLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "parentLayoutDirection", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "coordinates", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @PlacementScopeMarker
    public static abstract class PlacementScope implements Density {
        public static final int $stable = 0;
        private boolean motionFrameOfReferencePlacement;

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public final void handleMotionFrameOfReferencePlacement(Placeable placeable) {
            if (placeable instanceof MotionReferencePlacementDelegate) {
                ((MotionReferencePlacementDelegate) placeable).updatePlacedUnderMotionFrameOfReference(this.motionFrameOfReferencePlacement);
            }
        }

        public static /* synthetic */ void place$default(PlacementScope placementScope, Placeable placeable, int i, int i6, float f, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: place");
            }
            if ((i10 & 4) != 0) {
                f = 0.0f;
            }
            placementScope.place(placeable, i, i6, f);
        }

        /* renamed from: place-70tqf50$default, reason: not valid java name */
        public static /* synthetic */ void m5617place70tqf50$default(PlacementScope placementScope, Placeable placeable, long j5, float f, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: place-70tqf50");
            }
            if ((i & 2) != 0) {
                f = 0.0f;
            }
            placementScope.m5623place70tqf50(placeable, j5, f);
        }

        public static /* synthetic */ void placeRelative$default(PlacementScope placementScope, Placeable placeable, int i, int i6, float f, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeRelative");
            }
            if ((i10 & 4) != 0) {
                f = 0.0f;
            }
            placementScope.placeRelative(placeable, i, i6, f);
        }

        /* renamed from: placeRelative-70tqf50$default, reason: not valid java name */
        public static /* synthetic */ void m5618placeRelative70tqf50$default(PlacementScope placementScope, Placeable placeable, long j5, float f, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeRelative-70tqf50");
            }
            if ((i & 2) != 0) {
                f = 0.0f;
            }
            placementScope.m5628placeRelative70tqf50(placeable, j5, f);
        }

        public static /* synthetic */ void placeRelativeWithLayer$default(PlacementScope placementScope, Placeable placeable, int i, int i6, float f, k kVar, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeRelativeWithLayer");
            }
            if ((i10 & 4) != 0) {
                f = 0.0f;
            }
            float f7 = f;
            if ((i10 & 8) != 0) {
                kVar = PlaceableKt.DefaultLayerBlock;
            }
            placementScope.placeRelativeWithLayer(placeable, i, i6, f7, kVar);
        }

        /* renamed from: placeRelativeWithLayer-aW-9-wM$default, reason: not valid java name */
        public static /* synthetic */ void m5619placeRelativeWithLayeraW9wM$default(PlacementScope placementScope, Placeable placeable, long j5, float f, k kVar, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeRelativeWithLayer-aW-9-wM");
            }
            if ((i & 2) != 0) {
                f = 0.0f;
            }
            float f7 = f;
            if ((i & 4) != 0) {
                kVar = PlaceableKt.DefaultLayerBlock;
            }
            placementScope.m5629placeRelativeWithLayeraW9wM(placeable, j5, f7, kVar);
        }

        public static /* synthetic */ void placeWithLayer$default(PlacementScope placementScope, Placeable placeable, int i, int i6, float f, k kVar, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeWithLayer");
            }
            if ((i10 & 4) != 0) {
                f = 0.0f;
            }
            float f7 = f;
            if ((i10 & 8) != 0) {
                kVar = PlaceableKt.DefaultLayerBlock;
            }
            placementScope.placeWithLayer(placeable, i, i6, f7, kVar);
        }

        /* renamed from: placeWithLayer-aW-9-wM$default, reason: not valid java name */
        public static /* synthetic */ void m5621placeWithLayeraW9wM$default(PlacementScope placementScope, Placeable placeable, long j5, float f, k kVar, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeWithLayer-aW-9-wM");
            }
            if ((i & 2) != 0) {
                f = 0.0f;
            }
            float f7 = f;
            if ((i & 4) != 0) {
                kVar = PlaceableKt.DefaultLayerBlock;
            }
            placementScope.m5631placeWithLayeraW9wM(placeable, j5, f7, kVar);
        }

        public float current(Ruler ruler, float f) {
            return f;
        }

        public LayoutCoordinates getCoordinates() {
            return null;
        }

        @Override // androidx.compose.ui.unit.Density
        public float getDensity() {
            return 1.0f;
        }

        @Override // androidx.compose.ui.unit.FontScaling
        public float getFontScale() {
            return 1.0f;
        }

        public abstract LayoutDirection getParentLayoutDirection();

        public abstract int getParentWidth();

        public final void place(Placeable placeable, int i, int i6, float f) {
            placeable.mo5550placeAtf8xVGno(b.h(this, placeable, placeable, IntOffset.m6966constructorimpl((i6 & 4294967295L) | (i << 32))), f, (k) null);
        }

        /* renamed from: place-70tqf50, reason: not valid java name */
        public final void m5623place70tqf50(Placeable placeable, long j5, float f) {
            placeable.mo5550placeAtf8xVGno(b.h(this, placeable, placeable, j5), f, (k) null);
        }

        /* renamed from: placeApparentToRealOffset-aW-9-wM$ui_release, reason: not valid java name */
        public final void m5624placeApparentToRealOffsetaW9wM$ui_release(Placeable placeable, long j5, float f, k kVar) {
            placeable.mo5550placeAtf8xVGno(b.h(this, placeable, placeable, j5), f, kVar);
        }

        /* renamed from: placeAutoMirrored-aW-9-wM$ui_release, reason: not valid java name */
        public final void m5626placeAutoMirroredaW9wM$ui_release(Placeable placeable, long j5, float f, k kVar) {
            if (getParentLayoutDirection() == LayoutDirection.Ltr || getParentWidth() == 0) {
                placeable.mo5550placeAtf8xVGno(b.h(this, placeable, placeable, j5), f, kVar);
                return;
            }
            placeable.mo5550placeAtf8xVGno(b.h(this, placeable, placeable, IntOffset.m6966constructorimpl((IntOffset.m6973getYimpl(j5) & 4294967295L) | (((getParentWidth() - placeable.getWidth()) - IntOffset.m6972getXimpl(j5)) << 32))), f, kVar);
        }

        public final void placeRelative(Placeable placeable, int i, int i6, float f) {
            long jM6966constructorimpl = IntOffset.m6966constructorimpl((i << 32) | (i6 & 4294967295L));
            if (getParentLayoutDirection() == LayoutDirection.Ltr || getParentWidth() == 0) {
                placeable.mo5550placeAtf8xVGno(b.h(this, placeable, placeable, jM6966constructorimpl), f, (k) null);
            } else {
                placeable.mo5550placeAtf8xVGno(b.h(this, placeable, placeable, IntOffset.m6966constructorimpl((((getParentWidth() - placeable.getWidth()) - IntOffset.m6972getXimpl(jM6966constructorimpl)) << 32) | (IntOffset.m6973getYimpl(jM6966constructorimpl) & 4294967295L))), f, (k) null);
            }
        }

        /* renamed from: placeRelative-70tqf50, reason: not valid java name */
        public final void m5628placeRelative70tqf50(Placeable placeable, long j5, float f) {
            if (getParentLayoutDirection() == LayoutDirection.Ltr || getParentWidth() == 0) {
                placeable.mo5550placeAtf8xVGno(b.h(this, placeable, placeable, j5), f, (k) null);
                return;
            }
            placeable.mo5550placeAtf8xVGno(b.h(this, placeable, placeable, IntOffset.m6966constructorimpl((IntOffset.m6973getYimpl(j5) & 4294967295L) | (((getParentWidth() - placeable.getWidth()) - IntOffset.m6972getXimpl(j5)) << 32))), f, (k) null);
        }

        public final void placeRelativeWithLayer(Placeable placeable, int i, int i6, float f, k kVar) {
            long jM6966constructorimpl = IntOffset.m6966constructorimpl((i << 32) | (i6 & 4294967295L));
            if (getParentLayoutDirection() == LayoutDirection.Ltr || getParentWidth() == 0) {
                placeable.mo5550placeAtf8xVGno(b.h(this, placeable, placeable, jM6966constructorimpl), f, kVar);
            } else {
                placeable.mo5550placeAtf8xVGno(b.h(this, placeable, placeable, IntOffset.m6966constructorimpl((((getParentWidth() - placeable.getWidth()) - IntOffset.m6972getXimpl(jM6966constructorimpl)) << 32) | (IntOffset.m6973getYimpl(jM6966constructorimpl) & 4294967295L))), f, kVar);
            }
        }

        /* renamed from: placeRelativeWithLayer-aW-9-wM, reason: not valid java name */
        public final void m5629placeRelativeWithLayeraW9wM(Placeable placeable, long j5, float f, k kVar) {
            if (getParentLayoutDirection() == LayoutDirection.Ltr || getParentWidth() == 0) {
                placeable.mo5550placeAtf8xVGno(b.h(this, placeable, placeable, j5), f, kVar);
                return;
            }
            placeable.mo5550placeAtf8xVGno(b.h(this, placeable, placeable, IntOffset.m6966constructorimpl((IntOffset.m6973getYimpl(j5) & 4294967295L) | (((getParentWidth() - placeable.getWidth()) - IntOffset.m6972getXimpl(j5)) << 32))), f, kVar);
        }

        public final void placeWithLayer(Placeable placeable, int i, int i6, float f, k kVar) {
            placeable.mo5550placeAtf8xVGno(b.h(this, placeable, placeable, IntOffset.m6966constructorimpl((i6 & 4294967295L) | (i << 32))), f, kVar);
        }

        /* renamed from: placeWithLayer-aW-9-wM, reason: not valid java name */
        public final void m5631placeWithLayeraW9wM(Placeable placeable, long j5, float f, k kVar) {
            placeable.mo5550placeAtf8xVGno(b.h(this, placeable, placeable, j5), f, kVar);
        }

        public final void withMotionFrameOfReferencePlacement(k block) {
            this.motionFrameOfReferencePlacement = true;
            block.invoke(this);
            this.motionFrameOfReferencePlacement = false;
        }

        public static /* synthetic */ void placeRelativeWithLayer$default(PlacementScope placementScope, Placeable placeable, int i, int i6, GraphicsLayer graphicsLayer, float f, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeRelativeWithLayer");
            }
            if ((i10 & 8) != 0) {
                f = 0.0f;
            }
            placementScope.placeRelativeWithLayer(placeable, i, i6, graphicsLayer, f);
        }

        /* renamed from: placeRelativeWithLayer-aW-9-wM$default, reason: not valid java name */
        public static /* synthetic */ void m5620placeRelativeWithLayeraW9wM$default(PlacementScope placementScope, Placeable placeable, long j5, GraphicsLayer graphicsLayer, float f, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeRelativeWithLayer-aW-9-wM");
            }
            if ((i & 4) != 0) {
                f = 0.0f;
            }
            placementScope.m5630placeRelativeWithLayeraW9wM(placeable, j5, graphicsLayer, f);
        }

        public static /* synthetic */ void placeWithLayer$default(PlacementScope placementScope, Placeable placeable, int i, int i6, GraphicsLayer graphicsLayer, float f, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeWithLayer");
            }
            if ((i10 & 8) != 0) {
                f = 0.0f;
            }
            placementScope.placeWithLayer(placeable, i, i6, graphicsLayer, f);
        }

        /* renamed from: placeWithLayer-aW-9-wM$default, reason: not valid java name */
        public static /* synthetic */ void m5622placeWithLayeraW9wM$default(PlacementScope placementScope, Placeable placeable, long j5, GraphicsLayer graphicsLayer, float f, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeWithLayer-aW-9-wM");
            }
            if ((i & 4) != 0) {
                f = 0.0f;
            }
            placementScope.m5632placeWithLayeraW9wM(placeable, j5, graphicsLayer, f);
        }

        /* renamed from: placeApparentToRealOffset-aW-9-wM$ui_release, reason: not valid java name */
        public final void m5625placeApparentToRealOffsetaW9wM$ui_release(Placeable placeable, long j5, float f, GraphicsLayer graphicsLayer) {
            placeable.mo5614placeAtf8xVGno(b.h(this, placeable, placeable, j5), f, graphicsLayer);
        }

        /* renamed from: placeWithLayer-aW-9-wM, reason: not valid java name */
        public final void m5632placeWithLayeraW9wM(Placeable placeable, long j5, GraphicsLayer graphicsLayer, float f) {
            placeable.mo5614placeAtf8xVGno(b.h(this, placeable, placeable, j5), f, graphicsLayer);
        }

        public final void placeWithLayer(Placeable placeable, int i, int i6, GraphicsLayer graphicsLayer, float f) {
            placeable.mo5614placeAtf8xVGno(b.h(this, placeable, placeable, IntOffset.m6966constructorimpl((i6 & 4294967295L) | (i << 32))), f, graphicsLayer);
        }

        /* renamed from: placeAutoMirrored-aW-9-wM$ui_release, reason: not valid java name */
        public final void m5627placeAutoMirroredaW9wM$ui_release(Placeable placeable, long j5, float f, GraphicsLayer graphicsLayer) {
            if (getParentLayoutDirection() == LayoutDirection.Ltr || getParentWidth() == 0) {
                placeable.mo5614placeAtf8xVGno(b.h(this, placeable, placeable, j5), f, graphicsLayer);
                return;
            }
            placeable.mo5614placeAtf8xVGno(b.h(this, placeable, placeable, IntOffset.m6966constructorimpl((IntOffset.m6973getYimpl(j5) & 4294967295L) | (((getParentWidth() - placeable.getWidth()) - IntOffset.m6972getXimpl(j5)) << 32))), f, graphicsLayer);
        }

        /* renamed from: placeRelativeWithLayer-aW-9-wM, reason: not valid java name */
        public final void m5630placeRelativeWithLayeraW9wM(Placeable placeable, long j5, GraphicsLayer graphicsLayer, float f) {
            if (getParentLayoutDirection() == LayoutDirection.Ltr || getParentWidth() == 0) {
                placeable.mo5614placeAtf8xVGno(b.h(this, placeable, placeable, j5), f, graphicsLayer);
                return;
            }
            placeable.mo5614placeAtf8xVGno(b.h(this, placeable, placeable, IntOffset.m6966constructorimpl((IntOffset.m6973getYimpl(j5) & 4294967295L) | (((getParentWidth() - placeable.getWidth()) - IntOffset.m6972getXimpl(j5)) << 32))), f, graphicsLayer);
        }

        public final void placeRelativeWithLayer(Placeable placeable, int i, int i6, GraphicsLayer graphicsLayer, float f) {
            long jM6966constructorimpl = IntOffset.m6966constructorimpl((i << 32) | (i6 & 4294967295L));
            if (getParentLayoutDirection() == LayoutDirection.Ltr || getParentWidth() == 0) {
                placeable.mo5614placeAtf8xVGno(b.h(this, placeable, placeable, jM6966constructorimpl), f, graphicsLayer);
            } else {
                placeable.mo5614placeAtf8xVGno(b.h(this, placeable, placeable, IntOffset.m6966constructorimpl((((getParentWidth() - placeable.getWidth()) - IntOffset.m6972getXimpl(jM6966constructorimpl)) << 32) | (IntOffset.m6973getYimpl(jM6966constructorimpl) & 4294967295L))), f, graphicsLayer);
            }
        }
    }
}
