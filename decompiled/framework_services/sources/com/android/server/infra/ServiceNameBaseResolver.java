package com.android.server.infra;

import android.app.AppGlobals;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ServiceInfo;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Slog;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.TimeUtils;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ServiceNameBaseResolver implements ServiceNameResolver {
    private static final int MSG_RESET_TEMPORARY_SERVICE = 0;
    private static final String TAG = null;
    protected final Context mContext;
    protected final SparseBooleanArray mDefaultServicesDisabled;
    protected final boolean mIsMultiple;
    protected final Object mLock;
    private ServiceNameResolver.NameResolverListener mOnSetCallback;
    private Handler mTemporaryHandler;
    private long mTemporaryServiceExpiration;
    protected final SparseArray<String[]> mTemporaryServiceNamesList;

    /* JADX INFO: renamed from: -$$Nest$sfgetTAG, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m4463$$Nest$sfgetTAG() {
        return TAG;
    }

    public abstract String readServiceName(int r1);

    public abstract String[] readServiceNameList(int r1);

    static {
        TAG = ServiceNameBaseResolver.class.getSimpleName();
    }

    protected ServiceNameBaseResolver(Context context, boolean isMultiple) {
        this.mLock = new Object();
        this.mTemporaryServiceNamesList = new SparseArray();
        this.mDefaultServicesDisabled = new SparseBooleanArray();
        this.mContext = context;
        this.mIsMultiple = isMultiple;
    }

    @Override // com.android.server.infra.ServiceNameResolver
    public void setOnTemporaryServiceNameChangedCallback(ServiceNameResolver.NameResolverListener callback) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mOnSetCallback = callback;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.infra.ServiceNameResolver
    public String getServiceName(int userId) {
        String[] serviceNames = getServiceNameList(userId);
        if (serviceNames != null) goto L5;
    L8:
        return null;
    L5:
        if (serviceNames.length == 0) goto L8;
        return serviceNames[0];
    }

    @Override // com.android.server.infra.ServiceNameResolver
    public String getDefaultServiceName(int userId) {
        String[] serviceNames = getDefaultServiceNameList(userId);
        if (serviceNames != null) goto L5;
    L8:
        return null;
    L5:
        if (serviceNames.length == 0) goto L8;
        return serviceNames[0];
    }

    @Override // com.android.server.infra.ServiceNameResolver
    public String[] getServiceNameList(int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        String[] temporaryNames = this.mTemporaryServiceNamesList.get(userId);     // Catch: Throwable -> L9
        if (temporaryNames == null) goto L11;
        Slog.w(TAG, "getServiceName(): using temporary name " + Arrays.toString(temporaryNames) + " for user " + userId);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return temporaryNames;
    L11:
        boolean disabled = this.mDefaultServicesDisabled.get(userId);     // Catch: Throwable -> L9
        if (disabled == false) goto L17;
        Slog.w(TAG, "getServiceName(): temporary name not set and default disabled for user " + userId);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return null;
    L17:
        String[] r3 = getDefaultServiceNameList(userId);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r3;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.infra.ServiceNameResolver
    public String[] getDefaultServiceNameList(int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (this.mIsMultiple == false) goto L28;
        String[] serviceNameList = readServiceNameList(userId);     // Catch: Throwable -> L17
        List<String> validatedServiceNameList = new ArrayList();     // Catch: Throwable -> L17
        int i = 0;
    L37:
    L19:
        e = move-exception;
        Slog.e(TAG, "Could not validate provided services.", e);     // Catch: Throwable -> L17
    L25:
        String[] validatedServiceNameArray = new String[validatedServiceNameList.size()];     // Catch: Throwable -> L17
        String[] r4 = (String[]) validatedServiceNameList.toArray(validatedServiceNameArray);     // Catch: Throwable -> L17
        monitor-exit(r0);     // Catch: Throwable -> L17
        return r4;
    L9:
        if (i >= serviceNameList.length) goto L25;
        if (TextUtils.isEmpty(serviceNameList[i]) == true) goto L21;
        ComponentName serviceComponent = ComponentName.unflattenFromString(serviceNameList[i]);     // Catch: Throwable -> L17 Exception -> L19
        ServiceInfo serviceInfo = AppGlobals.getPackageManager().getServiceInfo(serviceComponent, 786432, userId);     // Catch: Throwable -> L17 Exception -> L19
        if (serviceInfo == null) goto L21;
        validatedServiceNameList.add(serviceNameList[i]);     // Catch: Throwable -> L17 Exception -> L19
    L21:
        i = i + 1;
        goto L37
    L28:
        String name = readServiceName(userId);     // Catch: Throwable -> L17
        if (TextUtils.isEmpty(name) == false) goto L31;
        String[] r2 = new String[0];     // Catch: Throwable -> L17
    L32:
        monitor-exit(r0);     // Catch: Throwable -> L17
        return r2;
    L31:
        r2 = new String[]{name};     // Catch: Throwable -> L17
        goto L32
    }

    @Override // com.android.server.infra.ServiceNameResolver
    public boolean isConfiguredInMultipleMode() {
        return this.mIsMultiple;
    }

    @Override // com.android.server.infra.ServiceNameResolver
    public boolean isTemporary(int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mTemporaryServiceNamesList.get(userId) == null) goto L7;
        boolean r1 = true;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r1;
    L7:
        r1 = false;
        goto L8
    }

    @Override // com.android.server.infra.ServiceNameResolver
    public void setTemporaryService(int userId, String componentName, int durationMs) {
        setTemporaryServices(userId, new String[]{componentName}, durationMs);
    }

    @Override // com.android.server.infra.ServiceNameResolver
    public void setTemporaryServices(int userId, String[] componentNames, int durationMs) {
        Object r1 = this.mLock;
        monitor-enter(r1);
        this.mTemporaryServiceNamesList.put(userId, componentNames);     // Catch: Throwable -> L11
        if (this.mTemporaryHandler != null) goto L13;
        final Looper r5 = Looper.getMainLooper();     // Catch: Throwable -> L11
        final Handler.Callback r6 = null;
        final boolean r7 = true;
        final ServiceNameBaseResolver r4 = this;
        final int userId2 = userId;
        r4.mTemporaryHandler = new AnonymousClass1(r4, r5, r6, r7, userId2);     // Catch: Throwable -> L9
    L14:
        r4.mTemporaryServiceExpiration = SystemClock.elapsedRealtime() + ((long) durationMs);     // Catch: Throwable -> L9
        r4.mTemporaryHandler.sendEmptyMessageDelayed(0, durationMs);     // Catch: Throwable -> L9
        int i = 0;
    L16:
        if (i >= componentNames.length) goto L19;
        notifyTemporaryServiceNameChangedLocked(userId2, componentNames[i], true);     // Catch: Throwable -> L9
        i = i + 1;     // Catch: Throwable -> L9
        goto L16
    L19:
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L13:
        r4 = this;
        userId2 = userId;
        r4.mTemporaryHandler.removeMessages(0);     // Catch: Throwable -> L9
    L11:
        th = move-exception;
        Throwable r12 = th;
    L21:
        monitor-exit(r1);     // Catch: Throwable -> L9
        throw r12;
    L9:
        th = move-exception;
        r12 = th;
        goto L21
    }

    @Override // com.android.server.infra.ServiceNameResolver
    public void resetTemporaryService(int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        Slog.i(TAG, "resetting temporary service for user " + userId + " from " + Arrays.toString(this.mTemporaryServiceNamesList.get(userId)));     // Catch: Throwable -> L7
        this.mTemporaryServiceNamesList.remove(userId);     // Catch: Throwable -> L7
        if (this.mTemporaryHandler == null) goto L9;
        this.mTemporaryHandler.removeMessages(0);     // Catch: Throwable -> L7
        this.mTemporaryHandler = null;     // Catch: Throwable -> L7
    L9:
        notifyTemporaryServiceNameChangedLocked(userId, null, false);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.infra.ServiceNameResolver
    public boolean setDefaultServiceEnabled(int userId, boolean enabled) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean currentlyEnabled = isDefaultServiceEnabledLocked(userId);     // Catch: Throwable -> L10
        if (currentlyEnabled != enabled) goto L13;
        Slog.i(TAG, "setDefaultServiceEnabled(" + userId + "): already " + enabled);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return false;
    L13:
        if (enabled == false) goto L15;
        Slog.i(TAG, "disabling default service for user " + userId);     // Catch: Throwable -> L10
        this.mDefaultServicesDisabled.delete(userId);     // Catch: Throwable -> L10
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return true;
    L15:
        Slog.i(TAG, "enabling default service for user " + userId);     // Catch: Throwable -> L10
        this.mDefaultServicesDisabled.put(userId, true);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.infra.ServiceNameResolver
    public boolean isDefaultServiceEnabled(int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r1 = isDefaultServiceEnabledLocked(userId);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private boolean isDefaultServiceEnabledLocked(int userId) {
        return !this.mDefaultServicesDisabled.get(userId);
    }

    public String toString() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        String r1 = "FrameworkResourcesServiceNamer[temps=" + this.mTemporaryServiceNamesList + "]";     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.infra.ServiceNameResolver
    public void dumpShort(PrintWriter pw, int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        String[] temporaryNames = this.mTemporaryServiceNamesList.get(userId);     // Catch: Throwable -> L7
        if (temporaryNames == null) goto L9;
        pw.print("tmpName=");     // Catch: Throwable -> L7
        pw.print(Arrays.toString(temporaryNames));     // Catch: Throwable -> L7
        long ttl = this.mTemporaryServiceExpiration - SystemClock.elapsedRealtime();     // Catch: Throwable -> L7
        pw.print(" (expires in ");     // Catch: Throwable -> L7
        TimeUtils.formatDuration(ttl, pw);     // Catch: Throwable -> L7
        pw.print("), ");     // Catch: Throwable -> L7
    L9:
        pw.print("defaultName=");     // Catch: Throwable -> L7
        pw.print(getDefaultServiceName(userId));     // Catch: Throwable -> L7
        boolean disabled = this.mDefaultServicesDisabled.get(userId);     // Catch: Throwable -> L7
        if (disabled == false) goto L12;
        String r3 = " (disabled)";
    L13:
        pw.println(r3);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L12:
        r3 = " (enabled)";
    L7:
        th = move-exception;
        throw th;
    }

    private void notifyTemporaryServiceNameChangedLocked(int userId, String newTemporaryName, boolean isTemporary) {
        if (this.mOnSetCallback == null) goto L6;
        this.mOnSetCallback.onNameResolved(userId, newTemporaryName, isTemporary);
        return;
    }
}
