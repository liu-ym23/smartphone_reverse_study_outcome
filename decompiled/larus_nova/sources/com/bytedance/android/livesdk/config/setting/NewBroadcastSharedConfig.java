package com.bytedance.android.livesdk.config.setting;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes8.dex */
public final class NewBroadcastSharedConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f121204a = null;

    static {
        f121204a = LazyKt.lazy(NewBroadcastSharedConfig$isSharedOpen$2.INSTANCE);
    }

    public static Boolean a() {
        return (Boolean) f121204a.getValue();
    }
}
