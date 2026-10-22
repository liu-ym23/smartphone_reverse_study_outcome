package com.android.server.display;

import android.R;
import android.app.BroadcastOptions;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.hardware.display.WifiDisplay;
import android.hardware.display.WifiDisplaySessionInfo;
import android.hardware.display.WifiDisplayStatus;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.UserHandle;
import android.util.Slog;
import android.view.Display;
import android.view.DisplayAddress;
import android.view.DisplayShape;
import android.view.Surface;
import android.view.SurfaceControl;
import com.android.internal.util.DumpUtils;
import com.android.internal.util.IndentingPrintWriter;
import com.android.server.display.feature.DisplayManagerFlags;
import com.android.server.display.utils.DebugUtils;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
final class WifiDisplayAdapter extends DisplayAdapter {
    private static final String ACTION_DISCONNECT = "android.server.display.wfd.DISCONNECT";
    private static final boolean DEBUG = false;
    private static final String DISPLAY_NAME_PREFIX = "wifi:";
    private static final int MSG_SEND_STATUS_CHANGE_BROADCAST = 1;
    private static final String TAG = "WifiDisplayAdapter";
    private WifiDisplay mActiveDisplay;
    private int mActiveDisplayState;
    private WifiDisplay[] mAvailableDisplays;
    private final BroadcastReceiver mBroadcastReceiver;
    private WifiDisplayStatus mCurrentStatus;
    private WifiDisplayController mDisplayController;
    private WifiDisplayDevice mDisplayDevice;
    private WifiDisplay[] mDisplays;
    private int mFeatureState;
    private final WifiDisplayHandler mHandler;
    private boolean mPendingStatusChangeBroadcast;
    private final PersistentDataStore mPersistentDataStore;
    private WifiDisplay[] mRememberedDisplays;
    private int mScanState;
    private WifiDisplaySessionInfo mSessionInfo;
    private final boolean mSupportsProtectedBuffers;
    private final WifiDisplayController.Listener mWifiDisplayListener;

    private final class WifiDisplayDevice extends DisplayDevice {
        private final DisplayAddress mAddress;
        private final int mFlags;
        private final int mHeight;
        private DisplayDeviceInfo mInfo;
        private final Display.Mode mMode;
        private String mName;
        private final float mRefreshRate;
        private Surface mSurface;
        private final int mWidth;
        final /* synthetic */ WifiDisplayAdapter this$0;

        public WifiDisplayDevice(WifiDisplayAdapter r3, IBinder displayToken, String name, int width, int height, float refreshRate, int flags, String address, Surface surface) {
            this.this$0 = r3;
            super(r3, displayToken, WifiDisplayAdapter.DISPLAY_NAME_PREFIX + address, r3.getContext());
            this.mName = name;
            this.mWidth = width;
            this.mHeight = height;
            this.mRefreshRate = refreshRate;
            this.mFlags = flags;
            this.mAddress = DisplayAddress.fromMacAddress(address);
            this.mSurface = surface;
            this.mMode = DisplayAdapter.createMode(width, height, refreshRate);
        }

        @Override // com.android.server.display.DisplayDevice
        public boolean hasStableUniqueId() {
            return true;
        }

        public void destroyLocked() {
            if (this.mSurface == null) goto L5;
            this.mSurface.release();
            this.mSurface = null;
        L5:
            DisplayControl.destroyVirtualDisplay(getDisplayTokenLocked());
        }

        public void setNameLocked(String name) {
            this.mName = name;
            this.mInfo = null;
        }

        @Override // com.android.server.display.DisplayDevice
        public void configureSurfaceLocked(SurfaceControl.Transaction t) {
            if (this.mSurface == null) goto L6;
            setSurfaceLocked(t, this.mSurface);
            return;
        }

        @Override // com.android.server.display.DisplayDevice
        public DisplayDeviceInfo getDisplayDeviceInfoLocked() {
            if (this.mInfo != null) goto L9;
            this.mInfo = new DisplayDeviceInfo();
            this.mInfo.name = this.mName;
            this.mInfo.uniqueId = getUniqueId();
            this.mInfo.width = this.mWidth;
            this.mInfo.height = this.mHeight;
            this.mInfo.modeId = this.mMode.getModeId();
            this.mInfo.renderFrameRate = this.mMode.getRefreshRate();
            this.mInfo.defaultModeId = this.mMode.getModeId();
            this.mInfo.supportedModes = new Display.Mode[]{this.mMode};
            this.mInfo.presentationDeadlineNanos = 1000000000 / ((long) ((int) this.mRefreshRate));
            this.mInfo.flags = this.mFlags;
            this.mInfo.type = 3;
            this.mInfo.address = this.mAddress;
            this.mInfo.touch = 2;
            this.mInfo.setAssumedDensityForExternalDisplay(this.mWidth, this.mHeight);
            this.mInfo.flags |= 8192;
            if (this.this$0.getFeatureFlags().isDisplayContentModeManagementEnabled() == false) goto L7;
            this.mInfo.flags |= 1048576;
        L7:
            this.mInfo.displayShape = DisplayShape.createDefaultDisplayShape(this.mInfo.width, this.mInfo.height, false);
        L9:
            return this.mInfo;
        }
    }

    private final class WifiDisplayHandler extends Handler {
        final /* synthetic */ WifiDisplayAdapter this$0;

        public WifiDisplayHandler(WifiDisplayAdapter r2, Looper looper) {
            this.this$0 = r2;
            super(looper, null, true);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            switch(msg.what) {
                case 1: goto L5;
                default: goto L7;
            };
        L5:
            WifiDisplayAdapter.m3922$$Nest$mhandleSendStatusChangeBroadcast(this.this$0);
            return;
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmActiveDisplay, reason: not valid java name */
    static /* bridge */ /* synthetic */ WifiDisplay m3903$$Nest$fgetmActiveDisplay(WifiDisplayAdapter r0) {
        return r0.mActiveDisplay;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmActiveDisplayState, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m3904$$Nest$fgetmActiveDisplayState(WifiDisplayAdapter r0) {
        return r0.mActiveDisplayState;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAvailableDisplays, reason: not valid java name */
    static /* bridge */ /* synthetic */ WifiDisplay[] m3905$$Nest$fgetmAvailableDisplays(WifiDisplayAdapter r0) {
        return r0.mAvailableDisplays;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmBroadcastReceiver, reason: not valid java name */
    static /* bridge */ /* synthetic */ BroadcastReceiver m3906$$Nest$fgetmBroadcastReceiver(WifiDisplayAdapter r0) {
        return r0.mBroadcastReceiver;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDisplayController, reason: not valid java name */
    static /* bridge */ /* synthetic */ WifiDisplayController m3907$$Nest$fgetmDisplayController(WifiDisplayAdapter r0) {
        return r0.mDisplayController;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmFeatureState, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m3908$$Nest$fgetmFeatureState(WifiDisplayAdapter r0) {
        return r0.mFeatureState;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ WifiDisplayHandler m3909$$Nest$fgetmHandler(WifiDisplayAdapter r0) {
        return r0.mHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPersistentDataStore, reason: not valid java name */
    static /* bridge */ /* synthetic */ PersistentDataStore m3910$$Nest$fgetmPersistentDataStore(WifiDisplayAdapter r0) {
        return r0.mPersistentDataStore;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmScanState, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m3911$$Nest$fgetmScanState(WifiDisplayAdapter r0) {
        return r0.mScanState;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmWifiDisplayListener, reason: not valid java name */
    static /* bridge */ /* synthetic */ WifiDisplayController.Listener m3912$$Nest$fgetmWifiDisplayListener(WifiDisplayAdapter r0) {
        return r0.mWifiDisplayListener;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmActiveDisplay, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3913$$Nest$fputmActiveDisplay(WifiDisplayAdapter r0, WifiDisplay r1) {
        r0.mActiveDisplay = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmActiveDisplayState, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3914$$Nest$fputmActiveDisplayState(WifiDisplayAdapter r0, int r1) {
        r0.mActiveDisplayState = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmAvailableDisplays, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3915$$Nest$fputmAvailableDisplays(WifiDisplayAdapter r0, WifiDisplay[] r1) {
        r0.mAvailableDisplays = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmDisplayController, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3916$$Nest$fputmDisplayController(WifiDisplayAdapter r0, WifiDisplayController r1) {
        r0.mDisplayController = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmFeatureState, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3917$$Nest$fputmFeatureState(WifiDisplayAdapter r0, int r1) {
        r0.mFeatureState = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmScanState, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3918$$Nest$fputmScanState(WifiDisplayAdapter r0, int r1) {
        r0.mScanState = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmSessionInfo, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3919$$Nest$fputmSessionInfo(WifiDisplayAdapter r0, WifiDisplaySessionInfo r1) {
        r0.mSessionInfo = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$maddDisplayDeviceLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3920$$Nest$maddDisplayDeviceLocked(WifiDisplayAdapter r0, WifiDisplay r1, Surface r2, int r3, int r4, int r5) {
        r0.addDisplayDeviceLocked(r1, r2, r3, r4, r5);
    }

    /* JADX INFO: renamed from: -$$Nest$mfixRememberedDisplayNamesFromAvailableDisplaysLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3921$$Nest$mfixRememberedDisplayNamesFromAvailableDisplaysLocked(WifiDisplayAdapter r0) {
        r0.fixRememberedDisplayNamesFromAvailableDisplaysLocked();
    }

    /* JADX INFO: renamed from: -$$Nest$mhandleSendStatusChangeBroadcast, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3922$$Nest$mhandleSendStatusChangeBroadcast(WifiDisplayAdapter r0) {
        r0.handleSendStatusChangeBroadcast();
    }

    /* JADX INFO: renamed from: -$$Nest$mremoveDisplayDeviceLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3923$$Nest$mremoveDisplayDeviceLocked(WifiDisplayAdapter r0) {
        r0.removeDisplayDeviceLocked();
    }

    /* JADX INFO: renamed from: -$$Nest$mrenameDisplayDeviceLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3924$$Nest$mrenameDisplayDeviceLocked(WifiDisplayAdapter r0, String r1) {
        r0.renameDisplayDeviceLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mscheduleStatusChangedBroadcastLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3925$$Nest$mscheduleStatusChangedBroadcastLocked(WifiDisplayAdapter r0) {
        r0.scheduleStatusChangedBroadcastLocked();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateDisplaysLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3926$$Nest$mupdateDisplaysLocked(WifiDisplayAdapter r0) {
        r0.updateDisplaysLocked();
    }

    static {
        DEBUG = DebugUtils.isDebuggable(TAG);
    }

    public WifiDisplayAdapter(DisplayManagerService.SyncRoot syncRoot, Context context, Handler handler, DisplayAdapter.Listener listener, PersistentDataStore persistentDataStore, DisplayManagerFlags featureFlags) {
        super(syncRoot, context, handler, listener, TAG, featureFlags);
        this.mDisplays = WifiDisplay.EMPTY_ARRAY;
        this.mAvailableDisplays = WifiDisplay.EMPTY_ARRAY;
        this.mRememberedDisplays = WifiDisplay.EMPTY_ARRAY;
        this.mBroadcastReceiver = new AnonymousClass8(this);
        this.mWifiDisplayListener = new AnonymousClass9(this);
        if (context.getPackageManager().hasSystemFeature("android.hardware.wifi.direct") == false) goto L7;
        this.mHandler = new WifiDisplayHandler(this, handler.getLooper());
        this.mPersistentDataStore = persistentDataStore;
        this.mSupportsProtectedBuffers = context.getResources().getBoolean(R.bool.config_wlan_data_service_conn_persistence_on_restart);
        return;
    L7:
        throw new RuntimeException("WiFi display was requested, but there is no WiFi Direct feature");
    }

    @Override // com.android.server.display.DisplayAdapter
    public void dumpLocked(PrintWriter pw) {
        super.dumpLocked(pw);
        pw.println("mCurrentStatus=" + getWifiDisplayStatusLocked());
        pw.println("mFeatureState=" + this.mFeatureState);
        pw.println("mScanState=" + this.mScanState);
        pw.println("mActiveDisplayState=" + this.mActiveDisplayState);
        pw.println("mActiveDisplay=" + this.mActiveDisplay);
        pw.println("mDisplays=" + Arrays.toString(this.mDisplays));
        pw.println("mAvailableDisplays=" + Arrays.toString(this.mAvailableDisplays));
        pw.println("mRememberedDisplays=" + Arrays.toString(this.mRememberedDisplays));
        pw.println("mPendingStatusChangeBroadcast=" + this.mPendingStatusChangeBroadcast);
        pw.println("mSupportsProtectedBuffers=" + this.mSupportsProtectedBuffers);
        if (this.mDisplayController != null) goto L5;
        pw.println("mDisplayController=null");
        return;
    L5:
        pw.println("mDisplayController:");
        IndentingPrintWriter ipw = new IndentingPrintWriter(pw, "  ");
        ipw.increaseIndent();
        DumpUtils.dumpAsync(getHandler(), this.mDisplayController, ipw, "", 200);
    }

    @Override // com.android.server.display.DisplayAdapter
    public void registerLocked() {
        super.registerLocked();
        updateRememberedDisplaysLocked();
        getHandler().post(new AnonymousClass1(this));
    }

    public void requestStartScanLocked() {
        if (DEBUG == false) goto L5;
        Slog.d(TAG, "requestStartScanLocked");
    L5:
        getHandler().post(new AnonymousClass2(this));
    }

    public void requestStopScanLocked() {
        if (DEBUG == false) goto L5;
        Slog.d(TAG, "requestStopScanLocked");
    L5:
        getHandler().post(new AnonymousClass3(this));
    }

    public void requestConnectLocked(final String address) {
        if (DEBUG == false) goto L5;
        Slog.d(TAG, "requestConnectLocked: address=" + address);
    L5:
        getHandler().post(new AnonymousClass4(this, address));
    }

    public void requestPauseLocked() {
        if (DEBUG == false) goto L5;
        Slog.d(TAG, "requestPauseLocked");
    L5:
        getHandler().post(new AnonymousClass5(this));
    }

    public void requestResumeLocked() {
        if (DEBUG == false) goto L5;
        Slog.d(TAG, "requestResumeLocked");
    L5:
        getHandler().post(new AnonymousClass6(this));
    }

    public void requestDisconnectLocked() {
        if (DEBUG == false) goto L5;
        Slog.d(TAG, "requestDisconnectedLocked");
    L5:
        getHandler().post(new AnonymousClass7(this));
    }

    public void requestRenameLocked(String address, String alias) {
        if (DEBUG == false) goto L5;
        Slog.d(TAG, "requestRenameLocked: address=" + address + ", alias=" + alias);
    L5:
        if (alias == null) goto L13;
        String alias2 = alias.trim();
        if (alias2.isEmpty() == false) goto L9;
    L12:
        String alias3 = null;
    L14:
        WifiDisplay display = this.mPersistentDataStore.getRememberedWifiDisplay(address);
        if (display != null) goto L17;
    L21:
        String address2 = address;
    L23:
        if (this.mActiveDisplay != null) goto L25;
        return;
    L25:
        if (this.mActiveDisplay.getDeviceAddress().equals(address2) == false) goto L29;
        renameDisplayDeviceLocked(this.mActiveDisplay.getFriendlyDisplayName());
        return;
    L29:
        return;
    L17:
        if (Objects.equals(display.getDeviceAlias(), alias3) == true) goto L21;
        address2 = address;
        if (this.mPersistentDataStore.rememberWifiDisplay(new WifiDisplay(address2, display.getDeviceName(), alias3, false, false, false)) == false) goto L23;
        this.mPersistentDataStore.saveIfNeeded();
        updateRememberedDisplaysLocked();
        scheduleStatusChangedBroadcastLocked();
        goto L23
    L9:
        if (alias2.equals(address) == true) goto L12;
        alias3 = alias2;
        goto L14
    L13:
        alias3 = alias;
        goto L14
    }

    public void requestForgetLocked(String address) {
        if (DEBUG == false) goto L6;
        Slog.d(TAG, "requestForgetLocked: address=" + address);
    L6:
        if (this.mPersistentDataStore.forgetWifiDisplay(address) == false) goto L9;
        this.mPersistentDataStore.saveIfNeeded();
        updateRememberedDisplaysLocked();
        scheduleStatusChangedBroadcastLocked();
    L9:
        if (this.mActiveDisplay != null) goto L11;
        return;
    L11:
        if (this.mActiveDisplay.getDeviceAddress().equals(address) == false) goto L15;
        requestDisconnectLocked();
        return;
    }

    public WifiDisplayStatus getWifiDisplayStatusLocked() {
        if (this.mCurrentStatus != null) goto L6;
        this.mCurrentStatus = new WifiDisplayStatus(this.mFeatureState, this.mScanState, this.mActiveDisplayState, this.mActiveDisplay, this.mDisplays, this.mSessionInfo);
    L6:
        if (DEBUG == false) goto L9;
        Slog.d(TAG, "getWifiDisplayStatusLocked: result=" + this.mCurrentStatus);
    L9:
        return this.mCurrentStatus;
    }

    private void updateDisplaysLocked() {
        List<WifiDisplay> displays = new ArrayList(this.mAvailableDisplays.length + this.mRememberedDisplays.length);
        boolean[] remembered = new boolean[this.mAvailableDisplays.length];
        WifiDisplay[] r2 = this.mRememberedDisplays;
        int r3 = r2.length;
        int r4 = 0;
    L3:
        if (r4 >= r3) goto L14;
        WifiDisplay d = r2[r4];
        boolean available = false;
        int i = 0;
    L6:
        if (i >= this.mAvailableDisplays.length) goto L11;
        if (d.equals(this.mAvailableDisplays[i]) == true) goto L9;
        i = i + 1;
        goto L6
    L9:
        available = true;
        remembered[i] = true;
    L11:
        if (available == true) goto L13;
        displays.add(new WifiDisplay(d.getDeviceAddress(), d.getDeviceName(), d.getDeviceAlias(), false, false, true));
    L13:
        r4 = r4 + 1;
        goto L3
    L14:
        int i2 = 0;
    L16:
        if (i2 >= this.mAvailableDisplays.length) goto L18;
        WifiDisplay d2 = this.mAvailableDisplays[i2];
        displays.add(new WifiDisplay(d2.getDeviceAddress(), d2.getDeviceName(), d2.getDeviceAlias(), true, d2.canConnect(), remembered[i2]));
        i2 = i2 + 1;
        goto L16
    L18:
        this.mDisplays = (WifiDisplay[]) displays.toArray(WifiDisplay.EMPTY_ARRAY);
    }

    private void updateRememberedDisplaysLocked() {
        this.mRememberedDisplays = this.mPersistentDataStore.getRememberedWifiDisplays();
        this.mActiveDisplay = this.mPersistentDataStore.applyWifiDisplayAlias(this.mActiveDisplay);
        this.mAvailableDisplays = this.mPersistentDataStore.applyWifiDisplayAliases(this.mAvailableDisplays);
        updateDisplaysLocked();
    }

    private void fixRememberedDisplayNamesFromAvailableDisplaysLocked() {
        boolean changed = false;
        int i = 0;
    L4:
        if (i >= this.mRememberedDisplays.length) goto L15;
        WifiDisplay rememberedDisplay = this.mRememberedDisplays[i];
        WifiDisplay availableDisplay = findAvailableDisplayLocked(rememberedDisplay.getDeviceAddress());
        if (availableDisplay == null) goto L13;
        if (rememberedDisplay.equals(availableDisplay) == true) goto L13;
        if (DEBUG == false) goto L12;
        Slog.d(TAG, "fixRememberedDisplayNamesFromAvailableDisplaysLocked: updating remembered display to " + availableDisplay);
    L12:
        this.mRememberedDisplays[i] = availableDisplay;
        changed = changed | this.mPersistentDataStore.rememberWifiDisplay(availableDisplay);
    L13:
        i = i + 1;
        goto L4
    L15:
        if (changed == false) goto L22;
        this.mPersistentDataStore.saveIfNeeded();
        return;
    }

    private WifiDisplay findAvailableDisplayLocked(String address) {
        WifiDisplay[] r0 = this.mAvailableDisplays;
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L8;
        WifiDisplay display = r0[r2];
        if (display.getDeviceAddress().equals(address) == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return display;
    L8:
        return null;
    }

    private void addDisplayDeviceLocked(WifiDisplay display, Surface surface, int width, int height, int flags) {
        removeDisplayDeviceLocked();
        if (this.mPersistentDataStore.rememberWifiDisplay(display) == false) goto L6;
        this.mPersistentDataStore.saveIfNeeded();
        updateRememberedDisplaysLocked();
        scheduleStatusChangedBroadcastLocked();
    L6:
        if ((flags & 1) == 0) goto L8;
        boolean r0 = true;
    L9:
        boolean secure = r0;
        if (secure == false) goto L15;
        int deviceFlags = 64 | 4;
        if (this.mSupportsProtectedBuffers == false) goto L14;
        int deviceFlags2 = deviceFlags | 8;
    L16:
        String name = display.getFriendlyDisplayName();
        String address = display.getDeviceAddress();
        IBinder displayToken = DisplayControl.createVirtualDisplay(name, secure);
        this.mDisplayDevice = new WifiDisplayDevice(this, displayToken, name, width, height, 60.0f, deviceFlags2, address, surface);
        sendDisplayDeviceEventLocked(this.mDisplayDevice, 1);
        return;
    L14:
        deviceFlags2 = deviceFlags;
        goto L16
    L15:
        deviceFlags2 = 64;
        goto L16
    L8:
        r0 = false;
        goto L9
    }

    private void removeDisplayDeviceLocked() {
        if (this.mDisplayDevice == null) goto L6;
        this.mDisplayDevice.destroyLocked();
        sendDisplayDeviceEventLocked(this.mDisplayDevice, 3);
        this.mDisplayDevice = null;
        return;
    }

    private void renameDisplayDeviceLocked(String name) {
        if (this.mDisplayDevice != null) goto L5;
        return;
    L5:
        if (this.mDisplayDevice.getNameLocked().equals(name) == true) goto L9;
        this.mDisplayDevice.setNameLocked(name);
        sendDisplayDeviceEventLocked(this.mDisplayDevice, 2);
        return;
    }

    private void scheduleStatusChangedBroadcastLocked() {
        this.mCurrentStatus = null;
        if (this.mPendingStatusChangeBroadcast == true) goto L6;
        this.mPendingStatusChangeBroadcast = true;
        this.mHandler.sendEmptyMessage(1);
        return;
    }

    private void handleSendStatusChangeBroadcast() {
        DisplayManagerService.SyncRoot r0 = getSyncRoot();
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mPendingStatusChangeBroadcast == true) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        this.mPendingStatusChangeBroadcast = false;     // Catch: Throwable -> L8
        Intent intent = new Intent("android.hardware.display.action.WIFI_DISPLAY_STATUS_CHANGED");     // Catch: Throwable -> L8
        intent.addFlags(1073741824);     // Catch: Throwable -> L8
        intent.putExtra("android.hardware.display.extra.WIFI_DISPLAY_STATUS", getWifiDisplayStatusLocked());     // Catch: Throwable -> L8
        BroadcastOptions options = BroadcastOptions.makeBasic();     // Catch: Throwable -> L8
        options.setDeliveryGroupPolicy(1);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        getContext().sendBroadcastAsUser(intent, UserHandle.ALL, null, options.toBundle());
    }
}
