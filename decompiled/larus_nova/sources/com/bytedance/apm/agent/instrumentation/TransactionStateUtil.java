package com.bytedance.apm.agent.instrumentation;

import com.bytedance.apm.agent.instrumentation.transaction.TxState;
import com.bytedance.apm.agent.logging.AgentLog;
import com.bytedance.apm.agent.logging.AgentLogManager;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLException;
import org.apache.http.conn.ConnectTimeoutException;

/* JADX INFO: loaded from: classes14.dex */
public class TransactionStateUtil {
    private static final AgentLog log = null;

    public TransactionStateUtil() {
    }

    static {
        log = AgentLogManager.getAgentLog();
    }

    public static void inspectAndInstrument(TxState r100, HttpURLConnection r101) {
        r100.setUrl(r101.getURL().toString());
        r100.setStartTime(System.currentTimeMillis());
        r100.setCarrier("");
    }

    public static void inspectAndInstrumentResponse(TxState r100, HttpURLConnection r101) {
        int r102 = r101.getContentLength();
        if (r102 < 0) goto L10;
        r100.setBytesReceived(r102);
    L10:
        int r103 = r101.getResponseCode();     // Catch: Throwable -> L7
    L8:
        r100.setStatusCode(r103);
        return;
    L7:
        r103 = 0;
        goto L8
    }

    public static void setErrorCodeFromException(TxState r100, Exception r101) {
        if ((r101 instanceof UnknownHostException) == false) goto L6;
        r100.setErrorCode(-10);
        return;
    L6:
        if ((r101 instanceof SocketTimeoutException) == false) goto L8;
    L20:
        r100.setErrorCode(-11);
        return;
    L8:
        if ((r101 instanceof ConnectTimeoutException) == true) goto L20;
        if ((r101 instanceof ConnectException) == false) goto L14;
        r100.setErrorCode(-12);
        return;
    L14:
        if ((r101 instanceof MalformedURLException) == false) goto L17;
        r100.setErrorCode(-13);
        return;
    L17:
        if ((r101 instanceof SSLException) == false) goto L19;
        r100.setErrorCode(-14);
        return;
    L19:
        r100.setErrorCode(-1);
    }
}
