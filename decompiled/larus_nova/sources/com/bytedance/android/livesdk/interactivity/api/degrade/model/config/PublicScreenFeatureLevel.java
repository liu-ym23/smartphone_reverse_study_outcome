package com.bytedance.android.livesdk.interactivity.api.degrade.model.config;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/degrade/model/config/PublicScreenFeatureLevel;", "", "", "level", "I", "getLevel", "()I", "LEVEL_DEFAULT", "LEVEL_ONE", "LEVEL_SMART", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PublicScreenFeatureLevel extends Enum<PublicScreenFeatureLevel> {
    public static final PublicScreenFeatureLevel LEVEL_DEFAULT = null;
    public static final PublicScreenFeatureLevel LEVEL_ONE = null;
    public static final PublicScreenFeatureLevel LEVEL_SMART = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PublicScreenFeatureLevel[] f133116a = null;
    private final int level;

    static {
        PublicScreenFeatureLevel r100 = new PublicScreenFeatureLevel("LEVEL_DEFAULT", 0, 0);
        LEVEL_DEFAULT = r100;
        PublicScreenFeatureLevel r101 = new PublicScreenFeatureLevel("LEVEL_ONE", 1, 100);
        LEVEL_ONE = r101;
        PublicScreenFeatureLevel r102 = new PublicScreenFeatureLevel("LEVEL_SMART", 2, 999);
        LEVEL_SMART = r102;
        f133116a = new PublicScreenFeatureLevel[]{r100, r101, r102};
    }

    public static PublicScreenFeatureLevel valueOf(String r100) {
        return (PublicScreenFeatureLevel) a.a(PublicScreenFeatureLevel.class, r100);
    }

    public static PublicScreenFeatureLevel[] values() {
        return (PublicScreenFeatureLevel[]) f133116a.clone();
    }

    public final int getLevel() {
        return this.level;
    }

    public PublicScreenFeatureLevel(String r100, int r101, int r102) {
        super(r100, r101);
        this.level = r102;
    }
}
