package com.obric.autoaction.app.launcherpage.condition.location;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: compiled from: ConditionLocationModel.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("Count")
    private final long f23218a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("Total")
    private final long f23219b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("PoiItems")
    private final List<o> f23220c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SerializedName("Report")
    private final String f23221d;

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, n.class) == true) goto L8;
        return false;
    L8:
        n r10 = (n) ZeusTransformUtils.preCheckCast(r9, n.class, "com.obric.aiagent.plugin");
        if (this.f23218a == r10.f23218a) goto L12;
        return false;
    L12:
        if (this.f23219b == r10.f23219b) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f23220c, r10.f23220c) == true) goto L18;
        return false;
    L18:
        if (d.h.b.o.a(this.f23221d, r10.f23221d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((Long.hashCode(this.f23218a) * 31) + Long.hashCode(this.f23219b)) * 31) + this.f23220c.hashCode()) * 31) + this.f23221d.hashCode();
    }

    public String toString() {
        return "LocationResponse(count=" + this.f23218a + ", total=" + this.f23219b + ", poiItems=" + this.f23220c + ", report=" + this.f23221d + ')';
    }

    public final List<o> a() {
        return this.f23220c;
    }
}
