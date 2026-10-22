package io.ktor.utils.io;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "io.ktor.utils.io.ByteChannelScanner", f = "ByteChannelScanner.kt", l = {53, 55, 58, 70}, m = "findNext$ktor_io")
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ByteChannelScanner$findNext$1 extends ContinuationImpl {
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ByteChannelScanner this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteChannelScanner$findNext$1(ByteChannelScanner byteChannelScanner, InterfaceC4014c<? super ByteChannelScanner$findNext$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.this$0 = byteChannelScanner;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.findNext$ktor_io(false, this);
    }
}
