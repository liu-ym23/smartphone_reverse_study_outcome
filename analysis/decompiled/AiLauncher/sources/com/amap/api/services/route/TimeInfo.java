package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class TimeInfo implements Parcelable {
    public static final Parcelable.Creator<TimeInfo> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private long f17946a;

    /* renamed from: b, reason: collision with root package name */
    private List<TimeInfosElement> f17947b;

    public static class a implements Parcelable.Creator<TimeInfo> {
        @Override // android.os.Parcelable.Creator
        public TimeInfo createFromParcel(Parcel parcel) {
            return new TimeInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ TimeInfo[] newArray(int i10) {
            return null;
        }
    }

    public TimeInfo(Parcel parcel) {
        this.f17947b = new ArrayList();
        this.f17946a = parcel.readInt();
        this.f17947b = parcel.createTypedArrayList(TimeInfosElement.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<TimeInfosElement> getElements() {
        return this.f17947b;
    }

    public long getStartTime() {
        return this.f17946a;
    }

    public void setElements(List<TimeInfosElement> list) {
        this.f17947b = list;
    }

    public void setStartTime(long j10) {
        this.f17946a = j10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeLong(this.f17946a);
        parcel.writeTypedList(this.f17947b);
    }

    public TimeInfo() {
        this.f17947b = new ArrayList();
    }
}
