package com.android.server.autofill;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteCallback;
import android.os.RemoteException;
import android.service.autofill.IInlineSuggestionRenderService;
import android.service.autofill.IInlineSuggestionUiCallback;
import android.service.autofill.InlinePresentation;
import android.util.Slog;
import com.android.internal.infra.AbstractMultiplePendingRequestsRemoteService;
import com.android.internal.infra.AbstractRemoteService;

/* JADX INFO: loaded from: classes.dex */
public final class RemoteInlineSuggestionRenderService extends AbstractMultiplePendingRequestsRemoteService<RemoteInlineSuggestionRenderService, IInlineSuggestionRenderService> {
    private static final String TAG = "RemoteInlineSuggestionRenderService";
    private final long mIdleUnbindTimeoutMs;

    interface InlineSuggestionRenderCallbacks extends AbstractRemoteService.VultureCallback<RemoteInlineSuggestionRenderService> {
    }

    /* JADX INFO: renamed from: $r8$lambda$8k3ksF-uSp6UPFs7oGUfh-XhtUo, reason: not valid java name */
    public static /* synthetic */ void m2329$r8$lambda$8k3ksFuSp6UPFs7oGUfhXhtUo(RemoteCallback r0, IInlineSuggestionRenderService r1) {
        lambda$getInlineSuggestionsRendererInfo$1(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$AU37lt9_FmJzuTzM575ylljynDY(int r0, int r1, IInlineSuggestionRenderService r2) {
        lambda$destroySuggestionViews$2(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$YEEtRNwA0GJnZRVwxBAHCPmMPcc(IInlineSuggestionUiCallback r0, InlinePresentation r1, int r2, int r3, IBinder r4, int r5, int r6, int r7, IInlineSuggestionRenderService r8) {
        lambda$renderSuggestion$0(r0, r1, r2, r3, r4, r5, r6, r7, r8);
    }

    protected /* bridge */ /* synthetic */ IInterface getServiceInterface(IBinder r1) {
        return m2330getServiceInterface(r1);
    }

    RemoteInlineSuggestionRenderService(Context context, ComponentName componentName, String serviceInterface, int userId, InlineSuggestionRenderCallbacks callback, boolean bindInstantServiceAllowed, boolean verbose) {
        Handler r6 = context.getMainThreadHandler();
        if (bindInstantServiceAllowed == false) goto L6;
        int r0 = 4194304;
    L7:
        super(context, serviceInterface, componentName, userId, callback, r6, r0, verbose, 2);
        this.mIdleUnbindTimeoutMs = 0;
        ensureBound();
        return;
    L6:
        r0 = 0;
        goto L7
    }

    /* JADX INFO: renamed from: getServiceInterface, reason: collision with other method in class */
    protected IInlineSuggestionRenderService m2330getServiceInterface(IBinder service) {
        return IInlineSuggestionRenderService.Stub.asInterface(service);
    }

    protected long getTimeoutIdleBindMillis() {
        return 0;
    }

    protected void handleOnConnectedStateChanged(boolean connected) {
        if (connected == true) goto L4;
    L6:
        super.handleOnConnectedStateChanged(connected);
        return;
    L4:
        if (getTimeoutIdleBindMillis() == 0) goto L6;
        scheduleUnbind();
        goto L6
    }

    public void ensureBound() {
        scheduleBind();
    }

    private static /* synthetic */ void lambda$renderSuggestion$0(IInlineSuggestionUiCallback callback, InlinePresentation presentation, int width, int height, IBinder hostInputToken, int displayId, int userId, int sessionId, IInlineSuggestionRenderService s) throws RemoteException {
        s.renderSuggestion(callback, presentation, width, height, hostInputToken, displayId, userId, sessionId);
    }

    public void renderSuggestion(final IInlineSuggestionUiCallback callback, final InlinePresentation presentation, final int width, final int height, final IBinder hostInputToken, final int displayId, final int userId, final int sessionId) {
        scheduleAsyncRequest(new RemoteInlineSuggestionRenderService$$ExternalSyntheticLambda1(callback, presentation, width, height, hostInputToken, displayId, userId, sessionId));
    }

    private static /* synthetic */ void lambda$getInlineSuggestionsRendererInfo$1(RemoteCallback callback, IInlineSuggestionRenderService s) throws RemoteException {
        s.getInlineSuggestionsRendererInfo(callback);
    }

    public void getInlineSuggestionsRendererInfo(final RemoteCallback callback) {
        scheduleAsyncRequest(new RemoteInlineSuggestionRenderService$$ExternalSyntheticLambda0(callback));
    }

    private static /* synthetic */ void lambda$destroySuggestionViews$2(int userId, int sessionId, IInlineSuggestionRenderService s) throws RemoteException {
        s.destroySuggestionViews(userId, sessionId);
    }

    public void destroySuggestionViews(final int userId, final int sessionId) {
        scheduleAsyncRequest(new RemoteInlineSuggestionRenderService$$ExternalSyntheticLambda2(userId, sessionId));
    }

    private static ServiceInfo getServiceInfo(Context context, int userId) {
        String packageName = context.getPackageManager().getServicesSystemSharedLibraryPackageName();
        if (packageName != null) goto L6;
        Slog.w(TAG, "no external services package!");
        return null;
    L6:
        Intent intent = new Intent("android.service.autofill.InlineSuggestionRenderService");
        intent.setPackage(packageName);
        ResolveInfo resolveInfo = context.getPackageManager().resolveServiceAsUser(intent, 132, userId);
        if (resolveInfo != null) goto L9;
        ServiceInfo serviceInfo = null;
    L10:
        if (resolveInfo == null) goto L18;
        if (serviceInfo == null) goto L18;
        if ("android.permission.BIND_INLINE_SUGGESTION_RENDER_SERVICE".equals(serviceInfo.permission) == true) goto L17;
        Slog.w(TAG, serviceInfo.name + " does not require permission android.permission.BIND_INLINE_SUGGESTION_RENDER_SERVICE");
        return null;
    L17:
        return serviceInfo;
    L18:
        Slog.w(TAG, "No valid components found.");
        return null;
    L9:
        serviceInfo = resolveInfo.serviceInfo;
        goto L10
    }

    public static ComponentName getServiceComponentName(Context context, int userId) {
        ServiceInfo serviceInfo = getServiceInfo(context, userId);
        if (serviceInfo != null) goto L6;
        return null;
    L6:
        ComponentName componentName = new ComponentName(serviceInfo.packageName, serviceInfo.name);
        if (Helper.sVerbose == false) goto L9;
        Slog.v(TAG, "getServiceComponentName(): " + componentName);
    L9:
        return componentName;
    }
}
