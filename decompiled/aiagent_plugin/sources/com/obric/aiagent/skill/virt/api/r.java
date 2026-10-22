package com.obric.aiagent.skill.virt.api;

import com.obric.aikernel.sdk.ext.CozeCloudExt;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ShellApi.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f21598a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f21599b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final s f21600c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f21601d;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, r.class) == true) goto L8;
        return false;
    L8:
        r r6 = (r) ZeusTransformUtils.preCheckCast(r5, r.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f21598a, r6.f21598a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f21599b, r6.f21599b) == true) goto L15;
        return false;
    L15:
        if (this.f21600c == r6.f21600c) goto L18;
        return false;
    L18:
        if (d.h.b.o.a(this.f21601d, r6.f21601d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.f21598a.hashCode() * 31) + this.f21599b.hashCode()) * 31) + this.f21600c.hashCode()) * 31) + this.f21601d.hashCode();
    }

    public String toString() {
        return "ShellOutputEvent(groupId=" + this.f21598a + ", executionId=" + this.f21599b + ", stream=" + this.f21600c + ", chunk=" + this.f21601d + ')';
    }

    public r(String r2, String r3, s r4, String r5) {
        d.h.b.o.e(r2, "groupId");
        d.h.b.o.e(r3, "executionId");
        d.h.b.o.e(r4, CozeCloudExt.API_KEY_HTTP_STREAM_METHOD);
        d.h.b.o.e(r5, MonitorConstants.CHUNK);
        this.f21598a = r2;
        this.f21599b = r3;
        this.f21600c = r4;
        this.f21601d = r5;
    }

    public final String a() {
        return this.f21598a;
    }

    public final String b() {
        return this.f21599b;
    }

    public final s c() {
        return this.f21600c;
    }

    public final String d() {
        return this.f21601d;
    }
}
