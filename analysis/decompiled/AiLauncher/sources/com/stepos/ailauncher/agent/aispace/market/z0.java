package com.stepos.ailauncher.agent.aispace.market;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.agent.aispace.market.data.AgentSkillBean;
import com.stepos.ailauncher.agent.skill.SkillStatus;
import com.stepos.ailauncher.contract.model.MarketAgentBrief;
import com.stepos.ailauncher.contract.model.SkillItemBrief;
import java.util.Locale;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001b\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0013\u0010\t\u001a\u00020\u0001*\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\n\u001a\u0013\u0010\r\u001a\u00020\f*\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000e\u001a\u0013\u0010\u0011\u001a\u00020\u0010*\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012\"\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/market/data/e;", "", "f", "(Lcom/stepos/ailauncher/agent/aispace/market/data/e;)Z", "testing", "Lcom/stepos/ailauncher/contract/model/SkillItemBrief;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Lcom/stepos/ailauncher/agent/aispace/market/data/e;Z)Lcom/stepos/ailauncher/contract/model/SkillItemBrief;", "Lcom/stepos/ailauncher/agent/skill/SkillStatus;", "e", "(Lcom/stepos/ailauncher/agent/skill/SkillStatus;)Z", "Lcom/stepos/ailauncher/contract/model/MarketAgentBrief;", "Lcom/stepos/ailauncher/agent/aispace/market/AgentMarketItem;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Lcom/stepos/ailauncher/contract/model/MarketAgentBrief;)Lcom/stepos/ailauncher/agent/aispace/market/AgentMarketItem;", "Lcom/stepos/ailauncher/agent/aispace/market/data/g;", "Lcom/stepos/ailauncher/contract/model/MarketAppBrief;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Lcom/stepos/ailauncher/agent/aispace/market/data/g;)Lcom/stepos/ailauncher/contract/model/MarketAppBrief;", "", "TAG", "Ljava/lang/String;", "agent_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class z0 {
    private static final String TAG = "AgentMarketSvc";

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SkillStatus.values().length];
            try {
                iArr[SkillStatus.INSTALLED_ENABLED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SkillStatus.INSTALLED_DISABLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SkillStatus.INSTALLED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[SkillStatus.CONNECTED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[SkillStatus.DISCONNECTED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final boolean e(SkillStatus skillStatus) {
        int i10 = a.$EnumSwitchMapping$0[skillStatus.ordinal()];
        return i10 == 1 || i10 == 2 || i10 == 3 || i10 == 4 || i10 == 5;
    }

    public static final boolean f(AgentSkillBean agentSkillBean) {
        String lowerCase = agentSkillBean.getStatus().toLowerCase(Locale.ROOT);
        kotlin.jvm.internal.p.h(lowerCase, "toLowerCase(...)");
        return agentSkillBean.getInstallStatus() == 1 || kotlin.jvm.internal.p.d(lowerCase, x5.d.EXTRA_ENABLED) || kotlin.jvm.internal.p.d(lowerCase, "disabled") || kotlin.jvm.internal.p.d(lowerCase, "installed") || kotlin.jvm.internal.p.d(lowerCase, "connected");
    }

    public static final SkillItemBrief g(AgentSkillBean agentSkillBean, boolean z10) {
        String name = agentSkillBean.getName();
        if (La.H.x0(name)) {
            name = agentSkillBean.getId();
        }
        String str = name;
        String displayName = agentSkillBean.getDisplayName();
        String description = agentSkillBean.getDescription();
        boolean zF = f(agentSkillBean);
        String icon = agentSkillBean.getIcon();
        String str2 = icon == null ? "" : icon;
        String version = agentSkillBean.getVersion();
        String installVersion = agentSkillBean.getInstallVersion();
        boolean z11 = agentSkillBean.getNeedUpdate() == 1;
        String env = agentSkillBean.getEnv();
        return new SkillItemBrief(str, displayName, description, zF, str2, version, "", installVersion, z11, z10, false, env == null ? "" : env, 1024, null);
    }

    public static final AgentMarketItem h(MarketAgentBrief marketAgentBrief) {
        return new AgentMarketItem(marketAgentBrief.getAssetId(), marketAgentBrief.getReversionId(), marketAgentBrief.getVersion(), marketAgentBrief.getName(), marketAgentBrief.getDescription(), marketAgentBrief.getDeveloper(), marketAgentBrief.getDownloadCount(), marketAgentBrief.getInstallVersion(), marketAgentBrief.getNeedUpdate(), marketAgentBrief.getInstalled() ? AgentMarketStatus.INSTALLED_ENABLED : AgentMarketStatus.NOT_INSTALLED, marketAgentBrief.getIconUrl(), marketAgentBrief.getTesting(), marketAgentBrief.getEnv());
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final com.stepos.ailauncher.contract.model.MarketAppBrief i(com.stepos.ailauncher.agent.aispace.market.data.AppItemDto r10) {
        /*
            java.lang.String r1 = r10.getAppId()
            java.lang.String r0 = r10.getDisplayName()
            java.lang.String r2 = ""
            if (r0 == 0) goto L15
            boolean r3 = La.H.x0(r0)
            if (r3 == 0) goto L13
            r0 = 0
        L13:
            if (r0 != 0) goto L1c
        L15:
            java.lang.String r0 = r10.getName()
            if (r0 != 0) goto L1c
            r0 = r2
        L1c:
            java.lang.String r3 = r10.getDescription()
            if (r3 != 0) goto L23
            r3 = r2
        L23:
            java.lang.String r4 = r10.getVersion()
            if (r4 != 0) goto L2a
            r4 = r2
        L2a:
            java.lang.String r5 = r10.getAppType()
            if (r5 != 0) goto L31
            r5 = r2
        L31:
            java.lang.String r6 = r10.getPackageName()
            if (r6 != 0) goto L38
            r6 = r2
        L38:
            java.lang.String r7 = r10.getH5Url()
            if (r7 != 0) goto L3f
            r7 = r2
        L3f:
            java.lang.String r8 = r10.getIcon()
            if (r8 != 0) goto L46
            r8 = r2
        L46:
            java.lang.String r10 = r10.getEnv()
            if (r10 != 0) goto L4f
            r9 = r2
        L4d:
            r2 = r0
            goto L51
        L4f:
            r9 = r10
            goto L4d
        L51:
            com.stepos.ailauncher.contract.model.MarketAppBrief r0 = new com.stepos.ailauncher.contract.model.MarketAppBrief
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.agent.aispace.market.z0.i(com.stepos.ailauncher.agent.aispace.market.data.g):com.stepos.ailauncher.contract.model.MarketAppBrief");
    }
}
