package com.bytedance.android.live.revlink.link.dynamiclayout.defaultconfig;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes47.dex */
public final class MediaDefaultConfig {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f98591d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f98592a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f98593b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f98594c;

    public static final class a {
    }

    static {
    }

    public MediaDefaultConfig() {
        this.f98592a = LazyKt.lazy(new MediaDefaultConfig$entrance$2(this));
        this.f98593b = LazyKt.lazy(new MediaDefaultConfig$normalConfig$2(this));
        this.f98594c = LazyKt.lazy(new MediaDefaultConfig$enlargeConfig$2(this));
    }
}
