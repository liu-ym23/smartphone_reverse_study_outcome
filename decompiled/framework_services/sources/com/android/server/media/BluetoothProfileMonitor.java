package com.android.server.media;

import android.bluetooth.BluetoothA2dp;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothHearingAid;
import android.bluetooth.BluetoothLeAudio;
import android.bluetooth.BluetoothProfile;
import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
class BluetoothProfileMonitor {
    static final long GROUP_ID_NO_GROUP = -1;
    private BluetoothA2dp mA2dpProfile;
    private final BluetoothAdapter mBluetoothAdapter;
    private final Context mContext;
    private BluetoothHearingAid mHearingAidProfile;
    private BluetoothLeAudio mLeAudioProfile;
    private final ProfileListener mProfileListener;

    private final class ProfileListener implements BluetoothProfile.ServiceListener {
        final /* synthetic */ BluetoothProfileMonitor this$0;

        /* synthetic */ ProfileListener(BluetoothProfileMonitor r1, BluetoothProfileMonitorIA r2) {
            this(r1);
        }

        private ProfileListener(BluetoothProfileMonitor r1) {
            this.this$0 = r1;
        }

        @Override // android.bluetooth.BluetoothProfile.ServiceListener
        public void onServiceConnected(int profile, BluetoothProfile proxy) {
            BluetoothProfileMonitor r0 = this.this$0;
            monitor-enter(r0);
            switch(profile) {
                case 2: goto L10;
                case 21: goto L9;
                case 22: goto L6;
                default: goto L11;
            };
        L6:
            BluetoothProfileMonitor.m5523$$Nest$fputmLeAudioProfile(this.this$0, (BluetoothLeAudio) proxy);     // Catch: Throwable -> L7
            goto L11
        L9:
            BluetoothProfileMonitor.m5522$$Nest$fputmHearingAidProfile(this.this$0, (BluetoothHearingAid) proxy);     // Catch: Throwable -> L7
            goto L11
        L10:
            BluetoothProfileMonitor.m5521$$Nest$fputmA2dpProfile(this.this$0, (BluetoothA2dp) proxy);     // Catch: Throwable -> L7
        L11:
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // android.bluetooth.BluetoothProfile.ServiceListener
        public void onServiceDisconnected(int profile) {
            BluetoothProfileMonitor r0 = this.this$0;
            monitor-enter(r0);
            switch(profile) {
                case 2: goto L11;
                case 21: goto L10;
                case 22: goto L7;
                default: goto L12;
            };
        L7:
            BluetoothProfileMonitor.m5523$$Nest$fputmLeAudioProfile(this.this$0, null);     // Catch: Throwable -> L8
            goto L12
        L10:
            BluetoothProfileMonitor.m5522$$Nest$fputmHearingAidProfile(this.this$0, null);     // Catch: Throwable -> L8
            goto L12
        L11:
            BluetoothProfileMonitor.m5521$$Nest$fputmA2dpProfile(this.this$0, null);     // Catch: Throwable -> L8
        L12:
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            throw th;
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fputmA2dpProfile, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5521$$Nest$fputmA2dpProfile(BluetoothProfileMonitor r0, BluetoothA2dp r1) {
        r0.mA2dpProfile = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmHearingAidProfile, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5522$$Nest$fputmHearingAidProfile(BluetoothProfileMonitor r0, BluetoothHearingAid r1) {
        r0.mHearingAidProfile = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmLeAudioProfile, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5523$$Nest$fputmLeAudioProfile(BluetoothProfileMonitor r0, BluetoothLeAudio r1) {
        r0.mLeAudioProfile = r1;
    }

    BluetoothProfileMonitor(Context context, BluetoothAdapter bluetoothAdapter) {
        this.mProfileListener = new ProfileListener(this, null);
        context.getClass();
        this.mContext = context;
        bluetoothAdapter.getClass();
        this.mBluetoothAdapter = bluetoothAdapter;
    }

    void start() {
        this.mBluetoothAdapter.getProfileProxy(this.mContext, this.mProfileListener, 2);
        this.mBluetoothAdapter.getProfileProxy(this.mContext, this.mProfileListener, 21);
        this.mBluetoothAdapter.getProfileProxy(this.mContext, this.mProfileListener, 22);
    }

    boolean isProfileSupported(int profile, BluetoothDevice device) {
        monitor-enter(this);
        switch(profile) {
            case 2: goto L10;
            case 21: goto L9;
            case 22: goto L8;
            default: goto L5;
        };
    L8:
        BluetoothProfile bluetoothProfile = this.mLeAudioProfile;     // Catch: Throwable -> L6
    L11:
        monitor-exit(this);     // Catch: Throwable -> L6
        if (bluetoothProfile != null) goto L16;
        return false;
    L16:
        return bluetoothProfile.getConnectedDevices().contains(device);
    L9:
        bluetoothProfile = this.mHearingAidProfile;     // Catch: Throwable -> L6
        goto L11
    L10:
        bluetoothProfile = this.mA2dpProfile;     // Catch: Throwable -> L6
        goto L11
    L5:
        throw new IllegalArgumentException(profile + " is not supported as Bluetooth profile");     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }

    long getGroupId(int profile, BluetoothDevice device) {
        monitor-enter(this);
        long r0 = -1;
        switch(profile) {
            case 2: goto L21;
            case 21: goto L16;
            case 22: goto L10;
            default: goto L6;
        };
    L21:
        monitor-exit(this);     // Catch: Throwable -> L7
        return -1;
    L6:
        throw new IllegalArgumentException(profile + " is not supported as Bluetooth profile");     // Catch: Throwable -> L7
    L10:
        if (this.mLeAudioProfile == null) goto L13;
        r0 = this.mLeAudioProfile.getGroupId(device);     // Catch: Throwable -> L7
    L13:
        monitor-exit(this);     // Catch: Throwable -> L7
        return r0;
    L16:
        if (this.mHearingAidProfile == null) goto L19;
        r0 = this.mHearingAidProfile.getHiSyncId(device);     // Catch: Throwable -> L7
    L19:
        monitor-exit(this);     // Catch: Throwable -> L7
        return r0;
    L7:
        th = move-exception;
        throw th;
    }
}
