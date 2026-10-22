package com.bytedance.ai.applet.grantingV2;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.applet.grantingV2.PermissionStrategy", f = "PermissionStrategy.kt", i = {}, l = {361}, m = "postPermissionDetail", n = {}, s = {})
public final class PermissionStrategy$postPermissionDetail$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PermissionStrategy this$0;

    public PermissionStrategy$postPermissionDetail$1(PermissionStrategy r100, Continuation<? super PermissionStrategy$postPermissionDetail$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        PermissionStrategy r101 = this.this$0;
        int r102 = PermissionStrategy.f34652d;
        return r101.m(null, null, null, this);
    }
}
