package com.bytedance.applet.debugger;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.applet.debugger.DebuggerConversationCreator", f = "DebuggerConversationCreator.kt", i = {}, l = {85}, m = "cleanup", n = {}, s = {})
public final class DebuggerConversationCreator$cleanup$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DebuggerConversationCreator this$0;

    public DebuggerConversationCreator$cleanup$1(DebuggerConversationCreator r100, Continuation<? super DebuggerConversationCreator$cleanup$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, null, this);
    }
}
