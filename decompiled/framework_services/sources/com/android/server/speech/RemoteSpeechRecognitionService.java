package com.android.server.speech;

import android.content.AttributionSource;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.speech.IModelDownloadListener;
import android.speech.IRecognitionListener;
import android.speech.IRecognitionService;
import android.speech.IRecognitionSupportCallback;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.util.Slog;
import com.android.internal.infra.ServiceConnector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
final class RemoteSpeechRecognitionService extends ServiceConnector.Impl<IRecognitionService> {
    private static final boolean DEBUG = false;
    private static final int MAX_CONCURRENT_CLIENTS = 100;
    private static final String TAG = null;
    private final int mCallingUid;
    private final List<Pair<IBinder, IRecognitionListener>> mClientListeners;
    private final Map<IBinder, ClientState> mClients;
    private final ComponentName mComponentName;
    private boolean mConnected;
    private final Object mLock;

    static class ClientState {
        DelegatingListener mDelegatingListener;
        boolean mRecordingInProgress;

        ClientState(DelegatingListener delegatingListener, boolean recordingInProgress) {
            this.mDelegatingListener = delegatingListener;
            this.mRecordingInProgress = recordingInProgress;
        }

        ClientState(DelegatingListener delegatingListener) {
            this(delegatingListener, true);
        }

        ClientState() {
            this(null, true);
        }

        void reset() {
            this.mDelegatingListener = null;
            this.mRecordingInProgress = false;
        }
    }

    private static class DelegatingListener extends IRecognitionListener.Stub {
        private final Runnable mOnSessionFailure;
        private final Runnable mOnSessionSuccess;
        private final IRecognitionListener mRemoteListener;

        /* JADX INFO: renamed from: -$$Nest$fgetmRemoteListener, reason: not valid java name */
        static /* bridge */ /* synthetic */ IRecognitionListener m8292$$Nest$fgetmRemoteListener(DelegatingListener r0) {
            return r0.mRemoteListener;
        }

        DelegatingListener(IRecognitionListener listener, Runnable onSessionSuccess, Runnable onSessionFailure) {
            this.mRemoteListener = listener;
            this.mOnSessionSuccess = onSessionSuccess;
            this.mOnSessionFailure = onSessionFailure;
        }

        public void onReadyForSpeech(Bundle params) throws RemoteException {
            this.mRemoteListener.onReadyForSpeech(params);
        }

        public void onBeginningOfSpeech() throws RemoteException {
            this.mRemoteListener.onBeginningOfSpeech();
        }

        public void onRmsChanged(float rmsdB) throws RemoteException {
            this.mRemoteListener.onRmsChanged(rmsdB);
        }

        public void onBufferReceived(byte[] buffer) throws RemoteException {
            this.mRemoteListener.onBufferReceived(buffer);
        }

        public void onEndOfSpeech() throws RemoteException {
            this.mRemoteListener.onEndOfSpeech();
        }

        public void onError(int error) throws RemoteException {
            this.mOnSessionFailure.run();
            this.mRemoteListener.onError(error);
        }

        public void onResults(Bundle results) throws RemoteException {
            this.mOnSessionSuccess.run();
            this.mRemoteListener.onResults(results);
        }

        public void onPartialResults(Bundle results) throws RemoteException {
            this.mRemoteListener.onPartialResults(results);
        }

        public void onSegmentResults(Bundle results) throws RemoteException {
            this.mRemoteListener.onSegmentResults(results);
        }

        public void onEndOfSegmentedSession() throws RemoteException {
            this.mOnSessionSuccess.run();
            this.mRemoteListener.onEndOfSegmentedSession();
        }

        public void onLanguageDetection(Bundle results) throws RemoteException {
            this.mRemoteListener.onLanguageDetection(results);
        }

        public void onEvent(int eventType, Bundle params) throws RemoteException {
            this.mRemoteListener.onEvent(eventType, params);
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$7yPg66Gh2dfj10yzZXlGUH-IR90, reason: not valid java name */
    public static /* synthetic */ boolean m8289$r8$lambda$7yPg66Gh2dfj10yzZXlGUHIR90(IRecognitionListener r0, Pair r1) {
        return lambda$removeClient$8(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$C7gK7zFUdNuOalCmr3xCltdTQNA(IRecognitionListener r0, boolean r1, IRecognitionService r2) {
        lambda$cancel$4(r0, r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$KnSTy4mIWNiV_QE-V1Lcocq96P4, reason: not valid java name */
    public static /* synthetic */ void m8290$r8$lambda$KnSTy4mIWNiV_QEV1Lcocq96P4(RemoteSpeechRecognitionService r0, IRecognitionListener r1) {
        r0.lambda$startListening$1(r1);
    }

    public static /* synthetic */ void $r8$lambda$Sj8fsOjE_bDRKmTMq7qwUvUr7m4(DelegatingListener r0, IRecognitionService r1) {
        lambda$stopListening$3(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$XM077MW2pg9W0-weK1UAA4Npj6A, reason: not valid java name */
    public static /* synthetic */ void m8291$r8$lambda$XM077MW2pg9W0weK1UAA4Npj6A(RemoteSpeechRecognitionService r0, ClientState r1) {
        r0.lambda$startListening$0(r1);
    }

    public static /* synthetic */ void $r8$lambda$dH3jy9Viz6DNximeH0j3uusXx50(RemoteSpeechRecognitionService r0, IRecognitionService r1) {
        r0.lambda$cancel$5(r1);
    }

    public static /* synthetic */ void $r8$lambda$nMTyE_c6w6YDml4k8aSHwBkNZIg(Intent r0, DelegatingListener r1, AttributionSource r2, IRecognitionService r3) {
        lambda$startListening$2(r0, r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$rdvZF0KUgSx1ik1ydVid10sMmmU(Intent r0, AttributionSource r1, IRecognitionSupportCallback r2, IRecognitionService r3) {
        lambda$checkRecognitionSupport$6(r0, r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$zDMfOJBHsbmRMADRLPUDaZeM5nc(Intent r0, AttributionSource r1, IModelDownloadListener r2, IRecognitionService r3) {
        lambda$triggerModelDownload$7(r0, r1, r2, r3);
    }

    protected /* bridge */ /* synthetic */ void onServiceConnectionStatusChanged(IInterface r1, boolean r2) {
        onServiceConnectionStatusChanged((IRecognitionService) r1, r2);
    }

    static {
        TAG = RemoteSpeechRecognitionService.class.getSimpleName();
    }

    RemoteSpeechRecognitionService(Context context, ComponentName serviceName, int userId, int callingUid, boolean isPrivileged) {
        super(context, new Intent("android.speech.RecognitionService").setComponent(serviceName), getBindingFlags(isPrivileged), userId, new RemoteSpeechRecognitionService$$ExternalSyntheticLambda8());
        this.mLock = new Object();
        this.mConnected = false;
        this.mClients = new HashMap();
        this.mClientListeners = new ArrayList();
        this.mCallingUid = callingUid;
        this.mComponentName = serviceName;
    }

    private static int getBindingFlags(boolean isPrivileged) {
        if (isPrivileged == false) goto L6;
        int bindingFlags = 1 | 67112960;
        return bindingFlags;
    L6:
        return 1;
    }

    ComponentName getServiceComponentName() {
        return this.mComponentName;
    }

    void startListening(final Intent recognizerIntent, final IRecognitionListener listener, final AttributionSource attributionSource) {
        if (listener != null) goto L6;
        Slog.w(TAG, "#startListening called with no preceding #setListening - ignoring.");
        return;
    L6:
        if (this.mConnected == true) goto L9;
        tryRespondWithError(listener, 11);
        return;
    L9:
        Object r0 = this.mLock;
        monitor-enter(r0);
        ClientState clientState = this.mClients.get(listener.asBinder());     // Catch: Throwable -> L18
        if (clientState != null) goto L22;
        if (this.mClients.size() < 100) goto L20;
        tryRespondWithError(listener, 8);     // Catch: Throwable -> L18
        Log.i(TAG, "#startListening received when the recognizer's capacity is full - ignoring this call.");     // Catch: Throwable -> L18
        monitor-exit(r0);     // Catch: Throwable -> L18
        return;
    L20:
        final ClientState newClientState = new ClientState();     // Catch: Throwable -> L18
        newClientState.mDelegatingListener = new DelegatingListener(listener, new RemoteSpeechRecognitionService$$ExternalSyntheticLambda3(this, newClientState), new RemoteSpeechRecognitionService$$ExternalSyntheticLambda4(this, listener));     // Catch: Throwable -> L18
        this.mClients.put(listener.asBinder(), newClientState);     // Catch: Throwable -> L18
        clientState = newClientState;
    L27:
        final DelegatingListener listenerToStart = clientState.mDelegatingListener;     // Catch: Throwable -> L18
        run(new RemoteSpeechRecognitionService$$ExternalSyntheticLambda5(recognizerIntent, listenerToStart, attributionSource));     // Catch: Throwable -> L18
        monitor-exit(r0);     // Catch: Throwable -> L18
        return;
    L22:
        if (clientState.mRecordingInProgress == false) goto L26;
        Slog.i(TAG, "#startListening called while listening is in progress for this caller.");     // Catch: Throwable -> L18
        tryRespondWithError(listener, 5);     // Catch: Throwable -> L18
        monitor-exit(r0);     // Catch: Throwable -> L18
        return;
    L26:
        clientState.mRecordingInProgress = true;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$startListening$0(ClientState newClientState) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        newClientState.mRecordingInProgress = false;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$startListening$1(IRecognitionListener listener) {
        removeClient(listener);
    }

    private static /* synthetic */ void lambda$startListening$2(Intent recognizerIntent, DelegatingListener listenerToStart, AttributionSource attributionSource, IRecognitionService service) throws Exception {
        service.startListening(recognizerIntent, listenerToStart, attributionSource);
    }

    void stopListening(IRecognitionListener listener) {
        if (this.mConnected == true) goto L6;
        tryRespondWithError(listener, 11);
        return;
    L6:
        Object r0 = this.mLock;
        monitor-enter(r0);
        ClientState clientState = this.mClients.get(listener.asBinder());     // Catch: Throwable -> L13
        if (clientState != null) goto L16;
        Slog.w(TAG, "#stopListening called with no preceding #startListening - ignoring.");     // Catch: Throwable -> L13
        tryRespondWithError(listener, 5);     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L16:
        if (clientState.mRecordingInProgress == true) goto L20;
        tryRespondWithError(listener, 5);     // Catch: Throwable -> L13
        Slog.i(TAG, "#stopListening called while listening isn't in progress - ignoring.");     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L20:
        clientState.mRecordingInProgress = false;     // Catch: Throwable -> L13
        final DelegatingListener listenerToStop = clientState.mDelegatingListener;     // Catch: Throwable -> L13
        run(new RemoteSpeechRecognitionService$$ExternalSyntheticLambda7(listenerToStop));     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ void lambda$stopListening$3(DelegatingListener listenerToStop, IRecognitionService service) throws Exception {
        service.stopListening(listenerToStop);
    }

    void cancel(IRecognitionListener listener, final boolean isShutdown) {
        if (this.mConnected == true) goto L5;
        tryRespondWithError(listener, 11);
    L5:
        Object r0 = this.mLock;
        monitor-enter(r0);
        ClientState clientState = this.mClients.get(listener.asBinder());     // Catch: Throwable -> L10
        if (clientState == null) goto L12;
        clientState.mRecordingInProgress = false;     // Catch: Throwable -> L10
        final DelegatingListener r2 = clientState.mDelegatingListener;     // Catch: Throwable -> L10
        run(new RemoteSpeechRecognitionService$$ExternalSyntheticLambda1(r2, isShutdown));     // Catch: Throwable -> L10
    L12:
        if (isShutdown == false) goto L16;
        removeClient(listener);     // Catch: Throwable -> L10
        if (this.mClients.isEmpty() == false) goto L16;
        run(new RemoteSpeechRecognitionService$$ExternalSyntheticLambda2(this));     // Catch: Throwable -> L10
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ void lambda$cancel$4(IRecognitionListener delegatingListener, boolean isShutdown, IRecognitionService service) throws Exception {
        service.cancel(delegatingListener, isShutdown);
    }

    private /* synthetic */ void lambda$cancel$5(IRecognitionService service) throws Exception {
        unbind();
    }

    void checkRecognitionSupport(final Intent recognizerIntent, final AttributionSource attributionSource, final IRecognitionSupportCallback callback) {
        if (this.mConnected == false) goto L12;
        run(new RemoteSpeechRecognitionService$$ExternalSyntheticLambda0(recognizerIntent, attributionSource, callback));
        return;
    L12:
        callback.onError(11);     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        Slog.w(TAG, "Failed to report the connection broke to the caller.", e);
        e.printStackTrace();
    }

    private static /* synthetic */ void lambda$checkRecognitionSupport$6(Intent recognizerIntent, AttributionSource attributionSource, IRecognitionSupportCallback callback, IRecognitionService service) throws Exception {
        service.checkRecognitionSupport(recognizerIntent, attributionSource, callback);
    }

    void triggerModelDownload(final Intent recognizerIntent, final AttributionSource attributionSource, final IModelDownloadListener listener) {
        if (this.mConnected == false) goto L12;
        run(new RemoteSpeechRecognitionService$$ExternalSyntheticLambda6(recognizerIntent, attributionSource, listener));
        return;
    L12:
        listener.onError(11);     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        Slog.w(TAG, "#downloadModel failed due to connection.", e);
        e.printStackTrace();
    }

    private static /* synthetic */ void lambda$triggerModelDownload$7(Intent recognizerIntent, AttributionSource attributionSource, IModelDownloadListener listener, IRecognitionService service) throws Exception {
        service.triggerModelDownload(recognizerIntent, attributionSource, listener);
    }

    void shutdown(IBinder clientToken) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        Iterator<Pair<IBinder, IRecognitionListener>> r1 = this.mClientListeners.iterator();     // Catch: Throwable -> L10
    L6:
        if (r1.hasNext() == false) goto L13;
        Pair<IBinder, IRecognitionListener> clientListener = r1.next();     // Catch: Throwable -> L10
        if (clientListener.first != clientToken) goto L6;
        cancel((IRecognitionListener) clientListener.second, true);     // Catch: Throwable -> L10
        goto L6
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    protected void onServiceConnectionStatusChanged(IRecognitionService service, boolean connected) {
        this.mConnected = connected;
        Object r0 = this.mLock;
        monitor-enter(r0);
        if (connected == false) goto L19;
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L19:
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.mClients.isEmpty() == false) goto L12;
        Slog.i(TAG, "Connection to speech recognition service lost, but no #startListening has been invoked yet.");     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L12:
        int r2 = 0;
        ClientState[] r1 = (ClientState[]) this.mClients.values().toArray(new ClientState[0]);     // Catch: Throwable -> L10
        int r3 = r1.length;     // Catch: Throwable -> L10
    L13:
        if (r2 >= r3) goto L15;
        ClientState clientState = r1[r2];     // Catch: Throwable -> L10
        tryRespondWithError(DelegatingListener.m8292$$Nest$fgetmRemoteListener(clientState.mDelegatingListener), 11);     // Catch: Throwable -> L10
        removeClient(DelegatingListener.m8292$$Nest$fgetmRemoteListener(clientState.mDelegatingListener));     // Catch: Throwable -> L10
        r2 = r2 + 1;     // Catch: Throwable -> L10
        goto L13
    }

    protected long getAutoDisconnectTimeoutMs() {
        return 0;
    }

    private void removeClient(final IRecognitionListener listener) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        ClientState clientState = this.mClients.remove(listener.asBinder());     // Catch: Throwable -> L7
        if (clientState == null) goto L9;
        clientState.reset();     // Catch: Throwable -> L7
    L9:
        this.mClientListeners.removeIf(new RemoteSpeechRecognitionService$$ExternalSyntheticLambda9(listener));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ boolean lambda$removeClient$8(IRecognitionListener listener, Pair clientListener) {
        if (clientListener.second != listener) goto L5;
        return true;
    L5:
        return false;
    }

    private static void tryRespondWithError(IRecognitionListener listener, int errorCode) {
        if (listener == null) goto L11;
        listener.onError(errorCode);     // Catch: RemoteException -> L5
        return;
    L5:
        e = move-exception;
        Slog.w(TAG, TextUtils.formatSimple("Failed to respond with an error %d to the client", new Object[]{Integer.valueOf(errorCode)}), e);
        return;
    }

    boolean hasActiveSessions() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mClients.isEmpty() == true) goto L7;
        boolean r1 = true;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r1;
    L7:
        r1 = false;
        goto L8
    }

    void associateClientWithActiveListener(IBinder clientToken, IRecognitionListener listener) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mClients.containsKey(listener.asBinder()) == false) goto L9;
        this.mClientListeners.add(new Pair(clientToken, listener));     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
    }
}
