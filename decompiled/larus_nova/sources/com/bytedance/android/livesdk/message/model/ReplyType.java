package com.bytedance.android.livesdk.message.model;

/* JADX INFO: loaded from: classes11.dex */
public final enum ReplyType extends Enum<ReplyType> {
    public static final ReplyType Agree = null;
    public static final ReplyType None = null;
    public static final ReplyType Reject = null;
    public static final ReplyType UnsupportedDevice = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ReplyType[] f153613a = null;

    static {
        ReplyType r100 = new ReplyType("None", 0);
        None = r100;
        ReplyType r101 = new ReplyType("Agree", 1);
        Agree = r101;
        ReplyType r102 = new ReplyType("Reject", 2);
        Reject = r102;
        ReplyType r103 = new ReplyType("UnsupportedDevice", 3);
        UnsupportedDevice = r103;
        f153613a = new ReplyType[]{r100, r101, r102, r103};
    }

    public static ReplyType[] values() {
        return (ReplyType[]) f153613a.clone();
    }

    public static ReplyType valueOf(String r100) {
        return (ReplyType) r27.a.a(ReplyType.class, r100);
    }

    public ReplyType(String r100, int r101) {
        super(r100, r101);
    }
}
