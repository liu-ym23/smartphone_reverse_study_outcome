package androidx.compose.material3;

import C7.r;
import S7.n;
import S7.o;
import android.view.compose.PredictiveBackHandlerKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.Ref$FloatRef;
import m9.InterfaceC1733z;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u001a0\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0002\b\u0005H\u0001¢\u0006\u0004\b\u0007\u0010\b\"\u001a\u0010\n\u001a\u00020\t8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u001a\u0010\u000e\u001a\u00020\t8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\r\"\u001a\u0010\u0010\u001a\u00020\t8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r¨\u0006\u0012"}, d2 = {"Landroidx/compose/material3/DrawerState;", "drawerState", "Lkotlin/Function1;", "Landroidx/compose/material3/DrawerPredictiveBackState;", "LC7/r;", "Landroidx/compose/runtime/Composable;", "content", "DrawerPredictiveBackHandler", "(Landroidx/compose/material3/DrawerState;LS7/o;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/ui/unit/Dp;", "PredictiveBackDrawerMaxScaleXDistanceGrow", "F", "getPredictiveBackDrawerMaxScaleXDistanceGrow", "()F", "PredictiveBackDrawerMaxScaleXDistanceShrink", "getPredictiveBackDrawerMaxScaleXDistanceShrink", "PredictiveBackDrawerMaxScaleYDistance", "getPredictiveBackDrawerMaxScaleYDistance", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class NavigationDrawer_androidKt {
    private static final float PredictiveBackDrawerMaxScaleXDistanceGrow = Dp.m6844constructorimpl(12);
    private static final float PredictiveBackDrawerMaxScaleXDistanceShrink = Dp.m6844constructorimpl(24);
    private static final float PredictiveBackDrawerMaxScaleYDistance = Dp.m6844constructorimpl(48);

    @Composable
    @ComposableInferredTarget(scheme = "[0[0]]")
    public static final void DrawerPredictiveBackHandler(final DrawerState drawerState, final o oVar, Composer composer, final int i) {
        int i6;
        Object navigationDrawer_androidKt$DrawerPredictiveBackHandler$2$1;
        boolean z10;
        int i10;
        int i11;
        Composer composerStartRestartGroup = composer.startRestartGroup(1444817207);
        if ((i & 6) == 0) {
            i6 = (composerStartRestartGroup.changed(drawerState) ? 4 : 2) | i;
        } else {
            i6 = i;
        }
        if ((i & 48) == 0) {
            i6 |= composerStartRestartGroup.changedInstance(oVar) ? 32 : 16;
        }
        int i12 = i6;
        if ((i12 & 19) == 18 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1444817207, i12, -1, "androidx.compose.material3.DrawerPredictiveBackHandler (NavigationDrawer.android.kt:44)");
            }
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = new DrawerPredictiveBackState();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            DrawerPredictiveBackState drawerPredictiveBackState = (DrawerPredictiveBackState) objRememberedValue;
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = B7.a.e(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.f4908a, composerStartRestartGroup), composerStartRestartGroup);
            }
            InterfaceC1733z coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue2).getCoroutineScope();
            boolean z11 = composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection()) == LayoutDirection.Rtl;
            Ref$FloatRef ref$FloatRef = new Ref$FloatRef();
            Ref$FloatRef ref$FloatRef2 = new Ref$FloatRef();
            Ref$FloatRef ref$FloatRef3 = new Ref$FloatRef();
            Density density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            ref$FloatRef.f4917a = density.mo381toPx0680j_4(PredictiveBackDrawerMaxScaleXDistanceGrow);
            ref$FloatRef2.f4917a = density.mo381toPx0680j_4(PredictiveBackDrawerMaxScaleXDistanceShrink);
            ref$FloatRef3.f4917a = density.mo381toPx0680j_4(PredictiveBackDrawerMaxScaleYDistance);
            boolean zIsOpen = drawerState.isOpen();
            int i13 = i12 & 14;
            boolean zChanged = composerStartRestartGroup.changed(z11) | composerStartRestartGroup.changed(ref$FloatRef.f4917a) | composerStartRestartGroup.changed(ref$FloatRef2.f4917a) | composerStartRestartGroup.changed(ref$FloatRef3.f4917a) | composerStartRestartGroup.changedInstance(coroutineScope) | (i13 == 4);
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue3 == companion.getEmpty()) {
                z10 = zIsOpen;
                i10 = i12;
                i11 = 0;
                navigationDrawer_androidKt$DrawerPredictiveBackHandler$2$1 = new NavigationDrawer_androidKt$DrawerPredictiveBackHandler$2$1(drawerPredictiveBackState, coroutineScope, drawerState, z11, ref$FloatRef, ref$FloatRef2, ref$FloatRef3, null);
                composerStartRestartGroup.updateRememberedValue(navigationDrawer_androidKt$DrawerPredictiveBackHandler$2$1);
            } else {
                z10 = zIsOpen;
                navigationDrawer_androidKt$DrawerPredictiveBackHandler$2$1 = objRememberedValue3;
                i10 = i12;
                i11 = 0;
            }
            PredictiveBackHandlerKt.PredictiveBackHandler(z10, (n) navigationDrawer_androidKt$DrawerPredictiveBackHandler$2$1, composerStartRestartGroup, i11, i11);
            Boolean boolValueOf = Boolean.valueOf(drawerState.isClosed());
            int i14 = i13 == 4 ? 1 : i11;
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (i14 != 0 || objRememberedValue4 == companion.getEmpty()) {
                objRememberedValue4 = new NavigationDrawer_androidKt$DrawerPredictiveBackHandler$3$1(drawerState, drawerPredictiveBackState, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            EffectsKt.LaunchedEffect(boolValueOf, (n) objRememberedValue4, composerStartRestartGroup, i11);
            oVar.invoke(drawerPredictiveBackState, composerStartRestartGroup, Integer.valueOf((i10 & 112) | 6));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new n() { // from class: androidx.compose.material3.NavigationDrawer_androidKt.DrawerPredictiveBackHandler.4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // S7.n
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return r.f317a;
                }

                public final void invoke(Composer composer2, int i15) {
                    NavigationDrawer_androidKt.DrawerPredictiveBackHandler(drawerState, oVar, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    public static final float getPredictiveBackDrawerMaxScaleXDistanceGrow() {
        return PredictiveBackDrawerMaxScaleXDistanceGrow;
    }

    public static final float getPredictiveBackDrawerMaxScaleXDistanceShrink() {
        return PredictiveBackDrawerMaxScaleXDistanceShrink;
    }

    public static final float getPredictiveBackDrawerMaxScaleYDistance() {
        return PredictiveBackDrawerMaxScaleYDistance;
    }
}
