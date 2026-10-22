package com.stepos.ailauncher.container.api;

import h9.InterfaceC4149a;
import kotlin.Metadata;
import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/ailauncher/container/api/OverlayPageDestroyReason;", "", "<init>", "(Ljava/lang/String;I)V", "DESTROY", "RELAUNCH", "PAGE_LIST_CHANGED", "container_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class OverlayPageDestroyReason {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ OverlayPageDestroyReason[] $VALUES;
    public static final OverlayPageDestroyReason DESTROY = new OverlayPageDestroyReason("DESTROY", 0);
    public static final OverlayPageDestroyReason RELAUNCH = new OverlayPageDestroyReason("RELAUNCH", 1);
    public static final OverlayPageDestroyReason PAGE_LIST_CHANGED = new OverlayPageDestroyReason("PAGE_LIST_CHANGED", 2);

    private static final /* synthetic */ OverlayPageDestroyReason[] $values() {
        return new OverlayPageDestroyReason[]{DESTROY, RELAUNCH, PAGE_LIST_CHANGED};
    }

    static {
        OverlayPageDestroyReason[] overlayPageDestroyReasonArr$values = $values();
        $VALUES = overlayPageDestroyReasonArr$values;
        $ENTRIES = a.a(overlayPageDestroyReasonArr$values);
    }

    private OverlayPageDestroyReason(String str, int i10) {
    }

    public static InterfaceC4149a<OverlayPageDestroyReason> getEntries() {
        return $ENTRIES;
    }

    public static OverlayPageDestroyReason valueOf(String str) {
        return (OverlayPageDestroyReason) Enum.valueOf(OverlayPageDestroyReason.class, str);
    }

    public static OverlayPageDestroyReason[] values() {
        return (OverlayPageDestroyReason[]) $VALUES.clone();
    }
}
