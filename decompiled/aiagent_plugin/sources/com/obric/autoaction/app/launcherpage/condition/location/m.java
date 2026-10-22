package com.obric.autoaction.app.launcherpage.condition.location;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ConditionLocationModel.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("Lng")
    private final double f23216a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("Lat")
    private final double f23217b;

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, m.class) == true) goto L8;
        return false;
    L8:
        m r10 = (m) ZeusTransformUtils.preCheckCast(r9, m.class, "com.obric.aiagent.plugin");
        if (Double.compare(this.f23216a, r10.f23216a) == 0) goto L12;
        return false;
    L12:
        if (Double.compare(this.f23217b, r10.f23217b) == 0) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (Double.hashCode(this.f23216a) * 31) + Double.hashCode(this.f23217b);
    }

    public String toString() {
        return "LngLat(lng=" + this.f23216a + ", lat=" + this.f23217b + ')';
    }

    public final double a() {
        return this.f23216a;
    }

    public final double b() {
        return this.f23217b;
    }
}
