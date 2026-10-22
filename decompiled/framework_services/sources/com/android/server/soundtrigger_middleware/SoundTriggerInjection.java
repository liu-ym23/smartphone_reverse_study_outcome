package com.android.server.soundtrigger_middleware;

import android.media.soundtrigger.Phrase;
import android.media.soundtrigger.RecognitionConfig;
import android.media.soundtrigger.SoundModel;
import android.media.soundtrigger_middleware.IInjectGlobalEvent;
import android.media.soundtrigger_middleware.IInjectModelEvent;
import android.media.soundtrigger_middleware.IInjectRecognitionEvent;
import android.media.soundtrigger_middleware.ISoundTriggerInjection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Slog;

/* JADX INFO: loaded from: classes3.dex */
public class SoundTriggerInjection implements ISoundTriggerInjection, IBinder.DeathRecipient {
    private static final String TAG = "SoundTriggerInjection";
    private ISoundTriggerInjection mClient;
    private final Object mClientLock;
    private IInjectGlobalEvent mGlobalEventInjection;

    public SoundTriggerInjection() {
        this.mClientLock = new Object();
        this.mClient = null;
        this.mGlobalEventInjection = null;
    }

    public void registerClient(ISoundTriggerInjection client) {
        Object r0 = this.mClientLock;
        monitor-enter(r0);
        client.getClass();     // Catch: Throwable -> L9
        if (this.mClient != null) goto L30;
    L14:
        this.mClient = client;     // Catch: Throwable -> L9
        this.mClient.asBinder().linkToDeath(this, 0);     // Catch: Throwable -> L9 RemoteException -> L19
        if (this.mGlobalEventInjection == null) goto L24;
        this.mClient.registerGlobalEventInjection(this.mGlobalEventInjection);     // Catch: Throwable -> L9 RemoteException -> L19
    L24:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L23:
        this.mClient = null;     // Catch: Throwable -> L9
        goto L24
    L30:
        this.mClient.onPreempted();     // Catch: Throwable -> L9 RemoteException -> L11
    L13:
        this.mClient.asBinder().unlinkToDeath(this, 0);     // Catch: Throwable -> L9
        goto L14
    L11:
        e = move-exception;
        Slog.e(TAG, "RemoteException when handling preemption", e);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    @Override // android.os.IBinder.DeathRecipient
    public void binderDied() {
        Slog.wtf(TAG, "Binder died without params");
    }

    @Override // android.os.IBinder.DeathRecipient
    public void binderDied(IBinder who) {
        Object r0 = this.mClientLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mClient != null) goto L7;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L7:
        if (who != this.mClient.asBinder()) goto L11;
        this.mClient = null;     // Catch: Throwable -> L9
        goto L11
    }

    public void registerGlobalEventInjection(IInjectGlobalEvent globalInjection) {
        Object r0 = this.mClientLock;
        monitor-enter(r0);
        this.mGlobalEventInjection = globalInjection;     // Catch: Throwable -> L8
        if (this.mClient != null) goto L20;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L20:
        this.mClient.registerGlobalEventInjection(this.mGlobalEventInjection);     // Catch: Throwable -> L8 RemoteException -> L12
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L14:
        this.mClient = null;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    }

    public void onRestarted(IInjectGlobalEvent globalSession) {
        Object r0 = this.mClientLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mClient != null) goto L19;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L19:
        this.mClient.onRestarted(globalSession);     // Catch: Throwable -> L8 RemoteException -> L12
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L14:
        this.mClient = null;     // Catch: Throwable -> L8
        goto L15
    }

    public void onFrameworkDetached(IInjectGlobalEvent globalSession) {
        Object r0 = this.mClientLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mClient != null) goto L19;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L19:
        this.mClient.onFrameworkDetached(globalSession);     // Catch: Throwable -> L8 RemoteException -> L12
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L14:
        this.mClient = null;     // Catch: Throwable -> L8
        goto L15
    }

    public void onClientAttached(IBinder token, IInjectGlobalEvent globalSession) {
        Object r0 = this.mClientLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mClient != null) goto L19;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L19:
        this.mClient.onClientAttached(token, globalSession);     // Catch: Throwable -> L8 RemoteException -> L12
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L14:
        this.mClient = null;     // Catch: Throwable -> L8
        goto L15
    }

    public void onClientDetached(IBinder token) {
        Object r0 = this.mClientLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mClient != null) goto L19;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L19:
        this.mClient.onClientDetached(token);     // Catch: Throwable -> L8 RemoteException -> L12
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L14:
        this.mClient = null;     // Catch: Throwable -> L8
        goto L15
    }

    public void onSoundModelLoaded(SoundModel model, Phrase[] phrases, IInjectModelEvent modelInjection, IInjectGlobalEvent globalSession) {
        Object r0 = this.mClientLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mClient != null) goto L19;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L19:
        this.mClient.onSoundModelLoaded(model, phrases, modelInjection, globalSession);     // Catch: Throwable -> L8 RemoteException -> L12
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L14:
        this.mClient = null;     // Catch: Throwable -> L8
        goto L15
    }

    public void onParamSet(int modelParam, int value, IInjectModelEvent modelSession) {
        Object r0 = this.mClientLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mClient != null) goto L19;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L19:
        this.mClient.onParamSet(modelParam, value, modelSession);     // Catch: Throwable -> L8 RemoteException -> L12
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L14:
        this.mClient = null;     // Catch: Throwable -> L8
        goto L15
    }

    public void onRecognitionStarted(int audioSessionToken, RecognitionConfig config, IInjectRecognitionEvent recognitionInjection, IInjectModelEvent modelSession) {
        Object r0 = this.mClientLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mClient != null) goto L19;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L19:
        this.mClient.onRecognitionStarted(audioSessionToken, config, recognitionInjection, modelSession);     // Catch: Throwable -> L8 RemoteException -> L12
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L14:
        this.mClient = null;     // Catch: Throwable -> L8
        goto L15
    }

    public void onRecognitionStopped(IInjectRecognitionEvent recognitionSession) {
        Object r0 = this.mClientLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mClient != null) goto L19;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L19:
        this.mClient.onRecognitionStopped(recognitionSession);     // Catch: Throwable -> L8 RemoteException -> L12
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L14:
        this.mClient = null;     // Catch: Throwable -> L8
        goto L15
    }

    public void onSoundModelUnloaded(IInjectModelEvent modelSession) {
        Object r0 = this.mClientLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mClient != null) goto L19;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L19:
        this.mClient.onSoundModelUnloaded(modelSession);     // Catch: Throwable -> L8 RemoteException -> L12
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L14:
        this.mClient = null;     // Catch: Throwable -> L8
        goto L15
    }

    public void onPreempted() {
        Slog.wtf(TAG, "Unexpected preempted!");
    }

    public IBinder asBinder() {
        Slog.wtf(TAG, "Unexpected asBinder!");
        throw new UnsupportedOperationException("Calling asBinder on a fake binder object");
    }
}
