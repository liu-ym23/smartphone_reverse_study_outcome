package com.zyql.protobuf.runtime;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import u7.c;
import u7.d;
import u7.o;
import u7.q;

/* loaded from: classes2.dex */
public final class ChatRequest$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ ChatRequest$Builder(int i) {
        this();
    }

    public ChatRequest$Builder clearCancelRequest() {
        copyOnWrite();
        d.D((d) this.instance);
        return this;
    }

    public ChatRequest$Builder clearId() {
        copyOnWrite();
        d.E((d) this.instance);
        return this;
    }

    public ChatRequest$Builder clearPayload() {
        copyOnWrite();
        d.F((d) this.instance);
        return this;
    }

    public ChatRequest$Builder clearSendInputRequest() {
        copyOnWrite();
        d.G((d) this.instance);
        return this;
    }

    public ChatRequest$Builder clearStartAgentRequest() {
        copyOnWrite();
        d.H((d) this.instance);
        return this;
    }

    public c getCancelRequest() {
        return ((d) this.instance).Q();
    }

    public long getId() {
        return ((d) this.instance).R();
    }

    public ChatRequest$PayloadCase getPayloadCase() {
        return ((d) this.instance).S();
    }

    public o getSendInputRequest() {
        return ((d) this.instance).T();
    }

    public q getStartAgentRequest() {
        return ((d) this.instance).U();
    }

    public boolean hasCancelRequest() {
        return ((d) this.instance).V();
    }

    public boolean hasSendInputRequest() {
        return ((d) this.instance).W();
    }

    public boolean hasStartAgentRequest() {
        return ((d) this.instance).X();
    }

    public ChatRequest$Builder mergeCancelRequest(c cVar) {
        copyOnWrite();
        d.I((d) this.instance, cVar);
        return this;
    }

    public ChatRequest$Builder mergeSendInputRequest(o oVar) {
        copyOnWrite();
        d.J((d) this.instance, oVar);
        return this;
    }

    public ChatRequest$Builder mergeStartAgentRequest(q qVar) {
        copyOnWrite();
        d.K((d) this.instance, qVar);
        return this;
    }

    public ChatRequest$Builder setCancelRequest(c cVar) {
        copyOnWrite();
        d.L((d) this.instance, cVar);
        return this;
    }

    public ChatRequest$Builder setId(long j5) {
        copyOnWrite();
        d.M((d) this.instance, j5);
        return this;
    }

    public ChatRequest$Builder setSendInputRequest(o oVar) {
        copyOnWrite();
        d.N((d) this.instance, oVar);
        return this;
    }

    public ChatRequest$Builder setStartAgentRequest(q qVar) {
        copyOnWrite();
        d.O((d) this.instance, qVar);
        return this;
    }

    private ChatRequest$Builder() {
        super(d.DEFAULT_INSTANCE);
    }

    public ChatRequest$Builder setCancelRequest(CancelRequest$Builder cancelRequest$Builder) {
        copyOnWrite();
        d.L((d) this.instance, (c) cancelRequest$Builder.k());
        return this;
    }

    public ChatRequest$Builder setSendInputRequest(SendInputRequest$Builder sendInputRequest$Builder) {
        copyOnWrite();
        d.N((d) this.instance, (o) sendInputRequest$Builder.k());
        return this;
    }

    public ChatRequest$Builder setStartAgentRequest(StartAgentRequest$Builder startAgentRequest$Builder) {
        copyOnWrite();
        d.O((d) this.instance, (q) startAgentRequest$Builder.k());
        return this;
    }
}
