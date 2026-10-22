package com.zyql.protobuf.common;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import java.util.Collections;
import java.util.Map;
import q7.C1804b;

/* loaded from: classes2.dex */
public final class AgentCompleteHookData$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ AgentCompleteHookData$Builder(int i) {
        this();
    }

    public AgentCompleteHookData$Builder clearAgentId() {
        copyOnWrite();
        C1804b.D((C1804b) this.instance);
        return this;
    }

    public AgentCompleteHookData$Builder clearAgentName() {
        copyOnWrite();
        C1804b.E((C1804b) this.instance);
        return this;
    }

    public AgentCompleteHookData$Builder clearDurationMs() {
        copyOnWrite();
        C1804b.F((C1804b) this.instance);
        return this;
    }

    public AgentCompleteHookData$Builder clearMetadata() {
        copyOnWrite();
        C1804b.K((C1804b) this.instance).clear();
        return this;
    }

    public AgentCompleteHookData$Builder clearOutputText() {
        copyOnWrite();
        C1804b.G((C1804b) this.instance);
        return this;
    }

    public AgentCompleteHookData$Builder clearRunId() {
        copyOnWrite();
        C1804b.H((C1804b) this.instance);
        return this;
    }

    public AgentCompleteHookData$Builder clearSessionId() {
        copyOnWrite();
        C1804b.I((C1804b) this.instance);
        return this;
    }

    public AgentCompleteHookData$Builder clearTurnsTaken() {
        copyOnWrite();
        C1804b.J((C1804b) this.instance);
        return this;
    }

    public boolean containsMetadata(String str) {
        str.getClass();
        return ((C1804b) this.instance).e0().containsKey(str);
    }

    public String getAgentId() {
        return ((C1804b) this.instance).Y();
    }

    public ByteString getAgentIdBytes() {
        return ((C1804b) this.instance).Z();
    }

    public String getAgentName() {
        return ((C1804b) this.instance).a0();
    }

    public ByteString getAgentNameBytes() {
        return ((C1804b) this.instance).b0();
    }

    public long getDurationMs() {
        return ((C1804b) this.instance).d0();
    }

    @Deprecated
    public Map<String, String> getMetadata() {
        return getMetadataMap();
    }

    public int getMetadataCount() {
        return ((C1804b) this.instance).e0().size();
    }

    public Map<String, String> getMetadataMap() {
        return Collections.unmodifiableMap(((C1804b) this.instance).e0());
    }

    public String getMetadataOrDefault(String str, String str2) {
        str.getClass();
        Map mapE0 = ((C1804b) this.instance).e0();
        return mapE0.containsKey(str) ? (String) mapE0.get(str) : str2;
    }

    public String getMetadataOrThrow(String str) {
        str.getClass();
        Map mapE0 = ((C1804b) this.instance).e0();
        if (mapE0.containsKey(str)) {
            return (String) mapE0.get(str);
        }
        throw new IllegalArgumentException();
    }

    public String getOutputText() {
        return ((C1804b) this.instance).f0();
    }

    public ByteString getOutputTextBytes() {
        return ((C1804b) this.instance).g0();
    }

    public String getRunId() {
        return ((C1804b) this.instance).h0();
    }

    public ByteString getRunIdBytes() {
        return ((C1804b) this.instance).i0();
    }

    public String getSessionId() {
        return ((C1804b) this.instance).j0();
    }

    public ByteString getSessionIdBytes() {
        return ((C1804b) this.instance).k0();
    }

    public int getTurnsTaken() {
        return ((C1804b) this.instance).l0();
    }

    public AgentCompleteHookData$Builder putAllMetadata(Map<String, String> map) {
        copyOnWrite();
        C1804b.K((C1804b) this.instance).putAll(map);
        return this;
    }

    public AgentCompleteHookData$Builder putMetadata(String str, String str2) {
        str.getClass();
        str2.getClass();
        copyOnWrite();
        C1804b.K((C1804b) this.instance).put(str, str2);
        return this;
    }

    public AgentCompleteHookData$Builder removeMetadata(String str) {
        str.getClass();
        copyOnWrite();
        C1804b.K((C1804b) this.instance).remove(str);
        return this;
    }

    public AgentCompleteHookData$Builder setAgentId(String str) {
        copyOnWrite();
        C1804b.L((C1804b) this.instance, str);
        return this;
    }

    public AgentCompleteHookData$Builder setAgentIdBytes(ByteString byteString) {
        copyOnWrite();
        C1804b.M((C1804b) this.instance, byteString);
        return this;
    }

    public AgentCompleteHookData$Builder setAgentName(String str) {
        copyOnWrite();
        C1804b.N((C1804b) this.instance, str);
        return this;
    }

    public AgentCompleteHookData$Builder setAgentNameBytes(ByteString byteString) {
        copyOnWrite();
        C1804b.O((C1804b) this.instance, byteString);
        return this;
    }

    public AgentCompleteHookData$Builder setDurationMs(long j5) {
        copyOnWrite();
        C1804b.P((C1804b) this.instance, j5);
        return this;
    }

    public AgentCompleteHookData$Builder setOutputText(String str) {
        copyOnWrite();
        C1804b.Q((C1804b) this.instance, str);
        return this;
    }

    public AgentCompleteHookData$Builder setOutputTextBytes(ByteString byteString) {
        copyOnWrite();
        C1804b.R((C1804b) this.instance, byteString);
        return this;
    }

    public AgentCompleteHookData$Builder setRunId(String str) {
        copyOnWrite();
        C1804b.S((C1804b) this.instance, str);
        return this;
    }

    public AgentCompleteHookData$Builder setRunIdBytes(ByteString byteString) {
        copyOnWrite();
        C1804b.T((C1804b) this.instance, byteString);
        return this;
    }

    public AgentCompleteHookData$Builder setSessionId(String str) {
        copyOnWrite();
        C1804b.U((C1804b) this.instance, str);
        return this;
    }

    public AgentCompleteHookData$Builder setSessionIdBytes(ByteString byteString) {
        copyOnWrite();
        C1804b.V((C1804b) this.instance, byteString);
        return this;
    }

    public AgentCompleteHookData$Builder setTurnsTaken(int i) {
        copyOnWrite();
        C1804b.W((C1804b) this.instance, i);
        return this;
    }

    private AgentCompleteHookData$Builder() {
        super(C1804b.DEFAULT_INSTANCE);
    }
}
