package androidx.compose.material3;

import C7.r;
import H4.o;
import S7.k;
import S7.n;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.internal.AnchoredDraggableKt;
import androidx.compose.material3.internal.AnchoredDraggableState;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.MultiContentMeasurePolicy;
import androidx.compose.ui.layout.MultiContentMeasurePolicyKt;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.AbstractC1683A;
import m9.InterfaceC1733z;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0007\n\u0002\b\u0006\u001a\u0085\u0002\u0010 \u001a\u00020\u00022\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000¢\u0006\u0002\b\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\t2\b\b\u0002\u0010\u0012\u001a\u00020\t2\u0015\b\u0002\u0010\u0014\u001a\u000f\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0013¢\u0006\u0002\b\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00152\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0013¢\u0006\u0002\b\u00032\u0019\b\u0002\u0010\u0019\u001a\u0013\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00020\u0000¢\u0006\u0002\b\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u000e2\b\b\u0002\u0010\u001b\u001a\u00020\u000e2\u0017\u0010\u001d\u001a\u0013\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00020\u0000¢\u0006\u0002\b\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001f\u001a#\u0010$\u001a\u00020\u00072\b\b\u0002\u0010\"\u001a\u00020!2\b\b\u0002\u0010#\u001a\u00020\u0018H\u0007¢\u0006\u0004\b$\u0010%\u001a9\u0010*\u001a\u00020!2\b\b\u0002\u0010'\u001a\u00020&2\u0014\b\u0002\u0010(\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u00150\u00002\b\b\u0002\u0010)\u001a\u00020\u0015H\u0007¢\u0006\u0004\b*\u0010+\u001a\u0088\u0001\u00104\u001a\u00020\u00022\u0006\u0010,\u001a\u00020!2\u0006\u0010-\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010.\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u000e2\u0006\u0010/\u001a\u00020\t2\u0006\u00100\u001a\u00020\t2\u0013\u00101\u001a\u000f\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0013¢\u0006\u0002\b\u00032\u0017\u0010\u001d\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000¢\u0006\u0002\b\u0003H\u0003ø\u0001\u0000¢\u0006\u0004\b2\u00103\u001a\u008e\u0001\u0010<\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0013\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0013¢\u0006\u0002\b\u00032\u0011\u00105\u001a\r\u0012\u0004\u0012\u00020\u00020\u0013¢\u0006\u0002\b\u00032\u0011\u00106\u001a\r\u0012\u0004\u0012\u00020\u00020\u0013¢\u0006\u0002\b\u00032\u0011\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u00020\u0013¢\u0006\u0002\b\u00032\f\u00108\u001a\b\u0012\u0004\u0012\u0002070\u00132\u0006\u00109\u001a\u00020!2\u0006\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u000eH\u0003ø\u0001\u0000¢\u0006\u0004\b:\u0010;\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006="}, d2 = {"Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "LC7/r;", "Landroidx/compose/runtime/Composable;", "sheetContent", "Landroidx/compose/ui/Modifier;", "modifier", "Landroidx/compose/material3/BottomSheetScaffoldState;", "scaffoldState", "Landroidx/compose/ui/unit/Dp;", "sheetPeekHeight", "sheetMaxWidth", "Landroidx/compose/ui/graphics/Shape;", "sheetShape", "Landroidx/compose/ui/graphics/Color;", "sheetContainerColor", "sheetContentColor", "sheetTonalElevation", "sheetShadowElevation", "Lkotlin/Function0;", "sheetDragHandle", "", "sheetSwipeEnabled", "topBar", "Landroidx/compose/material3/SnackbarHostState;", "snackbarHost", "containerColor", "contentColor", "Landroidx/compose/foundation/layout/PaddingValues;", "content", "BottomSheetScaffold-sdMYb0k", "(LS7/o;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/BottomSheetScaffoldState;FFLandroidx/compose/ui/graphics/Shape;JJFFLS7/n;ZLS7/n;LS7/o;JJLS7/o;Landroidx/compose/runtime/Composer;III)V", "BottomSheetScaffold", "Landroidx/compose/material3/SheetState;", "bottomSheetState", "snackbarHostState", "rememberBottomSheetScaffoldState", "(Landroidx/compose/material3/SheetState;Landroidx/compose/material3/SnackbarHostState;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/BottomSheetScaffoldState;", "Landroidx/compose/material3/SheetValue;", "initialValue", "confirmValueChange", "skipHiddenState", "rememberStandardBottomSheetState", "(Landroidx/compose/material3/SheetValue;LS7/k;ZLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SheetState;", "state", "peekHeight", "shape", "tonalElevation", "shadowElevation", "dragHandle", "StandardBottomSheet-w7I5h1o", "(Landroidx/compose/material3/SheetState;FFZLandroidx/compose/ui/graphics/Shape;JJFFLS7/n;LS7/o;Landroidx/compose/runtime/Composer;II)V", "StandardBottomSheet", "body", "bottomSheet", "", "sheetOffset", "sheetState", "BottomSheetScaffoldLayout-2E65NiM", "(Landroidx/compose/ui/Modifier;LS7/n;LS7/n;LS7/n;LS7/n;LS7/a;Landroidx/compose/material3/SheetState;JJLandroidx/compose/runtime/Composer;I)V", "BottomSheetScaffoldLayout", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class BottomSheetScaffoldKt {
    /* JADX WARN: Removed duplicated region for block: B:101:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0205  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x024f  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x02a5  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x02a7  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x02aa  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x02b1  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x02ba  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x02bd  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x02c4  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x02c8  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x02d3  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x02df  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x02ee  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x02fc  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x0300  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x0309  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x0310  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x0314  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x031b  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x031f  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x0322  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x0326  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x0329  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x0330  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x0338  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x034b  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x0353  */
    /* JADX WARN: Removed duplicated region for block: B:260:0x0368  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x037d  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x0388  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:275:0x03f8  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x0400  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x0442  */
    /* JADX WARN: Removed duplicated region for block: B:284:0x0460  */
    /* JADX WARN: Removed duplicated region for block: B:286:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x011f  */
    @androidx.compose.runtime.Composable
    @androidx.compose.material3.ExperimentalMaterial3Api
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][_][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /* renamed from: BottomSheetScaffold-sdMYb0k, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m1538BottomSheetScaffoldsdMYb0k(final S7.o r34, androidx.compose.ui.Modifier r35, androidx.compose.material3.BottomSheetScaffoldState r36, float r37, float r38, androidx.compose.ui.graphics.Shape r39, long r40, long r42, float r44, float r45, S7.n r46, boolean r47, S7.n r48, S7.o r49, long r50, long r52, final S7.o r54, androidx.compose.runtime.Composer r55, final int r56, final int r57, final int r58) {
        /*
            Method dump skipped, instructions count: 1144
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.BottomSheetScaffoldKt.m1538BottomSheetScaffoldsdMYb0k(S7.o, androidx.compose.ui.Modifier, androidx.compose.material3.BottomSheetScaffoldState, float, float, androidx.compose.ui.graphics.Shape, long, long, float, float, S7.n, boolean, S7.n, S7.o, long, long, S7.o, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[_][androidx.compose.ui.UiComposable][_][_]]")
    /* renamed from: BottomSheetScaffoldLayout-2E65NiM, reason: not valid java name */
    public static final void m1539BottomSheetScaffoldLayout2E65NiM(final Modifier modifier, final n nVar, final n nVar2, final n nVar3, final n nVar4, final S7.a aVar, final SheetState sheetState, final long j5, final long j6, Composer composer, final int i) {
        int i6;
        n nVar5;
        char c;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1651214892);
        if ((i & 6) == 0) {
            i6 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i6 = i;
        }
        if ((i & 48) == 0) {
            i6 |= composerStartRestartGroup.changedInstance(nVar) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            nVar5 = nVar2;
            i6 |= composerStartRestartGroup.changedInstance(nVar5) ? 256 : 128;
        } else {
            nVar5 = nVar2;
        }
        if ((i & 3072) == 0) {
            i6 |= composerStartRestartGroup.changedInstance(nVar3) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i6 |= composerStartRestartGroup.changedInstance(nVar4) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i6 |= composerStartRestartGroup.changedInstance(aVar) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i6 |= composerStartRestartGroup.changed(sheetState) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            i6 |= composerStartRestartGroup.changed(j5) ? 8388608 : 4194304;
        }
        if ((100663296 & i) == 0) {
            c = 2;
            i6 |= composerStartRestartGroup.changed(j6) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        } else {
            c = 2;
        }
        char c2 = c;
        if ((i6 & 38347923) == 38347922 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1651214892, i6, -1, "androidx.compose.material3.BottomSheetScaffoldLayout (BottomSheetScaffold.kt:354)");
            }
            n nVarM1705getLambda3$material3_release = nVar == null ? ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1705getLambda3$material3_release() : nVar;
            final n nVar6 = nVar5;
            ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(398963586, true, new n() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // S7.n
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return r.f317a;
                }

                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                @Composable
                public final void invoke(Composer composer2, int i10) {
                    if ((i10 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(398963586, i10, -1, "androidx.compose.material3.BottomSheetScaffoldLayout.<anonymous> (BottomSheetScaffold.kt:360)");
                    }
                    SurfaceKt.m2314SurfaceT9BRK9s(modifier, null, j5, j6, 0.0f, 0.0f, null, nVar6, composer2, 0, 114);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54);
            n[] nVarArr = new n[4];
            nVarArr[0] = nVarM1705getLambda3$material3_release;
            nVarArr[1] = composableLambdaRememberComposableLambda;
            nVarArr[c2] = nVar3;
            nVarArr[3] = nVar4;
            List listN = o.N(nVarArr);
            boolean z10 = ((3670016 & i6) == 1048576) | ((i6 & 458752) == 131072);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z10 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new MultiContentMeasurePolicy() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffoldLayout$2$1
                    @Override // androidx.compose.ui.layout.MultiContentMeasurePolicy
                    /* renamed from: measure-3p2s80s */
                    public final MeasureResult mo648measure3p2s80s(MeasureScope measureScope, List<? extends List<? extends Measurable>> list, long j10) {
                        Integer numValueOf;
                        List<? extends Measurable> list2 = list.get(0);
                        int i10 = 1;
                        List<? extends Measurable> list3 = list.get(1);
                        List<? extends Measurable> list4 = list.get(2);
                        List<? extends Measurable> list5 = list.get(3);
                        final int iM6797getMaxWidthimpl = Constraints.m6797getMaxWidthimpl(j10);
                        final int iM6796getMaxHeightimpl = Constraints.m6796getMaxHeightimpl(j10);
                        long jM6787copyZbe2FdA$default = Constraints.m6787copyZbe2FdA$default(j10, 0, 0, 0, 0, 10, null);
                        final ArrayList arrayList = new ArrayList(list4.size());
                        int size = list4.size();
                        for (int i11 = 0; i11 < size; i11++) {
                            arrayList.add(list4.get(i11).mo5549measureBRTryo0(jM6787copyZbe2FdA$default));
                        }
                        final ArrayList arrayList2 = new ArrayList(list2.size());
                        int size2 = list2.size();
                        for (int i12 = 0; i12 < size2; i12++) {
                            arrayList2.add(list2.get(i12).mo5549measureBRTryo0(jM6787copyZbe2FdA$default));
                        }
                        if (arrayList2.isEmpty()) {
                            numValueOf = null;
                        } else {
                            numValueOf = Integer.valueOf(((Placeable) arrayList2.get(0)).getHeight());
                            int iH = o.H(arrayList2);
                            if (1 <= iH) {
                                while (true) {
                                    Integer numValueOf2 = Integer.valueOf(((Placeable) arrayList2.get(i10)).getHeight());
                                    if (numValueOf2.compareTo(numValueOf) > 0) {
                                        numValueOf = numValueOf2;
                                    }
                                    if (i10 == iH) {
                                        break;
                                    }
                                    i10++;
                                }
                            }
                        }
                        final int iIntValue = numValueOf != null ? numValueOf.intValue() : 0;
                        long jM6787copyZbe2FdA$default2 = Constraints.m6787copyZbe2FdA$default(jM6787copyZbe2FdA$default, 0, 0, 0, iM6796getMaxHeightimpl - iIntValue, 7, null);
                        final ArrayList arrayList3 = new ArrayList(list3.size());
                        int size3 = list3.size();
                        for (int i13 = 0; i13 < size3; i13++) {
                            arrayList3.add(list3.get(i13).mo5549measureBRTryo0(jM6787copyZbe2FdA$default2));
                        }
                        final ArrayList arrayList4 = new ArrayList(list5.size());
                        int size4 = list5.size();
                        for (int i14 = 0; i14 < size4; i14++) {
                            arrayList4.add(list5.get(i14).mo5549measureBRTryo0(jM6787copyZbe2FdA$default));
                        }
                        final SheetState sheetState2 = sheetState;
                        final S7.a aVar2 = aVar;
                        return MeasureScope.layout$default(measureScope, iM6797getMaxWidthimpl, iM6796getMaxHeightimpl, null, new k() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffoldLayout$2$1.1

                            @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
                            /* renamed from: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffoldLayout$2$1$1$WhenMappings */
                            public /* synthetic */ class WhenMappings {
                                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                                static {
                                    int[] iArr = new int[SheetValue.values().length];
                                    try {
                                        iArr[SheetValue.PartiallyExpanded.ordinal()] = 1;
                                    } catch (NoSuchFieldError unused) {
                                    }
                                    try {
                                        iArr[SheetValue.Expanded.ordinal()] = 2;
                                    } catch (NoSuchFieldError unused2) {
                                    }
                                    try {
                                        iArr[SheetValue.Hidden.ordinal()] = 3;
                                    } catch (NoSuchFieldError unused3) {
                                    }
                                    $EnumSwitchMapping$0 = iArr;
                                }
                            }

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // S7.k
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((Placeable.PlacementScope) obj);
                                return r.f317a;
                            }

                            public final void invoke(Placeable.PlacementScope placementScope) {
                                Integer numValueOf3;
                                Integer numValueOf4;
                                int iU;
                                List<Placeable> list6 = arrayList;
                                Integer numValueOf5 = null;
                                if (list6.isEmpty()) {
                                    numValueOf3 = null;
                                } else {
                                    numValueOf3 = Integer.valueOf(list6.get(0).getWidth());
                                    int iH2 = o.H(list6);
                                    if (1 <= iH2) {
                                        int i15 = 1;
                                        while (true) {
                                            Integer numValueOf6 = Integer.valueOf(list6.get(i15).getWidth());
                                            if (numValueOf6.compareTo(numValueOf3) > 0) {
                                                numValueOf3 = numValueOf6;
                                            }
                                            if (i15 == iH2) {
                                                break;
                                            } else {
                                                i15++;
                                            }
                                        }
                                    }
                                }
                                int iMax = Integer.max(0, (iM6797getMaxWidthimpl - (numValueOf3 != null ? numValueOf3.intValue() : 0)) / 2);
                                List<Placeable> list7 = arrayList4;
                                if (list7.isEmpty()) {
                                    numValueOf4 = null;
                                } else {
                                    numValueOf4 = Integer.valueOf(list7.get(0).getWidth());
                                    int iH3 = o.H(list7);
                                    if (1 <= iH3) {
                                        int i16 = 1;
                                        while (true) {
                                            Integer numValueOf7 = Integer.valueOf(list7.get(i16).getWidth());
                                            if (numValueOf7.compareTo(numValueOf4) > 0) {
                                                numValueOf4 = numValueOf7;
                                            }
                                            if (i16 == iH3) {
                                                break;
                                            } else {
                                                i16++;
                                            }
                                        }
                                    }
                                }
                                int iIntValue2 = numValueOf4 != null ? numValueOf4.intValue() : 0;
                                List<Placeable> list8 = arrayList4;
                                if (!list8.isEmpty()) {
                                    numValueOf5 = Integer.valueOf(list8.get(0).getHeight());
                                    int iH4 = o.H(list8);
                                    if (1 <= iH4) {
                                        int i17 = 1;
                                        while (true) {
                                            Integer numValueOf8 = Integer.valueOf(list8.get(i17).getHeight());
                                            if (numValueOf8.compareTo(numValueOf5) > 0) {
                                                numValueOf5 = numValueOf8;
                                            }
                                            if (i17 == iH4) {
                                                break;
                                            } else {
                                                i17++;
                                            }
                                        }
                                    }
                                }
                                int iIntValue3 = numValueOf5 != null ? numValueOf5.intValue() : 0;
                                int i18 = (iM6797getMaxWidthimpl - iIntValue2) / 2;
                                int i19 = WhenMappings.$EnumSwitchMapping$0[sheetState2.getCurrentValue().ordinal()];
                                if (i19 == 1) {
                                    iU = U7.a.U(((Number) aVar2.invoke()).floatValue());
                                } else {
                                    if (i19 != 2 && i19 != 3) {
                                        throw new NoWhenBranchMatchedException();
                                    }
                                    iU = iM6796getMaxHeightimpl;
                                }
                                int i20 = iU - iIntValue3;
                                List<Placeable> list9 = arrayList3;
                                int i21 = iIntValue;
                                int size5 = list9.size();
                                for (int i22 = 0; i22 < size5; i22++) {
                                    Placeable.PlacementScope.placeRelative$default(placementScope, list9.get(i22), 0, i21, 0.0f, 4, null);
                                }
                                List<Placeable> list10 = arrayList2;
                                int size6 = list10.size();
                                for (int i23 = 0; i23 < size6; i23++) {
                                    Placeable.PlacementScope.placeRelative$default(placementScope, list10.get(i23), 0, 0, 0.0f, 4, null);
                                }
                                List<Placeable> list11 = arrayList;
                                int size7 = list11.size();
                                for (int i24 = 0; i24 < size7; i24++) {
                                    Placeable.PlacementScope.placeRelative$default(placementScope, list11.get(i24), iMax, 0, 0.0f, 4, null);
                                }
                                List<Placeable> list12 = arrayList4;
                                int size8 = list12.size();
                                for (int i25 = 0; i25 < size8; i25++) {
                                    Placeable.PlacementScope.placeRelative$default(placementScope, list12.get(i25), i18, i20, 0.0f, 4, null);
                                }
                            }
                        }, 4, null);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            MultiContentMeasurePolicy multiContentMeasurePolicy = (MultiContentMeasurePolicy) objRememberedValue;
            Modifier.Companion companion = Modifier.INSTANCE;
            n nVarCombineAsVirtualLayouts = LayoutKt.combineAsVirtualLayouts(listN);
            boolean zChanged = composerStartRestartGroup.changed(multiContentMeasurePolicy);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = MultiContentMeasurePolicyKt.createMeasurePolicy(multiContentMeasurePolicy);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) objRememberedValue2;
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
            S7.a constructor = companion2.getConstructor();
            if (composerStartRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM3474constructorimpl = Updater.m3474constructorimpl(composerStartRestartGroup);
            n nVarG = androidx.appfunctions.metadata.a.g(companion2, composerM3474constructorimpl, measurePolicy, composerM3474constructorimpl, currentCompositionLocalMap);
            if (composerM3474constructorimpl.getInserting() || !kotlin.jvm.internal.k.b(composerM3474constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                androidx.appfunctions.metadata.a.z(nVarG, currentCompositeKeyHash, composerM3474constructorimpl, currentCompositeKeyHash);
            }
            Updater.m3481setimpl(composerM3474constructorimpl, modifierMaterializeModifier, companion2.getSetModifier());
            nVarCombineAsVirtualLayouts.invoke(composerStartRestartGroup, 0);
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new n() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffoldLayout$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // S7.n
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return r.f317a;
                }

                public final void invoke(Composer composer2, int i10) {
                    BottomSheetScaffoldKt.m1539BottomSheetScaffoldLayout2E65NiM(modifier, nVar, nVar2, nVar3, nVar4, aVar, sheetState, j5, j6, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /* renamed from: StandardBottomSheet-w7I5h1o, reason: not valid java name */
    public static final void m1540StandardBottomSheetw7I5h1o(final SheetState sheetState, final float f, final float f7, final boolean z10, final Shape shape, final long j5, final long j6, final float f9, final float f10, final n nVar, final S7.o oVar, Composer composer, final int i, final int i6) {
        int i10;
        int i11;
        InterfaceC1733z interfaceC1733z;
        int i12;
        Object obj;
        Modifier modifierNestedScroll$default;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(721467526);
        if ((i & 6) == 0) {
            i10 = (composerStartRestartGroup.changed(sheetState) ? 4 : 2) | i;
        } else {
            i10 = i;
        }
        if ((i & 48) == 0) {
            i10 |= composerStartRestartGroup.changed(f) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i10 |= composerStartRestartGroup.changed(f7) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i10 |= composerStartRestartGroup.changed(z10) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i10 |= composerStartRestartGroup.changed(shape) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i10 |= composerStartRestartGroup.changed(j5) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i10 |= composerStartRestartGroup.changed(j6) ? 1048576 : 524288;
        }
        if ((i & 12582912) == 0) {
            i10 |= composerStartRestartGroup.changed(f9) ? 8388608 : 4194304;
        }
        if ((i & 100663296) == 0) {
            i10 |= composerStartRestartGroup.changed(f10) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if ((805306368 & i) == 0) {
            i10 |= composerStartRestartGroup.changedInstance(nVar) ? 536870912 : 268435456;
        }
        if ((i6 & 6) == 0) {
            i11 = i6 | (composerStartRestartGroup.changedInstance(oVar) ? 4 : 2);
        } else {
            i11 = i6;
        }
        if ((i10 & 306783379) == 306783378 && (i11 & 3) == 2 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(721467526, i10, i11, "androidx.compose.material3.StandardBottomSheet (BottomSheetScaffold.kt:224)");
            }
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = B7.a.e(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.f4908a, composerStartRestartGroup), composerStartRestartGroup);
            }
            final InterfaceC1733z coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
            Orientation orientation = Orientation.Vertical;
            final float fMo381toPx0680j_4 = ((Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity())).mo381toPx0680j_4(f);
            composerStartRestartGroup.startReplaceGroup(-1831611516);
            if (z10) {
                Modifier.Companion companion2 = Modifier.INSTANCE;
                boolean zChanged = composerStartRestartGroup.changed(sheetState.getAnchoredDraggableState$material3_release());
                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    i12 = i10;
                } else {
                    i12 = i10;
                    if (objRememberedValue2 == companion.getEmpty()) {
                    }
                    interfaceC1733z = coroutineScope;
                    obj = null;
                    modifierNestedScroll$default = NestedScrollModifierKt.nestedScroll$default(companion2, (NestedScrollConnection) objRememberedValue2, null, 2, null);
                }
                objRememberedValue2 = SheetDefaultsKt.ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(sheetState, orientation, new k() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$nestedScroll$1$1

                    @J7.c(c = "androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$nestedScroll$1$1$1", f = "BottomSheetScaffold.kt", l = {236}, m = "invokeSuspend")
                    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {1, 8, 0})
                    /* renamed from: androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$nestedScroll$1$1$1, reason: invalid class name */
                    public static final class AnonymousClass1 extends SuspendLambda implements n {
                        final /* synthetic */ float $it;
                        final /* synthetic */ SheetState $state;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        public AnonymousClass1(SheetState sheetState, float f, H7.c<? super AnonymousClass1> cVar) {
                            super(2, cVar);
                            this.$state = sheetState;
                            this.$it = f;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
                            return new AnonymousClass1(this.$state, this.$it, cVar);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
                            int i = this.label;
                            if (i == 0) {
                                kotlin.b.b(obj);
                                SheetState sheetState = this.$state;
                                float f = this.$it;
                                this.label = 1;
                                if (sheetState.settle$material3_release(f, this) == coroutineSingletons) {
                                    return coroutineSingletons;
                                }
                            } else {
                                if (i != 1) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                kotlin.b.b(obj);
                            }
                            return r.f317a;
                        }

                        @Override // S7.n
                        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
                            return ((AnonymousClass1) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
                        }
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // S7.k
                    public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                        invoke(((Number) obj2).floatValue());
                        return r.f317a;
                    }

                    public final void invoke(float f11) {
                        AbstractC1683A.n(coroutineScope, null, new AnonymousClass1(sheetState, f11, null), 3);
                    }
                });
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                interfaceC1733z = coroutineScope;
                obj = null;
                modifierNestedScroll$default = NestedScrollModifierKt.nestedScroll$default(companion2, (NestedScrollConnection) objRememberedValue2, null, 2, null);
            } else {
                interfaceC1733z = coroutineScope;
                i12 = i10;
                obj = null;
                modifierNestedScroll$default = Modifier.INSTANCE;
            }
            composerStartRestartGroup.endReplaceGroup();
            Modifier modifierThen = SizeKt.m736requiredHeightInVpY3zN4$default(SizeKt.fillMaxWidth$default(SizeKt.m752widthInVpY3zN4$default(Modifier.INSTANCE, 0.0f, f7, 1, obj), 0.0f, 1, obj), f, 0.0f, 2, obj).then(modifierNestedScroll$default);
            AnchoredDraggableState<SheetValue> anchoredDraggableState$material3_release = sheetState.getAnchoredDraggableState$material3_release();
            boolean zChanged2 = ((i12 & 14) == 4) | composerStartRestartGroup.changed(fMo381toPx0680j_4);
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChanged2 || objRememberedValue3 == companion.getEmpty()) {
                objRememberedValue3 = new n() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$1$1

                    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
                    public /* synthetic */ class WhenMappings {
                        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                        static {
                            int[] iArr = new int[SheetValue.values().length];
                            try {
                                iArr[SheetValue.Hidden.ordinal()] = 1;
                            } catch (NoSuchFieldError unused) {
                            }
                            try {
                                iArr[SheetValue.PartiallyExpanded.ordinal()] = 2;
                            } catch (NoSuchFieldError unused2) {
                            }
                            try {
                                iArr[SheetValue.Expanded.ordinal()] = 3;
                            } catch (NoSuchFieldError unused3) {
                            }
                            $EnumSwitchMapping$0 = iArr;
                        }
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // S7.n
                    public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                        return m1543invokeGpV2Q24(((IntSize) obj2).m7019unboximpl(), ((Constraints) obj3).getValue());
                    }

                    /* JADX WARN: Removed duplicated region for block: B:10:0x003c A[PHI: r3
                      0x003c: PHI (r3v5 androidx.compose.material3.SheetValue) = 
                      (r3v3 androidx.compose.material3.SheetValue)
                      (r3v6 androidx.compose.material3.SheetValue)
                      (r3v7 androidx.compose.material3.SheetValue)
                      (r3v8 androidx.compose.material3.SheetValue)
                      (r3v9 androidx.compose.material3.SheetValue)
                      (r3v10 androidx.compose.material3.SheetValue)
                      (r3v11 androidx.compose.material3.SheetValue)
                     binds: [B:29:0x0077, B:20:0x005c, B:23:0x0065, B:26:0x006e, B:9:0x003a, B:12:0x0044, B:15:0x004d] A[DONT_GENERATE, DONT_INLINE]] */
                    /* renamed from: invoke-GpV2Q24, reason: not valid java name */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public final kotlin.Pair<androidx.compose.material3.internal.DraggableAnchors<androidx.compose.material3.SheetValue>, androidx.compose.material3.SheetValue> m1543invokeGpV2Q24(long r2, long r4) {
                        /*
                            r1 = this;
                            int r4 = androidx.compose.ui.unit.Constraints.m6796getMaxHeightimpl(r4)
                            float r4 = (float) r4
                            int r2 = androidx.compose.ui.unit.IntSize.m7014getHeightimpl(r2)
                            float r2 = (float) r2
                            androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$1$1$newAnchors$1 r3 = new androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$1$1$newAnchors$1
                            androidx.compose.material3.SheetState r5 = r1
                            float r0 = r2
                            r3.<init>()
                            androidx.compose.material3.internal.DraggableAnchors r2 = androidx.compose.material3.internal.AnchoredDraggableKt.DraggableAnchors(r3)
                            androidx.compose.material3.SheetState r1 = r1
                            androidx.compose.material3.internal.AnchoredDraggableState r1 = r1.getAnchoredDraggableState$material3_release()
                            java.lang.Object r1 = r1.getTargetValue()
                            androidx.compose.material3.SheetValue r1 = (androidx.compose.material3.SheetValue) r1
                            int[] r3 = androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$1$1.WhenMappings.$EnumSwitchMapping$0
                            int r4 = r1.ordinal()
                            r3 = r3[r4]
                            r4 = 1
                            if (r3 == r4) goto L71
                            r4 = 2
                            if (r3 == r4) goto L56
                            r4 = 3
                            if (r3 != r4) goto L50
                            androidx.compose.material3.SheetValue r3 = androidx.compose.material3.SheetValue.Expanded
                            boolean r4 = r2.hasAnchorFor(r3)
                            if (r4 == 0) goto L3e
                        L3c:
                            r1 = r3
                            goto L7a
                        L3e:
                            androidx.compose.material3.SheetValue r3 = androidx.compose.material3.SheetValue.PartiallyExpanded
                            boolean r4 = r2.hasAnchorFor(r3)
                            if (r4 == 0) goto L47
                            goto L3c
                        L47:
                            androidx.compose.material3.SheetValue r3 = androidx.compose.material3.SheetValue.Hidden
                            boolean r4 = r2.hasAnchorFor(r3)
                            if (r4 == 0) goto L7a
                            goto L3c
                        L50:
                            kotlin.NoWhenBranchMatchedException r1 = new kotlin.NoWhenBranchMatchedException
                            r1.<init>()
                            throw r1
                        L56:
                            androidx.compose.material3.SheetValue r3 = androidx.compose.material3.SheetValue.PartiallyExpanded
                            boolean r4 = r2.hasAnchorFor(r3)
                            if (r4 == 0) goto L5f
                            goto L3c
                        L5f:
                            androidx.compose.material3.SheetValue r3 = androidx.compose.material3.SheetValue.Expanded
                            boolean r4 = r2.hasAnchorFor(r3)
                            if (r4 == 0) goto L68
                            goto L3c
                        L68:
                            androidx.compose.material3.SheetValue r3 = androidx.compose.material3.SheetValue.Hidden
                            boolean r4 = r2.hasAnchorFor(r3)
                            if (r4 == 0) goto L7a
                            goto L3c
                        L71:
                            androidx.compose.material3.SheetValue r3 = androidx.compose.material3.SheetValue.Hidden
                            boolean r4 = r2.hasAnchorFor(r3)
                            if (r4 == 0) goto L7a
                            goto L3c
                        L7a:
                            kotlin.Pair r3 = new kotlin.Pair
                            r3.<init>(r2, r1)
                            return r3
                        */
                        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$1$1.m1543invokeGpV2Q24(long, long):kotlin.Pair");
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            final InterfaceC1733z interfaceC1733z2 = interfaceC1733z;
            int i13 = i12 >> 9;
            composer2 = composerStartRestartGroup;
            SurfaceKt.m2314SurfaceT9BRK9s(AnchoredDraggableKt.anchoredDraggable$default(AnchoredDraggableKt.draggableAnchors(modifierThen, anchoredDraggableState$material3_release, orientation, (n) objRememberedValue3), sheetState.getAnchoredDraggableState$material3_release(), orientation, z10, false, null, 24, null), shape, j5, j6, f9, f10, null, ComposableLambdaKt.rememberComposableLambda(390720907, true, new n() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // S7.n
                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                    invoke((Composer) obj2, ((Number) obj3).intValue());
                    return r.f317a;
                }

                @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
                @Composable
                public final void invoke(Composer composer3, int i14) {
                    if ((i14 & 3) == 2 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(390720907, i14, -1, "androidx.compose.material3.StandardBottomSheet.<anonymous> (BottomSheetScaffold.kt:295)");
                    }
                    Modifier.Companion companion3 = Modifier.INSTANCE;
                    Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(companion3, 0.0f, 1, null);
                    n nVar2 = nVar;
                    final SheetState sheetState2 = sheetState;
                    final boolean z11 = z10;
                    final InterfaceC1733z interfaceC1733z3 = interfaceC1733z2;
                    S7.o oVar2 = oVar;
                    Arrangement.Vertical top = Arrangement.INSTANCE.getTop();
                    Alignment.Companion companion4 = Alignment.INSTANCE;
                    MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, companion4.getStart(), composer3, 0);
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer3, modifierFillMaxWidth$default);
                    ComposeUiNode.Companion companion5 = ComposeUiNode.INSTANCE;
                    S7.a constructor = companion5.getConstructor();
                    if (composer3.getApplier() == null) {
                        ComposablesKt.invalidApplier();
                    }
                    composer3.startReusableNode();
                    if (composer3.getInserting()) {
                        composer3.createNode(constructor);
                    } else {
                        composer3.useNode();
                    }
                    Composer composerM3474constructorimpl = Updater.m3474constructorimpl(composer3);
                    n nVarG = androidx.appfunctions.metadata.a.g(companion5, composerM3474constructorimpl, measurePolicyColumnMeasurePolicy, composerM3474constructorimpl, currentCompositionLocalMap);
                    if (composerM3474constructorimpl.getInserting() || !kotlin.jvm.internal.k.b(composerM3474constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        androidx.appfunctions.metadata.a.z(nVarG, currentCompositeKeyHash, composerM3474constructorimpl, currentCompositeKeyHash);
                    }
                    Updater.m3481setimpl(composerM3474constructorimpl, modifierMaterializeModifier, companion5.getSetModifier());
                    ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                    composer3.startReplaceGroup(-1168080147);
                    if (nVar2 != null) {
                        Strings.Companion companion6 = Strings.INSTANCE;
                        final String strM2752getString2EP1pXo = Strings_androidKt.m2752getString2EP1pXo(Strings.m2682constructorimpl(R.string.m3c_bottom_sheet_collapse_description), composer3, 0);
                        final String strM2752getString2EP1pXo2 = Strings_androidKt.m2752getString2EP1pXo(Strings.m2682constructorimpl(R.string.m3c_bottom_sheet_dismiss_description), composer3, 0);
                        final String strM2752getString2EP1pXo3 = Strings_androidKt.m2752getString2EP1pXo(Strings.m2682constructorimpl(R.string.m3c_bottom_sheet_expand_description), composer3, 0);
                        Modifier modifierAlign = columnScopeInstance.align(companion3, companion4.getCenterHorizontally());
                        boolean zChanged3 = composer3.changed(sheetState2) | composer3.changed(z11) | composer3.changed(strM2752getString2EP1pXo3) | composer3.changedInstance(interfaceC1733z3) | composer3.changed(strM2752getString2EP1pXo) | composer3.changed(strM2752getString2EP1pXo2);
                        Object objRememberedValue4 = composer3.rememberedValue();
                        if (zChanged3 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue4 = new k() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$2$1$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // S7.k
                                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                                    invoke((SemanticsPropertyReceiver) obj2);
                                    return r.f317a;
                                }

                                public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                    final SheetState sheetState3 = sheetState2;
                                    boolean z12 = z11;
                                    String str = strM2752getString2EP1pXo3;
                                    String str2 = strM2752getString2EP1pXo;
                                    String str3 = strM2752getString2EP1pXo2;
                                    final InterfaceC1733z interfaceC1733z4 = interfaceC1733z3;
                                    if (sheetState3.getAnchoredDraggableState$material3_release().getAnchors().getSize() <= 1 || !z12) {
                                        return;
                                    }
                                    SheetValue currentValue = sheetState3.getCurrentValue();
                                    SheetValue sheetValue = SheetValue.PartiallyExpanded;
                                    if (currentValue == sheetValue) {
                                        if (((Boolean) sheetState3.getAnchoredDraggableState$material3_release().getConfirmValueChange().invoke(SheetValue.Expanded)).booleanValue()) {
                                            SemanticsPropertiesKt.expand(semanticsPropertyReceiver, str, new S7.a() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$2$1$1$1$1$1

                                                @J7.c(c = "androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$2$1$1$1$1$1$1", f = "BottomSheetScaffold.kt", l = {311}, m = "invokeSuspend")
                                                @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {1, 8, 0})
                                                /* renamed from: androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$2$1$1$1$1$1$1, reason: invalid class name */
                                                public static final class AnonymousClass1 extends SuspendLambda implements n {
                                                    final /* synthetic */ SheetState $this_with;
                                                    int label;

                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    public AnonymousClass1(SheetState sheetState, H7.c<? super AnonymousClass1> cVar) {
                                                        super(2, cVar);
                                                        this.$this_with = sheetState;
                                                    }

                                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                    public final H7.c<r> create(Object obj, H7.c<?> cVar) {
                                                        return new AnonymousClass1(this.$this_with, cVar);
                                                    }

                                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                    public final Object invokeSuspend(Object obj) {
                                                        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
                                                        int i = this.label;
                                                        if (i == 0) {
                                                            kotlin.b.b(obj);
                                                            SheetState sheetState = this.$this_with;
                                                            this.label = 1;
                                                            if (sheetState.expand(this) == coroutineSingletons) {
                                                                return coroutineSingletons;
                                                            }
                                                        } else {
                                                            if (i != 1) {
                                                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                                            }
                                                            kotlin.b.b(obj);
                                                        }
                                                        return r.f317a;
                                                    }

                                                    @Override // S7.n
                                                    public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
                                                        return ((AnonymousClass1) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
                                                    }
                                                }

                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(0);
                                                }

                                                @Override // S7.a
                                                public final Boolean invoke() {
                                                    AbstractC1683A.n(interfaceC1733z4, null, new AnonymousClass1(sheetState3, null), 3);
                                                    return Boolean.TRUE;
                                                }
                                            });
                                        }
                                    } else if (((Boolean) sheetState3.getAnchoredDraggableState$material3_release().getConfirmValueChange().invoke(sheetValue)).booleanValue()) {
                                        SemanticsPropertiesKt.collapse(semanticsPropertyReceiver, str2, new S7.a() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$2$1$1$1$1$2

                                            @J7.c(c = "androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$2$1$1$1$1$2$1", f = "BottomSheetScaffold.kt", l = {320}, m = "invokeSuspend")
                                            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {1, 8, 0})
                                            /* renamed from: androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$2$1$1$1$1$2$1, reason: invalid class name */
                                            public static final class AnonymousClass1 extends SuspendLambda implements n {
                                                final /* synthetic */ SheetState $this_with;
                                                int label;

                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                public AnonymousClass1(SheetState sheetState, H7.c<? super AnonymousClass1> cVar) {
                                                    super(2, cVar);
                                                    this.$this_with = sheetState;
                                                }

                                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                public final H7.c<r> create(Object obj, H7.c<?> cVar) {
                                                    return new AnonymousClass1(this.$this_with, cVar);
                                                }

                                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                public final Object invokeSuspend(Object obj) {
                                                    CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
                                                    int i = this.label;
                                                    if (i == 0) {
                                                        kotlin.b.b(obj);
                                                        SheetState sheetState = this.$this_with;
                                                        this.label = 1;
                                                        if (sheetState.partialExpand(this) == coroutineSingletons) {
                                                            return coroutineSingletons;
                                                        }
                                                    } else {
                                                        if (i != 1) {
                                                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                                        }
                                                        kotlin.b.b(obj);
                                                    }
                                                    return r.f317a;
                                                }

                                                @Override // S7.n
                                                public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
                                                    return ((AnonymousClass1) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
                                                }
                                            }

                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(0);
                                            }

                                            @Override // S7.a
                                            public final Boolean invoke() {
                                                AbstractC1683A.n(interfaceC1733z4, null, new AnonymousClass1(sheetState3, null), 3);
                                                return Boolean.TRUE;
                                            }
                                        });
                                    }
                                    if (sheetState3.getSkipHiddenState()) {
                                        return;
                                    }
                                    SemanticsPropertiesKt.dismiss(semanticsPropertyReceiver, str3, new S7.a() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$2$1$1$1$1$3

                                        @J7.c(c = "androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$2$1$1$1$1$3$1", f = "BottomSheetScaffold.kt", l = {327}, m = "invokeSuspend")
                                        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {1, 8, 0})
                                        /* renamed from: androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$2$1$1$1$1$3$1, reason: invalid class name */
                                        public static final class AnonymousClass1 extends SuspendLambda implements n {
                                            final /* synthetic */ SheetState $this_with;
                                            int label;

                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            public AnonymousClass1(SheetState sheetState, H7.c<? super AnonymousClass1> cVar) {
                                                super(2, cVar);
                                                this.$this_with = sheetState;
                                            }

                                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                            public final H7.c<r> create(Object obj, H7.c<?> cVar) {
                                                return new AnonymousClass1(this.$this_with, cVar);
                                            }

                                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                            public final Object invokeSuspend(Object obj) {
                                                CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
                                                int i = this.label;
                                                if (i == 0) {
                                                    kotlin.b.b(obj);
                                                    SheetState sheetState = this.$this_with;
                                                    this.label = 1;
                                                    if (sheetState.hide(this) == coroutineSingletons) {
                                                        return coroutineSingletons;
                                                    }
                                                } else {
                                                    if (i != 1) {
                                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                                    }
                                                    kotlin.b.b(obj);
                                                }
                                                return r.f317a;
                                            }

                                            @Override // S7.n
                                            public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
                                                return ((AnonymousClass1) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
                                            }
                                        }

                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(0);
                                        }

                                        @Override // S7.a
                                        public final Boolean invoke() {
                                            AbstractC1683A.n(interfaceC1733z4, null, new AnonymousClass1(sheetState3, null), 3);
                                            return Boolean.TRUE;
                                        }
                                    });
                                }
                            };
                            composer3.updateRememberedValue(objRememberedValue4);
                        }
                        Modifier modifierSemantics = SemanticsModifierKt.semantics(modifierAlign, true, (k) objRememberedValue4);
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion4.getTopStart(), false);
                        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                        CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer3, modifierSemantics);
                        S7.a constructor2 = companion5.getConstructor();
                        if (composer3.getApplier() == null) {
                            ComposablesKt.invalidApplier();
                        }
                        composer3.startReusableNode();
                        if (composer3.getInserting()) {
                            composer3.createNode(constructor2);
                        } else {
                            composer3.useNode();
                        }
                        Composer composerM3474constructorimpl2 = Updater.m3474constructorimpl(composer3);
                        n nVarG2 = androidx.appfunctions.metadata.a.g(companion5, composerM3474constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, composerM3474constructorimpl2, currentCompositionLocalMap2);
                        if (composerM3474constructorimpl2.getInserting() || !kotlin.jvm.internal.k.b(composerM3474constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                            androidx.appfunctions.metadata.a.z(nVarG2, currentCompositeKeyHash2, composerM3474constructorimpl2, currentCompositeKeyHash2);
                        }
                        Updater.m3481setimpl(composerM3474constructorimpl2, modifierMaterializeModifier2, companion5.getSetModifier());
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        androidx.compose.foundation.b.A(nVar2, composer3, 0);
                    }
                    composer3.endReplaceGroup();
                    oVar2.invoke(columnScopeInstance, composer3, 6);
                    composer3.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), composer2, (i13 & 112) | 12582912 | (i13 & 896) | (i13 & 7168) | (57344 & i13) | (i13 & 458752), 64);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new n() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // S7.n
                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                    invoke((Composer) obj2, ((Number) obj3).intValue());
                    return r.f317a;
                }

                public final void invoke(Composer composer3, int i14) {
                    BottomSheetScaffoldKt.m1540StandardBottomSheetw7I5h1o(sheetState, f, f7, z10, shape, j5, j6, f9, f10, nVar, oVar, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i6));
                }
            });
        }
    }

    @Composable
    @ExperimentalMaterial3Api
    public static final BottomSheetScaffoldState rememberBottomSheetScaffoldState(SheetState sheetState, SnackbarHostState snackbarHostState, Composer composer, int i, int i6) {
        Composer composer2;
        if ((i6 & 1) != 0) {
            composer2 = composer;
            sheetState = rememberStandardBottomSheetState(null, null, false, composer2, 0, 7);
        } else {
            composer2 = composer;
        }
        if ((i6 & 2) != 0) {
            Object objRememberedValue = composer2.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new SnackbarHostState();
                composer2.updateRememberedValue(objRememberedValue);
            }
            snackbarHostState = (SnackbarHostState) objRememberedValue;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1474606134, i, -1, "androidx.compose.material3.rememberBottomSheetScaffoldState (BottomSheetScaffold.kt:180)");
        }
        boolean z10 = ((((i & 14) ^ 6) > 4 && composer2.changed(sheetState)) || (i & 6) == 4) | ((((i & 112) ^ 48) > 32 && composer2.changed(snackbarHostState)) || (i & 48) == 32);
        Object objRememberedValue2 = composer2.rememberedValue();
        if (z10 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = new BottomSheetScaffoldState(sheetState, snackbarHostState);
            composer2.updateRememberedValue(objRememberedValue2);
        }
        BottomSheetScaffoldState bottomSheetScaffoldState = (BottomSheetScaffoldState) objRememberedValue2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return bottomSheetScaffoldState;
    }

    @Composable
    @ExperimentalMaterial3Api
    public static final SheetState rememberStandardBottomSheetState(SheetValue sheetValue, k kVar, boolean z10, Composer composer, int i, int i6) {
        if ((i6 & 1) != 0) {
            sheetValue = SheetValue.PartiallyExpanded;
        }
        SheetValue sheetValue2 = sheetValue;
        if ((i6 & 2) != 0) {
            kVar = new k() { // from class: androidx.compose.material3.BottomSheetScaffoldKt.rememberStandardBottomSheetState.1
                @Override // S7.k
                public final Boolean invoke(SheetValue sheetValue3) {
                    return Boolean.TRUE;
                }
            };
        }
        k kVar2 = kVar;
        if ((i6 & 4) != 0) {
            z10 = true;
        }
        boolean z11 = z10;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(678511581, i, -1, "androidx.compose.material3.rememberStandardBottomSheetState (BottomSheetScaffold.kt:204)");
        }
        SheetState sheetStateRememberSheetState = SheetDefaultsKt.rememberSheetState(false, kVar2, sheetValue2, z11, composer, (i & 112) | ((i << 6) & 896) | ((i << 3) & 7168), 1);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return sheetStateRememberSheetState;
    }
}
