package com.bytedance.android.livesdk.interactivity.api.degrade.model.config;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/degrade/model/config/HotCommentFeatureLevel;", "", "", "level", "I", "getLevel", "()I", "LEVEL_DEFAULT", "LEVEL_ONE", "LEVEL_TWO", "LEVEL_SMART", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum HotCommentFeatureLevel extends Enum<HotCommentFeatureLevel> {
    public static final HotCommentFeatureLevel LEVEL_DEFAULT = null;
    public static final HotCommentFeatureLevel LEVEL_ONE = null;
    public static final HotCommentFeatureLevel LEVEL_SMART = null;
    public static final HotCommentFeatureLevel LEVEL_TWO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ HotCommentFeatureLevel[] f133114a = null;
    private final int level;

    static {
        HotCommentFeatureLevel r100 = new HotCommentFeatureLevel("LEVEL_DEFAULT", 0, 0);
        LEVEL_DEFAULT = r100;
        HotCommentFeatureLevel r101 = new HotCommentFeatureLevel("LEVEL_ONE", 1, 100);
        LEVEL_ONE = r101;
        HotCommentFeatureLevel r102 = new HotCommentFeatureLevel("LEVEL_TWO", 2, 200);
        LEVEL_TWO = r102;
        HotCommentFeatureLevel r103 = new HotCommentFeatureLevel("LEVEL_SMART", 3, 999);
        LEVEL_SMART = r103;
        f133114a = new HotCommentFeatureLevel[]{r100, r101, r102, r103};
    }

    public static HotCommentFeatureLevel valueOf(String r100) {
        return (HotCommentFeatureLevel) a.a(HotCommentFeatureLevel.class, r100);
    }

    public static HotCommentFeatureLevel[] values() {
        return (HotCommentFeatureLevel[]) f133114a.clone();
    }

    public final int getLevel() {
        return this.level;
    }

    public HotCommentFeatureLevel(String r100, int r101, int r102) {
        super(r100, r101);
        this.level = r102;
    }
}
