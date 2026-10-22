package androidx.core.view;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

/* JADX INFO: loaded from: classes17.dex */
public class DifferentialMotionFlingController {
    private final Context mContext;
    private final int[] mFlingVelocityThresholds;
    private float mLastFlingVelocity;
    private int mLastProcessedAxis;
    private int mLastProcessedDeviceId;
    private int mLastProcessedSource;
    private final DifferentialMotionFlingTarget mTarget;
    private final DifferentialVelocityProvider mVelocityProvider;
    private final FlingVelocityThresholdCalculator mVelocityThresholdCalculator;
    private VelocityTracker mVelocityTracker;

    public interface DifferentialVelocityProvider {
        float getCurrentVelocity(VelocityTracker r100, MotionEvent r101, int r102);
    }

    public interface FlingVelocityThresholdCalculator {
        void calculateFlingVelocityThresholds(Context r100, int[] r101, MotionEvent r102, int r103);
    }

    public static /* synthetic */ void a(Context r100, int[] r101, MotionEvent r102, int r103) {
        calculateFlingVelocityThresholds(r100, r101, r102, r103);
    }

    public static /* synthetic */ float b(VelocityTracker r100, MotionEvent r101, int r102) {
        return getCurrentVelocity(r100, r101, r102);
    }

    public DifferentialMotionFlingController(Context r100, DifferentialMotionFlingTarget r101) {
        this(r100, r101, new b(), new c());
    }

    private boolean calculateFlingVelocityThresholds(MotionEvent r100, int r101) {
        int r102 = r100.getSource();
        int r103 = r100.getDeviceId();
        if (this.mLastProcessedSource == r102) goto L5;
    L11:
        this.mVelocityThresholdCalculator.calculateFlingVelocityThresholds(this.mContext, this.mFlingVelocityThresholds, r100, r101);
        this.mLastProcessedSource = r102;
        this.mLastProcessedDeviceId = r103;
        this.mLastProcessedAxis = r101;
        return true;
    L5:
        if (this.mLastProcessedDeviceId != r103) goto L11;
        if (this.mLastProcessedAxis != r101) goto L11;
        return false;
    }

    private float getCurrentVelocity(MotionEvent r100, int r101) {
        if (this.mVelocityTracker != null) goto L6;
        this.mVelocityTracker = VelocityTracker.obtain();
    L6:
        return this.mVelocityProvider.getCurrentVelocity(this.mVelocityTracker, r100, r101);
    }

    public void onMotionEvent(MotionEvent r100, int r101) {
        boolean r102 = calculateFlingVelocityThresholds(r100, r101);
        if (this.mFlingVelocityThresholds[0] != Integer.MAX_VALUE) goto L8;
        VelocityTracker r103 = this.mVelocityTracker;
        if (r103 == null) goto L23;
        r103.recycle();
        this.mVelocityTracker = null;
        return;
    L23:
        return;
    L8:
        float r104 = getCurrentVelocity(r100, r101) * this.mTarget.getScaledScrollFactor();
        float r105 = Math.signum(r104);
        float r106 = 0.0f;
        if (r102 == false) goto L11;
    L14:
        this.mTarget.stopDifferentialMotionFling();
    L15:
        float r107 = Math.abs(r104);
        int[] r108 = this.mFlingVelocityThresholds;
        if (r107 >= r108[0]) goto L18;
        return;
    L18:
        int r109 = r108[1];
        float r110 = Math.max(-r109, Math.min(r104, r109));
        if (this.mTarget.startDifferentialMotionFling(r110) == false) goto L21;
        r106 = r110;
    L21:
        this.mLastFlingVelocity = r106;
        return;
    L11:
        if (r105 == Math.signum(this.mLastFlingVelocity)) goto L15;
        if (r105 == 0.0f) goto L15;
        goto L14
    }

    private static float getCurrentVelocity(VelocityTracker r100, MotionEvent r101, int r102) {
        VelocityTrackerCompat.addMovement(r100, r101);
        VelocityTrackerCompat.computeCurrentVelocity(r100, 1000);
        return VelocityTrackerCompat.getAxisVelocity(r100, r102);
    }

    public DifferentialMotionFlingController(Context r100, DifferentialMotionFlingTarget r101, FlingVelocityThresholdCalculator r102, DifferentialVelocityProvider r103) {
        this.mLastProcessedAxis = -1;
        this.mLastProcessedSource = -1;
        this.mLastProcessedDeviceId = -1;
        this.mFlingVelocityThresholds = new int[]{Integer.MAX_VALUE, 0};
        this.mContext = r100;
        this.mTarget = r101;
        this.mVelocityThresholdCalculator = r102;
        this.mVelocityProvider = r103;
    }

    private static void calculateFlingVelocityThresholds(Context r100, int[] r101, MotionEvent r102, int r103) {
        ViewConfiguration r104 = ViewConfiguration.get(r100);
        r101[0] = ViewConfigurationCompat.getScaledMinimumFlingVelocity(r100, r104, r102.getDeviceId(), r103, r102.getSource());
        r101[1] = ViewConfigurationCompat.getScaledMaximumFlingVelocity(r100, r104, r102.getDeviceId(), r103, r102.getSource());
    }
}
