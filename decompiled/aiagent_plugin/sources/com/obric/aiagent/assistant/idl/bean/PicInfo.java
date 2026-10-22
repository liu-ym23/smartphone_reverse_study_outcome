package com.obric.aiagent.assistant.idl.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: PicInfo.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PicInfo implements Parcelable {
    public static final Parcelable.Creator<PicInfo> CREATOR = null;
    private final Integer height;
    private final String resId;
    private final Long time;
    private final String tosKey;
    private final Integer width;

    /* JADX INFO: compiled from: PicInfo.kt */
    public static final class Creator implements Parcelable.Creator<PicInfo> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PicInfo createFromParcel(Parcel r9) {
            o.e(r9, "parcel");
            String r1 = r9.readString();
            if (r9.readInt() != 0) goto L5;
            Integer r3 = null;
        L7:
            if (r9.readInt() != 0) goto L9;
            Integer r4 = null;
        L10:
            String r5 = r9.readString();
            if (r9.readInt() != 0) goto L13;
            Long r10 = null;
        L15:
            return new PicInfo(r1, r3, r4, r5, r10);
        L13:
            r10 = Long.valueOf(r9.readLong());
            goto L15
        L9:
            r4 = Integer.valueOf(r9.readInt());
            goto L10
        L5:
            r3 = Integer.valueOf(r9.readInt());
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ PicInfo createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PicInfo[] newArray(int r1) {
            return new PicInfo[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ PicInfo[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    public PicInfo() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ PicInfo copy$default(PicInfo r3, String r4, Integer r5, Integer r6, String r7, Long r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.tosKey;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.width;
    L8:
        Integer r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.height;
    L11:
        Integer r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.resId;
    L14:
        String r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.time;
    L17:
        String r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final String component1() {
        return this.tosKey;
    }

    public final Integer component2() {
        return this.width;
    }

    public final Integer component3() {
        return this.height;
    }

    public final String component4() {
        return this.resId;
    }

    public final Long component5() {
        return this.time;
    }

    public final PicInfo copy(String r7, Integer r8, Integer r9, String r10, Long r11) {
        return new PicInfo(r7, r8, r9, r10, r11);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, PicInfo.class) == true) goto L8;
        return false;
    L8:
        PicInfo r6 = (PicInfo) ZeusTransformUtils.preCheckCast(r5, PicInfo.class, "com.obric.aiagent.plugin");
        if (o.a(this.tosKey, r6.tosKey) == true) goto L12;
        return false;
    L12:
        if (o.a(this.width, r6.width) == true) goto L15;
        return false;
    L15:
        if (o.a(this.height, r6.height) == true) goto L18;
        return false;
    L18:
        if (o.a(this.resId, r6.resId) == true) goto L21;
        return false;
    L21:
        if (o.a(this.time, r6.time) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        String r0 = this.tosKey;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.width;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.height;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.resId;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Long r13 = this.time;
        if (r13 == null) goto L23;
        r1 = r13.hashCode();
    L23:
        return r12 + r1;
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
        return "PicInfo(tosKey=" + this.tosKey + ", width=" + this.width + ", height=" + this.height + ", resId=" + this.resId + ", time=" + this.time + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        o.e(r3, "dest");
        r3.writeString(this.tosKey);
        Integer r5 = this.width;
        if (r5 != null) goto L5;
        r3.writeInt(0);
    L6:
        Integer r6 = this.height;
        if (r6 != null) goto L9;
        r3.writeInt(0);
    L10:
        r3.writeString(this.resId);
        Long r2 = this.time;
        if (r2 != null) goto L13;
        r3.writeInt(0);
        return;
    L13:
        r3.writeInt(1);
        r3.writeLong(r2.longValue());
        return;
    L9:
        r3.writeInt(1);
        r3.writeInt(r6.intValue());
        goto L10
    L5:
        r3.writeInt(1);
        r3.writeInt(r5.intValue());
        goto L6
    }

    public PicInfo(String r1, Integer r2, Integer r3, String r4, Long r5) {
        this.tosKey = r1;
        this.width = r2;
        this.height = r3;
        this.resId = r4;
        this.time = r5;
    }

    public final String getTosKey() {
        return this.tosKey;
    }

    public /* synthetic */ PicInfo(String r3, Integer r4, Integer r5, String r6, Long r7, int r8, h r9) {
        if ((r8 & 1) == 0) goto L6;
        r3 = "";
    L6:
        if ((r8 & 2) == 0) goto L9;
        r4 = 0;
    L9:
        if ((r8 & 4) == 0) goto L12;
        r5 = 0;
    L12:
        if ((r8 & 8) == 0) goto L15;
        r6 = "";
    L15:
        if ((r8 & 16) == 0) goto L17;
        r7 = 0L;
    L17:
        this(r3, r4, r5, r6, r7);
    }

    public final Integer getWidth() {
        return this.width;
    }

    public final Integer getHeight() {
        return this.height;
    }

    public final String getResId() {
        return this.resId;
    }

    public final Long getTime() {
        return this.time;
    }
}
