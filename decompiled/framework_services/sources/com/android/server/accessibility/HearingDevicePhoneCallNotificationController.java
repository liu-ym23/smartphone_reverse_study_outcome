package com.android.server.accessibility;

import android.R;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.bluetooth.BluetoothUuid;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioDeviceAttributes;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.os.Bundle;
import android.telephony.TelephonyCallback;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.android.internal.util.ArrayUtils;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

/* JADX INFO: loaded from: classes.dex */
public class HearingDevicePhoneCallNotificationController {
    private final Executor mCallbackExecutor;
    private final TelephonyCallback mTelephonyListener;
    private final TelephonyManager mTelephonyManager;

    static class CallStateListener extends TelephonyCallback implements TelephonyCallback.CallStateListener {
        private static final String ACTION_BLUETOOTH_DEVICE_DETAILS = "com.android.settings.BLUETOOTH_DEVICE_DETAIL_SETTINGS";
        private static final String ACTION_SWITCH_TO_BUILTIN_MIC = "com.android.server.accessibility.hearingdevice.action.SWITCH_TO_BUILTIN_MIC";
        private static final String ACTION_SWITCH_TO_HEARING_MIC = "com.android.server.accessibility.hearingdevice.action.SWITCH_TO_HEARING_MIC";
        private static final AudioDeviceAttributes BUILTIN_MIC = null;
        private static final String EXTRA_SHOW_FRAGMENT_ARGUMENTS = ":settings:show_fragment_args";
        private static final String KEY_BLUETOOTH_ADDRESS = "device_address";
        private static final int MICROPHONE_SOURCE_VOICE_COMMUNICATION = 7;
        private static final String TAG = "HearingDevice_CallStateListener";
        private AudioManager mAudioManager;
        private final Executor mCommDeviceChangedExecutor;
        private final AudioManager.OnCommunicationDeviceChangedListener mCommDeviceChangedListener;
        private final Context mContext;
        private BluetoothDevice mHearingDevice;
        private BroadcastReceiver mHearingDeviceActionReceiver;
        private boolean mIsCommDeviceChangedRegistered;
        private boolean mIsNotificationShown;
        private NotificationManager mNotificationManager;

        private class HearingDeviceActionReceiver extends BroadcastReceiver {
            final /* synthetic */ CallStateListener this$0;

            /* synthetic */ HearingDeviceActionReceiver(CallStateListener r1, HearingDevicePhoneCallNotificationControllerIA r2) {
                this(r1);
            }

            private HearingDeviceActionReceiver(CallStateListener r1) {
                this.this$0 = r1;
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                String action = intent.getAction();
                if (TextUtils.isEmpty(action) == false) goto L6;
                return;
            L6:
                if (CallStateListener.ACTION_SWITCH_TO_BUILTIN_MIC.equals(action) == false) goto L9;
                CallStateListener.m720$$Nest$mswitchToBuiltinMic(this.this$0);
                CallStateListener.m719$$Nest$mshowNotification(this.this$0, false);
                return;
            L9:
                if (CallStateListener.ACTION_SWITCH_TO_HEARING_MIC.equals(action) == false) goto L13;
                CallStateListener.m721$$Nest$mswitchToHearingMic(this.this$0);
                CallStateListener.m719$$Nest$mshowNotification(this.this$0, true);
                return;
            }
        }

        /* JADX INFO: renamed from: $r8$lambda$8a2Wa2DdipLWj_-n6p0PCH85GjY, reason: not valid java name */
        public static /* synthetic */ void m718$r8$lambda$8a2Wa2DdipLWj_n6p0PCH85GjY(CallStateListener r0, AudioDeviceInfo r1) {
            r0.lambda$new$0(r1);
        }

        public static /* synthetic */ boolean $r8$lambda$N94sfgtU8f4QzmRxLpBL9efKKKE(CallStateListener r0, BluetoothAdapter r1, AudioDeviceInfo r2) {
            return r0.lambda$getSupportedInputHearingDeviceInfo$3(r1, r2);
        }

        public static /* synthetic */ boolean $r8$lambda$qVcMpu0NUKadzzhWodLdFTcnhWY(Set r0, AudioDeviceInfo r1) {
            return lambda$getSupportedInputHearingDeviceInfo$2(r0, r1);
        }

        public static /* synthetic */ boolean $r8$lambda$yjDjB9XWlgvm7k0KRhylDmmWCPg(AudioDeviceInfo r0) {
            return lambda$getSupportedInputHearingDeviceInfo$1(r0);
        }

        /* JADX INFO: renamed from: -$$Nest$mshowNotification, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m719$$Nest$mshowNotification(CallStateListener r0, boolean r1) {
            r0.showNotification(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$mswitchToBuiltinMic, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m720$$Nest$mswitchToBuiltinMic(CallStateListener r0) {
            r0.switchToBuiltinMic();
        }

        /* JADX INFO: renamed from: -$$Nest$mswitchToHearingMic, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m721$$Nest$mswitchToHearingMic(CallStateListener r0) {
            r0.switchToHearingMic();
        }

        static {
            BUILTIN_MIC = new AudioDeviceAttributes(1, 15, "");
        }

        CallStateListener(Context context, Executor executor) {
            this.mIsCommDeviceChangedRegistered = false;
            this.mIsNotificationShown = false;
            this.mContext = context;
            this.mCommDeviceChangedExecutor = executor;
            this.mCommDeviceChangedListener = new HearingDevicePhoneCallNotificationController$CallStateListener$$ExternalSyntheticLambda0(this);
        }

        private /* synthetic */ void lambda$new$0(AudioDeviceInfo device) {
            if (device != null) goto L4;
            return;
        L4:
            this.mHearingDevice = getSupportedInputHearingDeviceInfo(List.of(device));
            if (this.mHearingDevice == null) goto L7;
            showNotificationIfNeeded();
            return;
        L7:
            dismissNotificationIfNeeded();
        }

        @Override // android.telephony.TelephonyCallback.CallStateListener
        public void onCallStateChanged(int state) {
            this.mNotificationManager = (NotificationManager) this.mContext.getSystemService(NotificationManager.class);
            this.mAudioManager = (AudioManager) this.mContext.getSystemService(AudioManager.class);
            if (this.mNotificationManager != null) goto L5;
        L22:
            Log.w(TAG, "NotificationManager or AudioManager is not prepare yet.");
            return;
        L5:
            if (this.mAudioManager == null) goto L22;
            if (state != 0) goto L13;
            removeOnCommunicationDeviceChangedListenerIfNeeded(this.mCommDeviceChangedListener);
            dismissNotificationIfNeeded();
            if (this.mHearingDevice == null) goto L11;
            setMicrophonePreferredForCalls(this.mHearingDevice.isMicrophonePreferredForCalls());
        L11:
            this.mHearingDevice = null;
        L13:
            if (state != 2) goto L24;
            AudioDeviceInfo commDevice = this.mAudioManager.getCommunicationDevice();
            if (commDevice != null) goto L17;
            return;
        L17:
            this.mHearingDevice = getSupportedInputHearingDeviceInfo(List.of(commDevice));
            if (this.mHearingDevice == null) goto L20;
            showNotificationIfNeeded();
            return;
        L20:
            addOnCommunicationDeviceChangedListenerIfNeeded(this.mCommDeviceChangedExecutor, this.mCommDeviceChangedListener);
            return;
        }

        private void addOnCommunicationDeviceChangedListenerIfNeeded(Executor executor, AudioManager.OnCommunicationDeviceChangedListener listener) {
            if (this.mIsCommDeviceChangedRegistered == false) goto L5;
            return;
        L5:
            this.mIsCommDeviceChangedRegistered = true;
            this.mAudioManager.addOnCommunicationDeviceChangedListener(executor, listener);
        }

        private void removeOnCommunicationDeviceChangedListenerIfNeeded(AudioManager.OnCommunicationDeviceChangedListener listener) {
            if (this.mIsCommDeviceChangedRegistered == true) goto L5;
            return;
        L5:
            this.mAudioManager.removeOnCommunicationDeviceChangedListener(listener);
            this.mIsCommDeviceChangedRegistered = false;
        }

        private void showNotificationIfNeeded() {
            if (this.mIsNotificationShown == false) goto L5;
            return;
        L5:
            showNotification(this.mHearingDevice.isMicrophonePreferredForCalls());
            this.mIsNotificationShown = true;
        }

        private void dismissNotificationIfNeeded() {
            if (this.mIsNotificationShown == true) goto L5;
            return;
        L5:
            dismissNotification();
            this.mIsNotificationShown = false;
        }

        private void showNotification(boolean useRemoteMicrophone) {
            this.mNotificationManager.notify(1012, createSwitchInputNotification(useRemoteMicrophone));
            registerReceiverIfNeeded();
        }

        private void dismissNotification() {
            unregisterReceiverIfNeeded();
            this.mNotificationManager.cancel(1012);
        }

        private BluetoothDevice getSupportedInputHearingDeviceInfo(List<AudioDeviceInfo> infoList) {
            final BluetoothAdapter bluetoothAdapter = ((BluetoothManager) this.mContext.getSystemService(BluetoothManager.class)).getAdapter();
            if (bluetoothAdapter != null) goto L6;
            return null;
        L6:
            if (isHapClientSupported() == true) goto L8;
            return null;
        L8:
            final Set<String> inputDeviceAddress = (Set) Arrays.stream(this.mAudioManager.getDevices(1)).map(new HearingDevicePhoneCallNotificationController$CallStateListener$$ExternalSyntheticLambda1()).collect(Collectors.toSet());
            AudioDeviceInfo hearingDeviceInfo = infoList.stream().filter(new HearingDevicePhoneCallNotificationController$CallStateListener$$ExternalSyntheticLambda2()).filter(new HearingDevicePhoneCallNotificationController$CallStateListener$$ExternalSyntheticLambda3(inputDeviceAddress)).filter(new HearingDevicePhoneCallNotificationController$CallStateListener$$ExternalSyntheticLambda4(this, bluetoothAdapter)).findAny().orElse(null);
            if (hearingDeviceInfo != null) goto L12;
            return null;
        L12:
            return bluetoothAdapter.getRemoteDevice(hearingDeviceInfo.getAddress());
        }

        private static /* synthetic */ boolean lambda$getSupportedInputHearingDeviceInfo$1(AudioDeviceInfo info) {
            if (info.getType() != 26) goto L5;
            return true;
        L5:
            return false;
        }

        private static /* synthetic */ boolean lambda$getSupportedInputHearingDeviceInfo$2(Set inputDeviceAddress, AudioDeviceInfo info) {
            return inputDeviceAddress.contains(info.getAddress());
        }

        private /* synthetic */ boolean lambda$getSupportedInputHearingDeviceInfo$3(BluetoothAdapter bluetoothAdapter, AudioDeviceInfo info) {
            return isHapClientDevice(bluetoothAdapter, info);
        }

        boolean isHapClientDevice(BluetoothAdapter bluetoothAdapter, AudioDeviceInfo info) {
            BluetoothDevice device = bluetoothAdapter.getRemoteDevice(info.getAddress());
            return ArrayUtils.contains(device.getUuids(), BluetoothUuid.HAS);
        }

        boolean isHapClientSupported() {
            return BluetoothAdapter.getDefaultAdapter().getSupportedProfiles().contains(28);
        }

        private Notification createSwitchInputNotification(boolean useRemoteMicrophone) {
            CharSequence message = getSwitchInputMessage(useRemoteMicrophone);
            return new Notification.Builder(this.mContext, "ACCESSIBILITY_HEARING_DEVICE").setContentTitle(getSwitchInputTitle(useRemoteMicrophone)).setContentText(message).setSmallIcon(R.drawable.pointer_wait_60).setColor(this.mContext.getResources().getColor(R.color.system_notification_accent_color)).setStyle(new Notification.BigTextStyle().bigText(message)).setLocalOnly(true).setCategory("sys").setContentIntent(createPendingIntent(ACTION_BLUETOOTH_DEVICE_DETAILS)).setActions(new Notification.Action[]{buildSwitchInputAction(useRemoteMicrophone), buildOpenSettingsAction()}).build();
        }

        private Notification.Action buildSwitchInputAction(boolean useRemoteMicrophone) {
            if (useRemoteMicrophone == false) goto L6;
            return new Notification.Action.Builder(null, this.mContext.getString(R.string.input_method_binding_label), createPendingIntent(ACTION_SWITCH_TO_BUILTIN_MIC)).build();
        L6:
            return new Notification.Action.Builder(null, this.mContext.getString(R.string.input_method_binding_label), createPendingIntent(ACTION_SWITCH_TO_HEARING_MIC)).build();
        }

        private Notification.Action buildOpenSettingsAction() {
            return new Notification.Action.Builder(null, this.mContext.getString(R.string.inputMethod), createPendingIntent(ACTION_BLUETOOTH_DEVICE_DETAILS)).build();
        }

        private PendingIntent createPendingIntent(String action) {
            Intent intent = new Intent(action);
            switch(action.hashCode()) {
                case -1827282504: goto L12;
                case 743003214: goto L9;
                case 1679791549: goto L6;
                default: goto L14;
            };
        L14:
            byte r1 = -1;
        L16:
            switch(r1) {
                case 0: goto L23;
                case 1: goto L23;
                case 2: goto L19;
                default: goto L17;
            };
        L17:
            return null;
        L23:
            intent.setPackage(this.mContext.getPackageName());
            return PendingIntent.getBroadcast(this.mContext, 0, intent, 67108864);
        L19:
            if (this.mHearingDevice != null) goto L21;
            return null;
        L21:
            Bundle bundle = new Bundle();
            bundle.putString(KEY_BLUETOOTH_ADDRESS, this.mHearingDevice.getAddress());
            intent.putExtra(EXTRA_SHOW_FRAGMENT_ARGUMENTS, bundle);
            intent.addFlags(268468224);
            return PendingIntent.getActivity(this.mContext, 0, intent, 67108864);
        L6:
            if (action.equals(ACTION_SWITCH_TO_BUILTIN_MIC) == false) goto L14;
            r1 = 0;
            goto L16
        L9:
            if (action.equals(ACTION_SWITCH_TO_HEARING_MIC) == false) goto L14;
            r1 = 1;
            goto L16
        L12:
            if (action.equals(ACTION_BLUETOOTH_DEVICE_DETAILS) == false) goto L14;
            r1 = 2;
            goto L16
        }

        private void setMicrophonePreferredForCalls(boolean useRemoteMicrophone) {
            if (useRemoteMicrophone == false) goto L4;
            switchToHearingMic();
            return;
        L4:
            switchToBuiltinMic();
        }

        private void switchToBuiltinMic() {
            this.mAudioManager.clearPreferredDevicesForCapturePreset(7);
            this.mAudioManager.setPreferredDeviceForCapturePreset(7, BUILTIN_MIC);
        }

        private void switchToHearingMic() {
            this.mAudioManager.clearPreferredDevicesForCapturePreset(7);
        }

        private void registerReceiverIfNeeded() {
            if (this.mHearingDeviceActionReceiver == null) goto L5;
            return;
        L5:
            this.mHearingDeviceActionReceiver = new HearingDeviceActionReceiver(this, null);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(ACTION_SWITCH_TO_BUILTIN_MIC);
            intentFilter.addAction(ACTION_SWITCH_TO_HEARING_MIC);
            this.mContext.registerReceiver(this.mHearingDeviceActionReceiver, intentFilter, "android.permission.MANAGE_ACCESSIBILITY", null, 4);
        }

        private void unregisterReceiverIfNeeded() {
            if (this.mHearingDeviceActionReceiver != null) goto L5;
            return;
        L5:
            this.mContext.unregisterReceiver(this.mHearingDeviceActionReceiver);
            this.mHearingDeviceActionReceiver = null;
        }

        private CharSequence getSwitchInputTitle(boolean useRemoteMicrophone) {
            if (useRemoteMicrophone == false) goto L5;
            return this.mContext.getString(R.string.install_carrier_app_notification_text_app_name);
        L5:
            return this.mContext.getString(R.string.install_carrier_app_notification_button);
        }

        private CharSequence getSwitchInputMessage(boolean useRemoteMicrophone) {
            if (useRemoteMicrophone == false) goto L5;
            return this.mContext.getString(R.string.install_carrier_app_notification_text);
        L5:
            return this.mContext.getString(R.string.input_method_switcher_settings_button);
        }
    }

    public HearingDevicePhoneCallNotificationController(Context context) {
        this.mTelephonyManager = (TelephonyManager) context.getSystemService(TelephonyManager.class);
        this.mCallbackExecutor = Executors.newSingleThreadExecutor();
        this.mTelephonyListener = new CallStateListener(context, this.mCallbackExecutor);
    }

    HearingDevicePhoneCallNotificationController(Context context, TelephonyCallback telephonyCallback) {
        this.mTelephonyListener = telephonyCallback;
        this.mTelephonyManager = (TelephonyManager) context.getSystemService(TelephonyManager.class);
        this.mCallbackExecutor = context.getMainExecutor();
    }

    public void startListenForCallState() {
        this.mTelephonyManager.registerTelephonyCallback(this.mCallbackExecutor, this.mTelephonyListener);
    }
}
