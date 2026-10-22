package com.bytedance.android.livesdk.performance.aapleasure;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/performance/aapleasure/ExperienceSceneLevel;", "", "", "level", "I", "getLevel", "()I", EffectConstants.NORMAL, "SERIOUS", "CRITICAL", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ExperienceSceneLevel extends Enum<ExperienceSceneLevel> {
    public static final ExperienceSceneLevel CRITICAL = null;
    public static final ExperienceSceneLevel NORMAL = null;
    public static final ExperienceSceneLevel SERIOUS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ExperienceSceneLevel[] f154411a = null;
    private final int level;

    static {
        ExperienceSceneLevel r100 = new ExperienceSceneLevel(EffectConstants.NORMAL, 0, 0);
        NORMAL = r100;
        ExperienceSceneLevel r101 = new ExperienceSceneLevel("SERIOUS", 1, -1);
        SERIOUS = r101;
        ExperienceSceneLevel r102 = new ExperienceSceneLevel("CRITICAL", 2, -2);
        CRITICAL = r102;
        f154411a = new ExperienceSceneLevel[]{r100, r101, r102};
    }

    public static ExperienceSceneLevel valueOf(String r100) {
        return (ExperienceSceneLevel) r27.a.a(ExperienceSceneLevel.class, r100);
    }

    public static ExperienceSceneLevel[] values() {
        return (ExperienceSceneLevel[]) f154411a.clone();
    }

    public final int getLevel() {
        return this.level;
    }

    public ExperienceSceneLevel(String r100, int r101, int r102) {
        super(r100, r101);
        this.level = r102;
    }
}
