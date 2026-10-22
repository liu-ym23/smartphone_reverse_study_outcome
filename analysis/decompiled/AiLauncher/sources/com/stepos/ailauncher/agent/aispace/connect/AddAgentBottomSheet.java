package com.stepos.ailauncher.agent.aispace.connect;

import Ua.C1060i;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.stepos.ailauncher.agent.aispace.connect.data.AgentEntranceCache;
import com.stepos.ailauncher.agent.aispace.connect.data.AgentEntranceGroup;
import com.stepos.ailauncher.agent.aispace.connect.data.AgentEntranceResponseData;
import kotlin.Metadata;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J1\u0010\n\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/connect/AddAgentBottomSheet;", "", "<init>", "()V", "Landroid/view/ViewGroup;", "host", "Lkotlin/Function0;", "LY8/t;", "onPickStep", "onPickOther", "f", "(Landroid/view/ViewGroup;Lp9/a;Lp9/a;)V", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AddAgentBottomSheet {
    public static final AddAgentBottomSheet INSTANCE = new AddAgentBottomSheet();

    public static final void g(Y4.l lVar, AgentEntranceResponseData agentEntranceResponseData) {
        AgentEntranceGroup otherAgents;
        AgentEntranceGroup stepai;
        if (agentEntranceResponseData != null && (stepai = agentEntranceResponseData.getStepai()) != null) {
            if (!La.H.x0(stepai.getTitle())) {
                lVar.tvSheetStepTitle.setText(stepai.getTitle());
            }
            if (!La.H.x0(stepai.getDescription())) {
                lVar.tvSheetStepDesc.setText(stepai.getDescription());
            }
        }
        if (agentEntranceResponseData == null || (otherAgents = agentEntranceResponseData.getOtherAgents()) == null) {
            return;
        }
        if (!La.H.x0(otherAgents.getTitle())) {
            lVar.tvSheetOtherTitle.setText(otherAgents.getTitle());
        }
        if (La.H.x0(otherAgents.getDescription())) {
            return;
        }
        lVar.tvSheetOtherDesc.setText(otherAgents.getDescription());
    }

    public static final void h(kotlinx.coroutines.g gVar, Ua.M m10, ViewGroup viewGroup, FrameLayout frameLayout) {
        kotlinx.coroutines.g.Y0(gVar, null, 1, null);
        kotlinx.coroutines.d.e(m10, null, 1, null);
        viewGroup.removeView(frameLayout);
    }

    public static final void i(kotlinx.coroutines.g gVar, Ua.M m10, ViewGroup viewGroup, FrameLayout frameLayout, View view) {
        h(gVar, m10, viewGroup, frameLayout);
    }

    public static final void j(View view) {
    }

    public static final void k(InterfaceC5063a interfaceC5063a, kotlinx.coroutines.g gVar, Ua.M m10, ViewGroup viewGroup, FrameLayout frameLayout, View view) {
        h(gVar, m10, viewGroup, frameLayout);
        interfaceC5063a.invoke();
    }

    public static final void l(InterfaceC5063a interfaceC5063a, kotlinx.coroutines.g gVar, Ua.M m10, ViewGroup viewGroup, FrameLayout frameLayout, View view) {
        h(gVar, m10, viewGroup, frameLayout);
        interfaceC5063a.invoke();
    }

    public final void f(final ViewGroup host, final InterfaceC5063a<Y8.t> onPickStep, final InterfaceC5063a<Y8.t> onPickOther) {
        kotlin.jvm.internal.p.i(host, "host");
        kotlin.jvm.internal.p.i(onPickStep, "onPickStep");
        kotlin.jvm.internal.p.i(onPickOther, "onPickOther");
        Y4.l lVarC = Y4.l.c(LayoutInflater.from(host.getContext()), host, false);
        kotlin.jvm.internal.p.h(lVarC, "inflate(...)");
        final FrameLayout frameLayoutB = lVarC.b();
        kotlin.jvm.internal.p.h(frameLayoutB, "getRoot(...)");
        final Ua.M mA = kotlinx.coroutines.d.a(Ua.L0.b(null, 1, null).plus(Ua.Y.c().getImmediate()));
        g(lVarC, AgentEntranceCache.INSTANCE.a());
        final kotlinx.coroutines.g gVarD = C1060i.d(mA, null, null, new AddAgentBottomSheet$show$collectJob$1(lVarC, null), 3, null);
        C1060i.d(mA, null, null, new AddAgentBottomSheet$show$1(null), 3, null);
        frameLayoutB.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.connect.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AddAgentBottomSheet.i(gVarD, mA, host, frameLayoutB, view);
            }
        });
        lVarC.sheetPanel.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.connect.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AddAgentBottomSheet.j(view);
            }
        });
        lVarC.sheetCardStep.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.connect.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AddAgentBottomSheet.k(onPickStep, gVarD, mA, host, frameLayoutB, view);
            }
        });
        lVarC.sheetCardOther.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.connect.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AddAgentBottomSheet.l(onPickOther, gVarD, mA, host, frameLayoutB, view);
            }
        });
        host.addView(frameLayoutB);
    }
}
