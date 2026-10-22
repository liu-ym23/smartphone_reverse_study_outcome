package androidx.compose.material3.tokens;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007R\u0011\u0010\u000e\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0010\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0007R\u0011\u0010\u0012\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000b¨\u0006\u0014"}, d2 = {"Landroidx/compose/material3/tokens/ProgressIndicatorTokens;", "", "<init>", "()V", "ActiveIndicatorColor", "Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "getActiveIndicatorColor", "()Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "ActiveShape", "Landroidx/compose/material3/tokens/ShapeKeyTokens;", "getActiveShape", "()Landroidx/compose/material3/tokens/ShapeKeyTokens;", "StopColor", "getStopColor", "StopShape", "getStopShape", "TrackColor", "getTrackColor", "TrackShape", "getTrackShape", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ProgressIndicatorTokens {
    public static final int $stable = 0;
    private static final ColorSchemeKeyTokens ActiveIndicatorColor = null;
    private static final ShapeKeyTokens ActiveShape = null;
    public static final ProgressIndicatorTokens INSTANCE = null;
    private static final ColorSchemeKeyTokens StopColor = null;
    private static final ShapeKeyTokens StopShape = null;
    private static final ColorSchemeKeyTokens TrackColor = null;
    private static final ShapeKeyTokens TrackShape = null;

    private ProgressIndicatorTokens() {
    }

    static {
        INSTANCE = new ProgressIndicatorTokens();
        ColorSchemeKeyTokens r100 = ColorSchemeKeyTokens.Primary;
        ActiveIndicatorColor = r100;
        ShapeKeyTokens r101 = ShapeKeyTokens.CornerFull;
        ActiveShape = r101;
        StopColor = r100;
        StopShape = r101;
        TrackColor = ColorSchemeKeyTokens.SecondaryContainer;
        TrackShape = r101;
    }

    public final ColorSchemeKeyTokens getActiveIndicatorColor() {
        return ActiveIndicatorColor;
    }

    public final ShapeKeyTokens getActiveShape() {
        return ActiveShape;
    }

    public final ColorSchemeKeyTokens getStopColor() {
        return StopColor;
    }

    public final ShapeKeyTokens getStopShape() {
        return StopShape;
    }

    public final ColorSchemeKeyTokens getTrackColor() {
        return TrackColor;
    }

    public final ShapeKeyTokens getTrackShape() {
        return TrackShape;
    }
}
