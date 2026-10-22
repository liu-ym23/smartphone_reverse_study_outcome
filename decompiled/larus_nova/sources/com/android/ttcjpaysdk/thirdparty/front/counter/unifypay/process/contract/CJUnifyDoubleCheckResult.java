package com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.process.contract;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/process/contract/CJUnifyDoubleCheckResult;", "", "(Ljava/lang/String;I)V", "BLOCK", "FAIL", "CANCEL", "SELECT_OTHER_PAYMENT_METHOD", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum CJUnifyDoubleCheckResult extends Enum<CJUnifyDoubleCheckResult> {
    private static final /* synthetic */ CJUnifyDoubleCheckResult[] $VALUES = null;
    public static final CJUnifyDoubleCheckResult BLOCK = null;
    public static final CJUnifyDoubleCheckResult CANCEL = null;
    public static final CJUnifyDoubleCheckResult FAIL = null;
    public static final CJUnifyDoubleCheckResult SELECT_OTHER_PAYMENT_METHOD = null;

    private static final /* synthetic */ CJUnifyDoubleCheckResult[] $values() {
        return new CJUnifyDoubleCheckResult[]{BLOCK, FAIL, CANCEL, SELECT_OTHER_PAYMENT_METHOD};
    }

    public static CJUnifyDoubleCheckResult valueOf(String r100) {
        return (CJUnifyDoubleCheckResult) a.a(CJUnifyDoubleCheckResult.class, r100);
    }

    public static CJUnifyDoubleCheckResult[] values() {
        return (CJUnifyDoubleCheckResult[]) $VALUES.clone();
    }

    static {
        BLOCK = new CJUnifyDoubleCheckResult("BLOCK", 0);
        FAIL = new CJUnifyDoubleCheckResult("FAIL", 1);
        CANCEL = new CJUnifyDoubleCheckResult("CANCEL", 2);
        SELECT_OTHER_PAYMENT_METHOD = new CJUnifyDoubleCheckResult("SELECT_OTHER_PAYMENT_METHOD", 3);
        $VALUES = $values();
    }

    private CJUnifyDoubleCheckResult(String r100, int r101) {
        super(r100, r101);
    }
}
