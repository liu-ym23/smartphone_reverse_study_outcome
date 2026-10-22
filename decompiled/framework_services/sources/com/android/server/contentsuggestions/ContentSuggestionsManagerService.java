package com.android.server.contentsuggestions;

import android.R;
import android.app.contentsuggestions.ClassificationsRequest;
import android.app.contentsuggestions.IClassificationsCallback;
import android.app.contentsuggestions.IContentSuggestionsManager;
import android.app.contentsuggestions.ISelectionsCallback;
import android.app.contentsuggestions.SelectionsRequest;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Binder;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.ShellCallback;
import android.os.UserHandle;
import android.util.Slog;
import android.window.TaskSnapshot;
import com.android.internal.os.IResultReceiver;
import com.android.server.LocalServices;
import com.android.server.infra.AbstractMasterSystemService;
import com.android.server.infra.AbstractPerUserSystemService;
import com.android.server.infra.FrameworkResourcesServiceNameResolver;
import com.android.server.wm.ActivityTaskManagerInternal;
import java.io.FileDescriptor;

/* JADX INFO: loaded from: classes.dex */
public class ContentSuggestionsManagerService extends AbstractMasterSystemService<ContentSuggestionsManagerService, ContentSuggestionsPerUserService> {
    private static final String EXTRA_BITMAP = "android.contentsuggestions.extra.BITMAP";
    private static final int MAX_TEMP_SERVICE_DURATION_MS = 120000;
    private static final String TAG = null;
    private static final boolean VERBOSE = false;
    private ActivityTaskManagerInternal mActivityTaskManagerInternal;

    private class ContentSuggestionsManagerStub extends IContentSuggestionsManager.Stub {
        final /* synthetic */ ContentSuggestionsManagerService this$0;

        /* synthetic */ ContentSuggestionsManagerStub(ContentSuggestionsManagerService r1, ContentSuggestionsManagerServiceIA r2) {
            this(r1);
        }

        private ContentSuggestionsManagerStub(ContentSuggestionsManagerService r1) {
            this.this$0 = r1;
        }

        public void provideContextBitmap(int userId, Bitmap bitmap, Bundle imageContextRequestExtras) {
            if (bitmap == null) goto L18;
            if (imageContextRequestExtras == null) goto L16;
            ContentSuggestionsManagerService.m3239$$Nest$menforceCaller(this.this$0, UserHandle.getCallingUserId(), "provideContextBitmap");
            Object r0 = ContentSuggestionsManagerService.access$000(this.this$0);
            monitor-enter(r0);
            ContentSuggestionsPerUserService service = (ContentSuggestionsPerUserService) ContentSuggestionsManagerService.access$100(this.this$0, userId);     // Catch: Throwable -> L9
            if (service == null) goto L11;
            imageContextRequestExtras.putParcelable(ContentSuggestionsManagerService.EXTRA_BITMAP, bitmap);     // Catch: Throwable -> L9
            service.provideContextImageFromBitmapLocked(imageContextRequestExtras);     // Catch: Throwable -> L9
        L11:
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L9:
            th = move-exception;
            throw th;
        L16:
            throw new IllegalArgumentException("Expected non-null imageContextRequestExtras");
        L18:
            throw new IllegalArgumentException("Expected non-null bitmap");
        }

        public void provideContextImage(int userId, int taskId, Bundle imageContextRequestExtras) {
            if (imageContextRequestExtras == null) goto L18;
            ContentSuggestionsManagerService.m3239$$Nest$menforceCaller(this.this$0, UserHandle.getCallingUserId(), "provideContextImage");
            TaskSnapshot snapshot = null;
            if (imageContextRequestExtras.containsKey(ContentSuggestionsManagerService.EXTRA_BITMAP) == true) goto L6;
            snapshot = ContentSuggestionsManagerService.m3238$$Nest$fgetmActivityTaskManagerInternal(this.this$0).getTaskSnapshotBlocking(taskId, false, 8);
        L6:
            Object r1 = ContentSuggestionsManagerService.access$200(this.this$0);
            monitor-enter(r1);
            ContentSuggestionsPerUserService service = (ContentSuggestionsPerUserService) ContentSuggestionsManagerService.access$300(this.this$0, userId);     // Catch: Throwable -> L11
            if (service == null) goto L13;
            service.provideContextImageLocked(taskId, snapshot, imageContextRequestExtras);     // Catch: Throwable -> L11
        L13:
            monitor-exit(r1);     // Catch: Throwable -> L11
            return;
        L11:
            th = move-exception;
            throw th;
        L18:
            throw new IllegalArgumentException("Expected non-null imageContextRequestExtras");
        }

        public void suggestContentSelections(int userId, SelectionsRequest selectionsRequest, ISelectionsCallback selectionsCallback) {
            ContentSuggestionsManagerService.m3239$$Nest$menforceCaller(this.this$0, UserHandle.getCallingUserId(), "suggestContentSelections");
            Object r0 = ContentSuggestionsManagerService.access$400(this.this$0);
            monitor-enter(r0);
            ContentSuggestionsPerUserService service = (ContentSuggestionsPerUserService) ContentSuggestionsManagerService.access$500(this.this$0, userId);     // Catch: Throwable -> L7
            if (service == null) goto L9;
            service.suggestContentSelectionsLocked(selectionsRequest, selectionsCallback);     // Catch: Throwable -> L7
        L9:
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public void classifyContentSelections(int userId, ClassificationsRequest classificationsRequest, IClassificationsCallback callback) {
            ContentSuggestionsManagerService.m3239$$Nest$menforceCaller(this.this$0, UserHandle.getCallingUserId(), "classifyContentSelections");
            Object r0 = ContentSuggestionsManagerService.access$600(this.this$0);
            monitor-enter(r0);
            ContentSuggestionsPerUserService service = (ContentSuggestionsPerUserService) ContentSuggestionsManagerService.access$700(this.this$0, userId);     // Catch: Throwable -> L7
            if (service == null) goto L9;
            service.classifyContentSelectionsLocked(classificationsRequest, callback);     // Catch: Throwable -> L7
        L9:
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public void notifyInteraction(int userId, String requestId, Bundle bundle) {
            ContentSuggestionsManagerService.m3239$$Nest$menforceCaller(this.this$0, UserHandle.getCallingUserId(), "notifyInteraction");
            Object r0 = ContentSuggestionsManagerService.access$800(this.this$0);
            monitor-enter(r0);
            ContentSuggestionsPerUserService service = (ContentSuggestionsPerUserService) ContentSuggestionsManagerService.access$900(this.this$0, userId);     // Catch: Throwable -> L7
            if (service == null) goto L9;
            service.notifyInteractionLocked(requestId, bundle);     // Catch: Throwable -> L7
        L9:
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public void isEnabled(int userId, IResultReceiver receiver) throws RemoteException {
            ContentSuggestionsManagerService.m3239$$Nest$menforceCaller(this.this$0, UserHandle.getCallingUserId(), "isEnabled");
            Object r0 = ContentSuggestionsManagerService.access$1000(this.this$0);
            monitor-enter(r0);
            boolean isDisabled = ContentSuggestionsManagerService.access$1100(this.this$0, userId);     // Catch: Throwable -> L11
            monitor-exit(r0);     // Catch: Throwable -> L11
            if (isDisabled == false) goto L8;
            int r1 = 0;
        L9:
            receiver.send(r1, null);
            return;
        L8:
            r1 = 1;
        L11:
            th = move-exception;
            throw th;
        }

        public void resetTemporaryService(int userId) {
            this.this$0.resetTemporaryService(userId);
        }

        public void setTemporaryService(int userId, String serviceName, int duration) {
            this.this$0.setTemporaryService(userId, serviceName, duration);
        }

        public void setDefaultServiceEnabled(int userId, boolean enabled) {
            this.this$0.setDefaultServiceEnabled(userId, enabled);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void onShellCommand(FileDescriptor in, FileDescriptor out, FileDescriptor err, String[] args, ShellCallback callback, ResultReceiver resultReceiver) throws RemoteException {
            int callingUid = Binder.getCallingUid();
            if (callingUid == 2000) goto L7;
            if (callingUid == 0) goto L7;
            Slog.e(ContentSuggestionsManagerService.m3240$$Nest$sfgetTAG(), "Expected shell caller");
            return;
        L7:
            new ContentSuggestionsManagerServiceShellCommand(this.this$0).exec(this, in, out, err, args, callback, resultReceiver);
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmActivityTaskManagerInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ ActivityTaskManagerInternal m3238$$Nest$fgetmActivityTaskManagerInternal(ContentSuggestionsManagerService r0) {
        return r0.mActivityTaskManagerInternal;
    }

    /* JADX INFO: renamed from: -$$Nest$menforceCaller, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3239$$Nest$menforceCaller(ContentSuggestionsManagerService r0, int r1, String r2) {
        r0.enforceCaller(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetTAG, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m3240$$Nest$sfgetTAG() {
        return TAG;
    }

    static /* synthetic */ Object access$000(ContentSuggestionsManagerService x0) {
        return x0.mLock;
    }

    static /* synthetic */ AbstractPerUserSystemService access$100(ContentSuggestionsManagerService x0, int x1) {
        return x0.getServiceForUserLocked(x1);
    }

    static /* synthetic */ Object access$1000(ContentSuggestionsManagerService x0) {
        return x0.mLock;
    }

    static /* synthetic */ boolean access$1100(ContentSuggestionsManagerService x0, int x1) {
        return x0.isDisabledLocked(x1);
    }

    static /* synthetic */ Object access$200(ContentSuggestionsManagerService x0) {
        return x0.mLock;
    }

    static /* synthetic */ AbstractPerUserSystemService access$300(ContentSuggestionsManagerService x0, int x1) {
        return x0.getServiceForUserLocked(x1);
    }

    static /* synthetic */ Object access$400(ContentSuggestionsManagerService x0) {
        return x0.mLock;
    }

    static /* synthetic */ AbstractPerUserSystemService access$500(ContentSuggestionsManagerService x0, int x1) {
        return x0.getServiceForUserLocked(x1);
    }

    static /* synthetic */ Object access$600(ContentSuggestionsManagerService x0) {
        return x0.mLock;
    }

    static /* synthetic */ AbstractPerUserSystemService access$700(ContentSuggestionsManagerService x0, int x1) {
        return x0.getServiceForUserLocked(x1);
    }

    static /* synthetic */ Object access$800(ContentSuggestionsManagerService x0) {
        return x0.mLock;
    }

    static /* synthetic */ AbstractPerUserSystemService access$900(ContentSuggestionsManagerService x0, int x1) {
        return x0.getServiceForUserLocked(x1);
    }

    @Override // com.android.server.infra.AbstractMasterSystemService
    protected /* bridge */ /* synthetic */ AbstractPerUserSystemService newServiceLocked(int r1, boolean r2) {
        return newServiceLocked(r1, r2);
    }

    static {
        TAG = ContentSuggestionsManagerService.class.getSimpleName();
    }

    public ContentSuggestionsManagerService(Context context) {
        super(context, new FrameworkResourcesServiceNameResolver(context, R.string.config_display_features), "no_content_suggestions");
        this.mActivityTaskManagerInternal = (ActivityTaskManagerInternal) LocalServices.getService(ActivityTaskManagerInternal.class);
    }

    @Override // com.android.server.infra.AbstractMasterSystemService
    protected ContentSuggestionsPerUserService newServiceLocked(int resolvedUserId, boolean disabled) {
        return new ContentSuggestionsPerUserService(this, this.mLock, resolvedUserId);
    }

    @Override // com.android.server.SystemService
    public void onStart() {
        publishBinderService("content_suggestions", new ContentSuggestionsManagerStub(this, null));
    }

    @Override // com.android.server.infra.AbstractMasterSystemService
    protected void enforceCallingPermissionForManagement() {
        getContext().enforceCallingPermission("android.permission.MANAGE_CONTENT_SUGGESTIONS", TAG);
    }

    @Override // com.android.server.infra.AbstractMasterSystemService
    protected int getMaximumTemporaryServiceDurationMs() {
        return MAX_TEMP_SERVICE_DURATION_MS;
    }

    private void enforceCaller(int userId, String func) {
        Context ctx = getContext();
        if (ctx.checkCallingPermission("android.permission.MANAGE_CONTENT_SUGGESTIONS") != 0) goto L5;
        return;
    L5:
        if (this.mServiceNameResolver.isTemporary(userId) == false) goto L7;
        return;
    L7:
        if (this.mActivityTaskManagerInternal.isCallerRecents(Binder.getCallingUid()) == true) goto L13;
        String msg = "Permission Denial: " + func + " from pid=" + Binder.getCallingPid() + ", uid=" + Binder.getCallingUid() + " expected caller is recents";
        Slog.w(TAG, msg);
        throw new SecurityException(msg);
    }
}
