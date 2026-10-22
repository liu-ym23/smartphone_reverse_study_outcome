package com.stepos.ailauncher.common.permission;

import h9.InterfaceC4149a;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/stepos/ailauncher/common/permission/PermissionLaunchKind;", "", "<init>", "(Ljava/lang/String;I)V", "IN_HOST_TASK", "NEW_TASK_ANCHORED", "permission_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PermissionLaunchKind {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ PermissionLaunchKind[] $VALUES;
    public static final PermissionLaunchKind IN_HOST_TASK = new PermissionLaunchKind("IN_HOST_TASK", 0);
    public static final PermissionLaunchKind NEW_TASK_ANCHORED = new PermissionLaunchKind("NEW_TASK_ANCHORED", 1);

    private static final /* synthetic */ PermissionLaunchKind[] $values() {
        return new PermissionLaunchKind[]{IN_HOST_TASK, NEW_TASK_ANCHORED};
    }

    static {
        PermissionLaunchKind[] permissionLaunchKindArr$values = $values();
        $VALUES = permissionLaunchKindArr$values;
        $ENTRIES = kotlin.enums.a.a(permissionLaunchKindArr$values);
    }

    private PermissionLaunchKind(String str, int i10) {
    }

    public static InterfaceC4149a<PermissionLaunchKind> getEntries() {
        return $ENTRIES;
    }

    public static PermissionLaunchKind valueOf(String str) {
        return (PermissionLaunchKind) Enum.valueOf(PermissionLaunchKind.class, str);
    }

    public static PermissionLaunchKind[] values() {
        return (PermissionLaunchKind[]) $VALUES.clone();
    }
}
