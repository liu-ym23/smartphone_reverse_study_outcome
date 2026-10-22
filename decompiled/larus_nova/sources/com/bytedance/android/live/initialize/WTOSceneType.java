package com.bytedance.android.live.initialize;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/initialize/WTOSceneType;", "", "", "tag", "Ljava/lang/String;", "getTag", "()Ljava/lang/String;", "CURRENT", "PRELOAD", "COMMON", "live-initialize-annotation_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum WTOSceneType extends Enum<WTOSceneType> {
    public static final WTOSceneType COMMON = null;
    public static final WTOSceneType CURRENT = null;
    public static final WTOSceneType PRELOAD = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ WTOSceneType[] f69371a = null;
    private final String tag;

    static {
        WTOSceneType r100 = new WTOSceneType("CURRENT", 0, "CURRENT");
        CURRENT = r100;
        WTOSceneType r101 = new WTOSceneType("PRELOAD", 1, "PRELOAD");
        PRELOAD = r101;
        WTOSceneType r102 = new WTOSceneType("COMMON", 2, "COMMON");
        COMMON = r102;
        f69371a = new WTOSceneType[]{r100, r101, r102};
    }

    public static WTOSceneType valueOf(String r100) {
        return (WTOSceneType) r27.a.a(WTOSceneType.class, r100);
    }

    public static WTOSceneType[] values() {
        return (WTOSceneType[]) f69371a.clone();
    }

    public final String getTag() {
        return this.tag;
    }

    public WTOSceneType(String r100, int r101, String r102) {
        super(r100, r101);
        this.tag = r102;
    }
}
