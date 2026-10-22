package com.stepos.agentframework.chatcore.utils;

import com.stepos.agentframework.chatcore.utils.ExtKt$fixInterval$1;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "com.stepos.agentframework.chatcore.utils.ExtKt$fixInterval$1$1", f = "Ext.kt", l = {43, 46}, m = "emit", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ExtKt$fixInterval$1$1$emit$1 extends ContinuationImpl {
    long J$0;
    long J$1;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ExtKt$fixInterval$1.AnonymousClass1<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ExtKt$fixInterval$1$1$emit$1(ExtKt$fixInterval$1.AnonymousClass1<? super T> anonymousClass1, InterfaceC4014c<? super ExtKt$fixInterval$1$1$emit$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.this$0 = anonymousClass1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit(null, this);
    }
}
