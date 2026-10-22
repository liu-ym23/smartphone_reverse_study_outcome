package com.obric.common.upgrade;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import java.util.List;

/* JADX INFO: compiled from: AppUpgradeResponse.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("apps")
    private final List<a> f32607a;

    /* JADX WARN: Multi-variable type inference failed */
    public c() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
        return false;
    L8:
        c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
        if (o.a(this.f32607a, r6.f32607a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.f32607a.hashCode();
    }

    public String toString() {
        return "AppUpgradeData(apps=" + this.f32607a + ')';
    }

    public c(List<a> r3) {
        List<a> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        o.e(r4, "apps");
        this.f32607a = r4;
    }

    public /* synthetic */ c(List r2, int r3, d.h.b.h r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        if ((r3 & 1) == 0) goto L5;
        r5 = p.b();
    L5:
        this(r5);
    }

    public final List<a> a() {
        return this.f32607a;
    }
}
