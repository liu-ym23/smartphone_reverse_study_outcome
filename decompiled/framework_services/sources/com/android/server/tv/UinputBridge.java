package com.android.server.tv;

import android.os.IBinder;
import dalvik.system.CloseGuard;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public final class UinputBridge {
    private final CloseGuard mCloseGuard;
    private long mPtr;
    private IBinder mToken;

    private static native void nativeClear(long r0);

    private static native void nativeClose(long r0);

    private static native long nativeGamepadOpen(String r0, String r1);

    private static native long nativeOpen(String r0, String r1, int r2, int r3, int r4);

    private static native void nativeSendGamepadAxisValue(long r0, int r2, float r3);

    private static native void nativeSendGamepadKey(long r0, int r2, boolean r3);

    private static native void nativeSendKey(long r0, int r2, boolean r3);

    private static native void nativeSendPointerDown(long r0, int r2, int r3, int r4);

    private static native void nativeSendPointerSync(long r0);

    private static native void nativeSendPointerUp(long r0, int r2);

    public UinputBridge(IBinder token, String name, int width, int height, int maxPointers) throws IOException {
        this.mCloseGuard = CloseGuard.get();
        if (width < 1) goto L20;
        if (height < 1) goto L20;
        if (maxPointers < 1) goto L18;
        if (maxPointers > 32) goto L18;
        if (token == null) goto L16;
        this.mPtr = nativeOpen(name, token.toString(), width, height, maxPointers);
        if (this.mPtr == 0) goto L14;
        this.mToken = token;
        this.mCloseGuard.open("close");
        return;
    L14:
        throw new IOException("Could not open uinput device " + name);
    L16:
        throw new IllegalArgumentException("Token cannot be null");
    L18:
        throw new IllegalArgumentException("Touchpad must support between 1 and 32 pointers.");
    L20:
        throw new IllegalArgumentException("Touchpad must be at least 1x1.");
    }

    private UinputBridge(IBinder token, long ptr) {
        this.mCloseGuard = CloseGuard.get();
        this.mPtr = ptr;
        this.mToken = token;
        this.mCloseGuard.open("close");
    }

    public static UinputBridge openGamepad(IBinder token, String name) throws IOException {
        if (token == null) goto L10;
        long ptr = nativeGamepadOpen(name, token.toString());
        if (ptr == 0) goto L8;
        return new UinputBridge(token, ptr);
    L8:
        throw new IOException("Could not open uinput device " + name);
    L10:
        throw new IllegalArgumentException("Token cannot be null");
    }

    protected void finalize() throws Throwable {
        this.mCloseGuard.warnIfOpen();     // Catch: Throwable -> L6
        close(this.mToken);     // Catch: Throwable -> L6
        this.mToken = null;
        super.finalize();
        return;
    L6:
        th = move-exception;
        this.mToken = null;
        super.finalize();
        throw th;
    }

    public void close(IBinder token) {
        if (isTokenValid(token) == true) goto L5;
        return;
    L5:
        if (this.mPtr == 0) goto L9;
        clear(token);
        nativeClose(this.mPtr);
        this.mPtr = 0;
        this.mCloseGuard.close();
        return;
    }

    public IBinder getToken() {
        return this.mToken;
    }

    protected boolean isTokenValid(IBinder token) {
        return this.mToken.equals(token);
    }

    public void sendKeyDown(IBinder token, int keyCode) {
        if (isTokenValid(token) == false) goto L6;
        nativeSendKey(this.mPtr, keyCode, true);
        return;
    }

    public void sendKeyUp(IBinder token, int keyCode) {
        if (isTokenValid(token) == false) goto L6;
        nativeSendKey(this.mPtr, keyCode, false);
        return;
    }

    public void sendPointerDown(IBinder token, int pointerId, int x, int y) {
        if (isTokenValid(token) == false) goto L6;
        nativeSendPointerDown(this.mPtr, pointerId, x, y);
        return;
    }

    public void sendPointerUp(IBinder token, int pointerId) {
        if (isTokenValid(token) == false) goto L6;
        nativeSendPointerUp(this.mPtr, pointerId);
        return;
    }

    public void sendPointerSync(IBinder token) {
        if (isTokenValid(token) == false) goto L6;
        nativeSendPointerSync(this.mPtr);
        return;
    }

    public void sendGamepadKey(IBinder token, int keyCode, boolean down) {
        if (isTokenValid(token) == false) goto L6;
        nativeSendGamepadKey(this.mPtr, keyCode, down);
        return;
    }

    public void sendGamepadAxisValue(IBinder token, int axis, float value) {
        if (isTokenValid(token) == false) goto L6;
        nativeSendGamepadAxisValue(this.mPtr, axis, value);
        return;
    }

    public void clear(IBinder token) {
        if (isTokenValid(token) == false) goto L6;
        nativeClear(this.mPtr);
        return;
    }
}
