package com.android.ttcjpaysdk.bdpay.counter.outer.independent;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/counter/outer/independent/AddiActionType;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "CONFIRM", "bdpay-counter-outer_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum AddiActionType extends Enum<AddiActionType> {
    private static final /* synthetic */ AddiActionType[] $VALUES = null;
    public static final AddiActionType CONFIRM = null;
    private final String value;

    private static final /* synthetic */ AddiActionType[] $values() {
        return new AddiActionType[]{CONFIRM};
    }

    public static AddiActionType valueOf(String r100) {
        return (AddiActionType) a.a(AddiActionType.class, r100);
    }

    public static AddiActionType[] values() {
        return (AddiActionType[]) $VALUES.clone();
    }

    static {
        CONFIRM = new AddiActionType("CONFIRM", 0, "confirm");
        $VALUES = $values();
    }

    public final String getValue() {
        return this.value;
    }

    private AddiActionType(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
