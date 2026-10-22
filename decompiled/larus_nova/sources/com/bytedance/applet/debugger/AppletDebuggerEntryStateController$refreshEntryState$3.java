package com.bytedance.applet.debugger;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.applet.debugger.AppletDebuggerEntryStateController", f = "AppletDebuggerEntryStateController.kt", i = {0}, l = {122}, m = "refreshEntryState", n = {"userId"}, s = {"L$0"})
final class AppletDebuggerEntryStateController$refreshEntryState$3 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AppletDebuggerEntryStateController this$0;

    public AppletDebuggerEntryStateController$refreshEntryState$3(AppletDebuggerEntryStateController r100, Continuation<? super AppletDebuggerEntryStateController$refreshEntryState$3> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return AppletDebuggerEntryStateController.a(this.this$0, null, this);
    }
}
