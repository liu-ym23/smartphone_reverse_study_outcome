package com.stepos.agentframework.adapter.netcore;

import K7.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/stepos/agentframework/adapter/netcore/ApiType;", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;I)V", "COZE", "DIFY", "BFF", "OPENCLAW", "AGENT_SPACE", "AGENTBUS", "netcore_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ApiType {
    private static final /* synthetic */ a $ENTRIES;
    private static final /* synthetic */ ApiType[] $VALUES;
    public static final ApiType COZE = new ApiType("COZE", 0);
    public static final ApiType DIFY = new ApiType("DIFY", 1);
    public static final ApiType BFF = new ApiType("BFF", 2);
    public static final ApiType OPENCLAW = new ApiType("OPENCLAW", 3);
    public static final ApiType AGENT_SPACE = new ApiType("AGENT_SPACE", 4);
    public static final ApiType AGENTBUS = new ApiType("AGENTBUS", 5);

    private static final /* synthetic */ ApiType[] $values() {
        return new ApiType[]{COZE, DIFY, BFF, OPENCLAW, AGENT_SPACE, AGENTBUS};
    }

    static {
        ApiType[] apiTypeArr$values = $values();
        $VALUES = apiTypeArr$values;
        $ENTRIES = kotlin.enums.a.a(apiTypeArr$values);
    }

    private ApiType(String str, int i) {
    }

    public static a getEntries() {
        return $ENTRIES;
    }

    public static ApiType valueOf(String str) {
        return (ApiType) Enum.valueOf(ApiType.class, str);
    }

    public static ApiType[] values() {
        return (ApiType[]) $VALUES.clone();
    }
}
