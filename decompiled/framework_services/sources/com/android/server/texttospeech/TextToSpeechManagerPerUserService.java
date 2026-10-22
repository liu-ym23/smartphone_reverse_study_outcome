package com.android.server.texttospeech;

import android.app.AppGlobals;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.speech.tts.ITextToSpeechService;
import android.speech.tts.ITextToSpeechSessionCallback;
import android.util.Slog;
import com.android.internal.infra.ServiceConnector;
import com.android.server.infra.AbstractPerUserSystemService;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes3.dex */
final class TextToSpeechManagerPerUserService extends AbstractPerUserSystemService<TextToSpeechManagerPerUserService, TextToSpeechManagerService> {
    private static final String TAG = null;

    private static class TextToSpeechSessionConnection extends ServiceConnector.Impl<ITextToSpeechService> {
        private ITextToSpeechSessionCallback mCallback;
        private final String mEngine;
        private final IBinder.DeathRecipient mUnbindOnDeathHandler;

        /* JADX INFO: renamed from: $r8$lambda$3-yVGMsgcEZQX1SgaZp7W8CoFnU, reason: not valid java name */
        public static /* synthetic */ void m8524$r8$lambda$3yVGMsgcEZQX1SgaZp7W8CoFnU(TextToSpeechSessionConnection r0, ITextToSpeechService r1) {
            r0.lambda$start$2(r1);
        }

        /* JADX INFO: renamed from: $r8$lambda$6CcC5lJd7vYO8_P-7a0Ju7jwqgA, reason: not valid java name */
        public static /* synthetic */ Void m8525$r8$lambda$6CcC5lJd7vYO8_P7a0Ju7jwqgA(TextToSpeechSessionConnection r0, Throwable r1) {
            return r0.lambda$start$4(r1);
        }

        public static /* synthetic */ void $r8$lambda$AOVeDAJ0WAG3YLszpwQiT9QoIic(TextToSpeechSessionConnection r0) {
            r0.lambda$start$1();
        }

        /* JADX INFO: renamed from: $r8$lambda$Xw8pqhagDopPBtux5-0bLu5kKQM, reason: not valid java name */
        public static /* synthetic */ void m8526$r8$lambda$Xw8pqhagDopPBtux50bLu5kKQM(TextToSpeechSessionConnection r0) {
            r0.lambda$new$0();
        }

        /* JADX INFO: renamed from: $r8$lambda$mYJ0LLWNqaDFfe_7N4npH3-Cys0, reason: not valid java name */
        public static /* synthetic */ void m8527$r8$lambda$mYJ0LLWNqaDFfe_7N4npH3Cys0(TextToSpeechSessionConnection r0, Throwable r1) {
            r0.lambda$start$3(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$munbindEngine, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m8528$$Nest$munbindEngine(TextToSpeechSessionConnection r0, String r1) {
            r0.unbindEngine(r1);
        }

        protected /* bridge */ /* synthetic */ void onServiceConnectionStatusChanged(IInterface r1, boolean r2) {
            onServiceConnectionStatusChanged((ITextToSpeechService) r1, r2);
        }

        static void start(Context context, int userId, String engine, ITextToSpeechSessionCallback callback) {
            new TextToSpeechSessionConnection(context, userId, engine, callback).start();
        }

        private TextToSpeechSessionConnection(Context context, int userId, String engine, ITextToSpeechSessionCallback callback) {
            super(context, new Intent("android.intent.action.TTS_SERVICE").setPackage(engine), 67633153, userId, new TextToSpeechManagerPerUserService$TextToSpeechSessionConnection$$ExternalSyntheticLambda2());
            this.mEngine = engine;
            this.mCallback = callback;
            this.mUnbindOnDeathHandler = new TextToSpeechManagerPerUserService$TextToSpeechSessionConnection$$ExternalSyntheticLambda3(this);
        }

        private /* synthetic */ void lambda$new$0() {
            unbindEngine("client process death is reported");
        }

        private void start() {
            Slog.d(TextToSpeechManagerPerUserService.m8523$$Nest$sfgetTAG(), "Trying to start connection to TTS engine: " + this.mEngine);
            connect().thenAccept(new TextToSpeechManagerPerUserService$TextToSpeechSessionConnection$$ExternalSyntheticLambda4(this)).exceptionally(new TextToSpeechManagerPerUserService$TextToSpeechSessionConnection$$ExternalSyntheticLambda5(this));
        }

        private /* synthetic */ void lambda$start$2(ITextToSpeechService serviceBinder) {
            if (serviceBinder == null) goto L8;
            Slog.d(TextToSpeechManagerPerUserService.m8523$$Nest$sfgetTAG(), "Connected successfully to TTS engine: " + this.mEngine);
            this.mCallback.onConnected(new AnonymousClass1(this), serviceBinder.asBinder());     // Catch: RemoteException -> L6
            this.mCallback.asBinder().linkToDeath(this.mUnbindOnDeathHandler, 0);     // Catch: RemoteException -> L6
            return;
        L6:
            ex = move-exception;
            Slog.w(TextToSpeechManagerPerUserService.m8523$$Nest$sfgetTAG(), "Error notifying the client on connection", ex);
            unbindEngine("failed communicating with the client - process is dead");
            return;
        L8:
            Slog.w(TextToSpeechManagerPerUserService.m8523$$Nest$sfgetTAG(), "Failed to obtain TTS engine binder");
            TextToSpeechManagerPerUserService.runSessionCallbackMethod(new TextToSpeechManagerPerUserService$TextToSpeechSessionConnection$$ExternalSyntheticLambda0(this));
        }

        private /* synthetic */ void lambda$start$1() throws RemoteException {
            this.mCallback.onError("Failed creating TTS session");
        }

        private /* synthetic */ Void lambda$start$4(final Throwable ex) {
            Slog.w(TextToSpeechManagerPerUserService.m8523$$Nest$sfgetTAG(), "TTS engine binding error", ex);
            TextToSpeechManagerPerUserService.runSessionCallbackMethod(new TextToSpeechManagerPerUserService$TextToSpeechSessionConnection$$ExternalSyntheticLambda6(this, ex));
            return null;
        }

        private /* synthetic */ void lambda$start$3(Throwable ex) throws RemoteException {
            this.mCallback.onError("Failed creating TTS session: " + ex.getCause());
        }

        protected void onServiceConnectionStatusChanged(ITextToSpeechService service, boolean connected) {
            if (connected == true) goto L12;
            Slog.w(TextToSpeechManagerPerUserService.m8523$$Nest$sfgetTAG(), "Disconnected from TTS engine");
            final ITextToSpeechSessionCallback r0 = this.mCallback;
            r0.getClass();
            TextToSpeechManagerPerUserService.runSessionCallbackMethod(new TextToSpeechManagerPerUserService$TextToSpeechSessionConnection$$ExternalSyntheticLambda1(r0));
            this.mCallback.asBinder().unlinkToDeath(this.mUnbindOnDeathHandler, 0);     // Catch: NoSuchElementException -> L6
        L8:
            this.mCallback = null;
            return;
        L7:
            Slog.d(TextToSpeechManagerPerUserService.m8523$$Nest$sfgetTAG(), "The death recipient was not linked.");
            goto L8
        }

        protected long getAutoDisconnectTimeoutMs() {
            return 0;
        }

        private void unbindEngine(String reason) {
            Slog.d(TextToSpeechManagerPerUserService.m8523$$Nest$sfgetTAG(), "Unbinding TTS engine: " + this.mEngine + ". Reason: " + reason);
            unbind();
        }
    }

    interface ThrowingRunnable {
        void runOrThrow() throws RemoteException;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetTAG, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m8523$$Nest$sfgetTAG() {
        return TAG;
    }

    static {
        TAG = TextToSpeechManagerPerUserService.class.getSimpleName();
    }

    TextToSpeechManagerPerUserService(TextToSpeechManagerService master, Object lock, int userId) {
        super(master, lock, userId);
    }

    void createSessionLocked(String engine, ITextToSpeechSessionCallback sessionCallback) {
        TextToSpeechSessionConnection.start(getContext(), this.mUserId, engine, sessionCallback);
    }

    @Override // com.android.server.infra.AbstractPerUserSystemService
    protected ServiceInfo newServiceInfoLocked(ComponentName serviceComponent) throws PackageManager.NameNotFoundException {
        return AppGlobals.getPackageManager().getServiceInfo(serviceComponent, 128, this.mUserId);
    L6:
        throw new PackageManager.NameNotFoundException("Could not get service for " + serviceComponent);
    }

    static void runSessionCallbackMethod(ThrowingRunnable callbackRunnable) {
        callbackRunnable.runOrThrow();     // Catch: RemoteException -> L4
        return;
    L4:
        ex = move-exception;
        Slog.i(TAG, "Failed running callback method: " + ex);
    }
}
