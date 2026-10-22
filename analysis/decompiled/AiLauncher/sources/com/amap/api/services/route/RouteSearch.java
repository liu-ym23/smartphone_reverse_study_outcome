package com.amap.api.services.route;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.col.jmsl.C1582n;
import com.amap.api.col.jmsl.C1631z1;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.interfaces.IRouteSearch;
import com.autonavi.aps.amapapi.config.Const;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class RouteSearch {
    public static final int BUS_COMFORTABLE = 4;
    public static final int BUS_DEFAULT = 0;
    public static final int BUS_LEASE_CHANGE = 2;
    public static final int BUS_LEASE_WALK = 3;
    public static final int BUS_NO_SUBWAY = 5;
    public static final int BUS_SAVE_MONEY = 1;
    public static final int BusComfortable = 4;
    public static final int BusDefault = 0;
    public static final int BusLeaseChange = 2;
    public static final int BusLeaseWalk = 3;
    public static final int BusNoSubway = 5;
    public static final int BusSaveMoney = 1;
    public static final int DRIVEING_PLAN_AVOID_CONGESTION_CHOICE_HIGHWAY = 9;
    public static final int DRIVEING_PLAN_AVOID_CONGESTION_FASTEST_SAVE_MONEY = 11;
    public static final int DRIVEING_PLAN_AVOID_CONGESTION_NO_HIGHWAY = 4;
    public static final int DRIVEING_PLAN_AVOID_CONGESTION_SAVE_MONEY = 6;
    public static final int DRIVEING_PLAN_AVOID_CONGESTION_SAVE_MONEY_NO_HIGHWAY = 7;
    public static final int DRIVEING_PLAN_CHOICE_HIGHWAY = 8;
    public static final int DRIVEING_PLAN_DEFAULT = 1;
    public static final int DRIVEING_PLAN_FASTEST_SHORTEST = 10;
    public static final int DRIVEING_PLAN_NO_HIGHWAY = 2;
    public static final int DRIVEING_PLAN_SAVE_MONEY = 3;
    public static final int DRIVEING_PLAN_SAVE_MONEY_NO_HIGHWAY = 5;
    public static final String DRIVING_EXCLUDE_FERRY = "ferry";
    public static final String DRIVING_EXCLUDE_MOTORWAY = "motorway";
    public static final String DRIVING_EXCLUDE_TOLL = "toll";
    public static final int DRIVING_MULTI_CHOICE_AVOID_CONGESTION = 12;
    public static final int DRIVING_MULTI_CHOICE_AVOID_CONGESTION_NO_HIGHWAY = 15;
    public static final int DRIVING_MULTI_CHOICE_AVOID_CONGESTION_NO_HIGHWAY_SAVE_MONEY = 18;
    public static final int DRIVING_MULTI_CHOICE_AVOID_CONGESTION_SAVE_MONEY = 17;
    public static final int DRIVING_MULTI_CHOICE_HIGHWAY = 19;
    public static final int DRIVING_MULTI_CHOICE_HIGHWAY_AVOID_CONGESTION = 20;
    public static final int DRIVING_MULTI_CHOICE_NO_HIGHWAY = 13;
    public static final int DRIVING_MULTI_CHOICE_SAVE_MONEY = 14;
    public static final int DRIVING_MULTI_CHOICE_SAVE_MONEY_NO_HIGHWAY = 16;
    public static final int DRIVING_MULTI_STRATEGY_FASTEST_SAVE_MONEY_SHORTEST = 5;
    public static final int DRIVING_MULTI_STRATEGY_FASTEST_SHORTEST = 11;
    public static final int DRIVING_MULTI_STRATEGY_FASTEST_SHORTEST_AVOID_CONGESTION = 10;
    public static final int DRIVING_NORMAL_CAR = 0;
    public static final int DRIVING_PLUGIN_HYBRID_CAR = 2;
    public static final int DRIVING_PURE_ELECTRIC_VEHICLE = 1;
    public static final int DRIVING_SINGLE_AVOID_CONGESTION = 4;
    public static final int DRIVING_SINGLE_DEFAULT = 0;
    public static final int DRIVING_SINGLE_NO_EXPRESSWAYS = 3;
    public static final int DRIVING_SINGLE_NO_HIGHWAY = 6;
    public static final int DRIVING_SINGLE_NO_HIGHWAY_SAVE_MONEY = 7;
    public static final int DRIVING_SINGLE_NO_HIGHWAY_SAVE_MONEY_AVOID_CONGESTION = 9;
    public static final int DRIVING_SINGLE_SAVE_MONEY = 1;
    public static final int DRIVING_SINGLE_SAVE_MONEY_AVOID_CONGESTION = 8;
    public static final int DRIVING_SINGLE_SHORTEST = 2;
    public static final int DrivingAvoidCongestion = 4;
    public static final int DrivingDefault = 0;
    public static final int DrivingMultiStrategy = 5;
    public static final int DrivingNoExpressways = 3;
    public static final int DrivingNoHighAvoidCongestionSaveMoney = 9;
    public static final int DrivingNoHighWay = 6;
    public static final int DrivingNoHighWaySaveMoney = 7;
    public static final int DrivingSaveMoney = 1;
    public static final int DrivingSaveMoneyAvoidCongestion = 8;
    public static final int DrivingShortDistance = 2;
    public static final String EXTENSIONS_ALL = "all";
    public static final String EXTENSIONS_BASE = "base";
    public static final int RIDING_DEFAULT = 0;
    public static final int RIDING_FAST = 2;
    public static final int RIDING_RECOMMEND = 1;
    public static final int RidingDefault = 0;
    public static final int RidingFast = 2;
    public static final int RidingRecommend = 1;
    public static final int TRUCK_AVOID_CONGESTION = 1;
    public static final int TRUCK_AVOID_CONGESTION_CHOICE_HIGHWAY = 9;
    public static final int TRUCK_AVOID_CONGESTION_NO_HIGHWAY = 4;
    public static final int TRUCK_AVOID_CONGESTION__SAVE_MONEY = 6;
    public static final int TRUCK_AVOID_CONGESTION__SAVE_MONEY_NO_HIGHWAY = 7;
    public static final int TRUCK_CHOICE_HIGHWAY = 8;
    public static final int TRUCK_NO_HIGHWAY = 2;
    public static final int TRUCK_SAVE_MONEY = 3;
    public static final int TRUCK_SAVE_MONEY_NO_HIGHWAY = 5;
    public static final int TRUCK_SIZE_HEAVY = 4;
    public static final int TRUCK_SIZE_LIGHT = 2;
    public static final int TRUCK_SIZE_MEDIUM = 3;
    public static final int TRUCK_SIZE_MINI = 1;
    public static final int WALK_DEFAULT = 0;
    public static final int WALK_MULTI_PATH = 1;
    public static final int WalkDefault = 0;
    public static final int WalkMultipath = 1;

    /* renamed from: a, reason: collision with root package name */
    private IRouteSearch f17807a;

    public static class BusRouteQuery implements Cloneable, Parcelable {
        public static final Parcelable.Creator<BusRouteQuery> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        private FromAndTo f17808a;

        /* renamed from: b, reason: collision with root package name */
        private int f17809b;

        /* renamed from: c, reason: collision with root package name */
        private String f17810c;

        /* renamed from: d, reason: collision with root package name */
        private String f17811d;

        /* renamed from: e, reason: collision with root package name */
        private int f17812e;

        /* renamed from: f, reason: collision with root package name */
        private String f17813f;

        public static class a implements Parcelable.Creator<BusRouteQuery> {
            @Override // android.os.Parcelable.Creator
            public BusRouteQuery createFromParcel(Parcel parcel) {
                return new BusRouteQuery(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public BusRouteQuery[] newArray(int i10) {
                return new BusRouteQuery[i10];
            }
        }

        public BusRouteQuery(FromAndTo fromAndTo, int i10, String str, int i11) {
            this.f17813f = "base";
            this.f17808a = fromAndTo;
            this.f17809b = i10;
            this.f17810c = str;
            this.f17812e = i11;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            BusRouteQuery busRouteQuery = (BusRouteQuery) obj;
            String str = this.f17810c;
            if (str == null) {
                if (busRouteQuery.f17810c != null) {
                    return false;
                }
            } else if (!str.equals(busRouteQuery.f17810c)) {
                return false;
            }
            String str2 = this.f17811d;
            if (str2 == null) {
                if (busRouteQuery.f17811d != null) {
                    return false;
                }
            } else if (!str2.equals(busRouteQuery.f17811d)) {
                return false;
            }
            String str3 = this.f17813f;
            if (str3 == null) {
                if (busRouteQuery.f17813f != null) {
                    return false;
                }
            } else if (!str3.equals(busRouteQuery.f17813f)) {
                return false;
            }
            FromAndTo fromAndTo = this.f17808a;
            if (fromAndTo == null) {
                if (busRouteQuery.f17808a != null) {
                    return false;
                }
            } else if (!fromAndTo.equals(busRouteQuery.f17808a)) {
                return false;
            }
            return this.f17809b == busRouteQuery.f17809b && this.f17812e == busRouteQuery.f17812e;
        }

        public String getCity() {
            return this.f17810c;
        }

        public String getCityd() {
            return this.f17811d;
        }

        public String getExtensions() {
            return this.f17813f;
        }

        public FromAndTo getFromAndTo() {
            return this.f17808a;
        }

        public int getMode() {
            return this.f17809b;
        }

        public int getNightFlag() {
            return this.f17812e;
        }

        public int hashCode() {
            String str = this.f17810c;
            int iHashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
            FromAndTo fromAndTo = this.f17808a;
            int iHashCode2 = (((((iHashCode + (fromAndTo == null ? 0 : fromAndTo.hashCode())) * 31) + this.f17809b) * 31) + this.f17812e) * 31;
            String str2 = this.f17811d;
            return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
        }

        public void setCityd(String str) {
            this.f17811d = str;
        }

        public void setExtensions(String str) {
            this.f17813f = str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeParcelable(this.f17808a, i10);
            parcel.writeInt(this.f17809b);
            parcel.writeString(this.f17810c);
            parcel.writeInt(this.f17812e);
            parcel.writeString(this.f17811d);
            parcel.writeString(this.f17813f);
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public BusRouteQuery m29clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e10) {
                C1631z1.o(e10, "RouteSearch", "BusRouteQueryclone");
            }
            BusRouteQuery busRouteQuery = new BusRouteQuery(this.f17808a, this.f17809b, this.f17810c, this.f17812e);
            busRouteQuery.setCityd(this.f17811d);
            busRouteQuery.setExtensions(this.f17813f);
            return busRouteQuery;
        }

        public BusRouteQuery(Parcel parcel) {
            this.f17813f = "base";
            this.f17808a = (FromAndTo) parcel.readParcelable(FromAndTo.class.getClassLoader());
            this.f17809b = parcel.readInt();
            this.f17810c = parcel.readString();
            this.f17812e = parcel.readInt();
            this.f17811d = parcel.readString();
            this.f17813f = parcel.readString();
        }

        public BusRouteQuery() {
            this.f17813f = "base";
        }
    }

    public static class DrivePlanQuery implements Parcelable, Cloneable {
        public static final Parcelable.Creator<DrivePlanQuery> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        private FromAndTo f17814a;

        /* renamed from: b, reason: collision with root package name */
        private String f17815b;

        /* renamed from: c, reason: collision with root package name */
        private int f17816c;

        /* renamed from: d, reason: collision with root package name */
        private int f17817d;

        /* renamed from: e, reason: collision with root package name */
        private int f17818e;

        /* renamed from: f, reason: collision with root package name */
        private int f17819f;

        /* renamed from: g, reason: collision with root package name */
        private int f17820g;

        public static class a implements Parcelable.Creator<DrivePlanQuery> {
            @Override // android.os.Parcelable.Creator
            public DrivePlanQuery createFromParcel(Parcel parcel) {
                return new DrivePlanQuery(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public DrivePlanQuery[] newArray(int i10) {
                return new DrivePlanQuery[i10];
            }
        }

        public DrivePlanQuery(FromAndTo fromAndTo, int i10, int i11, int i12) {
            this.f17816c = 1;
            this.f17817d = 0;
            this.f17814a = fromAndTo;
            this.f17818e = i10;
            this.f17819f = i11;
            this.f17820g = i12;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            DrivePlanQuery drivePlanQuery = (DrivePlanQuery) obj;
            FromAndTo fromAndTo = this.f17814a;
            if (fromAndTo == null) {
                if (drivePlanQuery.f17814a != null) {
                    return false;
                }
            } else if (!fromAndTo.equals(drivePlanQuery.f17814a)) {
                return false;
            }
            String str = this.f17815b;
            if (str == null) {
                if (drivePlanQuery.f17815b != null) {
                    return false;
                }
            } else if (!str.equals(drivePlanQuery.f17815b)) {
                return false;
            }
            return this.f17816c == drivePlanQuery.f17816c && this.f17817d == drivePlanQuery.f17817d && this.f17818e == drivePlanQuery.f17818e && this.f17819f == drivePlanQuery.f17819f && this.f17820g == drivePlanQuery.f17820g;
        }

        public int getCarType() {
            return this.f17817d;
        }

        public int getCount() {
            return this.f17820g;
        }

        public String getDestParentPoiID() {
            return this.f17815b;
        }

        public int getFirstTime() {
            return this.f17818e;
        }

        public FromAndTo getFromAndTo() {
            return this.f17814a;
        }

        public int getInterval() {
            return this.f17819f;
        }

        public int getMode() {
            return this.f17816c;
        }

        public int hashCode() {
            FromAndTo fromAndTo = this.f17814a;
            int iHashCode = ((fromAndTo == null ? 0 : fromAndTo.hashCode()) + 31) * 31;
            String str = this.f17815b;
            return ((((((((((iHashCode + (str != null ? str.hashCode() : 0)) * 31) + this.f17816c) * 31) + this.f17817d) * 31) + this.f17818e) * 31) + this.f17819f) * 31) + this.f17820g;
        }

        public void setCarType(int i10) {
            this.f17817d = i10;
        }

        public void setDestParentPoiID(String str) {
            this.f17815b = str;
        }

        public void setMode(int i10) {
            this.f17816c = i10;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeParcelable(this.f17814a, i10);
            parcel.writeString(this.f17815b);
            parcel.writeInt(this.f17816c);
            parcel.writeInt(this.f17817d);
            parcel.writeInt(this.f17818e);
            parcel.writeInt(this.f17819f);
            parcel.writeInt(this.f17820g);
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public DrivePlanQuery m30clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e10) {
                C1631z1.o(e10, "RouteSearch", "DriveRouteQueryclone");
            }
            DrivePlanQuery drivePlanQuery = new DrivePlanQuery(this.f17814a, this.f17818e, this.f17819f, this.f17820g);
            drivePlanQuery.setDestParentPoiID(this.f17815b);
            drivePlanQuery.setMode(this.f17816c);
            drivePlanQuery.setCarType(this.f17817d);
            return drivePlanQuery;
        }

        public DrivePlanQuery() {
            this.f17816c = 1;
            this.f17817d = 0;
            this.f17818e = 0;
            this.f17819f = 0;
            this.f17820g = 48;
        }

        public DrivePlanQuery(Parcel parcel) {
            this.f17816c = 1;
            this.f17817d = 0;
            this.f17818e = 0;
            this.f17819f = 0;
            this.f17820g = 48;
            this.f17814a = (FromAndTo) parcel.readParcelable(FromAndTo.class.getClassLoader());
            this.f17815b = parcel.readString();
            this.f17816c = parcel.readInt();
            this.f17817d = parcel.readInt();
            this.f17818e = parcel.readInt();
            this.f17819f = parcel.readInt();
            this.f17820g = parcel.readInt();
        }
    }

    public static class DriveRouteQuery implements Parcelable, Cloneable {
        public static final Parcelable.Creator<DriveRouteQuery> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        private FromAndTo f17821a;

        /* renamed from: b, reason: collision with root package name */
        private int f17822b;

        /* renamed from: c, reason: collision with root package name */
        private List<LatLonPoint> f17823c;

        /* renamed from: d, reason: collision with root package name */
        private List<List<LatLonPoint>> f17824d;

        /* renamed from: e, reason: collision with root package name */
        private String f17825e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f17826f;

        /* renamed from: g, reason: collision with root package name */
        private int f17827g;

        /* renamed from: h, reason: collision with root package name */
        private String f17828h;

        /* renamed from: i, reason: collision with root package name */
        private String f17829i;

        public static class a implements Parcelable.Creator<DriveRouteQuery> {
            @Override // android.os.Parcelable.Creator
            public DriveRouteQuery createFromParcel(Parcel parcel) {
                return new DriveRouteQuery(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public DriveRouteQuery[] newArray(int i10) {
                return new DriveRouteQuery[i10];
            }
        }

        public DriveRouteQuery(FromAndTo fromAndTo, int i10, List<LatLonPoint> list, List<List<LatLonPoint>> list2, String str) {
            this.f17826f = true;
            this.f17827g = 0;
            this.f17828h = null;
            this.f17829i = "base";
            this.f17821a = fromAndTo;
            this.f17822b = i10;
            this.f17823c = list;
            this.f17824d = list2;
            this.f17825e = str;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            DriveRouteQuery driveRouteQuery = (DriveRouteQuery) obj;
            String str = this.f17825e;
            if (str == null) {
                if (driveRouteQuery.f17825e != null) {
                    return false;
                }
            } else if (!str.equals(driveRouteQuery.f17825e)) {
                return false;
            }
            List<List<LatLonPoint>> list = this.f17824d;
            if (list == null) {
                if (driveRouteQuery.f17824d != null) {
                    return false;
                }
            } else if (!list.equals(driveRouteQuery.f17824d)) {
                return false;
            }
            FromAndTo fromAndTo = this.f17821a;
            if (fromAndTo == null) {
                if (driveRouteQuery.f17821a != null) {
                    return false;
                }
            } else if (!fromAndTo.equals(driveRouteQuery.f17821a)) {
                return false;
            }
            if (this.f17822b != driveRouteQuery.f17822b) {
                return false;
            }
            List<LatLonPoint> list2 = this.f17823c;
            if (list2 == null) {
                if (driveRouteQuery.f17823c != null) {
                    return false;
                }
            } else if (!list2.equals(driveRouteQuery.f17823c) || this.f17826f != driveRouteQuery.isUseFerry() || this.f17827g != driveRouteQuery.f17827g) {
                return false;
            }
            String str2 = this.f17829i;
            if (str2 == null) {
                if (driveRouteQuery.f17829i != null) {
                    return false;
                }
            } else if (!str2.equals(driveRouteQuery.f17829i)) {
                return false;
            }
            return true;
        }

        public String getAvoidRoad() {
            return this.f17825e;
        }

        public List<List<LatLonPoint>> getAvoidpolygons() {
            return this.f17824d;
        }

        public String getAvoidpolygonsStr() {
            StringBuffer stringBuffer = new StringBuffer();
            List<List<LatLonPoint>> list = this.f17824d;
            if (list == null || list.size() == 0) {
                return null;
            }
            for (int i10 = 0; i10 < this.f17824d.size(); i10++) {
                List<LatLonPoint> list2 = this.f17824d.get(i10);
                for (int i11 = 0; i11 < list2.size(); i11++) {
                    LatLonPoint latLonPoint = list2.get(i11);
                    stringBuffer.append(latLonPoint.getLongitude());
                    stringBuffer.append(Const.STR_MART_COMMA);
                    stringBuffer.append(latLonPoint.getLatitude());
                    if (i11 < list2.size() - 1) {
                        stringBuffer.append(Const.STR_MART_SEMICOLON);
                    }
                }
                if (i10 < this.f17824d.size() - 1) {
                    stringBuffer.append("|");
                }
            }
            return stringBuffer.toString();
        }

        public int getCarType() {
            return this.f17827g;
        }

        public String getExclude() {
            return this.f17828h;
        }

        public String getExtensions() {
            return this.f17829i;
        }

        public FromAndTo getFromAndTo() {
            return this.f17821a;
        }

        public int getMode() {
            return this.f17822b;
        }

        public List<LatLonPoint> getPassedByPoints() {
            return this.f17823c;
        }

        public String getPassedPointStr() {
            StringBuffer stringBuffer = new StringBuffer();
            List<LatLonPoint> list = this.f17823c;
            if (list == null || list.size() == 0) {
                return null;
            }
            for (int i10 = 0; i10 < this.f17823c.size(); i10++) {
                LatLonPoint latLonPoint = this.f17823c.get(i10);
                stringBuffer.append(latLonPoint.getLongitude());
                stringBuffer.append(Const.STR_MART_COMMA);
                stringBuffer.append(latLonPoint.getLatitude());
                if (i10 < this.f17823c.size() - 1) {
                    stringBuffer.append(Const.STR_MART_SEMICOLON);
                }
            }
            return stringBuffer.toString();
        }

        public boolean hasAvoidRoad() {
            return !C1631z1.p(getAvoidRoad());
        }

        public boolean hasAvoidpolygons() {
            return !C1631z1.p(getAvoidpolygonsStr());
        }

        public boolean hasPassPoint() {
            return !C1631z1.p(getPassedPointStr());
        }

        public int hashCode() {
            String str = this.f17825e;
            int iHashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
            List<List<LatLonPoint>> list = this.f17824d;
            int iHashCode2 = (iHashCode + (list == null ? 0 : list.hashCode())) * 31;
            FromAndTo fromAndTo = this.f17821a;
            int iHashCode3 = (((iHashCode2 + (fromAndTo == null ? 0 : fromAndTo.hashCode())) * 31) + this.f17822b) * 31;
            List<LatLonPoint> list2 = this.f17823c;
            return ((iHashCode3 + (list2 != null ? list2.hashCode() : 0)) * 31) + this.f17827g;
        }

        public boolean isUseFerry() {
            return this.f17826f;
        }

        public void setCarType(int i10) {
            this.f17827g = i10;
        }

        public void setExclude(String str) {
            this.f17828h = str;
        }

        public void setExtensions(String str) {
            this.f17829i = str;
        }

        public void setUseFerry(boolean z10) {
            this.f17826f = z10;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeParcelable(this.f17821a, i10);
            parcel.writeInt(this.f17822b);
            parcel.writeTypedList(this.f17823c);
            List<List<LatLonPoint>> list = this.f17824d;
            if (list == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(list.size());
                Iterator<List<LatLonPoint>> it = this.f17824d.iterator();
                while (it.hasNext()) {
                    parcel.writeTypedList(it.next());
                }
            }
            parcel.writeString(this.f17825e);
            parcel.writeInt(this.f17826f ? 1 : 0);
            parcel.writeInt(this.f17827g);
            parcel.writeString(this.f17828h);
            parcel.writeString(this.f17829i);
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public DriveRouteQuery m31clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e10) {
                C1631z1.o(e10, "RouteSearch", "DriveRouteQueryclone");
            }
            DriveRouteQuery driveRouteQuery = new DriveRouteQuery(this.f17821a, this.f17822b, this.f17823c, this.f17824d, this.f17825e);
            driveRouteQuery.setUseFerry(this.f17826f);
            driveRouteQuery.setCarType(this.f17827g);
            driveRouteQuery.setExclude(this.f17828h);
            driveRouteQuery.setExtensions(this.f17829i);
            return driveRouteQuery;
        }

        public DriveRouteQuery(Parcel parcel) {
            this.f17826f = true;
            this.f17827g = 0;
            this.f17828h = null;
            this.f17829i = "base";
            this.f17821a = (FromAndTo) parcel.readParcelable(FromAndTo.class.getClassLoader());
            this.f17822b = parcel.readInt();
            this.f17823c = parcel.createTypedArrayList(LatLonPoint.CREATOR);
            int i10 = parcel.readInt();
            if (i10 == 0) {
                this.f17824d = null;
            } else {
                this.f17824d = new ArrayList();
            }
            for (int i11 = 0; i11 < i10; i11++) {
                this.f17824d.add(parcel.createTypedArrayList(LatLonPoint.CREATOR));
            }
            this.f17825e = parcel.readString();
            this.f17826f = parcel.readInt() == 1;
            this.f17827g = parcel.readInt();
            this.f17828h = parcel.readString();
            this.f17829i = parcel.readString();
        }

        public DriveRouteQuery() {
            this.f17826f = true;
            this.f17827g = 0;
            this.f17828h = null;
            this.f17829i = "base";
        }
    }

    public static class FromAndTo implements Cloneable, Parcelable {
        public static final Parcelable.Creator<FromAndTo> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        private LatLonPoint f17830a;

        /* renamed from: b, reason: collision with root package name */
        private LatLonPoint f17831b;

        /* renamed from: c, reason: collision with root package name */
        private String f17832c;

        /* renamed from: d, reason: collision with root package name */
        private String f17833d;

        /* renamed from: e, reason: collision with root package name */
        private String f17834e;

        /* renamed from: f, reason: collision with root package name */
        private String f17835f;

        /* renamed from: g, reason: collision with root package name */
        private String f17836g;

        /* renamed from: h, reason: collision with root package name */
        private String f17837h;

        public static class a implements Parcelable.Creator<FromAndTo> {
            @Override // android.os.Parcelable.Creator
            public FromAndTo createFromParcel(Parcel parcel) {
                return new FromAndTo(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public FromAndTo[] newArray(int i10) {
                return new FromAndTo[i10];
            }
        }

        public FromAndTo(LatLonPoint latLonPoint, LatLonPoint latLonPoint2) {
            this.f17830a = latLonPoint;
            this.f17831b = latLonPoint2;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            FromAndTo fromAndTo = (FromAndTo) obj;
            String str = this.f17833d;
            if (str == null) {
                if (fromAndTo.f17833d != null) {
                    return false;
                }
            } else if (!str.equals(fromAndTo.f17833d)) {
                return false;
            }
            LatLonPoint latLonPoint = this.f17830a;
            if (latLonPoint == null) {
                if (fromAndTo.f17830a != null) {
                    return false;
                }
            } else if (!latLonPoint.equals(fromAndTo.f17830a)) {
                return false;
            }
            String str2 = this.f17832c;
            if (str2 == null) {
                if (fromAndTo.f17832c != null) {
                    return false;
                }
            } else if (!str2.equals(fromAndTo.f17832c)) {
                return false;
            }
            LatLonPoint latLonPoint2 = this.f17831b;
            if (latLonPoint2 == null) {
                if (fromAndTo.f17831b != null) {
                    return false;
                }
            } else if (!latLonPoint2.equals(fromAndTo.f17831b)) {
                return false;
            }
            String str3 = this.f17834e;
            if (str3 == null) {
                if (fromAndTo.f17834e != null) {
                    return false;
                }
            } else if (!str3.equals(fromAndTo.f17834e)) {
                return false;
            }
            String str4 = this.f17835f;
            if (str4 == null) {
                if (fromAndTo.f17835f != null) {
                    return false;
                }
            } else if (!str4.equals(fromAndTo.f17835f)) {
                return false;
            }
            return true;
        }

        public String getDestinationPoiID() {
            return this.f17833d;
        }

        public String getDestinationType() {
            return this.f17835f;
        }

        public LatLonPoint getFrom() {
            return this.f17830a;
        }

        public String getOriginType() {
            return this.f17834e;
        }

        public String getPlateNumber() {
            return this.f17837h;
        }

        public String getPlateProvince() {
            return this.f17836g;
        }

        public String getStartPoiID() {
            return this.f17832c;
        }

        public LatLonPoint getTo() {
            return this.f17831b;
        }

        public int hashCode() {
            String str = this.f17833d;
            int iHashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
            LatLonPoint latLonPoint = this.f17830a;
            int iHashCode2 = (iHashCode + (latLonPoint == null ? 0 : latLonPoint.hashCode())) * 31;
            String str2 = this.f17832c;
            int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            LatLonPoint latLonPoint2 = this.f17831b;
            int iHashCode4 = (iHashCode3 + (latLonPoint2 == null ? 0 : latLonPoint2.hashCode())) * 31;
            String str3 = this.f17834e;
            int iHashCode5 = (iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.f17835f;
            return iHashCode5 + (str4 != null ? str4.hashCode() : 0);
        }

        public void setDestinationPoiID(String str) {
            this.f17833d = str;
        }

        public void setDestinationType(String str) {
            this.f17835f = str;
        }

        public void setOriginType(String str) {
            this.f17834e = str;
        }

        public void setPlateNumber(String str) {
            this.f17837h = str;
        }

        public void setPlateProvince(String str) {
            this.f17836g = str;
        }

        public void setStartPoiID(String str) {
            this.f17832c = str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeParcelable(this.f17830a, i10);
            parcel.writeParcelable(this.f17831b, i10);
            parcel.writeString(this.f17832c);
            parcel.writeString(this.f17833d);
            parcel.writeString(this.f17834e);
            parcel.writeString(this.f17835f);
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public FromAndTo m32clone() throws CloneNotSupportedException {
            try {
                super.clone();
            } catch (CloneNotSupportedException e10) {
                C1631z1.o(e10, "RouteSearch", "FromAndToclone");
            }
            FromAndTo fromAndTo = new FromAndTo(this.f17830a, this.f17831b);
            fromAndTo.setStartPoiID(this.f17832c);
            fromAndTo.setDestinationPoiID(this.f17833d);
            fromAndTo.setOriginType(this.f17834e);
            fromAndTo.setDestinationType(this.f17835f);
            return fromAndTo;
        }

        public FromAndTo(Parcel parcel) {
            this.f17830a = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
            this.f17831b = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
            this.f17832c = parcel.readString();
            this.f17833d = parcel.readString();
            this.f17834e = parcel.readString();
            this.f17835f = parcel.readString();
        }

        public FromAndTo() {
        }
    }

    public interface OnRoutePlanSearchListener {
        void onDriveRoutePlanSearched(DriveRoutePlanResult driveRoutePlanResult, int i10);
    }

    public interface OnRouteSearchListener {
        void onBusRouteSearched(BusRouteResult busRouteResult, int i10);

        void onDriveRouteSearched(DriveRouteResult driveRouteResult, int i10);

        void onRideRouteSearched(RideRouteResult rideRouteResult, int i10);

        void onWalkRouteSearched(WalkRouteResult walkRouteResult, int i10);
    }

    public interface OnTruckRouteSearchListener {
        void onTruckRouteSearched(TruckRouteRestult truckRouteRestult, int i10);
    }

    public static class RideRouteQuery implements Parcelable, Cloneable {
        public static final Parcelable.Creator<RideRouteQuery> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        private FromAndTo f17838a;

        /* renamed from: b, reason: collision with root package name */
        private int f17839b;

        /* renamed from: c, reason: collision with root package name */
        private String f17840c;

        public static class a implements Parcelable.Creator<RideRouteQuery> {
            @Override // android.os.Parcelable.Creator
            public RideRouteQuery createFromParcel(Parcel parcel) {
                return new RideRouteQuery(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public RideRouteQuery[] newArray(int i10) {
                return new RideRouteQuery[i10];
            }
        }

        public RideRouteQuery(FromAndTo fromAndTo, int i10) {
            this.f17840c = "base";
            this.f17838a = fromAndTo;
            this.f17839b = i10;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            RideRouteQuery rideRouteQuery = (RideRouteQuery) obj;
            FromAndTo fromAndTo = this.f17838a;
            if (fromAndTo == null) {
                if (rideRouteQuery.f17838a != null) {
                    return false;
                }
            } else if (!fromAndTo.equals(rideRouteQuery.f17838a)) {
                return false;
            }
            return this.f17839b == rideRouteQuery.f17839b;
        }

        public String getExtensions() {
            return this.f17840c;
        }

        public FromAndTo getFromAndTo() {
            return this.f17838a;
        }

        public int getMode() {
            return this.f17839b;
        }

        public int hashCode() {
            FromAndTo fromAndTo = this.f17838a;
            return (((fromAndTo == null ? 0 : fromAndTo.hashCode()) + 31) * 31) + this.f17839b;
        }

        public void setExtensions(String str) {
            this.f17840c = str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeParcelable(this.f17838a, i10);
            parcel.writeInt(this.f17839b);
            parcel.writeString(this.f17840c);
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public RideRouteQuery m33clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e10) {
                C1631z1.o(e10, "RouteSearch", "RideRouteQueryclone");
            }
            RideRouteQuery rideRouteQuery = new RideRouteQuery(this.f17838a);
            rideRouteQuery.setExtensions(this.f17840c);
            return rideRouteQuery;
        }

        public RideRouteQuery(FromAndTo fromAndTo) {
            this.f17840c = "base";
            this.f17838a = fromAndTo;
        }

        public RideRouteQuery(Parcel parcel) {
            this.f17840c = "base";
            this.f17838a = (FromAndTo) parcel.readParcelable(FromAndTo.class.getClassLoader());
            this.f17839b = parcel.readInt();
            this.f17840c = parcel.readString();
        }

        public RideRouteQuery() {
            this.f17840c = "base";
        }
    }

    public static class TruckRouteQuery implements Parcelable, Cloneable {
        public static final Parcelable.Creator<TruckRouteQuery> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        private FromAndTo f17841a;

        /* renamed from: b, reason: collision with root package name */
        private int f17842b;

        /* renamed from: c, reason: collision with root package name */
        private int f17843c;

        /* renamed from: d, reason: collision with root package name */
        private List<LatLonPoint> f17844d;

        /* renamed from: e, reason: collision with root package name */
        private float f17845e;

        /* renamed from: f, reason: collision with root package name */
        private float f17846f;

        /* renamed from: g, reason: collision with root package name */
        private float f17847g;

        /* renamed from: h, reason: collision with root package name */
        private float f17848h;

        /* renamed from: i, reason: collision with root package name */
        private float f17849i;

        /* renamed from: j, reason: collision with root package name */
        private String f17850j;

        public static class a implements Parcelable.Creator<TruckRouteQuery> {
            @Override // android.os.Parcelable.Creator
            public TruckRouteQuery createFromParcel(Parcel parcel) {
                return new TruckRouteQuery(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public TruckRouteQuery[] newArray(int i10) {
                return new TruckRouteQuery[i10];
            }
        }

        public TruckRouteQuery(FromAndTo fromAndTo, int i10, List<LatLonPoint> list, int i11) {
            this.f17850j = "base";
            this.f17841a = fromAndTo;
            this.f17843c = i10;
            this.f17844d = list;
            this.f17842b = i11;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String getExtensions() {
            return this.f17850j;
        }

        public FromAndTo getFromAndTo() {
            return this.f17841a;
        }

        public int getMode() {
            return this.f17843c;
        }

        public List<LatLonPoint> getPassedByPoints() {
            return this.f17844d;
        }

        public String getPassedPointStr() {
            StringBuffer stringBuffer = new StringBuffer();
            List<LatLonPoint> list = this.f17844d;
            if (list == null || list.size() == 0) {
                return null;
            }
            for (int i10 = 0; i10 < this.f17844d.size(); i10++) {
                LatLonPoint latLonPoint = this.f17844d.get(i10);
                stringBuffer.append(latLonPoint.getLongitude());
                stringBuffer.append(Const.STR_MART_COMMA);
                stringBuffer.append(latLonPoint.getLatitude());
                if (i10 < this.f17844d.size() - 1) {
                    stringBuffer.append(Const.STR_MART_SEMICOLON);
                }
            }
            return stringBuffer.toString();
        }

        public float getTruckAxis() {
            return this.f17849i;
        }

        public float getTruckHeight() {
            return this.f17845e;
        }

        public float getTruckLoad() {
            return this.f17847g;
        }

        public int getTruckSize() {
            return this.f17842b;
        }

        public float getTruckWeight() {
            return this.f17848h;
        }

        public float getTruckWidth() {
            return this.f17846f;
        }

        public boolean hasPassPoint() {
            return !C1631z1.p(getPassedPointStr());
        }

        public void setExtensions(String str) {
            this.f17850j = str;
        }

        public void setMode(int i10) {
            this.f17843c = i10;
        }

        public void setTruckAxis(float f10) {
            this.f17849i = f10;
        }

        public void setTruckHeight(float f10) {
            this.f17845e = f10;
        }

        public void setTruckLoad(float f10) {
            this.f17847g = f10;
        }

        public void setTruckSize(int i10) {
            this.f17842b = i10;
        }

        public void setTruckWeight(float f10) {
            this.f17848h = f10;
        }

        public void setTruckWidth(float f10) {
            this.f17846f = f10;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeParcelable(this.f17841a, i10);
            parcel.writeInt(this.f17842b);
            parcel.writeInt(this.f17843c);
            parcel.writeTypedList(this.f17844d);
            parcel.writeFloat(this.f17845e);
            parcel.writeFloat(this.f17846f);
            parcel.writeFloat(this.f17847g);
            parcel.writeFloat(this.f17848h);
            parcel.writeFloat(this.f17849i);
            parcel.writeString(this.f17850j);
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public TruckRouteQuery m34clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e10) {
                C1631z1.o(e10, "RouteSearch", "TruckRouteQueryclone");
            }
            TruckRouteQuery truckRouteQuery = new TruckRouteQuery(this.f17841a, this.f17843c, this.f17844d, this.f17842b);
            truckRouteQuery.setExtensions(this.f17850j);
            return truckRouteQuery;
        }

        public TruckRouteQuery(Parcel parcel) {
            this.f17842b = 2;
            this.f17850j = "base";
            this.f17841a = (FromAndTo) parcel.readParcelable(FromAndTo.class.getClassLoader());
            this.f17842b = parcel.readInt();
            this.f17843c = parcel.readInt();
            this.f17844d = parcel.createTypedArrayList(LatLonPoint.CREATOR);
            this.f17845e = parcel.readFloat();
            this.f17846f = parcel.readFloat();
            this.f17847g = parcel.readFloat();
            this.f17848h = parcel.readFloat();
            this.f17849i = parcel.readFloat();
            this.f17850j = parcel.readString();
        }
    }

    public static class WalkRouteQuery implements Parcelable, Cloneable {
        public static final Parcelable.Creator<WalkRouteQuery> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        private FromAndTo f17851a;

        /* renamed from: b, reason: collision with root package name */
        private int f17852b;

        /* renamed from: c, reason: collision with root package name */
        private String f17853c;

        public static class a implements Parcelable.Creator<WalkRouteQuery> {
            @Override // android.os.Parcelable.Creator
            public WalkRouteQuery createFromParcel(Parcel parcel) {
                return new WalkRouteQuery(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public WalkRouteQuery[] newArray(int i10) {
                return new WalkRouteQuery[i10];
            }
        }

        public WalkRouteQuery(FromAndTo fromAndTo, int i10) {
            this.f17853c = "base";
            this.f17851a = fromAndTo;
            this.f17852b = i10;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            WalkRouteQuery walkRouteQuery = (WalkRouteQuery) obj;
            FromAndTo fromAndTo = this.f17851a;
            if (fromAndTo == null) {
                if (walkRouteQuery.f17851a != null) {
                    return false;
                }
            } else if (!fromAndTo.equals(walkRouteQuery.f17851a)) {
                return false;
            }
            String str = this.f17853c;
            if (str == null) {
                if (walkRouteQuery.f17853c != null) {
                    return false;
                }
            } else if (!str.equals(walkRouteQuery.f17853c)) {
                return false;
            }
            return this.f17852b == walkRouteQuery.f17852b;
        }

        public String getExtensions() {
            return this.f17853c;
        }

        public FromAndTo getFromAndTo() {
            return this.f17851a;
        }

        public int getMode() {
            return this.f17852b;
        }

        public int hashCode() {
            FromAndTo fromAndTo = this.f17851a;
            return (((fromAndTo == null ? 0 : fromAndTo.hashCode()) + 31) * 31) + this.f17852b;
        }

        public void setExtensions(String str) {
            this.f17853c = str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeParcelable(this.f17851a, i10);
            parcel.writeInt(this.f17852b);
            parcel.writeString(this.f17853c);
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public WalkRouteQuery m35clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e10) {
                C1631z1.o(e10, "RouteSearch", "WalkRouteQueryclone");
            }
            WalkRouteQuery walkRouteQuery = new WalkRouteQuery(this.f17851a);
            walkRouteQuery.setExtensions(this.f17853c);
            return walkRouteQuery;
        }

        public WalkRouteQuery(FromAndTo fromAndTo) {
            this.f17853c = "base";
            this.f17851a = fromAndTo;
        }

        public WalkRouteQuery(Parcel parcel) {
            this.f17853c = "base";
            this.f17851a = (FromAndTo) parcel.readParcelable(FromAndTo.class.getClassLoader());
            this.f17852b = parcel.readInt();
            this.f17853c = parcel.readString();
        }

        public WalkRouteQuery() {
            this.f17853c = "base";
        }
    }

    public RouteSearch(Context context) throws AMapException {
        if (this.f17807a == null) {
            try {
                this.f17807a = new C1582n(context);
            } catch (Exception e10) {
                e10.printStackTrace();
                if (e10 instanceof AMapException) {
                    throw ((AMapException) e10);
                }
            }
        }
    }

    public BusRouteResult calculateBusRoute(BusRouteQuery busRouteQuery) throws AMapException {
        IRouteSearch iRouteSearch = this.f17807a;
        if (iRouteSearch != null) {
            return iRouteSearch.calculateBusRoute(busRouteQuery);
        }
        return null;
    }

    public void calculateBusRouteAsyn(BusRouteQuery busRouteQuery) {
        IRouteSearch iRouteSearch = this.f17807a;
        if (iRouteSearch != null) {
            iRouteSearch.calculateBusRouteAsyn(busRouteQuery);
        }
    }

    public DriveRoutePlanResult calculateDrivePlan(DrivePlanQuery drivePlanQuery) throws AMapException {
        IRouteSearch iRouteSearch = this.f17807a;
        if (iRouteSearch != null) {
            return iRouteSearch.calculateDrivePlan(drivePlanQuery);
        }
        return null;
    }

    public void calculateDrivePlanAsyn(DrivePlanQuery drivePlanQuery) {
        IRouteSearch iRouteSearch = this.f17807a;
        if (iRouteSearch != null) {
            iRouteSearch.calculateDrivePlanAsyn(drivePlanQuery);
        }
    }

    public DriveRouteResult calculateDriveRoute(DriveRouteQuery driveRouteQuery) throws AMapException {
        IRouteSearch iRouteSearch = this.f17807a;
        if (iRouteSearch != null) {
            return iRouteSearch.calculateDriveRoute(driveRouteQuery);
        }
        return null;
    }

    public void calculateDriveRouteAsyn(DriveRouteQuery driveRouteQuery) {
        IRouteSearch iRouteSearch = this.f17807a;
        if (iRouteSearch != null) {
            iRouteSearch.calculateDriveRouteAsyn(driveRouteQuery);
        }
    }

    public RideRouteResult calculateRideRoute(RideRouteQuery rideRouteQuery) throws AMapException {
        IRouteSearch iRouteSearch = this.f17807a;
        if (iRouteSearch != null) {
            return iRouteSearch.calculateRideRoute(rideRouteQuery);
        }
        return null;
    }

    public void calculateRideRouteAsyn(RideRouteQuery rideRouteQuery) {
        IRouteSearch iRouteSearch = this.f17807a;
        if (iRouteSearch != null) {
            iRouteSearch.calculateRideRouteAsyn(rideRouteQuery);
        }
    }

    public TruckRouteRestult calculateTruckRoute(TruckRouteQuery truckRouteQuery) throws AMapException {
        IRouteSearch iRouteSearch = this.f17807a;
        if (iRouteSearch != null) {
            return iRouteSearch.calculateTruckRoute(truckRouteQuery);
        }
        return null;
    }

    public void calculateTruckRouteAsyn(TruckRouteQuery truckRouteQuery) {
        IRouteSearch iRouteSearch = this.f17807a;
        if (iRouteSearch != null) {
            iRouteSearch.calculateTruckRouteAsyn(truckRouteQuery);
        }
    }

    public WalkRouteResult calculateWalkRoute(WalkRouteQuery walkRouteQuery) throws AMapException {
        IRouteSearch iRouteSearch = this.f17807a;
        if (iRouteSearch != null) {
            return iRouteSearch.calculateWalkRoute(walkRouteQuery);
        }
        return null;
    }

    public void calculateWalkRouteAsyn(WalkRouteQuery walkRouteQuery) {
        IRouteSearch iRouteSearch = this.f17807a;
        if (iRouteSearch != null) {
            iRouteSearch.calculateWalkRouteAsyn(walkRouteQuery);
        }
    }

    public void setOnRoutePlanSearchListener(OnRoutePlanSearchListener onRoutePlanSearchListener) {
        IRouteSearch iRouteSearch = this.f17807a;
        if (iRouteSearch != null) {
            iRouteSearch.setOnRoutePlanSearchListener(onRoutePlanSearchListener);
        }
    }

    public void setOnTruckRouteSearchListener(OnTruckRouteSearchListener onTruckRouteSearchListener) {
        IRouteSearch iRouteSearch = this.f17807a;
        if (iRouteSearch != null) {
            iRouteSearch.setOnTruckRouteSearchListener(onTruckRouteSearchListener);
        }
    }

    public void setRouteSearchListener(OnRouteSearchListener onRouteSearchListener) {
        IRouteSearch iRouteSearch = this.f17807a;
        if (iRouteSearch != null) {
            iRouteSearch.setRouteSearchListener(onRouteSearchListener);
        }
    }
}
