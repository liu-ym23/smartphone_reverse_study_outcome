package androidx.compose.material3;

import android.content.res.Configuration;
import android.graphics.Rect;
import android.view.View;
import androidx.compose.material3.internal.AccessibilityServiceStateProvider_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.RectHelper_androidKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.window.PopupProperties;
import com.byted.cast.sink.api.Option;
import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0002\u001a\u001b\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006H\u0001¢\u0006\u0002\u0010\u0007\u001a\u001f\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0001¢\u0006\u0004\b\u000e\u0010\u000f\u001a+\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006H\u0003¢\u0006\u0002\u0010\u0016\u001a\f\u0010\u0017\u001a\u00020\u0018*\u00020\u0012H\u0002¨\u0006\u0019²\u0006\n\u0010\u001a\u001a\u00020\rX\u008a\u0084\u0002"}, d2 = {"platformWindowBoundsCalculator", "Landroidx/compose/material3/WindowBoundsCalculator;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/WindowBoundsCalculator;", "OnPlatformWindowBoundsChange", "", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "popupPropertiesForAnchorType", "Landroidx/compose/ui/window/PopupProperties;", "anchorType", "Landroidx/compose/material3/ExposedDropdownMenuAnchorType;", "alwaysFocusable", "", "popupPropertiesForAnchorType-BTG8-q0", "(Ljava/lang/String;ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/ui/window/PopupProperties;", "SoftKeyboardListener", "view", "Landroid/view/View;", "density", "Landroidx/compose/ui/unit/Density;", "onKeyboardVisibilityChange", "(Landroid/view/View;Landroidx/compose/ui/unit/Density;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "getWindowBounds", "Landroidx/compose/ui/unit/IntRect;", "material3", "a11yServicesEnabled"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ExposedDropdownMenu_androidKt {
    private static final Unit OnPlatformWindowBoundsChange$lambda$1(Function0 r100, int r101, Composer r102, int r103) {
        OnPlatformWindowBoundsChange(r100, r102, RecomposeScopeImplKt.updateChangedFlags(r101 | 1));
        return Unit.INSTANCE;
    }

    private static final Unit SoftKeyboardListener$lambda$6(View r100, Density r101, Function0 r102, int r103, Composer r104, int r105) {
        SoftKeyboardListener(r100, r101, r102, r104, RecomposeScopeImplKt.updateChangedFlags(r103 | 1));
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(View r100, Density r101, Function0 r102, int r103, Composer r104, int r105) {
        return SoftKeyboardListener$lambda$6(r100, r101, r102, r103, r104, r105);
    }

    public static /* synthetic */ Unit b(Function0 r100, int r101, Composer r102, int r103) {
        return OnPlatformWindowBoundsChange$lambda$1(r100, r101, r102, r103);
    }

    public static /* synthetic */ DisposableEffectResult c(View r100, Function0 r101, DisposableEffectScope r102) {
        return SoftKeyboardListener$lambda$5$lambda$4(r100, r101, r102);
    }

    public static final /* synthetic */ IntRect access$getWindowBounds(View r100) {
        return getWindowBounds(r100);
    }

    private static final IntRect getWindowBounds(View r100) {
        Rect r101 = new Rect();
        r100.getWindowVisibleDisplayFrame(r101);
        return RectHelper_androidKt.toComposeIntRect(r101);
    }

    private static final boolean popupPropertiesForAnchorType_BTG8_q0$lambda$2(State<Boolean> r100) {
        return r100.getValue().booleanValue();
    }

    public static final WindowBoundsCalculator platformWindowBoundsCalculator(Composer r100, int r101) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(703324275, r101, -1, "androidx.compose.material3.platformWindowBoundsCalculator (ExposedDropdownMenu.android.kt:40)");
    L5:
        Object r102 = (Configuration) r100.consume(AndroidCompositionLocals_androidKt.getLocalConfiguration());
        View r103 = (View) r100.consume(AndroidCompositionLocals_androidKt.getLocalView());
        boolean r104 = r100.changed(r102) | r100.changed(r103);
        Object r105 = r100.rememberedValue();
        if (r104 == false) goto L8;
    L9:
        r105 = new WindowBoundsCalculator(r103);
        r100.updateRememberedValue(r105);
    L10:
        WindowBoundsCalculator r106 = (WindowBoundsCalculator) r105;
        if (ComposerKt.isTraceInProgress() == false) goto L13;
        ComposerKt.traceEventEnd();
    L13:
        return r106;
    L8:
        if (r105 != Composer.Companion.getEmpty()) goto L10;
        goto L9
    }

    public static final void OnPlatformWindowBoundsChange(final Function0<Unit> r100, Composer r101, final int r102) {
        Composer r103 = r101.startRestartGroup(-1646555525);
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
        r106.updateScope(new fb(r100, r102));
        return;
    L27:
        return;
    L17:
        if (ComposerKt.isTraceInProgress() == false) goto L19;
        ComposerKt.traceEventStart(-1646555525, r104, -1, "androidx.compose.material3.OnPlatformWindowBoundsChange (ExposedDropdownMenu.android.kt:47)");
    L19:
        SoftKeyboardListener((View) r103.consume(AndroidCompositionLocals_androidKt.getLocalView()), (Density) r103.consume(CompositionLocalsKt.getLocalDensity()), r100, r103, (r104 << 6) & MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RENDER_FRAME_COUNT);
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

    private static final DisposableEffectResult SoftKeyboardListener$lambda$5$lambda$4(View r100, Function0 r101, DisposableEffectScope r102) {
        final ExposedDropdownMenu_androidKt$SoftKeyboardListener$1$1$listener$1 r103 = new ExposedDropdownMenu_androidKt$SoftKeyboardListener$1$1$listener$1(r100, r101);
        return new ExposedDropdownMenu_androidKt$SoftKeyboardListener$lambda$5$lambda$4$$inlined$onDispose$1(r103);
    }

    /* JADX INFO: renamed from: popupPropertiesForAnchorType-BTG8-q0, reason: not valid java name */
    public static final PopupProperties m2223popupPropertiesForAnchorTypeBTG8q0(String r100, boolean r110, Composer r111, int r112) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(895018515, r112, -1, "androidx.compose.material3.popupPropertiesForAnchorType (ExposedDropdownMenu.android.kt:57)");
    L5:
        State<Boolean> r113 = AccessibilityServiceStateProvider_androidKt.rememberAccessibilityServiceState(false, false, false, r111, 0, 7);
        if (popupPropertiesForAnchorType_BTG8_q0$lambda$2(r113) == true) goto L8;
        int r114 = Option.BYTE_LINK_OPTION_20;
    L9:
        ExposedDropdownMenuAnchorType.Companion r101 = ExposedDropdownMenuAnchorType.Companion;
        if (ExposedDropdownMenuAnchorType.m2196equalsimpl0(r100, r101.m2200getPrimaryEditableoYjWRB4()) == false) goto L12;
    L17:
        boolean r102 = true;
    L18:
        if (r102 == false) goto L21;
        if (r110 == true) goto L21;
        r114 = r114 | 8;
    L21:
        PopupProperties r103 = new PopupProperties(r114, false, false, false, false, false, 62, null);
        if (ComposerKt.isTraceInProgress() == false) goto L24;
        ComposerKt.traceEventEnd();
    L24:
        return r103;
    L12:
        if (ExposedDropdownMenuAnchorType.m2196equalsimpl0(r100, r101.m2202getSecondaryEditableoYjWRB4()) == true) goto L14;
    L16:
        r102 = false;
        goto L18
    L14:
        if (popupPropertiesForAnchorType_BTG8_q0$lambda$2(r113) == true) goto L16;
    L8:
        r114 = 393216;
        goto L9
    }

    private static final void SoftKeyboardListener(final View r100, final Density r101, final Function0<Unit> r102, Composer r110, final int r111) {
        Composer r112 = r110.startRestartGroup(-1319522472);
        if ((r111 & 6) == 0) goto L5;
        int r103 = r111;
    L11:
        if ((r111 & 48) != 0) goto L18;
        if (r112.changed(r101) == false) goto L15;
        int r104 = 32;
    L16:
        r103 = r103 | r104;
        goto L18
    L15:
        r104 = 16;
    L18:
        if ((r111 & 384) == 0) goto L20;
    L24:
        boolean r105 = false;
        if ((r103 & 147) == 146) goto L27;
        boolean r106 = true;
    L29:
        if (r112.shouldExecute(r106, r103 & 1) == true) goto L31;
        r112.skipToGroupEnd();
    L45:
        ScopeUpdateScope r113 = r112.endRestartGroup();
        if (r113 == null) goto L49;
        r113.updateScope(new hb(r100, r101, r102, r111));
        return;
    L49:
        return;
    L31:
        if (ComposerKt.isTraceInProgress() == false) goto L33;
        ComposerKt.traceEventStart(-1319522472, r103, -1, "androidx.compose.material3.SoftKeyboardListener (ExposedDropdownMenu.android.kt:85)");
    L33:
        boolean r107 = r112.changedInstance(r100);
        if ((r103 & MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RENDER_FRAME_COUNT) != 256) goto L36;
        r105 = true;
    L36:
        boolean r108 = r107 | r105;
        Object r109 = r112.rememberedValue();
        if (r108 == false) goto L39;
    L40:
        r109 = new gb(r100, r102);
        r112.updateRememberedValue(r109);
    L41:
        EffectsKt.DisposableEffect(r100, r101, (Function1) r109, r112, (r103 & 14) | (r103 & 112));
        if (ComposerKt.isTraceInProgress() == false) goto L45;
        ComposerKt.traceEventEnd();
        goto L45
    L39:
        if (r109 != Composer.Companion.getEmpty()) goto L41;
    L27:
        r106 = false;
        goto L29
    L20:
        if (r112.changedInstance(r102) == false) goto L22;
        int r114 = 256;
    L23:
        r103 = r103 | r114;
        goto L24
    L22:
        r114 = 128;
        goto L23
    L5:
        if (r112.changedInstance(r100) == false) goto L7;
        int r115 = 4;
    L8:
        r103 = r115 | r111;
        goto L11
    L7:
        r115 = 2;
        goto L8
    }
}
