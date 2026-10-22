package com.android.server.display;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.hardware.display.BrightnessConfiguration;
import android.hardware.display.BrightnessCorrection;
import android.pico.utils.ExtImplFactory;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.LongArray;
import android.util.MathUtils;
import android.util.Pair;
import android.util.Slog;
import android.util.Spline;
import com.android.internal.display.BrightnessUtils;
import com.android.internal.util.Preconditions;
import com.android.server.display.utils.Plog;
import com.android.server.display.whitebalance.DisplayWhiteBalanceController;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BrightnessMappingStrategy {
    public static final float INVALID_LUX = -1.0f;
    public static final float INVALID_NITS = -1.0f;
    private static final float LUX_GRAD_SMOOTHING = 0.25f;
    private static final float MAX_GRAD = 1.0f;
    private static final float MIN_PERMISSABLE_INCREASE = 0.004f;
    private static final Plog PLOG = null;
    private static final float SHORT_TERM_MODEL_THRESHOLD_RATIO = 0.6f;
    private static final String TAG = "BrightnessMappingStrategy";
    protected boolean mLoggingEnabled;

    static class PhysicalMappingStrategy extends BrightnessMappingStrategy {
        private static final SimpleDateFormat FORMAT = null;
        private static final int NO_OF_PREVIOUS_CONFIGS_TO_LOG = 5;
        private Spline mAdjustedNitsToBrightnessSpline;
        private float mAutoBrightnessAdjustment;
        private final float[] mBrightness;
        private boolean mBrightnessRangeAdjustmentApplied;
        private Spline mBrightnessSpline;
        private LongArray mBrightnessSplineChangeTimes;
        private Spline mBrightnessToAdjustedNitsSpline;
        private Spline mBrightnessToNitsSpline;
        private BrightnessConfiguration mConfig;
        private final BrightnessConfiguration mDefaultConfig;
        private final DisplayWhiteBalanceController mDisplayWhiteBalanceController;
        private IExtBrightnessMappingStrategy.IExtPhysicalMappingStrategy mExt;
        private final float mMaxGamma;
        private final int mMode;
        private final float[] mNits;
        private Spline mNitsToBrightnessSpline;
        private final int mPreset;
        private List<Spline> mPreviousBrightnessSplines;
        private float mUserBrightness;
        private float mUserLux;

        static {
            FORMAT = new SimpleDateFormat("MM-dd HH:mm:ss.SSS");
        }

        public PhysicalMappingStrategy(BrightnessConfiguration config, float[] nits, float[] brightness, float maxGamma, int mode, int preset, DisplayWhiteBalanceController displayWhiteBalanceController) {
            this.mPreviousBrightnessSplines = new ArrayList();
            this.mBrightnessSplineChangeTimes = new LongArray();
            this.mExt = (IExtBrightnessMappingStrategy.IExtPhysicalMappingStrategy) ExtImplFactory.getImpl(IExtBrightnessMappingStrategy.IExtPhysicalMappingStrategy.class, new Object[]{this});
            boolean r1 = false;
            if (nits.length != 0) goto L5;
        L7:
            boolean r0 = false;
        L8:
            Preconditions.checkArgument(r0, "Nits and brightness arrays must not be empty!");
            if (nits.length != brightness.length) goto L11;
            r1 = true;
        L11:
            Preconditions.checkArgument(r1, "Nits and brightness arrays must be the same length!");
            config.getClass();
            Preconditions.checkArrayElementsInRange(nits, 0.0f, Float.MAX_VALUE, "nits");
            Preconditions.checkArrayElementsInRange(brightness, 0.0f, 1.0f, "brightness");
            this.mMode = mode;
            this.mPreset = preset;
            this.mMaxGamma = maxGamma;
            this.mAutoBrightnessAdjustment = 0.0f;
            this.mUserLux = -1.0f;
            this.mUserBrightness = Float.NaN;
            this.mDisplayWhiteBalanceController = displayWhiteBalanceController;
            this.mNits = nits;
            this.mBrightness = brightness;
            computeNitsBrightnessSplines(this.mNits);
            this.mAdjustedNitsToBrightnessSpline = this.mNitsToBrightnessSpline;
            this.mBrightnessToAdjustedNitsSpline = this.mBrightnessToNitsSpline;
            this.mDefaultConfig = config;
            if (this.mLoggingEnabled == false) goto L14;
            BrightnessMappingStrategy.m3582$$Nest$sfgetPLOG().start("physical mapping strategy");
        L14:
            this.mConfig = config;
            computeSpline();
            return;
        L5:
            if (brightness.length == 0) goto L7;
            r0 = true;
            goto L8
        }

        @Override // com.android.server.display.BrightnessMappingStrategy
        public long getShortTermModelTimeout() {
            if (this.mConfig.getShortTermModelTimeoutMillis() < 0) goto L7;
            return this.mConfig.getShortTermModelTimeoutMillis();
        L7:
            return this.mDefaultConfig.getShortTermModelTimeoutMillis();
        }

        @Override // com.android.server.display.BrightnessMappingStrategy
        public boolean setBrightnessConfiguration(BrightnessConfiguration config) {
            if (config != null) goto L5;
            config = this.mDefaultConfig;
        L5:
            if (config.equals(this.mConfig) == false) goto L9;
            return false;
        L9:
            if (this.mLoggingEnabled == false) goto L11;
            BrightnessMappingStrategy.m3582$$Nest$sfgetPLOG().start("brightness configuration");
        L11:
            this.mConfig = config;
            computeSpline();
            return true;
        }

        @Override // com.android.server.display.BrightnessMappingStrategy
        public BrightnessConfiguration getBrightnessConfiguration() {
            return this.mConfig;
        }

        @Override // com.android.server.display.BrightnessMappingStrategy
        public float getBrightness(float lux, String packageName, int category) {
            float sceneBrightness = this.mExt.getBrightness(lux);
            if (Float.isNaN(sceneBrightness) == true) goto L5;
            return sceneBrightness;
        L5:
            float nits = this.mBrightnessSpline.interpolate(lux);
            if (this.mDisplayWhiteBalanceController == null) goto L8;
            nits = this.mDisplayWhiteBalanceController.calculateAdjustedBrightnessNits(nits);
        L8:
            float brightness = this.mAdjustedNitsToBrightnessSpline.interpolate(nits);
            if (hasUserDataPoints() == true) goto L12;
            return correctBrightness(brightness, packageName, category);
        L12:
            if (this.mLoggingEnabled == false) goto L16;
            Slog.d(BrightnessMappingStrategy.TAG, "user point set, correction not applied");
            return brightness;
        L16:
            return brightness;
        }

        @Override // com.android.server.display.BrightnessMappingStrategy
        public float getAutoBrightnessAdjustment() {
            return this.mAutoBrightnessAdjustment;
        }

        @Override // com.android.server.display.BrightnessMappingStrategy
        public boolean setAutoBrightnessAdjustment(float adjustment) {
            float adjustment2 = MathUtils.constrain(adjustment, -1.0f, 1.0f);
            if (adjustment2 != this.mAutoBrightnessAdjustment) goto L7;
            return false;
        L7:
            if (this.mLoggingEnabled == false) goto L9;
            Slog.d(BrightnessMappingStrategy.TAG, "setAutoBrightnessAdjustment: " + this.mAutoBrightnessAdjustment + " => " + adjustment2);
            BrightnessMappingStrategy.m3582$$Nest$sfgetPLOG().start("auto-brightness adjustment");
        L9:
            this.mAutoBrightnessAdjustment = adjustment2;
            computeSpline();
            return true;
        }

        @Override // com.android.server.display.BrightnessMappingStrategy
        public float convertToNits(float brightness) {
            return this.mBrightnessToNitsSpline.interpolate(brightness);
        }

        @Override // com.android.server.display.BrightnessMappingStrategy
        public float convertToAdjustedNits(float brightness) {
            return this.mBrightnessToAdjustedNitsSpline.interpolate(brightness);
        }

        @Override // com.android.server.display.BrightnessMappingStrategy
        public float getBrightnessFromNits(float nits) {
            return this.mNitsToBrightnessSpline.interpolate(nits);
        }

        @Override // com.android.server.display.BrightnessMappingStrategy
        public void addUserDataPoint(float lux, float brightness) {
            float unadjustedBrightness = getUnadjustedBrightness(lux);
            if (this.mLoggingEnabled == false) goto L5;
            Slog.d(BrightnessMappingStrategy.TAG, "addUserDataPoint: (" + lux + "," + brightness + ")");
            BrightnessMappingStrategy.m3582$$Nest$sfgetPLOG().start("add user data point").logPoint("user data point", lux, brightness).logPoint("current brightness", lux, unadjustedBrightness);
        L5:
            float adjustment = inferAutoBrightnessAdjustment(this.mMaxGamma, brightness, unadjustedBrightness);
            if (this.mLoggingEnabled == false) goto L8;
            Slog.d(BrightnessMappingStrategy.TAG, "addUserDataPoint: " + this.mAutoBrightnessAdjustment + " => " + adjustment);
        L8:
            this.mAutoBrightnessAdjustment = adjustment;
            this.mExt.setUserDataPoint(lux, brightness);
            this.mUserLux = lux;
            this.mUserBrightness = brightness;
            computeSpline();
            if (this.mPreviousBrightnessSplines.size() != 5) goto L11;
            this.mPreviousBrightnessSplines.remove(0);
            this.mBrightnessSplineChangeTimes.remove(0);
        L11:
            this.mPreviousBrightnessSplines.add(this.mBrightnessSpline);
            this.mBrightnessSplineChangeTimes.add(System.currentTimeMillis());
        }

        @Override // com.android.server.display.BrightnessMappingStrategy
        public void clearUserDataPoints() {
            if (hasUserDataPoints() == true) goto L5;
            return;
        L5:
            if (this.mLoggingEnabled == false) goto L7;
            Slog.d(BrightnessMappingStrategy.TAG, "clearUserDataPoints: " + this.mAutoBrightnessAdjustment + " => 0");
            BrightnessMappingStrategy.m3582$$Nest$sfgetPLOG().start("clear user data points").logPoint("user data point", this.mUserLux, this.mUserBrightness);
        L7:
            this.mAutoBrightnessAdjustment = 0.0f;
            this.mExt.clearUserDataPoints();
            this.mUserLux = -1.0f;
            this.mUserBrightness = Float.NaN;
            computeSpline();
        }

        @Override // com.android.server.display.BrightnessMappingStrategy
        public boolean hasUserDataPoints() {
            if (this.mExt.getUserDataPointCount() <= 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.android.server.display.BrightnessMappingStrategy
        public boolean isDefaultConfig() {
            return this.mDefaultConfig.equals(this.mConfig);
        }

        @Override // com.android.server.display.BrightnessMappingStrategy
        public BrightnessConfiguration getDefaultConfig() {
            return this.mDefaultConfig;
        }

        @Override // com.android.server.display.BrightnessMappingStrategy
        public void recalculateSplines(boolean applyAdjustment, float[] adjustedNits) {
            this.mBrightnessRangeAdjustmentApplied = applyAdjustment;
            if (applyAdjustment == false) goto L5;
            this.mAdjustedNitsToBrightnessSpline = Spline.createSpline(adjustedNits, this.mBrightness);
            this.mBrightnessToAdjustedNitsSpline = Spline.createSpline(this.mBrightness, adjustedNits);
            return;
        L5:
            this.mAdjustedNitsToBrightnessSpline = this.mNitsToBrightnessSpline;
            this.mBrightnessToAdjustedNitsSpline = this.mBrightnessToNitsSpline;
        }

        @Override // com.android.server.display.BrightnessMappingStrategy
        public void dump(PrintWriter pw, float hbmTransition) {
            pw.println("PhysicalMappingStrategy");
            pw.println("  mConfig=" + this.mConfig);
            pw.println("  mBrightnessSpline=" + this.mBrightnessSpline);
            pw.println("  mNitsToBrightnessSpline=" + this.mNitsToBrightnessSpline);
            pw.println("  mBrightnessToNitsSpline=" + this.mBrightnessToNitsSpline);
            pw.println("  mAdjustedNitsToBrightnessSpline=" + this.mAdjustedNitsToBrightnessSpline);
            pw.println("  mAdjustedBrightnessToNitsSpline=" + this.mBrightnessToAdjustedNitsSpline);
            pw.println("  mMaxGamma=" + this.mMaxGamma);
            pw.println("  mAutoBrightnessAdjustment=" + this.mAutoBrightnessAdjustment);
            pw.println("  mUserLux=" + this.mUserLux);
            pw.println("  mUserBrightness=" + this.mUserBrightness);
            pw.println("  mDefaultConfig=" + this.mDefaultConfig);
            pw.println("  mBrightnessRangeAdjustmentApplied=" + this.mBrightnessRangeAdjustmentApplied);
            pw.println("  shortTermModelTimeout=" + getShortTermModelTimeout());
            if (this.mPreviousBrightnessSplines.isEmpty() == true) goto L5;
            pw.println("  Previous short-term models (oldest to newest): ");
        L5:
            int i = 0;
        L7:
            if (i >= this.mPreviousBrightnessSplines.size()) goto L9;
            pw.println("  Computed at " + FORMAT.format(new Date(this.mBrightnessSplineChangeTimes.get(i))) + ": ");
            dumpConfigDiff(pw, hbmTransition, this.mPreviousBrightnessSplines.get(i), true);
            i = i + 1;
            goto L7
        L9:
            pw.println("  Difference between current config and default: ");
            dumpConfigDiff(pw, hbmTransition, this.mBrightnessSpline, false);
        }

        @Override // com.android.server.display.BrightnessMappingStrategy
        int getMode() {
            return this.mMode;
        }

        @Override // com.android.server.display.BrightnessMappingStrategy
        int getPreset() {
            return this.mPreset;
        }

        @Override // com.android.server.display.BrightnessMappingStrategy
        float getUserLux() {
            return this.mUserLux;
        }

        @Override // com.android.server.display.BrightnessMappingStrategy
        float getUserBrightness() {
            return this.mUserBrightness;
        }

        private void dumpConfigDiff(PrintWriter pw, float hbmTransition, Spline brightnessSpline, boolean shortTermModelOnly) {
            PhysicalMappingStrategy r0 = this;
            Pair<float[], float[]> currentCurve = r0.mConfig.getCurve();
            Spline currSpline = Spline.createSpline((float[]) currentCurve.first, (float[]) currentCurve.second);
            Pair<float[], float[]> defaultCurve = r0.mDefaultConfig.getCurve();
            Spline defaultSpline = Spline.createSpline((float[]) defaultCurve.first, (float[]) defaultCurve.second);
            float[] luxes = (float[]) currentCurve.first;
            if (r0.mUserLux < 0.0f) goto L5;
            luxes = Arrays.copyOf((float[]) currentCurve.first, ((float[]) currentCurve.first).length + 1);
            luxes[luxes.length - 1] = r0.mUserLux;
            Arrays.sort(luxes);
        L5:
            StringBuilder sbLong = null;
            StringBuilder sbShort = null;
            StringBuilder sbBrightness = null;
            StringBuilder sbPercent = null;
            StringBuilder sbPercentHbm = null;
            StringBuilder sbPercent2 = null;
            StringBuilder sbPercentHbm2 = null;
            boolean needsHeaders = true;
            String separator = "";
            int i = 0;
        L6:
            Pair<float[], float[]> defaultCurve2 = defaultCurve;
            if (i >= luxes.length) goto L32;
            float lux = luxes[i];
            if (needsHeaders == false) goto L12;
            StringBuilder sbLux = new StringBuilder("            lux: ");
            StringBuilder sbNits = new StringBuilder("        default: ");
            StringBuilder sbLong2 = new StringBuilder("      long-term: ");
            StringBuilder sbShort2 = new StringBuilder("        current: ");
            StringBuilder sbBrightness2 = new StringBuilder("    current(bl): ");
            StringBuilder sbPercent3 = new StringBuilder("     current(%): ");
            StringBuilder sbPercentHbm3 = new StringBuilder("  current(hbm%): ");
            needsHeaders = false;
            sbPercent2 = sbPercent3;
            sbPercentHbm2 = sbPercentHbm3;
            sbPercent = sbShort2;
            sbPercentHbm = sbBrightness2;
            sbBrightness = sbLong2;
            sbShort = sbNits;
            sbLong = sbLux;
        L12:
            boolean needsHeaders2 = needsHeaders;
            float defaultNits = defaultSpline.interpolate(lux);
            Spline defaultSpline2 = defaultSpline;
            float longTermNits = currSpline.interpolate(lux);
            Spline currSpline2 = currSpline;
            float shortTermNits = brightnessSpline.interpolate(lux);
            float brightness = r0.mAdjustedNitsToBrightnessSpline.interpolate(shortTermNits);
            int i2 = i;
            if (lux != r0.mUserLux) goto L15;
            String r19 = "^";
        L16:
            String luxPrefix = r19;
            StringBuilder r2 = new StringBuilder();
            float[] luxes2 = luxes;
            r2.append(luxPrefix);
            String luxPrefix2 = r0.toStrFloatForDump(lux);
            r2.append(luxPrefix2);
            String strLux = r2.toString();
            String strNits = r0.toStrFloatForDump(defaultNits);
            String strLong = r0.toStrFloatForDump(longTermNits);
            String strShort = r0.toStrFloatForDump(shortTermNits);
            String strBrightness = r0.toStrFloatForDump(brightness);
            String strPercent = String.valueOf(Math.round(BrightnessUtils.convertLinearToGamma(brightness / hbmTransition) * 100.0f));
            String strPercentHbm = String.valueOf(Math.round(BrightnessUtils.convertLinearToGamma(brightness) * 100.0f));
            int maxLen = Math.max(strLux.length(), Math.max(strNits.length(), Math.max(strBrightness.length(), Math.max(strPercent.length(), Math.max(strPercentHbm.length(), Math.max(strLong.length(), strShort.length()))))));
            String format = separator + "%" + maxLen + "s";
            String separator2 = ", ";
            sbLong.append(TextUtils.formatSimple(format, new Object[]{strLux}));
            sbShort.append(TextUtils.formatSimple(format, new Object[]{strNits}));
            sbBrightness.append(TextUtils.formatSimple(format, new Object[]{strLong}));
            sbPercent.append(TextUtils.formatSimple(format, new Object[]{strShort}));
            sbPercentHbm.append(TextUtils.formatSimple(format, new Object[]{strBrightness}));
            sbPercent2.append(TextUtils.formatSimple(format, new Object[]{strPercent}));
            sbPercentHbm2.append(TextUtils.formatSimple(format, new Object[]{strPercentHbm}));
            if (sbLong.length() > 80) goto L22;
            luxes = luxes2;
            int i3 = i2;
            if (i3 == (luxes.length - 1)) goto L23;
            needsHeaders = needsHeaders2;
        L30:
            separator = separator2;
            i = i3 + 1;
            r0 = this;
            defaultCurve = defaultCurve2;
            defaultSpline = defaultSpline2;
            currSpline = currSpline2;
        L23:
            pw.println(sbLong);
            if (shortTermModelOnly == true) goto L26;
            pw.println(sbShort);
            pw.println(sbBrightness);
        L26:
            pw.println(sbPercent);
            pw.println(sbPercentHbm);
            pw.println(sbPercent2);
            if (hbmTransition >= 1.0f) goto L29;
            pw.println(sbPercentHbm2);
        L29:
            pw.println("");
            separator2 = "";
            needsHeaders = true;
            goto L30
        L22:
            i3 = i2;
            luxes = luxes2;
            goto L23
        L15:
            r19 = "";
            goto L16
        }

        private String toStrFloatForDump(float value) {
            if (value != 0.0f) goto L7;
            return "0";
        L7:
            if (value >= 0.1f) goto L11;
            return String.format(Locale.US, "%.3f", new Object[]{Float.valueOf(value)});
        L11:
            if (value >= 1.0f) goto L15;
            return String.format(Locale.US, "%.2f", new Object[]{Float.valueOf(value)});
        L15:
            if (value >= 10.0f) goto L19;
            return String.format(Locale.US, "%.1f", new Object[]{Float.valueOf(value)});
        L19:
            return TextUtils.formatSimple("%d", new Object[]{Integer.valueOf(Math.round(value))});
        }

        private void computeNitsBrightnessSplines(float[] nits) {
            this.mNitsToBrightnessSpline = Spline.createSpline(nits, this.mBrightness);
            this.mBrightnessToNitsSpline = Spline.createSpline(this.mBrightness, nits);
        }

        private void computeSpline() {
            IExtBrightnessMappingStrategy.SplineComputationResult r = this.mExt.computePhysicalSpline(this.mConfig, this.mAdjustedNitsToBrightnessSpline, this.mBrightnessToAdjustedNitsSpline, this.mMaxGamma, this.mAutoBrightnessAdjustment);
            if (r != null) goto L5;
        L10:
            Pair<float[], float[]> defaultCurve = this.mConfig.getCurve();
            float[] defaultLux = (float[]) defaultCurve.first;
            float[] defaultNits = (float[]) defaultCurve.second;
            float[] defaultBrightness = new float[defaultNits.length];
            int i = 0;
        L12:
            if (i >= defaultBrightness.length) goto L14;
            defaultBrightness[i] = this.mAdjustedNitsToBrightnessSpline.interpolate(defaultNits[i]);
            i = i + 1;
            goto L12
        L14:
            Pair<float[], float[]> curve = getAdjustedCurve(defaultLux, defaultBrightness, this.mUserLux, this.mUserBrightness, this.mAutoBrightnessAdjustment, this.mMaxGamma);
            float[] lux = (float[]) curve.first;
            float[] brightness = (float[]) curve.second;
            float[] nits = new float[brightness.length];
            int i2 = 0;
        L16:
            if (i2 >= nits.length) goto L18;
            nits[i2] = this.mBrightnessToAdjustedNitsSpline.interpolate(brightness[i2]);
            i2 = i2 + 1;
            goto L16
        L18:
            this.mBrightnessSpline = Spline.createSpline(lux, nits);
            return;
        L5:
            if (r.finalLux == null) goto L10;
            if (r.finalNits == null) goto L10;
            this.mBrightnessSpline = Spline.createSpline(r.finalLux, r.finalNits);
            this.mExt.onSplineRecomputed("physical", this.mMode, this.mPreset, this.mUserLux, this.mUserBrightness, r.configLux, r.configBrightness, r.userLux, r.userBrightness, r.finalLux, r.finalBrightness);
        }

        @Override // com.android.server.display.BrightnessMappingStrategy
        public float getUnadjustedBrightness(float lux) {
            Pair<float[], float[]> curve = this.mConfig.getCurve();
            Spline spline = Spline.createSpline((float[]) curve.first, (float[]) curve.second);
            return this.mAdjustedNitsToBrightnessSpline.interpolate(spline.interpolate(lux));
        }

        private float correctBrightness(float brightness, String packageName, int category) {
            if (packageName == null) goto L8;
            BrightnessCorrection correction = this.mConfig.getCorrectionByPackageName(packageName);
            if (correction == null) goto L8;
            return correction.apply(brightness);
        L8:
            if (category == (-1)) goto L13;
            BrightnessCorrection correction2 = this.mConfig.getCorrectionByCategory(category);
            if (correction2 == null) goto L13;
            return correction2.apply(brightness);
        L13:
            return brightness;
        }

        @Override // com.android.server.display.BrightnessMappingStrategy
        public IExtBrightnessMappingStrategy getExt() {
            return this.mExt;
        }
    }

    static class SimpleMappingStrategy extends BrightnessMappingStrategy {
        private float mAutoBrightnessAdjustment;
        private final float[] mBrightness;
        public DisplayDeviceConfig mDisplayDeviceConfig;
        private IExtBrightnessMappingStrategy.IExtSimpleMappingStrategy mExt;
        private final float[] mLux;
        private float mMaxGamma;
        private final int mMode;
        private final int mPreset;
        private long mShortTermModelTimeout;
        protected Spline mSpline;
        private float mUserBrightness;
        private float mUserLux;

        /* synthetic */ SimpleMappingStrategy(float[] r1, float[] r2, float r3, float[] r4, float[] r5, DisplayDeviceConfig r6, long r7, int r9, int r10, BrightnessMappingStrategyIA r11) {
            this(r1, r2, r3, r4, r5, r6, r7, r9, r10);
        }

        private SimpleMappingStrategy(float[] lux, float[] brightness, float maxGamma, float[] nits, float[] rawBrightness, DisplayDeviceConfig displayDeviceConfig, long timeout, int mode, int preset) {
            this.mExt = (IExtBrightnessMappingStrategy.IExtSimpleMappingStrategy) ExtImplFactory.getImpl(IExtBrightnessMappingStrategy.IExtSimpleMappingStrategy.class, new Object[]{this});
            boolean r1 = false;
            if (lux.length != 0) goto L5;
        L7:
            boolean r0 = false;
        L8:
            Preconditions.checkArgument(r0, "Lux and brightness arrays must not be empty!");
            if (lux.length != brightness.length) goto L11;
            r1 = true;
        L11:
            Preconditions.checkArgument(r1, "Lux and brightness arrays must be the same length!");
            Preconditions.checkArrayElementsInRange(lux, 0.0f, Float.MAX_VALUE, "lux");
            Preconditions.checkArrayElementsInRange(brightness, 0.0f, 2.1474836E9f, "brightness");
            int N = brightness.length;
            this.mLux = new float[N];
            this.mBrightness = new float[N];
            int i = 0;
        L12:
            if (i >= N) goto L14;
            this.mLux[i] = lux[i];
            this.mBrightness[i] = brightness[i];
            i = i + 1;
            goto L12
        L14:
            this.mMaxGamma = maxGamma;
            this.mAutoBrightnessAdjustment = 0.0f;
            this.mUserLux = -1.0f;
            this.mUserBrightness = Float.NaN;
            if (this.mLoggingEnabled == false) goto L17;
            BrightnessMappingStrategy.m3582$$Nest$sfgetPLOG().start("simple mapping strategy");
        L17:
            computeSpline();
            this.mShortTermModelTimeout = timeout;
            this.mMode = mode;
            this.mPreset = preset;
            this.mDisplayDeviceConfig = displayDeviceConfig;
            this.mExt.createSplines(this.mLux, this.mBrightness, nits, rawBrightness);
            return;
        L5:
            if (brightness.length == 0) goto L7;
            r0 = true;
            goto L8
        }

        @Override // com.android.server.display.BrightnessMappingStrategy
        public long getShortTermModelTimeout() {
            return this.mShortTermModelTimeout;
        }

        @Override // com.android.server.display.BrightnessMappingStrategy
        public boolean setBrightnessConfiguration(BrightnessConfiguration config) {
            return false;
        }

        @Override // com.android.server.display.BrightnessMappingStrategy
        public BrightnessConfiguration getBrightnessConfiguration() {
            return null;
        }

        @Override // com.android.server.display.BrightnessMappingStrategy
        public float getBrightness(float lux, String packageName, int category) {
            return this.mExt.getBrightness(lux, packageName, category);
        }

        @Override // com.android.server.display.BrightnessMappingStrategy
        public float getAutoBrightnessAdjustment() {
            return this.mAutoBrightnessAdjustment;
        }

        @Override // com.android.server.display.BrightnessMappingStrategy
        public boolean setAutoBrightnessAdjustment(float adjustment) {
            float adjustment2 = MathUtils.constrain(adjustment, -1.0f, 1.0f);
            if (adjustment2 != this.mAutoBrightnessAdjustment) goto L7;
            return false;
        L7:
            if (this.mLoggingEnabled == false) goto L9;
            Slog.d(BrightnessMappingStrategy.TAG, "setAutoBrightnessAdjustment: " + this.mAutoBrightnessAdjustment + " => " + adjustment2);
            BrightnessMappingStrategy.m3582$$Nest$sfgetPLOG().start("auto-brightness adjustment");
        L9:
            this.mAutoBrightnessAdjustment = adjustment2;
            computeSpline();
            return true;
        }

        @Override // com.android.server.display.BrightnessMappingStrategy
        public float convertToNits(float brightness) {
            return this.mExt.convertToNits(brightness);
        }

        @Override // com.android.server.display.BrightnessMappingStrategy
        public float convertToAdjustedNits(float brightness) {
            return -1.0f;
        }

        @Override // com.android.server.display.BrightnessMappingStrategy
        public float getBrightnessFromNits(float nits) {
            return this.mExt.getBrightnessFromNits(nits);
        }

        @Override // com.android.server.display.BrightnessMappingStrategy
        public void addUserDataPoint(float lux, float brightness) {
            float unadjustedBrightness = getUnadjustedBrightness(lux);
            if (this.mLoggingEnabled == false) goto L5;
            Slog.d(BrightnessMappingStrategy.TAG, "addUserDataPoint: (" + lux + "," + brightness + ")");
            BrightnessMappingStrategy.m3582$$Nest$sfgetPLOG().start("add user data point").logPoint("user data point", lux, brightness).logPoint("current brightness", lux, unadjustedBrightness);
        L5:
            float adjustment = inferAutoBrightnessAdjustment(this.mMaxGamma, brightness, unadjustedBrightness);
            if (this.mLoggingEnabled == false) goto L8;
            Slog.d(BrightnessMappingStrategy.TAG, "addUserDataPoint: " + this.mAutoBrightnessAdjustment + " => " + adjustment);
        L8:
            this.mAutoBrightnessAdjustment = adjustment;
            this.mExt.setUserDataPoint(lux, brightness);
            this.mUserLux = lux;
            this.mUserBrightness = brightness;
            computeSpline();
        }

        @Override // com.android.server.display.BrightnessMappingStrategy
        public void clearUserDataPoints() {
            if (hasUserDataPoints() == true) goto L5;
            return;
        L5:
            if (this.mLoggingEnabled == false) goto L7;
            Slog.d(BrightnessMappingStrategy.TAG, "clearUserDataPoints: " + this.mAutoBrightnessAdjustment + " => 0");
            BrightnessMappingStrategy.m3582$$Nest$sfgetPLOG().start("clear user data points").logPoint("user data point", this.mUserLux, this.mUserBrightness);
        L7:
            this.mAutoBrightnessAdjustment = 0.0f;
            this.mExt.clearUserDataPoints();
            this.mUserLux = -1.0f;
            this.mUserBrightness = Float.NaN;
            computeSpline();
        }

        @Override // com.android.server.display.BrightnessMappingStrategy
        public boolean hasUserDataPoints() {
            if (this.mExt.getUserDataPointCount() <= 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // com.android.server.display.BrightnessMappingStrategy
        public boolean isDefaultConfig() {
            return true;
        }

        @Override // com.android.server.display.BrightnessMappingStrategy
        public BrightnessConfiguration getDefaultConfig() {
            return null;
        }

        @Override // com.android.server.display.BrightnessMappingStrategy
        public void recalculateSplines(boolean applyAdjustment, float[] adjustment) {
        }

        @Override // com.android.server.display.BrightnessMappingStrategy
        public void dump(PrintWriter pw, float hbmTransition) {
            pw.println("SimpleMappingStrategy");
            this.mExt.dump(pw, hbmTransition);
            pw.println("  mMaxGamma=" + this.mMaxGamma);
            pw.println("  mAutoBrightnessAdjustment=" + this.mAutoBrightnessAdjustment);
            pw.println("  mUserLux=" + this.mUserLux);
            pw.println("  mUserBrightness=" + this.mUserBrightness);
            pw.println("  mShortTermModelTimeout=" + this.mShortTermModelTimeout);
        }

        @Override // com.android.server.display.BrightnessMappingStrategy
        int getMode() {
            return this.mMode;
        }

        @Override // com.android.server.display.BrightnessMappingStrategy
        int getPreset() {
            return this.mPreset;
        }

        @Override // com.android.server.display.BrightnessMappingStrategy
        float getUserLux() {
            return this.mUserLux;
        }

        @Override // com.android.server.display.BrightnessMappingStrategy
        float getUserBrightness() {
            return this.mUserBrightness;
        }

        private void computeSpline() {
            IExtBrightnessMappingStrategy.SplineComputationResult r = this.mExt.computeSimpleSpline(this.mLux, this.mBrightness, this.mMaxGamma, this.mAutoBrightnessAdjustment);
            if (r != null) goto L5;
        L10:
            Pair<float[], float[]> curve = getAdjustedCurve(this.mLux, this.mBrightness, this.mUserLux, this.mUserBrightness, this.mAutoBrightnessAdjustment, this.mMaxGamma);
            this.mSpline = Spline.createSpline((float[]) curve.first, (float[]) curve.second);
            return;
        L5:
            if (r.finalLux == null) goto L10;
            if (r.finalBrightness == null) goto L10;
            this.mSpline = Spline.createSpline(r.finalLux, r.finalBrightness);
            this.mExt.onSplineRecomputed("simple", this.mMode, this.mPreset, this.mUserLux, this.mUserBrightness, r.configLux, r.configBrightness, r.userLux, r.userBrightness, r.finalLux, r.finalBrightness);
        }

        @Override // com.android.server.display.BrightnessMappingStrategy
        public float getUnadjustedBrightness(float lux) {
            return this.mExt.getUnadjustedBrightness(lux);
        }

        @Override // com.android.server.display.BrightnessMappingStrategy
        public IExtBrightnessMappingStrategy getExt() {
            return this.mExt;
        }
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetPLOG, reason: not valid java name */
    static /* bridge */ /* synthetic */ Plog m3582$$Nest$sfgetPLOG() {
        return PLOG;
    }

    public abstract void addUserDataPoint(float r1, float r2);

    public abstract void clearUserDataPoints();

    public abstract float convertToAdjustedNits(float r1);

    public abstract float convertToNits(float r1);

    public abstract void dump(PrintWriter r1, float r2);

    public abstract float getAutoBrightnessAdjustment();

    public abstract float getBrightness(float r1, String r2, int r3);

    public abstract BrightnessConfiguration getBrightnessConfiguration();

    public abstract float getBrightnessFromNits(float r1);

    public abstract BrightnessConfiguration getDefaultConfig();

    public abstract IExtBrightnessMappingStrategy getExt();

    abstract int getMode();

    abstract int getPreset();

    public abstract long getShortTermModelTimeout();

    public abstract float getUnadjustedBrightness(float r1);

    abstract float getUserBrightness();

    abstract float getUserLux();

    public abstract boolean hasUserDataPoints();

    public abstract boolean isDefaultConfig();

    public abstract void recalculateSplines(boolean r1, float[] r2);

    public abstract boolean setAutoBrightnessAdjustment(float r1);

    public abstract boolean setBrightnessConfiguration(BrightnessConfiguration r1);

    public BrightnessMappingStrategy() {
        this.mLoggingEnabled = true;
    }

    static {
        PLOG = Plog.createSystemPlog(TAG);
    }

    static BrightnessMappingStrategy create(Context context, DisplayDeviceConfig displayDeviceConfig, int mode, DisplayWhiteBalanceController displayWhiteBalanceController) {
        float[] brightnessLevelsNits = null;
        int preset = Settings.System.getIntForUser(context.getContentResolver(), "screen_brightness_for_als", 2, -2);
        switch(mode) {
            case 0: goto L7;
            case 1: goto L6;
            case 2: goto L5;
            case 3: goto L5;
            default: goto L4;
        };
    L4:
        float[] luxLevels = null;
        float[] brightnessLevels = null;
    L8:
        float autoBrightnessAdjustmentMaxGamma = context.getResources().getFraction(R.fraction.config_autoBrightnessAdjustmentMaxGamma, 1, 1);
        long shortTermModelTimeout = context.getResources().getInteger(R.integer.config_bg_current_drain_media_playback_min_duration);
        float[] nitsRange = displayDeviceConfig.getNits();
        float[] brightnessRange = displayDeviceConfig.getBrightness();
        if (isValidMapping(nitsRange, brightnessRange) == false) goto L17;
        if (isValidMapping(brightnessLevels, brightnessLevelsNits) == false) goto L17;
        BrightnessConfiguration.Builder builder = new BrightnessConfiguration.Builder(brightnessLevels, brightnessLevelsNits);
        builder.setShortTermModelTimeoutMillis(shortTermModelTimeout);
        builder.setShortTermModelLowerLuxMultiplier(SHORT_TERM_MODEL_THRESHOLD_RATIO);
        builder.setShortTermModelUpperLuxMultiplier(SHORT_TERM_MODEL_THRESHOLD_RATIO);
        BrightnessMappingStrategy strategy = new PhysicalMappingStrategy(builder.build(), nitsRange, brightnessRange, autoBrightnessAdjustmentMaxGamma, mode, preset, displayWhiteBalanceController);
        strategy.getExt().init(context);
        return strategy;
    L17:
        if (isValidMapping(brightnessLevels, luxLevels) == false) goto L20;
        BrightnessMappingStrategy strategy2 = new SimpleMappingStrategy(brightnessLevels, luxLevels, autoBrightnessAdjustmentMaxGamma, nitsRange, brightnessRange, displayDeviceConfig, shortTermModelTimeout, mode, preset, null);
        strategy2.getExt().init(context);
        return strategy2;
    L20:
        Slog.e(TAG, "create failed null mode=" + mode + ", preset=" + preset);
        return null;
    L5:
        float[] luxLevels2 = displayDeviceConfig.getAutoBrightnessBrighteningLevelsLux(mode, preset);
        float[] brightnessLevels2 = displayDeviceConfig.getAutoBrightnessBrighteningLevels(mode, preset);
        luxLevels = brightnessLevels2;
        brightnessLevels = luxLevels2;
        goto L8
    L6:
        brightnessLevelsNits = getFloatArray(context.getResources().obtainTypedArray(R.array.config_bg_current_drain_high_threshold_to_restricted_bucket));
        float[] luxLevels3 = getLuxLevels(context.getResources().getIntArray(R.array.config_biometric_sensors));
        luxLevels = null;
        brightnessLevels = luxLevels3;
        goto L8
    L7:
        brightnessLevelsNits = displayDeviceConfig.getAutoBrightnessBrighteningLevelsNits();
        float[] luxLevels4 = displayDeviceConfig.getAutoBrightnessBrighteningLevelsLux(mode, preset);
        float[] brightnessLevels3 = displayDeviceConfig.getAutoBrightnessBrighteningLevels(mode, preset);
        luxLevels = brightnessLevels3;
        brightnessLevels = luxLevels4;
        goto L8
    }

    private static float[] getLuxLevels(int[] lux) {
        float[] levels = new float[lux.length + 1];
        int i = 0;
    L4:
        if (i >= lux.length) goto L7;
        levels[i + 1] = lux[i];
        i = i + 1;
        goto L4
    L7:
        return levels;
    }

    public static float[] getFloatArray(TypedArray array) {
        int N = array.length();
        float[] vals = new float[N];
        int i = 0;
    L3:
        if (i >= N) goto L5;
        vals[i] = array.getFloat(i, -1.0f);
        i = i + 1;
        goto L3
    L5:
        array.recycle();
        return vals;
    }

    private static boolean isValidMapping(float[] x, float[] y) {
        if (x == null) goto L44;
        if (y == null) goto L44;
        if (x.length == 0) goto L44;
        if (y.length == 0) goto L44;
        if (x.length == y.length) goto L14;
        Slog.e(TAG, "IllegalArgumentException isValidMapping x.len=" + x.length + ", y.len=" + y.length);
        return false;
    L14:
        int N = x.length;
        float prevX = x[0];
        float prevY = y[0];
        if (prevX >= 0.0f) goto L17;
    L42:
        String info = String.format(Locale.US, "prevX(%f) < 0 || prevY(%f) < 0", new Object[]{Float.valueOf(prevX), Float.valueOf(prevY)});
        Slog.e(TAG, "IllegalArgumentException isValidMapping " + info);
        return false;
    L17:
        if (prevY < 0.0f) goto L42;
        if (Float.isNaN(prevX) == true) goto L42;
        if (Float.isNaN(prevY) == true) goto L42;
        int i = 1;
    L24:
        if (i >= N) goto L40;
        if (prevX >= x[i]) goto L38;
        if (prevY > y[i]) goto L38;
        if (Float.isNaN(x[i]) == true) goto L36;
        if (Float.isNaN(y[i]) == true) goto L36;
        prevX = x[i];
        prevY = y[i];
        i = i + 1;
    L36:
        Slog.e(TAG, "IllegalArgumentException isValidMapping Float.isNaN(x[i]) || Float.isNaN(y[i])");
        return false;
    L38:
        String info2 = String.format(Locale.US, "prevX(%f) > x[%d]=%f || prevY(%f) > y[%d]=%f", new Object[]{Float.valueOf(prevX), Integer.valueOf(i), Float.valueOf(x[i]), Float.valueOf(prevY), Integer.valueOf(i), Float.valueOf(y[i])});
        Slog.e(TAG, "IllegalArgumentException isValidMapping " + info2);
        return false;
    L40:
        return true;
    L44:
        Slog.d(TAG, "IllegalArgumentException isValidMapping x=" + Arrays.toString(x) + ", y=" + Arrays.toString(y));
        return false;
    }

    private static boolean isValidMapping(float[] x, int[] y) {
        if (x == null) goto L34;
        if (y == null) goto L34;
        if (x.length == 0) goto L34;
        if (y.length == 0) goto L34;
        if (x.length == y.length) goto L13;
        return false;
    L13:
        int N = x.length;
        float prevX = x[0];
        int prevY = y[0];
        if (prevX < 0.0f) goto L33;
        if (prevY < 0) goto L33;
        if (Float.isNaN(prevX) == true) goto L33;
        int i = 1;
    L20:
        if (i >= N) goto L31;
        if (prevX >= x[i]) goto L30;
        if (prevY > y[i]) goto L30;
        if (Float.isNaN(x[i]) == true) goto L28;
        prevX = x[i];
        prevY = y[i];
        i = i + 1;
        goto L20
    L28:
        return false;
    L30:
        return false;
    L31:
        return true;
    L33:
        return false;
    L34:
        return false;
    }

    public boolean setLoggingEnabled(boolean loggingEnabled) {
        if (this.mLoggingEnabled != loggingEnabled) goto L6;
        return false;
    L6:
        this.mLoggingEnabled = loggingEnabled;
        return true;
    }

    public float getBrightness(float lux) {
        return getBrightness(lux, null, -1);
    }

    public boolean shouldResetShortTermModel(float ambientLux, float shortTermModelAnchor) {
        BrightnessConfiguration config = getBrightnessConfiguration();
        float minThresholdRatio = SHORT_TERM_MODEL_THRESHOLD_RATIO;
        float maxThresholdRatio = SHORT_TERM_MODEL_THRESHOLD_RATIO;
        if (config != null) goto L5;
    L10:
        float minAmbientLux = shortTermModelAnchor - (shortTermModelAnchor * minThresholdRatio);
        float maxAmbientLux = (shortTermModelAnchor * maxThresholdRatio) + shortTermModelAnchor;
        if (minAmbientLux < ambientLux) goto L13;
    L19:
        Slog.d(TAG, "ShortTermModel: reset data, ambient lux is " + ambientLux + "(" + minAmbientLux + ", " + maxAmbientLux + ")");
        return true;
    L13:
        if (ambientLux > maxAmbientLux) goto L19;
        if (this.mLoggingEnabled == false) goto L21;
        Slog.d(TAG, "ShortTermModel: re-validate user data, ambient lux is " + minAmbientLux + " < " + ambientLux + " < " + maxAmbientLux);
        return false;
    L21:
        return false;
    L5:
        if (Float.isNaN(config.getShortTermModelLowerLuxMultiplier()) == true) goto L8;
        minThresholdRatio = config.getShortTermModelLowerLuxMultiplier();
    L8:
        if (Float.isNaN(config.getShortTermModelUpperLuxMultiplier()) == true) goto L10;
        maxThresholdRatio = config.getShortTermModelUpperLuxMultiplier();
        goto L10
    }

    protected Pair<float[], float[]> insertControlPoint(float[] luxLevels, float[] brightnessLevels, float lux, float brightness) {
        int idx = findInsertionPoint(luxLevels, lux);
        if (idx != luxLevels.length) goto L6;
        float[] newLuxLevels = Arrays.copyOf(luxLevels, luxLevels.length + 1);
        float[] newBrightnessLevels = Arrays.copyOf(brightnessLevels, brightnessLevels.length + 1);
        newLuxLevels[idx] = lux;
        newBrightnessLevels[idx] = brightness;
    L9:
        smoothCurve(newLuxLevels, newBrightnessLevels, idx);
        return Pair.create(newLuxLevels, newBrightnessLevels);
    L6:
        if (luxLevels[idx] != lux) goto L8;
        newLuxLevels = Arrays.copyOf(luxLevels, luxLevels.length);
        newBrightnessLevels = Arrays.copyOf(brightnessLevels, brightnessLevels.length);
        newBrightnessLevels[idx] = brightness;
        goto L9
    L8:
        newLuxLevels = Arrays.copyOf(luxLevels, luxLevels.length + 1);
        System.arraycopy(newLuxLevels, idx, newLuxLevels, idx + 1, luxLevels.length - idx);
        newLuxLevels[idx] = lux;
        newBrightnessLevels = Arrays.copyOf(brightnessLevels, brightnessLevels.length + 1);
        System.arraycopy(newBrightnessLevels, idx, newBrightnessLevels, idx + 1, brightnessLevels.length - idx);
        newBrightnessLevels[idx] = brightness;
        goto L9
    }

    private int findInsertionPoint(float[] arr, float val) {
        int i = 0;
    L4:
        if (i >= arr.length) goto L9;
        if (val <= arr[i]) goto L7;
        i = i + 1;
        goto L4
    L7:
        return i;
    L9:
        int i2 = arr.length;
        return i2;
    }

    private void smoothCurve(float[] lux, float[] brightness, int idx) {
        if (this.mLoggingEnabled == false) goto L5;
        PLOG.logCurve("unsmoothed curve", lux, brightness);
    L5:
        float prevLux = lux[idx];
        float prevBrightness = brightness[idx];
        int i = idx + 1;
    L7:
        if (i >= lux.length) goto L12;
        float currLux = lux[i];
        float currBrightness = brightness[i];
        float maxBrightness = MathUtils.max(permissibleRatio(currLux, prevLux) * prevBrightness, MIN_PERMISSABLE_INCREASE + prevBrightness);
        float newBrightness = MathUtils.constrain(currBrightness, prevBrightness, maxBrightness);
        if (newBrightness == currBrightness) goto L12;
        prevLux = currLux;
        prevBrightness = newBrightness;
        brightness[i] = newBrightness;
        i = i + 1;
    L12:
        float prevLux2 = lux[idx];
        float prevBrightness2 = brightness[idx];
        int i2 = idx - 1;
    L13:
        if (i2 < 0) goto L19;
        float currLux2 = lux[i2];
        float currBrightness2 = brightness[i2];
        float minBrightness = permissibleRatio(currLux2, prevLux2) * prevBrightness2;
        float newBrightness2 = MathUtils.constrain(currBrightness2, minBrightness, prevBrightness2);
        if (newBrightness2 == currBrightness2) goto L19;
        prevLux2 = currLux2;
        prevBrightness2 = newBrightness2;
        brightness[i2] = newBrightness2;
        i2 = i2 - 1;
    L19:
        if (this.mLoggingEnabled == false) goto L26;
        PLOG.logCurve("smoothed curve", lux, brightness);
        return;
    }

    private float permissibleRatio(float currLux, float prevLux) {
        return MathUtils.pow((currLux + LUX_GRAD_SMOOTHING) / (LUX_GRAD_SMOOTHING + prevLux), 1.0f);
    }

    protected float inferAutoBrightnessAdjustment(float maxGamma, float desiredBrightness, float currentBrightness) {
        float gamma = Float.NaN;
        if (currentBrightness > 0.1f) goto L5;
    L14:
        float adjustment = desiredBrightness - currentBrightness;
    L15:
        float adjustment2 = MathUtils.constrain(adjustment, -1.0f, 1.0f);
        if (this.mLoggingEnabled == false) goto L18;
        Slog.d(TAG, "inferAutoBrightnessAdjustment: " + maxGamma + "^" + (-adjustment2) + "=" + MathUtils.pow(maxGamma, -adjustment2) + " == " + gamma);
        Slog.d(TAG, "inferAutoBrightnessAdjustment: " + currentBrightness + "^" + gamma + "=" + MathUtils.pow(currentBrightness, gamma) + " == " + desiredBrightness);
    L18:
        return adjustment2;
    L5:
        if (currentBrightness >= 0.9f) goto L14;
        if (desiredBrightness != 0.0f) goto L11;
        adjustment = -1.0f;
        goto L15
    L11:
        if (desiredBrightness != 1.0f) goto L13;
        adjustment = 1.0f;
        goto L15
    L13:
        gamma = MathUtils.log(desiredBrightness) / MathUtils.log(currentBrightness);
        adjustment = (-MathUtils.log(gamma)) / MathUtils.log(maxGamma);
        goto L15
    }

    protected Pair<float[], float[]> getAdjustedCurve(float[] lux, float[] brightness, float userLux, float userBrightness, float adjustment, float maxGamma) {
        float[] newLux = lux;
        float[] newBrightness = Arrays.copyOf(brightness, brightness.length);
        if (this.mLoggingEnabled == false) goto L5;
        PLOG.logCurve("unadjusted curve", newLux, newBrightness);
    L5:
        float adjustment2 = MathUtils.constrain(adjustment, -1.0f, 1.0f);
        float gamma = MathUtils.pow(maxGamma, -adjustment2);
        if (this.mLoggingEnabled == false) goto L9;
        Slog.d(TAG, "getAdjustedCurve: " + maxGamma + "^" + (-adjustment2) + "=" + MathUtils.pow(maxGamma, -adjustment2) + " == " + gamma);
    L9:
        if (gamma == 1.0f) goto L15;
        int i = 0;
    L12:
        if (i >= newBrightness.length) goto L15;
        newBrightness[i] = MathUtils.pow(newBrightness[i], gamma);
        i = i + 1;
    L15:
        if (this.mLoggingEnabled == false) goto L18;
        PLOG.logCurve("gamma adjusted curve", newLux, newBrightness);
    L18:
        if (userLux == (-1.0f)) goto L23;
        Pair<float[], float[]> curve = insertControlPoint(newLux, newBrightness, userLux, userBrightness);
        newLux = (float[]) curve.first;
        newBrightness = (float[]) curve.second;
        if (this.mLoggingEnabled == false) goto L23;
        PLOG.logCurve("gamma and user adjusted curve", newLux, newBrightness);
        Pair<float[], float[]> curve2 = insertControlPoint(lux, brightness, userLux, userBrightness);
        PLOG.logCurve("user adjusted curve", (float[]) curve2.first, (float[]) curve2.second);
    L23:
        return Pair.create(newLux, newBrightness);
    }
}
