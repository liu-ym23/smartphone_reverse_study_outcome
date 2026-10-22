package com.android.ttcjpaysdk.base.service;

import com.tencent.open.SocialConstants;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/PayMsg;", "", SocialConstants.PARAM_APP_DESC, "", "(Ljava/lang/String;ILjava/lang/String;)V", "getDesc", "()Ljava/lang/String;", "BTN_DESC", "PAY_AMOUNT", "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum PayMsg extends Enum<PayMsg> {
    private static final /* synthetic */ PayMsg[] $VALUES = null;
    public static final PayMsg BTN_DESC = null;
    public static final PayMsg PAY_AMOUNT = null;
    private final String desc;

    private static final /* synthetic */ PayMsg[] $values() {
        return new PayMsg[]{BTN_DESC, PAY_AMOUNT};
    }

    public static PayMsg valueOf(String r100) {
        return (PayMsg) a.a(PayMsg.class, r100);
    }

    public static PayMsg[] values() {
        return (PayMsg[]) $VALUES.clone();
    }

    static {
        BTN_DESC = new PayMsg("BTN_DESC", 0, "btn文案描述");
        PAY_AMOUNT = new PayMsg("PAY_AMOUNT", 1, "支付金额");
        $VALUES = $values();
    }

    public final String getDesc() {
        return this.desc;
    }

    private PayMsg(String r100, int r101, String r102) {
        super(r100, r101);
        this.desc = r102;
    }
}
