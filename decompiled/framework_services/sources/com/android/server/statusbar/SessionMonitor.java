package com.android.server.statusbar;

import android.app.StatusBarManager;
import android.content.Context;
import android.os.RemoteException;
import android.util.Log;
import com.android.internal.logging.InstanceId;
import com.android.internal.statusbar.ISessionListener;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public class SessionMonitor {
    private static final String TAG = "SessionMonitor";
    private final Context mContext;
    private final Map<Integer, Set<ISessionListener>> mSessionToListeners;

    public SessionMonitor(Context context) {
        this.mSessionToListeners = new HashMap();
        this.mContext = context;
        Iterator r0 = StatusBarManager.ALL_SESSIONS.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        int session = ((Integer) r0.next()).intValue();
        this.mSessionToListeners.put(Integer.valueOf(session), new HashSet());
        goto L4
    }

    public void registerSessionListener(int sessionFlags, ISessionListener listener) {
        requireListenerPermissions(sessionFlags);
        Map<Integer, Set<ISessionListener>> r0 = this.mSessionToListeners;
        monitor-enter(r0);
        Iterator r1 = StatusBarManager.ALL_SESSIONS.iterator();     // Catch: Throwable -> L10
    L6:
        if (r1.hasNext() == false) goto L13;
        int sessionType = ((Integer) r1.next()).intValue();     // Catch: Throwable -> L10
        if ((sessionFlags & sessionType) == 0) goto L6;
        this.mSessionToListeners.get(Integer.valueOf(sessionType)).add(listener);     // Catch: Throwable -> L10
        goto L6
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public void unregisterSessionListener(int sessionFlags, ISessionListener listener) {
        Map<Integer, Set<ISessionListener>> r0 = this.mSessionToListeners;
        monitor-enter(r0);
        Iterator r1 = StatusBarManager.ALL_SESSIONS.iterator();     // Catch: Throwable -> L10
    L6:
        if (r1.hasNext() == false) goto L13;
        int sessionType = ((Integer) r1.next()).intValue();     // Catch: Throwable -> L10
        if ((sessionFlags & sessionType) == 0) goto L6;
        this.mSessionToListeners.get(Integer.valueOf(sessionType)).remove(listener);     // Catch: Throwable -> L10
        goto L6
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public void onSessionStarted(int sessionType, InstanceId instanceId) {
        requireSetterPermissions(sessionType);
        if (isValidSessionType(sessionType) == true) goto L6;
        Log.e(TAG, "invalid onSessionStarted sessionType=" + sessionType);
        return;
    L6:
        Map<Integer, Set<ISessionListener>> r0 = this.mSessionToListeners;
        monitor-enter(r0);
        Iterator<ISessionListener> r1 = this.mSessionToListeners.get(Integer.valueOf(sessionType)).iterator();     // Catch: Throwable -> L14
    L10:
        if (r1.hasNext() == false) goto L19;
        ISessionListener listener = r1.next();     // Catch: Throwable -> L14
        listener.onSessionStarted(sessionType, instanceId);     // Catch: Throwable -> L14 RemoteException -> L16
    L16:
        e = move-exception;
        Log.e(TAG, "unable to send session start to listener=" + listener, e);     // Catch: Throwable -> L14
        goto L10
    L19:
        monitor-exit(r0);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    }

    public void onSessionEnded(int sessionType, InstanceId instanceId) {
        requireSetterPermissions(sessionType);
        if (isValidSessionType(sessionType) == true) goto L6;
        Log.e(TAG, "invalid onSessionEnded sessionType=" + sessionType);
        return;
    L6:
        Map<Integer, Set<ISessionListener>> r0 = this.mSessionToListeners;
        monitor-enter(r0);
        Iterator<ISessionListener> r1 = this.mSessionToListeners.get(Integer.valueOf(sessionType)).iterator();     // Catch: Throwable -> L14
    L10:
        if (r1.hasNext() == false) goto L19;
        ISessionListener listener = r1.next();     // Catch: Throwable -> L14
        listener.onSessionEnded(sessionType, instanceId);     // Catch: Throwable -> L14 RemoteException -> L16
    L16:
        e = move-exception;
        Log.e(TAG, "unable to send session end to listener=" + listener, e);     // Catch: Throwable -> L14
        goto L10
    L19:
        monitor-exit(r0);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    }

    private boolean isValidSessionType(int sessionType) {
        return StatusBarManager.ALL_SESSIONS.contains(Integer.valueOf(sessionType));
    }

    private void requireListenerPermissions(int sessionFlags) {
        if ((sessionFlags & 1) == 0) goto L6;
        this.mContext.enforceCallingOrSelfPermission("android.permission.MANAGE_BIOMETRIC", "StatusBarManagerService.SessionMonitor");
    L6:
        if ((sessionFlags & 2) == 0) goto L9;
        this.mContext.enforceCallingOrSelfPermission("android.permission.MANAGE_BIOMETRIC", "StatusBarManagerService.SessionMonitor");
        return;
    }

    private void requireSetterPermissions(int sessionFlags) {
        if ((sessionFlags & 1) == 0) goto L6;
        this.mContext.enforceCallingOrSelfPermission("android.permission.CONTROL_KEYGUARD", "StatusBarManagerService.SessionMonitor");
    L6:
        if ((sessionFlags & 2) == 0) goto L9;
        this.mContext.enforceCallingOrSelfPermission("android.permission.STATUS_BAR_SERVICE", "StatusBarManagerService.SessionMonitor");
        return;
    }
}
