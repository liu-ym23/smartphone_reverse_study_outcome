package io.ktor.client.plugins.cache;

import Z8.C1173v;
import Z8.F;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ame.sdk.SkillStoreKt;
import io.ktor.client.engine.UtilsKt;
import io.ktor.http.ContentType;
import io.ktor.http.HttpHeaders;
import io.ktor.http.URLProtocol;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.logging.KtorSimpleLoggerJvmKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;
import vc.c;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aU\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0001\u001a\u00020\u00002\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00022\u001a\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00050\u0002H\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a\u0013\u0010\u000b\u001a\u00020\n*\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\f\"\u001e\u0010\u000f\u001a\u00060\rj\u0002`\u000e8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lio/ktor/http/content/OutgoingContent;", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "Lkotlin/Function1;", "", "headerExtractor", "", "allHeadersExtractor", "mergedHeadersLookup", "(Lio/ktor/http/content/OutgoingContent;Lp9/l;Lp9/l;)Lp9/l;", "Lio/ktor/http/URLProtocol;", "", "canStore", "(Lio/ktor/http/URLProtocol;)Z", "Lvc/c;", "Lio/ktor/util/logging/Logger;", "LOGGER", "Lvc/c;", "getLOGGER", "()Lvc/c;", "ktor-client-core"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class HttpCacheKt {
    private static final c LOGGER = KtorSimpleLoggerJvmKt.KtorSimpleLogger("io.ktor.client.plugins.HttpCache");

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean canStore(URLProtocol uRLProtocol) {
        return p.d(uRLProtocol.getName(), "http") || p.d(uRLProtocol.getName(), "https");
    }

    public static final c getLOGGER() {
        return LOGGER;
    }

    public static final InterfaceC5074l<String, String> mergedHeadersLookup(final OutgoingContent content, final InterfaceC5074l<? super String, String> headerExtractor, final InterfaceC5074l<? super String, ? extends List<String>> allHeadersExtractor) {
        p.i(content, "content");
        p.i(headerExtractor, "headerExtractor");
        p.i(allHeadersExtractor, "allHeadersExtractor");
        return new InterfaceC5074l() { // from class: io.ktor.client.plugins.cache.b
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return HttpCacheKt.mergedHeadersLookup$lambda$0(content, headerExtractor, allHeadersExtractor, (String) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String mergedHeadersLookup$lambda$0(OutgoingContent outgoingContent, InterfaceC5074l interfaceC5074l, InterfaceC5074l interfaceC5074l2, String header) {
        String string;
        String string2;
        p.i(header, "header");
        HttpHeaders httpHeaders = HttpHeaders.INSTANCE;
        if (p.d(header, httpHeaders.getContentLength())) {
            Long contentLength = outgoingContent.getContentLength();
            return (contentLength == null || (string2 = contentLength.toString()) == null) ? "" : string2;
        }
        if (p.d(header, httpHeaders.getContentType())) {
            ContentType contentType = outgoingContent.getContentType();
            return (contentType == null || (string = contentType.toString()) == null) ? "" : string;
        }
        if (p.d(header, httpHeaders.getUserAgent())) {
            String str = outgoingContent.getHeaders().get(httpHeaders.getUserAgent());
            if (str != null) {
                return str;
            }
            String str2 = (String) interfaceC5074l.invoke(httpHeaders.getUserAgent());
            return str2 == null ? UtilsKt.getKTOR_DEFAULT_USER_AGENT() : str2;
        }
        List<String> all = outgoingContent.getHeaders().getAll(header);
        if (all == null && (all = (List) interfaceC5074l2.invoke(header)) == null) {
            all = C1173v.m();
        }
        return F.A0(all, Const.STR_MART_SEMICOLON, null, null, 0, null, null, 62, null);
    }
}
