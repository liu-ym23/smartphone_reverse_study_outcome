package com.android.server.notification;

import android.app.Notification;
import android.app.NotificationChannel;
import android.content.Context;
import android.media.AudioAttributes;
import android.os.Binder;
import android.os.RemoteException;
import android.util.Slog;
import com.android.internal.compat.IPlatformCompat;
import com.android.server.am.HostingRecord;

/* JADX INFO: loaded from: classes2.dex */
public class NotificationChannelExtractor implements NotificationSignalExtractor {
    private static final boolean DBG = false;
    static final long RESTRICT_AUDIO_ATTRIBUTES = 331793339;
    private static final String TAG = "ChannelExtractor";
    private RankingConfig mConfig;
    private Context mContext;
    private IPlatformCompat mPlatformCompat;

    public NotificationChannelExtractor() {
    }

    @Override // com.android.server.notification.NotificationSignalExtractor
    public void initialize(Context ctx, NotificationUsageStats usageStats) {
        this.mContext = ctx;
    }

    @Override // com.android.server.notification.NotificationSignalExtractor
    public void setCompatChangeLogger(IPlatformCompat platformCompat) {
        this.mPlatformCompat = platformCompat;
    }

    @Override // com.android.server.notification.NotificationSignalExtractor
    public RankingReconsideration process(NotificationRecord record) {
        if (record != null) goto L5;
    L31:
        return null;
    L5:
        if (record.getNotification() == null) goto L31;
        if (this.mConfig != null) goto L10;
        return null;
    L10:
        NotificationChannel updatedChannel = this.mConfig.getConversationNotificationChannel(record.getSbn().getPackageName(), record.getSbn().getUid(), record.getChannel().getId(), record.getSbn().getShortcutId(), true, false);
        record.updateNotificationChannel(updatedChannel);
        AudioAttributes attributes = record.getChannel().getAudioAttributes();
        if (attributes != null) goto L13;
        return null;
    L13:
        boolean updateAttributes = false;
        if (record.getNotification().isStyle(Notification.CallStyle.class) == true) goto L19;
        if (attributes.getUsage() != 6) goto L19;
        updateAttributes = true;
    L19:
        if (HostingRecord.TRIGGER_TYPE_ALARM.equals(record.getNotification().category) == true) goto L24;
        if (attributes.getUsage() != 4) goto L24;
        updateAttributes = true;
    L24:
        if (attributes.getUsage() != 0) goto L26;
    L27:
        updateAttributes = true;
    L28:
        if (updateAttributes == false) goto L30;
        reportAudioAttributesChanged(record.getUid());
        NotificationChannel clone = record.getChannel().copy();
        clone.setSound(clone.getSound(), new AudioAttributes.Builder(attributes).setUsage(5).build());
        record.updateNotificationChannel(clone);
    L30:
        return null;
    L26:
        if (attributes.getUsage() != 1) goto L28;
        goto L27
    }

    private void reportAudioAttributesChanged(int uid) {
        long id = Binder.clearCallingIdentity();
        this.mPlatformCompat.reportChangeByUid(RESTRICT_AUDIO_ATTRIBUTES, uid);     // Catch: Throwable -> L5 RemoteException -> L7
    L4:
        Binder.restoreCallingIdentity(id);
        return;
    L5:
        th = move-exception;
        Binder.restoreCallingIdentity(id);
        throw th;
    L7:
        e = move-exception;
        Slog.e(TAG, "Unexpected exception while reporting to changecompat", e);     // Catch: Throwable -> L5
        goto L4
    }

    @Override // com.android.server.notification.NotificationSignalExtractor
    public void setConfig(RankingConfig config) {
        this.mConfig = config;
    }

    @Override // com.android.server.notification.NotificationSignalExtractor
    public void setZenHelper(ZenModeHelper helper) {
    }
}
