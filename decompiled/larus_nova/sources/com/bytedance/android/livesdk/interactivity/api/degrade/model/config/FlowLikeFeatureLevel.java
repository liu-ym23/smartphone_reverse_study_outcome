package com.bytedance.android.livesdk.interactivity.api.degrade.model.config;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/degrade/model/config/FlowLikeFeatureLevel;", "", "", "level", "I", "getLevel", "()I", "LEVEL_DEFAULT", "LEVEL_ONE", "LEVEL_TWO", "LEVEL_THREE", "LEVEL_FOUR", "LEVEL_FIVE", "LEVEL_SMART", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum FlowLikeFeatureLevel extends Enum<FlowLikeFeatureLevel> {
    public static final FlowLikeFeatureLevel LEVEL_DEFAULT = null;
    public static final FlowLikeFeatureLevel LEVEL_FIVE = null;
    public static final FlowLikeFeatureLevel LEVEL_FOUR = null;
    public static final FlowLikeFeatureLevel LEVEL_ONE = null;
    public static final FlowLikeFeatureLevel LEVEL_SMART = null;
    public static final FlowLikeFeatureLevel LEVEL_THREE = null;
    public static final FlowLikeFeatureLevel LEVEL_TWO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FlowLikeFeatureLevel[] f133113a = null;
    private final int level;

    static {
        FlowLikeFeatureLevel r100 = new FlowLikeFeatureLevel("LEVEL_DEFAULT", 0, 0);
        LEVEL_DEFAULT = r100;
        FlowLikeFeatureLevel r101 = new FlowLikeFeatureLevel("LEVEL_ONE", 1, 100);
        LEVEL_ONE = r101;
        FlowLikeFeatureLevel r102 = new FlowLikeFeatureLevel("LEVEL_TWO", 2, 200);
        LEVEL_TWO = r102;
        FlowLikeFeatureLevel r103 = new FlowLikeFeatureLevel("LEVEL_THREE", 3, 300);
        LEVEL_THREE = r103;
        FlowLikeFeatureLevel r104 = new FlowLikeFeatureLevel("LEVEL_FOUR", 4, 400);
        LEVEL_FOUR = r104;
        FlowLikeFeatureLevel r105 = new FlowLikeFeatureLevel("LEVEL_FIVE", 5, 500);
        LEVEL_FIVE = r105;
        FlowLikeFeatureLevel r106 = new FlowLikeFeatureLevel("LEVEL_SMART", 6, 999);
        LEVEL_SMART = r106;
        f133113a = new FlowLikeFeatureLevel[]{r100, r101, r102, r103, r104, r105, r106};
    }

    public static FlowLikeFeatureLevel valueOf(String r100) {
        return (FlowLikeFeatureLevel) a.a(FlowLikeFeatureLevel.class, r100);
    }

    public static FlowLikeFeatureLevel[] values() {
        return (FlowLikeFeatureLevel[]) f133113a.clone();
    }

    public final int getLevel() {
        return this.level;
    }

    public FlowLikeFeatureLevel(String r100, int r101, int r102) {
        super(r100, r101);
        this.level = r102;
    }
}
