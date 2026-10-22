package com.bytedance.android.anniex.pitaya;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"com/bytedance/android/anniex/pitaya/StrategyError$ErrorCode", "", "Lcom/bytedance/android/anniex/pitaya/StrategyError$ErrorCode;", "", "code", "I", "getCode", "()I", "STRATEGY_DISABLE", "STRATEGY_UNKNOWN", "UNKNOWN_EXCEPTION", "METHOD_NOT_IMPLEMENTED", "POLICY_NOT_READY", "POLICY_NULL", "DETECTED_TEXT_BLANK", "anniex_release"}, k = 1, mv = {1, 4, 3})
public final enum StrategyError$ErrorCode extends Enum<StrategyError$ErrorCode> {
    public static final StrategyError$ErrorCode DETECTED_TEXT_BLANK = null;
    public static final StrategyError$ErrorCode METHOD_NOT_IMPLEMENTED = null;
    public static final StrategyError$ErrorCode POLICY_NOT_READY = null;
    public static final StrategyError$ErrorCode POLICY_NULL = null;
    public static final StrategyError$ErrorCode STRATEGY_DISABLE = null;
    public static final StrategyError$ErrorCode STRATEGY_UNKNOWN = null;
    public static final StrategyError$ErrorCode UNKNOWN_EXCEPTION = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ StrategyError$ErrorCode[] f41033a = null;
    private final int code;

    public static StrategyError$ErrorCode valueOf(String r100) {
        return (StrategyError$ErrorCode) a.a(StrategyError$ErrorCode.class, r100);
    }

    public static StrategyError$ErrorCode[] values() {
        return (StrategyError$ErrorCode[]) f41033a.clone();
    }

    static {
        StrategyError$ErrorCode r100 = new StrategyError$ErrorCode("STRATEGY_DISABLE", 0, -100);
        STRATEGY_DISABLE = r100;
        StrategyError$ErrorCode r101 = new StrategyError$ErrorCode("STRATEGY_UNKNOWN", 1, -101);
        STRATEGY_UNKNOWN = r101;
        StrategyError$ErrorCode r102 = new StrategyError$ErrorCode("UNKNOWN_EXCEPTION", 2, -110);
        UNKNOWN_EXCEPTION = r102;
        StrategyError$ErrorCode r103 = new StrategyError$ErrorCode("METHOD_NOT_IMPLEMENTED", 3, -111);
        METHOD_NOT_IMPLEMENTED = r103;
        StrategyError$ErrorCode r104 = new StrategyError$ErrorCode("POLICY_NOT_READY", 4, -112);
        POLICY_NOT_READY = r104;
        StrategyError$ErrorCode r105 = new StrategyError$ErrorCode("POLICY_NULL", 5, -113);
        POLICY_NULL = r105;
        StrategyError$ErrorCode r110 = new StrategyError$ErrorCode("DETECTED_TEXT_BLANK", 6, -114);
        DETECTED_TEXT_BLANK = r110;
        f41033a = new StrategyError$ErrorCode[]{r100, r101, r102, r103, r104, r105, r110};
    }

    public final int getCode() {
        return this.code;
    }

    public StrategyError$ErrorCode(String r100, int r101, int r102) {
        super(r100, r101);
        this.code = r102;
    }
}
