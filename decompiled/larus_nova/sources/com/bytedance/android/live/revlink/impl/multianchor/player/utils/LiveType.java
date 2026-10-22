package com.bytedance.android.live.revlink.impl.multianchor.player.utils;

import com.obric.miniapp.alarm.AccountType;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/multianchor/player/utils/LiveType;", "", "PC_LIVE", "VIDEO", AccountType.OTHERS, "AUDIO", "SCREEN_RECORD", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum LiveType extends Enum<LiveType> {
    public static final LiveType AUDIO = null;
    public static final LiveType OTHERS = null;
    public static final LiveType PC_LIVE = null;
    public static final LiveType SCREEN_RECORD = null;
    public static final LiveType VIDEO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveType[] f94594a = null;

    static {
        LiveType r100 = new LiveType("PC_LIVE", 0);
        PC_LIVE = r100;
        LiveType r101 = new LiveType("VIDEO", 1);
        VIDEO = r101;
        LiveType r102 = new LiveType(AccountType.OTHERS, 2);
        OTHERS = r102;
        LiveType r103 = new LiveType("AUDIO", 3);
        AUDIO = r103;
        LiveType r104 = new LiveType("SCREEN_RECORD", 4);
        SCREEN_RECORD = r104;
        f94594a = new LiveType[]{r100, r101, r102, r103, r104};
    }

    public static LiveType valueOf(String r100) {
        return (LiveType) a.a(LiveType.class, r100);
    }

    public static LiveType[] values() {
        return (LiveType[]) f94594a.clone();
    }

    public LiveType(String r100, int r101) {
        super(r100, r101);
    }
}
