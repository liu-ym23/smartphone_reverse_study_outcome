package com.obric.aiagent.ttnet;

import com.bytedance.apm.battery.dao.DBHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.io.File;
import java.util.Map;

/* JADX INFO: compiled from: ITTNetFileTransfer.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f22271a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final File f22272b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f22273c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map<String, String> f22274d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f22275e;
    private final long f;
    private final long g;

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, j.class) == true) goto L8;
        return false;
    L8:
        j r10 = (j) ZeusTransformUtils.preCheckCast(r9, j.class, "com.obric.aiagent.plugin");
        if (o.a(this.f22271a, r10.f22271a) == true) goto L12;
        return false;
    L12:
        if (o.a(this.f22272b, r10.f22272b) == true) goto L15;
        return false;
    L15:
        if (o.a(this.f22273c, r10.f22273c) == true) goto L18;
        return false;
    L18:
        if (o.a(this.f22274d, r10.f22274d) == true) goto L21;
        return false;
    L21:
        if (this.f22275e == r10.f22275e) goto L24;
        return false;
    L24:
        if (this.f == r10.f) goto L27;
        return false;
    L27:
        if (this.g == r10.g) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        return (((((((((((this.f22271a.hashCode() * 31) + this.f22272b.hashCode()) * 31) + this.f22273c.hashCode()) * 31) + this.f22274d.hashCode()) * 31) + Long.hashCode(this.f22275e)) * 31) + Long.hashCode(this.f)) * 31) + Long.hashCode(this.g);
    }

    public String toString() {
        return "TTNetFilePutRequest(url=" + this.f22271a + ", source=" + this.f22272b + ", contentType=" + this.f22273c + ", headers=" + this.f22274d + ", connectTimeoutMs=" + this.f22275e + ", readTimeoutMs=" + this.f + ", writeTimeoutMs=" + this.g + ')';
    }

    public j(String r3, File r4, String r5, Map<String, String> r6, long r7, long r9, long r11) {
        Map<String, String> r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.aiagent.plugin");
        o.e(r3, "url");
        o.e(r4, DBHelper.BATTERY_COL_SOURCE);
        o.e(r5, "contentType");
        o.e(r8, "headers");
        this.f22271a = r3;
        this.f22272b = r4;
        this.f22273c = r5;
        this.f22274d = r8;
        this.f22275e = r7;
        this.f = r9;
        this.g = r11;
    }

    public final String a() {
        return this.f22271a;
    }

    public final File b() {
        return this.f22272b;
    }

    public final String c() {
        return this.f22273c;
    }

    public final Map<String, String> d() {
        return this.f22274d;
    }

    public final long e() {
        return this.f22275e;
    }

    public final long f() {
        return this.f;
    }

    public final long g() {
        return this.g;
    }
}
