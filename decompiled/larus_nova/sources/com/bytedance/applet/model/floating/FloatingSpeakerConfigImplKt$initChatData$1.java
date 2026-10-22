package com.bytedance.applet.model.floating;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.applet.model.floating.FloatingSpeakerConfigImplKt", f = "FloatingSpeakerConfigImpl.kt", i = {0, 0}, l = {482}, m = "initChatData", n = {"jsonObject", "jsonArray"}, s = {"L$0", "L$1"})
final class FloatingSpeakerConfigImplKt$initChatData$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    public FloatingSpeakerConfigImplKt$initChatData$1(Continuation<? super FloatingSpeakerConfigImplKt$initChatData$1> r100) {
        super(r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return FloatingSpeakerConfigImplKt.a(null, this);
    }
}
