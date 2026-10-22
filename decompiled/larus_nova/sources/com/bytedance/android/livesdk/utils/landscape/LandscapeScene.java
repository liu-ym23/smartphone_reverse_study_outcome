package com.bytedance.android.livesdk.utils.landscape;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/utils/landscape/LandscapeScene;", "", "", "value", "I", "getValue", "()I", UserProfileEvent.POSITION_NONE, "ROTATE", "SLIDE", "JUMP", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LandscapeScene extends Enum<LandscapeScene> {
    public static final LandscapeScene JUMP = null;
    public static final LandscapeScene NONE = null;
    public static final LandscapeScene ROTATE = null;
    public static final LandscapeScene SLIDE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LandscapeScene[] f159060a = null;
    private final int value;

    static {
        LandscapeScene r100 = new LandscapeScene(UserProfileEvent.POSITION_NONE, 0, 0);
        NONE = r100;
        LandscapeScene r101 = new LandscapeScene("ROTATE", 1, 1);
        ROTATE = r101;
        LandscapeScene r102 = new LandscapeScene("SLIDE", 2, 2);
        SLIDE = r102;
        LandscapeScene r103 = new LandscapeScene("JUMP", 3, 3);
        JUMP = r103;
        f159060a = new LandscapeScene[]{r100, r101, r102, r103};
    }

    public static LandscapeScene valueOf(String r100) {
        return (LandscapeScene) r27.a.a(LandscapeScene.class, r100);
    }

    public static LandscapeScene[] values() {
        return (LandscapeScene[]) f159060a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public LandscapeScene(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
