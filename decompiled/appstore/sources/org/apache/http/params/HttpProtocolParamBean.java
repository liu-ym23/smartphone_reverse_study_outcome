package org.apache.http.params;

import org.apache.http.HttpVersion;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class HttpProtocolParamBean extends HttpAbstractParamBean {
    public HttpProtocolParamBean(HttpParams r10) {
        super(r10);
    }

    public void setContentCharset(String r10) {
        HttpProtocolParams.setContentCharset(this.params, r10);
    }

    public void setHttpElementCharset(String r10) {
        HttpProtocolParams.setHttpElementCharset(this.params, r10);
    }

    public void setUseExpectContinue(boolean r10) {
        HttpProtocolParams.setUseExpectContinue(this.params, r10);
    }

    public void setUserAgent(String r10) {
        HttpProtocolParams.setUserAgent(this.params, r10);
    }

    public void setVersion(HttpVersion r10) {
        HttpProtocolParams.setVersion(this.params, r10);
    }
}
