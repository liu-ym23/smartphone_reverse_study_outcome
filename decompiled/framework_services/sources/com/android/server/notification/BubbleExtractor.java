package com.android.server.notification;

import android.R;
import android.app.ActivityManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.util.Slog;
import com.android.internal.util.FrameworkStatsLog;
import com.android.server.am.HostingRecord;

/* JADX INFO: loaded from: classes2.dex */
public class BubbleExtractor implements NotificationSignalExtractor {
    private static final boolean DBG = false;
    private static final String TAG = "BubbleExtractor";
    private ActivityManager mActivityManager;
    private RankingConfig mConfig;
    private Context mContext;
    private PackageManager mPackageManager;
    private ShortcutHelper mShortcutHelper;
    boolean mSupportsBubble;

    public BubbleExtractor() {
    }

    @Override // com.android.server.notification.NotificationSignalExtractor
    public void initialize(Context context, NotificationUsageStats usageStats) {
        this.mContext = context;
        this.mActivityManager = (ActivityManager) this.mContext.getSystemService(HostingRecord.HOSTING_TYPE_ACTIVITY);
        this.mSupportsBubble = Resources.getSystem().getBoolean(R.bool.config_supportsSplitScreenMultiWindow);
    }

    @Override // com.android.server.notification.NotificationSignalExtractor
    public RankingReconsideration process(NotificationRecord record) {
        if (record != null) goto L5;
    L56:
        return null;
    L5:
        if (record.getNotification() == null) goto L56;
        if (this.mConfig != null) goto L11;
        return null;
    L11:
        if (this.mShortcutHelper != null) goto L14;
        return null;
    L14:
        if (this.mPackageManager != null) goto L16;
        return null;
    L16:
        boolean applyFlag = false;
        if (canPresentAsBubble(record) == true) goto L19;
    L27:
        boolean notifCanPresentAsBubble = false;
    L28:
        boolean userEnabledBubbles = this.mConfig.bubblesEnabled(record.getUser());
        int appPreference = this.mConfig.getBubblePreference(record.getSbn().getPackageName(), record.getSbn().getUid());
        NotificationChannel recordChannel = record.getChannel();
        if (userEnabledBubbles == false) goto L44;
        if (appPreference == 0) goto L44;
        if (notifCanPresentAsBubble == false) goto L44;
        if (recordChannel != null) goto L35;
        record.setAllowBubble(true);
    L48:
        if (record.canBubble() == true) goto L50;
    L52:
        if (applyFlag == false) goto L54;
        record.getNotification().flags |= 4096;
    L55:
        return null;
    L54:
        record.getNotification().flags &= -4097;
        goto L55
    L50:
        if (record.isFlagBubbleRemoved() == true) goto L52;
        applyFlag = true;
        goto L52
    L35:
        if (appPreference != 1) goto L42;
        if (recordChannel.getAllowBubbles() == 0) goto L39;
        boolean r7 = true;
    L40:
        record.setAllowBubble(r7);
        goto L48
    L39:
        r7 = false;
        goto L40
    L42:
        if (appPreference != 2) goto L48;
        record.setAllowBubble(recordChannel.canBubble());
    L44:
        record.setAllowBubble(false);
        if (notifCanPresentAsBubble == true) goto L48;
        record.getNotification().setBubbleMetadata(null);
        goto L48
    L19:
        if (this.mActivityManager.isLowRamDevice() == true) goto L27;
        if (record.isConversation() == false) goto L27;
        if (record.getShortcutInfo() == null) goto L27;
        if (record.getNotification().isFgsOrUij() == true) goto L27;
        notifCanPresentAsBubble = true;
        goto L28
    }

    @Override // com.android.server.notification.NotificationSignalExtractor
    public void setConfig(RankingConfig config) {
        this.mConfig = config;
    }

    @Override // com.android.server.notification.NotificationSignalExtractor
    public void setZenHelper(ZenModeHelper helper) {
    }

    public void setShortcutHelper(ShortcutHelper helper) {
        this.mShortcutHelper = helper;
    }

    public void setPackageManager(PackageManager packageManager) {
        this.mPackageManager = packageManager;
    }

    public void setActivityManager(ActivityManager manager) {
        this.mActivityManager = manager;
    }

    boolean canPresentAsBubble(NotificationRecord r) {
        if (this.mSupportsBubble == true) goto L5;
        return false;
    L5:
        Notification notification = r.getNotification();
        Notification.BubbleMetadata metadata = notification.getBubbleMetadata();
        String pkg = r.getSbn().getPackageName();
        if (metadata != null) goto L8;
        return false;
    L8:
        String shortcutId = metadata.getShortcutId();
        if (r.getShortcutInfo() == null) goto L11;
        String notificationShortcutId = r.getShortcutInfo().getId();
    L12:
        boolean shortcutValid = false;
        if (notificationShortcutId == null) goto L16;
        if (shortcutId == null) goto L16;
        shortcutValid = shortcutId.equals(notificationShortcutId);
    L23:
        if (metadata.getIntent() != null) goto L27;
        if (shortcutValid == true) goto L27;
        logBubbleError(r.getKey(), "couldn't find valid shortcut for bubble with shortcutId: " + shortcutId);
        return false;
    L27:
        if (shortcutValid == false) goto L30;
        return true;
    L30:
        return canLaunchInTaskView(metadata.getIntent().getIntent(), pkg, r.getUser().getIdentifier());
    L16:
        if (shortcutId == null) goto L23;
        if (this.mShortcutHelper.getValidShortcutInfo(shortcutId, pkg, r.getUser()) == null) goto L20;
        boolean r8 = true;
    L21:
        shortcutValid = r8;
        goto L23
    L20:
        r8 = false;
        goto L21
    L11:
        notificationShortcutId = null;
        goto L12
    }

    private boolean canLaunchInTaskView(Intent intent, String packageName, int userId) {
        if (intent != null) goto L6;
        Slog.w(TAG, "Unable to create bubble -- no intent");
        return false;
    L6:
        ResolveInfo resolveInfo = this.mPackageManager.resolveActivityAsUser(intent, 0, userId);
        if (resolveInfo == null) goto L9;
        ActivityInfo info = resolveInfo.activityInfo;
    L11:
        if (info != null) goto L15;
        FrameworkStatsLog.write(173, packageName, 1);
        Slog.w(TAG, "Unable to send as bubble -- couldn't find activity info for intent: " + intent);
        return false;
    L15:
        if (ActivityInfo.isResizeableMode(info.resizeMode) == true) goto L18;
        FrameworkStatsLog.write(173, packageName, 2);
        Slog.w(TAG, "Unable to send as bubble -- activity is not resizable for intent: " + intent);
        return false;
    L18:
        return true;
    L9:
        info = null;
        goto L11
    }

    private void logBubbleError(String key, String failureMessage) {
    }
}
