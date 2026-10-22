package com.bytedance.android.livesdk.livecommerce.utils;

import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.Disposable;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;

/* JADX INFO: loaded from: classes10.dex */
public final class g implements CoroutineScope, Disposable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineContext f153081a;

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        Job r100 = (Job) this.f153081a.get(Job.Key);
        if (r100 == null) goto L6;
        JobKt.cancelChildren$default(r100, null, 1, null);
        return;
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        Job r100 = (Job) this.f153081a.get(Job.Key);
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.isCancelled() != true) goto L7;
        return true;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public final CoroutineContext getCoroutineContext() {
        return this.f153081a;
    }

    public g(CoroutineContext r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f153081a = r100;
    }
}
