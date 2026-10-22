package com.bytedance.apm.agent.instrumentation.transaction;

import com.bytedance.apm.agent.logging.AgentLog;
import com.bytedance.apm.agent.logging.AgentLogManager;
import com.ss.android.dypay.api.DyPayConstant;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;
import r27.a;

/* JADX INFO: loaded from: classes14.dex */
public final class TxState {
    private static final AgentLog LOG = null;
    private long bytesReceived;
    private long bytesSent;
    private String carrier;
    private long endTime;
    private int errorCode;
    private JSONObject extraData;
    private String httpMethod;
    private String rawUrl;
    private long startTime;
    private State state;
    private int statusCode;
    private TransactionData transactionData;
    private String url;
    private String wanType;

    public static final enum State extends Enum<State> {
        private static final /* synthetic */ State[] $VALUES = null;
        public static final State COMPLETE = null;
        public static final State READY = null;
        public static final State SENT = null;

        static {
            State r100 = new State("READY", 0);
            READY = r100;
            State r101 = new State("SENT", 1);
            SENT = r101;
            State r102 = new State("COMPLETE", 2);
            COMPLETE = r102;
            $VALUES = new State[]{r100, r101, r102};
        }

        public static State[] values() {
            return (State[]) $VALUES.clone();
        }

        public static State valueOf(String r100) {
            return (State) a.a(State.class, r100);
        }

        private State(String r100, int r101) {
            super(r100, r101);
        }
    }

    private TransactionData toTransactionData() {
        if (isComplete() == true) goto L5;
        LOG.warning("toTransactionData() called on incomplete TransactionState");
    L5:
        String r100 = this.url;
        if (r100 != null) goto L10;
        LOG.error("Attempted to convert TransactionData TransactionState instance with no URL into TransactionData TransactionData");
        return null;
    L10:
        if (this.transactionData != null) goto L13;
        TransactionData r101 = new TransactionData(r100, this.carrier, this.endTime - this.startTime, this.statusCode, this.errorCode, this.bytesSent, this.bytesReceived, this.wanType, this.httpMethod, this.extraData);
        this.transactionData = r101;
        r101.setRequestEnd(this.endTime);
        this.transactionData.setErrorCode(this.errorCode);
    L13:
        return this.transactionData;
    }

    public TransactionData end() {
        addAssistData(DyPayConstant.KEY_START_TIME, this.startTime + "");
        if (isComplete() == true) goto L6;
        this.state = State.COMPLETE;
        this.endTime = System.currentTimeMillis();
    L6:
        return toTransactionData();
    }

    public boolean isComplete() {
        if (this.state.ordinal() < State.COMPLETE.ordinal()) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isSent() {
        if (this.state.ordinal() < State.SENT.ordinal()) goto L5;
        return true;
    L5:
        return false;
    }

    public String toString() {
        return " StartTime " + String.valueOf(this.startTime) + " BytesReceived " + String.valueOf(this.bytesReceived) + " BytesSent " + String.valueOf(this.bytesSent) + " Url " + this.url;
    }

    static {
        LOG = AgentLogManager.getAgentLog();
    }

    public TxState() {
        this.carrier = "unknown";
        this.wanType = "unknown";
        this.state = State.READY;
        this.extraData = new JSONObject();
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public long getReceivedBytes() {
        return this.bytesReceived;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public String getUrl() {
        return this.url;
    }

    public void setBytesReceived(long r100) {
        if (isComplete() == true) goto L5;
        this.bytesReceived = r100;
        return;
    L5:
        LOG.warning("setBytesReceived(...) called on TransactionState in " + this.state.toString() + " state");
    }

    public void setBytesSent(long r100) {
        if (isComplete() == true) goto L5;
        this.bytesSent = r100;
        this.state = State.SENT;
        return;
    L5:
        LOG.warning("setBytesSent(...) called on TransactionState in " + this.state.toString() + " state");
    }

    public void setCarrier(String r100) {
        if (isSent() == true) goto L5;
        this.carrier = r100;
        return;
    L5:
        LOG.warning("setCarrier(...) called on TransactionState in " + this.state.toString() + " state");
    }

    public void setErrorCode(int r100) {
        if (isComplete() == true) goto L5;
        this.errorCode = r100;
        return;
    L5:
        TransactionData r101 = this.transactionData;
        if (r101 == null) goto L8;
        r101.setErrorCode(r100);
    L8:
        LOG.warning("setErrorCode(...) called on TransactionState in " + this.state.toString() + " state");
    }

    public void setMethod(String r100) {
        if (isSent() == true) goto L5;
        this.httpMethod = r100;
        return;
    L5:
        LOG.warning("setHttpMethod(...) called on TransactionState in " + this.state.toString() + " state");
    }

    public void setStartTime(long r100) {
        this.startTime = r100;
    }

    public void setStatusCode(int r100) {
        if (isComplete() == true) goto L6;
        this.statusCode = r100;
        return;
    L6:
        if (this.statusCode != 0) goto L9;
        if (r100 == 0) goto L9;
        this.statusCode = r100;
    L9:
        LOG.warning("setStatusCode(...) called on TransactionState in " + this.state.toString() + " state");
    }

    public void setUrl(String r100) {
        if (this.rawUrl != null) goto L5;
        this.rawUrl = r100;
    L5:
        String r101 = null;
        if (r100 != null) goto L21;
    L13:
        if (r101 != null) goto L16;
        return;
    L16:
        if (isSent() == true) goto L18;
        this.url = r101;
        return;
    L18:
        LOG.warning("setUrl(...) called on TransactionState in " + this.state.toString() + " state");
        return;
    L21:
        URL r102 = new URL(r100);     // Catch: MalformedURLException -> L20
        StringBuffer r103 = new StringBuffer();
        r103.append(r102.getProtocol());
        r103.append("://");
        r103.append(r102.getHost());
        if (r102.getPort() == (-1)) goto L12;
        r103.append(":");
        r103.append(r102.getPort());
    L12:
        r103.append(r102.getPath());
        r101 = r103.toString();
        goto L13
    }

    public void setWanType(String r100) {
        if (isSent() == true) goto L5;
        this.wanType = r100;
        return;
    L5:
        LOG.warning("setWanType(...) called on TransactionState in " + this.state.toString() + " state");
    }

    public void addAssistData(String r100, String r101) {
        if (isComplete() == false) goto L10;
        LOG.warning("addAssistData(...) called on TransactionState in " + this.state.toString() + " state");
    L10:
        this.extraData.put(r100, r101);     // Catch: JSONException -> L7
        return;
    L7:
        e = move-exception;
        LOG.error("Caught error while addAssistData: ", e);
    }
}
