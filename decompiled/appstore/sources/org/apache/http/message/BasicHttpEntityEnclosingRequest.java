package org.apache.http.message;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.ProtocolVersion;
import org.apache.http.RequestLine;
import org.apache.http.protocol.HTTP;

/* JADX INFO: loaded from: classes4.dex */
public class BasicHttpEntityEnclosingRequest extends BasicHttpRequest implements HttpEntityEnclosingRequest {
    private HttpEntity entity;

    public BasicHttpEntityEnclosingRequest(String r10, String r11) {
        super(r10, r11);
    }

    @Override // org.apache.http.HttpEntityEnclosingRequest
    public boolean expectContinue() {
        Header r10 = getFirstHeader("Expect");
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (HTTP.EXPECT_CONTINUE.equalsIgnoreCase(r10.getValue()) == false) goto L7;
        return true;
    }

    @Override // org.apache.http.HttpEntityEnclosingRequest
    public HttpEntity getEntity() {
        return this.entity;
    }

    @Override // org.apache.http.HttpEntityEnclosingRequest
    public void setEntity(HttpEntity r10) {
        this.entity = r10;
    }

    public BasicHttpEntityEnclosingRequest(String r10, String r11, ProtocolVersion r12) {
        super(r10, r11, r12);
    }

    public BasicHttpEntityEnclosingRequest(RequestLine r10) {
        super(r10);
    }
}
