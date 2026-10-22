package android.os;

import android.os.Parcelable;
import b.C0354a;

/* loaded from: classes.dex */
public class WakeLockData implements Parcelable {
    public static final Parcelable.Creator<WakeLockData> CREATOR = new C0354a(0);
    private static final String TAG = "WakeLockData";
    public int mFlags;
    public String mHistoryTag;
    public boolean mNotifiedAcquired;
    public int mOwnerPid;
    public int mOwnerUid;
    public String mPackageName;
    public String mTag;
    public WorkSource mWorkSource;

    public WakeLockData() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "mFlags=" + this.mFlags + " mTag = " + this.mTag + " PackageName = '" + this.mPackageName + "' (uid=" + this.mOwnerUid + ", pid=" + this.mOwnerPid + ", ws=" + this.mWorkSource + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeInt(this.mFlags);
        parcel.writeString(this.mTag);
        parcel.writeString(this.mPackageName);
        parcel.writeParcelable(this.mWorkSource, i4);
        parcel.writeInt(this.mOwnerUid);
        parcel.writeInt(this.mOwnerPid);
        parcel.writeString(this.mHistoryTag);
        parcel.writeByte(this.mNotifiedAcquired ? (byte) 1 : (byte) 0);
    }

    public WakeLockData(Parcel parcel) {
        this.mFlags = parcel.readInt();
        this.mTag = parcel.readString();
        this.mPackageName = parcel.readString();
        this.mWorkSource = (WorkSource) parcel.readParcelable(WorkSource.class.getClassLoader());
        this.mOwnerUid = parcel.readInt();
        this.mOwnerPid = parcel.readInt();
        this.mHistoryTag = parcel.readString();
        this.mNotifiedAcquired = parcel.readByte() != 0;
    }
}
