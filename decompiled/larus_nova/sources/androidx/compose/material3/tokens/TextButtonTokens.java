package androidx.compose.material3.tokens;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u001b\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007R\u0014\u0010\u000e\u001a\u00020\tX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0010\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0007R\u0014\u0010\u0012\u001a\u00020\tX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000bR\u0011\u0010\u0014\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0007R\u0011\u0010\u0016\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0007R\u0011\u0010\u0018\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0007R\u0011\u0010\u001a\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0007R\u0011\u0010\u001c\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0007R\u0011\u0010\u001e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0007R\u0011\u0010 \u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0007R\u0011\u0010\"\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0007¨\u0006$"}, d2 = {"Landroidx/compose/material3/tokens/TextButtonTokens;", "", "<init>", "()V", "DisabledContainerColor", "Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "getDisabledContainerColor", "()Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "DisabledContainerOpacity", "", "getDisabledContainerOpacity", "()F", "DisabledIconColor", "getDisabledIconColor", "DisabledIconOpacity", "getDisabledIconOpacity", "DisabledLabelColor", "getDisabledLabelColor", "DisabledLabelOpacity", "getDisabledLabelOpacity", "FocusedIconColor", "getFocusedIconColor", "FocusedLabelColor", "getFocusedLabelColor", "HoveredIconColor", "getHoveredIconColor", "HoveredLabelColor", "getHoveredLabelColor", "IconColor", "getIconColor", "LabelColor", "getLabelColor", "PressedIconColor", "getPressedIconColor", "PressedLabelColor", "getPressedLabelColor", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TextButtonTokens {
    public static final int $stable = 0;
    private static final ColorSchemeKeyTokens DisabledContainerColor = null;
    private static final float DisabledContainerOpacity = 0.0f;
    private static final ColorSchemeKeyTokens DisabledIconColor = null;
    private static final float DisabledIconOpacity = 0.0f;
    private static final ColorSchemeKeyTokens DisabledLabelColor = null;
    private static final float DisabledLabelOpacity = 0.0f;
    private static final ColorSchemeKeyTokens FocusedIconColor = null;
    private static final ColorSchemeKeyTokens FocusedLabelColor = null;
    private static final ColorSchemeKeyTokens HoveredIconColor = null;
    private static final ColorSchemeKeyTokens HoveredLabelColor = null;
    public static final TextButtonTokens INSTANCE = null;
    private static final ColorSchemeKeyTokens IconColor = null;
    private static final ColorSchemeKeyTokens LabelColor = null;
    private static final ColorSchemeKeyTokens PressedIconColor = null;
    private static final ColorSchemeKeyTokens PressedLabelColor = null;

    private TextButtonTokens() {
    }

    static {
        INSTANCE = new TextButtonTokens();
        DisabledContainerColor = ColorSchemeKeyTokens.OnSurface;
        DisabledContainerOpacity = 0.1f;
        ColorSchemeKeyTokens r100 = ColorSchemeKeyTokens.OnSurfaceVariant;
        DisabledIconColor = r100;
        DisabledIconOpacity = 0.38f;
        DisabledLabelColor = r100;
        DisabledLabelOpacity = 0.38f;
        FocusedIconColor = r100;
        FocusedLabelColor = r100;
        HoveredIconColor = r100;
        HoveredLabelColor = r100;
        IconColor = r100;
        LabelColor = r100;
        PressedIconColor = r100;
        PressedLabelColor = r100;
    }

    public final ColorSchemeKeyTokens getDisabledContainerColor() {
        return DisabledContainerColor;
    }

    public final float getDisabledContainerOpacity() {
        return DisabledContainerOpacity;
    }

    public final ColorSchemeKeyTokens getDisabledIconColor() {
        return DisabledIconColor;
    }

    public final float getDisabledIconOpacity() {
        return DisabledIconOpacity;
    }

    public final ColorSchemeKeyTokens getDisabledLabelColor() {
        return DisabledLabelColor;
    }

    public final float getDisabledLabelOpacity() {
        return DisabledLabelOpacity;
    }

    public final ColorSchemeKeyTokens getFocusedIconColor() {
        return FocusedIconColor;
    }

    public final ColorSchemeKeyTokens getFocusedLabelColor() {
        return FocusedLabelColor;
    }

    public final ColorSchemeKeyTokens getHoveredIconColor() {
        return HoveredIconColor;
    }

    public final ColorSchemeKeyTokens getHoveredLabelColor() {
        return HoveredLabelColor;
    }

    public final ColorSchemeKeyTokens getIconColor() {
        return IconColor;
    }

    public final ColorSchemeKeyTokens getLabelColor() {
        return LabelColor;
    }

    public final ColorSchemeKeyTokens getPressedIconColor() {
        return PressedIconColor;
    }

    public final ColorSchemeKeyTokens getPressedLabelColor() {
        return PressedLabelColor;
    }
}
