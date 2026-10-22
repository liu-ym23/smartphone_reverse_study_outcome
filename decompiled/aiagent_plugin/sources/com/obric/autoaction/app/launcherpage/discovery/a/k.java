package com.obric.autoaction.app.launcherpage.discovery.a;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: compiled from: DiscoveryModel.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("group_title")
    private final String f23615a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SerializedName("instructions")
    private final List<e> f23616b;

    /* JADX WARN: Multi-variable type inference failed */
    public k() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, k.class) == true) goto L8;
        return false;
    L8:
        k r6 = (k) ZeusTransformUtils.preCheckCast(r5, k.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f23615a, r6.f23615a) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f23616b, r6.f23616b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        String r0 = this.f23615a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        List<e> r4 = this.f23616b;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "InstructionGroup(title=" + this.f23615a + ", instructions=" + this.f23616b + ')';
    }

    public k(String r3, List<e> r4) {
        List<e> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        this.f23615a = r3;
        this.f23616b = r5;
    }

    public /* synthetic */ k(String r2, List r3, int r4, d.h.b.h r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r6 = null;
    L8:
        this(r2, r6);
    }

    public final String a() {
        return this.f23615a;
    }

    public final List<e> b() {
        return this.f23616b;
    }
}
