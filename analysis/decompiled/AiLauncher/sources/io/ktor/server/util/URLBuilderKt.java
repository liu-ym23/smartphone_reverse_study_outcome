package io.ktor.server.util;

import Y8.t;
import io.ktor.http.RequestConnectionPoint;
import io.ktor.http.URLBuilder;
import io.ktor.http.URLProtocol;
import io.ktor.server.application.ApplicationCall;
import io.ktor.server.plugins.OriginConnectionPointKt;
import io.ktor.server.request.ApplicationRequestPropertiesKt;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a!\u0010\n\u001a\u00020\t2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\n\u0010\u000b\u001a-\u0010\n\u001a\u00020\t*\u00020\u00012\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u0006H\u0086\bø\u0001\u0000¢\u0006\u0004\b\n\u0010\f\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\r"}, d2 = {"Lio/ktor/http/URLBuilder$Companion;", "Lio/ktor/server/application/ApplicationCall;", "call", "Lio/ktor/http/URLBuilder;", "createFromCall", "(Lio/ktor/http/URLBuilder$Companion;Lio/ktor/server/application/ApplicationCall;)Lio/ktor/http/URLBuilder;", "Lkotlin/Function1;", "LY8/t;", "block", "", "url", "(Lp9/l;)Ljava/lang/String;", "(Lio/ktor/server/application/ApplicationCall;Lp9/l;)Ljava/lang/String;", "ktor-server-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class URLBuilderKt {
    public static final URLBuilder createFromCall(URLBuilder.Companion companion, ApplicationCall call) {
        p.i(companion, "<this>");
        p.i(call, "call");
        RequestConnectionPoint origin = OriginConnectionPointKt.getOrigin(call.getRequest());
        URLBuilder uRLBuilder = new URLBuilder(null, null, 0, null, null, null, null, null, false, 511, null);
        URLProtocol uRLProtocol = URLProtocol.INSTANCE.getByName().get(origin.getScheme());
        if (uRLProtocol == null) {
            uRLProtocol = new URLProtocol(origin.getScheme(), 0);
        }
        uRLBuilder.setProtocol(uRLProtocol);
        uRLBuilder.setHost(origin.getServerHost());
        uRLBuilder.setPort(origin.getServerPort());
        io.ktor.http.URLBuilderKt.setEncodedPath(uRLBuilder, ApplicationRequestPropertiesKt.path(call.getRequest()));
        uRLBuilder.getParameters().appendAll(call.getRequest().getQueryParameters());
        return uRLBuilder;
    }

    public static final String url(InterfaceC5074l<? super URLBuilder, t> block) {
        p.i(block, "block");
        URLBuilder uRLBuilder = new URLBuilder(null, null, 0, null, null, null, null, null, false, 511, null);
        block.invoke(uRLBuilder);
        return uRLBuilder.buildString();
    }

    public static /* synthetic */ String url$default(ApplicationCall applicationCall, InterfaceC5074l block, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            block = new InterfaceC5074l<URLBuilder, t>() { // from class: io.ktor.server.util.URLBuilderKt.url.1
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(URLBuilder uRLBuilder) {
                    p.i(uRLBuilder, "<this>");
                }

                @Override // p9.InterfaceC5074l
                public /* bridge */ /* synthetic */ t invoke(URLBuilder uRLBuilder) {
                    invoke2(uRLBuilder);
                    return t.f7040a;
                }
            };
        }
        p.i(applicationCall, "<this>");
        p.i(block, "block");
        URLBuilder uRLBuilderCreateFromCall = createFromCall(URLBuilder.INSTANCE, applicationCall);
        block.invoke(uRLBuilderCreateFromCall);
        return uRLBuilderCreateFromCall.buildString();
    }

    public static final String url(ApplicationCall applicationCall, InterfaceC5074l<? super URLBuilder, t> block) {
        p.i(applicationCall, "<this>");
        p.i(block, "block");
        URLBuilder uRLBuilderCreateFromCall = createFromCall(URLBuilder.INSTANCE, applicationCall);
        block.invoke(uRLBuilderCreateFromCall);
        return uRLBuilderCreateFromCall.buildString();
    }
}
