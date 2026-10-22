package com.amap.api.services.route;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.col.s.be;
import com.amap.api.col.s.i;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.interfaces.IRouteSearch;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
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

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private IRouteSearch f29155a;

    public static class BusRouteQuery implements Parcelable, Cloneable {
        public static final Parcelable.Creator<BusRouteQuery> CREATOR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private FromAndTo f29156a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f29157b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f29158c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f29159d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f29160e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private String f29161f;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        static {
            CREATOR = new AnonymousClass1();
        }

        public int hashCode() {
            String r100 = this.f29158c;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = (r102 + 31) * 31;
            FromAndTo r104 = this.f29156a;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (((((r103 + r105) * 31) + this.f29157b) * 31) + this.f29160e) * 31;
            String r107 = this.f29159d;
            if (r107 == null) goto L15;
            r101 = r107.hashCode();
        L15:
            return r106 + r101;
        L9:
            r105 = r104.hashCode();
            goto L10
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public BusRouteQuery() {
            this.f29161f = "base";
        }

        public BusRouteQuery clone() {
            super.clone();     // Catch: CloneNotSupportedException -> L4
        L6:
            BusRouteQuery r100 = new BusRouteQuery(this.f29156a, this.f29157b, this.f29158c, this.f29160e);
            r100.setCityd(this.f29159d);
            r100.setExtensions(this.f29161f);
            return r100;
        L4:
            e = move-exception;
            i.a(e, "RouteSearch", "BusRouteQueryclone");
            goto L6
        }

        public String getCity() {
            return this.f29158c;
        }

        public String getCityd() {
            return this.f29159d;
        }

        public String getExtensions() {
            return this.f29161f;
        }

        public FromAndTo getFromAndTo() {
            return this.f29156a;
        }

        public int getMode() {
            return this.f29157b;
        }

        public int getNightFlag() {
            return this.f29160e;
        }

        /* JADX INFO: renamed from: clone, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m8040clone() throws CloneNotSupportedException {
            return clone();
        }

        public BusRouteQuery(Parcel r100) {
            this.f29161f = "base";
            this.f29156a = (FromAndTo) r100.readParcelable(FromAndTo.class.getClassLoader());
            this.f29157b = r100.readInt();
            this.f29158c = r100.readString();
            this.f29160e = r100.readInt();
            this.f29159d = r100.readString();
            this.f29161f = r100.readString();
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 != null) goto L9;
            return false;
        L9:
            if (getClass() == r100.getClass()) goto L11;
            return false;
        L11:
            BusRouteQuery r101 = (BusRouteQuery) r100;
            String r102 = this.f29158c;
            if (r102 != null) goto L17;
            if (r101.f29158c == null) goto L19;
            return false;
        L19:
            String r103 = this.f29159d;
            if (r103 != null) goto L25;
            if (r101.f29159d == null) goto L27;
            return false;
        L27:
            String r104 = this.f29161f;
            if (r104 != null) goto L33;
            if (r101.f29161f == null) goto L35;
            return false;
        L35:
            FromAndTo r105 = this.f29156a;
            if (r105 != null) goto L41;
            if (r101.f29156a == null) goto L44;
            return false;
        L44:
            if (this.f29157b == r101.f29157b) goto L47;
            return false;
        L47:
            if (this.f29160e == r101.f29160e) goto L49;
            return false;
        L49:
            return true;
        L41:
            if (r105.equals(r101.f29156a) == true) goto L44;
            return false;
        L33:
            if (r104.equals(r101.f29161f) == true) goto L35;
            return false;
        L25:
            if (r103.equals(r101.f29159d) == true) goto L27;
            return false;
        L17:
            if (r102.equals(r101.f29158c) == true) goto L19;
            return false;
        }

        public void setCityd(String r100) {
            this.f29159d = r100;
        }

        public void setExtensions(String r100) {
            this.f29161f = r100;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r100, int r101) {
            r100.writeParcelable(this.f29156a, r101);
            r100.writeInt(this.f29157b);
            r100.writeString(this.f29158c);
            r100.writeInt(this.f29160e);
            r100.writeString(this.f29159d);
            r100.writeString(this.f29161f);
        }

        public BusRouteQuery(FromAndTo r100, int r101, String r102, int r103) {
            this.f29161f = "base";
            this.f29156a = r100;
            this.f29157b = r101;
            this.f29158c = r102;
            this.f29160e = r103;
        }
    }

    public static class DrivePlanQuery implements Parcelable, Cloneable {
        public static final Parcelable.Creator<DrivePlanQuery> CREATOR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private FromAndTo f29162a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f29163b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f29164c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f29165d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f29166e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f29167f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f29168g;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        static {
            CREATOR = new AnonymousClass1();
        }

        public int hashCode() {
            FromAndTo r100 = this.f29162a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = (r102 + 31) * 31;
            String r104 = this.f29163b;
            if (r104 == null) goto L11;
            r101 = r104.hashCode();
        L11:
            return ((((((((((r103 + r101) * 31) + this.f29164c) * 31) + this.f29165d) * 31) + this.f29166e) * 31) + this.f29167f) * 31) + this.f29168g;
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public DrivePlanQuery() {
            this.f29164c = 1;
            this.f29165d = 0;
            this.f29166e = 0;
            this.f29167f = 0;
            this.f29168g = 48;
        }

        public DrivePlanQuery clone() {
            super.clone();     // Catch: CloneNotSupportedException -> L4
        L6:
            DrivePlanQuery r100 = new DrivePlanQuery(this.f29162a, this.f29166e, this.f29167f, this.f29168g);
            r100.setDestParentPoiID(this.f29163b);
            r100.setMode(this.f29164c);
            r100.setCarType(this.f29165d);
            return r100;
        L4:
            e = move-exception;
            i.a(e, "RouteSearch", "DriveRouteQueryclone");
            goto L6
        }

        public int getCarType() {
            return this.f29165d;
        }

        public int getCount() {
            return this.f29168g;
        }

        public String getDestParentPoiID() {
            return this.f29163b;
        }

        public int getFirstTime() {
            return this.f29166e;
        }

        public FromAndTo getFromAndTo() {
            return this.f29162a;
        }

        public int getInterval() {
            return this.f29167f;
        }

        public int getMode() {
            return this.f29164c;
        }

        /* JADX INFO: renamed from: clone, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m8041clone() throws CloneNotSupportedException {
            return clone();
        }

        public DrivePlanQuery(Parcel r100) {
            this.f29164c = 1;
            this.f29165d = 0;
            this.f29166e = 0;
            this.f29167f = 0;
            this.f29168g = 48;
            this.f29162a = (FromAndTo) r100.readParcelable(FromAndTo.class.getClassLoader());
            this.f29163b = r100.readString();
            this.f29164c = r100.readInt();
            this.f29165d = r100.readInt();
            this.f29166e = r100.readInt();
            this.f29167f = r100.readInt();
            this.f29168g = r100.readInt();
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 != null) goto L9;
            return false;
        L9:
            if (getClass() == r100.getClass()) goto L11;
            return false;
        L11:
            DrivePlanQuery r101 = (DrivePlanQuery) r100;
            FromAndTo r102 = this.f29162a;
            if (r102 != null) goto L17;
            if (r101.f29162a == null) goto L19;
            return false;
        L19:
            String r103 = this.f29163b;
            if (r103 != null) goto L25;
            if (r101.f29163b == null) goto L28;
            return false;
        L28:
            if (this.f29164c == r101.f29164c) goto L31;
            return false;
        L31:
            if (this.f29165d == r101.f29165d) goto L34;
            return false;
        L34:
            if (this.f29166e == r101.f29166e) goto L37;
            return false;
        L37:
            if (this.f29167f == r101.f29167f) goto L40;
            return false;
        L40:
            if (this.f29168g == r101.f29168g) goto L42;
            return false;
        L42:
            return true;
        L25:
            if (r103.equals(r101.f29163b) == true) goto L28;
            return false;
        L17:
            if (r102.equals(r101.f29162a) == true) goto L19;
            return false;
        }

        public void setCarType(int r100) {
            this.f29165d = r100;
        }

        public void setDestParentPoiID(String r100) {
            this.f29163b = r100;
        }

        public void setMode(int r100) {
            this.f29164c = r100;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r100, int r101) {
            r100.writeParcelable(this.f29162a, r101);
            r100.writeString(this.f29163b);
            r100.writeInt(this.f29164c);
            r100.writeInt(this.f29165d);
            r100.writeInt(this.f29166e);
            r100.writeInt(this.f29167f);
            r100.writeInt(this.f29168g);
        }

        public DrivePlanQuery(FromAndTo r100, int r101, int r102, int r103) {
            this.f29164c = 1;
            this.f29165d = 0;
            this.f29162a = r100;
            this.f29166e = r101;
            this.f29167f = r102;
            this.f29168g = r103;
        }
    }

    public static class DriveRouteQuery implements Parcelable, Cloneable {
        public static final Parcelable.Creator<DriveRouteQuery> CREATOR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private FromAndTo f29169a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f29170b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private List<LatLonPoint> f29171c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private List<List<LatLonPoint>> f29172d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f29173e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f29174f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f29175g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private String f29176h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private String f29177i;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        static {
            CREATOR = new AnonymousClass1();
        }

        public String getAvoidpolygonsStr() {
            StringBuffer r100 = new StringBuffer();
            List<List<LatLonPoint>> r101 = this.f29172d;
            if (r101 != null) goto L5;
            return null;
        L5:
            if (r101.size() == 0) goto L31;
            int r102 = 0;
        L9:
            if (r102 >= this.f29172d.size()) goto L22;
            List r103 = (List) ListProtector.get(this.f29172d, r102);
            int r104 = 0;
        L12:
            if (r104 >= r103.size()) goto L18;
            LatLonPoint r105 = (LatLonPoint) ListProtector.get(r103, r104);
            r100.append(r105.getLongitude());
            r100.append(",");
            r100.append(r105.getLatitude());
            if (r104 >= (r103.size() - 1)) goto L16;
            r100.append(com.alipay.sdk.m.u.i.f25853b);
        L16:
            r104 = r104 + 1;
            goto L12
        L18:
            if (r102 >= (this.f29172d.size() - 1)) goto L20;
            r100.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        L20:
            r102 = r102 + 1;
            goto L9
        L22:
            return r100.toString();
        L31:
            return null;
        }

        public String getPassedPointStr() {
            StringBuffer r100 = new StringBuffer();
            List<LatLonPoint> r101 = this.f29171c;
            if (r101 != null) goto L5;
            return null;
        L5:
            if (r101.size() == 0) goto L21;
            int r102 = 0;
        L9:
            if (r102 >= this.f29171c.size()) goto L15;
            LatLonPoint r103 = (LatLonPoint) ListProtector.get(this.f29171c, r102);
            r100.append(r103.getLongitude());
            r100.append(",");
            r100.append(r103.getLatitude());
            if (r102 >= (this.f29171c.size() - 1)) goto L13;
            r100.append(com.alipay.sdk.m.u.i.f25853b);
        L13:
            r102 = r102 + 1;
            goto L9
        L15:
            return r100.toString();
        L21:
            return null;
        }

        public int hashCode() {
            String r100 = this.f29173e;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = (r102 + 31) * 31;
            List<List<LatLonPoint>> r104 = this.f29172d;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            FromAndTo r107 = this.f29169a;
            if (r107 != null) goto L13;
            int r108 = 0;
        L14:
            int r109 = (((r106 + r108) * 31) + this.f29170b) * 31;
            List<LatLonPoint> r110 = this.f29171c;
            if (r110 == null) goto L19;
            r101 = r110.hashCode();
        L19:
            return ((r109 + r101) * 31) + this.f29175g;
        L13:
            r108 = r107.hashCode();
            goto L14
        L9:
            r105 = r104.hashCode();
            goto L10
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public DriveRouteQuery() {
            this.f29174f = true;
            this.f29175g = 0;
            this.f29176h = null;
            this.f29177i = "base";
        }

        public DriveRouteQuery clone() {
            super.clone();     // Catch: CloneNotSupportedException -> L4
        L6:
            DriveRouteQuery r100 = new DriveRouteQuery(this.f29169a, this.f29170b, this.f29171c, this.f29172d, this.f29173e);
            r100.setUseFerry(this.f29174f);
            r100.setCarType(this.f29175g);
            r100.setExclude(this.f29176h);
            r100.setExtensions(this.f29177i);
            return r100;
        L4:
            e = move-exception;
            i.a(e, "RouteSearch", "DriveRouteQueryclone");
            goto L6
        }

        public boolean hasAvoidRoad() {
            if (i.a(getAvoidRoad()) == false) goto L6;
            return false;
        L6:
            return true;
        }

        public boolean hasAvoidpolygons() {
            if (i.a(getAvoidpolygonsStr()) == false) goto L6;
            return false;
        L6:
            return true;
        }

        public boolean hasPassPoint() {
            if (i.a(getPassedPointStr()) == false) goto L6;
            return false;
        L6:
            return true;
        }

        public String getAvoidRoad() {
            return this.f29173e;
        }

        public List<List<LatLonPoint>> getAvoidpolygons() {
            return this.f29172d;
        }

        public int getCarType() {
            return this.f29175g;
        }

        public String getExclude() {
            return this.f29176h;
        }

        public String getExtensions() {
            return this.f29177i;
        }

        public FromAndTo getFromAndTo() {
            return this.f29169a;
        }

        public int getMode() {
            return this.f29170b;
        }

        public List<LatLonPoint> getPassedByPoints() {
            return this.f29171c;
        }

        public boolean isUseFerry() {
            return this.f29174f;
        }

        /* JADX INFO: renamed from: clone, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m8042clone() throws CloneNotSupportedException {
            return clone();
        }

        public DriveRouteQuery(Parcel r100) {
            boolean r101 = true;
            this.f29174f = true;
            this.f29175g = 0;
            this.f29176h = null;
            this.f29177i = "base";
            this.f29169a = (FromAndTo) r100.readParcelable(FromAndTo.class.getClassLoader());
            this.f29170b = r100.readInt();
            this.f29171c = r100.createTypedArrayList(LatLonPoint.CREATOR);
            int r102 = r100.readInt();
            if (r102 != 0) goto L5;
            this.f29172d = null;
        L6:
            int r103 = 0;
        L7:
            if (r103 >= r102) goto L9;
            this.f29172d.add(r100.createTypedArrayList(LatLonPoint.CREATOR));
            r103 = r103 + 1;
            goto L7
        L9:
            this.f29173e = r100.readString();
            if (r100.readInt() == 1) goto L13;
            r101 = false;
        L13:
            this.f29174f = r101;
            this.f29175g = r100.readInt();
            this.f29176h = r100.readString();
            this.f29177i = r100.readString();
            return;
        L5:
            this.f29172d = new ArrayList();
            goto L6
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 != null) goto L9;
            return false;
        L9:
            if (getClass() == r100.getClass()) goto L11;
            return false;
        L11:
            DriveRouteQuery r101 = (DriveRouteQuery) r100;
            String r102 = this.f29173e;
            if (r102 != null) goto L17;
            if (r101.f29173e == null) goto L19;
            return false;
        L19:
            List<List<LatLonPoint>> r103 = this.f29172d;
            if (r103 != null) goto L25;
            if (r101.f29172d == null) goto L27;
            return false;
        L27:
            FromAndTo r104 = this.f29169a;
            if (r104 != null) goto L33;
            if (r101.f29169a == null) goto L36;
            return false;
        L36:
            if (this.f29170b == r101.f29170b) goto L38;
            return false;
        L38:
            List<LatLonPoint> r105 = this.f29171c;
            if (r105 != null) goto L44;
            if (r101.f29171c == null) goto L52;
            return false;
        L52:
            String r106 = this.f29177i;
            if (r106 != null) goto L58;
            if (r101.f29177i == null) goto L60;
            return false;
        L60:
            return true;
        L58:
            if (r106.equals(r101.f29177i) == true) goto L60;
            return false;
        L44:
            if (r105.equals(r101.f29171c) == true) goto L47;
            return false;
        L47:
            if (this.f29174f == r101.isUseFerry()) goto L50;
            return false;
        L50:
            if (this.f29175g == r101.f29175g) goto L52;
            return false;
        L33:
            if (r104.equals(r101.f29169a) == true) goto L36;
            return false;
        L25:
            if (r103.equals(r101.f29172d) == true) goto L27;
            return false;
        L17:
            if (r102.equals(r101.f29173e) == true) goto L19;
            return false;
        }

        public void setCarType(int r100) {
            this.f29175g = r100;
        }

        public void setExclude(String r100) {
            this.f29176h = r100;
        }

        public void setExtensions(String r100) {
            this.f29177i = r100;
        }

        public void setUseFerry(boolean r100) {
            this.f29174f = r100;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r100, int r101) {
            r100.writeParcelable(this.f29169a, r101);
            r100.writeInt(this.f29170b);
            r100.writeTypedList(this.f29171c);
            List<List<LatLonPoint>> r102 = this.f29172d;
            if (r102 != null) goto L5;
            r100.writeInt(0);
        L9:
            r100.writeString(this.f29173e);
            r100.writeInt(this.f29174f ? 1 : 0);
            r100.writeInt(this.f29175g);
            r100.writeString(this.f29176h);
            r100.writeString(this.f29177i);
            return;
        L5:
            r100.writeInt(r102.size());
            Iterator<List<LatLonPoint>> r103 = this.f29172d.iterator();
        L7:
            if (r103.hasNext() == false) goto L9;
            r100.writeTypedList(r103.next());
            goto L7
        }

        public DriveRouteQuery(FromAndTo r100, int r101, List<LatLonPoint> r102, List<List<LatLonPoint>> r103, String r104) {
            this.f29174f = true;
            this.f29175g = 0;
            this.f29176h = null;
            this.f29177i = "base";
            this.f29169a = r100;
            this.f29170b = r101;
            this.f29171c = r102;
            this.f29172d = r103;
            this.f29173e = r104;
        }
    }

    public static class FromAndTo implements Parcelable, Cloneable {
        public static final Parcelable.Creator<FromAndTo> CREATOR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private LatLonPoint f29178a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private LatLonPoint f29179b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f29180c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f29181d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f29182e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private String f29183f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private String f29184g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private String f29185h;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        static {
            CREATOR = new AnonymousClass1();
        }

        public int hashCode() {
            String r100 = this.f29181d;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = (r102 + 31) * 31;
            LatLonPoint r104 = this.f29178a;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            String r107 = this.f29180c;
            if (r107 != null) goto L13;
            int r108 = 0;
        L14:
            int r109 = (r106 + r108) * 31;
            LatLonPoint r110 = this.f29179b;
            if (r110 != null) goto L17;
            int r111 = 0;
        L18:
            int r112 = (r109 + r111) * 31;
            String r113 = this.f29182e;
            if (r113 != null) goto L21;
            int r114 = 0;
        L22:
            int r115 = (r112 + r114) * 31;
            String r116 = this.f29183f;
            if (r116 == null) goto L27;
            r101 = r116.hashCode();
        L27:
            return r115 + r101;
        L21:
            r114 = r113.hashCode();
            goto L22
        L17:
            r111 = r110.hashCode();
            goto L18
        L13:
            r108 = r107.hashCode();
            goto L14
        L9:
            r105 = r104.hashCode();
            goto L10
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public FromAndTo clone() {
            super.clone();     // Catch: CloneNotSupportedException -> L4
        L6:
            FromAndTo r100 = new FromAndTo(this.f29178a, this.f29179b);
            r100.setStartPoiID(this.f29180c);
            r100.setDestinationPoiID(this.f29181d);
            r100.setOriginType(this.f29182e);
            r100.setDestinationType(this.f29183f);
            return r100;
        L4:
            e = move-exception;
            i.a(e, "RouteSearch", "FromAndToclone");
            goto L6
        }

        public FromAndTo() {
        }

        public String getDestinationPoiID() {
            return this.f29181d;
        }

        public String getDestinationType() {
            return this.f29183f;
        }

        public LatLonPoint getFrom() {
            return this.f29178a;
        }

        public String getOriginType() {
            return this.f29182e;
        }

        public String getPlateNumber() {
            return this.f29185h;
        }

        public String getPlateProvince() {
            return this.f29184g;
        }

        public String getStartPoiID() {
            return this.f29180c;
        }

        public LatLonPoint getTo() {
            return this.f29179b;
        }

        /* JADX INFO: renamed from: clone, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m8043clone() throws CloneNotSupportedException {
            return clone();
        }

        public FromAndTo(Parcel r100) {
            this.f29178a = (LatLonPoint) r100.readParcelable(LatLonPoint.class.getClassLoader());
            this.f29179b = (LatLonPoint) r100.readParcelable(LatLonPoint.class.getClassLoader());
            this.f29180c = r100.readString();
            this.f29181d = r100.readString();
            this.f29182e = r100.readString();
            this.f29183f = r100.readString();
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 != null) goto L9;
            return false;
        L9:
            if (getClass() == r100.getClass()) goto L11;
            return false;
        L11:
            FromAndTo r101 = (FromAndTo) r100;
            String r102 = this.f29181d;
            if (r102 != null) goto L17;
            if (r101.f29181d == null) goto L19;
            return false;
        L19:
            LatLonPoint r103 = this.f29178a;
            if (r103 != null) goto L25;
            if (r101.f29178a == null) goto L27;
            return false;
        L27:
            String r104 = this.f29180c;
            if (r104 != null) goto L33;
            if (r101.f29180c == null) goto L35;
            return false;
        L35:
            LatLonPoint r105 = this.f29179b;
            if (r105 != null) goto L41;
            if (r101.f29179b == null) goto L43;
            return false;
        L43:
            String r106 = this.f29182e;
            if (r106 != null) goto L49;
            if (r101.f29182e == null) goto L51;
            return false;
        L51:
            String r107 = this.f29183f;
            if (r107 != null) goto L57;
            if (r101.f29183f == null) goto L59;
            return false;
        L59:
            return true;
        L57:
            if (r107.equals(r101.f29183f) == true) goto L59;
            return false;
        L49:
            if (r106.equals(r101.f29182e) == true) goto L51;
            return false;
        L41:
            if (r105.equals(r101.f29179b) == true) goto L43;
            return false;
        L33:
            if (r104.equals(r101.f29180c) == true) goto L35;
            return false;
        L25:
            if (r103.equals(r101.f29178a) == true) goto L27;
            return false;
        L17:
            if (r102.equals(r101.f29181d) == true) goto L19;
            return false;
        }

        public void setDestinationPoiID(String r100) {
            this.f29181d = r100;
        }

        public void setDestinationType(String r100) {
            this.f29183f = r100;
        }

        public void setOriginType(String r100) {
            this.f29182e = r100;
        }

        public void setPlateNumber(String r100) {
            this.f29185h = r100;
        }

        public void setPlateProvince(String r100) {
            this.f29184g = r100;
        }

        public void setStartPoiID(String r100) {
            this.f29180c = r100;
        }

        public FromAndTo(LatLonPoint r100, LatLonPoint r101) {
            this.f29178a = r100;
            this.f29179b = r101;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r100, int r101) {
            r100.writeParcelable(this.f29178a, r101);
            r100.writeParcelable(this.f29179b, r101);
            r100.writeString(this.f29180c);
            r100.writeString(this.f29181d);
            r100.writeString(this.f29182e);
            r100.writeString(this.f29183f);
        }
    }

    public interface OnRoutePlanSearchListener {
        void onDriveRoutePlanSearched(DriveRoutePlanResult r100, int r101);
    }

    public interface OnRouteSearchListener {
        void onBusRouteSearched(BusRouteResult r100, int r101);

        void onDriveRouteSearched(DriveRouteResult r100, int r101);

        void onRideRouteSearched(RideRouteResult r100, int r101);

        void onWalkRouteSearched(WalkRouteResult r100, int r101);
    }

    public interface OnTruckRouteSearchListener {
        void onTruckRouteSearched(TruckRouteRestult r100, int r101);
    }

    public static class RideRouteQuery implements Parcelable, Cloneable {
        public static final Parcelable.Creator<RideRouteQuery> CREATOR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private FromAndTo f29186a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f29187b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f29188c;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        static {
            CREATOR = new AnonymousClass1();
        }

        public int hashCode() {
            FromAndTo r100 = this.f29186a;
            if (r100 != null) goto L5;
            int r101 = 0;
        L7:
            return ((r101 + 31) * 31) + this.f29187b;
        L5:
            r101 = r100.hashCode();
            goto L7
        }

        public RideRouteQuery() {
            this.f29188c = "base";
        }

        public RideRouteQuery clone() {
            super.clone();     // Catch: CloneNotSupportedException -> L4
        L6:
            RideRouteQuery r100 = new RideRouteQuery(this.f29186a);
            r100.setExtensions(this.f29188c);
            return r100;
        L4:
            e = move-exception;
            i.a(e, "RouteSearch", "RideRouteQueryclone");
            goto L6
        }

        public String getExtensions() {
            return this.f29188c;
        }

        public FromAndTo getFromAndTo() {
            return this.f29186a;
        }

        public int getMode() {
            return this.f29187b;
        }

        /* JADX INFO: renamed from: clone, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m8044clone() throws CloneNotSupportedException {
            return clone();
        }

        public RideRouteQuery(Parcel r100) {
            this.f29188c = "base";
            this.f29186a = (FromAndTo) r100.readParcelable(FromAndTo.class.getClassLoader());
            this.f29187b = r100.readInt();
            this.f29188c = r100.readString();
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 != null) goto L9;
            return false;
        L9:
            if (getClass() == r100.getClass()) goto L11;
            return false;
        L11:
            RideRouteQuery r101 = (RideRouteQuery) r100;
            FromAndTo r102 = this.f29186a;
            if (r102 != null) goto L17;
            if (r101.f29186a == null) goto L20;
            return false;
        L20:
            if (this.f29187b == r101.f29187b) goto L22;
            return false;
        L22:
            return true;
        L17:
            if (r102.equals(r101.f29186a) == true) goto L20;
            return false;
        }

        public void setExtensions(String r100) {
            this.f29188c = r100;
        }

        public RideRouteQuery(FromAndTo r100) {
            this.f29188c = "base";
            this.f29186a = r100;
        }

        public RideRouteQuery(FromAndTo r100, int r101) {
            this.f29188c = "base";
            this.f29186a = r100;
            this.f29187b = r101;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r100, int r101) {
            r100.writeParcelable(this.f29186a, r101);
            r100.writeInt(this.f29187b);
            r100.writeString(this.f29188c);
        }
    }

    public static class TruckRouteQuery implements Parcelable, Cloneable {
        public static final Parcelable.Creator<TruckRouteQuery> CREATOR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private FromAndTo f29189a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f29190b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f29191c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private List<LatLonPoint> f29192d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private float f29193e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private float f29194f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private float f29195g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private float f29196h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private float f29197i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private String f29198j;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        static {
            CREATOR = new AnonymousClass1();
        }

        public String getPassedPointStr() {
            StringBuffer r100 = new StringBuffer();
            List<LatLonPoint> r101 = this.f29192d;
            if (r101 != null) goto L5;
            return null;
        L5:
            if (r101.size() == 0) goto L21;
            int r102 = 0;
        L9:
            if (r102 >= this.f29192d.size()) goto L15;
            LatLonPoint r103 = (LatLonPoint) ListProtector.get(this.f29192d, r102);
            r100.append(r103.getLongitude());
            r100.append(",");
            r100.append(r103.getLatitude());
            if (r102 >= (this.f29192d.size() - 1)) goto L13;
            r100.append(com.alipay.sdk.m.u.i.f25853b);
        L13:
            r102 = r102 + 1;
            goto L9
        L15:
            return r100.toString();
        L21:
            return null;
        }

        public TruckRouteQuery clone() {
            super.clone();     // Catch: CloneNotSupportedException -> L4
        L6:
            TruckRouteQuery r100 = new TruckRouteQuery(this.f29189a, this.f29191c, this.f29192d, this.f29190b);
            r100.setExtensions(this.f29198j);
            return r100;
        L4:
            e = move-exception;
            i.a(e, "RouteSearch", "TruckRouteQueryclone");
            goto L6
        }

        public boolean hasPassPoint() {
            if (i.a(getPassedPointStr()) == false) goto L6;
            return false;
        L6:
            return true;
        }

        public String getExtensions() {
            return this.f29198j;
        }

        public FromAndTo getFromAndTo() {
            return this.f29189a;
        }

        public int getMode() {
            return this.f29191c;
        }

        public List<LatLonPoint> getPassedByPoints() {
            return this.f29192d;
        }

        public float getTruckAxis() {
            return this.f29197i;
        }

        public float getTruckHeight() {
            return this.f29193e;
        }

        public float getTruckLoad() {
            return this.f29195g;
        }

        public int getTruckSize() {
            return this.f29190b;
        }

        public float getTruckWeight() {
            return this.f29196h;
        }

        public float getTruckWidth() {
            return this.f29194f;
        }

        /* JADX INFO: renamed from: clone, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m8045clone() throws CloneNotSupportedException {
            return clone();
        }

        public TruckRouteQuery(Parcel r100) {
            this.f29190b = 2;
            this.f29198j = "base";
            this.f29189a = (FromAndTo) r100.readParcelable(FromAndTo.class.getClassLoader());
            this.f29190b = r100.readInt();
            this.f29191c = r100.readInt();
            this.f29192d = r100.createTypedArrayList(LatLonPoint.CREATOR);
            this.f29193e = r100.readFloat();
            this.f29194f = r100.readFloat();
            this.f29195g = r100.readFloat();
            this.f29196h = r100.readFloat();
            this.f29197i = r100.readFloat();
            this.f29198j = r100.readString();
        }

        public void setExtensions(String r100) {
            this.f29198j = r100;
        }

        public void setMode(int r100) {
            this.f29191c = r100;
        }

        public void setTruckAxis(float r100) {
            this.f29197i = r100;
        }

        public void setTruckHeight(float r100) {
            this.f29193e = r100;
        }

        public void setTruckLoad(float r100) {
            this.f29195g = r100;
        }

        public void setTruckSize(int r100) {
            this.f29190b = r100;
        }

        public void setTruckWeight(float r100) {
            this.f29196h = r100;
        }

        public void setTruckWidth(float r100) {
            this.f29194f = r100;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r100, int r101) {
            r100.writeParcelable(this.f29189a, r101);
            r100.writeInt(this.f29190b);
            r100.writeInt(this.f29191c);
            r100.writeTypedList(this.f29192d);
            r100.writeFloat(this.f29193e);
            r100.writeFloat(this.f29194f);
            r100.writeFloat(this.f29195g);
            r100.writeFloat(this.f29196h);
            r100.writeFloat(this.f29197i);
            r100.writeString(this.f29198j);
        }

        public TruckRouteQuery(FromAndTo r100, int r101, List<LatLonPoint> r102, int r103) {
            this.f29198j = "base";
            this.f29189a = r100;
            this.f29191c = r101;
            this.f29192d = r102;
            this.f29190b = r103;
        }
    }

    public static class WalkRouteQuery implements Parcelable, Cloneable {
        public static final Parcelable.Creator<WalkRouteQuery> CREATOR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private FromAndTo f29199a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f29200b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f29201c;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        static {
            CREATOR = new AnonymousClass1();
        }

        public int hashCode() {
            FromAndTo r100 = this.f29199a;
            if (r100 != null) goto L5;
            int r101 = 0;
        L7:
            return ((r101 + 31) * 31) + this.f29200b;
        L5:
            r101 = r100.hashCode();
            goto L7
        }

        public WalkRouteQuery() {
            this.f29201c = "base";
        }

        public WalkRouteQuery clone() {
            super.clone();     // Catch: CloneNotSupportedException -> L4
        L6:
            WalkRouteQuery r100 = new WalkRouteQuery(this.f29199a);
            r100.setExtensions(this.f29201c);
            return r100;
        L4:
            e = move-exception;
            i.a(e, "RouteSearch", "WalkRouteQueryclone");
            goto L6
        }

        public String getExtensions() {
            return this.f29201c;
        }

        public FromAndTo getFromAndTo() {
            return this.f29199a;
        }

        public int getMode() {
            return this.f29200b;
        }

        /* JADX INFO: renamed from: clone, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m8046clone() throws CloneNotSupportedException {
            return clone();
        }

        public WalkRouteQuery(Parcel r100) {
            this.f29201c = "base";
            this.f29199a = (FromAndTo) r100.readParcelable(FromAndTo.class.getClassLoader());
            this.f29200b = r100.readInt();
            this.f29201c = r100.readString();
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 != null) goto L9;
            return false;
        L9:
            if (getClass() == r100.getClass()) goto L11;
            return false;
        L11:
            WalkRouteQuery r101 = (WalkRouteQuery) r100;
            FromAndTo r102 = this.f29199a;
            if (r102 != null) goto L17;
            if (r101.f29199a == null) goto L19;
            return false;
        L19:
            String r103 = this.f29201c;
            if (r103 != null) goto L25;
            if (r101.f29201c == null) goto L28;
            return false;
        L28:
            if (this.f29200b == r101.f29200b) goto L30;
            return false;
        L30:
            return true;
        L25:
            if (r103.equals(r101.f29201c) == true) goto L28;
            return false;
        L17:
            if (r102.equals(r101.f29199a) == true) goto L19;
            return false;
        }

        public void setExtensions(String r100) {
            this.f29201c = r100;
        }

        public WalkRouteQuery(FromAndTo r100) {
            this.f29201c = "base";
            this.f29199a = r100;
        }

        public WalkRouteQuery(FromAndTo r100, int r101) {
            this.f29201c = "base";
            this.f29199a = r100;
            this.f29200b = r101;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r100, int r101) {
            r100.writeParcelable(this.f29199a, r101);
            r100.writeInt(this.f29200b);
            r100.writeString(this.f29201c);
        }
    }

    public RouteSearch(Context r100) {
        if (this.f29155a != null) goto L11;
        this.f29155a = new be(r100);     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public BusRouteResult calculateBusRoute(BusRouteQuery r100) throws AMapException {
        IRouteSearch r101 = this.f29155a;
        if (r101 != null) goto L5;
        return null;
    L5:
        return r101.calculateBusRoute(r100);
    }

    public void calculateBusRouteAsyn(BusRouteQuery r100) {
        IRouteSearch r101 = this.f29155a;
        if (r101 == null) goto L6;
        r101.calculateBusRouteAsyn(r100);
        return;
    }

    public DriveRoutePlanResult calculateDrivePlan(DrivePlanQuery r100) throws AMapException {
        IRouteSearch r101 = this.f29155a;
        if (r101 != null) goto L5;
        return null;
    L5:
        return r101.calculateDrivePlan(r100);
    }

    public void calculateDrivePlanAsyn(DrivePlanQuery r100) {
        IRouteSearch r101 = this.f29155a;
        if (r101 == null) goto L6;
        r101.calculateDrivePlanAsyn(r100);
        return;
    }

    public DriveRouteResult calculateDriveRoute(DriveRouteQuery r100) throws AMapException {
        IRouteSearch r101 = this.f29155a;
        if (r101 != null) goto L5;
        return null;
    L5:
        return r101.calculateDriveRoute(r100);
    }

    public void calculateDriveRouteAsyn(DriveRouteQuery r100) {
        IRouteSearch r101 = this.f29155a;
        if (r101 == null) goto L6;
        r101.calculateDriveRouteAsyn(r100);
        return;
    }

    public RideRouteResult calculateRideRoute(RideRouteQuery r100) throws AMapException {
        IRouteSearch r101 = this.f29155a;
        if (r101 != null) goto L5;
        return null;
    L5:
        return r101.calculateRideRoute(r100);
    }

    public void calculateRideRouteAsyn(RideRouteQuery r100) {
        IRouteSearch r101 = this.f29155a;
        if (r101 == null) goto L6;
        r101.calculateRideRouteAsyn(r100);
        return;
    }

    public TruckRouteRestult calculateTruckRoute(TruckRouteQuery r100) throws AMapException {
        IRouteSearch r101 = this.f29155a;
        if (r101 != null) goto L5;
        return null;
    L5:
        return r101.calculateTruckRoute(r100);
    }

    public void calculateTruckRouteAsyn(TruckRouteQuery r100) {
        IRouteSearch r101 = this.f29155a;
        if (r101 == null) goto L6;
        r101.calculateTruckRouteAsyn(r100);
        return;
    }

    public WalkRouteResult calculateWalkRoute(WalkRouteQuery r100) throws AMapException {
        IRouteSearch r101 = this.f29155a;
        if (r101 != null) goto L5;
        return null;
    L5:
        return r101.calculateWalkRoute(r100);
    }

    public void calculateWalkRouteAsyn(WalkRouteQuery r100) {
        IRouteSearch r101 = this.f29155a;
        if (r101 == null) goto L6;
        r101.calculateWalkRouteAsyn(r100);
        return;
    }

    public void setOnRoutePlanSearchListener(OnRoutePlanSearchListener r100) {
        IRouteSearch r101 = this.f29155a;
        if (r101 == null) goto L6;
        r101.setOnRoutePlanSearchListener(r100);
        return;
    }

    public void setOnTruckRouteSearchListener(OnTruckRouteSearchListener r100) {
        IRouteSearch r101 = this.f29155a;
        if (r101 == null) goto L6;
        r101.setOnTruckRouteSearchListener(r100);
        return;
    }

    public void setRouteSearchListener(OnRouteSearchListener r100) {
        IRouteSearch r101 = this.f29155a;
        if (r101 == null) goto L6;
        r101.setRouteSearchListener(r100);
        return;
    }
}
