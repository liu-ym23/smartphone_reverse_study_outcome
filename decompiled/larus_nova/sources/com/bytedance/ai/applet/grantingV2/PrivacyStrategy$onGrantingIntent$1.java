package com.bytedance.ai.applet.grantingV2;

import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.applet.grantingV2.PrivacyStrategy", f = "PrivacyStrategy.kt", i = {0, 0, 0, 0, 1, 1, 1, 1}, l = {59, 61}, m = "onGrantingIntent", n = {PerfLog.PARAM_KEY_CONTEXT_ID, "meta", "granted", "isHistory", PerfLog.PARAM_KEY_CONTEXT_ID, "meta", "granted", "isHistory"}, s = {"L$0", "L$1", "Z$0", "Z$1", "L$0", "L$1", "Z$0", "Z$1"})
public final class PrivacyStrategy$onGrantingIntent$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    boolean Z$0;
    boolean Z$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PrivacyStrategy this$0;

    public PrivacyStrategy$onGrantingIntent$1(PrivacyStrategy r100, Continuation<? super PrivacyStrategy$onGrantingIntent$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.d(null, false, false, this);
    }
}
