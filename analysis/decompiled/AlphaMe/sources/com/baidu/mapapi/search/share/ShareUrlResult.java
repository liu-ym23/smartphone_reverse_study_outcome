package com.baidu.mapapi.search.share;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.search.core.SearchResult;

/* loaded from: classes.dex */
public class ShareUrlResult extends SearchResult implements Parcelable {
    public static final Parcelable.Creator<ShareUrlResult> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private String f7566a;

    /* renamed from: b, reason: collision with root package name */
    private int f7567b;

    public static class a implements Parcelable.Creator<ShareUrlResult> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ShareUrlResult createFromParcel(Parcel parcel) {
            return new ShareUrlResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ShareUrlResult[] newArray(int i4) {
            return new ShareUrlResult[i4];
        }
    }

    public ShareUrlResult() {
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getUrl() {
        return this.f7566a;
    }

    public void setType(int i4) {
        this.f7567b = i4;
    }

    public void setUrl(String str) {
        this.f7566a = str;
    }

    @Override // com.baidu.mapapi.search.core.SearchResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.f7566a);
        parcel.writeInt(this.f7567b);
    }

    public ShareUrlResult(Parcel parcel) {
        this.f7566a = parcel.readString();
        this.f7567b = parcel.readInt();
    }
}
