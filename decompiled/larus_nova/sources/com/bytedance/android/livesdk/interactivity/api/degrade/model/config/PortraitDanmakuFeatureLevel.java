package com.bytedance.android.livesdk.interactivity.api.degrade.model.config;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/degrade/model/config/PortraitDanmakuFeatureLevel;", "", "", "level", "I", "getLevel", "()I", "LEVEL_DEFAULT", "LEVEL_ONE", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PortraitDanmakuFeatureLevel extends Enum<PortraitDanmakuFeatureLevel> {
    public static final PortraitDanmakuFeatureLevel LEVEL_DEFAULT = null;
    public static final PortraitDanmakuFeatureLevel LEVEL_ONE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PortraitDanmakuFeatureLevel[] f133115a = null;
    private final int level;

    static {
        PortraitDanmakuFeatureLevel r100 = new PortraitDanmakuFeatureLevel("LEVEL_DEFAULT", 0, 0);
        LEVEL_DEFAULT = r100;
        PortraitDanmakuFeatureLevel r101 = new PortraitDanmakuFeatureLevel("LEVEL_ONE", 1, 100);
        LEVEL_ONE = r101;
        f133115a = new PortraitDanmakuFeatureLevel[]{r100, r101};
    }

    public static PortraitDanmakuFeatureLevel valueOf(String r100) {
        return (PortraitDanmakuFeatureLevel) a.a(PortraitDanmakuFeatureLevel.class, r100);
    }

    public static PortraitDanmakuFeatureLevel[] values() {
        return (PortraitDanmakuFeatureLevel[]) f133115a.clone();
    }

    public final int getLevel() {
        return this.level;
    }

    public PortraitDanmakuFeatureLevel(String r100, int r101, int r102) {
        super(r100, r101);
        this.level = r102;
    }
}
