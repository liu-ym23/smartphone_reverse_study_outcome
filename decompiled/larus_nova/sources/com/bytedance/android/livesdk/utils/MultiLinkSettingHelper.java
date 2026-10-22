package com.bytedance.android.livesdk.utils;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes11.dex */
public final class MultiLinkSettingHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f158771a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f158772b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f158773c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f158774d = null;

    public static boolean a() {
        return ((Boolean) f158774d.getValue()).booleanValue();
    }

    static {
        f158771a = LazyKt.lazy(MultiLinkSettingHelper$LIVE_PANEL_FIRST_FRAME_OPT$2.INSTANCE);
        f158772b = LazyKt.lazy(MultiLinkSettingHelper$LIVE_LINKMIC_LINK_SUCCESS_UPDATE_LIVECORE_PARAMS$2.INSTANCE);
        f158773c = LazyKt.lazy(MultiLinkSettingHelper$LIVE_LINKMIC_REQUEST_SONG_CONTINUE_BROADCAST_OPT$2.INSTANCE);
        f158774d = LazyKt.lazy(MultiLinkSettingHelper$LIVE_KTV_CORE_PATH_BUG_FIX_FALLBACK$2.INSTANCE);
    }
}
