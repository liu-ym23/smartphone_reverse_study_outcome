package org.apache.http.params;

import java.nio.charset.CodingErrorAction;
import org.apache.http.HttpVersion;
import org.apache.http.ProtocolVersion;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.Args;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public final class HttpProtocolParams implements CoreProtocolPNames {
    private HttpProtocolParams() {
    }

    public static String getContentCharset(HttpParams r10) {
        Args.notNull(r10, "HTTP parameters");
        String r11 = (String) r10.getParameter("http.protocol.content-charset");
        if (r11 == null) goto L5;
        return r11;
    L5:
        return HTTP.DEF_CONTENT_CHARSET.name();
    }

    public static String getHttpElementCharset(HttpParams r10) {
        Args.notNull(r10, "HTTP parameters");
        String r11 = (String) r10.getParameter("http.protocol.element-charset");
        if (r11 == null) goto L5;
        return r11;
    L5:
        return HTTP.DEF_PROTOCOL_CHARSET.name();
    }

    public static CodingErrorAction getMalformedInputAction(HttpParams r10) {
        Args.notNull(r10, "HTTP parameters");
        Object r11 = r10.getParameter(CoreProtocolPNames.HTTP_MALFORMED_INPUT_ACTION);
        if (r11 != null) goto L7;
        return CodingErrorAction.REPORT;
    L7:
        return (CodingErrorAction) r11;
    }

    public static CodingErrorAction getUnmappableInputAction(HttpParams r10) {
        Args.notNull(r10, "HTTP parameters");
        Object r11 = r10.getParameter(CoreProtocolPNames.HTTP_UNMAPPABLE_INPUT_ACTION);
        if (r11 != null) goto L7;
        return CodingErrorAction.REPORT;
    L7:
        return (CodingErrorAction) r11;
    }

    public static String getUserAgent(HttpParams r10) {
        Args.notNull(r10, "HTTP parameters");
        return (String) r10.getParameter("http.useragent");
    }

    public static ProtocolVersion getVersion(HttpParams r10) {
        Args.notNull(r10, "HTTP parameters");
        Object r11 = r10.getParameter("http.protocol.version");
        if (r11 != null) goto L7;
        return HttpVersion.HTTP_1_1;
    L7:
        return (ProtocolVersion) r11;
    }

    public static void setContentCharset(HttpParams r10, String r11) {
        Args.notNull(r10, "HTTP parameters");
        r10.setParameter("http.protocol.content-charset", r11);
    }

    public static void setHttpElementCharset(HttpParams r10, String r11) {
        Args.notNull(r10, "HTTP parameters");
        r10.setParameter("http.protocol.element-charset", r11);
    }

    public static void setMalformedInputAction(HttpParams r10, CodingErrorAction r11) {
        Args.notNull(r10, "HTTP parameters");
        r10.setParameter(CoreProtocolPNames.HTTP_MALFORMED_INPUT_ACTION, r11);
    }

    public static void setUnmappableInputAction(HttpParams r10, CodingErrorAction r11) {
        Args.notNull(r10, "HTTP parameters");
        r10.setParameter(CoreProtocolPNames.HTTP_UNMAPPABLE_INPUT_ACTION, r11);
    }

    public static void setUseExpectContinue(HttpParams r10, boolean r11) {
        Args.notNull(r10, "HTTP parameters");
        r10.setBooleanParameter("http.protocol.expect-continue", r11);
    }

    public static void setUserAgent(HttpParams r10, String r11) {
        Args.notNull(r10, "HTTP parameters");
        r10.setParameter("http.useragent", r11);
    }

    public static void setVersion(HttpParams r10, ProtocolVersion r11) {
        Args.notNull(r10, "HTTP parameters");
        r10.setParameter("http.protocol.version", r11);
    }

    public static boolean useExpectContinue(HttpParams r10) {
        Args.notNull(r10, "HTTP parameters");
        return r10.getBooleanParameter("http.protocol.expect-continue", false);
    }
}
