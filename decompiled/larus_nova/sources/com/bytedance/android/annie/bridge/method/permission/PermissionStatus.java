package com.bytedance.android.annie.bridge.method.permission;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/annie/bridge/method/permission/PermissionStatus;", "", "PERMITTED", "DENIED", "UNDETERMINED", "RESTRICTED", "annie_release"}, k = 1, mv = {1, 4, 3})
public final enum PermissionStatus extends Enum<PermissionStatus> {
    public static final PermissionStatus DENIED = null;
    public static final PermissionStatus PERMITTED = null;
    public static final PermissionStatus RESTRICTED = null;
    public static final PermissionStatus UNDETERMINED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PermissionStatus[] f38764a = null;

    public static PermissionStatus valueOf(String r100) {
        return (PermissionStatus) r27.a.a(PermissionStatus.class, r100);
    }

    public static PermissionStatus[] values() {
        return (PermissionStatus[]) f38764a.clone();
    }

    static {
        PermissionStatus r100 = new PermissionStatus("PERMITTED", 0);
        PERMITTED = r100;
        PermissionStatus r101 = new PermissionStatus("DENIED", 1);
        DENIED = r101;
        PermissionStatus r102 = new PermissionStatus("UNDETERMINED", 2);
        UNDETERMINED = r102;
        PermissionStatus r103 = new PermissionStatus("RESTRICTED", 3);
        RESTRICTED = r103;
        f38764a = new PermissionStatus[]{r100, r101, r102, r103};
    }

    public PermissionStatus(String r100, int r101) {
        super(r100, r101);
    }
}
