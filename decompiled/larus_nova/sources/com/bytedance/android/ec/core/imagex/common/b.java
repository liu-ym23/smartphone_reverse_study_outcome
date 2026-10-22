package com.bytedance.android.ec.core.imagex.common;

import android.os.Looper;
import java.util.concurrent.Executor;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class b implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f44636a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f44637b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f44638c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f44639d;

    public b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        this.f44638c = r100;
        this.f44639d = 0;
        this.f44636a = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new AsyncHandler$asyncHandler$2(this));
        this.f44637b = LazyKt.lazy(new AsyncHandler$taskMergeManager$2(this));
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable r100) {
        if (r100 == null) goto L11;
        Intrinsics.checkNotNullParameter(r100, "block");
        if (Intrinsics.areEqual(Looper.myLooper(), ((AsyncHandler$asyncHandler$2.a) this.f44636a.getValue()).getLooper()) == false) goto L7;
        r100.run();
        return;
    L7:
        if (((Boolean) TaskMergeManager.f44626e.getValue()).booleanValue() == false) goto L9;
        ((TaskMergeManager) this.f44637b.getValue()).a(new v.a(Integer.valueOf(this.f44639d), r100));
        return;
    L9:
        ((AsyncHandler$asyncHandler$2.a) this.f44636a.getValue()).post(new v.a(Integer.valueOf(this.f44639d), r100));
        return;
    }
}
