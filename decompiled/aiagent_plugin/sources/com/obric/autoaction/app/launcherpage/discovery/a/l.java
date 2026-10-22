package com.obric.autoaction.app.launcherpage.discovery.a;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: compiled from: DiscoveryModel.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("instruction_groups")
    private final List<k> f23617a;

    /* JADX WARN: Multi-variable type inference failed */
    public l() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, l.class) == true) goto L8;
        return false;
    L8:
        l r6 = (l) ZeusTransformUtils.preCheckCast(r5, l.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f23617a, r6.f23617a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        List<k> r0 = this.f23617a;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public String toString() {
        return "InstructionGroupsData(instructionGroups=" + this.f23617a + ')';
    }

    public l(List<k> r3) {
        this.f23617a = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
    }

    public /* synthetic */ l(List r2, int r3, d.h.b.h r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        if ((r3 & 1) == 0) goto L5;
        r5 = null;
    L5:
        this(r5);
    }

    public final List<k> a() {
        return this.f23617a;
    }
}
