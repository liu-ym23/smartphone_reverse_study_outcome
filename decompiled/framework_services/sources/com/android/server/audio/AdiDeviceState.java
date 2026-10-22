package com.android.server.audio;

import android.media.AudioDeviceAttributes;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.media.AudioSystem;
import android.media.Utils;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class AdiDeviceState {
    private static final String SETTING_FIELD_SEPARATOR = ",";
    private static final String TAG = "AS.AdiDeviceState";
    private int mAudioDeviceCategory;
    private boolean mAutoBtCategorySet;
    private final String mDeviceAddress;
    private final Pair<Integer, String> mDeviceId;
    private final int mDeviceType;
    private boolean mHasHeadTracker;
    private boolean mHeadTrackerEnabled;
    private final int mInternalDeviceType;
    private boolean mSAEnabled;

    AdiDeviceState(int deviceType, int internalDeviceType, String address) {
        this.mAudioDeviceCategory = 0;
        this.mAutoBtCategorySet = false;
        this.mHasHeadTracker = false;
        this.mDeviceType = deviceType;
        if (internalDeviceType == 0) goto L5;
        this.mInternalDeviceType = internalDeviceType;
    L7:
        if (AudioSystem.isBluetoothDevice(this.mInternalDeviceType) == false) goto L9;
        address.getClass();
        String r0 = address;
    L10:
        this.mDeviceAddress = r0;
        this.mDeviceId = new Pair(Integer.valueOf(this.mInternalDeviceType), this.mDeviceAddress);
        return;
    L9:
        r0 = "";
        goto L10
    L5:
        this.mInternalDeviceType = AudioDeviceInfo.convertDeviceTypeToInternalDevice(deviceType);
        goto L7
    }

    public synchronized Pair<Integer, String> getDeviceId() {
        monitor-enter(this);
        Pair<Integer, String> r0 = this.mDeviceId;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized int getDeviceType() {
        monitor-enter(this);
        int r0 = this.mDeviceType;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized int getInternalDeviceType() {
        monitor-enter(this);
        int r0 = this.mInternalDeviceType;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized String getDeviceAddress() {
        monitor-enter(this);
        String r0 = this.mDeviceAddress;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void setSAEnabled(boolean sAEnabled) {
        monitor-enter(this);
        this.mSAEnabled = sAEnabled;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized boolean isSAEnabled() {
        monitor-enter(this);
        boolean r0 = this.mSAEnabled;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void setHeadTrackerEnabled(boolean headTrackerEnabled) {
        monitor-enter(this);
        this.mHeadTrackerEnabled = headTrackerEnabled;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized boolean isHeadTrackerEnabled() {
        monitor-enter(this);
        boolean r0 = this.mHeadTrackerEnabled;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void setHasHeadTracker(boolean hasHeadTracker) {
        monitor-enter(this);
        this.mHasHeadTracker = hasHeadTracker;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized boolean hasHeadTracker() {
        monitor-enter(this);
        boolean r0 = this.mHasHeadTracker;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized int getAudioDeviceCategory() {
        monitor-enter(this);
        int r0 = this.mAudioDeviceCategory;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void setAudioDeviceCategory(int audioDeviceCategory) {
        monitor-enter(this);
        this.mAudioDeviceCategory = audioDeviceCategory;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized boolean isBtDeviceCategoryFixed() {
        monitor-enter(this);
        updateAudioDeviceCategory();     // Catch: Throwable -> L6
        boolean r0 = this.mAutoBtCategorySet;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized boolean updateAudioDeviceCategory() {
        monitor-enter(this);
    L19:
        th = move-exception;
        throw th;
    L5:
        if (AudioSystem.isBluetoothDevice(this.mInternalDeviceType) == true) goto L9;
        monitor-exit(this);
        return false;
    L9:
        if (this.mAutoBtCategorySet == false) goto L12;
        monitor-exit(this);
        return false;
    L12:
        int newAudioDeviceCategory = BtHelper.getBtDeviceCategory(this.mDeviceAddress);     // Catch: Throwable -> L19
        if (newAudioDeviceCategory != 0) goto L16;
        monitor-exit(this);
        return false;
    L16:
        this.mAudioDeviceCategory = newAudioDeviceCategory;     // Catch: Throwable -> L19
        this.mAutoBtCategorySet = true;     // Catch: Throwable -> L19
        monitor-exit(this);
        return true;
    }

    public boolean equals(Object obj) {
        if (this != obj) goto L6;
        return true;
    L6:
        if (obj != null) goto L9;
        return false;
    L9:
        if (getClass() == obj.getClass()) goto L11;
        return false;
    L11:
        AdiDeviceState sads = (AdiDeviceState) obj;
        if (this.mDeviceType != sads.mDeviceType) goto L27;
        if (this.mInternalDeviceType != sads.mInternalDeviceType) goto L27;
        if (this.mDeviceAddress.equals(sads.mDeviceAddress) == false) goto L27;
        if (this.mSAEnabled != sads.mSAEnabled) goto L27;
        if (this.mHasHeadTracker != sads.mHasHeadTracker) goto L27;
        if (this.mHeadTrackerEnabled != sads.mHeadTrackerEnabled) goto L27;
        if (this.mAudioDeviceCategory != sads.mAudioDeviceCategory) goto L27;
        return true;
    L27:
        return false;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(this.mDeviceType), Integer.valueOf(this.mInternalDeviceType), this.mDeviceAddress, Boolean.valueOf(this.mSAEnabled), Boolean.valueOf(this.mHasHeadTracker), Boolean.valueOf(this.mHeadTrackerEnabled), Integer.valueOf(this.mAudioDeviceCategory)});
    }

    public String toString() {
        return "type: " + this.mDeviceType + " internal type: 0x" + Integer.toHexString(this.mInternalDeviceType) + " addr: " + Utils.anonymizeBluetoothAddress(this.mInternalDeviceType, this.mDeviceAddress) + " bt audio type: " + AudioManager.audioDeviceCategoryToString(this.mAudioDeviceCategory) + " enabled: " + this.mSAEnabled + " HT: " + this.mHasHeadTracker + " HTenabled: " + this.mHeadTrackerEnabled;
    }

    public synchronized String toPersistableString() {
        monitor-enter(this);
        StringBuilder r0 = new StringBuilder();     // Catch: Throwable -> L6
        r0.append(this.mDeviceType);     // Catch: Throwable -> L6
        r0.append(SETTING_FIELD_SEPARATOR);     // Catch: Throwable -> L6
        r0.append(this.mDeviceAddress);     // Catch: Throwable -> L6
        r0.append(SETTING_FIELD_SEPARATOR);     // Catch: Throwable -> L6
        if (this.mSAEnabled == false) goto L8;
        String r1 = "1";
    L9:
        r0.append(r1);     // Catch: Throwable -> L6
        r0.append(SETTING_FIELD_SEPARATOR);     // Catch: Throwable -> L6
        if (this.mHasHeadTracker == false) goto L12;
        String r2 = "1";
    L13:
        r0.append(r2);     // Catch: Throwable -> L6
        r0.append(SETTING_FIELD_SEPARATOR);     // Catch: Throwable -> L6
        if (this.mHeadTrackerEnabled == false) goto L16;
        String r3 = "1";
    L17:
        r0.append(r3);     // Catch: Throwable -> L6
        r0.append(SETTING_FIELD_SEPARATOR);     // Catch: Throwable -> L6
        r0.append(this.mInternalDeviceType);     // Catch: Throwable -> L6
        r0.append(SETTING_FIELD_SEPARATOR);     // Catch: Throwable -> L6
        r0.append(this.mAudioDeviceCategory);     // Catch: Throwable -> L6
        String r4 = r0.toString();     // Catch: Throwable -> L6
        monitor-exit(this);
        return r4;
    L16:
        r3 = "0";
        goto L17
    L12:
        r2 = "0";
        goto L13
    L8:
        r1 = "0";
    L6:
        th = move-exception;
        throw th;
    }

    public static int getPeristedMaxSize() {
        return 39;
    }

    public static AdiDeviceState fromPersistedString(String persistedString) {
        if (persistedString != null) goto L6;
        return null;
    L6:
        if (persistedString.isEmpty() == false) goto L8;
        return null;
    L8:
        String[] fields = TextUtils.split(persistedString, SETTING_FIELD_SEPARATOR);
        if (fields.length >= 5) goto L11;
    L37:
        return null;
    L11:
        if (fields.length > 7) goto L37;
        boolean r2 = false;
        int deviceType = Integer.parseInt(fields[0]);     // Catch: NumberFormatException -> L17
        int internalDeviceType = -1;
        if (fields.length < 6) goto L19;
        internalDeviceType = Integer.parseInt(fields[5]);     // Catch: NumberFormatException -> L17
    L19:
        int audioDeviceCategory = 0;
        if (fields.length != 7) goto L22;
        audioDeviceCategory = Integer.parseInt(fields[6]);     // Catch: NumberFormatException -> L17
    L22:
        AdiDeviceState deviceState = new AdiDeviceState(deviceType, internalDeviceType, fields[1]);     // Catch: NumberFormatException -> L17
        if (Integer.parseInt(fields[2]) != 1) goto L25;
        boolean r8 = true;
    L26:
        deviceState.setSAEnabled(r8);     // Catch: NumberFormatException -> L17
        if (Integer.parseInt(fields[3]) != 1) goto L29;
        boolean r9 = true;
    L30:
        deviceState.setHasHeadTracker(r9);     // Catch: NumberFormatException -> L17
        if (Integer.parseInt(fields[4]) != 1) goto L33;
        r2 = true;
    L33:
        deviceState.setHeadTrackerEnabled(r2);     // Catch: NumberFormatException -> L17
        deviceState.setAudioDeviceCategory(audioDeviceCategory);     // Catch: NumberFormatException -> L17
        deviceState.updateAudioDeviceCategory();     // Catch: NumberFormatException -> L17
        return deviceState;
    L29:
        r9 = false;
        goto L30
    L25:
        r8 = false;
    L17:
        e = move-exception;
        Log.e(TAG, "unable to parse setting for AdiDeviceState: " + persistedString, e);
        return null;
    }

    public synchronized AudioDeviceAttributes getAudioDeviceAttributes() {
        monitor-enter(this);
        AudioDeviceAttributes r0 = new AudioDeviceAttributes(2, this.mDeviceType, this.mDeviceAddress);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }
}
