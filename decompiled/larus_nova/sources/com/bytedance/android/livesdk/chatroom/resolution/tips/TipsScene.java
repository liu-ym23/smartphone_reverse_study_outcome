package com.bytedance.android.livesdk.chatroom.resolution.tips;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/resolution/tips/TipsScene;", "", "", "type", "I", "getType", "()I", "", "des", "Ljava/lang/String;", "getDes", "()Ljava/lang/String;", UserProfileEvent.POSITION_NONE, "VS", "GAME", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum TipsScene extends Enum<TipsScene> {
    public static final TipsScene GAME = null;
    public static final TipsScene NONE = null;
    public static final TipsScene VS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TipsScene[] f110499a = null;
    private final String des;
    private final int type;

    static {
        TipsScene r100 = new TipsScene(UserProfileEvent.POSITION_NONE, 0, 0, "none");
        NONE = r100;
        TipsScene r101 = new TipsScene("VS", 1, 1, "vs");
        VS = r101;
        TipsScene r102 = new TipsScene("GAME", 2, 2, "game");
        GAME = r102;
        f110499a = new TipsScene[]{r100, r101, r102};
    }

    public static TipsScene valueOf(String r100) {
        return (TipsScene) a.a(TipsScene.class, r100);
    }

    public static TipsScene[] values() {
        return (TipsScene[]) f110499a.clone();
    }

    public final String getDes() {
        return this.des;
    }

    public final int getType() {
        return this.type;
    }

    public TipsScene(String r100, int r101, int r102, String r103) {
        super(r100, r101);
        this.type = r102;
        this.des = r103;
    }
}
