package com.bytedance.android.livesdk.vscore_api.paid;

import com.bytedance.android.live.network.annotation.PbRequest;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u001e\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001f¨\u0006 "}, d2 = {"Lcom/bytedance/android/livesdk/vscore_api/paid/PaidInteractEntry;", "", "", "key", "Ljava/lang/String;", "getKey", "()Ljava/lang/String;", "CONTROL_ENTRY_COMMENT", "CONTROL_ENTRY_CHAT_CHANNEL", "CONTROL_ENTRY_PUBLIC_SCREEN", "CONTROL_ENTRY_CASTSCREEN", "CONTROL_ENTRY_LANDSCAPE", "CONTROL_ENTRY_GIFT", "CONTROL_ENTRY_FANCLUB", "CONTROL_ENTRY_SUBSCRIBE", "CONTROL_ENTRY_PK", "CONTROL_ENTRY_ANCHOR_LINK", "CONTROL_ENTRY_AUDIENCE_LINK", "CONTROL_ENTRY_REPLAY_PROGRESSBAR", "CONTROL_ENTRY_FLOAT_WINDOW", "CONTROL_PAD_OPEN", "CONTROL_ENTRY_MULTI_CAMERA_PANEL", "CONTROL_ENTRY_COMMUNITY_MULTI_CAMERA", "CONTROL_ENTRY_MULTI_CAMERA_PANEL_AUTO_OPEN", "CONTROL_ENTRY_PLAYPAUSE", "CONTROL_ENTRY_DANMAKU", "CONTROL_ENTRY_GRAVITY_ORIENTATION", "CONTROL_ENTRY_GESTURE", "CONTROL_ENTRY_CASTSCREEN_QUIET", "CONTROL_ENTRY_SEEK_JSB", "CONTROL_ENTRY_PAID_LOTTERY", "CONTROL_ENTRY_PLAYER_SCALE_GESTURE", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PaidInteractEntry extends Enum<PaidInteractEntry> {
    public static final PaidInteractEntry CONTROL_ENTRY_ANCHOR_LINK = null;
    public static final PaidInteractEntry CONTROL_ENTRY_AUDIENCE_LINK = null;
    public static final PaidInteractEntry CONTROL_ENTRY_CASTSCREEN = null;
    public static final PaidInteractEntry CONTROL_ENTRY_CASTSCREEN_QUIET = null;
    public static final PaidInteractEntry CONTROL_ENTRY_CHAT_CHANNEL = null;
    public static final PaidInteractEntry CONTROL_ENTRY_COMMENT = null;
    public static final PaidInteractEntry CONTROL_ENTRY_COMMUNITY_MULTI_CAMERA = null;
    public static final PaidInteractEntry CONTROL_ENTRY_DANMAKU = null;
    public static final PaidInteractEntry CONTROL_ENTRY_FANCLUB = null;
    public static final PaidInteractEntry CONTROL_ENTRY_FLOAT_WINDOW = null;
    public static final PaidInteractEntry CONTROL_ENTRY_GESTURE = null;
    public static final PaidInteractEntry CONTROL_ENTRY_GIFT = null;
    public static final PaidInteractEntry CONTROL_ENTRY_GRAVITY_ORIENTATION = null;
    public static final PaidInteractEntry CONTROL_ENTRY_LANDSCAPE = null;
    public static final PaidInteractEntry CONTROL_ENTRY_MULTI_CAMERA_PANEL = null;
    public static final PaidInteractEntry CONTROL_ENTRY_MULTI_CAMERA_PANEL_AUTO_OPEN = null;
    public static final PaidInteractEntry CONTROL_ENTRY_PAID_LOTTERY = null;
    public static final PaidInteractEntry CONTROL_ENTRY_PK = null;
    public static final PaidInteractEntry CONTROL_ENTRY_PLAYER_SCALE_GESTURE = null;
    public static final PaidInteractEntry CONTROL_ENTRY_PLAYPAUSE = null;
    public static final PaidInteractEntry CONTROL_ENTRY_PUBLIC_SCREEN = null;
    public static final PaidInteractEntry CONTROL_ENTRY_REPLAY_PROGRESSBAR = null;
    public static final PaidInteractEntry CONTROL_ENTRY_SEEK_JSB = null;
    public static final PaidInteractEntry CONTROL_ENTRY_SUBSCRIBE = null;
    public static final PaidInteractEntry CONTROL_PAD_OPEN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PaidInteractEntry[] f159400a = null;
    private final String key;

    public static PaidInteractEntry valueOf(String r100) {
        return (PaidInteractEntry) a.a(PaidInteractEntry.class, r100);
    }

    public static PaidInteractEntry[] values() {
        return (PaidInteractEntry[]) f159400a.clone();
    }

    static {
        PaidInteractEntry r100 = new PaidInteractEntry("CONTROL_ENTRY_COMMENT", 0, "comment");
        CONTROL_ENTRY_COMMENT = r100;
        PaidInteractEntry r101 = new PaidInteractEntry("CONTROL_ENTRY_CHAT_CHANNEL", 1, "comment");
        CONTROL_ENTRY_CHAT_CHANNEL = r101;
        PaidInteractEntry r102 = new PaidInteractEntry("CONTROL_ENTRY_PUBLIC_SCREEN", 2, "public_screen");
        CONTROL_ENTRY_PUBLIC_SCREEN = r102;
        PaidInteractEntry r103 = new PaidInteractEntry("CONTROL_ENTRY_CASTSCREEN", 3, "castscreen");
        CONTROL_ENTRY_CASTSCREEN = r103;
        PaidInteractEntry r104 = new PaidInteractEntry("CONTROL_ENTRY_LANDSCAPE", 4, "landscape");
        CONTROL_ENTRY_LANDSCAPE = r104;
        PaidInteractEntry r105 = new PaidInteractEntry("CONTROL_ENTRY_GIFT", 5, PbRequest.SwitchType.GIFT);
        CONTROL_ENTRY_GIFT = r105;
        PaidInteractEntry r106 = new PaidInteractEntry("CONTROL_ENTRY_FANCLUB", 6, "fanclub");
        CONTROL_ENTRY_FANCLUB = r106;
        PaidInteractEntry r107 = new PaidInteractEntry("CONTROL_ENTRY_SUBSCRIBE", 7, "subscribe");
        CONTROL_ENTRY_SUBSCRIBE = r107;
        PaidInteractEntry r108 = new PaidInteractEntry("CONTROL_ENTRY_PK", 8, "comment");
        CONTROL_ENTRY_PK = r108;
        PaidInteractEntry r109 = new PaidInteractEntry("CONTROL_ENTRY_ANCHOR_LINK", 9, "anchor_link");
        CONTROL_ENTRY_ANCHOR_LINK = r109;
        PaidInteractEntry r110 = new PaidInteractEntry("CONTROL_ENTRY_AUDIENCE_LINK", 10, "anchor_link");
        CONTROL_ENTRY_AUDIENCE_LINK = r110;
        PaidInteractEntry r111 = new PaidInteractEntry("CONTROL_ENTRY_REPLAY_PROGRESSBAR", 11, "replay_progressbar");
        CONTROL_ENTRY_REPLAY_PROGRESSBAR = r111;
        PaidInteractEntry r112 = new PaidInteractEntry("CONTROL_ENTRY_FLOAT_WINDOW", 12, "float_window");
        CONTROL_ENTRY_FLOAT_WINDOW = r112;
        PaidInteractEntry r113 = new PaidInteractEntry("CONTROL_PAD_OPEN", 13, "pad_open");
        CONTROL_PAD_OPEN = r113;
        PaidInteractEntry r114 = new PaidInteractEntry("CONTROL_ENTRY_MULTI_CAMERA_PANEL", 14, "multi_camera");
        CONTROL_ENTRY_MULTI_CAMERA_PANEL = r114;
        PaidInteractEntry r115 = new PaidInteractEntry("CONTROL_ENTRY_COMMUNITY_MULTI_CAMERA", 15, "community_multi_camera");
        CONTROL_ENTRY_COMMUNITY_MULTI_CAMERA = r115;
        PaidInteractEntry r116 = new PaidInteractEntry("CONTROL_ENTRY_MULTI_CAMERA_PANEL_AUTO_OPEN", 16, "multi_camera");
        CONTROL_ENTRY_MULTI_CAMERA_PANEL_AUTO_OPEN = r116;
        PaidInteractEntry r117 = new PaidInteractEntry("CONTROL_ENTRY_PLAYPAUSE", 17, "playpause");
        CONTROL_ENTRY_PLAYPAUSE = r117;
        PaidInteractEntry r118 = new PaidInteractEntry("CONTROL_ENTRY_DANMAKU", 18, "danmaku");
        CONTROL_ENTRY_DANMAKU = r118;
        PaidInteractEntry r119 = new PaidInteractEntry("CONTROL_ENTRY_GRAVITY_ORIENTATION", 19, "gravity_orientation");
        CONTROL_ENTRY_GRAVITY_ORIENTATION = r119;
        PaidInteractEntry r120 = new PaidInteractEntry("CONTROL_ENTRY_GESTURE", 20, "gesture");
        CONTROL_ENTRY_GESTURE = r120;
        PaidInteractEntry r121 = new PaidInteractEntry("CONTROL_ENTRY_CASTSCREEN_QUIET", 21, "castscreen");
        CONTROL_ENTRY_CASTSCREEN_QUIET = r121;
        PaidInteractEntry r122 = new PaidInteractEntry("CONTROL_ENTRY_SEEK_JSB", 22, "seek_jsb");
        CONTROL_ENTRY_SEEK_JSB = r122;
        PaidInteractEntry r123 = new PaidInteractEntry("CONTROL_ENTRY_PAID_LOTTERY", 23, "paid_lottery");
        CONTROL_ENTRY_PAID_LOTTERY = r123;
        PaidInteractEntry r124 = new PaidInteractEntry("CONTROL_ENTRY_PLAYER_SCALE_GESTURE", 24, "player_scale_gesture");
        CONTROL_ENTRY_PLAYER_SCALE_GESTURE = r124;
        f159400a = new PaidInteractEntry[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r120, r121, r122, r123, r124};
    }

    public final String getKey() {
        return this.key;
    }

    public PaidInteractEntry(String r100, int r101, String r102) {
        super(r100, r101);
        this.key = r102;
    }
}
