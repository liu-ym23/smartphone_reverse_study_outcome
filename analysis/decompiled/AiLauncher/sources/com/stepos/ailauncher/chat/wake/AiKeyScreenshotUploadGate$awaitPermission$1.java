package com.stepos.ailauncher.chat.wake;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "com.stepos.ailauncher.chat.wake.AiKeyScreenshotUploadGate", f = "AiKeyScreenshotUploadGate.kt", l = {59}, m = "awaitPermission", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AiKeyScreenshotUploadGate$awaitPermission$1 extends ContinuationImpl {
    long J$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AiKeyScreenshotUploadGate this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AiKeyScreenshotUploadGate$awaitPermission$1(AiKeyScreenshotUploadGate aiKeyScreenshotUploadGate, InterfaceC4014c<? super AiKeyScreenshotUploadGate$awaitPermission$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.this$0 = aiKeyScreenshotUploadGate;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(0L, this);
    }
}
