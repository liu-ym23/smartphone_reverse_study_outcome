package com.slardaros.client.monitor.network.httpurlconnection;

import androidx.core.os.EnvironmentCompat;
import com.obric.olog.OLog;
import com.slardaros.client.monitor.network.NetUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class TransactionState {
    public static final String TAG = "TransactionState";
    private long bytesReceived;
    private long bytesSent;
    private String carrier;
    private long endTime;
    private int errorCode;
    private Exception exception;
    private JSONObject extraData;
    private String httpMethod;
    private boolean isBackground;
    private String rawUrl;
    private long startTime;
    private State state;
    private int statusCode;
    private TransactionData transactionData;
    private String url;
    private String wanType;

    private static final enum State extends Enum<State> {
        private static final /* synthetic */ State[] $VALUES = null;
        public static final State COMPLETE = null;
        public static final State READY = null;
        public static final State SENT = null;

        private State(String r1, int r2) {
            super(r1, r2);
        }

        public static State valueOf(String r1) {
            return (State) Enum.valueOf(State.class, r1);
        }

        public static State[] values() {
            return (State[]) $VALUES.clone();
        }

        static {
            State r0 = new State("READY", 0);
            READY = r0;
            State r1 = new State("SENT", 1);
            SENT = r1;
            State r3 = new State("COMPLETE", 2);
            COMPLETE = r3;
            $VALUES = new State[]{r0, r1, r3};
        }
    }

    public TransactionState() {
        this.isBackground = true;
        this.exception = null;
        this.carrier = EnvironmentCompat.MEDIA_UNKNOWN;
        this.wanType = EnvironmentCompat.MEDIA_UNKNOWN;
        this.state = State.READY;
        this.extraData = new JSONObject();
    }

    public long getStartTime() {
        return this.startTime;
    }

    public void setStartTime(long r1) {
        this.startTime = r1;
    }

    public void setUrl(String r2) {
        if (this.rawUrl != null) goto L5;
        this.rawUrl = r2;
    L5:
        String r3 = NetUtil.sanitizeUrl(r2);
        if (r3 != null) goto L9;
        return;
    L9:
        if (isSent() == true) goto L11;
        this.url = r3;
        return;
    L11:
        OLog.w(TAG, "setUrl(...) called on TransactionState in " + this.state.toString() + " state");
    }

    public String getUrl() {
        return this.url;
    }

    public void setCarrier(String r2) {
        if (isSent() == true) goto L5;
        this.carrier = r2;
        return;
    L5:
        OLog.w(TAG, "setCarrier(...) called on TransactionState in " + this.state.toString() + " state");
    }

    public void setMethod(String r2) {
        if (isSent() == true) goto L5;
        this.httpMethod = r2;
        return;
    L5:
        OLog.w(TAG, "setHttpMethod(...) called on TransactionState in " + this.state.toString() + " state");
    }

    public void setWanType(String r2) {
        if (isSent() == true) goto L5;
        this.wanType = r2;
        return;
    L5:
        OLog.w(TAG, "setWanType(...) called on TransactionState in " + this.state.toString() + " state");
    }

    public void addAssistData(String r3, String r4) {
        if (isComplete() == false) goto L10;
        OLog.w(TAG, "addAssistData(...) called on TransactionState in " + this.state.toString() + " state");
    L10:
        this.extraData.put(r3, r4);     // Catch: JSONException -> L7
        return;
    L7:
        e = move-exception;
        OLog.e("Caught error while addAssistData: ", e.getMessage());
    }

    public boolean isSent() {
        if (this.state.ordinal() < State.SENT.ordinal()) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isComplete() {
        if (this.state.ordinal() < State.COMPLETE.ordinal()) goto L5;
        return true;
    L5:
        return false;
    }

    public void setStatusCode(int r2) {
        if (isComplete() == true) goto L6;
        this.statusCode = r2;
        return;
    L6:
        if (this.statusCode != 0) goto L9;
        if (r2 == 0) goto L9;
        this.statusCode = r2;
    L9:
        OLog.w(TAG, "setStatusCode(...) called on TransactionState in " + this.state.toString() + " state");
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public void setErrorCode(int r2) {
        if (isComplete() == true) goto L5;
        this.errorCode = r2;
        return;
    L5:
        TransactionData r0 = this.transactionData;
        if (r0 == null) goto L8;
        r0.setErrorCode(r2);
    L8:
        OLog.w(TAG, "setErrorCode(...) called on TransactionState in " + this.state.toString() + " state");
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public void setBytesSent(long r2) {
        if (isComplete() == true) goto L5;
        this.bytesSent = r2;
        this.state = State.SENT;
        return;
    L5:
        OLog.w(TAG, "setBytesSent(...) called on TransactionState in " + this.state.toString() + " state");
    }

    public void setBytesReceived(long r2) {
        if (isComplete() == true) goto L5;
        this.bytesReceived = r2;
        return;
    L5:
        OLog.w(TAG, "setBytesReceived(...) called on TransactionState in " + this.state.toString() + " state");
    }

    public long getReceivedBytes() {
        return this.bytesReceived;
    }

    public void setIsBackground(boolean r1) {
        this.isBackground = r1;
    }

    public boolean getIsBackground() {
        return this.isBackground;
    }

    public void setException(Exception r1) {
        this.exception = r1;
    }

    public Exception getException() {
        return this.exception;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder(" StartTime ");
        r0.append(String.valueOf(this.startTime)).append(" BytesReceived ").append(String.valueOf(this.bytesReceived)).append(" BytesSent ").append(String.valueOf(this.bytesSent)).append(" Url ").append(this.url);
        return r0.toString();
    }

    public TransactionData end() {
        addAssistData("startTime", this.startTime + "");
        if (isComplete() == true) goto L6;
        this.state = State.COMPLETE;
        this.endTime = System.currentTimeMillis();
    L6:
        return toTransactionData();
    }

    private TransactionData toTransactionData() {
        if (isComplete() == true) goto L6;
        OLog.w(TAG, "toTransactionData() called on incomplete TransactionState");
    L6:
        if (this.url != null) goto L10;
        OLog.e(TAG, "Attempted to convert TransactionData TransactionState instance with no URL into TransactionData TransactionData");
        return null;
    L10:
        if (this.transactionData != null) goto L13;
        TransactionData r0 = new TransactionData(this.url, this.carrier, this.endTime - this.startTime, this.statusCode, this.errorCode, this.bytesSent, this.bytesReceived, this.wanType, this.httpMethod, this.extraData);
        this.transactionData = r0;
        r0.setRequestEnd(this.endTime);
        this.transactionData.setErrorCode(this.errorCode);
    L13:
        return this.transactionData;
    }
}
