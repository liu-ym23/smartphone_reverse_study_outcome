package androidx.compose.ui;

import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002¨\u0006\b"}, d2 = {"preferredFrameRate", "Landroidx/compose/ui/Modifier;", "frameRate", "", "frameRateCategory", "Landroidx/compose/ui/FrameRateCategory;", "preferredFrameRate-kI47g10", "(Landroidx/compose/ui/Modifier;F)Landroidx/compose/ui/Modifier;", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class FrameRateKt {
    private static final Modifier frameRate(Modifier r100, float r101) {
        return r100.then(new FrameRateElement(r101));
    }

    public static final Modifier preferredFrameRate(Modifier r210, float r211) {
        if (ComposeUiFlags.isAdaptiveRefreshRateEnabled == false) goto L6;
        return frameRate(GraphicsLayerModifierKt.m4992graphicsLayer_6ThJ44$default(r210, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, false, null, 0, 0, 0, 0, null, 524287, null), r211);
    L6:
        return r210;
    }

    /* JADX INFO: renamed from: preferredFrameRate-kI47g10, reason: not valid java name */
    public static final Modifier m4316preferredFrameRatekI47g10(Modifier r210, float r211) {
        if (ComposeUiFlags.isAdaptiveRefreshRateEnabled == false) goto L6;
        return frameRate(GraphicsLayerModifierKt.m4992graphicsLayer_6ThJ44$default(r210, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, false, null, 0, 0, 0, 0, null, 524287, null), r211);
    L6:
        return r210;
    }
}
