package androidx.compose.ui.graphics;

import android.graphics.Rect;
import android.graphics.RectF;
import androidx.compose.ui.unit.IntRect;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0007\u001a\n\u0010\u0003\u001a\u00020\u0004*\u00020\u0002\u001a\n\u0010\u0005\u001a\u00020\u0002*\u00020\u0001\u001a\n\u0010\u0005\u001a\u00020\u0002*\u00020\u0004\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0006\u001a\n\u0010\u0007\u001a\u00020\u0006*\u00020\u0001¨\u0006\b"}, d2 = {"toAndroidRect", "Landroid/graphics/Rect;", "Landroidx/compose/ui/geometry/Rect;", "toAndroidRectF", "Landroid/graphics/RectF;", "toComposeRect", "Landroidx/compose/ui/unit/IntRect;", "toComposeIntRect", "ui-graphics_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class RectHelper_androidKt {
    @Deprecated(message = "Converting Rect to android.graphics.Rect is lossy, and requires rounding. The behavior of toAndroidRect() truncates to an integral Rect, but you should choose the method of rounding most suitable for your use case.", replaceWith = @ReplaceWith(expression = "android.graphics.Rect(left.toInt(), top.toInt(), right.toInt(), bottom.toInt())", imports = {}))
    public static final Rect toAndroidRect(androidx.compose.ui.geometry.Rect r100) {
        return new Rect((int) r100.getLeft(), (int) r100.getTop(), (int) r100.getRight(), (int) r100.getBottom());
    }

    public static final RectF toAndroidRectF(androidx.compose.ui.geometry.Rect r100) {
        return new RectF(r100.getLeft(), r100.getTop(), r100.getRight(), r100.getBottom());
    }

    public static final IntRect toComposeIntRect(Rect r100) {
        return new IntRect(r100.left, r100.top, r100.right, r100.bottom);
    }

    public static final androidx.compose.ui.geometry.Rect toComposeRect(Rect r100) {
        return new androidx.compose.ui.geometry.Rect(r100.left, r100.top, r100.right, r100.bottom);
    }

    public static final Rect toAndroidRect(IntRect r100) {
        return new Rect(r100.getLeft(), r100.getTop(), r100.getRight(), r100.getBottom());
    }

    public static final androidx.compose.ui.geometry.Rect toComposeRect(RectF r100) {
        return new androidx.compose.ui.geometry.Rect(r100.left, r100.top, r100.right, r100.bottom);
    }
}
