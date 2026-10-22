package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItemV2;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class VisualPoiItem extends PoiItemV2 {
    public static final Parcelable.Creator<VisualPoiItem> CREATOR = new a();

    /* renamed from: r, reason: collision with root package name */
    private String f17614r;

    /* renamed from: s, reason: collision with root package name */
    private String f17615s;

    /* renamed from: t, reason: collision with root package name */
    private String f17616t;

    /* renamed from: u, reason: collision with root package name */
    private String f17617u;

    /* renamed from: v, reason: collision with root package name */
    private String f17618v;

    /* renamed from: w, reason: collision with root package name */
    private List<TopListItem> f17619w;

    /* renamed from: x, reason: collision with root package name */
    private String f17620x;

    public static class a implements Parcelable.Creator<VisualPoiItem> {
        @Override // android.os.Parcelable.Creator
        public VisualPoiItem createFromParcel(Parcel parcel) {
            return new VisualPoiItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public VisualPoiItem[] newArray(int i10) {
            return new VisualPoiItem[i10];
        }
    }

    public VisualPoiItem(String str, LatLonPoint latLonPoint, String str2, String str3) {
        super(str, latLonPoint, str2, str3);
        this.f17619w = new ArrayList();
    }

    public String getBizType() {
        return this.f17614r;
    }

    public String getDistance() {
        return this.f17618v;
    }

    public String getEmail() {
        return this.f17617u;
    }

    public String getFeaturedReviews() {
        return this.f17620x;
    }

    public String getPostcode() {
        return this.f17615s;
    }

    public List<TopListItem> getTopList() {
        return this.f17619w;
    }

    public String getWebsite() {
        return this.f17616t;
    }

    public void setBizType(String str) {
        this.f17614r = str;
    }

    public void setDistance(String str) {
        this.f17618v = str;
    }

    public void setEmail(String str) {
        this.f17617u = str;
    }

    public void setFeaturedReviews(String str) {
        this.f17620x = str;
    }

    public void setPostcode(String str) {
        this.f17615s = str;
    }

    public void setTopList(List<TopListItem> list) {
        this.f17619w = list;
    }

    public void setWebsite(String str) {
        this.f17616t = str;
    }

    @Override // com.amap.api.services.core.PoiItemV2
    public String toString() {
        return "VisualPoiItem{poiId='" + getPoiId() + "', title='" + getTitle() + "', snippet='" + getSnippet() + "', bizType='" + this.f17614r + "', distance='" + this.f17618v + "', featuredReviews='" + this.f17620x + "', topList=" + this.f17619w + '}';
    }

    @Override // com.amap.api.services.core.PoiItemV2, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeString(this.f17614r);
        parcel.writeString(this.f17615s);
        parcel.writeString(this.f17616t);
        parcel.writeString(this.f17617u);
        parcel.writeString(this.f17618v);
        parcel.writeTypedList(this.f17619w);
        parcel.writeString(this.f17620x);
    }

    public VisualPoiItem(Parcel parcel) {
        super(parcel);
        this.f17619w = new ArrayList();
        this.f17614r = parcel.readString();
        this.f17615s = parcel.readString();
        this.f17616t = parcel.readString();
        this.f17617u = parcel.readString();
        this.f17618v = parcel.readString();
        this.f17619w = parcel.createTypedArrayList(TopListItem.CREATOR);
        this.f17620x = parcel.readString();
    }
}
