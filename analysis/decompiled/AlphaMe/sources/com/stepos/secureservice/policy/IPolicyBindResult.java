package com.stepos.secureservice.policy;

import B0.g;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
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
        public IPolicyBindResult[] newArray(int i4) {
            return new IPolicyBindResult[i4];
        }
    };
    public String bindId;
    public int publicFlag;
    public int serverId;

    public IPolicyBindResult() {
    }

    public IPolicyBindResult(int i4, int i5, String str) {
        this.serverId = i4;
        this.publicFlag = i5;
        this.bindId = str;
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
        int i4 = ((this.serverId * 31) + this.publicFlag) * 31;
        String str = this.bindId;
        return i4 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("IPolicyBindResult{serverId=");
        sb.append(this.serverId);
        sb.append(", publicFlag=");
        sb.append(this.publicFlag);
        sb.append(", bindId='");
        return g.r(sb, this.bindId, "'}");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i4) {
        parcel.writeInt(this.serverId);
        parcel.writeInt(this.publicFlag);
        parcel.writeString(this.bindId);
    }

    public IPolicyBindResult(Parcel parcel) {
        this.serverId = parcel.readInt();
        this.publicFlag = parcel.readInt();
        this.bindId = parcel.readString();
    }
}
