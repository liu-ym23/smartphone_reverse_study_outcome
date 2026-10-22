package androidx.compose.material.internal;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.PathBuilder;
import androidx.compose.ui.graphics.vector.VectorKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u0007H\u0082\b\u001aK\u0010\b\u001a\u00020\u0006*\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\r2\u0017\u0010\u000e\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u0005¢\u0006\u0002\b\u0007H\u0082\b¢\u0006\u0004\b\u0011\u0010\u0012\"\u000e\u0010\u0013\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"materialIcon", "Landroidx/compose/ui/graphics/vector/ImageVector;", "name", "", "block", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/vector/ImageVector$Builder;", "Lkotlin/ExtensionFunctionType;", "materialPath", "fillAlpha", "", "strokeAlpha", "pathFillType", "Landroidx/compose/ui/graphics/PathFillType;", "pathBuilder", "Landroidx/compose/ui/graphics/vector/PathBuilder;", "", "materialPath-YwgOQQI", "(Landroidx/compose/ui/graphics/vector/ImageVector$Builder;FFILkotlin/jvm/functions/Function1;)Landroidx/compose/ui/graphics/vector/ImageVector$Builder;", "MaterialIconDimension", "material"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class IconsKt {
    private static final float MaterialIconDimension = 24.0f;

    private static final ImageVector materialIcon(String r110, Function1<? super ImageVector.Builder, ImageVector.Builder> r111) {
        return r111.invoke(new ImageVector.Builder(r110, Dp.m7544constructorimpl(24.0f), Dp.m7544constructorimpl(24.0f), 24.0f, 24.0f, 0, 0, false, 224, null)).build();
    }

    /* JADX INFO: renamed from: materialPath-YwgOQQI, reason: not valid java name */
    private static final ImageVector.Builder m1806materialPathYwgOQQI(ImageVector.Builder r110, float r111, float r112, int r210, Function1<? super PathBuilder, Unit> r211) {
        SolidColor r100 = new SolidColor(Color.Companion.m4853getBlack0d7_KjU(), null);
        int r101 = StrokeCap.Companion.m5206getButtKaPHkGw();
        int r113 = StrokeJoin.Companion.m5216getBevelLxFBmk8();
        PathBuilder r102 = new PathBuilder();
        r211.invoke(r102);
        return ImageVector.Builder.m5567addPathoIyEayM$default(r110, r102.getNodes(), r210, "", r100, r111, null, r112, 1.0f, r101, r113, 1.0f, 0.0f, 0.0f, 0.0f, 14336, null);
    }

    /* JADX INFO: renamed from: materialPath-YwgOQQI$default, reason: not valid java name */
    public static /* synthetic */ ImageVector.Builder m1807materialPathYwgOQQI$default(ImageVector.Builder r110, float r210, float r211, int r212, Function1 r213, int r214, Object r215) {
        if ((r214 & 1) == 0) goto L5;
        float r100 = 1.0f;
    L7:
        if ((r214 & 2) == 0) goto L9;
        float r101 = 1.0f;
    L11:
        if ((r214 & 4) == 0) goto L13;
        int r102 = VectorKt.getDefaultFillType();
    L14:
        SolidColor r103 = new SolidColor(Color.Companion.m4853getBlack0d7_KjU(), null);
        int r111 = StrokeCap.Companion.m5206getButtKaPHkGw();
        int r112 = StrokeJoin.Companion.m5216getBevelLxFBmk8();
        PathBuilder r104 = new PathBuilder();
        r213.invoke(r104);
        return ImageVector.Builder.m5567addPathoIyEayM$default(r110, r104.getNodes(), r102, "", r103, r100, null, r101, 1.0f, r111, r112, 1.0f, 0.0f, 0.0f, 0.0f, 14336, null);
    L13:
        r102 = r212;
        goto L14
    L9:
        r101 = r211;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }
}
