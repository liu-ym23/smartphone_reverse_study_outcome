package com.slardaros.client.monitor.network.httpurlconnection;

import com.obric.olog.OLog;
import com.slardaros.client.SlardarAgent;
import com.slardaros.client.SlardarUtil;
import java.io.IOException;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLException;
import org.apache.http.conn.ConnectTimeoutException;

/* JADX INFO: loaded from: classes4.dex */
public class TransactionStateUtil {
    private static final String TAG = "TransactionStateUtil";

    public TransactionStateUtil() {
    }

    public static void inspectAndInstrument(TransactionState r2, HttpURLConnection r3) {
        r2.setUrl(r3.getURL().toString());
        r2.setStartTime(System.currentTimeMillis());
        r2.setCarrier("");
        r2.setIsBackground(!SlardarUtil.isAppInForeground(SlardarAgent.getContext()));
    }

    public static void inspectAndInstrumentResponse(TransactionState r3, HttpURLConnection r4) {
        int r1 = r4.getContentLength();
        if (r1 < 0) goto L14;
        r3.setBytesReceived(r1);
    L14:
        int r5 = r4.getResponseCode();     // Catch: NullPointerException -> L7 IOException -> L9
    L12:
        r3.setStatusCode(r5);
        return;
    L9:
        e = move-exception;
        OLog.e(TAG, "Failed to retrieve response code due to an I/O exception: " + e.getMessage());
    L11:
        r5 = 0;
    L7:
        e = move-exception;
        OLog.e(TAG, "Failed to retrieve response code due to underlying (Harmony?) NPE ", e);
        goto L11
    }

    public static void setErrorCodeFromException(TransactionState r1, Exception r2) {
        if ((r2 instanceof UnknownHostException) == false) goto L6;
        r1.setErrorCode(-10);
    L21:
        r1.setException(r2);
        return;
    L6:
        if ((r2 instanceof SocketTimeoutException) == false) goto L8;
    L20:
        r1.setErrorCode(-11);
        goto L21
    L8:
        if ((r2 instanceof ConnectTimeoutException) == true) goto L20;
        if ((r2 instanceof ConnectException) == false) goto L14;
        r1.setErrorCode(-12);
        goto L21
    L14:
        if ((r2 instanceof MalformedURLException) == false) goto L17;
        r1.setErrorCode(-13);
        goto L21
    L17:
        if ((r2 instanceof SSLException) == false) goto L19;
        r1.setErrorCode(-14);
        goto L21
    L19:
        r1.setErrorCode(-1);
        goto L21
    }
}
