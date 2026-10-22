package androidx.compose.material.icons.twotone;

import androidx.compose.material.icons.Icons;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.PathBuilder;
import androidx.compose.ui.graphics.vector.VectorKt;
import androidx.compose.ui.unit.Dp;
import com.stepos.statsrpk.service.c;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_star", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Star", "Landroidx/compose/material/icons/Icons$TwoTone;", "getStar", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class StarKt {
    private static ImageVector _star;

    public static final ImageVector getStar(Icons.TwoTone twoTone) {
        ImageVector imageVector = _star;
        if (imageVector != null) {
            k.c(imageVector);
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("TwoTone.Star", Dp.m6844constructorimpl(24.0f), Dp.m6844constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, false, 96, null);
        int defaultFillType = VectorKt.getDefaultFillType();
        Color.Companion companion = Color.INSTANCE;
        SolidColor solidColor = new SolidColor(companion.m4165getBlack0d7_KjU(), null);
        StrokeCap.Companion companion2 = StrokeCap.INSTANCE;
        int iM4508getButtKaPHkGw = companion2.m4508getButtKaPHkGw();
        StrokeJoin.Companion companion3 = StrokeJoin.INSTANCE;
        int iM4518getBevelLxFBmk8 = companion3.m4518getBevelLxFBmk8();
        PathBuilder pathBuilderE = c.e(12.0f, 15.4f, -3.76f, 2.27f);
        pathBuilderE.lineToRelative(1.0f, -4.28f);
        pathBuilderE.lineToRelative(-3.32f, -2.88f);
        pathBuilderE.lineToRelative(4.38f, -0.38f);
        pathBuilderE.lineToRelative(1.7f, -4.03f);
        pathBuilderE.lineToRelative(1.71f, 4.04f);
        pathBuilderE.lineToRelative(4.38f, 0.38f);
        ImageVector.Builder.m4864addPathoIyEayM$default(builder, c.h(pathBuilderE, -3.32f, 2.88f, 1.0f, 4.28f), defaultFillType, "", solidColor, 0.3f, null, 0.3f, 1.0f, iM4508getButtKaPHkGw, iM4518getBevelLxFBmk8, 1.0f, 0.0f, 0.0f, 0.0f, 14336, null);
        int defaultFillType2 = VectorKt.getDefaultFillType();
        SolidColor solidColor2 = new SolidColor(companion.m4165getBlack0d7_KjU(), null);
        int iM4508getButtKaPHkGw2 = companion2.m4508getButtKaPHkGw();
        int iM4518getBevelLxFBmk82 = companion3.m4518getBevelLxFBmk8();
        PathBuilder pathBuilderE2 = c.e(22.0f, 9.24f, -7.19f, -0.62f);
        pathBuilderE2.lineTo(12.0f, 2.0f);
        pathBuilderE2.lineTo(9.19f, 8.63f);
        pathBuilderE2.lineTo(2.0f, 9.24f);
        pathBuilderE2.lineToRelative(5.46f, 4.73f);
        pathBuilderE2.lineTo(5.82f, 21.0f);
        pathBuilderE2.lineTo(12.0f, 17.27f);
        pathBuilderE2.lineTo(18.18f, 21.0f);
        pathBuilderE2.lineToRelative(-1.63f, -7.03f);
        pathBuilderE2.lineTo(22.0f, 9.24f);
        pathBuilderE2.close();
        pathBuilderE2.moveTo(12.0f, 15.4f);
        pathBuilderE2.lineToRelative(-3.76f, 2.27f);
        pathBuilderE2.lineToRelative(1.0f, -4.28f);
        pathBuilderE2.lineToRelative(-3.32f, -2.88f);
        pathBuilderE2.lineToRelative(4.38f, -0.38f);
        pathBuilderE2.lineTo(12.0f, 6.1f);
        pathBuilderE2.lineToRelative(1.71f, 4.04f);
        pathBuilderE2.lineToRelative(4.38f, 0.38f);
        pathBuilderE2.lineToRelative(-3.32f, 2.88f);
        pathBuilderE2.lineToRelative(1.0f, 4.28f);
        pathBuilderE2.lineTo(12.0f, 15.4f);
        pathBuilderE2.close();
        ImageVector imageVectorBuild = ImageVector.Builder.m4864addPathoIyEayM$default(builder, pathBuilderE2.getNodes(), defaultFillType2, "", solidColor2, 1.0f, null, 1.0f, 1.0f, iM4508getButtKaPHkGw2, iM4518getBevelLxFBmk82, 1.0f, 0.0f, 0.0f, 0.0f, 14336, null).build();
        _star = imageVectorBuild;
        k.c(imageVectorBuild);
        return imageVectorBuild;
    }
}
