package com.android.server.display.color;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.ColorSpace;
import android.hardware.display.ColorDisplayManager;
import android.hardware.display.DisplayManagerInternal;
import android.opengl.Matrix;
import android.util.Slog;
import android.view.SurfaceControl;
import com.android.server.display.feature.DisplayManagerFlags;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes2.dex */
final class DisplayWhiteBalanceTintController extends ColorTemperatureTintController {
    private static final int COLORSPACE_MATRIX_LENGTH = 9;
    private static final int NUM_DISPLAY_PRIMARIES_VALS = 12;
    private static final int NUM_VALUES_PER_PRIMARY = 3;
    private int mAppliedCct;
    private CctEvaluator mCctEvaluator;
    private float[] mChromaticAdaptationMatrix;
    int mCurrentColorTemperature;
    private float[] mCurrentColorTemperatureXYZ;
    ColorSpace.Rgb mDisplayColorSpaceRGB;
    private final DisplayManagerFlags mDisplayManagerFlags;
    private final DisplayManagerInternal mDisplayManagerInternal;
    private int mDisplayNominalWhiteCct;
    float[] mDisplayNominalWhiteXYZ;
    private boolean mIsAllowed;
    private Boolean mIsAvailable;
    private final Object mLock;
    private final float[] mMatrixDisplayWhiteBalance;
    boolean mSetUp;
    private int mTargetCct;
    private int mTemperatureDefault;
    int mTemperatureMax;
    int mTemperatureMin;
    private long mTransitionDuration;
    private long mTransitionDurationDecrease;
    private long mTransitionDurationIncrease;

    DisplayWhiteBalanceTintController(DisplayManagerInternal dm, DisplayManagerFlags displayManagerFlags) {
        this.mLock = new Object();
        this.mDisplayNominalWhiteXYZ = new float[3];
        this.mSetUp = false;
        this.mMatrixDisplayWhiteBalance = new float[16];
        this.mIsAllowed = true;
        this.mDisplayManagerInternal = dm;
        this.mDisplayManagerFlags = displayManagerFlags;
    }

    @Override // com.android.server.display.color.TintController
    public void setUp(Context context, boolean needsLinear) {
        this.mSetUp = false;
        Resources res = context.getResources();
        setAllowed(res.getBoolean(R.bool.config_dontPreferApn));
        ColorSpace.Rgb displayColorSpaceRGB = getDisplayColorSpaceFromSurfaceControl();
        if (displayColorSpaceRGB != null) goto L9;
        Slog.w("ColorDisplayService", "Failed to get display color space from SurfaceControl, trying res");
        ColorSpace.Rgb displayColorSpaceRGB2 = getDisplayColorSpaceFromResources(res);
        if (displayColorSpaceRGB2 != null) goto L8;
        Slog.e("ColorDisplayService", "Failed to get display color space from resources");
        return;
    L8:
        ColorSpace.Rgb displayColorSpaceRGB3 = displayColorSpaceRGB2;
    L11:
        if (isColorMatrixValid(displayColorSpaceRGB3.getTransform()) == true) goto L15;
        Slog.e("ColorDisplayService", "Invalid display color space RGB-to-XYZ transform");
        return;
    L15:
        if (isColorMatrixValid(displayColorSpaceRGB3.getInverseTransform()) == true) goto L18;
        Slog.e("ColorDisplayService", "Invalid display color space XYZ-to-RGB transform");
        return;
    L18:
        String[] nominalWhiteValues = res.getStringArray(R.array.config_dozeTapSensorPostureMapping);
        float[] displayNominalWhiteXYZ = new float[3];
        int i = 0;
    L20:
        if (i >= nominalWhiteValues.length) goto L22;
        displayNominalWhiteXYZ[i] = Float.parseFloat(nominalWhiteValues[i]);
        i = i + 1;
        goto L20
    L22:
        int displayNominalWhiteCct = res.getInteger(R.integer.config_doubleTapPowerGestureMultiTargetDefaultAction);
        int colorTemperatureMin = res.getInteger(R.integer.config_doubleTapMinTimeMillis);
        if (colorTemperatureMin > 0) goto L26;
        Slog.e("ColorDisplayService", "Display white balance minimum temperature must be greater than 0");
        return;
    L26:
        int colorTemperatureMax = res.getInteger(R.integer.config_doublePressOnStemPrimaryBehavior);
        if (colorTemperatureMax >= colorTemperatureMin) goto L30;
        Slog.e("ColorDisplayService", "Display white balance max temp must be greater or equal to min");
        return;
    L30:
        int defaultTemperature = res.getInteger(R.integer.config_dockedStackDividerSnapMode);
        this.mTransitionDuration = res.getInteger(R.integer.config_doublelineClockDefault);
        if (this.mDisplayManagerFlags.isAdaptiveTone2Enabled() == true) goto L33;
        this.mTransitionDurationDecrease = this.mTransitionDuration;
        this.mTransitionDurationIncrease = this.mTransitionDuration;
    L34:
        int[] cctRangeMinimums = res.getIntArray(R.array.config_emergency_iso_country_codes);
        int[] steps = res.getIntArray(R.array.config_enabledCredentialProviderService);
        Object r11 = this.mLock;
        monitor-enter(r11);
        this.mDisplayColorSpaceRGB = displayColorSpaceRGB3;     // Catch: Throwable -> L40
        this.mDisplayNominalWhiteXYZ = displayNominalWhiteXYZ;     // Catch: Throwable -> L40
        this.mDisplayNominalWhiteCct = displayNominalWhiteCct;     // Catch: Throwable -> L40
        this.mTargetCct = this.mDisplayNominalWhiteCct;     // Catch: Throwable -> L40
        this.mAppliedCct = this.mDisplayNominalWhiteCct;     // Catch: Throwable -> L40
        this.mTemperatureMin = colorTemperatureMin;     // Catch: Throwable -> L40
        this.mTemperatureMax = colorTemperatureMax;     // Catch: Throwable -> L40
        this.mTemperatureDefault = defaultTemperature;     // Catch: Throwable -> L40
        this.mSetUp = true;     // Catch: Throwable -> L40
        this.mCctEvaluator = new CctEvaluator(this.mTemperatureMin, this.mTemperatureMax, cctRangeMinimums, steps);     // Catch: Throwable -> L40
        monitor-exit(r11);     // Catch: Throwable -> L40
        setMatrix(this.mTemperatureDefault);
        return;
    L40:
        th = move-exception;
        throw th;
    L33:
        this.mTransitionDurationIncrease = res.getInteger(R.integer.config_downloadDataDirSize);
        this.mTransitionDurationDecrease = res.getInteger(R.integer.config_downloadDataDirLowSpaceThreshold);
        goto L34
    L9:
        displayColorSpaceRGB3 = displayColorSpaceRGB;
        goto L11
    }

    @Override // com.android.server.display.color.TintController
    public float[] getMatrix() {
        if (this.mSetUp == false) goto L10;
        if (isActivated() == false) goto L10;
        computeMatrixForCct(this.mAppliedCct);
        return this.mMatrixDisplayWhiteBalance;
    L10:
        return ColorDisplayService.MATRIX_IDENTITY;
    }

    @Override // com.android.server.display.color.ColorTemperatureTintController
    public int getTargetCct() {
        return this.mTargetCct;
    }

    private static float[] mul3x3(float[] lhs, float[] rhs) {
        float[] r = {((lhs[0] * rhs[0]) + (lhs[3] * rhs[1])) + (lhs[6] * rhs[2]), ((lhs[1] * rhs[0]) + (lhs[4] * rhs[1])) + (lhs[7] * rhs[2]), ((lhs[2] * rhs[0]) + (lhs[5] * rhs[1])) + (lhs[8] * rhs[2]), ((lhs[0] * rhs[3]) + (lhs[3] * rhs[4])) + (lhs[6] * rhs[5]), ((lhs[1] * rhs[3]) + (lhs[4] * rhs[4])) + (lhs[7] * rhs[5]), ((lhs[2] * rhs[3]) + (lhs[5] * rhs[4])) + (lhs[8] * rhs[5]), ((lhs[0] * rhs[6]) + (lhs[3] * rhs[7])) + (lhs[6] * rhs[8]), ((lhs[1] * rhs[6]) + (lhs[4] * rhs[7])) + (lhs[7] * rhs[8]), ((lhs[2] * rhs[6]) + (lhs[5] * rhs[7])) + (lhs[8] * rhs[8])};
        return r;
    }

    @Override // com.android.server.display.color.TintController
    public void setMatrix(int cct) {
        setTargetCct(cct);
        computeMatrixForCct(this.mTargetCct);
    }

    @Override // com.android.server.display.color.ColorTemperatureTintController
    public void setTargetCct(int cct) {
        if (this.mSetUp == true) goto L7;
        Slog.w("ColorDisplayService", "Can't set display white balance temperature: uninitialized");
        return;
    L7:
        if (cct >= this.mTemperatureMin) goto L10;
        Slog.w("ColorDisplayService", "Requested display color temperature is below allowed minimum");
        this.mTargetCct = this.mTemperatureMin;
        return;
    L10:
        if (cct <= this.mTemperatureMax) goto L12;
        Slog.w("ColorDisplayService", "Requested display color temperature is above allowed maximum");
        this.mTargetCct = this.mTemperatureMax;
        return;
    L12:
        this.mTargetCct = cct;
    }

    @Override // com.android.server.display.color.ColorTemperatureTintController
    public int getDisabledCct() {
        return this.mDisplayNominalWhiteCct;
    }

    @Override // com.android.server.display.color.ColorTemperatureTintController
    public float[] computeMatrixForCct(int cct) {
        if (this.mSetUp == false) goto L21;
        if (cct == 0) goto L21;
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mCurrentColorTemperature = cct;     // Catch: Throwable -> L13
        if (cct == this.mDisplayNominalWhiteCct) goto L11;
    L15:
        computeMatrixForCctLocked(cct);     // Catch: Throwable -> L13
    L16:
        Slog.d("ColorDisplayService", "computeDisplayWhiteBalanceMatrix: cct =" + cct + " matrix =" + TintController.matrixToString(this.mMatrixDisplayWhiteBalance, 16));     // Catch: Throwable -> L13
        float[] r1 = this.mMatrixDisplayWhiteBalance;     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        return r1;
    L11:
        if (isActivated() == true) goto L15;
        Matrix.setIdentityM(this.mMatrixDisplayWhiteBalance, 0);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    L21:
        Slog.w("ColorDisplayService", "Couldn't compute matrix for cct=" + cct);
        return ColorDisplayService.MATRIX_IDENTITY;
    }

    private void computeMatrixForCctLocked(int cct) {
        this.mCurrentColorTemperatureXYZ = ColorSpace.cctToXyz(cct);
        this.mChromaticAdaptationMatrix = ColorSpace.chromaticAdaptation(ColorSpace.Adaptation.BRADFORD, this.mDisplayNominalWhiteXYZ, this.mCurrentColorTemperatureXYZ);
        float[] result = mul3x3(this.mChromaticAdaptationMatrix, this.mDisplayColorSpaceRGB.getTransform());
        float[] result2 = mul3x3(this.mDisplayColorSpaceRGB.getInverseTransform(), result);
        float adaptedMaxR = (result2[0] + result2[3]) + result2[6];
        float adaptedMaxG = (result2[1] + result2[4]) + result2[7];
        float adaptedMaxB = (result2[2] + result2[5]) + result2[8];
        float denum = Math.max(Math.max(adaptedMaxR, adaptedMaxG), adaptedMaxB);
        Matrix.setIdentityM(this.mMatrixDisplayWhiteBalance, 0);
        int i = 0;
    L4:
        if (i >= result2.length) goto L10;
        result2[i] = result2[i] / denum;
        if (isColorMatrixCoeffValid(result2[i]) == false) goto L7;
        i = i + 1;
        goto L4
    L7:
        Slog.e("ColorDisplayService", "Invalid DWB color matrix");
        return;
    L10:
        System.arraycopy(result2, 0, this.mMatrixDisplayWhiteBalance, 0, 3);
        System.arraycopy(result2, 3, this.mMatrixDisplayWhiteBalance, 4, 3);
        System.arraycopy(result2, 6, this.mMatrixDisplayWhiteBalance, 8, 3);
    }

    @Override // com.android.server.display.color.ColorTemperatureTintController
    int getAppliedCct() {
        return this.mAppliedCct;
    }

    @Override // com.android.server.display.color.ColorTemperatureTintController
    void setAppliedCct(int cct) {
        this.mAppliedCct = cct;
    }

    @Override // com.android.server.display.color.ColorTemperatureTintController
    CctEvaluator getEvaluator() {
        return this.mCctEvaluator;
    }

    @Override // com.android.server.display.color.TintController
    public int getLevel() {
        return 125;
    }

    @Override // com.android.server.display.color.TintController
    public boolean isAvailable(Context context) {
        if (this.mIsAvailable != null) goto L6;
        this.mIsAvailable = Boolean.valueOf(ColorDisplayManager.isDisplayWhiteBalanceAvailable(context));
    L6:
        return this.mIsAvailable.booleanValue();
    }

    @Override // com.android.server.display.color.TintController
    public long getTransitionDurationMilliseconds() {
        return this.mTransitionDuration;
    }

    @Override // com.android.server.display.color.TintController
    public long getTransitionDurationMilliseconds(boolean isIncreasing) {
        if (isIncreasing == false) goto L5;
        return this.mTransitionDurationIncrease;
    L5:
        return this.mTransitionDurationDecrease;
    }

    @Override // com.android.server.display.color.TintController
    public void dump(PrintWriter pw) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        pw.println("    mSetUp = " + this.mSetUp);     // Catch: Throwable -> L8
        if (this.mSetUp == true) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        pw.println("    mTemperatureMin = " + this.mTemperatureMin);     // Catch: Throwable -> L8
        pw.println("    mTemperatureMax = " + this.mTemperatureMax);     // Catch: Throwable -> L8
        pw.println("    mTemperatureDefault = " + this.mTemperatureDefault);     // Catch: Throwable -> L8
        pw.println("    mDisplayNominalWhiteCct = " + this.mDisplayNominalWhiteCct);     // Catch: Throwable -> L8
        pw.println("    mCurrentColorTemperature = " + this.mCurrentColorTemperature);     // Catch: Throwable -> L8
        pw.println("    mTargetCct = " + this.mTargetCct);     // Catch: Throwable -> L8
        pw.println("    mAppliedCct = " + this.mAppliedCct);     // Catch: Throwable -> L8
        pw.println("    mCurrentColorTemperatureXYZ = " + TintController.matrixToString(this.mCurrentColorTemperatureXYZ, 3));     // Catch: Throwable -> L8
        pw.println("    mDisplayColorSpaceRGB RGB-to-XYZ = " + TintController.matrixToString(this.mDisplayColorSpaceRGB.getTransform(), 3));     // Catch: Throwable -> L8
        pw.println("    mChromaticAdaptationMatrix = " + TintController.matrixToString(this.mChromaticAdaptationMatrix, 3));     // Catch: Throwable -> L8
        pw.println("    mDisplayColorSpaceRGB XYZ-to-RGB = " + TintController.matrixToString(this.mDisplayColorSpaceRGB.getInverseTransform(), 3));     // Catch: Throwable -> L8
        pw.println("    mMatrixDisplayWhiteBalance = " + TintController.matrixToString(this.mMatrixDisplayWhiteBalance, 4));     // Catch: Throwable -> L8
        pw.println("    mIsAllowed = " + this.mIsAllowed);     // Catch: Throwable -> L8
        pw.println("    mTransitionDuration = " + this.mTransitionDuration);     // Catch: Throwable -> L8
        pw.println("    mTransitionDurationIncrease = " + this.mTransitionDurationIncrease);     // Catch: Throwable -> L8
        pw.println("    mTransitionDurationDecrease = " + this.mTransitionDurationDecrease);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public float getLuminance() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mChromaticAdaptationMatrix != null) goto L7;
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return -1.0f;
    L7:
        if (this.mChromaticAdaptationMatrix.length != 9) goto L13;
        float r2 = 1.0f / ((this.mChromaticAdaptationMatrix[1] + this.mChromaticAdaptationMatrix[4]) + this.mChromaticAdaptationMatrix[7]);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r2;
    }

    public void setAllowed(boolean allowed) {
        this.mIsAllowed = allowed;
    }

    public boolean isAllowed() {
        return this.mIsAllowed;
    }

    private ColorSpace.Rgb makeRgbColorSpaceFromXYZ(float[] redGreenBlueXYZ, float[] whiteXYZ) {
        return new ColorSpace.Rgb("Display Color Space", redGreenBlueXYZ, whiteXYZ, 2.200000047683716d);
    }

    private ColorSpace.Rgb getDisplayColorSpaceFromSurfaceControl() {
        SurfaceControl.DisplayPrimaries primaries = this.mDisplayManagerInternal.getDisplayNativePrimaries(0);
        if (primaries != null) goto L5;
        return null;
    L5:
        if (primaries.red != null) goto L7;
        return null;
    L7:
        if (primaries.green != null) goto L9;
        return null;
    L9:
        if (primaries.blue != null) goto L11;
        return null;
    L11:
        if (primaries.white != null) goto L14;
        return null;
    L14:
        return makeRgbColorSpaceFromXYZ(new float[]{primaries.red.X, primaries.red.Y, primaries.red.Z, primaries.green.X, primaries.green.Y, primaries.green.Z, primaries.blue.X, primaries.blue.Y, primaries.blue.Z}, new float[]{primaries.white.X, primaries.white.Y, primaries.white.Z});
    }

    private ColorSpace.Rgb getDisplayColorSpaceFromResources(Resources res) {
        String[] displayPrimariesValues = res.getStringArray(R.array.config_dropboxLowPriorityTags);
        float[] displayRedGreenBlueXYZ = new float[9];
        float[] displayWhiteXYZ = new float[3];
        int i = 0;
    L4:
        if (i >= displayRedGreenBlueXYZ.length) goto L6;
        displayRedGreenBlueXYZ[i] = Float.parseFloat(displayPrimariesValues[i]);
        i = i + 1;
        goto L4
    L6:
        int i2 = 0;
    L8:
        if (i2 >= displayWhiteXYZ.length) goto L11;
        displayWhiteXYZ[i2] = Float.parseFloat(displayPrimariesValues[displayRedGreenBlueXYZ.length + i2]);
        i2 = i2 + 1;
        goto L8
    L11:
        return makeRgbColorSpaceFromXYZ(displayRedGreenBlueXYZ, displayWhiteXYZ);
    }

    private boolean isColorMatrixCoeffValid(float coeff) {
        if (Float.isNaN(coeff) == false) goto L5;
    L7:
        return false;
    L5:
        if (Float.isInfinite(coeff) == true) goto L7;
        return true;
    }

    private boolean isColorMatrixValid(float[] matrix) {
        if (matrix != null) goto L5;
    L15:
        return false;
    L5:
        if (matrix.length != 9) goto L15;
        int r1 = matrix.length;
        int r2 = 0;
    L8:
        if (r2 >= r1) goto L13;
        float value = matrix[r2];
        if (isColorMatrixCoeffValid(value) == false) goto L11;
        r2 = r2 + 1;
        goto L8
    L11:
        return false;
    L13:
        return true;
    }
}
