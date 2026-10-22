package com.bytedance.ai.bridge.method.login;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.bridge.method.login.PostLoginResultMethod", f = "PostLoginResultMethod.kt", i = {}, l = {193}, m = "postLoginCodeToOpenPlat", n = {}, s = {})
final class PostLoginResultMethod$postLoginCodeToOpenPlat$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PostLoginResultMethod this$0;

    public PostLoginResultMethod$postLoginCodeToOpenPlat$1(PostLoginResultMethod r100, Continuation<? super PostLoginResultMethod$postLoginCodeToOpenPlat$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return PostLoginResultMethod.b(this.this$0, null, null, null, this);
    }
}
