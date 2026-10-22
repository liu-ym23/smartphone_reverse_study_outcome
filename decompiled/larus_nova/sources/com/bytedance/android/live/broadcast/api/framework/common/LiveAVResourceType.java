package com.bytedance.android.live.broadcast.api.framework.common;

import com.obric.miniapp.alarm.AccountType;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/framework/common/LiveAVResourceType;", "", "", "value", "I", "getValue", "()I", "VIDEO", "AUDIO", AccountType.ALL, "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveAVResourceType extends Enum<LiveAVResourceType> {
    public static final LiveAVResourceType ALL = null;
    public static final LiveAVResourceType AUDIO = null;
    public static final LiveAVResourceType VIDEO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveAVResourceType[] f58985a = null;
    private final int value;

    static {
        LiveAVResourceType r100 = new LiveAVResourceType("VIDEO", 0, 0);
        VIDEO = r100;
        LiveAVResourceType r101 = new LiveAVResourceType("AUDIO", 1, 1);
        AUDIO = r101;
        LiveAVResourceType r102 = new LiveAVResourceType(AccountType.ALL, 2, 2);
        ALL = r102;
        f58985a = new LiveAVResourceType[]{r100, r101, r102};
    }

    public static LiveAVResourceType valueOf(String r100) {
        return (LiveAVResourceType) r27.a.a(LiveAVResourceType.class, r100);
    }

    public static LiveAVResourceType[] values() {
        return (LiveAVResourceType[]) f58985a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public LiveAVResourceType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
