package com.stepos.stepclaw.runtime;

import com.stepos.stepclaw.SecurePrefs;
import i5.a;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/stepos/stepclaw/runtime/RootfsMode;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "(Ljava/lang/String;I)V", "MOUNTED", "step-runtime_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class RootfsMode {
    private static final /* synthetic */ a $ENTRIES;
    private static final /* synthetic */ RootfsMode[] $VALUES;
    public static final RootfsMode MOUNTED = new RootfsMode("MOUNTED", 0);

    private static final /* synthetic */ RootfsMode[] $values() {
        return new RootfsMode[]{MOUNTED};
    }

    static {
        RootfsMode[] rootfsModeArr$values = $values();
        $VALUES = rootfsModeArr$values;
        $ENTRIES = a.a.F(rootfsModeArr$values);
    }

    private RootfsMode(String str, int i8) {
    }

    public static a getEntries() {
        return $ENTRIES;
    }

    public static RootfsMode valueOf(String str) {
        return (RootfsMode) Enum.valueOf(RootfsMode.class, str);
    }

    public static RootfsMode[] values() {
        return (RootfsMode[]) $VALUES.clone();
    }
}
