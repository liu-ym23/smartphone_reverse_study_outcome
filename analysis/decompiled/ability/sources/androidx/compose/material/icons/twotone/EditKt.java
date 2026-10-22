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

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_edit", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Edit", "Landroidx/compose/material/icons/Icons$TwoTone;", "getEdit", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class EditKt {
    private static ImageVector _edit;

    public static final ImageVector getEdit(Icons.TwoTone twoTone) {
        ImageVector imageVector = _edit;
        if (imageVector != null) {
            k.c(imageVector);
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("TwoTone.Edit", Dp.m6844constructorimpl(24.0f), Dp.m6844constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, false, 96, null);
        int defaultFillType = VectorKt.getDefaultFillType();
        Color.Companion companion = Color.INSTANCE;
        SolidColor solidColor = new SolidColor(companion.m4165getBlack0d7_KjU(), null);
        StrokeCap.Companion companion2 = StrokeCap.INSTANCE;
        int iM4508getButtKaPHkGw = companion2.m4508getButtKaPHkGw();
        StrokeJoin.Companion companion3 = StrokeJoin.INSTANCE;
        int iM4518getBevelLxFBmk8 = companion3.m4518getBevelLxFBmk8();
        PathBuilder pathBuilder = new PathBuilder();
        pathBuilder.moveTo(5.0f, 18.08f);
        pathBuilder.verticalLineTo(19.0f);
        pathBuilder.horizontalLineToRelative(0.92f);
        ImageVector.Builder.m4864addPathoIyEayM$default(builder, c.h(pathBuilder, 9.06f, -9.06f, -0.92f, -0.92f), defaultFillType, "", solidColor, 0.3f, null, 0.3f, 1.0f, iM4508getButtKaPHkGw, iM4518getBevelLxFBmk8, 1.0f, 0.0f, 0.0f, 0.0f, 14336, null);
        int defaultFillType2 = VectorKt.getDefaultFillType();
        SolidColor solidColor2 = new SolidColor(companion.m4165getBlack0d7_KjU(), null);
        int iM4508getButtKaPHkGw2 = companion2.m4508getButtKaPHkGw();
        int iM4518getBevelLxFBmk82 = companion3.m4518getBevelLxFBmk8();
        PathBuilder pathBuilderD = c.d(20.71f, 7.04f);
        pathBuilderD.curveToRelative(0.39f, -0.39f, 0.39f, -1.02f, 0.0f, -1.41f);
        pathBuilderD.lineToRelative(-2.34f, -2.34f);
        pathBuilderD.curveToRelative(-0.2f, -0.2f, -0.45f, -0.29f, -0.71f, -0.29f);
        pathBuilderD.reflectiveCurveToRelative(-0.51f, 0.1f, -0.7f, 0.29f);
        pathBuilderD.lineToRelative(-1.83f, 1.83f);
        pathBuilderD.lineToRelative(3.75f, 3.75f);
        pathBuilderD.lineToRelative(1.83f, -1.83f);
        pathBuilderD.close();
        pathBuilderD.moveTo(3.0f, 17.25f);
        pathBuilderD.verticalLineTo(21.0f);
        pathBuilderD.horizontalLineToRelative(3.75f);
        pathBuilderD.lineTo(17.81f, 9.94f);
        pathBuilderD.lineToRelative(-3.75f, -3.75f);
        pathBuilderD.lineTo(3.0f, 17.25f);
        pathBuilderD.close();
        pathBuilderD.moveTo(5.92f, 19.0f);
        pathBuilderD.horizontalLineTo(5.0f);
        pathBuilderD.verticalLineToRelative(-0.92f);
        pathBuilderD.lineToRelative(9.06f, -9.06f);
        pathBuilderD.lineToRelative(0.92f, 0.92f);
        pathBuilderD.lineTo(5.92f, 19.0f);
        pathBuilderD.close();
        ImageVector imageVectorBuild = ImageVector.Builder.m4864addPathoIyEayM$default(builder, pathBuilderD.getNodes(), defaultFillType2, "", solidColor2, 1.0f, null, 1.0f, 1.0f, iM4508getButtKaPHkGw2, iM4518getBevelLxFBmk82, 1.0f, 0.0f, 0.0f, 0.0f, 14336, null).build();
        _edit = imageVectorBuild;
        k.c(imageVectorBuild);
        return imageVectorBuild;
    }
}
