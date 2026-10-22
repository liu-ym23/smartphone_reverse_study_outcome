package com.obric.eventkit.eventstaskmanager;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: loaded from: classes4.dex */
public final class AppNotification implements Parcelable {
    public static final CREATOR CREATOR = null;
    private final String appName;
    private final String content;
    private final String id;
    private final String packageName;
    private final String time;
    private final String title;

    public static final class CREATOR implements Parcelable.Creator<AppNotification> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(h r1) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AppNotification createFromParcel(Parcel r1) {
            o.e(r1, "parcel");
            return new AppNotification(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ AppNotification createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AppNotification[] newArray(int r1) {
            return new AppNotification[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ AppNotification[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public AppNotification() {
        this(null, null, null, null, null, null, 63, null);
    }

    public AppNotification(Parcel r9) {
        o.e(r9, "parcel");
        this(r9.readString(), r9.readString(), r9.readString(), r9.readString(), r9.readString(), r9.readString());
    }

    public AppNotification(String r1, String r2, String r3, String r4, String r5, String r6) {
        this.id = r1;
        this.time = r2;
        this.content = r3;
        this.appName = r4;
        this.packageName = r5;
        this.title = r6;
    }

    public /* synthetic */ AppNotification(String r2, String r3, String r4, String r5, String r6, String r7, int r8, h r9) {
        if ((r8 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r8 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r8 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r8 & 8) == 0) goto L15;
        r5 = null;
    L15:
        if ((r8 & 16) == 0) goto L18;
        r6 = null;
    L18:
        if ((r8 & 32) == 0) goto L20;
        r7 = null;
    L20:
        this(r2, r3, r4, r5, r6, r7);
    }

    public static /* synthetic */ AppNotification copy$default(AppNotification r4, String r5, String r6, String r7, String r8, String r9, String r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.id;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.time;
    L8:
        String r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.content;
    L11:
        String r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.appName;
    L14:
        String r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.packageName;
    L17:
        String r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.title;
    L20:
        String r14 = r5;
        return r4.copy(r14, r13, r0, r1, r2, r10);
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.time;
    }

    public final String component3() {
        return this.content;
    }

    public final String component4() {
        return this.appName;
    }

    public final String component5() {
        return this.packageName;
    }

    public final String component6() {
        return this.title;
    }

    public final AppNotification copy(String r8, String r9, String r10, String r11, String r12, String r13) {
        return new AppNotification(r8, r9, r10, r11, r12, r13);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, AppNotification.class) == true) goto L8;
        return false;
    L8:
        AppNotification r6 = (AppNotification) ZeusTransformUtils.preCheckCast(r5, AppNotification.class, "com.obric.aiagent.plugin");
        if (o.a(this.id, r6.id) == true) goto L12;
        return false;
    L12:
        if (o.a(this.time, r6.time) == true) goto L15;
        return false;
    L15:
        if (o.a(this.content, r6.content) == true) goto L18;
        return false;
    L18:
        if (o.a(this.appName, r6.appName) == true) goto L21;
        return false;
    L21:
        if (o.a(this.packageName, r6.packageName) == true) goto L24;
        return false;
    L24:
        if (o.a(this.title, r6.title) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final String getAppName() {
        return this.appName;
    }

    public final String getContent() {
        return this.content;
    }

    public final String getId() {
        return this.id;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final String getTime() {
        return this.time;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        String r0 = this.id;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.time;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.content;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.appName;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.packageName;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.title;
        if (r16 == null) goto L27;
        r1 = r16.hashCode();
    L27:
        return r15 + r1;
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "AppNotification(id=" + this.id + ", time=" + this.time + ", content=" + this.content + ", appName=" + this.appName + ", packageName=" + this.packageName + ", title=" + this.title + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        o.e(r1, "parcel");
        r1.writeString(this.id);
        r1.writeString(this.time);
        r1.writeString(this.content);
        r1.writeString(this.appName);
        r1.writeString(this.packageName);
        r1.writeString(this.title);
    }
}
