package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a \u0010\u0000\u001a\u00020\u00012\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0004H\u0001¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"PlatformMaterialTheme", "", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "material"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class MaterialTheme_androidKt {
    private static final Unit PlatformMaterialTheme$lambda$0(Function2 r100, int r101, Composer r102, int r103) {
        PlatformMaterialTheme(r100, r102, RecomposeScopeImplKt.updateChangedFlags(r101 | 1));
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(Function2 r100, int r101, Composer r102, int r103) {
        return PlatformMaterialTheme$lambda$0(r100, r101, r102, r103);
    }

    public static final void PlatformMaterialTheme(final Function2<? super Composer, ? super Integer, Unit> r100, Composer r101, final int r102) {
        Composer r103 = r101.startRestartGroup(-1677843913);
        if ((r102 & 6) == 0) goto L5;
        int r104 = r102;
    L11:
        if ((r104 & 3) == 2) goto L13;
        boolean r105 = true;
    L15:
        if (r103.shouldExecute(r105, r104 & 1) == true) goto L17;
        r103.skipToGroupEnd();
    L23:
        ScopeUpdateScope r106 = r103.endRestartGroup();
        if (r106 == null) goto L27;
        r106.updateScope(new y5(r100, r102));
        return;
    L27:
        return;
    L17:
        if (ComposerKt.isTraceInProgress() == false) goto L19;
        ComposerKt.traceEventStart(-1677843913, r104, -1, "androidx.compose.material.PlatformMaterialTheme (MaterialTheme.android.kt:21)");
    L19:
        r100.invoke(r103, Integer.valueOf(r104 & 14));
        if (ComposerKt.isTraceInProgress() == false) goto L23;
        ComposerKt.traceEventEnd();
        goto L23
    L13:
        r105 = false;
        goto L15
    L5:
        if (r103.changedInstance(r100) == false) goto L7;
        int r107 = 4;
    L8:
        r104 = r107 | r102;
        goto L11
    L7:
        r107 = 2;
        goto L8
    }
}
