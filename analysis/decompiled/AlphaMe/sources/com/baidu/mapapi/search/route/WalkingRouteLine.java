package com.baidu.mapapi.search.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.RouteLine;
import com.baidu.mapapi.search.core.RouteNode;
import com.baidu.mapapi.search.core.RouteStep;
import java.util.List;

/* loaded from: classes.dex */
public class WalkingRouteLine extends RouteLine<WalkingStep> implements Parcelable {
    public static final Parcelable.Creator<WalkingRouteLine> CREATOR = new a();

    public static class WalkingStep extends RouteStep implements Parcelable {
        public static final Parcelable.Creator<WalkingStep> CREATOR = new a();

        /* renamed from: e, reason: collision with root package name */
        private int f7554e;

        /* renamed from: f, reason: collision with root package name */
        private RouteNode f7555f;

        /* renamed from: g, reason: collision with root package name */
        private RouteNode f7556g;

        /* renamed from: h, reason: collision with root package name */
        private String f7557h;

        /* renamed from: i, reason: collision with root package name */
        private String f7558i;

        /* renamed from: j, reason: collision with root package name */
        private String f7559j;

        /* renamed from: k, reason: collision with root package name */
        private String f7560k;

        public static class a implements Parcelable.Creator<WalkingStep> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public WalkingStep createFromParcel(Parcel parcel) {
                return new WalkingStep(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public WalkingStep[] newArray(int i4) {
                return new WalkingStep[i4];
            }
        }

        public WalkingStep() {
        }

        @Override // com.baidu.mapapi.search.core.RouteStep, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public int getDirection() {
            return this.f7554e;
        }

        public RouteNode getEntrance() {
            return this.f7555f;
        }

        public String getEntranceInstructions() {
            return this.f7558i;
        }

        public RouteNode getExit() {
            return this.f7556g;
        }

        public String getExitInstructions() {
            return this.f7559j;
        }

        public String getInstructions() {
            return this.f7560k;
        }

        @Override // com.baidu.mapapi.search.core.RouteStep
        public List<LatLng> getWayPoints() {
            if (this.mWayPoints == null) {
                this.mWayPoints = CoordUtil.decodeLocationList(this.f7557h);
            }
            return this.mWayPoints;
        }

        public void setDirection(int i4) {
            this.f7554e = i4;
        }

        public void setEntrance(RouteNode routeNode) {
            this.f7555f = routeNode;
        }

        public void setEntranceInstructions(String str) {
            this.f7558i = str;
        }

        public void setExit(RouteNode routeNode) {
            this.f7556g = routeNode;
        }

        public void setExitInstructions(String str) {
            this.f7559j = str;
        }

        public void setInstructions(String str) {
            this.f7560k = str;
        }

        public void setPathString(String str) {
            this.f7557h = str;
        }

        @Override // com.baidu.mapapi.search.core.RouteStep, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i4) {
            super.writeToParcel(parcel, 1);
            parcel.writeInt(this.f7554e);
            parcel.writeParcelable(this.f7555f, 1);
            parcel.writeParcelable(this.f7556g, 1);
            parcel.writeString(this.f7557h);
            parcel.writeString(this.f7558i);
            parcel.writeString(this.f7559j);
            parcel.writeString(this.f7560k);
        }

        public WalkingStep(Parcel parcel) {
            super(parcel);
            this.f7554e = parcel.readInt();
            this.f7555f = (RouteNode) parcel.readParcelable(RouteNode.class.getClassLoader());
            this.f7556g = (RouteNode) parcel.readParcelable(RouteNode.class.getClassLoader());
            this.f7557h = parcel.readString();
            this.f7558i = parcel.readString();
            this.f7559j = parcel.readString();
            this.f7560k = parcel.readString();
        }
    }

    public static class a implements Parcelable.Creator<WalkingRouteLine> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public WalkingRouteLine createFromParcel(Parcel parcel) {
            return new WalkingRouteLine(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public WalkingRouteLine[] newArray(int i4) {
            return new WalkingRouteLine[i4];
        }
    }

    public WalkingRouteLine() {
    }

    @Override // com.baidu.mapapi.search.core.RouteLine, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.baidu.mapapi.search.core.RouteLine
    public List<WalkingStep> getAllStep() {
        return super.getAllStep();
    }

    @Override // com.baidu.mapapi.search.core.RouteLine, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.setType(RouteLine.TYPE.WALKSTEP);
        super.writeToParcel(parcel, 1);
    }

    public WalkingRouteLine(Parcel parcel) {
        super(parcel);
    }
}
