package com.android.ttcjpaysdk.bdpay.counter.outer.sign.view;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/view/AgreementViewPosition;", "", "(Ljava/lang/String;I)V", "ABOVE", "BELOW", "bdpay-counter-outer_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum AgreementViewPosition extends Enum<AgreementViewPosition> {
    private static final /* synthetic */ AgreementViewPosition[] $VALUES = null;
    public static final AgreementViewPosition ABOVE = null;
    public static final AgreementViewPosition BELOW = null;

    private static final /* synthetic */ AgreementViewPosition[] $values() {
        return new AgreementViewPosition[]{ABOVE, BELOW};
    }

    public static AgreementViewPosition valueOf(String r100) {
        return (AgreementViewPosition) a.a(AgreementViewPosition.class, r100);
    }

    public static AgreementViewPosition[] values() {
        return (AgreementViewPosition[]) $VALUES.clone();
    }

    static {
        ABOVE = new AgreementViewPosition("ABOVE", 0);
        BELOW = new AgreementViewPosition("BELOW", 1);
        $VALUES = $values();
    }

    private AgreementViewPosition(String r100, int r101) {
        super(r100, r101);
    }
}
