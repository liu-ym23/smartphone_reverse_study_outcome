package com.baidu.mapapi.search.route;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.RouteLine;
import com.baidu.mapapi.search.core.RouteNode;
import com.baidu.mapapi.search.core.RouteStep;
import java.util.ArrayList;
import java.util.List;

@SuppressLint({"ParcelCreator"})
/* loaded from: classes.dex */
public class IndoorRouteLine extends RouteLine<IndoorRouteStep> {
    public static final Parcelable.Creator<IndoorRouteLine> CREATOR = new a();

    public static class IndoorRouteStep extends RouteStep {

        /* renamed from: e, reason: collision with root package name */
        private RouteNode f7483e;

        /* renamed from: f, reason: collision with root package name */
        private RouteNode f7484f;

        /* renamed from: g, reason: collision with root package name */
        private String f7485g;

        /* renamed from: h, reason: collision with root package name */
        private String f7486h;

        /* renamed from: i, reason: collision with root package name */
        private String f7487i;

        /* renamed from: j, reason: collision with root package name */
        private List<IndoorStepNode> f7488j;

        /* renamed from: k, reason: collision with root package name */
        private List<Double> f7489k;

        public static class IndoorStepNode {

            /* renamed from: a, reason: collision with root package name */
            private String f7490a;

            /* renamed from: b, reason: collision with root package name */
            private int f7491b;

            /* renamed from: c, reason: collision with root package name */
            private LatLng f7492c;

            /* renamed from: d, reason: collision with root package name */
            private String f7493d;

            public String getDetail() {
                return this.f7493d;
            }

            public LatLng getLocation() {
                return this.f7492c;
            }

            public String getName() {
                return this.f7490a;
            }

            public int getType() {
                return this.f7491b;
            }

            public void setDetail(String str) {
                this.f7493d = str;
            }

            public void setLocation(LatLng latLng) {
                this.f7492c = latLng;
            }

            public void setName(String str) {
                this.f7490a = str;
            }

            public void setType(int i4) {
                this.f7491b = i4;
            }
        }

        private List<LatLng> a(List<Double> list) {
            ArrayList arrayList = new ArrayList();
            for (int i4 = 0; i4 < list.size(); i4 += 2) {
                arrayList.add(new LatLng(list.get(i4).doubleValue(), list.get(i4 + 1).doubleValue()));
            }
            return arrayList;
        }

        public String getBuildingId() {
            return this.f7487i;
        }

        public RouteNode getEntrace() {
            return this.f7483e;
        }

        public RouteNode getExit() {
            return this.f7484f;
        }

        public String getFloorId() {
            return this.f7486h;
        }

        public String getInstructions() {
            return this.f7485g;
        }

        public List<IndoorStepNode> getStepNodes() {
            return this.f7488j;
        }

        @Override // com.baidu.mapapi.search.core.RouteStep
        public List<LatLng> getWayPoints() {
            if (this.mWayPoints == null) {
                this.mWayPoints = a(this.f7489k);
            }
            return this.mWayPoints;
        }

        public void setBuildingId(String str) {
            this.f7487i = str;
        }

        public void setEntrace(RouteNode routeNode) {
            this.f7483e = routeNode;
        }

        public void setExit(RouteNode routeNode) {
            this.f7484f = routeNode;
        }

        public void setFloorId(String str) {
            this.f7486h = str;
        }

        public void setInstructions(String str) {
            this.f7485g = str;
        }

        public void setPath(List<Double> list) {
            this.f7489k = list;
        }

        public void setStepNodes(List<IndoorStepNode> list) {
            this.f7488j = list;
        }
    }

    public static class a implements Parcelable.Creator<IndoorRouteLine> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public IndoorRouteLine createFromParcel(Parcel parcel) {
            return new IndoorRouteLine(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public IndoorRouteLine[] newArray(int i4) {
            return new IndoorRouteLine[i4];
        }
    }

    public IndoorRouteLine() {
        setType(RouteLine.TYPE.WALKSTEP);
    }

    @Override // com.baidu.mapapi.search.core.RouteLine, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.baidu.mapapi.search.core.RouteLine
    public List<IndoorRouteStep> getAllStep() {
        return super.getAllStep();
    }

    @Override // com.baidu.mapapi.search.core.RouteLine, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
    }

    public IndoorRouteLine(Parcel parcel) {
        super(parcel);
    }
}
