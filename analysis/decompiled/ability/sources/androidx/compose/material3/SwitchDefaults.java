package androidx.compose.material3;

import androidx.compose.material3.tokens.SwitchTokens;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\r\u0010\r\u001a\u00020\tH\u0007¢\u0006\u0002\u0010\u000eJ²\u0001\u0010\r\u001a\u00020\t2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u00102\b\b\u0002\u0010\u0014\u001a\u00020\u00102\b\b\u0002\u0010\u0015\u001a\u00020\u00102\b\b\u0002\u0010\u0016\u001a\u00020\u00102\b\b\u0002\u0010\u0017\u001a\u00020\u00102\b\b\u0002\u0010\u0018\u001a\u00020\u00102\b\b\u0002\u0010\u0019\u001a\u00020\u00102\b\b\u0002\u0010\u001a\u001a\u00020\u00102\b\b\u0002\u0010\u001b\u001a\u00020\u00102\b\b\u0002\u0010\u001c\u001a\u00020\u00102\b\b\u0002\u0010\u001d\u001a\u00020\u00102\b\b\u0002\u0010\u001e\u001a\u00020\u00102\b\b\u0002\u0010\u001f\u001a\u00020\u0010H\u0007ø\u0001\u0000¢\u0006\u0004\b \u0010!R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\b\u001a\u00020\t*\u00020\n8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\""}, d2 = {"Landroidx/compose/material3/SwitchDefaults;", "", "()V", "IconSize", "Landroidx/compose/ui/unit/Dp;", "getIconSize-D9Ej5fM", "()F", "F", "defaultSwitchColors", "Landroidx/compose/material3/SwitchColors;", "Landroidx/compose/material3/ColorScheme;", "getDefaultSwitchColors$material3_release", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/SwitchColors;", "colors", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/SwitchColors;", "checkedThumbColor", "Landroidx/compose/ui/graphics/Color;", "checkedTrackColor", "checkedBorderColor", "checkedIconColor", "uncheckedThumbColor", "uncheckedTrackColor", "uncheckedBorderColor", "uncheckedIconColor", "disabledCheckedThumbColor", "disabledCheckedTrackColor", "disabledCheckedBorderColor", "disabledCheckedIconColor", "disabledUncheckedThumbColor", "disabledUncheckedTrackColor", "disabledUncheckedBorderColor", "disabledUncheckedIconColor", "colors-V1nXRL4", "(JJJJJJJJJJJJJJJJLandroidx/compose/runtime/Composer;III)Landroidx/compose/material3/SwitchColors;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SwitchDefaults {
    public static final int $stable = 0;
    public static final SwitchDefaults INSTANCE = new SwitchDefaults();
    private static final float IconSize = Dp.m6844constructorimpl(16);

    private SwitchDefaults() {
    }

    @Composable
    public final SwitchColors colors(Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(435552781, i, -1, "androidx.compose.material3.SwitchDefaults.colors (Switch.kt:299)");
        }
        SwitchColors defaultSwitchColors$material3_release = getDefaultSwitchColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return defaultSwitchColors$material3_release;
    }

    @Composable
    /* renamed from: colors-V1nXRL4, reason: not valid java name */
    public final SwitchColors m2346colorsV1nXRL4(long j5, long j6, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, Composer composer, int i, int i6, int i10) {
        long j24;
        long j25;
        long jM4184compositeOverOWjLjI;
        long j26;
        long jM4184compositeOverOWjLjI2;
        long j27;
        long jM4184compositeOverOWjLjI3;
        long j28;
        long jM4184compositeOverOWjLjI4;
        long j29;
        long jM4184compositeOverOWjLjI5;
        long j30;
        int i11;
        long jM4184compositeOverOWjLjI6;
        long j31;
        long jM4184compositeOverOWjLjI7;
        long value = (i10 & 1) != 0 ? ColorSchemeKt.getValue(SwitchTokens.INSTANCE.getSelectedHandleColor(), composer, 6) : j5;
        long value2 = (i10 & 2) != 0 ? ColorSchemeKt.getValue(SwitchTokens.INSTANCE.getSelectedTrackColor(), composer, 6) : j6;
        long jM4174getTransparent0d7_KjU = (i10 & 4) != 0 ? Color.INSTANCE.m4174getTransparent0d7_KjU() : j10;
        long value3 = (i10 & 8) != 0 ? ColorSchemeKt.getValue(SwitchTokens.INSTANCE.getSelectedIconColor(), composer, 6) : j11;
        long value4 = (i10 & 16) != 0 ? ColorSchemeKt.getValue(SwitchTokens.INSTANCE.getUnselectedHandleColor(), composer, 6) : j12;
        long value5 = (i10 & 32) != 0 ? ColorSchemeKt.getValue(SwitchTokens.INSTANCE.getUnselectedTrackColor(), composer, 6) : j13;
        long value6 = (i10 & 64) != 0 ? ColorSchemeKt.getValue(SwitchTokens.INSTANCE.getUnselectedFocusTrackOutlineColor(), composer, 6) : j14;
        long value7 = (i10 & 128) != 0 ? ColorSchemeKt.getValue(SwitchTokens.INSTANCE.getUnselectedIconColor(), composer, 6) : j15;
        if ((i10 & 256) != 0) {
            SwitchTokens switchTokens = SwitchTokens.INSTANCE;
            j24 = value;
            j25 = value2;
            jM4184compositeOverOWjLjI = ColorKt.m4184compositeOverOWjLjI(Color.m4138copywmQWz5c$default(ColorSchemeKt.getValue(switchTokens.getDisabledSelectedHandleColor(), composer, 6), switchTokens.getDisabledSelectedHandleOpacity(), 0.0f, 0.0f, 0.0f, 14, null), MaterialTheme.INSTANCE.getColorScheme(composer, 6).getSurface());
        } else {
            j24 = value;
            j25 = value2;
            jM4184compositeOverOWjLjI = j16;
        }
        if ((i10 & 512) != 0) {
            SwitchTokens switchTokens2 = SwitchTokens.INSTANCE;
            j26 = jM4184compositeOverOWjLjI;
            jM4184compositeOverOWjLjI2 = ColorKt.m4184compositeOverOWjLjI(Color.m4138copywmQWz5c$default(ColorSchemeKt.getValue(switchTokens2.getDisabledSelectedTrackColor(), composer, 6), switchTokens2.getDisabledTrackOpacity(), 0.0f, 0.0f, 0.0f, 14, null), MaterialTheme.INSTANCE.getColorScheme(composer, 6).getSurface());
        } else {
            j26 = jM4184compositeOverOWjLjI;
            jM4184compositeOverOWjLjI2 = j17;
        }
        long jM4174getTransparent0d7_KjU2 = (i10 & 1024) != 0 ? Color.INSTANCE.m4174getTransparent0d7_KjU() : j18;
        if ((i10 & 2048) != 0) {
            SwitchTokens switchTokens3 = SwitchTokens.INSTANCE;
            j27 = jM4184compositeOverOWjLjI2;
            jM4184compositeOverOWjLjI3 = ColorKt.m4184compositeOverOWjLjI(Color.m4138copywmQWz5c$default(ColorSchemeKt.getValue(switchTokens3.getDisabledSelectedIconColor(), composer, 6), switchTokens3.getDisabledSelectedIconOpacity(), 0.0f, 0.0f, 0.0f, 14, null), MaterialTheme.INSTANCE.getColorScheme(composer, 6).getSurface());
        } else {
            j27 = jM4184compositeOverOWjLjI2;
            jM4184compositeOverOWjLjI3 = j19;
        }
        if ((i10 & 4096) != 0) {
            SwitchTokens switchTokens4 = SwitchTokens.INSTANCE;
            j28 = jM4184compositeOverOWjLjI3;
            jM4184compositeOverOWjLjI4 = ColorKt.m4184compositeOverOWjLjI(Color.m4138copywmQWz5c$default(ColorSchemeKt.getValue(switchTokens4.getDisabledUnselectedHandleColor(), composer, 6), switchTokens4.getDisabledUnselectedHandleOpacity(), 0.0f, 0.0f, 0.0f, 14, null), MaterialTheme.INSTANCE.getColorScheme(composer, 6).getSurface());
        } else {
            j28 = jM4184compositeOverOWjLjI3;
            jM4184compositeOverOWjLjI4 = j20;
        }
        if ((i10 & 8192) != 0) {
            SwitchTokens switchTokens5 = SwitchTokens.INSTANCE;
            j29 = jM4184compositeOverOWjLjI4;
            jM4184compositeOverOWjLjI5 = ColorKt.m4184compositeOverOWjLjI(Color.m4138copywmQWz5c$default(ColorSchemeKt.getValue(switchTokens5.getDisabledUnselectedTrackColor(), composer, 6), switchTokens5.getDisabledTrackOpacity(), 0.0f, 0.0f, 0.0f, 14, null), MaterialTheme.INSTANCE.getColorScheme(composer, 6).getSurface());
        } else {
            j29 = jM4184compositeOverOWjLjI4;
            jM4184compositeOverOWjLjI5 = j21;
        }
        if ((i10 & 16384) != 0) {
            SwitchTokens switchTokens6 = SwitchTokens.INSTANCE;
            i11 = 6;
            j30 = jM4184compositeOverOWjLjI5;
            jM4184compositeOverOWjLjI6 = ColorKt.m4184compositeOverOWjLjI(Color.m4138copywmQWz5c$default(ColorSchemeKt.getValue(switchTokens6.getDisabledUnselectedTrackOutlineColor(), composer, 6), switchTokens6.getDisabledTrackOpacity(), 0.0f, 0.0f, 0.0f, 14, null), MaterialTheme.INSTANCE.getColorScheme(composer, 6).getSurface());
        } else {
            j30 = jM4184compositeOverOWjLjI5;
            i11 = 6;
            jM4184compositeOverOWjLjI6 = j22;
        }
        if ((i10 & 32768) != 0) {
            SwitchTokens switchTokens7 = SwitchTokens.INSTANCE;
            j31 = jM4184compositeOverOWjLjI6;
            jM4184compositeOverOWjLjI7 = ColorKt.m4184compositeOverOWjLjI(Color.m4138copywmQWz5c$default(ColorSchemeKt.getValue(switchTokens7.getDisabledUnselectedIconColor(), composer, i11), switchTokens7.getDisabledUnselectedIconOpacity(), 0.0f, 0.0f, 0.0f, 14, null), MaterialTheme.INSTANCE.getColorScheme(composer, i11).getSurface());
        } else {
            j31 = jM4184compositeOverOWjLjI6;
            jM4184compositeOverOWjLjI7 = j23;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1937926421, i, i6, "androidx.compose.material3.SwitchDefaults.colors (Switch.kt:362)");
        }
        long j32 = j24;
        SwitchColors switchColors = new SwitchColors(j32, j25, jM4174getTransparent0d7_KjU, value3, value4, value5, value6, value7, j26, j27, jM4174getTransparent0d7_KjU2, j28, j29, j30, j31, jM4184compositeOverOWjLjI7, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return switchColors;
    }

    public final SwitchColors getDefaultSwitchColors$material3_release(ColorScheme colorScheme) {
        SwitchColors defaultSwitchColorsCached = colorScheme.getDefaultSwitchColorsCached();
        if (defaultSwitchColorsCached != null) {
            return defaultSwitchColorsCached;
        }
        SwitchTokens switchTokens = SwitchTokens.INSTANCE;
        long jFromToken = ColorSchemeKt.fromToken(colorScheme, switchTokens.getSelectedHandleColor());
        long jFromToken2 = ColorSchemeKt.fromToken(colorScheme, switchTokens.getSelectedTrackColor());
        Color.Companion companion = Color.INSTANCE;
        SwitchColors switchColors = new SwitchColors(jFromToken, jFromToken2, companion.m4174getTransparent0d7_KjU(), ColorSchemeKt.fromToken(colorScheme, switchTokens.getSelectedIconColor()), ColorSchemeKt.fromToken(colorScheme, switchTokens.getUnselectedHandleColor()), ColorSchemeKt.fromToken(colorScheme, switchTokens.getUnselectedTrackColor()), ColorSchemeKt.fromToken(colorScheme, switchTokens.getUnselectedFocusTrackOutlineColor()), ColorSchemeKt.fromToken(colorScheme, switchTokens.getUnselectedIconColor()), ColorKt.m4184compositeOverOWjLjI(Color.m4138copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, switchTokens.getDisabledSelectedHandleColor()), switchTokens.getDisabledSelectedHandleOpacity(), 0.0f, 0.0f, 0.0f, 14, null), colorScheme.getSurface()), ColorKt.m4184compositeOverOWjLjI(Color.m4138copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, switchTokens.getDisabledSelectedTrackColor()), switchTokens.getDisabledTrackOpacity(), 0.0f, 0.0f, 0.0f, 14, null), colorScheme.getSurface()), companion.m4174getTransparent0d7_KjU(), ColorKt.m4184compositeOverOWjLjI(Color.m4138copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, switchTokens.getDisabledSelectedIconColor()), switchTokens.getDisabledSelectedIconOpacity(), 0.0f, 0.0f, 0.0f, 14, null), colorScheme.getSurface()), ColorKt.m4184compositeOverOWjLjI(Color.m4138copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, switchTokens.getDisabledUnselectedHandleColor()), switchTokens.getDisabledUnselectedHandleOpacity(), 0.0f, 0.0f, 0.0f, 14, null), colorScheme.getSurface()), ColorKt.m4184compositeOverOWjLjI(Color.m4138copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, switchTokens.getDisabledUnselectedTrackColor()), switchTokens.getDisabledTrackOpacity(), 0.0f, 0.0f, 0.0f, 14, null), colorScheme.getSurface()), ColorKt.m4184compositeOverOWjLjI(Color.m4138copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, switchTokens.getDisabledUnselectedTrackOutlineColor()), switchTokens.getDisabledTrackOpacity(), 0.0f, 0.0f, 0.0f, 14, null), colorScheme.getSurface()), ColorKt.m4184compositeOverOWjLjI(Color.m4138copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, switchTokens.getDisabledUnselectedIconColor()), switchTokens.getDisabledUnselectedIconOpacity(), 0.0f, 0.0f, 0.0f, 14, null), colorScheme.getSurface()), null);
        colorScheme.setDefaultSwitchColorsCached$material3_release(switchColors);
        return switchColors;
    }

    /* renamed from: getIconSize-D9Ej5fM, reason: not valid java name */
    public final float m2347getIconSizeD9Ej5fM() {
        return IconSize;
    }
}
