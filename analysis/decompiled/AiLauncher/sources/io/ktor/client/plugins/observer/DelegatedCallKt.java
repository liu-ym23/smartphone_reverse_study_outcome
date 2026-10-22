package io.ktor.client.plugins.observer;

import com.stepos.ame.sdk.SkillStoreKt;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.statement.HttpResponse;
import io.ktor.http.Headers;
import io.ktor.utils.io.ByteReadChannel;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001b\u0010\u0003\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0003\u0010\u0004\u001a!\u0010\u0003\u001a\u00020\u0000*\u00020\u00002\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0007¢\u0006\u0004\b\u0003\u0010\u0007\u001a#\u0010\n\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lio/ktor/client/call/HttpClientCall;", "Lio/ktor/utils/io/ByteReadChannel;", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "wrapWithContent", "(Lio/ktor/client/call/HttpClientCall;Lio/ktor/utils/io/ByteReadChannel;)Lio/ktor/client/call/HttpClientCall;", "Lkotlin/Function0;", "block", "(Lio/ktor/client/call/HttpClientCall;Lp9/a;)Lio/ktor/client/call/HttpClientCall;", "Lio/ktor/http/Headers;", "headers", "wrap", "(Lio/ktor/client/call/HttpClientCall;Lio/ktor/utils/io/ByteReadChannel;Lio/ktor/http/Headers;)Lio/ktor/client/call/HttpClientCall;", "ktor-client-core"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DelegatedCallKt {
    public static final HttpClientCall wrap(HttpClientCall httpClientCall, final ByteReadChannel content, Headers headers) {
        p.i(httpClientCall, "<this>");
        p.i(content, "content");
        p.i(headers, "headers");
        return io.ktor.client.call.DelegatedCallKt.replaceResponse(httpClientCall, headers, new InterfaceC5074l() { // from class: io.ktor.client.plugins.observer.c
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return DelegatedCallKt.wrap$lambda$2(content, (HttpResponse) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ByteReadChannel wrap$lambda$2(ByteReadChannel byteReadChannel, HttpResponse replaceResponse) {
        p.i(replaceResponse, "$this$replaceResponse");
        return byteReadChannel;
    }

    public static final HttpClientCall wrapWithContent(HttpClientCall httpClientCall, final ByteReadChannel content) {
        p.i(httpClientCall, "<this>");
        p.i(content, "content");
        return io.ktor.client.call.DelegatedCallKt.replaceResponse$default(httpClientCall, null, new InterfaceC5074l() { // from class: io.ktor.client.plugins.observer.b
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return DelegatedCallKt.wrapWithContent$lambda$0(content, (HttpResponse) obj);
            }
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ByteReadChannel wrapWithContent$lambda$0(ByteReadChannel byteReadChannel, HttpResponse replaceResponse) {
        p.i(replaceResponse, "$this$replaceResponse");
        return byteReadChannel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ByteReadChannel wrapWithContent$lambda$1(InterfaceC5063a interfaceC5063a, HttpResponse replaceResponse) {
        p.i(replaceResponse, "$this$replaceResponse");
        return (ByteReadChannel) interfaceC5063a.invoke();
    }

    public static final HttpClientCall wrapWithContent(HttpClientCall httpClientCall, final InterfaceC5063a<? extends ByteReadChannel> block) {
        p.i(httpClientCall, "<this>");
        p.i(block, "block");
        return io.ktor.client.call.DelegatedCallKt.replaceResponse$default(httpClientCall, null, new InterfaceC5074l() { // from class: io.ktor.client.plugins.observer.a
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return DelegatedCallKt.wrapWithContent$lambda$1(block, (HttpResponse) obj);
            }
        }, 1, null);
    }
}
