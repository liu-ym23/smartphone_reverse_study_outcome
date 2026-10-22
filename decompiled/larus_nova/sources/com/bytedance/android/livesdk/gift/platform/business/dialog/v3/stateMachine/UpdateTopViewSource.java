package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import com.obric.miniapp.alarm.AccountType;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/UpdateTopViewSource;", "", "(Ljava/lang/String;I)V", "SELECT_GIFT", "EXTRA_UPDATE", "TOPIC_UPDATE", "SCROLL", AccountType.OTHERS, "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum UpdateTopViewSource extends Enum<UpdateTopViewSource> {
    private static final /* synthetic */ UpdateTopViewSource[] $VALUES = null;
    public static final UpdateTopViewSource EXTRA_UPDATE = null;
    public static final UpdateTopViewSource OTHERS = null;
    public static final UpdateTopViewSource SCROLL = null;
    public static final UpdateTopViewSource SELECT_GIFT = null;
    public static final UpdateTopViewSource TOPIC_UPDATE = null;

    static {
        UpdateTopViewSource r100 = new UpdateTopViewSource("SELECT_GIFT", 0);
        SELECT_GIFT = r100;
        UpdateTopViewSource r101 = new UpdateTopViewSource("EXTRA_UPDATE", 1);
        EXTRA_UPDATE = r101;
        UpdateTopViewSource r102 = new UpdateTopViewSource("TOPIC_UPDATE", 2);
        TOPIC_UPDATE = r102;
        UpdateTopViewSource r103 = new UpdateTopViewSource("SCROLL", 3);
        SCROLL = r103;
        UpdateTopViewSource r104 = new UpdateTopViewSource(AccountType.OTHERS, 4);
        OTHERS = r104;
        $VALUES = new UpdateTopViewSource[]{r100, r101, r102, r103, r104};
    }

    public static UpdateTopViewSource valueOf(String r100) {
        return (UpdateTopViewSource) a.a(UpdateTopViewSource.class, r100);
    }

    public static UpdateTopViewSource[] values() {
        return (UpdateTopViewSource[]) $VALUES.clone();
    }

    private UpdateTopViewSource(String r100, int r101) {
        super(r100, r101);
    }
}
