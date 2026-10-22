package com.stepos.ailauncher.common.permission;

import h9.InterfaceC4149a;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/stepos/ailauncher/common/permission/SceneRequestMode;", "", "<init>", "(Ljava/lang/String;I)V", "ON_DEMAND", "ONCE", "permission_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SceneRequestMode {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ SceneRequestMode[] $VALUES;
    public static final SceneRequestMode ON_DEMAND = new SceneRequestMode("ON_DEMAND", 0);
    public static final SceneRequestMode ONCE = new SceneRequestMode("ONCE", 1);

    private static final /* synthetic */ SceneRequestMode[] $values() {
        return new SceneRequestMode[]{ON_DEMAND, ONCE};
    }

    static {
        SceneRequestMode[] sceneRequestModeArr$values = $values();
        $VALUES = sceneRequestModeArr$values;
        $ENTRIES = kotlin.enums.a.a(sceneRequestModeArr$values);
    }

    private SceneRequestMode(String str, int i10) {
    }

    public static InterfaceC4149a<SceneRequestMode> getEntries() {
        return $ENTRIES;
    }

    public static SceneRequestMode valueOf(String str) {
        return (SceneRequestMode) Enum.valueOf(SceneRequestMode.class, str);
    }

    public static SceneRequestMode[] values() {
        return (SceneRequestMode[]) $VALUES.clone();
    }
}
