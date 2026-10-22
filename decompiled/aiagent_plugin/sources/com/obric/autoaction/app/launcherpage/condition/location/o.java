package com.obric.autoaction.app.launcherpage.condition.location;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ConditionLocationModel.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("Id")
    private final String f23222a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("Name")
    private final String f23223b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("Address")
    private final String f23224c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SerializedName("Adms")
    private final a f23225d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @SerializedName("TypeCode")
    private final String f23226e;

    @SerializedName("LngLat")
    private final m f;

    @SerializedName("Type")
    private final String g;

    @SerializedName("Distance")
    private final double h;

    @SerializedName("GeoHash")
    private final String i;

    @SerializedName("Level")
    private final String j;

    @SerializedName("LinkedAddr")
    private final l k;

    @SerializedName("AoiID")
    private final String l;

    @SerializedName("UpdateTime")
    private final long m;

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, o.class) == true) goto L8;
        return false;
    L8:
        o r10 = (o) ZeusTransformUtils.preCheckCast(r9, o.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f23222a, r10.f23222a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f23223b, r10.f23223b) == true) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f23224c, r10.f23224c) == true) goto L18;
        return false;
    L18:
        if (d.h.b.o.a(this.f23225d, r10.f23225d) == true) goto L21;
        return false;
    L21:
        if (d.h.b.o.a(this.f23226e, r10.f23226e) == true) goto L24;
        return false;
    L24:
        if (d.h.b.o.a(this.f, r10.f) == true) goto L27;
        return false;
    L27:
        if (d.h.b.o.a(this.g, r10.g) == true) goto L30;
        return false;
    L30:
        if (Double.compare(this.h, r10.h) == 0) goto L33;
        return false;
    L33:
        if (d.h.b.o.a(this.i, r10.i) == true) goto L36;
        return false;
    L36:
        if (d.h.b.o.a(this.j, r10.j) == true) goto L39;
        return false;
    L39:
        if (d.h.b.o.a(this.k, r10.k) == true) goto L42;
        return false;
    L42:
        if (d.h.b.o.a(this.l, r10.l) == true) goto L45;
        return false;
    L45:
        if (this.m == r10.m) goto L47;
        return false;
    L47:
        return true;
    }

    public int hashCode() {
        return (((((((((((((((((((((((this.f23222a.hashCode() * 31) + this.f23223b.hashCode()) * 31) + this.f23224c.hashCode()) * 31) + this.f23225d.hashCode()) * 31) + this.f23226e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + Double.hashCode(this.h)) * 31) + this.i.hashCode()) * 31) + this.j.hashCode()) * 31) + this.k.hashCode()) * 31) + this.l.hashCode()) * 31) + Long.hashCode(this.m);
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("PoiItem(id=").append(this.f23222a).append(", name=").append(this.f23223b).append(", address=").append(this.f23224c).append(", adms=").append(this.f23225d).append(", typeCode=").append(this.f23226e).append(", lngLat=").append(this.f).append(", type=").append(this.g).append(", distance=").append(this.h).append(", geoHash=").append(this.i).append(", level=").append(this.j).append(", linkedAddr=").append(this.k).append(", aoiId=");
        r0.append(this.l).append(", updateTime=").append(this.m).append(')');
        return r0.toString();
    }

    public final String a() {
        return this.f23223b;
    }

    public final String b() {
        return this.f23224c;
    }

    public final m c() {
        return this.f;
    }

    public final String getType() {
        return this.g;
    }
}
