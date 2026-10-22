package androidx.compose.foundation.text.selection;

import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u0017\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\"\u0010\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007\"\u0016\u0010\b\u001a\u00020\u00028\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"LocalTextSelectionColors", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/foundation/text/selection/TextSelectionColors;", "getLocalTextSelectionColors", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "DefaultSelectionColor", "Landroidx/compose/ui/graphics/Color;", "J", "DefaultTextSelectionColors", "getDefaultTextSelectionColors$annotations", "()V", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TextSelectionColorsKt {
    private static final long DefaultSelectionColor = 0;
    private static final TextSelectionColors DefaultTextSelectionColors = null;
    private static final ProvidableCompositionLocal<TextSelectionColors> LocalTextSelectionColors = null;

    public static /* synthetic */ TextSelectionColors a() {
        return LocalTextSelectionColors$lambda$0();
    }

    private static /* synthetic */ void getDefaultTextSelectionColors$annotations() {
    }

    static {
        LocalTextSelectionColors = CompositionLocalKt.compositionLocalOf$default(null, new w2(), 1, null);
        long r100 = ColorKt.Color(4282550004L);
        DefaultSelectionColor = r100;
        DefaultTextSelectionColors = new TextSelectionColors(r100, Color.m4826copywmQWz5c$default(r100, 0.4f, 0.0f, 0.0f, 0.0f, 14, null), null);
    }

    private static final TextSelectionColors LocalTextSelectionColors$lambda$0() {
        return DefaultTextSelectionColors;
    }

    public static final ProvidableCompositionLocal<TextSelectionColors> getLocalTextSelectionColors() {
        return LocalTextSelectionColors;
    }
}
