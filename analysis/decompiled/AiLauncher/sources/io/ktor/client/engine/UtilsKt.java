package io.ktor.client.engine;

import Ua.InterfaceC1045a0;
import Y8.t;
import Z8.F;
import Z8.Y;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ame.sdk.SkillStoreKt;
import e9.InterfaceC4014c;
import io.ktor.client.utils.HeadersKt;
import io.ktor.http.ContentType;
import io.ktor.http.Headers;
import io.ktor.http.HeadersBuilder;
import io.ktor.http.HttpHeaders;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.PlatformUtils;
import io.ktor.utils.io.InternalAPI;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.coroutines.d;
import kotlin.jvm.internal.n;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\"\n\u0002\b\u0003\u001a9\u0010\b\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0007¢\u0006\u0004\b\b\u0010\t\u001a\u0010\u0010\u000b\u001a\u00020\nH\u0087@¢\u0006\u0004\b\u000b\u0010\f\u001a\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0080H¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u000f\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0012\u0010\u0013\" \u0010\u0014\u001a\u00020\u00058\u0006X\u0087D¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u0012\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017\"\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00050\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lio/ktor/http/Headers;", "requestHeaders", "Lio/ktor/http/content/OutgoingContent;", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "Lkotlin/Function2;", "", "LY8/t;", "block", "mergeHeaders", "(Lio/ktor/http/Headers;Lio/ktor/http/content/OutgoingContent;Lp9/p;)V", "Lkotlin/coroutines/d;", "callContext", "(Le9/c;)Ljava/lang/Object;", "Lkotlinx/coroutines/g;", "callJob", "attachToUserJob", "(Lkotlinx/coroutines/g;Le9/c;)Ljava/lang/Object;", "", "needUserAgent", "()Z", "KTOR_DEFAULT_USER_AGENT", "Ljava/lang/String;", "getKTOR_DEFAULT_USER_AGENT", "()Ljava/lang/String;", "getKTOR_DEFAULT_USER_AGENT$annotations", "()V", "", "DATE_HEADERS", "Ljava/util/Set;", "ktor-client-core"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class UtilsKt {
    private static final Set<String> DATE_HEADERS;
    private static final String KTOR_DEFAULT_USER_AGENT = "ktor-client";

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 176)
    /* renamed from: io.ktor.client.engine.UtilsKt$attachToUserJob$2, reason: invalid class name */
    public static final class AnonymousClass2 implements InterfaceC5074l<Throwable, t> {
        final /* synthetic */ InterfaceC1045a0 $cleanupHandler;

        public AnonymousClass2(InterfaceC1045a0 interfaceC1045a0) {
            this.$cleanupHandler = interfaceC1045a0;
        }

        @Override // p9.InterfaceC5074l
        public /* bridge */ /* synthetic */ t invoke(Throwable th) {
            invoke2(th);
            return t.f7040a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Throwable th) {
            this.$cleanupHandler.dispose();
        }
    }

    static {
        HttpHeaders httpHeaders = HttpHeaders.INSTANCE;
        DATE_HEADERS = Y.j(httpHeaders.getDate(), httpHeaders.getExpires(), httpHeaders.getLastModified(), httpHeaders.getIfModifiedSince(), httpHeaders.getIfUnmodifiedSince());
    }

    public static final Object attachToUserJob(kotlinx.coroutines.g gVar, InterfaceC4014c<? super t> interfaceC4014c) {
        kotlinx.coroutines.g gVar2 = (kotlinx.coroutines.g) interfaceC4014c.getContext().get(kotlinx.coroutines.g.INSTANCE);
        if (gVar2 == null) {
            return t.f7040a;
        }
        gVar.J(new AnonymousClass2(kotlinx.coroutines.g.b1(gVar2, true, false, new UtilsKt$attachToUserJob$cleanupHandler$1(gVar), 2, null)));
        return t.f7040a;
    }

    private static final Object attachToUserJob$$forInline(kotlinx.coroutines.g gVar, InterfaceC4014c<? super t> interfaceC4014c) {
        n.c(3);
        throw null;
    }

    @InternalAPI
    public static final Object callContext(InterfaceC4014c<? super kotlin.coroutines.d> interfaceC4014c) {
        d.b bVar = interfaceC4014c.getContext().get(KtorCallContextElement.INSTANCE);
        p.f(bVar);
        return ((KtorCallContextElement) bVar).getCallContext();
    }

    public static final String getKTOR_DEFAULT_USER_AGENT() {
        return KTOR_DEFAULT_USER_AGENT;
    }

    @InternalAPI
    public static /* synthetic */ void getKTOR_DEFAULT_USER_AGENT$annotations() {
    }

    @InternalAPI
    public static final void mergeHeaders(final Headers requestHeaders, final OutgoingContent content, final p9.p<? super String, ? super String, t> block) {
        String string;
        String string2;
        p.i(requestHeaders, "requestHeaders");
        p.i(content, "content");
        p.i(block, "block");
        HeadersKt.buildHeaders(new InterfaceC5074l() { // from class: io.ktor.client.engine.f
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return UtilsKt.mergeHeaders$lambda$0(requestHeaders, content, (HeadersBuilder) obj);
            }
        }).forEach(new p9.p() { // from class: io.ktor.client.engine.g
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return UtilsKt.mergeHeaders$lambda$2(block, (String) obj, (List) obj2);
            }
        });
        HttpHeaders httpHeaders = HttpHeaders.INSTANCE;
        if (requestHeaders.get(httpHeaders.getUserAgent()) == null && content.getHeaders().get(httpHeaders.getUserAgent()) == null && needUserAgent()) {
            block.invoke(httpHeaders.getUserAgent(), KTOR_DEFAULT_USER_AGENT);
        }
        ContentType contentType = content.getContentType();
        if ((contentType == null || (string = contentType.toString()) == null) && (string = content.getHeaders().get(httpHeaders.getContentType())) == null) {
            string = requestHeaders.get(httpHeaders.getContentType());
        }
        Long contentLength = content.getContentLength();
        if ((contentLength == null || (string2 = contentLength.toString()) == null) && (string2 = content.getHeaders().get(httpHeaders.getContentLength())) == null) {
            string2 = requestHeaders.get(httpHeaders.getContentLength());
        }
        if (string != null) {
            block.invoke(httpHeaders.getContentType(), string);
        }
        if (string2 != null) {
            block.invoke(httpHeaders.getContentLength(), string2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t mergeHeaders$lambda$0(Headers headers, OutgoingContent outgoingContent, HeadersBuilder buildHeaders) {
        p.i(buildHeaders, "$this$buildHeaders");
        buildHeaders.appendAll(headers);
        buildHeaders.appendAll(outgoingContent.getHeaders());
        return t.f7040a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final t mergeHeaders$lambda$2(p9.p pVar, String key, List values) {
        p.i(key, "key");
        p.i(values, "values");
        HttpHeaders httpHeaders = HttpHeaders.INSTANCE;
        if (!p.d(httpHeaders.getContentLength(), key) && !p.d(httpHeaders.getContentType(), key)) {
            if (DATE_HEADERS.contains(key)) {
                Iterator it = values.iterator();
                while (it.hasNext()) {
                    pVar.invoke(key, (String) it.next());
                }
            } else {
                pVar.invoke(key, F.A0(values, p.d(httpHeaders.getCookie(), key) ? "; " : Const.STR_MART_COMMA, null, null, 0, null, null, 62, null));
            }
            return t.f7040a;
        }
        return t.f7040a;
    }

    private static final boolean needUserAgent() {
        return !PlatformUtils.INSTANCE.getIS_BROWSER();
    }
}
