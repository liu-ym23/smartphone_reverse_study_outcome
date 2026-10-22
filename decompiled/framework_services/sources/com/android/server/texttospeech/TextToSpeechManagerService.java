package com.android.server.texttospeech;

import android.content.Context;
import android.os.RemoteException;
import android.os.UserHandle;
import android.speech.tts.ITextToSpeechManager;
import android.speech.tts.ITextToSpeechSessionCallback;
import com.android.server.infra.AbstractMasterSystemService;
import com.android.server.infra.AbstractPerUserSystemService;

/* JADX INFO: loaded from: classes3.dex */
public final class TextToSpeechManagerService extends AbstractMasterSystemService<TextToSpeechManagerService, TextToSpeechManagerPerUserService> {
    private static final String TAG = null;

    private final class TextToSpeechManagerServiceStub extends ITextToSpeechManager.Stub {
        final /* synthetic */ TextToSpeechManagerService this$0;

        public static /* synthetic */ void $r8$lambda$McysofB3DPRWNoOiGG0Nnf59nbs(ITextToSpeechSessionCallback r0) {
            lambda$createSession$0(r0);
        }

        public static /* synthetic */ void $r8$lambda$Qpdn0QL9a4JWwPyvOSRBIwgJMnY(ITextToSpeechSessionCallback r0) {
            lambda$createSession$1(r0);
        }

        /* synthetic */ TextToSpeechManagerServiceStub(TextToSpeechManagerService r1, TextToSpeechManagerServiceIA r2) {
            this(r1);
        }

        private TextToSpeechManagerServiceStub(TextToSpeechManagerService r1) {
            this.this$0 = r1;
        }

        public void createSession(String engine, final ITextToSpeechSessionCallback sessionCallback) {
            Object r0 = TextToSpeechManagerService.access$000(this.this$0);
            monitor-enter(r0);
            if (engine != null) goto L10;
            TextToSpeechManagerPerUserService.runSessionCallbackMethod(new TextToSpeechManagerService$TextToSpeechManagerServiceStub$$ExternalSyntheticLambda0(sessionCallback));     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L10:
            TextToSpeechManagerPerUserService perUserService = (TextToSpeechManagerPerUserService) TextToSpeechManagerService.access$100(this.this$0, UserHandle.getCallingUserId());     // Catch: Throwable -> L8
            if (perUserService == null) goto L13;
            perUserService.createSessionLocked(engine, sessionCallback);     // Catch: Throwable -> L8
        L14:
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L13:
            TextToSpeechManagerPerUserService.runSessionCallbackMethod(new TextToSpeechManagerService$TextToSpeechManagerServiceStub$$ExternalSyntheticLambda1(sessionCallback));     // Catch: Throwable -> L8
        L8:
            th = move-exception;
            throw th;
        }

        private static /* synthetic */ void lambda$createSession$0(ITextToSpeechSessionCallback sessionCallback) throws RemoteException {
            sessionCallback.onError("Engine cannot be null");
        }

        private static /* synthetic */ void lambda$createSession$1(ITextToSpeechSessionCallback sessionCallback) throws RemoteException {
            sessionCallback.onError("Service is not available for user");
        }
    }

    static /* synthetic */ Object access$000(TextToSpeechManagerService x0) {
        return x0.mLock;
    }

    static /* synthetic */ AbstractPerUserSystemService access$100(TextToSpeechManagerService x0, int x1) {
        return x0.getServiceForUserLocked(x1);
    }

    @Override // com.android.server.infra.AbstractMasterSystemService
    protected /* bridge */ /* synthetic */ AbstractPerUserSystemService newServiceLocked(int r1, boolean r2) {
        return newServiceLocked(r1, r2);
    }

    static {
        TAG = TextToSpeechManagerService.class.getSimpleName();
    }

    public TextToSpeechManagerService(Context context) {
        super(context, null, null);
    }

    @Override // com.android.server.SystemService
    public void onStart() {
        publishBinderService("texttospeech", new TextToSpeechManagerServiceStub(this, null));
    }

    @Override // com.android.server.infra.AbstractMasterSystemService
    protected TextToSpeechManagerPerUserService newServiceLocked(int resolvedUserId, boolean disabled) {
        return new TextToSpeechManagerPerUserService(this, this.mLock, resolvedUserId);
    }
}
