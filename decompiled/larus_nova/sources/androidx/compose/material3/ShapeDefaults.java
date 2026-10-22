package androidx.compose.material3;

import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.foundation.shape.CornerSize;
import androidx.compose.foundation.shape.CornerSizeKt;
import androidx.compose.material3.tokens.ShapeTokens;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0015\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007R\u0014\u0010\u000e\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0007R\u0011\u0010\u0010\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0007R\u0014\u0010\u0012\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0007R\u0014\u0010\u0014\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0007R\u0014\u0010\u0016\u001a\u00020\u0017X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u0017X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\u0017X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0019R\u0014\u0010\u001e\u001a\u00020\u0017X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0019R\u0014\u0010 \u001a\u00020\u0017X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0019R\u0014\u0010\"\u001a\u00020\u0017X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0019R\u0014\u0010$\u001a\u00020\u0017X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0019R\u0014\u0010&\u001a\u00020\u0017X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0019R\u0014\u0010(\u001a\u00020\u0017X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0019R\u0014\u0010*\u001a\u00020\u0017X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0019¨\u0006,"}, d2 = {"Landroidx/compose/material3/ShapeDefaults;", "", "<init>", "()V", "ExtraSmall", "Landroidx/compose/foundation/shape/CornerBasedShape;", "getExtraSmall", "()Landroidx/compose/foundation/shape/CornerBasedShape;", "Small", "getSmall", "Medium", "getMedium", "Large", "getLarge", "LargeIncreased", "getLargeIncreased$material3", "ExtraLarge", "getExtraLarge", "ExtraLargeIncreased", "getExtraLargeIncreased$material3", "ExtraExtraLarge", "getExtraExtraLarge$material3", "CornerNone", "Landroidx/compose/foundation/shape/CornerSize;", "getCornerNone$material3", "()Landroidx/compose/foundation/shape/CornerSize;", "CornerExtraSmall", "getCornerExtraSmall$material3", "CornerSmall", "getCornerSmall$material3", "CornerMedium", "getCornerMedium$material3", "CornerLarge", "getCornerLarge$material3", "CornerLargeIncreased", "getCornerLargeIncreased$material3", "CornerExtraLarge", "getCornerExtraLarge$material3", "CornerExtraLargeIncreased", "getCornerExtraLargeIncreased$material3", "CornerExtraExtraLarge", "getCornerExtraExtraLarge$material3", "CornerFull", "getCornerFull$material3", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ShapeDefaults {
    public static final int $stable = 0;
    private static final CornerSize CornerExtraExtraLarge = null;
    private static final CornerSize CornerExtraLarge = null;
    private static final CornerSize CornerExtraLargeIncreased = null;
    private static final CornerSize CornerExtraSmall = null;
    private static final CornerSize CornerFull = null;
    private static final CornerSize CornerLarge = null;
    private static final CornerSize CornerLargeIncreased = null;
    private static final CornerSize CornerMedium = null;
    private static final CornerSize CornerNone = null;
    private static final CornerSize CornerSmall = null;
    private static final CornerBasedShape ExtraExtraLarge = null;
    private static final CornerBasedShape ExtraLarge = null;
    private static final CornerBasedShape ExtraLargeIncreased = null;
    private static final CornerBasedShape ExtraSmall = null;
    public static final ShapeDefaults INSTANCE = null;
    private static final CornerBasedShape Large = null;
    private static final CornerBasedShape LargeIncreased = null;
    private static final CornerBasedShape Medium = null;
    private static final CornerBasedShape Small = null;

    private ShapeDefaults() {
    }

    static {
        INSTANCE = new ShapeDefaults();
        ShapeTokens r100 = ShapeTokens.INSTANCE;
        ExtraSmall = r100.getCornerExtraSmall();
        Small = r100.getCornerSmall();
        Medium = r100.getCornerMedium();
        Large = r100.getCornerLarge();
        LargeIncreased = r100.getCornerLargeIncreased();
        ExtraLarge = r100.getCornerExtraLarge();
        ExtraLargeIncreased = r100.getCornerExtraLargeIncreased();
        ExtraExtraLarge = r100.getCornerExtraExtraLarge();
        CornerNone = r100.getCornerValueNone();
        CornerExtraSmall = r100.getCornerValueExtraSmall();
        CornerSmall = r100.getCornerValueSmall();
        CornerMedium = r100.getCornerValueMedium();
        CornerLarge = r100.getCornerValueLarge();
        CornerLargeIncreased = r100.getCornerValueLargeIncreased();
        CornerExtraLarge = r100.getCornerValueExtraLarge();
        CornerExtraLargeIncreased = r100.getCornerValueExtraLargeIncreased();
        CornerExtraExtraLarge = r100.getCornerValueExtraExtraLarge();
        CornerFull = CornerSizeKt.CornerSize(100);
    }

    public final CornerSize getCornerExtraExtraLarge$material3() {
        return CornerExtraExtraLarge;
    }

    public final CornerSize getCornerExtraLarge$material3() {
        return CornerExtraLarge;
    }

    public final CornerSize getCornerExtraLargeIncreased$material3() {
        return CornerExtraLargeIncreased;
    }

    public final CornerSize getCornerExtraSmall$material3() {
        return CornerExtraSmall;
    }

    public final CornerSize getCornerFull$material3() {
        return CornerFull;
    }

    public final CornerSize getCornerLarge$material3() {
        return CornerLarge;
    }

    public final CornerSize getCornerLargeIncreased$material3() {
        return CornerLargeIncreased;
    }

    public final CornerSize getCornerMedium$material3() {
        return CornerMedium;
    }

    public final CornerSize getCornerNone$material3() {
        return CornerNone;
    }

    public final CornerSize getCornerSmall$material3() {
        return CornerSmall;
    }

    public final CornerBasedShape getExtraExtraLarge$material3() {
        return ExtraExtraLarge;
    }

    public final CornerBasedShape getExtraLarge() {
        return ExtraLarge;
    }

    public final CornerBasedShape getExtraLargeIncreased$material3() {
        return ExtraLargeIncreased;
    }

    public final CornerBasedShape getExtraSmall() {
        return ExtraSmall;
    }

    public final CornerBasedShape getLarge() {
        return Large;
    }

    public final CornerBasedShape getLargeIncreased$material3() {
        return LargeIncreased;
    }

    public final CornerBasedShape getMedium() {
        return Medium;
    }

    public final CornerBasedShape getSmall() {
        return Small;
    }
}
