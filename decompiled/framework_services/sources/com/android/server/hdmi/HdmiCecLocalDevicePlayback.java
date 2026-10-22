package com.android.server.hdmi;

import android.R;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.hardware.hdmi.HdmiDeviceInfo;
import android.hardware.hdmi.IHdmiControlCallback;
import android.os.Binder;
import android.os.Handler;
import android.os.SystemProperties;
import android.sysprop.HdmiProperties;
import android.util.Slog;
import com.android.internal.app.LocalePicker;
import com.android.internal.util.IndentingPrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ArrayBlockingQueue;
import org.apache.commons.compress.utils.CharsetNames;

/* JADX INFO: loaded from: classes2.dex */
public class HdmiCecLocalDevicePlayback extends HdmiCecLocalDeviceSource {
    static final long POPUP_AFTER_ACTIVE_SOURCE_LOST_DELAY_MS = 5000;
    static final long STANDBY_AFTER_ACTIVE_SOURCE_LOST_DELAY_MS = 30000;
    static final long STANDBY_AFTER_HOTPLUG_OUT_DELAY_MS = 30000;
    private static final String TAG = "HdmiCecLocalDevicePlayback";
    private Handler mDelayedPopupOnActiveSourceLostHandler;
    private Handler mDelayedStandbyHandler;
    Handler mDelayedStandbyOnActiveSourceLostHandler;
    private boolean mIsActiveSourceLostPopupLaunched;
    protected HdmiProperties.playback_device_action_on_routing_control_values mPlaybackDeviceActionOnRoutingControl;
    private ActiveWakeLock mWakeLock;

    /* JADX INFO: renamed from: com.android.server.hdmi.HdmiCecLocalDevicePlayback$7, reason: invalid class name */
    static /* synthetic */ class AnonymousClass7 {
        static final /* synthetic */ int[] $SwitchMap$android$sysprop$HdmiProperties$playback_device_action_on_routing_control_values = null;

        static {
            $SwitchMap$android$sysprop$HdmiProperties$playback_device_action_on_routing_control_values = new int[HdmiProperties.playback_device_action_on_routing_control_values.values().length];
            $SwitchMap$android$sysprop$HdmiProperties$playback_device_action_on_routing_control_values[HdmiProperties.playback_device_action_on_routing_control_values.WAKE_UP_AND_SEND_ACTIVE_SOURCE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L5
        L17:
            $SwitchMap$android$sysprop$HdmiProperties$playback_device_action_on_routing_control_values[HdmiProperties.playback_device_action_on_routing_control_values.WAKE_UP_ONLY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L13:
            $SwitchMap$android$sysprop$HdmiProperties$playback_device_action_on_routing_control_values[HdmiProperties.playback_device_action_on_routing_control_values.NONE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    private interface ActiveWakeLock {
        void acquire();

        boolean isHeld();

        void release();
    }

    private class DelayedStandbyOnActiveSourceLostRunnable implements Runnable {
        final /* synthetic */ HdmiCecLocalDevicePlayback this$0;

        /* synthetic */ DelayedStandbyOnActiveSourceLostRunnable(HdmiCecLocalDevicePlayback r1, HdmiCecLocalDevicePlaybackIA r2) {
            this(r1);
        }

        private DelayedStandbyOnActiveSourceLostRunnable(HdmiCecLocalDevicePlayback r1) {
            this.this$0 = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.this$0.isActiveSource() == true) goto L6;
            this.this$0.mService.standby();
            HdmiCecLocalDevicePlayback.m4297$$Nest$fputmIsActiveSourceLostPopupLaunched(this.this$0, false);
            return;
        }
    }

    private class DelayedStandbyRunnable implements Runnable {
        final /* synthetic */ HdmiCecLocalDevicePlayback this$0;

        /* synthetic */ DelayedStandbyRunnable(HdmiCecLocalDevicePlayback r1, HdmiCecLocalDevicePlaybackIA r2) {
            this(r1);
        }

        private DelayedStandbyRunnable(HdmiCecLocalDevicePlayback r1) {
            this.this$0 = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.this$0.mService.getPowerManagerInternal().wasDeviceIdleFor(30000) == false) goto L5;
            this.this$0.mService.standby();
            return;
        L5:
            HdmiCecLocalDevicePlayback.m4296$$Nest$fgetmDelayedStandbyHandler(this.this$0).postDelayed(new DelayedStandbyRunnable(this.this$0), 30000);
        }
    }

    private class SystemWakeLock implements ActiveWakeLock {
        private final WakeLockWrapper mWakeLock;
        final /* synthetic */ HdmiCecLocalDevicePlayback this$0;

        public SystemWakeLock(HdmiCecLocalDevicePlayback r3) {
            this.this$0 = r3;
            this.mWakeLock = r3.mService.getPowerManager().newWakeLock(1, HdmiCecLocalDevicePlayback.TAG);
            this.mWakeLock.setReferenceCounted(false);
        }

        @Override // com.android.server.hdmi.HdmiCecLocalDevicePlayback.ActiveWakeLock
        public void acquire() {
            this.mWakeLock.acquire();
            HdmiLogger.debug("active source: %b. Wake lock acquired", new Object[]{Boolean.valueOf(this.this$0.isActiveSource())});
        }

        @Override // com.android.server.hdmi.HdmiCecLocalDevicePlayback.ActiveWakeLock
        public void release() {
            this.mWakeLock.release();
            HdmiLogger.debug("Wake lock released", new Object[0]);
        }

        @Override // com.android.server.hdmi.HdmiCecLocalDevicePlayback.ActiveWakeLock
        public boolean isHeld() {
            return this.mWakeLock.isHeld();
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDelayedStandbyHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m4296$$Nest$fgetmDelayedStandbyHandler(HdmiCecLocalDevicePlayback r0) {
        return r0.mDelayedStandbyHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmIsActiveSourceLostPopupLaunched, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4297$$Nest$fputmIsActiveSourceLostPopupLaunched(HdmiCecLocalDevicePlayback r0, boolean r1) {
        r0.mIsActiveSourceLostPopupLaunched = r1;
    }

    @Override // com.android.server.hdmi.HdmiCecLocalDevice
    public /* bridge */ /* synthetic */ ArrayBlockingQueue getActiveSourceHistory() {
        return super.getActiveSourceHistory();
    }

    @Override // com.android.server.hdmi.HdmiCecLocalDevice
    @HdmiAnnotations.ServiceThreadOnly
    public /* bridge */ /* synthetic */ void invokeStandbyCompletedCallback(HdmiCecLocalDevice.StandbyCompletedCallback r1) {
        super.invokeStandbyCompletedCallback(r1);
    }

    HdmiCecLocalDevicePlayback(HdmiControlService service) {
        super(service, 4);
        this.mPlaybackDeviceActionOnRoutingControl = (HdmiProperties.playback_device_action_on_routing_control_values) HdmiProperties.playback_device_action_on_routing_control().orElse(HdmiProperties.playback_device_action_on_routing_control_values.NONE);
        this.mDelayedStandbyHandler = new Handler(service.getServiceLooper());
        this.mDelayedStandbyOnActiveSourceLostHandler = new Handler(service.getServiceLooper());
        this.mDelayedPopupOnActiveSourceLostHandler = new Handler(service.getServiceLooper());
        this.mStandbyHandler = new HdmiCecStandbyModeHandler(service, this);
        this.mIsActiveSourceLostPopupLaunched = false;
    }

    @Override // com.android.server.hdmi.HdmiCecLocalDevice
    @HdmiAnnotations.ServiceThreadOnly
    protected void onAddressAllocated(int logicalAddress, int reason) {
        assertRunOnServiceThread();
        if (reason != 0) goto L5;
        this.mService.setAndBroadcastActiveSource(this.mService.getPhysicalAddress(), getDeviceInfo().getDeviceType(), 15, "HdmiCecLocalDevicePlayback#onAddressAllocated()");
    L5:
        this.mService.sendCecCommand(HdmiCecMessageBuilder.buildReportPhysicalAddressCommand(getDeviceInfo().getLogicalAddress(), this.mService.getPhysicalAddress(), this.mDeviceType));
        this.mService.sendCecCommand(HdmiCecMessageBuilder.buildDeviceVendorIdCommand(getDeviceInfo().getLogicalAddress(), this.mService.getVendorId()));
        buildAndSendSetOsdName(0);
        if (this.mService.audioSystem() != null) goto L8;
        this.mService.sendCecCommand(HdmiCecMessageBuilder.buildGiveSystemAudioModeStatus(getDeviceInfo().getLogicalAddress(), 5), new AnonymousClass1(this));
    L8:
        launchDeviceDiscovery();
        startQueuedActions();
    }

    @HdmiAnnotations.ServiceThreadOnly
    private void launchDeviceDiscovery() {
        assertRunOnServiceThread();
        clearDeviceInfoList();
        DeviceDiscoveryAction action = new DeviceDiscoveryAction(this, new AnonymousClass2(this));
        addAndStartAction(action, true);
    }

    @Override // com.android.server.hdmi.HdmiCecLocalDevice
    @HdmiAnnotations.ServiceThreadOnly
    protected int getPreferredAddress() {
        assertRunOnServiceThread();
        return SystemProperties.getInt("persist.sys.hdmi.addr.playback", 15);
    }

    @Override // com.android.server.hdmi.HdmiCecLocalDevice
    @HdmiAnnotations.ServiceThreadOnly
    protected void setPreferredAddress(int addr) {
        assertRunOnServiceThread();
        this.mService.writeStringSystemProperty("persist.sys.hdmi.addr.playback", String.valueOf(addr));
    }

    @HdmiAnnotations.ServiceThreadOnly
    void deviceSelect(int id, IHdmiControlCallback callback) {
        assertRunOnServiceThread();
        if (id != getDeviceInfo().getId()) goto L6;
        this.mService.oneTouchPlay(callback);
        return;
    L6:
        HdmiDeviceInfo targetDevice = this.mService.getHdmiCecNetwork().getDeviceInfo(id);
        if (targetDevice != null) goto L10;
        invokeCallback(callback, 3);
        return;
    L10:
        int targetAddress = targetDevice.getLogicalAddress();
        if (isAlreadyActiveSource(targetDevice, targetAddress, callback) == false) goto L14;
        return;
    L14:
        if (this.mService.isCecControlEnabled() == true) goto L17;
        setActiveSource(targetDevice, "HdmiCecLocalDevicePlayback#deviceSelect()");
        invokeCallback(callback, 6);
        return;
    L17:
        List<DeviceSelectActionFromPlayback> actions = getActions(DeviceSelectActionFromPlayback.class);
        if (actions.isEmpty() == true) goto L22;
        DeviceSelectActionFromPlayback action = actions.get(0);
        if (action.getTargetAddress() != targetDevice.getLogicalAddress()) goto L22;
        return;
    L22:
        addAndStartAction(new DeviceSelectActionFromPlayback(this, targetDevice, callback), true);
    }

    @Override // com.android.server.hdmi.HdmiCecLocalDeviceSource, com.android.server.hdmi.HdmiCecLocalDevice
    @HdmiAnnotations.ServiceThreadOnly
    void onHotplug(int portId, boolean connected) {
        assertRunOnServiceThread();
        this.mCecMessageCache.flushAll();
        HdmiCecLocalDevicePlaybackIA r0 = null;
        if (connected == false) goto L5;
        this.mDelayedStandbyHandler.removeCallbacksAndMessages(null);
        return;
    L5:
        getWakeLock().release();
        this.mService.getHdmiCecNetwork().removeDevicesConnectedToPort(portId);
        this.mDelayedStandbyHandler.removeCallbacksAndMessages(null);
        this.mDelayedStandbyHandler.postDelayed(new DelayedStandbyRunnable(this, r0), 30000);
    }

    @HdmiAnnotations.ServiceThreadOnly
    void dismissUiOnActiveSourceStatusRecovered() {
        assertRunOnServiceThread();
        Intent intent = new Intent("android.hardware.hdmi.action.ON_ACTIVE_SOURCE_RECOVERED_DISMISS_UI");
        this.mIsActiveSourceLostPopupLaunched = false;
        this.mService.sendBroadcastAsUser(intent);
    }

    @Override // com.android.server.hdmi.HdmiCecLocalDevice
    @HdmiAnnotations.ServiceThreadOnly
    protected void onStandby(boolean initiatedByCec, int standbyAction, final HdmiCecLocalDevice.StandbyCompletedCallback callback) {
        assertRunOnServiceThread();
        if (this.mService.isCecControlEnabled() == true) goto L6;
        invokeStandbyCompletedCallback(callback);
        return;
    L6:
        boolean wasActiveSource = isActiveSource();
        byte r4 = -1;
        this.mService.setActiveSource(-1, 65535, "HdmiCecLocalDevicePlayback#onStandby()");
        if (wasActiveSource == true) goto L10;
        invokeStandbyCompletedCallback(callback);
        return;
    L10:
        HdmiControlService.SendMessageCallback sendMessageCallback = new AnonymousClass3(this, callback);
        if (initiatedByCec == false) goto L15;
        this.mService.sendCecCommand(HdmiCecMessageBuilder.buildInactiveSource(getDeviceInfo().getLogicalAddress(), this.mService.getPhysicalAddress()), sendMessageCallback);
        return;
    L15:
        switch(standbyAction) {
            case 0: goto L18;
            case 1: goto L17;
            default: goto L41;
        };
    L17:
        this.mService.sendCecCommand(HdmiCecMessageBuilder.buildStandby(getDeviceInfo().getLogicalAddress(), 15), sendMessageCallback);
        return;
    L18:
        String powerControlMode = this.mService.getHdmiCecConfig().getStringValue("power_control_mode");
        switch(powerControlMode.hashCode()) {
            case -1744153479: goto L31;
            case -1618876223: goto L28;
            case 3387192: goto L25;
            case 110530246: goto L22;
            default: goto L33;
        };
    L33:
        switch(r4) {
            case 0: goto L38;
            case 1: goto L37;
            case 2: goto L36;
            case 3: goto L35;
            default: goto L46;
        };
    L35:
        this.mService.sendCecCommand(HdmiCecMessageBuilder.buildInactiveSource(getDeviceInfo().getLogicalAddress(), this.mService.getPhysicalAddress()), sendMessageCallback);
        return;
    L36:
        this.mService.sendCecCommand(HdmiCecMessageBuilder.buildStandby(getDeviceInfo().getLogicalAddress(), 15), sendMessageCallback);
        return;
    L37:
        this.mService.sendCecCommand(HdmiCecMessageBuilder.buildStandby(getDeviceInfo().getLogicalAddress(), 0));
        this.mService.sendCecCommand(HdmiCecMessageBuilder.buildStandby(getDeviceInfo().getLogicalAddress(), 5), sendMessageCallback);
        return;
    L38:
        this.mService.sendCecCommand(HdmiCecMessageBuilder.buildStandby(getDeviceInfo().getLogicalAddress(), 0), sendMessageCallback);
        return;
    L46:
        return;
    L22:
        if (powerControlMode.equals("to_tv") == false) goto L33;
        r4 = 0;
        goto L33
    L25:
        if (powerControlMode.equals("none") == false) goto L33;
        r4 = 3;
        goto L33
    L28:
        if (powerControlMode.equals("broadcast") == false) goto L33;
        r4 = 2;
        goto L33
    L31:
        if (powerControlMode.equals("to_tv_and_audio_system") == false) goto L33;
        r4 = 1;
        goto L33
    }

    @Override // com.android.server.hdmi.HdmiCecLocalDevice
    @HdmiAnnotations.ServiceThreadOnly
    protected void onInitializeCecComplete(int initiatedBy) {
        if (initiatedBy == 2) goto L5;
        return;
    L5:
        String powerControlMode = this.mService.getHdmiCecConfig().getStringValue("power_control_mode");
        if (powerControlMode.equals("none") == false) goto L8;
        return;
    L8:
        oneTouchPlay(new AnonymousClass4(this));
    }

    @Override // com.android.server.hdmi.HdmiCecLocalDeviceSource, com.android.server.hdmi.HdmiCecLocalDevice
    @HdmiAnnotations.ServiceThreadOnly
    protected void setActiveSource(int logicalAddress, int physicalAddress, String caller) {
        assertRunOnServiceThread();
        super.setActiveSource(logicalAddress, physicalAddress, caller);
        if (isActiveSource() == false) goto L5;
        getWakeLock().acquire();
        return;
    L5:
        getWakeLock().release();
    }

    @HdmiAnnotations.ServiceThreadOnly
    private ActiveWakeLock getWakeLock() {
        assertRunOnServiceThread();
        if (this.mWakeLock != null) goto L9;
        if (SystemProperties.getBoolean("persist.sys.hdmi.keep_awake", true) == false) goto L7;
        this.mWakeLock = new SystemWakeLock(this);
        goto L9
    L7:
        this.mWakeLock = new AnonymousClass5(this);
        HdmiLogger.debug("No wakelock is used to keep the display on.", new Object[0]);
    L9:
        return this.mWakeLock;
    }

    @Override // com.android.server.hdmi.HdmiCecLocalDevice
    protected boolean canGoToStandby() {
        return !getWakeLock().isHeld();
    }

    @Override // com.android.server.hdmi.HdmiCecLocalDeviceSource
    @HdmiAnnotations.ServiceThreadOnly
    protected void onActiveSourceLost() {
        assertRunOnServiceThread();
        this.mService.pauseActiveMediaSessions();
        String r0 = this.mService.getHdmiCecConfig().getStringValue("power_state_change_on_active_source_lost");
        switch(r0.hashCode()) {
            case -1129124284: goto L9;
            case 3387192: goto L6;
            default: goto L11;
        };
    L11:
        byte r1 = -1;
    L12:
        switch(r1) {
            case 0: goto L15;
            case 1: goto L14;
            default: goto L13;
        };
    L13:
        return;
    L14:
        return;
    L15:
        this.mDelayedPopupOnActiveSourceLostHandler.removeCallbacksAndMessages(null);
        this.mDelayedPopupOnActiveSourceLostHandler.postDelayed(new AnonymousClass6(this), POPUP_AFTER_ACTIVE_SOURCE_LOST_DELAY_MS);
        return;
    L6:
        if (r0.equals("none") == false) goto L11;
        r1 = 1;
        goto L12
    L9:
        if (r0.equals("standby_now") == false) goto L11;
        r1 = 0;
        goto L12
    }

    @HdmiAnnotations.ServiceThreadOnly
    void startHdmiCecActiveSourceLostActivity() {
        long identity = Binder.clearCallingIdentity();
        Context context = this.mService.getContext();     // Catch: Throwable -> L5 ActivityNotFoundException -> L7
        Intent intent = new Intent();     // Catch: Throwable -> L5 ActivityNotFoundException -> L7
        intent.setComponent(ComponentName.unflattenFromString(context.getResources().getString(R.string.config_qualified_networks_service_class)));     // Catch: Throwable -> L5 ActivityNotFoundException -> L7
        intent.addFlags(268435456);     // Catch: Throwable -> L5 ActivityNotFoundException -> L7
        context.startActivityAsUser(intent, context.getUser());     // Catch: Throwable -> L5 ActivityNotFoundException -> L7
        this.mIsActiveSourceLostPopupLaunched = true;     // Catch: Throwable -> L5 ActivityNotFoundException -> L7
    L4:
        Binder.restoreCallingIdentity(identity);
        return;
    L5:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    L8:
        Slog.e(TAG, "Unable to start HdmiCecActiveSourceLostActivity");     // Catch: Throwable -> L5
        goto L4
    }

    @Override // com.android.server.hdmi.HdmiCecLocalDevice
    @HdmiAnnotations.ServiceThreadOnly
    protected int handleUserControlPressed(HdmiCecMessage message) {
        assertRunOnServiceThread();
        wakeUpIfActiveSource();
        return super.handleUserControlPressed(message);
    }

    @Override // com.android.server.hdmi.HdmiCecLocalDevice
    @HdmiAnnotations.ServiceThreadOnly
    protected int handleSetMenuLanguage(HdmiCecMessage message) {
        assertRunOnServiceThread();
        if (this.mService.getHdmiCecConfig().getIntValue("set_menu_language") != 0) goto L23;
        return 0;
    L23:
        String iso3Language = new String(message.getParams(), 0, 3, CharsetNames.US_ASCII);     // Catch: UnsupportedEncodingException -> L16
        Locale currentLocale = this.mService.getContext().getResources().getConfiguration().locale;     // Catch: UnsupportedEncodingException -> L16
        String curIso3Language = HdmiControlService.localeToMenuLanguage(currentLocale);     // Catch: UnsupportedEncodingException -> L16
        HdmiLogger.debug("handleSetMenuLanguage " + iso3Language + " cur:" + curIso3Language, new Object[0]);     // Catch: UnsupportedEncodingException -> L16
        if (curIso3Language.equals(iso3Language) == false) goto L9;
        return -1;
    L9:
        List<LocalePicker.LocaleInfo> localeInfos = LocalePicker.getAllAssetLocales(this.mService.getContext(), false);     // Catch: UnsupportedEncodingException -> L16
        Iterator<LocalePicker.LocaleInfo> r6 = localeInfos.iterator();     // Catch: UnsupportedEncodingException -> L16
    L11:
        if (r6.hasNext() == false) goto L19;
        LocalePicker.LocaleInfo localeInfo = r6.next();     // Catch: UnsupportedEncodingException -> L16
        if (HdmiControlService.localeToMenuLanguage(localeInfo.getLocale()).equals(iso3Language) == false) goto L11;
        startSetMenuLanguageActivity(localeInfo.getLocale());     // Catch: UnsupportedEncodingException -> L16
        return -1;
    L19:
        Slog.w(TAG, "Can't handle <Set Menu Language> of " + iso3Language);     // Catch: UnsupportedEncodingException -> L16
        return 3;
    L16:
        e = move-exception;
        Slog.w(TAG, "Can't handle <Set Menu Language>", e);
        return 3;
    }

    private void startSetMenuLanguageActivity(Locale locale) {
        long identity = Binder.clearCallingIdentity();
        Context context = this.mService.getContext();     // Catch: Throwable -> L5 ActivityNotFoundException -> L7
        Intent intent = new Intent();     // Catch: Throwable -> L5 ActivityNotFoundException -> L7
        intent.putExtra("android.hardware.hdmi.extra.LOCALE", locale.toLanguageTag());     // Catch: Throwable -> L5 ActivityNotFoundException -> L7
        intent.setComponent(ComponentName.unflattenFromString(context.getResources().getString(R.string.config_qualified_networks_service_package)));     // Catch: Throwable -> L5 ActivityNotFoundException -> L7
        intent.addFlags(268435456);     // Catch: Throwable -> L5 ActivityNotFoundException -> L7
        context.startActivityAsUser(intent, context.getUser());     // Catch: Throwable -> L5 ActivityNotFoundException -> L7
    L4:
        Binder.restoreCallingIdentity(identity);
        return;
    L5:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    L8:
        Slog.e(TAG, "unable to start HdmiCecSetMenuLanguageActivity");     // Catch: Throwable -> L5
        goto L4
    }

    @Override // com.android.server.hdmi.HdmiCecLocalDevice
    protected int handleSetSystemAudioMode(HdmiCecMessage message) {
        if (message.getDestination() == 15) goto L5;
    L13:
        return -1;
    L5:
        if (message.getSource() != 5) goto L13;
        if (this.mService.audioSystem() != null) goto L13;
        boolean setSystemAudioModeOn = HdmiUtils.parseCommandParamSystemAudioStatus(message);
        if (this.mService.isSystemAudioActivated() == setSystemAudioModeOn) goto L12;
        this.mService.setSystemAudioActivated(setSystemAudioModeOn);
    L12:
        return -1;
    }

    @Override // com.android.server.hdmi.HdmiCecLocalDevice
    protected int handleSystemAudioModeStatus(HdmiCecMessage message) {
        if (message.getDestination() == getDeviceInfo().getLogicalAddress()) goto L5;
        return -1;
    L5:
        if (message.getSource() != 5) goto L12;
        boolean setSystemAudioModeOn = HdmiUtils.parseCommandParamSystemAudioStatus(message);
        if (this.mService.isSystemAudioActivated() == setSystemAudioModeOn) goto L13;
        this.mService.setSystemAudioActivated(setSystemAudioModeOn);
        return -1;
    L13:
        return -1;
    L12:
        return -1;
    }

    @Override // com.android.server.hdmi.HdmiCecLocalDeviceSource, com.android.server.hdmi.HdmiCecLocalDevice
    @HdmiAnnotations.ServiceThreadOnly
    protected int handleRoutingChange(HdmiCecMessage message) {
        assertRunOnServiceThread();
        int physicalAddress = HdmiUtils.twoBytesToInt(message.getParams(), 2);
        handleRoutingChangeAndInformation(physicalAddress, message);
        return -1;
    }

    @Override // com.android.server.hdmi.HdmiCecLocalDeviceSource, com.android.server.hdmi.HdmiCecLocalDevice
    @HdmiAnnotations.ServiceThreadOnly
    protected int handleRoutingInformation(HdmiCecMessage message) {
        assertRunOnServiceThread();
        int physicalAddress = HdmiUtils.twoBytesToInt(message.getParams());
        HdmiDeviceInfo sourceDevice = this.mService.getHdmiCecNetwork().getCecDeviceInfo(message.getSource());
        if (sourceDevice != null) goto L5;
    L10:
        handleRoutingChangeAndInformation(physicalAddress, message);
        return -1;
    L5:
        if (sourceDevice.getLogicalAddress() == 0) goto L10;
        if (sourceDevice.getPhysicalAddress() != physicalAddress) goto L10;
        Slog.d(TAG, "<Routing Information> is ignored, it is pointing to the same physical address as the message sender");
        return -1;
    }

    @Override // com.android.server.hdmi.HdmiCecLocalDeviceSource
    @HdmiAnnotations.ServiceThreadOnly
    protected void handleRoutingChangeAndInformation(int physicalAddress, HdmiCecMessage message) {
        assertRunOnServiceThread();
        if (HdmiUtils.isInActiveRoutingPath(this.mService.getPhysicalAddress(), physicalAddress) == false) goto L9;
        if (physicalAddress == 0) goto L9;
        if (isActiveSource() == false) goto L9;
        return;
    L9:
        if (physicalAddress == this.mService.getPhysicalAddress()) goto L13;
        setActiveSource(physicalAddress, "HdmiCecLocalDevicePlayback#handleRoutingChangeAndInformation()");
        return;
    L13:
        if (isActiveSource() == true) goto L15;
        setActiveSource(physicalAddress, "HdmiCecLocalDevicePlayback#handleRoutingChangeAndInformation()");
    L15:
        dismissUiOnActiveSourceStatusRecovered();
        switch(AnonymousClass7.$SwitchMap$android$sysprop$HdmiProperties$playback_device_action_on_routing_control_values[this.mPlaybackDeviceActionOnRoutingControl.ordinal()]) {
            case 1: goto L19;
            case 2: goto L18;
            default: goto L22;
        };
    L18:
        this.mService.wakeUp();
        return;
    L19:
        setAndBroadcastActiveSource(message, physicalAddress, "HdmiCecLocalDevicePlayback#handleRoutingChangeAndInformation()");
        return;
    }

    @Override // com.android.server.hdmi.HdmiCecLocalDevice
    protected void preprocessBufferedMessages(List<HdmiCecMessage> bufferedMessages) {
        Iterator<HdmiCecMessage> r0 = bufferedMessages.iterator();
    L4:
        if (r0.hasNext() == false) goto L15;
        HdmiCecMessage message = r0.next();
        if (message.getOpcode() == 128) goto L13;
        if (message.getOpcode() == 134) goto L13;
        if (message.getOpcode() != 130) goto L4;
    L13:
        removeAction(ActiveSourceAction.class);
        removeAction(OneTouchPlayAction.class);
        return;
    }

    @Override // com.android.server.hdmi.HdmiCecLocalDevice
    protected int findKeyReceiverAddress() {
        return 0;
    }

    @Override // com.android.server.hdmi.HdmiCecLocalDevice
    protected int findAudioReceiverAddress() {
        if (this.mService.isSystemAudioActivated() == false) goto L6;
        return 5;
    L6:
        return 0;
    }

    boolean isActiveSourceLostPopupLaunched() {
        return this.mIsActiveSourceLostPopupLaunched;
    }

    void setIsActiveSourceLostPopupLaunched(boolean isActiveSourceLostPopupLaunched) {
        this.mIsActiveSourceLostPopupLaunched = isActiveSourceLostPopupLaunched;
    }

    @Override // com.android.server.hdmi.HdmiCecLocalDeviceSource, com.android.server.hdmi.HdmiCecLocalDevice
    @HdmiAnnotations.ServiceThreadOnly
    protected void disableDevice(boolean initiatedByCec, HdmiCecLocalDevice.PendingActionClearedCallback callback) {
        assertRunOnServiceThread();
        removeAction(DeviceDiscoveryAction.class);
        removeAction(HotplugDetectionAction.class);
        removeAction(NewDeviceAction.class);
        removeAction(PowerStatusMonitorActionFromPlayback.class);
        removeAction(RequestActiveSourceAction.class);
        super.disableDevice(initiatedByCec, callback);
        clearDeviceInfoList();
        checkIfPendingActionsCleared();
    }

    @Override // com.android.server.hdmi.HdmiCecLocalDevice
    protected void dump(IndentingPrintWriter pw) {
        super.dump(pw);
        pw.println("isActiveSource(): " + isActiveSource());
    }
}
