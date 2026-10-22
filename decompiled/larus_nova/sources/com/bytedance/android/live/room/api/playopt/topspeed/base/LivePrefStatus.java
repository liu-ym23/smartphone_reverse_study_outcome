package com.bytedance.android.live.room.api.playopt.topspeed.base;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/room/api/playopt/topspeed/base/LivePrefStatus;", "", "", "code", "I", "getCode", "()I", "PREF_NORMAL", "PREF_MEDIUM", "PREF_SERIOUS", "experience-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LivePrefStatus extends Enum<LivePrefStatus> {
    public static final LivePrefStatus PREF_MEDIUM = null;
    public static final LivePrefStatus PREF_NORMAL = null;
    public static final LivePrefStatus PREF_SERIOUS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LivePrefStatus[] f99076a = null;
    private final int code;

    static {
        LivePrefStatus r100 = new LivePrefStatus("PREF_NORMAL", 0, 0);
        PREF_NORMAL = r100;
        LivePrefStatus r101 = new LivePrefStatus("PREF_MEDIUM", 1, -1);
        PREF_MEDIUM = r101;
        LivePrefStatus r102 = new LivePrefStatus("PREF_SERIOUS", 2, -2);
        PREF_SERIOUS = r102;
        f99076a = new LivePrefStatus[]{r100, r101, r102};
    }

    public static LivePrefStatus valueOf(String r100) {
        return (LivePrefStatus) a.a(LivePrefStatus.class, r100);
    }

    public static LivePrefStatus[] values() {
        return (LivePrefStatus[]) f99076a.clone();
    }

    public final int getCode() {
        return this.code;
    }

    public LivePrefStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.code = r102;
    }
}
