package com.amap.api.services.auto;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.col.jmsl.B1;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.interfaces.IAutoTSearch;

/* loaded from: classes.dex */
public class AutoTSearch {

    /* renamed from: a, reason: collision with root package name */
    private IAutoTSearch f17235a;

    public static class FilterBox implements Cloneable, Parcelable {
        public static final Parcelable.Creator<FilterBox> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        private String f17236a;

        /* renamed from: b, reason: collision with root package name */
        private String f17237b;

        /* renamed from: c, reason: collision with root package name */
        private String f17238c;

        /* renamed from: d, reason: collision with root package name */
        private String f17239d;

        /* renamed from: e, reason: collision with root package name */
        private String f17240e;

        public static class a implements Parcelable.Creator<FilterBox> {
            @Override // android.os.Parcelable.Creator
            public FilterBox createFromParcel(Parcel parcel) {
                return new FilterBox(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public FilterBox[] newArray(int i10) {
                return new FilterBox[i10];
            }
        }

        public FilterBox() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String getCheckedLevel() {
            return this.f17237b;
        }

        public String getClassifyV2Data() {
            return this.f17238c;
        }

        public String getClassifyV2Level2Data() {
            return this.f17239d;
        }

        public String getClassifyV2Level3Data() {
            return this.f17240e;
        }

        public String getRetainState() {
            return this.f17236a;
        }

        public void setCheckedLevel(String str) {
            this.f17237b = str;
        }

        public void setClassifyV2Data(String str) {
            this.f17238c = str;
        }

        public void setClassifyV2Level2Data(String str) {
            this.f17239d = str;
        }

        public void setClassifyV2Level3Data(String str) {
            this.f17240e = str;
        }

        public void setRetainState(String str) {
            this.f17236a = str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeString(this.f17236a);
            parcel.writeString(this.f17237b);
            parcel.writeString(this.f17238c);
            parcel.writeString(this.f17239d);
            parcel.writeString(this.f17240e);
        }

        public FilterBox(Parcel parcel) {
            this.f17236a = parcel.readString();
            this.f17237b = parcel.readString();
            this.f17238c = parcel.readString();
            this.f17239d = parcel.readString();
            this.f17240e = parcel.readString();
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public FilterBox m17clone() throws CloneNotSupportedException {
            try {
                super.clone();
            } catch (CloneNotSupportedException e10) {
                e10.printStackTrace();
            }
            FilterBox filterBox = new FilterBox();
            filterBox.setRetainState(this.f17236a);
            filterBox.setCheckedLevel(this.f17237b);
            filterBox.setClassifyV2Data(this.f17238c);
            filterBox.setClassifyV2Level2Data(this.f17239d);
            filterBox.setClassifyV2Level3Data(this.f17240e);
            return filterBox;
        }
    }

    public interface OnChargeStationListener {
        void onChargeStationSearched(AutoTChargeStationResult autoTChargeStationResult, int i10);
    }

    public static class Query implements Cloneable, Parcelable {
        public static final Parcelable.Creator<Query> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        private String f17241a;

        /* renamed from: b, reason: collision with root package name */
        private String f17242b;

        /* renamed from: c, reason: collision with root package name */
        private String f17243c;

        /* renamed from: d, reason: collision with root package name */
        private String f17244d;

        /* renamed from: e, reason: collision with root package name */
        private String f17245e;

        /* renamed from: f, reason: collision with root package name */
        private int f17246f;

        /* renamed from: g, reason: collision with root package name */
        private int f17247g;

        /* renamed from: h, reason: collision with root package name */
        private boolean f17248h;

        /* renamed from: i, reason: collision with root package name */
        private String f17249i;

        /* renamed from: j, reason: collision with root package name */
        private int f17250j;

        /* renamed from: k, reason: collision with root package name */
        private LatLonPoint f17251k;

        /* renamed from: l, reason: collision with root package name */
        private String f17252l;

        /* renamed from: m, reason: collision with root package name */
        private String f17253m;

        /* renamed from: n, reason: collision with root package name */
        private FilterBox f17254n;

        /* renamed from: o, reason: collision with root package name */
        private String f17255o;

        /* renamed from: p, reason: collision with root package name */
        private String f17256p;

        public static class a implements Parcelable.Creator<Query> {
            @Override // android.os.Parcelable.Creator
            public Query createFromParcel(Parcel parcel) {
                return new Query(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public Query[] newArray(int i10) {
                return new Query[i10];
            }
        }

        public Query() {
            this.f17248h = false;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String getAccessKey() {
            return this.f17255o;
        }

        public String getAdCode() {
            return this.f17241a;
        }

        public String getCity() {
            return this.f17242b;
        }

        public String getDataType() {
            return this.f17243c;
        }

        public FilterBox getFilterBox() {
            return this.f17254n;
        }

        public String getGeoObj() {
            return this.f17244d;
        }

        public String getKeywords() {
            return this.f17245e;
        }

        public LatLonPoint getLatLonPoint() {
            return this.f17251k;
        }

        public int getPageNum() {
            return this.f17246f;
        }

        public int getPageSize() {
            return this.f17247g;
        }

        public String getQueryType() {
            return this.f17249i;
        }

        public int getRange() {
            return this.f17250j;
        }

        public String getSecretKey() {
            return this.f17256p;
        }

        public String getUserCity() {
            return this.f17253m;
        }

        public String getUserLoc() {
            return this.f17252l;
        }

        public boolean isQii() {
            return this.f17248h;
        }

        public void setAccessKey(String str) {
            this.f17255o = str;
        }

        public void setAdCode(String str) {
            this.f17241a = str;
        }

        public void setCity(String str) {
            this.f17242b = str;
        }

        public void setDataType(String str) {
            this.f17243c = str;
        }

        public void setFilterBox(FilterBox filterBox) {
            this.f17254n = filterBox;
        }

        public void setGeoObj(String str) {
            this.f17244d = str;
        }

        public void setKeywords(String str) {
            this.f17245e = str;
        }

        public void setLatLonPoint(LatLonPoint latLonPoint) {
            this.f17251k = latLonPoint;
        }

        public void setPageNum(int i10) {
            this.f17246f = i10;
        }

        public void setPageSize(int i10) {
            this.f17247g = i10;
        }

        public void setQii(boolean z10) {
            this.f17248h = z10;
        }

        public void setQueryType(String str) {
            this.f17249i = str;
        }

        public void setRange(int i10) {
            this.f17250j = i10;
        }

        public void setSecretKey(String str) {
            this.f17256p = str;
        }

        public void setUserCity(String str) {
            this.f17253m = str;
        }

        public void setUserLoc(String str) {
            this.f17252l = str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeString(this.f17241a);
            parcel.writeString(this.f17242b);
            parcel.writeString(this.f17243c);
            parcel.writeString(this.f17244d);
            parcel.writeString(this.f17245e);
            parcel.writeInt(this.f17246f);
            parcel.writeInt(this.f17247g);
            parcel.writeByte(this.f17248h ? (byte) 1 : (byte) 0);
            parcel.writeString(this.f17249i);
            parcel.writeInt(this.f17250j);
            parcel.writeParcelable(this.f17251k, i10);
            parcel.writeString(this.f17252l);
            parcel.writeString(this.f17253m);
            parcel.writeParcelable(this.f17254n, i10);
            parcel.writeString(this.f17255o);
            parcel.writeString(this.f17256p);
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public Query m18clone() throws CloneNotSupportedException {
            try {
                super.clone();
            } catch (CloneNotSupportedException e10) {
                e10.printStackTrace();
            }
            Query query = new Query();
            query.setAdCode(this.f17241a);
            query.setCity(this.f17242b);
            query.setDataType(this.f17243c);
            query.setGeoObj(this.f17244d);
            query.setKeywords(this.f17245e);
            query.setPageNum(this.f17246f);
            query.setPageSize(this.f17247g);
            query.setQii(this.f17248h);
            query.setQueryType(this.f17249i);
            query.setRange(this.f17250j);
            query.setLatLonPoint(this.f17251k);
            query.setUserLoc(this.f17252l);
            query.setUserCity(this.f17253m);
            query.setAccessKey(this.f17255o);
            query.setSecretKey(this.f17256p);
            query.setFilterBox(this.f17254n);
            return query;
        }

        public Query(Parcel parcel) {
            this.f17248h = false;
            this.f17241a = parcel.readString();
            this.f17242b = parcel.readString();
            this.f17243c = parcel.readString();
            this.f17244d = parcel.readString();
            this.f17245e = parcel.readString();
            this.f17246f = parcel.readInt();
            this.f17247g = parcel.readInt();
            this.f17248h = parcel.readByte() != 0;
            this.f17249i = parcel.readString();
            this.f17250j = parcel.readInt();
            this.f17251k = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
            this.f17252l = parcel.readString();
            this.f17253m = parcel.readString();
            this.f17254n = (FilterBox) parcel.readParcelable(FilterBox.class.getClassLoader());
            this.f17255o = parcel.readString();
            this.f17256p = parcel.readString();
        }
    }

    public AutoTSearch(Context context) throws AMapException {
        if (this.f17235a == null) {
            try {
                this.f17235a = new B1(context);
            } catch (Exception e10) {
                e10.printStackTrace();
                if (e10 instanceof AMapException) {
                    throw ((AMapException) e10);
                }
            }
        }
    }

    public AutoTChargeStationResult searchChargeStation() throws AMapException {
        IAutoTSearch iAutoTSearch = this.f17235a;
        if (iAutoTSearch == null) {
            return null;
        }
        return iAutoTSearch.searchChargeStation();
    }

    public void searchChargeStationAsync() throws AMapException {
        IAutoTSearch iAutoTSearch = this.f17235a;
        if (iAutoTSearch == null) {
            return;
        }
        iAutoTSearch.searchChargeStationAsync();
    }

    public void setChargeStationListener(OnChargeStationListener onChargeStationListener) {
        IAutoTSearch iAutoTSearch = this.f17235a;
        if (iAutoTSearch == null || onChargeStationListener == null) {
            return;
        }
        iAutoTSearch.setChargeStationListener(onChargeStationListener);
    }

    public void setQuery(Query query) {
        IAutoTSearch iAutoTSearch = this.f17235a;
        if (iAutoTSearch == null) {
            return;
        }
        iAutoTSearch.setQuery(query);
    }
}
