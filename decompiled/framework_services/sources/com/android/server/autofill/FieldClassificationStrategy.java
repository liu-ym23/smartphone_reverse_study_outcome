package com.android.server.autofill;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.res.Resources;
import android.os.Binder;
import android.os.Bundle;
import android.os.RemoteCallback;
import android.os.RemoteException;
import android.os.UserHandle;
import android.service.autofill.IAutofillFieldClassificationService;
import android.util.ArrayMap;
import android.util.Log;
import android.util.Slog;
import android.view.autofill.AutofillValue;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class FieldClassificationStrategy {
    private static final String TAG = "FieldClassificationStrategy";
    private final Context mContext;
    private final Object mLock;
    private ArrayList<Command> mQueuedCommands;
    private IAutofillFieldClassificationService mRemoteService;
    private ServiceConnection mServiceConnection;
    private final int mUserId;

    private interface Command {
        void run(IAutofillFieldClassificationService r1) throws RemoteException;
    }

    private interface MetadataParser<T> {
        T get(Resources r1, int r2);
    }

    public static /* synthetic */ void $r8$lambda$9sWXxX7cfJft1mIYxxD_LwAD8NI(RemoteCallback r0, List r1, String[] r2, String[] r3, String r4, Bundle r5, ArrayMap r6, ArrayMap r7, IAutofillFieldClassificationService r8) {
        lambda$calculateScores$2(r0, r1, r2, r3, r4, r5, r6, r7, r8);
    }

    public static /* synthetic */ String[] $r8$lambda$aJEVLsx2mFg0afcVOdCBIjG48zg(Resources r0, int r1) {
        return lambda$getAvailableAlgorithms$0(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$qj3pLd3hoFDa-51StWU71Om5Tp8, reason: not valid java name */
    public static /* synthetic */ String m2278$r8$lambda$qj3pLd3hoFDa51StWU71Om5Tp8(Resources r0, int r1) {
        return lambda$getDefaultAlgorithm$1(r0, r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m2279$$Nest$fgetmLock(FieldClassificationStrategy r0) {
        return r0.mLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmQueuedCommands, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArrayList m2280$$Nest$fgetmQueuedCommands(FieldClassificationStrategy r0) {
        return r0.mQueuedCommands;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmRemoteService, reason: not valid java name */
    static /* bridge */ /* synthetic */ IAutofillFieldClassificationService m2281$$Nest$fgetmRemoteService(FieldClassificationStrategy r0) {
        return r0.mRemoteService;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmQueuedCommands, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2282$$Nest$fputmQueuedCommands(FieldClassificationStrategy r0, ArrayList r1) {
        r0.mQueuedCommands = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmRemoteService, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2283$$Nest$fputmRemoteService(FieldClassificationStrategy r0, IAutofillFieldClassificationService r1) {
        r0.mRemoteService = r1;
    }

    public FieldClassificationStrategy(Context context, int userId) {
        this.mLock = new Object();
        this.mContext = context;
        this.mUserId = userId;
    }

    ServiceInfo getServiceInfo() {
        String packageName = this.mContext.getPackageManager().getServicesSystemSharedLibraryPackageName();
        if (packageName != null) goto L6;
        Slog.w(TAG, "no external services package!");
        return null;
    L6:
        Intent intent = new Intent("android.service.autofill.AutofillFieldClassificationService");
        intent.setPackage(packageName);
        ResolveInfo resolveInfo = this.mContext.getPackageManager().resolveService(intent, 132);
        if (resolveInfo != null) goto L9;
    L13:
        Slog.w(TAG, "No valid components found.");
        return null;
    L9:
        if (resolveInfo.serviceInfo == null) goto L13;
        return resolveInfo.serviceInfo;
    }

    private ComponentName getServiceComponentName() {
        ServiceInfo serviceInfo = getServiceInfo();
        if (serviceInfo != null) goto L5;
        return null;
    L5:
        ComponentName name = new ComponentName(serviceInfo.packageName, serviceInfo.name);
        if ("android.permission.BIND_AUTOFILL_FIELD_CLASSIFICATION_SERVICE".equals(serviceInfo.permission) == true) goto L10;
        Slog.w(TAG, name.flattenToShortString() + " does not require permission android.permission.BIND_AUTOFILL_FIELD_CLASSIFICATION_SERVICE");
        return null;
    L10:
        if (Helper.sVerbose == false) goto L12;
        Slog.v(TAG, "getServiceComponentName(): " + name);
    L12:
        return name;
    }

    void reset() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mServiceConnection == null) goto L18;
        if (Helper.sDebug == false) goto L24;
        Slog.d(TAG, "reset(): unbinding service.");     // Catch: Throwable -> L10
    L24:
        this.mContext.unbindService(this.mServiceConnection);     // Catch: Throwable -> L10 IllegalArgumentException -> L14
    L16:
        this.mServiceConnection = null;     // Catch: Throwable -> L10
    L20:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L14:
        e = move-exception;
        Slog.w(TAG, "reset(): " + e.getMessage());     // Catch: Throwable -> L10
        goto L16
    L18:
        if (Helper.sDebug == false) goto L20;
        Slog.d(TAG, "reset(): service is not bound. Do nothing.");     // Catch: Throwable -> L10
        goto L20
    }

    private void connectAndRun(Command command) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mRemoteService == null) goto L20;
    L11:
        e = move-exception;
        Slog.w(TAG, "exception calling service: " + e);     // Catch: Throwable -> L9
    L17:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L7:
        if (Helper.sVerbose == false) goto L13;
        Slog.v(TAG, "running command right away");     // Catch: Throwable -> L9 RemoteException -> L11
    L13:
        command.run(this.mRemoteService);     // Catch: Throwable -> L9 RemoteException -> L11
    L20:
        if (Helper.sDebug == false) goto L23;
        Slog.d(TAG, "service is null; queuing command");     // Catch: Throwable -> L9
    L23:
        if (this.mQueuedCommands != null) goto L25;
        this.mQueuedCommands = new ArrayList(1);     // Catch: Throwable -> L9
    L25:
        this.mQueuedCommands.add(command);     // Catch: Throwable -> L9
        if (this.mServiceConnection == null) goto L30;
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L30:
        if (Helper.sVerbose == false) goto L32;
        Slog.v(TAG, "creating connection");     // Catch: Throwable -> L9
    L32:
        this.mServiceConnection = new AnonymousClass1(this);     // Catch: Throwable -> L9
        ComponentName component = getServiceComponentName();     // Catch: Throwable -> L9
        if (Helper.sVerbose == false) goto L35;
        Slog.v(TAG, "binding to: " + component);     // Catch: Throwable -> L9
    L35:
        if (component == null) goto L46;
        Intent intent = new Intent();     // Catch: Throwable -> L9
        intent.setComponent(component);     // Catch: Throwable -> L9
        long token = Binder.clearCallingIdentity();     // Catch: Throwable -> L9
        this.mContext.bindServiceAsUser(intent, this.mServiceConnection, 1, UserHandle.of(this.mUserId));     // Catch: Throwable -> L41
        if (Helper.sVerbose == false) goto L43;
        Slog.v(TAG, "bound");     // Catch: Throwable -> L41
    L43:
        Binder.restoreCallingIdentity(token);     // Catch: Throwable -> L9
    L41:
        th = move-exception;
        Binder.restoreCallingIdentity(token);     // Catch: Throwable -> L9
        throw th;     // Catch: Throwable -> L9
    L46:
        monitor-exit(r0);     // Catch: Throwable -> L9
    }

    String[] getAvailableAlgorithms() {
        return (String[]) getMetadataValue("android.autofill.field_classification.available_algorithms", new FieldClassificationStrategy$$ExternalSyntheticLambda0());
    }

    private static /* synthetic */ String[] lambda$getAvailableAlgorithms$0(Resources res, int id) {
        return res.getStringArray(id);
    }

    private static /* synthetic */ String lambda$getDefaultAlgorithm$1(Resources res, int id) {
        return res.getString(id);
    }

    String getDefaultAlgorithm() {
        return (String) getMetadataValue("android.autofill.field_classification.default_algorithm", new FieldClassificationStrategy$$ExternalSyntheticLambda1());
    }

    private <T> T getMetadataValue(String field, MetadataParser<T> parser) {
        ServiceInfo serviceInfo = getServiceInfo();
        if (serviceInfo != null) goto L5;
        return null;
    L5:
        PackageManager pm = this.mContext.getPackageManager();
        Resources res = pm.getResourcesForApplication(serviceInfo.applicationInfo);     // Catch: PackageManager.NameNotFoundException -> L9
        int resourceId = serviceInfo.metaData.getInt(field);
        return parser.get(res, resourceId);
    L9:
        e = move-exception;
        Log.e(TAG, "Error getting application resources for " + serviceInfo, e);
        return null;
    }

    private static /* synthetic */ void lambda$calculateScores$2(RemoteCallback callback, List actualValues, String[] userDataValues, String[] categoryIds, String defaultAlgorithm, Bundle defaultArgs, ArrayMap algorithms, ArrayMap args, IAutofillFieldClassificationService service) throws RemoteException {
        service.calculateScores(callback, actualValues, userDataValues, categoryIds, defaultAlgorithm, defaultArgs, algorithms, args);
    }

    void calculateScores(final RemoteCallback callback, final List<AutofillValue> actualValues, final String[] userDataValues, final String[] categoryIds, final String defaultAlgorithm, final Bundle defaultArgs, final ArrayMap<String, String> algorithms, final ArrayMap<String, Bundle> args) {
        connectAndRun(new FieldClassificationStrategy$$ExternalSyntheticLambda2(callback, actualValues, userDataValues, categoryIds, defaultAlgorithm, defaultArgs, algorithms, args));
    }

    void dump(String prefix, PrintWriter pw) {
        ComponentName impl = getServiceComponentName();
        pw.print(prefix);
        pw.print("User ID: ");
        pw.println(this.mUserId);
        pw.print(prefix);
        pw.print("Queued commands: ");
        if (this.mQueuedCommands != null) goto L5;
        pw.println("N/A");
    L6:
        pw.print(prefix);
        pw.print("Implementation: ");
        if (impl != null) goto L10;
        pw.println("N/A");
        return;
    L10:
        pw.println(impl.flattenToShortString());
        pw.print(prefix);     // Catch: Exception -> L13
        pw.print("Available algorithms: ");     // Catch: Exception -> L13
        pw.println(Arrays.toString(getAvailableAlgorithms()));     // Catch: Exception -> L13
        pw.print(prefix);     // Catch: Exception -> L13
        pw.print("Default algorithm: ");     // Catch: Exception -> L13
        pw.println(getDefaultAlgorithm());     // Catch: Exception -> L13
        return;
    L13:
        e = move-exception;
        pw.print("ERROR CALLING SERVICE: ");
        pw.println(e);
        return;
    L5:
        pw.println(this.mQueuedCommands.size());
        goto L6
    }
}
