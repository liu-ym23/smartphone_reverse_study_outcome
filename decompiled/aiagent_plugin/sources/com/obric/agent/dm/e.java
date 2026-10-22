package com.obric.agent.dm;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.List;

/* JADX INFO: compiled from: ECA.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("jobs")
    private final List<f> f14431a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("isCloud")
    private final boolean f14432b;

    /* JADX WARN: Multi-variable type inference failed */
    public e() {
        this(null, false, 3, 0 == true ? 1 : 0);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, e.class) == true) goto L8;
        return false;
    L8:
        e r6 = (e) ZeusTransformUtils.preCheckCast(r5, e.class, "com.obric.aiagent.plugin");
        if (o.a(this.f14431a, r6.f14431a) == true) goto L12;
        return false;
    L12:
        if (this.f14432b == r6.f14432b) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        List<f> r0 = this.f14431a;
        if (r0 != null) goto L5;
        int r1 = 0;
    L7:
        return (r1 * 31) + Boolean.hashCode(this.f14432b);
    L5:
        r1 = r0.hashCode();
        goto L7
    }

    public String toString() {
        return "ECAData(jobs=" + this.f14431a + ", isCloud=" + this.f14432b + ')';
    }

    public e(List<f> r3, boolean r4) {
        this.f14431a = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        this.f14432b = r4;
    }

    public /* synthetic */ e(List r2, boolean r3, int r4, h r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        if ((r4 & 1) == 0) goto L6;
        r6 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = false;
    L8:
        this(r6, r3);
    }

    public final List<f> a() {
        return this.f14431a;
    }

    public final boolean b() {
        return this.f14432b;
    }
}
