package com.bytedance.android.live.profit.redpacket.model;

import com.bytedance.tools.kcp.aio.runtime.RpcEnum;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@RpcEnum(messageName = "webcast.revenue.biz.luckyBox.ResultType")
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/profit/redpacket/model/ResultType;", "", "ResultTypeUnknown", "ResultTypeWin", "ResultTypeSurpriseWin", "ResultTypeNotWin", "ResultTypeEnd", "ResultTypeExpired", "live-redpacket-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum ResultType extends Enum<ResultType> {
    public static final ResultType ResultTypeEnd = null;
    public static final ResultType ResultTypeExpired = null;
    public static final ResultType ResultTypeNotWin = null;
    public static final ResultType ResultTypeSurpriseWin = null;
    public static final ResultType ResultTypeUnknown = null;
    public static final ResultType ResultTypeWin = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ResultType[] f88661a = null;

    static {
        ResultType r100 = new ResultType("ResultTypeUnknown", 0);
        ResultTypeUnknown = r100;
        ResultType r101 = new ResultType("ResultTypeWin", 1);
        ResultTypeWin = r101;
        ResultType r102 = new ResultType("ResultTypeSurpriseWin", 2);
        ResultTypeSurpriseWin = r102;
        ResultType r103 = new ResultType("ResultTypeNotWin", 3);
        ResultTypeNotWin = r103;
        ResultType r104 = new ResultType("ResultTypeEnd", 4);
        ResultTypeEnd = r104;
        ResultType r105 = new ResultType("ResultTypeExpired", 5);
        ResultTypeExpired = r105;
        f88661a = new ResultType[]{r100, r101, r102, r103, r104, r105};
    }

    public static ResultType valueOf(String r100) {
        return (ResultType) r27.a.a(ResultType.class, r100);
    }

    public static ResultType[] values() {
        return (ResultType[]) f88661a.clone();
    }

    public ResultType(String r100, int r101) {
        super(r100, r101);
    }
}
