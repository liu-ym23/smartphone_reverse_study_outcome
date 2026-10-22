package com.stepos.agentframework.display;

import h9.InterfaceC4149a;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/stepos/agentframework/display/OverlayRefreshPriority;", "", "rank", "", "<init>", "(Ljava/lang/String;II)V", "getRank", "()I", "CONTENT", "RECORDING", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class OverlayRefreshPriority {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ OverlayRefreshPriority[] $VALUES;
    public static final OverlayRefreshPriority CONTENT = new OverlayRefreshPriority("CONTENT", 0, 20);
    public static final OverlayRefreshPriority RECORDING = new OverlayRefreshPriority("RECORDING", 1, 30);
    private final int rank;

    private static final /* synthetic */ OverlayRefreshPriority[] $values() {
        return new OverlayRefreshPriority[]{CONTENT, RECORDING};
    }

    static {
        OverlayRefreshPriority[] overlayRefreshPriorityArr$values = $values();
        $VALUES = overlayRefreshPriorityArr$values;
        $ENTRIES = kotlin.enums.a.a(overlayRefreshPriorityArr$values);
    }

    private OverlayRefreshPriority(String str, int i10, int i11) {
        this.rank = i11;
    }

    public static InterfaceC4149a<OverlayRefreshPriority> getEntries() {
        return $ENTRIES;
    }

    public static OverlayRefreshPriority valueOf(String str) {
        return (OverlayRefreshPriority) Enum.valueOf(OverlayRefreshPriority.class, str);
    }

    public static OverlayRefreshPriority[] values() {
        return (OverlayRefreshPriority[]) $VALUES.clone();
    }

    public final int getRank() {
        return this.rank;
    }
}
