package com.volcengine.tos.comm.event;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes3.dex */
public final class UploadEventType {

    /* renamed from: a, reason: collision with root package name */
    public static final UploadEventType f4235a;
    public static final UploadEventType b;
    public static final UploadEventType c;
    public static final UploadEventType d;
    public static final UploadEventType e;
    public static final UploadEventType f;
    public static final UploadEventType g;
    public static final /* synthetic */ UploadEventType[] h;

    static {
        UploadEventType uploadEventType = new UploadEventType("UploadEventCreateMultipartUploadSucceed", 0);
        f4235a = uploadEventType;
        UploadEventType uploadEventType2 = new UploadEventType("UploadEventCreateMultipartUploadFailed", 1);
        b = uploadEventType2;
        UploadEventType uploadEventType3 = new UploadEventType("UploadEventUploadPartSucceed", 2);
        c = uploadEventType3;
        UploadEventType uploadEventType4 = new UploadEventType("UploadEventUploadPartFailed", 3);
        d = uploadEventType4;
        UploadEventType uploadEventType5 = new UploadEventType("UploadEventUploadPartAborted", 4);
        e = uploadEventType5;
        UploadEventType uploadEventType6 = new UploadEventType("UploadEventCompleteMultipartUploadSucceed", 5);
        f = uploadEventType6;
        UploadEventType uploadEventType7 = new UploadEventType("UploadEventCompleteMultipartUploadFailed", 6);
        g = uploadEventType7;
        h = new UploadEventType[]{uploadEventType, uploadEventType2, uploadEventType3, uploadEventType4, uploadEventType5, uploadEventType6, uploadEventType7};
    }

    public static UploadEventType valueOf(String str) {
        return (UploadEventType) Enum.valueOf(UploadEventType.class, str);
    }

    public static UploadEventType[] values() {
        return (UploadEventType[]) h.clone();
    }
}
