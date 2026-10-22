package com.android.server.notification;

import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.content.pm.ParceledListSlice;
import android.os.UserHandle;
import java.util.Collection;

/* JADX INFO: loaded from: classes2.dex */
public interface RankingConfig {
    boolean badgingEnabled(UserHandle r1);

    boolean bubblesEnabled(UserHandle r1);

    boolean canShowBadge(String r1, int r2);

    boolean canShowNotificationsOnLockscreen(int r1);

    boolean canShowPrivateNotificationsOnLockScreen(int r1);

    boolean createNotificationChannel(String r1, int r2, NotificationChannel r3, boolean r4, boolean r5, int r6, boolean r7);

    void createNotificationChannelGroup(String r1, int r2, NotificationChannelGroup r3, boolean r4, int r5, boolean r6);

    boolean deleteNotificationChannel(String r1, int r2, String r3, int r4, boolean r5);

    int getBubblePreference(String r1, int r2);

    NotificationChannel getConversationNotificationChannel(String r1, int r2, String r3, String r4, boolean r5, boolean r6);

    NotificationChannel getNotificationChannel(String r1, int r2, String r3, boolean r4);

    Collection<NotificationChannelGroup> getNotificationChannelGroupsWithoutChannels(String r1, int r2);

    ParceledListSlice<NotificationChannel> getNotificationChannels(String r1, int r2, boolean r3, boolean r4);

    boolean isGroupBlocked(String r1, int r2, String r3);

    boolean isMediaNotificationFilteringEnabled();

    void permanentlyDeleteNotificationChannel(String r1, int r2, String r3);

    void permanentlyDeleteNotificationChannels(String r1, int r2);

    void setShowBadge(String r1, int r2, boolean r3);

    void updateNotificationChannel(String r1, int r2, NotificationChannel r3, boolean r4, int r5, boolean r6);
}
