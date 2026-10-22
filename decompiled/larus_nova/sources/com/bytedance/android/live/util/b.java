package com.bytedance.android.live.util;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.service.ILiveCallback;
import com.lynx.tasm.LynxError;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class b implements ILiveCallback<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Continuation f102530a;

    public b(SafeContinuation r100) {
        this.f102530a = r100;
    }

    @Override // com.bytedance.android.livesdkapi.service.ILiveCallback
    public final void onFailed(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, LynxError.LYNX_THROWABLE);
        Continuation r101 = this.f102530a;     // Catch: Exception -> L5
        Result.Companion r102 = Result.Companion;     // Catch: Exception -> L5
        r101.resumeWith(Result.m9449constructorimpl(ResultKt.createFailure(r100)));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        ALogger.e("wrapContinuationToLiveCallback onFailed resumeWithException", e);
    }

    @Override // com.bytedance.android.livesdkapi.service.ILiveCallback
    public final void onSuccess(Object r100) {
        this.f102530a.resumeWith(Result.m9449constructorimpl(r100));     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        ALogger.e("wrapContinuationToLiveCallback onSuccess resume", e);
    }
}
