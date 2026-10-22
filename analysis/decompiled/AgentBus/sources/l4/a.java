package l4;

import com.google.protobuf.f2;
import com.google.protobuf.l;
import com.stepos.agentbus.agents.bff.proto.AuthBindReqOrBuilder;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes.dex */
public final class a extends f2 implements AuthBindReqOrBuilder {
    @Override // com.stepos.agentbus.agents.bff.proto.AuthBindReqOrBuilder
    public final boolean containsReserved(String str) {
        str.getClass();
        return ((c) this.f2351g).getReservedMap().containsKey(str);
    }

    @Override // com.stepos.agentbus.agents.bff.proto.AuthBindReqOrBuilder
    public final String getAppVersion() {
        return ((c) this.f2351g).getAppVersion();
    }

    @Override // com.stepos.agentbus.agents.bff.proto.AuthBindReqOrBuilder
    public final l getAppVersionBytes() {
        return ((c) this.f2351g).getAppVersionBytes();
    }

    @Override // com.stepos.agentbus.agents.bff.proto.AuthBindReqOrBuilder
    public final String getChannel() {
        return ((c) this.f2351g).getChannel();
    }

    @Override // com.stepos.agentbus.agents.bff.proto.AuthBindReqOrBuilder
    public final l getChannelBytes() {
        return ((c) this.f2351g).getChannelBytes();
    }

    @Override // com.stepos.agentbus.agents.bff.proto.AuthBindReqOrBuilder
    public final String getDevice() {
        return ((c) this.f2351g).getDevice();
    }

    @Override // com.stepos.agentbus.agents.bff.proto.AuthBindReqOrBuilder
    public final l getDeviceBytes() {
        return ((c) this.f2351g).getDeviceBytes();
    }

    @Override // com.stepos.agentbus.agents.bff.proto.AuthBindReqOrBuilder
    public final String getDid() {
        return ((c) this.f2351g).getDid();
    }

    @Override // com.stepos.agentbus.agents.bff.proto.AuthBindReqOrBuilder
    public final l getDidBytes() {
        return ((c) this.f2351g).getDidBytes();
    }

    @Override // com.stepos.agentbus.agents.bff.proto.AuthBindReqOrBuilder
    public final int getPlatform() {
        return ((c) this.f2351g).getPlatform();
    }

    @Override // com.stepos.agentbus.agents.bff.proto.AuthBindReqOrBuilder
    public final String getProduct() {
        return ((c) this.f2351g).getProduct();
    }

    @Override // com.stepos.agentbus.agents.bff.proto.AuthBindReqOrBuilder
    public final l getProductBytes() {
        return ((c) this.f2351g).getProductBytes();
    }

    @Override // com.stepos.agentbus.agents.bff.proto.AuthBindReqOrBuilder
    public final Map getReserved() {
        return getReservedMap();
    }

    @Override // com.stepos.agentbus.agents.bff.proto.AuthBindReqOrBuilder
    public final int getReservedCount() {
        return ((c) this.f2351g).getReservedMap().size();
    }

    @Override // com.stepos.agentbus.agents.bff.proto.AuthBindReqOrBuilder
    public final Map getReservedMap() {
        return Collections.unmodifiableMap(((c) this.f2351g).getReservedMap());
    }

    @Override // com.stepos.agentbus.agents.bff.proto.AuthBindReqOrBuilder
    public final String getReservedOrDefault(String str, String str2) {
        str.getClass();
        Map reservedMap = ((c) this.f2351g).getReservedMap();
        return reservedMap.containsKey(str) ? (String) reservedMap.get(str) : str2;
    }

    @Override // com.stepos.agentbus.agents.bff.proto.AuthBindReqOrBuilder
    public final String getReservedOrThrow(String str) {
        str.getClass();
        Map reservedMap = ((c) this.f2351g).getReservedMap();
        if (reservedMap.containsKey(str)) {
            return (String) reservedMap.get(str);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.stepos.agentbus.agents.bff.proto.AuthBindReqOrBuilder
    public final String getToken() {
        return ((c) this.f2351g).getToken();
    }

    @Override // com.stepos.agentbus.agents.bff.proto.AuthBindReqOrBuilder
    public final l getTokenBytes() {
        return ((c) this.f2351g).getTokenBytes();
    }

    @Override // com.stepos.agentbus.agents.bff.proto.AuthBindReqOrBuilder
    public final String getTokenType() {
        return ((c) this.f2351g).getTokenType();
    }

    @Override // com.stepos.agentbus.agents.bff.proto.AuthBindReqOrBuilder
    public final l getTokenTypeBytes() {
        return ((c) this.f2351g).getTokenTypeBytes();
    }

    @Override // com.stepos.agentbus.agents.bff.proto.AuthBindReqOrBuilder
    public final String getUid() {
        return ((c) this.f2351g).getUid();
    }

    @Override // com.stepos.agentbus.agents.bff.proto.AuthBindReqOrBuilder
    public final l getUidBytes() {
        return ((c) this.f2351g).getUidBytes();
    }
}
