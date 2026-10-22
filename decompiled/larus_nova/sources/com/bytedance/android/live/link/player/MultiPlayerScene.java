package com.bytedance.android.live.link.player;

import kotlin.Metadata;
import r27.a;
import rc0.k;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/link/player/MultiPlayerScene;", "", "", "toString", "IN_ROOM", "PREVIEW_FEED_FULL_SCREEN", "UNKNOWN", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum MultiPlayerScene extends Enum<MultiPlayerScene> {
    public static final MultiPlayerScene IN_ROOM = null;
    public static final MultiPlayerScene PREVIEW_FEED_FULL_SCREEN = null;
    public static final MultiPlayerScene UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MultiPlayerScene[] f70868a = null;

    static {
        MultiPlayerScene r100 = new MultiPlayerScene("IN_ROOM", 0);
        IN_ROOM = r100;
        MultiPlayerScene r101 = new MultiPlayerScene("PREVIEW_FEED_FULL_SCREEN", 1);
        PREVIEW_FEED_FULL_SCREEN = r101;
        MultiPlayerScene r102 = new MultiPlayerScene("UNKNOWN", 2);
        UNKNOWN = r102;
        f70868a = new MultiPlayerScene[]{r100, r101, r102};
    }

    public static MultiPlayerScene valueOf(String r100) {
        return (MultiPlayerScene) a.a(MultiPlayerScene.class, r100);
    }

    public static MultiPlayerScene[] values() {
        return (MultiPlayerScene[]) f70868a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        int r100 = k.f537044a[ordinal()];
        if (r100 != 1) goto L5;
        return "IN_ROOM";
    L5:
        if (r100 == 2) goto L7;
        return "UNKNOWN";
    L7:
        return "PREVIEW_FEED_FULL_SCREEN";
    }

    public MultiPlayerScene(String r100, int r101) {
        super(r100, r101);
    }
}
