package com.stepos.mcp.sdk.base;

import androidx.core.app.NotificationCompat;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u000b2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/stepos/mcp/sdk/base/IToolHandler;", "", AppAgent.CONSTRUCT, "()V", "Lcom/stepos/mcp/sdk/base/BaseMCPService;", NotificationCompat.CATEGORY_SERVICE, "LC7/r;", "handlerTools", "(Lcom/stepos/mcp/sdk/base/BaseMCPService;)V", "", "abilityName", "Lcom/stepos/mcp/sdk/base/IAbility;", "getAbility", "(Ljava/lang/String;)Lcom/stepos/mcp/sdk/base/IAbility;", "sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class IToolHandler {
    public final IAbility<?, ?> getAbility(String abilityName) {
        k.f(abilityName, "abilityName");
        return AbilityManager.INSTANCE.getAbility(abilityName);
    }

    public abstract void handlerTools(BaseMCPService service);
}
