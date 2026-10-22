package com.android.server.speech;

import android.R;
import android.content.ComponentName;
import android.content.Context;
import android.os.IBinder;
import android.os.UserHandle;
import android.speech.IRecognitionServiceManager;
import android.speech.IRecognitionServiceManagerCallback;
import android.util.Slog;
import com.android.server.infra.AbstractMasterSystemService;
import com.android.server.infra.AbstractPerUserSystemService;
import com.android.server.infra.FrameworkResourcesServiceNameResolver;

/* JADX INFO: loaded from: classes3.dex */
public final class SpeechRecognitionManagerService extends AbstractMasterSystemService<SpeechRecognitionManagerService, SpeechRecognitionManagerServiceImpl> {
    private static final int MAX_TEMP_SERVICE_SUBSTITUTION_DURATION_MS = 60000;
    private static final String TAG = null;

    final class SpeechRecognitionManagerServiceStub extends IRecognitionServiceManager.Stub {
        final /* synthetic */ SpeechRecognitionManagerService this$0;

        SpeechRecognitionManagerServiceStub(SpeechRecognitionManagerService this$0) {
            this.this$0 = this$0;
        }

        public void createSession(ComponentName componentName, IBinder clientToken, boolean onDevice, IRecognitionServiceManagerCallback callback) {
            int userId = UserHandle.getCallingUserId();
            Object r1 = SpeechRecognitionManagerService.access$000(this.this$0);
            monitor-enter(r1);
            SpeechRecognitionManagerServiceImpl service = (SpeechRecognitionManagerServiceImpl) SpeechRecognitionManagerService.access$100(this.this$0, userId);     // Catch: Throwable -> L7
            service.createSessionLocked(componentName, clientToken, onDevice, callback);     // Catch: Throwable -> L7
            monitor-exit(r1);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public void setTemporaryComponent(ComponentName componentName) {
            int userId = UserHandle.getCallingUserId();
            if (componentName != null) goto L6;
            this.this$0.resetTemporaryService(userId);
            Slog.i(SpeechRecognitionManagerService.m8293$$Nest$sfgetTAG(), "Reset temporary service for user " + userId);
            return;
        L6:
            this.this$0.setTemporaryService(userId, componentName.flattenToString(), 60000);
            Slog.i(SpeechRecognitionManagerService.m8293$$Nest$sfgetTAG(), "SpeechRecognition temporarily set to " + componentName + " for 60000ms");
        }
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetTAG, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m8293$$Nest$sfgetTAG() {
        return TAG;
    }

    static /* synthetic */ Object access$000(SpeechRecognitionManagerService x0) {
        return x0.mLock;
    }

    static /* synthetic */ AbstractPerUserSystemService access$100(SpeechRecognitionManagerService x0, int x1) {
        return x0.getServiceForUserLocked(x1);
    }

    @Override // com.android.server.infra.AbstractMasterSystemService
    protected /* bridge */ /* synthetic */ AbstractPerUserSystemService newServiceLocked(int r1, boolean r2) {
        return newServiceLocked(r1, r2);
    }

    static {
        TAG = SpeechRecognitionManagerService.class.getSimpleName();
    }

    public SpeechRecognitionManagerService(Context context) {
        super(context, new FrameworkResourcesServiceNameResolver(context, R.string.config_geofenceProviderPackageName), null);
    }

    @Override // com.android.server.SystemService
    public void onStart() {
        publishBinderService("speech_recognition", new SpeechRecognitionManagerServiceStub(this));
    }

    @Override // com.android.server.infra.AbstractMasterSystemService
    protected void enforceCallingPermissionForManagement() {
        getContext().enforceCallingPermission("android.permission.MANAGE_SPEECH_RECOGNITION", TAG);
    }

    @Override // com.android.server.infra.AbstractMasterSystemService
    protected int getMaximumTemporaryServiceDurationMs() {
        return 60000;
    }

    @Override // com.android.server.infra.AbstractMasterSystemService
    protected SpeechRecognitionManagerServiceImpl newServiceLocked(int resolvedUserId, boolean disabled) {
        return new SpeechRecognitionManagerServiceImpl(this, this.mLock, resolvedUserId);
    }
}
