package com.bytedance.android.ec.model.live;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/ec/model/live/LiveClearScreenMode;", "", "CLEAR_SCREEN_MODE_NONE", "CLEAR_SCREEN_MODE_HALF", "CLEAR_SCREEN_MODE_FULL", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final enum LiveClearScreenMode extends Enum<LiveClearScreenMode> {
    public static final LiveClearScreenMode CLEAR_SCREEN_MODE_FULL = null;
    public static final LiveClearScreenMode CLEAR_SCREEN_MODE_HALF = null;
    public static final LiveClearScreenMode CLEAR_SCREEN_MODE_NONE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveClearScreenMode[] f47885a = null;

    static {
        LiveClearScreenMode r100 = new LiveClearScreenMode("CLEAR_SCREEN_MODE_NONE", 0);
        CLEAR_SCREEN_MODE_NONE = r100;
        LiveClearScreenMode r101 = new LiveClearScreenMode("CLEAR_SCREEN_MODE_HALF", 1);
        CLEAR_SCREEN_MODE_HALF = r101;
        LiveClearScreenMode r102 = new LiveClearScreenMode("CLEAR_SCREEN_MODE_FULL", 2);
        CLEAR_SCREEN_MODE_FULL = r102;
        f47885a = new LiveClearScreenMode[]{r100, r101, r102};
    }

    public static LiveClearScreenMode valueOf(String r100) {
        return (LiveClearScreenMode) r27.a.a(LiveClearScreenMode.class, r100);
    }

    public static LiveClearScreenMode[] values() {
        return (LiveClearScreenMode[]) f47885a.clone();
    }

    public LiveClearScreenMode(String r100, int r101) {
        super(r100, r101);
    }
}
