package com.stepos.ailauncher.common.permission;

import h9.InterfaceC4149a;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/stepos/ailauncher/common/permission/PermissionLaunchPolicy;", "", "<init>", "(Ljava/lang/String;I)V", "AUTO", "INDEPENDENT_TASK", "permission_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PermissionLaunchPolicy {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ PermissionLaunchPolicy[] $VALUES;
    public static final PermissionLaunchPolicy AUTO = new PermissionLaunchPolicy("AUTO", 0);
    public static final PermissionLaunchPolicy INDEPENDENT_TASK = new PermissionLaunchPolicy("INDEPENDENT_TASK", 1);

    private static final /* synthetic */ PermissionLaunchPolicy[] $values() {
        return new PermissionLaunchPolicy[]{AUTO, INDEPENDENT_TASK};
    }

    static {
        PermissionLaunchPolicy[] permissionLaunchPolicyArr$values = $values();
        $VALUES = permissionLaunchPolicyArr$values;
        $ENTRIES = kotlin.enums.a.a(permissionLaunchPolicyArr$values);
    }

    private PermissionLaunchPolicy(String str, int i10) {
    }

    public static InterfaceC4149a<PermissionLaunchPolicy> getEntries() {
        return $ENTRIES;
    }

    public static PermissionLaunchPolicy valueOf(String str) {
        return (PermissionLaunchPolicy) Enum.valueOf(PermissionLaunchPolicy.class, str);
    }

    public static PermissionLaunchPolicy[] values() {
        return (PermissionLaunchPolicy[]) $VALUES.clone();
    }
}
