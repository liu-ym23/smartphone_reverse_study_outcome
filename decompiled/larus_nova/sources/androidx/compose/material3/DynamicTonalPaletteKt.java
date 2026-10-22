package androidx.compose.material3;

import android.R;
import android.content.Context;
import android.os.Build;
import androidx.compose.material3.internal.colorUtil.Cam;
import androidx.compose.material3.internal.colorUtil.CamUtils;
import androidx.compose.ui.graphics.ColorKt;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0001\u001a\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a\u001d\u0010\u0007\u001a\u00020\b*\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\nH\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0001H\u0001\u001a\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u0003H\u0001\u001a\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0001H\u0001\u001a\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u0003H\u0001¨\u0006\u0012"}, d2 = {"dynamicTonalPalette", "Landroidx/compose/material3/TonalPalette;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "dynamicLightColorScheme", "Landroidx/compose/material3/ColorScheme;", "dynamicDarkColorScheme", "setLuminance", "Landroidx/compose/ui/graphics/Color;", "newLuminance", "", "setLuminance-DxMtmZc", "(JF)J", "dynamicLightColorScheme31", "tonalPalette", "dynamicLightColorScheme34", "dynamicDarkColorScheme31", "dynamicDarkColorScheme34", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class DynamicTonalPaletteKt {
    public static final ColorScheme dynamicDarkColorScheme(Context r100) {
        if (Build.VERSION.SDK_INT < 34) goto L6;
        return dynamicDarkColorScheme34(r100);
    L6:
        return dynamicDarkColorScheme31(dynamicTonalPalette(r100));
    }

    public static final ColorScheme dynamicDarkColorScheme31(TonalPalette r910) {
        long r100 = r910.m2980getPrimary800d7_KjU();
        long r101 = r910.m2974getPrimary200d7_KjU();
        long r102 = r910.m2975getPrimary300d7_KjU();
        long r103 = r910.m2981getPrimary900d7_KjU();
        long r104 = r910.m2976getPrimary400d7_KjU();
        long r110 = r910.m2993getSecondary800d7_KjU();
        long r111 = r910.m2987getSecondary200d7_KjU();
        long r112 = r910.m2988getSecondary300d7_KjU();
        long r113 = r910.m2994getSecondary900d7_KjU();
        long r114 = r910.m3006getTertiary800d7_KjU();
        long r210 = r910.m3000getTertiary200d7_KjU();
        long r211 = r910.m3001getTertiary300d7_KjU();
        long r212 = r910.m3007getTertiary900d7_KjU();
        long r213 = r910.m2959getNeutralVariant60d7_KjU();
        long r214 = r910.m2964getNeutralVariant900d7_KjU();
        long r310 = r910.m2959getNeutralVariant60d7_KjU();
        long r311 = r910.m2964getNeutralVariant900d7_KjU();
        long r312 = r910.m2955getNeutralVariant300d7_KjU();
        long r313 = r910.m2962getNeutralVariant800d7_KjU();
        long r410 = r910.m2964getNeutralVariant900d7_KjU();
        long r411 = r910.m2952getNeutralVariant200d7_KjU();
        long r510 = r910.m2960getNeutralVariant600d7_KjU();
        long r511 = r910.m2955getNeutralVariant300d7_KjU();
        long r512 = r910.m2947getNeutralVariant00d7_KjU();
        long r513 = r910.m2954getNeutralVariant240d7_KjU();
        long r710 = r910.m2959getNeutralVariant60d7_KjU();
        long r610 = r910.m2950getNeutralVariant120d7_KjU();
        long r611 = r910.m2951getNeutralVariant170d7_KjU();
        long r612 = r910.m2953getNeutralVariant220d7_KjU();
        long r613 = r910.m2948getNeutralVariant100d7_KjU();
        long r614 = r910.m2956getNeutralVariant40d7_KjU();
        return ColorSchemeKt.m2048darkColorScheme_VG5OTI$default(r100, r101, r102, r103, r104, r110, r111, r112, r113, r114, r210, r211, r212, r213, r214, r310, r311, r312, r313, r910.m2980getPrimary800d7_KjU(), r410, r411, 0, 0, 0, 0, r510, r511, r512, r513, r610, r611, r612, r613, r614, r710, r910.m2981getPrimary900d7_KjU(), r910.m2980getPrimary800d7_KjU(), r910.m2972getPrimary100d7_KjU(), r910.m2975getPrimary300d7_KjU(), r910.m2994getSecondary900d7_KjU(), r910.m2993getSecondary800d7_KjU(), r910.m2985getSecondary100d7_KjU(), r910.m2988getSecondary300d7_KjU(), r910.m3007getTertiary900d7_KjU(), r910.m3006getTertiary800d7_KjU(), r910.m2998getTertiary100d7_KjU(), r910.m3001getTertiary300d7_KjU(), 62914560, 0, null);
    }

    public static final ColorScheme dynamicDarkColorScheme34(Context r102) {
        ColorResourceHelper r100 = ColorResourceHelper.INSTANCE;
        long r101 = r100.m1985getColorWaAFU9c(r102, R.color.system_primary_dark);
        long r103 = r100.m1985getColorWaAFU9c(r102, R.color.system_on_primary_dark);
        long r104 = r100.m1985getColorWaAFU9c(r102, R.color.system_primary_container_dark);
        long r105 = r100.m1985getColorWaAFU9c(r102, R.color.system_on_primary_container_dark);
        long r110 = r100.m1985getColorWaAFU9c(r102, R.color.system_primary_light);
        long r111 = r100.m1985getColorWaAFU9c(r102, R.color.system_secondary_dark);
        long r112 = r100.m1985getColorWaAFU9c(r102, R.color.system_on_secondary_dark);
        long r113 = r100.m1985getColorWaAFU9c(r102, R.color.system_secondary_container_dark);
        long r114 = r100.m1985getColorWaAFU9c(r102, R.color.system_on_secondary_container_dark);
        long r210 = r100.m1985getColorWaAFU9c(r102, R.color.system_tertiary_dark);
        long r211 = r100.m1985getColorWaAFU9c(r102, R.color.system_on_tertiary_dark);
        long r212 = r100.m1985getColorWaAFU9c(r102, R.color.system_tertiary_container_dark);
        long r213 = r100.m1985getColorWaAFU9c(r102, R.color.system_on_tertiary_container_dark);
        long r214 = r100.m1985getColorWaAFU9c(r102, R.color.system_background_dark);
        long r310 = r100.m1985getColorWaAFU9c(r102, R.color.system_on_background_dark);
        long r311 = r100.m1985getColorWaAFU9c(r102, R.color.system_surface_dark);
        long r312 = r100.m1985getColorWaAFU9c(r102, R.color.system_on_surface_dark);
        long r313 = r100.m1985getColorWaAFU9c(r102, R.color.system_surface_variant_dark);
        long r314 = r100.m1985getColorWaAFU9c(r102, R.color.system_on_surface_variant_dark);
        long r410 = r100.m1985getColorWaAFU9c(r102, R.color.system_surface_light);
        long r411 = r100.m1985getColorWaAFU9c(r102, R.color.system_on_surface_light);
        long r510 = r100.m1985getColorWaAFU9c(r102, R.color.system_outline_dark);
        long r511 = r100.m1985getColorWaAFU9c(r102, R.color.system_outline_variant_dark);
        long r610 = r100.m1985getColorWaAFU9c(r102, R.color.system_surface_bright_dark);
        long r710 = r100.m1985getColorWaAFU9c(r102, R.color.system_surface_dim_dark);
        long r611 = r100.m1985getColorWaAFU9c(r102, R.color.system_surface_container_dark);
        long r612 = r100.m1985getColorWaAFU9c(r102, R.color.system_surface_container_high_dark);
        long r613 = r100.m1985getColorWaAFU9c(r102, R.color.system_surface_container_highest_dark);
        long r614 = r100.m1985getColorWaAFU9c(r102, R.color.system_surface_container_low_dark);
        long r711 = r100.m1985getColorWaAFU9c(r102, R.color.system_surface_container_lowest_dark);
        return ColorSchemeKt.m2048darkColorScheme_VG5OTI$default(r101, r103, r104, r105, r110, r111, r112, r113, r114, r210, r211, r212, r213, r214, r310, r311, r312, r313, r314, r100.m1985getColorWaAFU9c(r102, R.color.system_primary_dark), r410, r411, 0, 0, 0, 0, r510, r511, 0, r610, r611, r612, r613, r614, r711, r710, r100.m1985getColorWaAFU9c(r102, R.color.system_primary_fixed), r100.m1985getColorWaAFU9c(r102, R.color.system_primary_fixed_dim), r100.m1985getColorWaAFU9c(r102, R.color.system_on_primary_fixed), r100.m1985getColorWaAFU9c(r102, R.color.system_on_primary_fixed_variant), r100.m1985getColorWaAFU9c(r102, R.color.system_secondary_fixed), r100.m1985getColorWaAFU9c(r102, R.color.system_secondary_fixed_dim), r100.m1985getColorWaAFU9c(r102, R.color.system_on_secondary_fixed), r100.m1985getColorWaAFU9c(r102, R.color.system_on_secondary_fixed_variant), r100.m1985getColorWaAFU9c(r102, R.color.system_tertiary_fixed), r100.m1985getColorWaAFU9c(r102, R.color.system_tertiary_fixed_dim), r100.m1985getColorWaAFU9c(r102, R.color.system_on_tertiary_fixed), r100.m1985getColorWaAFU9c(r102, R.color.system_on_tertiary_fixed_variant), 331350016, 0, null);
    }

    public static final ColorScheme dynamicLightColorScheme(Context r100) {
        if (Build.VERSION.SDK_INT < 34) goto L6;
        return dynamicLightColorScheme34(r100);
    L6:
        return dynamicLightColorScheme31(dynamicTonalPalette(r100));
    }

    public static final ColorScheme dynamicLightColorScheme31(TonalPalette r910) {
        long r100 = r910.m2976getPrimary400d7_KjU();
        long r101 = r910.m2973getPrimary1000d7_KjU();
        long r102 = r910.m2981getPrimary900d7_KjU();
        long r103 = r910.m2972getPrimary100d7_KjU();
        long r104 = r910.m2980getPrimary800d7_KjU();
        long r110 = r910.m2989getSecondary400d7_KjU();
        long r111 = r910.m2986getSecondary1000d7_KjU();
        long r112 = r910.m2994getSecondary900d7_KjU();
        long r113 = r910.m2985getSecondary100d7_KjU();
        long r114 = r910.m3002getTertiary400d7_KjU();
        long r210 = r910.m2999getTertiary1000d7_KjU();
        long r211 = r910.m3007getTertiary900d7_KjU();
        long r212 = r910.m2998getTertiary100d7_KjU();
        long r213 = r910.m2969getNeutralVariant980d7_KjU();
        long r214 = r910.m2948getNeutralVariant100d7_KjU();
        long r310 = r910.m2969getNeutralVariant980d7_KjU();
        long r311 = r910.m2948getNeutralVariant100d7_KjU();
        long r312 = r910.m2964getNeutralVariant900d7_KjU();
        long r313 = r910.m2955getNeutralVariant300d7_KjU();
        long r410 = r910.m2952getNeutralVariant200d7_KjU();
        long r411 = r910.m2967getNeutralVariant950d7_KjU();
        long r510 = r910.m2958getNeutralVariant500d7_KjU();
        long r511 = r910.m2962getNeutralVariant800d7_KjU();
        long r512 = r910.m2947getNeutralVariant00d7_KjU();
        long r513 = r910.m2969getNeutralVariant980d7_KjU();
        long r710 = r910.m2963getNeutralVariant870d7_KjU();
        long r610 = r910.m2966getNeutralVariant940d7_KjU();
        long r611 = r910.m2965getNeutralVariant920d7_KjU();
        long r612 = r910.m2964getNeutralVariant900d7_KjU();
        long r613 = r910.m2968getNeutralVariant960d7_KjU();
        long r614 = r910.m2949getNeutralVariant1000d7_KjU();
        return ColorSchemeKt.m2054lightColorScheme_VG5OTI$default(r100, r101, r102, r103, r104, r110, r111, r112, r113, r114, r210, r211, r212, r213, r214, r310, r311, r312, r313, r910.m2976getPrimary400d7_KjU(), r410, r411, 0, 0, 0, 0, r510, r511, r512, r513, r610, r611, r612, r613, r614, r710, r910.m2981getPrimary900d7_KjU(), r910.m2980getPrimary800d7_KjU(), r910.m2972getPrimary100d7_KjU(), r910.m2975getPrimary300d7_KjU(), r910.m2994getSecondary900d7_KjU(), r910.m2993getSecondary800d7_KjU(), r910.m2985getSecondary100d7_KjU(), r910.m2988getSecondary300d7_KjU(), r910.m3007getTertiary900d7_KjU(), r910.m3006getTertiary800d7_KjU(), r910.m2998getTertiary100d7_KjU(), r910.m3001getTertiary300d7_KjU(), 62914560, 0, null);
    }

    public static final ColorScheme dynamicLightColorScheme34(Context r102) {
        ColorResourceHelper r100 = ColorResourceHelper.INSTANCE;
        long r101 = r100.m1985getColorWaAFU9c(r102, R.color.system_primary_light);
        long r103 = r100.m1985getColorWaAFU9c(r102, R.color.system_on_primary_light);
        long r104 = r100.m1985getColorWaAFU9c(r102, R.color.system_primary_container_light);
        long r105 = r100.m1985getColorWaAFU9c(r102, R.color.system_on_primary_container_light);
        long r110 = r100.m1985getColorWaAFU9c(r102, R.color.system_primary_dark);
        long r111 = r100.m1985getColorWaAFU9c(r102, R.color.system_secondary_light);
        long r112 = r100.m1985getColorWaAFU9c(r102, R.color.system_on_secondary_light);
        long r113 = r100.m1985getColorWaAFU9c(r102, R.color.system_secondary_container_light);
        long r114 = r100.m1985getColorWaAFU9c(r102, R.color.system_on_secondary_container_light);
        long r210 = r100.m1985getColorWaAFU9c(r102, R.color.system_tertiary_light);
        long r211 = r100.m1985getColorWaAFU9c(r102, R.color.system_on_tertiary_light);
        long r212 = r100.m1985getColorWaAFU9c(r102, R.color.system_tertiary_container_light);
        long r213 = r100.m1985getColorWaAFU9c(r102, R.color.system_on_tertiary_container_light);
        long r214 = r100.m1985getColorWaAFU9c(r102, R.color.system_background_light);
        long r310 = r100.m1985getColorWaAFU9c(r102, R.color.system_on_background_light);
        long r311 = r100.m1985getColorWaAFU9c(r102, R.color.system_surface_light);
        long r312 = r100.m1985getColorWaAFU9c(r102, R.color.system_on_surface_light);
        long r313 = r100.m1985getColorWaAFU9c(r102, R.color.system_surface_variant_light);
        long r314 = r100.m1985getColorWaAFU9c(r102, R.color.system_on_surface_variant_light);
        long r410 = r100.m1985getColorWaAFU9c(r102, R.color.system_surface_dark);
        long r411 = r100.m1985getColorWaAFU9c(r102, R.color.system_on_surface_dark);
        long r510 = r100.m1985getColorWaAFU9c(r102, R.color.system_outline_light);
        long r511 = r100.m1985getColorWaAFU9c(r102, R.color.system_outline_variant_light);
        long r610 = r100.m1985getColorWaAFU9c(r102, R.color.system_surface_bright_light);
        long r710 = r100.m1985getColorWaAFU9c(r102, R.color.system_surface_dim_light);
        long r611 = r100.m1985getColorWaAFU9c(r102, R.color.system_surface_container_light);
        long r612 = r100.m1985getColorWaAFU9c(r102, R.color.system_surface_container_high_light);
        long r613 = r100.m1985getColorWaAFU9c(r102, R.color.system_surface_container_highest_light);
        long r614 = r100.m1985getColorWaAFU9c(r102, R.color.system_surface_container_low_light);
        long r711 = r100.m1985getColorWaAFU9c(r102, R.color.system_surface_container_lowest_light);
        return ColorSchemeKt.m2054lightColorScheme_VG5OTI$default(r101, r103, r104, r105, r110, r111, r112, r113, r114, r210, r211, r212, r213, r214, r310, r311, r312, r313, r314, r100.m1985getColorWaAFU9c(r102, R.color.system_primary_light), r410, r411, 0, 0, 0, 0, r510, r511, 0, r610, r611, r612, r613, r614, r711, r710, r100.m1985getColorWaAFU9c(r102, R.color.system_primary_fixed), r100.m1985getColorWaAFU9c(r102, R.color.system_primary_fixed_dim), r100.m1985getColorWaAFU9c(r102, R.color.system_on_primary_fixed), r100.m1985getColorWaAFU9c(r102, R.color.system_on_primary_fixed_variant), r100.m1985getColorWaAFU9c(r102, R.color.system_secondary_fixed), r100.m1985getColorWaAFU9c(r102, R.color.system_secondary_fixed_dim), r100.m1985getColorWaAFU9c(r102, R.color.system_on_secondary_fixed), r100.m1985getColorWaAFU9c(r102, R.color.system_on_secondary_fixed_variant), r100.m1985getColorWaAFU9c(r102, R.color.system_tertiary_fixed), r100.m1985getColorWaAFU9c(r102, R.color.system_tertiary_fixed_dim), r100.m1985getColorWaAFU9c(r102, R.color.system_on_tertiary_fixed), r100.m1985getColorWaAFU9c(r102, R.color.system_on_tertiary_fixed_variant), 331350016, 0, null);
    }

    public static final TonalPalette dynamicTonalPalette(Context r183) {
        ColorResourceHelper r110 = ColorResourceHelper.INSTANCE;
        return new TonalPalette(r110.m1985getColorWaAFU9c(r183, R.color.system_neutral1_0), r110.m1985getColorWaAFU9c(r183, R.color.system_neutral1_10), m2190setLuminanceDxMtmZc(r110.m1985getColorWaAFU9c(r183, R.color.system_neutral1_600), 98.0f), m2190setLuminanceDxMtmZc(r110.m1985getColorWaAFU9c(r183, R.color.system_neutral1_600), 96.0f), r110.m1985getColorWaAFU9c(r183, R.color.system_neutral1_50), m2190setLuminanceDxMtmZc(r110.m1985getColorWaAFU9c(r183, R.color.system_neutral1_600), 94.0f), m2190setLuminanceDxMtmZc(r110.m1985getColorWaAFU9c(r183, R.color.system_neutral1_600), 92.0f), r110.m1985getColorWaAFU9c(r183, R.color.system_neutral1_100), m2190setLuminanceDxMtmZc(r110.m1985getColorWaAFU9c(r183, R.color.system_neutral1_600), 87.0f), r110.m1985getColorWaAFU9c(r183, R.color.system_neutral1_200), r110.m1985getColorWaAFU9c(r183, R.color.system_neutral1_300), r110.m1985getColorWaAFU9c(r183, R.color.system_neutral1_400), r110.m1985getColorWaAFU9c(r183, R.color.system_neutral1_500), r110.m1985getColorWaAFU9c(r183, R.color.system_neutral1_600), r110.m1985getColorWaAFU9c(r183, R.color.system_neutral1_700), m2190setLuminanceDxMtmZc(r110.m1985getColorWaAFU9c(r183, R.color.system_neutral1_600), 24.0f), m2190setLuminanceDxMtmZc(r110.m1985getColorWaAFU9c(r183, R.color.system_neutral1_600), 22.0f), r110.m1985getColorWaAFU9c(r183, R.color.system_neutral1_800), m2190setLuminanceDxMtmZc(r110.m1985getColorWaAFU9c(r183, R.color.system_neutral1_600), 17.0f), m2190setLuminanceDxMtmZc(r110.m1985getColorWaAFU9c(r183, R.color.system_neutral1_600), 12.0f), r110.m1985getColorWaAFU9c(r183, R.color.system_neutral1_900), m2190setLuminanceDxMtmZc(r110.m1985getColorWaAFU9c(r183, R.color.system_neutral1_600), 6.0f), m2190setLuminanceDxMtmZc(r110.m1985getColorWaAFU9c(r183, R.color.system_neutral1_600), 4.0f), r110.m1985getColorWaAFU9c(r183, R.color.system_neutral1_1000), r110.m1985getColorWaAFU9c(r183, R.color.system_neutral2_0), r110.m1985getColorWaAFU9c(r183, R.color.system_neutral2_10), m2190setLuminanceDxMtmZc(r110.m1985getColorWaAFU9c(r183, R.color.system_neutral2_600), 98.0f), m2190setLuminanceDxMtmZc(r110.m1985getColorWaAFU9c(r183, R.color.system_neutral2_600), 96.0f), r110.m1985getColorWaAFU9c(r183, R.color.system_neutral2_50), m2190setLuminanceDxMtmZc(r110.m1985getColorWaAFU9c(r183, R.color.system_neutral2_600), 94.0f), m2190setLuminanceDxMtmZc(r110.m1985getColorWaAFU9c(r183, R.color.system_neutral2_600), 92.0f), r110.m1985getColorWaAFU9c(r183, R.color.system_neutral2_100), m2190setLuminanceDxMtmZc(r110.m1985getColorWaAFU9c(r183, R.color.system_neutral2_600), 87.0f), r110.m1985getColorWaAFU9c(r183, R.color.system_neutral2_200), r110.m1985getColorWaAFU9c(r183, R.color.system_neutral2_300), r110.m1985getColorWaAFU9c(r183, R.color.system_neutral2_400), r110.m1985getColorWaAFU9c(r183, R.color.system_neutral2_500), r110.m1985getColorWaAFU9c(r183, R.color.system_neutral2_600), r110.m1985getColorWaAFU9c(r183, R.color.system_neutral2_700), m2190setLuminanceDxMtmZc(r110.m1985getColorWaAFU9c(r183, R.color.system_neutral2_600), 24.0f), m2190setLuminanceDxMtmZc(r110.m1985getColorWaAFU9c(r183, R.color.system_neutral2_600), 22.0f), r110.m1985getColorWaAFU9c(r183, R.color.system_neutral2_800), m2190setLuminanceDxMtmZc(r110.m1985getColorWaAFU9c(r183, R.color.system_neutral2_600), 17.0f), m2190setLuminanceDxMtmZc(r110.m1985getColorWaAFU9c(r183, R.color.system_neutral2_600), 12.0f), r110.m1985getColorWaAFU9c(r183, R.color.system_neutral2_900), m2190setLuminanceDxMtmZc(r110.m1985getColorWaAFU9c(r183, R.color.system_neutral2_600), 6.0f), m2190setLuminanceDxMtmZc(r110.m1985getColorWaAFU9c(r183, R.color.system_neutral2_600), 4.0f), r110.m1985getColorWaAFU9c(r183, R.color.system_neutral2_1000), r110.m1985getColorWaAFU9c(r183, R.color.system_accent1_0), r110.m1985getColorWaAFU9c(r183, R.color.system_accent1_10), r110.m1985getColorWaAFU9c(r183, R.color.system_accent1_50), r110.m1985getColorWaAFU9c(r183, R.color.system_accent1_100), r110.m1985getColorWaAFU9c(r183, R.color.system_accent1_200), r110.m1985getColorWaAFU9c(r183, R.color.system_accent1_300), r110.m1985getColorWaAFU9c(r183, R.color.system_accent1_400), r110.m1985getColorWaAFU9c(r183, R.color.system_accent1_500), r110.m1985getColorWaAFU9c(r183, R.color.system_accent1_600), r110.m1985getColorWaAFU9c(r183, R.color.system_accent1_700), r110.m1985getColorWaAFU9c(r183, R.color.system_accent1_800), r110.m1985getColorWaAFU9c(r183, R.color.system_accent1_900), r110.m1985getColorWaAFU9c(r183, R.color.system_accent1_1000), r110.m1985getColorWaAFU9c(r183, R.color.system_accent2_0), r110.m1985getColorWaAFU9c(r183, R.color.system_accent2_10), r110.m1985getColorWaAFU9c(r183, R.color.system_accent2_50), r110.m1985getColorWaAFU9c(r183, R.color.system_accent2_100), r110.m1985getColorWaAFU9c(r183, R.color.system_accent2_200), r110.m1985getColorWaAFU9c(r183, R.color.system_accent2_300), r110.m1985getColorWaAFU9c(r183, R.color.system_accent2_400), r110.m1985getColorWaAFU9c(r183, R.color.system_accent2_500), r110.m1985getColorWaAFU9c(r183, R.color.system_accent2_600), r110.m1985getColorWaAFU9c(r183, R.color.system_accent2_700), r110.m1985getColorWaAFU9c(r183, R.color.system_accent2_800), r110.m1985getColorWaAFU9c(r183, R.color.system_accent2_900), r110.m1985getColorWaAFU9c(r183, R.color.system_accent2_1000), r110.m1985getColorWaAFU9c(r183, R.color.system_accent3_0), r110.m1985getColorWaAFU9c(r183, R.color.system_accent3_10), r110.m1985getColorWaAFU9c(r183, R.color.system_accent3_50), r110.m1985getColorWaAFU9c(r183, R.color.system_accent3_100), r110.m1985getColorWaAFU9c(r183, R.color.system_accent3_200), r110.m1985getColorWaAFU9c(r183, R.color.system_accent3_300), r110.m1985getColorWaAFU9c(r183, R.color.system_accent3_400), r110.m1985getColorWaAFU9c(r183, R.color.system_accent3_500), r110.m1985getColorWaAFU9c(r183, R.color.system_accent3_600), r110.m1985getColorWaAFU9c(r183, R.color.system_accent3_700), r110.m1985getColorWaAFU9c(r183, R.color.system_accent3_800), r110.m1985getColorWaAFU9c(r183, R.color.system_accent3_900), r110.m1985getColorWaAFU9c(r183, R.color.system_accent3_1000), null);
    }

    /* JADX INFO: renamed from: setLuminance-DxMtmZc, reason: not valid java name */
    public static final long m2190setLuminanceDxMtmZc(long r100, float r110) {
        double r101 = r110;
        boolean r102 = true;
        if (r101 >= 1.0E-4d) goto L5;
        boolean r103 = true;
    L7:
        if (r101 > 99.9999d) goto L11;
        r102 = false;
    L11:
        if ((r103 | r102) == true) goto L13;
        Cam.Companion r104 = Cam.Companion;
        Cam r105 = r104.fromInt(ColorKt.m4881toArgb8_81llA(r100));
        return ColorKt.Color(r104.getInt(r105.getHue(), r105.getChroma(), r110));
    L13:
        return ColorKt.Color(CamUtils.INSTANCE.argbFromLstar(r101));
    L5:
        r103 = false;
        goto L7
    }
}
