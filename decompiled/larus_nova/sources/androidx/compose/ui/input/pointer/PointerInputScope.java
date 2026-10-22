package androidx.compose.ui.input.pointer;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpRect;
import androidx.compose.ui.unit.FontScaling;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J=\u0010\u0016\u001a\u0002H\u0017\"\u0004\b\u0000\u0010\u00172'\u0010\u0018\u001a#\b\u0001\u0012\u0004\u0012\u00020\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00170\u001b\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u0019¢\u0006\u0002\b\u001dH¦@¢\u0006\u0002\u0010\u001eR\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0005R\u0012\u0010\t\u001a\u00020\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR*\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e8V@VX\u0097\u000e¢\u0006\u0012\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u001fÀ\u0006\u0003"}, d2 = {"Landroidx/compose/ui/input/pointer/PointerInputScope;", "Landroidx/compose/ui/unit/Density;", "size", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g", "()J", "extendedTouchPadding", "Landroidx/compose/ui/geometry/Size;", "getExtendedTouchPadding-NH-jbRc", "viewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "getViewConfiguration", "()Landroidx/compose/ui/platform/ViewConfiguration;", "_", "", "interceptOutOfBoundsChildEvents", "getInterceptOutOfBoundsChildEvents$annotations", "()V", "getInterceptOutOfBoundsChildEvents", "()Z", "setInterceptOutOfBoundsChildEvents", "(Z)V", "awaitPointerEventScope", "R", "block", "Lkotlin/Function2;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface PointerInputScope extends Density {

    /* JADX INFO: renamed from: androidx.compose.ui.input.pointer.PointerInputScope$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static boolean $default$getInterceptOutOfBoundsChildEvents(PointerInputScope r100) {
            return false;
        }

        public static void $default$setInterceptOutOfBoundsChildEvents(PointerInputScope r100, boolean r101) {
        }

        /* JADX INFO: renamed from: $default$getExtendedTouchPadding-NH-jbRc, reason: not valid java name */
        public static long m6150$default$getExtendedTouchPaddingNHjbRc(PointerInputScope r100) {
            return Size.Companion.m4660getZeroNHjbRc();
        }

        /* JADX INFO: renamed from: access$getExtendedTouchPadding-NH-jbRc$jd, reason: not valid java name */
        public static /* synthetic */ long m6151access$getExtendedTouchPaddingNHjbRc$jd(PointerInputScope r100) {
            return m6150$default$getExtendedTouchPaddingNHjbRc(r100);
        }

        public static /* synthetic */ boolean access$getInterceptOutOfBoundsChildEvents$jd(PointerInputScope r100) {
            return $default$getInterceptOutOfBoundsChildEvents(r100);
        }

        /* JADX INFO: renamed from: access$roundToPx--R2X_6o$jd, reason: not valid java name */
        public static /* synthetic */ int m6152access$roundToPxR2X_6o$jd(PointerInputScope r100, long r101) {
            return Density.CC.m7508$default$roundToPxR2X_6o(r100, r101);
        }

        /* JADX INFO: renamed from: access$roundToPx-0680j_4$jd, reason: not valid java name */
        public static /* synthetic */ int m6153access$roundToPx0680j_4$jd(PointerInputScope r100, float r101) {
            return Density.CC.m7509$default$roundToPx0680j_4(r100, r101);
        }

        public static /* synthetic */ void access$setInterceptOutOfBoundsChildEvents$jd(PointerInputScope r100, boolean r101) {
            $default$setInterceptOutOfBoundsChildEvents(r100, r101);
        }

        /* JADX INFO: renamed from: access$toDp-GaN1DYA$jd, reason: not valid java name */
        public static /* synthetic */ float m6154access$toDpGaN1DYA$jd(PointerInputScope r100, long r101) {
            return FontScaling.CC.m7653$default$toDpGaN1DYA(r100, r101);
        }

        /* JADX INFO: renamed from: access$toDp-u2uoSUM$jd, reason: not valid java name */
        public static /* synthetic */ float m6155access$toDpu2uoSUM$jd(PointerInputScope r100, float r101) {
            return Density.CC.m7510$default$toDpu2uoSUM(r100, r101);
        }

        /* JADX INFO: renamed from: access$toDpSize-k-rfVVM$jd, reason: not valid java name */
        public static /* synthetic */ long m6157access$toDpSizekrfVVM$jd(PointerInputScope r100, long r101) {
            return Density.CC.m7512$default$toDpSizekrfVVM(r100, r101);
        }

        /* JADX INFO: renamed from: access$toPx--R2X_6o$jd, reason: not valid java name */
        public static /* synthetic */ float m6158access$toPxR2X_6o$jd(PointerInputScope r100, long r101) {
            return Density.CC.m7513$default$toPxR2X_6o(r100, r101);
        }

        /* JADX INFO: renamed from: access$toPx-0680j_4$jd, reason: not valid java name */
        public static /* synthetic */ float m6159access$toPx0680j_4$jd(PointerInputScope r100, float r101) {
            return Density.CC.m7514$default$toPx0680j_4(r100, r101);
        }

        public static /* synthetic */ Rect access$toRect$jd(PointerInputScope r100, DpRect r101) {
            return Density.CC.$default$toRect(r100, r101);
        }

        /* JADX INFO: renamed from: access$toSize-XkaWNTQ$jd, reason: not valid java name */
        public static /* synthetic */ long m6160access$toSizeXkaWNTQ$jd(PointerInputScope r100, long r101) {
            return Density.CC.m7515$default$toSizeXkaWNTQ(r100, r101);
        }

        /* JADX INFO: renamed from: access$toSp-0xMU5do$jd, reason: not valid java name */
        public static /* synthetic */ long m6161access$toSp0xMU5do$jd(PointerInputScope r100, float r101) {
            return FontScaling.CC.m7654$default$toSp0xMU5do(r100, r101);
        }

        /* JADX INFO: renamed from: access$toSp-kPz2Gy4$jd, reason: not valid java name */
        public static /* synthetic */ long m6162access$toSpkPz2Gy4$jd(PointerInputScope r100, float r101) {
            return Density.CC.m7516$default$toSpkPz2Gy4(r100, r101);
        }

        /* JADX INFO: renamed from: access$toDp-u2uoSUM$jd, reason: not valid java name */
        public static /* synthetic */ float m6156access$toDpu2uoSUM$jd(PointerInputScope r100, int r101) {
            return Density.CC.m7511$default$toDpu2uoSUM(r100, r101);
        }

        /* JADX INFO: renamed from: access$toSp-kPz2Gy4$jd, reason: not valid java name */
        public static /* synthetic */ long m6163access$toSpkPz2Gy4$jd(PointerInputScope r100, int r101) {
            return Density.CC.m7517$default$toSpkPz2Gy4(r100, r101);
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void getInterceptOutOfBoundsChildEvents$annotations() {
        }

        /* JADX INFO: renamed from: getExtendedTouchPadding-NH-jbRc, reason: not valid java name */
        public static long m6164getExtendedTouchPaddingNHjbRc(PointerInputScope r100) {
            return CC.m6151access$getExtendedTouchPaddingNHjbRc$jd(r100);
        }

        public static boolean getInterceptOutOfBoundsChildEvents(PointerInputScope r100) {
            return CC.access$getInterceptOutOfBoundsChildEvents$jd(r100);
        }

        /* JADX INFO: renamed from: roundToPx--R2X_6o, reason: not valid java name */
        public static int m6165roundToPxR2X_6o(PointerInputScope r100, long r101) {
            return CC.m6152access$roundToPxR2X_6o$jd(r100, r101);
        }

        /* JADX INFO: renamed from: roundToPx-0680j_4, reason: not valid java name */
        public static int m6166roundToPx0680j_4(PointerInputScope r100, float r101) {
            return CC.m6153access$roundToPx0680j_4$jd(r100, r101);
        }

        public static void setInterceptOutOfBoundsChildEvents(PointerInputScope r100, boolean r101) {
            CC.access$setInterceptOutOfBoundsChildEvents$jd(r100, r101);
        }

        /* JADX INFO: renamed from: toDp-GaN1DYA, reason: not valid java name */
        public static float m6167toDpGaN1DYA(PointerInputScope r100, long r101) {
            return CC.m6154access$toDpGaN1DYA$jd(r100, r101);
        }

        /* JADX INFO: renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m6168toDpu2uoSUM(PointerInputScope r100, float r101) {
            return CC.m6155access$toDpu2uoSUM$jd(r100, r101);
        }

        /* JADX INFO: renamed from: toDpSize-k-rfVVM, reason: not valid java name */
        public static long m6170toDpSizekrfVVM(PointerInputScope r100, long r101) {
            return CC.m6157access$toDpSizekrfVVM$jd(r100, r101);
        }

        /* JADX INFO: renamed from: toPx--R2X_6o, reason: not valid java name */
        public static float m6171toPxR2X_6o(PointerInputScope r100, long r101) {
            return CC.m6158access$toPxR2X_6o$jd(r100, r101);
        }

        /* JADX INFO: renamed from: toPx-0680j_4, reason: not valid java name */
        public static float m6172toPx0680j_4(PointerInputScope r100, float r101) {
            return CC.m6159access$toPx0680j_4$jd(r100, r101);
        }

        public static Rect toRect(PointerInputScope r100, DpRect r101) {
            return CC.access$toRect$jd(r100, r101);
        }

        /* JADX INFO: renamed from: toSize-XkaWNTQ, reason: not valid java name */
        public static long m6173toSizeXkaWNTQ(PointerInputScope r100, long r101) {
            return CC.m6160access$toSizeXkaWNTQ$jd(r100, r101);
        }

        /* JADX INFO: renamed from: toSp-0xMU5do, reason: not valid java name */
        public static long m6174toSp0xMU5do(PointerInputScope r100, float r101) {
            return CC.m6161access$toSp0xMU5do$jd(r100, r101);
        }

        /* JADX INFO: renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m6175toSpkPz2Gy4(PointerInputScope r100, float r101) {
            return CC.m6162access$toSpkPz2Gy4$jd(r100, r101);
        }

        /* JADX INFO: renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m6169toDpu2uoSUM(PointerInputScope r100, int r101) {
            return CC.m6156access$toDpu2uoSUM$jd(r100, r101);
        }

        /* JADX INFO: renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m6176toSpkPz2Gy4(PointerInputScope r100, int r101) {
            return CC.m6163access$toSpkPz2Gy4$jd(r100, r101);
        }
    }

    <R> Object awaitPointerEventScope(Function2<? super AwaitPointerEventScope, ? super Continuation<? super R>, ? extends Object> r100, Continuation<? super R> r101);

    /* JADX INFO: renamed from: getExtendedTouchPadding-NH-jbRc */
    long mo361getExtendedTouchPaddingNHjbRc();

    boolean getInterceptOutOfBoundsChildEvents();

    /* JADX INFO: renamed from: getSize-YbymL2g */
    long mo362getSizeYbymL2g();

    ViewConfiguration getViewConfiguration();

    void setInterceptOutOfBoundsChildEvents(boolean r100);
}
