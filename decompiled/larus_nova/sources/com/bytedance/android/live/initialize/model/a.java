package com.bytedance.android.live.initialize.model;

import com.bytedance.android.live.initialize.scheduler.WTOSchedulerNotify;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class a<T> implements wa0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<T> f69404a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<T, Unit> f69405b;

    public a(WTOSchedulerNotify r100, Function1 r101) {
        Intrinsics.checkNotNullParameter(r101, "onDispose");
        this.f69405b = r101;
        this.f69404a = new WeakReference(r100);
    }
}
