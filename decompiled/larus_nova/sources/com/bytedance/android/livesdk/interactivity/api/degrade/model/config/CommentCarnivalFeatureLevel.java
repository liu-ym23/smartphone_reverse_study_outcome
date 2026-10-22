package com.bytedance.android.livesdk.interactivity.api.degrade.model.config;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/degrade/model/config/CommentCarnivalFeatureLevel;", "", "", "level", "I", "getLevel", "()I", "LEVEL_DEFAULT", "LEVEL_ONE", "LEVEL_SMART", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum CommentCarnivalFeatureLevel extends Enum<CommentCarnivalFeatureLevel> {
    public static final CommentCarnivalFeatureLevel LEVEL_DEFAULT = null;
    public static final CommentCarnivalFeatureLevel LEVEL_ONE = null;
    public static final CommentCarnivalFeatureLevel LEVEL_SMART = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CommentCarnivalFeatureLevel[] f133110a = null;
    private final int level;

    static {
        CommentCarnivalFeatureLevel r100 = new CommentCarnivalFeatureLevel("LEVEL_DEFAULT", 0, 0);
        LEVEL_DEFAULT = r100;
        CommentCarnivalFeatureLevel r101 = new CommentCarnivalFeatureLevel("LEVEL_ONE", 1, 100);
        LEVEL_ONE = r101;
        CommentCarnivalFeatureLevel r102 = new CommentCarnivalFeatureLevel("LEVEL_SMART", 2, 999);
        LEVEL_SMART = r102;
        f133110a = new CommentCarnivalFeatureLevel[]{r100, r101, r102};
    }

    public static CommentCarnivalFeatureLevel valueOf(String r100) {
        return (CommentCarnivalFeatureLevel) a.a(CommentCarnivalFeatureLevel.class, r100);
    }

    public static CommentCarnivalFeatureLevel[] values() {
        return (CommentCarnivalFeatureLevel[]) f133110a.clone();
    }

    public final int getLevel() {
        return this.level;
    }

    public CommentCarnivalFeatureLevel(String r100, int r101, int r102) {
        super(r100, r101);
        this.level = r102;
    }
}
