package com.baidu.platform.comapi.longlink;

import r27.a;

/* JADX INFO: loaded from: classes39.dex */
public final enum ELongLinkStatus extends Enum<ELongLinkStatus> {
    private static final /* synthetic */ ELongLinkStatus[] $VALUES = null;
    public static final ELongLinkStatus CloudRestart = null;
    public static final ELongLinkStatus CloudStop = null;
    public static final ELongLinkStatus OK = null;
    public static final ELongLinkStatus ResultConnectError = null;
    public static final ELongLinkStatus ResultSendError = null;
    public static final ELongLinkStatus ResultServerError = null;
    public static final ELongLinkStatus ResultTimeout = null;
    public static final ELongLinkStatus SendDataLenLimited = null;
    public static final ELongLinkStatus SendFormatError = null;
    public static final ELongLinkStatus SendInvalidReqID = null;
    public static final ELongLinkStatus SendLimited = null;
    public static final ELongLinkStatus SendUnRegistered = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f32921a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f32922b;

    static {
        ELongLinkStatus r100 = new ELongLinkStatus("OK", 0, 0);
        OK = r100;
        ELongLinkStatus r101 = new ELongLinkStatus("SendFormatError", 1, r100.getStatusCode() + 1);
        SendFormatError = r101;
        ELongLinkStatus r102 = new ELongLinkStatus("SendUnRegistered", 2, r100.getStatusCode() + 2);
        SendUnRegistered = r102;
        ELongLinkStatus r103 = new ELongLinkStatus("SendLimited", 3, r100.getStatusCode() + 3);
        SendLimited = r103;
        ELongLinkStatus r104 = new ELongLinkStatus("SendDataLenLimited", 4, r100.getStatusCode() + 4);
        SendDataLenLimited = r104;
        ELongLinkStatus r105 = new ELongLinkStatus("SendInvalidReqID", 5, r100.getStatusCode() + 5);
        SendInvalidReqID = r105;
        ELongLinkStatus r110 = new ELongLinkStatus("ResultConnectError", 6, r100.getStatusCode() + 6);
        ResultConnectError = r110;
        ELongLinkStatus r111 = new ELongLinkStatus("ResultSendError", 7, r100.getStatusCode() + 7);
        ResultSendError = r111;
        ELongLinkStatus r112 = new ELongLinkStatus("ResultTimeout", 8, r100.getStatusCode() + 8);
        ResultTimeout = r112;
        ELongLinkStatus r113 = new ELongLinkStatus("ResultServerError", 9, r100.getStatusCode() + 9);
        ResultServerError = r113;
        ELongLinkStatus r106 = new ELongLinkStatus("CloudStop", 10, r100.getStatusCode() + 10);
        CloudStop = r106;
        ELongLinkStatus r107 = new ELongLinkStatus("CloudRestart", 11, r100.getStatusCode() + 11);
        CloudRestart = r107;
        $VALUES = new ELongLinkStatus[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r106, r107};
    }

    public static ELongLinkStatus[] values() {
        return (ELongLinkStatus[]) $VALUES.clone();
    }

    public int getRequestId() {
        return this.f32922b;
    }

    public int getStatusCode() {
        return this.f32921a;
    }

    public static ELongLinkStatus valueOf(String r100) {
        return (ELongLinkStatus) a.a(ELongLinkStatus.class, r100);
    }

    public void setRequestId(int r100) {
        this.f32922b = r100;
    }

    private ELongLinkStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.f32921a = r102;
    }
}
