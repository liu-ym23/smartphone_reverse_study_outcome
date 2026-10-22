package com.android.server.biometrics.sensors;

import android.hardware.biometrics.AuthenticationStateListener;
import android.hardware.biometrics.events.AuthenticationAcquiredInfo;
import android.hardware.biometrics.events.AuthenticationErrorInfo;
import android.hardware.biometrics.events.AuthenticationFailedInfo;
import android.hardware.biometrics.events.AuthenticationHelpInfo;
import android.hardware.biometrics.events.AuthenticationStartedInfo;
import android.hardware.biometrics.events.AuthenticationStoppedInfo;
import android.hardware.biometrics.events.AuthenticationSucceededInfo;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Slog;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public class AuthenticationStateListeners implements IBinder.DeathRecipient {
    private static final String TAG = "AuthenticationStateListeners";
    private final CopyOnWriteArrayList<AuthenticationStateListener> mAuthenticationStateListeners;

    /* JADX INFO: renamed from: $r8$lambda$4-MCj9LEOHJrtdihppV4Ke3ZUL4, reason: not valid java name */
    public static /* synthetic */ boolean m2611$r8$lambda$4MCj9LEOHJrtdihppV4Ke3ZUL4(IBinder r0, AuthenticationStateListener r1) {
        return lambda$binderDied$0(r0, r1);
    }

    public AuthenticationStateListeners() {
        this.mAuthenticationStateListeners = new CopyOnWriteArrayList();
    }

    public void registerAuthenticationStateListener(AuthenticationStateListener listener) {
        this.mAuthenticationStateListeners.add(listener);
        listener.asBinder().linkToDeath(this, 0);     // Catch: RemoteException -> L5
        return;
    L5:
        e = move-exception;
        Slog.e(TAG, "Failed to link to death", e);
    }

    public void unregisterAuthenticationStateListener(AuthenticationStateListener listener) {
        this.mAuthenticationStateListeners.remove(listener);
    }

    public void onAuthenticationAcquired(AuthenticationAcquiredInfo authInfo) {
        Iterator<AuthenticationStateListener> r0 = this.mAuthenticationStateListeners.iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        AuthenticationStateListener listener = r0.next();
        listener.onAuthenticationAcquired(authInfo);     // Catch: RemoteException -> L8
    L8:
        e = move-exception;
        Slog.e(TAG, "Remote exception in notifying listener that authentication acquired", e);
        goto L4
    }

    public void onAuthenticationError(AuthenticationErrorInfo authInfo) {
        Iterator<AuthenticationStateListener> r1 = this.mAuthenticationStateListeners.iterator();
    L4:
        if (r1.hasNext() == false) goto L11;
        AuthenticationStateListener listener = r1.next();
        Slog.d(TAG, "onAuthenticationError authInfo=" + authInfo.toString());     // Catch: RemoteException -> L8
        listener.onAuthenticationError(authInfo);     // Catch: RemoteException -> L8
    L8:
        e = move-exception;
        Slog.e(TAG, "Remote exception in notifying listener of unrecoverable authentication error", e);
        goto L4
    }

    public void onAuthenticationFailed(AuthenticationFailedInfo authInfo) {
        Iterator<AuthenticationStateListener> r0 = this.mAuthenticationStateListeners.iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        AuthenticationStateListener listener = r0.next();
        listener.onAuthenticationFailed(authInfo);     // Catch: RemoteException -> L8
    L8:
        e = move-exception;
        Slog.e(TAG, "Remote exception in notifying listener that authentication failed", e);
        goto L4
    }

    public void onAuthenticationHelp(AuthenticationHelpInfo authInfo) {
        Iterator<AuthenticationStateListener> r0 = this.mAuthenticationStateListeners.iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        AuthenticationStateListener listener = r0.next();
        listener.onAuthenticationHelp(authInfo);     // Catch: RemoteException -> L8
    L8:
        e = move-exception;
        Slog.e(TAG, "Remote exception in notifying listener of recoverable authentication error", e);
        goto L4
    }

    public void onAuthenticationStarted(AuthenticationStartedInfo authInfo) {
        Iterator<AuthenticationStateListener> r0 = this.mAuthenticationStateListeners.iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        AuthenticationStateListener listener = r0.next();
        listener.onAuthenticationStarted(authInfo);     // Catch: RemoteException -> L8
    L8:
        e = move-exception;
        Slog.e(TAG, "Remote exception in notifying listener that authentication started", e);
        goto L4
    }

    public void onAuthenticationStopped(AuthenticationStoppedInfo authInfo) {
        Iterator<AuthenticationStateListener> r0 = this.mAuthenticationStateListeners.iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        AuthenticationStateListener listener = r0.next();
        listener.onAuthenticationStopped(authInfo);     // Catch: RemoteException -> L8
    L8:
        e = move-exception;
        Slog.e(TAG, "Remote exception in notifying listener that authentication stopped", e);
        goto L4
    }

    public void onAuthenticationSucceeded(AuthenticationSucceededInfo authInfo) {
        Iterator<AuthenticationStateListener> r0 = this.mAuthenticationStateListeners.iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        AuthenticationStateListener listener = r0.next();
        listener.onAuthenticationSucceeded(authInfo);     // Catch: RemoteException -> L8
    L8:
        e = move-exception;
        Slog.e(TAG, "Remote exception in notifying listener that authentication succeeded", e);
        goto L4
    }

    @Override // android.os.IBinder.DeathRecipient
    public void binderDied() {
    }

    @Override // android.os.IBinder.DeathRecipient
    public void binderDied(final IBinder who) {
        Slog.w(TAG, "Callback binder died: " + who);
        if (this.mAuthenticationStateListeners.removeIf(new AuthenticationStateListeners$$ExternalSyntheticLambda0(who)) == false) goto L5;
        Slog.w(TAG, "Removed dead listener for " + who);
        return;
    L5:
        Slog.w(TAG, "No dead listeners found");
    }

    private static /* synthetic */ boolean lambda$binderDied$0(IBinder who, AuthenticationStateListener listener) {
        return listener.asBinder().equals(who);
    }
}
