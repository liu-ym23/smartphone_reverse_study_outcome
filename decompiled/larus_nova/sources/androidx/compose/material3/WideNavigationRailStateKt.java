package androidx.compose.material3;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u0017\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0004\u001a\r\u0010\b\u001a\u00020\u0003*\u00020\u0003H\u0080\u0002\"\u0018\u0010\u0005\u001a\u00020\u0006*\u00020\u00038@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0007¨\u0006\t"}, d2 = {"rememberWideNavigationRailState", "Landroidx/compose/material3/WideNavigationRailState;", "initialValue", "Landroidx/compose/material3/WideNavigationRailValue;", "(Landroidx/compose/material3/WideNavigationRailValue;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/WideNavigationRailState;", "isExpanded", "", "(Landroidx/compose/material3/WideNavigationRailValue;)Z", "not", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class WideNavigationRailStateKt {
    public static /* synthetic */ WideNavigationRailState a(WideNavigationRailValue r100, FiniteAnimationSpec r101) {
        return rememberWideNavigationRailState$lambda$1$lambda$0(r100, r101);
    }

    public static final boolean isExpanded(WideNavigationRailValue r100) {
        if (r100 != WideNavigationRailValue.Expanded) goto L5;
        return true;
    L5:
        return false;
    }

    public static final WideNavigationRailValue not(WideNavigationRailValue r100) {
        WideNavigationRailValue r101 = WideNavigationRailValue.Collapsed;
        if (r100 == r101) goto L5;
        return r101;
    L5:
        return WideNavigationRailValue.Expanded;
    }

    private static final WideNavigationRailState rememberWideNavigationRailState$lambda$1$lambda$0(WideNavigationRailValue r100, FiniteAnimationSpec r101) {
        return new WideNavigationRailStateImpl(r100, r101);
    }

    public static final WideNavigationRailState rememberWideNavigationRailState(final WideNavigationRailValue r100, Composer r101, int r102, int r110) {
        boolean r103 = true;
        if ((r110 & 1) == 0) goto L6;
        r100 = WideNavigationRailValue.Collapsed;
    L6:
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventStart(1595273472, r102, -1, "androidx.compose.material3.rememberWideNavigationRailState (WideNavigationRailState.kt:86)");
    L8:
        final FiniteAnimationSpec r111 = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, r101, 6);
        Object[] r104 = new Object[0];
        Saver<WideNavigationRailState, WideNavigationRailValue> r105 = WideNavigationRailStateImpl.Companion.Saver(r111);
        if (((r102 & 14) ^ 6) <= 4) goto L13;
        if (r101.changed(r100.ordinal()) == false) goto L13;
    L16:
        boolean r106 = r101.changedInstance(r111) | r103;
        Object r107 = r101.rememberedValue();
        if (r106 == false) goto L19;
    L20:
        r107 = new sy(r100, r111);
        r101.updateRememberedValue(r107);
    L21:
        WideNavigationRailState r108 = (WideNavigationRailState) RememberSaveableKt.m4284rememberSaveable(r104, r105, (Function0) r107, r101, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L24;
        ComposerKt.traceEventEnd();
    L24:
        return r108;
    L19:
        if (r107 != Composer.Companion.getEmpty()) goto L21;
    L13:
        if ((r102 & 6) == 4) goto L16;
        r103 = false;
        goto L16
    }
}
