package androidx.compose.material3.internal;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0002\u001a-\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\tH\u0001¢\u0006\u0002\u0010\n¨\u0006\u000b²\u0006\u0010\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\tX\u008a\u0084\u0002"}, d2 = {"rememberPredictiveBackState", "Landroidx/compose/material3/internal/PredictiveBackState;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/internal/PredictiveBackState;", "PredictiveBackStateHandler", "", "state", "enabled", "", com.alipay.sdk.m.x.d.f25924n, "Lkotlin/Function0;", "(Landroidx/compose/material3/internal/PredictiveBackState;ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "material3", "currentOnBack"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class BasicEdgeToEdgeDialogKt {
    private static final Unit PredictiveBackStateHandler$lambda$3(PredictiveBackState r100, boolean r101, Function0 r102, int r103, int r110, Composer r111, int r112) {
        PredictiveBackStateHandler(r100, r101, r102, r111, RecomposeScopeImplKt.updateChangedFlags(r103 | 1), r110);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(PredictiveBackState r100, boolean r101, Function0 r102, int r103, int r104, Composer r105, int r106) {
        return PredictiveBackStateHandler$lambda$3(r100, r101, r102, r103, r104, r105, r106);
    }

    private static final Function0<Unit> PredictiveBackStateHandler$lambda$1(State<? extends Function0<Unit>> r100) {
        return r100.getValue();
    }

    public static final /* synthetic */ Function0 access$PredictiveBackStateHandler$lambda$1(State r100) {
        return PredictiveBackStateHandler$lambda$1(r100);
    }

    public static final PredictiveBackState rememberPredictiveBackState(Composer r100, int r101) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(1883443352, r101, -1, "androidx.compose.material3.internal.rememberPredictiveBackState (BasicEdgeToEdgeDialog.kt:77)");
    L5:
        Object r102 = r100.rememberedValue();
        if (r102 != Composer.Companion.getEmpty()) goto L8;
        r102 = new PredictiveBackStateImpl();
        r100.updateRememberedValue(r102);
    L8:
        PredictiveBackStateImpl r103 = (PredictiveBackStateImpl) r102;
        if (ComposerKt.isTraceInProgress() == false) goto L11;
        ComposerKt.traceEventEnd();
    L11:
        return r103;
    }

    public static final void PredictiveBackStateHandler(final PredictiveBackState r100, boolean r101, final Function0<Unit> r110, Composer r111, final int r112, final int r113) {
        Composer r114 = r111.startRestartGroup(698755635);
        if ((r113 & 1) == 0) goto L6;
        int r102 = r112 | 6;
    L16:
        int r103 = r113 & 2;
        if (r103 == 0) goto L20;
        r102 = r102 | 48;
    L27:
        if ((r113 & 4) == 0) goto L30;
        r102 = r102 | 384;
    L36:
        boolean r104 = true;
        if ((r102 & 147) == 146) goto L39;
        boolean r105 = true;
    L41:
        if (r114.shouldExecute(r105, r102 & 1) == false) goto L69;
        if (r103 == 0) goto L45;
        r101 = true;
    L45:
        if (ComposerKt.isTraceInProgress() == false) goto L47;
        ComposerKt.traceEventStart(698755635, r102, -1, "androidx.compose.material3.internal.PredictiveBackStateHandler (BasicEdgeToEdgeDialog.kt:90)");
    L47:
        State r106 = SnapshotStateKt.rememberUpdatedState(r110, r114, (r102 >> 6) & 14);
        r114.startMovableGroup(1489276985, r100);
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type androidx.compose.material3.internal.PredictiveBackStateImpl");
        PredictiveBackStateImpl r107 = (PredictiveBackStateImpl) r100;
        if (r101 == true) goto L50;
    L52:
        boolean r108 = false;
    L54:
        if ((r102 & 14) != 4) goto L56;
    L61:
        boolean r109 = r114.changed(r106) | r104;
        Object r115 = r114.rememberedValue();
        if (r109 == false) goto L64;
    L65:
        r115 = new BasicEdgeToEdgeDialogKt$PredictiveBackStateHandler$1$1(r100, r106, null);
        r114.updateRememberedValue(r115);
    L66:
        BackHandler_androidKt.PredictiveBackHandler(r108, (Function2) r115, r114, 0, 0);
        r114.endMovableGroup();
        if (ComposerKt.isTraceInProgress() == false) goto L70;
        ComposerKt.traceEventEnd();
    L70:
        final boolean r116 = r101;
        ScopeUpdateScope r117 = r114.endRestartGroup();
        if (r117 == null) goto L74;
        r117.updateScope(new b0(r100, r116, r110, r112, r113));
        return;
    L74:
        return;
    L64:
        if (r115 != Composer.Companion.getEmpty()) goto L66;
    L56:
        if ((r102 & 8) != 0) goto L58;
    L60:
        r104 = false;
        goto L61
    L58:
        if (r114.changedInstance(r100) == false) goto L60;
    L50:
        if ((r107.getValue() instanceof BackEventProgress.Completed) == true) goto L52;
        r108 = true;
        goto L54
    L69:
        r114.skipToGroupEnd();
        goto L70
    L39:
        r105 = false;
        goto L41
    L30:
        if ((r112 & 384) != 0) goto L36;
        if (r114.changedInstance(r110) == false) goto L34;
        int r118 = 256;
    L35:
        r102 = r102 | r118;
        goto L36
    L34:
        r118 = 128;
        goto L35
    L20:
        if ((r112 & 48) != 0) goto L27;
        if (r114.changed(r101) == false) goto L24;
        int r119 = 32;
    L25:
        r102 = r102 | r119;
        goto L27
    L24:
        r119 = 16;
        goto L25
    L6:
        if ((r112 & 6) == 0) goto L8;
        r102 = r112;
        goto L16
    L8:
        if ((r112 & 8) != 0) goto L10;
        boolean r120 = r114.changed(r100);
    L11:
        if (r120 == false) goto L13;
        int r121 = 4;
    L14:
        r102 = r121 | r112;
        goto L16
    L13:
        r121 = 2;
        goto L14
    L10:
        r120 = r114.changedInstance(r100);
        goto L11
    }
}
