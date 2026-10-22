package com.bytedance.android.ecom.bcm.track.api.p003const;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/ecom/bcm/track/api/const/AppendScene;", "", "UnKnown", "GlobalProps", "EnterStorePage", "UltimateBuy", "bcm-track-api_release"}, k = 1, mv = {1, 4, 0})
public final enum AppendScene extends Enum<AppendScene> {
    public static final AppendScene EnterStorePage = null;
    public static final AppendScene GlobalProps = null;
    public static final AppendScene UltimateBuy = null;
    public static final AppendScene UnKnown = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AppendScene[] f51064a = null;

    static {
        AppendScene r100 = new AppendScene("UnKnown", 0);
        UnKnown = r100;
        AppendScene r101 = new AppendScene("GlobalProps", 1);
        GlobalProps = r101;
        AppendScene r102 = new AppendScene("EnterStorePage", 2);
        EnterStorePage = r102;
        AppendScene r103 = new AppendScene("UltimateBuy", 3);
        UltimateBuy = r103;
        f51064a = new AppendScene[]{r100, r101, r102, r103};
    }

    public static AppendScene valueOf(String r100) {
        return (AppendScene) a.a(AppendScene.class, r100);
    }

    public static AppendScene[] values() {
        return (AppendScene[]) f51064a.clone();
    }

    public AppendScene(String r100, int r101) {
        super(r100, r101);
    }
}
