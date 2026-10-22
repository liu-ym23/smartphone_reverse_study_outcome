package androidx.compose.ui.graphics.shadow;

import android.graphics.BlurMaskFilter;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.PaintingStyle;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aC\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`\b2\b\b\u0002\u0010\t\u001a\u00020\nH\u0000¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"configureShadow", "Landroidx/compose/ui/graphics/Paint;", TypedValues.Custom.S_COLOR, "Landroidx/compose/ui/graphics/Color;", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "blurFilter", "Landroid/graphics/BlurMaskFilter;", "Landroidx/compose/ui/graphics/shadow/BlurFilter;", "style", "Landroidx/compose/ui/graphics/PaintingStyle;", "configureShadow-FoewPVk", "(Landroidx/compose/ui/graphics/Paint;JILandroid/graphics/BlurMaskFilter;I)Landroidx/compose/ui/graphics/Paint;", "ui-graphics_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class BlurKt {
    /* renamed from: configureShadow-FoewPVk, reason: not valid java name */
    public static final Paint m4841configureShadowFoewPVk(Paint paint, long j5, int i, BlurMaskFilter blurMaskFilter, int i6) {
        paint.mo4016setColor8_81llA(j5);
        paint.mo4015setBlendModes9anfk8(i);
        paint.mo4020setStylek9PVt8s(i6);
        Blur_androidKt.setBlurFilter(paint, blurMaskFilter);
        return paint;
    }

    /* renamed from: configureShadow-FoewPVk$default, reason: not valid java name */
    public static /* synthetic */ Paint m4842configureShadowFoewPVk$default(Paint paint, long j5, int i, BlurMaskFilter blurMaskFilter, int i6, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j5 = Color.INSTANCE.m4165getBlack0d7_KjU();
        }
        long j6 = j5;
        if ((i10 & 2) != 0) {
            i = BlendMode.INSTANCE.m4080getSrcOver0nO6VwU();
        }
        int i11 = i;
        if ((i10 & 4) != 0) {
            blurMaskFilter = null;
        }
        BlurMaskFilter blurMaskFilter2 = blurMaskFilter;
        if ((i10 & 8) != 0) {
            i6 = PaintingStyle.INSTANCE.m4417getFillTiuSbCo();
        }
        return m4841configureShadowFoewPVk(paint, j6, i11, blurMaskFilter2, i6);
    }
}
