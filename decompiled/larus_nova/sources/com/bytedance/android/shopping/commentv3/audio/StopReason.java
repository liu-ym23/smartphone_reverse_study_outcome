package com.bytedance.android.shopping.commentv3.audio;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/commentv3/audio/StopReason;", "", "USER_STOP", "PAGE_DISAPPEAR", "PAGE_DESTROY", "COMPONENT_HIDE", "LIST_REFRESH", "REPLAY_SAME_SLICE", "REPLACED_BY_OTHER", "PLAY_COMPLETE", "PLAY_ERROR", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum StopReason extends Enum<StopReason> {
    public static final StopReason COMPONENT_HIDE = null;
    public static final StopReason LIST_REFRESH = null;
    public static final StopReason PAGE_DESTROY = null;
    public static final StopReason PAGE_DISAPPEAR = null;
    public static final StopReason PLAY_COMPLETE = null;
    public static final StopReason PLAY_ERROR = null;
    public static final StopReason REPLACED_BY_OTHER = null;
    public static final StopReason REPLAY_SAME_SLICE = null;
    public static final StopReason USER_STOP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ StopReason[] f172599a = null;

    static {
        StopReason r100 = new StopReason("USER_STOP", 0);
        USER_STOP = r100;
        StopReason r101 = new StopReason("PAGE_DISAPPEAR", 1);
        PAGE_DISAPPEAR = r101;
        StopReason r102 = new StopReason("PAGE_DESTROY", 2);
        PAGE_DESTROY = r102;
        StopReason r103 = new StopReason("COMPONENT_HIDE", 3);
        COMPONENT_HIDE = r103;
        StopReason r104 = new StopReason("LIST_REFRESH", 4);
        LIST_REFRESH = r104;
        StopReason r105 = new StopReason("REPLAY_SAME_SLICE", 5);
        REPLAY_SAME_SLICE = r105;
        StopReason r106 = new StopReason("REPLACED_BY_OTHER", 6);
        REPLACED_BY_OTHER = r106;
        StopReason r107 = new StopReason("PLAY_COMPLETE", 7);
        PLAY_COMPLETE = r107;
        StopReason r108 = new StopReason("PLAY_ERROR", 8);
        PLAY_ERROR = r108;
        f172599a = new StopReason[]{r100, r101, r102, r103, r104, r105, r106, r107, r108};
    }

    public static StopReason valueOf(String r100) {
        return (StopReason) r27.a.a(StopReason.class, r100);
    }

    public static StopReason[] values() {
        return (StopReason[]) f172599a.clone();
    }

    public StopReason(String r100, int r101) {
        super(r100, r101);
    }
}
