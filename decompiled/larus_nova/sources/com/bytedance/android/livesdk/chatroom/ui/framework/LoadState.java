package com.bytedance.android.livesdk.chatroom.ui.framework;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0014\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/framework/LoadState;", "", "", "value", "I", "getValue", "()I", UserProfileEvent.POSITION_NONE, "FS_BEGIN", "FS_END", "P0_BEGIN", "P0_END", "P0_REAL_END", "P1_BEGIN", "P1_END", "P1_REAL_END", "P2_BEGIN", "P2_END", "P2_REAL_END", "P3_BEGIN", "P3_END", "P3_REAL_END", "liveroom-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LoadState extends Enum<LoadState> {
    public static final LoadState FS_BEGIN = null;
    public static final LoadState FS_END = null;
    public static final LoadState NONE = null;
    public static final LoadState P0_BEGIN = null;
    public static final LoadState P0_END = null;
    public static final LoadState P0_REAL_END = null;
    public static final LoadState P1_BEGIN = null;
    public static final LoadState P1_END = null;
    public static final LoadState P1_REAL_END = null;
    public static final LoadState P2_BEGIN = null;
    public static final LoadState P2_END = null;
    public static final LoadState P2_REAL_END = null;
    public static final LoadState P3_BEGIN = null;
    public static final LoadState P3_END = null;
    public static final LoadState P3_REAL_END = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LoadState[] f112782a = null;
    private final int value;

    public static LoadState valueOf(String r100) {
        return (LoadState) r27.a.a(LoadState.class, r100);
    }

    public static LoadState[] values() {
        return (LoadState[]) f112782a.clone();
    }

    static {
        LoadState r100 = new LoadState(UserProfileEvent.POSITION_NONE, 0, 0);
        NONE = r100;
        LoadState r101 = new LoadState("FS_BEGIN", 1, 1);
        FS_BEGIN = r101;
        LoadState r102 = new LoadState("FS_END", 2, 2);
        FS_END = r102;
        LoadState r103 = new LoadState("P0_BEGIN", 3, 3);
        P0_BEGIN = r103;
        LoadState r104 = new LoadState("P0_END", 4, 4);
        P0_END = r104;
        LoadState r105 = new LoadState("P0_REAL_END", 5, 5);
        P0_REAL_END = r105;
        LoadState r106 = new LoadState("P1_BEGIN", 6, 6);
        P1_BEGIN = r106;
        LoadState r107 = new LoadState("P1_END", 7, 7);
        P1_END = r107;
        LoadState r108 = new LoadState("P1_REAL_END", 8, 8);
        P1_REAL_END = r108;
        LoadState r109 = new LoadState("P2_BEGIN", 9, 9);
        P2_BEGIN = r109;
        LoadState r110 = new LoadState("P2_END", 10, 10);
        P2_END = r110;
        LoadState r111 = new LoadState("P2_REAL_END", 11, 11);
        P2_REAL_END = r111;
        LoadState r112 = new LoadState("P3_BEGIN", 12, 12);
        P3_BEGIN = r112;
        LoadState r113 = new LoadState("P3_END", 13, 13);
        P3_END = r113;
        LoadState r114 = new LoadState("P3_REAL_END", 14, 14);
        P3_REAL_END = r114;
        f112782a = new LoadState[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114};
    }

    public final int getValue() {
        return this.value;
    }

    public LoadState(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
