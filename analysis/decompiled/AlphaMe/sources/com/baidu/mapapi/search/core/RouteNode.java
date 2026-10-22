package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.LatLng;

/* loaded from: classes.dex */
public class RouteNode implements Parcelable {
    public static final Parcelable.Creator<RouteNode> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private String f7325a;

    /* renamed from: b, reason: collision with root package name */
    private LatLng f7326b;

    /* renamed from: c, reason: collision with root package name */
    private String f7327c;

    public static class a implements Parcelable.Creator<RouteNode> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RouteNode createFromParcel(Parcel parcel) {
            return new RouteNode(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RouteNode[] newArray(int i4) {
            return new RouteNode[i4];
        }
    }

    public RouteNode() {
    }

    public static RouteNode location(LatLng latLng) {
        RouteNode routeNode = new RouteNode();
        routeNode.setLocation(latLng);
        return routeNode;
    }

    public static RouteNode titleAndLocation(String str, LatLng latLng) {
        RouteNode routeNode = new RouteNode();
        routeNode.setTitle(str);
        routeNode.setLocation(latLng);
        return routeNode;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LatLng getLocation() {
        return this.f7326b;
    }

    public String getTitle() {
        return this.f7325a;
    }

    public String getUid() {
        return this.f7327c;
    }

    public void setLocation(LatLng latLng) {
        this.f7326b = latLng;
    }

    public void setTitle(String str) {
        this.f7325a = str;
    }

    public void setUid(String str) {
        this.f7327c = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.f7325a);
        parcel.writeValue(this.f7326b);
        parcel.writeString(this.f7327c);
    }

    public RouteNode(Parcel parcel) {
        this.f7325a = parcel.readString();
        this.f7326b = (LatLng) parcel.readValue(LatLng.class.getClassLoader());
        this.f7327c = parcel.readString();
    }
}
