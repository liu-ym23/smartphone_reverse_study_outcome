package io.ktor.server.routing;

import La.H;
import La.K;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\bJ\u0015\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lio/ktor/server/routing/PathSegmentSelectorBuilder;", "", "<init>", "()V", "", UxipConstants.f30680s, "Lio/ktor/server/routing/RouteSelector;", "parseParameter", "(Ljava/lang/String;)Lio/ktor/server/routing/RouteSelector;", "parseConstant", "parseName", "(Ljava/lang/String;)Ljava/lang/String;", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PathSegmentSelectorBuilder {
    public static final PathSegmentSelectorBuilder INSTANCE = new PathSegmentSelectorBuilder();

    private PathSegmentSelectorBuilder() {
    }

    public final RouteSelector parseConstant(String value) {
        kotlin.jvm.internal.p.i(value, "value");
        return kotlin.jvm.internal.p.d(value, "*") ? PathSegmentWildcardRouteSelector.INSTANCE : new PathSegmentConstantRouteSelector(value);
    }

    public final String parseName(String value) {
        kotlin.jvm.internal.p.i(value, "value");
        String strSubstring = value.substring(H.u1(value, '{', "").length() + 1, (value.length() - H.q1(value, '}', "").length()) - 1);
        kotlin.jvm.internal.p.h(strSubstring, "substring(...)");
        return La.D.K(strSubstring, "?", false, 2, null) ? K.M1(strSubstring, 1) : La.D.K(strSubstring, "...", false, 2, null) ? K.M1(strSubstring, 3) : strSubstring;
    }

    public final RouteSelector parseParameter(String value) {
        String strSubstring;
        String strSubstring2;
        kotlin.jvm.internal.p.i(value, "value");
        int iT0 = H.t0(value, '{', 0, false, 6, null);
        int iA0 = H.A0(value, '}', 0, false, 6, null);
        if (iT0 == 0) {
            strSubstring = null;
        } else {
            strSubstring = value.substring(0, iT0);
            kotlin.jvm.internal.p.h(strSubstring, "substring(...)");
        }
        if (iA0 == value.length() - 1) {
            strSubstring2 = null;
        } else {
            strSubstring2 = value.substring(iA0 + 1);
            kotlin.jvm.internal.p.h(strSubstring2, "substring(...)");
        }
        String strSubstring3 = value.substring(iT0 + 1, iA0);
        kotlin.jvm.internal.p.h(strSubstring3, "substring(...)");
        if (La.D.K(strSubstring3, "?", false, 2, null)) {
            return new PathSegmentOptionalParameterRouteSelector(K.M1(strSubstring3, 1), strSubstring, strSubstring2);
        }
        if (!La.D.K(strSubstring3, "...", false, 2, null)) {
            return new PathSegmentParameterRouteSelector(strSubstring3, strSubstring, strSubstring2);
        }
        if (strSubstring2 != null && strSubstring2.length() != 0) {
            throw new IllegalArgumentException("Suffix after tailcard is not supported");
        }
        String strM1 = K.M1(strSubstring3, 3);
        if (strSubstring == null) {
            strSubstring = "";
        }
        return new PathSegmentTailcardRouteSelector(strM1, strSubstring);
    }
}
