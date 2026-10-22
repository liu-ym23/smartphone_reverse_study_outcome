package io.ktor.client.call;

import com.stepos.ame.sdk.SkillStoreKt;
import io.ktor.client.statement.HttpResponse;
import io.ktor.http.Headers;
import io.ktor.utils.io.ByteReadChannel;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a/\u0010\u0007\u001a\u00020\u0000*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lio/ktor/client/call/HttpClientCall;", "Lio/ktor/http/Headers;", "headers", "Lkotlin/Function1;", "Lio/ktor/client/statement/HttpResponse;", "Lio/ktor/utils/io/ByteReadChannel;", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "replaceResponse", "(Lio/ktor/client/call/HttpClientCall;Lio/ktor/http/Headers;Lp9/l;)Lio/ktor/client/call/HttpClientCall;", "ktor-client-core"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DelegatedCallKt {
    public static final HttpClientCall replaceResponse(HttpClientCall httpClientCall, Headers headers, InterfaceC5074l<? super HttpResponse, ? extends ByteReadChannel> content) {
        p.i(httpClientCall, "<this>");
        p.i(headers, "headers");
        p.i(content, "content");
        return new DelegatedCall(httpClientCall.getClient(), httpClientCall, content, headers);
    }

    public static /* synthetic */ HttpClientCall replaceResponse$default(HttpClientCall httpClientCall, Headers headers, InterfaceC5074l interfaceC5074l, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            headers = httpClientCall.getResponse().getHeaders();
        }
        return replaceResponse(httpClientCall, headers, interfaceC5074l);
    }
}
