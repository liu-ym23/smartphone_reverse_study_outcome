package org.apache.http.message;

import java.util.Locale;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.ProtocolVersion;
import org.apache.http.ReasonPhraseCatalog;
import org.apache.http.StatusLine;
import org.apache.http.util.Args;
import org.apache.http.util.TextUtils;

/* JADX INFO: loaded from: classes4.dex */
public class BasicHttpResponse extends AbstractHttpMessage implements HttpResponse {
    private int code;
    private HttpEntity entity;
    private Locale locale;
    private final ReasonPhraseCatalog reasonCatalog;
    private String reasonPhrase;
    private StatusLine statusline;
    private ProtocolVersion ver;

    public BasicHttpResponse(StatusLine r10, ReasonPhraseCatalog r11, Locale r12) {
        this.statusline = (StatusLine) Args.notNull(r10, "Status line");
        this.ver = r10.getProtocolVersion();
        this.code = r10.getStatusCode();
        this.reasonPhrase = r10.getReasonPhrase();
        this.reasonCatalog = r11;
        this.locale = r12;
    }

    @Override // org.apache.http.HttpResponse
    public HttpEntity getEntity() {
        return this.entity;
    }

    @Override // org.apache.http.HttpResponse
    public Locale getLocale() {
        return this.locale;
    }

    @Override // org.apache.http.HttpMessage
    public ProtocolVersion getProtocolVersion() {
        return this.ver;
    }

    public String getReason(int r10) {
        ReasonPhraseCatalog r11 = this.reasonCatalog;
        if (r11 == null) goto L9;
        Locale r12 = this.locale;
        if (r12 != null) goto L11;
        r12 = Locale.getDefault();
    L11:
        return r11.getReason(r10, r12);
    L9:
        return null;
    }

    @Override // org.apache.http.HttpResponse
    public StatusLine getStatusLine() {
        if (this.statusline != null) goto L14;
        ProtocolVersion r10 = this.ver;
        if (r10 != null) goto L8;
        r10 = HttpVersion.HTTP_1_1;
    L8:
        int r11 = this.code;
        String r12 = this.reasonPhrase;
        if (r12 != null) goto L12;
        r12 = getReason(r11);
    L12:
        this.statusline = new BasicStatusLine(r10, r11, r12);
    L14:
        return this.statusline;
    }

    @Override // org.apache.http.HttpResponse
    public void setEntity(HttpEntity r10) {
        this.entity = r10;
    }

    @Override // org.apache.http.HttpResponse
    public void setLocale(Locale r10) {
        this.locale = (Locale) Args.notNull(r10, "Locale");
        this.statusline = null;
    }

    @Override // org.apache.http.HttpResponse
    public void setReasonPhrase(String r10) {
        this.statusline = null;
        if (TextUtils.isBlank(r10) == false) goto L5;
        r10 = null;
    L5:
        this.reasonPhrase = r10;
    }

    @Override // org.apache.http.HttpResponse
    public void setStatusCode(int r10) {
        Args.notNegative(r10, "Status code");
        this.statusline = null;
        this.code = r10;
        this.reasonPhrase = null;
    }

    @Override // org.apache.http.HttpResponse
    public void setStatusLine(StatusLine r10) {
        this.statusline = (StatusLine) Args.notNull(r10, "Status line");
        this.ver = r10.getProtocolVersion();
        this.code = r10.getStatusCode();
        this.reasonPhrase = r10.getReasonPhrase();
    }

    public String toString() {
        StringBuilder r10 = new StringBuilder();
        r10.append(getStatusLine());
        r10.append(TokenParser.SP);
        r10.append(this.headergroup);
        if (this.entity == null) goto L6;
        r10.append(TokenParser.SP);
        r10.append(this.entity);
    L6:
        return r10.toString();
    }

    @Override // org.apache.http.HttpResponse
    public void setStatusLine(ProtocolVersion r10, int r11) {
        Args.notNegative(r11, "Status code");
        this.statusline = null;
        this.ver = r10;
        this.code = r11;
        this.reasonPhrase = null;
    }

    public BasicHttpResponse(StatusLine r10) {
        this.statusline = (StatusLine) Args.notNull(r10, "Status line");
        this.ver = r10.getProtocolVersion();
        this.code = r10.getStatusCode();
        this.reasonPhrase = r10.getReasonPhrase();
        this.reasonCatalog = null;
        this.locale = null;
    }

    @Override // org.apache.http.HttpResponse
    public void setStatusLine(ProtocolVersion r10, int r11, String r12) {
        Args.notNegative(r11, "Status code");
        this.statusline = null;
        this.ver = r10;
        this.code = r11;
        this.reasonPhrase = r12;
    }

    public BasicHttpResponse(ProtocolVersion r10, int r11, String r12) {
        Args.notNegative(r11, "Status code");
        this.statusline = null;
        this.ver = r10;
        this.code = r11;
        this.reasonPhrase = r12;
        this.reasonCatalog = null;
        this.locale = null;
    }
}
