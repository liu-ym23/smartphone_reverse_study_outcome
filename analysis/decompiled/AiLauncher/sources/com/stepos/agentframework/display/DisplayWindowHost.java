package com.stepos.agentframework.display;

import com.stepos.core.download.ModelFlowMeta;
import h9.InterfaceC4149a;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/agentframework/display/DisplayWindowHost;", "", "<init>", "(Ljava/lang/String;I)V", "OVERLAY", "ACTIVITY", ModelFlowMeta.PLAN_NONE, "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DisplayWindowHost {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ DisplayWindowHost[] $VALUES;
    public static final DisplayWindowHost OVERLAY = new DisplayWindowHost("OVERLAY", 0);
    public static final DisplayWindowHost ACTIVITY = new DisplayWindowHost("ACTIVITY", 1);
    public static final DisplayWindowHost NONE = new DisplayWindowHost(ModelFlowMeta.PLAN_NONE, 2);

    private static final /* synthetic */ DisplayWindowHost[] $values() {
        return new DisplayWindowHost[]{OVERLAY, ACTIVITY, NONE};
    }

    static {
        DisplayWindowHost[] displayWindowHostArr$values = $values();
        $VALUES = displayWindowHostArr$values;
        $ENTRIES = kotlin.enums.a.a(displayWindowHostArr$values);
    }

    private DisplayWindowHost(String str, int i10) {
    }

    public static InterfaceC4149a<DisplayWindowHost> getEntries() {
        return $ENTRIES;
    }

    public static DisplayWindowHost valueOf(String str) {
        return (DisplayWindowHost) Enum.valueOf(DisplayWindowHost.class, str);
    }

    public static DisplayWindowHost[] values() {
        return (DisplayWindowHost[]) $VALUES.clone();
    }
}
