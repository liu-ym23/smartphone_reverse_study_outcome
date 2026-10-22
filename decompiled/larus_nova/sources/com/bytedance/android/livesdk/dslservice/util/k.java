package com.bytedance.android.livesdk.dslservice.util;

import com.bytedance.android.livesdk.dslservice.TriangleServiceWidget;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f122993a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f122994b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f122995c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Runnable f122996d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f122997e;

    public k(TriangleServiceWidget.b r100) {
        Intrinsics.checkNotNullParameter(r100, "runnable");
        this.f122996d = r100;
        this.f122997e = 1;
        this.f122995c = LazyKt.lazy(new IdleTaskHandler$mIdleHandler$2(this));
    }
}
