package com.obric.eventkit.eventstaskmanager;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.apm.battery.dao.DBHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: loaded from: classes4.dex */
public final class NotificationEvent extends AppEvent {
    public static final CREATOR CREATOR = null;
    private static final int VERSION = 0;
    private AppNotification[] notifications;

    public static final class CREATOR implements Parcelable.Creator<NotificationEvent> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(h r1) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NotificationEvent createFromParcel(Parcel r2) {
            o.e(r2, DBHelper.BATTERY_COL_SOURCE);
            return (NotificationEvent) ZeusTransformUtils.preCheckCast(AppEvent.CREATOR.createAppEventFromParcel$eventstaskkit_release(r2), NotificationEvent.class, "com.obric.aiagent.plugin");
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ NotificationEvent createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NotificationEvent[] newArray(int r1) {
            return new NotificationEvent[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ NotificationEvent[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public NotificationEvent() {
        this(null, null, null, 7, null);
    }

    public NotificationEvent(String r2, String r3, AppNotification[] r4) {
        super(r2, r3, null);
        this.notifications = r4;
    }

    public /* synthetic */ NotificationEvent(String r2, String r3, AppNotification[] r4, int r5, h r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = null;
    L11:
        this(r2, r3, r4);
    }

    public final AppNotification[] getNotifications() {
        return this.notifications;
    }

    @Override // com.obric.eventkit.eventstaskmanager.AppEvent
    public void readFromParcel(Parcel r7) {
        o.e(r7, "parcel");
        super.readFromParcel(r7);
        int r0 = r7.readInt();
        if (r0 <= 0) goto L10;
        int r1 = 0;
        AppNotification[] r2 = new AppNotification[r0];
    L5:
        if (r1 >= r0) goto L7;
        Parcelable r3 = r7.readParcelable(AppNotification.class.getClassLoader());
        o.a(r3);
        r2[r1] = (AppNotification) ZeusTransformUtils.preCheckCast(r3, AppNotification.class, "com.obric.aiagent.plugin");
        r1 = r1 + 1;
        goto L5
    L7:
        this.notifications = r2;
        return;
    }

    public final void setNotifications(AppNotification[] r1) {
        this.notifications = r1;
    }

    @Override // com.obric.eventkit.eventstaskmanager.AppEvent
    public String toString() {
        return "NotificationEvent(id=" + getId() + ", content=" + getContent() + ", extra=" + getExtra() + ", createTime=" + getCreateTime() + ", lastModifiedTime=" + getLastModifiedTime() + ", source='" + getSource() + "', eventType='" + getEventType() + "', notifications='" + this.notifications + "')";
    }

    @Override // com.obric.eventkit.eventstaskmanager.AppEvent, android.os.Parcelable
    public void writeToParcel(Parcel r4, int r5) {
        o.e(r4, "dest");
        super.writeToParcel(r4, r5);
        AppNotification[] r0 = this.notifications;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.length;
    L6:
        r4.writeInt(r2);
        AppNotification[] r3 = this.notifications;
        if (r3 == null) goto L11;
        int r6 = r3.length;
    L9:
        if (r1 >= r6) goto L13;
        r4.writeParcelable(r3[r1], r5);
        r1 = r1 + 1;
        goto L9
    L13:
        return;
    L11:
        return;
    L5:
        r2 = 0;
        goto L6
    }
}
