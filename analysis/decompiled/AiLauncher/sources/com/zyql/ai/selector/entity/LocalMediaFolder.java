package com.zyql.ai.selector.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class LocalMediaFolder implements Parcelable {
    public static final Parcelable.Creator<LocalMediaFolder> CREATOR = new Parcelable.Creator<LocalMediaFolder>() { // from class: com.zyql.ai.selector.entity.LocalMediaFolder.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LocalMediaFolder createFromParcel(Parcel parcel) {
            return new LocalMediaFolder(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LocalMediaFolder[] newArray(int i10) {
            return new LocalMediaFolder[i10];
        }
    };
    private long bucketId;
    private int checkedNum;
    private int currentDataPage;
    private List<LocalMedia> data;
    private String firstImagePath;
    private String firstMimeType;
    private int imageNum;
    private boolean isCameraFolder;
    private boolean isChecked;
    private boolean isHasMore;
    private String name;
    private int ofAllType;

    public LocalMediaFolder() {
        this.bucketId = -1L;
        this.ofAllType = -1;
        this.data = new ArrayList();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long getBucketId() {
        return this.bucketId;
    }

    public int getCheckedNum() {
        return this.checkedNum;
    }

    public int getCurrentDataPage() {
        return this.currentDataPage;
    }

    public List<LocalMedia> getData() {
        return this.data;
    }

    public String getFirstImagePath() {
        return this.firstImagePath;
    }

    public String getFirstMimeType() {
        return this.firstMimeType;
    }

    public int getImageNum() {
        return this.imageNum;
    }

    public String getName() {
        return TextUtils.isEmpty(this.name) ? "unknown" : this.name;
    }

    public int getOfAllType() {
        return this.ofAllType;
    }

    public boolean isCameraFolder() {
        return this.isCameraFolder;
    }

    public boolean isChecked() {
        return this.isChecked;
    }

    public boolean isHasMore() {
        return this.isHasMore;
    }

    public void setBucketId(long j10) {
        this.bucketId = j10;
    }

    public void setCameraFolder(boolean z10) {
        this.isCameraFolder = z10;
    }

    public void setChecked(boolean z10) {
        this.isChecked = z10;
    }

    public void setCheckedNum(int i10) {
        this.checkedNum = i10;
    }

    public void setCurrentDataPage(int i10) {
        this.currentDataPage = i10;
    }

    public void setData(List<LocalMedia> list) {
        this.data = list;
    }

    public void setFirstImagePath(String str) {
        this.firstImagePath = str;
    }

    public void setFirstMimeType(String str) {
        this.firstMimeType = str;
    }

    public void setHasMore(boolean z10) {
        this.isHasMore = z10;
    }

    public void setImageNum(int i10) {
        this.imageNum = i10;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setOfAllType(int i10) {
        this.ofAllType = i10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeLong(this.bucketId);
        parcel.writeString(this.name);
        parcel.writeString(this.firstImagePath);
        parcel.writeString(this.firstMimeType);
        parcel.writeInt(this.imageNum);
        parcel.writeInt(this.checkedNum);
        parcel.writeByte(this.isChecked ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.ofAllType);
        parcel.writeByte(this.isCameraFolder ? (byte) 1 : (byte) 0);
        parcel.writeTypedList(this.data);
        parcel.writeInt(this.currentDataPage);
        parcel.writeByte(this.isHasMore ? (byte) 1 : (byte) 0);
    }

    public LocalMediaFolder(Parcel parcel) {
        this.bucketId = -1L;
        this.ofAllType = -1;
        this.data = new ArrayList();
        this.bucketId = parcel.readLong();
        this.name = parcel.readString();
        this.firstImagePath = parcel.readString();
        this.firstMimeType = parcel.readString();
        this.imageNum = parcel.readInt();
        this.checkedNum = parcel.readInt();
        this.isChecked = parcel.readByte() != 0;
        this.ofAllType = parcel.readInt();
        this.isCameraFolder = parcel.readByte() != 0;
        this.data = parcel.createTypedArrayList(LocalMedia.CREATOR);
        this.currentDataPage = parcel.readInt();
        this.isHasMore = parcel.readByte() != 0;
    }
}
