package androidx.compose.foundation.layout;

import android.os.Build;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import com.bytedance.android.livesdk.diagnose.DiagnoseResult;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0006\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u0007\u001a\u001f\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0001¢\u0006\u0004\b\b\u0010\t\"\u000e\u0010\n\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0014\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0015\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"imeNestedScroll", "Landroidx/compose/ui/Modifier;", "rememberWindowInsetsConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "windowInsets", "Landroidx/compose/foundation/layout/AndroidWindowInsets;", "side", "Landroidx/compose/foundation/layout/WindowInsetsSides;", "rememberWindowInsetsConnection-VRgvIgI", "(Landroidx/compose/foundation/layout/AndroidWindowInsets;ILandroidx/compose/runtime/Composer;I)Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "Inflection", "", "PlatformFlingScrollFriction", "GravityEarth", "InchesPerMeter", "DecelerationRate", "", "DecelMinusOne", "StartTension", "EndTension", DiagnoseResult.DIAGNOSE_LEVEL_P1, DiagnoseResult.DIAGNOSE_LEVEL_P2, "foundation-layout"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class WindowInsetsConnection_androidKt {
    private static final double DecelMinusOne = 0.0d;
    private static final double DecelerationRate = 0.0d;
    private static final float EndTension = 1.0f;
    private static final float GravityEarth = 9.80665f;
    private static final float InchesPerMeter = 39.37f;
    private static final float Inflection = 0.35f;
    private static final float P1 = 0.175f;
    private static final float P2 = 0.35000002f;
    private static final float PlatformFlingScrollFriction = 0.0f;
    private static final float StartTension = 0.5f;

    public static /* synthetic */ DisposableEffectResult a(WindowInsetsNestedScrollConnection r100, DisposableEffectScope r101) {
        return rememberWindowInsetsConnection_VRgvIgI$lambda$4$lambda$3(r100, r101);
    }

    static {
        PlatformFlingScrollFriction = ViewConfiguration.getScrollFriction();
        double r100 = Math.log(0.78d) / Math.log(0.9d);
        DecelerationRate = r100;
        DecelMinusOne = r100 - 1.0d;
    }

    public static final /* synthetic */ double access$getDecelMinusOne$p() {
        return DecelMinusOne;
    }

    public static final /* synthetic */ double access$getDecelerationRate$p() {
        return DecelerationRate;
    }

    public static final /* synthetic */ float access$getPlatformFlingScrollFriction$p() {
        return PlatformFlingScrollFriction;
    }

    public static final Modifier imeNestedScroll(Modifier r100) {
        if (Build.VERSION.SDK_INT >= 30) goto L6;
        return r100;
    L6:
        if (InspectableValueKt.isDebugInspectorInfoEnabled() == false) goto L8;
        Function1<InspectorInfo, Unit> r101 = new WindowInsetsConnection_androidKt$imeNestedScroll$$inlined$debugInspectorInfo$1();
    L10:
        return ComposedModifierKt.composed(r100, r101, AnonymousClass2.INSTANCE);
    L8:
        r101 = InspectableValueKt.getNoInspectorInfo();
        goto L10
    }

    private static final DisposableEffectResult rememberWindowInsetsConnection_VRgvIgI$lambda$4$lambda$3(final WindowInsetsNestedScrollConnection r100, DisposableEffectScope r101) {
        return new WindowInsetsConnection_androidKt$rememberWindowInsetsConnection_VRgvIgI$lambda$4$lambda$3$$inlined$onDispose$1(r100);
    }

    /* JADX INFO: renamed from: rememberWindowInsetsConnection-VRgvIgI, reason: not valid java name */
    public static final NestedScrollConnection m801rememberWindowInsetsConnectionVRgvIgI(AndroidWindowInsets r100, int r101, Composer r102, int r103) {
        r102.startReplaceGroup(-1011341039);
        if (ComposerKt.isTraceInProgress() == false) goto L6;
        ComposerKt.traceEventStart(-1011341039, r103, -1, "androidx.compose.foundation.layout.rememberWindowInsetsConnection (WindowInsetsConnection.android.kt:105)");
    L6:
        if (Build.VERSION.SDK_INT >= 30) goto L12;
        DoNothingNestedScrollConnection r104 = DoNothingNestedScrollConnection.INSTANCE;
        if (ComposerKt.isTraceInProgress() == false) goto L10;
        ComposerKt.traceEventEnd();
    L10:
        r102.endReplaceGroup();
        return r104;
    L12:
        LayoutDirection r105 = (LayoutDirection) r102.consume(CompositionLocalsKt.getLocalLayoutDirection());
        SideCalculator r106 = SideCalculator.Companion.m761chooseCalculatorni1skBw(r101, r105);
        View r107 = (View) r102.consume(AndroidCompositionLocals_androidKt.getLocalView());
        Density r108 = (Density) r102.consume(CompositionLocalsKt.getLocalDensity());
        if (((r103 & 14) ^ 6) <= 4) goto L17;
        if (r102.changed(r100) == false) goto L17;
    L18:
        boolean r109 = true;
    L20:
        boolean r110 = ((r109 | r102.changed(r107)) | r102.changed(r106)) | r102.changed(r108);
        Object r111 = r102.rememberedValue();
        if (r110 == false) goto L23;
    L24:
        r111 = new WindowInsetsNestedScrollConnection(r100, r107, r106, r108);
        r102.updateRememberedValue(r111);
    L25:
        final WindowInsetsNestedScrollConnection r112 = (WindowInsetsNestedScrollConnection) r111;
        boolean r113 = r102.changedInstance(r112);
        Object r114 = r102.rememberedValue();
        if (r113 == false) goto L28;
    L29:
        r114 = new g2(r112);
        r102.updateRememberedValue(r114);
    L30:
        EffectsKt.DisposableEffect(r112, (Function1) r114, r102, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L33;
        ComposerKt.traceEventEnd();
    L33:
        r102.endReplaceGroup();
        return r112;
    L28:
        if (r114 != Composer.Companion.getEmpty()) goto L30;
    L23:
        if (r111 != Composer.Companion.getEmpty()) goto L25;
    L17:
        if ((r103 & 6) == 4) goto L18;
        r109 = false;
        goto L20
    }
}
