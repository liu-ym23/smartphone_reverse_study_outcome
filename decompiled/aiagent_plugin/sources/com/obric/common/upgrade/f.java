package com.obric.common.upgrade;

import com.google.gson.annotations.SerializedName;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: AppUpgradeResponse.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName(MonitorConstants.CODE)
    private final int f32630a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("msg")
    private final String f32631b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("data")
    private final c f32632c;

    public f() {
        this(0, null, null, 7, null);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, f.class) == true) goto L8;
        return false;
    L8:
        f r6 = (f) ZeusTransformUtils.preCheckCast(r5, f.class, "com.obric.aiagent.plugin");
        if (this.f32630a == r6.f32630a) goto L12;
        return false;
    L12:
        if (o.a(this.f32631b, r6.f32631b) == true) goto L15;
        return false;
    L15:
        if (o.a(this.f32632c, r6.f32632c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.f32630a) * 31) + this.f32631b.hashCode()) * 31) + this.f32632c.hashCode();
    }

    public String toString() {
        return "AppUpgradeResponse(code=" + this.f32630a + ", msg=" + this.f32631b + ", data=" + this.f32632c + ')';
    }

    public f(int r2, String r3, c r4) {
        o.e(r3, "msg");
        o.e(r4, "data");
        this.f32630a = r2;
        this.f32631b = r3;
        this.f32632c = r4;
    }

    public final int a() {
        return this.f32630a;
    }

    public /* synthetic */ f(int r1, String r2, c r3, int r4, d.h.b.h r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = 0;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = "";
    L9:
        if ((r4 & 4) == 0) goto L11;
        r3 = new c(null, 1, null);
    L11:
        this(r1, r2, r3);
    }

    public final c b() {
        return this.f32632c;
    }
}
