package com.android.server.display.brightness;

import android.R;
import android.content.Context;
import android.hardware.display.DisplayManagerInternal;
import android.pico.utils.ExtImplFactory;
import android.util.IndentingPrintWriter;
import android.util.Slog;
import com.android.server.display.brightness.strategy.AutoBrightnessFallbackStrategy;
import com.android.server.display.brightness.strategy.AutomaticBrightnessStrategy;
import com.android.server.display.brightness.strategy.AutomaticBrightnessStrategy2;
import com.android.server.display.brightness.strategy.BoostBrightnessStrategy;
import com.android.server.display.brightness.strategy.DisplayBrightnessStrategy;
import com.android.server.display.brightness.strategy.DozeBrightnessStrategy;
import com.android.server.display.brightness.strategy.FallbackBrightnessStrategy;
import com.android.server.display.brightness.strategy.FollowerBrightnessStrategy;
import com.android.server.display.brightness.strategy.InvalidBrightnessStrategy;
import com.android.server.display.brightness.strategy.OffloadBrightnessStrategy;
import com.android.server.display.brightness.strategy.OverrideBrightnessStrategy;
import com.android.server.display.brightness.strategy.ScreenOffBrightnessStrategy;
import com.android.server.display.brightness.strategy.TemporaryBrightnessStrategy;
import com.android.server.display.feature.DisplayManagerFlags;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes2.dex */
public class DisplayBrightnessStrategySelector {
    private static final String TAG = "DisplayBrightnessStrategySelector";
    private boolean mAllowAutoBrightnessWhileDozing;
    private final boolean mAllowAutoBrightnessWhileDozingConfig;
    private final AutoBrightnessFallbackStrategy mAutoBrightnessFallbackStrategy;
    private final AutomaticBrightnessStrategy2 mAutomaticBrightnessStrategy;
    protected final AutomaticBrightnessStrategy mAutomaticBrightnessStrategy1;
    private final AutomaticBrightnessStrategy2 mAutomaticBrightnessStrategy2;
    private final BoostBrightnessStrategy mBoostBrightnessStrategy;
    final Context mContext;
    final DisplayBrightnessStrategy[] mDisplayBrightnessStrategies;
    private final int mDisplayId;
    private final DisplayManagerFlags mDisplayManagerFlags;
    final DozeBrightnessStrategy mDozeBrightnessStrategy;
    private IExtDisplayBrightnessStrategySelector mExt;
    private final FallbackBrightnessStrategy mFallbackBrightnessStrategy;
    private final FollowerBrightnessStrategy mFollowerBrightnessStrategy;
    private final InvalidBrightnessStrategy mInvalidBrightnessStrategy;
    private final OffloadBrightnessStrategy mOffloadBrightnessStrategy;
    String mOldBrightnessStrategyName;
    private final OverrideBrightnessStrategy mOverrideBrightnessStrategy;
    final ScreenOffBrightnessStrategy mScreenOffBrightnessStrategy;
    private final TemporaryBrightnessStrategy mTemporaryBrightnessStrategy;

    static class Injector {
        Injector() {
        }

        ScreenOffBrightnessStrategy getScreenOffBrightnessStrategy() {
            return new ScreenOffBrightnessStrategy();
        }

        DozeBrightnessStrategy getDozeBrightnessStrategy() {
            return new DozeBrightnessStrategy();
        }

        OverrideBrightnessStrategy getOverrideBrightnessStrategy() {
            return new OverrideBrightnessStrategy();
        }

        TemporaryBrightnessStrategy getTemporaryBrightnessStrategy() {
            return new TemporaryBrightnessStrategy();
        }

        BoostBrightnessStrategy getBoostBrightnessStrategy() {
            return new BoostBrightnessStrategy();
        }

        FollowerBrightnessStrategy getFollowerBrightnessStrategy(int displayId) {
            return new FollowerBrightnessStrategy(displayId);
        }

        InvalidBrightnessStrategy getInvalidBrightnessStrategy() {
            return new InvalidBrightnessStrategy();
        }

        AutomaticBrightnessStrategy getAutomaticBrightnessStrategy1(Context context, int displayId, DisplayManagerFlags displayManagerFlags) {
            return new AutomaticBrightnessStrategy(context, displayId, displayManagerFlags);
        }

        AutomaticBrightnessStrategy2 getAutomaticBrightnessStrategy2(Context context, int displayId) {
            return new AutomaticBrightnessStrategy2(context, displayId);
        }

        OffloadBrightnessStrategy getOffloadBrightnessStrategy(DisplayManagerFlags displayManagerFlags) {
            return new OffloadBrightnessStrategy(displayManagerFlags);
        }

        AutoBrightnessFallbackStrategy getAutoBrightnessFallbackStrategy() {
            return new AutoBrightnessFallbackStrategy(null);
        }

        FallbackBrightnessStrategy getFallbackBrightnessStrategy() {
            return new FallbackBrightnessStrategy();
        }
    }

    public DisplayBrightnessStrategySelector(Context context, Injector injector, int displayId, DisplayManagerFlags flags) {
        this.mExt = (IExtDisplayBrightnessStrategySelector) ExtImplFactory.getImpl(IExtDisplayBrightnessStrategySelector.class, new Object[]{this});
        if (injector != null) goto L5;
        Injector injector2 = new Injector();
    L6:
        this.mContext = context;
        this.mDisplayManagerFlags = flags;
        this.mDisplayId = displayId;
        this.mDozeBrightnessStrategy = injector2.getDozeBrightnessStrategy();
        this.mScreenOffBrightnessStrategy = injector2.getScreenOffBrightnessStrategy();
        this.mOverrideBrightnessStrategy = injector2.getOverrideBrightnessStrategy();
        this.mTemporaryBrightnessStrategy = injector2.getTemporaryBrightnessStrategy();
        this.mBoostBrightnessStrategy = injector2.getBoostBrightnessStrategy();
        this.mFollowerBrightnessStrategy = injector2.getFollowerBrightnessStrategy(displayId);
        this.mInvalidBrightnessStrategy = injector2.getInvalidBrightnessStrategy();
        FallbackBrightnessStrategy r6 = null;
        if (this.mDisplayManagerFlags.isRefactorDisplayPowerControllerEnabled() == true) goto L9;
        AutomaticBrightnessStrategy r5 = null;
    L10:
        this.mAutomaticBrightnessStrategy1 = r5;
        if (this.mDisplayManagerFlags.isRefactorDisplayPowerControllerEnabled() == false) goto L13;
        AutomaticBrightnessStrategy2 r7 = null;
    L14:
        this.mAutomaticBrightnessStrategy2 = r7;
        if (this.mDisplayManagerFlags.isRefactorDisplayPowerControllerEnabled() == false) goto L17;
        AutomaticBrightnessStrategy2 r8 = this.mAutomaticBrightnessStrategy1;
    L18:
        this.mAutomaticBrightnessStrategy = r8;
        if (this.mDisplayManagerFlags.isRefactorDisplayPowerControllerEnabled() == false) goto L21;
        AutoBrightnessFallbackStrategy r9 = injector2.getAutoBrightnessFallbackStrategy();
    L22:
        this.mAutoBrightnessFallbackStrategy = r9;
        if (flags.isDisplayOffloadEnabled() == false) goto L25;
        this.mOffloadBrightnessStrategy = injector2.getOffloadBrightnessStrategy(this.mDisplayManagerFlags);
    L27:
        if (this.mDisplayManagerFlags.isRefactorDisplayPowerControllerEnabled() == false) goto L30;
        r6 = injector2.getFallbackBrightnessStrategy();
    L30:
        this.mFallbackBrightnessStrategy = r6;
        this.mDisplayBrightnessStrategies = new DisplayBrightnessStrategy[]{this.mInvalidBrightnessStrategy, this.mScreenOffBrightnessStrategy, this.mDozeBrightnessStrategy, this.mFollowerBrightnessStrategy, this.mBoostBrightnessStrategy, this.mOverrideBrightnessStrategy, this.mTemporaryBrightnessStrategy, this.mAutomaticBrightnessStrategy1, this.mOffloadBrightnessStrategy, this.mAutoBrightnessFallbackStrategy, this.mFallbackBrightnessStrategy};
        this.mAllowAutoBrightnessWhileDozingConfig = context.getResources().getBoolean(R.bool.config_allowAutoBrightnessWhileDozing);
        this.mAllowAutoBrightnessWhileDozing = this.mAllowAutoBrightnessWhileDozingConfig;
        this.mOldBrightnessStrategyName = this.mInvalidBrightnessStrategy.getName();
        this.mExt.onBaseReady(context, displayId);
        return;
    L25:
        this.mOffloadBrightnessStrategy = null;
        goto L27
    L21:
        r9 = null;
        goto L22
    L17:
        r8 = this.mAutomaticBrightnessStrategy2;
        goto L18
    L13:
        r7 = injector2.getAutomaticBrightnessStrategy2(context, displayId);
        goto L14
    L9:
        r5 = injector2.getAutomaticBrightnessStrategy1(context, displayId, this.mDisplayManagerFlags);
        goto L10
    L5:
        injector2 = injector;
        goto L6
    }

    public DisplayBrightnessStrategy selectStrategy(StrategySelectionRequest strategySelectionRequest) {
        DisplayBrightnessStrategy displayBrightnessStrategy = this.mInvalidBrightnessStrategy;
        int targetDisplayState = strategySelectionRequest.getTargetDisplayState();
        DisplayManagerInternal.DisplayPowerRequest displayPowerRequest = strategySelectionRequest.getDisplayPowerRequest();
        setAllowAutoBrightnessWhileDozing(strategySelectionRequest.getDisplayOffloadSession());
        if (targetDisplayState != 1) goto L5;
        displayBrightnessStrategy = this.mScreenOffBrightnessStrategy;
    L48:
        if (this.mDisplayManagerFlags.isRefactorDisplayPowerControllerEnabled() == false) goto L50;
        StrategySelectionNotifyRequest notifyRequest = constructStrategySelectionNotifyRequest(displayBrightnessStrategy, strategySelectionRequest);
        postProcess(notifyRequest);
        this.mExt.strategySelectionPostProcessor(notifyRequest);
    L50:
        this.mExt.onDisplayBrightnessStrategySelected(displayBrightnessStrategy);
        if (this.mOldBrightnessStrategyName.equals(displayBrightnessStrategy.getName()) == true) goto L53;
        Slog.i(TAG, "Changing the DisplayBrightnessStrategy from " + this.mOldBrightnessStrategyName + " to " + displayBrightnessStrategy.getName() + " for display " + this.mDisplayId);
        this.mOldBrightnessStrategyName = displayBrightnessStrategy.getName();
    L53:
        return displayBrightnessStrategy;
    L5:
        DisplayBrightnessStrategy extStrategy = this.mExt.selectStrategy(strategySelectionRequest);
        if (extStrategy == null) goto L9;
        displayBrightnessStrategy = extStrategy;
        goto L48
    L9:
        if (shouldUseDozeBrightnessStrategy(displayPowerRequest) == false) goto L12;
        displayBrightnessStrategy = this.mDozeBrightnessStrategy;
        goto L48
    L12:
        if (BrightnessUtils.isValidBrightnessValue(this.mFollowerBrightnessStrategy.getBrightnessToFollow()) == false) goto L15;
        displayBrightnessStrategy = this.mFollowerBrightnessStrategy;
        goto L48
    L15:
        if (displayPowerRequest.boostScreenBrightness == false) goto L18;
        displayBrightnessStrategy = this.mBoostBrightnessStrategy;
        goto L48
    L18:
        if (BrightnessUtils.isValidBrightnessValue(displayPowerRequest.screenBrightnessOverride) == false) goto L20;
    L46:
        displayBrightnessStrategy = this.mOverrideBrightnessStrategy;
        goto L48
    L20:
        if (BrightnessUtils.isValidBrightnessValue(this.mOverrideBrightnessStrategy.getWindowManagerBrightnessOverride()) == true) goto L46;
        if (BrightnessUtils.isValidBrightnessValue(this.mTemporaryBrightnessStrategy.getTemporaryScreenBrightness()) == false) goto L25;
        displayBrightnessStrategy = this.mTemporaryBrightnessStrategy;
        goto L48
    L25:
        DisplayBrightnessStrategy extStrategy2 = this.mExt.selectPostTemporaryStrategy(strategySelectionRequest);
        if (extStrategy2 == null) goto L29;
        displayBrightnessStrategy = extStrategy2;
        goto L48
    L29:
        if (this.mDisplayManagerFlags.isRefactorDisplayPowerControllerEnabled() == false) goto L34;
        if (isAutomaticBrightnessStrategyValid(strategySelectionRequest) == false) goto L34;
        displayBrightnessStrategy = this.mAutomaticBrightnessStrategy1;
    L34:
        if (this.mAutomaticBrightnessStrategy.shouldUseAutoBrightness() == false) goto L41;
        if (this.mOffloadBrightnessStrategy == null) goto L41;
        if (BrightnessUtils.isValidBrightnessValue(this.mOffloadBrightnessStrategy.getOffloadScreenBrightness()) == false) goto L41;
        displayBrightnessStrategy = this.mOffloadBrightnessStrategy;
    L41:
        if (isAutoBrightnessFallbackStrategyValid() == false) goto L44;
        displayBrightnessStrategy = this.mAutoBrightnessFallbackStrategy;
        goto L48
    L44:
        if (this.mDisplayManagerFlags.isRefactorDisplayPowerControllerEnabled() == false) goto L48;
        displayBrightnessStrategy = this.mFallbackBrightnessStrategy;
        goto L48
    }

    public TemporaryBrightnessStrategy getTemporaryDisplayBrightnessStrategy() {
        return this.mTemporaryBrightnessStrategy;
    }

    public FollowerBrightnessStrategy getFollowerDisplayBrightnessStrategy() {
        return this.mFollowerBrightnessStrategy;
    }

    public AutomaticBrightnessStrategy2 getAutomaticBrightnessStrategy() {
        return this.mAutomaticBrightnessStrategy;
    }

    public OffloadBrightnessStrategy getOffloadBrightnessStrategy() {
        return this.mOffloadBrightnessStrategy;
    }

    public boolean isAllowAutoBrightnessWhileDozing() {
        return this.mAllowAutoBrightnessWhileDozing;
    }

    public boolean isAllowAutoBrightnessWhileDozingConfig() {
        return this.mAllowAutoBrightnessWhileDozingConfig;
    }

    public AutoBrightnessFallbackStrategy getAutoBrightnessFallbackStrategy() {
        return this.mAutoBrightnessFallbackStrategy;
    }

    public OverrideBrightnessStrategy getOverrideBrightnessStrategy() {
        return this.mOverrideBrightnessStrategy;
    }

    public void onBrightnessClampedForManualRange(float effectiveSdrBrightness) {
        this.mExt.onBrightnessClampedForManualRange(effectiveSdrBrightness);
    }

    public FallbackBrightnessStrategy getFallbackDisplayBrightnessStrategy() {
        return this.mFallbackBrightnessStrategy;
    }

    public void dump(PrintWriter writer) {
        writer.println();
        writer.println("DisplayBrightnessStrategySelector:");
        writer.println("----------------------------------");
        writer.println("  mDisplayId= " + this.mDisplayId);
        writer.println("  mOldBrightnessStrategyName= " + this.mOldBrightnessStrategyName);
        writer.println("  mAllowAutoBrightnessWhileDozingConfig= " + this.mAllowAutoBrightnessWhileDozingConfig);
        writer.println("  mAllowAutoBrightnessWhileDozing= " + this.mAllowAutoBrightnessWhileDozing);
        PrintWriter r0 = new IndentingPrintWriter(writer, " ");
        DisplayBrightnessStrategy[] r1 = this.mDisplayBrightnessStrategies;
        int r2 = r1.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L8;
        DisplayBrightnessStrategy displayBrightnessStrategy = r1[r3];
        if (displayBrightnessStrategy == null) goto L7;
        displayBrightnessStrategy.dump(r0);
    L7:
        r3 = r3 + 1;
        goto L3
    L8:
        this.mExt.dump(writer);
    }

    void setAllowAutoBrightnessWhileDozing(DisplayManagerInternal.DisplayOffloadSession displayOffloadSession) {
        this.mAllowAutoBrightnessWhileDozing = this.mAllowAutoBrightnessWhileDozingConfig;
        if (this.mDisplayManagerFlags.isDisplayOffloadEnabled() == false) goto L7;
        if (displayOffloadSession == null) goto L8;
        this.mAllowAutoBrightnessWhileDozing &= displayOffloadSession.allowAutoBrightnessInDoze();
        return;
    L8:
        return;
    }

    private boolean isAutoBrightnessFallbackStrategyValid() {
        if (this.mDisplayManagerFlags.isRefactorDisplayPowerControllerEnabled() == true) goto L5;
    L11:
        return false;
    L5:
        if (this.mAutoBrightnessFallbackStrategy == null) goto L11;
        if (getAutomaticBrightnessStrategy().shouldUseAutoBrightness() == false) goto L11;
        if (this.mAutoBrightnessFallbackStrategy.isValid() == false) goto L11;
        return true;
    }

    private boolean isAutomaticBrightnessStrategyValid(StrategySelectionRequest strategySelectionRequest) {
        this.mAutomaticBrightnessStrategy1.setAutoBrightnessState(strategySelectionRequest.getTargetDisplayState(), this.mAllowAutoBrightnessWhileDozing, 0, strategySelectionRequest.getDisplayPowerRequest().policy, strategySelectionRequest.getDisplayPowerRequest().useNormalBrightnessForDoze, strategySelectionRequest.getLastUserSetScreenBrightness(), strategySelectionRequest.isUserSetBrightnessChanged(), strategySelectionRequest.isWearBedtimeModeEnabled());
        if (strategySelectionRequest.isStylusBeingUsed() == false) goto L5;
    L9:
        return false;
    L5:
        if (this.mExt.skipOverrideBrightness2Auto() == true) goto L9;
        if (this.mAutomaticBrightnessStrategy1.isAutoBrightnessValid() == false) goto L9;
        return true;
    }

    private StrategySelectionNotifyRequest constructStrategySelectionNotifyRequest(DisplayBrightnessStrategy selectedDisplayBrightnessStrategy, StrategySelectionRequest strategySelectionRequest) {
        return new StrategySelectionNotifyRequest(strategySelectionRequest.getDisplayPowerRequest(), strategySelectionRequest.getTargetDisplayState(), selectedDisplayBrightnessStrategy, strategySelectionRequest.getLastUserSetScreenBrightness(), strategySelectionRequest.isUserSetBrightnessChanged(), this.mAllowAutoBrightnessWhileDozing, getAutomaticBrightnessStrategy().shouldUseAutoBrightness(), strategySelectionRequest.isWearBedtimeModeEnabled());
    }

    private void postProcess(StrategySelectionNotifyRequest strategySelectionNotifyRequest) {
        DisplayBrightnessStrategy[] r0 = this.mDisplayBrightnessStrategies;
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L8;
        DisplayBrightnessStrategy displayBrightnessStrategy = r0[r2];
        if (displayBrightnessStrategy == null) goto L7;
        displayBrightnessStrategy.strategySelectionPostProcessor(strategySelectionNotifyRequest);
    L7:
        r2 = r2 + 1;
        goto L3
    }

    private boolean shouldUseDozeBrightnessStrategy(DisplayManagerInternal.DisplayPowerRequest displayPowerRequest) {
        if (this.mDisplayManagerFlags.isNormalBrightnessForDozeParameterEnabled(this.mContext) == false) goto L7;
        if (displayPowerRequest.useNormalBrightnessForDoze == false) goto L7;
    L13:
        return false;
    L7:
        if (displayPowerRequest.policy != 1) goto L13;
        if (this.mAllowAutoBrightnessWhileDozing == true) goto L13;
        if (BrightnessUtils.isValidBrightnessValue(displayPowerRequest.dozeScreenBrightness) == false) goto L13;
        return true;
    }

    public IExtDisplayBrightnessStrategySelector getExt() {
        return this.mExt;
    }
}
