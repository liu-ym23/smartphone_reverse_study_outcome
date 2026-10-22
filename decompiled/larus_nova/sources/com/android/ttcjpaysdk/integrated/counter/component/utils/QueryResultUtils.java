package com.android.ttcjpaysdk.integrated.counter.component.utils;

import com.android.ttcjpaysdk.base.utils.CJPayCountDownTimeUtil;
import com.android.ttcjpaysdk.integrated.counter.model.CJPayCounterModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0011B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\nJ\u001e\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fJ \u0010\u0010\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fH\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/counter/component/utils/QueryResultUtils;", "", "()V", "TimerKey", "", "getTimerKey", "()Ljava/lang/String;", "isCancel", "", "cancelQuery", "", "queryResult", "papiid", "tradeNo", "callback", "Lcom/android/ttcjpaysdk/integrated/counter/component/utils/QueryResultUtils$QueryCallback;", "tradeQuery", "QueryCallback", "integrated-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class QueryResultUtils {
    public static final QueryResultUtils INSTANCE = null;
    private static final String TimerKey = null;
    private static boolean isCancel;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/counter/component/utils/QueryResultUtils$QueryCallback;", "", "failed", "", "success", "integrated-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface QueryCallback {
        void failed();

        void success();
    }

    private QueryResultUtils() {
    }

    public final void cancelQuery() {
        isCancel = true;
        CJPayCountDownTimeUtil.getInstance().cancel(TimerKey);
    }

    static {
        INSTANCE = new QueryResultUtils();
        TimerKey = "QueryResultUtils";
    }

    public static final /* synthetic */ boolean access$isCancel$p() {
        return isCancel;
    }

    public final String getTimerKey() {
        return TimerKey;
    }

    private final void tradeQuery(String r100, String r101, final QueryCallback r102) {
        new CJPayCounterModel().getTradeQueryData(r100, r101, new C92031(r102));
    }

    public final void queryResult(final String r100, final String r110, final QueryCallback r111) {
        Intrinsics.checkNotNullParameter(r100, "papiid");
        Intrinsics.checkNotNullParameter(r110, "tradeNo");
        Intrinsics.checkNotNullParameter(r111, "callback");
        isCancel = false;
        CJPayCountDownTimeUtil r101 = CJPayCountDownTimeUtil.getInstance();
        String r102 = TimerKey;
        r101.cancel(r102);
        CJPayCountDownTimeUtil.getInstance().putCountDownTimer(r102, 2000, 1000, new AnonymousClass1(r100, r110, r111));
    }

    public static final /* synthetic */ void access$tradeQuery(QueryResultUtils r100, String r101, String r102, QueryCallback r103) {
        r100.tradeQuery(r101, r102, r103);
    }
}
