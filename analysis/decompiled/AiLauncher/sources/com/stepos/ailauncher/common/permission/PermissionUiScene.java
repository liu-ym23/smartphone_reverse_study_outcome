package com.stepos.ailauncher.common.permission;

import h9.InterfaceC4149a;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/stepos/ailauncher/common/permission/PermissionUiScene;", "", "<init>", "(Ljava/lang/String;I)V", "GENERIC_ACTIVITY", "MINUS_ONE_OVERLAY", "EXPRESS_CAPSULE", "WAKE_NO_PANEL", "permission_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PermissionUiScene {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ PermissionUiScene[] $VALUES;
    public static final PermissionUiScene GENERIC_ACTIVITY = new PermissionUiScene("GENERIC_ACTIVITY", 0);
    public static final PermissionUiScene MINUS_ONE_OVERLAY = new PermissionUiScene("MINUS_ONE_OVERLAY", 1);
    public static final PermissionUiScene EXPRESS_CAPSULE = new PermissionUiScene("EXPRESS_CAPSULE", 2);
    public static final PermissionUiScene WAKE_NO_PANEL = new PermissionUiScene("WAKE_NO_PANEL", 3);

    private static final /* synthetic */ PermissionUiScene[] $values() {
        return new PermissionUiScene[]{GENERIC_ACTIVITY, MINUS_ONE_OVERLAY, EXPRESS_CAPSULE, WAKE_NO_PANEL};
    }

    static {
        PermissionUiScene[] permissionUiSceneArr$values = $values();
        $VALUES = permissionUiSceneArr$values;
        $ENTRIES = kotlin.enums.a.a(permissionUiSceneArr$values);
    }

    private PermissionUiScene(String str, int i10) {
    }

    public static InterfaceC4149a<PermissionUiScene> getEntries() {
        return $ENTRIES;
    }

    public static PermissionUiScene valueOf(String str) {
        return (PermissionUiScene) Enum.valueOf(PermissionUiScene.class, str);
    }

    public static PermissionUiScene[] values() {
        return (PermissionUiScene[]) $VALUES.clone();
    }
}
