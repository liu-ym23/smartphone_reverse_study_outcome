package io.ktor.server.http.content;

import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import io.ktor.server.application.ApplicationCall;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

/* JADX INFO: Add missing generic type declarations: [Resource] */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0005\u001a\u00020\u0004\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00028\u00002\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"", "Resource", "<unused var>", "Lio/ktor/server/application/ApplicationCall;", "LY8/t;", "<anonymous>"}, k = 3, mv = {2, 1, 0})
@InterfaceC4112d(c = "io.ktor.server.http.content.StaticContentConfig$modifier$1", f = "StaticContent.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes4.dex */
public final class StaticContentConfig$modifier$1<Resource> extends SuspendLambda implements p9.q<Resource, ApplicationCall, InterfaceC4014c<? super Y8.t>, Object> {
    int label;

    public StaticContentConfig$modifier$1(InterfaceC4014c<? super StaticContentConfig$modifier$1> interfaceC4014c) {
        super(3, interfaceC4014c);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Resource resource, ApplicationCall applicationCall, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return new StaticContentConfig$modifier$1(interfaceC4014c).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        C4063a.g();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        C4849c.b(obj);
        return Y8.t.f7040a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p9.q
    public /* bridge */ /* synthetic */ Object invoke(Object obj, ApplicationCall applicationCall, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return invoke2((StaticContentConfig$modifier$1<Resource>) obj, applicationCall, interfaceC4014c);
    }
}
