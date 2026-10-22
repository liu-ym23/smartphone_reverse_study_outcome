package com.android.server.display.color;

import android.R;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.app.AlarmManager;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageManagerInternal;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.hardware.display.ColorDisplayManager;
import android.hardware.display.DisplayManagerInternal;
import android.hardware.display.IColorDisplayManager;
import android.hardware.display.IColorDisplayManagerExt;
import android.hardware.display.Time;
import android.opengl.Matrix;
import android.os.Binder;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.ParcelFileDescriptor;
import android.os.SystemProperties;
import android.os.UserHandle;
import android.os.UserManager;
import android.pico.utils.ExtImplFactory;
import android.provider.Settings;
import android.util.MathUtils;
import android.util.Slog;
import android.util.SparseIntArray;
import android.util.Spline;
import android.view.SurfaceControl;
import android.view.animation.AnimationUtils;
import com.android.internal.util.DumpUtils;
import com.android.server.DisplayThread;
import com.android.server.LocalServices;
import com.android.server.SystemService;
import com.android.server.am.HostingRecord;
import com.android.server.am.ProcessList;
import com.android.server.display.feature.DisplayManagerFlags;
import com.android.server.pm.UserManagerService;
import com.android.server.twilight.TwilightListener;
import com.android.server.twilight.TwilightManager;
import com.android.server.twilight.TwilightState;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;

/* JADX INFO: loaded from: classes2.dex */
public final class ColorDisplayService extends SystemService {
    private static final ColorMatrixEvaluator COLOR_MATRIX_EVALUATOR = null;
    private static final int EVEN_DIMMER_MAX_PERCENT_ALLOWED = 100;
    private static final float[] MATRIX_GRAYSCALE = null;
    static final float[] MATRIX_IDENTITY = null;
    private static final float[] MATRIX_INVERT_COLOR = null;
    private static final int MSG_APPLY_DISPLAY_WHITE_BALANCE = 5;
    private static final int MSG_APPLY_GLOBAL_SATURATION = 4;
    protected static final int MSG_APPLY_NIGHT_DISPLAY_ANIMATED = 3;
    private static final int MSG_APPLY_NIGHT_DISPLAY_IMMEDIATE = 2;
    private static final int MSG_APPLY_REDUCE_BRIGHT_COLORS = 6;
    private static final int MSG_SET_UP = 1;
    private static final int MSG_USER_CHANGED = 0;
    private static final int NOT_SET = -1;
    private static final int PERCENTAGE_MAX = 100;
    private static final int PERCENTAGE_MIN = 0;
    static final String TAG = "ColorDisplayService";
    private final AppSaturationController mAppSaturationController;
    private boolean mBootCompleted;
    private final Object mCctTintApplierLock;
    private SparseIntArray mColorModeCompositionColorSpaces;
    private ContentObserver mContentObserver;
    private int mCurrentUser;
    private final DisplayManagerFlags mDisplayManagerFlags;
    private DisplayWhiteBalanceListener mDisplayWhiteBalanceListener;
    final DisplayWhiteBalanceTintController mDisplayWhiteBalanceTintController;
    private boolean mEvenDimmerActivated;
    private Spline mEvenDimmerSpline;
    private IExtColorDisplayService mExt;
    private final TintController mGlobalSaturationTintController;
    final Handler mHandler;
    private NightDisplayAutoMode mNightDisplayAutoMode;
    private int mNightDisplayMode;
    private final NightDisplayTintController mNightDisplayTintController;
    private ReduceBrightColorsListener mReduceBrightColorsListener;
    private final ReduceBrightColorsTintController mReduceBrightColorsTintController;
    private TwilightState mTwilightState;
    private final UserManagerService mUserManager;
    private ContentObserver mUserSetupObserver;
    private final boolean mVisibleBackgroundUsersEnabled;

    final class BinderService extends IColorDisplayManager.Stub {
        final /* synthetic */ ColorDisplayService this$0;

        BinderService(ColorDisplayService this$0) {
            this.this$0 = this$0;
        }

        public void setColorMode(int colorMode) {
            setColorMode_enforcePermission();
            ColorDisplayService.m4034$$Nest$menforceValidCallingUser(this.this$0, "setColorMode");
            long token = Binder.clearCallingIdentity();
            ColorDisplayService.m4052$$Nest$msetColorModeInternal(this.this$0, colorMode);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(token);
            return;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        }

        public int getColorMode() {
            long token = Binder.clearCallingIdentity();
            int r2 = ColorDisplayService.m4035$$Nest$mgetColorModeInternal(this.this$0);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(token);
            return r2;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        }

        public boolean isDeviceColorManaged() {
            long token = Binder.clearCallingIdentity();
            boolean r2 = ColorDisplayService.m4042$$Nest$misDeviceColorManagedInternal(this.this$0);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(token);
            return r2;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        }

        public boolean setSaturationLevel(int level) {
            boolean hasLegacyPermission = false;
            if (this.this$0.getContext().checkCallingOrSelfPermission("android.permission.CONTROL_DISPLAY_COLOR_TRANSFORMS") != 0) goto L5;
            boolean hasTransformsPermission = true;
        L7:
            if (this.this$0.getContext().checkCallingPermission("android.permission.CONTROL_DISPLAY_SATURATION") != 0) goto L9;
            hasLegacyPermission = true;
        L9:
            if (hasTransformsPermission == true) goto L14;
            if (hasLegacyPermission == true) goto L14;
            throw new SecurityException("Permission required to set display saturation level");
        L14:
            ColorDisplayService.m4034$$Nest$menforceValidCallingUser(this.this$0, "setSaturationLevel");
            long token = Binder.clearCallingIdentity();
            this.this$0.setSaturationLevelInternal(level);     // Catch: Throwable -> L18
            Binder.restoreCallingIdentity(token);
            return true;
        L18:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        L5:
            hasTransformsPermission = false;
            goto L7
        }

        public boolean isSaturationActivated() {
            super.isSaturationActivated_enforcePermission();
            long token = Binder.clearCallingIdentity();
        L8:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        L4:
            if (ColorDisplayService.m4021$$Nest$fgetmGlobalSaturationTintController(this.this$0).isActivatedStateNotSet() == true) goto L10;
            if (ColorDisplayService.m4021$$Nest$fgetmGlobalSaturationTintController(this.this$0).isActivated() == false) goto L10;
            boolean r2 = true;
        L11:
            Binder.restoreCallingIdentity(token);
            return r2;
        L10:
            r2 = false;
            goto L11
        }

        public boolean setAppSaturationLevel(String packageName, int level) {
            super.setAppSaturationLevel_enforcePermission();
            ColorDisplayService.m4034$$Nest$menforceValidCallingUser(this.this$0, "setAppSaturationLevel");
            String callingPackageName = ((PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class)).getNameForUid(Binder.getCallingUid());
            long token = Binder.clearCallingIdentity();
            boolean r3 = this.this$0.setAppSaturationLevelInternal(callingPackageName, packageName, level);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(token);
            return r3;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        }

        public int getTransformCapabilities() {
            super.getTransformCapabilities_enforcePermission();
            long token = Binder.clearCallingIdentity();
            int r2 = ColorDisplayService.m4041$$Nest$mgetTransformCapabilitiesInternal(this.this$0);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(token);
            return r2;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        }

        public boolean setNightDisplayActivated(boolean activated) {
            setNightDisplayActivated_enforcePermission();
            ColorDisplayService.m4034$$Nest$menforceValidCallingUser(this.this$0, "setNightDisplayActivated");
            long token = Binder.clearCallingIdentity();
            ColorDisplayService.m4023$$Nest$fgetmNightDisplayTintController(this.this$0).setActivated(Boolean.valueOf(activated));     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(token);
            return true;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        }

        public boolean isNightDisplayActivated() {
            long token = Binder.clearCallingIdentity();
            boolean r2 = ColorDisplayService.m4023$$Nest$fgetmNightDisplayTintController(this.this$0).isActivated();     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(token);
            return r2;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        }

        public boolean setNightDisplayColorTemperature(int temperature) {
            setNightDisplayColorTemperature_enforcePermission();
            ColorDisplayService.m4034$$Nest$menforceValidCallingUser(this.this$0, "setNightDisplayColorTemperature");
            long token = Binder.clearCallingIdentity();
            boolean r2 = ColorDisplayService.m4023$$Nest$fgetmNightDisplayTintController(this.this$0).setColorTemperature(temperature);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(token);
            return r2;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        }

        public int getNightDisplayColorTemperature() {
            long token = Binder.clearCallingIdentity();
            int r2 = ColorDisplayService.m4023$$Nest$fgetmNightDisplayTintController(this.this$0).getColorTemperature();     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(token);
            return r2;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        }

        public boolean setNightDisplayAutoMode(int autoMode) {
            setNightDisplayAutoMode_enforcePermission();
            ColorDisplayService.m4034$$Nest$menforceValidCallingUser(this.this$0, "setNightDisplayAutoMode");
            long token = Binder.clearCallingIdentity();
            boolean r2 = ColorDisplayService.m4054$$Nest$msetNightDisplayAutoModeInternal(this.this$0, autoMode);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(token);
            return r2;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        }

        public int getNightDisplayAutoMode() {
            getNightDisplayAutoMode_enforcePermission();
            long token = Binder.clearCallingIdentity();
            int r2 = ColorDisplayService.m4036$$Nest$mgetNightDisplayAutoModeInternal(this.this$0);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(token);
            return r2;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        }

        public int getNightDisplayAutoModeRaw() {
            long token = Binder.clearCallingIdentity();
            int r2 = ColorDisplayService.m4037$$Nest$mgetNightDisplayAutoModeRawInternal(this.this$0);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(token);
            return r2;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        }

        public boolean setNightDisplayCustomStartTime(Time startTime) {
            setNightDisplayCustomStartTime_enforcePermission();
            ColorDisplayService.m4034$$Nest$menforceValidCallingUser(this.this$0, "setNightDisplayCustomStartTime");
            long token = Binder.clearCallingIdentity();
            boolean r2 = ColorDisplayService.m4056$$Nest$msetNightDisplayCustomStartTimeInternal(this.this$0, startTime);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(token);
            return r2;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        }

        public Time getNightDisplayCustomStartTime() {
            long token = Binder.clearCallingIdentity();
            Time r2 = ColorDisplayService.m4039$$Nest$mgetNightDisplayCustomStartTimeInternal(this.this$0);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(token);
            return r2;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        }

        public boolean setNightDisplayCustomEndTime(Time endTime) {
            setNightDisplayCustomEndTime_enforcePermission();
            ColorDisplayService.m4034$$Nest$menforceValidCallingUser(this.this$0, "setNightDisplayCustomEndTime");
            long token = Binder.clearCallingIdentity();
            boolean r2 = ColorDisplayService.m4055$$Nest$msetNightDisplayCustomEndTimeInternal(this.this$0, endTime);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(token);
            return r2;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        }

        public Time getNightDisplayCustomEndTime() {
            long token = Binder.clearCallingIdentity();
            Time r2 = ColorDisplayService.m4038$$Nest$mgetNightDisplayCustomEndTimeInternal(this.this$0);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(token);
            return r2;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        }

        public boolean setDisplayWhiteBalanceEnabled(boolean enabled) {
            setDisplayWhiteBalanceEnabled_enforcePermission();
            ColorDisplayService.m4034$$Nest$menforceValidCallingUser(this.this$0, "setDisplayWhiteBalanceEnabled");
            long token = Binder.clearCallingIdentity();
            boolean r2 = ColorDisplayService.m4053$$Nest$msetDisplayWhiteBalanceSettingEnabled(this.this$0, enabled);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(token);
            return r2;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        }

        public boolean isDisplayWhiteBalanceEnabled() {
            long token = Binder.clearCallingIdentity();
            boolean r2 = ColorDisplayService.m4043$$Nest$misDisplayWhiteBalanceSettingEnabled(this.this$0);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(token);
            return r2;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        }

        public boolean isReduceBrightColorsActivated() {
            long token = Binder.clearCallingIdentity();
            boolean r2 = ColorDisplayService.m4024$$Nest$fgetmReduceBrightColorsTintController(this.this$0).isActivated();     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(token);
            return r2;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        }

        public boolean setReduceBrightColorsActivated(boolean activated) {
            setReduceBrightColorsActivated_enforcePermission();
            ColorDisplayService.m4034$$Nest$menforceValidCallingUser(this.this$0, "setReduceBrightColorsActivated");
            long token = Binder.clearCallingIdentity();
            boolean r2 = ColorDisplayService.m4057$$Nest$msetReduceBrightColorsActivatedInternal(this.this$0, activated);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(token);
            return r2;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        }

        public int getReduceBrightColorsStrength() {
            long token = Binder.clearCallingIdentity();
            int r2 = ColorDisplayService.m4024$$Nest$fgetmReduceBrightColorsTintController(this.this$0).getStrength();     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(token);
            return r2;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        }

        public float getReduceBrightColorsOffsetFactor() {
            long token = Binder.clearCallingIdentity();
            float r2 = ColorDisplayService.m4024$$Nest$fgetmReduceBrightColorsTintController(this.this$0).getOffsetFactor();     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(token);
            return r2;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        }

        public boolean setReduceBrightColorsStrength(int strength) {
            setReduceBrightColorsStrength_enforcePermission();
            ColorDisplayService.m4034$$Nest$menforceValidCallingUser(this.this$0, "setReduceBrightColorsStrength");
            long token = Binder.clearCallingIdentity();
            boolean r2 = ColorDisplayService.m4058$$Nest$msetReduceBrightColorsStrengthInternal(this.this$0, strength);     // Catch: Throwable -> L6
            Binder.restoreCallingIdentity(token);
            return r2;
        L6:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        }

        public void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
            if (DumpUtils.checkDumpPermission(this.this$0.getContext(), ColorDisplayService.TAG, pw) == true) goto L5;
            return;
        L5:
            long token = Binder.clearCallingIdentity();
            ColorDisplayService.m4033$$Nest$mdumpInternal(this.this$0, pw, args);     // Catch: Throwable -> L9
            Binder.restoreCallingIdentity(token);
            return;
        L9:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int handleShellCommand(ParcelFileDescriptor in, ParcelFileDescriptor out, ParcelFileDescriptor err, String[] args) {
            this.this$0.getContext().enforceCallingOrSelfPermission("android.permission.CONTROL_DISPLAY_COLOR_TRANSFORMS", "Permission required to use ADB color transform commands");
            long token = Binder.clearCallingIdentity();
            int r13 = new ColorDisplayShellCommand(this.this$0).exec(this, in.getFileDescriptor(), out.getFileDescriptor(), err.getFileDescriptor(), args);     // Catch: Throwable -> L8
            Binder.restoreCallingIdentity(token);
            return r13;
        L8:
            th = move-exception;
            Throwable r14 = th;
        L12:
            Binder.restoreCallingIdentity(token);
            throw r14;
        L10:
            th = move-exception;
            r14 = th;
            goto L12
        }

        public IColorDisplayManagerExt getExtInstance() {
            return ColorDisplayService.m4020$$Nest$fgetmExt(this.this$0).getExtInstance();
        }
    }

    public class ColorDisplayServiceInternal {
        final /* synthetic */ ColorDisplayService this$0;

        public ColorDisplayServiceInternal(ColorDisplayService this$0) {
            this.this$0 = this$0;
        }

        public void setDisplayWhiteBalanceAllowed(boolean allowed) {
            this.this$0.mDisplayWhiteBalanceTintController.setAllowed(allowed);
            this.this$0.updateDisplayWhiteBalanceStatus();
        }

        public boolean setDisplayWhiteBalanceColorTemperature(int cct) {
            this.this$0.mDisplayWhiteBalanceTintController.setTargetCct(cct);
            if (this.this$0.mDisplayWhiteBalanceTintController.isActivated() == false) goto L6;
            this.this$0.mHandler.sendEmptyMessage(5);
            return true;
        L6:
            return false;
        }

        public float getDisplayWhiteBalanceLuminance() {
            return this.this$0.mDisplayWhiteBalanceTintController.getLuminance();
        }

        public boolean resetDisplayWhiteBalanceColorTemperature() {
            int temperatureDefault = this.this$0.getContext().getResources().getInteger(R.integer.config_dockedStackDividerSnapMode);
            Slog.d(ColorDisplayService.TAG, "resetDisplayWhiteBalanceColorTemperature: " + temperatureDefault);
            return setDisplayWhiteBalanceColorTemperature(temperatureDefault);
        }

        public boolean setDisplayWhiteBalanceListener(DisplayWhiteBalanceListener listener) {
            ColorDisplayService.m4025$$Nest$fputmDisplayWhiteBalanceListener(this.this$0, listener);
            return this.this$0.mDisplayWhiteBalanceTintController.isActivated();
        }

        public boolean isDisplayWhiteBalanceEnabled() {
            return ColorDisplayService.m4043$$Nest$misDisplayWhiteBalanceSettingEnabled(this.this$0);
        }

        public float getAdjustedNitsForStrength(float nits, int strength) {
            return ColorDisplayService.m4024$$Nest$fgetmReduceBrightColorsTintController(this.this$0).getAdjustedNitsForStrength(nits, strength);
        }

        public boolean setReduceBrightColorsListener(ReduceBrightColorsListener listener) {
            ColorDisplayService.m4028$$Nest$fputmReduceBrightColorsListener(this.this$0, listener);
            return ColorDisplayService.m4024$$Nest$fgetmReduceBrightColorsTintController(this.this$0).isActivated();
        }

        public boolean isReduceBrightColorsActivated() {
            return ColorDisplayService.m4024$$Nest$fgetmReduceBrightColorsTintController(this.this$0).isActivated();
        }

        public int getReduceBrightColorsStrength() {
            return ColorDisplayService.m4024$$Nest$fgetmReduceBrightColorsTintController(this.this$0).getStrength();
        }

        public boolean getReduceBrightColorsActivatedForEvenDimmer() {
            return ColorDisplayService.m4018$$Nest$fgetmEvenDimmerActivated(this.this$0);
        }

        public float getReduceBrightColorsAdjustedBrightnessNits(float nits) {
            return ColorDisplayService.m4024$$Nest$fgetmReduceBrightColorsTintController(this.this$0).getAdjustedBrightness(nits);
        }

        public boolean attachColorTransformController(String packageName, int userId, WeakReference<ColorTransformController> controller) {
            return ColorDisplayService.m4014$$Nest$fgetmAppSaturationController(this.this$0).addColorTransformController(packageName, userId, controller);
        }

        public void applyEvenDimmerColorChanges(boolean enabled, int strength) {
            ColorDisplayService.m4026$$Nest$fputmEvenDimmerActivated(this.this$0, enabled);
            ColorDisplayService.m4024$$Nest$fgetmReduceBrightColorsTintController(this.this$0).setActivated(Boolean.valueOf(enabled));
            ColorDisplayService.m4024$$Nest$fgetmReduceBrightColorsTintController(this.this$0).setMatrix(strength);
            this.this$0.mHandler.sendEmptyMessage(6);
        }

        public Spline fetchEvenDimmerSpline(float nits) {
            if (ColorDisplayService.m4019$$Nest$fgetmEvenDimmerSpline(this.this$0) != null) goto L6;
            ColorDisplayService.m4027$$Nest$fputmEvenDimmerSpline(this.this$0, createNitsToStrengthSpline(nits));
        L6:
            return ColorDisplayService.m4019$$Nest$fgetmEvenDimmerSpline(this.this$0);
        }

        private Spline createNitsToStrengthSpline(float nits) {
            float[] requestedNits = new float[101];
            float[] resultingStrength = new float[101];
            int i = 0;
        L4:
            if (i > 100) goto L11;
            resultingStrength[100 - i] = i;
            requestedNits[100 - i] = getAdjustedNitsForStrength(nits, i);
            if (requestedNits[100 - i] == 0.0f) goto L7;
            i = i + 1;
            goto L4
        L7:
            return null;
        L11:
            return new Spline.LinearSpline(requestedNits, resultingStrength);
        }
    }

    private static class ColorMatrixEvaluator implements TypeEvaluator<float[]> {
        private final float[] mResultMatrix;

        /* synthetic */ ColorMatrixEvaluator(ColorDisplayServiceIA r1) {
            this();
        }

        private ColorMatrixEvaluator() {
            this.mResultMatrix = new float[16];
        }

        @Override // android.animation.TypeEvaluator
        public /* bridge */ /* synthetic */ float[] evaluate(float r1, float[] r2, float[] r3) {
            return evaluate2(r1, r2, r3);
        }

        /* JADX INFO: renamed from: evaluate, reason: avoid collision after fix types in other method */
        public float[] evaluate2(float fraction, float[] startValue, float[] endValue) {
            int i = 0;
        L4:
            if (i >= this.mResultMatrix.length) goto L7;
            this.mResultMatrix[i] = MathUtils.lerp(startValue[i], endValue[i], fraction);
            i = i + 1;
            goto L4
        L7:
            return this.mResultMatrix;
        }
    }

    public interface ColorTransformController {
        void applyAppSaturation(float[] r1, float[] r2);
    }

    private final class CustomNightDisplayAutoMode extends NightDisplayAutoMode implements AlarmManager.OnAlarmListener {
        private final AlarmManager mAlarmManager;
        private LocalTime mEndTime;
        private LocalDateTime mLastActivatedTime;
        private LocalTime mStartTime;
        private final BroadcastReceiver mTimeChangedReceiver;
        final /* synthetic */ ColorDisplayService this$0;

        /* JADX INFO: renamed from: -$$Nest$mupdateActivated, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m4061$$Nest$mupdateActivated(CustomNightDisplayAutoMode r0) {
            r0.updateActivated();
        }

        CustomNightDisplayAutoMode(final ColorDisplayService r3) {
            this.this$0 = r3;
            super(r3, null);
            this.mAlarmManager = (AlarmManager) r3.getContext().getSystemService(HostingRecord.TRIGGER_TYPE_ALARM);
            this.mTimeChangedReceiver = new AnonymousClass1(this, r3);
        }

        private void updateActivated() {
            LocalDateTime now = LocalDateTime.now();
            LocalDateTime start = ColorDisplayService.getDateTimeBefore(this.mStartTime, now);
            LocalDateTime end = ColorDisplayService.getDateTimeAfter(this.mEndTime, start);
            boolean activate = now.isBefore(end);
            if (this.mLastActivatedTime == null) goto L14;
            if (this.mLastActivatedTime.isBefore(now) == false) goto L14;
            if (this.mLastActivatedTime.isAfter(start) == false) goto L14;
            if (this.mLastActivatedTime.isAfter(end) == false) goto L11;
        L12:
            activate = ColorDisplayService.m4023$$Nest$fgetmNightDisplayTintController(this.this$0).isActivatedSetting();
            goto L14
        L11:
            if (now.isBefore(end) == true) goto L12;
        L14:
            if (ColorDisplayService.m4023$$Nest$fgetmNightDisplayTintController(this.this$0).isActivatedStateNotSet() == false) goto L16;
        L17:
            NightDisplayTintController r4 = ColorDisplayService.m4023$$Nest$fgetmNightDisplayTintController(this.this$0);
            Boolean r5 = Boolean.valueOf(activate);
            if (activate == false) goto L20;
            LocalDateTime r6 = start;
        L21:
            r4.setActivated(r5, r6);
        L22:
            updateNextAlarm(Boolean.valueOf(ColorDisplayService.m4023$$Nest$fgetmNightDisplayTintController(this.this$0).isActivated()), now);
            return;
        L20:
            r6 = end;
            goto L21
        L16:
            if (ColorDisplayService.m4023$$Nest$fgetmNightDisplayTintController(this.this$0).isActivated() == activate) goto L22;
            goto L17
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [java.time.ZonedDateTime] */
        private void updateNextAlarm(Boolean activated, LocalDateTime now) {
            if (activated != null) goto L4;
            return;
        L4:
            if (activated.booleanValue() == false) goto L6;
            LocalDateTime next = ColorDisplayService.getDateTimeAfter(this.mEndTime, now);
        L7:
            long millis = next.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
            this.mAlarmManager.setExact(1, millis, ColorDisplayService.TAG, this, null);
            return;
        L6:
            next = ColorDisplayService.getDateTimeAfter(this.mStartTime, now);
            goto L7
        }

        @Override // com.android.server.display.color.ColorDisplayService.NightDisplayAutoMode
        public void onStart() {
            IntentFilter intentFilter = new IntentFilter("android.intent.action.TIME_SET");
            intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
            this.this$0.getContext().registerReceiver(this.mTimeChangedReceiver, intentFilter);
            this.mStartTime = ColorDisplayService.m4039$$Nest$mgetNightDisplayCustomStartTimeInternal(this.this$0).getLocalTime();
            this.mEndTime = ColorDisplayService.m4038$$Nest$mgetNightDisplayCustomEndTimeInternal(this.this$0).getLocalTime();
            this.mLastActivatedTime = ColorDisplayService.m4040$$Nest$mgetNightDisplayLastActivatedTimeSetting(this.this$0);
            updateActivated();
        }

        @Override // com.android.server.display.color.ColorDisplayService.NightDisplayAutoMode
        public void onStop() {
            this.this$0.getContext().unregisterReceiver(this.mTimeChangedReceiver);
            this.mAlarmManager.cancel(this);
            this.mLastActivatedTime = null;
        }

        @Override // com.android.server.display.color.ColorDisplayService.NightDisplayAutoMode
        public void onActivated(boolean activated) {
            this.mLastActivatedTime = ColorDisplayService.m4040$$Nest$mgetNightDisplayLastActivatedTimeSetting(this.this$0);
            updateNextAlarm(Boolean.valueOf(activated), LocalDateTime.now());
        }

        @Override // com.android.server.display.color.ColorDisplayService.NightDisplayAutoMode
        public void onCustomStartTimeChanged(LocalTime startTime) {
            this.mStartTime = startTime;
            this.mLastActivatedTime = null;
            updateActivated();
        }

        @Override // com.android.server.display.color.ColorDisplayService.NightDisplayAutoMode
        public void onCustomEndTimeChanged(LocalTime endTime) {
            this.mEndTime = endTime;
            this.mLastActivatedTime = null;
            updateActivated();
        }

        @Override // android.app.AlarmManager.OnAlarmListener
        public void onAlarm() {
            Slog.d(ColorDisplayService.TAG, "onAlarm");
            updateActivated();
        }
    }

    public interface DisplayWhiteBalanceListener {
        void onDisplayWhiteBalanceStatusChanged(boolean r1);
    }

    private abstract class NightDisplayAutoMode {
        /* synthetic */ NightDisplayAutoMode(ColorDisplayService r1, ColorDisplayServiceIA r2) {
            this(r1);
        }

        public abstract void onActivated(boolean r1);

        public abstract void onStart();

        public abstract void onStop();

        private NightDisplayAutoMode(ColorDisplayService r1) {
        }

        public void onCustomStartTimeChanged(LocalTime startTime) {
        }

        public void onCustomEndTimeChanged(LocalTime endTime) {
        }
    }

    private final class NightDisplayTintController extends TintController {
        private Integer mColorTemp;
        private final float[] mColorTempCoefficients;
        private Boolean mIsAvailable;
        private final float[] mMatrix;
        final /* synthetic */ ColorDisplayService this$0;

        /* synthetic */ NightDisplayTintController(ColorDisplayService r1, ColorDisplayServiceIA r2) {
            this(r1);
        }

        private NightDisplayTintController(ColorDisplayService r1) {
            this.this$0 = r1;
            this.mMatrix = new float[16];
            this.mColorTempCoefficients = new float[9];
        }

        @Override // com.android.server.display.color.TintController
        public void setUp(Context context, boolean needsLinear) {
            Resources r0 = context.getResources();
            if (needsLinear == false) goto L5;
            int r1 = R.array.config_reduceBrightColorsCoefficientsNonlinear;
        L6:
            String[] coefficients = r0.getStringArray(r1);
            int i = 0;
        L8:
            if (i >= 9) goto L12;
            if (i >= coefficients.length) goto L15;
            this.mColorTempCoefficients[i] = Float.parseFloat(coefficients[i]);
            i = i + 1;
            goto L8
        L15:
            return;
        L12:
            return;
        L5:
            r1 = R.array.config_requestVibrationParamsForUsages;
            goto L6
        }

        @Override // com.android.server.display.color.TintController
        public void setMatrix(int cct) {
            if (this.mMatrix.length == 16) goto L6;
            Slog.d(ColorDisplayService.TAG, "The display transformation matrix must be 4x4");
            return;
        L6:
            Matrix.setIdentityM(this.mMatrix, 0);
            ColorDisplayService.m4020$$Nest$fgetmExt(this.this$0).setMatrix(cct, this.mMatrix);
        }

        @Override // com.android.server.display.color.TintController
        public float[] getMatrix() {
            return ColorDisplayService.m4020$$Nest$fgetmExt(this.this$0).getMatrix(isActivated(), this.mMatrix);
        }

        @Override // com.android.server.display.color.TintController
        public void setActivated(Boolean activated) {
            setActivated(activated, LocalDateTime.now());
        }

        public void setActivated(Boolean r6, LocalDateTime r7) {
            if (r6 != null) goto L6;
            super.setActivated(null);
            return;
        L6:
            if (r6.booleanValue() == isActivated()) goto L8;
            boolean r0 = true;
        L10:
            if (isActivatedStateNotSet() == true) goto L14;
            if (r0 == false) goto L14;
            Settings.Secure.putStringForUser(this.this$0.getContext().getContentResolver(), "night_display_last_activated_time", r7.toString(), ColorDisplayService.m4017$$Nest$fgetmCurrentUser(this.this$0));
        L14:
            if (isActivatedStateNotSet() == true) goto L16;
            if (r0 == true) goto L16;
            return;
        L16:
            super.setActivated(r6);
            if (isActivatedSetting() == r6.booleanValue()) goto L19;
            ContentResolver r1 = this.this$0.getContext().getContentResolver();
            boolean r2 = r6.booleanValue();
            int r3 = ColorDisplayService.m4017$$Nest$fgetmCurrentUser(this.this$0);
            Settings.Secure.putIntForUser(r1, "night_display_activated", r2 ? 1 : 0, r3);
        L19:
            ColorDisplayService.m4020$$Nest$fgetmExt(this.this$0).setEyeActivated(r6.booleanValue());
            onActivated(r6.booleanValue());
            return;
        L8:
            r0 = false;
            goto L10
        }

        @Override // com.android.server.display.color.TintController
        public int getLevel() {
            return 100;
        }

        @Override // com.android.server.display.color.TintController
        public boolean isAvailable(Context context) {
            if (this.mIsAvailable != null) goto L6;
            this.mIsAvailable = Boolean.valueOf(ColorDisplayManager.isNightDisplayAvailable(context));
        L6:
            return this.mIsAvailable.booleanValue();
        }

        private void onActivated(boolean activated) {
            if (activated == false) goto L4;
            String r0 = "Turning on night display";
        L5:
            Slog.i(ColorDisplayService.TAG, r0);
            if (ColorDisplayService.m4022$$Nest$fgetmNightDisplayAutoMode(this.this$0) == null) goto L9;
            ColorDisplayService.m4022$$Nest$fgetmNightDisplayAutoMode(this.this$0).onActivated(activated);
        L9:
            if (this.this$0.mDisplayWhiteBalanceTintController.isAvailable(this.this$0.getContext()) == false) goto L11;
            this.this$0.updateDisplayWhiteBalanceStatus();
        L11:
            this.this$0.mHandler.sendEmptyMessage(3);
            return;
        L4:
            r0 = "Turning off night display";
            goto L5
        }

        int getColorTemperature() {
            if (this.mColorTemp == null) goto L6;
            return clampNightDisplayColorTemperature(this.mColorTemp.intValue());
        L6:
            return getColorTemperatureSetting();
        }

        boolean setColorTemperature(int temperature) {
            this.mColorTemp = Integer.valueOf(temperature);
            boolean success = Settings.Secure.putIntForUser(this.this$0.getContext().getContentResolver(), "night_display_color_temperature", temperature, ColorDisplayService.m4017$$Nest$fgetmCurrentUser(this.this$0));
            onColorTemperatureChanged(temperature);
            return success;
        }

        void onColorTemperatureChanged(int temperature) {
            setMatrix(temperature);
            this.this$0.mHandler.sendEmptyMessage(2);
        }

        boolean isActivatedSetting() {
            if (ColorDisplayService.m4017$$Nest$fgetmCurrentUser(this.this$0) != (-10000)) goto L6;
            return false;
        L6:
            if (Settings.Secure.getIntForUser(this.this$0.getContext().getContentResolver(), "night_display_activated", 0, ColorDisplayService.m4017$$Nest$fgetmCurrentUser(this.this$0)) == 1) goto L8;
            return false;
        L8:
            return true;
        }

        int getColorTemperatureSetting() {
            if (ColorDisplayService.m4017$$Nest$fgetmCurrentUser(this.this$0) != (-10000)) goto L6;
            return -1;
        L6:
            return clampNightDisplayColorTemperature(Settings.Secure.getIntForUser(this.this$0.getContext().getContentResolver(), "night_display_color_temperature", -1, ColorDisplayService.m4017$$Nest$fgetmCurrentUser(this.this$0)));
        }

        private int clampNightDisplayColorTemperature(int colorTemperature) {
            if (colorTemperature != (-1)) goto L6;
            int colorTemperature2 = this.this$0.getContext().getResources().getInteger(R.integer.config_ntpPollingInterval);
            colorTemperature = ColorDisplayService.m4020$$Nest$fgetmExt(this.this$0).getNightDisplayColorTemperatureDefault(colorTemperature2);
        L6:
            return ColorDisplayService.m4020$$Nest$fgetmExt(this.this$0).clampNightDisplayColorTemperature(colorTemperature);
        }
    }

    public interface ReduceBrightColorsListener {
        void onReduceBrightColorsActivationChanged(boolean r1, boolean r2);

        void onReduceBrightColorsStrengthChanged(int r1);
    }

    private final class TintHandler extends Handler {
        final /* synthetic */ ColorDisplayService this$0;

        /* synthetic */ TintHandler(ColorDisplayService r1, Looper r2, ColorDisplayServiceIA r3) {
            this(r1, r2);
        }

        private TintHandler(ColorDisplayService r2, Looper looper) {
            this.this$0 = r2;
            super(looper, null, true);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            switch(msg.what) {
                case 0: goto L11;
                case 1: goto L10;
                case 2: goto L9;
                case 3: goto L8;
                case 4: goto L7;
                case 5: goto L6;
                case 6: goto L5;
                default: goto L19;
            };
        L5:
            ColorDisplayService.m4031$$Nest$mapplyTint(this.this$0, ColorDisplayService.m4024$$Nest$fgetmReduceBrightColorsTintController(this.this$0), true);
            return;
        L6:
            ColorDisplayService.m4032$$Nest$mapplyTintByCct(this.this$0, this.this$0.mDisplayWhiteBalanceTintController, false);
            return;
        L7:
            ColorDisplayService.m4021$$Nest$fgetmGlobalSaturationTintController(this.this$0).setMatrix(msg.arg1);
            ColorDisplayService.m4031$$Nest$mapplyTint(this.this$0, ColorDisplayService.m4021$$Nest$fgetmGlobalSaturationTintController(this.this$0), false);
            return;
        L8:
            ColorDisplayService.m4031$$Nest$mapplyTint(this.this$0, ColorDisplayService.m4023$$Nest$fgetmNightDisplayTintController(this.this$0), false);
            return;
        L9:
            ColorDisplayService.m4031$$Nest$mapplyTint(this.this$0, ColorDisplayService.m4023$$Nest$fgetmNightDisplayTintController(this.this$0), true);
            return;
        L10:
            ColorDisplayService.m4059$$Nest$msetUp(this.this$0);
            return;
        L11:
            this.this$0.onUserChanged(msg.arg1);
            return;
        }
    }

    static class TintValueAnimator extends ValueAnimator {
        private float[] max;
        private float[] min;

        TintValueAnimator() {
        }

        public static TintValueAnimator ofMatrix(ColorMatrixEvaluator evaluator, Object... values) {
            TintValueAnimator anim = new TintValueAnimator();
            anim.setObjectValues(values);
            anim.setEvaluator(evaluator);
            if (values != null) goto L5;
            return null;
        L5:
            if (values.length == 0) goto L16;
            float[] m = (float[]) values[0];
            anim.min = new float[m.length];
            anim.max = new float[m.length];
            int i = 0;
        L9:
            if (i >= m.length) goto L12;
            anim.min[i] = Float.MAX_VALUE;
            anim.max[i] = Float.MIN_VALUE;
            i = i + 1;
            goto L9
        L12:
            return anim;
        L16:
            return null;
        }

        public void updateMinMaxComponents() {
            float[] value = (float[]) getAnimatedValue();
            if (value != null) goto L5;
            return;
        L5:
            int i = 0;
        L7:
            if (i >= value.length) goto L10;
            this.min[i] = Math.min(this.min[i], value[i]);
            this.max[i] = Math.max(this.max[i], value[i]);
            i = i + 1;
            goto L7
        }

        public float[] getMin() {
            return this.min;
        }

        public float[] getMax() {
            return this.max;
        }
    }

    private final class TwilightNightDisplayAutoMode extends NightDisplayAutoMode implements TwilightListener {
        private LocalDateTime mLastActivatedTime;
        private final TwilightManager mTwilightManager;
        final /* synthetic */ ColorDisplayService this$0;

        TwilightNightDisplayAutoMode(ColorDisplayService r2) {
            this.this$0 = r2;
            super(r2, null);
            this.mTwilightManager = (TwilightManager) ColorDisplayService.access$000(r2, TwilightManager.class);
        }

        private void updateActivated(TwilightState state) {
            if (state != null) goto L4;
            return;
        L4:
            boolean activate = state.isNight();
            if (this.mLastActivatedTime == null) goto L12;
            LocalDateTime now = LocalDateTime.now();
            LocalDateTime sunrise = state.sunrise();
            LocalDateTime sunset = state.sunset();
            if (this.mLastActivatedTime.isBefore(now) == false) goto L12;
            if ((this.mLastActivatedTime.isBefore(sunrise) ^ this.mLastActivatedTime.isBefore(sunset)) == false) goto L12;
            activate = ColorDisplayService.m4023$$Nest$fgetmNightDisplayTintController(this.this$0).isActivatedSetting();
        L12:
            if (ColorDisplayService.m4023$$Nest$fgetmNightDisplayTintController(this.this$0).isActivatedStateNotSet() == false) goto L14;
        L15:
            ColorDisplayService.m4023$$Nest$fgetmNightDisplayTintController(this.this$0).setActivated(Boolean.valueOf(activate));
            return;
        L14:
            if (ColorDisplayService.m4023$$Nest$fgetmNightDisplayTintController(this.this$0).isActivated() != activate) goto L15;
        }

        @Override // com.android.server.display.color.ColorDisplayService.NightDisplayAutoMode
        public void onActivated(boolean activated) {
            this.mLastActivatedTime = ColorDisplayService.m4040$$Nest$mgetNightDisplayLastActivatedTimeSetting(this.this$0);
        }

        @Override // com.android.server.display.color.ColorDisplayService.NightDisplayAutoMode
        public void onStart() {
            this.mTwilightManager.registerListener(this, this.this$0.mHandler);
            this.mLastActivatedTime = ColorDisplayService.m4040$$Nest$mgetNightDisplayLastActivatedTimeSetting(this.this$0);
            updateActivated(this.mTwilightManager.getLastTwilightState());
        }

        @Override // com.android.server.display.color.ColorDisplayService.NightDisplayAutoMode
        public void onStop() {
            this.mTwilightManager.unregisterListener(this);
            this.mLastActivatedTime = null;
        }

        @Override // com.android.server.twilight.TwilightListener
        public void onTwilightStateChanged(TwilightState state) {
            StringBuilder r0 = new StringBuilder();
            r0.append("onTwilightStateChanged: isNight=");
            if (state != null) goto L5;
            Boolean r1 = null;
        L6:
            r0.append(r1);
            r0.append(" state=");
            r0.append(state);
            Slog.d(ColorDisplayService.TAG, r0.toString());
            ColorDisplayService.m4029$$Nest$fputmTwilightState(this.this$0, state);
            updateActivated(state);
            return;
        L5:
            r1 = Boolean.valueOf(state.isNight());
            goto L6
        }
    }

    public static /* synthetic */ void $r8$lambda$HbHh6J1EbY9le7r1yQp5fMf2Tlg(DisplayTransformManager r0, TintController r1, ValueAnimator r2) {
        lambda$applyTint$0(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$m4YJh7bBq1EE5sh53YV516e7Uf8(ColorDisplayService r0, ColorTemperatureTintController r1, DisplayTransformManager r2, ValueAnimator r3) {
        r0.lambda$applyTintByCct$1(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAppSaturationController, reason: not valid java name */
    static /* bridge */ /* synthetic */ AppSaturationController m4014$$Nest$fgetmAppSaturationController(ColorDisplayService r0) {
        return r0.mAppSaturationController;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmBootCompleted, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m4015$$Nest$fgetmBootCompleted(ColorDisplayService r0) {
        return r0.mBootCompleted;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCctTintApplierLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m4016$$Nest$fgetmCctTintApplierLock(ColorDisplayService r0) {
        return r0.mCctTintApplierLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCurrentUser, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m4017$$Nest$fgetmCurrentUser(ColorDisplayService r0) {
        return r0.mCurrentUser;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmEvenDimmerActivated, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m4018$$Nest$fgetmEvenDimmerActivated(ColorDisplayService r0) {
        return r0.mEvenDimmerActivated;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmEvenDimmerSpline, reason: not valid java name */
    static /* bridge */ /* synthetic */ Spline m4019$$Nest$fgetmEvenDimmerSpline(ColorDisplayService r0) {
        return r0.mEvenDimmerSpline;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmExt, reason: not valid java name */
    static /* bridge */ /* synthetic */ IExtColorDisplayService m4020$$Nest$fgetmExt(ColorDisplayService r0) {
        return r0.mExt;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmGlobalSaturationTintController, reason: not valid java name */
    static /* bridge */ /* synthetic */ TintController m4021$$Nest$fgetmGlobalSaturationTintController(ColorDisplayService r0) {
        return r0.mGlobalSaturationTintController;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmNightDisplayAutoMode, reason: not valid java name */
    static /* bridge */ /* synthetic */ NightDisplayAutoMode m4022$$Nest$fgetmNightDisplayAutoMode(ColorDisplayService r0) {
        return r0.mNightDisplayAutoMode;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmNightDisplayTintController, reason: not valid java name */
    static /* bridge */ /* synthetic */ NightDisplayTintController m4023$$Nest$fgetmNightDisplayTintController(ColorDisplayService r0) {
        return r0.mNightDisplayTintController;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmReduceBrightColorsTintController, reason: not valid java name */
    static /* bridge */ /* synthetic */ ReduceBrightColorsTintController m4024$$Nest$fgetmReduceBrightColorsTintController(ColorDisplayService r0) {
        return r0.mReduceBrightColorsTintController;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmDisplayWhiteBalanceListener, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4025$$Nest$fputmDisplayWhiteBalanceListener(ColorDisplayService r0, DisplayWhiteBalanceListener r1) {
        r0.mDisplayWhiteBalanceListener = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmEvenDimmerActivated, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4026$$Nest$fputmEvenDimmerActivated(ColorDisplayService r0, boolean r1) {
        r0.mEvenDimmerActivated = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmEvenDimmerSpline, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4027$$Nest$fputmEvenDimmerSpline(ColorDisplayService r0, Spline r1) {
        r0.mEvenDimmerSpline = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmReduceBrightColorsListener, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4028$$Nest$fputmReduceBrightColorsListener(ColorDisplayService r0, ReduceBrightColorsListener r1) {
        r0.mReduceBrightColorsListener = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmTwilightState, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4029$$Nest$fputmTwilightState(ColorDisplayService r0, TwilightState r1) {
        r0.mTwilightState = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmUserSetupObserver, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4030$$Nest$fputmUserSetupObserver(ColorDisplayService r0, ContentObserver r1) {
        r0.mUserSetupObserver = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mapplyTint, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4031$$Nest$mapplyTint(ColorDisplayService r0, TintController r1, boolean r2) {
        r0.applyTint(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mapplyTintByCct, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4032$$Nest$mapplyTintByCct(ColorDisplayService r0, ColorTemperatureTintController r1, boolean r2) {
        r0.applyTintByCct(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mdumpInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4033$$Nest$mdumpInternal(ColorDisplayService r0, PrintWriter r1, String[] r2) {
        r0.dumpInternal(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$menforceValidCallingUser, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4034$$Nest$menforceValidCallingUser(ColorDisplayService r0, String r1) {
        r0.enforceValidCallingUser(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetColorModeInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m4035$$Nest$mgetColorModeInternal(ColorDisplayService r0) {
        return r0.getColorModeInternal();
    }

    /* JADX INFO: renamed from: -$$Nest$mgetNightDisplayAutoModeInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m4036$$Nest$mgetNightDisplayAutoModeInternal(ColorDisplayService r0) {
        return r0.getNightDisplayAutoModeInternal();
    }

    /* JADX INFO: renamed from: -$$Nest$mgetNightDisplayAutoModeRawInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m4037$$Nest$mgetNightDisplayAutoModeRawInternal(ColorDisplayService r0) {
        return r0.getNightDisplayAutoModeRawInternal();
    }

    /* JADX INFO: renamed from: -$$Nest$mgetNightDisplayCustomEndTimeInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ Time m4038$$Nest$mgetNightDisplayCustomEndTimeInternal(ColorDisplayService r0) {
        return r0.getNightDisplayCustomEndTimeInternal();
    }

    /* JADX INFO: renamed from: -$$Nest$mgetNightDisplayCustomStartTimeInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ Time m4039$$Nest$mgetNightDisplayCustomStartTimeInternal(ColorDisplayService r0) {
        return r0.getNightDisplayCustomStartTimeInternal();
    }

    /* JADX INFO: renamed from: -$$Nest$mgetNightDisplayLastActivatedTimeSetting, reason: not valid java name */
    static /* bridge */ /* synthetic */ LocalDateTime m4040$$Nest$mgetNightDisplayLastActivatedTimeSetting(ColorDisplayService r0) {
        return r0.getNightDisplayLastActivatedTimeSetting();
    }

    /* JADX INFO: renamed from: -$$Nest$mgetTransformCapabilitiesInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m4041$$Nest$mgetTransformCapabilitiesInternal(ColorDisplayService r0) {
        return r0.getTransformCapabilitiesInternal();
    }

    /* JADX INFO: renamed from: -$$Nest$misDeviceColorManagedInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m4042$$Nest$misDeviceColorManagedInternal(ColorDisplayService r0) {
        return r0.isDeviceColorManagedInternal();
    }

    /* JADX INFO: renamed from: -$$Nest$misDisplayWhiteBalanceSettingEnabled, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m4043$$Nest$misDisplayWhiteBalanceSettingEnabled(ColorDisplayService r0) {
        return r0.isDisplayWhiteBalanceSettingEnabled();
    }

    /* JADX INFO: renamed from: -$$Nest$monAccessibilityActivated, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4044$$Nest$monAccessibilityActivated(ColorDisplayService r0) {
        r0.onAccessibilityActivated();
    }

    /* JADX INFO: renamed from: -$$Nest$monAccessibilityDaltonizerChanged, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4045$$Nest$monAccessibilityDaltonizerChanged(ColorDisplayService r0) {
        r0.onAccessibilityDaltonizerChanged();
    }

    /* JADX INFO: renamed from: -$$Nest$monAccessibilityInversionChanged, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4046$$Nest$monAccessibilityInversionChanged(ColorDisplayService r0) {
        r0.onAccessibilityInversionChanged();
    }

    /* JADX INFO: renamed from: -$$Nest$monNightDisplayAutoModeChanged, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4047$$Nest$monNightDisplayAutoModeChanged(ColorDisplayService r0, int r1) {
        r0.onNightDisplayAutoModeChanged(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$monNightDisplayCustomEndTimeChanged, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4048$$Nest$monNightDisplayCustomEndTimeChanged(ColorDisplayService r0, LocalTime r1) {
        r0.onNightDisplayCustomEndTimeChanged(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$monNightDisplayCustomStartTimeChanged, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4049$$Nest$monNightDisplayCustomStartTimeChanged(ColorDisplayService r0, LocalTime r1) {
        r0.onNightDisplayCustomStartTimeChanged(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$monReduceBrightColorsActivationChanged, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4050$$Nest$monReduceBrightColorsActivationChanged(ColorDisplayService r0, boolean r1) {
        r0.onReduceBrightColorsActivationChanged(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$monReduceBrightColorsStrengthLevelChanged, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4051$$Nest$monReduceBrightColorsStrengthLevelChanged(ColorDisplayService r0) {
        r0.onReduceBrightColorsStrengthLevelChanged();
    }

    /* JADX INFO: renamed from: -$$Nest$msetColorModeInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4052$$Nest$msetColorModeInternal(ColorDisplayService r0, int r1) {
        r0.setColorModeInternal(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$msetDisplayWhiteBalanceSettingEnabled, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m4053$$Nest$msetDisplayWhiteBalanceSettingEnabled(ColorDisplayService r0, boolean r1) {
        return r0.setDisplayWhiteBalanceSettingEnabled(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$msetNightDisplayAutoModeInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m4054$$Nest$msetNightDisplayAutoModeInternal(ColorDisplayService r0, int r1) {
        return r0.setNightDisplayAutoModeInternal(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$msetNightDisplayCustomEndTimeInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m4055$$Nest$msetNightDisplayCustomEndTimeInternal(ColorDisplayService r0, Time r1) {
        return r0.setNightDisplayCustomEndTimeInternal(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$msetNightDisplayCustomStartTimeInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m4056$$Nest$msetNightDisplayCustomStartTimeInternal(ColorDisplayService r0, Time r1) {
        return r0.setNightDisplayCustomStartTimeInternal(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$msetReduceBrightColorsActivatedInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m4057$$Nest$msetReduceBrightColorsActivatedInternal(ColorDisplayService r0, boolean r1) {
        return r0.setReduceBrightColorsActivatedInternal(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$msetReduceBrightColorsStrengthInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m4058$$Nest$msetReduceBrightColorsStrengthInternal(ColorDisplayService r0, int r1) {
        return r0.setReduceBrightColorsStrengthInternal(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$msetUp, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4059$$Nest$msetUp(ColorDisplayService r0) {
        r0.setUp();
    }

    /* JADX INFO: renamed from: -$$Nest$smisUserSetupCompleted, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m4060$$Nest$smisUserSetupCompleted(ContentResolver r0, int r1) {
        return isUserSetupCompleted(r0, r1);
    }

    static /* synthetic */ Object access$000(ColorDisplayService x0, Class x1) {
        return x0.getLocalService(x1);
    }

    static {
        MATRIX_IDENTITY = new float[16];
        Matrix.setIdentityM(MATRIX_IDENTITY, 0);
        COLOR_MATRIX_EVALUATOR = new ColorMatrixEvaluator(null);
        MATRIX_GRAYSCALE = new float[]{0.2126f, 0.2126f, 0.2126f, 0.0f, 0.7152f, 0.7152f, 0.7152f, 0.0f, 0.0722f, 0.0722f, 0.0722f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
        MATRIX_INVERT_COLOR = new float[]{0.402f, -0.598f, -0.599f, 0.0f, -1.174f, -0.174f, -1.175f, 0.0f, -0.228f, -0.228f, 0.772f, 0.0f, 1.0f, 1.0f, 1.0f, 1.0f};
    }

    public ColorDisplayService(Context context) {
        this(context, new ReduceBrightColorsTintController());
    }

    public ColorDisplayService(Context context, ReduceBrightColorsTintController rbcController) {
        super(context);
        this.mDisplayManagerFlags = new DisplayManagerFlags();
        this.mDisplayWhiteBalanceTintController = new DisplayWhiteBalanceTintController((DisplayManagerInternal) LocalServices.getService(DisplayManagerInternal.class), this.mDisplayManagerFlags);
        ColorDisplayServiceIA r1 = null;
        this.mNightDisplayTintController = new NightDisplayTintController(this, r1);
        this.mGlobalSaturationTintController = new GlobalSaturationTintController();
        this.mAppSaturationController = new AppSaturationController();
        this.mCurrentUser = ProcessList.INVALID_ADJ;
        this.mColorModeCompositionColorSpaces = null;
        this.mCctTintApplierLock = new Object();
        this.mExt = (IExtColorDisplayService) ExtImplFactory.getImpl(IExtColorDisplayService.class, new Object[]{this});
        this.mReduceBrightColorsTintController = rbcController;
        this.mHandler = new TintHandler(this, DisplayThread.get().getLooper(), r1);
        this.mVisibleBackgroundUsersEnabled = UserManager.isVisibleBackgroundUsersEnabled();
        this.mUserManager = UserManagerService.getInstance();
        this.mExt.init(context);
    }

    @Override // com.android.server.SystemService
    public void onStart() {
        publishBinderService("color_display", new BinderService(this));
        publishLocalService(ColorDisplayServiceInternal.class, new ColorDisplayServiceInternal(this));
        publishLocalService(DisplayTransformManager.class, new DisplayTransformManager());
    }

    @Override // com.android.server.SystemService
    public void onBootPhase(int phase) {
        if (phase < 1000) goto L9;
        this.mBootCompleted = true;
        if (this.mCurrentUser == (-10000)) goto L9;
        if (this.mUserSetupObserver != null) goto L9;
        this.mHandler.sendEmptyMessage(1);
    L9:
        this.mExt.onBootPhase(phase);
    }

    @Override // com.android.server.SystemService
    public void onUserStarting(SystemService.TargetUser user) {
        if (this.mCurrentUser != (-10000)) goto L6;
        Message message = this.mHandler.obtainMessage(0);
        message.arg1 = user.getUserIdentifier();
        this.mHandler.sendMessage(message);
        return;
    }

    @Override // com.android.server.SystemService
    public void onUserSwitching(SystemService.TargetUser from, SystemService.TargetUser to) {
        Message message = this.mHandler.obtainMessage(0);
        message.arg1 = to.getUserIdentifier();
        this.mHandler.sendMessage(message);
    }

    @Override // com.android.server.SystemService
    public void onUserStopping(SystemService.TargetUser user) {
        if (this.mCurrentUser != user.getUserIdentifier()) goto L6;
        Message message = this.mHandler.obtainMessage(0);
        message.arg1 = ProcessList.INVALID_ADJ;
        this.mHandler.sendMessage(message);
        return;
    }

    void onUserChanged(int userHandle) {
        final ContentResolver cr = getContext().getContentResolver();
        if (this.mCurrentUser != (-10000)) goto L5;
    L10:
        this.mCurrentUser = userHandle;
        this.mExt.onUserChanged(this.mCurrentUser);
        if (this.mCurrentUser != (-10000)) goto L13;
        return;
    L13:
        if (isUserSetupCompleted(cr, this.mCurrentUser) == true) goto L16;
        final Handler r2 = this.mHandler;
        this.mUserSetupObserver = new AnonymousClass1(this, r2, cr);
        cr.registerContentObserver(Settings.Secure.getUriFor("user_setup_complete"), false, this.mUserSetupObserver, this.mCurrentUser);
        return;
    L16:
        if (this.mBootCompleted == false) goto L21;
        setUp();
        return;
    L21:
        return;
    L5:
        if (this.mUserSetupObserver == null) goto L8;
        cr.unregisterContentObserver(this.mUserSetupObserver);
        this.mUserSetupObserver = null;
        goto L10
    L8:
        if (this.mBootCompleted == false) goto L10;
        tearDown();
        goto L10
    }

    private static boolean isUserSetupCompleted(ContentResolver cr, int userHandle) {
        if (Settings.Secure.getIntForUser(cr, "user_setup_complete", 0, userHandle) == 1) goto L5;
        return false;
    L5:
        return true;
    }

    private void setUpDisplayCompositionColorSpaces(Resources res) {
        this.mColorModeCompositionColorSpaces = null;
        int[] colorModes = res.getIntArray(R.array.config_displayWhiteBalanceHighLightAmbientBrightnessesStrong);
        if (colorModes != null) goto L5;
        return;
    L5:
        int[] compSpaces = res.getIntArray(R.array.config_displayWhiteBalanceIncreaseThresholds);
        if (compSpaces != null) goto L9;
        return;
    L9:
        if (colorModes.length == compSpaces.length) goto L12;
        Slog.e(TAG, "Number of composition color spaces doesn't match specified color modes");
        return;
    L12:
        this.mColorModeCompositionColorSpaces = new SparseIntArray(colorModes.length);
        int i = 0;
    L14:
        if (i >= colorModes.length) goto L17;
        this.mColorModeCompositionColorSpaces.put(colorModes[i], compSpaces[i]);
        i = i + 1;
        goto L14
    }

    private void setUp() {
        Slog.d(TAG, "setUp: currentUser=" + this.mCurrentUser);
        if (this.mContentObserver != null) goto L5;
        final Handler r1 = this.mHandler;
        this.mContentObserver = new AnonymousClass2(this, r1);
    L5:
        ContentResolver cr = getContext().getContentResolver();
        cr.registerContentObserver(Settings.Secure.getUriFor("night_display_activated"), false, this.mContentObserver, this.mCurrentUser);
        cr.registerContentObserver(Settings.Secure.getUriFor("night_display_color_temperature"), false, this.mContentObserver, this.mCurrentUser);
        cr.registerContentObserver(Settings.Secure.getUriFor("night_display_auto_mode"), false, this.mContentObserver, this.mCurrentUser);
        cr.registerContentObserver(Settings.Secure.getUriFor("night_display_custom_start_time"), false, this.mContentObserver, this.mCurrentUser);
        cr.registerContentObserver(Settings.Secure.getUriFor("night_display_custom_end_time"), false, this.mContentObserver, this.mCurrentUser);
        cr.registerContentObserver(Settings.System.getUriFor("display_color_mode"), false, this.mContentObserver, this.mCurrentUser);
        cr.registerContentObserver(Settings.Secure.getUriFor("accessibility_display_inversion_enabled"), false, this.mContentObserver, this.mCurrentUser);
        cr.registerContentObserver(Settings.Secure.getUriFor("accessibility_display_daltonizer_enabled"), false, this.mContentObserver, this.mCurrentUser);
        cr.registerContentObserver(Settings.Secure.getUriFor("accessibility_display_daltonizer"), false, this.mContentObserver, this.mCurrentUser);
        cr.registerContentObserver(Settings.Secure.getUriFor("display_white_balance_enabled"), false, this.mContentObserver, this.mCurrentUser);
        cr.registerContentObserver(Settings.Secure.getUriFor("reduce_bright_colors_activated"), false, this.mContentObserver, this.mCurrentUser);
        cr.registerContentObserver(Settings.Secure.getUriFor("reduce_bright_colors_level"), false, this.mContentObserver, this.mCurrentUser);
        cr.registerContentObserver(Settings.Secure.getUriFor("accessibility_display_daltonizer_saturation_level"), false, this.mContentObserver, this.mCurrentUser);
        onAccessibilityInversionChanged();
        onAccessibilityDaltonizerChanged();
        setUpDisplayCompositionColorSpaces(getContext().getResources());
        onDisplayColorModeChanged(getColorModeInternal());
        DisplayTransformManager dtm = (DisplayTransformManager) getLocalService(DisplayTransformManager.class);
        if (this.mNightDisplayTintController.isAvailable(getContext()) == false) goto L11;
        this.mNightDisplayTintController.setActivated(null);
        this.mNightDisplayTintController.setUp(getContext(), dtm.needsLinearColorMatrix());
        this.mNightDisplayTintController.setMatrix(this.mNightDisplayTintController.getColorTemperatureSetting());
        onNightDisplayAutoModeChanged(getNightDisplayAutoModeInternal());
        if (this.mNightDisplayTintController.isActivatedStateNotSet() == false) goto L11;
        this.mNightDisplayTintController.setActivated(Boolean.valueOf(this.mNightDisplayTintController.isActivatedSetting()));
    L11:
        if (this.mDisplayWhiteBalanceTintController.isAvailable(getContext()) == false) goto L14;
        this.mDisplayWhiteBalanceTintController.setUp(getContext(), true);
        updateDisplayWhiteBalanceStatus();
    L14:
        if (this.mReduceBrightColorsTintController.isAvailable(getContext()) == false) goto L19;
        this.mReduceBrightColorsTintController.setUp(getContext(), dtm.needsLinearColorMatrix());
        onReduceBrightColorsStrengthLevelChanged();
        boolean reset = resetReduceBrightColors();
        if (reset == true) goto L20;
        onReduceBrightColorsActivationChanged(false);
        this.mHandler.sendEmptyMessage(6);
        return;
    L20:
        return;
    }

    private void tearDown() {
        Slog.d(TAG, "tearDown: currentUser=" + this.mCurrentUser);
        if (this.mContentObserver == null) goto L6;
        getContext().getContentResolver().unregisterContentObserver(this.mContentObserver);
    L6:
        if (this.mNightDisplayTintController.isAvailable(getContext()) == false) goto L12;
        if (this.mNightDisplayAutoMode == null) goto L10;
        this.mNightDisplayAutoMode.onStop();
        this.mNightDisplayAutoMode = null;
    L10:
        this.mNightDisplayTintController.endAnimator();
    L12:
        if (this.mDisplayWhiteBalanceTintController.isAvailable(getContext()) == false) goto L15;
        this.mDisplayWhiteBalanceTintController.endAnimator();
    L15:
        if (this.mGlobalSaturationTintController.isAvailable(getContext()) == false) goto L18;
        this.mGlobalSaturationTintController.setActivated(null);
    L18:
        if (this.mReduceBrightColorsTintController.isAvailable(getContext()) == false) goto L21;
        this.mReduceBrightColorsTintController.setActivated(null);
        return;
    }

    void cancelAllAnimators() {
        this.mNightDisplayTintController.cancelAnimator();
        this.mGlobalSaturationTintController.cancelAnimator();
        this.mReduceBrightColorsTintController.cancelAnimator();
        this.mDisplayWhiteBalanceTintController.cancelAnimator();
    }

    private boolean resetReduceBrightColors() {
        if (this.mCurrentUser != (-10000)) goto L5;
        return false;
    L5:
        boolean shouldResetOnReboot = true;
        if (Settings.Secure.getIntForUser(getContext().getContentResolver(), "reduce_bright_colors_activated", 0, this.mCurrentUser) != 1) goto L8;
        boolean isSettingActivated = true;
    L10:
        if (Settings.Secure.getIntForUser(getContext().getContentResolver(), "reduce_bright_colors_persist_across_reboots", 0, this.mCurrentUser) == 0) goto L13;
        shouldResetOnReboot = false;
    L13:
        if (isSettingActivated == true) goto L15;
    L19:
        return false;
    L15:
        if (this.mReduceBrightColorsTintController.isActivatedStateNotSet() == false) goto L19;
        if (shouldResetOnReboot == false) goto L19;
        return Settings.Secure.putIntForUser(getContext().getContentResolver(), "reduce_bright_colors_activated", 0, this.mCurrentUser);
    L8:
        isSettingActivated = false;
        goto L10
    }

    private void onNightDisplayAutoModeChanged(int autoMode) {
        Slog.d(TAG, "onNightDisplayAutoModeChanged: autoMode=" + autoMode);
        this.mNightDisplayMode = autoMode;
        if (this.mNightDisplayAutoMode == null) goto L6;
        this.mNightDisplayAutoMode.onStop();
        this.mNightDisplayAutoMode = null;
    L6:
        if (autoMode != 1) goto L9;
        this.mNightDisplayAutoMode = new CustomNightDisplayAutoMode(this);
    L12:
        if (this.mNightDisplayAutoMode == null) goto L15;
        this.mNightDisplayAutoMode.onStart();
        return;
    L15:
        return;
    L9:
        if (autoMode != 2) goto L12;
        this.mNightDisplayAutoMode = new TwilightNightDisplayAutoMode(this);
        goto L12
    }

    private void onNightDisplayCustomStartTimeChanged(LocalTime startTime) {
        Slog.d(TAG, "onNightDisplayCustomStartTimeChanged: startTime=" + startTime);
        if (this.mNightDisplayAutoMode == null) goto L6;
        this.mNightDisplayAutoMode.onCustomStartTimeChanged(startTime);
        return;
    }

    private void onNightDisplayCustomEndTimeChanged(LocalTime endTime) {
        Slog.d(TAG, "onNightDisplayCustomEndTimeChanged: endTime=" + endTime);
        if (this.mNightDisplayAutoMode == null) goto L6;
        this.mNightDisplayAutoMode.onCustomEndTimeChanged(endTime);
        return;
    }

    private int getCompositionColorSpace(int mode) {
        if (this.mColorModeCompositionColorSpaces != null) goto L6;
        return -1;
    L6:
        return this.mColorModeCompositionColorSpaces.get(mode, -1);
    }

    void onDisplayColorModeChanged(int mode) {
        if (mode != (-1)) goto L5;
        return;
    L5:
        this.mReduceBrightColorsTintController.cancelAnimator();
        this.mNightDisplayTintController.cancelAnimator();
        this.mDisplayWhiteBalanceTintController.cancelAnimator();
        DisplayTransformManager dtm = (DisplayTransformManager) getLocalService(DisplayTransformManager.class);
        if (this.mNightDisplayTintController.isAvailable(getContext()) == false) goto L9;
        this.mNightDisplayTintController.setUp(getContext(), dtm.needsLinearColorMatrix(mode));
        this.mNightDisplayTintController.setMatrix(this.mNightDisplayTintController.getColorTemperatureSetting());
    L9:
        if (this.mReduceBrightColorsTintController.isAvailable(getContext()) == false) goto L11;
        this.mReduceBrightColorsTintController.setUp(getContext(), dtm.needsLinearColorMatrix(mode));
        onReduceBrightColorsStrengthLevelChanged();
    L11:
        dtm.setColorMode(mode, this.mNightDisplayTintController.getMatrix(), this.mReduceBrightColorsTintController.getMatrix(), getCompositionColorSpace(mode));
        if (this.mDisplayWhiteBalanceTintController.isAvailable(getContext()) == false) goto L15;
        updateDisplayWhiteBalanceStatus();
        return;
    }

    private void onAccessibilityActivated() {
        onDisplayColorModeChanged(getColorModeInternal());
    }

    private boolean isAccessiblityDaltonizerEnabled() {
        if (Settings.Secure.getIntForUser(getContext().getContentResolver(), "accessibility_display_daltonizer_enabled", 0, this.mCurrentUser) == 0) goto L6;
        return true;
    L6:
        return false;
    }

    private boolean isAccessiblityInversionEnabled() {
        if (Settings.Secure.getIntForUser(getContext().getContentResolver(), "accessibility_display_inversion_enabled", 0, this.mCurrentUser) == 0) goto L6;
        return true;
    L6:
        return false;
    }

    private boolean isAccessibilityEnabled() {
        if (isAccessiblityDaltonizerEnabled() == false) goto L5;
    L8:
        return true;
    L5:
        if (isAccessiblityInversionEnabled() == true) goto L8;
        return false;
    }

    private void onAccessibilityDaltonizerChanged() {
        if (this.mCurrentUser != (-10000)) goto L5;
        return;
    L5:
        ContentResolver contentResolver = getContext().getContentResolver();
        if (isAccessiblityDaltonizerEnabled() == false) goto L8;
        int daltonizerMode = Settings.Secure.getIntForUser(contentResolver, "accessibility_display_daltonizer", 12, this.mCurrentUser);
    L9:
        int saturation = Settings.Secure.getIntForUser(contentResolver, "accessibility_display_daltonizer_saturation_level", -1, this.mCurrentUser);
        DisplayTransformManager dtm = (DisplayTransformManager) getLocalService(DisplayTransformManager.class);
        if (daltonizerMode != 0) goto L12;
        dtm.setColorMatrix(200, MATRIX_GRAYSCALE);
        dtm.setDaltonizerMode(-1, saturation);
        return;
    L12:
        dtm.setColorMatrix(200, null);
        dtm.setDaltonizerMode(daltonizerMode, saturation);
        return;
    L8:
        daltonizerMode = -1;
        goto L9
    }

    private void onAccessibilityInversionChanged() {
        if (this.mCurrentUser != (-10000)) goto L5;
        return;
    L5:
        DisplayTransformManager dtm = (DisplayTransformManager) getLocalService(DisplayTransformManager.class);
        if (isAccessiblityInversionEnabled() == false) goto L8;
        float[] r1 = MATRIX_INVERT_COLOR;
    L9:
        dtm.setColorMatrix(300, r1);
        return;
    L8:
        r1 = null;
        goto L9
    }

    private void onReduceBrightColorsActivationChanged(boolean userInitiated) {
        if (this.mCurrentUser != (-10000)) goto L5;
        return;
    L5:
        boolean activated = false;
        if (Settings.Secure.getIntForUser(getContext().getContentResolver(), "reduce_bright_colors_activated", 0, this.mCurrentUser) != 1) goto L8;
        activated = true;
    L8:
        this.mReduceBrightColorsTintController.setActivated(Boolean.valueOf(activated));
        if (this.mReduceBrightColorsListener == null) goto L12;
        this.mReduceBrightColorsListener.onReduceBrightColorsActivationChanged(activated, userInitiated);
        return;
    }

    private void onReduceBrightColorsStrengthLevelChanged() {
        if (this.mCurrentUser != (-10000)) goto L5;
        return;
    L5:
        int percentage = Settings.Secure.getIntForUser(getContext().getContentResolver(), "reduce_bright_colors_level", -1, this.mCurrentUser);
        if (percentage != (-1)) goto L8;
        int deviceMin = getContext().getResources().getInteger(R.integer.config_satellite_nb_iot_inactivity_timeout_millis);
    L9:
        this.mReduceBrightColorsTintController.setMatrix(deviceMin);
        if (this.mReduceBrightColorsListener == null) goto L13;
        this.mReduceBrightColorsListener.onReduceBrightColorsStrengthChanged(deviceMin);
        return;
    L13:
        return;
    L8:
        int deviceMin2 = getContext().getResources().getInteger(R.integer.config_satellite_stay_at_listening_from_sending_millis);
        int deviceMax = getContext().getResources().getInteger(R.integer.config_satellite_stay_at_listening_from_receiving_millis);
        deviceMin = (int) MathUtils.constrainedMap(deviceMin2, deviceMax, 0.0f, 100.0f, percentage);
        goto L9
    }

    private void applyTint(final TintController tintController, boolean immediate) {
        tintController.cancelAnimator();
        final DisplayTransformManager dtm = (DisplayTransformManager) getLocalService(DisplayTransformManager.class);
        float[] from = dtm.getColorMatrix(tintController.getLevel());
        final float[] to = tintController.getMatrix();
        this.mExt.applyTint(tintController, immediate, from, to);
        if (immediate == false) goto L5;
        dtm.setColorMatrix(tintController.getLevel(), to);
        return;
    L5:
        ColorMatrixEvaluator r3 = COLOR_MATRIX_EVALUATOR;
        if (from != null) goto L8;
        float[] r4 = MATRIX_IDENTITY;
    L9:
        TintValueAnimator valueAnimator = TintValueAnimator.ofMatrix(r3, new Object[]{r4, to});
        tintController.setAnimator(valueAnimator);
        valueAnimator.setDuration(tintController.getTransitionDurationMilliseconds());
        valueAnimator.setInterpolator(AnimationUtils.loadInterpolator(getContext(), R.interpolator.fast_out_slow_in));
        valueAnimator.addUpdateListener(new ColorDisplayService$$ExternalSyntheticLambda1(dtm, tintController));
        valueAnimator.addListener(new AnonymousClass3(this, tintController, to, dtm));
        valueAnimator.start();
        return;
    L8:
        r4 = from;
        goto L9
    }

    private static /* synthetic */ void lambda$applyTint$0(DisplayTransformManager dtm, TintController tintController, ValueAnimator animator) {
        float[] value = (float[]) animator.getAnimatedValue();
        dtm.setColorMatrix(tintController.getLevel(), value);
        ((TintValueAnimator) animator).updateMinMaxComponents();
    }

    private void applyTintByCct(final ColorTemperatureTintController tintController, boolean immediate) {
        Object r1 = this.mCctTintApplierLock;
        monitor-enter(r1);
        tintController.cancelAnimator();     // Catch: Throwable -> L30
        final DisplayTransformManager dtm = (DisplayTransformManager) getLocalService(DisplayTransformManager.class);     // Catch: Throwable -> L30
        final int from = tintController.getAppliedCct();     // Catch: Throwable -> L30
        if (tintController.isActivated() == false) goto L11;
    L8:
        th = th;
    L32:
        monitor-exit(r1);     // Catch: Throwable -> L28
        throw th;
    L7:
        final int to = tintController.getTargetCct();     // Catch: Throwable -> L8
    L13:
        if (immediate == false) goto L16;
        Slog.d(TAG, tintController.getClass().getSimpleName() + " applied immediately: toCct=" + to + " fromCct=" + from);     // Catch: Throwable -> L8
        dtm.setColorMatrix(tintController.getLevel(), tintController.computeMatrixForCct(to));     // Catch: Throwable -> L8
        tintController.setAppliedCct(to);     // Catch: Throwable -> L8
    L26:
        monitor-exit(r1);     // Catch: Throwable -> L28
        return;
    L16:
        if (to <= from) goto L18;
        boolean r0 = true;
    L19:
        long duration = tintController.getTransitionDurationMilliseconds(r0);     // Catch: Throwable -> L30
        Slog.d(TAG, tintController.getClass().getSimpleName() + " animation started: toCct=" + to + " fromCct=" + from + " with duration=" + duration);     // Catch: Throwable -> L30
        ValueAnimator valueAnimator = ValueAnimator.ofInt(new int[]{from, to});     // Catch: Throwable -> L30
        tintController.setAnimator(valueAnimator);     // Catch: Throwable -> L30
        CctEvaluator evaluator = tintController.getEvaluator();     // Catch: Throwable -> L30
        if (evaluator == null) goto L23;
        valueAnimator.setEvaluator(evaluator);     // Catch: Throwable -> L8
    L23:
        valueAnimator.setDuration(duration);     // Catch: Throwable -> L30
        valueAnimator.setInterpolator(AnimationUtils.loadInterpolator(getContext(), R.interpolator.linear));     // Catch: Throwable -> L30
        valueAnimator.addUpdateListener(new ColorDisplayService$$ExternalSyntheticLambda0(this, tintController, dtm));     // Catch: Throwable -> L30
        valueAnimator.addListener(new AnonymousClass4(this, tintController, to, from, dtm));     // Catch: Throwable -> L28
        valueAnimator.start();     // Catch: Throwable -> L28
        goto L26
    L18:
        r0 = false;
        goto L19
    L11:
        to = tintController.getDisabledCct();     // Catch: Throwable -> L30
    L30:
        th = th;
    L28:
        th = th;
        goto L32
    }

    private /* synthetic */ void lambda$applyTintByCct$1(ColorTemperatureTintController tintController, DisplayTransformManager dtm, ValueAnimator animator) {
        Object r0 = this.mCctTintApplierLock;
        monitor-enter(r0);
        int value = ((Integer) animator.getAnimatedValue()).intValue();     // Catch: Throwable -> L7
        if (value == tintController.getAppliedCct()) goto L9;
        dtm.setColorMatrix(tintController.getLevel(), tintController.computeMatrixForCct(value));     // Catch: Throwable -> L7
        tintController.setAppliedCct(value);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    static LocalDateTime getDateTimeBefore(LocalTime localTime, LocalDateTime compareTime) {
        LocalDateTime ldt = LocalDateTime.of(compareTime.getYear(), compareTime.getMonth(), compareTime.getDayOfMonth(), localTime.getHour(), localTime.getMinute());
        if (ldt.isAfter(compareTime) == false) goto L6;
        return ldt.minusDays(1);
    L6:
        return ldt;
    }

    static LocalDateTime getDateTimeAfter(LocalTime localTime, LocalDateTime compareTime) {
        LocalDateTime ldt = LocalDateTime.of(compareTime.getYear(), compareTime.getMonth(), compareTime.getDayOfMonth(), localTime.getHour(), localTime.getMinute());
        if (ldt.isBefore(compareTime) == false) goto L6;
        return ldt.plusDays(1);
    L6:
        return ldt;
    }

    void updateDisplayWhiteBalanceStatus() {
        boolean oldActivated = this.mDisplayWhiteBalanceTintController.isActivated();
        DisplayTransformManager dtm = (DisplayTransformManager) getLocalService(DisplayTransformManager.class);
        DisplayWhiteBalanceTintController r2 = this.mDisplayWhiteBalanceTintController;
        if (isDisplayWhiteBalanceSettingEnabled() == true) goto L5;
    L13:
        boolean r3 = false;
    L14:
        r2.setActivated(Boolean.valueOf(r3));
        boolean activated = this.mDisplayWhiteBalanceTintController.isActivated();
        if (this.mDisplayWhiteBalanceListener == null) goto L18;
        if (oldActivated == activated) goto L18;
        this.mDisplayWhiteBalanceListener.onDisplayWhiteBalanceStatusChanged(activated);
    L18:
        if (oldActivated == false) goto L22;
        if (activated == true) goto L23;
        this.mHandler.sendEmptyMessage(5);
        return;
    L23:
        return;
    L22:
        return;
    L5:
        if (this.mNightDisplayTintController.isActivated() == true) goto L13;
        if (isAccessibilityEnabled() == true) goto L13;
        if (dtm.needsLinearColorMatrix() == false) goto L13;
        if (this.mDisplayWhiteBalanceTintController.isAllowed() == false) goto L13;
        r3 = true;
        goto L14
    }

    private boolean setDisplayWhiteBalanceSettingEnabled(boolean r4) {
        if (this.mCurrentUser != (-10000)) goto L6;
        return false;
    L6:
        ContentResolver r0 = getContext().getContentResolver();
        int r1 = this.mCurrentUser;
        return Settings.Secure.putIntForUser(r0, "display_white_balance_enabled", r4 ? 1 : 0, r1);
    }

    private boolean isDisplayWhiteBalanceSettingEnabled() {
        if (this.mCurrentUser != (-10000)) goto L5;
        return false;
    L5:
        ContentResolver r0 = getContext().getContentResolver();
        if (getContext().getResources().getBoolean(R.bool.config_dockedStackDividerFreeSnapMode) == false) goto L8;
        int r1 = 1;
    L10:
        if (Settings.Secure.getIntForUser(r0, "display_white_balance_enabled", r1, this.mCurrentUser) == 1) goto L12;
        return false;
    L12:
        return true;
    L8:
        r1 = 0;
        goto L10
    }

    private boolean setReduceBrightColorsActivatedInternal(boolean r4) {
        if (this.mCurrentUser != (-10000)) goto L6;
        return false;
    L6:
        ContentResolver r0 = getContext().getContentResolver();
        int r1 = this.mCurrentUser;
        return Settings.Secure.putIntForUser(r0, "reduce_bright_colors_activated", r4 ? 1 : 0, r1);
    }

    private boolean setReduceBrightColorsStrengthInternal(int strength) {
        if (this.mCurrentUser != (-10000)) goto L7;
        return false;
    L7:
        return Settings.Secure.putIntForUser(getContext().getContentResolver(), "reduce_bright_colors_level", strength, this.mCurrentUser);
    }

    private boolean isDeviceColorManagedInternal() {
        DisplayTransformManager dtm = (DisplayTransformManager) getLocalService(DisplayTransformManager.class);
        return dtm.isDeviceColorManaged();
    }

    private int getTransformCapabilitiesInternal() {
        int availabilityFlags = 0;
        if (SurfaceControl.getProtectedContentSupport() == false) goto L5;
        availabilityFlags = 0 | 1;
    L5:
        Resources res = getContext().getResources();
        if (res.getBoolean(R.bool.config_showMenuShortcutsWhenKeyboardPresent) == false) goto L9;
        availabilityFlags = availabilityFlags | 2;
    L9:
        if (res.getBoolean(R.bool.config_showNavigationBar) == true) goto L11;
        return availabilityFlags;
    L11:
        return availabilityFlags | 4;
    }

    private boolean setNightDisplayAutoModeInternal(int autoMode) {
        if (getNightDisplayAutoModeInternal() == autoMode) goto L6;
        Settings.Secure.putStringForUser(getContext().getContentResolver(), "night_display_last_activated_time", null, this.mCurrentUser);
    L6:
        return Settings.Secure.putIntForUser(getContext().getContentResolver(), "night_display_auto_mode", autoMode, this.mCurrentUser);
    }

    private int getNightDisplayAutoModeInternal() {
        int autoMode = getNightDisplayAutoModeRawInternal();
        if (autoMode != (-1)) goto L5;
        autoMode = getContext().getResources().getInteger(R.integer.config_defaultRefreshRateInHbmHdr);
    L5:
        if (autoMode != 0) goto L7;
        return autoMode;
    L7:
        if (autoMode != 1) goto L9;
        return autoMode;
    L9:
        if (autoMode == 2) goto L14;
        Slog.e(TAG, "Invalid autoMode: " + autoMode);
        return 0;
    L14:
        return autoMode;
    }

    private int getNightDisplayAutoModeRawInternal() {
        if (this.mCurrentUser != (-10000)) goto L6;
        return -1;
    L6:
        return Settings.Secure.getIntForUser(getContext().getContentResolver(), "night_display_auto_mode", -1, this.mCurrentUser);
    }

    private Time getNightDisplayCustomStartTimeInternal() {
        int startTimeValue = Settings.Secure.getIntForUser(getContext().getContentResolver(), "night_display_custom_start_time", -1, this.mCurrentUser);
        if (startTimeValue != (-1)) goto L6;
        startTimeValue = getContext().getResources().getInteger(R.integer.config_defaultRefreshRateInZone);
    L6:
        return new Time(LocalTime.ofSecondOfDay(startTimeValue / 1000));
    }

    private boolean setNightDisplayCustomStartTimeInternal(Time startTime) {
        return Settings.Secure.putIntForUser(getContext().getContentResolver(), "night_display_custom_start_time", startTime.getLocalTime().toSecondOfDay() * 1000, this.mCurrentUser);
    }

    private Time getNightDisplayCustomEndTimeInternal() {
        int endTimeValue = Settings.Secure.getIntForUser(getContext().getContentResolver(), "night_display_custom_end_time", -1, this.mCurrentUser);
        if (endTimeValue != (-1)) goto L6;
        endTimeValue = getContext().getResources().getInteger(R.integer.config_defaultRefreshRateInHbmSunlight);
    L6:
        return new Time(LocalTime.ofSecondOfDay(endTimeValue / 1000));
    }

    private boolean setNightDisplayCustomEndTimeInternal(Time endTime) {
        return Settings.Secure.putIntForUser(getContext().getContentResolver(), "night_display_custom_end_time", endTime.getLocalTime().toSecondOfDay() * 1000, this.mCurrentUser);
    }

    private LocalDateTime getNightDisplayLastActivatedTimeSetting() {
        ContentResolver cr = getContext().getContentResolver();
        String lastActivatedTime = Settings.Secure.getStringForUser(cr, "night_display_last_activated_time", getContext().getUserId());
        if (lastActivatedTime == null) goto L11;
        return LocalDateTime.parse(lastActivatedTime);
    L12:
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(Long.parseLong(lastActivatedTime)), ZoneId.systemDefault());
    L11:
        return LocalDateTime.MIN;
    }

    void setSaturationLevelInternal(int saturationLevel) {
        Message message = this.mHandler.obtainMessage(4);
        message.arg1 = saturationLevel;
        this.mHandler.sendMessage(message);
    }

    boolean setAppSaturationLevelInternal(String callingPackageName, String affectedPackageName, int saturationLevel) {
        return this.mAppSaturationController.setSaturationLevel(callingPackageName, affectedPackageName, this.mCurrentUser, saturationLevel);
    }

    private void setColorModeInternal(int colorMode) {
        if (isColorModeAvailable(colorMode) == false) goto L7;
        Settings.System.putIntForUser(getContext().getContentResolver(), "display_color_mode", colorMode, this.mCurrentUser);
        return;
    L7:
        throw new IllegalArgumentException("Invalid colorMode: " + colorMode);
    }

    private int getColorModeInternal() {
        ContentResolver cr = getContext().getContentResolver();
        if (isAccessibilityEnabled() == false) goto L7;
        int a11yColorMode = getContext().getResources().getInteger(R.integer.config_accumulatedBatteryUsageStatsSpanSize);
        if (a11yColorMode < 0) goto L7;
        return a11yColorMode;
    L7:
        int colorMode = Settings.System.getIntForUser(cr, "display_color_mode", -1, this.mCurrentUser);
        if (colorMode != (-1)) goto L11;
        colorMode = getCurrentColorModeFromSystemProperties();
    L11:
        if (isColorModeAvailable(colorMode) == true) goto L24;
        int[] mappedColorModes = getContext().getResources().getIntArray(R.array.config_packagesExemptFromSuspension);
        if (colorMode != (-1)) goto L15;
    L19:
        int[] availableColorModes = getContext().getResources().getIntArray(R.array.config_cameraPrivacyLightColors);
        if (availableColorModes.length > 0) goto L26;
        return -1;
    L26:
        return availableColorModes[0];
    L15:
        if (mappedColorModes.length <= colorMode) goto L19;
        if (isColorModeAvailable(mappedColorModes[colorMode]) == false) goto L19;
        return mappedColorModes[colorMode];
    L24:
        return colorMode;
    }

    private int getCurrentColorModeFromSystemProperties() {
        int displayColorSetting = SystemProperties.getInt("persist.sys.sf.native_mode", 0);
        if (displayColorSetting != 0) goto L10;
        if ("1.0".equals(SystemProperties.get("persist.sys.sf.color_saturation")) == false) goto L8;
        return 0;
    L8:
        return 1;
    L10:
        if (displayColorSetting != 1) goto L12;
        return 2;
    L12:
        if (displayColorSetting != 2) goto L16;
        return 3;
    L16:
        if (displayColorSetting >= 256) goto L18;
        return -1;
    L18:
        if (displayColorSetting > 511) goto L23;
        return displayColorSetting;
    L23:
        return -1;
    }

    private boolean isColorModeAvailable(int colorMode) {
        int[] availableColorModes = getContext().getResources().getIntArray(R.array.config_cameraPrivacyLightColors);
        if (availableColorModes == null) goto L12;
        int r2 = availableColorModes.length;
        int r3 = 0;
    L6:
        if (r3 >= r2) goto L12;
        int mode = availableColorModes[r3];
        if (mode == colorMode) goto L9;
        r3 = r3 + 1;
        goto L6
    L9:
        return true;
    L12:
        return false;
    }

    private void dumpInternal(PrintWriter pw, String[] args) {
        this.mExt.dumpInternal(pw, args);
        pw.println("COLOR DISPLAY MANAGER dumpsys (color_display)");
        pw.println("Night display:");
        if (this.mNightDisplayTintController.isAvailable(getContext()) == false) goto L7;
        pw.println("    Activated: " + this.mNightDisplayTintController.isActivated());
        pw.println("    Color temp: " + this.mNightDisplayTintController.getColorTemperature());
        pw.println("    Mode: " + this.mNightDisplayMode);
        if (this.mNightDisplayMode != 2) goto L8;
        pw.println("    Twilight state: " + this.mTwilightState);
    L8:
        pw.println("Global saturation:");
        if (this.mGlobalSaturationTintController.isAvailable(getContext()) == false) goto L11;
        pw.println("    Activated: " + this.mGlobalSaturationTintController.isActivated());
    L12:
        this.mAppSaturationController.dump(pw);
        pw.println("Display white balance:");
        if (this.mDisplayWhiteBalanceTintController.isAvailable(getContext()) == false) goto L15;
        pw.println("    Activated: " + this.mDisplayWhiteBalanceTintController.isActivated());
        this.mDisplayWhiteBalanceTintController.dump(pw);
    L16:
        pw.println("Reduce bright colors:");
        if (this.mReduceBrightColorsTintController.isAvailable(getContext()) == false) goto L19;
        pw.println("    Activated: " + this.mReduceBrightColorsTintController.isActivated());
        this.mReduceBrightColorsTintController.dump(pw);
    L20:
        pw.println("Color mode: " + getColorModeInternal());
        return;
    L19:
        pw.println("    Not available");
        goto L20
    L15:
        pw.println("    Not available");
        goto L16
    L11:
        pw.println("    Not available");
        goto L12
    L7:
        pw.println("    Not available");
        goto L8
    }

    private void enforceValidCallingUser(String method) {
        if (this.mVisibleBackgroundUsersEnabled == true) goto L5;
        return;
    L5:
        int callingUserId = UserHandle.getCallingUserId();
        if (callingUserId != 0) goto L8;
        return;
    L8:
        if (callingUserId == this.mCurrentUser) goto L23;
        long ident = Binder.clearCallingIdentity();
        if (this.mUserManager.isSameProfileGroup(callingUserId, this.mCurrentUser) == false) goto L15;
        Binder.restoreCallingIdentity(ident);
        return;
    L15:
        Binder.restoreCallingIdentity(ident);
        throw new SecurityException("Calling user id: " + callingUserId + ", is not permitted to use Method " + method + "().");
    L17:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    }

    protected void applyTintExt(TintController tintController, boolean immediate) {
        applyTint(tintController, immediate);
    }

    public IExtColorDisplayService getExt() {
        return this.mExt;
    }
}
