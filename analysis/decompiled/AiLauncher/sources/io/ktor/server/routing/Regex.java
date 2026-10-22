package io.ktor.server.routing;

import La.H;
import La.InterfaceC0961k;
import La.InterfaceC0962l;
import La.MatchGroup;
import com.fasterxml.jackson.core.JsonPointer;
import e9.InterfaceC4014c;
import io.ktor.http.Parameters;
import io.ktor.http.ParametersBuilder;
import io.ktor.http.ParametersKt;
import io.ktor.server.routing.RouteSelectorEvaluation;
import io.ktor.util.PlatformUtils;
import java.util.Iterator;
import kotlin.Metadata;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J'\u0010\f\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ \u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\bH\u0096@¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0016¨\u0006\u0018"}, d2 = {"Lio/ktor/server/routing/PathSegmentRegexRouteSelector;", "Lio/ktor/server/routing/RouteSelector;", "Lkotlin/text/Regex;", "regex", "<init>", "(Lkotlin/text/Regex;)V", "LLa/m;", "result", "", "lastSlashPosition", "", "prefix", "countSegments", "(LLa/m;ILjava/lang/String;)I", "Lio/ktor/server/routing/RoutingResolveContext;", "context", "segmentIndex", "Lio/ktor/server/routing/RouteSelectorEvaluation;", "evaluate", "(Lio/ktor/server/routing/RoutingResolveContext;ILe9/c;)Ljava/lang/Object;", "toString", "()Ljava/lang/String;", "Lkotlin/text/Regex;", "Companion", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: io.ktor.server.routing.PathSegmentRegexRouteSelector, reason: from toString */
/* loaded from: classes4.dex */
public final class Regex extends RouteSelector {
    private static final kotlin.text.Regex GROUP_NAME_MATCHER;
    private final kotlin.text.Regex regex;

    static {
        GROUP_NAME_MATCHER = PlatformUtils.INSTANCE.getIS_JS() ? new kotlin.text.Regex("(^|[^\\\\])\\(\\?<(\\p{L}[\\p{L}\\p{N}]*)>(.*?[^\\\\])?\\)") : new kotlin.text.Regex("(^|[^\\\\])\\(\\?<(\\p{Alpha}\\p{Alnum}*)>(.*?[^\\\\])?\\)");
    }

    public Regex(kotlin.text.Regex regex) {
        kotlin.jvm.internal.p.i(regex, "regex");
        this.regex = regex;
    }

    private final int countSegments(La.m result, int lastSlashPosition, String prefix) {
        String value = result.getValue();
        String strSubstring = value.substring(0, lastSlashPosition);
        kotlin.jvm.internal.p.h(strSubstring, "substring(...)");
        int i10 = 0;
        for (int i11 = 0; i11 < strSubstring.length(); i11++) {
            if (strSubstring.charAt(i11) == '/') {
                i10++;
            }
        }
        return kotlin.jvm.internal.p.d(prefix, "/") ? i10 : i10 + 1;
    }

    @Override // io.ktor.server.routing.RouteSelector
    public Object evaluate(RoutingResolveContext routingResolveContext, int i10, InterfaceC4014c<? super RouteSelectorEvaluation> interfaceC4014c) {
        int iCountSegments;
        String value;
        String str = (H.i1(this.regex.h(), JsonPointer.SEPARATOR, false, 2, null) || La.D.X(this.regex.h(), "\\/", false, 2, null)) ? "/" : "";
        String strA0 = Z8.F.A0(Z8.F.h0(routingResolveContext.getSegments(), i10), "/", str, (H.j0(this.regex.h(), JsonPointer.SEPARATOR, false, 2, null) && IgnoreTrailingSlashKt.getIgnoreTrailingSlash(routingResolveContext.getCall())) ? "/" : "", 0, null, null, 56, null);
        La.m mVarD = kotlin.text.Regex.d(this.regex, strA0, 0, 2, null);
        if (mVarD == null) {
            return RouteSelectorEvaluation.INSTANCE.getFailed();
        }
        int length = mVarD.getValue().length();
        if (strA0.length() == length) {
            iCountSegments = routingResolveContext.getSegments().size() - i10;
        } else {
            if (strA0.charAt(length) != '/') {
                if (length >= 1) {
                    int i11 = length - 1;
                    if (strA0.charAt(i11) == '/') {
                        iCountSegments = countSegments(mVarD, i11, str);
                    }
                }
                return RouteSelectorEvaluation.INSTANCE.getFailed();
            }
            iCountSegments = countSegments(mVarD, length, str);
        }
        InterfaceC0961k groups = mVarD.getGroups();
        kotlin.jvm.internal.p.g(groups, "null cannot be cast to non-null type kotlin.text.MatchNamedGroupCollection");
        InterfaceC0962l interfaceC0962l = (InterfaceC0962l) groups;
        Parameters.Companion companion = Parameters.INSTANCE;
        ParametersBuilder parametersBuilderParametersBuilder$default = ParametersKt.ParametersBuilder$default(0, 1, null);
        Iterator it = kotlin.text.Regex.f(GROUP_NAME_MATCHER, this.regex.h(), 0, 2, null).iterator();
        while (it.hasNext()) {
            String str2 = ((La.m) it.next()).b().getMatch().c().get(2);
            MatchGroup matchGroup = interfaceC0962l.get(str2);
            if (matchGroup == null || (value = matchGroup.getValue()) == null) {
                value = "";
            }
            parametersBuilderParametersBuilder$default.append(str2, value);
        }
        return new RouteSelectorEvaluation.Success(1.0d, parametersBuilderParametersBuilder$default.build(), iCountSegments);
    }

    public String toString() {
        return "Regex(" + this.regex.h() + ')';
    }
}
