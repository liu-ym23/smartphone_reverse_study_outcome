package androidx.compose.ui.draw;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpRect;
import androidx.compose.ui.unit.FontScaling;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0002À\u0006\u0003"}, d2 = {"Landroidx/compose/ui/draw/InnerShadowScope;", "Landroidx/compose/ui/draw/ShadowScope;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface InnerShadowScope extends ShadowScope {

    /* JADX INFO: renamed from: androidx.compose.ui.draw.InnerShadowScope$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        /* JADX INFO: renamed from: access$roundToPx--R2X_6o$jd, reason: not valid java name */
        public static /* synthetic */ int m4392access$roundToPxR2X_6o$jd(InnerShadowScope r100, long r101) {
            return Density.CC.m7508$default$roundToPxR2X_6o(r100, r101);
        }

        /* JADX INFO: renamed from: access$roundToPx-0680j_4$jd, reason: not valid java name */
        public static /* synthetic */ int m4393access$roundToPx0680j_4$jd(InnerShadowScope r100, float r101) {
            return Density.CC.m7509$default$roundToPx0680j_4(r100, r101);
        }

        /* JADX INFO: renamed from: access$toDp-GaN1DYA$jd, reason: not valid java name */
        public static /* synthetic */ float m4394access$toDpGaN1DYA$jd(InnerShadowScope r100, long r101) {
            return FontScaling.CC.m7653$default$toDpGaN1DYA(r100, r101);
        }

        /* JADX INFO: renamed from: access$toDp-u2uoSUM$jd, reason: not valid java name */
        public static /* synthetic */ float m4395access$toDpu2uoSUM$jd(InnerShadowScope r100, float r101) {
            return Density.CC.m7510$default$toDpu2uoSUM(r100, r101);
        }

        /* JADX INFO: renamed from: access$toDpSize-k-rfVVM$jd, reason: not valid java name */
        public static /* synthetic */ long m4397access$toDpSizekrfVVM$jd(InnerShadowScope r100, long r101) {
            return Density.CC.m7512$default$toDpSizekrfVVM(r100, r101);
        }

        /* JADX INFO: renamed from: access$toPx--R2X_6o$jd, reason: not valid java name */
        public static /* synthetic */ float m4398access$toPxR2X_6o$jd(InnerShadowScope r100, long r101) {
            return Density.CC.m7513$default$toPxR2X_6o(r100, r101);
        }

        /* JADX INFO: renamed from: access$toPx-0680j_4$jd, reason: not valid java name */
        public static /* synthetic */ float m4399access$toPx0680j_4$jd(InnerShadowScope r100, float r101) {
            return Density.CC.m7514$default$toPx0680j_4(r100, r101);
        }

        public static /* synthetic */ Rect access$toRect$jd(InnerShadowScope r100, DpRect r101) {
            return Density.CC.$default$toRect(r100, r101);
        }

        /* JADX INFO: renamed from: access$toSize-XkaWNTQ$jd, reason: not valid java name */
        public static /* synthetic */ long m4400access$toSizeXkaWNTQ$jd(InnerShadowScope r100, long r101) {
            return Density.CC.m7515$default$toSizeXkaWNTQ(r100, r101);
        }

        /* JADX INFO: renamed from: access$toSp-0xMU5do$jd, reason: not valid java name */
        public static /* synthetic */ long m4401access$toSp0xMU5do$jd(InnerShadowScope r100, float r101) {
            return FontScaling.CC.m7654$default$toSp0xMU5do(r100, r101);
        }

        /* JADX INFO: renamed from: access$toSp-kPz2Gy4$jd, reason: not valid java name */
        public static /* synthetic */ long m4402access$toSpkPz2Gy4$jd(InnerShadowScope r100, float r101) {
            return Density.CC.m7516$default$toSpkPz2Gy4(r100, r101);
        }

        /* JADX INFO: renamed from: access$toDp-u2uoSUM$jd, reason: not valid java name */
        public static /* synthetic */ float m4396access$toDpu2uoSUM$jd(InnerShadowScope r100, int r101) {
            return Density.CC.m7511$default$toDpu2uoSUM(r100, r101);
        }

        /* JADX INFO: renamed from: access$toSp-kPz2Gy4$jd, reason: not valid java name */
        public static /* synthetic */ long m4403access$toSpkPz2Gy4$jd(InnerShadowScope r100, int r101) {
            return Density.CC.m7517$default$toSpkPz2Gy4(r100, r101);
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        /* JADX INFO: renamed from: roundToPx--R2X_6o, reason: not valid java name */
        public static int m4404roundToPxR2X_6o(InnerShadowScope r100, long r101) {
            return CC.m4392access$roundToPxR2X_6o$jd(r100, r101);
        }

        /* JADX INFO: renamed from: roundToPx-0680j_4, reason: not valid java name */
        public static int m4405roundToPx0680j_4(InnerShadowScope r100, float r101) {
            return CC.m4393access$roundToPx0680j_4$jd(r100, r101);
        }

        /* JADX INFO: renamed from: toDp-GaN1DYA, reason: not valid java name */
        public static float m4406toDpGaN1DYA(InnerShadowScope r100, long r101) {
            return CC.m4394access$toDpGaN1DYA$jd(r100, r101);
        }

        /* JADX INFO: renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m4407toDpu2uoSUM(InnerShadowScope r100, float r101) {
            return CC.m4395access$toDpu2uoSUM$jd(r100, r101);
        }

        /* JADX INFO: renamed from: toDpSize-k-rfVVM, reason: not valid java name */
        public static long m4409toDpSizekrfVVM(InnerShadowScope r100, long r101) {
            return CC.m4397access$toDpSizekrfVVM$jd(r100, r101);
        }

        /* JADX INFO: renamed from: toPx--R2X_6o, reason: not valid java name */
        public static float m4410toPxR2X_6o(InnerShadowScope r100, long r101) {
            return CC.m4398access$toPxR2X_6o$jd(r100, r101);
        }

        /* JADX INFO: renamed from: toPx-0680j_4, reason: not valid java name */
        public static float m4411toPx0680j_4(InnerShadowScope r100, float r101) {
            return CC.m4399access$toPx0680j_4$jd(r100, r101);
        }

        public static Rect toRect(InnerShadowScope r100, DpRect r101) {
            return CC.access$toRect$jd(r100, r101);
        }

        /* JADX INFO: renamed from: toSize-XkaWNTQ, reason: not valid java name */
        public static long m4412toSizeXkaWNTQ(InnerShadowScope r100, long r101) {
            return CC.m4400access$toSizeXkaWNTQ$jd(r100, r101);
        }

        /* JADX INFO: renamed from: toSp-0xMU5do, reason: not valid java name */
        public static long m4413toSp0xMU5do(InnerShadowScope r100, float r101) {
            return CC.m4401access$toSp0xMU5do$jd(r100, r101);
        }

        /* JADX INFO: renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m4414toSpkPz2Gy4(InnerShadowScope r100, float r101) {
            return CC.m4402access$toSpkPz2Gy4$jd(r100, r101);
        }

        /* JADX INFO: renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m4408toDpu2uoSUM(InnerShadowScope r100, int r101) {
            return CC.m4396access$toDpu2uoSUM$jd(r100, r101);
        }

        /* JADX INFO: renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m4415toSpkPz2Gy4(InnerShadowScope r100, int r101) {
            return CC.m4403access$toSpkPz2Gy4$jd(r100, r101);
        }
    }
}
