package com.bytedance.android.live.recharge.exchange;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
public interface IAutoExchangeService extends com.bytedance.android.live.recharge.core.c {

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/recharge/exchange/IAutoExchangeService$ExchangeRiskCode;", "", "", "value", "I", "getValue", "()I", "ExchangeCodeNameCard", "ExchangeCodeRealName", "HotsoonExchangeExceeding", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum ExchangeRiskCode extends Enum<ExchangeRiskCode> {
        public static final ExchangeRiskCode ExchangeCodeNameCard = null;
        public static final ExchangeRiskCode ExchangeCodeRealName = null;
        public static final ExchangeRiskCode HotsoonExchangeExceeding = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ExchangeRiskCode[] f89780a = null;
        private final int value;

        static {
            ExchangeRiskCode r100 = new ExchangeRiskCode("ExchangeCodeNameCard", 0, 4005178);
            ExchangeCodeNameCard = r100;
            ExchangeRiskCode r101 = new ExchangeRiskCode("ExchangeCodeRealName", 1, 4005177);
            ExchangeCodeRealName = r101;
            ExchangeRiskCode r102 = new ExchangeRiskCode("HotsoonExchangeExceeding", 2, 20011);
            HotsoonExchangeExceeding = r102;
            f89780a = new ExchangeRiskCode[]{r100, r101, r102};
        }

        public static ExchangeRiskCode valueOf(String r100) {
            return (ExchangeRiskCode) r27.a.a(ExchangeRiskCode.class, r100);
        }

        public static ExchangeRiskCode[] values() {
            return (ExchangeRiskCode[]) f89780a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public ExchangeRiskCode(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use IIncomeExchangeServiceForLive instead")
    boolean d1();

    boolean w0();

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use IIncomeExchangeServiceForLive instead")
    boolean z1(long r100);
}
