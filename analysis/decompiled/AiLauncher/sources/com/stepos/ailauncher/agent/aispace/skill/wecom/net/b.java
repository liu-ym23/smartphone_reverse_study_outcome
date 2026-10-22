package com.stepos.ailauncher.agent.aispace.skill.wecom.net;

import Ac.o;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import e9.InterfaceC4014c;
import kotlin.Metadata;
import tb.AbstractC5531D;
import yc.v;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b`\u0018\u0000 \u000e2\u00020\u0001:\u0001\tJ6\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\b\u0001\u0010\u0006\u001a\u00020\u0005H§@¢\u0006\u0004\b\t\u0010\nJ6\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\b\u0001\u0010\u0006\u001a\u00020\u000bH§@¢\u0006\u0004\b\f\u0010\r¨\u0006\u000fÀ\u0006\u0003"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/skill/wecom/net/b;", "", "", "authorization", DidiCardProvider.KEY_TRACE_ID, "Lcom/stepos/ailauncher/agent/aispace/skill/wecom/net/g;", "body", "Lyc/v;", "Ltb/D;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Ljava/lang/String;Lcom/stepos/ailauncher/agent/aispace/skill/wecom/net/g;Le9/c;)Ljava/lang/Object;", "Lcom/stepos/ailauncher/agent/aispace/skill/wecom/net/k;", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;Ljava/lang/String;Lcom/stepos/ailauncher/agent/aispace/skill/wecom/net/k;Le9/c;)Ljava/lang/Object;", "Companion", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface b {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final String HEADER_TRACE_ID = "Trace-Id";
    public static final String PATH_PREFIX = "step.agi.botmsg.BotMsg/";

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/skill/wecom/net/b$a;", "", "<init>", "()V", "", "PATH_PREFIX", "Ljava/lang/String;", "HEADER_TRACE_ID", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.agent.aispace.skill.wecom.net.b$a, reason: from kotlin metadata */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final String HEADER_TRACE_ID = "Trace-Id";
        public static final String PATH_PREFIX = "step.agi.botmsg.BotMsg/";
    }

    @o("step.agi.botmsg.BotMsg/WecomConnect")
    Object a(@Ac.i("Authorization") String str, @Ac.i("Trace-Id") String str2, @Ac.a WecomConnectBody wecomConnectBody, InterfaceC4014c<? super v<AbstractC5531D>> interfaceC4014c);

    @o("step.agi.botmsg.BotMsg/WecomConnectStatus")
    Object b(@Ac.i("Authorization") String str, @Ac.i("Trace-Id") String str2, @Ac.a WecomStatusBody wecomStatusBody, InterfaceC4014c<? super v<AbstractC5531D>> interfaceC4014c);
}
