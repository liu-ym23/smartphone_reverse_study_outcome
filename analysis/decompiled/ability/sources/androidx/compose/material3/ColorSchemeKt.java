package androidx.compose.material3;

import androidx.compose.material3.tokens.ColorDarkTokens;
import androidx.compose.material3.tokens.ColorLightTokens;
import androidx.compose.material3.tokens.ColorSchemeKeyTokens;
import androidx.compose.material3.tokens.PaletteTokens;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ReadOnlyComposable;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import kotlin.Metadata;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b5\n\u0002\u0018\u0002\n\u0002\b\n\u001a\u001a\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000bH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a´\u0002\u0010\u0013\u001a\u00020\u00042\b\b\u0002\u0010\u0014\u001a\u00020\u000b2\b\b\u0002\u0010\u0015\u001a\u00020\u000b2\b\b\u0002\u0010\u0016\u001a\u00020\u000b2\b\b\u0002\u0010\u0017\u001a\u00020\u000b2\b\b\u0002\u0010\u0018\u001a\u00020\u000b2\b\b\u0002\u0010\u0019\u001a\u00020\u000b2\b\b\u0002\u0010\u001a\u001a\u00020\u000b2\b\b\u0002\u0010\u001b\u001a\u00020\u000b2\b\b\u0002\u0010\u001c\u001a\u00020\u000b2\b\b\u0002\u0010\u001d\u001a\u00020\u000b2\b\b\u0002\u0010\u001e\u001a\u00020\u000b2\b\b\u0002\u0010\u001f\u001a\u00020\u000b2\b\b\u0002\u0010 \u001a\u00020\u000b2\b\b\u0002\u0010!\u001a\u00020\u000b2\b\b\u0002\u0010\"\u001a\u00020\u000b2\b\b\u0002\u0010#\u001a\u00020\u000b2\b\b\u0002\u0010$\u001a\u00020\u000b2\b\b\u0002\u0010%\u001a\u00020\u000b2\b\b\u0002\u0010&\u001a\u00020\u000b2\b\b\u0002\u0010'\u001a\u00020\u000b2\b\b\u0002\u0010(\u001a\u00020\u000b2\b\b\u0002\u0010)\u001a\u00020\u000b2\b\b\u0002\u0010*\u001a\u00020\u000b2\b\b\u0002\u0010+\u001a\u00020\u000b2\b\b\u0002\u0010,\u001a\u00020\u000b2\b\b\u0002\u0010-\u001a\u00020\u000b2\b\b\u0002\u0010.\u001a\u00020\u000b2\b\b\u0002\u0010/\u001a\u00020\u000b2\b\b\u0002\u00100\u001a\u00020\u000bH\u0007ø\u0001\u0000¢\u0006\u0004\b1\u00102\u001aø\u0002\u0010\u0013\u001a\u00020\u00042\b\b\u0002\u0010\u0014\u001a\u00020\u000b2\b\b\u0002\u0010\u0015\u001a\u00020\u000b2\b\b\u0002\u0010\u0016\u001a\u00020\u000b2\b\b\u0002\u0010\u0017\u001a\u00020\u000b2\b\b\u0002\u0010\u0018\u001a\u00020\u000b2\b\b\u0002\u0010\u0019\u001a\u00020\u000b2\b\b\u0002\u0010\u001a\u001a\u00020\u000b2\b\b\u0002\u0010\u001b\u001a\u00020\u000b2\b\b\u0002\u0010\u001c\u001a\u00020\u000b2\b\b\u0002\u0010\u001d\u001a\u00020\u000b2\b\b\u0002\u0010\u001e\u001a\u00020\u000b2\b\b\u0002\u0010\u001f\u001a\u00020\u000b2\b\b\u0002\u0010 \u001a\u00020\u000b2\b\b\u0002\u0010!\u001a\u00020\u000b2\b\b\u0002\u0010\"\u001a\u00020\u000b2\b\b\u0002\u0010#\u001a\u00020\u000b2\b\b\u0002\u0010$\u001a\u00020\u000b2\b\b\u0002\u0010%\u001a\u00020\u000b2\b\b\u0002\u0010&\u001a\u00020\u000b2\b\b\u0002\u0010'\u001a\u00020\u000b2\b\b\u0002\u0010(\u001a\u00020\u000b2\b\b\u0002\u0010)\u001a\u00020\u000b2\b\b\u0002\u0010*\u001a\u00020\u000b2\b\b\u0002\u0010+\u001a\u00020\u000b2\b\b\u0002\u0010,\u001a\u00020\u000b2\b\b\u0002\u0010-\u001a\u00020\u000b2\b\b\u0002\u0010.\u001a\u00020\u000b2\b\b\u0002\u0010/\u001a\u00020\u000b2\b\b\u0002\u00100\u001a\u00020\u000b2\b\b\u0002\u00103\u001a\u00020\u000b2\b\b\u0002\u00104\u001a\u00020\u000b2\b\b\u0002\u00105\u001a\u00020\u000b2\b\b\u0002\u00106\u001a\u00020\u000b2\b\b\u0002\u00107\u001a\u00020\u000b2\b\b\u0002\u00108\u001a\u00020\u000b2\b\b\u0002\u00109\u001a\u00020\u000bø\u0001\u0000¢\u0006\u0004\b:\u0010;\u001a\b\u0010<\u001a\u00020\u0004H\u0000\u001a´\u0002\u0010=\u001a\u00020\u00042\b\b\u0002\u0010\u0014\u001a\u00020\u000b2\b\b\u0002\u0010\u0015\u001a\u00020\u000b2\b\b\u0002\u0010\u0016\u001a\u00020\u000b2\b\b\u0002\u0010\u0017\u001a\u00020\u000b2\b\b\u0002\u0010\u0018\u001a\u00020\u000b2\b\b\u0002\u0010\u0019\u001a\u00020\u000b2\b\b\u0002\u0010\u001a\u001a\u00020\u000b2\b\b\u0002\u0010\u001b\u001a\u00020\u000b2\b\b\u0002\u0010\u001c\u001a\u00020\u000b2\b\b\u0002\u0010\u001d\u001a\u00020\u000b2\b\b\u0002\u0010\u001e\u001a\u00020\u000b2\b\b\u0002\u0010\u001f\u001a\u00020\u000b2\b\b\u0002\u0010 \u001a\u00020\u000b2\b\b\u0002\u0010!\u001a\u00020\u000b2\b\b\u0002\u0010\"\u001a\u00020\u000b2\b\b\u0002\u0010#\u001a\u00020\u000b2\b\b\u0002\u0010$\u001a\u00020\u000b2\b\b\u0002\u0010%\u001a\u00020\u000b2\b\b\u0002\u0010&\u001a\u00020\u000b2\b\b\u0002\u0010'\u001a\u00020\u000b2\b\b\u0002\u0010(\u001a\u00020\u000b2\b\b\u0002\u0010)\u001a\u00020\u000b2\b\b\u0002\u0010*\u001a\u00020\u000b2\b\b\u0002\u0010+\u001a\u00020\u000b2\b\b\u0002\u0010,\u001a\u00020\u000b2\b\b\u0002\u0010-\u001a\u00020\u000b2\b\b\u0002\u0010.\u001a\u00020\u000b2\b\b\u0002\u0010/\u001a\u00020\u000b2\b\b\u0002\u00100\u001a\u00020\u000bH\u0007ø\u0001\u0000¢\u0006\u0004\b>\u00102\u001aø\u0002\u0010=\u001a\u00020\u00042\b\b\u0002\u0010\u0014\u001a\u00020\u000b2\b\b\u0002\u0010\u0015\u001a\u00020\u000b2\b\b\u0002\u0010\u0016\u001a\u00020\u000b2\b\b\u0002\u0010\u0017\u001a\u00020\u000b2\b\b\u0002\u0010\u0018\u001a\u00020\u000b2\b\b\u0002\u0010\u0019\u001a\u00020\u000b2\b\b\u0002\u0010\u001a\u001a\u00020\u000b2\b\b\u0002\u0010\u001b\u001a\u00020\u000b2\b\b\u0002\u0010\u001c\u001a\u00020\u000b2\b\b\u0002\u0010\u001d\u001a\u00020\u000b2\b\b\u0002\u0010\u001e\u001a\u00020\u000b2\b\b\u0002\u0010\u001f\u001a\u00020\u000b2\b\b\u0002\u0010 \u001a\u00020\u000b2\b\b\u0002\u0010!\u001a\u00020\u000b2\b\b\u0002\u0010\"\u001a\u00020\u000b2\b\b\u0002\u0010#\u001a\u00020\u000b2\b\b\u0002\u0010$\u001a\u00020\u000b2\b\b\u0002\u0010%\u001a\u00020\u000b2\b\b\u0002\u0010&\u001a\u00020\u000b2\b\b\u0002\u0010'\u001a\u00020\u000b2\b\b\u0002\u0010(\u001a\u00020\u000b2\b\b\u0002\u0010)\u001a\u00020\u000b2\b\b\u0002\u0010*\u001a\u00020\u000b2\b\b\u0002\u0010+\u001a\u00020\u000b2\b\b\u0002\u0010,\u001a\u00020\u000b2\b\b\u0002\u0010-\u001a\u00020\u000b2\b\b\u0002\u0010.\u001a\u00020\u000b2\b\b\u0002\u0010/\u001a\u00020\u000b2\b\b\u0002\u00100\u001a\u00020\u000b2\b\b\u0002\u00103\u001a\u00020\u000b2\b\b\u0002\u00104\u001a\u00020\u000b2\b\b\u0002\u00105\u001a\u00020\u000b2\b\b\u0002\u00106\u001a\u00020\u000b2\b\b\u0002\u00107\u001a\u00020\u000b2\b\b\u0002\u00108\u001a\u00020\u000b2\b\b\u0002\u00109\u001a\u00020\u000bø\u0001\u0000¢\u0006\u0004\b?\u0010;\u001a&\u0010@\u001a\u00020\u000b*\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010A\u001a\u00020BH\u0001ø\u0001\u0000¢\u0006\u0004\bC\u0010D\u001a\u001e\u0010\u000f\u001a\u00020\u000b*\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000bH\u0007ø\u0001\u0000¢\u0006\u0004\bE\u0010F\u001a\u0019\u0010G\u001a\u00020\u000b*\u00020\u00042\u0006\u0010\n\u001a\u00020\fH\u0001¢\u0006\u0002\u0010H\u001a\u001e\u0010I\u001a\u00020\u000b*\u00020\u00042\u0006\u0010A\u001a\u00020BH\u0007ø\u0001\u0000¢\u0006\u0004\bJ\u0010K\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u001a\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0006\"\u0018\u0010\n\u001a\u00020\u000b*\u00020\f8AX\u0080\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006L"}, d2 = {"DisabledAlpha", "", "LocalColorScheme", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/material3/ColorScheme;", "getLocalColorScheme", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "LocalTonalElevationEnabled", "", "getLocalTonalElevationEnabled", "value", "Landroidx/compose/ui/graphics/Color;", "Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "getValue", "(Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;Landroidx/compose/runtime/Composer;I)J", "contentColorFor", "backgroundColor", "contentColorFor-ek8zF_U", "(JLandroidx/compose/runtime/Composer;I)J", "darkColorScheme", "primary", "onPrimary", "primaryContainer", "onPrimaryContainer", "inversePrimary", "secondary", "onSecondary", "secondaryContainer", "onSecondaryContainer", "tertiary", "onTertiary", "tertiaryContainer", "onTertiaryContainer", "background", "onBackground", "surface", "onSurface", "surfaceVariant", "onSurfaceVariant", "surfaceTint", "inverseSurface", "inverseOnSurface", "error", "onError", "errorContainer", "onErrorContainer", "outline", "outlineVariant", "scrim", "darkColorScheme-G1PFc-w", "(JJJJJJJJJJJJJJJJJJJJJJJJJJJJJ)Landroidx/compose/material3/ColorScheme;", "surfaceBright", "surfaceContainer", "surfaceContainerHigh", "surfaceContainerHighest", "surfaceContainerLow", "surfaceContainerLowest", "surfaceDim", "darkColorScheme-C-Xl9yA", "(JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJ)Landroidx/compose/material3/ColorScheme;", "expressiveLightColorScheme", "lightColorScheme", "lightColorScheme-G1PFc-w", "lightColorScheme-C-Xl9yA", "applyTonalElevation", "elevation", "Landroidx/compose/ui/unit/Dp;", "applyTonalElevation-RFCenO8", "(Landroidx/compose/material3/ColorScheme;JFLandroidx/compose/runtime/Composer;I)J", "contentColorFor-4WTKRHQ", "(Landroidx/compose/material3/ColorScheme;J)J", "fromToken", "(Landroidx/compose/material3/ColorScheme;Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;)J", "surfaceColorAtElevation", "surfaceColorAtElevation-3ABfNKs", "(Landroidx/compose/material3/ColorScheme;F)J", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ColorSchemeKt {
    public static final float DisabledAlpha = 0.38f;
    private static final ProvidableCompositionLocal<ColorScheme> LocalColorScheme = CompositionLocalKt.staticCompositionLocalOf(new S7.a() { // from class: androidx.compose.material3.ColorSchemeKt$LocalColorScheme$1
        @Override // S7.a
        public final ColorScheme invoke() {
            return ColorSchemeKt.m1681lightColorSchemeCXl9yA$default(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, -1, 15, null);
        }
    });
    private static final ProvidableCompositionLocal<Boolean> LocalTonalElevationEnabled = CompositionLocalKt.staticCompositionLocalOf(new S7.a() { // from class: androidx.compose.material3.ColorSchemeKt$LocalTonalElevationEnabled$1
        @Override // S7.a
        public final Boolean invoke() {
            return Boolean.TRUE;
        }
    });

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ColorSchemeKeyTokens.values().length];
            try {
                iArr[ColorSchemeKeyTokens.Background.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ColorSchemeKeyTokens.Error.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ColorSchemeKeyTokens.ErrorContainer.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ColorSchemeKeyTokens.InverseOnSurface.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ColorSchemeKeyTokens.InversePrimary.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[ColorSchemeKeyTokens.InverseSurface.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnBackground.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnError.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnErrorContainer.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnPrimary.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnPrimaryContainer.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnSecondary.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnSecondaryContainer.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnSurface.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnSurfaceVariant.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr[ColorSchemeKeyTokens.SurfaceTint.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnTertiary.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OnTertiaryContainer.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr[ColorSchemeKeyTokens.Outline.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                iArr[ColorSchemeKeyTokens.OutlineVariant.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                iArr[ColorSchemeKeyTokens.Primary.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                iArr[ColorSchemeKeyTokens.PrimaryContainer.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                iArr[ColorSchemeKeyTokens.Scrim.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                iArr[ColorSchemeKeyTokens.Secondary.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                iArr[ColorSchemeKeyTokens.SecondaryContainer.ordinal()] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                iArr[ColorSchemeKeyTokens.Surface.ordinal()] = 26;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                iArr[ColorSchemeKeyTokens.SurfaceVariant.ordinal()] = 27;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                iArr[ColorSchemeKeyTokens.SurfaceBright.ordinal()] = 28;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                iArr[ColorSchemeKeyTokens.SurfaceContainer.ordinal()] = 29;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                iArr[ColorSchemeKeyTokens.SurfaceContainerHigh.ordinal()] = 30;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                iArr[ColorSchemeKeyTokens.SurfaceContainerHighest.ordinal()] = 31;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                iArr[ColorSchemeKeyTokens.SurfaceContainerLow.ordinal()] = 32;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                iArr[ColorSchemeKeyTokens.SurfaceContainerLowest.ordinal()] = 33;
            } catch (NoSuchFieldError unused33) {
            }
            try {
                iArr[ColorSchemeKeyTokens.SurfaceDim.ordinal()] = 34;
            } catch (NoSuchFieldError unused34) {
            }
            try {
                iArr[ColorSchemeKeyTokens.Tertiary.ordinal()] = 35;
            } catch (NoSuchFieldError unused35) {
            }
            try {
                iArr[ColorSchemeKeyTokens.TertiaryContainer.ordinal()] = 36;
            } catch (NoSuchFieldError unused36) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Composable
    @ReadOnlyComposable
    /* renamed from: applyTonalElevation-RFCenO8, reason: not valid java name */
    public static final long m1673applyTonalElevationRFCenO8(ColorScheme colorScheme, long j5, float f, Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1610977682, i, -1, "androidx.compose.material3.applyTonalElevation (ColorScheme.kt:895)");
        }
        boolean zBooleanValue = ((Boolean) composer.consume(LocalTonalElevationEnabled)).booleanValue();
        if (Color.m4140equalsimpl0(j5, colorScheme.getSurface()) && zBooleanValue) {
            j5 = m1684surfaceColorAtElevation3ABfNKs(colorScheme, f);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return j5;
    }

    @Stable
    /* renamed from: contentColorFor-4WTKRHQ, reason: not valid java name */
    public static final long m1674contentColorFor4WTKRHQ(ColorScheme colorScheme, long j5) {
        if (Color.m4140equalsimpl0(j5, colorScheme.getPrimary())) {
            return colorScheme.getOnPrimary();
        }
        if (Color.m4140equalsimpl0(j5, colorScheme.getSecondary())) {
            return colorScheme.getOnSecondary();
        }
        if (Color.m4140equalsimpl0(j5, colorScheme.getTertiary())) {
            return colorScheme.getOnTertiary();
        }
        if (Color.m4140equalsimpl0(j5, colorScheme.getBackground())) {
            return colorScheme.getOnBackground();
        }
        if (Color.m4140equalsimpl0(j5, colorScheme.getError())) {
            return colorScheme.getOnError();
        }
        if (Color.m4140equalsimpl0(j5, colorScheme.getPrimaryContainer())) {
            return colorScheme.getOnPrimaryContainer();
        }
        if (Color.m4140equalsimpl0(j5, colorScheme.getSecondaryContainer())) {
            return colorScheme.getOnSecondaryContainer();
        }
        if (Color.m4140equalsimpl0(j5, colorScheme.getTertiaryContainer())) {
            return colorScheme.getOnTertiaryContainer();
        }
        if (Color.m4140equalsimpl0(j5, colorScheme.getErrorContainer())) {
            return colorScheme.getOnErrorContainer();
        }
        if (Color.m4140equalsimpl0(j5, colorScheme.getInverseSurface())) {
            return colorScheme.getInverseOnSurface();
        }
        if (Color.m4140equalsimpl0(j5, colorScheme.getSurface())) {
            return colorScheme.getOnSurface();
        }
        if (Color.m4140equalsimpl0(j5, colorScheme.getSurfaceVariant())) {
            return colorScheme.getOnSurfaceVariant();
        }
        if (!Color.m4140equalsimpl0(j5, colorScheme.getSurfaceBright()) && !Color.m4140equalsimpl0(j5, colorScheme.getSurfaceContainer()) && !Color.m4140equalsimpl0(j5, colorScheme.getSurfaceContainerHigh()) && !Color.m4140equalsimpl0(j5, colorScheme.getSurfaceContainerHighest()) && !Color.m4140equalsimpl0(j5, colorScheme.getSurfaceContainerLow()) && !Color.m4140equalsimpl0(j5, colorScheme.getSurfaceContainerLowest())) {
            return Color.INSTANCE.m4175getUnspecified0d7_KjU();
        }
        return colorScheme.getOnSurface();
    }

    @Composable
    @ReadOnlyComposable
    /* renamed from: contentColorFor-ek8zF_U, reason: not valid java name */
    public static final long m1675contentColorForek8zF_U(long j5, Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(509589638, i, -1, "androidx.compose.material3.contentColorFor (ColorScheme.kt:878)");
        }
        composer.startReplaceGroup(-1680936624);
        long jM1674contentColorFor4WTKRHQ = m1674contentColorFor4WTKRHQ(MaterialTheme.INSTANCE.getColorScheme(composer, 6), j5);
        if (jM1674contentColorFor4WTKRHQ == 16) {
            jM1674contentColorFor4WTKRHQ = ((Color) composer.consume(ContentColorKt.getLocalContentColor())).m4149unboximpl();
        }
        composer.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return jM1674contentColorFor4WTKRHQ;
    }

    /* renamed from: darkColorScheme-C-Xl9yA, reason: not valid java name */
    public static final ColorScheme m1676darkColorSchemeCXl9yA(long j5, long j6, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36, long j37, long j38, long j39, long j40, long j41, long j42, long j43) {
        return new ColorScheme(j5, j6, j10, j11, j12, j13, j14, j15, j16, j17, j18, j19, j20, j21, j22, j23, j24, j25, j26, j27, j28, j29, j30, j31, j32, j33, j34, j35, j36, j37, j43, j38, j39, j40, j41, j42, null);
    }

    /* renamed from: darkColorScheme-C-Xl9yA$default, reason: not valid java name */
    public static /* synthetic */ ColorScheme m1677darkColorSchemeCXl9yA$default(long j5, long j6, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36, long j37, long j38, long j39, long j40, long j41, long j42, long j43, int i, int i6, Object obj) {
        long jM2840getPrimary0d7_KjU = (i & 1) != 0 ? ColorDarkTokens.INSTANCE.m2840getPrimary0d7_KjU() : j5;
        long jM2824getOnPrimary0d7_KjU = (i & 2) != 0 ? ColorDarkTokens.INSTANCE.m2824getOnPrimary0d7_KjU() : j6;
        long jM2841getPrimaryContainer0d7_KjU = (i & 4) != 0 ? ColorDarkTokens.INSTANCE.m2841getPrimaryContainer0d7_KjU() : j10;
        long jM2825getOnPrimaryContainer0d7_KjU = (i & 8) != 0 ? ColorDarkTokens.INSTANCE.m2825getOnPrimaryContainer0d7_KjU() : j11;
        long jM2819getInversePrimary0d7_KjU = (i & 16) != 0 ? ColorDarkTokens.INSTANCE.m2819getInversePrimary0d7_KjU() : j12;
        long jM2845getSecondary0d7_KjU = (i & 32) != 0 ? ColorDarkTokens.INSTANCE.m2845getSecondary0d7_KjU() : j13;
        long jM2828getOnSecondary0d7_KjU = (i & 64) != 0 ? ColorDarkTokens.INSTANCE.m2828getOnSecondary0d7_KjU() : j14;
        long jM2846getSecondaryContainer0d7_KjU = (i & 128) != 0 ? ColorDarkTokens.INSTANCE.m2846getSecondaryContainer0d7_KjU() : j15;
        long j44 = jM2840getPrimary0d7_KjU;
        long jM2829getOnSecondaryContainer0d7_KjU = (i & 256) != 0 ? ColorDarkTokens.INSTANCE.m2829getOnSecondaryContainer0d7_KjU() : j16;
        long jM2859getTertiary0d7_KjU = (i & 512) != 0 ? ColorDarkTokens.INSTANCE.m2859getTertiary0d7_KjU() : j17;
        long jM2834getOnTertiary0d7_KjU = (i & 1024) != 0 ? ColorDarkTokens.INSTANCE.m2834getOnTertiary0d7_KjU() : j18;
        long jM2860getTertiaryContainer0d7_KjU = (i & 2048) != 0 ? ColorDarkTokens.INSTANCE.m2860getTertiaryContainer0d7_KjU() : j19;
        long jM2835getOnTertiaryContainer0d7_KjU = (i & 4096) != 0 ? ColorDarkTokens.INSTANCE.m2835getOnTertiaryContainer0d7_KjU() : j20;
        long jM2815getBackground0d7_KjU = (i & 8192) != 0 ? ColorDarkTokens.INSTANCE.m2815getBackground0d7_KjU() : j21;
        long jM2821getOnBackground0d7_KjU = (i & 16384) != 0 ? ColorDarkTokens.INSTANCE.m2821getOnBackground0d7_KjU() : j22;
        long jM2849getSurface0d7_KjU = (i & 32768) != 0 ? ColorDarkTokens.INSTANCE.m2849getSurface0d7_KjU() : j23;
        long jM2832getOnSurface0d7_KjU = (i & 65536) != 0 ? ColorDarkTokens.INSTANCE.m2832getOnSurface0d7_KjU() : j24;
        long jM2858getSurfaceVariant0d7_KjU = (i & 131072) != 0 ? ColorDarkTokens.INSTANCE.m2858getSurfaceVariant0d7_KjU() : j25;
        long jM2833getOnSurfaceVariant0d7_KjU = (i & 262144) != 0 ? ColorDarkTokens.INSTANCE.m2833getOnSurfaceVariant0d7_KjU() : j26;
        long j45 = (i & 524288) != 0 ? j44 : j27;
        long jM2820getInverseSurface0d7_KjU = (i & 1048576) != 0 ? ColorDarkTokens.INSTANCE.m2820getInverseSurface0d7_KjU() : j28;
        long jM2818getInverseOnSurface0d7_KjU = (i & 2097152) != 0 ? ColorDarkTokens.INSTANCE.m2818getInverseOnSurface0d7_KjU() : j29;
        long jM2816getError0d7_KjU = (i & 4194304) != 0 ? ColorDarkTokens.INSTANCE.m2816getError0d7_KjU() : j30;
        long jM2822getOnError0d7_KjU = (i & 8388608) != 0 ? ColorDarkTokens.INSTANCE.m2822getOnError0d7_KjU() : j31;
        long jM2817getErrorContainer0d7_KjU = (i & 16777216) != 0 ? ColorDarkTokens.INSTANCE.m2817getErrorContainer0d7_KjU() : j32;
        long jM2823getOnErrorContainer0d7_KjU = (i & 33554432) != 0 ? ColorDarkTokens.INSTANCE.m2823getOnErrorContainer0d7_KjU() : j33;
        long jM2838getOutline0d7_KjU = (i & AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL) != 0 ? ColorDarkTokens.INSTANCE.m2838getOutline0d7_KjU() : j34;
        long jM2839getOutlineVariant0d7_KjU = (i & 134217728) != 0 ? ColorDarkTokens.INSTANCE.m2839getOutlineVariant0d7_KjU() : j35;
        long jM2844getScrim0d7_KjU = (i & 268435456) != 0 ? ColorDarkTokens.INSTANCE.m2844getScrim0d7_KjU() : j36;
        long jM2850getSurfaceBright0d7_KjU = (i & 536870912) != 0 ? ColorDarkTokens.INSTANCE.m2850getSurfaceBright0d7_KjU() : j37;
        long jM2851getSurfaceContainer0d7_KjU = (i & BasicMeasure.EXACTLY) != 0 ? ColorDarkTokens.INSTANCE.m2851getSurfaceContainer0d7_KjU() : j38;
        long jM2852getSurfaceContainerHigh0d7_KjU = (i & Integer.MIN_VALUE) != 0 ? ColorDarkTokens.INSTANCE.m2852getSurfaceContainerHigh0d7_KjU() : j39;
        long jM2853getSurfaceContainerHighest0d7_KjU = (i6 & 1) != 0 ? ColorDarkTokens.INSTANCE.m2853getSurfaceContainerHighest0d7_KjU() : j40;
        long jM2854getSurfaceContainerLow0d7_KjU = (i6 & 2) != 0 ? ColorDarkTokens.INSTANCE.m2854getSurfaceContainerLow0d7_KjU() : j41;
        long jM2855getSurfaceContainerLowest0d7_KjU = (i6 & 4) != 0 ? ColorDarkTokens.INSTANCE.m2855getSurfaceContainerLowest0d7_KjU() : j42;
        if ((i6 & 8) != 0) {
            j43 = ColorDarkTokens.INSTANCE.m2856getSurfaceDim0d7_KjU();
        }
        return m1676darkColorSchemeCXl9yA(j44, jM2824getOnPrimary0d7_KjU, jM2841getPrimaryContainer0d7_KjU, jM2825getOnPrimaryContainer0d7_KjU, jM2819getInversePrimary0d7_KjU, jM2845getSecondary0d7_KjU, jM2828getOnSecondary0d7_KjU, jM2846getSecondaryContainer0d7_KjU, jM2829getOnSecondaryContainer0d7_KjU, jM2859getTertiary0d7_KjU, jM2834getOnTertiary0d7_KjU, jM2860getTertiaryContainer0d7_KjU, jM2835getOnTertiaryContainer0d7_KjU, jM2815getBackground0d7_KjU, jM2821getOnBackground0d7_KjU, jM2849getSurface0d7_KjU, jM2832getOnSurface0d7_KjU, jM2858getSurfaceVariant0d7_KjU, jM2833getOnSurfaceVariant0d7_KjU, j45, jM2820getInverseSurface0d7_KjU, jM2818getInverseOnSurface0d7_KjU, jM2816getError0d7_KjU, jM2822getOnError0d7_KjU, jM2817getErrorContainer0d7_KjU, jM2823getOnErrorContainer0d7_KjU, jM2838getOutline0d7_KjU, jM2839getOutlineVariant0d7_KjU, jM2844getScrim0d7_KjU, jM2850getSurfaceBright0d7_KjU, jM2851getSurfaceContainer0d7_KjU, jM2852getSurfaceContainerHigh0d7_KjU, jM2853getSurfaceContainerHighest0d7_KjU, jM2854getSurfaceContainerLow0d7_KjU, jM2855getSurfaceContainerLowest0d7_KjU, j43);
    }

    @C7.c
    /* renamed from: darkColorScheme-G1PFc-w, reason: not valid java name */
    public static final /* synthetic */ ColorScheme m1678darkColorSchemeG1PFcw(long j5, long j6, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36) {
        return m1677darkColorSchemeCXl9yA$default(j5, j6, j10, j11, j12, j13, j14, j15, j16, j17, j18, j19, j20, j21, j22, j23, j24, j25, j26, j27, j28, j29, j30, j31, j32, j33, j34, j35, j36, 0L, 0L, 0L, 0L, 0L, 0L, 0L, -536870912, 15, null);
    }

    /* renamed from: darkColorScheme-G1PFc-w$default, reason: not valid java name */
    public static /* synthetic */ ColorScheme m1679darkColorSchemeG1PFcw$default(long j5, long j6, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36, int i, Object obj) {
        long jM2840getPrimary0d7_KjU = (i & 1) != 0 ? ColorDarkTokens.INSTANCE.m2840getPrimary0d7_KjU() : j5;
        long jM2824getOnPrimary0d7_KjU = (i & 2) != 0 ? ColorDarkTokens.INSTANCE.m2824getOnPrimary0d7_KjU() : j6;
        long jM2841getPrimaryContainer0d7_KjU = (i & 4) != 0 ? ColorDarkTokens.INSTANCE.m2841getPrimaryContainer0d7_KjU() : j10;
        long jM2825getOnPrimaryContainer0d7_KjU = (i & 8) != 0 ? ColorDarkTokens.INSTANCE.m2825getOnPrimaryContainer0d7_KjU() : j11;
        long jM2819getInversePrimary0d7_KjU = (i & 16) != 0 ? ColorDarkTokens.INSTANCE.m2819getInversePrimary0d7_KjU() : j12;
        long jM2845getSecondary0d7_KjU = (i & 32) != 0 ? ColorDarkTokens.INSTANCE.m2845getSecondary0d7_KjU() : j13;
        long jM2828getOnSecondary0d7_KjU = (i & 64) != 0 ? ColorDarkTokens.INSTANCE.m2828getOnSecondary0d7_KjU() : j14;
        long jM2846getSecondaryContainer0d7_KjU = (i & 128) != 0 ? ColorDarkTokens.INSTANCE.m2846getSecondaryContainer0d7_KjU() : j15;
        long j37 = jM2840getPrimary0d7_KjU;
        long jM2829getOnSecondaryContainer0d7_KjU = (i & 256) != 0 ? ColorDarkTokens.INSTANCE.m2829getOnSecondaryContainer0d7_KjU() : j16;
        long jM2859getTertiary0d7_KjU = (i & 512) != 0 ? ColorDarkTokens.INSTANCE.m2859getTertiary0d7_KjU() : j17;
        long jM2834getOnTertiary0d7_KjU = (i & 1024) != 0 ? ColorDarkTokens.INSTANCE.m2834getOnTertiary0d7_KjU() : j18;
        long jM2860getTertiaryContainer0d7_KjU = (i & 2048) != 0 ? ColorDarkTokens.INSTANCE.m2860getTertiaryContainer0d7_KjU() : j19;
        long jM2835getOnTertiaryContainer0d7_KjU = (i & 4096) != 0 ? ColorDarkTokens.INSTANCE.m2835getOnTertiaryContainer0d7_KjU() : j20;
        long jM2815getBackground0d7_KjU = (i & 8192) != 0 ? ColorDarkTokens.INSTANCE.m2815getBackground0d7_KjU() : j21;
        long jM2821getOnBackground0d7_KjU = (i & 16384) != 0 ? ColorDarkTokens.INSTANCE.m2821getOnBackground0d7_KjU() : j22;
        long jM2849getSurface0d7_KjU = (i & 32768) != 0 ? ColorDarkTokens.INSTANCE.m2849getSurface0d7_KjU() : j23;
        long jM2832getOnSurface0d7_KjU = (i & 65536) != 0 ? ColorDarkTokens.INSTANCE.m2832getOnSurface0d7_KjU() : j24;
        long jM2858getSurfaceVariant0d7_KjU = (i & 131072) != 0 ? ColorDarkTokens.INSTANCE.m2858getSurfaceVariant0d7_KjU() : j25;
        long jM2833getOnSurfaceVariant0d7_KjU = (i & 262144) != 0 ? ColorDarkTokens.INSTANCE.m2833getOnSurfaceVariant0d7_KjU() : j26;
        long j38 = (i & 524288) != 0 ? j37 : j27;
        long jM2820getInverseSurface0d7_KjU = (i & 1048576) != 0 ? ColorDarkTokens.INSTANCE.m2820getInverseSurface0d7_KjU() : j28;
        long jM2818getInverseOnSurface0d7_KjU = (i & 2097152) != 0 ? ColorDarkTokens.INSTANCE.m2818getInverseOnSurface0d7_KjU() : j29;
        long jM2816getError0d7_KjU = (i & 4194304) != 0 ? ColorDarkTokens.INSTANCE.m2816getError0d7_KjU() : j30;
        long jM2822getOnError0d7_KjU = (i & 8388608) != 0 ? ColorDarkTokens.INSTANCE.m2822getOnError0d7_KjU() : j31;
        long jM2817getErrorContainer0d7_KjU = (i & 16777216) != 0 ? ColorDarkTokens.INSTANCE.m2817getErrorContainer0d7_KjU() : j32;
        long jM2823getOnErrorContainer0d7_KjU = (i & 33554432) != 0 ? ColorDarkTokens.INSTANCE.m2823getOnErrorContainer0d7_KjU() : j33;
        long jM2838getOutline0d7_KjU = (i & AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL) != 0 ? ColorDarkTokens.INSTANCE.m2838getOutline0d7_KjU() : j34;
        long jM2839getOutlineVariant0d7_KjU = (i & 134217728) != 0 ? ColorDarkTokens.INSTANCE.m2839getOutlineVariant0d7_KjU() : j35;
        if ((i & 268435456) != 0) {
            j36 = ColorDarkTokens.INSTANCE.m2844getScrim0d7_KjU();
        }
        return m1678darkColorSchemeG1PFcw(j37, jM2824getOnPrimary0d7_KjU, jM2841getPrimaryContainer0d7_KjU, jM2825getOnPrimaryContainer0d7_KjU, jM2819getInversePrimary0d7_KjU, jM2845getSecondary0d7_KjU, jM2828getOnSecondary0d7_KjU, jM2846getSecondaryContainer0d7_KjU, jM2829getOnSecondaryContainer0d7_KjU, jM2859getTertiary0d7_KjU, jM2834getOnTertiary0d7_KjU, jM2860getTertiaryContainer0d7_KjU, jM2835getOnTertiaryContainer0d7_KjU, jM2815getBackground0d7_KjU, jM2821getOnBackground0d7_KjU, jM2849getSurface0d7_KjU, jM2832getOnSurface0d7_KjU, jM2858getSurfaceVariant0d7_KjU, jM2833getOnSurfaceVariant0d7_KjU, j38, jM2820getInverseSurface0d7_KjU, jM2818getInverseOnSurface0d7_KjU, jM2816getError0d7_KjU, jM2822getOnError0d7_KjU, jM2817getErrorContainer0d7_KjU, jM2823getOnErrorContainer0d7_KjU, jM2838getOutline0d7_KjU, jM2839getOutlineVariant0d7_KjU, j36);
    }

    public static final ColorScheme expressiveLightColorScheme() {
        PaletteTokens paletteTokens = PaletteTokens.INSTANCE;
        return m1681lightColorSchemeCXl9yA$default(0L, 0L, 0L, paletteTokens.m3199getPrimary300d7_KjU(), 0L, 0L, 0L, 0L, paletteTokens.m3212getSecondary300d7_KjU(), 0L, 0L, 0L, paletteTokens.m3212getSecondary300d7_KjU(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, -4361, 15, null);
    }

    @Stable
    public static final long fromToken(ColorScheme colorScheme, ColorSchemeKeyTokens colorSchemeKeyTokens) {
        switch (WhenMappings.$EnumSwitchMapping$0[colorSchemeKeyTokens.ordinal()]) {
            case 1:
                return colorScheme.getBackground();
            case 2:
                return colorScheme.getError();
            case 3:
                return colorScheme.getErrorContainer();
            case 4:
                return colorScheme.getInverseOnSurface();
            case 5:
                return colorScheme.getInversePrimary();
            case 6:
                return colorScheme.getInverseSurface();
            case 7:
                return colorScheme.getOnBackground();
            case 8:
                return colorScheme.getOnError();
            case 9:
                return colorScheme.getOnErrorContainer();
            case 10:
                return colorScheme.getOnPrimary();
            case 11:
                return colorScheme.getOnPrimaryContainer();
            case 12:
                return colorScheme.getOnSecondary();
            case 13:
                return colorScheme.getOnSecondaryContainer();
            case 14:
                return colorScheme.getOnSurface();
            case 15:
                return colorScheme.getOnSurfaceVariant();
            case 16:
                return colorScheme.getSurfaceTint();
            case 17:
                return colorScheme.getOnTertiary();
            case 18:
                return colorScheme.getOnTertiaryContainer();
            case 19:
                return colorScheme.getOutline();
            case 20:
                return colorScheme.getOutlineVariant();
            case 21:
                return colorScheme.getPrimary();
            case 22:
                return colorScheme.getPrimaryContainer();
            case 23:
                return colorScheme.getScrim();
            case 24:
                return colorScheme.getSecondary();
            case 25:
                return colorScheme.getSecondaryContainer();
            case 26:
                return colorScheme.getSurface();
            case 27:
                return colorScheme.getSurfaceVariant();
            case 28:
                return colorScheme.getSurfaceBright();
            case 29:
                return colorScheme.getSurfaceContainer();
            case 30:
                return colorScheme.getSurfaceContainerHigh();
            case 31:
                return colorScheme.getSurfaceContainerHighest();
            case 32:
                return colorScheme.getSurfaceContainerLow();
            case 33:
                return colorScheme.getSurfaceContainerLowest();
            case 34:
                return colorScheme.getSurfaceDim();
            case 35:
                return colorScheme.getTertiary();
            case 36:
                return colorScheme.getTertiaryContainer();
            default:
                return Color.INSTANCE.m4175getUnspecified0d7_KjU();
        }
    }

    public static final ProvidableCompositionLocal<ColorScheme> getLocalColorScheme() {
        return LocalColorScheme;
    }

    public static final ProvidableCompositionLocal<Boolean> getLocalTonalElevationEnabled() {
        return LocalTonalElevationEnabled;
    }

    @Composable
    @ReadOnlyComposable
    public static final long getValue(ColorSchemeKeyTokens colorSchemeKeyTokens, Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-810780884, i, -1, "androidx.compose.material3.<get-value> (ColorScheme.kt:1009)");
        }
        long jFromToken = fromToken(MaterialTheme.INSTANCE.getColorScheme(composer, 6), colorSchemeKeyTokens);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return jFromToken;
    }

    /* renamed from: lightColorScheme-C-Xl9yA, reason: not valid java name */
    public static final ColorScheme m1680lightColorSchemeCXl9yA(long j5, long j6, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36, long j37, long j38, long j39, long j40, long j41, long j42, long j43) {
        return new ColorScheme(j5, j6, j10, j11, j12, j13, j14, j15, j16, j17, j18, j19, j20, j21, j22, j23, j24, j25, j26, j27, j28, j29, j30, j31, j32, j33, j34, j35, j36, j37, j43, j38, j39, j40, j41, j42, null);
    }

    /* renamed from: lightColorScheme-C-Xl9yA$default, reason: not valid java name */
    public static /* synthetic */ ColorScheme m1681lightColorSchemeCXl9yA$default(long j5, long j6, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36, long j37, long j38, long j39, long j40, long j41, long j42, long j43, int i, int i6, Object obj) {
        long jM2888getPrimary0d7_KjU = (i & 1) != 0 ? ColorLightTokens.INSTANCE.m2888getPrimary0d7_KjU() : j5;
        long jM2872getOnPrimary0d7_KjU = (i & 2) != 0 ? ColorLightTokens.INSTANCE.m2872getOnPrimary0d7_KjU() : j6;
        long jM2889getPrimaryContainer0d7_KjU = (i & 4) != 0 ? ColorLightTokens.INSTANCE.m2889getPrimaryContainer0d7_KjU() : j10;
        long jM2873getOnPrimaryContainer0d7_KjU = (i & 8) != 0 ? ColorLightTokens.INSTANCE.m2873getOnPrimaryContainer0d7_KjU() : j11;
        long jM2867getInversePrimary0d7_KjU = (i & 16) != 0 ? ColorLightTokens.INSTANCE.m2867getInversePrimary0d7_KjU() : j12;
        long jM2893getSecondary0d7_KjU = (i & 32) != 0 ? ColorLightTokens.INSTANCE.m2893getSecondary0d7_KjU() : j13;
        long jM2876getOnSecondary0d7_KjU = (i & 64) != 0 ? ColorLightTokens.INSTANCE.m2876getOnSecondary0d7_KjU() : j14;
        long jM2894getSecondaryContainer0d7_KjU = (i & 128) != 0 ? ColorLightTokens.INSTANCE.m2894getSecondaryContainer0d7_KjU() : j15;
        long j44 = jM2888getPrimary0d7_KjU;
        long jM2877getOnSecondaryContainer0d7_KjU = (i & 256) != 0 ? ColorLightTokens.INSTANCE.m2877getOnSecondaryContainer0d7_KjU() : j16;
        long jM2907getTertiary0d7_KjU = (i & 512) != 0 ? ColorLightTokens.INSTANCE.m2907getTertiary0d7_KjU() : j17;
        long jM2882getOnTertiary0d7_KjU = (i & 1024) != 0 ? ColorLightTokens.INSTANCE.m2882getOnTertiary0d7_KjU() : j18;
        long jM2908getTertiaryContainer0d7_KjU = (i & 2048) != 0 ? ColorLightTokens.INSTANCE.m2908getTertiaryContainer0d7_KjU() : j19;
        long jM2883getOnTertiaryContainer0d7_KjU = (i & 4096) != 0 ? ColorLightTokens.INSTANCE.m2883getOnTertiaryContainer0d7_KjU() : j20;
        long jM2863getBackground0d7_KjU = (i & 8192) != 0 ? ColorLightTokens.INSTANCE.m2863getBackground0d7_KjU() : j21;
        long jM2869getOnBackground0d7_KjU = (i & 16384) != 0 ? ColorLightTokens.INSTANCE.m2869getOnBackground0d7_KjU() : j22;
        long jM2897getSurface0d7_KjU = (i & 32768) != 0 ? ColorLightTokens.INSTANCE.m2897getSurface0d7_KjU() : j23;
        long jM2880getOnSurface0d7_KjU = (i & 65536) != 0 ? ColorLightTokens.INSTANCE.m2880getOnSurface0d7_KjU() : j24;
        long jM2906getSurfaceVariant0d7_KjU = (i & 131072) != 0 ? ColorLightTokens.INSTANCE.m2906getSurfaceVariant0d7_KjU() : j25;
        long jM2881getOnSurfaceVariant0d7_KjU = (i & 262144) != 0 ? ColorLightTokens.INSTANCE.m2881getOnSurfaceVariant0d7_KjU() : j26;
        long j45 = (i & 524288) != 0 ? j44 : j27;
        long jM2868getInverseSurface0d7_KjU = (i & 1048576) != 0 ? ColorLightTokens.INSTANCE.m2868getInverseSurface0d7_KjU() : j28;
        long jM2866getInverseOnSurface0d7_KjU = (i & 2097152) != 0 ? ColorLightTokens.INSTANCE.m2866getInverseOnSurface0d7_KjU() : j29;
        long jM2864getError0d7_KjU = (i & 4194304) != 0 ? ColorLightTokens.INSTANCE.m2864getError0d7_KjU() : j30;
        long jM2870getOnError0d7_KjU = (i & 8388608) != 0 ? ColorLightTokens.INSTANCE.m2870getOnError0d7_KjU() : j31;
        long jM2865getErrorContainer0d7_KjU = (i & 16777216) != 0 ? ColorLightTokens.INSTANCE.m2865getErrorContainer0d7_KjU() : j32;
        long jM2871getOnErrorContainer0d7_KjU = (i & 33554432) != 0 ? ColorLightTokens.INSTANCE.m2871getOnErrorContainer0d7_KjU() : j33;
        long jM2886getOutline0d7_KjU = (i & AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL) != 0 ? ColorLightTokens.INSTANCE.m2886getOutline0d7_KjU() : j34;
        long jM2887getOutlineVariant0d7_KjU = (i & 134217728) != 0 ? ColorLightTokens.INSTANCE.m2887getOutlineVariant0d7_KjU() : j35;
        long jM2892getScrim0d7_KjU = (i & 268435456) != 0 ? ColorLightTokens.INSTANCE.m2892getScrim0d7_KjU() : j36;
        long jM2898getSurfaceBright0d7_KjU = (i & 536870912) != 0 ? ColorLightTokens.INSTANCE.m2898getSurfaceBright0d7_KjU() : j37;
        long jM2899getSurfaceContainer0d7_KjU = (i & BasicMeasure.EXACTLY) != 0 ? ColorLightTokens.INSTANCE.m2899getSurfaceContainer0d7_KjU() : j38;
        long jM2900getSurfaceContainerHigh0d7_KjU = (i & Integer.MIN_VALUE) != 0 ? ColorLightTokens.INSTANCE.m2900getSurfaceContainerHigh0d7_KjU() : j39;
        long jM2901getSurfaceContainerHighest0d7_KjU = (i6 & 1) != 0 ? ColorLightTokens.INSTANCE.m2901getSurfaceContainerHighest0d7_KjU() : j40;
        long jM2902getSurfaceContainerLow0d7_KjU = (i6 & 2) != 0 ? ColorLightTokens.INSTANCE.m2902getSurfaceContainerLow0d7_KjU() : j41;
        long jM2903getSurfaceContainerLowest0d7_KjU = (i6 & 4) != 0 ? ColorLightTokens.INSTANCE.m2903getSurfaceContainerLowest0d7_KjU() : j42;
        if ((i6 & 8) != 0) {
            j43 = ColorLightTokens.INSTANCE.m2904getSurfaceDim0d7_KjU();
        }
        return m1680lightColorSchemeCXl9yA(j44, jM2872getOnPrimary0d7_KjU, jM2889getPrimaryContainer0d7_KjU, jM2873getOnPrimaryContainer0d7_KjU, jM2867getInversePrimary0d7_KjU, jM2893getSecondary0d7_KjU, jM2876getOnSecondary0d7_KjU, jM2894getSecondaryContainer0d7_KjU, jM2877getOnSecondaryContainer0d7_KjU, jM2907getTertiary0d7_KjU, jM2882getOnTertiary0d7_KjU, jM2908getTertiaryContainer0d7_KjU, jM2883getOnTertiaryContainer0d7_KjU, jM2863getBackground0d7_KjU, jM2869getOnBackground0d7_KjU, jM2897getSurface0d7_KjU, jM2880getOnSurface0d7_KjU, jM2906getSurfaceVariant0d7_KjU, jM2881getOnSurfaceVariant0d7_KjU, j45, jM2868getInverseSurface0d7_KjU, jM2866getInverseOnSurface0d7_KjU, jM2864getError0d7_KjU, jM2870getOnError0d7_KjU, jM2865getErrorContainer0d7_KjU, jM2871getOnErrorContainer0d7_KjU, jM2886getOutline0d7_KjU, jM2887getOutlineVariant0d7_KjU, jM2892getScrim0d7_KjU, jM2898getSurfaceBright0d7_KjU, jM2899getSurfaceContainer0d7_KjU, jM2900getSurfaceContainerHigh0d7_KjU, jM2901getSurfaceContainerHighest0d7_KjU, jM2902getSurfaceContainerLow0d7_KjU, jM2903getSurfaceContainerLowest0d7_KjU, j43);
    }

    @C7.c
    /* renamed from: lightColorScheme-G1PFc-w, reason: not valid java name */
    public static final /* synthetic */ ColorScheme m1682lightColorSchemeG1PFcw(long j5, long j6, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36) {
        return m1681lightColorSchemeCXl9yA$default(j5, j6, j10, j11, j12, j13, j14, j15, j16, j17, j18, j19, j20, j21, j22, j23, j24, j25, j26, j27, j28, j29, j30, j31, j32, j33, j34, j35, j36, 0L, 0L, 0L, 0L, 0L, 0L, 0L, -536870912, 15, null);
    }

    /* renamed from: lightColorScheme-G1PFc-w$default, reason: not valid java name */
    public static /* synthetic */ ColorScheme m1683lightColorSchemeG1PFcw$default(long j5, long j6, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36, int i, Object obj) {
        long jM2888getPrimary0d7_KjU = (i & 1) != 0 ? ColorLightTokens.INSTANCE.m2888getPrimary0d7_KjU() : j5;
        long jM2872getOnPrimary0d7_KjU = (i & 2) != 0 ? ColorLightTokens.INSTANCE.m2872getOnPrimary0d7_KjU() : j6;
        long jM2889getPrimaryContainer0d7_KjU = (i & 4) != 0 ? ColorLightTokens.INSTANCE.m2889getPrimaryContainer0d7_KjU() : j10;
        long jM2873getOnPrimaryContainer0d7_KjU = (i & 8) != 0 ? ColorLightTokens.INSTANCE.m2873getOnPrimaryContainer0d7_KjU() : j11;
        long jM2867getInversePrimary0d7_KjU = (i & 16) != 0 ? ColorLightTokens.INSTANCE.m2867getInversePrimary0d7_KjU() : j12;
        long jM2893getSecondary0d7_KjU = (i & 32) != 0 ? ColorLightTokens.INSTANCE.m2893getSecondary0d7_KjU() : j13;
        long jM2876getOnSecondary0d7_KjU = (i & 64) != 0 ? ColorLightTokens.INSTANCE.m2876getOnSecondary0d7_KjU() : j14;
        long jM2894getSecondaryContainer0d7_KjU = (i & 128) != 0 ? ColorLightTokens.INSTANCE.m2894getSecondaryContainer0d7_KjU() : j15;
        long j37 = jM2888getPrimary0d7_KjU;
        long jM2877getOnSecondaryContainer0d7_KjU = (i & 256) != 0 ? ColorLightTokens.INSTANCE.m2877getOnSecondaryContainer0d7_KjU() : j16;
        long jM2907getTertiary0d7_KjU = (i & 512) != 0 ? ColorLightTokens.INSTANCE.m2907getTertiary0d7_KjU() : j17;
        long jM2882getOnTertiary0d7_KjU = (i & 1024) != 0 ? ColorLightTokens.INSTANCE.m2882getOnTertiary0d7_KjU() : j18;
        long jM2908getTertiaryContainer0d7_KjU = (i & 2048) != 0 ? ColorLightTokens.INSTANCE.m2908getTertiaryContainer0d7_KjU() : j19;
        long jM2883getOnTertiaryContainer0d7_KjU = (i & 4096) != 0 ? ColorLightTokens.INSTANCE.m2883getOnTertiaryContainer0d7_KjU() : j20;
        long jM2863getBackground0d7_KjU = (i & 8192) != 0 ? ColorLightTokens.INSTANCE.m2863getBackground0d7_KjU() : j21;
        long jM2869getOnBackground0d7_KjU = (i & 16384) != 0 ? ColorLightTokens.INSTANCE.m2869getOnBackground0d7_KjU() : j22;
        long jM2897getSurface0d7_KjU = (i & 32768) != 0 ? ColorLightTokens.INSTANCE.m2897getSurface0d7_KjU() : j23;
        long jM2880getOnSurface0d7_KjU = (i & 65536) != 0 ? ColorLightTokens.INSTANCE.m2880getOnSurface0d7_KjU() : j24;
        long jM2906getSurfaceVariant0d7_KjU = (i & 131072) != 0 ? ColorLightTokens.INSTANCE.m2906getSurfaceVariant0d7_KjU() : j25;
        long jM2881getOnSurfaceVariant0d7_KjU = (i & 262144) != 0 ? ColorLightTokens.INSTANCE.m2881getOnSurfaceVariant0d7_KjU() : j26;
        long j38 = (i & 524288) != 0 ? j37 : j27;
        long jM2868getInverseSurface0d7_KjU = (i & 1048576) != 0 ? ColorLightTokens.INSTANCE.m2868getInverseSurface0d7_KjU() : j28;
        long jM2866getInverseOnSurface0d7_KjU = (i & 2097152) != 0 ? ColorLightTokens.INSTANCE.m2866getInverseOnSurface0d7_KjU() : j29;
        long jM2864getError0d7_KjU = (i & 4194304) != 0 ? ColorLightTokens.INSTANCE.m2864getError0d7_KjU() : j30;
        long jM2870getOnError0d7_KjU = (i & 8388608) != 0 ? ColorLightTokens.INSTANCE.m2870getOnError0d7_KjU() : j31;
        long jM2865getErrorContainer0d7_KjU = (i & 16777216) != 0 ? ColorLightTokens.INSTANCE.m2865getErrorContainer0d7_KjU() : j32;
        long jM2871getOnErrorContainer0d7_KjU = (i & 33554432) != 0 ? ColorLightTokens.INSTANCE.m2871getOnErrorContainer0d7_KjU() : j33;
        long jM2886getOutline0d7_KjU = (i & AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL) != 0 ? ColorLightTokens.INSTANCE.m2886getOutline0d7_KjU() : j34;
        long jM2887getOutlineVariant0d7_KjU = (i & 134217728) != 0 ? ColorLightTokens.INSTANCE.m2887getOutlineVariant0d7_KjU() : j35;
        if ((i & 268435456) != 0) {
            j36 = ColorLightTokens.INSTANCE.m2892getScrim0d7_KjU();
        }
        return m1682lightColorSchemeG1PFcw(j37, jM2872getOnPrimary0d7_KjU, jM2889getPrimaryContainer0d7_KjU, jM2873getOnPrimaryContainer0d7_KjU, jM2867getInversePrimary0d7_KjU, jM2893getSecondary0d7_KjU, jM2876getOnSecondary0d7_KjU, jM2894getSecondaryContainer0d7_KjU, jM2877getOnSecondaryContainer0d7_KjU, jM2907getTertiary0d7_KjU, jM2882getOnTertiary0d7_KjU, jM2908getTertiaryContainer0d7_KjU, jM2883getOnTertiaryContainer0d7_KjU, jM2863getBackground0d7_KjU, jM2869getOnBackground0d7_KjU, jM2897getSurface0d7_KjU, jM2880getOnSurface0d7_KjU, jM2906getSurfaceVariant0d7_KjU, jM2881getOnSurfaceVariant0d7_KjU, j38, jM2868getInverseSurface0d7_KjU, jM2866getInverseOnSurface0d7_KjU, jM2864getError0d7_KjU, jM2870getOnError0d7_KjU, jM2865getErrorContainer0d7_KjU, jM2871getOnErrorContainer0d7_KjU, jM2886getOutline0d7_KjU, jM2887getOutlineVariant0d7_KjU, j36);
    }

    @Stable
    /* renamed from: surfaceColorAtElevation-3ABfNKs, reason: not valid java name */
    public static final long m1684surfaceColorAtElevation3ABfNKs(ColorScheme colorScheme, float f) {
        if (Dp.m6849equalsimpl0(f, Dp.m6844constructorimpl(0))) {
            return colorScheme.getSurface();
        }
        return ColorKt.m4184compositeOverOWjLjI(Color.m4138copywmQWz5c$default(colorScheme.getSurfaceTint(), ((((float) Math.log(f + 1)) * 4.5f) + 2.0f) / 100.0f, 0.0f, 0.0f, 0.0f, 14, null), colorScheme.getSurface());
    }
}
