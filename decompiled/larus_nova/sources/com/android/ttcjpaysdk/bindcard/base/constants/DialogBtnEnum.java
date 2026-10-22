package com.android.ttcjpaysdk.bindcard.base.constants;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/android/ttcjpaysdk/bindcard/base/constants/DialogBtnEnum;", "", "mDesc", "", "(Ljava/lang/String;ILjava/lang/String;)V", "DEFAULT", "FIRST", "SECOND", "THIRD", "FOURTH", "bdpay-bindcard-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum DialogBtnEnum extends Enum<DialogBtnEnum> {
    private static final /* synthetic */ DialogBtnEnum[] $VALUES = null;
    public static final DialogBtnEnum DEFAULT = null;
    public static final DialogBtnEnum FIRST = null;
    public static final DialogBtnEnum FOURTH = null;
    public static final DialogBtnEnum SECOND = null;
    public static final DialogBtnEnum THIRD = null;
    public final String mDesc;

    private static final /* synthetic */ DialogBtnEnum[] $values() {
        return new DialogBtnEnum[]{DEFAULT, FIRST, SECOND, THIRD, FOURTH};
    }

    public static DialogBtnEnum valueOf(String r100) {
        return (DialogBtnEnum) a.a(DialogBtnEnum.class, r100);
    }

    public static DialogBtnEnum[] values() {
        return (DialogBtnEnum[]) $VALUES.clone();
    }

    static {
        DEFAULT = new DialogBtnEnum("DEFAULT", 0, "默认传值");
        FIRST = new DialogBtnEnum("FIRST", 1, "第一个按钮");
        SECOND = new DialogBtnEnum("SECOND", 2, "第二个按钮");
        THIRD = new DialogBtnEnum("THIRD", 3, "第三个按钮");
        FOURTH = new DialogBtnEnum("FOURTH", 4, "第四个按钮");
        $VALUES = $values();
    }

    private DialogBtnEnum(String r100, int r101, String r102) {
        super(r100, r101);
        this.mDesc = r102;
    }
}
