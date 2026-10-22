package com.baidu.mapapi.map;

import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapsdkplatform.comapi.map.q;
import com.stepos.alphame.utils.Property;

/* loaded from: classes.dex */
public final class BaiduMapOptions implements Parcelable {
    public static final Parcelable.Creator<BaiduMapOptions> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    MapStatus f6249a;

    /* renamed from: b, reason: collision with root package name */
    boolean f6250b;

    /* renamed from: c, reason: collision with root package name */
    int f6251c;

    /* renamed from: d, reason: collision with root package name */
    boolean f6252d;

    /* renamed from: e, reason: collision with root package name */
    boolean f6253e;

    /* renamed from: f, reason: collision with root package name */
    boolean f6254f;

    /* renamed from: g, reason: collision with root package name */
    boolean f6255g;

    /* renamed from: h, reason: collision with root package name */
    boolean f6256h;

    /* renamed from: i, reason: collision with root package name */
    boolean f6257i;

    /* renamed from: j, reason: collision with root package name */
    LogoPosition f6258j;

    /* renamed from: k, reason: collision with root package name */
    Point f6259k;

    /* renamed from: l, reason: collision with root package name */
    Point f6260l;

    public static class a implements Parcelable.Creator<BaiduMapOptions> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BaiduMapOptions createFromParcel(Parcel parcel) {
            return new BaiduMapOptions(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public BaiduMapOptions[] newArray(int i4) {
            return new BaiduMapOptions[i4];
        }
    }

    public BaiduMapOptions() {
        this.f6249a = new MapStatus(Property.DEFAULT_FLOAT_VALUE, new LatLng(39.914935d, 116.403119d), Property.DEFAULT_FLOAT_VALUE, 12.0f, null, null);
        this.f6250b = false;
        this.f6251c = 1;
        this.f6252d = true;
        this.f6253e = true;
        this.f6254f = true;
        this.f6255g = true;
        this.f6256h = true;
        this.f6257i = true;
    }

    public q a() {
        return new q().a(this.f6249a.a()).a(this.f6250b).a(this.f6251c).c(this.f6252d).d(this.f6253e).b(this.f6254f).e(this.f6255g);
    }

    public BaiduMapOptions compassEnabled(boolean z4) {
        this.f6250b = z4;
        return this;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public BaiduMapOptions logoPosition(LogoPosition logoPosition) {
        this.f6258j = logoPosition;
        return this;
    }

    public BaiduMapOptions mapStatus(MapStatus mapStatus) {
        if (mapStatus != null) {
            this.f6249a = mapStatus;
        }
        return this;
    }

    public BaiduMapOptions mapType(int i4) {
        this.f6251c = i4;
        return this;
    }

    public BaiduMapOptions overlookingGesturesEnabled(boolean z4) {
        this.f6254f = z4;
        return this;
    }

    public BaiduMapOptions rotateGesturesEnabled(boolean z4) {
        this.f6252d = z4;
        return this;
    }

    public BaiduMapOptions scaleControlEnabled(boolean z4) {
        this.f6257i = z4;
        return this;
    }

    public BaiduMapOptions scaleControlPosition(Point point) {
        this.f6259k = point;
        return this;
    }

    public BaiduMapOptions scrollGesturesEnabled(boolean z4) {
        this.f6253e = z4;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeParcelable(this.f6249a, i4);
        parcel.writeByte(this.f6250b ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.f6251c);
        parcel.writeByte(this.f6252d ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f6253e ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f6254f ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f6255g ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f6256h ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f6257i ? (byte) 1 : (byte) 0);
        parcel.writeParcelable(this.f6259k, i4);
        parcel.writeParcelable(this.f6260l, i4);
    }

    public BaiduMapOptions zoomControlsEnabled(boolean z4) {
        this.f6256h = z4;
        return this;
    }

    public BaiduMapOptions zoomControlsPosition(Point point) {
        this.f6260l = point;
        return this;
    }

    public BaiduMapOptions zoomGesturesEnabled(boolean z4) {
        this.f6255g = z4;
        return this;
    }

    public BaiduMapOptions(Parcel parcel) {
        this.f6249a = new MapStatus(Property.DEFAULT_FLOAT_VALUE, new LatLng(39.914935d, 116.403119d), Property.DEFAULT_FLOAT_VALUE, 12.0f, null, null);
        this.f6250b = false;
        this.f6251c = 1;
        this.f6252d = true;
        this.f6253e = true;
        this.f6254f = true;
        this.f6255g = true;
        this.f6256h = true;
        this.f6257i = true;
        this.f6249a = (MapStatus) parcel.readParcelable(MapStatus.class.getClassLoader());
        this.f6250b = parcel.readByte() != 0;
        this.f6251c = parcel.readInt();
        this.f6252d = parcel.readByte() != 0;
        this.f6253e = parcel.readByte() != 0;
        this.f6254f = parcel.readByte() != 0;
        this.f6255g = parcel.readByte() != 0;
        this.f6256h = parcel.readByte() != 0;
        this.f6257i = parcel.readByte() != 0;
        this.f6259k = (Point) parcel.readParcelable(Point.class.getClassLoader());
        this.f6260l = (Point) parcel.readParcelable(Point.class.getClassLoader());
    }
}
