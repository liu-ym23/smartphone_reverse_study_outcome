package io.ktor.client.plugins;

import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import io.ktor.client.request.HttpRequest;
import io.ktor.client.utils.ExceptionUtilsJvmKt;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "", "request", "Lio/ktor/client/request/HttpRequest;", "cause"}, k = 3, mv = {2, 2, 0}, xi = 48)
@InterfaceC4112d(c = "io.ktor.client.plugins.HttpCallValidatorKt$HttpCallValidator$2$4", f = "HttpCallValidator.kt", l = {141}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class HttpCallValidatorKt$HttpCallValidator$2$4 extends SuspendLambda implements p9.q<HttpRequest, Throwable, InterfaceC4014c<? super Throwable>, Object> {
    final /* synthetic */ List<HandlerWrapper> $callExceptionHandlers;
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    Object L$2;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public HttpCallValidatorKt$HttpCallValidator$2$4(List<? extends HandlerWrapper> list, InterfaceC4014c<? super HttpCallValidatorKt$HttpCallValidator$2$4> interfaceC4014c) {
        super(3, interfaceC4014c);
        this.$callExceptionHandlers = list;
    }

    @Override // p9.q
    public final Object invoke(HttpRequest httpRequest, Throwable th, InterfaceC4014c<? super Throwable> interfaceC4014c) {
        HttpCallValidatorKt$HttpCallValidator$2$4 httpCallValidatorKt$HttpCallValidator$2$4 = new HttpCallValidatorKt$HttpCallValidator$2$4(this.$callExceptionHandlers, interfaceC4014c);
        httpCallValidatorKt$HttpCallValidator$2$4.L$0 = httpRequest;
        httpCallValidatorKt$HttpCallValidator$2$4.L$1 = th;
        return httpCallValidatorKt$HttpCallValidator$2$4.invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        HttpRequest httpRequest = (HttpRequest) this.L$0;
        Throwable th = (Throwable) this.L$1;
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 != 0) {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Throwable th2 = (Throwable) this.L$2;
            C4849c.b(obj);
            return th2;
        }
        C4849c.b(obj);
        Throwable thUnwrapCancellationException = ExceptionUtilsJvmKt.unwrapCancellationException(th);
        List<HandlerWrapper> list = this.$callExceptionHandlers;
        this.L$0 = g9.h.a(httpRequest);
        this.L$1 = g9.h.a(th);
        this.L$2 = thUnwrapCancellationException;
        this.label = 1;
        return HttpCallValidatorKt.HttpCallValidator$lambda$2$processException(list, thUnwrapCancellationException, httpRequest, this) == objG ? objG : thUnwrapCancellationException;
    }
}
