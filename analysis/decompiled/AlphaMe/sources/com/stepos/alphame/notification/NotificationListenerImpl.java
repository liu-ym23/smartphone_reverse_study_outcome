package com.stepos.alphame.notification;

import B0.g;
import android.app.Notification;
import android.content.Intent;
import android.os.Bundle;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import com.stepos.alphame.ApplicationImpl;
import com.stepos.alphame.R;
import com.stepos.alphame.awareness.AwarenessDataSource;
import com.stepos.alphame.data.utils.DailyUsageMessageHelperKt;
import com.stepos.alphame.userbehavior.UserBehaviorDataSource;
import com.stepos.alphame.utils.AlphaMeLogger;
import com.stepos.alphame.utils.Utils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class NotificationListenerImpl extends NotificationListenerService {
    private static final String CLOUD_PACKAGE_NAME = "com.stepos.cloudspace";
    private static final String EXTRA_ORIGINAL_PACKAGE_NAME = "android.originalPackageName";
    private static final String TAG = "NotificationEngine";
    private List<Integer> mPostedPersistIds = new ArrayList();
    private List<NotiRecord> mPostNotifications = new ArrayList();

    public class NotiRecord {
        String group;
        int id;
        String pkgName;

        public NotiRecord(String str, String str2, int i4) {
            this.pkgName = str;
            this.group = str2;
            this.id = i4;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof NotiRecord)) {
                return false;
            }
            NotiRecord notiRecord = (NotiRecord) obj;
            return TextUtils.equals(this.pkgName, notiRecord.pkgName) && TextUtils.equals(this.group, notiRecord.group) && this.id == notiRecord.id;
        }
    }

    private static String extractOrigPackageName(String str, String str2) {
        return (!CLOUD_PACKAGE_NAME.equals(str) || TextUtils.isEmpty(str2)) ? str : str2;
    }

    private boolean hasFlag(int i4, int i5) {
        return (i4 & i5) != 0;
    }

    private static boolean isInvalidStr(Object obj) {
        return !(obj instanceof CharSequence) || ((CharSequence) obj).length() <= 0;
    }

    private boolean isPersist(int i4) {
        return hasFlag(i4, 2) || hasFlag(i4, 32);
    }

    private boolean isTencentInvalidNotification(String str, String str2) {
        if (!"android".equals(str) || str2 == null) {
            return false;
        }
        return str2.contains(ApplicationImpl.getApplication().getString(R.string.wechat)) || str2.contains("wechat") || str2.contains("QQ") || str2.contains("qq");
    }

    private boolean needSave(String str, StatusBarNotification statusBarNotification) {
        Notification notification = statusBarNotification.getNotification();
        Bundle bundle = notification.extras;
        String group = notification.getGroup();
        int id = statusBarNotification.getId();
        int i4 = notification.flags;
        Object obj = bundle.get("android.title");
        Object obj2 = bundle.get("android.text");
        Object obj3 = bundle.get("android.title.big");
        Object obj4 = bundle.get("android.bigText");
        Object obj5 = bundle.get("android.summaryText");
        Object obj6 = bundle.get("android.subText");
        Object obj7 = bundle.get("android.messages");
        if (Utils.DEBUG.get()) {
            StringBuilder sbT = g.t("Notification posted flags = ", i4, ", isOngoing = ");
            sbT.append(statusBarNotification.isOngoing());
            sbT.append(", isClearable = ");
            sbT.append(statusBarNotification.isClearable());
            sbT.append(", isPersist = ");
            sbT.append(isPersist(i4));
            sbT.append(", group = ");
            sbT.append(group);
            sbT.append(", title = ");
            sbT.append(obj);
            sbT.append(", content = ");
            sbT.append(obj2);
            sbT.append(", bigTitle = ");
            sbT.append(obj3);
            sbT.append(", bigContent = ");
            sbT.append(obj4);
            sbT.append(", summary = ");
            sbT.append(obj5);
            sbT.append(", subText = ");
            sbT.append(obj6);
            sbT.append(", message = ");
            sbT.append(obj7);
            sbT.append(", sbn=");
            sbT.append(statusBarNotification);
            AlphaMeLogger.debugLog(sbT.toString());
        }
        if (isInvalidStr(obj) && isInvalidStr(obj2) && isInvalidStr(obj3) && isInvalidStr(obj4) && isInvalidStr(obj5) && isInvalidStr(obj6) && isInvalidStr(obj7)) {
            return false;
        }
        for (NotiRecord notiRecord : this.mPostNotifications) {
            if (TextUtils.equals(notiRecord.pkgName, str)) {
                String str2 = notiRecord.group;
                if (str2 != null && str2.equals(group)) {
                    return false;
                }
                if (notiRecord.id == id && isPersist(i4)) {
                    return false;
                }
            }
        }
        return true;
    }

    private void newNotification(String str, String str2, int i4) {
        for (NotiRecord notiRecord : this.mPostNotifications) {
            if (TextUtils.equals(str, notiRecord.pkgName) && TextUtils.equals(str2, notiRecord.group) && i4 == notiRecord.id) {
                return;
            }
        }
        StringBuilder sbX = g.x("mPostNotifications.add ", str, ", group = ", str2, ", id = ");
        sbX.append(i4);
        AlphaMeLogger.debugLog(TAG, sbX.toString());
        this.mPostNotifications.add(new NotiRecord(str, str2, i4));
    }

    private void removeNotification(String str, String str2, int i4) {
        NotiRecord next;
        Iterator<NotiRecord> it = this.mPostNotifications.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (TextUtils.equals(str, next.pkgName) && TextUtils.equals(str2, next.group) && i4 == next.id) {
                break;
            }
        }
        if (next != null) {
            StringBuilder sbX = g.x("mPostNotifications.remove ", str, ", group = ", str2, ", id = ");
            sbX.append(i4);
            AlphaMeLogger.debugLog(TAG, sbX.toString());
            this.mPostNotifications.remove(next);
        }
    }

    public void onForwardedNotificationPosted(String str, String str2, String str3, int i4, int i5, String str4, boolean z4) {
        String strExtractOrigPackageName = extractOrigPackageName(str, str2);
        if (z4 && !isTencentInvalidNotification(strExtractOrigPackageName, str4) && needSave(strExtractOrigPackageName, str3, i4, i5)) {
            AwarenessDataSource.getInstance().newNotiRecord(strExtractOrigPackageName, null);
            newNotification(strExtractOrigPackageName, str3, i4);
            long jCurrentTimeMillis = System.currentTimeMillis();
            UserBehaviorDataSource.getInstance().onNotificationEvent(strExtractOrigPackageName, jCurrentTimeMillis, true);
            DailyUsageMessageHelperKt.sendDailyUsageNotificationMessage(strExtractOrigPackageName, jCurrentTimeMillis);
        }
    }

    public void onForwardedNotificationRemoved(String str, String str2, String str3, int i4) {
        removeNotification(extractOrigPackageName(str, str2), str3, i4);
    }

    @Override // android.service.notification.NotificationListenerService
    public void onNotificationPosted(StatusBarNotification statusBarNotification) {
        if (statusBarNotification != null) {
            Notification notification = statusBarNotification.getNotification();
            String strExtractOrigPackageName = extractOrigPackageName(notification, statusBarNotification.getPackageName());
            if (isTencentInvalidNotification(strExtractOrigPackageName, notification)) {
                AlphaMeLogger.debugLog(TAG, "skip tencent android notification");
                return;
            }
            if (needSave(strExtractOrigPackageName, statusBarNotification)) {
                AlphaMeLogger.debugLog(TAG, "saveNotification from " + strExtractOrigPackageName);
                AwarenessDataSource.getInstance().newNotiRecord(strExtractOrigPackageName, null);
                newNotification(strExtractOrigPackageName, notification.getGroup(), statusBarNotification.getId());
                UserBehaviorDataSource.getInstance().onNotificationEvent(strExtractOrigPackageName, System.currentTimeMillis(), true);
                DailyUsageMessageHelperKt.sendDailyUsageNotificationMessage(strExtractOrigPackageName, System.currentTimeMillis());
            }
        }
    }

    @Override // android.service.notification.NotificationListenerService
    public void onNotificationRemoved(StatusBarNotification statusBarNotification) {
        if (statusBarNotification != null) {
            AlphaMeLogger.debugLog(TAG, "Notification removed " + statusBarNotification.getId() + ", " + statusBarNotification.getPackageName());
            Notification notification = statusBarNotification.getNotification();
            removeNotification(extractOrigPackageName(notification, statusBarNotification.getPackageName()), notification.getGroup(), statusBarNotification.getId());
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i4, int i5) {
        return super.onStartCommand(intent, i4, i5);
    }

    private static String extractOrigPackageName(Notification notification, String str) {
        Bundle bundle;
        String string;
        return (!CLOUD_PACKAGE_NAME.equals(str) || (bundle = notification.extras) == null || (string = bundle.getString(EXTRA_ORIGINAL_PACKAGE_NAME)) == null || string.length() <= 0) ? str : string;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0049  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean isTencentInvalidNotification(java.lang.String r3, android.app.Notification r4) {
        /*
            r2 = this;
            r2 = 0
            java.lang.String r0 = "android"
            boolean r3 = r0.equals(r3)     // Catch: java.lang.Exception -> L33
            if (r3 == 0) goto L53
            com.stepos.alphame.ApplicationImpl r3 = com.stepos.alphame.ApplicationImpl.getApplication()     // Catch: java.lang.Exception -> L33
            int r0 = com.stepos.alphame.R.string.wechat     // Catch: java.lang.Exception -> L33
            java.lang.String r3 = r3.getString(r0)     // Catch: java.lang.Exception -> L33
            if (r4 == 0) goto L53
            android.os.Bundle r4 = r4.extras     // Catch: java.lang.Exception -> L33
            if (r4 == 0) goto L53
            java.lang.String r0 = "android.title"
            java.lang.String r4 = r4.getString(r0)     // Catch: java.lang.Exception -> L33
            if (r4 == 0) goto L53
            boolean r3 = r4.contains(r3)     // Catch: java.lang.Exception -> L33
            r0 = 1
            if (r3 != 0) goto L35
            java.lang.String r3 = "wechat"
            boolean r3 = r4.contains(r3)     // Catch: java.lang.Exception -> L33
            if (r3 == 0) goto L31
            goto L35
        L31:
            r3 = r2
            goto L36
        L33:
            r3 = move-exception
            goto L50
        L35:
            r3 = r0
        L36:
            java.lang.String r1 = "QQ"
            boolean r1 = r4.contains(r1)     // Catch: java.lang.Exception -> L33
            if (r1 != 0) goto L49
            java.lang.String r1 = "qq"
            boolean r4 = r4.contains(r1)     // Catch: java.lang.Exception -> L33
            if (r4 == 0) goto L47
            goto L49
        L47:
            r4 = r2
            goto L4a
        L49:
            r4 = r0
        L4a:
            if (r3 != 0) goto L4e
            if (r4 == 0) goto L53
        L4e:
            r2 = r0
            goto L53
        L50:
            r3.printStackTrace()
        L53:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.alphame.notification.NotificationListenerImpl.isTencentInvalidNotification(java.lang.String, android.app.Notification):boolean");
    }

    private boolean needSave(String str, String str2, int i4, int i5) {
        for (NotiRecord notiRecord : this.mPostNotifications) {
            if (TextUtils.equals(notiRecord.pkgName, str)) {
                String str3 = notiRecord.group;
                if (str3 != null && str3.equals(str2)) {
                    return false;
                }
                if (notiRecord.id == i4 && isPersist(i5)) {
                    return false;
                }
            }
        }
        return true;
    }
}
