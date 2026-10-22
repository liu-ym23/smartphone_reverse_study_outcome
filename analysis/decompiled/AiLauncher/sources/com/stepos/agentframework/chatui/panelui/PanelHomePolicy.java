package com.stepos.agentframework.chatui.panelui;

import h9.InterfaceC4149a;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/agentframework/chatui/panelui/PanelHomePolicy;", "", "<init>", "(Ljava/lang/String;I)V", "CLEANUP_THEN_PANEL", "DISMISS_TOP_ONLY", "KEEP_AND_CONSUME", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PanelHomePolicy {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ PanelHomePolicy[] $VALUES;
    public static final PanelHomePolicy CLEANUP_THEN_PANEL = new PanelHomePolicy("CLEANUP_THEN_PANEL", 0);
    public static final PanelHomePolicy DISMISS_TOP_ONLY = new PanelHomePolicy("DISMISS_TOP_ONLY", 1);
    public static final PanelHomePolicy KEEP_AND_CONSUME = new PanelHomePolicy("KEEP_AND_CONSUME", 2);

    private static final /* synthetic */ PanelHomePolicy[] $values() {
        return new PanelHomePolicy[]{CLEANUP_THEN_PANEL, DISMISS_TOP_ONLY, KEEP_AND_CONSUME};
    }

    static {
        PanelHomePolicy[] panelHomePolicyArr$values = $values();
        $VALUES = panelHomePolicyArr$values;
        $ENTRIES = kotlin.enums.a.a(panelHomePolicyArr$values);
    }

    private PanelHomePolicy(String str, int i10) {
    }

    public static InterfaceC4149a<PanelHomePolicy> getEntries() {
        return $ENTRIES;
    }

    public static PanelHomePolicy valueOf(String str) {
        return (PanelHomePolicy) Enum.valueOf(PanelHomePolicy.class, str);
    }

    public static PanelHomePolicy[] values() {
        return (PanelHomePolicy[]) $VALUES.clone();
    }
}
