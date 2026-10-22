package androidx.compose.ui.draw;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0007\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0000\u001a\u00020\u0003H\u0007¨\u0006\u0005"}, d2 = {"scale", "Landroidx/compose/ui/Modifier;", LiveDegradeFpsAnimator.SCALE_X, "", LiveDegradeFpsAnimator.SCALE_Y, "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ScaleKt {
    public static final Modifier scale(Modifier r100, float r101) {
        return scale(r100, r101, r101);
    }

    public static final Modifier scale(Modifier r210, float r211, float r310) {
        boolean r100 = true;
        if (r211 != 1.0f) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L15;
        if (r310 == 1.0f) goto L11;
        r100 = false;
    L11:
        if (r100 == false) goto L15;
        return r210;
    L15:
        return GraphicsLayerModifierKt.m4992graphicsLayer_6ThJ44$default(r210, r211, r310, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0, null, false, null, 0, 0, 0, 0, null, 524284, null);
    L5:
        r101 = false;
        goto L6
    }
}
