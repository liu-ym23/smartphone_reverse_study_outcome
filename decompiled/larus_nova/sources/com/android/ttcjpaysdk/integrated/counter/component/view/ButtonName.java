package com.android.ttcjpaysdk.integrated.counter.component.view;

import com.tencent.open.SocialConstants;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/counter/component/view/ButtonName;", "", "logKey", "", SocialConstants.PARAM_APP_DESC, "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getDesc", "()Ljava/lang/String;", "getLogKey", "BUTTON_NAME1", "BUTTON_NAME2", "BUTTON_NAME3", "BUTTON_NAME4", "integrated-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum ButtonName extends Enum<ButtonName> {
    private static final /* synthetic */ ButtonName[] $VALUES = null;
    public static final ButtonName BUTTON_NAME1 = null;
    public static final ButtonName BUTTON_NAME2 = null;
    public static final ButtonName BUTTON_NAME3 = null;
    public static final ButtonName BUTTON_NAME4 = null;
    private final String desc;
    private final String logKey;

    private static final /* synthetic */ ButtonName[] $values() {
        return new ButtonName[]{BUTTON_NAME1, BUTTON_NAME2, BUTTON_NAME3, BUTTON_NAME4};
    }

    public static ButtonName valueOf(String r100) {
        return (ButtonName) a.a(ButtonName.class, r100);
    }

    public static ButtonName[] values() {
        return (ButtonName[]) $VALUES.clone();
    }

    static {
        BUTTON_NAME1 = new ButtonName("BUTTON_NAME1", 0, "1", "切换支付方式");
        BUTTON_NAME2 = new ButtonName("BUTTON_NAME2", 1, "2", "切换优惠");
        BUTTON_NAME3 = new ButtonName("BUTTON_NAME3", 2, "3", "支付确认");
        BUTTON_NAME4 = new ButtonName("BUTTON_NAME4", 3, "4", "强推区点击");
        $VALUES = $values();
    }

    public final String getDesc() {
        return this.desc;
    }

    public final String getLogKey() {
        return this.logKey;
    }

    private ButtonName(String r100, int r101, String r102, String r103) {
        super(r100, r101);
        this.logKey = r102;
        this.desc = r103;
    }
}
