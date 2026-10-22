package l4;

import com.google.protobuf.f2;
import com.google.protobuf.l;
import com.stepos.agentbus.agents.bff.proto.HeadOrBuilder;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes.dex */
public final class e extends f2 implements HeadOrBuilder {
    @Override // com.stepos.agentbus.agents.bff.proto.HeadOrBuilder
    public final boolean containsMeta(String str) {
        str.getClass();
        return ((g) this.f2351g).getMetaMap().containsKey(str);
    }

    @Override // com.stepos.agentbus.agents.bff.proto.HeadOrBuilder
    public final String getCommand() {
        return ((g) this.f2351g).getCommand();
    }

    @Override // com.stepos.agentbus.agents.bff.proto.HeadOrBuilder
    public final l getCommandBytes() {
        return ((g) this.f2351g).getCommandBytes();
    }

    @Override // com.stepos.agentbus.agents.bff.proto.HeadOrBuilder
    public final int getFrameType() {
        return ((g) this.f2351g).getFrameType();
    }

    @Override // com.stepos.agentbus.agents.bff.proto.HeadOrBuilder
    public final Map getMeta() {
        return getMetaMap();
    }

    @Override // com.stepos.agentbus.agents.bff.proto.HeadOrBuilder
    public final int getMetaCount() {
        return ((g) this.f2351g).getMetaMap().size();
    }

    @Override // com.stepos.agentbus.agents.bff.proto.HeadOrBuilder
    public final Map getMetaMap() {
        return Collections.unmodifiableMap(((g) this.f2351g).getMetaMap());
    }

    @Override // com.stepos.agentbus.agents.bff.proto.HeadOrBuilder
    public final String getMetaOrDefault(String str, String str2) {
        str.getClass();
        Map metaMap = ((g) this.f2351g).getMetaMap();
        return metaMap.containsKey(str) ? (String) metaMap.get(str) : str2;
    }

    @Override // com.stepos.agentbus.agents.bff.proto.HeadOrBuilder
    public final String getMetaOrThrow(String str) {
        str.getClass();
        Map metaMap = ((g) this.f2351g).getMetaMap();
        if (metaMap.containsKey(str)) {
            return (String) metaMap.get(str);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.stepos.agentbus.agents.bff.proto.HeadOrBuilder
    public final String getModule() {
        return ((g) this.f2351g).getModule();
    }

    @Override // com.stepos.agentbus.agents.bff.proto.HeadOrBuilder
    public final l getModuleBytes() {
        return ((g) this.f2351g).getModuleBytes();
    }

    @Override // com.stepos.agentbus.agents.bff.proto.HeadOrBuilder
    public final String getMsgId() {
        return ((g) this.f2351g).getMsgId();
    }

    @Override // com.stepos.agentbus.agents.bff.proto.HeadOrBuilder
    public final l getMsgIdBytes() {
        return ((g) this.f2351g).getMsgIdBytes();
    }

    @Override // com.stepos.agentbus.agents.bff.proto.HeadOrBuilder
    public final int getMsgType() {
        return ((g) this.f2351g).getMsgType();
    }
}
