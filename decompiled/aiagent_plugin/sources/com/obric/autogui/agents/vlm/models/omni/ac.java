package com.obric.autogui.agents.vlm.models.omni;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: compiled from: OmniUserInteractionProtocol.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ac {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f28205a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<String, String> f28206b;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ac.class) == true) goto L8;
        return false;
    L8:
        ac r6 = (ac) ZeusTransformUtils.preCheckCast(r5, ac.class, "com.obric.aiagent.plugin");
        if (this.f28205a == r6.f28205a) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.f28206b, r6.f28206b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (Integer.hashCode(this.f28205a) * 31) + this.f28206b.hashCode();
    }

    public String toString() {
        return "UserInteractionTermination(reason=" + this.f28205a + ", resultExtras=" + this.f28206b + ')';
    }

    public ac(int r3, Map<String, String> r4) {
        Map<String, String> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "resultExtras");
        this.f28205a = r3;
        this.f28206b = r5;
    }

    public final int a() {
        return this.f28205a;
    }

    public final Map<String, String> b() {
        return this.f28206b;
    }
}
