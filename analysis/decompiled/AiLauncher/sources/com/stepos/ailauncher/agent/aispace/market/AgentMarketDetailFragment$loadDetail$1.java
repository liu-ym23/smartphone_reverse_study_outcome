package com.stepos.ailauncher.agent.aispace.market;

import Y4.C1117a;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.stepos.ailauncher.agent.R$string;
import com.stepos.ailauncher.agent.skill.detail.SkillMarkwonFactoryKt;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.agent.aispace.market.AgentMarketDetailFragment$loadDetail$1", f = "AgentMarketDetailFragment.kt", l = {544, 556}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class AgentMarketDetailFragment$loadDetail$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ AgentMarketDetailFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentMarketDetailFragment$loadDetail$1(AgentMarketDetailFragment agentMarketDetailFragment, InterfaceC4014c<? super AgentMarketDetailFragment$loadDetail$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = agentMarketDetailFragment;
    }

    public static final Y8.t i(final AgentMarketDetailFragment agentMarketDetailFragment, final String str, boolean z10) {
        C1117a c1117a = agentMarketDetailFragment._binding;
        if (c1117a == null) {
            return Y8.t.f7040a;
        }
        LinearLayout cardReadme = c1117a.cardReadme;
        kotlin.jvm.internal.p.h(cardReadme, "cardReadme");
        TextView btnReadmeViewFull = c1117a.btnReadmeViewFull;
        kotlin.jvm.internal.p.h(btnReadmeViewFull, "btnReadmeViewFull");
        SkillMarkwonFactoryKt.e(cardReadme, btnReadmeViewFull, z10);
        if (z10) {
            c1117a.btnReadmeViewFull.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.market.t0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AgentMarketDetailFragment$loadDetail$1.n(agentMarketDetailFragment, str, view);
                }
            });
        }
        return Y8.t.f7040a;
    }

    public static final void n(AgentMarketDetailFragment agentMarketDetailFragment, String str, View view) {
        com.stepos.ailauncher.sheet.nav.a.z(agentMarketDetailFragment, com.stepos.ailauncher.agent.skill.detail.y0.INSTANCE.a(str, agentMarketDetailFragment.getString(R$string.skill_detail_section_readme)), "agent_readme", null, null, null, 28, null);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new AgentMarketDetailFragment$loadDetail$1(this.this$0, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((AgentMarketDetailFragment$loadDetail$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0186  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r17) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 415
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.aispace.market.AgentMarketDetailFragment$loadDetail$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
