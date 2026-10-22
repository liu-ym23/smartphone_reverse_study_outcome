package com.android.server.appbinding.finders;

import android.content.Context;
import android.content.pm.IPackageManager;
import android.content.pm.ServiceInfo;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.util.Log;
import android.util.Slog;
import android.util.SparseArray;
import com.android.server.appbinding.AppBindingConstants;
import com.android.server.appbinding.AppBindingUtils;
import java.io.PrintWriter;
import java.util.function.BiConsumer;

/* JADX INFO: loaded from: classes.dex */
public abstract class AppServiceFinder<TServiceType, TServiceInterfaceType extends IInterface> {
    protected static final boolean DEBUG = false;
    protected static final String TAG = "AppBindingService";
    protected final Context mContext;
    protected final Handler mHandler;
    private final SparseArray<String> mLastMessages;
    protected final BiConsumer<AppServiceFinder, Integer> mListener;
    private final Object mLock;
    private final SparseArray<String> mTargetPackages;
    private final SparseArray<ServiceInfo> mTargetServices;

    public abstract TServiceInterfaceType asInterface(IBinder r1);

    public abstract String getAppDescription();

    public abstract int getBindFlags(AppBindingConstants r1);

    protected abstract String getServiceAction();

    protected abstract Class<TServiceType> getServiceClass();

    protected abstract String getServicePermission();

    public abstract String getTargetPackage(int r1);

    public AppServiceFinder(Context context, BiConsumer<AppServiceFinder, Integer> listener, Handler callbackHandler) {
        this.mLock = new Object();
        this.mTargetPackages = new SparseArray(4);
        this.mTargetServices = new SparseArray(4);
        this.mLastMessages = new SparseArray(4);
        this.mContext = context;
        this.mListener = listener;
        this.mHandler = callbackHandler;
    }

    protected boolean isEnabled(AppBindingConstants constants) {
        return true;
    }

    public void startMonitoring() {
    }

    public void onUserRemoved(int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mTargetPackages.delete(userId);     // Catch: Throwable -> L7
        this.mTargetServices.delete(userId);     // Catch: Throwable -> L7
        this.mLastMessages.delete(userId);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final ServiceInfo findService(int userId, IPackageManager ipm, AppBindingConstants constants) {
        Object r1 = this.mLock;
        monitor-enter(r1);
        this.mTargetPackages.put(userId, null);     // Catch: Throwable -> L34
        this.mTargetServices.put(userId, null);     // Catch: Throwable -> L34
        this.mLastMessages.put(userId, null);     // Catch: Throwable -> L34
        if (isEnabled(constants) == true) goto L11;
        this.mLastMessages.put(userId, "feature disabled");     // Catch: Throwable -> L9
        Slog.i("AppBindingService", getAppDescription() + " feature disabled");     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return null;
    L11:
        String targetPackage = getTargetPackage(userId);     // Catch: Throwable -> L34
        if (targetPackage != null) goto L17;
        this.mLastMessages.put(userId, "Target package not found");     // Catch: Throwable -> L9
        Slog.w("AppBindingService", getAppDescription() + " u" + userId + " Target package not found");     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return null;
    L17:
        this.mTargetPackages.put(userId, targetPackage);     // Catch: Throwable -> L34
        StringBuilder errorMessage = new StringBuilder();     // Catch: Throwable -> L34
        ServiceInfo service = AppBindingUtils.findService(targetPackage, userId, getServiceAction(), getServicePermission(), getServiceClass(), ipm, errorMessage);     // Catch: Throwable -> L24
        if (service != null) goto L26;
        String message = errorMessage.toString();     // Catch: Throwable -> L24
        this.mLastMessages.put(userId, message);     // Catch: Throwable -> L24
        monitor-exit(r1);     // Catch: Throwable -> L24
        return null;
    L26:
        String error = validateService(service);     // Catch: Throwable -> L24
        if (error == null) goto L31;
        this.mLastMessages.put(userId, error);     // Catch: Throwable -> L24
        Log.e("AppBindingService", error);     // Catch: Throwable -> L24
        monitor-exit(r1);     // Catch: Throwable -> L24
        return null;
    L31:
        this.mLastMessages.put(userId, "Valid service found");     // Catch: Throwable -> L24
        this.mTargetServices.put(userId, service);     // Catch: Throwable -> L24
        monitor-exit(r1);     // Catch: Throwable -> L24
        return service;
    L9:
        th = th;
    L36:
        monitor-exit(r1);     // Catch: Throwable -> L24
        throw th;
    L24:
        th = th;
    L34:
        th = th;
        goto L36
    }

    protected String validateService(ServiceInfo service) {
        return null;
    }

    public void dump(String prefix, PrintWriter pw) {
        pw.print(prefix);
        pw.print("App type: ");
        pw.print(getAppDescription());
        pw.println();
        Object r0 = this.mLock;
        monitor-enter(r0);
        int i = 0;
    L15:
    L8:
        th = move-exception;
        throw th;
    L6:
        if (i >= this.mTargetPackages.size()) goto L11;
        int userId = this.mTargetPackages.keyAt(i);     // Catch: Throwable -> L8
        pw.print(prefix);     // Catch: Throwable -> L8
        pw.print("  User: ");     // Catch: Throwable -> L8
        pw.print(userId);     // Catch: Throwable -> L8
        pw.println();     // Catch: Throwable -> L8
        pw.print(prefix);     // Catch: Throwable -> L8
        pw.print("    Package: ");     // Catch: Throwable -> L8
        pw.print(this.mTargetPackages.get(userId));     // Catch: Throwable -> L8
        pw.println();     // Catch: Throwable -> L8
        pw.print(prefix);     // Catch: Throwable -> L8
        pw.print("    Service: ");     // Catch: Throwable -> L8
        pw.print(this.mTargetServices.get(userId));     // Catch: Throwable -> L8
        pw.println();     // Catch: Throwable -> L8
        pw.print(prefix);     // Catch: Throwable -> L8
        pw.print("    Message: ");     // Catch: Throwable -> L8
        pw.print(this.mLastMessages.get(userId));     // Catch: Throwable -> L8
        pw.println();     // Catch: Throwable -> L8
        i = i + 1;     // Catch: Throwable -> L8
        goto L15
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L8
    }

    public void dumpSimple(PrintWriter pw) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int i = 0;
    L15:
    L8:
        th = move-exception;
        throw th;
    L6:
        if (i >= this.mTargetPackages.size()) goto L11;
        int userId = this.mTargetPackages.keyAt(i);     // Catch: Throwable -> L8
        pw.print("finder,");     // Catch: Throwable -> L8
        pw.print(getAppDescription());     // Catch: Throwable -> L8
        pw.print(",");     // Catch: Throwable -> L8
        pw.print(userId);     // Catch: Throwable -> L8
        pw.print(",");     // Catch: Throwable -> L8
        pw.print(this.mTargetPackages.get(userId));     // Catch: Throwable -> L8
        pw.print(",");     // Catch: Throwable -> L8
        pw.print(this.mTargetServices.get(userId));     // Catch: Throwable -> L8
        pw.print(",");     // Catch: Throwable -> L8
        pw.print(this.mLastMessages.get(userId));     // Catch: Throwable -> L8
        pw.println();     // Catch: Throwable -> L8
        i = i + 1;     // Catch: Throwable -> L8
        goto L15
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L8
    }
}
