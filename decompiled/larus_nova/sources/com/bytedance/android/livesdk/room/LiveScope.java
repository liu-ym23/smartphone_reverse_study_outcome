package com.bytedance.android.livesdk.room;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/room/LiveScope;", "", "", "des", "Ljava/lang/String;", "getDes", "()Ljava/lang/String;", "LIVE", "SESSION", "ROOM", "room-flow_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveScope extends Enum<LiveScope> {
    public static final LiveScope LIVE = null;
    public static final LiveScope ROOM = null;
    public static final LiveScope SESSION = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveScope[] f157549a = null;
    private final String des;

    static {
        LiveScope r100 = new LiveScope("LIVE", 0, "直播维度");
        LIVE = r100;
        LiveScope r101 = new LiveScope("SESSION", 1, "内流维度");
        SESSION = r101;
        LiveScope r102 = new LiveScope("ROOM", 2, "单直播间维度");
        ROOM = r102;
        f157549a = new LiveScope[]{r100, r101, r102};
    }

    public static LiveScope valueOf(String r100) {
        return (LiveScope) r27.a.a(LiveScope.class, r100);
    }

    public static LiveScope[] values() {
        return (LiveScope[]) f157549a.clone();
    }

    public final String getDes() {
        return this.des;
    }

    public LiveScope(String r100, int r101, String r102) {
        super(r100, r101);
        this.des = r102;
    }

    public /* synthetic */ LiveScope(String r100, int r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L5;
        r102 = "";
    L5:
        this(r100, r101, r102);
    }
}
