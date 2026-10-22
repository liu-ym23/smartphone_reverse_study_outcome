package com.volcengine.tos.comm.event;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes3.dex */
public final class CopyEventType {

    /* renamed from: a, reason: collision with root package name */
    public static final CopyEventType f4233a;
    public static final CopyEventType b;
    public static final CopyEventType c;
    public static final CopyEventType d;
    public static final CopyEventType e;
    public static final CopyEventType f;
    public static final CopyEventType g;
    public static final /* synthetic */ CopyEventType[] h;

    static {
        CopyEventType copyEventType = new CopyEventType("CopyEventCreateMultipartUploadSucceed", 0);
        f4233a = copyEventType;
        CopyEventType copyEventType2 = new CopyEventType("CopyEventCreateMultipartUploadFailed", 1);
        b = copyEventType2;
        CopyEventType copyEventType3 = new CopyEventType("CopyEventUploadPartCopySucceed", 2);
        c = copyEventType3;
        CopyEventType copyEventType4 = new CopyEventType("CopyEventUploadPartCopyFailed", 3);
        d = copyEventType4;
        CopyEventType copyEventType5 = new CopyEventType("CopyEventUploadPartCopyAborted", 4);
        e = copyEventType5;
        CopyEventType copyEventType6 = new CopyEventType("CopyEventCompleteMultipartUploadSucceed", 5);
        f = copyEventType6;
        CopyEventType copyEventType7 = new CopyEventType("CopyEventCompleteMultipartUploadFailed", 6);
        g = copyEventType7;
        h = new CopyEventType[]{copyEventType, copyEventType2, copyEventType3, copyEventType4, copyEventType5, copyEventType6, copyEventType7};
    }

    public static CopyEventType valueOf(String str) {
        return (CopyEventType) Enum.valueOf(CopyEventType.class, str);
    }

    public static CopyEventType[] values() {
        return (CopyEventType[]) h.clone();
    }
}
