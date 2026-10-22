package io.ktor.client.engine.cio;

import Y8.t;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import io.ktor.http.HttpProtocolVersion;
import io.ktor.http.cio.ConnectionOptions;
import io.ktor.http.cio.HttpBodyKt;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.WriterScope;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lio/ktor/utils/io/WriterScope;", "LY8/t;", "<anonymous>", "(Lio/ktor/utils/io/WriterScope;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "io.ktor.client.engine.cio.UtilsKt$readResponse$2$1$body$httpBodyParser$1", f = "utils.kt", l = {203}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class UtilsKt$readResponse$2$1$body$httpBodyParser$1 extends SuspendLambda implements p<WriterScope, InterfaceC4014c<? super t>, Object> {
    final /* synthetic */ ConnectionOptions $connectionType;
    final /* synthetic */ long $contentLength;
    final /* synthetic */ ByteReadChannel $input;
    final /* synthetic */ String $transferEncoding;
    final /* synthetic */ HttpProtocolVersion $version;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UtilsKt$readResponse$2$1$body$httpBodyParser$1(HttpProtocolVersion httpProtocolVersion, long j10, String str, ConnectionOptions connectionOptions, ByteReadChannel byteReadChannel, InterfaceC4014c<? super UtilsKt$readResponse$2$1$body$httpBodyParser$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.$version = httpProtocolVersion;
        this.$contentLength = j10;
        this.$transferEncoding = str;
        this.$connectionType = connectionOptions;
        this.$input = byteReadChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        UtilsKt$readResponse$2$1$body$httpBodyParser$1 utilsKt$readResponse$2$1$body$httpBodyParser$1 = new UtilsKt$readResponse$2$1$body$httpBodyParser$1(this.$version, this.$contentLength, this.$transferEncoding, this.$connectionType, this.$input, interfaceC4014c);
        utilsKt$readResponse$2$1$body$httpBodyParser$1.L$0 = obj;
        return utilsKt$readResponse$2$1$body$httpBodyParser$1;
    }

    @Override // p9.p
    public final Object invoke(WriterScope writerScope, InterfaceC4014c<? super t> interfaceC4014c) {
        return ((UtilsKt$readResponse$2$1$body$httpBodyParser$1) create(writerScope, interfaceC4014c)).invokeSuspend(t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        WriterScope writerScope = (WriterScope) this.L$0;
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            HttpProtocolVersion httpProtocolVersion = this.$version;
            long j10 = this.$contentLength;
            String str = this.$transferEncoding;
            ConnectionOptions connectionOptions = this.$connectionType;
            ByteReadChannel byteReadChannel = this.$input;
            ByteWriteChannel channel = writerScope.getChannel();
            this.L$0 = g9.h.a(writerScope);
            this.label = 1;
            if (HttpBodyKt.parseHttpBody(httpProtocolVersion, j10, str, connectionOptions, byteReadChannel, channel, this) == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        return t.f7040a;
    }
}
