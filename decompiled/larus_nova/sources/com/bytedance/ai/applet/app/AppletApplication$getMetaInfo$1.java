package com.bytedance.ai.applet.app;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.applet.app.AppletApplication", f = "AppletApplication.kt", i = {}, l = {180, 184}, m = "getMetaInfo", n = {}, s = {})
public final class AppletApplication$getMetaInfo$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AppletApplication this$0;

    public AppletApplication$getMetaInfo$1(AppletApplication r100, Continuation<? super AppletApplication$getMetaInfo$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.k(this);
    }
}
