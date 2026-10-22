package com.obric.autoaction.vdplayer.legacy.d;

import com.obric.autogui.common.api.agent.IAutoActionAgentEventListener;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: compiled from: VDPlayerUIState.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<IAutoActionAgentEventListener.OperatingAppInfo> f25881a;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, d.class) == true) goto L8;
        return false;
    L8:
        d r6 = (d) ZeusTransformUtils.preCheckCast(r5, d.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.f25881a, r6.f25881a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.f25881a.hashCode();
    }

    public String toString() {
        return "AgentUIContext(operatingAppHistory=" + this.f25881a + ')';
    }

    public d(List<IAutoActionAgentEventListener.OperatingAppInfo> r3) {
        List<IAutoActionAgentEventListener.OperatingAppInfo> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "operatingAppHistory");
        this.f25881a = r4;
    }

    public final List<IAutoActionAgentEventListener.OperatingAppInfo> a() {
        return this.f25881a;
    }
}
