package com.android.server.contentsuggestions;

import android.app.AppGlobals;
import android.app.contentsuggestions.ClassificationsRequest;
import android.app.contentsuggestions.IClassificationsCallback;
import android.app.contentsuggestions.ISelectionsCallback;
import android.app.contentsuggestions.SelectionsRequest;
import android.content.ComponentName;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Slog;
import android.window.TaskSnapshot;
import com.android.server.infra.AbstractPerUserSystemService;

/* JADX INFO: loaded from: classes.dex */
public final class ContentSuggestionsPerUserService extends AbstractPerUserSystemService<ContentSuggestionsPerUserService, ContentSuggestionsManagerService> {
    private static final String TAG = null;
    private RemoteContentSuggestionsService mRemoteService;

    /* JADX INFO: renamed from: -$$Nest$mupdateRemoteServiceLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3241$$Nest$mupdateRemoteServiceLocked(ContentSuggestionsPerUserService r0) {
        r0.updateRemoteServiceLocked();
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetTAG, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m3242$$Nest$sfgetTAG() {
        return TAG;
    }

    static {
        TAG = ContentSuggestionsPerUserService.class.getSimpleName();
    }

    ContentSuggestionsPerUserService(ContentSuggestionsManagerService master, Object lock, int userId) {
        super(master, lock, userId);
    }

    @Override // com.android.server.infra.AbstractPerUserSystemService
    protected ServiceInfo newServiceInfoLocked(ComponentName serviceComponent) throws PackageManager.NameNotFoundException {
        ServiceInfo si = AppGlobals.getPackageManager().getServiceInfo(serviceComponent, 128, this.mUserId);     // Catch: RemoteException -> L8
        if ("android.permission.BIND_CONTENT_SUGGESTIONS_SERVICE".equals(si.permission) == false) goto L6;
        return si;
    L6:
        Slog.w(TAG, "ContentSuggestionsService from '" + si.packageName + "' does not require permission android.permission.BIND_CONTENT_SUGGESTIONS_SERVICE");
        throw new SecurityException("Service does not require permission android.permission.BIND_CONTENT_SUGGESTIONS_SERVICE");
    L10:
        throw new PackageManager.NameNotFoundException("Could not get service for " + serviceComponent);
    }

    @Override // com.android.server.infra.AbstractPerUserSystemService
    protected boolean updateLocked(boolean disabled) {
        boolean enabledChanged = super.updateLocked(disabled);
        updateRemoteServiceLocked();
        return enabledChanged;
    }

    void provideContextImageFromBitmapLocked(Bundle bitmapContainingExtras) {
        provideContextImageLocked(-1, null, bitmapContainingExtras);
    }

    void provideContextImageLocked(int taskId, TaskSnapshot snapshot, Bundle imageContextRequestExtras) {
        RemoteContentSuggestionsService service = ensureRemoteServiceLocked();
        if (service == null) goto L6;
        service.provideContextImage(taskId, snapshot, imageContextRequestExtras);
        return;
    }

    void suggestContentSelectionsLocked(SelectionsRequest selectionsRequest, ISelectionsCallback selectionsCallback) {
        RemoteContentSuggestionsService service = ensureRemoteServiceLocked();
        if (service == null) goto L6;
        service.suggestContentSelections(selectionsRequest, selectionsCallback);
        return;
    }

    void classifyContentSelectionsLocked(ClassificationsRequest classificationsRequest, IClassificationsCallback callback) {
        RemoteContentSuggestionsService service = ensureRemoteServiceLocked();
        if (service == null) goto L6;
        service.classifyContentSelections(classificationsRequest, callback);
        return;
    }

    void notifyInteractionLocked(String requestId, Bundle bundle) {
        RemoteContentSuggestionsService service = ensureRemoteServiceLocked();
        if (service == null) goto L6;
        service.notifyInteraction(requestId, bundle);
        return;
    }

    private void updateRemoteServiceLocked() {
        if (this.mRemoteService == null) goto L6;
        this.mRemoteService.destroy();
        this.mRemoteService = null;
        return;
    }

    private RemoteContentSuggestionsService ensureRemoteServiceLocked() {
        if (this.mRemoteService != null) goto L13;
        String serviceName = getComponentNameLocked();
        if (serviceName == null) goto L7;
        ComponentName serviceComponent = ComponentName.unflattenFromString(serviceName);
        this.mRemoteService = new RemoteContentSuggestionsService(getContext(), serviceComponent, this.mUserId, new AnonymousClass1(this), ((ContentSuggestionsManagerService) this.mMaster).isBindInstantServiceAllowed(), ((ContentSuggestionsManagerService) this.mMaster).verbose);
        goto L13
    L7:
        if (((ContentSuggestionsManagerService) this.mMaster).verbose == false) goto L14;
        Slog.v(TAG, "ensureRemoteServiceLocked(): not set");
        return null;
    L14:
        return null;
    L13:
        return this.mRemoteService;
    }
}
