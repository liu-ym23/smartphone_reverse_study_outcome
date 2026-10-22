package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* loaded from: classes.dex */
public class BusInfo extends TransitBaseInfo {
    public static final Parcelable.Creator<BusInfo> CREATOR = new a();

    /* renamed from: f, reason: collision with root package name */
    private int f7269f;

    /* renamed from: g, reason: collision with root package name */
    private int f7270g;

    /* renamed from: h, reason: collision with root package name */
    private List<RouteNode> f7271h;

    /* renamed from: i, reason: collision with root package name */
    private String f7272i;

    /* renamed from: j, reason: collision with root package name */
    private String f7273j;

    /* renamed from: k, reason: collision with root package name */
    private String f7274k;

    /* renamed from: l, reason: collision with root package name */
    private String f7275l;

    public static class a implements Parcelable.Creator<BusInfo> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BusInfo createFromParcel(Parcel parcel) {
            return new BusInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BusInfo[] newArray(int i4) {
            return new BusInfo[i4];
        }
    }

    public BusInfo() {
    }

    @Override // com.baidu.mapapi.search.core.TransitBaseInfo, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getDirectText() {
        return this.f7275l;
    }

    public String getEndUid() {
        return this.f7273j;
    }

    public String getLineUid() {
        return this.f7274k;
    }

    public List<RouteNode> getPassStopInfoList() {
        return this.f7271h;
    }

    public String getStartUid() {
        return this.f7272i;
    }

    public int getStopNum() {
        return this.f7270g;
    }

    public int getType() {
        return this.f7269f;
    }

    public void setDirectText(String str) {
        this.f7275l = str;
    }

    public void setEndUid(String str) {
        this.f7273j = str;
    }

    public void setLineUid(String str) {
        this.f7274k = str;
    }

    public void setPassStopInfoList(List<RouteNode> list) {
        this.f7271h = list;
    }

    public void setStartUid(String str) {
        this.f7272i = str;
    }

    public void setStopNum(int i4) {
        this.f7270g = i4;
    }

    public void setType(int i4) {
        this.f7269f = i4;
    }

    @Override // com.baidu.mapapi.search.core.TransitBaseInfo, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeInt(this.f7269f);
        parcel.writeInt(this.f7270g);
        parcel.writeTypedList(this.f7271h);
        parcel.writeString(this.f7272i);
        parcel.writeString(this.f7273j);
        parcel.writeString(this.f7274k);
        parcel.writeString(this.f7275l);
    }

    public BusInfo(Parcel parcel) {
        super(parcel);
        this.f7269f = parcel.readInt();
        this.f7270g = parcel.readInt();
        this.f7271h = parcel.createTypedArrayList(RouteNode.CREATOR);
        this.f7272i = parcel.readString();
        this.f7273j = parcel.readString();
        this.f7274k = parcel.readString();
        this.f7275l = parcel.readString();
    }
}
