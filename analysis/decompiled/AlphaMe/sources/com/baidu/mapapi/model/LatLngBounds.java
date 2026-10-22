package com.baidu.mapapi.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class LatLngBounds implements Parcelable {
    public static final Parcelable.Creator<LatLngBounds> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private LatLng f7229a;
    public final LatLng northeast;
    public final LatLng southwest;

    public static class a implements Parcelable.Creator<LatLngBounds> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public LatLngBounds createFromParcel(Parcel parcel) {
            return new LatLngBounds(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public LatLngBounds[] newArray(int i4) {
            return new LatLngBounds[i4];
        }
    }

    public LatLngBounds(LatLng latLng, LatLng latLng2) {
        this.northeast = latLng;
        this.southwest = latLng2;
    }

    public boolean contains(LatLng latLng) {
        if (latLng == null) {
            return false;
        }
        LatLng latLng2 = this.southwest;
        double d4 = latLng2.latitude;
        LatLng latLng3 = this.northeast;
        double d5 = latLng3.latitude;
        double d6 = latLng2.longitude;
        double d7 = latLng3.longitude;
        double d8 = latLng.latitude;
        double d9 = latLng.longitude;
        return d8 >= d4 && d8 <= d5 && d9 >= d6 && d9 <= d7;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LatLng getCenter() {
        LatLng latLng = this.f7229a;
        if (latLng != null) {
            return latLng;
        }
        GeoPoint geoPointLl2mc = CoordUtil.ll2mc(this.northeast);
        GeoPoint geoPointLl2mc2 = CoordUtil.ll2mc(this.southwest);
        LatLng latLngMc2ll = CoordUtil.mc2ll(new GeoPoint(geoPointLl2mc2.getLatitudeE6() + ((geoPointLl2mc.getLatitudeE6() - geoPointLl2mc2.getLatitudeE6()) / 2.0d), geoPointLl2mc2.getLongitudeE6() + ((geoPointLl2mc.getLongitudeE6() - geoPointLl2mc2.getLongitudeE6()) / 2.0d)));
        this.f7229a = latLngMc2ll;
        return latLngMc2ll;
    }

    public void setCenter(LatLng latLng) {
        this.f7229a = latLng;
    }

    public String toString() {
        return "southwest: " + this.southwest.latitude + ", " + this.southwest.longitude + "\nnortheast: " + this.northeast.latitude + ", " + this.northeast.longitude;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeParcelable(this.northeast, i4);
        parcel.writeParcelable(this.southwest, i4);
    }

    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        private double f7230a;

        /* renamed from: b, reason: collision with root package name */
        private double f7231b;

        /* renamed from: c, reason: collision with root package name */
        private double f7232c;

        /* renamed from: d, reason: collision with root package name */
        private double f7233d;

        /* renamed from: e, reason: collision with root package name */
        private double f7234e;

        /* renamed from: f, reason: collision with root package name */
        private double f7235f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f7236g = true;

        private void a() {
            if (Math.abs(this.f7235f) + Math.abs(this.f7233d) > 180.0d) {
                c();
            } else {
                c();
                b();
            }
        }

        private void b() {
            double d4 = this.f7233d;
            if (d4 > 180.0d) {
                double d5 = d4 - 360.0d;
                this.f7233d = d5;
                double d6 = this.f7232c;
                if (d5 < d6) {
                    this.f7233d = d6;
                    this.f7232c = d5;
                }
            }
        }

        private void c() {
            double d4 = this.f7235f + 360.0d;
            this.f7232c = d4;
            double d5 = this.f7233d;
            if (d4 > d5) {
                this.f7233d = d4;
                this.f7232c = d5;
            }
        }

        public LatLngBounds build() {
            double d4 = this.f7234e;
            if (d4 != 0.0d || this.f7235f != 0.0d) {
                double d5 = this.f7233d;
                if (d5 == 0.0d && this.f7232c == 0.0d) {
                    this.f7233d = d4;
                    this.f7232c = this.f7235f;
                } else if (Math.abs(d5) > 90.0d && Math.abs(this.f7235f) > 90.0d) {
                    c();
                } else if (Math.abs(this.f7233d) >= 90.0d || Math.abs(this.f7235f) >= 90.0d) {
                    a();
                } else {
                    c();
                    b();
                }
            }
            return new LatLngBounds(new LatLng(this.f7231b, this.f7233d), new LatLng(this.f7230a, this.f7232c));
        }

        public Builder include(LatLng latLng) {
            if (latLng == null) {
                return this;
            }
            if (this.f7236g) {
                this.f7236g = false;
                double d4 = latLng.longitude;
                if (d4 >= 0.0d) {
                    this.f7232c = d4;
                    this.f7233d = d4;
                } else {
                    this.f7235f = d4;
                    this.f7234e = d4;
                }
                double d5 = latLng.latitude;
                this.f7230a = d5;
                this.f7231b = d5;
            }
            a(latLng);
            return this;
        }

        private void a(LatLng latLng) {
            if (latLng == null) {
                return;
            }
            double d4 = latLng.latitude;
            double d5 = latLng.longitude;
            if (d4 < this.f7230a) {
                this.f7230a = d4;
            }
            if (d4 > this.f7231b) {
                this.f7231b = d4;
            }
            if (d5 < 0.0d) {
                if (d5 < this.f7235f) {
                    this.f7235f = d5;
                }
                if (d5 > this.f7234e) {
                    this.f7234e = d5;
                    return;
                }
                return;
            }
            if (d5 < this.f7232c) {
                this.f7232c = d5;
            }
            if (d5 > this.f7233d) {
                this.f7233d = d5;
                if (this.f7232c == 0.0d) {
                    this.f7232c = d5;
                }
            }
            if (d5 == 0.0d) {
                this.f7234e = d5;
            }
        }

        public Builder include(List<LatLng> list) {
            if (list != null && list.size() != 0) {
                if (list.get(0) != null && this.f7236g) {
                    this.f7236g = false;
                    if (list.get(0).longitude >= 0.0d) {
                        double d4 = list.get(0).longitude;
                        this.f7232c = d4;
                        this.f7233d = d4;
                    } else {
                        double d5 = list.get(0).longitude;
                        this.f7235f = d5;
                        this.f7234e = d5;
                    }
                    double d6 = list.get(0).latitude;
                    this.f7230a = d6;
                    this.f7231b = d6;
                }
                Iterator<LatLng> it = list.iterator();
                while (it.hasNext()) {
                    a(it.next());
                }
            }
            return this;
        }
    }

    public LatLngBounds(Parcel parcel) {
        this.northeast = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        this.southwest = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
    }
}
