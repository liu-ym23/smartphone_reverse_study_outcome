package com.zyql.protobuf.runtime;

import com.google.protobuf.ByteString;
import com.google.protobuf.C1014y2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Struct;
import com.google.protobuf.Y1;
import java.util.Collections;
import java.util.List;
import u7.h;

/* loaded from: classes2.dex */
public final class GetAgentInfoResponse$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ GetAgentInfoResponse$Builder(int i) {
        this();
    }

    public GetAgentInfoResponse$Builder addAllCapabilities(Iterable<String> iterable) {
        copyOnWrite();
        h.D((h) this.instance, iterable);
        return this;
    }

    public GetAgentInfoResponse$Builder addCapabilities(String str) {
        copyOnWrite();
        h.E((h) this.instance, str);
        return this;
    }

    public GetAgentInfoResponse$Builder addCapabilitiesBytes(ByteString byteString) {
        copyOnWrite();
        h.F((h) this.instance, byteString);
        return this;
    }

    public GetAgentInfoResponse$Builder clearAgentId() {
        copyOnWrite();
        h.G((h) this.instance);
        return this;
    }

    public GetAgentInfoResponse$Builder clearAgentName() {
        copyOnWrite();
        h.H((h) this.instance);
        return this;
    }

    public GetAgentInfoResponse$Builder clearCapabilities() {
        copyOnWrite();
        h.I((h) this.instance);
        return this;
    }

    public GetAgentInfoResponse$Builder clearDescription() {
        copyOnWrite();
        h.J((h) this.instance);
        return this;
    }

    public GetAgentInfoResponse$Builder clearMetadata() {
        copyOnWrite();
        h.K((h) this.instance);
        return this;
    }

    public GetAgentInfoResponse$Builder clearVersion() {
        copyOnWrite();
        h.L((h) this.instance);
        return this;
    }

    public String getAgentId() {
        return ((h) this.instance).Y();
    }

    public ByteString getAgentIdBytes() {
        return ((h) this.instance).Z();
    }

    public String getAgentName() {
        return ((h) this.instance).a0();
    }

    public ByteString getAgentNameBytes() {
        return ((h) this.instance).b0();
    }

    public String getCapabilities(int i) {
        return ((h) this.instance).c0(i);
    }

    public ByteString getCapabilitiesBytes(int i) {
        return ((h) this.instance).d0(i);
    }

    public int getCapabilitiesCount() {
        return ((h) this.instance).e0();
    }

    public List<String> getCapabilitiesList() {
        return Collections.unmodifiableList(((h) this.instance).f0());
    }

    public String getDescription() {
        return ((h) this.instance).g0();
    }

    public ByteString getDescriptionBytes() {
        return ((h) this.instance).h0();
    }

    public Struct getMetadata() {
        return ((h) this.instance).i0();
    }

    public String getVersion() {
        return ((h) this.instance).j0();
    }

    public ByteString getVersionBytes() {
        return ((h) this.instance).k0();
    }

    public boolean hasDescription() {
        return ((h) this.instance).l0();
    }

    public boolean hasMetadata() {
        return ((h) this.instance).m0();
    }

    public boolean hasVersion() {
        return ((h) this.instance).n0();
    }

    public GetAgentInfoResponse$Builder mergeMetadata(Struct struct) {
        copyOnWrite();
        h hVar = (h) this.instance;
        int i = h.AGENT_ID_FIELD_NUMBER;
        hVar.o0(struct);
        return this;
    }

    public GetAgentInfoResponse$Builder setAgentId(String str) {
        copyOnWrite();
        h.M((h) this.instance, str);
        return this;
    }

    public GetAgentInfoResponse$Builder setAgentIdBytes(ByteString byteString) {
        copyOnWrite();
        h.N((h) this.instance, byteString);
        return this;
    }

    public GetAgentInfoResponse$Builder setAgentName(String str) {
        copyOnWrite();
        h.O((h) this.instance, str);
        return this;
    }

    public GetAgentInfoResponse$Builder setAgentNameBytes(ByteString byteString) {
        copyOnWrite();
        h.P((h) this.instance, byteString);
        return this;
    }

    public GetAgentInfoResponse$Builder setCapabilities(int i, String str) {
        copyOnWrite();
        h.Q((h) this.instance, i, str);
        return this;
    }

    public GetAgentInfoResponse$Builder setDescription(String str) {
        copyOnWrite();
        h.R((h) this.instance, str);
        return this;
    }

    public GetAgentInfoResponse$Builder setDescriptionBytes(ByteString byteString) {
        copyOnWrite();
        h.S((h) this.instance, byteString);
        return this;
    }

    public GetAgentInfoResponse$Builder setMetadata(Struct struct) {
        copyOnWrite();
        h.T((h) this.instance, struct);
        return this;
    }

    public GetAgentInfoResponse$Builder setVersion(String str) {
        copyOnWrite();
        h.U((h) this.instance, str);
        return this;
    }

    public GetAgentInfoResponse$Builder setVersionBytes(ByteString byteString) {
        copyOnWrite();
        h.V((h) this.instance, byteString);
        return this;
    }

    private GetAgentInfoResponse$Builder() {
        super(h.DEFAULT_INSTANCE);
    }

    public GetAgentInfoResponse$Builder setMetadata(C1014y2 c1014y2) {
        copyOnWrite();
        h.T((h) this.instance, (Struct) c1014y2.k());
        return this;
    }
}
