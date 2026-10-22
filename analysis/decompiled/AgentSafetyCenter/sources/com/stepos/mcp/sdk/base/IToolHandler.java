package com.stepos.mcp.sdk.base;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class IToolHandler {
    public final IAbility<?, ?> getAbility(String str) {
        str.getClass();
        return AbilityManager.INSTANCE.getAbility(str);
    }

    public abstract void handlerTools(BaseMCPService baseMCPService);
}
