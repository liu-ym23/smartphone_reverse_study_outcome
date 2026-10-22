package com.obric.agent.dm;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.List;

/* JADX INFO: compiled from: ECA.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("actions")
    private final List<b> f14433a;

    /* JADX WARN: Multi-variable type inference failed */
    public f() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public final f a(List<b> r2) {
        return new f((List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin"));
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, f.class) == true) goto L8;
        return false;
    L8:
        f r6 = (f) ZeusTransformUtils.preCheckCast(r5, f.class, "com.obric.aiagent.plugin");
        if (o.a(this.f14433a, r6.f14433a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        List<b> r0 = this.f14433a;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public String toString() {
        return "ECAJob(actions=" + this.f14433a + ')';
    }

    public f(List<b> r3) {
        this.f14433a = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
    }

    public /* synthetic */ f(List r2, int r3, h r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        if ((r3 & 1) == 0) goto L5;
        r5 = null;
    L5:
        this(r5);
    }

    public final List<b> a() {
        return this.f14433a;
    }
}
