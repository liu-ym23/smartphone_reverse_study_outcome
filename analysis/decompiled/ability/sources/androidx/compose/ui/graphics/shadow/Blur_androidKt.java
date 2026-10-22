package androidx.compose.ui.graphics.shadow;

import android.graphics.BlurMaskFilter;
import androidx.compose.ui.graphics.Paint;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001b\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a#\u0010\t\u001a\u00020\b*\u00020\u00062\u000e\u0010\u0007\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003H\u0000¢\u0006\u0004\b\t\u0010\n*\f\b\u0000\u0010\u0004\"\u00020\u00022\u00020\u0002¨\u0006\u000b"}, d2 = {"", "radius", "Landroid/graphics/BlurMaskFilter;", "Landroidx/compose/ui/graphics/shadow/BlurFilter;", "BlurFilter", "(F)Landroid/graphics/BlurMaskFilter;", "Landroidx/compose/ui/graphics/Paint;", "blur", "LC7/r;", "setBlurFilter", "(Landroidx/compose/ui/graphics/Paint;Landroid/graphics/BlurMaskFilter;)V", "ui-graphics_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Blur_androidKt {
    public static final BlurMaskFilter BlurFilter(float f) {
        return new BlurMaskFilter(f, BlurMaskFilter.Blur.NORMAL);
    }

    public static final void setBlurFilter(Paint paint, BlurMaskFilter blurMaskFilter) {
        paint.asFrameworkPaint().setMaskFilter(blurMaskFilter);
    }
}
