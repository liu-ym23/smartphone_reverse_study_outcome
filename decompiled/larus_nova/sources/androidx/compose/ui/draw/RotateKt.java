package androidx.compose.ui.draw;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007¨\u0006\u0004"}, d2 = {"rotate", "Landroidx/compose/ui/Modifier;", "degrees", "", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class RotateKt {
    public static final Modifier rotate(Modifier r210, float r211) {
        if (r211 != 0.0f) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == true) goto L9;
        return GraphicsLayerModifierKt.m4992graphicsLayer_6ThJ44$default(r210, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, r211, 0.0f, 0, null, false, null, 0, 0, 0, 0, null, 524031, null);
    L9:
        return r210;
    L5:
        r100 = false;
        goto L6
    }
}
