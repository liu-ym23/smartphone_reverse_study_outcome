package com.obric.autoaction.app.launcherpage.discovery.a;

import com.google.gson.annotations.SerializedName;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: DiscoveryModel.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName(MonitorConstants.CODE)
    private final Integer f23583a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("msg")
    private final String f23584b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SerializedName("data")
    private final d f23585c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SerializedName("log_id")
    private final String f23586d;

    public c() {
        this(null, null, null, null, 15, null);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
        return false;
    L8:
        c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f23583a, r6.f23583a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f23584b, r6.f23584b) == true) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.f23585c, r6.f23585c) == true) goto L18;
        return false;
    L18:
        if (d.h.b.o.a(this.f23586d, r6.f23586d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        Integer r0 = this.f23583a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.f23584b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        d r7 = this.f23585c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.f23586d;
        if (r10 == null) goto L19;
        r1 = r10.hashCode();
    L19:
        return r9 + r1;
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "DiscoveryResponse(code=" + this.f23583a + ", msg=" + this.f23584b + ", data=" + this.f23585c + ", logId=" + this.f23586d + ')';
    }

    public c(Integer r1, String r2, d r3, String r4) {
        this.f23583a = r1;
        this.f23584b = r2;
        this.f23585c = r3;
        this.f23586d = r4;
    }

    public /* synthetic */ c(Integer r2, String r3, d r4, String r5, int r6, d.h.b.h r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = null;
    L14:
        this(r2, r3, r4, r5);
    }

    public final Integer a() {
        return this.f23583a;
    }

    public final String b() {
        return this.f23584b;
    }

    public final d c() {
        return this.f23585c;
    }

    public final String d() {
        return this.f23586d;
    }
}
