package androidx.compose.material3;

import androidx.compose.material3.tokens.TypographyTokens;
import androidx.compose.ui.text.TextStyle;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\bB\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001Bµ\u0002\b\u0000\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0003\u0012\b\b\u0002\u0010 \u001a\u00020\u0003¢\u0006\u0004\b!\u0010\"B\u009f\u0001\b\u0016\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003¢\u0006\u0004\b!\u0010#J¹\u0002\u0010C\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u0010\u001f\u001a\u00020\u00032\b\b\u0002\u0010 \u001a\u00020\u0003H\u0000¢\u0006\u0002\bDJ\u009c\u0001\u0010C\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u0003J\u0013\u0010E\u001a\u00020F2\b\u0010G\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010H\u001a\u00020IH\u0016J\b\u0010J\u001a\u00020KH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010%R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010%R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010%R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010%R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010%R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010%R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010%R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010%R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010%R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u0010%R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b0\u0010%R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b1\u0010%R\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b2\u0010%R\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b3\u0010%R\u0014\u0010\u0012\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010%R\u0014\u0010\u0013\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u0010%R\u0014\u0010\u0014\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u0010%R\u0014\u0010\u0015\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u0010%R\u0014\u0010\u0016\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u0010%R\u0014\u0010\u0017\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010%R\u0014\u0010\u0018\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u0010%R\u0014\u0010\u0019\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u0010%R\u0014\u0010\u001a\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010%R\u0014\u0010\u001b\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b=\u0010%R\u0014\u0010\u001c\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010%R\u0014\u0010\u001d\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u0010%R\u0014\u0010\u001e\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b@\u0010%R\u0014\u0010\u001f\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bA\u0010%R\u0014\u0010 \u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bB\u0010%¨\u0006L"}, d2 = {"Landroidx/compose/material3/Typography;", "", "displayLarge", "Landroidx/compose/ui/text/TextStyle;", "displayMedium", "displaySmall", "headlineLarge", "headlineMedium", "headlineSmall", "titleLarge", "titleMedium", "titleSmall", "bodyLarge", "bodyMedium", "bodySmall", "labelLarge", "labelMedium", "labelSmall", "displayLargeEmphasized", "displayMediumEmphasized", "displaySmallEmphasized", "headlineLargeEmphasized", "headlineMediumEmphasized", "headlineSmallEmphasized", "titleLargeEmphasized", "titleMediumEmphasized", "titleSmallEmphasized", "bodyLargeEmphasized", "bodyMediumEmphasized", "bodySmallEmphasized", "labelLargeEmphasized", "labelMediumEmphasized", "labelSmallEmphasized", "<init>", "(Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;)V", "(Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;)V", "getDisplayLarge", "()Landroidx/compose/ui/text/TextStyle;", "getDisplayMedium", "getDisplaySmall", "getHeadlineLarge", "getHeadlineMedium", "getHeadlineSmall", "getTitleLarge", "getTitleMedium", "getTitleSmall", "getBodyLarge", "getBodyMedium", "getBodySmall", "getLabelLarge", "getLabelMedium", "getLabelSmall", "getDisplayLargeEmphasized$material3", "getDisplayMediumEmphasized$material3", "getDisplaySmallEmphasized$material3", "getHeadlineLargeEmphasized$material3", "getHeadlineMediumEmphasized$material3", "getHeadlineSmallEmphasized$material3", "getTitleLargeEmphasized$material3", "getTitleMediumEmphasized$material3", "getTitleSmallEmphasized$material3", "getBodyLargeEmphasized$material3", "getBodyMediumEmphasized$material3", "getBodySmallEmphasized$material3", "getLabelLargeEmphasized$material3", "getLabelMediumEmphasized$material3", "getLabelSmallEmphasized$material3", "copy", "copy$material3", "equals", "", "other", "hashCode", "", "toString", "", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Typography {
    public static final int $stable = 0;
    private final TextStyle bodyLarge;
    private final TextStyle bodyLargeEmphasized;
    private final TextStyle bodyMedium;
    private final TextStyle bodyMediumEmphasized;
    private final TextStyle bodySmall;
    private final TextStyle bodySmallEmphasized;
    private final TextStyle displayLarge;
    private final TextStyle displayLargeEmphasized;
    private final TextStyle displayMedium;
    private final TextStyle displayMediumEmphasized;
    private final TextStyle displaySmall;
    private final TextStyle displaySmallEmphasized;
    private final TextStyle headlineLarge;
    private final TextStyle headlineLargeEmphasized;
    private final TextStyle headlineMedium;
    private final TextStyle headlineMediumEmphasized;
    private final TextStyle headlineSmall;
    private final TextStyle headlineSmallEmphasized;
    private final TextStyle labelLarge;
    private final TextStyle labelLargeEmphasized;
    private final TextStyle labelMedium;
    private final TextStyle labelMediumEmphasized;
    private final TextStyle labelSmall;
    private final TextStyle labelSmallEmphasized;
    private final TextStyle titleLarge;
    private final TextStyle titleLargeEmphasized;
    private final TextStyle titleMedium;
    private final TextStyle titleMediumEmphasized;
    private final TextStyle titleSmall;
    private final TextStyle titleSmallEmphasized;

    public Typography() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 1073741823, null);
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((((((((((((((((((((((((this.displayLarge.hashCode() * 31) + this.displayMedium.hashCode()) * 31) + this.displaySmall.hashCode()) * 31) + this.headlineLarge.hashCode()) * 31) + this.headlineMedium.hashCode()) * 31) + this.headlineSmall.hashCode()) * 31) + this.titleLarge.hashCode()) * 31) + this.titleMedium.hashCode()) * 31) + this.titleSmall.hashCode()) * 31) + this.bodyLarge.hashCode()) * 31) + this.bodyMedium.hashCode()) * 31) + this.bodySmall.hashCode()) * 31) + this.labelLarge.hashCode()) * 31) + this.labelMedium.hashCode()) * 31) + this.labelSmall.hashCode()) * 31) + this.displayLargeEmphasized.hashCode()) * 31) + this.displayMediumEmphasized.hashCode()) * 31) + this.displaySmallEmphasized.hashCode()) * 31) + this.headlineLargeEmphasized.hashCode()) * 31) + this.headlineMediumEmphasized.hashCode()) * 31) + this.headlineSmallEmphasized.hashCode()) * 31) + this.titleLargeEmphasized.hashCode()) * 31) + this.titleMediumEmphasized.hashCode()) * 31) + this.titleSmallEmphasized.hashCode()) * 31) + this.bodyLargeEmphasized.hashCode()) * 31) + this.bodyMediumEmphasized.hashCode()) * 31) + this.bodySmallEmphasized.hashCode()) * 31) + this.labelLargeEmphasized.hashCode()) * 31) + this.labelMediumEmphasized.hashCode()) * 31) + this.labelSmallEmphasized.hashCode();
    }

    public String toString() {
        return "Typography(displayLarge=" + this.displayLarge + ", displayMedium=" + this.displayMedium + ",displaySmall=" + this.displaySmall + ", headlineLarge=" + this.headlineLarge + ", headlineMedium=" + this.headlineMedium + ", headlineSmall=" + this.headlineSmall + ", titleLarge=" + this.titleLarge + ", titleMedium=" + this.titleMedium + ", titleSmall=" + this.titleSmall + ", bodyLarge=" + this.bodyLarge + ", bodyMedium=" + this.bodyMedium + ", bodySmall=" + this.bodySmall + ", labelLarge=" + this.labelLarge + ", labelMedium=" + this.labelMedium + ", labelSmall=" + this.labelSmall + ", displayLargeEmphasized=" + this.displayLargeEmphasized + ", displayMediumEmphasized=" + this.displayMediumEmphasized + ", displaySmallEmphasized=" + this.displaySmallEmphasized + ", headlineLargeEmphasized=" + this.headlineLargeEmphasized + ", headlineMediumEmphasized=" + this.headlineMediumEmphasized + ", headlineSmallEmphasized=" + this.headlineSmallEmphasized + ", titleLargeEmphasized=" + this.titleLargeEmphasized + ", titleMediumEmphasized=" + this.titleMediumEmphasized + ", titleSmallEmphasized=" + this.titleSmallEmphasized + ", bodyLargeEmphasized=" + this.bodyLargeEmphasized + ", bodyMediumEmphasized=" + this.bodyMediumEmphasized + ", bodySmallEmphasized=" + this.bodySmallEmphasized + ", labelLargeEmphasized=" + this.labelLargeEmphasized + ", labelMediumEmphasized=" + this.labelMediumEmphasized + ", labelSmallEmphasized=" + this.labelSmallEmphasized + ')';
    }

    public final TextStyle getBodyLarge() {
        return this.bodyLarge;
    }

    public final TextStyle getBodyLargeEmphasized$material3() {
        return this.bodyLargeEmphasized;
    }

    public final TextStyle getBodyMedium() {
        return this.bodyMedium;
    }

    public final TextStyle getBodyMediumEmphasized$material3() {
        return this.bodyMediumEmphasized;
    }

    public final TextStyle getBodySmall() {
        return this.bodySmall;
    }

    public final TextStyle getBodySmallEmphasized$material3() {
        return this.bodySmallEmphasized;
    }

    public final TextStyle getDisplayLarge() {
        return this.displayLarge;
    }

    public final TextStyle getDisplayLargeEmphasized$material3() {
        return this.displayLargeEmphasized;
    }

    public final TextStyle getDisplayMedium() {
        return this.displayMedium;
    }

    public final TextStyle getDisplayMediumEmphasized$material3() {
        return this.displayMediumEmphasized;
    }

    public final TextStyle getDisplaySmall() {
        return this.displaySmall;
    }

    public final TextStyle getDisplaySmallEmphasized$material3() {
        return this.displaySmallEmphasized;
    }

    public final TextStyle getHeadlineLarge() {
        return this.headlineLarge;
    }

    public final TextStyle getHeadlineLargeEmphasized$material3() {
        return this.headlineLargeEmphasized;
    }

    public final TextStyle getHeadlineMedium() {
        return this.headlineMedium;
    }

    public final TextStyle getHeadlineMediumEmphasized$material3() {
        return this.headlineMediumEmphasized;
    }

    public final TextStyle getHeadlineSmall() {
        return this.headlineSmall;
    }

    public final TextStyle getHeadlineSmallEmphasized$material3() {
        return this.headlineSmallEmphasized;
    }

    public final TextStyle getLabelLarge() {
        return this.labelLarge;
    }

    public final TextStyle getLabelLargeEmphasized$material3() {
        return this.labelLargeEmphasized;
    }

    public final TextStyle getLabelMedium() {
        return this.labelMedium;
    }

    public final TextStyle getLabelMediumEmphasized$material3() {
        return this.labelMediumEmphasized;
    }

    public final TextStyle getLabelSmall() {
        return this.labelSmall;
    }

    public final TextStyle getLabelSmallEmphasized$material3() {
        return this.labelSmallEmphasized;
    }

    public final TextStyle getTitleLarge() {
        return this.titleLarge;
    }

    public final TextStyle getTitleLargeEmphasized$material3() {
        return this.titleLargeEmphasized;
    }

    public final TextStyle getTitleMedium() {
        return this.titleMedium;
    }

    public final TextStyle getTitleMediumEmphasized$material3() {
        return this.titleMediumEmphasized;
    }

    public final TextStyle getTitleSmall() {
        return this.titleSmall;
    }

    public final TextStyle getTitleSmallEmphasized$material3() {
        return this.titleSmallEmphasized;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof Typography) == true) goto L8;
        return false;
    L8:
        Typography r101 = (Typography) r100;
        if (Intrinsics.areEqual(this.displayLarge, r101.displayLarge) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.displayMedium, r101.displayMedium) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.displaySmall, r101.displaySmall) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.headlineLarge, r101.headlineLarge) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.headlineMedium, r101.headlineMedium) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.headlineSmall, r101.headlineSmall) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.titleLarge, r101.titleLarge) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.titleMedium, r101.titleMedium) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.titleSmall, r101.titleSmall) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.bodyLarge, r101.bodyLarge) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.bodyMedium, r101.bodyMedium) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.bodySmall, r101.bodySmall) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.labelLarge, r101.labelLarge) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.labelMedium, r101.labelMedium) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.labelSmall, r101.labelSmall) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.displayLargeEmphasized, r101.displayLargeEmphasized) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.displayMediumEmphasized, r101.displayMediumEmphasized) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.displaySmallEmphasized, r101.displaySmallEmphasized) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.headlineLargeEmphasized, r101.headlineLargeEmphasized) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.headlineMediumEmphasized, r101.headlineMediumEmphasized) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.headlineSmallEmphasized, r101.headlineSmallEmphasized) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.titleLargeEmphasized, r101.titleLargeEmphasized) == true) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.titleMediumEmphasized, r101.titleMediumEmphasized) == true) goto L78;
        return false;
    L78:
        if (Intrinsics.areEqual(this.titleSmallEmphasized, r101.titleSmallEmphasized) == true) goto L81;
        return false;
    L81:
        if (Intrinsics.areEqual(this.bodyLargeEmphasized, r101.bodyLargeEmphasized) == true) goto L84;
        return false;
    L84:
        if (Intrinsics.areEqual(this.bodyMediumEmphasized, r101.bodyMediumEmphasized) == true) goto L87;
        return false;
    L87:
        if (Intrinsics.areEqual(this.bodySmallEmphasized, r101.bodySmallEmphasized) == true) goto L90;
        return false;
    L90:
        if (Intrinsics.areEqual(this.labelLargeEmphasized, r101.labelLargeEmphasized) == true) goto L93;
        return false;
    L93:
        if (Intrinsics.areEqual(this.labelMediumEmphasized, r101.labelMediumEmphasized) == true) goto L96;
        return false;
    L96:
        if (Intrinsics.areEqual(this.labelSmallEmphasized, r101.labelSmallEmphasized) == true) goto L98;
        return false;
    L98:
        return true;
    }

    public Typography(TextStyle r310, TextStyle r311, TextStyle r312, TextStyle r313, TextStyle r314, TextStyle r315, TextStyle r316, TextStyle r317, TextStyle r410, TextStyle r411, TextStyle r412, TextStyle r413, TextStyle r414, TextStyle r415, TextStyle r416) {
        this(r310, r311, r312, r313, r314, r315, r316, r317, r410, r411, r412, r413, r414, r415, r416, r310, r311, r312, r313, r314, r315, r316, r317, r410, r411, r412, r413, r414, r415, r416);
    }

    public final Typography copy(TextStyle r310, TextStyle r311, TextStyle r312, TextStyle r313, TextStyle r314, TextStyle r315, TextStyle r316, TextStyle r410, TextStyle r411, TextStyle r412, TextStyle r413, TextStyle r414, TextStyle r415, TextStyle r416, TextStyle r417) {
        return copy$material3(r310, r311, r312, r313, r314, r315, r316, r410, r411, r412, r413, r414, r415, r416, r417, this.displayLargeEmphasized, this.displayMediumEmphasized, this.displaySmallEmphasized, this.headlineLargeEmphasized, this.headlineMediumEmphasized, this.headlineSmallEmphasized, this.titleLargeEmphasized, this.titleMediumEmphasized, this.titleSmallEmphasized, this.bodyLargeEmphasized, this.bodyMediumEmphasized, this.bodySmallEmphasized, this.labelLargeEmphasized, this.labelMediumEmphasized, this.labelSmallEmphasized);
    }

    public /* synthetic */ Typography(TextStyle r110, TextStyle r111, TextStyle r112, TextStyle r113, TextStyle r210, TextStyle r211, TextStyle r212, TextStyle r213, TextStyle r214, TextStyle r215, TextStyle r216, TextStyle r217, TextStyle r218, TextStyle r219, TextStyle r310, int r311, DefaultConstructorMarker r312) {
        if ((r311 & 1) == 0) goto L5;
        TextStyle r100 = TypographyTokens.INSTANCE.getDisplayLarge();
    L7:
        if ((r311 & 2) == 0) goto L9;
        TextStyle r101 = TypographyTokens.INSTANCE.getDisplayMedium();
    L11:
        if ((r311 & 4) == 0) goto L13;
        TextStyle r102 = TypographyTokens.INSTANCE.getDisplaySmall();
    L15:
        if ((r311 & 8) == 0) goto L17;
        TextStyle r103 = TypographyTokens.INSTANCE.getHeadlineLarge();
    L19:
        if ((r311 & 16) == 0) goto L21;
        TextStyle r104 = TypographyTokens.INSTANCE.getHeadlineMedium();
    L23:
        if ((r311 & 32) == 0) goto L25;
        TextStyle r105 = TypographyTokens.INSTANCE.getHeadlineSmall();
    L27:
        if ((r311 & 64) == 0) goto L29;
        TextStyle r106 = TypographyTokens.INSTANCE.getTitleLarge();
    L31:
        if ((r311 & 128) == 0) goto L33;
        TextStyle r107 = TypographyTokens.INSTANCE.getTitleMedium();
    L35:
        if ((r311 & 256) == 0) goto L37;
        TextStyle r108 = TypographyTokens.INSTANCE.getTitleSmall();
    L39:
        if ((r311 & 512) == 0) goto L41;
        TextStyle r114 = TypographyTokens.INSTANCE.getBodyLarge();
    L43:
        if ((r311 & 1024) == 0) goto L45;
        TextStyle r115 = TypographyTokens.INSTANCE.getBodyMedium();
    L47:
        if ((r311 & 2048) == 0) goto L49;
        TextStyle r116 = TypographyTokens.INSTANCE.getBodySmall();
    L51:
        if ((r311 & 4096) == 0) goto L53;
        TextStyle r117 = TypographyTokens.INSTANCE.getLabelLarge();
    L55:
        if ((r311 & 8192) == 0) goto L57;
        TextStyle r118 = TypographyTokens.INSTANCE.getLabelMedium();
    L59:
        if ((r311 & 16384) == 0) goto L61;
        TextStyle r109 = TypographyTokens.INSTANCE.getLabelSmall();
    L62:
        this(r100, r101, r102, r103, r104, r105, r106, r107, r108, r114, r115, r116, r117, r118, r109);
        return;
    L61:
        r109 = r310;
        goto L62
    L57:
        r118 = r219;
        goto L59
    L53:
        r117 = r218;
        goto L55
    L49:
        r116 = r217;
        goto L51
    L45:
        r115 = r216;
        goto L47
    L41:
        r114 = r215;
        goto L43
    L37:
        r108 = r214;
        goto L39
    L33:
        r107 = r213;
        goto L35
    L29:
        r106 = r212;
        goto L31
    L25:
        r105 = r211;
        goto L27
    L21:
        r104 = r210;
        goto L23
    L17:
        r103 = r113;
        goto L19
    L13:
        r102 = r112;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }

    public static /* synthetic */ Typography copy$default(Typography r110, TextStyle r111, TextStyle r112, TextStyle r113, TextStyle r210, TextStyle r211, TextStyle r212, TextStyle r213, TextStyle r214, TextStyle r215, TextStyle r216, TextStyle r217, TextStyle r218, TextStyle r219, TextStyle r310, TextStyle r311, int r312, Object r313) {
        if ((r312 & 1) == 0) goto L5;
        TextStyle r100 = r110.displayLarge;
    L7:
        if ((r312 & 2) == 0) goto L9;
        TextStyle r101 = r110.displayMedium;
    L11:
        if ((r312 & 4) == 0) goto L13;
        TextStyle r102 = r110.displaySmall;
    L15:
        if ((r312 & 8) == 0) goto L17;
        TextStyle r103 = r110.headlineLarge;
    L19:
        if ((r312 & 16) == 0) goto L21;
        TextStyle r104 = r110.headlineMedium;
    L23:
        if ((r312 & 32) == 0) goto L25;
        TextStyle r105 = r110.headlineSmall;
    L27:
        if ((r312 & 64) == 0) goto L29;
        TextStyle r106 = r110.titleLarge;
    L31:
        if ((r312 & 128) == 0) goto L33;
        TextStyle r107 = r110.titleMedium;
    L35:
        if ((r312 & 256) == 0) goto L37;
        TextStyle r114 = r110.titleSmall;
    L39:
        if ((r312 & 512) == 0) goto L41;
        TextStyle r115 = r110.bodyLarge;
    L43:
        if ((r312 & 1024) == 0) goto L45;
        TextStyle r116 = r110.bodyMedium;
    L47:
        if ((r312 & 2048) == 0) goto L49;
        TextStyle r117 = r110.bodySmall;
    L51:
        if ((r312 & 4096) == 0) goto L53;
        TextStyle r118 = r110.labelLarge;
    L55:
        if ((r312 & 8192) == 0) goto L57;
        TextStyle r119 = r110.labelMedium;
    L59:
        if ((r312 & 16384) == 0) goto L61;
        TextStyle r108 = r110.labelSmall;
    L63:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r114, r115, r116, r117, r118, r119, r108);
    L61:
        r108 = r311;
        goto L63
    L57:
        r119 = r310;
        goto L59
    L53:
        r118 = r219;
        goto L55
    L49:
        r117 = r218;
        goto L51
    L45:
        r116 = r217;
        goto L47
    L41:
        r115 = r216;
        goto L43
    L37:
        r114 = r215;
        goto L39
    L33:
        r107 = r214;
        goto L35
    L29:
        r106 = r213;
        goto L31
    L25:
        r105 = r212;
        goto L27
    L21:
        r104 = r211;
        goto L23
    L17:
        r103 = r210;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public Typography(TextStyle r100, TextStyle r101, TextStyle r102, TextStyle r103, TextStyle r104, TextStyle r105, TextStyle r106, TextStyle r110, TextStyle r111, TextStyle r112, TextStyle r113, TextStyle r114, TextStyle r115, TextStyle r116, TextStyle r117, TextStyle r118, TextStyle r119, TextStyle r210, TextStyle r211, TextStyle r212, TextStyle r213, TextStyle r214, TextStyle r215, TextStyle r216, TextStyle r217, TextStyle r218, TextStyle r219, TextStyle r310, TextStyle r311, TextStyle r312) {
        this.displayLarge = r100;
        this.displayMedium = r101;
        this.displaySmall = r102;
        this.headlineLarge = r103;
        this.headlineMedium = r104;
        this.headlineSmall = r105;
        this.titleLarge = r106;
        this.titleMedium = r110;
        this.titleSmall = r111;
        this.bodyLarge = r112;
        this.bodyMedium = r113;
        this.bodySmall = r114;
        this.labelLarge = r115;
        this.labelMedium = r116;
        this.labelSmall = r117;
        this.displayLargeEmphasized = r118;
        this.displayMediumEmphasized = r119;
        this.displaySmallEmphasized = r210;
        this.headlineLargeEmphasized = r211;
        this.headlineMediumEmphasized = r212;
        this.headlineSmallEmphasized = r213;
        this.titleLargeEmphasized = r214;
        this.titleMediumEmphasized = r215;
        this.titleSmallEmphasized = r216;
        this.bodyLargeEmphasized = r217;
        this.bodyMediumEmphasized = r218;
        this.bodySmallEmphasized = r219;
        this.labelLargeEmphasized = r310;
        this.labelMediumEmphasized = r311;
        this.labelSmallEmphasized = r312;
    }

    public final Typography copy$material3(TextStyle r310, TextStyle r311, TextStyle r312, TextStyle r313, TextStyle r314, TextStyle r315, TextStyle r316, TextStyle r410, TextStyle r411, TextStyle r412, TextStyle r413, TextStyle r414, TextStyle r415, TextStyle r416, TextStyle r417, TextStyle r418, TextStyle r419, TextStyle r510, TextStyle r511, TextStyle r512, TextStyle r513, TextStyle r514, TextStyle r515, TextStyle r516, TextStyle r517, TextStyle r518, TextStyle r519, TextStyle r610, TextStyle r611, TextStyle r612) {
        return new Typography(r310, r311, r312, r313, r314, r315, r316, r410, r411, r412, r413, r414, r415, r416, r417, r418, r419, r510, r511, r512, r513, r514, r515, r516, r517, r518, r519, r610, r611, r612);
    }

    public /* synthetic */ Typography(TextStyle r310, TextStyle r311, TextStyle r312, TextStyle r313, TextStyle r314, TextStyle r315, TextStyle r316, TextStyle r317, TextStyle r410, TextStyle r411, TextStyle r412, TextStyle r413, TextStyle r414, TextStyle r415, TextStyle r416, TextStyle r417, TextStyle r418, TextStyle r419, TextStyle r510, TextStyle r511, TextStyle r512, TextStyle r513, TextStyle r514, TextStyle r515, TextStyle r516, TextStyle r517, TextStyle r518, TextStyle r519, TextStyle r610, TextStyle r611, int r612, DefaultConstructorMarker r613) {
        if ((r612 & 1) == 0) goto L5;
        TextStyle r100 = TypographyTokens.INSTANCE.getDisplayLarge();
    L7:
        if ((r612 & 2) == 0) goto L9;
        TextStyle r101 = TypographyTokens.INSTANCE.getDisplayMedium();
    L11:
        if ((r612 & 4) == 0) goto L13;
        TextStyle r102 = TypographyTokens.INSTANCE.getDisplaySmall();
    L15:
        if ((r612 & 8) == 0) goto L17;
        TextStyle r103 = TypographyTokens.INSTANCE.getHeadlineLarge();
    L19:
        if ((r612 & 16) == 0) goto L21;
        TextStyle r104 = TypographyTokens.INSTANCE.getHeadlineMedium();
    L23:
        if ((r612 & 32) == 0) goto L25;
        TextStyle r105 = TypographyTokens.INSTANCE.getHeadlineSmall();
    L27:
        if ((r612 & 64) == 0) goto L29;
        TextStyle r106 = TypographyTokens.INSTANCE.getTitleLarge();
    L31:
        if ((r612 & 128) == 0) goto L33;
        TextStyle r107 = TypographyTokens.INSTANCE.getTitleMedium();
    L35:
        if ((r612 & 256) == 0) goto L37;
        TextStyle r108 = TypographyTokens.INSTANCE.getTitleSmall();
    L39:
        if ((r612 & 512) == 0) goto L41;
        TextStyle r110 = TypographyTokens.INSTANCE.getBodyLarge();
    L43:
        if ((r612 & 1024) == 0) goto L45;
        TextStyle r111 = TypographyTokens.INSTANCE.getBodyMedium();
    L47:
        if ((r612 & 2048) == 0) goto L49;
        TextStyle r112 = TypographyTokens.INSTANCE.getBodySmall();
    L51:
        if ((r612 & 4096) == 0) goto L53;
        TextStyle r113 = TypographyTokens.INSTANCE.getLabelLarge();
    L55:
        if ((r612 & 8192) == 0) goto L57;
        TextStyle r114 = TypographyTokens.INSTANCE.getLabelMedium();
    L59:
        if ((r612 & 16384) == 0) goto L61;
        TextStyle r115 = TypographyTokens.INSTANCE.getLabelSmall();
    L63:
        if ((r612 & 32768) == 0) goto L65;
        TextStyle r116 = TypographyTokens.INSTANCE.getDisplayLargeEmphasized();
    L67:
        if ((r612 & 65536) == 0) goto L69;
        TextStyle r117 = TypographyTokens.INSTANCE.getDisplayMediumEmphasized();
    L71:
        if ((r612 & 131072) == 0) goto L73;
        TextStyle r118 = TypographyTokens.INSTANCE.getDisplaySmallEmphasized();
    L75:
        if ((r612 & 262144) == 0) goto L77;
        TextStyle r119 = TypographyTokens.INSTANCE.getHeadlineLargeEmphasized();
    L79:
        if ((r612 & 524288) == 0) goto L81;
        TextStyle r210 = TypographyTokens.INSTANCE.getHeadlineMediumEmphasized();
    L83:
        if ((r612 & 1048576) == 0) goto L85;
        TextStyle r211 = TypographyTokens.INSTANCE.getHeadlineSmallEmphasized();
    L87:
        if ((r612 & 2097152) == 0) goto L89;
        TextStyle r212 = TypographyTokens.INSTANCE.getTitleLargeEmphasized();
    L91:
        if ((r612 & 4194304) == 0) goto L93;
        TextStyle r213 = TypographyTokens.INSTANCE.getTitleMediumEmphasized();
    L95:
        if ((r612 & 8388608) == 0) goto L97;
        TextStyle r214 = TypographyTokens.INSTANCE.getTitleSmallEmphasized();
    L99:
        if ((r612 & 16777216) == 0) goto L101;
        TextStyle r215 = TypographyTokens.INSTANCE.getBodyLargeEmphasized();
    L103:
        if ((r612 & 33554432) == 0) goto L105;
        TextStyle r216 = TypographyTokens.INSTANCE.getBodyMediumEmphasized();
    L107:
        if ((r612 & 67108864) == 0) goto L109;
        TextStyle r217 = TypographyTokens.INSTANCE.getBodySmallEmphasized();
    L111:
        if ((r612 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L113;
        TextStyle r218 = TypographyTokens.INSTANCE.getLabelLargeEmphasized();
    L115:
        if ((r612 & 268435456) == 0) goto L117;
        TextStyle r219 = TypographyTokens.INSTANCE.getLabelMediumEmphasized();
    L119:
        if ((r612 & 536870912) == 0) goto L121;
        TextStyle r109 = TypographyTokens.INSTANCE.getLabelSmallEmphasized();
    L122:
        this(r100, r101, r102, r103, r104, r105, r106, r107, r108, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r109);
        return;
    L121:
        r109 = r611;
        goto L122
    L117:
        r219 = r610;
        goto L119
    L113:
        r218 = r519;
        goto L115
    L109:
        r217 = r518;
        goto L111
    L105:
        r216 = r517;
        goto L107
    L101:
        r215 = r516;
        goto L103
    L97:
        r214 = r515;
        goto L99
    L93:
        r213 = r514;
        goto L95
    L89:
        r212 = r513;
        goto L91
    L85:
        r211 = r512;
        goto L87
    L81:
        r210 = r511;
        goto L83
    L77:
        r119 = r510;
        goto L79
    L73:
        r118 = r419;
        goto L75
    L69:
        r117 = r418;
        goto L71
    L65:
        r116 = r417;
        goto L67
    L61:
        r115 = r416;
        goto L63
    L57:
        r114 = r415;
        goto L59
    L53:
        r113 = r414;
        goto L55
    L49:
        r112 = r413;
        goto L51
    L45:
        r111 = r412;
        goto L47
    L41:
        r110 = r411;
        goto L43
    L37:
        r108 = r410;
        goto L39
    L33:
        r107 = r317;
        goto L35
    L29:
        r106 = r316;
        goto L31
    L25:
        r105 = r315;
        goto L27
    L21:
        r104 = r314;
        goto L23
    L17:
        r103 = r313;
        goto L19
    L13:
        r102 = r312;
        goto L15
    L9:
        r101 = r311;
        goto L11
    L5:
        r100 = r310;
        goto L7
    }

    public static /* synthetic */ Typography copy$material3$default(Typography r110, TextStyle r111, TextStyle r112, TextStyle r210, TextStyle r211, TextStyle r212, TextStyle r213, TextStyle r214, TextStyle r215, TextStyle r216, TextStyle r217, TextStyle r218, TextStyle r219, TextStyle r310, TextStyle r311, TextStyle r312, TextStyle r313, TextStyle r314, TextStyle r315, TextStyle r316, TextStyle r317, TextStyle r318, TextStyle r319, TextStyle r410, TextStyle r411, TextStyle r412, TextStyle r413, TextStyle r414, TextStyle r415, TextStyle r416, TextStyle r417, int r418, Object r419) {
        if ((r418 & 1) == 0) goto L5;
        TextStyle r100 = r110.displayLarge;
    L7:
        if ((r418 & 2) == 0) goto L9;
        TextStyle r101 = r110.displayMedium;
    L11:
        if ((r418 & 4) == 0) goto L13;
        TextStyle r102 = r110.displaySmall;
    L15:
        if ((r418 & 8) == 0) goto L17;
        TextStyle r103 = r110.headlineLarge;
    L19:
        if ((r418 & 16) == 0) goto L21;
        TextStyle r104 = r110.headlineMedium;
    L23:
        if ((r418 & 32) == 0) goto L25;
        TextStyle r105 = r110.headlineSmall;
    L27:
        if ((r418 & 64) == 0) goto L29;
        TextStyle r106 = r110.titleLarge;
    L31:
        if ((r418 & 128) == 0) goto L33;
        TextStyle r107 = r110.titleMedium;
    L35:
        if ((r418 & 256) == 0) goto L37;
        TextStyle r113 = r110.titleSmall;
    L39:
        if ((r418 & 512) == 0) goto L41;
        TextStyle r114 = r110.bodyLarge;
    L43:
        if ((r418 & 1024) == 0) goto L45;
        TextStyle r115 = r110.bodyMedium;
    L47:
        if ((r418 & 2048) == 0) goto L49;
        TextStyle r116 = r110.bodySmall;
    L51:
        if ((r418 & 4096) == 0) goto L53;
        TextStyle r117 = r110.labelLarge;
    L55:
        if ((r418 & 8192) == 0) goto L57;
        TextStyle r118 = r110.labelMedium;
    L58:
        TextStyle r320 = r118;
        if ((r418 & 16384) == 0) goto L61;
        TextStyle r119 = r110.labelSmall;
    L62:
        TextStyle r321 = r119;
        if ((r418 & 32768) == 0) goto L65;
        TextStyle r120 = r110.displayLargeEmphasized;
    L66:
        TextStyle r322 = r120;
        if ((r418 & 65536) == 0) goto L69;
        TextStyle r121 = r110.displayMediumEmphasized;
    L70:
        TextStyle r323 = r121;
        if ((r418 & 131072) == 0) goto L73;
        TextStyle r122 = r110.displaySmallEmphasized;
    L74:
        TextStyle r324 = r122;
        if ((r418 & 262144) == 0) goto L77;
        TextStyle r123 = r110.headlineLargeEmphasized;
    L78:
        TextStyle r325 = r123;
        if ((r418 & 524288) == 0) goto L81;
        TextStyle r124 = r110.headlineMediumEmphasized;
    L82:
        TextStyle r326 = r124;
        if ((r418 & 1048576) == 0) goto L85;
        TextStyle r125 = r110.headlineSmallEmphasized;
    L86:
        TextStyle r327 = r125;
        if ((r418 & 2097152) == 0) goto L89;
        TextStyle r126 = r110.titleLargeEmphasized;
    L90:
        TextStyle r328 = r126;
        if ((r418 & 4194304) == 0) goto L93;
        TextStyle r127 = r110.titleMediumEmphasized;
    L94:
        TextStyle r420 = r127;
        if ((r418 & 8388608) == 0) goto L97;
        TextStyle r128 = r110.titleSmallEmphasized;
    L98:
        TextStyle r421 = r128;
        if ((r418 & 16777216) == 0) goto L101;
        TextStyle r129 = r110.bodyLargeEmphasized;
    L102:
        TextStyle r422 = r129;
        if ((r418 & 33554432) == 0) goto L105;
        TextStyle r130 = r110.bodyMediumEmphasized;
    L106:
        TextStyle r423 = r130;
        if ((r418 & 67108864) == 0) goto L109;
        TextStyle r131 = r110.bodySmallEmphasized;
    L110:
        TextStyle r424 = r131;
        if ((r418 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L113;
        TextStyle r132 = r110.labelLargeEmphasized;
    L114:
        TextStyle r425 = r132;
        if ((r418 & 268435456) == 0) goto L117;
        TextStyle r133 = r110.labelMediumEmphasized;
    L119:
        if ((r418 & 536870912) == 0) goto L121;
        TextStyle r108 = r110.labelSmallEmphasized;
    L123:
        return r110.copy$material3(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r116, r117, r320, r321, r322, r323, r324, r325, r326, r327, r328, r420, r421, r422, r423, r424, r425, r133, r108);
    L121:
        r108 = r417;
        goto L123
    L117:
        r133 = r416;
        goto L119
    L113:
        r132 = r415;
        goto L114
    L109:
        r131 = r414;
        goto L110
    L105:
        r130 = r413;
        goto L106
    L101:
        r129 = r412;
        goto L102
    L97:
        r128 = r411;
        goto L98
    L93:
        r127 = r410;
        goto L94
    L89:
        r126 = r319;
        goto L90
    L85:
        r125 = r318;
        goto L86
    L81:
        r124 = r317;
        goto L82
    L77:
        r123 = r316;
        goto L78
    L73:
        r122 = r315;
        goto L74
    L69:
        r121 = r314;
        goto L70
    L65:
        r120 = r313;
        goto L66
    L61:
        r119 = r312;
        goto L62
    L57:
        r118 = r311;
        goto L58
    L53:
        r117 = r310;
        goto L55
    L49:
        r116 = r219;
        goto L51
    L45:
        r115 = r218;
        goto L47
    L41:
        r114 = r217;
        goto L43
    L37:
        r113 = r216;
        goto L39
    L33:
        r107 = r215;
        goto L35
    L29:
        r106 = r214;
        goto L31
    L25:
        r105 = r213;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }
}
