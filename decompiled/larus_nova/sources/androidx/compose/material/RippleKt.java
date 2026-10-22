package androidx.compose.material;

import androidx.compose.foundation.IndicationNodeFactory;
import androidx.compose.material.ripple.RippleAlpha;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a-\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\b\u0010\t\u001a+\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\n2\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u000b\u0010\f\"\u0019\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0017\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0018\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"ripple", "Landroidx/compose/foundation/IndicationNodeFactory;", "bounded", "", "radius", "Landroidx/compose/ui/unit/Dp;", "color", "Landroidx/compose/ui/graphics/Color;", "ripple-H2RKhps", "(ZFJ)Landroidx/compose/foundation/IndicationNodeFactory;", "Landroidx/compose/ui/graphics/ColorProducer;", "ripple-wH6b6FI", "(Landroidx/compose/ui/graphics/ColorProducer;ZF)Landroidx/compose/foundation/IndicationNodeFactory;", "LocalRippleConfiguration", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/material/RippleConfiguration;", "getLocalRippleConfiguration", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "DefaultBoundedRipple", "Landroidx/compose/material/RippleNodeFactory;", "DefaultUnboundedRipple", "LightThemeHighContrastRippleAlpha", "Landroidx/compose/material/ripple/RippleAlpha;", "LightThemeLowContrastRippleAlpha", "DarkThemeRippleAlpha", "material"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class RippleKt {
    private static final RippleAlpha DarkThemeRippleAlpha = null;
    private static final RippleNodeFactory DefaultBoundedRipple = null;
    private static final RippleNodeFactory DefaultUnboundedRipple = null;
    private static final RippleAlpha LightThemeHighContrastRippleAlpha = null;
    private static final RippleAlpha LightThemeLowContrastRippleAlpha = null;
    private static final ProvidableCompositionLocal<RippleConfiguration> LocalRippleConfiguration = null;

    public static /* synthetic */ RippleConfiguration a() {
        return LocalRippleConfiguration$lambda$0();
    }

    static {
        LocalRippleConfiguration = CompositionLocalKt.compositionLocalOf$default(null, new t8(), 1, null);
        Dp.Companion r100 = Dp.Companion;
        float r101 = r100.m7564getUnspecifiedD9Ej5fM();
        Color.Companion r102 = Color.Companion;
        DefaultBoundedRipple = new RippleNodeFactory(true, r101, r102.m4863getUnspecified0d7_KjU(), null);
        DefaultUnboundedRipple = new RippleNodeFactory(false, r100.m7564getUnspecifiedD9Ej5fM(), r102.m4863getUnspecified0d7_KjU(), null);
        LightThemeHighContrastRippleAlpha = new RippleAlpha(0.16f, 0.24f, 0.08f, 0.24f);
        LightThemeLowContrastRippleAlpha = new RippleAlpha(0.08f, 0.12f, 0.04f, 0.12f);
        DarkThemeRippleAlpha = new RippleAlpha(0.08f, 0.12f, 0.04f, 0.1f);
    }

    private static final RippleConfiguration LocalRippleConfiguration$lambda$0() {
        return new RippleConfiguration(0, null, 3, null);
    }

    public static final /* synthetic */ RippleAlpha access$getDarkThemeRippleAlpha$p() {
        return DarkThemeRippleAlpha;
    }

    public static final /* synthetic */ RippleAlpha access$getLightThemeHighContrastRippleAlpha$p() {
        return LightThemeHighContrastRippleAlpha;
    }

    public static final /* synthetic */ RippleAlpha access$getLightThemeLowContrastRippleAlpha$p() {
        return LightThemeLowContrastRippleAlpha;
    }

    public static final ProvidableCompositionLocal<RippleConfiguration> getLocalRippleConfiguration() {
        return LocalRippleConfiguration;
    }

    /* JADX INFO: renamed from: ripple-H2RKhps, reason: not valid java name */
    public static final IndicationNodeFactory m1713rippleH2RKhps(boolean r100, float r101, long r102) {
        if (Dp.m7549equalsimpl0(r101, Dp.Companion.m7564getUnspecifiedD9Ej5fM()) == false) goto L11;
        if (Color.m4828equalsimpl0(r102, Color.Companion.m4863getUnspecified0d7_KjU()) == false) goto L11;
        if (r100 == false) goto L12;
        return DefaultBoundedRipple;
    L12:
        return DefaultUnboundedRipple;
    L11:
        return new RippleNodeFactory(r100, r101, r102, null);
    }

    /* JADX INFO: renamed from: ripple-wH6b6FI, reason: not valid java name */
    public static final IndicationNodeFactory m1715ripplewH6b6FI(ColorProducer r100, boolean r101, float r102) {
        return new RippleNodeFactory(r101, r102, r100, null);
    }

    /* JADX INFO: renamed from: ripple-H2RKhps$default, reason: not valid java name */
    public static /* synthetic */ IndicationNodeFactory m1714rippleH2RKhps$default(boolean r100, float r101, long r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = true;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = Dp.Companion.m7564getUnspecifiedD9Ej5fM();
    L9:
        if ((r103 & 4) == 0) goto L12;
        r102 = Color.Companion.m4863getUnspecified0d7_KjU();
    L12:
        return m1713rippleH2RKhps(r100, r101, r102);
    }

    /* JADX INFO: renamed from: ripple-wH6b6FI$default, reason: not valid java name */
    public static /* synthetic */ IndicationNodeFactory m1716ripplewH6b6FI$default(ColorProducer r100, boolean r101, float r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = true;
    L6:
        if ((r103 & 4) == 0) goto L9;
        r102 = Dp.Companion.m7564getUnspecifiedD9Ej5fM();
    L9:
        return m1715ripplewH6b6FI(r100, r101, r102);
    }
}
