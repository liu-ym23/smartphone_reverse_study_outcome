package com.obric.cae.libs.AllianceDrop;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class AllianceDropTransferInfo implements Parcelable {
    public static final Parcelable.Creator<AllianceDropTransferInfo> CREATOR = null;
    private final int mFileCount;
    private final String mMimeType;
    private final String mSenderName;
    private List<AllianceDropShareItem> mShareItemList;
    private final long mTotalSize;

    public class a implements Parcelable.Creator<AllianceDropTransferInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final AllianceDropTransferInfo createFromParcel(Parcel r2) {
            return new AllianceDropTransferInfo(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final AllianceDropTransferInfo[] newArray(int r1) {
            return new AllianceDropTransferInfo[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public AllianceDropTransferInfo(int r2, long r3, String r5, String r6) {
        this.mShareItemList = new ArrayList();
        this.mFileCount = r2;
        this.mTotalSize = r3;
        this.mSenderName = r5;
        this.mMimeType = r6;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getFileCount() {
        return this.mFileCount;
    }

    public String getMimeType() {
        return this.mMimeType;
    }

    public String getSenderName() {
        return this.mSenderName;
    }

    public List<AllianceDropShareItem> getShareItemList() {
        return this.mShareItemList;
    }

    public long getTotalSize() {
        return this.mTotalSize;
    }

    public void setShareItemList(List<AllianceDropShareItem> r1) {
        this.mShareItemList = r1;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        r3.writeInt(this.mFileCount);
        r3.writeLong(this.mTotalSize);
        r3.writeString(this.mSenderName);
        r3.writeString(this.mMimeType);
        List<AllianceDropShareItem> r5 = this.mShareItemList;
        if (r5 == null) goto L6;
        r3.writeTypedList(r5);
        return;
    }

    public AllianceDropTransferInfo(Parcel r3) {
        this.mShareItemList = new ArrayList();
        this.mFileCount = r3.readInt();
        this.mTotalSize = r3.readLong();
        this.mSenderName = r3.readString();
        this.mMimeType = r3.readString();
        if (this.mShareItemList == null) goto L6;
        this.mShareItemList = r3.createTypedArrayList(AllianceDropShareItem.CREATOR);
        return;
    }
}
