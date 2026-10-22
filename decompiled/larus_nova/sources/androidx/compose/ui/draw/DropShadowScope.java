package androidx.compose.ui.draw;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpRect;
import androidx.compose.ui.unit.FontScaling;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0002À\u0006\u0003"}, d2 = {"Landroidx/compose/ui/draw/DropShadowScope;", "Landroidx/compose/ui/draw/ShadowScope;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface DropShadowScope extends ShadowScope {

    /* JADX INFO: renamed from: androidx.compose.ui.draw.DropShadowScope$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        /* JADX INFO: renamed from: access$roundToPx--R2X_6o$jd, reason: not valid java name */
        public static /* synthetic */ int m4368access$roundToPxR2X_6o$jd(DropShadowScope r100, long r101) {
            return Density.CC.m7508$default$roundToPxR2X_6o(r100, r101);
        }

        /* JADX INFO: renamed from: access$roundToPx-0680j_4$jd, reason: not valid java name */
        public static /* synthetic */ int m4369access$roundToPx0680j_4$jd(DropShadowScope r100, float r101) {
            return Density.CC.m7509$default$roundToPx0680j_4(r100, r101);
        }

        /* JADX INFO: renamed from: access$toDp-GaN1DYA$jd, reason: not valid java name */
        public static /* synthetic */ float m4370access$toDpGaN1DYA$jd(DropShadowScope r100, long r101) {
            return FontScaling.CC.m7653$default$toDpGaN1DYA(r100, r101);
        }

        /* JADX INFO: renamed from: access$toDp-u2uoSUM$jd, reason: not valid java name */
        public static /* synthetic */ float m4371access$toDpu2uoSUM$jd(DropShadowScope r100, float r101) {
            return Density.CC.m7510$default$toDpu2uoSUM(r100, r101);
        }

        /* JADX INFO: renamed from: access$toDpSize-k-rfVVM$jd, reason: not valid java name */
        public static /* synthetic */ long m4373access$toDpSizekrfVVM$jd(DropShadowScope r100, long r101) {
            return Density.CC.m7512$default$toDpSizekrfVVM(r100, r101);
        }

        /* JADX INFO: renamed from: access$toPx--R2X_6o$jd, reason: not valid java name */
        public static /* synthetic */ float m4374access$toPxR2X_6o$jd(DropShadowScope r100, long r101) {
            return Density.CC.m7513$default$toPxR2X_6o(r100, r101);
        }

        /* JADX INFO: renamed from: access$toPx-0680j_4$jd, reason: not valid java name */
        public static /* synthetic */ float m4375access$toPx0680j_4$jd(DropShadowScope r100, float r101) {
            return Density.CC.m7514$default$toPx0680j_4(r100, r101);
        }

        public static /* synthetic */ Rect access$toRect$jd(DropShadowScope r100, DpRect r101) {
            return Density.CC.$default$toRect(r100, r101);
        }

        /* JADX INFO: renamed from: access$toSize-XkaWNTQ$jd, reason: not valid java name */
        public static /* synthetic */ long m4376access$toSizeXkaWNTQ$jd(DropShadowScope r100, long r101) {
            return Density.CC.m7515$default$toSizeXkaWNTQ(r100, r101);
        }

        /* JADX INFO: renamed from: access$toSp-0xMU5do$jd, reason: not valid java name */
        public static /* synthetic */ long m4377access$toSp0xMU5do$jd(DropShadowScope r100, float r101) {
            return FontScaling.CC.m7654$default$toSp0xMU5do(r100, r101);
        }

        /* JADX INFO: renamed from: access$toSp-kPz2Gy4$jd, reason: not valid java name */
        public static /* synthetic */ long m4378access$toSpkPz2Gy4$jd(DropShadowScope r100, float r101) {
            return Density.CC.m7516$default$toSpkPz2Gy4(r100, r101);
        }

        /* JADX INFO: renamed from: access$toDp-u2uoSUM$jd, reason: not valid java name */
        public static /* synthetic */ float m4372access$toDpu2uoSUM$jd(DropShadowScope r100, int r101) {
            return Density.CC.m7511$default$toDpu2uoSUM(r100, r101);
        }

        /* JADX INFO: renamed from: access$toSp-kPz2Gy4$jd, reason: not valid java name */
        public static /* synthetic */ long m4379access$toSpkPz2Gy4$jd(DropShadowScope r100, int r101) {
            return Density.CC.m7517$default$toSpkPz2Gy4(r100, r101);
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        /* JADX INFO: renamed from: roundToPx--R2X_6o, reason: not valid java name */
        public static int m4380roundToPxR2X_6o(DropShadowScope r100, long r101) {
            return CC.m4368access$roundToPxR2X_6o$jd(r100, r101);
        }

        /* JADX INFO: renamed from: roundToPx-0680j_4, reason: not valid java name */
        public static int m4381roundToPx0680j_4(DropShadowScope r100, float r101) {
            return CC.m4369access$roundToPx0680j_4$jd(r100, r101);
        }

        /* JADX INFO: renamed from: toDp-GaN1DYA, reason: not valid java name */
        public static float m4382toDpGaN1DYA(DropShadowScope r100, long r101) {
            return CC.m4370access$toDpGaN1DYA$jd(r100, r101);
        }

        /* JADX INFO: renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m4383toDpu2uoSUM(DropShadowScope r100, float r101) {
            return CC.m4371access$toDpu2uoSUM$jd(r100, r101);
        }

        /* JADX INFO: renamed from: toDpSize-k-rfVVM, reason: not valid java name */
        public static long m4385toDpSizekrfVVM(DropShadowScope r100, long r101) {
            return CC.m4373access$toDpSizekrfVVM$jd(r100, r101);
        }

        /* JADX INFO: renamed from: toPx--R2X_6o, reason: not valid java name */
        public static float m4386toPxR2X_6o(DropShadowScope r100, long r101) {
            return CC.m4374access$toPxR2X_6o$jd(r100, r101);
        }

        /* JADX INFO: renamed from: toPx-0680j_4, reason: not valid java name */
        public static float m4387toPx0680j_4(DropShadowScope r100, float r101) {
            return CC.m4375access$toPx0680j_4$jd(r100, r101);
        }

        public static Rect toRect(DropShadowScope r100, DpRect r101) {
            return CC.access$toRect$jd(r100, r101);
        }

        /* JADX INFO: renamed from: toSize-XkaWNTQ, reason: not valid java name */
        public static long m4388toSizeXkaWNTQ(DropShadowScope r100, long r101) {
            return CC.m4376access$toSizeXkaWNTQ$jd(r100, r101);
        }

        /* JADX INFO: renamed from: toSp-0xMU5do, reason: not valid java name */
        public static long m4389toSp0xMU5do(DropShadowScope r100, float r101) {
            return CC.m4377access$toSp0xMU5do$jd(r100, r101);
        }

        /* JADX INFO: renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m4390toSpkPz2Gy4(DropShadowScope r100, float r101) {
            return CC.m4378access$toSpkPz2Gy4$jd(r100, r101);
        }

        /* JADX INFO: renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m4384toDpu2uoSUM(DropShadowScope r100, int r101) {
            return CC.m4372access$toDpu2uoSUM$jd(r100, r101);
        }

        /* JADX INFO: renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m4391toSpkPz2Gy4(DropShadowScope r100, int r101) {
            return CC.m4379access$toSpkPz2Gy4$jd(r100, r101);
        }
    }
}
