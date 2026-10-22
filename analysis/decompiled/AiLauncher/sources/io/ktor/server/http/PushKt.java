package io.ktor.server.http;

import La.H;
import Y8.j;
import Y8.t;
import io.ktor.http.Parameters;
import io.ktor.http.QueryKt;
import io.ktor.http.URLBuilderKt;
import io.ktor.server.application.ApplicationCall;
import io.ktor.server.http.PushKt;
import io.ktor.server.response.ApplicationResponse;
import io.ktor.server.response.DefaultResponsePushBuilder;
import io.ktor.server.response.ResponsePushBuilder;
import io.ktor.server.response.UseHttp2Push;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0004\u0010\u0005\u001a#\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u0004\u0010\t\u001a'\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00030\nH\u0007¢\u0006\u0004\b\u0004\u0010\r¨\u0006\u000e"}, d2 = {"Lio/ktor/server/application/ApplicationCall;", "", "pathAndQuery", "LY8/t;", "push", "(Lio/ktor/server/application/ApplicationCall;Ljava/lang/String;)V", "encodedPath", "Lio/ktor/http/Parameters;", "encodedParameters", "(Lio/ktor/server/application/ApplicationCall;Ljava/lang/String;Lio/ktor/http/Parameters;)V", "Lkotlin/Function1;", "Lio/ktor/server/response/ResponsePushBuilder;", "block", "(Lio/ktor/server/application/ApplicationCall;Lp9/l;)V", "ktor-server-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PushKt {
    @UseHttp2Push
    public static final void push(ApplicationCall applicationCall, final String encodedPath, final Parameters encodedParameters) {
        p.i(applicationCall, "<this>");
        p.i(encodedPath, "encodedPath");
        p.i(encodedParameters, "encodedParameters");
        push(applicationCall, (InterfaceC5074l<? super ResponsePushBuilder, t>) new InterfaceC5074l() { // from class: r8.a
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return PushKt.push$lambda$1(encodedPath, encodedParameters, (ResponsePushBuilder) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t push$lambda$1(String str, Parameters parameters, ResponsePushBuilder push) {
        p.i(push, "$this$push");
        URLBuilderKt.setEncodedPath(push.getUrl(), str);
        push.getUrl().getEncodedParameters().clear();
        push.getUrl().getEncodedParameters().appendAll(parameters);
        return t.f7040a;
    }

    @UseHttp2Push
    public static final void push(ApplicationCall applicationCall, InterfaceC5074l<? super ResponsePushBuilder, t> block) {
        p.i(applicationCall, "<this>");
        p.i(block, "block");
        ApplicationResponse response = applicationCall.getResponse();
        DefaultResponsePushBuilder defaultResponsePushBuilder = new DefaultResponsePushBuilder(applicationCall);
        block.invoke(defaultResponsePushBuilder);
        response.push(defaultResponsePushBuilder);
    }

    @UseHttp2Push
    public static final void push(ApplicationCall applicationCall, String pathAndQuery) {
        Pair pairA;
        p.i(applicationCall, "<this>");
        p.i(pathAndQuery, "pathAndQuery");
        int iU0 = H.u0(pathAndQuery, "?", 0, false, 6, null);
        if (iU0 == -1) {
            pairA = j.a(pathAndQuery, "");
        } else {
            String strSubstring = pathAndQuery.substring(0, iU0);
            p.h(strSubstring, "substring(...)");
            String strSubstring2 = pathAndQuery.substring(iU0 + 1);
            p.h(strSubstring2, "substring(...)");
            pairA = j.a(strSubstring, strSubstring2);
        }
        push(applicationCall, (String) pairA.a(), QueryKt.parseQueryString$default((String) pairA.b(), 0, 0, false, 6, null));
    }
}
