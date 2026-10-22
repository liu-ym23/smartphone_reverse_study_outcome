package com.tencent.bugly.crashreport.common.info;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes4.dex */
public class PlugInBean implements Parcelable {
    public static final Parcelable.Creator<PlugInBean> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public final String f31444a;

    /* renamed from: b, reason: collision with root package name */
    public final String f31445b;

    /* renamed from: c, reason: collision with root package name */
    public final String f31446c;

    public static class a implements Parcelable.Creator<PlugInBean> {
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ PlugInBean createFromParcel(Parcel parcel) {
            return new PlugInBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ PlugInBean[] newArray(int i10) {
            return new PlugInBean[i10];
        }
    }

    public PlugInBean(String str, String str2, String str3) {
        this.f31444a = str;
        this.f31445b = str2;
        this.f31446c = str3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "plid:" + this.f31444a + " plV:" + this.f31445b + " plUUID:" + this.f31446c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f31444a);
        parcel.writeString(this.f31445b);
        parcel.writeString(this.f31446c);
    }

    public PlugInBean(Parcel parcel) {
        this.f31444a = parcel.readString();
        this.f31445b = parcel.readString();
        this.f31446c = parcel.readString();
    }
}
