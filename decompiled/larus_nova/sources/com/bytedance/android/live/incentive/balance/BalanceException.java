package com.bytedance.android.live.incentive.balance;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0001\fB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/bytedance/android/live/incentive/balance/BalanceException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "reason", "Lcom/bytedance/android/live/incentive/balance/BalanceException$Reason;", "(Lcom/bytedance/android/live/incentive/balance/BalanceException$Reason;)V", "message", "", "getMessage", "()Ljava/lang/String;", "getReason", "()Lcom/bytedance/android/live/incentive/balance/BalanceException$Reason;", "Reason", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class BalanceException extends Exception {
    private final Reason reason;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/incentive/balance/BalanceException$Reason;", "", "Unknown", "CurrencyNotAvailable", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum Reason extends Enum<Reason> {
        public static final Reason CurrencyNotAvailable = null;
        public static final Reason Unknown = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Reason[] f69325a = null;

        static {
            Reason r100 = new Reason("Unknown", 0);
            Unknown = r100;
            Reason r101 = new Reason("CurrencyNotAvailable", 1);
            CurrencyNotAvailable = r101;
            f69325a = new Reason[]{r100, r101};
        }

        public static Reason valueOf(String r100) {
            return (Reason) r27.a.a(Reason.class, r100);
        }

        public static Reason[] values() {
            return (Reason[]) f69325a.clone();
        }

        public Reason(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.reason.toString();
    }

    public final Reason getReason() {
        return this.reason;
    }

    public BalanceException(Reason r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        this.reason = r100;
    }
}
