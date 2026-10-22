package com.bes.sdk.utils;

import r27.a;

/* JADX INFO: loaded from: classes39.dex */
public final enum OTAStatus extends Enum<OTAStatus> {
    public static final OTAStatus STATUS_CANCELED = null;
    public static final OTAStatus STATUS_FAILED = null;
    public static final OTAStatus STATUS_PAUSED = null;
    public static final OTAStatus STATUS_REBOOT = null;
    public static final OTAStatus STATUS_STARTED = null;
    public static final OTAStatus STATUS_SUCCEED = null;
    public static final OTAStatus STATUS_UNKNOWN = null;
    public static final OTAStatus STATUS_UPDATING = null;
    public static final OTAStatus STATUS_VERIFIED = null;
    public static final OTAStatus STATUS_VERIFYING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OTAStatus[] f33672a = null;
    private String mName;
    private int mValue;

    static {
        OTAStatus r100 = new OTAStatus("STATUS_UNKNOWN", 0, -1, "Status Unknown");
        STATUS_UNKNOWN = r100;
        OTAStatus r101 = new OTAStatus("STATUS_STARTED", 1, 0, "Status Started");
        STATUS_STARTED = r101;
        OTAStatus r102 = new OTAStatus("STATUS_UPDATING", 2, 1, "Status Updating");
        STATUS_UPDATING = r102;
        OTAStatus r103 = new OTAStatus("STATUS_PAUSED", 3, 2, "Status Paused");
        STATUS_PAUSED = r103;
        OTAStatus r104 = new OTAStatus("STATUS_CANCELED", 4, 3, "Status Canceled");
        STATUS_CANCELED = r104;
        OTAStatus r105 = new OTAStatus("STATUS_VERIFYING", 5, 4, "Status Verifying");
        STATUS_VERIFYING = r105;
        OTAStatus r110 = new OTAStatus("STATUS_VERIFIED", 6, 5, "Status Verifyed");
        STATUS_VERIFIED = r110;
        OTAStatus r111 = new OTAStatus("STATUS_FAILED", 7, 6, "Status Failed");
        STATUS_FAILED = r111;
        OTAStatus r112 = new OTAStatus("STATUS_SUCCEED", 8, 7, "Status Succeed");
        STATUS_SUCCEED = r112;
        OTAStatus r113 = new OTAStatus("STATUS_REBOOT", 9, 8, "Status Reboot");
        STATUS_REBOOT = r113;
        f33672a = new OTAStatus[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113};
    }

    public static OTAStatus[] values() {
        return (OTAStatus[]) f33672a.clone();
    }

    public String getName() {
        return this.mName;
    }

    public int getValue() {
        return this.mValue;
    }

    public static OTAStatus valueOf(String r100) {
        return (OTAStatus) a.a(OTAStatus.class, r100);
    }

    public OTAStatus(String r100, int r101, int r102, String r103) {
        super(r100, r101);
        this.mValue = r102;
        this.mName = r103;
    }
}
