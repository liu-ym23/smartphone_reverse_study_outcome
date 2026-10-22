package androidx.compose.ui.graphics.shadow;

import android.graphics.BlurMaskFilter;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.PaintingStyle;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aC\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`\b2\b\b\u0002\u0010\t\u001a\u00020\nH\u0000¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"configureShadow", "Landroidx/compose/ui/graphics/Paint;", "color", "Landroidx/compose/ui/graphics/Color;", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "blurFilter", "Landroid/graphics/BlurMaskFilter;", "Landroidx/compose/ui/graphics/shadow/BlurFilter;", "style", "Landroidx/compose/ui/graphics/PaintingStyle;", "configureShadow-FoewPVk", "(Landroidx/compose/ui/graphics/Paint;JILandroid/graphics/BlurMaskFilter;I)Landroidx/compose/ui/graphics/Paint;", "ui-graphics_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class BlurKt {
    /* JADX INFO: renamed from: configureShadow-FoewPVk, reason: not valid java name */
    public static final Paint m5544configureShadowFoewPVk(Paint r100, long r101, int r102, BlurMaskFilter r103, int r104) {
        r100.mo4704setColor8_81llA(r101);
        r100.mo4703setBlendModes9anfk8(r102);
        r100.mo4708setStylek9PVt8s(r104);
        Blur_androidKt.setBlurFilter(r100, r103);
        return r100;
    }

    /* JADX INFO: renamed from: configureShadow-FoewPVk$default, reason: not valid java name */
    public static /* synthetic */ Paint m5545configureShadowFoewPVk$default(Paint r100, long r101, int r102, BlurMaskFilter r110, int r111, int r112, Object r113) {
        if ((r112 & 1) == 0) goto L5;
        r101 = Color.Companion.m4853getBlack0d7_KjU();
    L5:
        long r103 = r101;
        if ((r112 & 2) == 0) goto L8;
        r102 = BlendMode.Companion.m4768getSrcOver0nO6VwU();
    L8:
        int r104 = r102;
        if ((r112 & 4) == 0) goto L11;
        r110 = null;
    L11:
        BlurMaskFilter r105 = r110;
        if ((r112 & 8) == 0) goto L15;
        r111 = PaintingStyle.Companion.m5114getFillTiuSbCo();
    L15:
        return m5544configureShadowFoewPVk(r100, r103, r104, r105, r111);
    }
}
