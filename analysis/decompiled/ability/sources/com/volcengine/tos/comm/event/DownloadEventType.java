package com.volcengine.tos.comm.event;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes3.dex */
public final class DownloadEventType {

    /* renamed from: a, reason: collision with root package name */
    public static final DownloadEventType f4234a;
    public static final DownloadEventType b;
    public static final DownloadEventType c;
    public static final DownloadEventType d;
    public static final DownloadEventType e;
    public static final DownloadEventType f;
    public static final DownloadEventType g;
    public static final /* synthetic */ DownloadEventType[] h;

    static {
        DownloadEventType downloadEventType = new DownloadEventType("DownloadEventCreateTempFileSucceed", 0);
        f4234a = downloadEventType;
        DownloadEventType downloadEventType2 = new DownloadEventType("DownloadEventCreateTempFileFailed", 1);
        b = downloadEventType2;
        DownloadEventType downloadEventType3 = new DownloadEventType("DownloadEventDownloadPartSucceed", 2);
        c = downloadEventType3;
        DownloadEventType downloadEventType4 = new DownloadEventType("DownloadEventDownloadPartFailed", 3);
        d = downloadEventType4;
        DownloadEventType downloadEventType5 = new DownloadEventType("DownloadEventDownloadPartAborted", 4);
        e = downloadEventType5;
        DownloadEventType downloadEventType6 = new DownloadEventType("DownloadEventRenameTempFileSucceed", 5);
        f = downloadEventType6;
        DownloadEventType downloadEventType7 = new DownloadEventType("DownloadEventRenameTempFileFailed", 6);
        g = downloadEventType7;
        h = new DownloadEventType[]{downloadEventType, downloadEventType2, downloadEventType3, downloadEventType4, downloadEventType5, downloadEventType6, downloadEventType7};
    }

    public static DownloadEventType valueOf(String str) {
        return (DownloadEventType) Enum.valueOf(DownloadEventType.class, str);
    }

    public static DownloadEventType[] values() {
        return (DownloadEventType[]) h.clone();
    }
}
