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
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\bÁ\u0002\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Landroidx/compose/material/internal/Icons;", "", "<init>", "()V", "Filled", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Icons {
    public static final int $stable = 0;
    public static final Icons INSTANCE = null;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u00058@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Landroidx/compose/material/internal/Icons$Filled;", "", "<init>", "()V", "ArrowDropDown", "Landroidx/compose/ui/graphics/vector/ImageVector;", "getArrowDropDown$material", "()Landroidx/compose/ui/graphics/vector/ImageVector;", "_arrowDropDown", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Filled {
        public static final int $stable = 0;
        public static final Filled INSTANCE = null;
        private static ImageVector _arrowDropDown;

        static {
            INSTANCE = new Filled();
            $stable = 8;
        }

        private Filled() {
        }

        public final ImageVector getArrowDropDown$material() {
            ImageVector r100 = _arrowDropDown;
            if (r100 == null) goto L6;
            Intrinsics.checkNotNull(r100);
            return r100;
        L6:
            ImageVector.Builder r101 = new ImageVector.Builder("Filled.ArrowDropDown", Dp.m7544constructorimpl(24.0f), Dp.m7544constructorimpl(24.0f), 24.0f, 24.0f, 0, 0, false, 224, null);
            int r110 = VectorKt.getDefaultFillType();
            SolidColor r102 = new SolidColor(Color.Companion.m4853getBlack0d7_KjU(), null);
            int r210 = StrokeCap.Companion.m5206getButtKaPHkGw();
            int r211 = StrokeJoin.Companion.m5216getBevelLxFBmk8();
            PathBuilder r103 = new PathBuilder();
            r103.moveTo(7.0f, 10.0f);
            r103.lineToRelative(5.0f, 5.0f);
            r103.lineToRelative(5.0f, -5.0f);
            r103.close();
            ImageVector r104 = ImageVector.Builder.m5567addPathoIyEayM$default(r101, r103.getNodes(), r110, "", r102, 1.0f, null, 1.0f, 1.0f, r210, r211, 1.0f, 0.0f, 0.0f, 0.0f, 14336, null).build();
            _arrowDropDown = r104;
            Intrinsics.checkNotNull(r104);
            return r104;
        }
    }

    static {
        INSTANCE = new Icons();
    }

    private Icons() {
    }
}
