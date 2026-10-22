package com.zyql.protobuf.agent;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import o7.C1765a;
import o7.m;

/* loaded from: classes2.dex */
public final class GetAgentInfoResponse$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ GetAgentInfoResponse$Builder(int i) {
        this();
    }

    public GetAgentInfoResponse$Builder clearAgentInfo() {
        copyOnWrite();
        m.D((m) this.instance);
        return this;
    }

    public GetAgentInfoResponse$Builder clearError() {
        copyOnWrite();
        m.E((m) this.instance);
        return this;
    }

    public GetAgentInfoResponse$Builder clearSuccess() {
        copyOnWrite();
        m.F((m) this.instance);
        return this;
    }

    public C1765a getAgentInfo() {
        return ((m) this.instance).M();
    }

    public String getError() {
        return ((m) this.instance).O();
    }

    public ByteString getErrorBytes() {
        return ((m) this.instance).P();
    }

    public boolean getSuccess() {
        return ((m) this.instance).Q();
    }

    public boolean hasAgentInfo() {
        return ((m) this.instance).R();
    }

    public GetAgentInfoResponse$Builder mergeAgentInfo(C1765a c1765a) {
        copyOnWrite();
        m.G((m) this.instance, c1765a);
        return this;
    }

    public GetAgentInfoResponse$Builder setAgentInfo(C1765a c1765a) {
        copyOnWrite();
        m.H((m) this.instance, c1765a);
        return this;
    }

    public GetAgentInfoResponse$Builder setError(String str) {
        copyOnWrite();
        m.I((m) this.instance, str);
        return this;
    }

    public GetAgentInfoResponse$Builder setErrorBytes(ByteString byteString) {
        copyOnWrite();
        m.J((m) this.instance, byteString);
        return this;
    }

    public GetAgentInfoResponse$Builder setSuccess(boolean z10) {
        copyOnWrite();
        m.K((m) this.instance, z10);
        return this;
    }

    private GetAgentInfoResponse$Builder() {
        super(m.DEFAULT_INSTANCE);
    }

    public GetAgentInfoResponse$Builder setAgentInfo(AgentInfo$Builder agentInfo$Builder) {
        copyOnWrite();
        m.H((m) this.instance, (C1765a) agentInfo$Builder.k());
        return this;
    }
}
