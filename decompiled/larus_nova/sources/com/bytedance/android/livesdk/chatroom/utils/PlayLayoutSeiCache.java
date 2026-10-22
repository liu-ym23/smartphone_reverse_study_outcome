package com.bytedance.android.livesdk.chatroom.utils;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes8.dex */
public final class PlayLayoutSeiCache {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f114369a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f114370b;

    public PlayLayoutSeiCache() {
        this.f114369a = LazyKt.lazy(PlayLayoutSeiCache$cacheSeiMap$2.INSTANCE);
    }
}
