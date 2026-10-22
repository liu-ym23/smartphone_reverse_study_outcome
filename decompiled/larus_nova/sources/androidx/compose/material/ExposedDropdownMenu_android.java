package androidx.compose.material;

import android.graphics.Rect;
import android.view.View;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.graphics.RectHelper_androidKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.unit.IntRect;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0002\u001a\u001b\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006H\u0001¢\u0006\u0002\u0010\u0007\u001a\f\u0010\b\u001a\u00020\t*\u00020\nH\u0002¨\u0006\u000b"}, d2 = {"platformWindowBoundsCalculator", "Landroidx/compose/material/WindowBoundsCalculator;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material/WindowBoundsCalculator;", "OnPlatformWindowBoundsChange", "", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "getWindowBounds", "Landroidx/compose/ui/unit/IntRect;", "Landroid/view/View;", "material"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ExposedDropdownMenu_android {
    private static final Unit OnPlatformWindowBoundsChange$lambda$4(Function0 r100, int r101, Composer r102, int r103) {
        OnPlatformWindowBoundsChange(r100, r102, RecomposeScopeImplKt.updateChangedFlags(r101 | 1));
        return Unit.INSTANCE;
    }

    public static /* synthetic */ DisposableEffectResult a(View r100, Function0 r101, DisposableEffectScope r102) {
        return OnPlatformWindowBoundsChange$lambda$3$lambda$2(r100, r101, r102);
    }

    public static /* synthetic */ Unit b(Function0 r100, int r101, Composer r102, int r103) {
        return OnPlatformWindowBoundsChange$lambda$4(r100, r101, r102, r103);
    }

    public static final /* synthetic */ IntRect access$getWindowBounds(View r100) {
        return getWindowBounds(r100);
    }

    private static final IntRect getWindowBounds(View r100) {
        Rect r101 = new Rect();
        r100.getWindowVisibleDisplayFrame(r101);
        return RectHelper_androidKt.toComposeIntRect(r101);
    }

    public static final WindowBoundsCalculator platformWindowBoundsCalculator(Composer r100, int r101) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-1216067952, r101, -1, "androidx.compose.material.platformWindowBoundsCalculator (ExposedDropdownMenu.android.kt:35)");
    L5:
        View r102 = (View) r100.consume(AndroidCompositionLocals_androidKt.getLocalView());
        boolean r103 = r100.changed(r102);
        Object r104 = r100.rememberedValue();
        if (r103 == false) goto L8;
    L9:
        r104 = new WindowBoundsCalculator(r102);
        r100.updateRememberedValue(r104);
    L10:
        WindowBoundsCalculator r105 = (WindowBoundsCalculator) r104;
        if (ComposerKt.isTraceInProgress() == false) goto L13;
        ComposerKt.traceEventEnd();
    L13:
        return r105;
    L8:
        if (r104 != Composer.Companion.getEmpty()) goto L10;
        goto L9
    }

    public static final void OnPlatformWindowBoundsChange(final Function0<Unit> r100, Composer r101, final int r102) {
        Composer r103 = r101.startRestartGroup(1063434120);
        if ((r102 & 6) == 0) goto L5;
        int r104 = r102;
    L10:
        boolean r105 = true;
        if ((r104 & 3) == 2) goto L13;
        boolean r106 = true;
    L15:
        if (r103.shouldExecute(r106, r104 & 1) == true) goto L17;
        r103.skipToGroupEnd();
    L32:
        ScopeUpdateScope r107 = r103.endRestartGroup();
        if (r107 == null) goto L36;
        r107.updateScope(new z4(r100, r102));
        return;
    L36:
        return;
    L17:
        if (ComposerKt.isTraceInProgress() == false) goto L19;
        ComposerKt.traceEventStart(1063434120, r104, -1, "androidx.compose.material.OnPlatformWindowBoundsChange (ExposedDropdownMenu.android.kt:41)");
    L19:
        final View r108 = (View) r103.consume(AndroidCompositionLocals_androidKt.getLocalView());
        boolean r109 = r103.changedInstance(r108);
        if ((r104 & 14) == 4) goto L23;
        r105 = false;
    L23:
        boolean r110 = r109 | r105;
        Object r111 = r103.rememberedValue();
        if (r110 == false) goto L26;
    L27:
        r111 = new y4(r108, r100);
        r103.updateRememberedValue(r111);
    L28:
        EffectsKt.DisposableEffect(r108, (Function1) r111, r103, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L32;
        ComposerKt.traceEventEnd();
        goto L32
    L26:
        if (r111 != Composer.Companion.getEmpty()) goto L28;
    L13:
        r106 = false;
        goto L15
    L5:
        if (r103.changedInstance(r100) == false) goto L7;
        int r112 = 4;
    L8:
        r104 = r112 | r102;
        goto L10
    L7:
        r112 = 2;
        goto L8
    }

    private static final DisposableEffectResult OnPlatformWindowBoundsChange$lambda$3$lambda$2(View r100, Function0 r101, DisposableEffectScope r102) {
        final OnGlobalLayoutListener r103 = new OnGlobalLayoutListener(r100, r101);
        return new ExposedDropdownMenu_android$OnPlatformWindowBoundsChange$lambda$3$lambda$2$$inlined$onDispose$1(r103);
    }
}
