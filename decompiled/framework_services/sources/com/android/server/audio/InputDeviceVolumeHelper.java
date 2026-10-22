package com.android.server.audio;

import android.content.ContentResolver;
import android.media.AudioDeviceAttributes;
import android.media.AudioDeviceInfo;
import android.media.AudioSystem;
import android.util.IntArray;
import android.util.Log;
import android.util.SparseIntArray;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
class InputDeviceVolumeHelper {
    private static final String TAG = "InputDeviceVolumeHelper";
    private final int INDEX_DEFAULT;
    private final int INDEX_MAX;
    private final int INDEX_MIN;
    private final ContentResolver mContentResolver;
    private final SparseIntArray mInputGainIndexMap;
    private final String mInputGainIndexSettingsName;
    private final SettingsAdapter mSettings;
    private final Set<Integer> mSupportedDeviceTypes;

    InputDeviceVolumeHelper(SettingsAdapter settings, ContentResolver contentResolver, String settingsName) {
        this.INDEX_MIN = 0;
        this.INDEX_MAX = 100;
        this.INDEX_DEFAULT = 50;
        this.mSupportedDeviceTypes = new HashSet();
        this.mSettings = settings;
        this.mContentResolver = contentResolver;
        this.mInputGainIndexSettingsName = settingsName;
        IntArray internalDeviceTypes = new IntArray();
        int status = AudioSystem.getSupportedDeviceTypes(1, internalDeviceTypes);
        if (status == 0) goto L5;
        Log.e(TAG, "AudioSystem.getSupportedDeviceTypes(GET_DEVICES_INPUTS) failed. status:" + status);
    L5:
        this.mInputGainIndexMap = new SparseIntArray(internalDeviceTypes.size());
        int i = 0;
    L7:
        if (i >= internalDeviceTypes.size()) goto L9;
        this.mSupportedDeviceTypes.add(Integer.valueOf(internalDeviceTypes.get(i)));
        i = i + 1;
        goto L7
    L9:
        readSettings();
    }

    private void readSettings() {
        monitor-enter(InputDeviceVolumeHelper.class);
        Iterator<Integer> r1 = this.mSupportedDeviceTypes.iterator();     // Catch: Throwable -> L12
    L6:
        if (r1.hasNext() == false) goto L14;
        int inputDeviceType = r1.next().intValue();     // Catch: Throwable -> L12
        String name = getSettingNameForDevice(inputDeviceType);     // Catch: Throwable -> L12
        int index = 50;
        if (name == null) goto L11;
        index = this.mSettings.getSystemIntForUser(this.mContentResolver, name, 50, -2);     // Catch: Throwable -> L12
    L11:
        this.mInputGainIndexMap.put(inputDeviceType, getValidIndex(index));     // Catch: Throwable -> L12
        goto L6
    L14:
        monitor-exit(InputDeviceVolumeHelper.class);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    private String getSettingNameForDevice(int inputDeviceType) {
        if (this.mInputGainIndexSettingsName != null) goto L5;
        return null;
    L5:
        if (this.mInputGainIndexSettingsName.isEmpty() == true) goto L15;
        String suffix = AudioSystem.getInputDeviceName(inputDeviceType);
        if (suffix.isEmpty() == false) goto L12;
        return this.mInputGainIndexSettingsName;
    L12:
        return this.mInputGainIndexSettingsName + "_" + suffix;
    L15:
        return null;
    }

    private int getValidIndex(int index) {
        if (index >= 0) goto L6;
        return 0;
    L6:
        if (index <= 100) goto L8;
        return 100;
    L8:
        return index;
    }

    public int getInputGainIndex(AudioDeviceAttributes ada) {
        int inputDeviceType = AudioDeviceInfo.convertDeviceTypeToInternalInputDevice(ada.getType());
        ensureValidInputDeviceType(inputDeviceType);
        monitor-enter(InputDeviceVolumeHelper.class);
        int r2 = this.mInputGainIndexMap.get(inputDeviceType, 50);     // Catch: Throwable -> L7
        monitor-exit(InputDeviceVolumeHelper.class);     // Catch: Throwable -> L7
        return r2;
    L7:
        th = move-exception;
        throw th;
    }

    public int getMaxInputGainIndex() {
        return 100;
    }

    public int getMinInputGainIndex() {
        return 0;
    }

    public boolean isInputGainFixed(AudioDeviceAttributes ada) {
        int inputDeviceType = AudioDeviceInfo.convertDeviceTypeToInternalInputDevice(ada.getType());
        ensureValidInputDeviceType(inputDeviceType);
        return false;
    }

    public boolean setInputGainIndex(AudioDeviceAttributes ada, int index) {
        int inputDeviceType = AudioDeviceInfo.convertDeviceTypeToInternalInputDevice(ada.getType());
        ensureValidInputDeviceType(inputDeviceType);
        monitor-enter(InputDeviceVolumeHelper.class);
        int oldIndex = getInputGainIndex(ada);     // Catch: Throwable -> L9
        int index2 = getValidIndex(index);     // Catch: Throwable -> L9
        if (oldIndex != index2) goto L11;
        monitor-exit(InputDeviceVolumeHelper.class);     // Catch: Throwable -> L9
        return false;
    L11:
        this.mInputGainIndexMap.put(inputDeviceType, index2);     // Catch: Throwable -> L9
        monitor-exit(InputDeviceVolumeHelper.class);     // Catch: Throwable -> L9
        return true;
    L9:
        th = move-exception;
        throw th;
    }

    public void persistInputGainIndex(AudioDeviceAttributes ada) {
        int inputDeviceType = AudioDeviceInfo.convertDeviceTypeToInternalInputDevice(ada.getType());
        String name = getSettingNameForDevice(inputDeviceType);
        if (name == null) goto L6;
        int index = getInputGainIndex(ada);
        this.mSettings.putSystemIntForUser(this.mContentResolver, name, index, -2);
        return;
    }

    public boolean isValidInputDeviceType(int inputDeviceType) {
        return this.mSupportedDeviceTypes.contains(Integer.valueOf(inputDeviceType));
    }

    private void ensureValidInputDeviceType(int inputDeviceType) {
        if (isValidInputDeviceType(inputDeviceType) == false) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("Bad input device type " + inputDeviceType);
    }
}
