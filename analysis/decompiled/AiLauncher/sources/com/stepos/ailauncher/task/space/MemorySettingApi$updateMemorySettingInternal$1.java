package com.stepos.ailauncher.task.space;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "com.stepos.ailauncher.task.space.MemorySettingApi", f = "MemorySettingApi.kt", l = {628, com.stepos.agentframework.chatui.longtext.b.BLOCK_CHARS}, m = "updateMemorySettingInternal", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class MemorySettingApi$updateMemorySettingInternal$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MemorySettingApi this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemorySettingApi$updateMemorySettingInternal$1(MemorySettingApi memorySettingApi, InterfaceC4014c<? super MemorySettingApi$updateMemorySettingInternal$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.this$0 = memorySettingApi;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.Y(false, 0, this);
    }
}
