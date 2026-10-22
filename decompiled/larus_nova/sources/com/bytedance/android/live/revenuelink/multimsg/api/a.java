package com.bytedance.android.live.revenuelink.multimsg.api;

import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.live.kmp.statemachine.StateMachine;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public abstract class a<INPUT, OUTPUT> implements c<INPUT, OUTPUT> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TaskState<INPUT, OUTPUT, a<INPUT, OUTPUT>> f91873a;

    public abstract void b(INPUT r100);

    public a() {
        this.f91873a = new TaskState();
    }

    @Override // com.bytedance.android.live.revenuelink.multimsg.api.c
    public final void a(INPUT r100) {
        b(r100);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        int r101 = e.f91874a;
        Intrinsics.checkNotNullParameter(e, BaseHttpRequestInfo.KEY_EXCEPTION);
        e.b r102 = new e.b(e);
        Intrinsics.checkNotNullParameter(r102, "result");
        TaskState<INPUT, OUTPUT, a<INPUT, OUTPUT>> r103 = this.f91873a;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r102, "result");
        StateMachine.c(r103.f91864d, new TaskState.a.C1427a(r102));
    }
}
