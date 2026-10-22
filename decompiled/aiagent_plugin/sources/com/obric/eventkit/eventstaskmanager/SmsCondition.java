package com.obric.eventkit.eventstaskmanager;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: loaded from: classes4.dex */
public final class SmsCondition implements Parcelable, Condition {
    public static final Parcelable.Creator<SmsCondition> CREATOR = null;
    private final String categoryName;
    private final String categoryType;
    private final String content;

    public static final class Creator implements Parcelable.Creator<SmsCondition> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SmsCondition createFromParcel(Parcel r5) {
            int r4 = r5.readInt();
            o.e(r5, "parcel");
            SmsCondition r0 = new SmsCondition(r5.readString(), r5.readString(), r5.readString());
            int r1 = Math.min(r4, 0);
            ClassLoader r2 = Creator.class.getClassLoader();
            int r3 = 1;
        L3:
            if (r3 > r1) goto L5;
            r3 = r3 + 1;
        L5:
            if (r3 > r4) goto L7;
            com.obric.a.a.a(r5, r2);
            r3 = r3 + 1;
            goto L5
        L7:
            return r0;
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SmsCondition createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SmsCondition[] newArray(int r1) {
            return new SmsCondition[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SmsCondition[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new Creator();
    }

    public SmsCondition(String r2, String r3, String r4) {
        o.e(r2, "categoryType");
        o.e(r3, "categoryName");
        this.categoryType = r2;
        this.categoryName = r3;
        this.content = r4;
    }

    public /* synthetic */ SmsCondition(String r1, String r2, String r3, int r4, h r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = null;
    L5:
        this(r1, r2, r3);
    }

    public static /* synthetic */ SmsCondition copy$default(SmsCondition r0, String r1, String r2, String r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.categoryType;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.categoryName;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.content;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.categoryType;
    }

    public final String component2() {
        return this.categoryName;
    }

    public final String component3() {
        return this.content;
    }

    public final SmsCondition copy(String r1, String r2, String r3) {
        o.e(r1, "categoryType");
        o.e(r2, "categoryName");
        return new SmsCondition(r1, r2, r3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, SmsCondition.class) == true) goto L8;
        return false;
    L8:
        SmsCondition r6 = (SmsCondition) ZeusTransformUtils.preCheckCast(r5, SmsCondition.class, "com.obric.aiagent.plugin");
        if (o.a(this.categoryType, r6.categoryType) == true) goto L12;
        return false;
    L12:
        if (o.a(this.categoryName, r6.categoryName) == true) goto L15;
        return false;
    L15:
        if (o.a(this.content, r6.content) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final String getCategoryName() {
        return this.categoryName;
    }

    public final String getCategoryType() {
        return this.categoryType;
    }

    public final String getContent() {
        return this.content;
    }

    public int hashCode() {
        int r0 = ((this.categoryType.hashCode() * 31) + this.categoryName.hashCode()) * 31;
        String r2 = this.content;
        if (r2 != null) goto L5;
        int r3 = 0;
    L7:
        return r0 + r3;
    L5:
        r3 = r2.hashCode();
        goto L7
    }

    public String toString() {
        return "SmsCondition(categoryType=" + this.categoryType + ", categoryName=" + this.categoryName + ", content=" + this.content + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeInt(0);
        o.e(r1, "out");
        r1.writeString(this.categoryType);
        r1.writeString(this.categoryName);
        r1.writeString(this.content);
    }
}
