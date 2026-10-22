package com.bytedance.android.livesdk.chatroom.utils;

import com.bytedance.android.livesdkapi.config.FastStartLiveConfig;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes8.dex */
public final class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f114472a = 0;

    @JvmStatic
    public static final void a() {
        ((IPerformanceManager) jc1.k.n(IPerformanceManager.class)).onMultiModuleStop("link_mic_user_count");
        b();
        ((IPerformanceManager) jc1.k.n(IPerformanceManager.class)).onMultiModuleStop("interactive_scene");
    }

    @JvmStatic
    public static final void b() {
        ((IPerformanceManager) jc1.k.n(IPerformanceManager.class)).onMultiModuleStop("link_mic_ui_layout");
    }

    static {
    }

    @JvmStatic
    public static final void c(int r100) {
        ((IPerformanceManager) jc1.k.n(IPerformanceManager.class)).onMultiModuleStart("interactive_scene", r100);
    }

    @JvmStatic
    public static final void d(int r100) {
        ((IPerformanceManager) jc1.k.n(IPerformanceManager.class)).onMultiModuleStart("link_mic_ui_layout", r100);
    }

    @JvmStatic
    public static final void e(int r100) {
        ((IPerformanceManager) jc1.k.n(IPerformanceManager.class)).onMultiModuleStart("link_mic_user_count", r100);
    }

    @JvmStatic
    public static final void f(int[] r100) {
        Intrinsics.checkNotNullParameter(r100, Keys.API_EVENT_KEY_PLAY_MODE);
        ((IPerformanceManager) jc1.k.n(IPerformanceManager.class)).onMultiModuleStop(FastStartLiveConfig.PLAY_MODE);
        IPerformanceManager r101 = (IPerformanceManager) jc1.k.n(IPerformanceManager.class);
        JSONArray r102 = new JSONArray();
        int r103 = r100.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L5;
        r102.put(r100[r104]);
        r104 = r104 + 1;
        goto L3
    L5:
        r101.onMultiModuleStart(FastStartLiveConfig.PLAY_MODE, r102);
    }
}
