package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/stateMachine/RefreshGiftListSource;", "", "source", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getSource", "()Ljava/lang/String;", UserProfileEvent.POSITION_NONE, "OPEN_DIALOG", "CHANGE_RECEIVER", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum RefreshGiftListSource extends Enum<RefreshGiftListSource> {
    private static final /* synthetic */ RefreshGiftListSource[] $VALUES = null;
    public static final RefreshGiftListSource CHANGE_RECEIVER = null;
    public static final RefreshGiftListSource NONE = null;
    public static final RefreshGiftListSource OPEN_DIALOG = null;
    private final String source;

    static {
        RefreshGiftListSource r100 = new RefreshGiftListSource(UserProfileEvent.POSITION_NONE, 0, "none");
        NONE = r100;
        RefreshGiftListSource r101 = new RefreshGiftListSource("OPEN_DIALOG", 1, "open_panel");
        OPEN_DIALOG = r101;
        RefreshGiftListSource r102 = new RefreshGiftListSource("CHANGE_RECEIVER", 2, "change_recipient");
        CHANGE_RECEIVER = r102;
        $VALUES = new RefreshGiftListSource[]{r100, r101, r102};
    }

    public static RefreshGiftListSource valueOf(String r100) {
        return (RefreshGiftListSource) a.a(RefreshGiftListSource.class, r100);
    }

    public static RefreshGiftListSource[] values() {
        return (RefreshGiftListSource[]) $VALUES.clone();
    }

    public final String getSource() {
        return this.source;
    }

    private RefreshGiftListSource(String r100, int r101, String r102) {
        super(r100, r101);
        this.source = r102;
    }
}
