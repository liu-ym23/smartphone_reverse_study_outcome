package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.MultiSceneOpt;

/* JADX INFO: loaded from: classes8.dex */
public final class kc0 extends SSettingKey<MultiSceneOpt> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final kc0 f120590a = null;

    static {
        f120590a = new kc0();
    }

    public kc0() {
        super("live_multi_scene_opt", "多人场景的体验优化开关", new MultiSceneOpt(), new MultiSceneOpt(), true);
    }
}
