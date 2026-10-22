package com.android.server.tv;

import android.media.tv.ITvRemoteProvider;
import android.media.tv.ITvRemoteServiceInput;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.ArrayMap;
import android.util.Slog;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
final class TvRemoteServiceInput extends ITvRemoteServiceInput.Stub {
    private static final boolean DEBUG = false;
    private static final boolean DEBUG_KEYS = false;
    private static final String TAG = "TvRemoteServiceInput";
    private final Map<IBinder, UinputBridge> mBridgeMap;
    private final Object mLock;
    private final ITvRemoteProvider mProvider;

    TvRemoteServiceInput(Object lock, ITvRemoteProvider provider) {
        this.mBridgeMap = new ArrayMap();
        this.mLock = lock;
        this.mProvider = provider;
    }

    public void openInputBridge(IBinder token, String name, int width, int height, int maxPointers) {
        Object r1 = this.mLock;
        monitor-enter(r1);
    L18:
        th = move-exception;
        Throwable r11 = th;
    L46:
        monitor-exit(r1);     // Catch: Throwable -> L18
        throw r11;
    L44:
        th = move-exception;
        r11 = th;
        goto L46
    L5:
        if (this.mBridgeMap.containsKey(token) == false) goto L49;
        final IBinder token2 = token;
    L12:
        monitor-exit(r1);     // Catch: Throwable -> L18
        this.mProvider.onInputBridgeConnected(token2);     // Catch: RemoteException -> L15
        return;
    L16:
        Slog.e(TAG, "Failed remote call to onInputBridgeConnected");
        return;
    L49:
        long idToken = Binder.clearCallingIdentity();     // Catch: Throwable -> L44
        token2 = token;
        String name2 = name;
        this.mBridgeMap.put(token2, new UinputBridge(token2, name2, width, height, maxPointers));     // Catch: Throwable -> L20 RemoteException -> L22 IOException -> L24
        token2.linkToDeath(new AnonymousClass1(this, token2), 0);     // Catch: Throwable -> L20 RemoteException -> L22 IOException -> L24
        Binder.restoreCallingIdentity(idToken);     // Catch: Throwable -> L18
        goto L12
    L33:
        Slog.e(TAG, "Token is already dead");     // Catch: Throwable -> L20
        closeInputBridge(token2);     // Catch: Throwable -> L20
        Binder.restoreCallingIdentity(idToken);     // Catch: Throwable -> L18
        monitor-exit(r1);     // Catch: Throwable -> L18
        return;
    L38:
        Slog.e(TAG, "Cannot create device for " + name2);     // Catch: Throwable -> L20
        Binder.restoreCallingIdentity(idToken);     // Catch: Throwable -> L18
        monitor-exit(r1);     // Catch: Throwable -> L18
        return;
    L26:
        th = move-exception;
        IOException e = th;
    L42:
        Binder.restoreCallingIdentity(idToken);     // Catch: Throwable -> L18
        throw e;     // Catch: Throwable -> L18
    L29:
        token2 = token;
    L31:
        name2 = name;
    L20:
        th = move-exception;
        e = th;
        goto L42
    }

    public void openGamepadBridge(final IBinder token, String name) throws RemoteException {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (this.mBridgeMap.containsKey(token) == true) goto L10;
        long idToken = Binder.clearCallingIdentity();     // Catch: Throwable -> L16
        this.mBridgeMap.put(token, UinputBridge.openGamepad(token, name));     // Catch: Throwable -> L18 RemoteException -> L20 IOException -> L22
        token.linkToDeath(new AnonymousClass2(this, token), 0);     // Catch: Throwable -> L18 RemoteException -> L20 IOException -> L22
        Binder.restoreCallingIdentity(idToken);     // Catch: Throwable -> L16
        goto L10
    L18:
        th = move-exception;
        Binder.restoreCallingIdentity(idToken);     // Catch: Throwable -> L16
        throw th;     // Catch: Throwable -> L16
    L25:
        Slog.e(TAG, "Token is already dead");     // Catch: Throwable -> L18
        closeInputBridge(token);     // Catch: Throwable -> L18
        Binder.restoreCallingIdentity(idToken);     // Catch: Throwable -> L16
        return;
    L30:
        Slog.e(TAG, "Cannot create device for " + name);     // Catch: Throwable -> L18
        Binder.restoreCallingIdentity(idToken);     // Catch: Throwable -> L16
        return;
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L16
        this.mProvider.onInputBridgeConnected(token);     // Catch: RemoteException -> L13
        return;
    L14:
        Slog.e(TAG, "Failed remote call to onInputBridgeConnected");
    }

    public void closeInputBridge(IBinder token) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        UinputBridge inputBridge = this.mBridgeMap.remove(token);     // Catch: Throwable -> L9
        if (inputBridge != null) goto L11;
        Slog.w(TAG, String.format("Input bridge not found for token: %s", new Object[]{token}));     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        long idToken = Binder.clearCallingIdentity();     // Catch: Throwable -> L9
        inputBridge.close(token);     // Catch: Throwable -> L16
        Binder.restoreCallingIdentity(idToken);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L16:
        th = move-exception;
        Binder.restoreCallingIdentity(idToken);     // Catch: Throwable -> L9
        throw th;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    public void clearInputBridge(IBinder token) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        UinputBridge inputBridge = this.mBridgeMap.get(token);     // Catch: Throwable -> L9
        if (inputBridge != null) goto L11;
        Slog.w(TAG, String.format("Input bridge not found for token: %s", new Object[]{token}));     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        long idToken = Binder.clearCallingIdentity();     // Catch: Throwable -> L9
        inputBridge.clear(token);     // Catch: Throwable -> L16
        Binder.restoreCallingIdentity(idToken);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L16:
        th = move-exception;
        Binder.restoreCallingIdentity(idToken);     // Catch: Throwable -> L9
        throw th;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    public void sendTimestamp(IBinder token, long timestamp) {
    }

    public void sendKeyDown(IBinder token, int keyCode) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        UinputBridge inputBridge = this.mBridgeMap.get(token);     // Catch: Throwable -> L9
        if (inputBridge != null) goto L11;
        Slog.w(TAG, String.format("Input bridge not found for token: %s", new Object[]{token}));     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        long idToken = Binder.clearCallingIdentity();     // Catch: Throwable -> L9
        inputBridge.sendKeyDown(token, keyCode);     // Catch: Throwable -> L16
        Binder.restoreCallingIdentity(idToken);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L16:
        th = move-exception;
        Binder.restoreCallingIdentity(idToken);     // Catch: Throwable -> L9
        throw th;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    public void sendKeyUp(IBinder token, int keyCode) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        UinputBridge inputBridge = this.mBridgeMap.get(token);     // Catch: Throwable -> L9
        if (inputBridge != null) goto L11;
        Slog.w(TAG, String.format("Input bridge not found for token: %s", new Object[]{token}));     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        long idToken = Binder.clearCallingIdentity();     // Catch: Throwable -> L9
        inputBridge.sendKeyUp(token, keyCode);     // Catch: Throwable -> L16
        Binder.restoreCallingIdentity(idToken);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L16:
        th = move-exception;
        Binder.restoreCallingIdentity(idToken);     // Catch: Throwable -> L9
        throw th;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    public void sendPointerDown(IBinder token, int pointerId, int x, int y) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        UinputBridge inputBridge = this.mBridgeMap.get(token);     // Catch: Throwable -> L9
        if (inputBridge != null) goto L11;
        Slog.w(TAG, String.format("Input bridge not found for token: %s", new Object[]{token}));     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        long idToken = Binder.clearCallingIdentity();     // Catch: Throwable -> L9
        inputBridge.sendPointerDown(token, pointerId, x, y);     // Catch: Throwable -> L16
        Binder.restoreCallingIdentity(idToken);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L16:
        th = move-exception;
        Binder.restoreCallingIdentity(idToken);     // Catch: Throwable -> L9
        throw th;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    public void sendPointerUp(IBinder token, int pointerId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        UinputBridge inputBridge = this.mBridgeMap.get(token);     // Catch: Throwable -> L9
        if (inputBridge != null) goto L11;
        Slog.w(TAG, String.format("Input bridge not found for token: %s", new Object[]{token}));     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        long idToken = Binder.clearCallingIdentity();     // Catch: Throwable -> L9
        inputBridge.sendPointerUp(token, pointerId);     // Catch: Throwable -> L16
        Binder.restoreCallingIdentity(idToken);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L16:
        th = move-exception;
        Binder.restoreCallingIdentity(idToken);     // Catch: Throwable -> L9
        throw th;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    public void sendPointerSync(IBinder token) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        UinputBridge inputBridge = this.mBridgeMap.get(token);     // Catch: Throwable -> L9
        if (inputBridge != null) goto L11;
        Slog.w(TAG, String.format("Input bridge not found for token: %s", new Object[]{token}));     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        long idToken = Binder.clearCallingIdentity();     // Catch: Throwable -> L9
        inputBridge.sendPointerSync(token);     // Catch: Throwable -> L16
        Binder.restoreCallingIdentity(idToken);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L16:
        th = move-exception;
        Binder.restoreCallingIdentity(idToken);     // Catch: Throwable -> L9
        throw th;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    public void sendGamepadKeyUp(IBinder token, int keyIndex) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        UinputBridge inputBridge = this.mBridgeMap.get(token);     // Catch: Throwable -> L9
        if (inputBridge != null) goto L11;
        Slog.w(TAG, String.format("Input bridge not found for token: %s", new Object[]{token}));     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        long idToken = Binder.clearCallingIdentity();     // Catch: Throwable -> L9
        inputBridge.sendGamepadKey(token, keyIndex, false);     // Catch: Throwable -> L17
        Binder.restoreCallingIdentity(idToken);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L17:
        th = move-exception;
        Binder.restoreCallingIdentity(idToken);     // Catch: Throwable -> L9
        throw th;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    public void sendGamepadKeyDown(IBinder token, int keyCode) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        UinputBridge inputBridge = this.mBridgeMap.get(token);     // Catch: Throwable -> L9
        if (inputBridge != null) goto L11;
        Slog.w(TAG, String.format("Input bridge not found for token: %s", new Object[]{token}));     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        long idToken = Binder.clearCallingIdentity();     // Catch: Throwable -> L9
        inputBridge.sendGamepadKey(token, keyCode, true);     // Catch: Throwable -> L17
        Binder.restoreCallingIdentity(idToken);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L17:
        th = move-exception;
        Binder.restoreCallingIdentity(idToken);     // Catch: Throwable -> L9
        throw th;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    public void sendGamepadAxisValue(IBinder token, int axis, float value) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        UinputBridge inputBridge = this.mBridgeMap.get(token);     // Catch: Throwable -> L9
        if (inputBridge != null) goto L11;
        Slog.w(TAG, String.format("Input bridge not found for token: %s", new Object[]{token}));     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        long idToken = Binder.clearCallingIdentity();     // Catch: Throwable -> L9
        inputBridge.sendGamepadAxisValue(token, axis, value);     // Catch: Throwable -> L16
        Binder.restoreCallingIdentity(idToken);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L16:
        th = move-exception;
        Binder.restoreCallingIdentity(idToken);     // Catch: Throwable -> L9
        throw th;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }
}
