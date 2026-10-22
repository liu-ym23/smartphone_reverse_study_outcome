package com.android.server.contentsuggestions;

import android.app.contentsuggestions.ClassificationsRequest;
import android.app.contentsuggestions.IClassificationsCallback;
import android.app.contentsuggestions.ISelectionsCallback;
import android.app.contentsuggestions.SelectionsRequest;
import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.service.contentsuggestions.IContentSuggestionsService;
import android.window.TaskSnapshot;
import com.android.internal.infra.AbstractMultiplePendingRequestsRemoteService;
import com.android.internal.infra.AbstractRemoteService;

/* JADX INFO: loaded from: classes.dex */
public class RemoteContentSuggestionsService extends AbstractMultiplePendingRequestsRemoteService<RemoteContentSuggestionsService, IContentSuggestionsService> {
    private static final long TIMEOUT_REMOTE_REQUEST_MILLIS = 2000;

    interface Callbacks extends AbstractRemoteService.VultureCallback<RemoteContentSuggestionsService> {
    }

    public static /* synthetic */ void $r8$lambda$LTUeFDmDF7kqMAEZYEfsJ6jeUws(String r0, Bundle r1, IContentSuggestionsService r2) {
        lambda$notifyInteraction$3(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$On80J7VnhmH3jMEvHhDE5zj1mao(SelectionsRequest r0, ISelectionsCallback r1, IContentSuggestionsService r2) {
        lambda$suggestContentSelections$1(r0, r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$g6Un_nbUNkrxdJ9r2m-zHogGX_E, reason: not valid java name */
    public static /* synthetic */ void m3243$r8$lambda$g6Un_nbUNkrxdJ9r2mzHogGX_E(ClassificationsRequest r0, IClassificationsCallback r1, IContentSuggestionsService r2) {
        lambda$classifyContentSelections$2(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$scAORHn_UEw_9j0SGu4IWQdhyx4(int r0, TaskSnapshot r1, Bundle r2, IContentSuggestionsService r3) {
        lambda$provideContextImage$0(r0, r1, r2, r3);
    }

    protected /* bridge */ /* synthetic */ IInterface getServiceInterface(IBinder r1) {
        return m3244getServiceInterface(r1);
    }

    RemoteContentSuggestionsService(Context context, ComponentName serviceName, int userId, Callbacks callbacks, boolean bindInstantServiceAllowed, boolean verbose) {
        Handler r6 = context.getMainThreadHandler();
        if (bindInstantServiceAllowed == false) goto L6;
        int r0 = 4194304;
    L7:
        super(context, "android.service.contentsuggestions.ContentSuggestionsService", serviceName, userId, callbacks, r6, r0, verbose, 1);
        return;
    L6:
        r0 = 0;
        goto L7
    }

    /* JADX INFO: renamed from: getServiceInterface, reason: collision with other method in class */
    protected IContentSuggestionsService m3244getServiceInterface(IBinder service) {
        return IContentSuggestionsService.Stub.asInterface(service);
    }

    protected long getTimeoutIdleBindMillis() {
        return 0;
    }

    protected long getRemoteRequestMillis() {
        return 2000;
    }

    void provideContextImage(final int taskId, final TaskSnapshot snapshot, final Bundle imageContextRequestExtras) {
        scheduleAsyncRequest(new RemoteContentSuggestionsService$$ExternalSyntheticLambda1(taskId, snapshot, imageContextRequestExtras));
    }

    private static /* synthetic */ void lambda$provideContextImage$0(int taskId, TaskSnapshot snapshot, Bundle imageContextRequestExtras, IContentSuggestionsService s) throws RemoteException {
        s.provideContextImage(taskId, snapshot, imageContextRequestExtras);
        if (snapshot == null) goto L6;
        snapshot.removeReference(8);
        return;
    }

    void suggestContentSelections(final SelectionsRequest selectionsRequest, final ISelectionsCallback selectionsCallback) {
        scheduleAsyncRequest(new RemoteContentSuggestionsService$$ExternalSyntheticLambda3(selectionsRequest, selectionsCallback));
    }

    private static /* synthetic */ void lambda$suggestContentSelections$1(SelectionsRequest selectionsRequest, ISelectionsCallback selectionsCallback, IContentSuggestionsService s) throws RemoteException {
        s.suggestContentSelections(selectionsRequest, selectionsCallback);
    }

    private static /* synthetic */ void lambda$classifyContentSelections$2(ClassificationsRequest classificationsRequest, IClassificationsCallback callback, IContentSuggestionsService s) throws RemoteException {
        s.classifyContentSelections(classificationsRequest, callback);
    }

    void classifyContentSelections(final ClassificationsRequest classificationsRequest, final IClassificationsCallback callback) {
        scheduleAsyncRequest(new RemoteContentSuggestionsService$$ExternalSyntheticLambda0(classificationsRequest, callback));
    }

    private static /* synthetic */ void lambda$notifyInteraction$3(String requestId, Bundle bundle, IContentSuggestionsService s) throws RemoteException {
        s.notifyInteraction(requestId, bundle);
    }

    void notifyInteraction(final String requestId, final Bundle bundle) {
        scheduleAsyncRequest(new RemoteContentSuggestionsService$$ExternalSyntheticLambda2(requestId, bundle));
    }
}
