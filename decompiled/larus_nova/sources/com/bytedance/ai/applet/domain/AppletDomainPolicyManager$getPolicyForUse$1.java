package com.bytedance.ai.applet.domain;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.applet.domain.AppletDomainPolicyManager", f = "AppletDomainPolicyManager.kt", i = {0, 0}, l = {240}, m = "getPolicyForUse-0E7RQCE", n = {com.heytap.mcssdk.constant.b.f276376z, "source"}, s = {"L$0", "L$1"})
public final class AppletDomainPolicyManager$getPolicyForUse$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AppletDomainPolicyManager this$0;

    public AppletDomainPolicyManager$getPolicyForUse$1(AppletDomainPolicyManager r100, Continuation<? super AppletDomainPolicyManager$getPolicyForUse$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        AppletDomainPolicyManager r101 = this.this$0;
        AppletDomainPolicyManager r102 = AppletDomainPolicyManager.f34590a;
        Object r103 = r101.h(null, null, this);
        if (r103 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r103;
    L6:
        return Result.m9448boximpl(r103);
    }
}
