package com.zyql.protobuf.runtime;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import u7.g;

/* loaded from: classes2.dex */
public final class GetAgentInfoRequest$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ GetAgentInfoRequest$Builder(int i) {
        this();
    }

    public GetAgentInfoRequest$Builder clearAgentId() {
        copyOnWrite();
        g.D((g) this.instance);
        return this;
    }

    public String getAgentId() {
        return ((g) this.instance).H();
    }

    public ByteString getAgentIdBytes() {
        return ((g) this.instance).I();
    }

    public GetAgentInfoRequest$Builder setAgentId(String str) {
        copyOnWrite();
        g.E((g) this.instance, str);
        return this;
    }

    public GetAgentInfoRequest$Builder setAgentIdBytes(ByteString byteString) {
        copyOnWrite();
        g.F((g) this.instance, byteString);
        return this;
    }

    private GetAgentInfoRequest$Builder() {
        super(g.DEFAULT_INSTANCE);
    }
}
