package androidx.compose.ui.unit;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import kotlin.Metadata;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u0013\u0010\b\u001a\u00020\u0003*\u00020\tH\u0017¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\f\u001a\u00020\r*\u00020\tH\u0017¢\u0006\u0004\b\u000e\u0010\u000fJ\u0013\u0010\b\u001a\u00020\u0003*\u00020\u0010H\u0017¢\u0006\u0004\b\u0011\u0010\u0012J\u0013\u0010\f\u001a\u00020\r*\u00020\u0010H\u0017¢\u0006\u0004\b\u0013\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\t*\u00020\rH\u0017¢\u0006\u0004\b\u0016\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u0010*\u00020\rH\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u0013\u0010\u0015\u001a\u00020\t*\u00020\u0003H\u0017¢\u0006\u0004\b\u0016\u0010\u000bJ\u0013\u0010\u0018\u001a\u00020\u0010*\u00020\u0003H\u0017¢\u0006\u0004\b\u0019\u0010\u001bJ\f\u0010\u001c\u001a\u00020\u001d*\u00020\u001eH\u0017J\u0013\u0010\u001f\u001a\u00020 *\u00020!H\u0017¢\u0006\u0004\b\"\u0010#J\u0013\u0010$\u001a\u00020!*\u00020 H\u0017¢\u0006\u0004\b%\u0010#R\u001a\u0010\u0002\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006&À\u0006\u0003"}, d2 = {"Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/unit/FontScaling;", "density", "", "getDensity$annotations", "()V", "getDensity", "()F", "toPx", "Landroidx/compose/ui/unit/Dp;", "toPx-0680j_4", "(F)F", "roundToPx", "", "roundToPx-0680j_4", "(F)I", "Landroidx/compose/ui/unit/TextUnit;", "toPx--R2X_6o", "(J)F", "roundToPx--R2X_6o", "(J)I", "toDp", "toDp-u2uoSUM", "(I)F", "toSp", "toSp-kPz2Gy4", "(I)J", "(F)J", "toRect", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/unit/DpRect;", "toSize", "Landroidx/compose/ui/geometry/Size;", "Landroidx/compose/ui/unit/DpSize;", "toSize-XkaWNTQ", "(J)J", "toDpSize", "toDpSize-k-rfVVM", "ui-unit"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface Density extends FontScaling {

    /* JADX INFO: renamed from: androidx.compose.ui.unit.Density$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        /* JADX INFO: renamed from: $default$roundToPx--R2X_6o, reason: not valid java name */
        public static int m7508$default$roundToPxR2X_6o(Density r100, long r101) {
            return Math.round(r100.mo370toPxR2X_6o(r101));
        }

        /* JADX INFO: renamed from: $default$roundToPx-0680j_4, reason: not valid java name */
        public static int m7509$default$roundToPx0680j_4(Density r100, float r101) {
            float r102 = r100.mo371toPx0680j_4(r101);
            if (Float.isInfinite(r102) == false) goto L6;
            return Integer.MAX_VALUE;
        L6:
            return Math.round(r102);
        }

        /* JADX INFO: renamed from: $default$toDp-u2uoSUM, reason: not valid java name */
        public static float m7511$default$toDpu2uoSUM(Density r100, int r101) {
            return Dp.m7544constructorimpl(r101 / r100.getDensity());
        }

        /* JADX INFO: renamed from: $default$toDpSize-k-rfVVM, reason: not valid java name */
        public static long m7512$default$toDpSizekrfVVM(Density r100, long r101) {
            if (r101 == androidx.compose.ui.geometry.InlineClassHelperKt.UnspecifiedPackedFloats) goto L5;
            boolean r102 = true;
        L6:
            if (r102 == false) goto L9;
            return DpKt.m7566DpSizeYgX7TsA(r100.mo367toDpu2uoSUM(Float.intBitsToFloat((int) (r101 >> 32))), r100.mo367toDpu2uoSUM(Float.intBitsToFloat((int) (r101 & BodyPartID.bodyIdMax))));
        L9:
            return DpSize.Companion.m7651getUnspecifiedMYxV2XQ();
        L5:
            r102 = false;
            goto L6
        }

        /* JADX INFO: renamed from: $default$toPx--R2X_6o, reason: not valid java name */
        public static float m7513$default$toPxR2X_6o(Density r100, long r101) {
            if (TextUnitType.m7770equalsimpl0(TextUnit.m7741getTypeUIouoOA(r101), TextUnitType.Companion.m7775getSpUIouoOA()) == true) goto L6;
            InlineClassHelperKt.throwIllegalStateException("Only Sp can convert to Px");
        L6:
            return r100.mo371toPx0680j_4(r100.mo366toDpGaN1DYA(r101));
        }

        /* JADX INFO: renamed from: $default$toPx-0680j_4, reason: not valid java name */
        public static float m7514$default$toPx0680j_4(Density r100, float r101) {
            return r101 * r100.getDensity();
        }

        public static Rect $default$toRect(Density r100, DpRect r101) {
            return new Rect(r100.mo371toPx0680j_4(r101.m7627getLeftD9Ej5fM()), r100.mo371toPx0680j_4(r101.m7629getTopD9Ej5fM()), r100.mo371toPx0680j_4(r101.m7628getRightD9Ej5fM()), r100.mo371toPx0680j_4(r101.m7626getBottomD9Ej5fM()));
        }

        /* JADX INFO: renamed from: $default$toSize-XkaWNTQ, reason: not valid java name */
        public static long m7515$default$toSizeXkaWNTQ(Density r100, long r101) {
            if (r101 == androidx.compose.ui.geometry.InlineClassHelperKt.UnspecifiedPackedFloats) goto L5;
            boolean r102 = true;
        L6:
            if (r102 == false) goto L9;
            float r103 = r100.mo371toPx0680j_4(DpSize.m7642getWidthD9Ej5fM(r101));
            float r104 = r100.mo371toPx0680j_4(DpSize.m7640getHeightD9Ej5fM(r101));
            return Size.m4642constructorimpl((Float.floatToRawIntBits(r103) << 32) | (Float.floatToRawIntBits(r104) & BodyPartID.bodyIdMax));
        L9:
            return Size.Companion.m4659getUnspecifiedNHjbRc();
        L5:
            r102 = false;
            goto L6
        }

        /* JADX INFO: renamed from: $default$toSp-kPz2Gy4, reason: not valid java name */
        public static long m7516$default$toSpkPz2Gy4(Density r100, float r101) {
            return r100.mo373toSp0xMU5do(r100.mo367toDpu2uoSUM(r101));
        }

        /* JADX INFO: renamed from: access$roundToPx--R2X_6o$jd, reason: not valid java name */
        public static /* synthetic */ int m7518access$roundToPxR2X_6o$jd(Density r100, long r101) {
            return m7508$default$roundToPxR2X_6o(r100, r101);
        }

        /* JADX INFO: renamed from: access$roundToPx-0680j_4$jd, reason: not valid java name */
        public static /* synthetic */ int m7519access$roundToPx0680j_4$jd(Density r100, float r101) {
            return m7509$default$roundToPx0680j_4(r100, r101);
        }

        /* JADX INFO: renamed from: access$toDp-GaN1DYA$jd, reason: not valid java name */
        public static /* synthetic */ float m7520access$toDpGaN1DYA$jd(Density r100, long r101) {
            return FontScaling.CC.m7653$default$toDpGaN1DYA(r100, r101);
        }

        /* JADX INFO: renamed from: access$toDp-u2uoSUM$jd, reason: not valid java name */
        public static /* synthetic */ float m7521access$toDpu2uoSUM$jd(Density r100, float r101) {
            return m7510$default$toDpu2uoSUM(r100, r101);
        }

        /* JADX INFO: renamed from: access$toDpSize-k-rfVVM$jd, reason: not valid java name */
        public static /* synthetic */ long m7523access$toDpSizekrfVVM$jd(Density r100, long r101) {
            return m7512$default$toDpSizekrfVVM(r100, r101);
        }

        /* JADX INFO: renamed from: access$toPx--R2X_6o$jd, reason: not valid java name */
        public static /* synthetic */ float m7524access$toPxR2X_6o$jd(Density r100, long r101) {
            return m7513$default$toPxR2X_6o(r100, r101);
        }

        /* JADX INFO: renamed from: access$toPx-0680j_4$jd, reason: not valid java name */
        public static /* synthetic */ float m7525access$toPx0680j_4$jd(Density r100, float r101) {
            return m7514$default$toPx0680j_4(r100, r101);
        }

        public static /* synthetic */ Rect access$toRect$jd(Density r100, DpRect r101) {
            return $default$toRect(r100, r101);
        }

        /* JADX INFO: renamed from: access$toSize-XkaWNTQ$jd, reason: not valid java name */
        public static /* synthetic */ long m7526access$toSizeXkaWNTQ$jd(Density r100, long r101) {
            return m7515$default$toSizeXkaWNTQ(r100, r101);
        }

        /* JADX INFO: renamed from: access$toSp-0xMU5do$jd, reason: not valid java name */
        public static /* synthetic */ long m7527access$toSp0xMU5do$jd(Density r100, float r101) {
            return FontScaling.CC.m7654$default$toSp0xMU5do(r100, r101);
        }

        /* JADX INFO: renamed from: access$toSp-kPz2Gy4$jd, reason: not valid java name */
        public static /* synthetic */ long m7528access$toSpkPz2Gy4$jd(Density r100, float r101) {
            return m7516$default$toSpkPz2Gy4(r100, r101);
        }

        /* JADX INFO: renamed from: $default$toDp-u2uoSUM, reason: not valid java name */
        public static float m7510$default$toDpu2uoSUM(Density r100, float r101) {
            return Dp.m7544constructorimpl(r101 / r100.getDensity());
        }

        /* JADX INFO: renamed from: $default$toSp-kPz2Gy4, reason: not valid java name */
        public static long m7517$default$toSpkPz2Gy4(Density r100, int r101) {
            return r100.mo373toSp0xMU5do(r100.mo368toDpu2uoSUM(r101));
        }

        /* JADX INFO: renamed from: access$toDp-u2uoSUM$jd, reason: not valid java name */
        public static /* synthetic */ float m7522access$toDpu2uoSUM$jd(Density r100, int r101) {
            return m7511$default$toDpu2uoSUM(r100, r101);
        }

        /* JADX INFO: renamed from: access$toSp-kPz2Gy4$jd, reason: not valid java name */
        public static /* synthetic */ long m7529access$toSpkPz2Gy4$jd(Density r100, int r101) {
            return m7517$default$toSpkPz2Gy4(r100, r101);
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void getDensity$annotations() {
        }

        /* JADX INFO: renamed from: roundToPx--R2X_6o, reason: not valid java name */
        public static int m7530roundToPxR2X_6o(Density r100, long r101) {
            return CC.m7518access$roundToPxR2X_6o$jd(r100, r101);
        }

        /* JADX INFO: renamed from: roundToPx-0680j_4, reason: not valid java name */
        public static int m7531roundToPx0680j_4(Density r100, float r101) {
            return CC.m7519access$roundToPx0680j_4$jd(r100, r101);
        }

        /* JADX INFO: renamed from: toDp-GaN1DYA, reason: not valid java name */
        public static float m7532toDpGaN1DYA(Density r100, long r101) {
            return CC.m7520access$toDpGaN1DYA$jd(r100, r101);
        }

        /* JADX INFO: renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m7533toDpu2uoSUM(Density r100, float r101) {
            return CC.m7521access$toDpu2uoSUM$jd(r100, r101);
        }

        /* JADX INFO: renamed from: toDpSize-k-rfVVM, reason: not valid java name */
        public static long m7535toDpSizekrfVVM(Density r100, long r101) {
            return CC.m7523access$toDpSizekrfVVM$jd(r100, r101);
        }

        /* JADX INFO: renamed from: toPx--R2X_6o, reason: not valid java name */
        public static float m7536toPxR2X_6o(Density r100, long r101) {
            return CC.m7524access$toPxR2X_6o$jd(r100, r101);
        }

        /* JADX INFO: renamed from: toPx-0680j_4, reason: not valid java name */
        public static float m7537toPx0680j_4(Density r100, float r101) {
            return CC.m7525access$toPx0680j_4$jd(r100, r101);
        }

        public static Rect toRect(Density r100, DpRect r101) {
            return CC.access$toRect$jd(r100, r101);
        }

        /* JADX INFO: renamed from: toSize-XkaWNTQ, reason: not valid java name */
        public static long m7538toSizeXkaWNTQ(Density r100, long r101) {
            return CC.m7526access$toSizeXkaWNTQ$jd(r100, r101);
        }

        /* JADX INFO: renamed from: toSp-0xMU5do, reason: not valid java name */
        public static long m7539toSp0xMU5do(Density r100, float r101) {
            return CC.m7527access$toSp0xMU5do$jd(r100, r101);
        }

        /* JADX INFO: renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m7540toSpkPz2Gy4(Density r100, float r101) {
            return CC.m7528access$toSpkPz2Gy4$jd(r100, r101);
        }

        /* JADX INFO: renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m7534toDpu2uoSUM(Density r100, int r101) {
            return CC.m7522access$toDpu2uoSUM$jd(r100, r101);
        }

        /* JADX INFO: renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m7541toSpkPz2Gy4(Density r100, int r101) {
            return CC.m7529access$toSpkPz2Gy4$jd(r100, r101);
        }
    }

    float getDensity();

    /* JADX INFO: renamed from: roundToPx--R2X_6o */
    int mo364roundToPxR2X_6o(long r100);

    /* JADX INFO: renamed from: roundToPx-0680j_4 */
    int mo365roundToPx0680j_4(float r100);

    /* JADX INFO: renamed from: toDp-u2uoSUM */
    float mo367toDpu2uoSUM(float r100);

    /* JADX INFO: renamed from: toDp-u2uoSUM */
    float mo368toDpu2uoSUM(int r100);

    /* JADX INFO: renamed from: toDpSize-k-rfVVM */
    long mo369toDpSizekrfVVM(long r100);

    /* JADX INFO: renamed from: toPx--R2X_6o */
    float mo370toPxR2X_6o(long r100);

    /* JADX INFO: renamed from: toPx-0680j_4 */
    float mo371toPx0680j_4(float r100);

    Rect toRect(DpRect r100);

    /* JADX INFO: renamed from: toSize-XkaWNTQ */
    long mo372toSizeXkaWNTQ(long r100);

    /* JADX INFO: renamed from: toSp-kPz2Gy4 */
    long mo374toSpkPz2Gy4(float r100);

    /* JADX INFO: renamed from: toSp-kPz2Gy4 */
    long mo375toSpkPz2Gy4(int r100);
}
