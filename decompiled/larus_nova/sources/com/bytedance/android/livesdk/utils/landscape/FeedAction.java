package com.bytedance.android.livesdk.utils.landscape;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/utils/landscape/FeedAction;", "", "", "value", "I", "getValue", "()I", UserProfileEvent.POSITION_NONE, "PRODUCE", "CONSUME", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum FeedAction extends Enum<FeedAction> {
    public static final FeedAction CONSUME = null;
    public static final FeedAction NONE = null;
    public static final FeedAction PRODUCE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FeedAction[] f159058a = null;
    private final int value;

    static {
        FeedAction r100 = new FeedAction(UserProfileEvent.POSITION_NONE, 0, 0);
        NONE = r100;
        FeedAction r101 = new FeedAction("PRODUCE", 1, 1);
        PRODUCE = r101;
        FeedAction r102 = new FeedAction("CONSUME", 2, 2);
        CONSUME = r102;
        f159058a = new FeedAction[]{r100, r101, r102};
    }

    public static FeedAction valueOf(String r100) {
        return (FeedAction) r27.a.a(FeedAction.class, r100);
    }

    public static FeedAction[] values() {
        return (FeedAction[]) f159058a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public FeedAction(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
