package com.amap.api.services.route;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.col.jmsl.C1617w;
import com.amap.api.col.jmsl.C1631z1;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.interfaces.IRouteSearchV2;
import com.amap.api.services.route.RouteSearch;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class RouteSearchV2 {

    /* renamed from: a, reason: collision with root package name */
    private IRouteSearchV2 f17855a;

    public class AlternativeRoute {
        public static final int ALTERNATIVE_ROUTE_ONE = 1;
        public static final int ALTERNATIVE_ROUTE_THREE = 3;
        public static final int ALTERNATIVE_ROUTE_TWO = 2;

        public AlternativeRoute(RouteSearchV2 routeSearchV2) {
        }
    }

    public static class BusMode {
        public static final int BUS_COMFORTABLE = 4;
        public static final int BUS_DEFAULT = 0;
        public static final int BUS_LEASE_CHANGE = 2;
        public static final int BUS_LEASE_WALK = 3;
        public static final int BUS_NO_SUBWAY = 5;
        public static final int BUS_SAVE_MONEY = 1;
        public static final int BUS_SUBWAY = 6;
        public static final int BUS_SUBWAY_FIRST = 7;
        public static final int BUS_WASTE_LESS = 8;
    }

    public static class BusRouteQuery implements Cloneable, Parcelable {
        public static final Parcelable.Creator<BusRouteQuery> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        private FromAndTo f17856a;

        /* renamed from: b, reason: collision with root package name */
        private int f17857b;

        /* renamed from: c, reason: collision with root package name */
        private String f17858c;

        /* renamed from: d, reason: collision with root package name */
        private String f17859d;

        /* renamed from: e, reason: collision with root package name */
        private String f17860e;

        /* renamed from: f, reason: collision with root package name */
        private String f17861f;

        /* renamed from: g, reason: collision with root package name */
        private int f17862g;

        /* renamed from: h, reason: collision with root package name */
        private String f17863h;

        /* renamed from: i, reason: collision with root package name */
        private String f17864i;

        /* renamed from: j, reason: collision with root package name */
        private String f17865j;

        /* renamed from: k, reason: collision with root package name */
        private String f17866k;

        /* renamed from: l, reason: collision with root package name */
        private int f17867l;

        /* renamed from: m, reason: collision with root package name */
        private int f17868m;

        /* renamed from: n, reason: collision with root package name */
        private int f17869n;

        /* renamed from: o, reason: collision with root package name */
        private int f17870o;

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
            this.f17867l = 5;
            this.f17868m = 0;
            this.f17869n = 4;
            this.f17870o = 1;
            this.f17856a = fromAndTo;
            this.f17857b = i10;
            this.f17858c = str;
            this.f17862g = i11;
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
            if (this.f17857b == busRouteQuery.f17857b && this.f17862g == busRouteQuery.f17862g && this.f17863h.equals(busRouteQuery.f17863h) && this.f17864i.equals(busRouteQuery.f17864i) && this.f17867l == busRouteQuery.f17867l && this.f17868m == busRouteQuery.f17868m && this.f17869n == busRouteQuery.f17869n && this.f17870o == busRouteQuery.f17870o && this.f17856a.equals(busRouteQuery.f17856a) && this.f17858c.equals(busRouteQuery.f17858c) && this.f17859d.equals(busRouteQuery.f17859d) && this.f17860e.equals(busRouteQuery.f17860e) && this.f17861f.equals(busRouteQuery.f17861f) && this.f17865j.equals(busRouteQuery.f17865j)) {
                return this.f17866k.equals(busRouteQuery.f17866k);
            }
            return false;
        }

        public String getAd1() {
            return this.f17865j;
        }

        public String getAd2() {
            return this.f17866k;
        }

        public int getAlternativeRoute() {
            return this.f17867l;
        }

        public String getCity() {
            return this.f17858c;
        }

        public String getCityd() {
            return this.f17859d;
        }

        public String getDate() {
            return this.f17860e;
        }

        public String getDestinationPoiId() {
            return this.f17864i;
        }

        public FromAndTo getFromAndTo() {
            return this.f17856a;
        }

        public int getMaxTrans() {
            return this.f17869n;
        }

        public int getMode() {
            return this.f17857b;
        }

        public int getMultiExport() {
            return this.f17868m;
        }

        public int getNightFlag() {
            return this.f17862g;
        }

        public String getOriginPoiId() {
            return this.f17863h;
        }

        public int getShowFields() {
            return this.f17870o;
        }

        public String getTime() {
            return this.f17861f;
        }

        public int hashCode() {
            return (((((((((((((((((((((((((((this.f17856a.hashCode() * 31) + this.f17857b) * 31) + this.f17858c.hashCode()) * 31) + this.f17859d.hashCode()) * 31) + this.f17860e.hashCode()) * 31) + this.f17861f.hashCode()) * 31) + this.f17862g) * 31) + this.f17863h.hashCode()) * 31) + this.f17864i.hashCode()) * 31) + this.f17865j.hashCode()) * 31) + this.f17866k.hashCode()) * 31) + this.f17867l) * 31) + this.f17868m) * 31) + this.f17869n) * 31) + this.f17870o;
        }

        public void setAd1(String str) {
            this.f17865j = str;
        }

        public void setAd2(String str) {
            this.f17866k = str;
        }

        public void setAlternativeRoute(int i10) {
            this.f17867l = i10;
        }

        public void setCityd(String str) {
            this.f17859d = str;
        }

        public void setDate(String str) {
            this.f17860e = str;
        }

        public void setDestinationPoiId(String str) {
            this.f17864i = str;
        }

        public void setMaxTrans(int i10) {
            this.f17869n = i10;
        }

        public void setMultiExport(int i10) {
            this.f17868m = i10;
        }

        public void setOriginPoiId(String str) {
            this.f17863h = str;
        }

        public void setShowFields(int i10) {
            this.f17870o = i10;
        }

        public void setTime(String str) {
            this.f17861f = str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeParcelable(this.f17856a, i10);
            parcel.writeInt(this.f17857b);
            parcel.writeString(this.f17858c);
            parcel.writeInt(this.f17862g);
            parcel.writeString(this.f17859d);
            parcel.writeInt(this.f17870o);
            parcel.writeString(this.f17863h);
            parcel.writeString(this.f17864i);
            parcel.writeString(this.f17865j);
            parcel.writeString(this.f17866k);
            parcel.writeInt(this.f17867l);
            parcel.writeInt(this.f17869n);
            parcel.writeInt(this.f17868m);
            parcel.writeString(this.f17860e);
            parcel.writeString(this.f17861f);
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public BusRouteQuery m36clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e10) {
                C1631z1.o(e10, "RouteSearchV2", "BusRouteQueryclone");
            }
            BusRouteQuery busRouteQuery = new BusRouteQuery(this.f17856a, this.f17857b, this.f17858c, this.f17862g);
            busRouteQuery.setCityd(this.f17859d);
            busRouteQuery.setShowFields(this.f17870o);
            busRouteQuery.setDate(this.f17860e);
            busRouteQuery.setTime(this.f17861f);
            busRouteQuery.setAd1(this.f17865j);
            busRouteQuery.setAd2(this.f17866k);
            busRouteQuery.setOriginPoiId(this.f17863h);
            busRouteQuery.setDestinationPoiId(this.f17864i);
            busRouteQuery.setMaxTrans(this.f17869n);
            busRouteQuery.setMultiExport(this.f17868m);
            busRouteQuery.setAlternativeRoute(this.f17867l);
            return busRouteQuery;
        }

        public BusRouteQuery(Parcel parcel) {
            this.f17857b = 0;
            this.f17862g = 0;
            this.f17867l = 5;
            this.f17868m = 0;
            this.f17869n = 4;
            this.f17870o = 1;
            this.f17856a = (FromAndTo) parcel.readParcelable(FromAndTo.class.getClassLoader());
            this.f17857b = parcel.readInt();
            this.f17858c = parcel.readString();
            this.f17862g = parcel.readInt();
            this.f17859d = parcel.readString();
            this.f17870o = parcel.readInt();
            this.f17863h = parcel.readString();
            this.f17864i = parcel.readString();
            this.f17860e = parcel.readString();
            this.f17861f = parcel.readString();
            this.f17869n = parcel.readInt();
            this.f17868m = parcel.readInt();
            this.f17867l = parcel.readInt();
            this.f17865j = parcel.readString();
            this.f17866k = parcel.readString();
        }

        public BusRouteQuery() {
            this.f17857b = 0;
            this.f17862g = 0;
            this.f17867l = 5;
            this.f17868m = 0;
            this.f17869n = 4;
            this.f17870o = 1;
        }
    }

    public static class CurveCost {

        /* renamed from: a, reason: collision with root package name */
        private float f17871a;

        /* renamed from: b, reason: collision with root package name */
        private float f17872b;

        public float getAccess() {
            return this.f17871a;
        }

        public float getValue() {
            return this.f17872b;
        }

        public void setAccess(float f10) {
            this.f17871a = f10;
        }

        public void setValue(float f10) {
            this.f17872b = f10;
        }
    }

    public static class CustomCostMode {

        /* renamed from: a, reason: collision with root package name */
        private List<SpeedCost> f17873a;

        /* renamed from: b, reason: collision with root package name */
        private CurveCost f17874b;

        /* renamed from: c, reason: collision with root package name */
        private SlopeCost f17875c;

        /* renamed from: d, reason: collision with root package name */
        private float f17876d;

        /* renamed from: e, reason: collision with root package name */
        private TransCost f17877e;

        /* renamed from: f, reason: collision with root package name */
        private float f17878f;

        /* renamed from: g, reason: collision with root package name */
        private PowerTrainLoss f17879g;

        public float getAuxCost() {
            return this.f17876d;
        }

        public CurveCost getCurveCost() {
            return this.f17874b;
        }

        public float getFerryCost() {
            return this.f17878f;
        }

        public PowerTrainLoss getPowerTrainLosses() {
            return this.f17879g;
        }

        public SlopeCost getSlopeCost() {
            return this.f17875c;
        }

        public List<SpeedCost> getSpeedCosts() {
            return this.f17873a;
        }

        public TransCost getTransCost() {
            return this.f17877e;
        }

        public void setAuxCost(float f10) {
            this.f17876d = f10;
        }

        public void setCurveCost(CurveCost curveCost) {
            this.f17874b = curveCost;
        }

        public void setFerryCost(float f10) {
            this.f17878f = f10;
        }

        public void setPowerTrainLosses(PowerTrainLoss powerTrainLoss) {
            this.f17879g = powerTrainLoss;
        }

        public void setSlopeCost(SlopeCost slopeCost) {
            this.f17875c = slopeCost;
        }

        public void setSpeedCosts(List<SpeedCost> list) {
            this.f17873a = list;
        }

        public void setTransCost(TransCost transCost) {
            this.f17877e = transCost;
        }

        public String toJson() throws JSONException {
            try {
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                List<SpeedCost> list = this.f17873a;
                if (list != null) {
                    for (SpeedCost speedCost : list) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put(Const.JSON_KEY_SPEED, speedCost.getSpeed());
                        jSONObject2.put(UxipConstants.f30680s, speedCost.getValue());
                        jSONArray.put(jSONObject2);
                    }
                    jSONObject.put("speed_cost", jSONArray);
                }
                if (this.f17874b != null) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("access", this.f17874b.getAccess());
                    jSONObject3.put(UxipConstants.f30680s, this.f17874b.getValue());
                    jSONObject.put("curve_cost", jSONObject3);
                }
                if (this.f17875c != null) {
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put("up", this.f17875c.getUp());
                    jSONObject4.put("down", this.f17875c.getDown());
                    jSONObject.put("slope_cost", jSONObject4);
                }
                jSONObject.put("aux_cost", this.f17876d);
                if (this.f17877e != null) {
                    JSONObject jSONObject5 = new JSONObject();
                    jSONObject5.put("access", this.f17877e.getAccess());
                    jSONObject5.put("decess", this.f17877e.getDecess());
                    jSONObject.put("trans_cost", jSONObject5);
                }
                jSONObject.put("ferry_cost", this.f17878f);
                if (this.f17879g != null) {
                    JSONArray jSONArray2 = new JSONArray();
                    JSONObject jSONObject6 = new JSONObject();
                    jSONObject6.put("powerdemand", this.f17879g.getPowerDemand());
                    jSONObject6.put(UxipConstants.f30680s, this.f17879g.getPowerDemandValue());
                    JSONObject jSONObject7 = new JSONObject();
                    jSONObject7.put(Const.JSON_KEY_SPEED, this.f17879g.getSpeed());
                    jSONObject7.put(UxipConstants.f30680s, this.f17879g.getSpeedValue());
                    jSONArray2.put(jSONObject6);
                    jSONArray2.put(jSONObject7);
                    jSONObject.put("powertrain_loss", jSONArray2);
                }
                return jSONObject.toString();
            } catch (JSONException e10) {
                e10.printStackTrace();
                return null;
            }
        }
    }

    public static class DriveRouteQuery implements Parcelable, Cloneable {
        public static final Parcelable.Creator<DriveRouteQuery> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        private FromAndTo f17880a;

        /* renamed from: b, reason: collision with root package name */
        private NewEnergy f17881b;

        /* renamed from: c, reason: collision with root package name */
        private int f17882c;

        /* renamed from: d, reason: collision with root package name */
        private List<LatLonPoint> f17883d;

        /* renamed from: e, reason: collision with root package name */
        private List<List<LatLonPoint>> f17884e;

        /* renamed from: f, reason: collision with root package name */
        private String f17885f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f17886g;

        /* renamed from: h, reason: collision with root package name */
        private int f17887h;

        /* renamed from: i, reason: collision with root package name */
        private String f17888i;

        /* renamed from: j, reason: collision with root package name */
        private int f17889j;

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

        public DriveRouteQuery(FromAndTo fromAndTo, DrivingStrategy drivingStrategy, List<LatLonPoint> list, List<List<LatLonPoint>> list2, String str) {
            this.f17882c = DrivingStrategy.DEFAULT.getValue();
            this.f17886g = true;
            this.f17887h = 0;
            this.f17888i = null;
            this.f17889j = 1;
            this.f17880a = fromAndTo;
            this.f17882c = drivingStrategy.getValue();
            this.f17883d = list;
            this.f17884e = list2;
            this.f17885f = str;
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
            String str = this.f17885f;
            if (str == null) {
                if (driveRouteQuery.f17885f != null) {
                    return false;
                }
            } else if (!str.equals(driveRouteQuery.f17885f)) {
                return false;
            }
            List<List<LatLonPoint>> list = this.f17884e;
            if (list == null) {
                if (driveRouteQuery.f17884e != null) {
                    return false;
                }
            } else if (!list.equals(driveRouteQuery.f17884e)) {
                return false;
            }
            FromAndTo fromAndTo = this.f17880a;
            if (fromAndTo == null) {
                if (driveRouteQuery.f17880a != null) {
                    return false;
                }
            } else if (!fromAndTo.equals(driveRouteQuery.f17880a)) {
                return false;
            }
            if (this.f17882c != driveRouteQuery.f17882c) {
                return false;
            }
            List<LatLonPoint> list2 = this.f17883d;
            if (list2 == null) {
                if (driveRouteQuery.f17883d != null) {
                    return false;
                }
            } else if (!list2.equals(driveRouteQuery.f17883d) || this.f17886g != driveRouteQuery.isUseFerry() || this.f17887h != driveRouteQuery.f17887h || this.f17889j != driveRouteQuery.f17889j) {
                return false;
            }
            return true;
        }

        public String getAvoidRoad() {
            return this.f17885f;
        }

        public List<List<LatLonPoint>> getAvoidpolygons() {
            return this.f17884e;
        }

        public String getAvoidpolygonsStr() {
            StringBuffer stringBuffer = new StringBuffer();
            List<List<LatLonPoint>> list = this.f17884e;
            if (list == null || list.size() == 0) {
                return null;
            }
            for (int i10 = 0; i10 < this.f17884e.size(); i10++) {
                List<LatLonPoint> list2 = this.f17884e.get(i10);
                for (int i11 = 0; i11 < list2.size(); i11++) {
                    LatLonPoint latLonPoint = list2.get(i11);
                    stringBuffer.append(latLonPoint.getLongitude());
                    stringBuffer.append(Const.STR_MART_COMMA);
                    stringBuffer.append(latLonPoint.getLatitude());
                    if (i11 < list2.size() - 1) {
                        stringBuffer.append(Const.STR_MART_SEMICOLON);
                    }
                }
                if (i10 < this.f17884e.size() - 1) {
                    stringBuffer.append("|");
                }
            }
            return stringBuffer.toString();
        }

        public int getCarType() {
            return this.f17887h;
        }

        public String getExclude() {
            return this.f17888i;
        }

        public FromAndTo getFromAndTo() {
            return this.f17880a;
        }

        public DrivingStrategy getMode() {
            return DrivingStrategy.fromValue(this.f17882c);
        }

        public NewEnergy getNewEnergy() {
            return this.f17881b;
        }

        public List<LatLonPoint> getPassedByPoints() {
            return this.f17883d;
        }

        public String getPassedPointStr() {
            StringBuffer stringBuffer = new StringBuffer();
            List<LatLonPoint> list = this.f17883d;
            if (list == null || list.size() == 0) {
                return null;
            }
            for (int i10 = 0; i10 < this.f17883d.size(); i10++) {
                LatLonPoint latLonPoint = this.f17883d.get(i10);
                stringBuffer.append(latLonPoint.getLongitude());
                stringBuffer.append(Const.STR_MART_COMMA);
                stringBuffer.append(latLonPoint.getLatitude());
                if (i10 < this.f17883d.size() - 1) {
                    stringBuffer.append(Const.STR_MART_SEMICOLON);
                }
            }
            return stringBuffer.toString();
        }

        public int getShowFields() {
            return this.f17889j;
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
            String str = this.f17885f;
            int iHashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
            List<List<LatLonPoint>> list = this.f17884e;
            int iHashCode2 = (iHashCode + (list == null ? 0 : list.hashCode())) * 31;
            FromAndTo fromAndTo = this.f17880a;
            int iHashCode3 = (((iHashCode2 + (fromAndTo == null ? 0 : fromAndTo.hashCode())) * 31) + this.f17882c) * 31;
            List<LatLonPoint> list2 = this.f17883d;
            return ((iHashCode3 + (list2 != null ? list2.hashCode() : 0)) * 31) + this.f17887h;
        }

        public boolean isUseFerry() {
            return this.f17886g;
        }

        public void setCarType(int i10) {
            this.f17887h = i10;
        }

        public void setExclude(String str) {
            this.f17888i = str;
        }

        public void setNewEnergy(NewEnergy newEnergy) {
            this.f17881b = newEnergy;
        }

        public void setShowFields(int i10) {
            this.f17889j = i10;
        }

        public void setUseFerry(boolean z10) {
            this.f17886g = z10;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeParcelable(this.f17880a, i10);
            parcel.writeInt(this.f17882c);
            parcel.writeTypedList(this.f17883d);
            List<List<LatLonPoint>> list = this.f17884e;
            if (list == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(list.size());
                Iterator<List<LatLonPoint>> it = this.f17884e.iterator();
                while (it.hasNext()) {
                    parcel.writeTypedList(it.next());
                }
            }
            parcel.writeString(this.f17885f);
            parcel.writeInt(this.f17886g ? 1 : 0);
            parcel.writeInt(this.f17887h);
            parcel.writeString(this.f17888i);
            parcel.writeInt(this.f17889j);
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public DriveRouteQuery m37clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e10) {
                C1631z1.o(e10, "RouteSearchV2", "DriveRouteQueryclone");
            }
            DriveRouteQuery driveRouteQuery = new DriveRouteQuery(this.f17880a, DrivingStrategy.fromValue(this.f17882c), this.f17883d, this.f17884e, this.f17885f);
            driveRouteQuery.setUseFerry(this.f17886g);
            driveRouteQuery.setCarType(this.f17887h);
            driveRouteQuery.setExclude(this.f17888i);
            driveRouteQuery.setShowFields(this.f17889j);
            driveRouteQuery.setNewEnergy(this.f17881b);
            return driveRouteQuery;
        }

        public DriveRouteQuery(Parcel parcel) {
            this.f17882c = DrivingStrategy.DEFAULT.getValue();
            this.f17886g = true;
            this.f17887h = 0;
            this.f17888i = null;
            this.f17889j = 1;
            this.f17880a = (FromAndTo) parcel.readParcelable(FromAndTo.class.getClassLoader());
            this.f17882c = parcel.readInt();
            this.f17883d = parcel.createTypedArrayList(LatLonPoint.CREATOR);
            int i10 = parcel.readInt();
            if (i10 == 0) {
                this.f17884e = null;
            } else {
                this.f17884e = new ArrayList();
            }
            for (int i11 = 0; i11 < i10; i11++) {
                this.f17884e.add(parcel.createTypedArrayList(LatLonPoint.CREATOR));
            }
            this.f17885f = parcel.readString();
            this.f17886g = parcel.readInt() == 1;
            this.f17887h = parcel.readInt();
            this.f17888i = parcel.readString();
            this.f17889j = parcel.readInt();
        }

        public DriveRouteQuery() {
            this.f17882c = DrivingStrategy.DEFAULT.getValue();
            this.f17886g = true;
            this.f17887h = 0;
            this.f17888i = null;
            this.f17889j = 1;
        }
    }

    public enum DrivingStrategy {
        DEFAULT(32),
        AVOID_CONGESTION(33),
        HIGHWAY_PRIORITY(34),
        AVOID_HIGHWAY(35),
        LESS_CHARGE(36),
        ROAD_PRIORITY(37),
        SPEED_PRIORITY(38),
        AVOID_CONGESTION_HIGHWAY_PRIORITY(39),
        AVOID_CONGESTION_AVOID_HIGHWAY(40),
        AVOID_CONGESTION_LESS_CHARGE(41),
        LESS_CHARGE_AVOID_HIGHWAY(42),
        AVOID_CONGESTION_LESS_CHARGE_AVOID_HIGHWAY(43),
        AVOID_CONGESTION_ROAD_PRIORITY(44),
        AVOID_CONGESTION_SPEED_PRIORITY(45);


        /* renamed from: a, reason: collision with root package name */
        int f17891a;

        DrivingStrategy(int i10) {
            this.f17891a = i10;
        }

        public static DrivingStrategy fromValue(int i10) {
            return values()[i10 - 32];
        }

        public int getValue() {
            return this.f17891a;
        }
    }

    public static class FromAndTo implements Cloneable, Parcelable {
        public static final Parcelable.Creator<FromAndTo> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        private LatLonPoint f17892a;

        /* renamed from: b, reason: collision with root package name */
        private LatLonPoint f17893b;

        /* renamed from: c, reason: collision with root package name */
        private String f17894c;

        /* renamed from: d, reason: collision with root package name */
        private String f17895d;

        /* renamed from: e, reason: collision with root package name */
        private String f17896e;

        /* renamed from: f, reason: collision with root package name */
        private String f17897f;

        /* renamed from: g, reason: collision with root package name */
        private String f17898g;

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
            this.f17892a = latLonPoint;
            this.f17893b = latLonPoint2;
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
            String str = this.f17895d;
            if (str == null) {
                if (fromAndTo.f17895d != null) {
                    return false;
                }
            } else if (!str.equals(fromAndTo.f17895d)) {
                return false;
            }
            LatLonPoint latLonPoint = this.f17892a;
            if (latLonPoint == null) {
                if (fromAndTo.f17892a != null) {
                    return false;
                }
            } else if (!latLonPoint.equals(fromAndTo.f17892a)) {
                return false;
            }
            String str2 = this.f17894c;
            if (str2 == null) {
                if (fromAndTo.f17894c != null) {
                    return false;
                }
            } else if (!str2.equals(fromAndTo.f17894c)) {
                return false;
            }
            LatLonPoint latLonPoint2 = this.f17893b;
            if (latLonPoint2 == null) {
                if (fromAndTo.f17893b != null) {
                    return false;
                }
            } else if (!latLonPoint2.equals(fromAndTo.f17893b)) {
                return false;
            }
            String str3 = this.f17896e;
            if (str3 == null) {
                if (fromAndTo.f17896e != null) {
                    return false;
                }
            } else if (!str3.equals(fromAndTo.f17896e)) {
                return false;
            }
            String str4 = this.f17897f;
            if (str4 == null) {
                if (fromAndTo.f17897f != null) {
                    return false;
                }
            } else if (!str4.equals(fromAndTo.f17897f)) {
                return false;
            }
            return true;
        }

        public String getDestinationPoiID() {
            return this.f17895d;
        }

        public String getDestinationType() {
            return this.f17897f;
        }

        public LatLonPoint getFrom() {
            return this.f17892a;
        }

        public String getOriginType() {
            return this.f17896e;
        }

        public String getPlateNumber() {
            return this.f17898g;
        }

        public String getStartPoiID() {
            return this.f17894c;
        }

        public LatLonPoint getTo() {
            return this.f17893b;
        }

        public int hashCode() {
            String str = this.f17895d;
            int iHashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
            LatLonPoint latLonPoint = this.f17892a;
            int iHashCode2 = (iHashCode + (latLonPoint == null ? 0 : latLonPoint.hashCode())) * 31;
            String str2 = this.f17894c;
            int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            LatLonPoint latLonPoint2 = this.f17893b;
            int iHashCode4 = (iHashCode3 + (latLonPoint2 == null ? 0 : latLonPoint2.hashCode())) * 31;
            String str3 = this.f17896e;
            int iHashCode5 = (iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.f17897f;
            return iHashCode5 + (str4 != null ? str4.hashCode() : 0);
        }

        public void setDestinationPoiID(String str) {
            this.f17895d = str;
        }

        public void setDestinationType(String str) {
            this.f17897f = str;
        }

        public void setOriginType(String str) {
            this.f17896e = str;
        }

        public void setPlateNumber(String str) {
            this.f17898g = str;
        }

        public void setStartPoiID(String str) {
            this.f17894c = str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeParcelable(this.f17892a, i10);
            parcel.writeParcelable(this.f17893b, i10);
            parcel.writeString(this.f17894c);
            parcel.writeString(this.f17895d);
            parcel.writeString(this.f17896e);
            parcel.writeString(this.f17897f);
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public FromAndTo m38clone() throws CloneNotSupportedException {
            try {
                super.clone();
            } catch (CloneNotSupportedException e10) {
                C1631z1.o(e10, "RouteSearchV2", "FromAndToclone");
            }
            FromAndTo fromAndTo = new FromAndTo(this.f17892a, this.f17893b);
            fromAndTo.setStartPoiID(this.f17894c);
            fromAndTo.setDestinationPoiID(this.f17895d);
            fromAndTo.setOriginType(this.f17896e);
            fromAndTo.setDestinationType(this.f17897f);
            return fromAndTo;
        }

        public FromAndTo(Parcel parcel) {
            this.f17892a = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
            this.f17893b = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
            this.f17894c = parcel.readString();
            this.f17895d = parcel.readString();
            this.f17896e = parcel.readString();
            this.f17897f = parcel.readString();
        }

        public FromAndTo() {
        }
    }

    public static class NewEnergy {

        /* renamed from: a, reason: collision with root package name */
        private String f17899a;

        /* renamed from: b, reason: collision with root package name */
        private CustomCostMode f17900b;

        /* renamed from: i, reason: collision with root package name */
        private String f17907i;

        /* renamed from: c, reason: collision with root package name */
        private float f17901c = -1.0f;

        /* renamed from: d, reason: collision with root package name */
        private float f17902d = -1.0f;

        /* renamed from: e, reason: collision with root package name */
        private float f17903e = 1.5f;

        /* renamed from: f, reason: collision with root package name */
        private float f17904f = 100.0f;

        /* renamed from: g, reason: collision with root package name */
        private float f17905g = 0.0f;

        /* renamed from: h, reason: collision with root package name */
        private float f17906h = 0.0f;

        /* renamed from: j, reason: collision with root package name */
        private int f17908j = 0;

        public String buildParam() {
            StringBuilder sb2 = new StringBuilder();
            if (this.f17899a != null) {
                sb2.append("&key=");
                sb2.append(this.f17899a);
            }
            if (this.f17900b != null) {
                sb2.append("&custom_cost_mode=");
                sb2.append(this.f17900b.toJson());
            }
            if (this.f17901c > 0.0f) {
                sb2.append("&max_vehicle_charge=");
                sb2.append(this.f17901c);
            }
            if (this.f17902d > 0.0f) {
                sb2.append("&vehicle_charge=");
                sb2.append(this.f17902d);
            }
            sb2.append("&load=");
            sb2.append(this.f17903e);
            sb2.append("&leaving_percent=");
            sb2.append(this.f17904f);
            sb2.append("&arriving_percent=");
            sb2.append(this.f17905g);
            sb2.append("&destination_arriving_percent=");
            sb2.append(this.f17906h);
            if (this.f17907i != null) {
                sb2.append("&custom_charging_arguments=");
                sb2.append(this.f17907i);
            }
            if (this.f17908j > 0) {
                sb2.append("&waypoints_arriving_percent=");
                sb2.append(this.f17908j);
            }
            return sb2.toString();
        }

        public float getArrivingPercent() {
            return this.f17905g;
        }

        public String getCustomChargingArguments() {
            return this.f17907i;
        }

        public CustomCostMode getCustomCostMode() {
            return this.f17900b;
        }

        public float getDestinationArrivingPercent() {
            return this.f17906h;
        }

        public String getKey() {
            return this.f17899a;
        }

        public float getLeavingPercent() {
            return this.f17904f;
        }

        public float getLoad() {
            return this.f17903e;
        }

        public float getMaxVehicleCharge() {
            return this.f17901c;
        }

        public float getVehicleCharge() {
            return this.f17902d;
        }

        public int getWaypointsArrivingPercent() {
            return this.f17908j;
        }

        public void setArrivingPercent(float f10) {
            this.f17905g = f10;
        }

        public void setCustomChargingArguments(String str) {
            this.f17907i = str;
        }

        public void setCustomCostMode(CustomCostMode customCostMode) {
            this.f17900b = customCostMode;
        }

        public void setDestinationArrivingPercent(float f10) {
            this.f17906h = f10;
        }

        public void setKey(String str) {
            this.f17899a = str;
        }

        public void setLeavingPercent(float f10) {
            this.f17904f = f10;
        }

        public void setLoad(float f10) {
            this.f17903e = f10;
        }

        public void setMaxVehicleCharge(float f10) {
            this.f17901c = f10;
        }

        public void setVehicleCharge(float f10) {
            this.f17902d = f10;
        }

        public void setWaypointsArrivingPercent(int i10) {
            this.f17908j = i10;
        }
    }

    public interface OnRoutePlanSearchListener {
        void onDriveRoutePlanSearched(DriveRoutePlanResult driveRoutePlanResult, int i10);
    }

    public interface OnRouteSearchListener {
        void onBusRouteSearched(BusRouteResultV2 busRouteResultV2, int i10);

        void onDriveRouteSearched(DriveRouteResultV2 driveRouteResultV2, int i10);

        void onRideRouteSearched(RideRouteResultV2 rideRouteResultV2, int i10);

        void onWalkRouteSearched(WalkRouteResultV2 walkRouteResultV2, int i10);
    }

    public interface OnTruckRouteSearchListener {
        void onTruckRouteSearched(TruckRouteRestult truckRouteRestult, int i10);
    }

    public static class PowerTrainLoss {

        /* renamed from: a, reason: collision with root package name */
        private int f17909a;

        /* renamed from: b, reason: collision with root package name */
        private float f17910b;

        /* renamed from: c, reason: collision with root package name */
        private int f17911c;

        /* renamed from: d, reason: collision with root package name */
        private int f17912d;

        public int getPowerDemand() {
            return this.f17909a;
        }

        public float getPowerDemandValue() {
            return this.f17910b;
        }

        public int getSpeed() {
            return this.f17911c;
        }

        public int getSpeedValue() {
            return this.f17912d;
        }

        public void setPowerDemand(int i10) {
            this.f17909a = i10;
        }

        public void setPowerDemandValue(float f10) {
            this.f17910b = f10;
        }

        public void setSpeed(int i10) {
            this.f17911c = i10;
        }

        public void setSpeedValue(int i10) {
            this.f17912d = i10;
        }
    }

    public static class RideRouteQuery implements Parcelable, Cloneable {
        public static final Parcelable.Creator<RideRouteQuery> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        private FromAndTo f17913a;

        /* renamed from: b, reason: collision with root package name */
        private int f17914b;

        /* renamed from: c, reason: collision with root package name */
        private int f17915c;

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

        public RideRouteQuery(FromAndTo fromAndTo) {
            this.f17914b = 1;
            this.f17915c = 1;
            this.f17913a = fromAndTo;
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
            FromAndTo fromAndTo = this.f17913a;
            if (fromAndTo == null) {
                if (rideRouteQuery.f17913a != null) {
                    return false;
                }
            } else if (!fromAndTo.equals(rideRouteQuery.f17913a)) {
                return false;
            }
            return this.f17914b == rideRouteQuery.f17914b && this.f17915c == rideRouteQuery.f17915c;
        }

        public int getAlternativeRoute() {
            return this.f17915c;
        }

        public FromAndTo getFromAndTo() {
            return this.f17913a;
        }

        public int getShowFields() {
            return this.f17914b;
        }

        public int hashCode() {
            FromAndTo fromAndTo = this.f17913a;
            return (((((fromAndTo == null ? 0 : fromAndTo.hashCode()) + 31) * 31) + this.f17914b) * 31) + this.f17915c;
        }

        public void setAlternativeRoute(int i10) {
            this.f17915c = i10;
        }

        public void setShowFields(int i10) {
            this.f17914b = i10;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeParcelable(this.f17913a, i10);
            parcel.writeInt(this.f17915c);
            parcel.writeInt(this.f17914b);
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public RideRouteQuery m39clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e10) {
                C1631z1.o(e10, "RouteSearchV2", "RideRouteQueryclone");
            }
            RideRouteQuery rideRouteQuery = new RideRouteQuery(this.f17913a);
            rideRouteQuery.setShowFields(this.f17914b);
            rideRouteQuery.setAlternativeRoute(this.f17915c);
            return rideRouteQuery;
        }

        public RideRouteQuery(Parcel parcel) {
            this.f17914b = 1;
            this.f17915c = 1;
            this.f17913a = (FromAndTo) parcel.readParcelable(RouteSearch.FromAndTo.class.getClassLoader());
            this.f17915c = parcel.readInt();
            this.f17914b = parcel.readInt();
        }

        public RideRouteQuery() {
            this.f17914b = 1;
            this.f17915c = 1;
        }
    }

    public static class ShowFields {
        public static final int ALL = -1;
        public static final int CHARGE_STATION_INFO = 64;
        public static final int CITIES = 8;
        public static final int COST = 1;
        public static final int ELEC_COSUME_INFO = 32;
        public static final int NAVI = 4;
        public static final int POLINE = 16;
        public static final int TMCS = 2;
    }

    public static class SlopeCost {

        /* renamed from: a, reason: collision with root package name */
        private float f17916a;

        /* renamed from: b, reason: collision with root package name */
        private float f17917b;

        public float getDown() {
            return this.f17917b;
        }

        public float getUp() {
            return this.f17916a;
        }

        public void setDown(float f10) {
            this.f17917b = f10;
        }

        public void setUp(float f10) {
            this.f17916a = f10;
        }
    }

    public static class SpeedCost {

        /* renamed from: a, reason: collision with root package name */
        private int f17918a;

        /* renamed from: b, reason: collision with root package name */
        private float f17919b;

        public int getSpeed() {
            return this.f17918a;
        }

        public float getValue() {
            return this.f17919b;
        }

        public void setSpeed(int i10) {
            this.f17918a = i10;
        }

        public void setValue(float f10) {
            this.f17919b = f10;
        }
    }

    public static class TransCost {

        /* renamed from: a, reason: collision with root package name */
        private float f17920a;

        /* renamed from: b, reason: collision with root package name */
        private float f17921b;

        public float getAccess() {
            return this.f17920a;
        }

        public float getDecess() {
            return this.f17921b;
        }

        public void setAccess(float f10) {
            this.f17920a = f10;
        }

        public void setDecess(float f10) {
            this.f17921b = f10;
        }
    }

    public static class WalkRouteQuery implements Parcelable, Cloneable {
        public static final Parcelable.Creator<WalkRouteQuery> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        private FromAndTo f17922a;

        /* renamed from: b, reason: collision with root package name */
        private int f17923b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f17924c;

        /* renamed from: d, reason: collision with root package name */
        private int f17925d;

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

        public WalkRouteQuery(FromAndTo fromAndTo) {
            this.f17923b = 1;
            this.f17924c = false;
            this.f17925d = 1;
            this.f17922a = fromAndTo;
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
            if (this.f17923b == walkRouteQuery.f17923b && this.f17924c == walkRouteQuery.f17924c && this.f17925d == walkRouteQuery.f17925d) {
                return this.f17922a.equals(walkRouteQuery.f17922a);
            }
            return false;
        }

        public int getAlternativeRoute() {
            return this.f17925d;
        }

        public FromAndTo getFromAndTo() {
            return this.f17922a;
        }

        public int getShowFields() {
            return this.f17923b;
        }

        public int hashCode() {
            return (((((this.f17922a.hashCode() * 31) + this.f17923b) * 31) + (this.f17924c ? 1 : 0)) * 31) + this.f17925d;
        }

        public boolean isIndoor() {
            return this.f17924c;
        }

        public void setAlternativeRoute(int i10) {
            this.f17925d = i10;
        }

        public void setIndoor(boolean z10) {
            this.f17924c = z10;
        }

        public void setShowFields(int i10) {
            this.f17923b = i10;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeParcelable(this.f17922a, i10);
            parcel.writeBooleanArray(new boolean[]{this.f17924c});
            parcel.writeInt(this.f17925d);
            parcel.writeInt(this.f17923b);
        }

        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public WalkRouteQuery m40clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e10) {
                C1631z1.o(e10, "RouteSearchV2", "WalkRouteQueryclone");
            }
            WalkRouteQuery walkRouteQuery = new WalkRouteQuery(this.f17922a);
            walkRouteQuery.setShowFields(this.f17923b);
            walkRouteQuery.setIndoor(this.f17924c);
            walkRouteQuery.setAlternativeRoute(this.f17925d);
            return walkRouteQuery;
        }

        public WalkRouteQuery(Parcel parcel) {
            this.f17923b = 1;
            this.f17924c = false;
            this.f17925d = 1;
            this.f17922a = (FromAndTo) parcel.readParcelable(FromAndTo.class.getClassLoader());
            boolean[] zArr = new boolean[1];
            parcel.readBooleanArray(zArr);
            this.f17924c = zArr[0];
            this.f17925d = parcel.readInt();
            this.f17923b = parcel.readInt();
        }

        public WalkRouteQuery() {
            this.f17923b = 1;
            this.f17924c = false;
            this.f17925d = 1;
        }
    }

    public RouteSearchV2(Context context) throws AMapException {
        if (this.f17855a == null) {
            try {
                this.f17855a = new C1617w(context);
            } catch (Exception e10) {
                e10.printStackTrace();
                if (e10 instanceof AMapException) {
                    throw ((AMapException) e10);
                }
            }
        }
    }

    public BusRouteResultV2 calculateBusRoute(BusRouteQuery busRouteQuery) throws AMapException {
        IRouteSearchV2 iRouteSearchV2 = this.f17855a;
        if (iRouteSearchV2 != null) {
            return iRouteSearchV2.calculateBusRoute(busRouteQuery);
        }
        return null;
    }

    public void calculateBusRouteAsyn(BusRouteQuery busRouteQuery) {
        IRouteSearchV2 iRouteSearchV2 = this.f17855a;
        if (iRouteSearchV2 != null) {
            iRouteSearchV2.calculateBusRouteAsyn(busRouteQuery);
        }
    }

    public DriveRouteResultV2 calculateDriveRoute(DriveRouteQuery driveRouteQuery) throws AMapException {
        IRouteSearchV2 iRouteSearchV2 = this.f17855a;
        if (iRouteSearchV2 != null) {
            return iRouteSearchV2.calculateDriveRoute(driveRouteQuery);
        }
        return null;
    }

    public void calculateDriveRouteAsyn(DriveRouteQuery driveRouteQuery) {
        IRouteSearchV2 iRouteSearchV2 = this.f17855a;
        if (iRouteSearchV2 != null) {
            iRouteSearchV2.calculateDriveRouteAsyn(driveRouteQuery);
        }
    }

    public RideRouteResultV2 calculateRideRoute(RideRouteQuery rideRouteQuery) throws AMapException {
        IRouteSearchV2 iRouteSearchV2 = this.f17855a;
        if (iRouteSearchV2 != null) {
            return iRouteSearchV2.calculateRideRoute(rideRouteQuery);
        }
        return null;
    }

    public void calculateRideRouteAsyn(RideRouteQuery rideRouteQuery) {
        IRouteSearchV2 iRouteSearchV2 = this.f17855a;
        if (iRouteSearchV2 != null) {
            iRouteSearchV2.calculateRideRouteAsyn(rideRouteQuery);
        }
    }

    public WalkRouteResultV2 calculateWalkRoute(WalkRouteQuery walkRouteQuery) throws AMapException {
        IRouteSearchV2 iRouteSearchV2 = this.f17855a;
        if (iRouteSearchV2 != null) {
            return iRouteSearchV2.calculateWalkRoute(walkRouteQuery);
        }
        return null;
    }

    public void calculateWalkRouteAsyn(WalkRouteQuery walkRouteQuery) {
        IRouteSearchV2 iRouteSearchV2 = this.f17855a;
        if (iRouteSearchV2 != null) {
            iRouteSearchV2.calculateWalkRouteAsyn(walkRouteQuery);
        }
    }

    public void setRouteSearchListener(OnRouteSearchListener onRouteSearchListener) {
        IRouteSearchV2 iRouteSearchV2 = this.f17855a;
        if (iRouteSearchV2 != null) {
            iRouteSearchV2.setRouteSearchListener(onRouteSearchListener);
        }
    }
}
