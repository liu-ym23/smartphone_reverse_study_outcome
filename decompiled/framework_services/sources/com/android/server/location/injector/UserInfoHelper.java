package com.android.server.location.injector;

import android.util.IndentingPrintWriter;
import android.util.Log;
import com.android.server.location.LocationManagerService;
import com.android.server.location.eventlog.LocationEventLog;
import java.io.FileDescriptor;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public abstract class UserInfoHelper {
    private final CopyOnWriteArrayList<UserListener> mListeners;

    public interface UserListener {
        public static final int CURRENT_USER_CHANGED = 1;
        public static final int USER_STARTED = 2;
        public static final int USER_STOPPED = 3;
        public static final int USER_VISIBILITY_CHANGED = 4;

        @Retention(RetentionPolicy.SOURCE)
        public @interface UserChange {
        }

        void onUserChanged(int r1, int r2);
    }

    public abstract void dump(FileDescriptor r1, IndentingPrintWriter r2, String[] r3);

    public abstract int getCurrentUserId();

    protected abstract int[] getProfileIds(int r1);

    public abstract int[] getRunningUserIds();

    public abstract boolean isCurrentUserId(int r1);

    public abstract boolean isVisibleUserId(int r1);

    public UserInfoHelper() {
        this.mListeners = new CopyOnWriteArrayList();
    }

    public final void addListener(UserListener listener) {
        this.mListeners.add(listener);
    }

    public final void removeListener(UserListener listener) {
        this.mListeners.remove(listener);
    }

    protected final void dispatchOnUserStarted(int userId) {
        if (LocationManagerService.D == false) goto L5;
        Log.d(LocationManagerService.TAG, "u" + userId + " started");
    L5:
        Iterator<UserListener> r0 = this.mListeners.iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        UserListener listener = r0.next();
        listener.onUserChanged(userId, 2);
        goto L7
    }

    protected final void dispatchOnUserStopped(int userId) {
        if (LocationManagerService.D == false) goto L5;
        Log.d(LocationManagerService.TAG, "u" + userId + " stopped");
    L5:
        Iterator<UserListener> r0 = this.mListeners.iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        UserListener listener = r0.next();
        listener.onUserChanged(userId, 3);
        goto L7
    }

    protected final void dispatchOnCurrentUserChanged(int fromUserId, int toUserId) {
        int[] fromUserIds = getProfileIds(fromUserId);
        int[] toUserIds = getProfileIds(toUserId);
        if (LocationManagerService.D == false) goto L5;
        Log.d(LocationManagerService.TAG, "current user changed from u" + Arrays.toString(fromUserIds) + " to u" + Arrays.toString(toUserIds));
    L5:
        LocationEventLog.EVENT_LOG.logUserSwitched(fromUserId, toUserId);
        Iterator<UserListener> r2 = this.mListeners.iterator();
    L6:
        int r4 = 0;
        if (r2.hasNext() == false) goto L13;
        UserListener listener = r2.next();
        int r6 = fromUserIds.length;
    L10:
        if (r4 >= r6) goto L6;
        int userId = fromUserIds[r4];
        listener.onUserChanged(userId, 1);
        r4 = r4 + 1;
        goto L10
    L13:
        Iterator<UserListener> r3 = this.mListeners.iterator();
    L15:
        if (r3.hasNext() == false) goto L21;
        UserListener listener2 = r3.next();
        int r7 = toUserIds.length;
        int r8 = 0;
    L18:
        if (r8 >= r7) goto L15;
        int userId2 = toUserIds[r8];
        listener2.onUserChanged(userId2, 1);
        r8 = r8 + 1;
        goto L18
    }

    protected final void dispatchOnVisibleUserChanged(int userId, boolean visible) {
        if (LocationManagerService.D == false) goto L9;
        StringBuilder r0 = new StringBuilder();
        r0.append("visibility of u");
        r0.append(userId);
        r0.append(" changed to ");
        if (visible == false) goto L7;
        String r1 = "visible";
    L8:
        r0.append(r1);
        Log.d(LocationManagerService.TAG, r0.toString());
        goto L9
    L7:
        r1 = "invisible";
    L9:
        LocationEventLog.EVENT_LOG.logUserVisibilityChanged(userId, visible);
        Iterator<UserListener> r2 = this.mListeners.iterator();
    L11:
        if (r2.hasNext() == false) goto L13;
        UserListener listener = r2.next();
        listener.onUserChanged(userId, 4);
        goto L11
    }
}
