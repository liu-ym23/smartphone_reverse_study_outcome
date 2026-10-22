package com.stepos.statsapp.v3.lib.plugin.emitter;

import B0.g;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.material.internal.f;

/* loaded from: classes.dex */
public class EmitterConfig implements Parcelable {
    public static final Parcelable.Creator<EmitterConfig> CREATOR = new f(3);

    /* renamed from: a, reason: collision with root package name */
    public boolean f12309a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f12310b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f12311c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f12312d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f12313e;

    /* renamed from: f, reason: collision with root package name */
    public long f12314f;

    /* renamed from: g, reason: collision with root package name */
    public int f12315g;

    /* renamed from: h, reason: collision with root package name */
    public long f12316h;

    /* renamed from: i, reason: collision with root package name */
    public int f12317i;

    /* renamed from: j, reason: collision with root package name */
    public String f12318j;

    /* renamed from: k, reason: collision with root package name */
    public String f12319k;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("EmitterConfig{active=");
        sb.append(this.f12309a);
        sb.append(", flushOnStart=");
        sb.append(this.f12311c);
        sb.append(", flushOnCharge=");
        sb.append(this.f12312d);
        sb.append(", flushOnReconnect=");
        sb.append(this.f12313e);
        sb.append(", flushDelayInterval=");
        sb.append(this.f12314f);
        sb.append(", flushCacheLimit=");
        sb.append(this.f12315g);
        sb.append(", flushMobileTrafficLimit=");
        sb.append(this.f12316h);
        sb.append(", neartimeInterval=");
        sb.append(this.f12317i);
        sb.append(", appID='");
        sb.append(this.f12318j);
        sb.append("', channel='");
        return g.r(sb, this.f12319k, "'}");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        parcel.writeByte(this.f12310b ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f12309a ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f12311c ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f12312d ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f12313e ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.f12314f);
        parcel.writeInt(this.f12315g);
        parcel.writeLong(this.f12316h);
        parcel.writeString(this.f12318j);
        parcel.writeString(this.f12319k);
    }
}
