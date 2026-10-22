package androidx.compose.material.icons.filled;

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

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"_close", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Close", "Landroidx/compose/material/icons/Icons$Filled;", "getClose", "(Landroidx/compose/material/icons/Icons$Filled;)Landroidx/compose/ui/graphics/vector/ImageVector;", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CloseKt {
    private static ImageVector _close;

    public static final ImageVector getClose(Icons.Filled filled) {
        ImageVector imageVector = _close;
        if (imageVector != null) {
            k.c(imageVector);
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("Filled.Close", Dp.m6844constructorimpl(24.0f), Dp.m6844constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, false, 96, null);
        int defaultFillType = VectorKt.getDefaultFillType();
        SolidColor solidColor = new SolidColor(Color.INSTANCE.m4165getBlack0d7_KjU(), null);
        int iM4508getButtKaPHkGw = StrokeCap.INSTANCE.m4508getButtKaPHkGw();
        int iM4518getBevelLxFBmk8 = StrokeJoin.INSTANCE.m4518getBevelLxFBmk8();
        PathBuilder pathBuilderU = c.u(19.0f, 6.41f, 17.59f, 5.0f);
        pathBuilderU.lineTo(12.0f, 10.59f);
        pathBuilderU.lineTo(6.41f, 5.0f);
        pathBuilderU.lineTo(5.0f, 6.41f);
        pathBuilderU.lineTo(10.59f, 12.0f);
        pathBuilderU.lineTo(5.0f, 17.59f);
        pathBuilderU.lineTo(6.41f, 19.0f);
        pathBuilderU.lineTo(12.0f, 13.41f);
        pathBuilderU.lineTo(17.59f, 19.0f);
        ImageVector imageVectorBuild = ImageVector.Builder.m4864addPathoIyEayM$default(builder, c.v(pathBuilderU, 19.0f, 17.59f, 13.41f, 12.0f), defaultFillType, "", solidColor, 1.0f, null, 1.0f, 1.0f, iM4508getButtKaPHkGw, iM4518getBevelLxFBmk8, 1.0f, 0.0f, 0.0f, 0.0f, 14336, null).build();
        _close = imageVectorBuild;
        k.c(imageVectorBuild);
        return imageVectorBuild;
    }
}
