package com.obric.aiagent.assistant.idl.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: DataSource.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class DataSource implements Parcelable {
    public static final Parcelable.Creator<DataSource> CREATOR = null;
    private String domainName;
    private String intentName;
    private String sourceIntent;

    /* JADX INFO: compiled from: DataSource.kt */
    public static final class Creator implements Parcelable.Creator<DataSource> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DataSource createFromParcel(Parcel r3) {
            o.e(r3, "parcel");
            return new DataSource(r3.readString(), r3.readString(), r3.readString());
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ DataSource createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DataSource[] newArray(int r1) {
            return new DataSource[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ DataSource[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    public static /* synthetic */ DataSource copy$default(DataSource r0, String r1, String r2, String r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.domainName;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.intentName;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.sourceIntent;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.domainName;
    }

    public final String component2() {
        return this.intentName;
    }

    public final String component3() {
        return this.sourceIntent;
    }

    public final DataSource copy(String r1, String r2, String r3) {
        o.e(r1, "domainName");
        o.e(r2, "intentName");
        return new DataSource(r1, r2, r3);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, DataSource.class) == true) goto L8;
        return false;
    L8:
        DataSource r6 = (DataSource) ZeusTransformUtils.preCheckCast(r5, DataSource.class, "com.obric.aiagent.plugin");
        if (o.a(this.domainName, r6.domainName) == true) goto L12;
        return false;
    L12:
        if (o.a(this.intentName, r6.intentName) == true) goto L15;
        return false;
    L15:
        if (o.a(this.sourceIntent, r6.sourceIntent) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r0 = ((this.domainName.hashCode() * 31) + this.intentName.hashCode()) * 31;
        String r2 = this.sourceIntent;
        if (r2 != null) goto L5;
        int r3 = 0;
    L7:
        return r0 + r3;
    L5:
        r3 = r2.hashCode();
        goto L7
    }

    public String toString() {
        return "DataSource(domainName=" + this.domainName + ", intentName=" + this.intentName + ", sourceIntent=" + this.sourceIntent + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        o.e(r1, "dest");
        r1.writeString(this.domainName);
        r1.writeString(this.intentName);
        r1.writeString(this.sourceIntent);
    }

    public DataSource(String r2, String r3, String r4) {
        o.e(r2, "domainName");
        o.e(r3, "intentName");
        this.domainName = r2;
        this.intentName = r3;
        this.sourceIntent = r4;
    }

    public /* synthetic */ DataSource(String r1, String r2, String r3, int r4, h r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = null;
    L5:
        this(r1, r2, r3);
    }

    public final String getDomainName() {
        return this.domainName;
    }

    public final void setDomainName(String r2) {
        o.e(r2, "<set-?>");
        this.domainName = r2;
    }

    public final String getIntentName() {
        return this.intentName;
    }

    public final void setIntentName(String r2) {
        o.e(r2, "<set-?>");
        this.intentName = r2;
    }

    public final String getSourceIntent() {
        return this.sourceIntent;
    }

    public final void setSourceIntent(String r1) {
        this.sourceIntent = r1;
    }
}
