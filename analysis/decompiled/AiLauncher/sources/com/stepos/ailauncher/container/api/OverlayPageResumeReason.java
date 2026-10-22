package com.stepos.ailauncher.container.api;

import h9.InterfaceC4149a;
import kotlin.Metadata;
import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/ailauncher/container/api/OverlayPageResumeReason;", "", "<init>", "(Ljava/lang/String;I)V", "PAGE_SWITCH", "LAUNCHER_OPEN", "OVERLAY_ACTIVITY_RESUME", "container_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class OverlayPageResumeReason {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ OverlayPageResumeReason[] $VALUES;
    public static final OverlayPageResumeReason PAGE_SWITCH = new OverlayPageResumeReason("PAGE_SWITCH", 0);
    public static final OverlayPageResumeReason LAUNCHER_OPEN = new OverlayPageResumeReason("LAUNCHER_OPEN", 1);
    public static final OverlayPageResumeReason OVERLAY_ACTIVITY_RESUME = new OverlayPageResumeReason("OVERLAY_ACTIVITY_RESUME", 2);

    private static final /* synthetic */ OverlayPageResumeReason[] $values() {
        return new OverlayPageResumeReason[]{PAGE_SWITCH, LAUNCHER_OPEN, OVERLAY_ACTIVITY_RESUME};
    }

    static {
        OverlayPageResumeReason[] overlayPageResumeReasonArr$values = $values();
        $VALUES = overlayPageResumeReasonArr$values;
        $ENTRIES = a.a(overlayPageResumeReasonArr$values);
    }

    private OverlayPageResumeReason(String str, int i10) {
    }

    public static InterfaceC4149a<OverlayPageResumeReason> getEntries() {
        return $ENTRIES;
    }

    public static OverlayPageResumeReason valueOf(String str) {
        return (OverlayPageResumeReason) Enum.valueOf(OverlayPageResumeReason.class, str);
    }

    public static OverlayPageResumeReason[] values() {
        return (OverlayPageResumeReason[]) $VALUES.clone();
    }
}
