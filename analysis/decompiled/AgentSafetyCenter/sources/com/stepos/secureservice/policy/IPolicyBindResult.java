package com.stepos.secureservice.policy;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.activity.b;
import f.a;
import java.util.Objects;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
@a
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
        public IPolicyBindResult[] newArray(int i) {
            return new IPolicyBindResult[i];
        }
    };
    public String bindId;
    public int publicFlag;
    public int serverId;

    public IPolicyBindResult(Parcel parcel) {
        this.serverId = parcel.readInt();
        this.publicFlag = parcel.readInt();
        this.bindId = parcel.readString();
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
        int i = ((this.serverId * 31) + this.publicFlag) * 31;
        String str = this.bindId;
        return i + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("IPolicyBindResult{serverId=");
        sb2.append(this.serverId);
        sb2.append(", publicFlag=");
        sb2.append(this.publicFlag);
        sb2.append(", bindId='");
        return b.n(sb2, this.bindId, "'}");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.serverId);
        parcel.writeInt(this.publicFlag);
        parcel.writeString(this.bindId);
    }

    public IPolicyBindResult(int i, int i3, String str) {
        this.serverId = i;
        this.publicFlag = i3;
        this.bindId = str;
    }

    public IPolicyBindResult() {
    }
}
