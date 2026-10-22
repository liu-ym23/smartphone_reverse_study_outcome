package com.obric.memorydata.sdk.realtime;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.apm.battery.dao.DBHelper;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: FileActionContext.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class FileActionContext extends ActionContext {
    public static final CREATOR CREATOR = null;
    private final String activityName;
    private final FileEntity entity;
    private final String packageName;
    private final int type;

    /* JADX INFO: compiled from: FileActionContext.kt */
    public static final class CREATOR implements Parcelable.Creator<FileActionContext> {
        public /* synthetic */ CREATOR(h r1) {
            this();
        }

        private CREATOR() {
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ FileActionContext createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ FileActionContext[] newArray(int r1) {
            return newArray(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FileActionContext createFromParcel(Parcel r8) {
            o.e(r8, DBHelper.BATTERY_COL_SOURCE);
            String r2 = r8.readString();
            o.a(r2);
            String r3 = r8.readString();
            o.a(r3);
            Parcelable r9 = r8.readParcelable(FileEntity.class.getClassLoader());
            o.a(r9);
            int r1 = 0;
            return new FileActionContext(r1, r2, r3, (FileEntity) ZeusTransformUtils.preCheckCast(r9, FileEntity.class, "com.obric.aiagent.plugin"), 1, null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FileActionContext[] newArray(int r1) {
            return new FileActionContext[r1];
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public static /* synthetic */ FileActionContext copy$default(FileActionContext r0, int r1, String r2, String r3, FileEntity r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.type;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.packageName;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.activityName;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.entity;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final int component1() {
        return this.type;
    }

    public final String component2() {
        return this.packageName;
    }

    public final String component3() {
        return this.activityName;
    }

    public final FileEntity component4() {
        return this.entity;
    }

    public final FileActionContext copy(int r1, String r2, String r3, FileEntity r4) {
        o.e(r2, "packageName");
        o.e(r3, "activityName");
        o.e(r4, "entity");
        return new FileActionContext(r1, r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, FileActionContext.class) == true) goto L8;
        return false;
    L8:
        FileActionContext r6 = (FileActionContext) ZeusTransformUtils.preCheckCast(r5, FileActionContext.class, "com.obric.aiagent.plugin");
        if (this.type == r6.type) goto L12;
        return false;
    L12:
        if (o.a(this.packageName, r6.packageName) == true) goto L15;
        return false;
    L15:
        if (o.a(this.activityName, r6.activityName) == true) goto L18;
        return false;
    L18:
        if (o.a(this.entity, r6.entity) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.type) * 31) + this.packageName.hashCode()) * 31) + this.activityName.hashCode()) * 31) + this.entity.hashCode();
    }

    public String toString() {
        return "FileActionContext(type=" + this.type + ", packageName=" + this.packageName + ", activityName=" + this.activityName + ", entity=" + this.entity + ')';
    }

    public /* synthetic */ FileActionContext(int r1, String r2, String r3, FileEntity r4, int r5, h r6) {
        if ((r5 & 1) == 0) goto L5;
        r1 = 2;
    L5:
        this(r1, r2, r3, r4);
    }

    @Override // com.obric.memorydata.sdk.realtime.ActionContext
    public int getType() {
        return this.type;
    }

    @Override // com.obric.memorydata.sdk.realtime.ActionContext
    public String getPackageName() {
        return this.packageName;
    }

    @Override // com.obric.memorydata.sdk.realtime.ActionContext
    public String getActivityName() {
        return this.activityName;
    }

    public final FileEntity getEntity() {
        return this.entity;
    }

    public FileActionContext(int r2, String r3, String r4, FileEntity r5) {
        o.e(r3, "packageName");
        o.e(r4, "activityName");
        o.e(r5, "entity");
        this.type = r2;
        this.packageName = r3;
        this.activityName = r4;
        this.entity = r5;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        o.e(r3, "dest");
        super.writeToParcelBase(r3, r4);
        r3.writeString(getPackageName());
        r3.writeString(getActivityName());
        r3.writeParcelable((Parcelable) ZeusTransformUtils.preCheckCast(this.entity, Parcelable.class, "com.obric.aiagent.plugin"), r4);
    }
}
