package io.ktor.server.engine;

import Ua.M;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteReadChannelOperationsKt;
import io.ktor.utils.io.ByteWriteChannel;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "", "<anonymous>", "(LUa/M;)J"}, k = 3, mv = {2, 1, 0})
@InterfaceC4112d(c = "io.ktor.server.engine.BaseApplicationResponse$respondFromChannel$2$copied$1", f = "BaseApplicationResponse.kt", l = {223}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class BaseApplicationResponse$respondFromChannel$2$copied$1 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Long>, Object> {
    final /* synthetic */ Long $length;
    final /* synthetic */ ByteReadChannel $readChannel;
    final /* synthetic */ ByteWriteChannel $this_use;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseApplicationResponse$respondFromChannel$2$copied$1(ByteReadChannel byteReadChannel, ByteWriteChannel byteWriteChannel, Long l10, InterfaceC4014c<? super BaseApplicationResponse$respondFromChannel$2$copied$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$readChannel = byteReadChannel;
        this.$this_use = byteWriteChannel;
        this.$length = l10;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new BaseApplicationResponse$respondFromChannel$2$copied$1(this.$readChannel, this.$this_use, this.$length, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super Long> interfaceC4014c) {
        return ((BaseApplicationResponse$respondFromChannel$2$copied$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 != 0) {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            return obj;
        }
        C4849c.b(obj);
        ByteReadChannel byteReadChannel = this.$readChannel;
        ByteWriteChannel byteWriteChannel = this.$this_use;
        Long l10 = this.$length;
        long jLongValue = l10 != null ? l10.longValue() : Long.MAX_VALUE;
        this.label = 1;
        Object objCopyTo = ByteReadChannelOperationsKt.copyTo(byteReadChannel, byteWriteChannel, jLongValue, this);
        return objCopyTo == objG ? objG : objCopyTo;
    }
}
