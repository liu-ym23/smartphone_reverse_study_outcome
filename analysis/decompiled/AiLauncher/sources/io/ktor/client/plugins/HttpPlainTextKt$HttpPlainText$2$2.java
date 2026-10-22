package io.ktor.client.plugins;

import com.stepos.ame.sdk.SkillStoreKt;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import io.ktor.client.plugins.api.TransformResponseBodyContext;
import io.ktor.client.statement.HttpResponse;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteReadChannelOperationsKt;
import java.nio.charset.Charset;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\n"}, d2 = {"<anonymous>", "", "Lio/ktor/client/plugins/api/TransformResponseBodyContext;", UxipConstants.f30685x, "Lio/ktor/client/statement/HttpResponse;", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "Lio/ktor/utils/io/ByteReadChannel;", "requestedType", "Lio/ktor/util/reflect/TypeInfo;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@InterfaceC4112d(c = "io.ktor.client.plugins.HttpPlainTextKt$HttpPlainText$2$2", f = "HttpPlainText.kt", l = {147}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class HttpPlainTextKt$HttpPlainText$2$2 extends SuspendLambda implements p9.s<TransformResponseBodyContext, HttpResponse, ByteReadChannel, TypeInfo, InterfaceC4014c<? super Object>, Object> {
    final /* synthetic */ Charset $responseCharsetFallback;
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    /* synthetic */ Object L$2;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpPlainTextKt$HttpPlainText$2$2(Charset charset, InterfaceC4014c<? super HttpPlainTextKt$HttpPlainText$2$2> interfaceC4014c) {
        super(5, interfaceC4014c);
        this.$responseCharsetFallback = charset;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(TransformResponseBodyContext transformResponseBodyContext, HttpResponse httpResponse, ByteReadChannel byteReadChannel, TypeInfo typeInfo, InterfaceC4014c<Object> interfaceC4014c) {
        HttpPlainTextKt$HttpPlainText$2$2 httpPlainTextKt$HttpPlainText$2$2 = new HttpPlainTextKt$HttpPlainText$2$2(this.$responseCharsetFallback, interfaceC4014c);
        httpPlainTextKt$HttpPlainText$2$2.L$0 = httpResponse;
        httpPlainTextKt$HttpPlainText$2$2.L$1 = byteReadChannel;
        httpPlainTextKt$HttpPlainText$2$2.L$2 = typeInfo;
        return httpPlainTextKt$HttpPlainText$2$2.invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        HttpResponse httpResponse = (HttpResponse) this.L$0;
        ByteReadChannel byteReadChannel = (ByteReadChannel) this.L$1;
        TypeInfo typeInfo = (TypeInfo) this.L$2;
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            if (!kotlin.jvm.internal.p.d(typeInfo.getType(), kotlin.jvm.internal.t.b(String.class))) {
                return null;
            }
            this.L$0 = httpResponse;
            this.L$1 = g9.h.a(byteReadChannel);
            this.L$2 = g9.h.a(typeInfo);
            this.label = 1;
            obj = ByteReadChannelOperationsKt.readRemaining(byteReadChannel, this);
            if (obj == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        return HttpPlainTextKt.HttpPlainText$lambda$6$read(this.$responseCharsetFallback, httpResponse.getCall(), (fb.v) obj);
    }

    @Override // p9.s
    public /* bridge */ /* synthetic */ Object invoke(TransformResponseBodyContext transformResponseBodyContext, HttpResponse httpResponse, ByteReadChannel byteReadChannel, TypeInfo typeInfo, InterfaceC4014c<? super Object> interfaceC4014c) {
        return invoke2(transformResponseBodyContext, httpResponse, byteReadChannel, typeInfo, (InterfaceC4014c<Object>) interfaceC4014c);
    }
}
