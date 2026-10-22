package com.stepos.ailauncher.agent.aispace.skill.feishu.net;

import com.autonavi.aps.amapapi.config.Const;
import e9.InterfaceC4014c;
import kotlin.Metadata;
import tb.AbstractC5531D;
import yc.v;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b`\u0018\u0000 \f2\u00020\u0001:\u0001\tJ6\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\b\u0001\u0010\u0006\u001a\u00020\u0005H§@¢\u0006\u0004\b\t\u0010\nJ6\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0001\u0010\u0003\u001a\u00020\u00022\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\b\u0001\u0010\u0006\u001a\u00020\u0005H§@¢\u0006\u0004\b\u000b\u0010\n¨\u0006\rÀ\u0006\u0003"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/skill/feishu/net/d;", "", "", "authorization", "stepTraceId", "Lcom/stepos/ailauncher/agent/aispace/skill/feishu/net/l;", "body", "Lyc/v;", "Ltb/D;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Ljava/lang/String;Lcom/stepos/ailauncher/agent/aispace/skill/feishu/net/l;Le9/c;)Ljava/lang/Object;", Const.INTENT_KEY_PKGNAME, "Companion", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface d {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final String HEADER_TRACE_ID = "Step-Trace-Id";
    public static final String PATH_PREFIX = "task-engine/api/feishu";

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/skill/feishu/net/d$a;", "", "<init>", "()V", "", "PATH_PREFIX", "Ljava/lang/String;", "HEADER_TRACE_ID", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.agent.aispace.skill.feishu.net.d$a, reason: from kotlin metadata */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final String HEADER_TRACE_ID = "Step-Trace-Id";
        public static final String PATH_PREFIX = "task-engine/api/feishu";
    }

    @Ac.o("task-engine/api/feishu/connect")
    Object a(@Ac.i("Authorization") String str, @Ac.i("Step-Trace-Id") String str2, @Ac.a FeishuRequestBody feishuRequestBody, InterfaceC4014c<? super v<AbstractC5531D>> interfaceC4014c);

    @Ac.o("task-engine/api/feishu/status")
    Object b(@Ac.i("Authorization") String str, @Ac.i("Step-Trace-Id") String str2, @Ac.a FeishuRequestBody feishuRequestBody, InterfaceC4014c<? super v<AbstractC5531D>> interfaceC4014c);
}
