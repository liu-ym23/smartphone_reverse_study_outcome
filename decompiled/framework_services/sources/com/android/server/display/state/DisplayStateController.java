package com.android.server.display.state;

import android.hardware.display.DisplayManagerInternal;
import android.pico.utils.ExtImplFactory;
import android.util.IndentingPrintWriter;
import android.util.Pair;
import com.android.server.display.DisplayPowerProximityStateController;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes2.dex */
public class DisplayStateController {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final DisplayPowerProximityStateController mDisplayPowerProximityStateController;
    private int mDozeStateOverride;
    private int mDozeStateOverrideReason;
    private IExtDisplayStateController mExt;
    private boolean mPerformScreenOffTransition;
    private final boolean mShouldSkipScreenOffTransition;
    private final DisplayStateControllerSmtEx mSmtEx;

    static {
    }

    public DisplayStateController(DisplayPowerProximityStateController displayPowerProximityStateController, boolean shouldSkipScreenOffTransition) {
        this.mPerformScreenOffTransition = false;
        this.mDozeStateOverride = 0;
        this.mDozeStateOverrideReason = 0;
        this.mSmtEx = new DisplayStateControllerSmtEx(this);
        this.mExt = (IExtDisplayStateController) ExtImplFactory.getImpl(IExtDisplayStateController.class, new Object[]{this});
        this.mDisplayPowerProximityStateController = displayPowerProximityStateController;
        this.mShouldSkipScreenOffTransition = shouldSkipScreenOffTransition;
    }

    public Pair<Integer, Integer> updateDisplayState(DisplayManagerInternal.DisplayPowerRequest displayPowerRequest, boolean isDisplayEnabled, boolean isDisplayInTransition) {
        this.mPerformScreenOffTransition = false;
        int reason = displayPowerRequest.policyReason;
        switch(displayPowerRequest.policy) {
            case 0: goto L13;
            case 1: goto L5;
            default: goto L4;
        };
    L4:
        int state = 2;
        DisplayManagerInternal.DisplayPowerRequest displayPowerRequest2 = displayPowerRequest;
        boolean isDisplayEnabled2 = isDisplayEnabled;
        boolean isDisplayInTransition2 = isDisplayInTransition;
    L14:
        this.mDisplayPowerProximityStateController.updateProximityState(displayPowerRequest2, state);
        if (displayPowerRequest2.useProximitySensor == false) goto L19;
        if (state != 1) goto L19;
        this.mSmtEx.mRequestFromCallLock = true;
    L21:
        if (isDisplayEnabled2 == false) goto L26;
        if (isDisplayInTransition2 == true) goto L26;
        if (this.mDisplayPowerProximityStateController.isScreenOffBecauseOfProximity() == true) goto L26;
    L31:
        return new Pair(Integer.valueOf(state), Integer.valueOf(reason));
    L26:
        if (this.mSmtEx.mRequestFromCallLock == true) goto L31;
        if (displayPowerRequest2.useProximitySensor == false) goto L31;
        state = 1;
    L19:
        if (displayPowerRequest2.useProximitySensor == true) goto L21;
        this.mSmtEx.mRequestFromCallLock = false;
        goto L21
    L5:
        int state2 = this.mDozeStateOverride;
        if (state2 == 0) goto L8;
        int state3 = this.mDozeStateOverride;
        int reason2 = this.mDozeStateOverrideReason;
        int state4 = state3;
    L12:
        displayPowerRequest2 = displayPowerRequest;
        isDisplayEnabled2 = isDisplayEnabled;
        isDisplayInTransition2 = isDisplayInTransition;
        Pair<Integer, Integer> pair = this.mExt.updateDisplayState(displayPowerRequest2, this.mDozeStateOverride, isDisplayEnabled2, isDisplayInTransition2, state4, reason2);
        state = ((Integer) pair.first).intValue();
        reason = reason2;
        goto L14
    L8:
        int state5 = displayPowerRequest.dozeScreenState;
        if (state5 == 0) goto L11;
        int state6 = displayPowerRequest.dozeScreenState;
        reason2 = displayPowerRequest.dozeScreenStateReason;
        state4 = state6;
        goto L12
    L11:
        reason2 = reason;
        state4 = 3;
        goto L12
    L13:
        displayPowerRequest2 = displayPowerRequest;
        isDisplayEnabled2 = isDisplayEnabled;
        isDisplayInTransition2 = isDisplayInTransition;
        state = 1;
        this.mPerformScreenOffTransition = !this.mShouldSkipScreenOffTransition;
        goto L14
    }

    public void overrideDozeScreenState(int displayState, int reason) {
        this.mDozeStateOverride = displayState;
        this.mDozeStateOverrideReason = reason;
    }

    public boolean shouldPerformScreenOffTransition() {
        return this.mPerformScreenOffTransition;
    }

    public void dump(PrintWriter pw) {
        pw.println("DisplayStateController:");
        pw.println("-----------------------");
        pw.println("  mShouldSkipScreenOffTransition=" + this.mShouldSkipScreenOffTransition);
        pw.println("  mPerformScreenOffTransition=" + this.mPerformScreenOffTransition);
        pw.println("  mDozeStateOverride=" + this.mDozeStateOverride);
        PrintWriter r0 = new IndentingPrintWriter(pw, " ");
        if (this.mDisplayPowerProximityStateController == null) goto L6;
        this.mDisplayPowerProximityStateController.dumpLocal(r0);
        return;
    }

    public IExtDisplayStateController getExt() {
        return this.mExt;
    }
}
