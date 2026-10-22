package androidx.compose.ui.layout;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.node.MotionReferencePlacementDelegate;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpRect;
import androidx.compose.ui.unit.FontScaling;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.RangesKt;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b'\u0018\u00002\u00020\u0001:\u0001,B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0016\u001a\u00020\u0017H\u0002J:\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0019\u0010\u001d\u001a\u0015\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u001e¢\u0006\u0002\b H$¢\u0006\u0004\b!\u0010\"J'\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020$H\u0014¢\u0006\u0004\b!\u0010%R\u001e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\bR\u0014\u0010\r\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\bR&\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u000f@DX\u0084\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R&\u0010'\u001a\u00020&2\u0006\u0010\u0004\u001a\u00020&@DX\u0084\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b(\u0010\u0012\"\u0004\b)\u0010\u0014R \u0010*\u001a\u00020\u001a2\u0006\u0010\u0004\u001a\u00020\u001a@BX\u0084\u000e¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b+\u0010\u0012¨\u0006-"}, d2 = {"Landroidx/compose/ui/layout/Placeable;", "Landroidx/compose/ui/layout/Measured;", "<init>", "()V", "value", "", "width", "getWidth", "()I", "height", "getHeight", "measuredWidth", "getMeasuredWidth", "measuredHeight", "getMeasuredHeight", "Landroidx/compose/ui/unit/IntSize;", "measuredSize", "getMeasuredSize-YbymL2g", "()J", "setMeasuredSize-ozmzZPI", "(J)V", "J", "onMeasuredSizeChanged", "", "placeAt", "position", "Landroidx/compose/ui/unit/IntOffset;", "zIndex", "", "layerBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "Lkotlin/ExtensionFunctionType;", "placeAt-f8xVGno", "(JFLkotlin/jvm/functions/Function1;)V", GXTemplateKey.GAIAX_LAYER, "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "(JFLandroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "Landroidx/compose/ui/unit/Constraints;", "measurementConstraints", "getMeasurementConstraints-msEJaDk", "setMeasurementConstraints-BRTryo0", "apparentToRealOffset", "getApparentToRealOffset-nOcc-ac", "PlacementScope", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class Placeable implements Measured {
    public static final int $stable = 8;
    private long apparentToRealOffset;
    private int height;
    private long measuredSize;
    private long measurementConstraints;
    private int width;

    @Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0016\u001a\u00020\u0005*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0005H\u0016J#\u0010\u0019\u001a\u00020\u001a*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u0005¢\u0006\u0004\b\u001f\u0010 J$\u0010\u0019\u001a\u00020\u001a*\u00020\u001b2\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u000b2\b\b\u0002\u0010\u001e\u001a\u00020\u0005J$\u0010#\u001a\u00020\u001a*\u00020\u001b2\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u000b2\b\b\u0002\u0010\u001e\u001a\u00020\u0005J#\u0010#\u001a\u00020\u001a*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u0005¢\u0006\u0004\b$\u0010 J>\u0010%\u001a\u00020\u001a*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u00052\u0019\b\u0002\u0010&\u001a\u0013\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u001a0'¢\u0006\u0002\b)¢\u0006\u0004\b*\u0010+J?\u0010%\u001a\u00020\u001a*\u00020\u001b2\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u000b2\b\b\u0002\u0010\u001e\u001a\u00020\u00052\u0019\b\u0002\u0010&\u001a\u0013\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u001a0'¢\u0006\u0002\b)J?\u0010,\u001a\u00020\u001a*\u00020\u001b2\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u000b2\b\b\u0002\u0010\u001e\u001a\u00020\u00052\u0019\b\u0002\u0010&\u001a\u0013\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u001a0'¢\u0006\u0002\b)J>\u0010,\u001a\u00020\u001a*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u00052\u0019\b\u0002\u0010&\u001a\u0013\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u001a0'¢\u0006\u0002\b)¢\u0006\u0004\b-\u0010+J,\u0010,\u001a\u00020\u001a*\u00020\u001b2\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020/2\b\b\u0002\u0010\u001e\u001a\u00020\u0005J+\u0010,\u001a\u00020\u001a*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010.\u001a\u00020/2\b\b\u0002\u0010\u001e\u001a\u00020\u0005¢\u0006\u0004\b-\u00100J,\u0010%\u001a\u00020\u001a*\u00020\u001b2\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020/2\b\b\u0002\u0010\u001e\u001a\u00020\u0005J+\u0010%\u001a\u00020\u001a*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010.\u001a\u00020/2\b\b\u0002\u0010\u001e\u001a\u00020\u0005¢\u0006\u0004\b*\u00100JA\u00101\u001a\u00020\u001a*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00052\u001b\b\b\u0010&\u001a\u0015\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u001a\u0018\u00010'¢\u0006\u0002\b)H\u0080\b¢\u0006\u0004\b2\u0010+J,\u00101\u001a\u00020\u001a*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010.\u001a\u00020/H\u0080\b¢\u0006\u0004\b2\u00103JA\u00104\u001a\u00020\u001a*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00052\u001b\b\b\u0010&\u001a\u0015\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u001a\u0018\u00010'¢\u0006\u0002\b)H\u0080\b¢\u0006\u0004\b5\u0010+J,\u00104\u001a\u00020\u001a*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010.\u001a\u00020/H\u0080\b¢\u0006\u0004\b5\u00103J\u001f\u00108\u001a\u00020\u001a2\u0017\u00109\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u001a0'¢\u0006\u0002\b)J\f\u0010:\u001a\u00020\u001a*\u00020\u001bH\u0002R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u0012\u0010\n\u001a\u00020\u000bX¤\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000fX¤\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u000e\u00106\u001a\u000207X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Landroidx/compose/ui/layout/Placeable$PlacementScope;", "Landroidx/compose/ui/unit/Density;", "<init>", "()V", "density", "", "getDensity", "()F", "fontScale", "getFontScale", "parentWidth", "", "getParentWidth", "()I", "parentLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getParentLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "current", "Landroidx/compose/ui/layout/Ruler;", "defaultValue", "placeRelative", "", "Landroidx/compose/ui/layout/Placeable;", "position", "Landroidx/compose/ui/unit/IntOffset;", "zIndex", "placeRelative-70tqf50", "(Landroidx/compose/ui/layout/Placeable;JF)V", "x", "y", "place", "place-70tqf50", "placeRelativeWithLayer", "layerBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "Lkotlin/ExtensionFunctionType;", "placeRelativeWithLayer-aW-9-wM", "(Landroidx/compose/ui/layout/Placeable;JFLkotlin/jvm/functions/Function1;)V", "placeWithLayer", "placeWithLayer-aW-9-wM", GXTemplateKey.GAIAX_LAYER, "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "(Landroidx/compose/ui/layout/Placeable;JLandroidx/compose/ui/graphics/layer/GraphicsLayer;F)V", "placeAutoMirrored", "placeAutoMirrored-aW-9-wM$ui_release", "(Landroidx/compose/ui/layout/Placeable;JFLandroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "placeApparentToRealOffset", "placeApparentToRealOffset-aW-9-wM$ui_release", "motionFrameOfReferencePlacement", "", "withMotionFrameOfReferencePlacement", "block", "handleMotionFrameOfReferencePlacement", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @PlacementScopeMarker
    public static abstract class PlacementScope implements Density {
        public static final int $stable = 0;
        private boolean motionFrameOfReferencePlacement;

        public PlacementScope() {
        }

        public float current(Ruler r100, float r101) {
            return r101;
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

        @Override // androidx.compose.ui.unit.Density
        /* JADX INFO: renamed from: roundToPx--R2X_6o */
        public final /* synthetic */ int mo364roundToPxR2X_6o(long r100) {
            return Density.CC.m7508$default$roundToPxR2X_6o(this, r100);
        }

        @Override // androidx.compose.ui.unit.Density
        /* JADX INFO: renamed from: roundToPx-0680j_4 */
        public final /* synthetic */ int mo365roundToPx0680j_4(float r100) {
            return Density.CC.m7509$default$roundToPx0680j_4(this, r100);
        }

        @Override // androidx.compose.ui.unit.FontScaling
        /* JADX INFO: renamed from: toDp-GaN1DYA */
        public final /* synthetic */ float mo366toDpGaN1DYA(long r100) {
            return FontScaling.CC.m7653$default$toDpGaN1DYA(this, r100);
        }

        @Override // androidx.compose.ui.unit.Density
        /* JADX INFO: renamed from: toDp-u2uoSUM */
        public final /* synthetic */ float mo367toDpu2uoSUM(float r100) {
            return Density.CC.m7510$default$toDpu2uoSUM(this, r100);
        }

        @Override // androidx.compose.ui.unit.Density
        /* JADX INFO: renamed from: toDp-u2uoSUM */
        public final /* synthetic */ float mo368toDpu2uoSUM(int r100) {
            return Density.CC.m7511$default$toDpu2uoSUM(this, r100);
        }

        @Override // androidx.compose.ui.unit.Density
        /* JADX INFO: renamed from: toDpSize-k-rfVVM */
        public final /* synthetic */ long mo369toDpSizekrfVVM(long r100) {
            return Density.CC.m7512$default$toDpSizekrfVVM(this, r100);
        }

        @Override // androidx.compose.ui.unit.Density
        /* JADX INFO: renamed from: toPx--R2X_6o */
        public final /* synthetic */ float mo370toPxR2X_6o(long r100) {
            return Density.CC.m7513$default$toPxR2X_6o(this, r100);
        }

        @Override // androidx.compose.ui.unit.Density
        /* JADX INFO: renamed from: toPx-0680j_4 */
        public final /* synthetic */ float mo371toPx0680j_4(float r100) {
            return Density.CC.m7514$default$toPx0680j_4(this, r100);
        }

        @Override // androidx.compose.ui.unit.Density
        public final /* synthetic */ Rect toRect(DpRect r100) {
            return Density.CC.$default$toRect(this, r100);
        }

        @Override // androidx.compose.ui.unit.Density
        /* JADX INFO: renamed from: toSize-XkaWNTQ */
        public final /* synthetic */ long mo372toSizeXkaWNTQ(long r100) {
            return Density.CC.m7515$default$toSizeXkaWNTQ(this, r100);
        }

        @Override // androidx.compose.ui.unit.FontScaling
        /* JADX INFO: renamed from: toSp-0xMU5do */
        public final /* synthetic */ long mo373toSp0xMU5do(float r100) {
            return FontScaling.CC.m7654$default$toSp0xMU5do(this, r100);
        }

        @Override // androidx.compose.ui.unit.Density
        /* JADX INFO: renamed from: toSp-kPz2Gy4 */
        public final /* synthetic */ long mo374toSpkPz2Gy4(float r100) {
            return Density.CC.m7516$default$toSpkPz2Gy4(this, r100);
        }

        @Override // androidx.compose.ui.unit.Density
        /* JADX INFO: renamed from: toSp-kPz2Gy4 */
        public final /* synthetic */ long mo375toSpkPz2Gy4(int r100) {
            return Density.CC.m7517$default$toSpkPz2Gy4(this, r100);
        }

        public static final /* synthetic */ LayoutDirection access$getParentLayoutDirection(PlacementScope r100) {
            return r100.getParentLayoutDirection();
        }

        public static final /* synthetic */ int access$getParentWidth(PlacementScope r100) {
            return r100.getParentWidth();
        }

        /* JADX WARN: Multi-variable type inference failed */
        private final void handleMotionFrameOfReferencePlacement(Placeable r100) {
            if ((r100 instanceof MotionReferencePlacementDelegate) == false) goto L6;
            ((MotionReferencePlacementDelegate) r100).updatePlacedUnderMotionFrameOfReference(this.motionFrameOfReferencePlacement);
            return;
        }

        public final void withMotionFrameOfReferencePlacement(Function1<? super PlacementScope, Unit> r100) {
            this.motionFrameOfReferencePlacement = true;
            r100.invoke(this);
            this.motionFrameOfReferencePlacement = false;
        }

        public static final /* synthetic */ void access$handleMotionFrameOfReferencePlacement(PlacementScope r100, Placeable r101) {
            r100.handleMotionFrameOfReferencePlacement(r101);
        }

        /* JADX INFO: renamed from: place-70tqf50, reason: not valid java name */
        public final void m6333place70tqf50(Placeable r100, long r101, float r102) {
            access$handleMotionFrameOfReferencePlacement(this, r100);
            Placeable.m6320access$placeAtf8xVGno(r100, IntOffset.m7680plusqkQi6aY(r101, Placeable.m6318access$getApparentToRealOffsetnOccac(r100)), r102, null);
        }

        /* JADX INFO: renamed from: placeRelative-70tqf50, reason: not valid java name */
        public final void m6338placeRelative70tqf50(Placeable r100, long r101, float r102) {
            if (access$getParentLayoutDirection(this) != LayoutDirection.Ltr) goto L5;
        L8:
            access$handleMotionFrameOfReferencePlacement(this, r100);
            Placeable.m6320access$placeAtf8xVGno(r100, IntOffset.m7680plusqkQi6aY(r101, Placeable.m6318access$getApparentToRealOffsetnOccac(r100)), r102, null);
            return;
        L5:
            if (access$getParentWidth(this) == 0) goto L8;
            int r103 = (access$getParentWidth(this) - r100.getWidth()) - IntOffset.m7676getXimpl(r101);
            long r104 = ((long) IntOffset.m7677getYimpl(r101)) & BodyPartID.bodyIdMax;
            long r105 = IntOffset.m7670constructorimpl(r104 | (((long) r103) << 32));
            access$handleMotionFrameOfReferencePlacement(this, r100);
            Placeable.m6320access$placeAtf8xVGno(r100, IntOffset.m7680plusqkQi6aY(r105, Placeable.m6318access$getApparentToRealOffsetnOccac(r100)), r102, null);
        }

        public final void place(Placeable r100, int r101, int r102, float r103) {
            long r104 = ((long) r101) << 32;
            long r105 = IntOffset.m7670constructorimpl((((long) r102) & BodyPartID.bodyIdMax) | r104);
            access$handleMotionFrameOfReferencePlacement(this, r100);
            Placeable.m6320access$placeAtf8xVGno(r100, IntOffset.m7680plusqkQi6aY(r105, Placeable.m6318access$getApparentToRealOffsetnOccac(r100)), r103, null);
        }

        /* JADX INFO: renamed from: placeApparentToRealOffset-aW-9-wM$ui_release, reason: not valid java name */
        public final void m6334placeApparentToRealOffsetaW9wM$ui_release(Placeable r100, long r101, float r102, GraphicsLayer r103) {
            access$handleMotionFrameOfReferencePlacement(this, r100);
            Placeable.m6319access$placeAtf8xVGno(r100, IntOffset.m7680plusqkQi6aY(r101, Placeable.m6318access$getApparentToRealOffsetnOccac(r100)), r102, r103);
        }

        /* JADX INFO: renamed from: placeAutoMirrored-aW-9-wM$ui_release, reason: not valid java name */
        public final void m6336placeAutoMirroredaW9wM$ui_release(Placeable r100, long r101, float r102, GraphicsLayer r103) {
            if (access$getParentLayoutDirection(this) != LayoutDirection.Ltr) goto L5;
        L8:
            access$handleMotionFrameOfReferencePlacement(this, r100);
            Placeable.m6319access$placeAtf8xVGno(r100, IntOffset.m7680plusqkQi6aY(r101, Placeable.m6318access$getApparentToRealOffsetnOccac(r100)), r102, r103);
            return;
        L5:
            if (access$getParentWidth(this) == 0) goto L8;
            int r104 = (access$getParentWidth(this) - r100.getWidth()) - IntOffset.m7676getXimpl(r101);
            long r105 = ((long) IntOffset.m7677getYimpl(r101)) & BodyPartID.bodyIdMax;
            long r106 = IntOffset.m7670constructorimpl(r105 | (((long) r104) << 32));
            access$handleMotionFrameOfReferencePlacement(this, r100);
            Placeable.m6319access$placeAtf8xVGno(r100, IntOffset.m7680plusqkQi6aY(r106, Placeable.m6318access$getApparentToRealOffsetnOccac(r100)), r102, r103);
        }

        public final void placeRelative(Placeable r100, int r101, int r102, float r110) {
            long r103 = IntOffset.m7670constructorimpl((((long) r101) << 32) | (((long) r102) & BodyPartID.bodyIdMax));
            if (access$getParentLayoutDirection(this) != LayoutDirection.Ltr) goto L5;
        L8:
            access$handleMotionFrameOfReferencePlacement(this, r100);
            Placeable.m6320access$placeAtf8xVGno(r100, IntOffset.m7680plusqkQi6aY(r103, Placeable.m6318access$getApparentToRealOffsetnOccac(r100)), r110, null);
            return;
        L5:
            if (access$getParentWidth(this) == 0) goto L8;
            int r104 = (access$getParentWidth(this) - r100.getWidth()) - IntOffset.m7676getXimpl(r103);
            long r105 = IntOffset.m7670constructorimpl((((long) r104) << 32) | (((long) IntOffset.m7677getYimpl(r103)) & BodyPartID.bodyIdMax));
            access$handleMotionFrameOfReferencePlacement(this, r100);
            Placeable.m6320access$placeAtf8xVGno(r100, IntOffset.m7680plusqkQi6aY(r105, Placeable.m6318access$getApparentToRealOffsetnOccac(r100)), r110, null);
        }

        /* JADX INFO: renamed from: placeRelativeWithLayer-aW-9-wM, reason: not valid java name */
        public final void m6339placeRelativeWithLayeraW9wM(Placeable r100, long r101, float r102, Function1<? super GraphicsLayerScope, Unit> r103) {
            if (access$getParentLayoutDirection(this) != LayoutDirection.Ltr) goto L5;
        L8:
            access$handleMotionFrameOfReferencePlacement(this, r100);
            Placeable.m6320access$placeAtf8xVGno(r100, IntOffset.m7680plusqkQi6aY(r101, Placeable.m6318access$getApparentToRealOffsetnOccac(r100)), r102, r103);
            return;
        L5:
            if (access$getParentWidth(this) == 0) goto L8;
            int r104 = (access$getParentWidth(this) - r100.getWidth()) - IntOffset.m7676getXimpl(r101);
            long r105 = ((long) IntOffset.m7677getYimpl(r101)) & BodyPartID.bodyIdMax;
            long r106 = IntOffset.m7670constructorimpl(r105 | (((long) r104) << 32));
            access$handleMotionFrameOfReferencePlacement(this, r100);
            Placeable.m6320access$placeAtf8xVGno(r100, IntOffset.m7680plusqkQi6aY(r106, Placeable.m6318access$getApparentToRealOffsetnOccac(r100)), r102, r103);
        }

        /* JADX INFO: renamed from: placeWithLayer-aW-9-wM, reason: not valid java name */
        public final void m6341placeWithLayeraW9wM(Placeable r100, long r101, float r102, Function1<? super GraphicsLayerScope, Unit> r103) {
            access$handleMotionFrameOfReferencePlacement(this, r100);
            Placeable.m6320access$placeAtf8xVGno(r100, IntOffset.m7680plusqkQi6aY(r101, Placeable.m6318access$getApparentToRealOffsetnOccac(r100)), r102, r103);
        }

        /* JADX INFO: renamed from: placeApparentToRealOffset-aW-9-wM$ui_release, reason: not valid java name */
        public final void m6335placeApparentToRealOffsetaW9wM$ui_release(Placeable r100, long r101, float r102, Function1<? super GraphicsLayerScope, Unit> r103) {
            access$handleMotionFrameOfReferencePlacement(this, r100);
            Placeable.m6320access$placeAtf8xVGno(r100, IntOffset.m7680plusqkQi6aY(r101, Placeable.m6318access$getApparentToRealOffsetnOccac(r100)), r102, r103);
        }

        /* JADX INFO: renamed from: placeAutoMirrored-aW-9-wM$ui_release, reason: not valid java name */
        public final void m6337placeAutoMirroredaW9wM$ui_release(Placeable r100, long r101, float r102, Function1<? super GraphicsLayerScope, Unit> r103) {
            if (access$getParentLayoutDirection(this) != LayoutDirection.Ltr) goto L5;
        L8:
            access$handleMotionFrameOfReferencePlacement(this, r100);
            Placeable.m6320access$placeAtf8xVGno(r100, IntOffset.m7680plusqkQi6aY(r101, Placeable.m6318access$getApparentToRealOffsetnOccac(r100)), r102, r103);
            return;
        L5:
            if (access$getParentWidth(this) == 0) goto L8;
            int r104 = (access$getParentWidth(this) - r100.getWidth()) - IntOffset.m7676getXimpl(r101);
            long r105 = ((long) IntOffset.m7677getYimpl(r101)) & BodyPartID.bodyIdMax;
            long r106 = IntOffset.m7670constructorimpl(r105 | (((long) r104) << 32));
            access$handleMotionFrameOfReferencePlacement(this, r100);
            Placeable.m6320access$placeAtf8xVGno(r100, IntOffset.m7680plusqkQi6aY(r106, Placeable.m6318access$getApparentToRealOffsetnOccac(r100)), r102, r103);
        }

        /* JADX INFO: renamed from: placeRelativeWithLayer-aW-9-wM, reason: not valid java name */
        public final void m6340placeRelativeWithLayeraW9wM(Placeable r100, long r101, GraphicsLayer r102, float r103) {
            if (access$getParentLayoutDirection(this) != LayoutDirection.Ltr) goto L5;
        L8:
            access$handleMotionFrameOfReferencePlacement(this, r100);
            Placeable.m6319access$placeAtf8xVGno(r100, IntOffset.m7680plusqkQi6aY(r101, Placeable.m6318access$getApparentToRealOffsetnOccac(r100)), r103, r102);
            return;
        L5:
            if (access$getParentWidth(this) == 0) goto L8;
            int r104 = (access$getParentWidth(this) - r100.getWidth()) - IntOffset.m7676getXimpl(r101);
            long r105 = ((long) IntOffset.m7677getYimpl(r101)) & BodyPartID.bodyIdMax;
            long r106 = IntOffset.m7670constructorimpl(r105 | (((long) r104) << 32));
            access$handleMotionFrameOfReferencePlacement(this, r100);
            Placeable.m6319access$placeAtf8xVGno(r100, IntOffset.m7680plusqkQi6aY(r106, Placeable.m6318access$getApparentToRealOffsetnOccac(r100)), r103, r102);
        }

        /* JADX INFO: renamed from: placeWithLayer-aW-9-wM, reason: not valid java name */
        public final void m6342placeWithLayeraW9wM(Placeable r100, long r101, GraphicsLayer r102, float r103) {
            access$handleMotionFrameOfReferencePlacement(this, r100);
            Placeable.m6319access$placeAtf8xVGno(r100, IntOffset.m7680plusqkQi6aY(r101, Placeable.m6318access$getApparentToRealOffsetnOccac(r100)), r103, r102);
        }

        public final void placeRelativeWithLayer(Placeable r100, int r101, int r102, float r110, Function1<? super GraphicsLayerScope, Unit> r111) {
            long r103 = IntOffset.m7670constructorimpl((((long) r101) << 32) | (((long) r102) & BodyPartID.bodyIdMax));
            if (access$getParentLayoutDirection(this) != LayoutDirection.Ltr) goto L5;
        L8:
            access$handleMotionFrameOfReferencePlacement(this, r100);
            Placeable.m6320access$placeAtf8xVGno(r100, IntOffset.m7680plusqkQi6aY(r103, Placeable.m6318access$getApparentToRealOffsetnOccac(r100)), r110, r111);
            return;
        L5:
            if (access$getParentWidth(this) == 0) goto L8;
            int r104 = (access$getParentWidth(this) - r100.getWidth()) - IntOffset.m7676getXimpl(r103);
            long r105 = IntOffset.m7670constructorimpl((((long) r104) << 32) | (((long) IntOffset.m7677getYimpl(r103)) & BodyPartID.bodyIdMax));
            access$handleMotionFrameOfReferencePlacement(this, r100);
            Placeable.m6320access$placeAtf8xVGno(r100, IntOffset.m7680plusqkQi6aY(r105, Placeable.m6318access$getApparentToRealOffsetnOccac(r100)), r110, r111);
        }

        public final void placeWithLayer(Placeable r100, int r101, int r102, float r103, Function1<? super GraphicsLayerScope, Unit> r104) {
            long r105 = ((long) r101) << 32;
            long r106 = IntOffset.m7670constructorimpl((((long) r102) & BodyPartID.bodyIdMax) | r105);
            access$handleMotionFrameOfReferencePlacement(this, r100);
            Placeable.m6320access$placeAtf8xVGno(r100, IntOffset.m7680plusqkQi6aY(r106, Placeable.m6318access$getApparentToRealOffsetnOccac(r100)), r103, r104);
        }

        public final void placeRelativeWithLayer(Placeable r100, int r101, int r102, GraphicsLayer r110, float r111) {
            long r103 = IntOffset.m7670constructorimpl((((long) r101) << 32) | (((long) r102) & BodyPartID.bodyIdMax));
            if (access$getParentLayoutDirection(this) != LayoutDirection.Ltr) goto L5;
        L8:
            access$handleMotionFrameOfReferencePlacement(this, r100);
            Placeable.m6319access$placeAtf8xVGno(r100, IntOffset.m7680plusqkQi6aY(r103, Placeable.m6318access$getApparentToRealOffsetnOccac(r100)), r111, r110);
            return;
        L5:
            if (access$getParentWidth(this) == 0) goto L8;
            int r104 = (access$getParentWidth(this) - r100.getWidth()) - IntOffset.m7676getXimpl(r103);
            long r105 = IntOffset.m7670constructorimpl((((long) r104) << 32) | (((long) IntOffset.m7677getYimpl(r103)) & BodyPartID.bodyIdMax));
            access$handleMotionFrameOfReferencePlacement(this, r100);
            Placeable.m6319access$placeAtf8xVGno(r100, IntOffset.m7680plusqkQi6aY(r105, Placeable.m6318access$getApparentToRealOffsetnOccac(r100)), r111, r110);
        }

        public final void placeWithLayer(Placeable r100, int r101, int r102, GraphicsLayer r103, float r104) {
            long r105 = ((long) r101) << 32;
            long r106 = IntOffset.m7670constructorimpl((((long) r102) & BodyPartID.bodyIdMax) | r105);
            access$handleMotionFrameOfReferencePlacement(this, r100);
            Placeable.m6319access$placeAtf8xVGno(r100, IntOffset.m7680plusqkQi6aY(r106, Placeable.m6318access$getApparentToRealOffsetnOccac(r100)), r104, r103);
        }

        /* JADX INFO: renamed from: place-70tqf50$default, reason: not valid java name */
        public static /* synthetic */ void m6327place70tqf50$default(PlacementScope r100, Placeable r101, long r102, float r103, int r104, Object r105) {
            if (r105 != null) goto L9;
            if ((r104 & 2) == 0) goto L6;
            r103 = 0.0f;
        L6:
            r100.m6333place70tqf50(r101, r102, r103);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: place-70tqf50");
        }

        /* JADX INFO: renamed from: placeRelative-70tqf50$default, reason: not valid java name */
        public static /* synthetic */ void m6328placeRelative70tqf50$default(PlacementScope r100, Placeable r101, long r102, float r103, int r104, Object r105) {
            if (r105 != null) goto L9;
            if ((r104 & 2) == 0) goto L6;
            r103 = 0.0f;
        L6:
            r100.m6338placeRelative70tqf50(r101, r102, r103);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeRelative-70tqf50");
        }

        public static /* synthetic */ void place$default(PlacementScope r100, Placeable r101, int r102, int r103, float r104, int r105, Object r106) {
            if (r106 != null) goto L9;
            if ((r105 & 4) == 0) goto L6;
            r104 = 0.0f;
        L6:
            r100.place(r101, r102, r103, r104);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: place");
        }

        public static /* synthetic */ void placeRelative$default(PlacementScope r100, Placeable r101, int r102, int r103, float r104, int r105, Object r106) {
            if (r106 != null) goto L9;
            if ((r105 & 4) == 0) goto L6;
            r104 = 0.0f;
        L6:
            r100.placeRelative(r101, r102, r103, r104);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeRelative");
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: renamed from: placeRelativeWithLayer-aW-9-wM$default, reason: not valid java name */
        public static /* synthetic */ void m6329placeRelativeWithLayeraW9wM$default(PlacementScope r100, Placeable r101, long r102, float r110, Function1 r111, int r112, Object r113) {
            if (r113 != null) goto L13;
            if ((r112 & 2) == 0) goto L6;
            float r103 = 0.0f;
        L8:
            if ((r112 & 4) == 0) goto L10;
            r111 = PlaceableKt.access$getDefaultLayerBlock$p();
        L10:
            r100.m6339placeRelativeWithLayeraW9wM(r101, r102, r103, r111);
            return;
        L6:
            r103 = r110;
            goto L8
        L13:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeRelativeWithLayer-aW-9-wM");
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: renamed from: placeWithLayer-aW-9-wM$default, reason: not valid java name */
        public static /* synthetic */ void m6331placeWithLayeraW9wM$default(PlacementScope r100, Placeable r101, long r102, float r110, Function1 r111, int r112, Object r113) {
            if (r113 != null) goto L13;
            if ((r112 & 2) == 0) goto L6;
            float r103 = 0.0f;
        L8:
            if ((r112 & 4) == 0) goto L10;
            r111 = PlaceableKt.access$getDefaultLayerBlock$p();
        L10:
            r100.m6341placeWithLayeraW9wM(r101, r102, r103, r111);
            return;
        L6:
            r103 = r110;
            goto L8
        L13:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeWithLayer-aW-9-wM");
        }

        /* JADX INFO: renamed from: placeRelativeWithLayer-aW-9-wM$default, reason: not valid java name */
        public static /* synthetic */ void m6330placeRelativeWithLayeraW9wM$default(PlacementScope r100, Placeable r101, long r102, GraphicsLayer r110, float r111, int r112, Object r113) {
            if (r113 != null) goto L10;
            if ((r112 & 4) == 0) goto L6;
            float r103 = 0.0f;
        L7:
            r100.m6340placeRelativeWithLayeraW9wM(r101, r102, r110, r103);
            return;
        L6:
            r103 = r111;
            goto L7
        L10:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeRelativeWithLayer-aW-9-wM");
        }

        /* JADX INFO: renamed from: placeWithLayer-aW-9-wM$default, reason: not valid java name */
        public static /* synthetic */ void m6332placeWithLayeraW9wM$default(PlacementScope r100, Placeable r101, long r102, GraphicsLayer r110, float r111, int r112, Object r113) {
            if (r113 != null) goto L10;
            if ((r112 & 4) == 0) goto L6;
            float r103 = 0.0f;
        L7:
            r100.m6342placeWithLayeraW9wM(r101, r102, r110, r103);
            return;
        L6:
            r103 = r111;
            goto L7
        L10:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeWithLayer-aW-9-wM");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void placeRelativeWithLayer$default(PlacementScope r100, Placeable r101, int r102, int r103, float r110, Function1 r111, int r112, Object r113) {
            if (r113 != null) goto L13;
            if ((r112 & 4) == 0) goto L6;
            float r104 = 0.0f;
        L8:
            if ((r112 & 8) == 0) goto L10;
            r111 = PlaceableKt.access$getDefaultLayerBlock$p();
        L10:
            r100.placeRelativeWithLayer(r101, r102, r103, r104, r111);
            return;
        L6:
            r104 = r110;
            goto L8
        L13:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeRelativeWithLayer");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void placeWithLayer$default(PlacementScope r100, Placeable r101, int r102, int r103, float r110, Function1 r111, int r112, Object r113) {
            if (r113 != null) goto L13;
            if ((r112 & 4) == 0) goto L6;
            float r104 = 0.0f;
        L8:
            if ((r112 & 8) == 0) goto L10;
            r111 = PlaceableKt.access$getDefaultLayerBlock$p();
        L10:
            r100.placeWithLayer(r101, r102, r103, r104, r111);
            return;
        L6:
            r104 = r110;
            goto L8
        L13:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeWithLayer");
        }

        public static /* synthetic */ void placeRelativeWithLayer$default(PlacementScope r100, Placeable r101, int r102, int r103, GraphicsLayer r110, float r111, int r112, Object r113) {
            if (r113 != null) goto L10;
            if ((r112 & 8) == 0) goto L6;
            float r104 = 0.0f;
        L7:
            r100.placeRelativeWithLayer(r101, r102, r103, r110, r104);
            return;
        L6:
            r104 = r111;
            goto L7
        L10:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeRelativeWithLayer");
        }

        public static /* synthetic */ void placeWithLayer$default(PlacementScope r100, Placeable r101, int r102, int r103, GraphicsLayer r110, float r111, int r112, Object r113) {
            if (r113 != null) goto L10;
            if ((r112 & 8) == 0) goto L6;
            float r104 = 0.0f;
        L7:
            r100.placeWithLayer(r101, r102, r103, r110, r104);
            return;
        L6:
            r104 = r111;
            goto L7
        L10:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: placeWithLayer");
        }
    }

    @Override // androidx.compose.ui.layout.Measured
    public /* synthetic */ Object getParentData() {
        return Measured.CC.$default$getParentData(this);
    }

    /* JADX INFO: renamed from: placeAt-f8xVGno */
    public abstract void mo6257placeAtf8xVGno(long r100, float r101, Function1<? super GraphicsLayerScope, Unit> r102);

    private final void onMeasuredSizeChanged() {
        this.width = RangesKt.coerceIn((int) (this.measuredSize >> 32), Constraints.m7489getMinWidthimpl(this.measurementConstraints), Constraints.m7487getMaxWidthimpl(this.measurementConstraints));
        int r100 = RangesKt.coerceIn((int) (this.measuredSize & BodyPartID.bodyIdMax), Constraints.m7488getMinHeightimpl(this.measurementConstraints), Constraints.m7486getMaxHeightimpl(this.measurementConstraints));
        this.height = r100;
        int r101 = this.width;
        long r102 = this.measuredSize;
        int r103 = (r101 - ((int) (r102 >> 32))) / 2;
        int r104 = (r100 - ((int) (r102 & BodyPartID.bodyIdMax))) / 2;
        this.apparentToRealOffset = IntOffset.m7670constructorimpl((((long) r103) << 32) | (BodyPartID.bodyIdMax & ((long) r104)));
    }

    @Override // androidx.compose.ui.layout.Measured
    public int getMeasuredHeight() {
        return (int) (this.measuredSize & BodyPartID.bodyIdMax);
    }

    @Override // androidx.compose.ui.layout.Measured
    public int getMeasuredWidth() {
        return (int) (this.measuredSize >> 32);
    }

    public Placeable() {
        long r100 = 0;
        this.measuredSize = IntSize.m7714constructorimpl((r100 & BodyPartID.bodyIdMax) | (r100 << 32));
        this.measurementConstraints = PlaceableKt.access$getDefaultConstraints$p();
        this.apparentToRealOffset = IntOffset.Companion.m7687getZeronOccac();
    }

    /* JADX INFO: renamed from: getApparentToRealOffset-nOcc-ac, reason: not valid java name */
    public final long m6321getApparentToRealOffsetnOccac() {
        return this.apparentToRealOffset;
    }

    public final int getHeight() {
        return this.height;
    }

    /* JADX INFO: renamed from: getMeasuredSize-YbymL2g, reason: not valid java name */
    public final long m6322getMeasuredSizeYbymL2g() {
        return this.measuredSize;
    }

    /* JADX INFO: renamed from: getMeasurementConstraints-msEJaDk, reason: not valid java name */
    public final long m6323getMeasurementConstraintsmsEJaDk() {
        return this.measurementConstraints;
    }

    public final int getWidth() {
        return this.width;
    }

    /* JADX INFO: renamed from: access$getApparentToRealOffset-nOcc-ac, reason: not valid java name */
    public static final /* synthetic */ long m6318access$getApparentToRealOffsetnOccac(Placeable r100) {
        return r100.apparentToRealOffset;
    }

    /* JADX INFO: renamed from: setMeasuredSize-ozmzZPI, reason: not valid java name */
    public final void m6325setMeasuredSizeozmzZPI(long r100) {
        if (IntSize.m7717equalsimpl0(this.measuredSize, r100) == true) goto L6;
        this.measuredSize = r100;
        onMeasuredSizeChanged();
        return;
    }

    /* JADX INFO: renamed from: setMeasurementConstraints-BRTryo0, reason: not valid java name */
    public final void m6326setMeasurementConstraintsBRTryo0(long r100) {
        if (Constraints.m7480equalsimpl0(this.measurementConstraints, r100) == true) goto L6;
        this.measurementConstraints = r100;
        onMeasuredSizeChanged();
        return;
    }

    /* JADX INFO: renamed from: placeAt-f8xVGno, reason: not valid java name */
    public void mo6324placeAtf8xVGno(long r100, float r101, GraphicsLayer r102) {
        mo6257placeAtf8xVGno(r100, r101, null);
    }

    /* JADX INFO: renamed from: access$placeAt-f8xVGno, reason: not valid java name */
    public static final /* synthetic */ void m6319access$placeAtf8xVGno(Placeable r100, long r101, float r102, GraphicsLayer r103) {
        r100.mo6324placeAtf8xVGno(r101, r102, r103);
    }

    /* JADX INFO: renamed from: access$placeAt-f8xVGno, reason: not valid java name */
    public static final /* synthetic */ void m6320access$placeAtf8xVGno(Placeable r100, long r101, float r102, Function1 r103) {
        r100.mo6257placeAtf8xVGno(r101, r102, r103);
    }
}
