package com.amap.api.services.cloud;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes.dex */
public class CloudItem implements Parcelable {
    public static final Parcelable.Creator<CloudItem> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private String f17306a;

    /* renamed from: b, reason: collision with root package name */
    private int f17307b;

    /* renamed from: c, reason: collision with root package name */
    private String f17308c;

    /* renamed from: d, reason: collision with root package name */
    private String f17309d;

    /* renamed from: e, reason: collision with root package name */
    private HashMap<String, String> f17310e;

    /* renamed from: f, reason: collision with root package name */
    private List<CloudImage> f17311f;
    protected final LatLonPoint mPoint;
    protected final String mSnippet;
    protected final String mTitle;

    public static class a implements Parcelable.Creator<CloudItem> {
        @Override // android.os.Parcelable.Creator
        public CloudItem createFromParcel(Parcel parcel) {
            return new CloudItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public CloudItem[] newArray(int i10) {
            return new CloudItem[i10];
        }
    }

    public CloudItem(String str, LatLonPoint latLonPoint, String str2, String str3) {
        this.f17307b = -1;
        this.f17306a = str;
        this.mPoint = latLonPoint;
        this.mTitle = str2;
        this.mSnippet = str3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof CloudItem)) {
            return false;
        }
        CloudItem cloudItem = (CloudItem) obj;
        String str = this.f17306a;
        if (str == null) {
            if (cloudItem.f17306a != null) {
                return false;
            }
        } else if (!str.equals(cloudItem.f17306a)) {
            return false;
        }
        return true;
    }

    public List<CloudImage> getCloudImage() {
        return this.f17311f;
    }

    public String getCreatetime() {
        return this.f17308c;
    }

    public HashMap<String, String> getCustomfield() {
        return this.f17310e;
    }

    public int getDistance() {
        return this.f17307b;
    }

    public String getID() {
        return this.f17306a;
    }

    public LatLonPoint getLatLonPoint() {
        return this.mPoint;
    }

    public String getSnippet() {
        return this.mSnippet;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public String getUpdatetime() {
        return this.f17309d;
    }

    public int hashCode() {
        String str = this.f17306a;
        return (str == null ? 0 : str.hashCode()) + 31;
    }

    public void setCreatetime(String str) {
        this.f17308c = str;
    }

    public void setCustomfield(HashMap<String, String> map) {
        this.f17310e = map;
    }

    public void setDistance(int i10) {
        this.f17307b = i10;
    }

    public void setUpdatetime(String str) {
        this.f17309d = str;
    }

    public void setmCloudImage(List<CloudImage> list) {
        this.f17311f = list;
    }

    public String toString() {
        return this.mTitle;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f17306a);
        parcel.writeInt(this.f17307b);
        parcel.writeValue(this.mPoint);
        parcel.writeString(this.mTitle);
        parcel.writeString(this.mSnippet);
        parcel.writeString(this.f17308c);
        parcel.writeString(this.f17309d);
        parcel.writeMap(this.f17310e);
        parcel.writeList(this.f17311f);
    }

    public CloudItem(Parcel parcel) {
        this.f17307b = -1;
        this.f17306a = parcel.readString();
        this.f17307b = parcel.readInt();
        this.mPoint = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.mTitle = parcel.readString();
        this.mSnippet = parcel.readString();
        this.f17308c = parcel.readString();
        this.f17309d = parcel.readString();
        HashMap<String, String> map = new HashMap<>();
        this.f17310e = map;
        parcel.readMap(map, HashMap.class.getClassLoader());
        List arrayList = new ArrayList();
        this.f17311f = arrayList;
        parcel.readList(arrayList, getClass().getClassLoader());
    }
}
