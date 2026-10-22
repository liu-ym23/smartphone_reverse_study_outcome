package com.bytedance.android.live.revlink.impl.mergepk.params;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/mergepk/params/ReplyType;", "", "Undefined", "Accept", "Reject", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum ReplyType extends Enum<ReplyType> {
    public static final ReplyType Accept = null;
    public static final ReplyType Reject = null;
    public static final ReplyType Undefined = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ReplyType[] f92674a = null;

    static {
        ReplyType r100 = new ReplyType("Undefined", 0);
        Undefined = r100;
        ReplyType r101 = new ReplyType("Accept", 1);
        Accept = r101;
        ReplyType r102 = new ReplyType("Reject", 2);
        Reject = r102;
        f92674a = new ReplyType[]{r100, r101, r102};
    }

    public static ReplyType valueOf(String r100) {
        return (ReplyType) a.a(ReplyType.class, r100);
    }

    public static ReplyType[] values() {
        return (ReplyType[]) f92674a.clone();
    }

    public ReplyType(String r100, int r101) {
        super(r100, r101);
    }
}
