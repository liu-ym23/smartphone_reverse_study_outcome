package com.stepos.agentbus.generated;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/stepos/agentbus/generated/RestoreScope;", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;I)V", "MODEL", "FILES", "CRONJOBS", "CLAW", "ALL", "agentbus-client_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class RestoreScope {
    private static final /* synthetic */ K7.a $ENTRIES;
    private static final /* synthetic */ RestoreScope[] $VALUES;
    public static final RestoreScope MODEL = new RestoreScope("MODEL", 0);
    public static final RestoreScope FILES = new RestoreScope("FILES", 1);
    public static final RestoreScope CRONJOBS = new RestoreScope("CRONJOBS", 2);
    public static final RestoreScope CLAW = new RestoreScope("CLAW", 3);
    public static final RestoreScope ALL = new RestoreScope("ALL", 4);

    private static final /* synthetic */ RestoreScope[] $values() {
        return new RestoreScope[]{MODEL, FILES, CRONJOBS, CLAW, ALL};
    }

    static {
        RestoreScope[] restoreScopeArr$values = $values();
        $VALUES = restoreScopeArr$values;
        $ENTRIES = kotlin.enums.a.a(restoreScopeArr$values);
    }

    private RestoreScope(String str, int i) {
    }

    public static K7.a getEntries() {
        return $ENTRIES;
    }

    public static RestoreScope valueOf(String str) {
        return (RestoreScope) Enum.valueOf(RestoreScope.class, str);
    }

    public static RestoreScope[] values() {
        return (RestoreScope[]) $VALUES.clone();
    }
}
