package com.bytedance.android.livesdk.interactivity.api.degrade.model.config;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/degrade/model/config/TapLikeFeatureLevel;", "", "", "level", "I", "getLevel", "()I", "LEVEL_DEFAULT", "LEVEL_ONE", "LEVEL_TWO", "LEVEL_THREE", "LEVEL_SMART", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum TapLikeFeatureLevel extends Enum<TapLikeFeatureLevel> {
    public static final TapLikeFeatureLevel LEVEL_DEFAULT = null;
    public static final TapLikeFeatureLevel LEVEL_ONE = null;
    public static final TapLikeFeatureLevel LEVEL_SMART = null;
    public static final TapLikeFeatureLevel LEVEL_THREE = null;
    public static final TapLikeFeatureLevel LEVEL_TWO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TapLikeFeatureLevel[] f133117a = null;
    private final int level;

    static {
        TapLikeFeatureLevel r100 = new TapLikeFeatureLevel("LEVEL_DEFAULT", 0, 0);
        LEVEL_DEFAULT = r100;
        TapLikeFeatureLevel r101 = new TapLikeFeatureLevel("LEVEL_ONE", 1, 100);
        LEVEL_ONE = r101;
        TapLikeFeatureLevel r102 = new TapLikeFeatureLevel("LEVEL_TWO", 2, 200);
        LEVEL_TWO = r102;
        TapLikeFeatureLevel r103 = new TapLikeFeatureLevel("LEVEL_THREE", 3, 300);
        LEVEL_THREE = r103;
        TapLikeFeatureLevel r104 = new TapLikeFeatureLevel("LEVEL_SMART", 4, 999);
        LEVEL_SMART = r104;
        f133117a = new TapLikeFeatureLevel[]{r100, r101, r102, r103, r104};
    }

    public static TapLikeFeatureLevel valueOf(String r100) {
        return (TapLikeFeatureLevel) a.a(TapLikeFeatureLevel.class, r100);
    }

    public static TapLikeFeatureLevel[] values() {
        return (TapLikeFeatureLevel[]) f133117a.clone();
    }

    public final int getLevel() {
        return this.level;
    }

    public TapLikeFeatureLevel(String r100, int r101, int r102) {
        super(r100, r101);
        this.level = r102;
    }
}
