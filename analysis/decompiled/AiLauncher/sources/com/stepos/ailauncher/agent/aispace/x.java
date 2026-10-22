package com.stepos.ailauncher.agent.aispace;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.adapter.agentbus.bff.ExternalAgent;
import com.stepos.ailauncher.agent.R$drawable;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/x;", "", "<init>", "()V", "", "agentType", "", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;)I", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)Ljava/lang/String;", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class x {
    public static final x INSTANCE = new x();

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ExternalAgent.values().length];
            try {
                iArr[ExternalAgent.CLAUDE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ExternalAgent.CODEX.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ExternalAgent.DEEPSEEK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ExternalAgent.DOUBAO.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ExternalAgent.STEPAI.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public final String a(String agentType) {
        String displayName;
        kotlin.jvm.internal.p.i(agentType, "agentType");
        ExternalAgent externalAgentB = ExternalAgent.INSTANCE.b(agentType);
        return (externalAgentB == null || (displayName = externalAgentB.getDisplayName()) == null) ? agentType : displayName;
    }

    public final int b(String agentType) {
        ExternalAgent externalAgentB = ExternalAgent.INSTANCE.b(agentType);
        int i10 = externalAgentB == null ? -1 : a.$EnumSwitchMapping$0[externalAgentB.ordinal()];
        if (i10 == -1) {
            return R$drawable.ic_agent_other;
        }
        if (i10 == 1) {
            return R$drawable.ic_agent_claude;
        }
        if (i10 == 2) {
            return R$drawable.ic_agent_codex;
        }
        if (i10 == 3) {
            return R$drawable.ic_agent_deepseek;
        }
        if (i10 == 4) {
            return R$drawable.ic_agent_doubao;
        }
        if (i10 == 5) {
            return R$drawable.ic_agent_stepai;
        }
        throw new NoWhenBranchMatchedException();
    }
}
