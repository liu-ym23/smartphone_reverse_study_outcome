package androidx.compose.ui.input.pointer;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpRect;
import androidx.compose.ui.unit.FontScaling;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0011\u001a\u00020\n2\b\b\u0002\u0010\u0012\u001a\u00020\u0013H¦@¢\u0006\u0002\u0010\u0014JG\u0010\u0015\u001a\u0004\u0018\u0001H\u0016\"\u0004\b\u0000\u0010\u00162\u0006\u0010\u0017\u001a\u00020\u00182'\u0010\u0019\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00160\u001b\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u001a¢\u0006\u0002\b\u001dH\u0096@¢\u0006\u0002\u0010\u001eJE\u0010\u001f\u001a\u0002H\u0016\"\u0004\b\u0000\u0010\u00162\u0006\u0010\u0017\u001a\u00020\u00182'\u0010\u0019\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00160\u001b\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u001a¢\u0006\u0002\b\u001dH\u0096@¢\u0006\u0002\u0010\u001eR\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0005R\u0012\u0010\t\u001a\u00020\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0012\u0010\r\u001a\u00020\u000eX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006 À\u0006\u0003"}, d2 = {"Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "Landroidx/compose/ui/unit/Density;", "size", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g", "()J", "extendedTouchPadding", "Landroidx/compose/ui/geometry/Size;", "getExtendedTouchPadding-NH-jbRc", "currentEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "getCurrentEvent", "()Landroidx/compose/ui/input/pointer/PointerEvent;", "viewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "getViewConfiguration", "()Landroidx/compose/ui/platform/ViewConfiguration;", "awaitPointerEvent", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "(Landroidx/compose/ui/input/pointer/PointerEventPass;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withTimeoutOrNull", ExifInterface.GPS_DIRECTION_TRUE, "timeMillis", "", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(JLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withTimeout", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface AwaitPointerEventScope extends Density {

    /* JADX INFO: renamed from: androidx.compose.ui.input.pointer.AwaitPointerEventScope$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static Object $default$withTimeout(AwaitPointerEventScope r100, long r101, Function2 r102, Continuation r103) {
            return withTimeout$suspendImpl(r100, r101, r102, r103);
        }

        public static Object $default$withTimeoutOrNull(AwaitPointerEventScope r100, long r101, Function2 r102, Continuation r103) {
            return withTimeoutOrNull$suspendImpl(r100, r101, r102, r103);
        }

        /* JADX INFO: renamed from: $default$getExtendedTouchPadding-NH-jbRc, reason: not valid java name */
        public static long m6022$default$getExtendedTouchPaddingNHjbRc(AwaitPointerEventScope r100) {
            return Size.Companion.m4660getZeroNHjbRc();
        }

        /* JADX INFO: renamed from: access$getExtendedTouchPadding-NH-jbRc$jd, reason: not valid java name */
        public static /* synthetic */ long m6023access$getExtendedTouchPaddingNHjbRc$jd(AwaitPointerEventScope r100) {
            return m6022$default$getExtendedTouchPaddingNHjbRc(r100);
        }

        /* JADX INFO: renamed from: access$roundToPx--R2X_6o$jd, reason: not valid java name */
        public static /* synthetic */ int m6024access$roundToPxR2X_6o$jd(AwaitPointerEventScope r100, long r101) {
            return Density.CC.m7508$default$roundToPxR2X_6o(r100, r101);
        }

        /* JADX INFO: renamed from: access$roundToPx-0680j_4$jd, reason: not valid java name */
        public static /* synthetic */ int m6025access$roundToPx0680j_4$jd(AwaitPointerEventScope r100, float r101) {
            return Density.CC.m7509$default$roundToPx0680j_4(r100, r101);
        }

        /* JADX INFO: renamed from: access$toDp-GaN1DYA$jd, reason: not valid java name */
        public static /* synthetic */ float m6026access$toDpGaN1DYA$jd(AwaitPointerEventScope r100, long r101) {
            return FontScaling.CC.m7653$default$toDpGaN1DYA(r100, r101);
        }

        /* JADX INFO: renamed from: access$toDp-u2uoSUM$jd, reason: not valid java name */
        public static /* synthetic */ float m6027access$toDpu2uoSUM$jd(AwaitPointerEventScope r100, float r101) {
            return Density.CC.m7510$default$toDpu2uoSUM(r100, r101);
        }

        /* JADX INFO: renamed from: access$toDpSize-k-rfVVM$jd, reason: not valid java name */
        public static /* synthetic */ long m6029access$toDpSizekrfVVM$jd(AwaitPointerEventScope r100, long r101) {
            return Density.CC.m7512$default$toDpSizekrfVVM(r100, r101);
        }

        /* JADX INFO: renamed from: access$toPx--R2X_6o$jd, reason: not valid java name */
        public static /* synthetic */ float m6030access$toPxR2X_6o$jd(AwaitPointerEventScope r100, long r101) {
            return Density.CC.m7513$default$toPxR2X_6o(r100, r101);
        }

        /* JADX INFO: renamed from: access$toPx-0680j_4$jd, reason: not valid java name */
        public static /* synthetic */ float m6031access$toPx0680j_4$jd(AwaitPointerEventScope r100, float r101) {
            return Density.CC.m7514$default$toPx0680j_4(r100, r101);
        }

        public static /* synthetic */ Rect access$toRect$jd(AwaitPointerEventScope r100, DpRect r101) {
            return Density.CC.$default$toRect(r100, r101);
        }

        /* JADX INFO: renamed from: access$toSize-XkaWNTQ$jd, reason: not valid java name */
        public static /* synthetic */ long m6032access$toSizeXkaWNTQ$jd(AwaitPointerEventScope r100, long r101) {
            return Density.CC.m7515$default$toSizeXkaWNTQ(r100, r101);
        }

        /* JADX INFO: renamed from: access$toSp-0xMU5do$jd, reason: not valid java name */
        public static /* synthetic */ long m6033access$toSp0xMU5do$jd(AwaitPointerEventScope r100, float r101) {
            return FontScaling.CC.m7654$default$toSp0xMU5do(r100, r101);
        }

        /* JADX INFO: renamed from: access$toSp-kPz2Gy4$jd, reason: not valid java name */
        public static /* synthetic */ long m6034access$toSpkPz2Gy4$jd(AwaitPointerEventScope r100, float r101) {
            return Density.CC.m7516$default$toSpkPz2Gy4(r100, r101);
        }

        /* JADX INFO: renamed from: access$toDp-u2uoSUM$jd, reason: not valid java name */
        public static /* synthetic */ float m6028access$toDpu2uoSUM$jd(AwaitPointerEventScope r100, int r101) {
            return Density.CC.m7511$default$toDpu2uoSUM(r100, r101);
        }

        /* JADX INFO: renamed from: access$toSp-kPz2Gy4$jd, reason: not valid java name */
        public static /* synthetic */ long m6035access$toSpkPz2Gy4$jd(AwaitPointerEventScope r100, int r101) {
            return Density.CC.m7517$default$toSpkPz2Gy4(r100, r101);
        }

        public static /* synthetic */ Object access$withTimeout$jd(AwaitPointerEventScope r100, long r101, Function2 r102, Continuation r103) {
            return $default$withTimeout(r100, r101, r102, r103);
        }

        public static /* synthetic */ Object access$withTimeoutOrNull$jd(AwaitPointerEventScope r100, long r101, Function2 r102, Continuation r103) {
            return $default$withTimeoutOrNull(r100, r101, r102, r103);
        }

        public static /* synthetic */ <T> Object withTimeout$suspendImpl(AwaitPointerEventScope r100, long r101, Function2<? super AwaitPointerEventScope, ? super Continuation<? super T>, ? extends Object> r102, Continuation<? super T> r103) {
            return r102.invoke(r100, r103);
        }

        public static /* synthetic */ <T> Object withTimeoutOrNull$suspendImpl(AwaitPointerEventScope r100, long r101, Function2<? super AwaitPointerEventScope, ? super Continuation<? super T>, ? extends Object> r102, Continuation<? super T> r103) {
            return r102.invoke(r100, r103);
        }

        public static /* synthetic */ Object awaitPointerEvent$default(AwaitPointerEventScope r100, PointerEventPass r101, Continuation r102, int r103, Object r104) {
            if (r104 != null) goto L9;
            if ((r103 & 1) == 0) goto L7;
            r101 = PointerEventPass.Main;
        L7:
            return r100.awaitPointerEvent(r101, r102);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: awaitPointerEvent");
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        /* JADX INFO: renamed from: getExtendedTouchPadding-NH-jbRc, reason: not valid java name */
        public static long m6036getExtendedTouchPaddingNHjbRc(AwaitPointerEventScope r100) {
            return CC.m6023access$getExtendedTouchPaddingNHjbRc$jd(r100);
        }

        /* JADX INFO: renamed from: roundToPx--R2X_6o, reason: not valid java name */
        public static int m6037roundToPxR2X_6o(AwaitPointerEventScope r100, long r101) {
            return CC.m6024access$roundToPxR2X_6o$jd(r100, r101);
        }

        /* JADX INFO: renamed from: roundToPx-0680j_4, reason: not valid java name */
        public static int m6038roundToPx0680j_4(AwaitPointerEventScope r100, float r101) {
            return CC.m6025access$roundToPx0680j_4$jd(r100, r101);
        }

        /* JADX INFO: renamed from: toDp-GaN1DYA, reason: not valid java name */
        public static float m6039toDpGaN1DYA(AwaitPointerEventScope r100, long r101) {
            return CC.m6026access$toDpGaN1DYA$jd(r100, r101);
        }

        /* JADX INFO: renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m6040toDpu2uoSUM(AwaitPointerEventScope r100, float r101) {
            return CC.m6027access$toDpu2uoSUM$jd(r100, r101);
        }

        /* JADX INFO: renamed from: toDpSize-k-rfVVM, reason: not valid java name */
        public static long m6042toDpSizekrfVVM(AwaitPointerEventScope r100, long r101) {
            return CC.m6029access$toDpSizekrfVVM$jd(r100, r101);
        }

        /* JADX INFO: renamed from: toPx--R2X_6o, reason: not valid java name */
        public static float m6043toPxR2X_6o(AwaitPointerEventScope r100, long r101) {
            return CC.m6030access$toPxR2X_6o$jd(r100, r101);
        }

        /* JADX INFO: renamed from: toPx-0680j_4, reason: not valid java name */
        public static float m6044toPx0680j_4(AwaitPointerEventScope r100, float r101) {
            return CC.m6031access$toPx0680j_4$jd(r100, r101);
        }

        public static Rect toRect(AwaitPointerEventScope r100, DpRect r101) {
            return CC.access$toRect$jd(r100, r101);
        }

        /* JADX INFO: renamed from: toSize-XkaWNTQ, reason: not valid java name */
        public static long m6045toSizeXkaWNTQ(AwaitPointerEventScope r100, long r101) {
            return CC.m6032access$toSizeXkaWNTQ$jd(r100, r101);
        }

        /* JADX INFO: renamed from: toSp-0xMU5do, reason: not valid java name */
        public static long m6046toSp0xMU5do(AwaitPointerEventScope r100, float r101) {
            return CC.m6033access$toSp0xMU5do$jd(r100, r101);
        }

        /* JADX INFO: renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m6047toSpkPz2Gy4(AwaitPointerEventScope r100, float r101) {
            return CC.m6034access$toSpkPz2Gy4$jd(r100, r101);
        }

        /* JADX INFO: renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m6041toDpu2uoSUM(AwaitPointerEventScope r100, int r101) {
            return CC.m6028access$toDpu2uoSUM$jd(r100, r101);
        }

        /* JADX INFO: renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m6048toSpkPz2Gy4(AwaitPointerEventScope r100, int r101) {
            return CC.m6035access$toSpkPz2Gy4$jd(r100, r101);
        }

        public static <T> Object withTimeout(AwaitPointerEventScope r100, long r101, Function2<? super AwaitPointerEventScope, ? super Continuation<? super T>, ? extends Object> r102, Continuation<? super T> r103) {
            return CC.access$withTimeout$jd(r100, r101, r102, r103);
        }

        public static <T> Object withTimeoutOrNull(AwaitPointerEventScope r100, long r101, Function2<? super AwaitPointerEventScope, ? super Continuation<? super T>, ? extends Object> r102, Continuation<? super T> r103) {
            return CC.access$withTimeoutOrNull$jd(r100, r101, r102, r103);
        }

        public static /* synthetic */ Object awaitPointerEvent$default(AwaitPointerEventScope r100, PointerEventPass r101, Continuation r102, int r103, Object r104) {
            return CC.awaitPointerEvent$default(r100, r101, r102, r103, r104);
        }
    }

    Object awaitPointerEvent(PointerEventPass r100, Continuation<? super PointerEvent> r101);

    PointerEvent getCurrentEvent();

    /* JADX INFO: renamed from: getExtendedTouchPadding-NH-jbRc, reason: not valid java name */
    long mo6020getExtendedTouchPaddingNHjbRc();

    /* JADX INFO: renamed from: getSize-YbymL2g, reason: not valid java name */
    long mo6021getSizeYbymL2g();

    ViewConfiguration getViewConfiguration();

    <T> Object withTimeout(long r100, Function2<? super AwaitPointerEventScope, ? super Continuation<? super T>, ? extends Object> r101, Continuation<? super T> r102);

    <T> Object withTimeoutOrNull(long r100, Function2<? super AwaitPointerEventScope, ? super Continuation<? super T>, ? extends Object> r101, Continuation<? super T> r102);
}
