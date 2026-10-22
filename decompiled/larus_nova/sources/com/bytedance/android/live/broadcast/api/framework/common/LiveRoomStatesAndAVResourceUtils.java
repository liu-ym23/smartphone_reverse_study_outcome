package com.bytedance.android.live.broadcast.api.framework.common;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes45.dex */
public final class LiveRoomStatesAndAVResourceUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f58989a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f58990b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f58991c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f58992d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f58993e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Lazy f58994f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Lazy f58995g = null;

    public static boolean a() {
        return ((Boolean) f58989a.getValue()).booleanValue();
    }

    static {
        f58989a = LazyKt.lazy(LiveRoomStatesAndAVResourceUtils$enableLiveAudioAndVideoOpt$2.INSTANCE);
        f58990b = LazyKt.lazy(LiveRoomStatesAndAVResourceUtils$enableLiveAudioAndVideoOptV2$2.INSTANCE);
        f58991c = LazyKt.lazy(LiveRoomStatesAndAVResourceUtils$enableLiveAudioAndVideoLogReport$2.INSTANCE);
        f58992d = LazyKt.lazy(LiveRoomStatesAndAVResourceUtils$enableLiveAudioAndVideoApiOpt$2.INSTANCE);
        f58993e = LazyKt.lazy(LiveRoomStatesAndAVResourceUtils$enableLivePreviewStreamMachineOpt$2.INSTANCE);
        f58994f = LazyKt.lazy(LiveRoomStatesAndAVResourceUtils$enableSensitiveEventInRoomOpt$2.INSTANCE);
        f58995g = LazyKt.lazy(LiveRoomStatesAndAVResourceUtils$enablePrivacyFacadeOpt$2.INSTANCE);
    }

    public static boolean c() {
        if (((Boolean) f58990b.getValue()).booleanValue() == true) goto L5;
    L7:
        return false;
    L5:
        if (a() == false) goto L7;
        return true;
    }

    public static boolean b() {
        if (c() == true) goto L5;
    L7:
        return false;
    L5:
        if (((Boolean) f58992d.getValue()).booleanValue() == false) goto L7;
        return true;
    }
}
