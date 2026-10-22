package com.stepos.secureservice.policy;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import java.util.Objects;

@Keep
/* loaded from: classes.dex */
public class IPolicyBindResult implements Parcelable {
    public static final Parcelable.Creator<IPolicyBindResult> CREATOR = new Parcelable.Creator<IPolicyBindResult>() { // from class: com.stepos.secureservice.policy.IPolicyBindResult.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public IPolicyBindResult createFromParcel(Parcel parcel) {
            return new IPolicyBindResult(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public IPolicyBindResult[] newArray(int i10) {
            return new IPolicyBindResult[i10];
        }
    };
    public String bindId;
    public int publicFlag;
    public int serverId;

    public IPolicyBindResult() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        IPolicyBindResult iPolicyBindResult = (IPolicyBindResult) obj;
        if (this.serverId == iPolicyBindResult.serverId && this.publicFlag == iPolicyBindResult.publicFlag) {
            return Objects.equals(this.bindId, iPolicyBindResult.bindId);
        }
        return false;
    }

    public int hashCode() {
        int i10 = ((this.serverId * 31) + this.publicFlag) * 31;
        String str = this.bindId;
        return i10 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "IPolicyBindResult{serverId=" + this.serverId + ", publicFlag=" + this.publicFlag + ", bindId='" + this.bindId + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.serverId);
        parcel.writeInt(this.publicFlag);
        parcel.writeString(this.bindId);
    }

    public IPolicyBindResult(int i10, int i11, String str) {
        this.serverId = i10;
        this.publicFlag = i11;
        this.bindId = str;
    }

    public IPolicyBindResult(Parcel parcel) {
        this.serverId = parcel.readInt();
        this.publicFlag = parcel.readInt();
        this.bindId = parcel.readString();
    }
}
