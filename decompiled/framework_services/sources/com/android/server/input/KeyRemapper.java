package com.android.server.input;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.ArrayMap;
import android.util.FeatureFlagUtils;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
final class KeyRemapper {
    private static final int MSG_CLEAR_ALL_REMAPPING = 3;
    private static final int MSG_REMAP_KEY = 2;
    private static final int MSG_UPDATE_EXISTING_KEY_REMAPPING = 1;
    private final Context mContext;
    private final PersistentDataStore mDataStore;
    private final Handler mHandler;
    private final NativeInputManagerService mNative;

    public static /* synthetic */ boolean $r8$lambda$N4TqxA4BYCMFcqyr3TCvlujPC84(KeyRemapper r0, Message r1) {
        return r0.handleMessage(r1);
    }

    KeyRemapper(Context context, NativeInputManagerService nativeService, PersistentDataStore dataStore, Looper looper) {
        this.mContext = context;
        this.mNative = nativeService;
        this.mDataStore = dataStore;
        this.mHandler = new Handler(looper, new KeyRemapper$$ExternalSyntheticLambda0(this));
    }

    public void systemRunning() {
        Message.obtain(this.mHandler, 1).sendToTarget();
    }

    public void remapKey(int fromKey, int toKey) {
        if (supportRemapping() == true) goto L5;
        return;
    L5:
        Message msg = Message.obtain(this.mHandler, 2, fromKey, toKey);
        this.mHandler.sendMessage(msg);
    }

    public void clearAllKeyRemappings() {
        if (supportRemapping() == true) goto L5;
        return;
    L5:
        Message msg = Message.obtain(this.mHandler, 3);
        this.mHandler.sendMessage(msg);
    }

    public Map<Integer, Integer> getKeyRemapping() {
        if (supportRemapping() == false) goto L5;
        PersistentDataStore r0 = this.mDataStore;
        monitor-enter(r0);
        Map<Integer, Integer> r1 = this.mDataStore.getKeyRemapping();     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r1;
    L11:
        th = move-exception;
        throw th;
    L5:
        return new ArrayMap();
    }

    private void applyKeyRemapping() {
        Map<Integer, Integer> keyRemapping = getKeyRemapping();
        int index = 0;
        int[] fromKeycodesArr = new int[keyRemapping.size()];
        int[] toKeycodesArr = new int[keyRemapping.size()];
        Iterator<Map.Entry<Integer, Integer>> r4 = keyRemapping.entrySet().iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        Map.Entry<Integer, Integer> entry = r4.next();
        fromKeycodesArr[index] = entry.getKey().intValue();
        toKeycodesArr[index] = entry.getValue().intValue();
        index = index + 1;
        goto L4
    L6:
        this.mNative.setKeyRemapping(fromKeycodesArr, toKeycodesArr);
    }

    private void remapKeyInternal(int fromKey, int toKey) {
        PersistentDataStore r0 = this.mDataStore;
        monitor-enter(r0);
        if (fromKey != toKey) goto L8;
        this.mDataStore.clearMappedKey(fromKey);     // Catch: Throwable -> L6
    L9:
        this.mDataStore.saveIfNeeded();     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        applyKeyRemapping();
        return;
    L8:
        this.mDataStore.remapKey(fromKey, toKey);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        this.mDataStore.saveIfNeeded();     // Catch: Throwable -> L13
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    private void clearAllRemappingsInternal() {
        PersistentDataStore r0 = this.mDataStore;
        monitor-enter(r0);
        Map<Integer, Integer> keyRemapping = this.mDataStore.getKeyRemapping();     // Catch: Throwable -> L9
        Iterator<Integer> r2 = keyRemapping.keySet().iterator();     // Catch: Throwable -> L9
    L6:
        if (r2.hasNext() == false) goto L12;
        int fromKey = r2.next().intValue();     // Catch: Throwable -> L9
        this.mDataStore.clearMappedKey(fromKey);     // Catch: Throwable -> L9
    L12:
        this.mDataStore.saveIfNeeded();     // Catch: Throwable -> L16
        monitor-exit(r0);     // Catch: Throwable -> L16
        applyKeyRemapping();
        return;
    L16:
        th = move-exception;
        throw th;
    L9:
        th = move-exception;
        this.mDataStore.saveIfNeeded();     // Catch: Throwable -> L16
        throw th;     // Catch: Throwable -> L16
    }

    public void updateExistingKeyMapping() {
        if (supportRemapping() == true) goto L5;
        return;
    L5:
        applyKeyRemapping();
    }

    private boolean handleMessage(Message msg) {
        switch(msg.what) {
            case 1: goto L10;
            case 2: goto L8;
            case 3: goto L6;
            default: goto L4;
        };
    L4:
        return false;
    L6:
        clearAllRemappingsInternal();
        return true;
    L8:
        remapKeyInternal(msg.arg1, msg.arg2);
        return true;
    L10:
        updateExistingKeyMapping();
        return true;
    }

    private boolean supportRemapping() {
        return FeatureFlagUtils.isEnabled(this.mContext, "settings_new_keyboard_modifier_key");
    }

    public String toString() {
        return this.mDataStore.getKeyRemapping().toString();
    }
}
