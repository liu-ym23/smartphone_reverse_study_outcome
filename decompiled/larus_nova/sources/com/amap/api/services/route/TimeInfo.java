package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public class TimeInfo implements Parcelable {
    public static final Parcelable.Creator<TimeInfo> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f29215a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<TimeInfosElement> f29216b;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public TimeInfo() {
        this.f29216b = new ArrayList();
    }

    public List<TimeInfosElement> getElements() {
        return this.f29216b;
    }

    public long getStartTime() {
        return this.f29215a;
    }

    public TimeInfo(Parcel r100) {
        this.f29216b = new ArrayList();
        this.f29215a = r100.readInt();
        this.f29216b = r100.createTypedArrayList(TimeInfosElement.CREATOR);
    }

    public void setElements(List<TimeInfosElement> r100) {
        this.f29216b = r100;
    }

    public void setStartTime(long r100) {
        this.f29215a = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeLong(this.f29215a);
        r100.writeTypedList(this.f29216b);
    }
}
