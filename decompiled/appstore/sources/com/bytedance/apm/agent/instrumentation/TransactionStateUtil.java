package com.bytedance.apm.agent.instrumentation;

import com.bytedance.apm.agent.instrumentation.transaction.TransactionState;
import com.bytedance.apm.agent.logging.AgentLog;
import com.bytedance.apm.agent.logging.AgentLogManager;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLException;
import org.apache.http.conn.ConnectTimeoutException;

/* JADX INFO: loaded from: classes.dex */
public class TransactionStateUtil {
    private static final AgentLog log = null;

    static {
        log = AgentLogManager.getAgentLog();
    }

    public TransactionStateUtil() {
    }

    public static void inspectAndInstrument(TransactionState r10, HttpURLConnection r11) {
        r10.setUrl(r11.getURL().toString());
        r10.setStartTime(System.currentTimeMillis());
        r10.setCarrier("");
    }

    public static void inspectAndInstrumentResponse(TransactionState r10, HttpURLConnection r11) {
        int r12 = r11.getContentLength();
        if (r12 < 0) goto L10;
        r10.setBytesReceived(r12);
    L10:
        int r13 = r11.getResponseCode();     // Catch: Throwable -> L7
    L8:
        r10.setStatusCode(r13);
        return;
    L7:
        r13 = 0;
        goto L8
    }

    public static void setErrorCodeFromException(TransactionState r10, Exception r11) {
        if ((r11 instanceof UnknownHostException) == false) goto L6;
        r10.setErrorCode(-10);
        return;
    L6:
        if ((r11 instanceof SocketTimeoutException) == false) goto L8;
    L20:
        r10.setErrorCode(-11);
        return;
    L8:
        if ((r11 instanceof ConnectTimeoutException) == true) goto L20;
        if ((r11 instanceof ConnectException) == false) goto L14;
        r10.setErrorCode(-12);
        return;
    L14:
        if ((r11 instanceof MalformedURLException) == false) goto L17;
        r10.setErrorCode(-13);
        return;
    L17:
        if ((r11 instanceof SSLException) == false) goto L19;
        r10.setErrorCode(-14);
        return;
    L19:
        r10.setErrorCode(-1);
    }
}
