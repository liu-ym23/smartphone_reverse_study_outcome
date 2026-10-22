package com.zyql.protobuf.agent;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import o7.C1763B;
import o7.C1766b;
import o7.C1773i;
import o7.m;
import o7.n;
import o7.q;

/* loaded from: classes2.dex */
public final class AgentMessage$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ AgentMessage$Builder(int i) {
        this();
    }

    public AgentMessage$Builder clearError() {
        copyOnWrite();
        C1766b.D((C1766b) this.instance);
        return this;
    }

    public AgentMessage$Builder clearGetAgentInfoResponse() {
        copyOnWrite();
        C1766b.E((C1766b) this.instance);
        return this;
    }

    public AgentMessage$Builder clearGetStoreRequest() {
        copyOnWrite();
        C1766b.F((C1766b) this.instance);
        return this;
    }

    public AgentMessage$Builder clearHookExecutionResult() {
        copyOnWrite();
        C1766b.G((C1766b) this.instance);
        return this;
    }

    public AgentMessage$Builder clearId() {
        copyOnWrite();
        C1766b.H((C1766b) this.instance);
        return this;
    }

    public AgentMessage$Builder clearRequest() {
        copyOnWrite();
        C1766b.I((C1766b) this.instance);
        return this;
    }

    public AgentMessage$Builder clearResponse() {
        copyOnWrite();
        C1766b.J((C1766b) this.instance);
        return this;
    }

    public AgentMessage$Builder clearTimestamp() {
        copyOnWrite();
        C1766b.K((C1766b) this.instance);
        return this;
    }

    public AgentMessage$Builder clearToolExecutionResult() {
        copyOnWrite();
        C1766b.L((C1766b) this.instance);
        return this;
    }

    public C1773i getError() {
        return ((C1766b) this.instance).a0();
    }

    public m getGetAgentInfoResponse() {
        return ((C1766b) this.instance).b0();
    }

    public n getGetStoreRequest() {
        return ((C1766b) this.instance).c0();
    }

    public q getHookExecutionResult() {
        return ((C1766b) this.instance).d0();
    }

    public String getId() {
        return ((C1766b) this.instance).e0();
    }

    public ByteString getIdBytes() {
        return ((C1766b) this.instance).f0();
    }

    public AgentMessage$RequestCase getRequestCase() {
        return ((C1766b) this.instance).g0();
    }

    public AgentMessage$ResponseCase getResponseCase() {
        return ((C1766b) this.instance).h0();
    }

    public long getTimestamp() {
        return ((C1766b) this.instance).i0();
    }

    public C1763B getToolExecutionResult() {
        return ((C1766b) this.instance).j0();
    }

    public boolean hasError() {
        return ((C1766b) this.instance).k0();
    }

    public boolean hasGetAgentInfoResponse() {
        return ((C1766b) this.instance).l0();
    }

    public boolean hasGetStoreRequest() {
        return ((C1766b) this.instance).m0();
    }

    public boolean hasHookExecutionResult() {
        return ((C1766b) this.instance).n0();
    }

    public boolean hasToolExecutionResult() {
        return ((C1766b) this.instance).o0();
    }

    public AgentMessage$Builder mergeError(C1773i c1773i) {
        copyOnWrite();
        C1766b.M((C1766b) this.instance, c1773i);
        return this;
    }

    public AgentMessage$Builder mergeGetAgentInfoResponse(m mVar) {
        copyOnWrite();
        C1766b.N((C1766b) this.instance, mVar);
        return this;
    }

    public AgentMessage$Builder mergeGetStoreRequest(n nVar) {
        copyOnWrite();
        C1766b.O((C1766b) this.instance, nVar);
        return this;
    }

    public AgentMessage$Builder mergeHookExecutionResult(q qVar) {
        copyOnWrite();
        C1766b.P((C1766b) this.instance, qVar);
        return this;
    }

    public AgentMessage$Builder mergeToolExecutionResult(C1763B c1763b) {
        copyOnWrite();
        C1766b.Q((C1766b) this.instance, c1763b);
        return this;
    }

    public AgentMessage$Builder setError(C1773i c1773i) {
        copyOnWrite();
        C1766b.R((C1766b) this.instance, c1773i);
        return this;
    }

    public AgentMessage$Builder setGetAgentInfoResponse(m mVar) {
        copyOnWrite();
        C1766b.S((C1766b) this.instance, mVar);
        return this;
    }

    public AgentMessage$Builder setGetStoreRequest(n nVar) {
        copyOnWrite();
        C1766b.T((C1766b) this.instance, nVar);
        return this;
    }

    public AgentMessage$Builder setHookExecutionResult(q qVar) {
        copyOnWrite();
        C1766b.U((C1766b) this.instance, qVar);
        return this;
    }

    public AgentMessage$Builder setId(String str) {
        copyOnWrite();
        C1766b.V((C1766b) this.instance, str);
        return this;
    }

    public AgentMessage$Builder setIdBytes(ByteString byteString) {
        copyOnWrite();
        C1766b.W((C1766b) this.instance, byteString);
        return this;
    }

    public AgentMessage$Builder setTimestamp(long j5) {
        copyOnWrite();
        C1766b.X((C1766b) this.instance, j5);
        return this;
    }

    public AgentMessage$Builder setToolExecutionResult(C1763B c1763b) {
        copyOnWrite();
        C1766b.Y((C1766b) this.instance, c1763b);
        return this;
    }

    private AgentMessage$Builder() {
        super(C1766b.DEFAULT_INSTANCE);
    }

    public AgentMessage$Builder setError(Error$Builder error$Builder) {
        copyOnWrite();
        C1766b.R((C1766b) this.instance, (C1773i) error$Builder.k());
        return this;
    }

    public AgentMessage$Builder setGetAgentInfoResponse(GetAgentInfoResponse$Builder getAgentInfoResponse$Builder) {
        copyOnWrite();
        C1766b.S((C1766b) this.instance, (m) getAgentInfoResponse$Builder.k());
        return this;
    }

    public AgentMessage$Builder setGetStoreRequest(GetStoreRequest$Builder getStoreRequest$Builder) {
        copyOnWrite();
        C1766b.T((C1766b) this.instance, (n) getStoreRequest$Builder.k());
        return this;
    }

    public AgentMessage$Builder setHookExecutionResult(HookExecutionResult$Builder hookExecutionResult$Builder) {
        copyOnWrite();
        C1766b.U((C1766b) this.instance, (q) hookExecutionResult$Builder.k());
        return this;
    }

    public AgentMessage$Builder setToolExecutionResult(ToolExecutionResult$Builder toolExecutionResult$Builder) {
        copyOnWrite();
        C1766b.Y((C1766b) this.instance, (C1763B) toolExecutionResult$Builder.k());
        return this;
    }
}
