package com.bytedance.android.livesdk.interactivity.medialink.ui.player.utils;

import com.obric.miniapp.alarm.AccountType;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/medialink/ui/player/utils/LiveType;", "", "PC_LIVE", "VIDEO", AccountType.OTHERS, "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveType extends Enum<LiveType> {
    public static final LiveType OTHERS = null;
    public static final LiveType PC_LIVE = null;
    public static final LiveType VIDEO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveType[] f138331a = null;

    static {
        LiveType r100 = new LiveType("PC_LIVE", 0);
        PC_LIVE = r100;
        LiveType r101 = new LiveType("VIDEO", 1);
        VIDEO = r101;
        LiveType r102 = new LiveType(AccountType.OTHERS, 2);
        OTHERS = r102;
        f138331a = new LiveType[]{r100, r101, r102};
    }

    public static LiveType valueOf(String r100) {
        return (LiveType) a.a(LiveType.class, r100);
    }

    public static LiveType[] values() {
        return (LiveType[]) f138331a.clone();
    }

    public LiveType(String r100, int r101) {
        super(r100, r101);
    }
}
