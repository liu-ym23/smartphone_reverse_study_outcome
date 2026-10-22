package androidx.compose.foundation.gestures;

import C7.r;
import J7.c;
import S7.n;
import S7.p;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import o7.s;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\u001aD\u0010\b\u001a\u00020\u0006*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012$\u0010\u0007\u001a \u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0003H\u0086@¢\u0006\u0004\b\b\u0010\t\u001a\u0011\u0010\u000b\u001a\u00020\u0005*\u00020\n¢\u0006\u0004\b\u000b\u0010\f\u001a\u0016\u0010\u000f\u001a\u00020\u0005*\u00020\u0004H\u0002ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a\u0011\u0010\u0010\u001a\u00020\u0005*\u00020\n¢\u0006\u0004\b\u0010\u0010\f\u001a\u0011\u0010\u0011\u001a\u00020\u0004*\u00020\n¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u001b\u0010\u0014\u001a\u00020\u0005*\u00020\n2\b\b\u0002\u0010\u0013\u001a\u00020\u0001¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u001b\u0010\u0016\u001a\u00020\u0004*\u00020\n2\b\b\u0002\u0010\u0013\u001a\u00020\u0001¢\u0006\u0004\b\u0016\u0010\u0017\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0018"}, d2 = {"Landroidx/compose/ui/input/pointer/PointerInputScope;", "", "panZoomLock", "Lkotlin/Function4;", "Landroidx/compose/ui/geometry/Offset;", "", "LC7/r;", "onGesture", "detectTransformGestures", "(Landroidx/compose/ui/input/pointer/PointerInputScope;ZLS7/p;LH7/c;)Ljava/lang/Object;", "Landroidx/compose/ui/input/pointer/PointerEvent;", "calculateRotation", "(Landroidx/compose/ui/input/pointer/PointerEvent;)F", "angle-k-4lQ0M", "(J)F", "angle", "calculateZoom", "calculatePan", "(Landroidx/compose/ui/input/pointer/PointerEvent;)J", "useCurrent", "calculateCentroidSize", "(Landroidx/compose/ui/input/pointer/PointerEvent;Z)F", "calculateCentroid", "(Landroidx/compose/ui/input/pointer/PointerEvent;Z)J", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TransformGestureDetectorKt {

    @c(c = "androidx.compose.foundation.gestures.TransformGestureDetectorKt$detectTransformGestures$2", f = "TransformGestureDetector.kt", l = {59, s.MESSAGE_POST_FIELD_NUMBER}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "LC7/r;", "<anonymous>", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;)V"}, k = 3, mv = {1, 8, 0})
    /* renamed from: androidx.compose.foundation.gestures.TransformGestureDetectorKt$detectTransformGestures$2, reason: invalid class name */
    public static final class AnonymousClass2 extends RestrictedSuspendLambda implements n {
        final /* synthetic */ p $onGesture;
        final /* synthetic */ boolean $panZoomLock;
        float F$0;
        float F$1;
        float F$2;
        int I$0;
        int I$1;
        long J$0;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(boolean z10, p pVar, H7.c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.$panZoomLock = z10;
            this.$onGesture = pVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$panZoomLock, this.$onGesture, cVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // S7.n
        public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, H7.c<? super r> cVar) {
            return ((AnonymousClass2) create(awaitPointerEventScope, cVar)).invokeSuspend(r.f317a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x0091, code lost:
        
            if (r15 == r6) goto L16;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:58:0x015f  */
        /* JADX WARN: Type inference failed for: r8v12 */
        /* JADX WARN: Type inference failed for: r8v3 */
        /* JADX WARN: Type inference failed for: r8v4, types: [int] */
        /* JADX WARN: Type inference failed for: r9v15 */
        /* JADX WARN: Type inference failed for: r9v3 */
        /* JADX WARN: Type inference failed for: r9v4, types: [int] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0091 -> B:17:0x0094). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r25) {
            /*
                Method dump skipped, instructions count: 426
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TransformGestureDetectorKt.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* renamed from: angle-k-4lQ0M, reason: not valid java name */
    private static final float m527anglek4lQ0M(long j5) {
        if (Offset.m3895getXimpl(j5) == 0.0f && Offset.m3896getYimpl(j5) == 0.0f) {
            return 0.0f;
        }
        return ((-((float) Math.atan2(Offset.m3895getXimpl(j5), Offset.m3896getYimpl(j5)))) * 180.0f) / 3.1415927f;
    }

    public static final long calculateCentroid(PointerEvent pointerEvent, boolean z10) {
        long jM3911getZeroF1C5BW0 = Offset.INSTANCE.m3911getZeroF1C5BW0();
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        int i = 0;
        for (int i6 = 0; i6 < size; i6++) {
            PointerInputChange pointerInputChange = changes.get(i6);
            if (pointerInputChange.getPressed() && pointerInputChange.getPreviousPressed()) {
                jM3911getZeroF1C5BW0 = Offset.m3900plusMKHz9U(jM3911getZeroF1C5BW0, z10 ? pointerInputChange.getPosition() : pointerInputChange.getPreviousPosition());
                i++;
            }
        }
        return i == 0 ? Offset.INSTANCE.m3910getUnspecifiedF1C5BW0() : Offset.m3890divtuRUvjQ(jM3911getZeroF1C5BW0, i);
    }

    public static /* synthetic */ long calculateCentroid$default(PointerEvent pointerEvent, boolean z10, int i, Object obj) {
        if ((i & 1) != 0) {
            z10 = true;
        }
        return calculateCentroid(pointerEvent, z10);
    }

    public static final float calculateCentroidSize(PointerEvent pointerEvent, boolean z10) {
        long jCalculateCentroid = calculateCentroid(pointerEvent, z10);
        float fM3893getDistanceimpl = 0.0f;
        if (Offset.m3892equalsimpl0(jCalculateCentroid, Offset.INSTANCE.m3910getUnspecifiedF1C5BW0())) {
            return 0.0f;
        }
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        int i = 0;
        for (int i6 = 0; i6 < size; i6++) {
            PointerInputChange pointerInputChange = changes.get(i6);
            if (pointerInputChange.getPressed() && pointerInputChange.getPreviousPressed()) {
                i++;
                fM3893getDistanceimpl = Offset.m3893getDistanceimpl(Offset.m3899minusMKHz9U(z10 ? pointerInputChange.getPosition() : pointerInputChange.getPreviousPosition(), jCalculateCentroid)) + fM3893getDistanceimpl;
            }
        }
        return fM3893getDistanceimpl / i;
    }

    public static /* synthetic */ float calculateCentroidSize$default(PointerEvent pointerEvent, boolean z10, int i, Object obj) {
        if ((i & 1) != 0) {
            z10 = true;
        }
        return calculateCentroidSize(pointerEvent, z10);
    }

    public static final long calculatePan(PointerEvent pointerEvent) {
        long jCalculateCentroid = calculateCentroid(pointerEvent, true);
        Offset.Companion companion = Offset.INSTANCE;
        return Offset.m3892equalsimpl0(jCalculateCentroid, companion.m3910getUnspecifiedF1C5BW0()) ? companion.m3911getZeroF1C5BW0() : Offset.m3899minusMKHz9U(jCalculateCentroid, calculateCentroid(pointerEvent, false));
    }

    public static final float calculateRotation(PointerEvent pointerEvent) {
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        int i = 0;
        int i6 = 0;
        while (true) {
            int i10 = 1;
            if (i >= size) {
                break;
            }
            PointerInputChange pointerInputChange = changes.get(i);
            if (!pointerInputChange.getPreviousPressed() || !pointerInputChange.getPressed()) {
                i10 = 0;
            }
            i6 += i10;
            i++;
        }
        if (i6 < 2) {
            return 0.0f;
        }
        long jCalculateCentroid = calculateCentroid(pointerEvent, true);
        long jCalculateCentroid2 = calculateCentroid(pointerEvent, false);
        List<PointerInputChange> changes2 = pointerEvent.getChanges();
        int size2 = changes2.size();
        float f = 0.0f;
        float f7 = 0.0f;
        for (int i11 = 0; i11 < size2; i11++) {
            PointerInputChange pointerInputChange2 = changes2.get(i11);
            if (pointerInputChange2.getPressed() && pointerInputChange2.getPreviousPressed()) {
                long position = pointerInputChange2.getPosition();
                long jM3899minusMKHz9U = Offset.m3899minusMKHz9U(pointerInputChange2.getPreviousPosition(), jCalculateCentroid2);
                long jM3899minusMKHz9U2 = Offset.m3899minusMKHz9U(position, jCalculateCentroid);
                float fM527anglek4lQ0M = m527anglek4lQ0M(jM3899minusMKHz9U2) - m527anglek4lQ0M(jM3899minusMKHz9U);
                float fM3893getDistanceimpl = Offset.m3893getDistanceimpl(Offset.m3900plusMKHz9U(jM3899minusMKHz9U2, jM3899minusMKHz9U)) / 2.0f;
                if (fM527anglek4lQ0M > 180.0f) {
                    fM527anglek4lQ0M -= 360.0f;
                } else if (fM527anglek4lQ0M < -180.0f) {
                    fM527anglek4lQ0M += 360.0f;
                }
                f7 += fM527anglek4lQ0M * fM3893getDistanceimpl;
                f += fM3893getDistanceimpl;
            }
        }
        if (f == 0.0f) {
            return 0.0f;
        }
        return f7 / f;
    }

    public static final float calculateZoom(PointerEvent pointerEvent) {
        float fCalculateCentroidSize = calculateCentroidSize(pointerEvent, true);
        float fCalculateCentroidSize2 = calculateCentroidSize(pointerEvent, false);
        if (fCalculateCentroidSize == 0.0f || fCalculateCentroidSize2 == 0.0f) {
            return 1.0f;
        }
        return fCalculateCentroidSize / fCalculateCentroidSize2;
    }

    public static final Object detectTransformGestures(PointerInputScope pointerInputScope, boolean z10, p pVar, H7.c<? super r> cVar) {
        Object objAwaitEachGesture = ForEachGestureKt.awaitEachGesture(pointerInputScope, new AnonymousClass2(z10, pVar, null), cVar);
        return objAwaitEachGesture == CoroutineSingletons.f4909a ? objAwaitEachGesture : r.f317a;
    }

    public static /* synthetic */ Object detectTransformGestures$default(PointerInputScope pointerInputScope, boolean z10, p pVar, H7.c cVar, int i, Object obj) {
        if ((i & 1) != 0) {
            z10 = false;
        }
        return detectTransformGestures(pointerInputScope, z10, pVar, cVar);
    }
}
