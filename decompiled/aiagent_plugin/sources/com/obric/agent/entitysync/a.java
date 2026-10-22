package com.obric.agent.entitysync;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.List;

/* JADX INFO: compiled from: AppEntitySyncModels.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f14467a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<d> f14468b;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
        return false;
    L8:
        a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
        if (o.a(this.f14467a, r6.f14467a) == true) goto L12;
        return false;
    L12:
        if (o.a(this.f14468b, r6.f14468b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.f14467a.hashCode() * 31) + this.f14468b.hashCode();
    }

    public String toString() {
        return "AppEntityCardMutation(cardKey=" + this.f14467a + ", items=" + this.f14468b + ')';
    }

    public a(String r3, List<d> r4) {
        List<d> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        o.e(r3, "cardKey");
        o.e(r5, "items");
        this.f14467a = r3;
        this.f14468b = r5;
    }

    public final String a() {
        return this.f14467a;
    }

    public final List<d> b() {
        return this.f14468b;
    }
}
