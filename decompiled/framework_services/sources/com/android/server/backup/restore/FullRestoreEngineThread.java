package com.android.server.backup.restore;

import android.os.ParcelFileDescriptor;
import java.io.InputStream;
import libcore.io.IoUtils;

/* JADX INFO: loaded from: classes.dex */
class FullRestoreEngineThread implements Runnable {
    FullRestoreEngine mEngine;
    InputStream mEngineStream;
    private final boolean mMustKillAgent;

    FullRestoreEngineThread(FullRestoreEngine engine, ParcelFileDescriptor engineSocket) {
        this.mEngine = engine;
        engine.setRunning(true);
        this.mEngineStream = new ParcelFileDescriptor.AutoCloseInputStream(engineSocket);
        this.mMustKillAgent = false;
    }

    FullRestoreEngineThread(FullRestoreEngine engine, InputStream inputStream) {
        this.mEngine = engine;
        engine.setRunning(true);
        this.mEngineStream = inputStream;
        this.mMustKillAgent = true;
    }

    public boolean isRunning() {
        return this.mEngine.isRunning();
    }

    public int waitForResult() {
        return this.mEngine.waitForResult();
    }

    @Override // java.lang.Runnable
    public void run() {
    L12:
    L6:
        th = move-exception;
        IoUtils.closeQuietly(this.mEngineStream);
        throw th;
    L3:
        if (this.mEngine.isRunning() == false) goto L8;
        this.mEngine.restoreOneFile(this.mEngineStream, this.mMustKillAgent, this.mEngine.mBuffer, this.mEngine.mOnlyPackage, this.mEngine.mAllowApks, this.mEngine.mEphemeralOpToken, this.mEngine.mMonitor);     // Catch: Throwable -> L6
        goto L12
    L8:
        IoUtils.closeQuietly(this.mEngineStream);
    }

    public void handleTimeout() {
        IoUtils.closeQuietly(this.mEngineStream);
        this.mEngine.handleTimeout();
    }
}
