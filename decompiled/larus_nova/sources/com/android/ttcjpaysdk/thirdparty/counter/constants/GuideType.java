package com.android.ttcjpaysdk.thirdparty.counter.constants;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/counter/constants/GuideType;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "RESET_PWD", "SET_PWD_AFTER_PAY", "bdpay-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum GuideType extends Enum<GuideType> {
    private static final /* synthetic */ GuideType[] $VALUES = null;
    public static final GuideType RESET_PWD = null;
    public static final GuideType SET_PWD_AFTER_PAY = null;
    private final String value;

    private static final /* synthetic */ GuideType[] $values() {
        return new GuideType[]{RESET_PWD, SET_PWD_AFTER_PAY};
    }

    public static GuideType valueOf(String r100) {
        return (GuideType) a.a(GuideType.class, r100);
    }

    public static GuideType[] values() {
        return (GuideType[]) $VALUES.clone();
    }

    static {
        RESET_PWD = new GuideType("RESET_PWD", 0, "reset_pwd");
        SET_PWD_AFTER_PAY = new GuideType("SET_PWD_AFTER_PAY", 1, "set_pwd_after_pay");
        $VALUES = $values();
    }

    public final String getValue() {
        return this.value;
    }

    private GuideType(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
