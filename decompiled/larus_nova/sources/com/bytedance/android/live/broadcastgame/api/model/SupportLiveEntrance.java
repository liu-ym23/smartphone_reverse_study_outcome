package com.bytedance.android.live.broadcastgame.api.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\t\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/api/model/SupportLiveEntrance;", "", "", "value", "J", "getValue", "()J", "ALL_ENTRANCE", "SINGLE", "DOUBLE", "MULTI", "livebroadcastgame-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum SupportLiveEntrance extends Enum<SupportLiveEntrance> {
    public static final SupportLiveEntrance ALL_ENTRANCE = null;
    public static final SupportLiveEntrance DOUBLE = null;
    public static final SupportLiveEntrance MULTI = null;
    public static final SupportLiveEntrance SINGLE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SupportLiveEntrance[] f59333a = null;
    private final long value;

    static {
        SupportLiveEntrance r100 = new SupportLiveEntrance("ALL_ENTRANCE", 0, 0);
        ALL_ENTRANCE = r100;
        SupportLiveEntrance r101 = new SupportLiveEntrance("SINGLE", 1, 1);
        SINGLE = r101;
        SupportLiveEntrance r102 = new SupportLiveEntrance("DOUBLE", 2, 2);
        DOUBLE = r102;
        SupportLiveEntrance r103 = new SupportLiveEntrance("MULTI", 3, 3);
        MULTI = r103;
        f59333a = new SupportLiveEntrance[]{r100, r101, r102, r103};
    }

    public static SupportLiveEntrance valueOf(String r100) {
        return (SupportLiveEntrance) r27.a.a(SupportLiveEntrance.class, r100);
    }

    public static SupportLiveEntrance[] values() {
        return (SupportLiveEntrance[]) f59333a.clone();
    }

    public final long getValue() {
        return this.value;
    }

    public SupportLiveEntrance(String r100, int r101, long r102) {
        super(r100, r101);
        this.value = r102;
    }
}
