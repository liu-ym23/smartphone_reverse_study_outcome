package androidx.compose.ui.layout;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpRect;
import androidx.compose.ui.unit.FontScaling;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes17.dex */
@MeasureScopeMarker
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001JG\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050\b2\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\u0016Jd\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050\b2\u001b\b\u0002\u0010\u000f\u001a\u0015\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\r\u0018\u00010\u000b¢\u0006\u0002\b\u000e2\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\b\u000eH\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0011À\u0006\u0003"}, d2 = {"Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "layout", "Landroidx/compose/ui/layout/MeasureResult;", "width", "", "height", "alignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "placementBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "", "Lkotlin/ExtensionFunctionType;", "rulers", "Landroidx/compose/ui/layout/RulerScope;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface MeasureScope extends IntrinsicMeasureScope {

    /* JADX INFO: renamed from: androidx.compose.ui.layout.MeasureScope$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static /* synthetic */ boolean access$isLookingAhead$jd(MeasureScope r100) {
            return IntrinsicMeasureScope.CC.$default$isLookingAhead(r100);
        }

        /* JADX INFO: renamed from: access$roundToPx--R2X_6o$jd, reason: not valid java name */
        public static /* synthetic */ int m6293access$roundToPxR2X_6o$jd(MeasureScope r100, long r101) {
            return Density.CC.m7508$default$roundToPxR2X_6o(r100, r101);
        }

        /* JADX INFO: renamed from: access$roundToPx-0680j_4$jd, reason: not valid java name */
        public static /* synthetic */ int m6294access$roundToPx0680j_4$jd(MeasureScope r100, float r101) {
            return Density.CC.m7509$default$roundToPx0680j_4(r100, r101);
        }

        /* JADX INFO: renamed from: access$toDp-GaN1DYA$jd, reason: not valid java name */
        public static /* synthetic */ float m6295access$toDpGaN1DYA$jd(MeasureScope r100, long r101) {
            return FontScaling.CC.m7653$default$toDpGaN1DYA(r100, r101);
        }

        /* JADX INFO: renamed from: access$toDp-u2uoSUM$jd, reason: not valid java name */
        public static /* synthetic */ float m6296access$toDpu2uoSUM$jd(MeasureScope r100, float r101) {
            return Density.CC.m7510$default$toDpu2uoSUM(r100, r101);
        }

        /* JADX INFO: renamed from: access$toDpSize-k-rfVVM$jd, reason: not valid java name */
        public static /* synthetic */ long m6298access$toDpSizekrfVVM$jd(MeasureScope r100, long r101) {
            return Density.CC.m7512$default$toDpSizekrfVVM(r100, r101);
        }

        /* JADX INFO: renamed from: access$toPx--R2X_6o$jd, reason: not valid java name */
        public static /* synthetic */ float m6299access$toPxR2X_6o$jd(MeasureScope r100, long r101) {
            return Density.CC.m7513$default$toPxR2X_6o(r100, r101);
        }

        /* JADX INFO: renamed from: access$toPx-0680j_4$jd, reason: not valid java name */
        public static /* synthetic */ float m6300access$toPx0680j_4$jd(MeasureScope r100, float r101) {
            return Density.CC.m7514$default$toPx0680j_4(r100, r101);
        }

        public static /* synthetic */ Rect access$toRect$jd(MeasureScope r100, DpRect r101) {
            return Density.CC.$default$toRect(r100, r101);
        }

        /* JADX INFO: renamed from: access$toSize-XkaWNTQ$jd, reason: not valid java name */
        public static /* synthetic */ long m6301access$toSizeXkaWNTQ$jd(MeasureScope r100, long r101) {
            return Density.CC.m7515$default$toSizeXkaWNTQ(r100, r101);
        }

        /* JADX INFO: renamed from: access$toSp-0xMU5do$jd, reason: not valid java name */
        public static /* synthetic */ long m6302access$toSp0xMU5do$jd(MeasureScope r100, float r101) {
            return FontScaling.CC.m7654$default$toSp0xMU5do(r100, r101);
        }

        /* JADX INFO: renamed from: access$toSp-kPz2Gy4$jd, reason: not valid java name */
        public static /* synthetic */ long m6303access$toSpkPz2Gy4$jd(MeasureScope r100, float r101) {
            return Density.CC.m7516$default$toSpkPz2Gy4(r100, r101);
        }

        /* JADX INFO: renamed from: access$toDp-u2uoSUM$jd, reason: not valid java name */
        public static /* synthetic */ float m6297access$toDpu2uoSUM$jd(MeasureScope r100, int r101) {
            return Density.CC.m7511$default$toDpu2uoSUM(r100, r101);
        }

        /* JADX INFO: renamed from: access$toSp-kPz2Gy4$jd, reason: not valid java name */
        public static /* synthetic */ long m6304access$toSpkPz2Gy4$jd(MeasureScope r100, int r101) {
            return Density.CC.m7517$default$toSpkPz2Gy4(r100, r101);
        }

        public static MeasureResult $default$layout(MeasureScope r100, int r101, int r102, Map r103, Function1 r110) {
            return r100.layout(r101, r102, r103, null, r110);
        }

        public static /* synthetic */ MeasureResult access$layout$jd(MeasureScope r100, int r101, int r102, Map r103, Function1 r104) {
            return $default$layout(r100, r101, r102, r103, r104);
        }

        public static MeasureResult $default$layout(final MeasureScope r100, final int r101, final int r110, final Map r111, final Function1 r112, final Function1 r113) {
            if ((r101 & (-16777216)) == 0) goto L5;
        L7:
            boolean r102 = false;
        L8:
            if (r102 == true) goto L11;
            InlineClassHelperKt.throwIllegalStateException("Size(" + r101 + " x " + r110 + ") is out of range. Each dimension must be between 0 and 16777215.");
        L11:
            return new AnonymousClass1(r101, r110, r111, r112, r100, r113);
        L5:
            if (((-16777216) & r110) != 0) goto L7;
            r102 = true;
            goto L8
        }

        public static /* synthetic */ MeasureResult access$layout$jd(MeasureScope r100, int r101, int r102, Map r103, Function1 r104, Function1 r105) {
            return $default$layout(r100, r101, r102, r103, r104, r105);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ MeasureResult layout$default(MeasureScope r100, int r101, int r102, Map r103, Function1 r104, int r105, Object r106) {
            if (r106 != null) goto L9;
            if ((r105 & 4) == 0) goto L7;
            r103 = MapsKt.emptyMap();
        L7:
            return r100.layout(r101, r102, r103, r104);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: layout");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ MeasureResult layout$default(MeasureScope r100, int r101, int r102, Map r103, Function1 r110, Function1 r111, int r112, Object r113) {
            if (r113 != null) goto L12;
            if ((r112 & 4) == 0) goto L6;
            r103 = MapsKt.emptyMap();
        L6:
            Map r104 = r103;
            if ((r112 & 8) == 0) goto L10;
            r110 = null;
        L10:
            return r100.layout(r101, r102, r104, r110, r111);
        L12:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: layout");
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static boolean isLookingAhead(MeasureScope r100) {
            return CC.access$isLookingAhead$jd(r100);
        }

        /* JADX INFO: renamed from: roundToPx--R2X_6o, reason: not valid java name */
        public static int m6305roundToPxR2X_6o(MeasureScope r100, long r101) {
            return CC.m6293access$roundToPxR2X_6o$jd(r100, r101);
        }

        /* JADX INFO: renamed from: roundToPx-0680j_4, reason: not valid java name */
        public static int m6306roundToPx0680j_4(MeasureScope r100, float r101) {
            return CC.m6294access$roundToPx0680j_4$jd(r100, r101);
        }

        /* JADX INFO: renamed from: toDp-GaN1DYA, reason: not valid java name */
        public static float m6307toDpGaN1DYA(MeasureScope r100, long r101) {
            return CC.m6295access$toDpGaN1DYA$jd(r100, r101);
        }

        /* JADX INFO: renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m6308toDpu2uoSUM(MeasureScope r100, float r101) {
            return CC.m6296access$toDpu2uoSUM$jd(r100, r101);
        }

        /* JADX INFO: renamed from: toDpSize-k-rfVVM, reason: not valid java name */
        public static long m6310toDpSizekrfVVM(MeasureScope r100, long r101) {
            return CC.m6298access$toDpSizekrfVVM$jd(r100, r101);
        }

        /* JADX INFO: renamed from: toPx--R2X_6o, reason: not valid java name */
        public static float m6311toPxR2X_6o(MeasureScope r100, long r101) {
            return CC.m6299access$toPxR2X_6o$jd(r100, r101);
        }

        /* JADX INFO: renamed from: toPx-0680j_4, reason: not valid java name */
        public static float m6312toPx0680j_4(MeasureScope r100, float r101) {
            return CC.m6300access$toPx0680j_4$jd(r100, r101);
        }

        public static Rect toRect(MeasureScope r100, DpRect r101) {
            return CC.access$toRect$jd(r100, r101);
        }

        /* JADX INFO: renamed from: toSize-XkaWNTQ, reason: not valid java name */
        public static long m6313toSizeXkaWNTQ(MeasureScope r100, long r101) {
            return CC.m6301access$toSizeXkaWNTQ$jd(r100, r101);
        }

        /* JADX INFO: renamed from: toSp-0xMU5do, reason: not valid java name */
        public static long m6314toSp0xMU5do(MeasureScope r100, float r101) {
            return CC.m6302access$toSp0xMU5do$jd(r100, r101);
        }

        /* JADX INFO: renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m6315toSpkPz2Gy4(MeasureScope r100, float r101) {
            return CC.m6303access$toSpkPz2Gy4$jd(r100, r101);
        }

        /* JADX INFO: renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m6309toDpu2uoSUM(MeasureScope r100, int r101) {
            return CC.m6297access$toDpu2uoSUM$jd(r100, r101);
        }

        /* JADX INFO: renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m6316toSpkPz2Gy4(MeasureScope r100, int r101) {
            return CC.m6304access$toSpkPz2Gy4$jd(r100, r101);
        }

        public static MeasureResult layout(MeasureScope r100, int r101, int r102, Map<AlignmentLine, Integer> r103, Function1<? super Placeable.PlacementScope, Unit> r104) {
            return CC.access$layout$jd(r100, r101, r102, r103, r104);
        }

        public static MeasureResult layout(MeasureScope r100, int r101, int r102, Map<AlignmentLine, Integer> r103, Function1<? super RulerScope, Unit> r104, Function1<? super Placeable.PlacementScope, Unit> r105) {
            return CC.access$layout$jd(r100, r101, r102, r103, r104, r105);
        }

        public static /* synthetic */ MeasureResult layout$default(MeasureScope r100, int r101, int r102, Map r103, Function1 r104, int r105, Object r106) {
            return CC.layout$default(r100, r101, r102, r103, r104, r105, r106);
        }

        public static /* synthetic */ MeasureResult layout$default(MeasureScope r100, int r101, int r102, Map r103, Function1 r104, Function1 r105, int r106, Object r107) {
            return CC.layout$default(r100, r101, r102, r103, r104, r105, r106, r107);
        }
    }

    MeasureResult layout(int r100, int r101, Map<AlignmentLine, Integer> r102, Function1<? super Placeable.PlacementScope, Unit> r103);

    MeasureResult layout(int r100, int r101, Map<AlignmentLine, Integer> r102, Function1<? super RulerScope, Unit> r103, Function1<? super Placeable.PlacementScope, Unit> r104);
}
