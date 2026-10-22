package com.obric.autoaction.app.launcherpage.condition.location;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ConditionLocationModel.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("Name")
    private final String f23211a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("GeoNameID")
    private final String f23212b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("Code")
    private final String f23213c;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, j.class) == true) goto L8;
        return false;
    L8:
        j r6 = (j) ZeusTransformUtils.preCheckCast(r5, j.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f23211a, r6.f23211a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f23212b, r6.f23212b) == true) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f23213c, r6.f23213c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.f23211a.hashCode() * 31) + this.f23212b.hashCode()) * 31) + this.f23213c.hashCode();
    }

    public String toString() {
        return "GeoInfo(name=" + this.f23211a + ", geoNameId=" + this.f23212b + ", code=" + this.f23213c + ')';
    }
}
