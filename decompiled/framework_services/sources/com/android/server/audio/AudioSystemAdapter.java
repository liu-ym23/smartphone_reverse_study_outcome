package com.android.server.audio;

import android.media.AudioAttributes;
import android.media.AudioDeviceAttributes;
import android.media.AudioMixerAttributes;
import android.media.AudioSystem;
import android.media.IDevicesForAttributesCallback;
import android.media.INativeAudioVolumeGroupCallback;
import android.media.ISoundDose;
import android.media.ISoundDoseCallback;
import android.media.audiopolicy.AudioMix;
import android.media.audiopolicy.AudioMixingRule;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.util.ArrayMap;
import android.util.Log;
import android.util.Pair;
import java.io.PrintWriter;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class AudioSystemAdapter implements AudioSystem.RoutingUpdateCallback, AudioSystem.VolumeRangeInitRequestCallback {
    private static final boolean DEBUG_CACHE = false;
    private static final boolean ENABLE_GETDEVICES_STATS = false;
    private static final int METHOD_GETDEVICESFORATTRIBUTES = 0;
    private static final int NB_MEASUREMENTS = 1;
    private static final String TAG = "AudioSystemAdapter";
    private static final boolean USE_CACHE_FOR_GETDEVICES = true;
    private static final Object sDeviceCacheLock = null;
    private static OnRoutingUpdatedListener sRoutingListener;
    private static final Object sRoutingListenerLock = null;
    private static AudioSystemAdapter sSingletonDefaultAdapter;
    private static OnVolRangeInitRequestListener sVolRangeInitReqListener;
    private static final Object sVolRangeInitReqListenerLock = null;
    private ConcurrentHashMap<Pair<AudioAttributes, Boolean>, ArrayList<AudioDeviceAttributes>> mDevicesForAttrCache;
    private long mDevicesForAttributesCacheClearTimeMs;
    private final RemoteCallbackList<IDevicesForAttributesCallback> mDevicesForAttributesCallbacks;
    private ConcurrentHashMap<Pair<AudioAttributes, Boolean>, ArrayList<AudioDeviceAttributes>> mLastDevicesForAttr;
    private int[] mMethodCacheHit;
    private int[] mMethodCallCounter;
    private String[] mMethodNames;
    private long[] mMethodTimeNs;
    private final ArrayMap<IBinder, List<Pair<AudioAttributes, Boolean>>> mRegisteredAttributesMap;

    interface OnRoutingUpdatedListener {
        void onRoutingUpdatedFromNative();
    }

    interface OnVolRangeInitRequestListener {
        void onVolumeRangeInitRequestFromNative();
    }

    public AudioSystemAdapter() {
        this.mMethodNames = new String[]{"getDevicesForAttributes"};
        this.mLastDevicesForAttr = new ConcurrentHashMap();
        this.mDevicesForAttributesCacheClearTimeMs = System.currentTimeMillis();
        this.mRegisteredAttributesMap = new ArrayMap();
        this.mDevicesForAttributesCallbacks = new RemoteCallbackList();
    }

    static {
        sDeviceCacheLock = new Object();
        sRoutingListenerLock = new Object();
        sVolRangeInitReqListenerLock = new Object();
    }

    public void onRoutingUpdated() {
        invalidateRoutingCache();
        Object r0 = sRoutingListenerLock;
        monitor-enter(r0);
        OnRoutingUpdatedListener listener = sRoutingListener;     // Catch: Throwable -> L37
        monitor-exit(r0);     // Catch: Throwable -> L37
        if (listener == null) goto L8;
        listener.onRoutingUpdatedFromNative();
    L8:
        ArrayMap<IBinder, List<Pair<AudioAttributes, Boolean>>> r2 = this.mRegisteredAttributesMap;
        monitor-enter(r2);
        int nbCallbacks = this.mDevicesForAttributesCallbacks.beginBroadcast();     // Catch: Throwable -> L22
        int i = 0;
    L11:
        if (i >= nbCallbacks) goto L32;
        IDevicesForAttributesCallback cb = this.mDevicesForAttributesCallbacks.getBroadcastItem(i);     // Catch: Throwable -> L22
        List<Pair<AudioAttributes, Boolean>> attrList = this.mRegisteredAttributesMap.get(cb.asBinder());     // Catch: Throwable -> L22
        if (attrList == null) goto L31;
        Iterator<Pair<AudioAttributes, Boolean>> r6 = attrList.iterator();     // Catch: Throwable -> L22
    L16:
        if (r6.hasNext() == false) goto L29;
        Pair<AudioAttributes, Boolean> attr = r6.next();     // Catch: Throwable -> L22
        ArrayList<AudioDeviceAttributes> devices = getDevicesForAttributes((AudioAttributes) attr.first, ((Boolean) attr.second).booleanValue());     // Catch: Throwable -> L22
        if (this.mLastDevicesForAttr.containsKey(attr) == true) goto L20;
    L43:
        cb.onDevicesForAttributesChanged((AudioAttributes) attr.first, ((Boolean) attr.second).booleanValue(), devices);     // Catch: Throwable -> L22 RemoteException -> L26
        goto L16
    L20:
        if (sameDeviceList(devices, this.mLastDevicesForAttr.get(attr)) == true) goto L16;
    L29:
        i = i + 1;
        goto L11
    L31:
        throw new IllegalStateException("Attribute list must not be null");     // Catch: Throwable -> L22
    L32:
        this.mDevicesForAttributesCallbacks.finishBroadcast();     // Catch: Throwable -> L22
        monitor-exit(r2);     // Catch: Throwable -> L22
        return;
    L22:
        th = move-exception;
        throw th;
    L37:
        th = move-exception;
        throw th;
    }

    static void setRoutingListener(OnRoutingUpdatedListener listener) {
        Object r0 = sRoutingListenerLock;
        monitor-enter(r0);
        sRoutingListener = listener;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void clearRoutingCache() {
        invalidateRoutingCache();
    }

    public void addOnDevicesForAttributesChangedListener(AudioAttributes attributes, boolean forVolume, IDevicesForAttributesCallback listener) {
        Pair<AudioAttributes, Boolean> attr = new Pair(attributes, Boolean.valueOf(forVolume));
        ArrayMap<IBinder, List<Pair<AudioAttributes, Boolean>>> r1 = this.mRegisteredAttributesMap;
        monitor-enter(r1);
        List<Pair<AudioAttributes, Boolean>> res = this.mRegisteredAttributesMap.get(listener.asBinder());     // Catch: Throwable -> L7
        if (res != null) goto L10;
        res = new ArrayList();     // Catch: Throwable -> L7
        this.mRegisteredAttributesMap.put(listener.asBinder(), res);     // Catch: Throwable -> L7
        this.mDevicesForAttributesCallbacks.register(listener);     // Catch: Throwable -> L7
    L10:
        if (res.contains(attr) == true) goto L12;
        res.add(attr);     // Catch: Throwable -> L7
    L12:
        monitor-exit(r1);     // Catch: Throwable -> L7
        getDevicesForAttributes(attributes, forVolume);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void removeOnDevicesForAttributesChangedListener(IDevicesForAttributesCallback listener) {
        ArrayMap<IBinder, List<Pair<AudioAttributes, Boolean>>> r0 = this.mRegisteredAttributesMap;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mRegisteredAttributesMap.containsKey(listener.asBinder()) == true) goto L11;
        Log.w(TAG, "listener to be removed is not found.");     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        this.mRegisteredAttributesMap.remove(listener.asBinder());     // Catch: Throwable -> L9
        this.mDevicesForAttributesCallbacks.unregister(listener);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
    }

    private boolean sameDeviceList(List<AudioDeviceAttributes> a, List<AudioDeviceAttributes> b) {
        Iterator<AudioDeviceAttributes> r0 = a.iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        AudioDeviceAttributes device = r0.next();
        if (b.contains(device) == true) goto L4;
        return false;
    L9:
        Iterator<AudioDeviceAttributes> r1 = b.iterator();
    L11:
        if (r1.hasNext() == false) goto L16;
        AudioDeviceAttributes device2 = r1.next();
        if (a.contains(device2) == true) goto L11;
        return false;
    L16:
        return true;
    }

    public void onVolumeRangeInitializationRequested() {
        Object r0 = sVolRangeInitReqListenerLock;
        monitor-enter(r0);
        OnVolRangeInitRequestListener listener = sVolRangeInitReqListener;     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        if (listener == null) goto L14;
        listener.onVolumeRangeInitRequestFromNative();
        return;
    L14:
        return;
    L9:
        th = move-exception;
        throw th;
    }

    static void setVolRangeInitReqListener(OnVolRangeInitRequestListener listener) {
        Object r0 = sVolRangeInitReqListenerLock;
        monitor-enter(r0);
        sVolRangeInitReqListener = listener;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    static final synchronized AudioSystemAdapter getDefaultAdapter() {
        monitor-enter(AudioSystemAdapter.class);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (sSingletonDefaultAdapter != null) goto L16;
        sSingletonDefaultAdapter = new AudioSystemAdapter();     // Catch: Throwable -> L14
        AudioSystem.setRoutingCallback(sSingletonDefaultAdapter);     // Catch: Throwable -> L14
        AudioSystem.setVolumeRangeInitRequestCallback(sSingletonDefaultAdapter);     // Catch: Throwable -> L14
        Object r1 = sDeviceCacheLock;     // Catch: Throwable -> L14
        monitor-enter(r1);     // Catch: Throwable -> L14
        AudioSystemAdapter r2 = sSingletonDefaultAdapter;     // Catch: Throwable -> L11
        r2.mDevicesForAttrCache = new ConcurrentHashMap(AudioSystem.getNumStreamTypes());     // Catch: Throwable -> L11
        int[] r3 = new int[1];     // Catch: Throwable -> L11
        sSingletonDefaultAdapter.mMethodCacheHit = r3;     // Catch: Throwable -> L11
        monitor-exit(r1);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L14
    L16:
        AudioSystemAdapter r4 = sSingletonDefaultAdapter;     // Catch: Throwable -> L14
        monitor-exit(AudioSystemAdapter.class);
        return r4;
    }

    private void invalidateRoutingCache() {
        Object r0 = sDeviceCacheLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mDevicesForAttrCache == null) goto L9;
        this.mDevicesForAttributesCacheClearTimeMs = System.currentTimeMillis();     // Catch: Throwable -> L7
        this.mLastDevicesForAttr.putAll(this.mDevicesForAttrCache);     // Catch: Throwable -> L7
        this.mDevicesForAttrCache.clear();     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
    }

    public ArrayList<AudioDeviceAttributes> getDevicesForAttributes(AudioAttributes attributes, boolean forVolume) {
        return getDevicesForAttributesImpl(attributes, forVolume);
    }

    private ArrayList<AudioDeviceAttributes> getDevicesForAttributesImpl(AudioAttributes attributes, boolean forVolume) {
        Pair<AudioAttributes, Boolean> key = new Pair(attributes, Boolean.valueOf(forVolume));
        Object r1 = sDeviceCacheLock;
        monitor-enter(r1);
        ArrayList<AudioDeviceAttributes> res = this.mDevicesForAttrCache.get(key);     // Catch: Throwable -> L9
        if (res != null) goto L11;
        ArrayList<AudioDeviceAttributes> res2 = AudioSystem.getDevicesForAttributes(attributes, forVolume);     // Catch: Throwable -> L9
        this.mDevicesForAttrCache.put(key, res2);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return res2;
    L11:
        int[] r3 = this.mMethodCacheHit;     // Catch: Throwable -> L9
        r3[0] = r3[0] + 1;     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return res;
    L9:
        th = move-exception;
        throw th;
    }

    private static String attrDeviceToDebugString(AudioAttributes attr, List<AudioDeviceAttributes> devices) {
        return " attrUsage=" + attr.getSystemUsage() + " " + AudioSystem.deviceSetToString(AudioSystem.generateAudioDeviceTypesSet(devices));
    }

    public int setDeviceConnectionState(AudioDeviceAttributes attributes, int state, int codecFormat, boolean deviceSwitch) {
        invalidateRoutingCache();
        return AudioSystem.setDeviceConnectionState(attributes, state, codecFormat, deviceSwitch);
    }

    public int getDeviceConnectionState(int device, String deviceAddress) {
        return AudioSystem.getDeviceConnectionState(device, deviceAddress);
    }

    public int handleDeviceConfigChange(int device, String deviceAddress, String deviceName, int codecFormat) {
        invalidateRoutingCache();
        return AudioSystem.handleDeviceConfigChange(device, deviceAddress, deviceName, codecFormat);
    }

    public int setDevicesRoleForStrategy(int strategy, int role, List<AudioDeviceAttributes> devices) {
        invalidateRoutingCache();
        return AudioSystem.setDevicesRoleForStrategy(strategy, role, devices);
    }

    public int removeDevicesRoleForStrategy(int strategy, int role, List<AudioDeviceAttributes> devices) {
        invalidateRoutingCache();
        return AudioSystem.removeDevicesRoleForStrategy(strategy, role, devices);
    }

    public int clearDevicesRoleForStrategy(int strategy, int role) {
        invalidateRoutingCache();
        return AudioSystem.clearDevicesRoleForStrategy(strategy, role);
    }

    public int setDevicesRoleForCapturePreset(int capturePreset, int role, List<AudioDeviceAttributes> devices) {
        invalidateRoutingCache();
        return AudioSystem.setDevicesRoleForCapturePreset(capturePreset, role, devices);
    }

    public int removeDevicesRoleForCapturePreset(int capturePreset, int role, List<AudioDeviceAttributes> devicesToRemove) {
        invalidateRoutingCache();
        return AudioSystem.removeDevicesRoleForCapturePreset(capturePreset, role, devicesToRemove);
    }

    public int addDevicesRoleForCapturePreset(int capturePreset, int role, List<AudioDeviceAttributes> devices) {
        invalidateRoutingCache();
        return AudioSystem.addDevicesRoleForCapturePreset(capturePreset, role, devices);
    }

    public int clearDevicesRoleForCapturePreset(int capturePreset, int role) {
        invalidateRoutingCache();
        return AudioSystem.clearDevicesRoleForCapturePreset(capturePreset, role);
    }

    public int setParameters(String keyValuePairs) {
        invalidateRoutingCache();
        return AudioSystem.setParameters(keyValuePairs);
    }

    public boolean isMicrophoneMuted() {
        return AudioSystem.isMicrophoneMuted();
    }

    public int muteMicrophone(boolean on) {
        return AudioSystem.muteMicrophone(on);
    }

    public int setCurrentImeUid(int uid) {
        return AudioSystem.setCurrentImeUid(uid);
    }

    public boolean isStreamActive(int stream, int inPastMs) {
        return AudioSystem.isStreamActive(stream, inPastMs);
    }

    public boolean isStreamActiveRemotely(int stream, int inPastMs) {
        return AudioSystem.isStreamActiveRemotely(stream, inPastMs);
    }

    public int setStreamVolumeIndexAS(int stream, int index, boolean muted, int device) {
        return AudioSystem.setStreamVolumeIndexAS(stream, index, muted, device);
    }

    public int setVolumeIndexForAttributes(AudioAttributes attributes, int index, boolean muted, int device) {
        return AudioSystem.setVolumeIndexForAttributes(attributes, index, muted, device);
    }

    public int setPhoneState(int state, int uid) {
        invalidateRoutingCache();
        return AudioSystem.setPhoneState(state, uid);
    }

    public int setAllowedCapturePolicy(int uid, int flags) {
        return AudioSystem.setAllowedCapturePolicy(uid, flags);
    }

    public int setForceUse(int usage, int config) {
        invalidateRoutingCache();
        return AudioSystem.setForceUse(usage, config);
    }

    public int getForceUse(int usage) {
        return AudioSystem.getForceUse(usage);
    }

    public int setDeviceAbsoluteVolumeEnabled(int nativeDeviceType, String address, boolean enabled, int streamToDriveAbs) {
        return AudioSystem.setDeviceAbsoluteVolumeEnabled(nativeDeviceType, address, enabled, streamToDriveAbs);
    }

    public int registerPolicyMixes(ArrayList<AudioMix> mixes, boolean register) {
        invalidateRoutingCache();
        return AudioSystem.registerPolicyMixes(mixes, register);
    }

    public List<AudioMix> getRegisteredPolicyMixes() {
        List<AudioMix> audioMixes = new ArrayList();
        int result = AudioSystem.getRegisteredPolicyMixes(audioMixes);
        if (result != 0) goto L7;
        return Collections.unmodifiableList(audioMixes);
    L7:
        throw new IllegalStateException("Cannot fetch registered policy mixes. Result: " + result);
    }

    public int updateMixingRules(AudioMix[] mixes, AudioMixingRule[] updatedMixingRules) {
        invalidateRoutingCache();
        return AudioSystem.updatePolicyMixes(mixes, updatedMixingRules);
    }

    public int setUidDeviceAffinities(int uid, int[] types, String[] addresses) {
        invalidateRoutingCache();
        return AudioSystem.setUidDeviceAffinities(uid, types, addresses);
    }

    public int removeUidDeviceAffinities(int uid) {
        invalidateRoutingCache();
        return AudioSystem.removeUidDeviceAffinities(uid);
    }

    public int setUserIdDeviceAffinities(int userId, int[] types, String[] addresses) {
        invalidateRoutingCache();
        return AudioSystem.setUserIdDeviceAffinities(userId, types, addresses);
    }

    public int removeUserIdDeviceAffinities(int userId) {
        invalidateRoutingCache();
        return AudioSystem.removeUserIdDeviceAffinities(userId);
    }

    public ISoundDose getSoundDoseInterface(ISoundDoseCallback callback) {
        return AudioSystem.getSoundDoseInterface(callback);
    }

    public int setPreferredMixerAttributes(AudioAttributes attributes, int portId, int uid, AudioMixerAttributes mixerAttributes) {
        return AudioSystem.setPreferredMixerAttributes(attributes, portId, uid, mixerAttributes);
    }

    public int clearPreferredMixerAttributes(AudioAttributes attributes, int portId, int uid) {
        return AudioSystem.clearPreferredMixerAttributes(attributes, portId, uid);
    }

    public int setMasterMute(boolean mute) {
        return AudioSystem.setMasterMute(mute);
    }

    public long listenForSystemPropertyChange(String systemPropertyName, Runnable callback) {
        return AudioSystem.listenForSystemPropertyChange(systemPropertyName, callback);
    }

    public void triggerSystemPropertyUpdate(long handle) {
        AudioSystem.triggerSystemPropertyUpdate(handle);
    }

    public int registerAudioVolumeGroupCallback(INativeAudioVolumeGroupCallback callback) {
        return AudioSystem.registerAudioVolumeGroupCallback(callback);
    }

    public int unregisterAudioVolumeGroupCallback(INativeAudioVolumeGroupCallback callback) {
        return AudioSystem.unregisterAudioVolumeGroupCallback(callback);
    }

    public void dump(PrintWriter pw) {
        pw.println("\nAudioSystemAdapter:");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd HH:mm:ss:SSS").withLocale(Locale.US).withZone(ZoneId.systemDefault());
        Object r1 = sDeviceCacheLock;
        monitor-enter(r1);
        pw.println(" last cache clear time: " + formatter.format(Instant.ofEpochMilli(this.mDevicesForAttributesCacheClearTimeMs)));     // Catch: Throwable -> L15
        pw.println(" mDevicesForAttrCache:");     // Catch: Throwable -> L15
        if (this.mDevicesForAttrCache == null) goto L23;
        Iterator<Map.Entry<Pair<AudioAttributes, Boolean>, ArrayList<AudioDeviceAttributes>>> r2 = this.mDevicesForAttrCache.entrySet().iterator();     // Catch: Throwable -> L15
    L8:
        if (r2.hasNext() == false) goto L23;
        Map.Entry<Pair<AudioAttributes, Boolean>, ArrayList<AudioDeviceAttributes>> entry = r2.next();     // Catch: Throwable -> L15
        AudioAttributes attributes = (AudioAttributes) entry.getKey().first;     // Catch: Throwable -> L15
        int stream = attributes.getVolumeControlStream();     // Catch: Throwable -> L15 IllegalArgumentException -> L17
        pw.println("\t" + attributes + " forVolume: " + entry.getKey().second + " stream: " + AudioSystem.STREAM_NAMES[stream] + "(" + stream + ")");     // Catch: Throwable -> L15 IllegalArgumentException -> L17
        Iterator<AudioDeviceAttributes> r6 = entry.getValue().iterator();     // Catch: Throwable -> L15 IllegalArgumentException -> L17
    L12:
        if (r6.hasNext() == false) goto L8;
        AudioDeviceAttributes devAttr = r6.next();     // Catch: Throwable -> L15 IllegalArgumentException -> L17
        pw.println("\t\t" + devAttr);     // Catch: Throwable -> L15 IllegalArgumentException -> L17
    L17:
        e = move-exception;
        pw.println("\t dump failed for attributes: " + attributes);     // Catch: Throwable -> L15
        Log.e(TAG, "dump failed", e);     // Catch: Throwable -> L15
    L23:
        monitor-exit(r1);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        throw th;
    }
}
