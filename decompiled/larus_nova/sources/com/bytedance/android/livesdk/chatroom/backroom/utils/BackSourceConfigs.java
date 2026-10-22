package com.bytedance.android.livesdk.chatroom.backroom.utils;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes7.dex */
public final class BackSourceConfigs {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f105113a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f105114b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f105115c = null;

    static {
        f105113a = LazyKt.lazy(BackSourceConfigs$blackListBackSources$2.INSTANCE);
        f105114b = LazyKt.lazy(BackSourceConfigs$multiBackSources$2.INSTANCE);
        f105115c = LazyKt.lazy(BackSourceConfigs$singleBackSources$2.INSTANCE);
    }
}
