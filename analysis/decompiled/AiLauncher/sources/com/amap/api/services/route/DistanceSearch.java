package com.amap.api.services.route;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.col.jmsl.C1565i2;
import com.amap.api.col.jmsl.C1631z1;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.interfaces.IDistanceSearch;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class DistanceSearch {
    public static final String EXTENSIONS_ALL = "all";
    public static final String EXTENSIONS_BASE = "base";
    public static final int TYPE_DISTANCE = 0;
    public static final int TYPE_DRIVING_DISTANCE = 1;
    public static final int TYPE_WALK_DISTANCE = 3;

    /* renamed from: a, reason: collision with root package name */
    private IDistanceSearch f17689a;

    public static class DistanceQuery implements Parcelable, Cloneable {
        public static final Parcelable.Creator<DistanceQuery> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        private int f17690a;

        /* renamed from: b, reason: collision with root package name */
        private List<LatLonPoint> f17691b;

        /* renamed from: c, reason: collision with root package name */
        private LatLonPoint f17692c;

        /* renamed from: d, reason: collision with root package name */
        private String f17693d;

        /* renamed from: e, reason: collision with root package name */
        private int f17694e;

        public static class a implements Parcelable.Creator<DistanceQuery> {
            @Override // android.os.Parcelable.Creator
            public DistanceQuery createFromParcel(Parcel parcel) {
                return new DistanceQuery(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public DistanceQuery[] newArray(int i10) {
                return new DistanceQuery[i10];
            }
        }

        public DistanceQuery() {
            this.f17690a = 1;
            this.f17691b = new ArrayList();
            this.f17693d = "base";
            this.f17694e = 4;
        }

        public void addOrigins(LatLonPoint... latLonPointArr) {
            for (LatLonPoint latLonPoint : latLonPointArr) {
                if (latLonPoint != null) {
                    this.f17691b.add(latLonPoint);
                }
            }
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public LatLonPoint getDestination() {
            return this.f17692c;
        }

        public String getExtensions() {
            return this.f17693d;
        }

        public int getMode() {
            return this.f17694e;
        }

        public List<LatLonPoint> getOrigins() {
            return this.f17691b;
        }

        public int getType() {
            return this.f17690a;
        }

        public void setDestination(LatLonPoint latLonPoint) {
            this.f17692c = latLonPoint;
        }

        public void setExtensions(String str) {
            this.f17693d = str;
        }

        public void setMode(int i10) {
            this.f17694e = i10;
        }

        public void setOrigins(List<LatLonPoint> list) {
            if (list != null) {
                this.f17691b = list;
            }
        }

        public void setType(int i10) {
            this.f17690a = i10;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeInt(this.f17690a);
            parcel.writeTypedList(this.f17691b);
            parcel.writeParcelable(this.f17692c, i10);
            parcel.writeString(this.f17693d);
            parcel.writeInt(this.f17694e);
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public DistanceQuery m28clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e10) {
                C1631z1.o(e10, "DistanceSearch", "DistanceQueryclone");
            }
            DistanceQuery distanceQuery = new DistanceQuery();
            distanceQuery.setType(this.f17690a);
            distanceQuery.setOrigins(this.f17691b);
            distanceQuery.setDestination(this.f17692c);
            distanceQuery.setExtensions(this.f17693d);
            distanceQuery.setMode(this.f17694e);
            return distanceQuery;
        }

        public DistanceQuery(Parcel parcel) {
            this.f17690a = 1;
            this.f17691b = new ArrayList();
            this.f17693d = "base";
            this.f17694e = 4;
            this.f17690a = parcel.readInt();
            this.f17691b = parcel.createTypedArrayList(LatLonPoint.CREATOR);
            this.f17692c = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
            this.f17693d = parcel.readString();
            this.f17694e = parcel.readInt();
        }
    }

    public interface OnDistanceSearchListener {
        void onDistanceSearched(DistanceResult distanceResult, int i10);
    }

    public DistanceSearch(Context context) throws AMapException {
        if (this.f17689a == null) {
            try {
                this.f17689a = new C1565i2(context);
            } catch (Exception e10) {
                e10.printStackTrace();
                if (e10 instanceof AMapException) {
                    throw ((AMapException) e10);
                }
            }
        }
    }

    public DistanceResult calculateRouteDistance(DistanceQuery distanceQuery) throws AMapException {
        IDistanceSearch iDistanceSearch = this.f17689a;
        if (iDistanceSearch != null) {
            return iDistanceSearch.calculateRouteDistance(distanceQuery);
        }
        return null;
    }

    public void calculateRouteDistanceAsyn(DistanceQuery distanceQuery) {
        IDistanceSearch iDistanceSearch = this.f17689a;
        if (iDistanceSearch != null) {
            iDistanceSearch.calculateRouteDistanceAsyn(distanceQuery);
        }
    }

    public void setDistanceSearchListener(OnDistanceSearchListener onDistanceSearchListener) {
        IDistanceSearch iDistanceSearch = this.f17689a;
        if (iDistanceSearch != null) {
            iDistanceSearch.setDistanceSearchListener(onDistanceSearchListener);
        }
    }
}
