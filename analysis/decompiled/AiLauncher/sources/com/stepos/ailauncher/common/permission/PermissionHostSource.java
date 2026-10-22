package com.stepos.ailauncher.common.permission;

import h9.InterfaceC4149a;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/stepos/ailauncher/common/permission/PermissionHostSource;", "", "<init>", "(Ljava/lang/String;I)V", "CONTEXT_ACTIVITY", "REGISTERED_HOST", "ANCHOR_FOREIGN", "INDEPENDENT", "permission_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PermissionHostSource {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ PermissionHostSource[] $VALUES;
    public static final PermissionHostSource CONTEXT_ACTIVITY = new PermissionHostSource("CONTEXT_ACTIVITY", 0);
    public static final PermissionHostSource REGISTERED_HOST = new PermissionHostSource("REGISTERED_HOST", 1);
    public static final PermissionHostSource ANCHOR_FOREIGN = new PermissionHostSource("ANCHOR_FOREIGN", 2);
    public static final PermissionHostSource INDEPENDENT = new PermissionHostSource("INDEPENDENT", 3);

    private static final /* synthetic */ PermissionHostSource[] $values() {
        return new PermissionHostSource[]{CONTEXT_ACTIVITY, REGISTERED_HOST, ANCHOR_FOREIGN, INDEPENDENT};
    }

    static {
        PermissionHostSource[] permissionHostSourceArr$values = $values();
        $VALUES = permissionHostSourceArr$values;
        $ENTRIES = kotlin.enums.a.a(permissionHostSourceArr$values);
    }

    private PermissionHostSource(String str, int i10) {
    }

    public static InterfaceC4149a<PermissionHostSource> getEntries() {
        return $ENTRIES;
    }

    public static PermissionHostSource valueOf(String str) {
        return (PermissionHostSource) Enum.valueOf(PermissionHostSource.class, str);
    }

    public static PermissionHostSource[] values() {
        return (PermissionHostSource[]) $VALUES.clone();
    }
}
