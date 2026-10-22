package com.stepos.statsapp.v3.lib.plugin.emitter;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.os.a;
import androidx.activity.b;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class EmitterConfig implements Parcelable {
    public static final Parcelable.Creator<EmitterConfig> CREATOR = new a(14);

    /* renamed from: c, reason: collision with root package name */
    public boolean f2810c;

    /* renamed from: f, reason: collision with root package name */
    public boolean f2811f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f2812g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f2813h;
    public boolean i;

    /* renamed from: j, reason: collision with root package name */
    public long f2814j;

    /* renamed from: k, reason: collision with root package name */
    public int f2815k;

    /* renamed from: l, reason: collision with root package name */
    public long f2816l;

    /* renamed from: m, reason: collision with root package name */
    public int f2817m;

    /* renamed from: n, reason: collision with root package name */
    public String f2818n;

    /* renamed from: o, reason: collision with root package name */
    public String f2819o;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("EmitterConfig{active=");
        sb2.append(this.f2810c);
        sb2.append(", flushOnStart=");
        sb2.append(this.f2812g);
        sb2.append(", flushOnCharge=");
        sb2.append(this.f2813h);
        sb2.append(", flushOnReconnect=");
        sb2.append(this.i);
        sb2.append(", flushDelayInterval=");
        sb2.append(this.f2814j);
        sb2.append(", flushCacheLimit=");
        sb2.append(this.f2815k);
        sb2.append(", flushMobileTrafficLimit=");
        sb2.append(this.f2816l);
        sb2.append(", neartimeInterval=");
        sb2.append(this.f2817m);
        sb2.append(", appID='");
        sb2.append(this.f2818n);
        sb2.append("', channel='");
        return b.n(sb2, this.f2819o, "'}");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.f2811f ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f2810c ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f2812g ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f2813h ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.i ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.f2814j);
        parcel.writeInt(this.f2815k);
        parcel.writeLong(this.f2816l);
        parcel.writeString(this.f2818n);
        parcel.writeString(this.f2819o);
    }
}
