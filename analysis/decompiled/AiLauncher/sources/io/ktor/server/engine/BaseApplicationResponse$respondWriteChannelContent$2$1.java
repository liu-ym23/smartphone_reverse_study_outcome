package io.ktor.server.engine;

import Ua.M;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import io.ktor.http.content.OutgoingContent;
import io.ktor.utils.io.ByteWriteChannel;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 1, 0})
@InterfaceC4112d(c = "io.ktor.server.engine.BaseApplicationResponse$respondWriteChannelContent$2$1", f = "BaseApplicationResponse.kt", l = {186}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class BaseApplicationResponse$respondWriteChannelContent$2$1 extends SuspendLambda implements p9.p<M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ OutgoingContent.WriteChannelContent $content;
    final /* synthetic */ ByteWriteChannel $this_use;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseApplicationResponse$respondWriteChannelContent$2$1(OutgoingContent.WriteChannelContent writeChannelContent, ByteWriteChannel byteWriteChannel, InterfaceC4014c<? super BaseApplicationResponse$respondWriteChannelContent$2$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$content = writeChannelContent;
        this.$this_use = byteWriteChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new BaseApplicationResponse$respondWriteChannelContent$2$1(this.$content, this.$this_use, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((BaseApplicationResponse$respondWriteChannelContent$2$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            OutgoingContent.WriteChannelContent writeChannelContent = this.$content;
            ByteWriteChannel byteWriteChannel = this.$this_use;
            this.label = 1;
            if (writeChannelContent.writeTo(byteWriteChannel, this) == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        return Y8.t.f7040a;
    }
}
