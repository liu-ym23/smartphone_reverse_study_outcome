package com.bytedance.android.gamecp.business.download.custommade.bean;

import com.larus.dora.api.model.FlowDoraWifiScene;
import r27.a;

/* JADX INFO: loaded from: classes44.dex */
public final enum InstallFailReason extends Enum<InstallFailReason> {
    public static final InstallFailReason OTHER = null;
    public static final InstallFailReason STATUS_FAILURE = null;
    public static final InstallFailReason STATUS_FAILURE_ABORTED_HAS_PERMISSION = null;
    public static final InstallFailReason STATUS_FAILURE_ABORTED_NO_PERMISSION = null;
    public static final InstallFailReason STATUS_FAILURE_BLOCKED = null;
    public static final InstallFailReason STATUS_FAILURE_CONFIRM_ERROR = null;
    public static final InstallFailReason STATUS_FAILURE_CONFLICT = null;
    public static final InstallFailReason STATUS_FAILURE_INCOMPATIBLE = null;
    public static final InstallFailReason STATUS_FAILURE_INVALID = null;
    public static final InstallFailReason STATUS_FAILURE_PREPARE_CHECK_RETURN = null;
    public static final InstallFailReason STATUS_FAILURE_PREPARE_RETURN = null;
    public static final InstallFailReason STATUS_FAILURE_SESSION_COMMIT_IN_BG_FAIL = null;
    public static final InstallFailReason STATUS_FAILURE_SESSION_ERROR = null;
    public static final InstallFailReason STATUS_FAILURE_START_ACTIVITY = null;
    public static final InstallFailReason STATUS_FAILURE_STORAGE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ InstallFailReason[] f52642a = null;
    public final int failureCode;

    static {
        InstallFailReason r100 = new InstallFailReason("STATUS_FAILURE", 0, 90001);
        STATUS_FAILURE = r100;
        InstallFailReason r101 = new InstallFailReason("STATUS_FAILURE_BLOCKED", 1, 90002);
        STATUS_FAILURE_BLOCKED = r101;
        InstallFailReason r102 = new InstallFailReason("STATUS_FAILURE_ABORTED_HAS_PERMISSION", 2, 90003);
        STATUS_FAILURE_ABORTED_HAS_PERMISSION = r102;
        InstallFailReason r103 = new InstallFailReason("STATUS_FAILURE_ABORTED_NO_PERMISSION", 3, 90004);
        STATUS_FAILURE_ABORTED_NO_PERMISSION = r103;
        InstallFailReason r104 = new InstallFailReason("STATUS_FAILURE_INVALID", 4, 90005);
        STATUS_FAILURE_INVALID = r104;
        InstallFailReason r105 = new InstallFailReason("STATUS_FAILURE_CONFLICT", 5, 90006);
        STATUS_FAILURE_CONFLICT = r105;
        InstallFailReason r110 = new InstallFailReason("STATUS_FAILURE_STORAGE", 6, 90007);
        STATUS_FAILURE_STORAGE = r110;
        InstallFailReason r111 = new InstallFailReason("STATUS_FAILURE_INCOMPATIBLE", 7, 90008);
        STATUS_FAILURE_INCOMPATIBLE = r111;
        InstallFailReason r112 = new InstallFailReason("STATUS_FAILURE_START_ACTIVITY", 8, 90011);
        STATUS_FAILURE_START_ACTIVITY = r112;
        InstallFailReason r113 = new InstallFailReason("STATUS_FAILURE_CONFIRM_ERROR", 9, 90012);
        STATUS_FAILURE_CONFIRM_ERROR = r113;
        InstallFailReason r114 = new InstallFailReason("STATUS_FAILURE_SESSION_ERROR", 10, 90013);
        STATUS_FAILURE_SESSION_ERROR = r114;
        InstallFailReason r106 = new InstallFailReason("STATUS_FAILURE_PREPARE_RETURN", 11, 90014);
        STATUS_FAILURE_PREPARE_RETURN = r106;
        InstallFailReason r107 = new InstallFailReason("STATUS_FAILURE_PREPARE_CHECK_RETURN", 12, 90015);
        STATUS_FAILURE_PREPARE_CHECK_RETURN = r107;
        InstallFailReason r115 = new InstallFailReason("STATUS_FAILURE_SESSION_COMMIT_IN_BG_FAIL", 13, 90015);
        STATUS_FAILURE_SESSION_COMMIT_IN_BG_FAIL = r115;
        InstallFailReason r108 = new InstallFailReason(FlowDoraWifiScene.OTHER, 14, 90000);
        OTHER = r108;
        f52642a = new InstallFailReason[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r106, r107, r115, r108};
    }

    public static InstallFailReason[] values() {
        return (InstallFailReason[]) f52642a.clone();
    }

    public static InstallFailReason valueOf(String r100) {
        return (InstallFailReason) a.a(InstallFailReason.class, r100);
    }

    public InstallFailReason(String r100, int r101, int r102) {
        super(r100, r101);
        this.failureCode = r102;
    }
}
