package com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.process.contract;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/process/contract/CJUnifyPrePayContext;", "", "(Ljava/lang/String;I)V", EffectConstants.NORMAL, "PAY_NEW_CARD", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum CJUnifyPrePayContext extends Enum<CJUnifyPrePayContext> {
    private static final /* synthetic */ CJUnifyPrePayContext[] $VALUES = null;
    public static final CJUnifyPrePayContext NORMAL = null;
    public static final CJUnifyPrePayContext PAY_NEW_CARD = null;

    private static final /* synthetic */ CJUnifyPrePayContext[] $values() {
        return new CJUnifyPrePayContext[]{NORMAL, PAY_NEW_CARD};
    }

    public static CJUnifyPrePayContext valueOf(String r100) {
        return (CJUnifyPrePayContext) a.a(CJUnifyPrePayContext.class, r100);
    }

    public static CJUnifyPrePayContext[] values() {
        return (CJUnifyPrePayContext[]) $VALUES.clone();
    }

    static {
        NORMAL = new CJUnifyPrePayContext(EffectConstants.NORMAL, 0);
        PAY_NEW_CARD = new CJUnifyPrePayContext("PAY_NEW_CARD", 1);
        $VALUES = $values();
    }

    private CJUnifyPrePayContext(String r100, int r101) {
        super(r100, r101);
    }
}
