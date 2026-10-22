package com.bes.sdk.utils;

import r27.a;

/* JADX INFO: loaded from: classes39.dex */
public final enum StatusCode extends Enum<StatusCode> {
    public static final StatusCode STATUS_CANCEL = null;
    public static final StatusCode STATUS_FAIL = null;
    public static final StatusCode STATUS_SUCCESS = null;
    public static final StatusCode STATUS_TIMEOUT = null;
    public static final StatusCode STATUS_UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ StatusCode[] f33673a = null;
    private String mDescription;
    private int mValue;

    static {
        StatusCode r100 = new StatusCode("STATUS_UNKNOWN", 0, -1, "Status Unknown");
        STATUS_UNKNOWN = r100;
        StatusCode r101 = new StatusCode("STATUS_SUCCESS", 1, 0, "Status Success");
        STATUS_SUCCESS = r101;
        StatusCode r102 = new StatusCode("STATUS_TIMEOUT", 2, 1, "Status Timeout");
        STATUS_TIMEOUT = r102;
        StatusCode r103 = new StatusCode("STATUS_CANCEL", 3, 2, "Status Canceled");
        STATUS_CANCEL = r103;
        StatusCode r104 = new StatusCode("STATUS_FAIL", 4, 3, "Status Failed");
        STATUS_FAIL = r104;
        f33673a = new StatusCode[]{r100, r101, r102, r103, r104};
    }

    public static StatusCode[] values() {
        return (StatusCode[]) f33673a.clone();
    }

    public String getDescription() {
        return this.mDescription;
    }

    public int getValue() {
        return this.mValue;
    }

    public static StatusCode valueOf(String r100) {
        return (StatusCode) a.a(StatusCode.class, r100);
    }

    public StatusCode(String r100, int r101, int r102, String r103) {
        super(r100, r101);
        this.mValue = r102;
        this.mDescription = r103;
    }
}
