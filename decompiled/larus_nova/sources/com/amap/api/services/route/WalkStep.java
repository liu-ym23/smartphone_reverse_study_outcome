package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public class WalkStep implements Parcelable {
    public static final Parcelable.Creator<WalkStep> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f29250a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f29251b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f29252c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f29253d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f29254e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private List<LatLonPoint> f29255f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f29256g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f29257h;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public WalkStep() {
        this.f29255f = new ArrayList();
    }

    public String getAction() {
        return this.f29256g;
    }

    public String getAssistantAction() {
        return this.f29257h;
    }

    public float getDistance() {
        return this.f29253d;
    }

    public float getDuration() {
        return this.f29254e;
    }

    public String getInstruction() {
        return this.f29250a;
    }

    public String getOrientation() {
        return this.f29251b;
    }

    public List<LatLonPoint> getPolyline() {
        return this.f29255f;
    }

    public String getRoad() {
        return this.f29252c;
    }

    public WalkStep(Parcel r100) {
        this.f29255f = new ArrayList();
        this.f29250a = r100.readString();
        this.f29251b = r100.readString();
        this.f29252c = r100.readString();
        this.f29253d = r100.readFloat();
        this.f29254e = r100.readFloat();
        this.f29255f = r100.createTypedArrayList(LatLonPoint.CREATOR);
        this.f29256g = r100.readString();
        this.f29257h = r100.readString();
    }

    public void setAction(String r100) {
        this.f29256g = r100;
    }

    public void setAssistantAction(String r100) {
        this.f29257h = r100;
    }

    public void setDistance(float r100) {
        this.f29253d = r100;
    }

    public void setDuration(float r100) {
        this.f29254e = r100;
    }

    public void setInstruction(String r100) {
        this.f29250a = r100;
    }

    public void setOrientation(String r100) {
        this.f29251b = r100;
    }

    public void setPolyline(List<LatLonPoint> r100) {
        this.f29255f = r100;
    }

    public void setRoad(String r100) {
        this.f29252c = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.f29250a);
        r100.writeString(this.f29251b);
        r100.writeString(this.f29252c);
        r100.writeFloat(this.f29253d);
        r100.writeFloat(this.f29254e);
        r100.writeTypedList(this.f29255f);
        r100.writeString(this.f29256g);
        r100.writeString(this.f29257h);
    }
}
