package com.bytedance.android.live.core.utils;

import com.bytedance.android.livesdkapi.model.LiveRoomMemoryOptConfigV2;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes45.dex */
public final class LiveRoomMemoryCacheOptUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f66068a = null;

    static {
        f66068a = LazyKt.lazy(LiveRoomMemoryCacheOptUtils$config$2.INSTANCE);
    }

    @JvmStatic
    public static final boolean a() {
        return ((LiveRoomMemoryOptConfigV2) f66068a.getValue()).getEnable();
    }
}
