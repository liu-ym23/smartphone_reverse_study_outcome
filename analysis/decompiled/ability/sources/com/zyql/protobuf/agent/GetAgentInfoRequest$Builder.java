package com.zyql.protobuf.agent;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import o7.l;

/* loaded from: classes2.dex */
public final class GetAgentInfoRequest$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ GetAgentInfoRequest$Builder(int i) {
        this();
    }

    public GetAgentInfoRequest$Builder clearAgentId() {
        copyOnWrite();
        l.D((l) this.instance);
        return this;
    }

    public String getAgentId() {
        return ((l) this.instance).H();
    }

    public ByteString getAgentIdBytes() {
        return ((l) this.instance).I();
    }

    public GetAgentInfoRequest$Builder setAgentId(String str) {
        copyOnWrite();
        l.E((l) this.instance, str);
        return this;
    }

    public GetAgentInfoRequest$Builder setAgentIdBytes(ByteString byteString) {
        copyOnWrite();
        l.F((l) this.instance, byteString);
        return this;
    }

    private GetAgentInfoRequest$Builder() {
        super(l.DEFAULT_INSTANCE);
    }
}
