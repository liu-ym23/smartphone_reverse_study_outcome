package androidx.compose.ui.platform;

import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0012\u0010\b\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0005R\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0005R\u0014\u0010\u0013\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\rR\u0014\u0010\u0015\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\rR\u0014\u0010\u0017\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\rø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0019À\u0006\u0003"}, d2 = {"Landroidx/compose/ui/platform/ViewConfiguration;", "", "longPressTimeoutMillis", "", "getLongPressTimeoutMillis", "()J", "doubleTapTimeoutMillis", "getDoubleTapTimeoutMillis", "doubleTapMinTimeMillis", "getDoubleTapMinTimeMillis", "touchSlop", "", "getTouchSlop", "()F", "handwritingSlop", "getHandwritingSlop", "minimumTouchTargetSize", "Landroidx/compose/ui/unit/DpSize;", "getMinimumTouchTargetSize-MYxV2XQ", "maximumFlingVelocity", "getMaximumFlingVelocity", "minimumFlingVelocity", "getMinimumFlingVelocity", "handwritingGestureLineMargin", "getHandwritingGestureLineMargin", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface ViewConfiguration {

    /* JADX INFO: renamed from: androidx.compose.ui.platform.ViewConfiguration$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static float $default$getHandwritingGestureLineMargin(ViewConfiguration r100) {
            return 16.0f;
        }

        public static float $default$getHandwritingSlop(ViewConfiguration r100) {
            return 2.0f;
        }

        public static float $default$getMaximumFlingVelocity(ViewConfiguration r100) {
            return Float.MAX_VALUE;
        }

        public static float $default$getMinimumFlingVelocity(ViewConfiguration r100) {
            return 0.0f;
        }

        /* JADX INFO: renamed from: $default$getMinimumTouchTargetSize-MYxV2XQ, reason: not valid java name */
        public static long m6746$default$getMinimumTouchTargetSizeMYxV2XQ(ViewConfiguration r100) {
            float r101 = 48;
            return DpKt.m7566DpSizeYgX7TsA(Dp.m7544constructorimpl(r101), Dp.m7544constructorimpl(r101));
        }

        public static /* synthetic */ float access$getHandwritingGestureLineMargin$jd(ViewConfiguration r100) {
            return $default$getHandwritingGestureLineMargin(r100);
        }

        public static /* synthetic */ float access$getHandwritingSlop$jd(ViewConfiguration r100) {
            return $default$getHandwritingSlop(r100);
        }

        public static /* synthetic */ float access$getMaximumFlingVelocity$jd(ViewConfiguration r100) {
            return $default$getMaximumFlingVelocity(r100);
        }

        public static /* synthetic */ float access$getMinimumFlingVelocity$jd(ViewConfiguration r100) {
            return $default$getMinimumFlingVelocity(r100);
        }

        /* JADX INFO: renamed from: access$getMinimumTouchTargetSize-MYxV2XQ$jd, reason: not valid java name */
        public static /* synthetic */ long m6747access$getMinimumTouchTargetSizeMYxV2XQ$jd(ViewConfiguration r100) {
            return m6746$default$getMinimumTouchTargetSizeMYxV2XQ(r100);
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static float getHandwritingGestureLineMargin(ViewConfiguration r100) {
            return CC.access$getHandwritingGestureLineMargin$jd(r100);
        }

        public static float getHandwritingSlop(ViewConfiguration r100) {
            return CC.access$getHandwritingSlop$jd(r100);
        }

        public static float getMaximumFlingVelocity(ViewConfiguration r100) {
            return CC.access$getMaximumFlingVelocity$jd(r100);
        }

        public static float getMinimumFlingVelocity(ViewConfiguration r100) {
            return CC.access$getMinimumFlingVelocity$jd(r100);
        }

        /* JADX INFO: renamed from: getMinimumTouchTargetSize-MYxV2XQ, reason: not valid java name */
        public static long m6748getMinimumTouchTargetSizeMYxV2XQ(ViewConfiguration r100) {
            return CC.m6747access$getMinimumTouchTargetSizeMYxV2XQ$jd(r100);
        }
    }

    long getDoubleTapMinTimeMillis();

    long getDoubleTapTimeoutMillis();

    float getHandwritingGestureLineMargin();

    float getHandwritingSlop();

    long getLongPressTimeoutMillis();

    float getMaximumFlingVelocity();

    float getMinimumFlingVelocity();

    /* JADX INFO: renamed from: getMinimumTouchTargetSize-MYxV2XQ */
    long mo6472getMinimumTouchTargetSizeMYxV2XQ();

    float getTouchSlop();
}
