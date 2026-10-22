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

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u001e\u0010\u0002\u001a\u00020\u0001*\u00020\u00038FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"_exitToApp", "Landroidx/compose/ui/graphics/vector/ImageVector;", "ExitToApp", "Landroidx/compose/material/icons/Icons$TwoTone;", "getExitToApp$annotations", "(Landroidx/compose/material/icons/Icons$TwoTone;)V", "getExitToApp", "(Landroidx/compose/material/icons/Icons$TwoTone;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ExitToAppKt {
    private static ImageVector _exitToApp;

    public static final ImageVector getExitToApp(Icons.TwoTone twoTone) {
        ImageVector imageVector = _exitToApp;
        if (imageVector != null) {
            k.c(imageVector);
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("TwoTone.ExitToApp", Dp.m6844constructorimpl(24.0f), Dp.m6844constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, false, 96, null);
        int defaultFillType = VectorKt.getDefaultFillType();
        SolidColor solidColor = new SolidColor(Color.INSTANCE.m4165getBlack0d7_KjU(), null);
        int iM4508getButtKaPHkGw = StrokeCap.INSTANCE.m4508getButtKaPHkGw();
        int iM4518getBevelLxFBmk8 = StrokeJoin.INSTANCE.m4518getBevelLxFBmk8();
        PathBuilder pathBuilderU = c.u(10.09f, 15.59f, 11.5f, 17.0f);
        pathBuilderU.lineToRelative(5.0f, -5.0f);
        pathBuilderU.lineToRelative(-5.0f, -5.0f);
        pathBuilderU.lineToRelative(-1.41f, 1.41f);
        pathBuilderU.lineTo(12.67f, 11.0f);
        pathBuilderU.horizontalLineTo(3.0f);
        pathBuilderU.verticalLineToRelative(2.0f);
        pathBuilderU.horizontalLineToRelative(9.67f);
        pathBuilderU.lineToRelative(-2.58f, 2.59f);
        pathBuilderU.close();
        pathBuilderU.moveTo(19.0f, 3.0f);
        pathBuilderU.horizontalLineTo(5.0f);
        pathBuilderU.curveToRelative(-1.11f, 0.0f, -2.0f, 0.9f, -2.0f, 2.0f);
        pathBuilderU.verticalLineToRelative(4.0f);
        pathBuilderU.horizontalLineToRelative(2.0f);
        pathBuilderU.verticalLineTo(5.0f);
        pathBuilderU.horizontalLineToRelative(14.0f);
        pathBuilderU.verticalLineToRelative(14.0f);
        pathBuilderU.horizontalLineTo(5.0f);
        pathBuilderU.verticalLineToRelative(-4.0f);
        pathBuilderU.horizontalLineTo(3.0f);
        pathBuilderU.verticalLineToRelative(4.0f);
        pathBuilderU.curveToRelative(0.0f, 1.1f, 0.89f, 2.0f, 2.0f, 2.0f);
        pathBuilderU.horizontalLineToRelative(14.0f);
        pathBuilderU.curveToRelative(1.1f, 0.0f, 2.0f, -0.9f, 2.0f, -2.0f);
        pathBuilderU.verticalLineTo(5.0f);
        pathBuilderU.curveToRelative(0.0f, -1.1f, -0.9f, -2.0f, -2.0f, -2.0f);
        pathBuilderU.close();
        ImageVector imageVectorBuild = ImageVector.Builder.m4864addPathoIyEayM$default(builder, pathBuilderU.getNodes(), defaultFillType, "", solidColor, 1.0f, null, 1.0f, 1.0f, iM4508getButtKaPHkGw, iM4518getBevelLxFBmk8, 1.0f, 0.0f, 0.0f, 0.0f, 14336, null).build();
        _exitToApp = imageVectorBuild;
        k.c(imageVectorBuild);
        return imageVectorBuild;
    }

    @C7.c
    public static /* synthetic */ void getExitToApp$annotations(Icons.TwoTone twoTone) {
    }
}
