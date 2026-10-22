package com.bytedance.android.ec.core.arch.lifecycle;

import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayDeque;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: classes43.dex */
public final class f extends CoroutineDispatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f43854a;

    public f() {
        this.f43854a = new b();
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final boolean isDispatchNeeded(CoroutineContext r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (Dispatchers.getMain().getImmediate().isDispatchNeeded(r100) == false) goto L5;
        return true;
    L5:
        b r101 = this.f43854a;
        if (r101.f43845b == false) goto L8;
    L11:
        boolean r102 = true;
    L13:
        return !r102;
    L8:
        if (r101.f43844a == false) goto L11;
        r102 = false;
        goto L13
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void dispatch(CoroutineContext r100, Runnable r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "block");
        b r102 = this.f43854a;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "runnable");
        MainCoroutineDispatcher r103 = Dispatchers.getMain().getImmediate();
        if (r103.isDispatchNeeded(r100) == false) goto L5;
    L18:
        r103.dispatch(r100, new a(r102, r100, r101));
        return;
    L5:
        if (r102.f43845b == false) goto L7;
    L10:
        boolean r104 = true;
    L11:
        if (r104 == true) goto L18;
        if (((ArrayDeque) r102.f43847d).offer(r101) == false) goto L17;
        r102.a();
        return;
    L17:
        throw new IllegalStateException("cannot enqueue any more runnables".toString());
    L7:
        if (r102.f43844a == false) goto L10;
        r104 = false;
        goto L11
    }
}
