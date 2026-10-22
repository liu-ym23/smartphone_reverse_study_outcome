package com.bytedance.android.shopping.store.live.event;

import com.android.ttcjpaysdk.base.h5.cjjsb.constant.ErrorCode;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes14.dex */
public final class ShopLiveState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PlayState f185518a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LiveScene f185519b;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/store/live/event/ShopLiveState$LiveScene;", "", "PREVIEW", "FLOAT_WINDOW", "LIVE_TAB", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum LiveScene extends Enum<LiveScene> {
        public static final LiveScene FLOAT_WINDOW = null;
        public static final LiveScene LIVE_TAB = null;
        public static final LiveScene PREVIEW = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LiveScene[] f185520a = null;

        static {
            LiveScene r100 = new LiveScene("PREVIEW", 0);
            PREVIEW = r100;
            LiveScene r101 = new LiveScene("FLOAT_WINDOW", 1);
            FLOAT_WINDOW = r101;
            LiveScene r102 = new LiveScene("LIVE_TAB", 2);
            LIVE_TAB = r102;
            f185520a = new LiveScene[]{r100, r101, r102};
        }

        public static LiveScene valueOf(String r100) {
            return (LiveScene) a.a(LiveScene.class, r100);
        }

        public static LiveScene[] values() {
            return (LiveScene[]) f185520a.clone();
        }

        public LiveScene(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/store/live/event/ShopLiveState$PlayState;", "", ErrorCode.INIT, "ENTER_LIVE", "START_PLAY", "PLAYING", "STOP_PLAY", "STOP_SUCCESS", "RELEASE", "RESUMABLE_ERROR", "ERROR", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum PlayState extends Enum<PlayState> {
        public static final PlayState ENTER_LIVE = null;
        public static final PlayState ERROR = null;
        public static final PlayState INIT = null;
        public static final PlayState PLAYING = null;
        public static final PlayState RELEASE = null;
        public static final PlayState RESUMABLE_ERROR = null;
        public static final PlayState START_PLAY = null;
        public static final PlayState STOP_PLAY = null;
        public static final PlayState STOP_SUCCESS = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ PlayState[] f185521a = null;

        static {
            PlayState r100 = new PlayState(ErrorCode.INIT, 0);
            INIT = r100;
            PlayState r101 = new PlayState("ENTER_LIVE", 1);
            ENTER_LIVE = r101;
            PlayState r102 = new PlayState("START_PLAY", 2);
            START_PLAY = r102;
            PlayState r103 = new PlayState("PLAYING", 3);
            PLAYING = r103;
            PlayState r104 = new PlayState("STOP_PLAY", 4);
            STOP_PLAY = r104;
            PlayState r105 = new PlayState("STOP_SUCCESS", 5);
            STOP_SUCCESS = r105;
            PlayState r106 = new PlayState("RELEASE", 6);
            RELEASE = r106;
            PlayState r107 = new PlayState("RESUMABLE_ERROR", 7);
            RESUMABLE_ERROR = r107;
            PlayState r108 = new PlayState("ERROR", 8);
            ERROR = r108;
            f185521a = new PlayState[]{r100, r101, r102, r103, r104, r105, r106, r107, r108};
        }

        public static PlayState valueOf(String r100) {
            return (PlayState) a.a(PlayState.class, r100);
        }

        public static PlayState[] values() {
            return (PlayState[]) f185521a.clone();
        }

        public PlayState(String r100, int r101) {
            super(r100, r101);
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ShopLiveState) == false) goto L10;
        ShopLiveState r101 = (ShopLiveState) r100;
        if (Intrinsics.areEqual(this.f185518a, r101.f185518a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f185519b, r101.f185519b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        PlayState r100 = this.f185518a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        LiveScene r104 = this.f185519b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ShopLiveState(playState=" + this.f185518a + ", liveScene=" + this.f185519b + ")";
    }

    public ShopLiveState(PlayState r100, LiveScene r101) {
        Intrinsics.checkNotNullParameter(r100, Keys.API_EVENT_KEY_PLAY_STATE);
        Intrinsics.checkNotNullParameter(r101, "liveScene");
        this.f185518a = r100;
        this.f185519b = r101;
    }
}
