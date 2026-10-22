package com.bytedance.apm.agent.instrumentation.transaction;

import com.bytedance.apm.agent.logging.AgentLog;
import com.bytedance.apm.agent.logging.AgentLogManager;
import com.bytedance.apm.util.y;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class TransactionState {
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
            State r10 = new State("READY", 0);
            READY = r10;
            State r11 = new State("SENT", 1);
            SENT = r11;
            State r12 = new State("COMPLETE", 2);
            COMPLETE = r12;
            $VALUES = new State[]{r10, r11, r12};
        }

        private State(String r10, int r11) {
            super(r10, r11);
        }

        public static State valueOf(String r10) {
            return (State) Enum.valueOf(State.class, r10);
        }

        public static State[] values() {
            return (State[]) $VALUES.clone();
        }
    }

    static {
        LOG = AgentLogManager.getAgentLog();
    }

    public TransactionState() {
        this.carrier = "unknown";
        this.wanType = "unknown";
        this.state = State.READY;
        this.extraData = new JSONObject();
    }

    private TransactionData toTransactionData() {
        if (isComplete() == true) goto L5;
        LOG.warning("toTransactionData() called on incomplete TransactionState");
    L5:
        String r10 = this.url;
        if (r10 != null) goto L10;
        LOG.error("Attempted to convert TransactionData TransactionState instance with no URL into TransactionData TransactionData");
        return null;
    L10:
        if (this.transactionData != null) goto L13;
        TransactionData r11 = new TransactionData(r10, this.carrier, this.endTime - this.startTime, this.statusCode, this.errorCode, this.bytesSent, this.bytesReceived, this.wanType, this.httpMethod, this.extraData);
        this.transactionData = r11;
        r11.setRequestEnd(this.endTime);
        this.transactionData.setErrorCode(this.errorCode);
    L13:
        return this.transactionData;
    }

    public void addAssistData(String r10, String r11) {
        if (isComplete() == false) goto L10;
        LOG.warning("addAssistData(...) called on TransactionState in " + this.state.toString() + " state");
    L10:
        this.extraData.put(r10, r11);     // Catch: JSONException -> L7
        return;
    L7:
        e = move-exception;
        LOG.error("Caught error while addAssistData: ", e);
    }

    public TransactionData end() {
        addAssistData("startTime", this.startTime + "");
        if (isComplete() == true) goto L6;
        this.state = State.COMPLETE;
        this.endTime = System.currentTimeMillis();
    L6:
        return toTransactionData();
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

    public void setBytesReceived(long r10) {
        if (isComplete() == true) goto L5;
        this.bytesReceived = r10;
        return;
    L5:
        LOG.warning("setBytesReceived(...) called on TransactionState in " + this.state.toString() + " state");
    }

    public void setBytesSent(long r10) {
        if (isComplete() == true) goto L5;
        this.bytesSent = r10;
        this.state = State.SENT;
        return;
    L5:
        LOG.warning("setBytesSent(...) called on TransactionState in " + this.state.toString() + " state");
    }

    public void setCarrier(String r10) {
        if (isSent() == true) goto L5;
        this.carrier = r10;
        return;
    L5:
        LOG.warning("setCarrier(...) called on TransactionState in " + this.state.toString() + " state");
    }

    public void setErrorCode(int r10) {
        if (isComplete() == true) goto L5;
        this.errorCode = r10;
        return;
    L5:
        TransactionData r11 = this.transactionData;
        if (r11 == null) goto L8;
        r11.setErrorCode(r10);
    L8:
        LOG.warning("setErrorCode(...) called on TransactionState in " + this.state.toString() + " state");
    }

    public void setMethod(String r10) {
        if (isSent() == true) goto L5;
        this.httpMethod = r10;
        return;
    L5:
        LOG.warning("setHttpMethod(...) called on TransactionState in " + this.state.toString() + " state");
    }

    public void setStartTime(long r10) {
        this.startTime = r10;
    }

    public void setStatusCode(int r10) {
        if (isComplete() == true) goto L6;
        this.statusCode = r10;
        return;
    L6:
        if (this.statusCode != 0) goto L9;
        if (r10 == 0) goto L9;
        this.statusCode = r10;
    L9:
        LOG.warning("setStatusCode(...) called on TransactionState in " + this.state.toString() + " state");
    }

    public void setUrl(String r10) {
        if (this.rawUrl != null) goto L5;
        this.rawUrl = r10;
    L5:
        String r11 = y.c(r10);
        if (r11 != null) goto L9;
        return;
    L9:
        if (isSent() == true) goto L11;
        this.url = r11;
        return;
    L11:
        LOG.warning("setUrl(...) called on TransactionState in " + this.state.toString() + " state");
    }

    public void setWanType(String r10) {
        if (isSent() == true) goto L5;
        this.wanType = r10;
        return;
    L5:
        LOG.warning("setWanType(...) called on TransactionState in " + this.state.toString() + " state");
    }

    public String toString() {
        return " StartTime " + String.valueOf(this.startTime) + " BytesReceived " + String.valueOf(this.bytesReceived) + " BytesSent " + String.valueOf(this.bytesSent) + " Url " + this.url;
    }
}
