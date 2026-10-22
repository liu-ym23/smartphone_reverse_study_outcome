package com.bytedance.android.live.broadcast.api.framework.common;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.obric.miniapp.alarm.AccountType;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/framework/common/AffectedStrategy;", "", "", "value", "I", "getValue", "()I", "AUTO", UserProfileEvent.POSITION_NONE, AccountType.ALL, "CUSTOM", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum AffectedStrategy extends Enum<AffectedStrategy> {
    public static final AffectedStrategy ALL = null;
    public static final AffectedStrategy AUTO = null;
    public static final AffectedStrategy CUSTOM = null;
    public static final AffectedStrategy NONE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AffectedStrategy[] f58980a = null;
    private final int value;

    static {
        AffectedStrategy r100 = new AffectedStrategy("AUTO", 0, 0);
        AUTO = r100;
        AffectedStrategy r101 = new AffectedStrategy(UserProfileEvent.POSITION_NONE, 1, 1);
        NONE = r101;
        AffectedStrategy r102 = new AffectedStrategy(AccountType.ALL, 2, 2);
        ALL = r102;
        AffectedStrategy r103 = new AffectedStrategy("CUSTOM", 3, 3);
        CUSTOM = r103;
        f58980a = new AffectedStrategy[]{r100, r101, r102, r103};
    }

    public static AffectedStrategy valueOf(String r100) {
        return (AffectedStrategy) r27.a.a(AffectedStrategy.class, r100);
    }

    public static AffectedStrategy[] values() {
        return (AffectedStrategy[]) f58980a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public AffectedStrategy(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
