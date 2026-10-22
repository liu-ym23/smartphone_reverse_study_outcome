package com.obric.memorydata.sdk.realtime;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.apm.battery.dao.DBHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: IMActionContext.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class IMActionContext extends ActionContext {
    public static final CREATOR CREATOR = null;
    private final String activityName;
    private final Bitmap bitmap;
    private final String packageName;
    private final int type;

    /* JADX INFO: compiled from: IMActionContext.kt */
    public static final class CREATOR implements Parcelable.Creator<IMActionContext> {
        public /* synthetic */ CREATOR(h r1) {
            this();
        }

        private CREATOR() {
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ IMActionContext createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ IMActionContext[] newArray(int r1) {
            return newArray(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public IMActionContext createFromParcel(Parcel r8) {
            o.e(r8, DBHelper.BATTERY_COL_SOURCE);
            String r2 = r8.readString();
            o.a(r2);
            String r3 = r8.readString();
            o.a(r3);
            Parcelable r9 = r8.readParcelable(Bitmap.class.getClassLoader());
            o.a(r9);
            int r1 = 0;
            return new IMActionContext(r1, r2, r3, (Bitmap) ZeusTransformUtils.preCheckCast(r9, Bitmap.class, "com.obric.aiagent.plugin"), 1, null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public IMActionContext[] newArray(int r1) {
            return new IMActionContext[r1];
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public static /* synthetic */ IMActionContext copy$default(IMActionContext r0, int r1, String r2, String r3, Bitmap r4, int r5, Object r6) {
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
        r4 = r0.bitmap;
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

    public final Bitmap component4() {
        return this.bitmap;
    }

    public final IMActionContext copy(int r1, String r2, String r3, Bitmap r4) {
        o.e(r2, "packageName");
        o.e(r3, "activityName");
        o.e(r4, "bitmap");
        return new IMActionContext(r1, r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, IMActionContext.class) == true) goto L8;
        return false;
    L8:
        IMActionContext r6 = (IMActionContext) ZeusTransformUtils.preCheckCast(r5, IMActionContext.class, "com.obric.aiagent.plugin");
        if (this.type == r6.type) goto L12;
        return false;
    L12:
        if (o.a(this.packageName, r6.packageName) == true) goto L15;
        return false;
    L15:
        if (o.a(this.activityName, r6.activityName) == true) goto L18;
        return false;
    L18:
        if (o.a(this.bitmap, r6.bitmap) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.type) * 31) + this.packageName.hashCode()) * 31) + this.activityName.hashCode()) * 31) + this.bitmap.hashCode();
    }

    public String toString() {
        return "IMActionContext(type=" + this.type + ", packageName=" + this.packageName + ", activityName=" + this.activityName + ", bitmap=" + this.bitmap + ')';
    }

    public /* synthetic */ IMActionContext(int r1, String r2, String r3, Bitmap r4, int r5, h r6) {
        if ((r5 & 1) == 0) goto L5;
        r1 = 4;
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

    public final Bitmap getBitmap() {
        return this.bitmap;
    }

    public IMActionContext(int r2, String r3, String r4, Bitmap r5) {
        o.e(r3, "packageName");
        o.e(r4, "activityName");
        o.e(r5, "bitmap");
        this.type = r2;
        this.packageName = r3;
        this.activityName = r4;
        this.bitmap = r5;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        o.e(r3, "dest");
        super.writeToParcelBase(r3, r4);
        r3.writeString(getPackageName());
        r3.writeString(getActivityName());
        r3.writeParcelable((Parcelable) ZeusTransformUtils.preCheckCast(this.bitmap, Parcelable.class, "com.obric.aiagent.plugin"), r4);
    }
}
