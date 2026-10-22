package com.bytedance.android.livesdk.popup;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/popup/LiveRepelPopupRegion;", "", "", EffectConfiguration.KEY_REGION, "Ljava/lang/String;", "getRegion", "()Ljava/lang/String;", UserProfileEvent.POSITION_NONE, "ROOM", "PREVIEW", "ROOM_FULL", "ROOM_TOP", "ROOM_BOTTOM", "PREVIEW_FULL", "PREVIEW_RIGHT", "PREVIEW_BOTTOM", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveRepelPopupRegion extends Enum<LiveRepelPopupRegion> {
    public static final LiveRepelPopupRegion NONE = null;
    public static final LiveRepelPopupRegion PREVIEW = null;
    public static final LiveRepelPopupRegion PREVIEW_BOTTOM = null;
    public static final LiveRepelPopupRegion PREVIEW_FULL = null;
    public static final LiveRepelPopupRegion PREVIEW_RIGHT = null;
    public static final LiveRepelPopupRegion ROOM = null;
    public static final LiveRepelPopupRegion ROOM_BOTTOM = null;
    public static final LiveRepelPopupRegion ROOM_FULL = null;
    public static final LiveRepelPopupRegion ROOM_TOP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveRepelPopupRegion[] f156274a = null;
    private final String region;

    public static LiveRepelPopupRegion valueOf(String r100) {
        return (LiveRepelPopupRegion) a.a(LiveRepelPopupRegion.class, r100);
    }

    public static LiveRepelPopupRegion[] values() {
        return (LiveRepelPopupRegion[]) f156274a.clone();
    }

    static {
        LiveRepelPopupRegion r100 = new LiveRepelPopupRegion(UserProfileEvent.POSITION_NONE, 0, "none");
        NONE = r100;
        LiveRepelPopupRegion r101 = new LiveRepelPopupRegion("ROOM", 1, "room");
        ROOM = r101;
        LiveRepelPopupRegion r102 = new LiveRepelPopupRegion("PREVIEW", 2, "preview");
        PREVIEW = r102;
        LiveRepelPopupRegion r103 = new LiveRepelPopupRegion("ROOM_FULL", 3, "room_full");
        ROOM_FULL = r103;
        LiveRepelPopupRegion r104 = new LiveRepelPopupRegion("ROOM_TOP", 4, "room_top");
        ROOM_TOP = r104;
        LiveRepelPopupRegion r105 = new LiveRepelPopupRegion("ROOM_BOTTOM", 5, "room_bottom");
        ROOM_BOTTOM = r105;
        LiveRepelPopupRegion r106 = new LiveRepelPopupRegion("PREVIEW_FULL", 6, "preview_full");
        PREVIEW_FULL = r106;
        LiveRepelPopupRegion r107 = new LiveRepelPopupRegion("PREVIEW_RIGHT", 7, "preview_right");
        PREVIEW_RIGHT = r107;
        LiveRepelPopupRegion r108 = new LiveRepelPopupRegion("PREVIEW_BOTTOM", 8, "preview_bottom");
        PREVIEW_BOTTOM = r108;
        f156274a = new LiveRepelPopupRegion[]{r100, r101, r102, r103, r104, r105, r106, r107, r108};
    }

    public final String getRegion() {
        return this.region;
    }

    public LiveRepelPopupRegion(String r100, int r101, String r102) {
        super(r100, r101);
        this.region = r102;
    }
}
