package androidx.compose.ui.graphics.drawscope;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpRect;
import androidx.compose.ui.unit.FontScaling;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0004À\u0006\u0003"}, d2 = {"Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "drawContent", "", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface ContentDrawScope extends DrawScope {

    /* JADX INFO: renamed from: androidx.compose.ui.graphics.drawscope.ContentDrawScope$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        /* JADX INFO: renamed from: access$getCenter-F1C5BW0$jd, reason: not valid java name */
        public static /* synthetic */ long m5339access$getCenterF1C5BW0$jd(ContentDrawScope r100) {
            return DrawScope.CC.m5371$default$getCenterF1C5BW0(r100);
        }

        /* JADX INFO: renamed from: access$getSize-NH-jbRc$jd, reason: not valid java name */
        public static /* synthetic */ long m5340access$getSizeNHjbRc$jd(ContentDrawScope r100) {
            return DrawScope.CC.m5372$default$getSizeNHjbRc(r100);
        }

        /* JADX INFO: renamed from: access$roundToPx--R2X_6o$jd, reason: not valid java name */
        public static /* synthetic */ int m5342access$roundToPxR2X_6o$jd(ContentDrawScope r100, long r101) {
            return Density.CC.m7508$default$roundToPxR2X_6o(r100, r101);
        }

        /* JADX INFO: renamed from: access$roundToPx-0680j_4$jd, reason: not valid java name */
        public static /* synthetic */ int m5343access$roundToPx0680j_4$jd(ContentDrawScope r100, float r101) {
            return Density.CC.m7509$default$roundToPx0680j_4(r100, r101);
        }

        /* JADX INFO: renamed from: access$toDp-GaN1DYA$jd, reason: not valid java name */
        public static /* synthetic */ float m5344access$toDpGaN1DYA$jd(ContentDrawScope r100, long r101) {
            return FontScaling.CC.m7653$default$toDpGaN1DYA(r100, r101);
        }

        /* JADX INFO: renamed from: access$toDp-u2uoSUM$jd, reason: not valid java name */
        public static /* synthetic */ float m5345access$toDpu2uoSUM$jd(ContentDrawScope r100, float r101) {
            return Density.CC.m7510$default$toDpu2uoSUM(r100, r101);
        }

        /* JADX INFO: renamed from: access$toDpSize-k-rfVVM$jd, reason: not valid java name */
        public static /* synthetic */ long m5347access$toDpSizekrfVVM$jd(ContentDrawScope r100, long r101) {
            return Density.CC.m7512$default$toDpSizekrfVVM(r100, r101);
        }

        /* JADX INFO: renamed from: access$toPx--R2X_6o$jd, reason: not valid java name */
        public static /* synthetic */ float m5348access$toPxR2X_6o$jd(ContentDrawScope r100, long r101) {
            return Density.CC.m7513$default$toPxR2X_6o(r100, r101);
        }

        /* JADX INFO: renamed from: access$toPx-0680j_4$jd, reason: not valid java name */
        public static /* synthetic */ float m5349access$toPx0680j_4$jd(ContentDrawScope r100, float r101) {
            return Density.CC.m7514$default$toPx0680j_4(r100, r101);
        }

        public static /* synthetic */ Rect access$toRect$jd(ContentDrawScope r100, DpRect r101) {
            return Density.CC.$default$toRect(r100, r101);
        }

        /* JADX INFO: renamed from: access$toSize-XkaWNTQ$jd, reason: not valid java name */
        public static /* synthetic */ long m5350access$toSizeXkaWNTQ$jd(ContentDrawScope r100, long r101) {
            return Density.CC.m7515$default$toSizeXkaWNTQ(r100, r101);
        }

        /* JADX INFO: renamed from: access$toSp-0xMU5do$jd, reason: not valid java name */
        public static /* synthetic */ long m5351access$toSp0xMU5do$jd(ContentDrawScope r100, float r101) {
            return FontScaling.CC.m7654$default$toSp0xMU5do(r100, r101);
        }

        /* JADX INFO: renamed from: access$toSp-kPz2Gy4$jd, reason: not valid java name */
        public static /* synthetic */ long m5352access$toSpkPz2Gy4$jd(ContentDrawScope r100, float r101) {
            return Density.CC.m7516$default$toSpkPz2Gy4(r100, r101);
        }

        /* JADX INFO: renamed from: access$toDp-u2uoSUM$jd, reason: not valid java name */
        public static /* synthetic */ float m5346access$toDpu2uoSUM$jd(ContentDrawScope r100, int r101) {
            return Density.CC.m7511$default$toDpu2uoSUM(r100, r101);
        }

        /* JADX INFO: renamed from: access$toSp-kPz2Gy4$jd, reason: not valid java name */
        public static /* synthetic */ long m5353access$toSpkPz2Gy4$jd(ContentDrawScope r100, int r101) {
            return Density.CC.m7517$default$toSpkPz2Gy4(r100, r101);
        }

        /* JADX INFO: renamed from: access$record-JVtK1S4$jd, reason: not valid java name */
        public static /* synthetic */ void m5341access$recordJVtK1S4$jd(ContentDrawScope r100, GraphicsLayer r101, long r102, Function1 r103) {
            DrawScope.CC.m5373$default$recordJVtK1S4(r100, r101, r102, r103);
        }

        /* JADX INFO: renamed from: access$drawImage-AZ2fEMs$jd, reason: not valid java name */
        public static /* synthetic */ void m5338access$drawImageAZ2fEMs$jd(ContentDrawScope r100, ImageBitmap r101, long r102, long r103, long r104, long r105, float r110, DrawStyle r111, ColorFilter r112, int r113, int r114) {
            DrawScope.CC.m5370$default$drawImageAZ2fEMs(r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114);
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        /* JADX INFO: renamed from: getCenter-F1C5BW0, reason: not valid java name */
        public static long m5355getCenterF1C5BW0(ContentDrawScope r100) {
            return CC.m5339access$getCenterF1C5BW0$jd(r100);
        }

        /* JADX INFO: renamed from: getSize-NH-jbRc, reason: not valid java name */
        public static long m5356getSizeNHjbRc(ContentDrawScope r100) {
            return CC.m5340access$getSizeNHjbRc$jd(r100);
        }

        /* JADX INFO: renamed from: roundToPx--R2X_6o, reason: not valid java name */
        public static int m5358roundToPxR2X_6o(ContentDrawScope r100, long r101) {
            return CC.m5342access$roundToPxR2X_6o$jd(r100, r101);
        }

        /* JADX INFO: renamed from: roundToPx-0680j_4, reason: not valid java name */
        public static int m5359roundToPx0680j_4(ContentDrawScope r100, float r101) {
            return CC.m5343access$roundToPx0680j_4$jd(r100, r101);
        }

        /* JADX INFO: renamed from: toDp-GaN1DYA, reason: not valid java name */
        public static float m5360toDpGaN1DYA(ContentDrawScope r100, long r101) {
            return CC.m5344access$toDpGaN1DYA$jd(r100, r101);
        }

        /* JADX INFO: renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m5361toDpu2uoSUM(ContentDrawScope r100, float r101) {
            return CC.m5345access$toDpu2uoSUM$jd(r100, r101);
        }

        /* JADX INFO: renamed from: toDpSize-k-rfVVM, reason: not valid java name */
        public static long m5363toDpSizekrfVVM(ContentDrawScope r100, long r101) {
            return CC.m5347access$toDpSizekrfVVM$jd(r100, r101);
        }

        /* JADX INFO: renamed from: toPx--R2X_6o, reason: not valid java name */
        public static float m5364toPxR2X_6o(ContentDrawScope r100, long r101) {
            return CC.m5348access$toPxR2X_6o$jd(r100, r101);
        }

        /* JADX INFO: renamed from: toPx-0680j_4, reason: not valid java name */
        public static float m5365toPx0680j_4(ContentDrawScope r100, float r101) {
            return CC.m5349access$toPx0680j_4$jd(r100, r101);
        }

        public static Rect toRect(ContentDrawScope r100, DpRect r101) {
            return CC.access$toRect$jd(r100, r101);
        }

        /* JADX INFO: renamed from: toSize-XkaWNTQ, reason: not valid java name */
        public static long m5366toSizeXkaWNTQ(ContentDrawScope r100, long r101) {
            return CC.m5350access$toSizeXkaWNTQ$jd(r100, r101);
        }

        /* JADX INFO: renamed from: toSp-0xMU5do, reason: not valid java name */
        public static long m5367toSp0xMU5do(ContentDrawScope r100, float r101) {
            return CC.m5351access$toSp0xMU5do$jd(r100, r101);
        }

        /* JADX INFO: renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m5368toSpkPz2Gy4(ContentDrawScope r100, float r101) {
            return CC.m5352access$toSpkPz2Gy4$jd(r100, r101);
        }

        /* JADX INFO: renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m5362toDpu2uoSUM(ContentDrawScope r100, int r101) {
            return CC.m5346access$toDpu2uoSUM$jd(r100, r101);
        }

        /* JADX INFO: renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m5369toSpkPz2Gy4(ContentDrawScope r100, int r101) {
            return CC.m5353access$toSpkPz2Gy4$jd(r100, r101);
        }

        /* JADX INFO: renamed from: record-JVtK1S4, reason: not valid java name */
        public static void m5357recordJVtK1S4(ContentDrawScope r100, GraphicsLayer r101, long r102, Function1<? super DrawScope, Unit> r103) {
            CC.m5341access$recordJVtK1S4$jd(r100, r101, r102, r103);
        }

        /* JADX INFO: renamed from: drawImage-AZ2fEMs, reason: not valid java name */
        public static void m5354drawImageAZ2fEMs(ContentDrawScope r100, ImageBitmap r101, long r102, long r103, long r104, long r105, float r110, DrawStyle r111, ColorFilter r112, int r113, int r114) {
            CC.m5338access$drawImageAZ2fEMs$jd(r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114);
        }
    }

    void drawContent();
}
