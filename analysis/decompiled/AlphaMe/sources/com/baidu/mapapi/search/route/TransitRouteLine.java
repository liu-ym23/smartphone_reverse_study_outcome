package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.RouteLine;
import com.baidu.mapapi.search.core.RouteNode;
import com.baidu.mapapi.search.core.RouteStep;
import com.baidu.mapapi.search.core.TaxiInfo;
import com.baidu.mapapi.search.core.VehicleInfo;
import java.util.List;

/* loaded from: classes.dex */
public final class TransitRouteLine extends RouteLine<TransitStep> implements Parcelable {
    public static final Parcelable.Creator<TransitRouteLine> CREATOR = new a();

    /* renamed from: i, reason: collision with root package name */
    private TaxiInfo f7542i;

    public static class TransitStep extends RouteStep implements Parcelable {
        public static final Parcelable.Creator<TransitStep> CREATOR = new a();

        /* renamed from: e, reason: collision with root package name */
        private VehicleInfo f7543e;

        /* renamed from: f, reason: collision with root package name */
        private RouteNode f7544f;

        /* renamed from: g, reason: collision with root package name */
        private RouteNode f7545g;

        /* renamed from: h, reason: collision with root package name */
        private TransitRouteStepType f7546h;

        /* renamed from: i, reason: collision with root package name */
        private String f7547i;

        /* renamed from: j, reason: collision with root package name */
        private String f7548j;

        public enum TransitRouteStepType {
            BUSLINE,
            SUBWAY,
            WAKLING
        }

        public static class a implements Parcelable.Creator<TransitStep> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public TransitStep createFromParcel(Parcel parcel) {
                return new TransitStep(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public TransitStep[] newArray(int i4) {
                return new TransitStep[i4];
            }
        }

        public TransitStep() {
        }

        @Override // com.baidu.mapapi.search.core.RouteStep, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public RouteNode getEntrance() {
            return this.f7544f;
        }

        public RouteNode getExit() {
            return this.f7545g;
        }

        public String getInstructions() {
            return this.f7547i;
        }

        public TransitRouteStepType getStepType() {
            return this.f7546h;
        }

        public VehicleInfo getVehicleInfo() {
            return this.f7543e;
        }

        @Override // com.baidu.mapapi.search.core.RouteStep
        public List<LatLng> getWayPoints() {
            if (this.mWayPoints == null) {
                this.mWayPoints = CoordUtil.decodeLocationList(this.f7548j);
            }
            return this.mWayPoints;
        }

        public void setEntrace(RouteNode routeNode) {
            this.f7544f = routeNode;
        }

        public void setExit(RouteNode routeNode) {
            this.f7545g = routeNode;
        }

        public void setInstructions(String str) {
            this.f7547i = str;
        }

        public void setPathString(String str) {
            this.f7548j = str;
        }

        public void setStepType(TransitRouteStepType transitRouteStepType) {
            this.f7546h = transitRouteStepType;
        }

        public void setVehicleInfo(VehicleInfo vehicleInfo) {
            this.f7543e = vehicleInfo;
        }

        @Override // com.baidu.mapapi.search.core.RouteStep, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i4) {
            super.writeToParcel(parcel, i4);
            parcel.writeParcelable(this.f7543e, 1);
            parcel.writeParcelable(this.f7544f, 1);
            parcel.writeParcelable(this.f7545g, 1);
            TransitRouteStepType transitRouteStepType = this.f7546h;
            parcel.writeInt(transitRouteStepType == null ? -1 : transitRouteStepType.ordinal());
            parcel.writeString(this.f7547i);
            parcel.writeString(this.f7548j);
        }

        public TransitStep(Parcel parcel) {
            super(parcel);
            this.f7543e = (VehicleInfo) parcel.readParcelable(VehicleInfo.class.getClassLoader());
            this.f7544f = (RouteNode) parcel.readParcelable(RouteNode.class.getClassLoader());
            this.f7545g = (RouteNode) parcel.readParcelable(RouteNode.class.getClassLoader());
            int i4 = parcel.readInt();
            this.f7546h = i4 == -1 ? null : TransitRouteStepType.values()[i4];
            this.f7547i = parcel.readString();
            this.f7548j = parcel.readString();
        }
    }

    public static class a implements Parcelable.Creator<TransitRouteLine> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public TransitRouteLine createFromParcel(Parcel parcel) {
            return new TransitRouteLine(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public TransitRouteLine[] newArray(int i4) {
            return new TransitRouteLine[i4];
        }
    }

    public TransitRouteLine() {
    }

    @Override // com.baidu.mapapi.search.core.RouteLine, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Deprecated
    public TaxiInfo getTaxitInfo() {
        return this.f7542i;
    }

    public void setTaxitInfo(TaxiInfo taxiInfo) {
        this.f7542i = taxiInfo;
    }

    @Override // com.baidu.mapapi.search.core.RouteLine, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.setType(RouteLine.TYPE.TRANSITSTEP);
        super.writeToParcel(parcel, i4);
        parcel.writeParcelable(this.f7542i, 1);
    }

    public TransitRouteLine(Parcel parcel) {
        super(parcel);
        this.f7542i = (TaxiInfo) parcel.readParcelable(TaxiInfo.class.getClassLoader());
    }
}
