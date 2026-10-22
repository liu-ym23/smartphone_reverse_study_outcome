package com.android.ttcjpaysdk.base.ui.widget;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/widget/FollowNameType;", "", "(Ljava/lang/String;I)V", "ADDI", "ADDI_WITH_VOUCHER", "ADDI_NOT_CHOOSE", "RETAIN", "ADDI_OPT", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum FollowNameType extends Enum<FollowNameType> {
    private static final /* synthetic */ FollowNameType[] $VALUES = null;
    public static final FollowNameType ADDI = null;
    public static final FollowNameType ADDI_NOT_CHOOSE = null;
    public static final FollowNameType ADDI_OPT = null;
    public static final FollowNameType ADDI_WITH_VOUCHER = null;
    public static final FollowNameType RETAIN = null;

    private static final /* synthetic */ FollowNameType[] $values() {
        return new FollowNameType[]{ADDI, ADDI_WITH_VOUCHER, ADDI_NOT_CHOOSE, RETAIN, ADDI_OPT};
    }

    public static FollowNameType valueOf(String r100) {
        return (FollowNameType) a.a(FollowNameType.class, r100);
    }

    public static FollowNameType[] values() {
        return (FollowNameType[]) $VALUES.clone();
    }

    static {
        ADDI = new FollowNameType("ADDI", 0);
        ADDI_WITH_VOUCHER = new FollowNameType("ADDI_WITH_VOUCHER", 1);
        ADDI_NOT_CHOOSE = new FollowNameType("ADDI_NOT_CHOOSE", 2);
        RETAIN = new FollowNameType("RETAIN", 3);
        ADDI_OPT = new FollowNameType("ADDI_OPT", 4);
        $VALUES = $values();
    }

    private FollowNameType(String r100, int r101) {
        super(r100, r101);
    }
}
