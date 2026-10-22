package com.bytedance.android.livesdk.gift.platform.business.jsbridge.methods;

import com.larus.network.http.ServiceType;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u0004\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/jsbridge/methods/AIWishGiftRoomScene;", "", "", "value", "Ljava/lang/Number;", "getValue", "()Ljava/lang/Number;", "Unknown", "Video", ServiceType.AUDIO, "External", "ScreenShot", "Media", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum AIWishGiftRoomScene extends Enum<AIWishGiftRoomScene> {
    public static final AIWishGiftRoomScene Audio = null;
    public static final AIWishGiftRoomScene External = null;
    public static final AIWishGiftRoomScene Media = null;
    public static final AIWishGiftRoomScene ScreenShot = null;
    public static final AIWishGiftRoomScene Unknown = null;
    public static final AIWishGiftRoomScene Video = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AIWishGiftRoomScene[] f129675a = null;
    private final Number value;

    static {
        AIWishGiftRoomScene r100 = new AIWishGiftRoomScene("Unknown", 0, -1);
        Unknown = r100;
        AIWishGiftRoomScene r101 = new AIWishGiftRoomScene("Video", 1, 0);
        Video = r101;
        AIWishGiftRoomScene r102 = new AIWishGiftRoomScene(ServiceType.AUDIO, 2, 1);
        Audio = r102;
        AIWishGiftRoomScene r103 = new AIWishGiftRoomScene("External", 3, 2);
        External = r103;
        AIWishGiftRoomScene r104 = new AIWishGiftRoomScene("ScreenShot", 4, 3);
        ScreenShot = r104;
        AIWishGiftRoomScene r105 = new AIWishGiftRoomScene("Media", 5, 5);
        Media = r105;
        f129675a = new AIWishGiftRoomScene[]{r100, r101, r102, r103, r104, r105};
    }

    public static AIWishGiftRoomScene valueOf(String r100) {
        return (AIWishGiftRoomScene) r27.a.a(AIWishGiftRoomScene.class, r100);
    }

    public static AIWishGiftRoomScene[] values() {
        return (AIWishGiftRoomScene[]) f129675a.clone();
    }

    public final Number getValue() {
        return this.value;
    }

    public AIWishGiftRoomScene(String r100, int r101, Number r102) {
        super(r100, r101);
        this.value = r102;
    }
}
