package com.android.server.notification;

import android.app.Notification;
import android.net.Uri;
import android.os.Bundle;
import android.os.UserHandle;
import com.android.internal.statusbar.NotificationVisibility;

/* JADX INFO: loaded from: classes2.dex */
public interface NotificationDelegate {
    void clearEffects();

    void clearInlineReplyUriPermissions(String r1, int r2);

    void grantInlineReplyUriPermission(String r1, Uri r2, UserHandle r3, String r4, int r5);

    void onBubbleMetadataFlagChanged(String r1, int r2);

    void onClearAll(int r1, int r2, int r3);

    void onNotificationActionClick(int r1, int r2, String r3, int r4, Notification.Action r5, NotificationVisibility r6, boolean r7);

    void onNotificationBubbleChanged(String r1, boolean r2, int r3);

    void onNotificationClear(int r1, int r2, String r3, int r4, String r5, int r6, int r7, NotificationVisibility r8);

    void onNotificationClick(int r1, int r2, String r3, NotificationVisibility r4);

    void onNotificationDirectReplied(String r1);

    void onNotificationError(int r1, int r2, String r3, String r4, int r5, int r6, int r7, String r8, int r9);

    void onNotificationExpansionChanged(String r1, boolean r2, boolean r3, int r4);

    void onNotificationFeedbackReceived(String r1, Bundle r2);

    void onNotificationSettingsViewed(String r1);

    void onNotificationSmartReplySent(String r1, int r2, CharSequence r3, int r4, boolean r5);

    void onNotificationSmartSuggestionsAdded(String r1, int r2, int r3, boolean r4, boolean r5);

    void onNotificationVisibilityChanged(NotificationVisibility[] r1, NotificationVisibility[] r2);

    void onPanelHidden();

    void onPanelRevealed(boolean r1, int r2);

    void onSetDisabled(int r1);

    void prepareForPossibleShutdown();
}
