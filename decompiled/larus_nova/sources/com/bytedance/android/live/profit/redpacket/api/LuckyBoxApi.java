package com.bytedance.android.live.profit.redpacket.api;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
public final class LuckyBoxApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f88581a = 0;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/profit/redpacket/api/LuckyBoxApi$ReceiveReqType;", "", "", "value", "I", "getValue", "()I", "REQ_TYPE_RECEIVE_UNKNOWN", "REQ_TYPE_NORMAL", "REQ_TYPE_EXPAND_AWARD", "REQ_TYPE_BACKUP", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum ReceiveReqType extends Enum<ReceiveReqType> {
        public static final ReceiveReqType REQ_TYPE_BACKUP = null;
        public static final ReceiveReqType REQ_TYPE_EXPAND_AWARD = null;
        public static final ReceiveReqType REQ_TYPE_NORMAL = null;
        public static final ReceiveReqType REQ_TYPE_RECEIVE_UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ReceiveReqType[] f88582a = null;
        private final int value;

        static {
            ReceiveReqType r100 = new ReceiveReqType("REQ_TYPE_RECEIVE_UNKNOWN", 0, 0);
            REQ_TYPE_RECEIVE_UNKNOWN = r100;
            ReceiveReqType r101 = new ReceiveReqType("REQ_TYPE_NORMAL", 1, 1);
            REQ_TYPE_NORMAL = r101;
            ReceiveReqType r102 = new ReceiveReqType("REQ_TYPE_EXPAND_AWARD", 2, 2);
            REQ_TYPE_EXPAND_AWARD = r102;
            ReceiveReqType r103 = new ReceiveReqType("REQ_TYPE_BACKUP", 3, 3);
            REQ_TYPE_BACKUP = r103;
            f88582a = new ReceiveReqType[]{r100, r101, r102, r103};
        }

        public static ReceiveReqType valueOf(String r100) {
            return (ReceiveReqType) r27.a.a(ReceiveReqType.class, r100);
        }

        public static ReceiveReqType[] values() {
            return (ReceiveReqType[]) f88582a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public ReceiveReqType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
    }
}
