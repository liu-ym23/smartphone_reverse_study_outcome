package com.android.ttcjpaysdk.kmp.common.ui.overlay;

import a1.a;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"CJOverlayHost", "", "(Landroidx/compose/runtime/Composer;I)V", "cj_common_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class CJOverlayFoundationKt {
    private static final Unit CJOverlayHost$lambda$0(int r100, Composer r101, int r102) {
        CJOverlayHost(r101, RecomposeScopeImplKt.updateChangedFlags(r100 | 1));
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(int r100, Composer r101, int r102) {
        return CJOverlayHost$lambda$0(r100, r101, r102);
    }

    public static final void CJOverlayHost(Composer r100, final int r101) {
        Composer r102 = r100.startRestartGroup(417982197);
        if (r101 == 0) goto L5;
        boolean r103 = true;
    L7:
        if (r102.shouldExecute(r103, r101 & 1) == true) goto L9;
        r102.skipToGroupEnd();
    L15:
        ScopeUpdateScope r104 = r102.endRestartGroup();
        if (r104 == null) goto L19;
        r104.updateScope(new a(r101));
        return;
    L19:
        return;
    L9:
        if (ComposerKt.isTraceInProgress() == false) goto L11;
        ComposerKt.traceEventStart(417982197, r101, -1, "com.android.ttcjpaysdk.kmp.common.ui.overlay.CJOverlayHost (CJOverlayFoundation.kt:155)");
    L11:
        CJOverlayHost_androidKt.CJOverlayHostImpl(r102, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L15;
        ComposerKt.traceEventEnd();
        goto L15
    L5:
        r103 = false;
        goto L7
    }
}
