package com.obric.aiagent.assistant.idl.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: PersonalContextInfo.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PersonalContextInfo implements Parcelable {
    public static final Parcelable.Creator<PersonalContextInfo> CREATOR = null;
    private final Boolean isComplete;
    private final String personalInfo;

    /* JADX INFO: compiled from: PersonalContextInfo.kt */
    public static final class Creator implements Parcelable.Creator<PersonalContextInfo> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PersonalContextInfo createFromParcel(Parcel r3) {
            o.e(r3, "parcel");
            String r0 = r3.readString();
            if (r3.readInt() != 0) goto L6;
            Boolean r4 = null;
        L11:
            return new PersonalContextInfo(r0, r4);
        L6:
            if (r3.readInt() == 0) goto L8;
            boolean r5 = true;
        L9:
            r4 = Boolean.valueOf(r5);
            goto L11
        L8:
            r5 = false;
            goto L9
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ PersonalContextInfo createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PersonalContextInfo[] newArray(int r1) {
            return new PersonalContextInfo[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ PersonalContextInfo[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PersonalContextInfo() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ PersonalContextInfo copy$default(PersonalContextInfo r0, String r1, Boolean r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.personalInfo;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.isComplete;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.personalInfo;
    }

    public final Boolean component2() {
        return this.isComplete;
    }

    public final PersonalContextInfo copy(String r1, Boolean r2) {
        return new PersonalContextInfo(r1, r2);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, PersonalContextInfo.class) == true) goto L8;
        return false;
    L8:
        PersonalContextInfo r6 = (PersonalContextInfo) ZeusTransformUtils.preCheckCast(r5, PersonalContextInfo.class, "com.obric.aiagent.plugin");
        if (o.a(this.personalInfo, r6.personalInfo) == true) goto L12;
        return false;
    L12:
        if (o.a(this.isComplete, r6.isComplete) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        String r0 = this.personalInfo;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Boolean r4 = this.isComplete;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "PersonalContextInfo(personalInfo=" + this.personalInfo + ", isComplete=" + this.isComplete + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r1v0, types: [android.os.Parcel, java.lang.Object] */
    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        o.e(r1, "dest");
        r1.writeString(this.personalInfo);
        Boolean r0 = this.isComplete;
        if (r0 != null) goto L6;
        ?? r3 = 0;
    L5:
        r1.writeInt(r3);
        return;
    L6:
        r1.writeInt(1);
        r3 = r0.booleanValue();
        goto L5
    }

    public PersonalContextInfo(String r1, Boolean r2) {
        this.personalInfo = r1;
        this.isComplete = r2;
    }

    public final String getPersonalInfo() {
        return this.personalInfo;
    }

    public /* synthetic */ PersonalContextInfo(String r1, Boolean r2, int r3, h r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = "";
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = false;
    L8:
        this(r1, r2);
    }

    public final Boolean isComplete() {
        return this.isComplete;
    }
}
