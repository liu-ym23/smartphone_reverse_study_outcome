package com.stepos.ailauncher.taskstore.sprite;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "com.stepos.ailauncher.taskstore.sprite.SpriteTaskBridge", f = "SpriteTaskBridge.kt", l = {72}, m = "handle", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SpriteTaskBridge$handle$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SpriteTaskBridge this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpriteTaskBridge$handle$1(SpriteTaskBridge spriteTaskBridge, InterfaceC4014c<? super SpriteTaskBridge$handle$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.this$0 = spriteTaskBridge;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.d(null, this);
    }
}
