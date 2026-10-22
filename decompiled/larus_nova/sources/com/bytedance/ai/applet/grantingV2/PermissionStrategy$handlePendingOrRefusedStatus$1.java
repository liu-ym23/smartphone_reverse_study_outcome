package com.bytedance.ai.applet.grantingV2;

import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.applet.grantingV2.PermissionStrategy", f = "PermissionStrategy.kt", i = {0, 1, 2, 2, 2, 3, 3, 3}, l = {174, 176, 202, 204}, m = "handlePendingOrRefusedStatus", n = {PerfLog.PARAM_KEY_CONTEXT_ID, PerfLog.PARAM_KEY_CONTEXT_ID, PerfLog.PARAM_KEY_CONTEXT_ID, "meta", "isHistory", PerfLog.PARAM_KEY_CONTEXT_ID, "meta", "isHistory"}, s = {"L$0", "L$0", "L$0", "L$1", "Z$0", "L$0", "L$1", "Z$0"})
final class PermissionStrategy$handlePendingOrRefusedStatus$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PermissionStrategy this$0;

    public PermissionStrategy$handlePendingOrRefusedStatus$1(PermissionStrategy r100, Continuation<? super PermissionStrategy$handlePendingOrRefusedStatus$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        PermissionStrategy r101 = this.this$0;
        int r102 = PermissionStrategy.f34652d;
        return r101.l(null, null, null, false, false, this);
    }
}
