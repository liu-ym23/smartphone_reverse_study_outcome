package com.obric.agent.trace;

import com.bytedance.apm.battery.dao.DBHelper;
import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: compiled from: TaskStateData.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName(DBHelper.COL_TIME)
    private final long f15443a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("eventName")
    private final String f15444b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("extra")
    private final Map<String, Object> f15445c;

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, e.class) == true) goto L8;
        return false;
    L8:
        e r10 = (e) ZeusTransformUtils.preCheckCast(r9, e.class, "com.obric.aiagent.plugin");
        if (this.f15443a == r10.f15443a) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f15444b, r10.f15444b) == true) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f15445c, r10.f15445c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r0 = ((Long.hashCode(this.f15443a) * 31) + this.f15444b.hashCode()) * 31;
        Map<String, Object> r2 = this.f15445c;
        if (r2 != null) goto L5;
        int r3 = 0;
    L7:
        return r0 + r3;
    L5:
        r3 = r2.hashCode();
        goto L7
    }

    public String toString() {
        return "DMEventFinal(timestamp=" + this.f15443a + ", eventName=" + this.f15444b + ", extra=" + this.f15445c + ')';
    }

    public e(long r3, String r5, Map<String, ? extends Object> r6) {
        Map<String, Object> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "eventName");
        this.f15443a = r3;
        this.f15444b = r5;
        this.f15445c = r7;
    }

    public final long a() {
        return this.f15443a;
    }

    public final String b() {
        return this.f15444b;
    }

    public final Map<String, Object> c() {
        return this.f15445c;
    }
}
