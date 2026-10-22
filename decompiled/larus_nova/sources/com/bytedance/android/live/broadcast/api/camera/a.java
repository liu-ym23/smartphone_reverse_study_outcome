package com.bytedance.android.live.broadcast.api.camera;

import io.reactivex.disposables.Disposable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f58972a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f58973b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Disposable f58974c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f58975d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.bytedance.android.live.pushstream.d f58976e;

    /* JADX INFO: renamed from: com.bytedance.android.live.broadcast.api.camera.a$a, reason: collision with other inner class name */
    public static final class C0941a {
    }

    static {
    }

    public a(com.bytedance.android.live.pushstream.d r100) {
        Intrinsics.checkNotNullParameter(r100, "liveStream");
        Intrinsics.checkNotNullParameter("live_take_page", "eventPage");
        this.f58976e = r100;
        this.f58972a = LazyKt.lazy(CameraDirtyCheckController$mainHandler$2.INSTANCE);
        this.f58973b = new b();
        this.f58975d = "";
    }
}
