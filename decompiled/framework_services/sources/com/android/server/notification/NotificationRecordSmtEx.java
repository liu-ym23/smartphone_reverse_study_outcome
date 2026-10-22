package com.android.server.notification;

import android.app.Notification;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.service.notification.StatusBarNotification;
import android.util.Log;
import android.widget.RemoteViews;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes2.dex */
public class NotificationRecordSmtEx implements Parcelable {
    public static final Parcelable.Creator<NotificationRecordSmtEx> CREATOR = null;
    private static final boolean DEBUG = false;
    private static final String TAG = "NotificationRecordSmtEx";
    private NotificationRecord mRecord;
    private boolean mSmtCustom;
    private int mSmtPackageVisibility;

    static {
        DEBUG = Log.isLoggable(TAG, 3);
        CREATOR = new AnonymousClass1();
    }

    public NotificationRecordSmtEx(NotificationRecord record) {
        this.mRecord = record;
    }

    protected NotificationRecordSmtEx(Parcel in) {
        this.mSmtPackageVisibility = in.readInt();
        if (in.readByte() == 0) goto L5;
        boolean r0 = true;
    L6:
        this.mSmtCustom = r0;
        return;
    L5:
        r0 = false;
        goto L6
    }

    public void setSmtPackageVisibility(int packageVisibility) {
        this.mSmtPackageVisibility = packageVisibility;
    }

    public int getSmtPackageVisibility() {
        return this.mSmtPackageVisibility;
    }

    public void setSmtCustom(boolean isCustom) {
        this.mSmtCustom = isCustom;
    }

    public boolean isCustom() {
        return this.mSmtCustom;
    }

    public void copyRankingInformation(NotificationRecordSmtEx recordSmtEx) {
        this.mSmtPackageVisibility = recordSmtEx.getSmtPackageVisibility();
        this.mSmtCustom = recordSmtEx.isCustom();
    }

    void dump(PrintWriter pw, String prefix) {
        pw.println(prefix + "mSmtPackageVisibility=" + this.mSmtPackageVisibility);
        pw.println(prefix + "mSmtCustom=" + this.mSmtCustom);
        pw.println(prefix + "mOverrideGroupKey=" + this.mRecord.getSbn().getOverrideGroupKey());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.mSmtPackageVisibility);
        dest.writeBoolean(this.mSmtCustom);
    }

    public static boolean isCustomView(StatusBarNotification sbn, Context context) {
    L11:
        e = move-exception;
        e.printStackTrace();
    L36:
        return false;
    L4:
        if (sbn.getNotification() == null) goto L36;
        int flags = sbn.getNotification().flags;     // Catch: Exception -> L11
        if ((536870912 & flags) <= 0) goto L15;
        if (DEBUG == false) goto L13;
        Log.i(TAG, sbn.getKey() + " is smt push notification, not custom");     // Catch: Exception -> L11
    L13:
        return false;
    L15:
        if ((134217728 & flags) <= 0) goto L21;
        if (DEBUG == false) goto L19;
        Log.i(TAG, sbn.getKey() + " is smt not custom notification, not custom");     // Catch: Exception -> L11
    L19:
        return false;
    L21:
        if (sbn.getNotification().isGroupSummary() == true) goto L23;
    L28:
        Notification.Builder builder = Notification.Builder.recoverBuilder(context, sbn.getNotification());     // Catch: Exception -> L11
        RemoteViews contentView = builder.createContentView();     // Catch: Exception -> L11
        RemoteViews bigContentView = builder.createBigContentView();     // Catch: Exception -> L11
        if (isCustomNotification(contentView, sbn) == false) goto L31;
    L32:
        return true;
    L31:
        if (isCustomNotification(bigContentView, sbn) == true) goto L32;
        return false;
    L23:
        if ((flags & 1024) <= 0) goto L28;
        if (DEBUG == false) goto L27;
        Log.i(TAG, sbn.getKey() + " is auto group summary, not custom");     // Catch: Exception -> L11
    L27:
        return false;
    }

    private static boolean isCustomNotification(RemoteViews view, StatusBarNotification sbn) {
        if (view != null) goto L5;
        return false;
    L5:
        int layoutId = view.getLayoutId();
        String style = null;
        if (sbn.getNotification() == null) goto L11;
        if (sbn.getNotification().extras == null) goto L11;
        style = sbn.getNotification().extras.getString("android.template");
    L11:
        if (layoutId != 17367136) goto L13;
    L31:
        if (style != null) goto L33;
        return false;
    L33:
        if (style.contains("DecoratedCustomViewStyle") == false) goto L35;
    L36:
        return true;
    L35:
        if (style.contains("DecoratedMediaCustomViewStyle") == true) goto L36;
        return false;
    L13:
        if (layoutId == 17367132) goto L31;
        if (layoutId == 17367137) goto L31;
        if (layoutId == 17367139) goto L31;
        if (layoutId == 17367140) goto L31;
        if (layoutId == 17367141) goto L31;
        if (layoutId == 17367143) goto L31;
        if (layoutId == 17367142) goto L31;
        if (layoutId == 17367138) goto L31;
        if (layoutId != 17367133) goto L36;
        goto L31
    }
}
