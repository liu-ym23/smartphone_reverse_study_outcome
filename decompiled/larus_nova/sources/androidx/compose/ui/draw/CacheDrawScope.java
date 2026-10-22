package androidx.compose.ui.draw;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.shadow.ShadowContext;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpRect;
import androidx.compose.ui.unit.FontScaling;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010%\u001a\u00020&J\u0006\u0010'\u001a\u00020(JH\u0010)\u001a\u00020**\u00020&2\b\b\u0002\u0010+\u001a\u00020\u00012\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010\u001d\u001a\u00020,2\u0017\u0010-\u001a\u0013\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020*0.¢\u0006\u0002\b/¢\u0006\u0004\b0\u00101J\u001f\u00102\u001a\u00020\u000b2\u0017\u0010-\u001a\u0013\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020*0.¢\u0006\u0002\b/J\u001f\u00104\u001a\u00020\u000b2\u0017\u0010-\u001a\u0013\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020*0.¢\u0006\u0002\b/R\u001a\u0010\u0004\u001a\u00020\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0011\u0010\u001d\u001a\u00020\u001e8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0011\u0010!\u001a\u00020\"8F¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0014\u0010+\u001a\u0002058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b6\u00107R\u0014\u00108\u001a\u0002058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b9\u00107¨\u0006:"}, d2 = {"Landroidx/compose/ui/draw/CacheDrawScope;", "Landroidx/compose/ui/unit/Density;", "<init>", "()V", "cacheParams", "Landroidx/compose/ui/draw/BuildDrawCacheParams;", "getCacheParams$ui_release", "()Landroidx/compose/ui/draw/BuildDrawCacheParams;", "setCacheParams$ui_release", "(Landroidx/compose/ui/draw/BuildDrawCacheParams;)V", "drawResult", "Landroidx/compose/ui/draw/DrawResult;", "getDrawResult$ui_release", "()Landroidx/compose/ui/draw/DrawResult;", "setDrawResult$ui_release", "(Landroidx/compose/ui/draw/DrawResult;)V", "contentDrawScope", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "getContentDrawScope$ui_release", "()Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "setContentDrawScope$ui_release", "(Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;)V", "graphicsContextProvider", "Lkotlin/Function0;", "Landroidx/compose/ui/graphics/GraphicsContext;", "getGraphicsContextProvider$ui_release", "()Lkotlin/jvm/functions/Function0;", "setGraphicsContextProvider$ui_release", "(Lkotlin/jvm/functions/Function0;)V", "size", "Landroidx/compose/ui/geometry/Size;", "getSize-NH-jbRc", "()J", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "obtainGraphicsLayer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "obtainShadowContext", "Landroidx/compose/ui/graphics/shadow/ShadowContext;", "record", "", "density", "Landroidx/compose/ui/unit/IntSize;", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "record-TdoYBX4", "(Landroidx/compose/ui/graphics/layer/GraphicsLayer;Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;JLkotlin/jvm/functions/Function1;)V", "onDrawBehind", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "onDrawWithContent", "", "getDensity", "()F", "fontScale", "getFontScale", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CacheDrawScope implements Density {
    public static final int $stable = 0;
    private BuildDrawCacheParams cacheParams;
    private ContentDrawScope contentDrawScope;
    private DrawResult drawResult;
    private Function0<? extends GraphicsContext> graphicsContextProvider;

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

    @Override // androidx.compose.ui.unit.Density
    public float getDensity() {
        return this.cacheParams.getDensity().getDensity();
    }

    @Override // androidx.compose.ui.unit.FontScaling
    public float getFontScale() {
        return this.cacheParams.getDensity().getFontScale();
    }

    public final LayoutDirection getLayoutDirection() {
        return this.cacheParams.getLayoutDirection();
    }

    /* JADX INFO: renamed from: getSize-NH-jbRc, reason: not valid java name */
    public final long m4366getSizeNHjbRc() {
        return this.cacheParams.mo4364getSizeNHjbRc();
    }

    public final GraphicsLayer obtainGraphicsLayer() {
        Function0<? extends GraphicsContext> r100 = this.graphicsContextProvider;
        Intrinsics.checkNotNull(r100);
        return r100.invoke().createGraphicsLayer();
    }

    public final ShadowContext obtainShadowContext() {
        Function0<? extends GraphicsContext> r100 = this.graphicsContextProvider;
        Intrinsics.checkNotNull(r100);
        return r100.invoke().getShadowContext();
    }

    public CacheDrawScope() {
        this.cacheParams = EmptyBuildDrawCacheParams.INSTANCE;
    }

    public final BuildDrawCacheParams getCacheParams$ui_release() {
        return this.cacheParams;
    }

    public final ContentDrawScope getContentDrawScope$ui_release() {
        return this.contentDrawScope;
    }

    public final DrawResult getDrawResult$ui_release() {
        return this.drawResult;
    }

    public final Function0<GraphicsContext> getGraphicsContextProvider$ui_release() {
        return this.graphicsContextProvider;
    }

    public final DrawResult onDrawBehind(final Function1<? super DrawScope, Unit> r100) {
        return onDrawWithContent(new AnonymousClass1(r100));
    }

    public final DrawResult onDrawWithContent(Function1<? super ContentDrawScope, Unit> r100) {
        DrawResult r101 = new DrawResult(r100);
        this.drawResult = r101;
        return r101;
    }

    public final void setCacheParams$ui_release(BuildDrawCacheParams r100) {
        this.cacheParams = r100;
    }

    public final void setContentDrawScope$ui_release(ContentDrawScope r100) {
        this.contentDrawScope = r100;
    }

    public final void setDrawResult$ui_release(DrawResult r100) {
        this.drawResult = r100;
    }

    public final void setGraphicsContextProvider$ui_release(Function0<? extends GraphicsContext> r100) {
        this.graphicsContextProvider = r100;
    }

    /* JADX INFO: renamed from: record-TdoYBX4, reason: not valid java name */
    public final void m4367recordTdoYBX4(GraphicsLayer r110, final Density r111, final LayoutDirection r112, long r113, final Function1<? super ContentDrawScope, Unit> r114) {
        final ContentDrawScope r100 = this.contentDrawScope;
        Intrinsics.checkNotNull(r100);
        final Density r101 = r100.getDrawContext().getDensity();
        final LayoutDirection r102 = r100.getDrawContext().getLayoutDirection();
        r100.mo5323recordJVtK1S4(r110, r113, new CacheDrawScope$record$1$1(r114, r100, r111, r112, r101, r102));
    }

    /* JADX INFO: renamed from: record-TdoYBX4$default, reason: not valid java name */
    public static /* synthetic */ void m4365recordTdoYBX4$default(CacheDrawScope r100, GraphicsLayer r101, Density r102, LayoutDirection r110, long r111, Function1 r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L5;
        Density r103 = r100;
    L7:
        if ((r113 & 2) == 0) goto L9;
        r110 = r100.getLayoutDirection();
    L9:
        LayoutDirection r104 = r110;
        if ((r113 & 4) == 0) goto L12;
        r111 = IntSizeKt.m7730toIntSizeuvyYCjk(r100.m4366getSizeNHjbRc());
    L12:
        r100.m4367recordTdoYBX4(r101, r103, r104, r111, r112);
        return;
    L5:
        r103 = r102;
        goto L7
    }
}
