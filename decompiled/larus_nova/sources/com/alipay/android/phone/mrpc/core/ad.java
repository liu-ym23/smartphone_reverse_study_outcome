package com.alipay.android.phone.mrpc.core;

import java.io.IOException;
import java.net.SocketException;
import javax.net.ssl.SSLException;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.protocol.HttpContext;

/* JADX INFO: loaded from: classes28.dex */
public class ad implements HttpRequestRetryHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f25004a = null;

    static {
        f25004a = "ad";
    }

    public ad() {
    }

    @Override // org.apache.http.client.HttpRequestRetryHandler
    public boolean retryRequest(IOException r100, int r101, HttpContext r102) {
        if (r101 < 3) goto L6;
        return false;
    L6:
        if ((r100 instanceof NoHttpResponseException) == false) goto L9;
        return true;
    L9:
        if ((r100 instanceof SocketException) == true) goto L13;
        if ((r100 instanceof SSLException) == true) goto L13;
    L17:
        return false;
    L13:
        if (r100.getMessage() == null) goto L17;
        if (r100.getMessage().contains("Broken pipe") == false) goto L17;
        return true;
    }
}
