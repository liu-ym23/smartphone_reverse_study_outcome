package com.stepos.ailauncher.chat.panelui;

import h9.InterfaceC4149a;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/stepos/ailauncher/chat/panelui/PanelLayerDismissReason;", "", "<init>", "(Ljava/lang/String;I)V", "USER", "HOME", "OVERVIEW", "OWNER_DESTROY", "FACTORY", "WAKE", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PanelLayerDismissReason {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ PanelLayerDismissReason[] $VALUES;
    public static final PanelLayerDismissReason USER = new PanelLayerDismissReason("USER", 0);
    public static final PanelLayerDismissReason HOME = new PanelLayerDismissReason("HOME", 1);
    public static final PanelLayerDismissReason OVERVIEW = new PanelLayerDismissReason("OVERVIEW", 2);
    public static final PanelLayerDismissReason OWNER_DESTROY = new PanelLayerDismissReason("OWNER_DESTROY", 3);
    public static final PanelLayerDismissReason FACTORY = new PanelLayerDismissReason("FACTORY", 4);
    public static final PanelLayerDismissReason WAKE = new PanelLayerDismissReason("WAKE", 5);

    private static final /* synthetic */ PanelLayerDismissReason[] $values() {
        return new PanelLayerDismissReason[]{USER, HOME, OVERVIEW, OWNER_DESTROY, FACTORY, WAKE};
    }

    static {
        PanelLayerDismissReason[] panelLayerDismissReasonArr$values = $values();
        $VALUES = panelLayerDismissReasonArr$values;
        $ENTRIES = kotlin.enums.a.a(panelLayerDismissReasonArr$values);
    }

    private PanelLayerDismissReason(String str, int i10) {
    }

    public static InterfaceC4149a<PanelLayerDismissReason> getEntries() {
        return $ENTRIES;
    }

    public static PanelLayerDismissReason valueOf(String str) {
        return (PanelLayerDismissReason) Enum.valueOf(PanelLayerDismissReason.class, str);
    }

    public static PanelLayerDismissReason[] values() {
        return (PanelLayerDismissReason[]) $VALUES.clone();
    }
}
