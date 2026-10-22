package com.bytedance.android.live.util;

import com.bytedance.android.livehostapi.platform.IHostAuthFunction;
import com.bytedance.android.livehostapi.platform.TokenInfo;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IHostAuthFunction f102531a;

    public c(IHostAuthFunction r100) {
        Intrinsics.checkNotNullParameter(r100, "authFunction");
        this.f102531a = r100;
    }

    public final Object a(Continuation<? super TokenInfo> r100) {
        SafeContinuation r101 = new SafeContinuation(IntrinsicsKt.intercepted(r100));
        this.f102531a.finishAuth(new b(r101));
        Object r102 = r101.getOrThrow();
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r100);
    L5:
        return r102;
    }

    public final Object b(Continuation<? super Boolean> r100) {
        SafeContinuation r101 = new SafeContinuation(IntrinsicsKt.intercepted(r100));
        this.f102531a.isCurrentAccountWithDouyinAuth(new b(r101));
        Object r102 = r101.getOrThrow();
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r100);
    L5:
        return r102;
    }

    public final Object c(Continuation<? super Boolean> r100) {
        SafeContinuation r101 = new SafeContinuation(IntrinsicsKt.intercepted(r100));
        this.f102531a.isCurrentAccountWithLegalPhoneNumber(new b(r101));
        Object r102 = r101.getOrThrow();
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r100);
    L5:
        return r102;
    }

    public final Object d(Continuation<? super Boolean> r100) {
        SafeContinuation r101 = new SafeContinuation(IntrinsicsKt.intercepted(r100));
        this.f102531a.isPhoneNumberUsedInDouyin(new b(r101));
        Object r102 = r101.getOrThrow();
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r100);
    L5:
        return r102;
    }

    public final Object e(Continuation<? super Boolean> r100) {
        SafeContinuation r101 = new SafeContinuation(IntrinsicsKt.intercepted(r100));
        this.f102531a.isUserAgreePhoneNumberUsageForDouyin(new b(r101));
        Object r102 = r101.getOrThrow();
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r100);
    L5:
        return r102;
    }
}
