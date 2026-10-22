package com.obric.eventkit.eventstaskmanager;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.apm.battery.dao.DBHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes4.dex */
public abstract class AppEvent implements Parcelable {
    public static final CREATOR CREATOR = null;
    private String content;
    private long createTime;
    private final String eventType;
    private ConcurrentHashMap<String, Object> extra;
    private String id;
    private long lastModifiedTime;
    private String source;

    public static final class CREATOR implements Parcelable.Creator<AppEvent> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(h r1) {
            this();
        }

        public final <T extends AppEvent> T createAppEventFromParcel$eventstaskkit_release(Parcel r1) {
            o.e(r1, DBHelper.BATTERY_COL_SOURCE);
            T r0 = (T) EventTypeKt.newInstanceByEventType(r1.readString());
            if (r0 == null) goto L5;
            r0.readFromParcel(r1);
            return r0;
        L5:
            return null;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AppEvent createFromParcel(Parcel r2) {
            o.e(r2, DBHelper.BATTERY_COL_SOURCE);
            return createAppEventFromParcel$eventstaskkit_release(r2);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ AppEvent createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AppEvent[] newArray(int r1) {
            return new AppEvent[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ AppEvent[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    private AppEvent(String r1, String r2) {
        this.id = r1;
        this.content = r2;
        long r3 = System.currentTimeMillis();
        this.createTime = r3;
        this.lastModifiedTime = r3;
        this.source = a.f33211a.a();
        this.eventType = EventTypeKt.a(this);
    }

    public /* synthetic */ AppEvent(String r2, String r3, int r4, h r5) {
        h r0 = null;
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3, r0);
    }

    public /* synthetic */ AppEvent(String r1, String r2, h r3) {
        this(r1, r2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final String getContent() {
        return this.content;
    }

    public final long getCreateTime() {
        return this.createTime;
    }

    public final String getEventType() {
        return this.eventType;
    }

    public final ConcurrentHashMap<String, Object> getExtra() {
        return this.extra;
    }

    public final String getId() {
        return this.id;
    }

    public final long getLastModifiedTime() {
        return this.lastModifiedTime;
    }

    public final String getSource() {
        return this.source;
    }

    public void readFromParcel(Parcel r3) {
        o.e(r3, "parcel");
        this.id = r3.readString();
        this.content = r3.readString();
        this.createTime = r3.readLong();
        this.lastModifiedTime = r3.readLong();
        String r0 = r3.readString();
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        this.source = r0;
        Serializable r4 = r3.readSerializable();
        if (ZeusTransformUtils.instanceOf(r4, ConcurrentHashMap.class) == false) goto L8;
        ConcurrentHashMap<String, Object> r5 = (ConcurrentHashMap) ZeusTransformUtils.preCheckCast(r4, ConcurrentHashMap.class, "com.obric.aiagent.plugin");
    L9:
        this.extra = r5;
        return;
    L8:
        r5 = null;
        goto L9
    }

    public final void setContent(String r1) {
        this.content = r1;
    }

    public final void setExtra(ConcurrentHashMap<String, Object> r1) {
        this.extra = r1;
    }

    public final void setId(String r1) {
        this.id = r1;
    }

    public final void setLastModifiedTime(long r1) {
        this.lastModifiedTime = r1;
    }

    public String toString() {
        return "AppEvent(id=" + this.id + ", content=" + this.content + ", extra=" + this.extra + ", createTime=" + this.createTime + ", lastModifiedTime=" + this.lastModifiedTime + ", source='" + this.source + "', eventType='" + this.eventType + "')";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        o.e(r3, "dest");
        r3.writeString(this.eventType);
        r3.writeString(this.id);
        r3.writeString(this.content);
        r3.writeLong(this.createTime);
        r3.writeLong(this.lastModifiedTime);
        r3.writeString(this.source);
        r3.writeSerializable(this.extra);
    }
}
