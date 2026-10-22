package io.ktor.http;

import Z8.C1172u;
import Z8.C1174w;
import com.autonavi.aps.amapapi.config.Const;
import com.fasterxml.jackson.core.JsonPointer;
import io.ktor.util.StringValuesKt;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000J\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\u001a\u0015\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0015\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0003\u0010\u0007\u001a!\u0010\u000b\u001a\u00020\u00022\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\u000b\u0010\f\u001a\u0017\u0010\r\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\r\u0010\u0004\u001a\u0015\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0015\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u0011\u001a\u0015\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u000e\u0010\u0012\u001a\u0019\u0010\u0013\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u0019\u0010\u0013\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0015\u001a/\u0010\u001c\u001a\u00020\t*\u00060\u0016j\u0002`\u00172\u0006\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u001aH\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001a-\u0010\u001c\u001a\u00020\t*\u00060\u0016j\u0002`\u00172\u0006\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010 \u001a+\u0010%\u001a\u00020\t*\u00060!j\u0002`\"2\b\u0010#\u001a\u0004\u0018\u00010\u00002\b\u0010$\u001a\u0004\u0018\u00010\u0000H\u0000¢\u0006\u0004\b%\u0010&\"\u0015\u0010)\u001a\u00020\u0000*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b'\u0010(\"\u0015\u0010+\u001a\u00020\u0000*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b*\u0010(\"\u0015\u0010-\u001a\u00020\u0000*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b,\u0010(\"\u0015\u0010.\u001a\u00020\u001a*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b.\u0010/\"\u0015\u00100\u001a\u00020\u001a*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b0\u0010/\"\u0015\u0010.\u001a\u00020\u001a*\u00020\u00058F¢\u0006\u0006\u001a\u0004\b.\u00101\"\u0015\u00100\u001a\u00020\u001a*\u00020\u00058F¢\u0006\u0006\u001a\u0004\b0\u00101¨\u00062"}, d2 = {"", "urlString", "Lio/ktor/http/Url;", "Url", "(Ljava/lang/String;)Lio/ktor/http/Url;", "Lio/ktor/http/URLBuilder;", "builder", "(Lio/ktor/http/URLBuilder;)Lio/ktor/http/Url;", "Lkotlin/Function1;", "LY8/t;", "block", "buildUrl", "(Lp9/l;)Lio/ktor/http/Url;", "parseUrl", "URLBuilder", "(Ljava/lang/String;)Lio/ktor/http/URLBuilder;", "url", "(Lio/ktor/http/Url;)Lio/ktor/http/URLBuilder;", "(Lio/ktor/http/URLBuilder;)Lio/ktor/http/URLBuilder;", "takeFrom", "(Lio/ktor/http/URLBuilder;Lio/ktor/http/URLBuilder;)Lio/ktor/http/URLBuilder;", "(Lio/ktor/http/URLBuilder;Lio/ktor/http/Url;)Lio/ktor/http/URLBuilder;", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "encodedPath", "encodedQuery", "", "trailingQuery", "appendUrlFullPath", "(Ljava/lang/Appendable;Ljava/lang/String;Ljava/lang/String;Z)V", "Lio/ktor/http/ParametersBuilder;", "encodedQueryParameters", "(Ljava/lang/Appendable;Ljava/lang/String;Lio/ktor/http/ParametersBuilder;Z)V", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "encodedUser", "encodedPassword", "appendUserAndPassword", "(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V", "getFullPath", "(Lio/ktor/http/Url;)Ljava/lang/String;", "fullPath", "getHostWithPort", "hostWithPort", "getHostWithPortIfSpecified", "hostWithPortIfSpecified", "isAbsolutePath", "(Lio/ktor/http/Url;)Z", "isRelativePath", "(Lio/ktor/http/URLBuilder;)Z", "ktor-http"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class URLUtilsKt {
    public static final URLBuilder URLBuilder(String urlString) {
        kotlin.jvm.internal.p.i(urlString, "urlString");
        return URLParserKt.takeFrom(new URLBuilder(null, null, 0, null, null, null, null, null, false, 511, null), urlString);
    }

    public static final Url Url(String urlString) {
        kotlin.jvm.internal.p.i(urlString, "urlString");
        return URLBuilder(urlString).build();
    }

    public static final void appendUrlFullPath(Appendable appendable, String encodedPath, String encodedQuery, boolean z10) throws IOException {
        kotlin.jvm.internal.p.i(appendable, "<this>");
        kotlin.jvm.internal.p.i(encodedPath, "encodedPath");
        kotlin.jvm.internal.p.i(encodedQuery, "encodedQuery");
        if (!La.H.x0(encodedPath) && !La.D.X(encodedPath, "/", false, 2, null)) {
            appendable.append(JsonPointer.SEPARATOR);
        }
        appendable.append(encodedPath);
        if (encodedQuery.length() > 0 || z10) {
            appendable.append("?");
        }
        appendable.append(encodedQuery);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence appendUrlFullPath$lambda$6(Pair it) {
        kotlin.jvm.internal.p.i(it, "it");
        String str = (String) it.e();
        if (it.f() == null) {
            return str;
        }
        return str + '=' + String.valueOf(it.f());
    }

    public static final void appendUserAndPassword(StringBuilder sb2, String str, String str2) {
        kotlin.jvm.internal.p.i(sb2, "<this>");
        if (str == null) {
            return;
        }
        sb2.append(str);
        if (str2 != null) {
            sb2.append(':');
            sb2.append(str2);
        }
        sb2.append("@");
    }

    public static final Url buildUrl(InterfaceC5074l<? super URLBuilder, Y8.t> block) {
        kotlin.jvm.internal.p.i(block, "block");
        URLBuilder uRLBuilder = new URLBuilder(null, null, 0, null, null, null, null, null, false, 511, null);
        block.invoke(uRLBuilder);
        return uRLBuilder.build();
    }

    public static final String getFullPath(Url url) throws IOException {
        kotlin.jvm.internal.p.i(url, "<this>");
        StringBuilder sb2 = new StringBuilder();
        appendUrlFullPath(sb2, url.getEncodedPath(), url.getEncodedQuery(), url.getTrailingQuery());
        return sb2.toString();
    }

    public static final String getHostWithPort(Url url) {
        kotlin.jvm.internal.p.i(url, "<this>");
        return url.getHost() + ':' + url.getPort();
    }

    public static final String getHostWithPortIfSpecified(Url url) {
        kotlin.jvm.internal.p.i(url, "<this>");
        int specifiedPort = url.getSpecifiedPort();
        return (specifiedPort == 0 || specifiedPort == url.getProtocol().getDefaultPort()) ? url.getHost() : getHostWithPort(url);
    }

    public static final boolean isAbsolutePath(Url url) {
        kotlin.jvm.internal.p.i(url, "<this>");
        return kotlin.jvm.internal.p.d(Z8.F.s0(url.getRawSegments()), "");
    }

    public static final boolean isRelativePath(Url url) {
        kotlin.jvm.internal.p.i(url, "<this>");
        return !isAbsolutePath(url);
    }

    public static final Url parseUrl(String urlString) {
        kotlin.jvm.internal.p.i(urlString, "urlString");
        try {
            URLBuilder URLBuilder = URLBuilder(urlString);
            if (URLBuilder.getHost().length() <= 0) {
                URLBuilder = null;
            }
            if (URLBuilder != null) {
                return URLBuilder.build();
            }
        } catch (URLParserException unused) {
        }
        return null;
    }

    public static final URLBuilder takeFrom(URLBuilder uRLBuilder, URLBuilder url) {
        kotlin.jvm.internal.p.i(uRLBuilder, "<this>");
        kotlin.jvm.internal.p.i(url, "url");
        uRLBuilder.setProtocolOrNull(url.getProtocolOrNull());
        uRLBuilder.setHost(url.getHost());
        uRLBuilder.setPort(url.getPort());
        uRLBuilder.setEncodedPathSegments(url.getEncodedPathSegments());
        uRLBuilder.setEncodedUser(url.getEncodedUser());
        uRLBuilder.setEncodedPassword(url.getEncodedPassword());
        ParametersBuilder parametersBuilderParametersBuilder$default = ParametersKt.ParametersBuilder$default(0, 1, null);
        StringValuesKt.appendAll(parametersBuilderParametersBuilder$default, url.getEncodedParameters());
        uRLBuilder.setEncodedParameters(parametersBuilderParametersBuilder$default);
        uRLBuilder.setEncodedFragment(url.getEncodedFragment());
        uRLBuilder.setTrailingQuery(url.getTrailingQuery());
        return uRLBuilder;
    }

    public static final URLBuilder URLBuilder(Url url) {
        kotlin.jvm.internal.p.i(url, "url");
        return takeFrom(new URLBuilder(null, null, 0, null, null, null, null, null, false, 511, null), url);
    }

    public static final Url Url(URLBuilder builder) {
        kotlin.jvm.internal.p.i(builder, "builder");
        return takeFrom(new URLBuilder(null, null, 0, null, null, null, null, null, false, 511, null), builder).build();
    }

    public static final boolean isAbsolutePath(URLBuilder uRLBuilder) {
        kotlin.jvm.internal.p.i(uRLBuilder, "<this>");
        return kotlin.jvm.internal.p.d(Z8.F.s0(uRLBuilder.getPathSegments()), "");
    }

    public static final boolean isRelativePath(URLBuilder uRLBuilder) {
        kotlin.jvm.internal.p.i(uRLBuilder, "<this>");
        return !isAbsolutePath(uRLBuilder);
    }

    public static final URLBuilder URLBuilder(URLBuilder builder) {
        kotlin.jvm.internal.p.i(builder, "builder");
        return takeFrom(new URLBuilder(null, null, 0, null, null, null, null, null, false, 511, null), builder);
    }

    public static final void appendUrlFullPath(Appendable appendable, String encodedPath, ParametersBuilder encodedQueryParameters, boolean z10) {
        List listE;
        kotlin.jvm.internal.p.i(appendable, "<this>");
        kotlin.jvm.internal.p.i(encodedPath, "encodedPath");
        kotlin.jvm.internal.p.i(encodedQueryParameters, "encodedQueryParameters");
        if (!La.H.x0(encodedPath) && !La.D.X(encodedPath, "/", false, 2, null)) {
            appendable.append(JsonPointer.SEPARATOR);
        }
        appendable.append(encodedPath);
        if (!encodedQueryParameters.isEmpty() || z10) {
            appendable.append("?");
        }
        Set<Map.Entry<String, List<String>>> setEntries = encodedQueryParameters.entries();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = setEntries.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String str = (String) entry.getKey();
            List list = (List) entry.getValue();
            if (list.isEmpty()) {
                listE = C1172u.e(Y8.j.a(str, null));
            } else {
                List list2 = list;
                ArrayList arrayList2 = new ArrayList(C1174w.x(list2, 10));
                Iterator it2 = list2.iterator();
                while (it2.hasNext()) {
                    arrayList2.add(Y8.j.a(str, (String) it2.next()));
                }
                listE = arrayList2;
            }
            Z8.A.E(arrayList, listE);
        }
        Z8.F.x0(arrayList, appendable, (124 & 2) != 0 ? ", " : Const.STR_MART_ADD, (124 & 4) != 0 ? "" : null, (124 & 8) == 0 ? null : "", (124 & 16) != 0 ? -1 : 0, (124 & 32) != 0 ? "..." : null, (124 & 64) != 0 ? null : new InterfaceC5074l() { // from class: io.ktor.http.D
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return URLUtilsKt.appendUrlFullPath$lambda$6((Pair) obj);
            }
        });
    }

    public static final URLBuilder takeFrom(URLBuilder uRLBuilder, Url url) {
        kotlin.jvm.internal.p.i(uRLBuilder, "<this>");
        kotlin.jvm.internal.p.i(url, "url");
        uRLBuilder.setProtocolOrNull(url.getProtocolOrNull());
        uRLBuilder.setHost(url.getHost());
        uRLBuilder.setPort(url.getPort());
        URLBuilderKt.setEncodedPath(uRLBuilder, url.getEncodedPath());
        uRLBuilder.setEncodedUser(url.getEncodedUser());
        uRLBuilder.setEncodedPassword(url.getEncodedPassword());
        ParametersBuilder parametersBuilderParametersBuilder$default = ParametersKt.ParametersBuilder$default(0, 1, null);
        parametersBuilderParametersBuilder$default.appendAll(QueryKt.parseQueryString$default(url.getEncodedQuery(), 0, 0, false, 6, null));
        uRLBuilder.setEncodedParameters(parametersBuilderParametersBuilder$default);
        uRLBuilder.setEncodedFragment(url.getEncodedFragment());
        uRLBuilder.setTrailingQuery(url.getTrailingQuery());
        return uRLBuilder;
    }
}
