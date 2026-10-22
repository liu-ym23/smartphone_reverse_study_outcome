package com.zyql.protobuf.runtime;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import u7.b;
import u7.m;
import u7.n;
import u7.p;

/* loaded from: classes2.dex */
public final class RequestAck$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ RequestAck$Builder(int i) {
        this();
    }

    public RequestAck$Builder clearAckType() {
        copyOnWrite();
        m.D((m) this.instance);
        return this;
    }

    public RequestAck$Builder clearCancelAck() {
        copyOnWrite();
        m.E((m) this.instance);
        return this;
    }

    public RequestAck$Builder clearErrorCode() {
        copyOnWrite();
        m.F((m) this.instance);
        return this;
    }

    public RequestAck$Builder clearErrorMessage() {
        copyOnWrite();
        m.G((m) this.instance);
        return this;
    }

    public RequestAck$Builder clearRequestId() {
        copyOnWrite();
        m.H((m) this.instance);
        return this;
    }

    public RequestAck$Builder clearSendInputAck() {
        copyOnWrite();
        m.I((m) this.instance);
        return this;
    }

    public RequestAck$Builder clearStartAgentAck() {
        copyOnWrite();
        m.J((m) this.instance);
        return this;
    }

    public RequestAck$AckTypeCase getAckTypeCase() {
        return ((m) this.instance).V();
    }

    public b getCancelAck() {
        return ((m) this.instance).W();
    }

    public int getErrorCode() {
        return ((m) this.instance).Y();
    }

    public String getErrorMessage() {
        return ((m) this.instance).Z();
    }

    public ByteString getErrorMessageBytes() {
        return ((m) this.instance).a0();
    }

    public long getRequestId() {
        return ((m) this.instance).b0();
    }

    public n getSendInputAck() {
        return ((m) this.instance).c0();
    }

    public p getStartAgentAck() {
        return ((m) this.instance).d0();
    }

    public boolean hasCancelAck() {
        return ((m) this.instance).e0();
    }

    public boolean hasErrorCode() {
        return ((m) this.instance).f0();
    }

    public boolean hasErrorMessage() {
        return ((m) this.instance).g0();
    }

    public boolean hasSendInputAck() {
        return ((m) this.instance).h0();
    }

    public boolean hasStartAgentAck() {
        return ((m) this.instance).i0();
    }

    public RequestAck$Builder mergeCancelAck(b bVar) {
        copyOnWrite();
        m.K((m) this.instance, bVar);
        return this;
    }

    public RequestAck$Builder mergeSendInputAck(n nVar) {
        copyOnWrite();
        m.L((m) this.instance, nVar);
        return this;
    }

    public RequestAck$Builder mergeStartAgentAck(p pVar) {
        copyOnWrite();
        m.M((m) this.instance, pVar);
        return this;
    }

    public RequestAck$Builder setCancelAck(b bVar) {
        copyOnWrite();
        m.N((m) this.instance, bVar);
        return this;
    }

    public RequestAck$Builder setErrorCode(int i) {
        copyOnWrite();
        m.O((m) this.instance, i);
        return this;
    }

    public RequestAck$Builder setErrorMessage(String str) {
        copyOnWrite();
        m.P((m) this.instance, str);
        return this;
    }

    public RequestAck$Builder setErrorMessageBytes(ByteString byteString) {
        copyOnWrite();
        m.Q((m) this.instance, byteString);
        return this;
    }

    public RequestAck$Builder setRequestId(long j5) {
        copyOnWrite();
        m.R((m) this.instance, j5);
        return this;
    }

    public RequestAck$Builder setSendInputAck(n nVar) {
        copyOnWrite();
        m.S((m) this.instance, nVar);
        return this;
    }

    public RequestAck$Builder setStartAgentAck(p pVar) {
        copyOnWrite();
        m.T((m) this.instance, pVar);
        return this;
    }

    private RequestAck$Builder() {
        super(m.DEFAULT_INSTANCE);
    }

    public RequestAck$Builder setCancelAck(CancelAck$Builder cancelAck$Builder) {
        copyOnWrite();
        m.N((m) this.instance, (b) cancelAck$Builder.k());
        return this;
    }

    public RequestAck$Builder setSendInputAck(SendInputAck$Builder sendInputAck$Builder) {
        copyOnWrite();
        m.S((m) this.instance, (n) sendInputAck$Builder.k());
        return this;
    }

    public RequestAck$Builder setStartAgentAck(StartAgentAck$Builder startAgentAck$Builder) {
        copyOnWrite();
        m.T((m) this.instance, (p) startAgentAck$Builder.k());
        return this;
    }
}
