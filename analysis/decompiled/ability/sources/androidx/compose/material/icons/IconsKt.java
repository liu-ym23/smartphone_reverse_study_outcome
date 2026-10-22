package androidx.compose.material.icons;

import S7.k;
import androidx.autofill.HintConstants;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.PathBuilder;
import androidx.compose.ui.graphics.vector.VectorKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000:\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u001a,\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H\u0087\b¢\u0006\u0004\b\u0006\u0010\u0007\u001a6\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\b2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H\u0086\b¢\u0006\u0004\b\u0006\u0010\n\u001aI\u0010\u0015\u001a\u00020\u0003*\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u0002H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\"\u001a\u0010\u0016\u001a\u00020\u000b8\u0000X\u0081T¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u0012\u0004\b\u0018\u0010\u0019\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001a"}, d2 = {"", HintConstants.AUTOFILL_HINT_NAME, "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/vector/ImageVector$Builder;", "block", "Landroidx/compose/ui/graphics/vector/ImageVector;", "materialIcon", "(Ljava/lang/String;LS7/k;)Landroidx/compose/ui/graphics/vector/ImageVector;", "", "autoMirror", "(Ljava/lang/String;ZLS7/k;)Landroidx/compose/ui/graphics/vector/ImageVector;", "", "fillAlpha", "strokeAlpha", "Landroidx/compose/ui/graphics/PathFillType;", "pathFillType", "Landroidx/compose/ui/graphics/vector/PathBuilder;", "LC7/r;", "pathBuilder", "materialPath-YwgOQQI", "(Landroidx/compose/ui/graphics/vector/ImageVector$Builder;FFILS7/k;)Landroidx/compose/ui/graphics/vector/ImageVector$Builder;", "materialPath", "MaterialIconDimension", "F", "getMaterialIconDimension$annotations", "()V", "material-icons-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class IconsKt {
    public static final float MaterialIconDimension = 24.0f;

    public static /* synthetic */ void getMaterialIconDimension$annotations() {
    }

    public static final ImageVector materialIcon(String str, boolean z10, k kVar) {
        return ((ImageVector.Builder) kVar.invoke(new ImageVector.Builder(str, Dp.m6844constructorimpl(24.0f), Dp.m6844constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, z10, 96, null))).build();
    }

    public static /* synthetic */ ImageVector materialIcon$default(String str, boolean z10, k kVar, int i, Object obj) {
        if ((i & 2) != 0) {
            z10 = false;
        }
        return ((ImageVector.Builder) kVar.invoke(new ImageVector.Builder(str, Dp.m6844constructorimpl(24.0f), Dp.m6844constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, z10, 96, null))).build();
    }

    /* renamed from: materialPath-YwgOQQI, reason: not valid java name */
    public static final ImageVector.Builder m1473materialPathYwgOQQI(ImageVector.Builder builder, float f, float f7, int i, k kVar) {
        SolidColor solidColor = new SolidColor(Color.INSTANCE.m4165getBlack0d7_KjU(), null);
        int iM4508getButtKaPHkGw = StrokeCap.INSTANCE.m4508getButtKaPHkGw();
        int iM4518getBevelLxFBmk8 = StrokeJoin.INSTANCE.m4518getBevelLxFBmk8();
        PathBuilder pathBuilder = new PathBuilder();
        kVar.invoke(pathBuilder);
        return ImageVector.Builder.m4864addPathoIyEayM$default(builder, pathBuilder.getNodes(), i, "", solidColor, f, null, f7, 1.0f, iM4508getButtKaPHkGw, iM4518getBevelLxFBmk8, 1.0f, 0.0f, 0.0f, 0.0f, 14336, null);
    }

    /* renamed from: materialPath-YwgOQQI$default, reason: not valid java name */
    public static /* synthetic */ ImageVector.Builder m1474materialPathYwgOQQI$default(ImageVector.Builder builder, float f, float f7, int i, k kVar, int i6, Object obj) {
        float f9 = (i6 & 1) != 0 ? 1.0f : f;
        float f10 = (i6 & 2) != 0 ? 1.0f : f7;
        int defaultFillType = (i6 & 4) != 0 ? VectorKt.getDefaultFillType() : i;
        SolidColor solidColor = new SolidColor(Color.INSTANCE.m4165getBlack0d7_KjU(), null);
        int iM4508getButtKaPHkGw = StrokeCap.INSTANCE.m4508getButtKaPHkGw();
        int iM4518getBevelLxFBmk8 = StrokeJoin.INSTANCE.m4518getBevelLxFBmk8();
        PathBuilder pathBuilder = new PathBuilder();
        kVar.invoke(pathBuilder);
        return ImageVector.Builder.m4864addPathoIyEayM$default(builder, pathBuilder.getNodes(), defaultFillType, "", solidColor, f9, null, f10, 1.0f, iM4508getButtKaPHkGw, iM4518getBevelLxFBmk8, 1.0f, 0.0f, 0.0f, 0.0f, 14336, null);
    }
}
