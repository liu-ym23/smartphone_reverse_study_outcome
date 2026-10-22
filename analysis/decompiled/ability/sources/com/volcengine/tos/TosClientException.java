package com.volcengine.tos;

/* loaded from: classes3.dex */
public class TosClientException extends TosException {
    public TosClientException(String str, Exception exc) {
        super(str, exc);
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "TosClientException{cause=" + getCause() + ", message='" + getMessage() + '}';
    }
}
