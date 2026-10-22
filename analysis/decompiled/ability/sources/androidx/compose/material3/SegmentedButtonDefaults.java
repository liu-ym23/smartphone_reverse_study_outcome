package androidx.compose.material3;

import C7.r;
import S7.n;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.CheckKt;
import androidx.compose.material3.tokens.OutlinedSegmentedButtonTokens;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ReadOnlyComposable;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Stable
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u008a\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u00072\b\b\u0002\u0010\u0010\u001a\u00020\u00072\b\b\u0002\u0010\u0011\u001a\u00020\u00072\b\b\u0002\u0010\u0012\u001a\u00020\u00072\b\b\u0002\u0010\u0013\u001a\u00020\u0007H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J)\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00162\b\b\u0002\u0010\u001a\u001a\u00020\u0019H\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001f\u001a\u00020\u001eH\u0007¢\u0006\u0004\b\u001f\u0010 JC\u0010'\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020!2\u0013\b\u0002\u0010%\u001a\r\u0012\u0004\u0012\u00020\u001e0#¢\u0006\u0002\b$2\u0015\b\u0002\u0010&\u001a\u000f\u0012\u0004\u0012\u00020\u001e\u0018\u00010#¢\u0006\u0002\b$H\u0007¢\u0006\u0004\b'\u0010(J\"\u0010/\u001a\u00020,2\u0006\u0010)\u001a\u00020\u00072\b\b\u0002\u0010+\u001a\u00020*ø\u0001\u0000¢\u0006\u0004\b-\u0010.R\u001d\u00100\u001a\u00020*8\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R\u001d\u00104\u001a\u00020*8\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b4\u00101\u001a\u0004\b5\u00103R\u0018\u00109\u001a\u00020\u0004*\u0002068@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b7\u00108R\u0011\u0010\u001a\u001a\u00020\u00198G¢\u0006\u0006\u001a\u0004\b:\u0010;\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006<"}, d2 = {"Landroidx/compose/material3/SegmentedButtonDefaults;", "", AppAgent.CONSTRUCT, "()V", "Landroidx/compose/material3/SegmentedButtonColors;", "colors", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/SegmentedButtonColors;", "Landroidx/compose/ui/graphics/Color;", "activeContainerColor", "activeContentColor", "activeBorderColor", "inactiveContainerColor", "inactiveContentColor", "inactiveBorderColor", "disabledActiveContainerColor", "disabledActiveContentColor", "disabledActiveBorderColor", "disabledInactiveContainerColor", "disabledInactiveContentColor", "disabledInactiveBorderColor", "colors-XqyqHi0", "(JJJJJJJJJJJJLandroidx/compose/runtime/Composer;III)Landroidx/compose/material3/SegmentedButtonColors;", "", "index", "count", "Landroidx/compose/foundation/shape/CornerBasedShape;", "baseShape", "Landroidx/compose/ui/graphics/Shape;", "itemShape", "(IILandroidx/compose/foundation/shape/CornerBasedShape;Landroidx/compose/runtime/Composer;II)Landroidx/compose/ui/graphics/Shape;", "LC7/r;", "ActiveIcon", "(Landroidx/compose/runtime/Composer;I)V", "", "active", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "activeContent", "inactiveContent", "Icon", "(ZLS7/n;LS7/n;Landroidx/compose/runtime/Composer;II)V", TypedValues.Custom.S_COLOR, "Landroidx/compose/ui/unit/Dp;", "width", "Landroidx/compose/foundation/BorderStroke;", "borderStroke-l07J4OM", "(JF)Landroidx/compose/foundation/BorderStroke;", "borderStroke", "BorderWidth", "F", "getBorderWidth-D9Ej5fM", "()F", "IconSize", "getIconSize-D9Ej5fM", "Landroidx/compose/material3/ColorScheme;", "getDefaultSegmentedButtonColors$material3_release", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/SegmentedButtonColors;", "defaultSegmentedButtonColors", "getBaseShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/shape/CornerBasedShape;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SegmentedButtonDefaults {
    public static final int $stable = 0;
    private static final float BorderWidth;
    public static final SegmentedButtonDefaults INSTANCE = new SegmentedButtonDefaults();
    private static final float IconSize;

    static {
        OutlinedSegmentedButtonTokens outlinedSegmentedButtonTokens = OutlinedSegmentedButtonTokens.INSTANCE;
        BorderWidth = outlinedSegmentedButtonTokens.m3136getOutlineWidthD9Ej5fM();
        IconSize = outlinedSegmentedButtonTokens.m3135getIconSizeD9Ej5fM();
    }

    private SegmentedButtonDefaults() {
    }

    /* renamed from: borderStroke-l07J4OM$default, reason: not valid java name */
    public static /* synthetic */ BorderStroke m2216borderStrokel07J4OM$default(SegmentedButtonDefaults segmentedButtonDefaults, long j5, float f, int i, Object obj) {
        if ((i & 2) != 0) {
            f = BorderWidth;
        }
        return segmentedButtonDefaults.m2217borderStrokel07J4OM(j5, f);
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void ActiveIcon(Composer composer, final int i) {
        int i6;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1273041460);
        if ((i & 6) == 0) {
            i6 = (composerStartRestartGroup.changed(this) ? 4 : 2) | i;
        } else {
            i6 = i;
        }
        if ((i6 & 3) == 2 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1273041460, i6, -1, "androidx.compose.material3.SegmentedButtonDefaults.ActiveIcon (SegmentedButton.kt:545)");
            }
            IconKt.m1909Iconww6aTOc(CheckKt.getCheck(Icons.Filled.INSTANCE), (String) null, SizeKt.m745size3ABfNKs(Modifier.INSTANCE, IconSize), 0L, composerStartRestartGroup, 48, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new n() { // from class: androidx.compose.material3.SegmentedButtonDefaults.ActiveIcon.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // S7.n
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return r.f317a;
                }

                public final void invoke(Composer composer2, int i10) {
                    SegmentedButtonDefaults.this.ActiveIcon(composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:63:? A[RETURN, SYNTHETIC] */
    @androidx.compose.runtime.Composable
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[0[0][0]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void Icon(final boolean r17, S7.n r18, S7.n r19, androidx.compose.runtime.Composer r20, final int r21, final int r22) {
        /*
            Method dump skipped, instructions count: 295
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SegmentedButtonDefaults.Icon(boolean, S7.n, S7.n, androidx.compose.runtime.Composer, int, int):void");
    }

    /* renamed from: borderStroke-l07J4OM, reason: not valid java name */
    public final BorderStroke m2217borderStrokel07J4OM(long color, float width) {
        return BorderStrokeKt.m268BorderStrokecXLIe8U(width, color);
    }

    @Composable
    public final SegmentedButtonColors colors(Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(679457321, i, -1, "androidx.compose.material3.SegmentedButtonDefaults.colors (SegmentedButton.kt:431)");
        }
        SegmentedButtonColors defaultSegmentedButtonColors$material3_release = getDefaultSegmentedButtonColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return defaultSegmentedButtonColors$material3_release;
    }

    @Composable
    /* renamed from: colors-XqyqHi0, reason: not valid java name */
    public final SegmentedButtonColors m2218colorsXqyqHi0(long j5, long j6, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, Composer composer, int i, int i6, int i10) {
        long j20;
        long j21;
        long jM4175getUnspecified0d7_KjU = (i10 & 1) != 0 ? Color.INSTANCE.m4175getUnspecified0d7_KjU() : j5;
        long jM4175getUnspecified0d7_KjU2 = (i10 & 2) != 0 ? Color.INSTANCE.m4175getUnspecified0d7_KjU() : j6;
        long jM4175getUnspecified0d7_KjU3 = (i10 & 4) != 0 ? Color.INSTANCE.m4175getUnspecified0d7_KjU() : j10;
        long jM4175getUnspecified0d7_KjU4 = (i10 & 8) != 0 ? Color.INSTANCE.m4175getUnspecified0d7_KjU() : j11;
        long jM4175getUnspecified0d7_KjU5 = (i10 & 16) != 0 ? Color.INSTANCE.m4175getUnspecified0d7_KjU() : j12;
        long jM4175getUnspecified0d7_KjU6 = (i10 & 32) != 0 ? Color.INSTANCE.m4175getUnspecified0d7_KjU() : j13;
        long jM4175getUnspecified0d7_KjU7 = (i10 & 64) != 0 ? Color.INSTANCE.m4175getUnspecified0d7_KjU() : j14;
        long jM4175getUnspecified0d7_KjU8 = (i10 & 128) != 0 ? Color.INSTANCE.m4175getUnspecified0d7_KjU() : j15;
        long j22 = jM4175getUnspecified0d7_KjU;
        long jM4175getUnspecified0d7_KjU9 = (i10 & 256) != 0 ? Color.INSTANCE.m4175getUnspecified0d7_KjU() : j16;
        long jM4175getUnspecified0d7_KjU10 = (i10 & 512) != 0 ? Color.INSTANCE.m4175getUnspecified0d7_KjU() : j17;
        long jM4175getUnspecified0d7_KjU11 = (i10 & 1024) != 0 ? Color.INSTANCE.m4175getUnspecified0d7_KjU() : j18;
        long jM4175getUnspecified0d7_KjU12 = (i10 & 2048) != 0 ? Color.INSTANCE.m4175getUnspecified0d7_KjU() : j19;
        if (ComposerKt.isTraceInProgress()) {
            j20 = jM4175getUnspecified0d7_KjU11;
            j21 = jM4175getUnspecified0d7_KjU2;
            ComposerKt.traceEventStart(132526205, i, i6, "androidx.compose.material3.SegmentedButtonDefaults.colors (SegmentedButton.kt:467)");
        } else {
            j20 = jM4175getUnspecified0d7_KjU11;
            j21 = jM4175getUnspecified0d7_KjU2;
        }
        SegmentedButtonColors segmentedButtonColorsM2203copy2qZNXz8 = getDefaultSegmentedButtonColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer, 6)).m2203copy2qZNXz8(j22, j21, jM4175getUnspecified0d7_KjU3, jM4175getUnspecified0d7_KjU4, jM4175getUnspecified0d7_KjU5, jM4175getUnspecified0d7_KjU6, jM4175getUnspecified0d7_KjU7, jM4175getUnspecified0d7_KjU8, jM4175getUnspecified0d7_KjU9, jM4175getUnspecified0d7_KjU10, j20, jM4175getUnspecified0d7_KjU12);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return segmentedButtonColorsM2203copy2qZNXz8;
    }

    @Composable
    @ReadOnlyComposable
    public final CornerBasedShape getBaseShape(Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1264240381, i, -1, "androidx.compose.material3.SegmentedButtonDefaults.<get-baseShape> (SegmentedButton.kt:512)");
        }
        Shape value = ShapesKt.getValue(OutlinedSegmentedButtonTokens.INSTANCE.getShape(), composer, 6);
        k.d(value, "null cannot be cast to non-null type androidx.compose.foundation.shape.CornerBasedShape");
        CornerBasedShape cornerBasedShape = (CornerBasedShape) value;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return cornerBasedShape;
    }

    /* renamed from: getBorderWidth-D9Ej5fM, reason: not valid java name */
    public final float m2219getBorderWidthD9Ej5fM() {
        return BorderWidth;
    }

    public final SegmentedButtonColors getDefaultSegmentedButtonColors$material3_release(ColorScheme colorScheme) {
        SegmentedButtonColors defaultSegmentedButtonColorsCached = colorScheme.getDefaultSegmentedButtonColorsCached();
        if (defaultSegmentedButtonColorsCached != null) {
            return defaultSegmentedButtonColorsCached;
        }
        OutlinedSegmentedButtonTokens outlinedSegmentedButtonTokens = OutlinedSegmentedButtonTokens.INSTANCE;
        SegmentedButtonColors segmentedButtonColors = new SegmentedButtonColors(ColorSchemeKt.fromToken(colorScheme, outlinedSegmentedButtonTokens.getSelectedContainerColor()), ColorSchemeKt.fromToken(colorScheme, outlinedSegmentedButtonTokens.getSelectedLabelTextColor()), ColorSchemeKt.fromToken(colorScheme, outlinedSegmentedButtonTokens.getOutlineColor()), colorScheme.getSurface(), ColorSchemeKt.fromToken(colorScheme, outlinedSegmentedButtonTokens.getUnselectedLabelTextColor()), ColorSchemeKt.fromToken(colorScheme, outlinedSegmentedButtonTokens.getOutlineColor()), ColorSchemeKt.fromToken(colorScheme, outlinedSegmentedButtonTokens.getSelectedContainerColor()), Color.m4138copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, outlinedSegmentedButtonTokens.getDisabledLabelTextColor()), outlinedSegmentedButtonTokens.getDisabledLabelTextOpacity(), 0.0f, 0.0f, 0.0f, 14, null), Color.m4138copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, outlinedSegmentedButtonTokens.getOutlineColor()), outlinedSegmentedButtonTokens.getDisabledOutlineOpacity(), 0.0f, 0.0f, 0.0f, 14, null), colorScheme.getSurface(), ColorSchemeKt.fromToken(colorScheme, outlinedSegmentedButtonTokens.getDisabledLabelTextColor()), ColorSchemeKt.fromToken(colorScheme, outlinedSegmentedButtonTokens.getOutlineColor()), null);
        colorScheme.setDefaultSegmentedButtonColorsCached$material3_release(segmentedButtonColors);
        return segmentedButtonColors;
    }

    /* renamed from: getIconSize-D9Ej5fM, reason: not valid java name */
    public final float m2220getIconSizeD9Ej5fM() {
        return IconSize;
    }

    @Composable
    @ReadOnlyComposable
    public final Shape itemShape(int i, int i6, CornerBasedShape cornerBasedShape, Composer composer, int i10, int i11) {
        if ((i11 & 4) != 0) {
            cornerBasedShape = getBaseShape(composer, (i10 >> 9) & 14);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-942072063, i10, -1, "androidx.compose.material3.SegmentedButtonDefaults.itemShape (SegmentedButton.kt:528)");
        }
        if (i6 == 1) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            return cornerBasedShape;
        }
        Shape shapeStart = i == 0 ? ShapesKt.start(cornerBasedShape) : i == i6 - 1 ? ShapesKt.end(cornerBasedShape) : RectangleShapeKt.getRectangleShape();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return shapeStart;
    }
}
