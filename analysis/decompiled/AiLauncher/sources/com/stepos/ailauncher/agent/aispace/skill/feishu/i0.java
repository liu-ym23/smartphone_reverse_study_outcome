package com.stepos.ailauncher.agent.aispace.skill.feishu;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/skill/feishu/i0;", "", "<init>", "()V", "Lcom/stepos/ailauncher/agent/aispace/skill/feishu/h0;", Const.INTENT_KEY_APIKEY, "()Lcom/stepos/ailauncher/agent/aispace/skill/feishu/h0;", "impl", "Lcom/stepos/ailauncher/agent/aispace/skill/feishu/h0;", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class i0 {
    public static final i0 INSTANCE = new i0();
    private static volatile h0 impl = new FakeFeishuConnector();

    public final h0 a() {
        return impl;
    }
}
