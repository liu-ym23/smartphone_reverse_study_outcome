package com.obric.autogui.vdplayer.adapter.orchestrator.a.a;

import android.os.Bundle;
import com.obric.autogui.common.api.agent.BizStatus;
import com.obric.autogui.common.api.agent.IAutoActionAgentEventListener;
import com.obric.autogui.common.api.agent.model.CallUserFunctionParams;
import com.obric.autogui.common.api.agent.model.ClarifyFunctionParams;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: PausedEventHandler.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final BizStatus f31661a;

    public d() {
        this.f31661a = BizStatus.PAUSED;
    }

    @Override // com.obric.autogui.vdplayer.adapter.orchestrator.a.a
    public BizStatus a() {
        return this.f31661a;
    }

    @Override // com.obric.autogui.vdplayer.adapter.orchestrator.a.a.a, com.obric.autogui.common.api.agent.IAutoActionAgentEventListener
    public void onBizStatusChanged(IAutoActionAgentEventListener.SessionInfo r7, BizStatus r8, BizStatus r9, int r10, BizStatus.StatusChangedReasonStruct r11, Bundle r12) {
        o.e(r7, "sessionInfo");
        o.e(r8, "oldStatus");
        o.e(r9, "status");
        o.e(r11, "reasonDetails");
        CallUserFunctionParams r13 = null;
        List r14 = null;
        if (r10 != 1200) goto L5;
        Object r15 = r11.getObj();
        if (ZeusTransformUtils.instanceOf(r15, CallUserFunctionParams.class) == false) goto L33;
        r13 = (CallUserFunctionParams) ZeusTransformUtils.preCheckCast(r15, CallUserFunctionParams.class, "com.obric.aiagent.plugin");
    L33:
        if (r13 == null) goto L42;
        a((com.obric.autogui.vdplayer.api.a.a) ZeusTransformUtils.preCheckCast(new com.obric.autogui.vdplayer.api.a.a.C0870a(r13.getSupportsUserAddition(), r13.getContent(), r13.getAction(), r13.getSecurityLevel()), com.obric.autogui.vdplayer.api.a.a.class, "com.obric.aiagent.plugin"));
        return;
    L42:
        return;
    L5:
        if (r10 != 1202) goto L7;
        Object r16 = r11.getObj();
        if (ZeusTransformUtils.instanceOf(r16, ClarifyFunctionParams.class) == false) goto L13;
        ClarifyFunctionParams r17 = (ClarifyFunctionParams) ZeusTransformUtils.preCheckCast(r16, ClarifyFunctionParams.class, "com.obric.aiagent.plugin");
    L14:
        if (r17 == null) goto L40;
        String r18 = r17.getContent();
        String r19 = r17.getSecurityLevel();
        List<String> r110 = r17.getOptions();
        if (r110 == null) goto L29;
        Iterable r111 = (Iterable) ZeusTransformUtils.preCheckCast(r110, Iterable.class, "com.obric.aiagent.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r111, 10)), Collection.class, "com.obric.aiagent.plugin");
        int r1 = 0;
        Iterator r112 = r111.iterator();
    L19:
        if (r112.hasNext() == false) goto L28;
        Object r2 = r112.next();
        int r3 = r1 + 1;
        if (r1 >= 0) goto L23;
        p.c();
    L23:
        String r4 = (String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.aiagent.plugin");
        Map<Integer, String> r5 = r17.getSpecialStyleOptions();
        if (r5 == null) goto L26;
        String r6 = (String) ZeusTransformUtils.preCheckCast(r5.get(Integer.valueOf(r1)), String.class, "com.obric.aiagent.plugin");
    L27:
        r0.add(new com.obric.autogui.vdplayer.api.a.a.b.C0871a(r4, r6));
        r1 = r3;
        goto L19
    L26:
        r6 = null;
        goto L27
    L28:
        r14 = (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin");
    L29:
        a((com.obric.autogui.vdplayer.api.a.a) ZeusTransformUtils.preCheckCast(new com.obric.autogui.vdplayer.api.a.a.b(r18, r19, r14), com.obric.autogui.vdplayer.api.a.a.class, "com.obric.aiagent.plugin"));
        return;
    L40:
        return;
    L13:
        r17 = null;
        goto L14
    L7:
        if (r10 != 1203) goto L43;
        a((com.obric.autogui.vdplayer.api.a.a) ZeusTransformUtils.preCheckCast(com.obric.autogui.vdplayer.api.a.a.c.f31686a, com.obric.autogui.vdplayer.api.a.a.class, "com.obric.aiagent.plugin"));
        return;
    }
}
