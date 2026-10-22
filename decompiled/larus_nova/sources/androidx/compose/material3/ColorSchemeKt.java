package androidx.compose.material3;

import androidx.compose.material3.tokens.ColorDarkTokens;
import androidx.compose.material3.tokens.ColorLightTokens;
import androidx.compose.material3.tokens.ColorSchemeKeyTokens;
import androidx.compose.material3.tokens.PaletteTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.unit.Dp;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b;\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\u001aí\u0003\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u0010\u001f\u001a\u00020\u00032\b\b\u0002\u0010 \u001a\u00020\u00032\b\b\u0002\u0010!\u001a\u00020\u00032\b\b\u0002\u0010\"\u001a\u00020\u00032\b\b\u0002\u0010#\u001a\u00020\u00032\b\b\u0002\u0010$\u001a\u00020\u00032\b\b\u0002\u0010%\u001a\u00020\u00032\b\b\u0002\u0010&\u001a\u00020\u00032\b\b\u0002\u0010'\u001a\u00020\u00032\b\b\u0002\u0010(\u001a\u00020\u00032\b\b\u0002\u0010)\u001a\u00020\u00032\b\b\u0002\u0010*\u001a\u00020\u00032\b\b\u0002\u0010+\u001a\u00020\u00032\b\b\u0002\u0010,\u001a\u00020\u00032\b\b\u0002\u0010-\u001a\u00020\u00032\b\b\u0002\u0010.\u001a\u00020\u00032\b\b\u0002\u0010/\u001a\u00020\u00032\b\b\u0002\u00100\u001a\u00020\u00032\b\b\u0002\u00101\u001a\u00020\u00032\b\b\u0002\u00102\u001a\u00020\u0003¢\u0006\u0004\b3\u00104\u001aí\u0003\u00105\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u0010\u001f\u001a\u00020\u00032\b\b\u0002\u0010 \u001a\u00020\u00032\b\b\u0002\u0010!\u001a\u00020\u00032\b\b\u0002\u0010\"\u001a\u00020\u00032\b\b\u0002\u0010#\u001a\u00020\u00032\b\b\u0002\u0010$\u001a\u00020\u00032\b\b\u0002\u0010%\u001a\u00020\u00032\b\b\u0002\u0010&\u001a\u00020\u00032\b\b\u0002\u0010'\u001a\u00020\u00032\b\b\u0002\u0010(\u001a\u00020\u00032\b\b\u0002\u0010)\u001a\u00020\u00032\b\b\u0002\u0010*\u001a\u00020\u00032\b\b\u0002\u0010+\u001a\u00020\u00032\b\b\u0002\u0010,\u001a\u00020\u00032\b\b\u0002\u0010-\u001a\u00020\u00032\b\b\u0002\u0010.\u001a\u00020\u00032\b\b\u0002\u0010/\u001a\u00020\u00032\b\b\u0002\u00100\u001a\u00020\u00032\b\b\u0002\u00101\u001a\u00020\u00032\b\b\u0002\u00102\u001a\u00020\u0003¢\u0006\u0004\b6\u00104\u001a\u001b\u00107\u001a\u00020\u0003*\u00020\u00012\u0006\u00108\u001a\u00020\u0003H\u0007¢\u0006\u0004\b9\u0010:\u001a\u0017\u00107\u001a\u00020\u00032\u0006\u00108\u001a\u00020\u0003H\u0007¢\u0006\u0004\b;\u0010<\u001a\u001b\u0010=\u001a\u00020\u0003*\u00020\u00012\u0006\u0010>\u001a\u00020?H\u0007¢\u0006\u0004\b@\u0010A\u001a\b\u0010B\u001a\u00020\u0001H\u0000\u001a÷\u0002\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u0010\u001f\u001a\u00020\u00032\b\b\u0002\u0010 \u001a\u00020\u00032\b\b\u0002\u0010!\u001a\u00020\u00032\b\b\u0002\u0010\"\u001a\u00020\u00032\b\b\u0002\u0010#\u001a\u00020\u00032\b\b\u0002\u0010$\u001a\u00020\u00032\b\b\u0002\u0010%\u001a\u00020\u00032\b\b\u0002\u0010&\u001a\u00020\u0003H\u0007¢\u0006\u0004\bC\u0010D\u001a±\u0002\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u0010\u001f\u001a\u00020\u0003H\u0007¢\u0006\u0004\bE\u0010F\u001a÷\u0002\u00105\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u0010\u001f\u001a\u00020\u00032\b\b\u0002\u0010 \u001a\u00020\u00032\b\b\u0002\u0010!\u001a\u00020\u00032\b\b\u0002\u0010\"\u001a\u00020\u00032\b\b\u0002\u0010#\u001a\u00020\u00032\b\b\u0002\u0010$\u001a\u00020\u00032\b\b\u0002\u0010%\u001a\u00020\u00032\b\b\u0002\u0010&\u001a\u00020\u0003H\u0007¢\u0006\u0004\bG\u0010D\u001a±\u0002\u00105\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u0010\u001f\u001a\u00020\u0003H\u0007¢\u0006\u0004\bH\u0010F\u001a\u0019\u0010I\u001a\u00020\u0003*\u00020\u00012\u0006\u0010J\u001a\u00020KH\u0001¢\u0006\u0002\u0010L\u001a#\u0010U\u001a\u00020\u0003*\u00020\u00012\u0006\u00108\u001a\u00020\u00032\u0006\u0010>\u001a\u00020?H\u0001¢\u0006\u0004\bV\u0010W\"\u001a\u0010M\u001a\b\u0012\u0004\u0012\u00020\u00010NX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bO\u0010P\"\u000e\u0010Q\u001a\u00020RX\u0080T¢\u0006\u0002\n\u0000\"\u0018\u0010J\u001a\u00020\u0003*\u00020K8AX\u0080\u0004¢\u0006\u0006\u001a\u0004\bS\u0010T\"\u0017\u0010X\u001a\b\u0012\u0004\u0012\u00020Y0N¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010P¨\u0006["}, d2 = {"lightColorScheme", "Landroidx/compose/material3/ColorScheme;", "primary", "Landroidx/compose/ui/graphics/Color;", "onPrimary", "primaryContainer", "onPrimaryContainer", "inversePrimary", "secondary", "onSecondary", "secondaryContainer", "onSecondaryContainer", "tertiary", "onTertiary", "tertiaryContainer", "onTertiaryContainer", "background", "onBackground", "surface", "onSurface", "surfaceVariant", "onSurfaceVariant", "surfaceTint", "inverseSurface", "inverseOnSurface", "error", LynxVideoManagerLite.EVENT_ON_ERROR, "errorContainer", "onErrorContainer", "outline", "outlineVariant", "scrim", "surfaceBright", "surfaceContainer", "surfaceContainerHigh", "surfaceContainerHighest", "surfaceContainerLow", "surfaceContainerLowest", "surfaceDim", "primaryFixed", "primaryFixedDim", "onPrimaryFixed", "onPrimaryFixedVariant", "secondaryFixed", "secondaryFixedDim", "onSecondaryFixed", "onSecondaryFixedVariant", "tertiaryFixed", "tertiaryFixedDim", "onTertiaryFixed", "onTertiaryFixedVariant", "lightColorScheme-_VG5OTI", "(JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJ)Landroidx/compose/material3/ColorScheme;", "darkColorScheme", "darkColorScheme-_VG5OTI", "contentColorFor", "backgroundColor", "contentColorFor-4WTKRHQ", "(Landroidx/compose/material3/ColorScheme;J)J", "contentColorFor-ek8zF_U", "(JLandroidx/compose/runtime/Composer;I)J", "surfaceColorAtElevation", "elevation", "Landroidx/compose/ui/unit/Dp;", "surfaceColorAtElevation-3ABfNKs", "(Landroidx/compose/material3/ColorScheme;F)J", "expressiveLightColorScheme", "lightColorScheme-C-Xl9yA", "(JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJ)Landroidx/compose/material3/ColorScheme;", "lightColorScheme-G1PFc-w", "(JJJJJJJJJJJJJJJJJJJJJJJJJJJJJ)Landroidx/compose/material3/ColorScheme;", "darkColorScheme-C-Xl9yA", "darkColorScheme-G1PFc-w", "fromToken", "value", "Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "(Landroidx/compose/material3/ColorScheme;Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;)J", "LocalColorScheme", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "getLocalColorScheme", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "DisabledAlpha", "", "getValue", "(Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;Landroidx/compose/runtime/Composer;I)J", "applyTonalElevation", "applyTonalElevation-RFCenO8", "(Landroidx/compose/material3/ColorScheme;JFLandroidx/compose/runtime/Composer;I)J", "LocalTonalElevationEnabled", "", "getLocalTonalElevationEnabled", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ColorSchemeKt {
    public static final float DisabledAlpha = 0.38f;
    private static final ProvidableCompositionLocal<ColorScheme> LocalColorScheme = null;
    private static final ProvidableCompositionLocal<Boolean> LocalTonalElevationEnabled = null;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r100 = new int[ColorSchemeKeyTokens.values().length];
            r100[ColorSchemeKeyTokens.Background.ordinal()] = 1;     // Catch: NoSuchFieldError -> L53
        L131:
            r100[ColorSchemeKeyTokens.Error.ordinal()] = 2;     // Catch: NoSuchFieldError -> L54
        L149:
            r100[ColorSchemeKeyTokens.ErrorContainer.ordinal()] = 3;     // Catch: NoSuchFieldError -> L55
        L161:
            r100[ColorSchemeKeyTokens.InverseOnSurface.ordinal()] = 4;     // Catch: NoSuchFieldError -> L56
        L165:
            r100[ColorSchemeKeyTokens.InversePrimary.ordinal()] = 5;     // Catch: NoSuchFieldError -> L57
        L175:
            r100[ColorSchemeKeyTokens.InverseSurface.ordinal()] = 6;     // Catch: NoSuchFieldError -> L58
        L189:
            r100[ColorSchemeKeyTokens.OnBackground.ordinal()] = 7;     // Catch: NoSuchFieldError -> L59
        L119:
            r100[ColorSchemeKeyTokens.OnError.ordinal()] = 8;     // Catch: NoSuchFieldError -> L60
        L135:
            r100[ColorSchemeKeyTokens.OnErrorContainer.ordinal()] = 9;     // Catch: NoSuchFieldError -> L61
        L139:
            r100[ColorSchemeKeyTokens.OnPrimary.ordinal()] = 10;     // Catch: NoSuchFieldError -> L62
        L155:
            r100[ColorSchemeKeyTokens.OnPrimaryContainer.ordinal()] = 11;     // Catch: NoSuchFieldError -> L63
        L181:
            r100[ColorSchemeKeyTokens.OnSecondary.ordinal()] = 12;     // Catch: NoSuchFieldError -> L64
        L195:
            r100[ColorSchemeKeyTokens.OnSecondaryContainer.ordinal()] = 13;     // Catch: NoSuchFieldError -> L65
        L103:
            r100[ColorSchemeKeyTokens.OnSurface.ordinal()] = 14;     // Catch: NoSuchFieldError -> L66
        L115:
            r100[ColorSchemeKeyTokens.OnSurfaceVariant.ordinal()] = 15;     // Catch: NoSuchFieldError -> L67
        L145:
            r100[ColorSchemeKeyTokens.SurfaceTint.ordinal()] = 16;     // Catch: NoSuchFieldError -> L68
        L159:
            r100[ColorSchemeKeyTokens.OnTertiary.ordinal()] = 17;     // Catch: NoSuchFieldError -> L69
        L163:
            r100[ColorSchemeKeyTokens.OnTertiaryContainer.ordinal()] = 18;     // Catch: NoSuchFieldError -> L70
        L177:
            r100[ColorSchemeKeyTokens.Outline.ordinal()] = 19;     // Catch: NoSuchFieldError -> L71
        L107:
            r100[ColorSchemeKeyTokens.OutlineVariant.ordinal()] = 20;     // Catch: NoSuchFieldError -> L72
        L123:
            r100[ColorSchemeKeyTokens.Primary.ordinal()] = 21;     // Catch: NoSuchFieldError -> L73
        L125:
            r100[ColorSchemeKeyTokens.PrimaryContainer.ordinal()] = 22;     // Catch: NoSuchFieldError -> L74
        L141:
            r100[ColorSchemeKeyTokens.Scrim.ordinal()] = 23;     // Catch: NoSuchFieldError -> L75
        L169:
            r100[ColorSchemeKeyTokens.Secondary.ordinal()] = 24;     // Catch: NoSuchFieldError -> L76
        L183:
            r100[ColorSchemeKeyTokens.SecondaryContainer.ordinal()] = 25;     // Catch: NoSuchFieldError -> L77
        L185:
            r100[ColorSchemeKeyTokens.Surface.ordinal()] = 26;     // Catch: NoSuchFieldError -> L78
        L105:
            r100[ColorSchemeKeyTokens.SurfaceVariant.ordinal()] = 27;     // Catch: NoSuchFieldError -> L79
        L129:
            r100[ColorSchemeKeyTokens.SurfaceBright.ordinal()] = 28;     // Catch: NoSuchFieldError -> L80
        L147:
            r100[ColorSchemeKeyTokens.SurfaceContainer.ordinal()] = 29;     // Catch: NoSuchFieldError -> L81
        L151:
            r100[ColorSchemeKeyTokens.SurfaceContainerHigh.ordinal()] = 30;     // Catch: NoSuchFieldError -> L82
        L167:
            r100[ColorSchemeKeyTokens.SurfaceContainerHighest.ordinal()] = 31;     // Catch: NoSuchFieldError -> L83
        L191:
            r100[ColorSchemeKeyTokens.SurfaceContainerLow.ordinal()] = 32;     // Catch: NoSuchFieldError -> L84
        L109:
            r100[ColorSchemeKeyTokens.SurfaceContainerLowest.ordinal()] = 33;     // Catch: NoSuchFieldError -> L85
        L111:
            r100[ColorSchemeKeyTokens.SurfaceDim.ordinal()] = 34;     // Catch: NoSuchFieldError -> L86
        L127:
            r100[ColorSchemeKeyTokens.Tertiary.ordinal()] = 35;     // Catch: NoSuchFieldError -> L87
        L157:
            r100[ColorSchemeKeyTokens.TertiaryContainer.ordinal()] = 36;     // Catch: NoSuchFieldError -> L88
        L171:
            r100[ColorSchemeKeyTokens.PrimaryFixed.ordinal()] = 37;     // Catch: NoSuchFieldError -> L89
        L173:
            r100[ColorSchemeKeyTokens.PrimaryFixedDim.ordinal()] = 38;     // Catch: NoSuchFieldError -> L90
        L187:
            r100[ColorSchemeKeyTokens.OnPrimaryFixed.ordinal()] = 39;     // Catch: NoSuchFieldError -> L91
        L117:
            r100[ColorSchemeKeyTokens.OnPrimaryFixedVariant.ordinal()] = 40;     // Catch: NoSuchFieldError -> L92
        L133:
            r100[ColorSchemeKeyTokens.SecondaryFixed.ordinal()] = 41;     // Catch: NoSuchFieldError -> L93
        L137:
            r100[ColorSchemeKeyTokens.SecondaryFixedDim.ordinal()] = 42;     // Catch: NoSuchFieldError -> L94
        L153:
            r100[ColorSchemeKeyTokens.OnSecondaryFixed.ordinal()] = 43;     // Catch: NoSuchFieldError -> L95
        L179:
            r100[ColorSchemeKeyTokens.OnSecondaryFixedVariant.ordinal()] = 44;     // Catch: NoSuchFieldError -> L96
        L193:
            r100[ColorSchemeKeyTokens.TertiaryFixed.ordinal()] = 45;     // Catch: NoSuchFieldError -> L97
        L101:
            r100[ColorSchemeKeyTokens.TertiaryFixedDim.ordinal()] = 46;     // Catch: NoSuchFieldError -> L98
        L113:
            r100[ColorSchemeKeyTokens.OnTertiaryFixed.ordinal()] = 47;     // Catch: NoSuchFieldError -> L99
        L143:
            r100[ColorSchemeKeyTokens.OnTertiaryFixedVariant.ordinal()] = 48;     // Catch: NoSuchFieldError -> L100
        L51:
            $EnumSwitchMapping$0 = r100;
        }
    }

    private static final boolean LocalTonalElevationEnabled$lambda$2() {
        return true;
    }

    public static /* synthetic */ boolean a() {
        return LocalTonalElevationEnabled$lambda$2();
    }

    public static /* synthetic */ ColorScheme b() {
        return LocalColorScheme$lambda$1();
    }

    static {
        LocalColorScheme = CompositionLocalKt.staticCompositionLocalOf(new g4());
        LocalTonalElevationEnabled = CompositionLocalKt.staticCompositionLocalOf(new h4());
    }

    private static final ColorScheme LocalColorScheme$lambda$1() {
        return m2054lightColorScheme_VG5OTI$default(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 65535, null);
    }

    public static final ColorScheme expressiveLightColorScheme() {
        PaletteTokens r510 = PaletteTokens.INSTANCE;
        return m2054lightColorScheme_VG5OTI$default(0, 0, 0, r510.m3798getPrimary300d7_KjU(), 0, 0, 0, 0, r510.m3811getSecondary300d7_KjU(), 0, 0, 0, r510.m3824getTertiary300d7_KjU(), 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, r510.m3748getError300d7_KjU(), 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -33558793, 65535, null);
    }

    public static final ProvidableCompositionLocal<ColorScheme> getLocalColorScheme() {
        return LocalColorScheme;
    }

    public static final ProvidableCompositionLocal<Boolean> getLocalTonalElevationEnabled() {
        return LocalTonalElevationEnabled;
    }

    /* JADX INFO: renamed from: contentColorFor-4WTKRHQ, reason: not valid java name */
    public static final long m2041contentColorFor4WTKRHQ(ColorScheme r100, long r101) {
        if (Color.m4828equalsimpl0(r101, r100.m2017getPrimary0d7_KjU()) == false) goto L6;
        return r100.m2001getOnPrimary0d7_KjU();
    L6:
        if (Color.m4828equalsimpl0(r101, r100.m2022getSecondary0d7_KjU()) == false) goto L9;
        return r100.m2005getOnSecondary0d7_KjU();
    L9:
        if (Color.m4828equalsimpl0(r101, r100.m2036getTertiary0d7_KjU()) == false) goto L12;
        return r100.m2011getOnTertiary0d7_KjU();
    L12:
        if (Color.m4828equalsimpl0(r101, r100.m1992getBackground0d7_KjU()) == false) goto L15;
        return r100.m1998getOnBackground0d7_KjU();
    L15:
        if (Color.m4828equalsimpl0(r101, r100.m1993getError0d7_KjU()) == false) goto L18;
        return r100.m1999getOnError0d7_KjU();
    L18:
        if (Color.m4828equalsimpl0(r101, r100.m2018getPrimaryContainer0d7_KjU()) == false) goto L21;
        return r100.m2002getOnPrimaryContainer0d7_KjU();
    L21:
        if (Color.m4828equalsimpl0(r101, r100.m2023getSecondaryContainer0d7_KjU()) == false) goto L24;
        return r100.m2006getOnSecondaryContainer0d7_KjU();
    L24:
        if (Color.m4828equalsimpl0(r101, r100.m2037getTertiaryContainer0d7_KjU()) == false) goto L27;
        return r100.m2012getOnTertiaryContainer0d7_KjU();
    L27:
        if (Color.m4828equalsimpl0(r101, r100.m1994getErrorContainer0d7_KjU()) == false) goto L30;
        return r100.m2000getOnErrorContainer0d7_KjU();
    L30:
        if (Color.m4828equalsimpl0(r101, r100.m1997getInverseSurface0d7_KjU()) == false) goto L33;
        return r100.m1995getInverseOnSurface0d7_KjU();
    L33:
        if (Color.m4828equalsimpl0(r101, r100.m2026getSurface0d7_KjU()) == false) goto L36;
        return r100.m2009getOnSurface0d7_KjU();
    L36:
        if (Color.m4828equalsimpl0(r101, r100.m2035getSurfaceVariant0d7_KjU()) == false) goto L39;
        return r100.m2010getOnSurfaceVariant0d7_KjU();
    L39:
        if (Color.m4828equalsimpl0(r101, r100.m2027getSurfaceBright0d7_KjU()) == false) goto L42;
        return r100.m2009getOnSurface0d7_KjU();
    L42:
        if (Color.m4828equalsimpl0(r101, r100.m2028getSurfaceContainer0d7_KjU()) == false) goto L45;
        return r100.m2009getOnSurface0d7_KjU();
    L45:
        if (Color.m4828equalsimpl0(r101, r100.m2029getSurfaceContainerHigh0d7_KjU()) == false) goto L48;
        return r100.m2009getOnSurface0d7_KjU();
    L48:
        if (Color.m4828equalsimpl0(r101, r100.m2030getSurfaceContainerHighest0d7_KjU()) == false) goto L51;
        return r100.m2009getOnSurface0d7_KjU();
    L51:
        if (Color.m4828equalsimpl0(r101, r100.m2031getSurfaceContainerLow0d7_KjU()) == false) goto L54;
        return r100.m2009getOnSurface0d7_KjU();
    L54:
        if (Color.m4828equalsimpl0(r101, r100.m2032getSurfaceContainerLowest0d7_KjU()) == false) goto L57;
        return r100.m2009getOnSurface0d7_KjU();
    L57:
        if (Color.m4828equalsimpl0(r101, r100.m2033getSurfaceDim0d7_KjU()) == false) goto L60;
        return r100.m2009getOnSurface0d7_KjU();
    L60:
        if (Color.m4828equalsimpl0(r101, r100.m2019getPrimaryFixed0d7_KjU()) == false) goto L63;
        return r100.m2003getOnPrimaryFixed0d7_KjU();
    L63:
        if (Color.m4828equalsimpl0(r101, r100.m2020getPrimaryFixedDim0d7_KjU()) == false) goto L66;
        return r100.m2003getOnPrimaryFixed0d7_KjU();
    L66:
        if (Color.m4828equalsimpl0(r101, r100.m2024getSecondaryFixed0d7_KjU()) == false) goto L69;
        return r100.m2007getOnSecondaryFixed0d7_KjU();
    L69:
        if (Color.m4828equalsimpl0(r101, r100.m2025getSecondaryFixedDim0d7_KjU()) == false) goto L72;
        return r100.m2007getOnSecondaryFixed0d7_KjU();
    L72:
        if (Color.m4828equalsimpl0(r101, r100.m2038getTertiaryFixed0d7_KjU()) == false) goto L75;
        return r100.m2013getOnTertiaryFixed0d7_KjU();
    L75:
        if (Color.m4828equalsimpl0(r101, r100.m2039getTertiaryFixedDim0d7_KjU()) == false) goto L78;
        return r100.m2013getOnTertiaryFixed0d7_KjU();
    L78:
        return Color.Companion.m4863getUnspecified0d7_KjU();
    }

    public static final long fromToken(ColorScheme r100, ColorSchemeKeyTokens r101) {
        switch(WhenMappings.$EnumSwitchMapping$0[r101.ordinal()]) {
            case 1: goto L54;
            case 2: goto L101;
            case 3: goto L100;
            case 4: goto L99;
            case 5: goto L98;
            case 6: goto L97;
            case 7: goto L96;
            case 8: goto L95;
            case 9: goto L94;
            case 10: goto L93;
            case 11: goto L92;
            case 12: goto L91;
            case 13: goto L90;
            case 14: goto L89;
            case 15: goto L88;
            case 16: goto L87;
            case 17: goto L86;
            case 18: goto L85;
            case 19: goto L84;
            case 20: goto L83;
            case 21: goto L82;
            case 22: goto L81;
            case 23: goto L80;
            case 24: goto L79;
            case 25: goto L78;
            case 26: goto L77;
            case 27: goto L76;
            case 28: goto L75;
            case 29: goto L74;
            case 30: goto L73;
            case 31: goto L72;
            case 32: goto L71;
            case 33: goto L70;
            case 34: goto L69;
            case 35: goto L68;
            case 36: goto L67;
            case 37: goto L66;
            case 38: goto L65;
            case 39: goto L64;
            case 40: goto L63;
            case 41: goto L62;
            case 42: goto L61;
            case 43: goto L60;
            case 44: goto L59;
            case 45: goto L58;
            case 46: goto L57;
            case 47: goto L56;
            case 48: goto L55;
            default: goto L5;
        };
    L5:
        throw new NoWhenBranchMatchedException();
    L55:
        return r100.m2014getOnTertiaryFixedVariant0d7_KjU();
    L56:
        return r100.m2013getOnTertiaryFixed0d7_KjU();
    L57:
        return r100.m2039getTertiaryFixedDim0d7_KjU();
    L58:
        return r100.m2038getTertiaryFixed0d7_KjU();
    L59:
        return r100.m2008getOnSecondaryFixedVariant0d7_KjU();
    L60:
        return r100.m2007getOnSecondaryFixed0d7_KjU();
    L61:
        return r100.m2025getSecondaryFixedDim0d7_KjU();
    L62:
        return r100.m2024getSecondaryFixed0d7_KjU();
    L63:
        return r100.m2004getOnPrimaryFixedVariant0d7_KjU();
    L64:
        return r100.m2003getOnPrimaryFixed0d7_KjU();
    L65:
        return r100.m2020getPrimaryFixedDim0d7_KjU();
    L66:
        return r100.m2019getPrimaryFixed0d7_KjU();
    L67:
        return r100.m2037getTertiaryContainer0d7_KjU();
    L68:
        return r100.m2036getTertiary0d7_KjU();
    L69:
        return r100.m2033getSurfaceDim0d7_KjU();
    L70:
        return r100.m2032getSurfaceContainerLowest0d7_KjU();
    L71:
        return r100.m2031getSurfaceContainerLow0d7_KjU();
    L72:
        return r100.m2030getSurfaceContainerHighest0d7_KjU();
    L73:
        return r100.m2029getSurfaceContainerHigh0d7_KjU();
    L74:
        return r100.m2028getSurfaceContainer0d7_KjU();
    L75:
        return r100.m2027getSurfaceBright0d7_KjU();
    L76:
        return r100.m2035getSurfaceVariant0d7_KjU();
    L77:
        return r100.m2026getSurface0d7_KjU();
    L78:
        return r100.m2023getSecondaryContainer0d7_KjU();
    L79:
        return r100.m2022getSecondary0d7_KjU();
    L80:
        return r100.m2021getScrim0d7_KjU();
    L81:
        return r100.m2018getPrimaryContainer0d7_KjU();
    L82:
        return r100.m2017getPrimary0d7_KjU();
    L83:
        return r100.m2016getOutlineVariant0d7_KjU();
    L84:
        return r100.m2015getOutline0d7_KjU();
    L85:
        return r100.m2012getOnTertiaryContainer0d7_KjU();
    L86:
        return r100.m2011getOnTertiary0d7_KjU();
    L87:
        return r100.m2034getSurfaceTint0d7_KjU();
    L88:
        return r100.m2010getOnSurfaceVariant0d7_KjU();
    L89:
        return r100.m2009getOnSurface0d7_KjU();
    L90:
        return r100.m2006getOnSecondaryContainer0d7_KjU();
    L91:
        return r100.m2005getOnSecondary0d7_KjU();
    L92:
        return r100.m2002getOnPrimaryContainer0d7_KjU();
    L93:
        return r100.m2001getOnPrimary0d7_KjU();
    L94:
        return r100.m2000getOnErrorContainer0d7_KjU();
    L95:
        return r100.m1999getOnError0d7_KjU();
    L96:
        return r100.m1998getOnBackground0d7_KjU();
    L97:
        return r100.m1997getInverseSurface0d7_KjU();
    L98:
        return r100.m1996getInversePrimary0d7_KjU();
    L99:
        return r100.m1995getInverseOnSurface0d7_KjU();
    L100:
        return r100.m1994getErrorContainer0d7_KjU();
    L101:
        return r100.m1993getError0d7_KjU();
    L54:
        return r100.m1992getBackground0d7_KjU();
    }

    /* JADX INFO: renamed from: surfaceColorAtElevation-3ABfNKs, reason: not valid java name */
    public static final long m2055surfaceColorAtElevation3ABfNKs(ColorScheme r100, float r110) {
        if (Dp.m7549equalsimpl0(r110, Dp.m7544constructorimpl(0)) == false) goto L7;
        return r100.m2026getSurface0d7_KjU();
    L7:
        return ColorKt.m4872compositeOverOWjLjI(Color.m4826copywmQWz5c$default(r100.m2034getSurfaceTint0d7_KjU(), ((((float) Math.log(r110 + 1)) * 4.5f) + 2.0f) / 100.0f, 0.0f, 0.0f, 0.0f, 14, null), r100.m2026getSurface0d7_KjU());
    }

    /* JADX INFO: renamed from: contentColorFor-ek8zF_U, reason: not valid java name */
    public static final long m2042contentColorForek8zF_U(long r100, Composer r101, int r102) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(509589638, r102, -1, "androidx.compose.material3.contentColorFor (ColorScheme.kt:1112)");
    L5:
        r101.startReplaceGroup(89374938);
        long r103 = m2041contentColorFor4WTKRHQ(MaterialTheme.INSTANCE.getColorScheme(r101, 6), r100);
        if (r103 == 16) goto L8;
        boolean r104 = true;
    L9:
        if (r104 == true) goto L12;
        r103 = ((Color) r101.consume(ContentColorKt.getLocalContentColor())).m4837unboximpl();
    L12:
        r101.endReplaceGroup();
        if (ComposerKt.isTraceInProgress() == false) goto L15;
        ComposerKt.traceEventEnd();
    L15:
        return r103;
    L8:
        r104 = false;
        goto L9
    }

    public static final long getValue(ColorSchemeKeyTokens r100, Composer r101, int r102) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-810780884, r102, -1, "androidx.compose.material3.<get-value> (ColorScheme.kt:1524)");
    L5:
        long r103 = fromToken(MaterialTheme.INSTANCE.getColorScheme(r101, 6), r100);
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r103;
    }

    /* JADX INFO: renamed from: applyTonalElevation-RFCenO8, reason: not valid java name */
    public static final long m2040applyTonalElevationRFCenO8(ColorScheme r100, long r101, float r102, Composer r103, int r104) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-1610977682, r104, -1, "androidx.compose.material3.applyTonalElevation (ColorScheme.kt:1539)");
    L5:
        boolean r105 = ((Boolean) r103.consume(LocalTonalElevationEnabled)).booleanValue();
        if (Color.m4828equalsimpl0(r101, r100.m2026getSurface0d7_KjU()) == false) goto L10;
        if (r105 == false) goto L10;
        r101 = m2055surfaceColorAtElevation3ABfNKs(r100, r102);
    L10:
        if (ComposerKt.isTraceInProgress() == false) goto L12;
        ComposerKt.traceEventEnd();
    L12:
        return r101;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use overload with additional surface roles instead")
    /* JADX INFO: renamed from: darkColorScheme-G1PFc-w, reason: not valid java name */
    public static final /* synthetic */ ColorScheme m2045darkColorSchemeG1PFcw(long r910, long r101, long r103, long r105, long r107, long r109, long r111, long r113, long r115, long r117, long r119, long r121, long r123, long r125, long r127, long r129, long r131, long r133, long r135, long r137, long r139, long r141, long r143, long r145, long r147, long r149, long r151, long r153, long r155) {
        return m2048darkColorScheme_VG5OTI$default(r910, r101, r103, r105, r107, r109, r111, r113, r115, r117, r119, r121, r123, r125, r127, r129, r131, r133, r135, r137, r139, r141, r143, r145, r147, r149, r151, r153, r155, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -536870912, 65535, null);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use overload with additional surface roles instead")
    /* JADX INFO: renamed from: lightColorScheme-G1PFc-w, reason: not valid java name */
    public static final /* synthetic */ ColorScheme m2051lightColorSchemeG1PFcw(long r910, long r101, long r103, long r105, long r107, long r109, long r111, long r113, long r115, long r117, long r119, long r121, long r123, long r125, long r127, long r129, long r131, long r133, long r135, long r137, long r139, long r141, long r143, long r145, long r147, long r149, long r151, long r153, long r155) {
        return m2054lightColorScheme_VG5OTI$default(r910, r101, r103, r105, r107, r109, r111, r113, r115, r117, r119, r121, r123, r125, r127, r129, r131, r133, r135, r137, r139, r141, r143, r145, r147, r149, r151, r153, r155, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -536870912, 65535, null);
    }

    /* JADX INFO: renamed from: darkColorScheme-G1PFc-w$default, reason: not valid java name */
    public static /* synthetic */ ColorScheme m2046darkColorSchemeG1PFcw$default(long r410, long r411, long r412, long r510, long r511, long r512, long r513, long r514, long r610, long r611, long r612, long r613, long r614, long r710, long r711, long r712, long r713, long r714, long r810, long r811, long r812, long r813, long r814, long r910, long r911, long r912, long r913, long r914, long r101, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L5;
        long r100 = ColorDarkTokens.INSTANCE.m3373getPrimary0d7_KjU();
    L7:
        if ((r103 & 2) == 0) goto L9;
        long r102 = ColorDarkTokens.INSTANCE.m3357getOnPrimary0d7_KjU();
    L11:
        if ((r103 & 4) == 0) goto L13;
        long r105 = ColorDarkTokens.INSTANCE.m3374getPrimaryContainer0d7_KjU();
    L15:
        if ((r103 & 8) == 0) goto L17;
        long r106 = ColorDarkTokens.INSTANCE.m3358getOnPrimaryContainer0d7_KjU();
    L19:
        if ((r103 & 16) == 0) goto L21;
        long r107 = ColorDarkTokens.INSTANCE.m3352getInversePrimary0d7_KjU();
    L23:
        if ((r103 & 32) == 0) goto L25;
        long r110 = ColorDarkTokens.INSTANCE.m3378getSecondary0d7_KjU();
    L27:
        if ((r103 & 64) == 0) goto L29;
        long r111 = ColorDarkTokens.INSTANCE.m3361getOnSecondary0d7_KjU();
    L31:
        if ((r103 & 128) == 0) goto L33;
        long r112 = ColorDarkTokens.INSTANCE.m3379getSecondaryContainer0d7_KjU();
    L34:
        long r515 = r112;
        if ((r103 & 256) == 0) goto L37;
        long r113 = ColorDarkTokens.INSTANCE.m3362getOnSecondaryContainer0d7_KjU();
    L38:
        long r615 = r113;
        if ((r103 & 512) == 0) goto L41;
        long r114 = ColorDarkTokens.INSTANCE.m3392getTertiary0d7_KjU();
    L42:
        long r616 = r114;
        if ((r103 & 1024) == 0) goto L45;
        long r115 = ColorDarkTokens.INSTANCE.m3367getOnTertiary0d7_KjU();
    L46:
        long r617 = r115;
        if ((r103 & 2048) == 0) goto L49;
        long r116 = ColorDarkTokens.INSTANCE.m3393getTertiaryContainer0d7_KjU();
    L50:
        long r618 = r116;
        if ((r103 & 4096) == 0) goto L53;
        long r117 = ColorDarkTokens.INSTANCE.m3368getOnTertiaryContainer0d7_KjU();
    L54:
        long r619 = r117;
        if ((r103 & 8192) == 0) goto L57;
        long r118 = ColorDarkTokens.INSTANCE.m3348getBackground0d7_KjU();
    L58:
        long r715 = r118;
        if ((r103 & 16384) == 0) goto L61;
        long r119 = ColorDarkTokens.INSTANCE.m3354getOnBackground0d7_KjU();
    L63:
        if ((r103 & 32768) == 0) goto L65;
        long r120 = ColorDarkTokens.INSTANCE.m3382getSurface0d7_KjU();
    L67:
        if ((r103 & 65536) == 0) goto L69;
        long r121 = ColorDarkTokens.INSTANCE.m3365getOnSurface0d7_KjU();
    L71:
        if ((r103 & 131072) == 0) goto L73;
        long r210 = ColorDarkTokens.INSTANCE.m3391getSurfaceVariant0d7_KjU();
    L75:
        if ((r103 & 262144) == 0) goto L77;
        long r211 = ColorDarkTokens.INSTANCE.m3366getOnSurfaceVariant0d7_KjU();
    L79:
        if ((r103 & 524288) == 0) goto L81;
        long r212 = r100;
    L83:
        if ((r103 & 1048576) == 0) goto L85;
        long r213 = ColorDarkTokens.INSTANCE.m3353getInverseSurface0d7_KjU();
    L87:
        if ((r103 & 2097152) == 0) goto L89;
        long r214 = ColorDarkTokens.INSTANCE.m3351getInverseOnSurface0d7_KjU();
    L91:
        if ((r103 & 4194304) == 0) goto L93;
        long r310 = ColorDarkTokens.INSTANCE.m3349getError0d7_KjU();
    L95:
        if ((r103 & 8388608) == 0) goto L97;
        long r311 = ColorDarkTokens.INSTANCE.m3355getOnError0d7_KjU();
    L99:
        if ((r103 & 16777216) == 0) goto L101;
        long r312 = ColorDarkTokens.INSTANCE.m3350getErrorContainer0d7_KjU();
    L103:
        if ((r103 & 33554432) == 0) goto L105;
        long r313 = ColorDarkTokens.INSTANCE.m3356getOnErrorContainer0d7_KjU();
    L107:
        if ((r103 & 67108864) == 0) goto L109;
        long r314 = ColorDarkTokens.INSTANCE.m3371getOutline0d7_KjU();
    L111:
        if ((r103 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L113;
        long r413 = ColorDarkTokens.INSTANCE.m3372getOutlineVariant0d7_KjU();
    L115:
        if ((r103 & 268435456) == 0) goto L117;
        long r414 = ColorDarkTokens.INSTANCE.m3377getScrim0d7_KjU();
    L119:
        return m2045darkColorSchemeG1PFcw(r100, r102, r105, r106, r107, r110, r111, r515, r615, r616, r617, r618, r619, r715, r119, r120, r121, r210, r211, r212, r213, r214, r310, r311, r312, r313, r314, r413, r414);
    L117:
        r414 = r101;
        goto L119
    L113:
        r413 = r914;
        goto L115
    L109:
        r314 = r913;
        goto L111
    L105:
        r313 = r912;
        goto L107
    L101:
        r312 = r911;
        goto L103
    L97:
        r311 = r910;
        goto L99
    L93:
        r310 = r814;
        goto L95
    L89:
        r214 = r813;
        goto L91
    L85:
        r213 = r812;
        goto L87
    L81:
        r212 = r811;
        goto L83
    L77:
        r211 = r810;
        goto L79
    L73:
        r210 = r714;
        goto L75
    L69:
        r121 = r713;
        goto L71
    L65:
        r120 = r712;
        goto L67
    L61:
        r119 = r711;
        goto L63
    L57:
        r118 = r710;
        goto L58
    L53:
        r117 = r614;
        goto L54
    L49:
        r116 = r613;
        goto L50
    L45:
        r115 = r612;
        goto L46
    L41:
        r114 = r611;
        goto L42
    L37:
        r113 = r610;
        goto L38
    L33:
        r112 = r514;
        goto L34
    L29:
        r111 = r513;
        goto L31
    L25:
        r110 = r512;
        goto L27
    L21:
        r107 = r511;
        goto L23
    L17:
        r106 = r510;
        goto L19
    L13:
        r105 = r412;
        goto L15
    L9:
        r102 = r411;
        goto L11
    L5:
        r100 = r410;
        goto L7
    }

    /* JADX INFO: renamed from: lightColorScheme-G1PFc-w$default, reason: not valid java name */
    public static /* synthetic */ ColorScheme m2052lightColorSchemeG1PFcw$default(long r410, long r411, long r412, long r510, long r511, long r512, long r513, long r514, long r610, long r611, long r612, long r613, long r614, long r710, long r711, long r712, long r713, long r714, long r810, long r811, long r812, long r813, long r814, long r910, long r911, long r912, long r913, long r914, long r101, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L5;
        long r100 = ColorLightTokens.INSTANCE.m3421getPrimary0d7_KjU();
    L7:
        if ((r103 & 2) == 0) goto L9;
        long r102 = ColorLightTokens.INSTANCE.m3405getOnPrimary0d7_KjU();
    L11:
        if ((r103 & 4) == 0) goto L13;
        long r105 = ColorLightTokens.INSTANCE.m3422getPrimaryContainer0d7_KjU();
    L15:
        if ((r103 & 8) == 0) goto L17;
        long r106 = ColorLightTokens.INSTANCE.m3406getOnPrimaryContainer0d7_KjU();
    L19:
        if ((r103 & 16) == 0) goto L21;
        long r107 = ColorLightTokens.INSTANCE.m3400getInversePrimary0d7_KjU();
    L23:
        if ((r103 & 32) == 0) goto L25;
        long r110 = ColorLightTokens.INSTANCE.m3426getSecondary0d7_KjU();
    L27:
        if ((r103 & 64) == 0) goto L29;
        long r111 = ColorLightTokens.INSTANCE.m3409getOnSecondary0d7_KjU();
    L31:
        if ((r103 & 128) == 0) goto L33;
        long r112 = ColorLightTokens.INSTANCE.m3427getSecondaryContainer0d7_KjU();
    L34:
        long r515 = r112;
        if ((r103 & 256) == 0) goto L37;
        long r113 = ColorLightTokens.INSTANCE.m3410getOnSecondaryContainer0d7_KjU();
    L38:
        long r615 = r113;
        if ((r103 & 512) == 0) goto L41;
        long r114 = ColorLightTokens.INSTANCE.m3440getTertiary0d7_KjU();
    L42:
        long r616 = r114;
        if ((r103 & 1024) == 0) goto L45;
        long r115 = ColorLightTokens.INSTANCE.m3415getOnTertiary0d7_KjU();
    L46:
        long r617 = r115;
        if ((r103 & 2048) == 0) goto L49;
        long r116 = ColorLightTokens.INSTANCE.m3441getTertiaryContainer0d7_KjU();
    L50:
        long r618 = r116;
        if ((r103 & 4096) == 0) goto L53;
        long r117 = ColorLightTokens.INSTANCE.m3416getOnTertiaryContainer0d7_KjU();
    L54:
        long r619 = r117;
        if ((r103 & 8192) == 0) goto L57;
        long r118 = ColorLightTokens.INSTANCE.m3396getBackground0d7_KjU();
    L58:
        long r715 = r118;
        if ((r103 & 16384) == 0) goto L61;
        long r119 = ColorLightTokens.INSTANCE.m3402getOnBackground0d7_KjU();
    L63:
        if ((r103 & 32768) == 0) goto L65;
        long r120 = ColorLightTokens.INSTANCE.m3430getSurface0d7_KjU();
    L67:
        if ((r103 & 65536) == 0) goto L69;
        long r121 = ColorLightTokens.INSTANCE.m3413getOnSurface0d7_KjU();
    L71:
        if ((r103 & 131072) == 0) goto L73;
        long r210 = ColorLightTokens.INSTANCE.m3439getSurfaceVariant0d7_KjU();
    L75:
        if ((r103 & 262144) == 0) goto L77;
        long r211 = ColorLightTokens.INSTANCE.m3414getOnSurfaceVariant0d7_KjU();
    L79:
        if ((r103 & 524288) == 0) goto L81;
        long r212 = r100;
    L83:
        if ((r103 & 1048576) == 0) goto L85;
        long r213 = ColorLightTokens.INSTANCE.m3401getInverseSurface0d7_KjU();
    L87:
        if ((r103 & 2097152) == 0) goto L89;
        long r214 = ColorLightTokens.INSTANCE.m3399getInverseOnSurface0d7_KjU();
    L91:
        if ((r103 & 4194304) == 0) goto L93;
        long r310 = ColorLightTokens.INSTANCE.m3397getError0d7_KjU();
    L95:
        if ((r103 & 8388608) == 0) goto L97;
        long r311 = ColorLightTokens.INSTANCE.m3403getOnError0d7_KjU();
    L99:
        if ((r103 & 16777216) == 0) goto L101;
        long r312 = ColorLightTokens.INSTANCE.m3398getErrorContainer0d7_KjU();
    L103:
        if ((r103 & 33554432) == 0) goto L105;
        long r313 = ColorLightTokens.INSTANCE.m3404getOnErrorContainer0d7_KjU();
    L107:
        if ((r103 & 67108864) == 0) goto L109;
        long r314 = ColorLightTokens.INSTANCE.m3419getOutline0d7_KjU();
    L111:
        if ((r103 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L113;
        long r413 = ColorLightTokens.INSTANCE.m3420getOutlineVariant0d7_KjU();
    L115:
        if ((r103 & 268435456) == 0) goto L117;
        long r414 = ColorLightTokens.INSTANCE.m3425getScrim0d7_KjU();
    L119:
        return m2051lightColorSchemeG1PFcw(r100, r102, r105, r106, r107, r110, r111, r515, r615, r616, r617, r618, r619, r715, r119, r120, r121, r210, r211, r212, r213, r214, r310, r311, r312, r313, r314, r413, r414);
    L117:
        r414 = r101;
        goto L119
    L113:
        r413 = r914;
        goto L115
    L109:
        r314 = r913;
        goto L111
    L105:
        r313 = r912;
        goto L107
    L101:
        r312 = r911;
        goto L103
    L97:
        r311 = r910;
        goto L99
    L93:
        r310 = r814;
        goto L95
    L89:
        r214 = r813;
        goto L91
    L85:
        r213 = r812;
        goto L87
    L81:
        r212 = r811;
        goto L83
    L77:
        r211 = r810;
        goto L79
    L73:
        r210 = r714;
        goto L75
    L69:
        r121 = r713;
        goto L71
    L65:
        r120 = r712;
        goto L67
    L61:
        r119 = r711;
        goto L63
    L57:
        r118 = r710;
        goto L58
    L53:
        r117 = r614;
        goto L54
    L49:
        r116 = r613;
        goto L50
    L45:
        r115 = r612;
        goto L46
    L41:
        r114 = r611;
        goto L42
    L37:
        r113 = r610;
        goto L38
    L33:
        r112 = r514;
        goto L34
    L29:
        r111 = r513;
        goto L31
    L25:
        r110 = r512;
        goto L27
    L21:
        r107 = r511;
        goto L23
    L17:
        r106 = r510;
        goto L19
    L13:
        r105 = r412;
        goto L15
    L9:
        r102 = r411;
        goto L11
    L5:
        r100 = r410;
        goto L7
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use overload with additional surface roles instead")
    /* JADX INFO: renamed from: darkColorScheme-C-Xl9yA, reason: not valid java name */
    public static final /* synthetic */ ColorScheme m2043darkColorSchemeCXl9yA(long r910, long r101, long r103, long r105, long r107, long r109, long r111, long r113, long r115, long r117, long r119, long r121, long r123, long r125, long r127, long r129, long r131, long r133, long r135, long r137, long r139, long r141, long r143, long r145, long r147, long r149, long r151, long r153, long r155, long r157, long r159, long r161, long r163, long r165, long r167, long r169) {
        return m2048darkColorScheme_VG5OTI$default(r910, r101, r103, r105, r107, r109, r111, r113, r115, r117, r119, r121, r123, r125, r127, r129, r131, r133, r135, r137, r139, r141, r143, r145, r147, r149, r151, r153, r155, r157, r159, r161, r163, r165, r167, r169, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 65520, null);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use overload with additional Fixed roles instead")
    /* JADX INFO: renamed from: lightColorScheme-C-Xl9yA, reason: not valid java name */
    public static final /* synthetic */ ColorScheme m2049lightColorSchemeCXl9yA(long r910, long r101, long r103, long r105, long r107, long r109, long r111, long r113, long r115, long r117, long r119, long r121, long r123, long r125, long r127, long r129, long r131, long r133, long r135, long r137, long r139, long r141, long r143, long r145, long r147, long r149, long r151, long r153, long r155, long r157, long r159, long r161, long r163, long r165, long r167, long r169) {
        return m2054lightColorScheme_VG5OTI$default(r910, r101, r103, r105, r107, r109, r111, r113, r115, r117, r119, r121, r123, r125, r127, r129, r131, r133, r135, r137, r139, r141, r143, r145, r147, r149, r151, r153, r155, r157, r159, r161, r163, r165, r167, r169, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 65520, null);
    }

    /* JADX INFO: renamed from: darkColorScheme-C-Xl9yA$default, reason: not valid java name */
    public static /* synthetic */ ColorScheme m2044darkColorSchemeCXl9yA$default(long r510, long r610, long r611, long r612, long r613, long r614, long r710, long r711, long r712, long r713, long r714, long r810, long r811, long r812, long r813, long r814, long r910, long r911, long r912, long r913, long r914, long r101, long r103, long r105, long r107, long r109, long r111, long r113, long r115, long r117, long r119, long r121, long r123, long r125, long r127, long r129, int r131, int r132, Object r133) {
        if ((r131 & 1) == 0) goto L5;
        long r100 = ColorDarkTokens.INSTANCE.m3373getPrimary0d7_KjU();
    L7:
        if ((r131 & 2) == 0) goto L9;
        long r102 = ColorDarkTokens.INSTANCE.m3357getOnPrimary0d7_KjU();
    L11:
        if ((r131 & 4) == 0) goto L13;
        long r104 = ColorDarkTokens.INSTANCE.m3374getPrimaryContainer0d7_KjU();
    L15:
        if ((r131 & 8) == 0) goto L17;
        long r106 = ColorDarkTokens.INSTANCE.m3358getOnPrimaryContainer0d7_KjU();
    L19:
        if ((r131 & 16) == 0) goto L21;
        long r108 = ColorDarkTokens.INSTANCE.m3352getInversePrimary0d7_KjU();
    L23:
        if ((r131 & 32) == 0) goto L25;
        long r110 = ColorDarkTokens.INSTANCE.m3378getSecondary0d7_KjU();
    L27:
        if ((r131 & 64) == 0) goto L29;
        long r112 = ColorDarkTokens.INSTANCE.m3361getOnSecondary0d7_KjU();
    L31:
        if ((r131 & 128) == 0) goto L33;
        long r114 = ColorDarkTokens.INSTANCE.m3379getSecondaryContainer0d7_KjU();
    L34:
        long r715 = r114;
        if ((r131 & 256) == 0) goto L37;
        long r116 = ColorDarkTokens.INSTANCE.m3362getOnSecondaryContainer0d7_KjU();
    L38:
        long r716 = r116;
        if ((r131 & 512) == 0) goto L41;
        long r118 = ColorDarkTokens.INSTANCE.m3392getTertiary0d7_KjU();
    L42:
        long r717 = r118;
        if ((r131 & 1024) == 0) goto L45;
        long r120 = ColorDarkTokens.INSTANCE.m3367getOnTertiary0d7_KjU();
    L46:
        long r718 = r120;
        if ((r131 & 2048) == 0) goto L49;
        long r122 = ColorDarkTokens.INSTANCE.m3393getTertiaryContainer0d7_KjU();
    L50:
        long r815 = r122;
        if ((r131 & 4096) == 0) goto L53;
        long r124 = ColorDarkTokens.INSTANCE.m3368getOnTertiaryContainer0d7_KjU();
    L54:
        long r816 = r124;
        if ((r131 & 8192) == 0) goto L57;
        long r126 = ColorDarkTokens.INSTANCE.m3348getBackground0d7_KjU();
    L58:
        long r817 = r126;
        if ((r131 & 16384) == 0) goto L61;
        long r128 = ColorDarkTokens.INSTANCE.m3354getOnBackground0d7_KjU();
    L63:
        if ((r131 & 32768) == 0) goto L65;
        long r130 = ColorDarkTokens.INSTANCE.m3382getSurface0d7_KjU();
    L67:
        if ((r131 & 65536) == 0) goto L69;
        long r134 = ColorDarkTokens.INSTANCE.m3365getOnSurface0d7_KjU();
    L71:
        if ((r131 & 131072) == 0) goto L73;
        long r210 = ColorDarkTokens.INSTANCE.m3391getSurfaceVariant0d7_KjU();
    L75:
        if ((r131 & 262144) == 0) goto L77;
        long r211 = ColorDarkTokens.INSTANCE.m3366getOnSurfaceVariant0d7_KjU();
    L79:
        if ((r131 & 524288) == 0) goto L81;
        long r212 = r100;
    L83:
        if ((r131 & 1048576) == 0) goto L85;
        long r213 = ColorDarkTokens.INSTANCE.m3353getInverseSurface0d7_KjU();
    L87:
        if ((r131 & 2097152) == 0) goto L89;
        long r214 = ColorDarkTokens.INSTANCE.m3351getInverseOnSurface0d7_KjU();
    L91:
        if ((r131 & 4194304) == 0) goto L93;
        long r310 = ColorDarkTokens.INSTANCE.m3349getError0d7_KjU();
    L95:
        if ((r131 & 8388608) == 0) goto L97;
        long r311 = ColorDarkTokens.INSTANCE.m3355getOnError0d7_KjU();
    L99:
        if ((r131 & 16777216) == 0) goto L101;
        long r312 = ColorDarkTokens.INSTANCE.m3350getErrorContainer0d7_KjU();
    L103:
        if ((r131 & 33554432) == 0) goto L105;
        long r313 = ColorDarkTokens.INSTANCE.m3356getOnErrorContainer0d7_KjU();
    L107:
        if ((r131 & 67108864) == 0) goto L109;
        long r314 = ColorDarkTokens.INSTANCE.m3371getOutline0d7_KjU();
    L111:
        if ((r131 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L113;
        long r410 = ColorDarkTokens.INSTANCE.m3372getOutlineVariant0d7_KjU();
    L115:
        if ((r131 & 268435456) == 0) goto L117;
        long r411 = ColorDarkTokens.INSTANCE.m3377getScrim0d7_KjU();
    L119:
        if ((r131 & 536870912) == 0) goto L121;
        long r412 = ColorDarkTokens.INSTANCE.m3383getSurfaceBright0d7_KjU();
    L123:
        if ((r131 & 1073741824) == 0) goto L125;
        long r413 = ColorDarkTokens.INSTANCE.m3384getSurfaceContainer0d7_KjU();
    L127:
        if ((r131 & Integer.MIN_VALUE) == 0) goto L129;
        long r414 = ColorDarkTokens.INSTANCE.m3385getSurfaceContainerHigh0d7_KjU();
    L131:
        if ((r132 & 1) == 0) goto L133;
        long r511 = ColorDarkTokens.INSTANCE.m3386getSurfaceContainerHighest0d7_KjU();
    L135:
        if ((r132 & 2) == 0) goto L137;
        long r512 = ColorDarkTokens.INSTANCE.m3387getSurfaceContainerLow0d7_KjU();
    L139:
        if ((r132 & 4) == 0) goto L141;
        long r513 = ColorDarkTokens.INSTANCE.m3388getSurfaceContainerLowest0d7_KjU();
    L143:
        if ((r132 & 8) == 0) goto L145;
        long r514 = ColorDarkTokens.INSTANCE.m3389getSurfaceDim0d7_KjU();
    L147:
        return m2043darkColorSchemeCXl9yA(r100, r102, r104, r106, r108, r110, r112, r715, r716, r717, r718, r815, r816, r817, r128, r130, r134, r210, r211, r212, r213, r214, r310, r311, r312, r313, r314, r410, r411, r412, r413, r414, r511, r512, r513, r514);
    L145:
        r514 = r129;
        goto L147
    L141:
        r513 = r127;
        goto L143
    L137:
        r512 = r125;
        goto L139
    L133:
        r511 = r123;
        goto L135
    L129:
        r414 = r121;
        goto L131
    L125:
        r413 = r119;
        goto L127
    L121:
        r412 = r117;
        goto L123
    L117:
        r411 = r115;
        goto L119
    L113:
        r410 = r113;
        goto L115
    L109:
        r314 = r111;
        goto L111
    L105:
        r313 = r109;
        goto L107
    L101:
        r312 = r107;
        goto L103
    L97:
        r311 = r105;
        goto L99
    L93:
        r310 = r103;
        goto L95
    L89:
        r214 = r101;
        goto L91
    L85:
        r213 = r914;
        goto L87
    L81:
        r212 = r913;
        goto L83
    L77:
        r211 = r912;
        goto L79
    L73:
        r210 = r911;
        goto L75
    L69:
        r134 = r910;
        goto L71
    L65:
        r130 = r814;
        goto L67
    L61:
        r128 = r813;
        goto L63
    L57:
        r126 = r812;
        goto L58
    L53:
        r124 = r811;
        goto L54
    L49:
        r122 = r810;
        goto L50
    L45:
        r120 = r714;
        goto L46
    L41:
        r118 = r713;
        goto L42
    L37:
        r116 = r712;
        goto L38
    L33:
        r114 = r711;
        goto L34
    L29:
        r112 = r710;
        goto L31
    L25:
        r110 = r614;
        goto L27
    L21:
        r108 = r613;
        goto L23
    L17:
        r106 = r612;
        goto L19
    L13:
        r104 = r611;
        goto L15
    L9:
        r102 = r610;
        goto L11
    L5:
        r100 = r510;
        goto L7
    }

    /* JADX INFO: renamed from: lightColorScheme-C-Xl9yA$default, reason: not valid java name */
    public static /* synthetic */ ColorScheme m2050lightColorSchemeCXl9yA$default(long r510, long r610, long r611, long r612, long r613, long r614, long r710, long r711, long r712, long r713, long r714, long r810, long r811, long r812, long r813, long r814, long r910, long r911, long r912, long r913, long r914, long r101, long r103, long r105, long r107, long r109, long r111, long r113, long r115, long r117, long r119, long r121, long r123, long r125, long r127, long r129, int r131, int r132, Object r133) {
        if ((r131 & 1) == 0) goto L5;
        long r100 = ColorLightTokens.INSTANCE.m3421getPrimary0d7_KjU();
    L7:
        if ((r131 & 2) == 0) goto L9;
        long r102 = ColorLightTokens.INSTANCE.m3405getOnPrimary0d7_KjU();
    L11:
        if ((r131 & 4) == 0) goto L13;
        long r104 = ColorLightTokens.INSTANCE.m3422getPrimaryContainer0d7_KjU();
    L15:
        if ((r131 & 8) == 0) goto L17;
        long r106 = ColorLightTokens.INSTANCE.m3406getOnPrimaryContainer0d7_KjU();
    L19:
        if ((r131 & 16) == 0) goto L21;
        long r108 = ColorLightTokens.INSTANCE.m3400getInversePrimary0d7_KjU();
    L23:
        if ((r131 & 32) == 0) goto L25;
        long r110 = ColorLightTokens.INSTANCE.m3426getSecondary0d7_KjU();
    L27:
        if ((r131 & 64) == 0) goto L29;
        long r112 = ColorLightTokens.INSTANCE.m3409getOnSecondary0d7_KjU();
    L31:
        if ((r131 & 128) == 0) goto L33;
        long r114 = ColorLightTokens.INSTANCE.m3427getSecondaryContainer0d7_KjU();
    L34:
        long r715 = r114;
        if ((r131 & 256) == 0) goto L37;
        long r116 = ColorLightTokens.INSTANCE.m3410getOnSecondaryContainer0d7_KjU();
    L38:
        long r716 = r116;
        if ((r131 & 512) == 0) goto L41;
        long r118 = ColorLightTokens.INSTANCE.m3440getTertiary0d7_KjU();
    L42:
        long r717 = r118;
        if ((r131 & 1024) == 0) goto L45;
        long r120 = ColorLightTokens.INSTANCE.m3415getOnTertiary0d7_KjU();
    L46:
        long r718 = r120;
        if ((r131 & 2048) == 0) goto L49;
        long r122 = ColorLightTokens.INSTANCE.m3441getTertiaryContainer0d7_KjU();
    L50:
        long r815 = r122;
        if ((r131 & 4096) == 0) goto L53;
        long r124 = ColorLightTokens.INSTANCE.m3416getOnTertiaryContainer0d7_KjU();
    L54:
        long r816 = r124;
        if ((r131 & 8192) == 0) goto L57;
        long r126 = ColorLightTokens.INSTANCE.m3396getBackground0d7_KjU();
    L58:
        long r817 = r126;
        if ((r131 & 16384) == 0) goto L61;
        long r128 = ColorLightTokens.INSTANCE.m3402getOnBackground0d7_KjU();
    L63:
        if ((r131 & 32768) == 0) goto L65;
        long r130 = ColorLightTokens.INSTANCE.m3430getSurface0d7_KjU();
    L67:
        if ((r131 & 65536) == 0) goto L69;
        long r134 = ColorLightTokens.INSTANCE.m3413getOnSurface0d7_KjU();
    L71:
        if ((r131 & 131072) == 0) goto L73;
        long r210 = ColorLightTokens.INSTANCE.m3439getSurfaceVariant0d7_KjU();
    L75:
        if ((r131 & 262144) == 0) goto L77;
        long r211 = ColorLightTokens.INSTANCE.m3414getOnSurfaceVariant0d7_KjU();
    L79:
        if ((r131 & 524288) == 0) goto L81;
        long r212 = r100;
    L83:
        if ((r131 & 1048576) == 0) goto L85;
        long r213 = ColorLightTokens.INSTANCE.m3401getInverseSurface0d7_KjU();
    L87:
        if ((r131 & 2097152) == 0) goto L89;
        long r214 = ColorLightTokens.INSTANCE.m3399getInverseOnSurface0d7_KjU();
    L91:
        if ((r131 & 4194304) == 0) goto L93;
        long r310 = ColorLightTokens.INSTANCE.m3397getError0d7_KjU();
    L95:
        if ((r131 & 8388608) == 0) goto L97;
        long r311 = ColorLightTokens.INSTANCE.m3403getOnError0d7_KjU();
    L99:
        if ((r131 & 16777216) == 0) goto L101;
        long r312 = ColorLightTokens.INSTANCE.m3398getErrorContainer0d7_KjU();
    L103:
        if ((r131 & 33554432) == 0) goto L105;
        long r313 = ColorLightTokens.INSTANCE.m3404getOnErrorContainer0d7_KjU();
    L107:
        if ((r131 & 67108864) == 0) goto L109;
        long r314 = ColorLightTokens.INSTANCE.m3419getOutline0d7_KjU();
    L111:
        if ((r131 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L113;
        long r410 = ColorLightTokens.INSTANCE.m3420getOutlineVariant0d7_KjU();
    L115:
        if ((r131 & 268435456) == 0) goto L117;
        long r411 = ColorLightTokens.INSTANCE.m3425getScrim0d7_KjU();
    L119:
        if ((r131 & 536870912) == 0) goto L121;
        long r412 = ColorLightTokens.INSTANCE.m3431getSurfaceBright0d7_KjU();
    L123:
        if ((r131 & 1073741824) == 0) goto L125;
        long r413 = ColorLightTokens.INSTANCE.m3432getSurfaceContainer0d7_KjU();
    L127:
        if ((r131 & Integer.MIN_VALUE) == 0) goto L129;
        long r414 = ColorLightTokens.INSTANCE.m3433getSurfaceContainerHigh0d7_KjU();
    L131:
        if ((r132 & 1) == 0) goto L133;
        long r511 = ColorLightTokens.INSTANCE.m3434getSurfaceContainerHighest0d7_KjU();
    L135:
        if ((r132 & 2) == 0) goto L137;
        long r512 = ColorLightTokens.INSTANCE.m3435getSurfaceContainerLow0d7_KjU();
    L139:
        if ((r132 & 4) == 0) goto L141;
        long r513 = ColorLightTokens.INSTANCE.m3436getSurfaceContainerLowest0d7_KjU();
    L143:
        if ((r132 & 8) == 0) goto L145;
        long r514 = ColorLightTokens.INSTANCE.m3437getSurfaceDim0d7_KjU();
    L147:
        return m2049lightColorSchemeCXl9yA(r100, r102, r104, r106, r108, r110, r112, r715, r716, r717, r718, r815, r816, r817, r128, r130, r134, r210, r211, r212, r213, r214, r310, r311, r312, r313, r314, r410, r411, r412, r413, r414, r511, r512, r513, r514);
    L145:
        r514 = r129;
        goto L147
    L141:
        r513 = r127;
        goto L143
    L137:
        r512 = r125;
        goto L139
    L133:
        r511 = r123;
        goto L135
    L129:
        r414 = r121;
        goto L131
    L125:
        r413 = r119;
        goto L127
    L121:
        r412 = r117;
        goto L123
    L117:
        r411 = r115;
        goto L119
    L113:
        r410 = r113;
        goto L115
    L109:
        r314 = r111;
        goto L111
    L105:
        r313 = r109;
        goto L107
    L101:
        r312 = r107;
        goto L103
    L97:
        r311 = r105;
        goto L99
    L93:
        r310 = r103;
        goto L95
    L89:
        r214 = r101;
        goto L91
    L85:
        r213 = r914;
        goto L87
    L81:
        r212 = r913;
        goto L83
    L77:
        r211 = r912;
        goto L79
    L73:
        r210 = r911;
        goto L75
    L69:
        r134 = r910;
        goto L71
    L65:
        r130 = r814;
        goto L67
    L61:
        r128 = r813;
        goto L63
    L57:
        r126 = r812;
        goto L58
    L53:
        r124 = r811;
        goto L54
    L49:
        r122 = r810;
        goto L50
    L45:
        r120 = r714;
        goto L46
    L41:
        r118 = r713;
        goto L42
    L37:
        r116 = r712;
        goto L38
    L33:
        r114 = r711;
        goto L34
    L29:
        r112 = r710;
        goto L31
    L25:
        r110 = r614;
        goto L27
    L21:
        r108 = r613;
        goto L23
    L17:
        r106 = r612;
        goto L19
    L13:
        r104 = r611;
        goto L15
    L9:
        r102 = r610;
        goto L11
    L5:
        r100 = r510;
        goto L7
    }

    /* JADX INFO: renamed from: darkColorScheme-_VG5OTI, reason: not valid java name */
    public static final ColorScheme m2047darkColorScheme_VG5OTI(long r910, long r101, long r103, long r105, long r107, long r109, long r111, long r113, long r115, long r117, long r119, long r121, long r123, long r125, long r127, long r129, long r131, long r133, long r135, long r137, long r139, long r141, long r143, long r145, long r147, long r149, long r151, long r153, long r155, long r157, long r159, long r161, long r163, long r165, long r167, long r169, long r171, long r173, long r175, long r177, long r179, long r181, long r183, long r185, long r187, long r189, long r191, long r193) {
        return new ColorScheme(r910, r101, r103, r105, r107, r109, r111, r113, r115, r117, r119, r121, r123, r125, r127, r129, r131, r133, r135, r137, r139, r141, r143, r145, r147, r149, r151, r153, r155, r157, r169, r159, r161, r163, r165, r167, r171, r173, r175, r177, r179, r181, r183, r185, r187, r189, r191, r193, null);
    }

    /* JADX INFO: renamed from: lightColorScheme-_VG5OTI, reason: not valid java name */
    public static final ColorScheme m2053lightColorScheme_VG5OTI(long r910, long r101, long r103, long r105, long r107, long r109, long r111, long r113, long r115, long r117, long r119, long r121, long r123, long r125, long r127, long r129, long r131, long r133, long r135, long r137, long r139, long r141, long r143, long r145, long r147, long r149, long r151, long r153, long r155, long r157, long r159, long r161, long r163, long r165, long r167, long r169, long r171, long r173, long r175, long r177, long r179, long r181, long r183, long r185, long r187, long r189, long r191, long r193) {
        return new ColorScheme(r910, r101, r103, r105, r107, r109, r111, r113, r115, r117, r119, r121, r123, r125, r127, r129, r131, r133, r135, r137, r139, r141, r143, r145, r147, r149, r151, r153, r155, r157, r169, r159, r161, r163, r165, r167, r171, r173, r175, r177, r179, r181, r183, r185, r187, r189, r191, r193, null);
    }

    /* JADX INFO: renamed from: darkColorScheme-_VG5OTI$default, reason: not valid java name */
    public static /* synthetic */ ColorScheme m2048darkColorScheme_VG5OTI$default(long r810, long r811, long r812, long r813, long r814, long r910, long r911, long r912, long r913, long r914, long r101, long r103, long r105, long r107, long r109, long r111, long r113, long r115, long r117, long r119, long r121, long r123, long r125, long r127, long r129, long r131, long r133, long r135, long r137, long r139, long r141, long r143, long r145, long r147, long r149, long r151, long r153, long r155, long r157, long r159, long r161, long r163, long r165, long r167, long r169, long r171, long r173, long r175, int r177, int r178, Object r179) {
        if ((r177 & 1) == 0) goto L5;
        long r100 = ColorDarkTokens.INSTANCE.m3373getPrimary0d7_KjU();
    L7:
        if ((r177 & 2) == 0) goto L9;
        long r102 = ColorDarkTokens.INSTANCE.m3357getOnPrimary0d7_KjU();
    L11:
        if ((r177 & 4) == 0) goto L13;
        long r104 = ColorDarkTokens.INSTANCE.m3374getPrimaryContainer0d7_KjU();
    L15:
        if ((r177 & 8) == 0) goto L17;
        long r106 = ColorDarkTokens.INSTANCE.m3358getOnPrimaryContainer0d7_KjU();
    L19:
        if ((r177 & 16) == 0) goto L21;
        long r110 = ColorDarkTokens.INSTANCE.m3352getInversePrimary0d7_KjU();
    L23:
        if ((r177 & 32) == 0) goto L25;
        long r112 = ColorDarkTokens.INSTANCE.m3378getSecondary0d7_KjU();
    L27:
        if ((r177 & 64) == 0) goto L29;
        long r114 = ColorDarkTokens.INSTANCE.m3361getOnSecondary0d7_KjU();
    L30:
        long r915 = r114;
        if ((r177 & 128) == 0) goto L33;
        long r116 = ColorDarkTokens.INSTANCE.m3379getSecondaryContainer0d7_KjU();
    L34:
        long r916 = r116;
        if ((r177 & 256) == 0) goto L37;
        long r118 = ColorDarkTokens.INSTANCE.m3362getOnSecondaryContainer0d7_KjU();
    L38:
        long r917 = r118;
        if ((r177 & 512) == 0) goto L41;
        long r120 = ColorDarkTokens.INSTANCE.m3392getTertiary0d7_KjU();
    L42:
        long r918 = r120;
        if ((r177 & 1024) == 0) goto L45;
        long r122 = ColorDarkTokens.INSTANCE.m3367getOnTertiary0d7_KjU();
    L46:
        long r108 = r122;
        if ((r177 & 2048) == 0) goto L49;
        long r124 = ColorDarkTokens.INSTANCE.m3393getTertiaryContainer0d7_KjU();
    L50:
        long r1010 = r124;
        if ((r177 & 4096) == 0) goto L53;
        long r126 = ColorDarkTokens.INSTANCE.m3368getOnTertiaryContainer0d7_KjU();
    L54:
        long r1011 = r126;
        if ((r177 & 8192) == 0) goto L57;
        long r128 = ColorDarkTokens.INSTANCE.m3348getBackground0d7_KjU();
    L58:
        long r1012 = r128;
        if ((r177 & 16384) == 0) goto L61;
        long r130 = ColorDarkTokens.INSTANCE.m3354getOnBackground0d7_KjU();
    L63:
        if ((r177 & 32768) == 0) goto L65;
        long r132 = ColorDarkTokens.INSTANCE.m3382getSurface0d7_KjU();
    L67:
        if ((r177 & 65536) == 0) goto L69;
        long r134 = ColorDarkTokens.INSTANCE.m3365getOnSurface0d7_KjU();
    L71:
        if ((r177 & 131072) == 0) goto L73;
        long r210 = ColorDarkTokens.INSTANCE.m3391getSurfaceVariant0d7_KjU();
    L75:
        if ((r177 & 262144) == 0) goto L77;
        long r211 = ColorDarkTokens.INSTANCE.m3366getOnSurfaceVariant0d7_KjU();
    L79:
        if ((r177 & 524288) == 0) goto L81;
        long r212 = r100;
    L83:
        if ((r177 & 1048576) == 0) goto L85;
        long r213 = ColorDarkTokens.INSTANCE.m3353getInverseSurface0d7_KjU();
    L87:
        if ((r177 & 2097152) == 0) goto L89;
        long r214 = ColorDarkTokens.INSTANCE.m3351getInverseOnSurface0d7_KjU();
    L91:
        if ((r177 & 4194304) == 0) goto L93;
        long r310 = ColorDarkTokens.INSTANCE.m3349getError0d7_KjU();
    L95:
        if ((r177 & 8388608) == 0) goto L97;
        long r311 = ColorDarkTokens.INSTANCE.m3355getOnError0d7_KjU();
    L99:
        if ((r177 & 16777216) == 0) goto L101;
        long r312 = ColorDarkTokens.INSTANCE.m3350getErrorContainer0d7_KjU();
    L103:
        if ((r177 & 33554432) == 0) goto L105;
        long r313 = ColorDarkTokens.INSTANCE.m3356getOnErrorContainer0d7_KjU();
    L107:
        if ((r177 & 67108864) == 0) goto L109;
        long r314 = ColorDarkTokens.INSTANCE.m3371getOutline0d7_KjU();
    L111:
        if ((r177 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L113;
        long r410 = ColorDarkTokens.INSTANCE.m3372getOutlineVariant0d7_KjU();
    L115:
        if ((r177 & 268435456) == 0) goto L117;
        long r411 = ColorDarkTokens.INSTANCE.m3377getScrim0d7_KjU();
    L119:
        if ((r177 & 536870912) == 0) goto L121;
        long r412 = ColorDarkTokens.INSTANCE.m3383getSurfaceBright0d7_KjU();
    L123:
        if ((r177 & 1073741824) == 0) goto L125;
        long r413 = ColorDarkTokens.INSTANCE.m3384getSurfaceContainer0d7_KjU();
    L127:
        if ((r177 & Integer.MIN_VALUE) == 0) goto L129;
        long r414 = ColorDarkTokens.INSTANCE.m3385getSurfaceContainerHigh0d7_KjU();
    L131:
        if ((r178 & 1) == 0) goto L133;
        long r510 = ColorDarkTokens.INSTANCE.m3386getSurfaceContainerHighest0d7_KjU();
    L135:
        if ((r178 & 2) == 0) goto L137;
        long r511 = ColorDarkTokens.INSTANCE.m3387getSurfaceContainerLow0d7_KjU();
    L139:
        if ((r178 & 4) == 0) goto L141;
        long r512 = ColorDarkTokens.INSTANCE.m3388getSurfaceContainerLowest0d7_KjU();
    L143:
        if ((r178 & 8) == 0) goto L145;
        long r513 = ColorDarkTokens.INSTANCE.m3389getSurfaceDim0d7_KjU();
    L147:
        if ((r178 & 16) == 0) goto L149;
        long r514 = ColorDarkTokens.INSTANCE.m3375getPrimaryFixed0d7_KjU();
    L151:
        if ((r178 & 32) == 0) goto L153;
        long r610 = ColorDarkTokens.INSTANCE.m3376getPrimaryFixedDim0d7_KjU();
    L155:
        if ((r178 & 64) == 0) goto L157;
        long r611 = ColorDarkTokens.INSTANCE.m3359getOnPrimaryFixed0d7_KjU();
    L159:
        if ((r178 & 128) == 0) goto L161;
        long r612 = ColorDarkTokens.INSTANCE.m3360getOnPrimaryFixedVariant0d7_KjU();
    L163:
        if ((r178 & 256) == 0) goto L165;
        long r613 = ColorDarkTokens.INSTANCE.m3380getSecondaryFixed0d7_KjU();
    L167:
        if ((r178 & 512) == 0) goto L169;
        long r614 = ColorDarkTokens.INSTANCE.m3381getSecondaryFixedDim0d7_KjU();
    L171:
        if ((r178 & 1024) == 0) goto L173;
        long r710 = ColorDarkTokens.INSTANCE.m3363getOnSecondaryFixed0d7_KjU();
    L175:
        if ((r178 & 2048) == 0) goto L177;
        long r711 = ColorDarkTokens.INSTANCE.m3364getOnSecondaryFixedVariant0d7_KjU();
    L179:
        if ((r178 & 4096) == 0) goto L181;
        long r712 = ColorDarkTokens.INSTANCE.m3394getTertiaryFixed0d7_KjU();
    L183:
        if ((r178 & 8192) == 0) goto L185;
        long r713 = ColorDarkTokens.INSTANCE.m3395getTertiaryFixedDim0d7_KjU();
    L187:
        if ((r178 & 16384) == 0) goto L189;
        long r714 = ColorDarkTokens.INSTANCE.m3369getOnTertiaryFixed0d7_KjU();
    L191:
        if ((r178 & 32768) == 0) goto L193;
        long r136 = ColorDarkTokens.INSTANCE.m3370getOnTertiaryFixedVariant0d7_KjU();
    L195:
        return m2047darkColorScheme_VG5OTI(r100, r102, r104, r106, r110, r112, r915, r916, r917, r918, r108, r1010, r1011, r1012, r130, r132, r134, r210, r211, r212, r213, r214, r310, r311, r312, r313, r314, r410, r411, r412, r413, r414, r510, r511, r512, r513, r514, r610, r611, r612, r613, r614, r710, r711, r712, r713, r714, r136);
    L193:
        r136 = r175;
        goto L195
    L189:
        r714 = r173;
        goto L191
    L185:
        r713 = r171;
        goto L187
    L181:
        r712 = r169;
        goto L183
    L177:
        r711 = r167;
        goto L179
    L173:
        r710 = r165;
        goto L175
    L169:
        r614 = r163;
        goto L171
    L165:
        r613 = r161;
        goto L167
    L161:
        r612 = r159;
        goto L163
    L157:
        r611 = r157;
        goto L159
    L153:
        r610 = r155;
        goto L155
    L149:
        r514 = r153;
        goto L151
    L145:
        r513 = r151;
        goto L147
    L141:
        r512 = r149;
        goto L143
    L137:
        r511 = r147;
        goto L139
    L133:
        r510 = r145;
        goto L135
    L129:
        r414 = r143;
        goto L131
    L125:
        r413 = r141;
        goto L127
    L121:
        r412 = r139;
        goto L123
    L117:
        r411 = r137;
        goto L119
    L113:
        r410 = r135;
        goto L115
    L109:
        r314 = r133;
        goto L111
    L105:
        r313 = r131;
        goto L107
    L101:
        r312 = r129;
        goto L103
    L97:
        r311 = r127;
        goto L99
    L93:
        r310 = r125;
        goto L95
    L89:
        r214 = r123;
        goto L91
    L85:
        r213 = r121;
        goto L87
    L81:
        r212 = r119;
        goto L83
    L77:
        r211 = r117;
        goto L79
    L73:
        r210 = r115;
        goto L75
    L69:
        r134 = r113;
        goto L71
    L65:
        r132 = r111;
        goto L67
    L61:
        r130 = r109;
        goto L63
    L57:
        r128 = r107;
        goto L58
    L53:
        r126 = r105;
        goto L54
    L49:
        r124 = r103;
        goto L50
    L45:
        r122 = r101;
        goto L46
    L41:
        r120 = r914;
        goto L42
    L37:
        r118 = r913;
        goto L38
    L33:
        r116 = r912;
        goto L34
    L29:
        r114 = r911;
        goto L30
    L25:
        r112 = r910;
        goto L27
    L21:
        r110 = r814;
        goto L23
    L17:
        r106 = r813;
        goto L19
    L13:
        r104 = r812;
        goto L15
    L9:
        r102 = r811;
        goto L11
    L5:
        r100 = r810;
        goto L7
    }

    /* JADX INFO: renamed from: lightColorScheme-_VG5OTI$default, reason: not valid java name */
    public static /* synthetic */ ColorScheme m2054lightColorScheme_VG5OTI$default(long r810, long r811, long r812, long r813, long r814, long r910, long r911, long r912, long r913, long r914, long r101, long r103, long r105, long r107, long r109, long r111, long r113, long r115, long r117, long r119, long r121, long r123, long r125, long r127, long r129, long r131, long r133, long r135, long r137, long r139, long r141, long r143, long r145, long r147, long r149, long r151, long r153, long r155, long r157, long r159, long r161, long r163, long r165, long r167, long r169, long r171, long r173, long r175, int r177, int r178, Object r179) {
        if ((r177 & 1) == 0) goto L5;
        long r100 = ColorLightTokens.INSTANCE.m3421getPrimary0d7_KjU();
    L7:
        if ((r177 & 2) == 0) goto L9;
        long r102 = ColorLightTokens.INSTANCE.m3405getOnPrimary0d7_KjU();
    L11:
        if ((r177 & 4) == 0) goto L13;
        long r104 = ColorLightTokens.INSTANCE.m3422getPrimaryContainer0d7_KjU();
    L15:
        if ((r177 & 8) == 0) goto L17;
        long r106 = ColorLightTokens.INSTANCE.m3406getOnPrimaryContainer0d7_KjU();
    L19:
        if ((r177 & 16) == 0) goto L21;
        long r110 = ColorLightTokens.INSTANCE.m3400getInversePrimary0d7_KjU();
    L23:
        if ((r177 & 32) == 0) goto L25;
        long r112 = ColorLightTokens.INSTANCE.m3426getSecondary0d7_KjU();
    L27:
        if ((r177 & 64) == 0) goto L29;
        long r114 = ColorLightTokens.INSTANCE.m3409getOnSecondary0d7_KjU();
    L30:
        long r915 = r114;
        if ((r177 & 128) == 0) goto L33;
        long r116 = ColorLightTokens.INSTANCE.m3427getSecondaryContainer0d7_KjU();
    L34:
        long r916 = r116;
        if ((r177 & 256) == 0) goto L37;
        long r118 = ColorLightTokens.INSTANCE.m3410getOnSecondaryContainer0d7_KjU();
    L38:
        long r917 = r118;
        if ((r177 & 512) == 0) goto L41;
        long r120 = ColorLightTokens.INSTANCE.m3440getTertiary0d7_KjU();
    L42:
        long r918 = r120;
        if ((r177 & 1024) == 0) goto L45;
        long r122 = ColorLightTokens.INSTANCE.m3415getOnTertiary0d7_KjU();
    L46:
        long r108 = r122;
        if ((r177 & 2048) == 0) goto L49;
        long r124 = ColorLightTokens.INSTANCE.m3441getTertiaryContainer0d7_KjU();
    L50:
        long r1010 = r124;
        if ((r177 & 4096) == 0) goto L53;
        long r126 = ColorLightTokens.INSTANCE.m3416getOnTertiaryContainer0d7_KjU();
    L54:
        long r1011 = r126;
        if ((r177 & 8192) == 0) goto L57;
        long r128 = ColorLightTokens.INSTANCE.m3396getBackground0d7_KjU();
    L58:
        long r1012 = r128;
        if ((r177 & 16384) == 0) goto L61;
        long r130 = ColorLightTokens.INSTANCE.m3402getOnBackground0d7_KjU();
    L63:
        if ((r177 & 32768) == 0) goto L65;
        long r132 = ColorLightTokens.INSTANCE.m3430getSurface0d7_KjU();
    L67:
        if ((r177 & 65536) == 0) goto L69;
        long r134 = ColorLightTokens.INSTANCE.m3413getOnSurface0d7_KjU();
    L71:
        if ((r177 & 131072) == 0) goto L73;
        long r210 = ColorLightTokens.INSTANCE.m3439getSurfaceVariant0d7_KjU();
    L75:
        if ((r177 & 262144) == 0) goto L77;
        long r211 = ColorLightTokens.INSTANCE.m3414getOnSurfaceVariant0d7_KjU();
    L79:
        if ((r177 & 524288) == 0) goto L81;
        long r212 = r100;
    L83:
        if ((r177 & 1048576) == 0) goto L85;
        long r213 = ColorLightTokens.INSTANCE.m3401getInverseSurface0d7_KjU();
    L87:
        if ((r177 & 2097152) == 0) goto L89;
        long r214 = ColorLightTokens.INSTANCE.m3399getInverseOnSurface0d7_KjU();
    L91:
        if ((r177 & 4194304) == 0) goto L93;
        long r310 = ColorLightTokens.INSTANCE.m3397getError0d7_KjU();
    L95:
        if ((r177 & 8388608) == 0) goto L97;
        long r311 = ColorLightTokens.INSTANCE.m3403getOnError0d7_KjU();
    L99:
        if ((r177 & 16777216) == 0) goto L101;
        long r312 = ColorLightTokens.INSTANCE.m3398getErrorContainer0d7_KjU();
    L103:
        if ((r177 & 33554432) == 0) goto L105;
        long r313 = ColorLightTokens.INSTANCE.m3404getOnErrorContainer0d7_KjU();
    L107:
        if ((r177 & 67108864) == 0) goto L109;
        long r314 = ColorLightTokens.INSTANCE.m3419getOutline0d7_KjU();
    L111:
        if ((r177 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L113;
        long r410 = ColorLightTokens.INSTANCE.m3420getOutlineVariant0d7_KjU();
    L115:
        if ((r177 & 268435456) == 0) goto L117;
        long r411 = ColorLightTokens.INSTANCE.m3425getScrim0d7_KjU();
    L119:
        if ((r177 & 536870912) == 0) goto L121;
        long r412 = ColorLightTokens.INSTANCE.m3431getSurfaceBright0d7_KjU();
    L123:
        if ((r177 & 1073741824) == 0) goto L125;
        long r413 = ColorLightTokens.INSTANCE.m3432getSurfaceContainer0d7_KjU();
    L127:
        if ((r177 & Integer.MIN_VALUE) == 0) goto L129;
        long r414 = ColorLightTokens.INSTANCE.m3433getSurfaceContainerHigh0d7_KjU();
    L131:
        if ((r178 & 1) == 0) goto L133;
        long r510 = ColorLightTokens.INSTANCE.m3434getSurfaceContainerHighest0d7_KjU();
    L135:
        if ((r178 & 2) == 0) goto L137;
        long r511 = ColorLightTokens.INSTANCE.m3435getSurfaceContainerLow0d7_KjU();
    L139:
        if ((r178 & 4) == 0) goto L141;
        long r512 = ColorLightTokens.INSTANCE.m3436getSurfaceContainerLowest0d7_KjU();
    L143:
        if ((r178 & 8) == 0) goto L145;
        long r513 = ColorLightTokens.INSTANCE.m3437getSurfaceDim0d7_KjU();
    L147:
        if ((r178 & 16) == 0) goto L149;
        long r514 = ColorLightTokens.INSTANCE.m3423getPrimaryFixed0d7_KjU();
    L151:
        if ((r178 & 32) == 0) goto L153;
        long r610 = ColorLightTokens.INSTANCE.m3424getPrimaryFixedDim0d7_KjU();
    L155:
        if ((r178 & 64) == 0) goto L157;
        long r611 = ColorLightTokens.INSTANCE.m3407getOnPrimaryFixed0d7_KjU();
    L159:
        if ((r178 & 128) == 0) goto L161;
        long r612 = ColorLightTokens.INSTANCE.m3408getOnPrimaryFixedVariant0d7_KjU();
    L163:
        if ((r178 & 256) == 0) goto L165;
        long r613 = ColorLightTokens.INSTANCE.m3428getSecondaryFixed0d7_KjU();
    L167:
        if ((r178 & 512) == 0) goto L169;
        long r614 = ColorLightTokens.INSTANCE.m3429getSecondaryFixedDim0d7_KjU();
    L171:
        if ((r178 & 1024) == 0) goto L173;
        long r710 = ColorLightTokens.INSTANCE.m3411getOnSecondaryFixed0d7_KjU();
    L175:
        if ((r178 & 2048) == 0) goto L177;
        long r711 = ColorLightTokens.INSTANCE.m3412getOnSecondaryFixedVariant0d7_KjU();
    L179:
        if ((r178 & 4096) == 0) goto L181;
        long r712 = ColorLightTokens.INSTANCE.m3442getTertiaryFixed0d7_KjU();
    L183:
        if ((r178 & 8192) == 0) goto L185;
        long r713 = ColorLightTokens.INSTANCE.m3443getTertiaryFixedDim0d7_KjU();
    L187:
        if ((r178 & 16384) == 0) goto L189;
        long r714 = ColorLightTokens.INSTANCE.m3417getOnTertiaryFixed0d7_KjU();
    L191:
        if ((r178 & 32768) == 0) goto L193;
        long r136 = ColorLightTokens.INSTANCE.m3418getOnTertiaryFixedVariant0d7_KjU();
    L195:
        return m2053lightColorScheme_VG5OTI(r100, r102, r104, r106, r110, r112, r915, r916, r917, r918, r108, r1010, r1011, r1012, r130, r132, r134, r210, r211, r212, r213, r214, r310, r311, r312, r313, r314, r410, r411, r412, r413, r414, r510, r511, r512, r513, r514, r610, r611, r612, r613, r614, r710, r711, r712, r713, r714, r136);
    L193:
        r136 = r175;
        goto L195
    L189:
        r714 = r173;
        goto L191
    L185:
        r713 = r171;
        goto L187
    L181:
        r712 = r169;
        goto L183
    L177:
        r711 = r167;
        goto L179
    L173:
        r710 = r165;
        goto L175
    L169:
        r614 = r163;
        goto L171
    L165:
        r613 = r161;
        goto L167
    L161:
        r612 = r159;
        goto L163
    L157:
        r611 = r157;
        goto L159
    L153:
        r610 = r155;
        goto L155
    L149:
        r514 = r153;
        goto L151
    L145:
        r513 = r151;
        goto L147
    L141:
        r512 = r149;
        goto L143
    L137:
        r511 = r147;
        goto L139
    L133:
        r510 = r145;
        goto L135
    L129:
        r414 = r143;
        goto L131
    L125:
        r413 = r141;
        goto L127
    L121:
        r412 = r139;
        goto L123
    L117:
        r411 = r137;
        goto L119
    L113:
        r410 = r135;
        goto L115
    L109:
        r314 = r133;
        goto L111
    L105:
        r313 = r131;
        goto L107
    L101:
        r312 = r129;
        goto L103
    L97:
        r311 = r127;
        goto L99
    L93:
        r310 = r125;
        goto L95
    L89:
        r214 = r123;
        goto L91
    L85:
        r213 = r121;
        goto L87
    L81:
        r212 = r119;
        goto L83
    L77:
        r211 = r117;
        goto L79
    L73:
        r210 = r115;
        goto L75
    L69:
        r134 = r113;
        goto L71
    L65:
        r132 = r111;
        goto L67
    L61:
        r130 = r109;
        goto L63
    L57:
        r128 = r107;
        goto L58
    L53:
        r126 = r105;
        goto L54
    L49:
        r124 = r103;
        goto L50
    L45:
        r122 = r101;
        goto L46
    L41:
        r120 = r914;
        goto L42
    L37:
        r118 = r913;
        goto L38
    L33:
        r116 = r912;
        goto L34
    L29:
        r114 = r911;
        goto L30
    L25:
        r112 = r910;
        goto L27
    L21:
        r110 = r814;
        goto L23
    L17:
        r106 = r813;
        goto L19
    L13:
        r104 = r812;
        goto L15
    L9:
        r102 = r811;
        goto L11
    L5:
        r100 = r810;
        goto L7
    }
}
