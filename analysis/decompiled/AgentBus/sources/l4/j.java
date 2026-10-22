package l4;

import com.google.protobuf.f2;
import com.google.protobuf.l;
import com.stepos.agentbus.agents.bff.proto.StreamMsgOrBuilder;

/* loaded from: classes.dex */
public final class j extends f2 implements StreamMsgOrBuilder {
    @Override // com.stepos.agentbus.agents.bff.proto.StreamMsgOrBuilder
    public final l getBody() {
        return ((k) this.f2351g).getBody();
    }

    @Override // com.stepos.agentbus.agents.bff.proto.StreamMsgOrBuilder
    public final g getHead() {
        return ((k) this.f2351g).getHead();
    }

    @Override // com.stepos.agentbus.agents.bff.proto.StreamMsgOrBuilder
    public final boolean hasHead() {
        return ((k) this.f2351g).hasHead();
    }
}
