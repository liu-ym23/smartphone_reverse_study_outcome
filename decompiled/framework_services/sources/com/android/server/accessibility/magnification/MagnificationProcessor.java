package com.android.server.accessibility.magnification;

import android.accessibilityservice.MagnificationConfig;
import android.graphics.Region;
import android.view.Display;
import android.view.accessibility.MagnificationAnimationCallback;
import java.io.PrintWriter;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class MagnificationProcessor {
    private static final boolean DEBUG = false;
    private static final String TAG = "MagnificationProcessor";
    private final MagnificationController mController;

    public MagnificationProcessor(MagnificationController controller) {
        this.mController = controller;
    }

    public MagnificationConfig getMagnificationConfig(int displayId) {
        int mode = getControllingMode(displayId);
        MagnificationConfig.Builder builder = new MagnificationConfig.Builder();
        if (mode != 1) goto L6;
        FullScreenMagnificationController fullScreenMagnificationController = this.mController.getFullScreenMagnificationController();
        builder.setMode(mode).setActivated(this.mController.isActivated(displayId, 1)).setScale(fullScreenMagnificationController.getScale(displayId)).setCenterX(fullScreenMagnificationController.getCenterX(displayId)).setCenterY(fullScreenMagnificationController.getCenterY(displayId));
    L10:
        return builder.build();
    L6:
        if (mode != 2) goto L8;
        MagnificationConnectionManager magnificationConnectionManager = this.mController.getMagnificationConnectionManager();
        builder.setMode(mode).setActivated(this.mController.isActivated(displayId, 2)).setScale(magnificationConnectionManager.getScale(displayId)).setCenterX(magnificationConnectionManager.getCenterX(displayId)).setCenterY(magnificationConnectionManager.getCenterY(displayId));
        goto L10
    L8:
        builder.setActivated(false);
        goto L10
    }

    public boolean setMagnificationConfig(int displayId, MagnificationConfig config, boolean animate, int id) {
        if (transitionModeIfNeeded(displayId, config, animate, id) == false) goto L5;
        return true;
    L5:
        int configMode = config.getMode();
        if (configMode != 0) goto L8;
        configMode = getControllingMode(displayId);
    L8:
        boolean configActivated = config.isActivated();
        if (configMode != 1) goto L16;
        if (configActivated == false) goto L14;
        return setScaleAndCenterForFullScreenMagnification(displayId, config.getScale(), config.getCenterX(), config.getCenterY(), animate, id);
    L14:
        return resetFullscreenMagnification(displayId, animate);
    L16:
        if (configMode != 2) goto L26;
        if (configActivated == false) goto L25;
        MagnificationConnectionManager r12 = this.mController.getMagnificationConnectionManager();
        float r6 = config.getScale();
        float r7 = config.getCenterX();
        float r8 = config.getCenterY();
        if (animate == false) goto L21;
        MagnificationAnimationCallback r15 = MagnificationAnimationCallback.STUB_ANIMATION_CALLBACK;
    L23:
        return r12.enableWindowMagnification(displayId, r6, r7, r8, r15, id);
    L21:
        r15 = null;
        goto L23
    L25:
        return this.mController.getMagnificationConnectionManager().disableWindowMagnification(displayId, false);
    L26:
        return false;
    }

    private boolean setScaleAndCenterForFullScreenMagnification(int displayId, float scale, float centerX, float centerY, boolean animate, int id) {
        if (isRegistered(displayId) == true) goto L6;
        register(displayId);
    L6:
        return this.mController.getFullScreenMagnificationController().setScaleAndCenter(displayId, scale, centerX, centerY, animate, id);
    }

    private boolean transitionModeIfNeeded(int displayId, MagnificationConfig config, boolean animate, int id) {
        int currentMode = getControllingMode(displayId);
        if (config.getMode() != 0) goto L6;
        return false;
    L6:
        if (currentMode == config.getMode()) goto L8;
    L10:
        this.mController.transitionMagnificationConfigMode(displayId, config, animate, id);
        return true;
    L8:
        if (this.mController.hasDisableMagnificationCallback(displayId) == true) goto L10;
        return false;
    }

    public float getScale(int displayId) {
        return this.mController.getFullScreenMagnificationController().getScale(displayId);
    }

    public float getCenterX(int displayId, boolean canControlMagnification) {
        boolean registeredJustForThisCall = registerDisplayMagnificationIfNeeded(displayId, canControlMagnification);
        float r1 = this.mController.getFullScreenMagnificationController().getCenterX(displayId);     // Catch: Throwable -> L7
        if (registeredJustForThisCall == false) goto L6;
        unregister(displayId);
    L6:
        return r1;
    L7:
        th = move-exception;
        if (registeredJustForThisCall == false) goto L10;
        unregister(displayId);
    L10:
        throw th;
    }

    public float getCenterY(int displayId, boolean canControlMagnification) {
        boolean registeredJustForThisCall = registerDisplayMagnificationIfNeeded(displayId, canControlMagnification);
        float r1 = this.mController.getFullScreenMagnificationController().getCenterY(displayId);     // Catch: Throwable -> L7
        if (registeredJustForThisCall == false) goto L6;
        unregister(displayId);
    L6:
        return r1;
    L7:
        th = move-exception;
        if (registeredJustForThisCall == false) goto L10;
        unregister(displayId);
    L10:
        throw th;
    }

    public void getCurrentMagnificationRegion(int displayId, Region outRegion, boolean canControlMagnification) {
        int currentMode = getControllingMode(displayId);
        if (currentMode != 1) goto L6;
        getFullscreenMagnificationRegion(displayId, outRegion, canControlMagnification);
        return;
    L6:
        if (currentMode != 2) goto L10;
        this.mController.getMagnificationConnectionManager().getMagnificationSourceBounds(displayId, outRegion);
        return;
    }

    public void getFullscreenMagnificationRegion(int displayId, Region outRegion, boolean canControlMagnification) {
        boolean registeredJustForThisCall = registerDisplayMagnificationIfNeeded(displayId, canControlMagnification);
        this.mController.getFullScreenMagnificationController().getMagnificationRegion(displayId, outRegion);     // Catch: Throwable -> L7
        if (registeredJustForThisCall == false) goto L13;
        unregister(displayId);
        return;
    L13:
        return;
    L7:
        th = move-exception;
        if (registeredJustForThisCall == false) goto L10;
        unregister(displayId);
    L10:
        throw th;
    }

    public boolean resetCurrentMagnification(int displayId, boolean animate) {
        int mode = getControllingMode(displayId);
        if (mode != 1) goto L7;
        return this.mController.getFullScreenMagnificationController().reset(displayId, animate);
    L7:
        if (mode != 2) goto L14;
        MagnificationConnectionManager r1 = this.mController.getMagnificationConnectionManager();
        if (animate == false) goto L11;
        MagnificationAnimationCallback r3 = MagnificationAnimationCallback.STUB_ANIMATION_CALLBACK;
    L13:
        return r1.disableWindowMagnification(displayId, false, r3);
    L11:
        r3 = null;
        goto L13
    L14:
        return false;
    }

    public boolean resetFullscreenMagnification(int displayId, boolean animate) {
        return this.mController.getFullScreenMagnificationController().reset(displayId, animate);
    }

    public void resetAllIfNeeded(int connectionId) {
        this.mController.getFullScreenMagnificationController().resetAllIfNeeded(connectionId);
        this.mController.getMagnificationConnectionManager().resetAllIfNeeded(connectionId);
    }

    public boolean isMagnifying(int displayId) {
        int mode = getControllingMode(displayId);
        if (mode != 1) goto L7;
        return this.mController.getFullScreenMagnificationController().isActivated(displayId);
    L7:
        if (mode == 2) goto L9;
        return false;
    L9:
        return this.mController.getMagnificationConnectionManager().isWindowMagnifierEnabled(displayId);
    }

    public int getControllingMode(int displayId) {
        if (this.mController.isActivated(displayId, 2) == false) goto L6;
        return 2;
    L6:
        if (this.mController.isActivated(displayId, 1) == false) goto L9;
        return 1;
    L9:
        if (this.mController.getLastMagnificationActivatedMode(displayId) != 2) goto L12;
        return 2;
    L12:
        return 1;
    }

    private boolean registerDisplayMagnificationIfNeeded(int displayId, boolean canControlMagnification) {
        if (isRegistered(displayId) == true) goto L7;
        if (canControlMagnification == false) goto L9;
        register(displayId);
        return true;
    L9:
        return false;
    L7:
        return false;
    }

    private boolean isRegistered(int displayId) {
        return this.mController.getFullScreenMagnificationController().isRegistered(displayId);
    }

    private void register(int displayId) {
        this.mController.getFullScreenMagnificationController().register(displayId);
    }

    private void unregister(int displayId) {
        this.mController.getFullScreenMagnificationController().unregister(displayId);
    }

    public void dump(PrintWriter pw, ArrayList<Display> displaysList) {
        int i = 0;
    L4:
        if (i >= displaysList.size()) goto L9;
        int displayId = displaysList.get(i).getDisplayId();
        MagnificationConfig config = getMagnificationConfig(displayId);
        pw.println("Magnifier on display#" + displayId);
        pw.append("    " + config).println();
        Region region = new Region();
        getCurrentMagnificationRegion(displayId, region, true);
        if (region.isEmpty() == true) goto L8;
        pw.append("    Magnification region=").append(region.toString()).println();
    L8:
        pw.append("    IdOfLastServiceToMagnify=" + getIdOfLastServiceToMagnify(config.getMode(), displayId)).println();
        dumpTrackingTypingFocusEnabledState(pw, displayId, config.getMode());
        i = i + 1;
        goto L4
    L9:
        pw.append("    SupportWindowMagnification=" + this.mController.supportWindowMagnification()).println();
        pw.append("    WindowMagnificationConnectionState=" + this.mController.getMagnificationConnectionManager().getConnectionState()).println();
    }

    private int getIdOfLastServiceToMagnify(int mode, int displayId) {
        if (mode != 1) goto L6;
        return this.mController.getFullScreenMagnificationController().getIdOfLastServiceToMagnify(displayId);
    L6:
        return this.mController.getMagnificationConnectionManager().getIdOfLastServiceToMagnify(displayId);
    }

    private void dumpTrackingTypingFocusEnabledState(PrintWriter pw, int displayId, int mode) {
        if (mode != 2) goto L6;
        pw.append("    TrackingTypingFocusEnabled=" + this.mController.getMagnificationConnectionManager().isTrackingTypingFocusEnabled(displayId)).println();
        return;
    }
}
