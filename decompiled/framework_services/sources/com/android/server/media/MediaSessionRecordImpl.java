package com.android.server.media;

import android.app.Notification;
import android.os.ResultReceiver;
import android.view.KeyEvent;
import java.io.PrintWriter;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public abstract class MediaSessionRecordImpl {
    private static final AtomicInteger sNextMediaSessionRecordId = null;
    private final int mUniqueId;

    public abstract void adjustVolume(String r1, String r2, int r3, int r4, boolean r5, int r6, int r7, boolean r8);

    public abstract boolean canHandleVolumeKey();

    public abstract boolean checkPlaybackActiveState(boolean r1);

    public abstract void close();

    public abstract void dump(PrintWriter r1, String r2);

    public abstract void expireTempEngaged();

    public abstract String getPackageName();

    public abstract int getSessionPolicies();

    public abstract int getUid();

    public abstract int getUserId();

    public abstract boolean hasLinkedNotificationSupport();

    public abstract boolean isActive();

    public abstract boolean isClosed();

    abstract boolean isLinkedToNotification(Notification r1);

    public abstract boolean isPlaybackTypeLocal();

    public abstract boolean isSystemPriority();

    public abstract void onGlobalPrioritySessionActiveChanged(boolean r1);

    public abstract boolean sendMediaButton(String r1, int r2, int r3, boolean r4, KeyEvent r5, int r6, ResultReceiver r7);

    public abstract void setSessionPolicies(int r1);

    static {
        sNextMediaSessionRecordId = new AtomicInteger(1);
    }

    protected MediaSessionRecordImpl() {
        this.mUniqueId = sNextMediaSessionRecordId.getAndIncrement();
    }

    public int getUniqueId() {
        return this.mUniqueId;
    }

    public final boolean equals(Object o) {
        if (this != o) goto L6;
        return true;
    L6:
        if (o != null) goto L8;
    L15:
        return false;
    L8:
        if ((o instanceof MediaSessionRecordImpl) == false) goto L15;
        MediaSessionRecordImpl that = (MediaSessionRecordImpl) o;
        if (this.mUniqueId != that.mUniqueId) goto L14;
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(this.mUniqueId)});
    }
}
