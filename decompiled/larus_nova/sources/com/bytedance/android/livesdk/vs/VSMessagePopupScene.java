package com.bytedance.android.livesdk.vs;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/vs/VSMessagePopupScene;", "", "PORTRAIT_DANMAKU", "PORTRAIT_PUBLIC_SCREEN", "LANDSCAPE_DANMAKU", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum VSMessagePopupScene extends Enum<VSMessagePopupScene> {
    public static final VSMessagePopupScene LANDSCAPE_DANMAKU = null;
    public static final VSMessagePopupScene PORTRAIT_DANMAKU = null;
    public static final VSMessagePopupScene PORTRAIT_PUBLIC_SCREEN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VSMessagePopupScene[] f159370a = null;

    static {
        VSMessagePopupScene r100 = new VSMessagePopupScene("PORTRAIT_DANMAKU", 0);
        PORTRAIT_DANMAKU = r100;
        VSMessagePopupScene r101 = new VSMessagePopupScene("PORTRAIT_PUBLIC_SCREEN", 1);
        PORTRAIT_PUBLIC_SCREEN = r101;
        VSMessagePopupScene r102 = new VSMessagePopupScene("LANDSCAPE_DANMAKU", 2);
        LANDSCAPE_DANMAKU = r102;
        f159370a = new VSMessagePopupScene[]{r100, r101, r102};
    }

    public static VSMessagePopupScene valueOf(String r100) {
        return (VSMessagePopupScene) r27.a.a(VSMessagePopupScene.class, r100);
    }

    public static VSMessagePopupScene[] values() {
        return (VSMessagePopupScene[]) f159370a.clone();
    }

    public VSMessagePopupScene(String r100, int r101) {
        super(r100, r101);
    }
}
