package com.stepos.ailauncher.chat.panelui;

import h9.InterfaceC4149a;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/stepos/ailauncher/chat/panelui/PanelLayerRecentsPhase;", "", "<init>", "(Ljava/lang/String;I)V", "PEEK", "OVERVIEW", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PanelLayerRecentsPhase {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ PanelLayerRecentsPhase[] $VALUES;
    public static final PanelLayerRecentsPhase PEEK = new PanelLayerRecentsPhase("PEEK", 0);
    public static final PanelLayerRecentsPhase OVERVIEW = new PanelLayerRecentsPhase("OVERVIEW", 1);

    private static final /* synthetic */ PanelLayerRecentsPhase[] $values() {
        return new PanelLayerRecentsPhase[]{PEEK, OVERVIEW};
    }

    static {
        PanelLayerRecentsPhase[] panelLayerRecentsPhaseArr$values = $values();
        $VALUES = panelLayerRecentsPhaseArr$values;
        $ENTRIES = kotlin.enums.a.a(panelLayerRecentsPhaseArr$values);
    }

    private PanelLayerRecentsPhase(String str, int i10) {
    }

    public static InterfaceC4149a<PanelLayerRecentsPhase> getEntries() {
        return $ENTRIES;
    }

    public static PanelLayerRecentsPhase valueOf(String str) {
        return (PanelLayerRecentsPhase) Enum.valueOf(PanelLayerRecentsPhase.class, str);
    }

    public static PanelLayerRecentsPhase[] values() {
        return (PanelLayerRecentsPhase[]) $VALUES.clone();
    }
}
