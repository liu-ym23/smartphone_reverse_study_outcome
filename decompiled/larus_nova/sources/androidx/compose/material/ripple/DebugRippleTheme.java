package androidx.compose.material.ripple;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import kotlin.Deprecated;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0004\u001a\u00020\u0005H\u0017¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\b\u001a\u00020\tH\u0017¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"Landroidx/compose/material/ripple/DebugRippleTheme;", "Landroidx/compose/material/ripple/RippleTheme;", "<init>", "()V", "defaultColor", "Landroidx/compose/ui/graphics/Color;", "defaultColor-WaAFU9c", "(Landroidx/compose/runtime/Composer;I)J", "rippleAlpha", "Landroidx/compose/material/ripple/RippleAlpha;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material/ripple/RippleAlpha;", "material-ripple"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class DebugRippleTheme implements RippleTheme {
    public static final DebugRippleTheme INSTANCE = null;

    static {
        INSTANCE = new DebugRippleTheme();
    }

    private DebugRippleTheme() {
    }

    @Override // androidx.compose.material.ripple.RippleTheme
    @Deprecated(message = "Super method is deprecated")
    /* JADX INFO: renamed from: defaultColor-WaAFU9c, reason: not valid java name */
    public long mo1820defaultColorWaAFU9c(Composer r100, int r101) {
        r100.startReplaceGroup(2042140174);
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(2042140174, r101, -1, "androidx.compose.material.ripple.DebugRippleTheme.defaultColor (RippleTheme.kt:237)");
    L5:
        long r102 = RippleTheme.Companion.m1832defaultRippleColor5vOe2sY(Color.Companion.m4853getBlack0d7_KjU(), true);
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        r100.endReplaceGroup();
        return r102;
    }

    @Override // androidx.compose.material.ripple.RippleTheme
    @Deprecated(message = "Super method is deprecated")
    public RippleAlpha rippleAlpha(Composer r100, int r101) {
        r100.startReplaceGroup(-1629816343);
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-1629816343, r101, -1, "androidx.compose.material.ripple.DebugRippleTheme.rippleAlpha (RippleTheme.kt:242)");
    L5:
        RippleAlpha r102 = RippleTheme.Companion.m1831defaultRippleAlphaDxMtmZc(Color.Companion.m4853getBlack0d7_KjU(), true);
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        r100.endReplaceGroup();
        return r102;
    }
}
