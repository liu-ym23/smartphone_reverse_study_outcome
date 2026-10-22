package com.bytedance.android.live.profit.lottery;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
public final class LotteryApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f87936a = 0;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\t\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/profit/lottery/LotteryApi$QueryFrom;", "", "", "value", "J", "getValue", "()J", "Undefined", "ClientEnterRoom", "WebResultPage", "ClientPoll", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum QueryFrom extends Enum<QueryFrom> {
        public static final QueryFrom ClientEnterRoom = null;
        public static final QueryFrom ClientPoll = null;
        public static final QueryFrom Undefined = null;
        public static final QueryFrom WebResultPage = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ QueryFrom[] f87937a = null;
        private final long value;

        static {
            QueryFrom r100 = new QueryFrom("Undefined", 0, 0);
            Undefined = r100;
            QueryFrom r101 = new QueryFrom("ClientEnterRoom", 1, 1);
            ClientEnterRoom = r101;
            QueryFrom r102 = new QueryFrom("WebResultPage", 2, 2);
            WebResultPage = r102;
            QueryFrom r103 = new QueryFrom("ClientPoll", 3, 3);
            ClientPoll = r103;
            f87937a = new QueryFrom[]{r100, r101, r102, r103};
        }

        public static QueryFrom valueOf(String r100) {
            return (QueryFrom) r27.a.a(QueryFrom.class, r100);
        }

        public static QueryFrom[] values() {
            return (QueryFrom[]) f87937a.clone();
        }

        public final long getValue() {
            return this.value;
        }

        public QueryFrom(String r100, int r101, long r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
    }
}
