package com.bytedance.android.livesdk.chatroom.resolution.newresolution.processor;

import com.bytedance.android.livesdk.chatroom.resolution.AutoResolutionManager;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes7.dex */
public final class InnerResolutionProcessor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f110486a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f110487b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f110488c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f110489d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f110490e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Lazy f110491f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final AutoResolutionManager f110492g = null;

    static {
        f110486a = LazyKt.lazy(InnerResolutionProcessor$normalLiveLevelMemory$2.INSTANCE);
        f110487b = LazyKt.lazy(InnerResolutionProcessor$liveLevelMemoryTime$2.INSTANCE);
        f110488c = LazyKt.lazy(InnerResolutionProcessor$vsLiveLevelMemory$2.INSTANCE);
        f110489d = LazyKt.lazy(InnerResolutionProcessor$vrLiveLevelMemory$2.INSTANCE);
        f110490e = LazyKt.lazy(InnerResolutionProcessor$gameLiveLevelMemory$2.INSTANCE);
        f110491f = LazyKt.lazy(InnerResolutionProcessor$lastPlayResolutionKey$2.INSTANCE);
        f110492g = new AutoResolutionManager();
    }
}
