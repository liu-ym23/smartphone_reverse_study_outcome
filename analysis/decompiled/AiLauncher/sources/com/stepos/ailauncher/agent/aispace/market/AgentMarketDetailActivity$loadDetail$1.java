package com.stepos.ailauncher.agent.aispace.market;

import Y4.C1117a;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.stepos.ailauncher.agent.skill.detail.SkillMarkwonFactoryKt;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.agent.aispace.market.AgentMarketDetailActivity$loadDetail$1", f = "AgentMarketDetailActivity.kt", l = {510, 526}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class AgentMarketDetailActivity$loadDetail$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ AgentMarketDetailActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentMarketDetailActivity$loadDetail$1(AgentMarketDetailActivity agentMarketDetailActivity, InterfaceC4014c<? super AgentMarketDetailActivity$loadDetail$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = agentMarketDetailActivity;
    }

    public static final Y8.t i(final AgentMarketDetailActivity agentMarketDetailActivity, final String str, boolean z10) {
        C1117a c1117a = agentMarketDetailActivity.binding;
        C1117a c1117a2 = null;
        if (c1117a == null) {
            kotlin.jvm.internal.p.A("binding");
            c1117a = null;
        }
        LinearLayout cardReadme = c1117a.cardReadme;
        kotlin.jvm.internal.p.h(cardReadme, "cardReadme");
        C1117a c1117a3 = agentMarketDetailActivity.binding;
        if (c1117a3 == null) {
            kotlin.jvm.internal.p.A("binding");
            c1117a3 = null;
        }
        TextView btnReadmeViewFull = c1117a3.btnReadmeViewFull;
        kotlin.jvm.internal.p.h(btnReadmeViewFull, "btnReadmeViewFull");
        SkillMarkwonFactoryKt.e(cardReadme, btnReadmeViewFull, z10);
        if (z10) {
            C1117a c1117a4 = agentMarketDetailActivity.binding;
            if (c1117a4 == null) {
                kotlin.jvm.internal.p.A("binding");
            } else {
                c1117a2 = c1117a4;
            }
            c1117a2.btnReadmeViewFull.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.agent.aispace.market.L
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AgentMarketDetailActivity$loadDetail$1.n(agentMarketDetailActivity, str, view);
                }
            });
        }
        return Y8.t.f7040a;
    }

    public static final void n(AgentMarketDetailActivity agentMarketDetailActivity, String str, View view) {
        new com.stepos.ailauncher.agent.skill.detail.p0(agentMarketDetailActivity, agentMarketDetailActivity.D0(), str).show();
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new AgentMarketDetailActivity$loadDetail$1(this.this$0, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((AgentMarketDetailActivity$loadDetail$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01d9  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r34) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 538
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.aispace.market.AgentMarketDetailActivity$loadDetail$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
