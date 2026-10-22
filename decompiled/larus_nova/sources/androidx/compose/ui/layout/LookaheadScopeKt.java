package androidx.compose.ui.layout;

import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000l\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a0\u0010\u0000\u001a\u00020\u00012!\u0010\u0002\u001a\u001d\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0005¢\u0006\u0002\b\u0006¢\u0006\u0002\b\u0007H\u0007¢\u0006\u0002\u0010\b\u001a \u0001\u0010\t\u001a\u00020\n*\u00020\n2!\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\u00032.\b\u0002\u0010\u0011\u001a(\u0012\u0004\u0012\u00020\u0013\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00100\u0012¢\u0006\u0002\b\u00072A\u0010\u0016\u001a=\u0012\u0004\u0012\u00020\u0018\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u00110\u001b¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u001d0\u0017¢\u0006\u0002\b\u0007\u001a3\u0010\u001f\u001a\u00020 *\u00020\u00042\u0006\u0010!\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020\u00142\u0006\u0010#\u001a\u00020 2\u0006\u0010$\u001a\u00020\u0010H\u0000¢\u0006\u0004\b%\u0010&\"4\u0010\u001e\u001a(\u0012\u0004\u0012\u00020\u0013\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00100\u0012¢\u0006\u0002\b\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"LookaheadScope", "", "content", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/LookaheadScope;", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/ui/UiComposable;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "approachLayout", "Landroidx/compose/ui/Modifier;", "isMeasurementApproachInProgress", "Landroidx/compose/ui/unit/IntSize;", "Lkotlin/ParameterName;", "name", "lookaheadSize", "", "isPlacementApproachInProgress", "Lkotlin/Function2;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "lookaheadCoordinates", "approachMeasure", "Lkotlin/Function3;", "Landroidx/compose/ui/layout/ApproachMeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "measurable", "Landroidx/compose/ui/unit/Constraints;", "constraints", "Landroidx/compose/ui/layout/MeasureResult;", "defaultPlacementApproachInProgress", "localLookaheadPositionOf", "Landroidx/compose/ui/geometry/Offset;", "coordinates", "sourceCoordinates", "relativeToSource", "includeMotionFrameOfReference", "localLookaheadPositionOf-Fgt4K4Q", "(Landroidx/compose/ui/layout/LookaheadScope;Landroidx/compose/ui/layout/LayoutCoordinates;Landroidx/compose/ui/layout/LayoutCoordinates;JZ)J", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class LookaheadScopeKt {
    private static final Function2<Placeable.PlacementScope, LayoutCoordinates, Boolean> defaultPlacementApproachInProgress = null;

    static {
        defaultPlacementApproachInProgress = LookaheadScopeKt$defaultPlacementApproachInProgress$1.INSTANCE;
    }

    public static final /* synthetic */ Function2 access$getDefaultPlacementApproachInProgress$p() {
        return defaultPlacementApproachInProgress;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void LookaheadScope(final Function3<? super LookaheadScope, ? super Composer, ? super Integer, Unit> r100, Composer r101, final int r102) {
        Composer r103 = r101.startRestartGroup(441837433);
        if ((r102 & 6) == 0) goto L5;
        int r104 = r102;
    L10:
        int r105 = 1;
        if ((r104 & 3) == 2) goto L13;
        boolean r106 = true;
    L15:
        if (r103.shouldExecute(r106, r104 & 1) == true) goto L17;
        r103.skipToGroupEnd();
    L36:
        ScopeUpdateScope r107 = r103.endRestartGroup();
        if (r107 == null) goto L40;
        r107.updateScope(new AnonymousClass4(r100, r102));
        return;
    L40:
        return;
    L17:
        if (ComposerKt.isTraceInProgress() == false) goto L19;
        ComposerKt.traceEventStart(441837433, r104, -1, "androidx.compose.ui.layout.LookaheadScope (LookaheadScope.kt:48)");
    L19:
        Object r108 = r103.rememberedValue();
        Composer.Companion r109 = Composer.Companion;
        if (r108 != r109.getEmpty()) goto L22;
        r108 = new LookaheadScopeImpl(null, r105, 0 == true ? 1 : 0);
        r103.updateRememberedValue(r108);
    L22:
        LookaheadScopeImpl r110 = (LookaheadScopeImpl) r108;
        Object r111 = r103.rememberedValue();
        if (r111 != r109.getEmpty()) goto L25;
        r111 = LookaheadScopeKt$LookaheadScope$1$1.INSTANCE;
        r103.updateRememberedValue(r111);
    L25:
        Function0 r112 = (Function0) r111;
        if ((r103.getApplier() instanceof Applier) == true) goto L28;
        ComposablesKt.invalidApplier();
    L28:
        r103.startReusableNode();
        if (r103.getInserting() == false) goto L31;
        r103.createNode(r112);
    L32:
        Composer r113 = Updater.m4166constructorimpl(r103);
        Updater.m4170initimpl(r113, LookaheadScopeKt$LookaheadScope$2$1.INSTANCE);
        Updater.m4173setimpl(r113, r110, LookaheadScopeKt$LookaheadScope$2$2.INSTANCE);
        r100.invoke(r110, r103, Integer.valueOf((r104 << 3) & 112));
        r103.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L36;
        ComposerKt.traceEventEnd();
        goto L36
    L31:
        r103.useNode();
        goto L32
    L13:
        r106 = false;
        goto L15
    L5:
        if (r103.changedInstance(r100) == false) goto L7;
        int r114 = 4;
    L8:
        r104 = r114 | r102;
        goto L10
    L7:
        r114 = 2;
        goto L8
    }

    public static final Modifier approachLayout(Modifier r100, Function1<? super IntSize, Boolean> r101, Function2<? super Placeable.PlacementScope, ? super LayoutCoordinates, Boolean> r102, Function3<? super ApproachMeasureScope, ? super Measurable, ? super Constraints, ? extends MeasureResult> r103) {
        return r100.then(new ApproachLayoutElement(r103, r101, r102));
    }

    /* JADX INFO: renamed from: localLookaheadPositionOf-Fgt4K4Q, reason: not valid java name */
    public static final long m6292localLookaheadPositionOfFgt4K4Q(LookaheadScope r100, LayoutCoordinates r101, LayoutCoordinates r102, long r103, boolean r104) {
        LayoutCoordinates r105 = r100.toLookaheadCoordinates(r101);
        LayoutCoordinates r106 = r100.toLookaheadCoordinates(r102);
        if ((r105 instanceof LookaheadLayoutCoordinates) == false) goto L6;
        return ((LookaheadLayoutCoordinates) r105).mo6260localPositionOfS_NoaFU(r106, r103, r104);
    L6:
        if ((r106 instanceof LookaheadLayoutCoordinates) == false) goto L9;
        return Offset.m4574constructorimpl(((LookaheadLayoutCoordinates) r106).mo6260localPositionOfS_NoaFU(r105, r103, r104) ^ (-9223372034707292160L));
    L9:
        return r105.mo6260localPositionOfS_NoaFU(r105, r103, r104);
    }

    public static /* synthetic */ Modifier approachLayout$default(Modifier r100, Function1 r101, Function2 r102, Function3 r103, int r104, Object r105) {
        if ((r104 & 2) == 0) goto L6;
        r102 = defaultPlacementApproachInProgress;
    L6:
        return approachLayout(r100, r101, r102, r103);
    }
}
