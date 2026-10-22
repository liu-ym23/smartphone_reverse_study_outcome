package com.android.server.display;

import android.content.Context;
import android.os.Handler;
import android.view.Display;
import com.android.server.display.feature.DisplayManagerFlags;
import java.io.PrintWriter;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
abstract class DisplayAdapter {
    public static final int DISPLAY_DEVICE_EVENT_ADDED = 1;
    public static final int DISPLAY_DEVICE_EVENT_CHANGED = 2;
    public static final int DISPLAY_DEVICE_EVENT_REMOVED = 3;
    private static final AtomicInteger NEXT_DISPLAY_MODE_ID = null;
    private final Context mContext;
    private final DisplayManagerFlags mFeatureFlags;
    private final Handler mHandler;
    private final Listener mListener;
    private final String mName;
    private final DisplayManagerService.SyncRoot mSyncRoot;

    public interface Listener {
        void onDisplayDeviceEvent(DisplayDevice r1, int r2);

        void onTraversalRequested();
    }

    public static /* synthetic */ void $r8$lambda$9V0Zb4R5pN2d6Ym6JsffUDuLT04(DisplayAdapter r0) {
        r0.lambda$sendTraversalRequestLocked$1();
    }

    /* JADX INFO: renamed from: $r8$lambda$m53kLy5P6p-BQH88mDK_wnWdYlc, reason: not valid java name */
    public static /* synthetic */ void m3612$r8$lambda$m53kLy5P6pBQH88mDK_wnWdYlc(DisplayAdapter r0, DisplayDevice r1, int r2) {
        r0.lambda$sendDisplayDeviceEventLocked$0(r1, r2);
    }

    static {
        NEXT_DISPLAY_MODE_ID = new AtomicInteger(1);
    }

    DisplayAdapter(DisplayManagerService.SyncRoot syncRoot, Context context, Handler handler, Listener listener, String name, DisplayManagerFlags featureFlags) {
        this.mSyncRoot = syncRoot;
        this.mContext = context;
        this.mHandler = handler;
        this.mListener = listener;
        this.mName = name;
        this.mFeatureFlags = featureFlags;
    }

    public final DisplayManagerService.SyncRoot getSyncRoot() {
        return this.mSyncRoot;
    }

    public final Context getContext() {
        return this.mContext;
    }

    public final Handler getHandler() {
        return this.mHandler;
    }

    public final String getName() {
        return this.mName;
    }

    public final DisplayManagerFlags getFeatureFlags() {
        return this.mFeatureFlags;
    }

    public void registerLocked() {
    }

    public void dumpLocked(PrintWriter pw) {
    }

    private /* synthetic */ void lambda$sendDisplayDeviceEventLocked$0(DisplayDevice device, int event) {
        this.mListener.onDisplayDeviceEvent(device, event);
    }

    protected final void sendDisplayDeviceEventLocked(final DisplayDevice device, final int event) {
        this.mHandler.post(new DisplayAdapter$$ExternalSyntheticLambda1(this, device, event));
    }

    private /* synthetic */ void lambda$sendTraversalRequestLocked$1() {
        this.mListener.onTraversalRequested();
    }

    protected final void sendTraversalRequestLocked() {
        this.mHandler.post(new DisplayAdapter$$ExternalSyntheticLambda0(this));
    }

    public static Display.Mode createMode(int width, int height, float refreshRate) {
        return createMode(width, height, refreshRate, refreshRate, new float[0], new int[0]);
    }

    public static Display.Mode createMode(int width, int height, float refreshRate, float vsyncRate, float[] alternativeRefreshRates, int[] supportedHdrTypes) {
        return new Display.Mode(NEXT_DISPLAY_MODE_ID.getAndIncrement(), width, height, refreshRate, vsyncRate, false, alternativeRefreshRates, supportedHdrTypes);
    }

    static int getPowerModeForState(int state) {
        switch(state) {
            case 1: goto L11;
            case 2: goto L3;
            case 3: goto L9;
            case 4: goto L7;
            case 5: goto L3;
            case 6: goto L5;
            default: goto L3;
        };
    L3:
        return 2;
    L5:
        return 4;
    L7:
        return 3;
    L9:
        return 1;
    L11:
        return 0;
    }
}
