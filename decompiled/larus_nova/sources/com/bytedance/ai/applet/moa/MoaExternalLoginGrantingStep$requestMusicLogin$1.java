package com.bytedance.ai.applet.moa;

import com.bytedance.sdk.open.aweme.common.constants.ParamKeyConstants;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.applet.moa.MoaExternalLoginGrantingStep", f = "MoaExternalLoginGrantingStep.kt", i = {0, 0, 0, 0, 0}, l = {219}, m = "requestMusicLogin", n = {"clientKey", ParamKeyConstants.WebViewConstants.REDIRECT_QUERY_SCOPE, "state", "aiAbility", "traceInfo"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4"})
public final class MoaExternalLoginGrantingStep$requestMusicLogin$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MoaExternalLoginGrantingStep this$0;

    public MoaExternalLoginGrantingStep$requestMusicLogin$1(MoaExternalLoginGrantingStep r100, Continuation<? super MoaExternalLoginGrantingStep$requestMusicLogin$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        MoaExternalLoginGrantingStep r101 = this.this$0;
        int r102 = MoaExternalLoginGrantingStep.f34789d;
        return r101.f(null, this);
    }
}
