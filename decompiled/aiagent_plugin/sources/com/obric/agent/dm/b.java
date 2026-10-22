package com.obric.agent.dm;

import com.bytedance.bdturing.localstorage.DbHelper;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: ECA.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("actionName")
    private final String f14426a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName(DbHelper.COL_ID)
    private final int f14427b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("inputParams")
    private final JsonObject f14428c;

    public b() {
        this(null, 0, null, 7, null);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
        return false;
    L8:
        b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
        if (o.a(this.f14426a, r6.f14426a) == true) goto L12;
        return false;
    L12:
        if (this.f14427b == r6.f14427b) goto L15;
        return false;
    L15:
        if (o.a(this.f14428c, r6.f14428c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r0 = this.f14426a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = ((r2 * 31) + Integer.hashCode(this.f14427b)) * 31;
        JsonObject r4 = this.f14428c;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "ECAAction(actionName=" + this.f14426a + ", id=" + this.f14427b + ", inputParams=" + this.f14428c + ')';
    }

    public b(String r1, int r2, JsonObject r3) {
        this.f14426a = r1;
        this.f14427b = r2;
        this.f14428c = r3;
    }

    public /* synthetic */ b(String r2, int r3, JsonObject r4, int r5, h r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = -1;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = null;
    L11:
        this(r2, r3, r4);
    }

    public final String a() {
        return this.f14426a;
    }

    public final int b() {
        return this.f14427b;
    }

    public final JsonObject c() {
        return this.f14428c;
    }
}
