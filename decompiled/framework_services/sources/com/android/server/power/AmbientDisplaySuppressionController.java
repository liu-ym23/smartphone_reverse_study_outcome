package com.android.server.power;

import android.os.RemoteException;
import android.os.ServiceManager;
import android.util.ArraySet;
import android.util.Pair;
import android.util.Slog;
import com.android.internal.statusbar.IStatusBarService;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public class AmbientDisplaySuppressionController {
    private static final String TAG = "AmbientDisplaySuppressionController";
    private final AmbientDisplaySuppressionChangedCallback mCallback;
    private IStatusBarService mStatusBarService;
    private final Set<Pair<String, Integer>> mSuppressionTokens;

    interface AmbientDisplaySuppressionChangedCallback {
        void onSuppressionChanged(boolean r1);
    }

    AmbientDisplaySuppressionController(AmbientDisplaySuppressionChangedCallback callback) {
        this.mSuppressionTokens = Collections.synchronizedSet(new ArraySet());
        callback.getClass();
        this.mCallback = callback;
    }

    public void suppress(String token, int callingUid, boolean suppress) {
        token.getClass();
        Pair<String, Integer> suppressionToken = Pair.create(token, Integer.valueOf(callingUid));
        boolean wasSuppressed = isSuppressed();
        if (suppress == false) goto L5;
        this.mSuppressionTokens.add(suppressionToken);
    L6:
        boolean isSuppressed = isSuppressed();
        if (isSuppressed == wasSuppressed) goto L22;
        this.mCallback.onSuppressionChanged(isSuppressed);
    L22:
        Set<Pair<String, Integer>> r3 = this.mSuppressionTokens;     // Catch: RemoteException -> L17
        monitor-enter(r3);     // Catch: RemoteException -> L17
        getStatusBar().suppressAmbientDisplay(isSuppressed);     // Catch: Throwable -> L14
        monitor-exit(r3);     // Catch: Throwable -> L14
    L24:
        return;
    L14:
        th = move-exception;
        throw th;     // Catch: RemoteException -> L17
    L17:
        e = move-exception;
        Slog.e(TAG, "Failed to suppress ambient display", e);
        return;
    L5:
        this.mSuppressionTokens.remove(suppressionToken);
        goto L6
    }

    List<String> getSuppressionTokens(int callingUid) {
        List<String> result = new ArrayList();
        Set<Pair<String, Integer>> r1 = this.mSuppressionTokens;
        monitor-enter(r1);
        Iterator<Pair<String, Integer>> r2 = this.mSuppressionTokens.iterator();     // Catch: Throwable -> L10
    L6:
        if (r2.hasNext() == false) goto L13;
        Pair<String, Integer> token = r2.next();     // Catch: Throwable -> L10
        if (((Integer) token.second).intValue() != callingUid) goto L6;
        result.add((String) token.first);     // Catch: Throwable -> L10
        goto L6
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L10
        return result;
    L10:
        th = move-exception;
        throw th;
    }

    public boolean isSuppressed(String token, int callingUid) {
        Set<Pair<String, Integer>> r0 = this.mSuppressionTokens;
        token.getClass();
        return r0.contains(Pair.create(token, Integer.valueOf(callingUid)));
    }

    public boolean isSuppressed() {
        return !this.mSuppressionTokens.isEmpty();
    }

    public void dump(PrintWriter pw) {
        pw.println("AmbientDisplaySuppressionController:");
        pw.println(" ambientDisplaySuppressed=" + isSuppressed());
        pw.println(" mSuppressionTokens=" + this.mSuppressionTokens);
    }

    private synchronized IStatusBarService getStatusBar() {
        monitor-enter(this);
    L6:
        th = move-exception;
        throw th;
    L4:
        if (this.mStatusBarService != null) goto L8;
        this.mStatusBarService = IStatusBarService.Stub.asInterface(ServiceManager.getService("statusbar"));     // Catch: Throwable -> L6
    L8:
        IStatusBarService r0 = this.mStatusBarService;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    }
}
