package com.miui.guardprovider;

import android.os.Bundle;
import com.miui.guardprovider.aidl.ScanResultInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;

/* JADX INFO: compiled from: ScanResult.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c implements Comparable<c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f13913a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f13914b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f13915c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f13916d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Bundle f13917e;
    private final long f;

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(c r3) {
        return a((c) ZeusTransformUtils.preCheckCast(r3, c.class, "com.obric.aiagent.plugin"));
    }

    public c(int r1, String r2, String r3, String r4, Bundle r5, long r6) {
        this.f13913a = r1;
        this.f13914b = r2;
        this.f13915c = r3;
        this.f13916d = r4;
        this.f13917e = r5;
        this.f = r6;
    }

    public int a(c r1) {
        return Integer.compare(r1.f13913a, this.f13913a);
    }

    public static c a(ScanResultInfo r9) {
        return new c(r9.threatLevel, r9.threatName, r9.threatDesc, r9.checkoutEngine, r9.extras, r9.flags);
    }

    public int a() {
        return this.f13913a;
    }

    public String b() {
        return this.f13914b;
    }

    public String c() {
        return this.f13915c;
    }

    public String d() {
        return this.f13916d;
    }

    public Bundle e() {
        return this.f13917e;
    }

    public long f() {
        return this.f;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L23:
        return false;
    L8:
        if (r5.getClass() != getClass()) goto L23;
        c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
        if (this.f13913a != r6.f13913a) goto L22;
        if (Objects.equals(this.f13914b, r6.f13914b) == false) goto L22;
        if (Objects.equals(this.f13915c, r6.f13915c) == false) goto L22;
        if (Objects.equals(this.f13916d, r6.f13916d) == false) goto L22;
        if (this.f != r6.f) goto L22;
        return true;
    L22:
        return false;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(this.f13913a), this.f13914b, this.f13915c, this.f13916d, Long.valueOf(this.f)});
    }

    public String toString() {
        return "ScanResult[threatLevel=" + this.f13913a + ", threatName=" + this.f13914b + ", threatDesc=" + this.f13915c + ", checkoutEngine=" + this.f13916d + ", extras=" + this.f13917e + ", flags=" + this.f + ']';
    }
}
