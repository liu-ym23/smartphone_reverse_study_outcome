package org.apache.http.params;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class HttpConnectionParamBean extends HttpAbstractParamBean {
    public HttpConnectionParamBean(HttpParams r10) {
        super(r10);
    }

    public void setConnectionTimeout(int r10) {
        HttpConnectionParams.setConnectionTimeout(this.params, r10);
    }

    public void setLinger(int r10) {
        HttpConnectionParams.setLinger(this.params, r10);
    }

    public void setSoTimeout(int r10) {
        HttpConnectionParams.setSoTimeout(this.params, r10);
    }

    public void setSocketBufferSize(int r10) {
        HttpConnectionParams.setSocketBufferSize(this.params, r10);
    }

    public void setStaleCheckingEnabled(boolean r10) {
        HttpConnectionParams.setStaleCheckingEnabled(this.params, r10);
    }

    public void setTcpNoDelay(boolean r10) {
        HttpConnectionParams.setTcpNoDelay(this.params, r10);
    }
}
