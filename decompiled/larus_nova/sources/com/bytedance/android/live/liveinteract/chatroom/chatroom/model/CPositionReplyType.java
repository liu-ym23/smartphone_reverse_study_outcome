package com.bytedance.android.live.liveinteract.chatroom.chatroom.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/liveinteract/chatroom/chatroom/model/CPositionReplyType;", "", "", "value", "I", "getValue", "()I", "Accept", "Reject", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum CPositionReplyType extends Enum<CPositionReplyType> {
    public static final CPositionReplyType Accept = null;
    public static final CPositionReplyType Reject = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CPositionReplyType[] f72163a = null;
    private final int value;

    static {
        CPositionReplyType r100 = new CPositionReplyType("Accept", 0, 1);
        Accept = r100;
        CPositionReplyType r101 = new CPositionReplyType("Reject", 1, 2);
        Reject = r101;
        f72163a = new CPositionReplyType[]{r100, r101};
    }

    public static CPositionReplyType valueOf(String r100) {
        return (CPositionReplyType) r27.a.a(CPositionReplyType.class, r100);
    }

    public static CPositionReplyType[] values() {
        return (CPositionReplyType[]) f72163a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public CPositionReplyType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
