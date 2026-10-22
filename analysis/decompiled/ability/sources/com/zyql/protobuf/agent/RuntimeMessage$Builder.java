package com.zyql.protobuf.agent;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import o7.C1773i;
import o7.C1774j;
import o7.l;
import o7.o;
import o7.s;
import o7.w;

/* loaded from: classes2.dex */
public final class RuntimeMessage$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ RuntimeMessage$Builder(int i) {
        this();
    }

    public RuntimeMessage$Builder clearError() {
        copyOnWrite();
        w.D((w) this.instance);
        return this;
    }

    public RuntimeMessage$Builder clearExecuteToolTask() {
        copyOnWrite();
        w.E((w) this.instance);
        return this;
    }

    public RuntimeMessage$Builder clearGetAgentInfoRequest() {
        copyOnWrite();
        w.F((w) this.instance);
        return this;
    }

    public RuntimeMessage$Builder clearGetStoreResponse() {
        copyOnWrite();
        w.G((w) this.instance);
        return this;
    }

    public RuntimeMessage$Builder clearId() {
        copyOnWrite();
        w.H((w) this.instance);
        return this;
    }

    public RuntimeMessage$Builder clearInvokeHookTask() {
        copyOnWrite();
        w.I((w) this.instance);
        return this;
    }

    public RuntimeMessage$Builder clearRequest() {
        copyOnWrite();
        w.J((w) this.instance);
        return this;
    }

    public RuntimeMessage$Builder clearResponse() {
        copyOnWrite();
        w.K((w) this.instance);
        return this;
    }

    public RuntimeMessage$Builder clearTimestamp() {
        copyOnWrite();
        w.L((w) this.instance);
        return this;
    }

    public C1773i getError() {
        return ((w) this.instance).a0();
    }

    public C1774j getExecuteToolTask() {
        return ((w) this.instance).b0();
    }

    public l getGetAgentInfoRequest() {
        return ((w) this.instance).c0();
    }

    public o getGetStoreResponse() {
        return ((w) this.instance).d0();
    }

    public String getId() {
        return ((w) this.instance).e0();
    }

    public ByteString getIdBytes() {
        return ((w) this.instance).f0();
    }

    public s getInvokeHookTask() {
        return ((w) this.instance).g0();
    }

    public RuntimeMessage$RequestCase getRequestCase() {
        return ((w) this.instance).h0();
    }

    public RuntimeMessage$ResponseCase getResponseCase() {
        return ((w) this.instance).i0();
    }

    public long getTimestamp() {
        return ((w) this.instance).j0();
    }

    public boolean hasError() {
        return ((w) this.instance).k0();
    }

    public boolean hasExecuteToolTask() {
        return ((w) this.instance).l0();
    }

    public boolean hasGetAgentInfoRequest() {
        return ((w) this.instance).m0();
    }

    public boolean hasGetStoreResponse() {
        return ((w) this.instance).n0();
    }

    public boolean hasInvokeHookTask() {
        return ((w) this.instance).o0();
    }

    public RuntimeMessage$Builder mergeError(C1773i c1773i) {
        copyOnWrite();
        w.M((w) this.instance, c1773i);
        return this;
    }

    public RuntimeMessage$Builder mergeExecuteToolTask(C1774j c1774j) {
        copyOnWrite();
        w.N((w) this.instance, c1774j);
        return this;
    }

    public RuntimeMessage$Builder mergeGetAgentInfoRequest(l lVar) {
        copyOnWrite();
        w.O((w) this.instance, lVar);
        return this;
    }

    public RuntimeMessage$Builder mergeGetStoreResponse(o oVar) {
        copyOnWrite();
        w.P((w) this.instance, oVar);
        return this;
    }

    public RuntimeMessage$Builder mergeInvokeHookTask(s sVar) {
        copyOnWrite();
        w.Q((w) this.instance, sVar);
        return this;
    }

    public RuntimeMessage$Builder setError(C1773i c1773i) {
        copyOnWrite();
        w.R((w) this.instance, c1773i);
        return this;
    }

    public RuntimeMessage$Builder setExecuteToolTask(C1774j c1774j) {
        copyOnWrite();
        w.S((w) this.instance, c1774j);
        return this;
    }

    public RuntimeMessage$Builder setGetAgentInfoRequest(l lVar) {
        copyOnWrite();
        w.T((w) this.instance, lVar);
        return this;
    }

    public RuntimeMessage$Builder setGetStoreResponse(o oVar) {
        copyOnWrite();
        w.U((w) this.instance, oVar);
        return this;
    }

    public RuntimeMessage$Builder setId(String str) {
        copyOnWrite();
        w.V((w) this.instance, str);
        return this;
    }

    public RuntimeMessage$Builder setIdBytes(ByteString byteString) {
        copyOnWrite();
        w.W((w) this.instance, byteString);
        return this;
    }

    public RuntimeMessage$Builder setInvokeHookTask(s sVar) {
        copyOnWrite();
        w.X((w) this.instance, sVar);
        return this;
    }

    public RuntimeMessage$Builder setTimestamp(long j5) {
        copyOnWrite();
        w.Y((w) this.instance, j5);
        return this;
    }

    private RuntimeMessage$Builder() {
        super(w.DEFAULT_INSTANCE);
    }

    public RuntimeMessage$Builder setError(Error$Builder error$Builder) {
        copyOnWrite();
        w.R((w) this.instance, (C1773i) error$Builder.k());
        return this;
    }

    public RuntimeMessage$Builder setExecuteToolTask(ExecuteToolTask$Builder executeToolTask$Builder) {
        copyOnWrite();
        w.S((w) this.instance, (C1774j) executeToolTask$Builder.k());
        return this;
    }

    public RuntimeMessage$Builder setGetAgentInfoRequest(GetAgentInfoRequest$Builder getAgentInfoRequest$Builder) {
        copyOnWrite();
        w.T((w) this.instance, (l) getAgentInfoRequest$Builder.k());
        return this;
    }

    public RuntimeMessage$Builder setGetStoreResponse(GetStoreResponse$Builder getStoreResponse$Builder) {
        copyOnWrite();
        w.U((w) this.instance, (o) getStoreResponse$Builder.k());
        return this;
    }

    public RuntimeMessage$Builder setInvokeHookTask(InvokeHookTask$Builder invokeHookTask$Builder) {
        copyOnWrite();
        w.X((w) this.instance, (s) invokeHookTask$Builder.k());
        return this;
    }
}
