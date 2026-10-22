package com.stepos.deepbinder.core.entity.ext;

import android.os.Parcel;
import android.os.Parcelable;
import f.a;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@a
/* loaded from: classes.dex */
public final class CallerData implements Parcelable {
    public static final CREATOR CREATOR = new CREATOR(null);
    private String callerPackageName;
    private String callerProcessName;
    private int pid;
    private int uid;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class CREATOR implements Parcelable.Creator<CallerData> {
        public /* synthetic */ CREATOR(e eVar) {
            this();
        }

        private CREATOR() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CallerData createFromParcel(Parcel parcel) {
            g.f(parcel, "parcel");
            return new CallerData(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CallerData[] newArray(int i10) {
            return new CallerData[i10];
        }
    }

    public CallerData() {
        this(null, null, 0, 0, 15, null);
    }

    public static /* synthetic */ CallerData copy$default(CallerData callerData, String str, String str2, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            str = callerData.callerPackageName;
        }
        if ((i12 & 2) != 0) {
            str2 = callerData.callerProcessName;
        }
        if ((i12 & 4) != 0) {
            i10 = callerData.uid;
        }
        if ((i12 & 8) != 0) {
            i11 = callerData.pid;
        }
        return callerData.copy(str, str2, i10, i11);
    }

    public final String component1() {
        return this.callerPackageName;
    }

    public final String component2() {
        return this.callerProcessName;
    }

    public final int component3() {
        return this.uid;
    }

    public final int component4() {
        return this.pid;
    }

    public final CallerData copy(String str, String str2, int i10, int i11) {
        return new CallerData(str, str2, i10, i11);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CallerData)) {
            return false;
        }
        CallerData callerData = (CallerData) obj;
        return g.b(this.callerPackageName, callerData.callerPackageName) && g.b(this.callerProcessName, callerData.callerProcessName) && this.uid == callerData.uid && this.pid == callerData.pid;
    }

    public final String getCallerPackageName() {
        return this.callerPackageName;
    }

    public final String getCallerProcessName() {
        return this.callerProcessName;
    }

    public final int getPid() {
        return this.pid;
    }

    public final int getUid() {
        return this.uid;
    }

    public int hashCode() {
        String str = this.callerPackageName;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.callerProcessName;
        return Integer.hashCode(this.pid) + ai.onnxruntime.a.d(this.uid, (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31, 31);
    }

    public final void setCallerPackageName(String str) {
        this.callerPackageName = str;
    }

    public final void setCallerProcessName(String str) {
        this.callerProcessName = str;
    }

    public final void setPid(int i10) {
        this.pid = i10;
    }

    public final void setUid(int i10) {
        this.uid = i10;
    }

    public String toString() {
        String str = this.callerPackageName;
        String str2 = this.callerProcessName;
        int i10 = this.uid;
        int i11 = this.pid;
        StringBuilder sbS = ai.onnxruntime.a.s("CallerData(callerPackageName='", str, "', callerProcessName='", str2, "', uid=");
        sbS.append(i10);
        sbS.append(", pid=");
        sbS.append(i11);
        sbS.append(")");
        return sbS.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        g.f(parcel, "parcel");
        parcel.writeString(this.callerPackageName);
        parcel.writeString(this.callerProcessName);
        parcel.writeInt(this.uid);
        parcel.writeInt(this.pid);
    }

    public CallerData(String str, String str2, int i10, int i11) {
        this.callerPackageName = str;
        this.callerProcessName = str2;
        this.uid = i10;
        this.pid = i11;
    }

    public /* synthetic */ CallerData(String str, String str2, int i10, int i11, int i12, e eVar) {
        this((i12 & 1) != 0 ? null : str, (i12 & 2) != 0 ? null : str2, (i12 & 4) != 0 ? 0 : i10, (i12 & 8) != 0 ? 0 : i11);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CallerData(Parcel parcel) {
        this(parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt());
        g.f(parcel, "parcel");
    }
}
