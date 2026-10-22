package com.stepos.ailauncher.chat.view;

import android.content.Context;
import android.view.LifecycleOwner;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.AgentUIConfig;
import com.stepos.ailauncher.chat.R$drawable;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001d\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroid/content/Context;", "context", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Lcom/stepos/agentframework/AgentUIConfig;", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;Landroidx/lifecycle/LifecycleOwner;)Lcom/stepos/agentframework/AgentUIConfig;", "chat_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class C6 {
    public static final AgentUIConfig a(Context context, LifecycleOwner lifecycleOwner) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(lifecycleOwner, "lifecycleOwner");
        AgentUIConfig.a aVarD = AgentUIConfig.INSTANCE.a().f(R$drawable.chat_receive_bg).g(R$drawable.float_chat_sent_bg).c(true).i(true).h(false).d(new C3026z(lifecycleOwner));
        C2760a4 c2760a4 = C2760a4.INSTANCE;
        return aVarD.e(new AgentUIConfig.MessageTextStyle(new AgentUIConfig.TextStyle(c2760a4.b(context, true), 16.0f, 1.28f), new AgentUIConfig.TextStyle(c2760a4.b(context, false), 16.0f, 1.28f))).a();
    }
}
