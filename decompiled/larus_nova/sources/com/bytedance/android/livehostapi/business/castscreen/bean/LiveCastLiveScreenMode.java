package com.bytedance.android.livehostapi.business.castscreen.bean;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livehostapi/business/castscreen/bean/LiveCastLiveScreenMode;", "", "(Ljava/lang/String;I)V", "PORTRAIT_SCREEN", "LANDSCAPE_SCREEN", "FULL_SCREEN", "hostapp-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveCastLiveScreenMode extends Enum<LiveCastLiveScreenMode> {
    private static final /* synthetic */ LiveCastLiveScreenMode[] $VALUES = null;
    public static final LiveCastLiveScreenMode FULL_SCREEN = null;
    public static final LiveCastLiveScreenMode LANDSCAPE_SCREEN = null;
    public static final LiveCastLiveScreenMode PORTRAIT_SCREEN = null;

    static {
        LiveCastLiveScreenMode r100 = new LiveCastLiveScreenMode("PORTRAIT_SCREEN", 0);
        PORTRAIT_SCREEN = r100;
        LiveCastLiveScreenMode r101 = new LiveCastLiveScreenMode("LANDSCAPE_SCREEN", 1);
        LANDSCAPE_SCREEN = r101;
        LiveCastLiveScreenMode r102 = new LiveCastLiveScreenMode("FULL_SCREEN", 2);
        FULL_SCREEN = r102;
        $VALUES = new LiveCastLiveScreenMode[]{r100, r101, r102};
    }

    public static LiveCastLiveScreenMode valueOf(String r100) {
        return (LiveCastLiveScreenMode) a.a(LiveCastLiveScreenMode.class, r100);
    }

    public static LiveCastLiveScreenMode[] values() {
        return (LiveCastLiveScreenMode[]) $VALUES.clone();
    }

    private LiveCastLiveScreenMode(String r100, int r101) {
        super(r100, r101);
    }
}
