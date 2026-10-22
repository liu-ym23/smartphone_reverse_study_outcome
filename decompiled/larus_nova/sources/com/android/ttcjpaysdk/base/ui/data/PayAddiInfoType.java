package com.android.ttcjpaysdk.base.ui.data;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/data/PayAddiInfoType;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "DEFAULT", "RETURN_AFTER_PAY", "FOLLOW", "PAY_WITHOUT_LOGIN", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum PayAddiInfoType extends Enum<PayAddiInfoType> {
    private static final /* synthetic */ PayAddiInfoType[] $VALUES = null;
    public static final PayAddiInfoType DEFAULT = null;
    public static final PayAddiInfoType FOLLOW = null;
    public static final PayAddiInfoType PAY_WITHOUT_LOGIN = null;
    public static final PayAddiInfoType RETURN_AFTER_PAY = null;
    private final String value;

    private static final /* synthetic */ PayAddiInfoType[] $values() {
        return new PayAddiInfoType[]{DEFAULT, RETURN_AFTER_PAY, FOLLOW, PAY_WITHOUT_LOGIN};
    }

    public static PayAddiInfoType valueOf(String r100) {
        return (PayAddiInfoType) a.a(PayAddiInfoType.class, r100);
    }

    public static PayAddiInfoType[] values() {
        return (PayAddiInfoType[]) $VALUES.clone();
    }

    static {
        DEFAULT = new PayAddiInfoType("DEFAULT", 0, "default");
        RETURN_AFTER_PAY = new PayAddiInfoType("RETURN_AFTER_PAY", 1, "return_after_pay");
        FOLLOW = new PayAddiInfoType("FOLLOW", 2, "follow");
        PAY_WITHOUT_LOGIN = new PayAddiInfoType("PAY_WITHOUT_LOGIN", 3, "pay_without_login");
        $VALUES = $values();
    }

    public final String getValue() {
        return this.value;
    }

    private PayAddiInfoType(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
