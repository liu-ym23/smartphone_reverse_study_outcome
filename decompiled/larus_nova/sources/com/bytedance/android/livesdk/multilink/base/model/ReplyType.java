package com.bytedance.android.livesdk.multilink.base.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/multilink/base/model/ReplyType;", "", "None", "Agree", "Reject", "UnsupportedDevice", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum ReplyType extends Enum<ReplyType> {
    public static final ReplyType Agree = null;
    public static final ReplyType None = null;
    public static final ReplyType Reject = null;
    public static final ReplyType UnsupportedDevice = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ReplyType[] f153986a = null;

    static {
        ReplyType r100 = new ReplyType("None", 0);
        None = r100;
        ReplyType r101 = new ReplyType("Agree", 1);
        Agree = r101;
        ReplyType r102 = new ReplyType("Reject", 2);
        Reject = r102;
        ReplyType r103 = new ReplyType("UnsupportedDevice", 3);
        UnsupportedDevice = r103;
        f153986a = new ReplyType[]{r100, r101, r102, r103};
    }

    public static ReplyType valueOf(String r100) {
        return (ReplyType) r27.a.a(ReplyType.class, r100);
    }

    public static ReplyType[] values() {
        return (ReplyType[]) f153986a.clone();
    }

    public ReplyType(String r100, int r101) {
        super(r100, r101);
    }
}
