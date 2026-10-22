package com.bytedance.android.livesdk.config;

import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public final class so extends SSettingKey<List<? extends String>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final so f121241a = null;

    static {
        f121241a = new so();
    }

    public so() {
        List<String> r100 = d81.f120006a;
        super("live_dispose_room_context_on_end_room_scenes", "在特定场景下endRoom时补充调用disposeDataContext", r100, r100);
    }
}
