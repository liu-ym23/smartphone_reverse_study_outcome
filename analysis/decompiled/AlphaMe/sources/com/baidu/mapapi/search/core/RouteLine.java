package com.baidu.mapapi.search.core;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.mapapi.search.core.RouteStep;
import com.baidu.mapapi.search.route.BikingRouteLine;
import com.baidu.mapapi.search.route.DrivingRouteLine;
import com.baidu.mapapi.search.route.TransitRouteLine;
import com.baidu.mapapi.search.route.WalkingRouteLine;
import java.util.List;

/* loaded from: classes.dex */
public class RouteLine<T extends RouteStep> implements Parcelable {

    /* renamed from: a, reason: collision with root package name */
    private RouteNode f7315a;

    /* renamed from: b, reason: collision with root package name */
    private RouteNode f7316b;

    /* renamed from: c, reason: collision with root package name */
    private String f7317c;

    /* renamed from: d, reason: collision with root package name */
    private List<T> f7318d;

    /* renamed from: e, reason: collision with root package name */
    private int f7319e;

    /* renamed from: f, reason: collision with root package name */
    private int f7320f;

    /* renamed from: g, reason: collision with root package name */
    private a f7321g;

    /* renamed from: h, reason: collision with root package name */
    TYPE f7322h;

    public enum TYPE {
        DRIVESTEP(0),
        TRANSITSTEP(1),
        WALKSTEP(2),
        BIKINGSTEP(3);


        /* renamed from: b, reason: collision with root package name */
        private int f7324b;

        TYPE(int i4) {
            this.f7324b = i4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int a() {
            return this.f7324b;
        }
    }

    public RouteLine() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<T> getAllStep() {
        return this.f7318d;
    }

    public int getDistance() {
        return this.f7319e;
    }

    public int getDuration() {
        return this.f7320f;
    }

    public a getLegLinked() {
        return this.f7321g;
    }

    public RouteNode getStarting() {
        return this.f7315a;
    }

    public RouteNode getTerminal() {
        return this.f7316b;
    }

    public String getTitle() {
        return this.f7317c;
    }

    public TYPE getType() {
        return this.f7322h;
    }

    public void setDistance(int i4) {
        this.f7319e = i4;
    }

    public void setDuration(int i4) {
        this.f7320f = i4;
    }

    public void setLegLinked(a aVar) {
        this.f7321g = aVar;
    }

    public void setStarting(RouteNode routeNode) {
        this.f7315a = routeNode;
    }

    public void setSteps(List<T> list) {
        this.f7318d = list;
    }

    public void setTerminal(RouteNode routeNode) {
        this.f7316b = routeNode;
    }

    public void setTitle(String str) {
        this.f7317c = str;
    }

    public void setType(TYPE type) {
        this.f7322h = type;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        TYPE type = this.f7322h;
        if (type != null) {
            parcel.writeInt(type.a());
        } else {
            parcel.writeInt(10);
        }
        parcel.writeValue(this.f7315a);
        parcel.writeValue(this.f7316b);
        parcel.writeString(this.f7317c);
        if (this.f7322h != null) {
            parcel.writeTypedList(this.f7318d);
        }
        parcel.writeInt(this.f7319e);
        parcel.writeInt(this.f7320f);
    }

    public RouteLine(Parcel parcel) {
        int i4 = parcel.readInt();
        this.f7315a = (RouteNode) parcel.readValue(RouteNode.class.getClassLoader());
        this.f7316b = (RouteNode) parcel.readValue(RouteNode.class.getClassLoader());
        this.f7317c = parcel.readString();
        if (i4 == 0) {
            this.f7318d = parcel.createTypedArrayList(DrivingRouteLine.DrivingStep.CREATOR);
        } else if (i4 == 1) {
            this.f7318d = parcel.createTypedArrayList(TransitRouteLine.TransitStep.CREATOR);
        } else if (i4 == 2) {
            this.f7318d = parcel.createTypedArrayList(WalkingRouteLine.WalkingStep.CREATOR);
        } else if (i4 == 3) {
            this.f7318d = parcel.createTypedArrayList(BikingRouteLine.BikingStep.CREATOR);
        }
        this.f7319e = parcel.readInt();
        this.f7320f = parcel.readInt();
    }
}
