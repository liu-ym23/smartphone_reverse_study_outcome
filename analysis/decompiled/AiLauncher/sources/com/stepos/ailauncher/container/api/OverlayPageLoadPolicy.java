package com.stepos.ailauncher.container.api;

import h9.InterfaceC4149a;
import kotlin.Metadata;
import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/stepos/ailauncher/container/api/OverlayPageLoadPolicy;", "", "<init>", "(Ljava/lang/String;I)V", "IMMEDIATE", "LAZY_ON_RESUME", "container_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class OverlayPageLoadPolicy {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ OverlayPageLoadPolicy[] $VALUES;
    public static final OverlayPageLoadPolicy IMMEDIATE = new OverlayPageLoadPolicy("IMMEDIATE", 0);
    public static final OverlayPageLoadPolicy LAZY_ON_RESUME = new OverlayPageLoadPolicy("LAZY_ON_RESUME", 1);

    private static final /* synthetic */ OverlayPageLoadPolicy[] $values() {
        return new OverlayPageLoadPolicy[]{IMMEDIATE, LAZY_ON_RESUME};
    }

    static {
        OverlayPageLoadPolicy[] overlayPageLoadPolicyArr$values = $values();
        $VALUES = overlayPageLoadPolicyArr$values;
        $ENTRIES = a.a(overlayPageLoadPolicyArr$values);
    }

    private OverlayPageLoadPolicy(String str, int i10) {
    }

    public static InterfaceC4149a<OverlayPageLoadPolicy> getEntries() {
        return $ENTRIES;
    }

    public static OverlayPageLoadPolicy valueOf(String str) {
        return (OverlayPageLoadPolicy) Enum.valueOf(OverlayPageLoadPolicy.class, str);
    }

    public static OverlayPageLoadPolicy[] values() {
        return (OverlayPageLoadPolicy[]) $VALUES.clone();
    }
}
