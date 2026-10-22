package com.zyql.protobuf.common;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import java.util.Collections;
import java.util.Map;
import q7.C1806d;

/* loaded from: classes2.dex */
public final class AgentStartHookData$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ AgentStartHookData$Builder(int i) {
        this();
    }

    public AgentStartHookData$Builder clearAgentId() {
        copyOnWrite();
        C1806d.D((C1806d) this.instance);
        return this;
    }

    public AgentStartHookData$Builder clearAgentName() {
        copyOnWrite();
        C1806d.E((C1806d) this.instance);
        return this;
    }

    public AgentStartHookData$Builder clearContext() {
        copyOnWrite();
        C1806d.I((C1806d) this.instance).clear();
        return this;
    }

    public AgentStartHookData$Builder clearInputText() {
        copyOnWrite();
        C1806d.F((C1806d) this.instance);
        return this;
    }

    public AgentStartHookData$Builder clearRunId() {
        copyOnWrite();
        C1806d.G((C1806d) this.instance);
        return this;
    }

    public AgentStartHookData$Builder clearSessionId() {
        copyOnWrite();
        C1806d.H((C1806d) this.instance);
        return this;
    }

    public boolean containsContext(String str) {
        str.getClass();
        return ((C1806d) this.instance).Y().containsKey(str);
    }

    public String getAgentId() {
        return ((C1806d) this.instance).U();
    }

    public ByteString getAgentIdBytes() {
        return ((C1806d) this.instance).V();
    }

    public String getAgentName() {
        return ((C1806d) this.instance).W();
    }

    public ByteString getAgentNameBytes() {
        return ((C1806d) this.instance).X();
    }

    @Deprecated
    public Map<String, String> getContext() {
        return getContextMap();
    }

    public int getContextCount() {
        return ((C1806d) this.instance).Y().size();
    }

    public Map<String, String> getContextMap() {
        return Collections.unmodifiableMap(((C1806d) this.instance).Y());
    }

    public String getContextOrDefault(String str, String str2) {
        str.getClass();
        Map mapY = ((C1806d) this.instance).Y();
        return mapY.containsKey(str) ? (String) mapY.get(str) : str2;
    }

    public String getContextOrThrow(String str) {
        str.getClass();
        Map mapY = ((C1806d) this.instance).Y();
        if (mapY.containsKey(str)) {
            return (String) mapY.get(str);
        }
        throw new IllegalArgumentException();
    }

    public String getInputText() {
        return ((C1806d) this.instance).a0();
    }

    public ByteString getInputTextBytes() {
        return ((C1806d) this.instance).b0();
    }

    public String getRunId() {
        return ((C1806d) this.instance).c0();
    }

    public ByteString getRunIdBytes() {
        return ((C1806d) this.instance).d0();
    }

    public String getSessionId() {
        return ((C1806d) this.instance).e0();
    }

    public ByteString getSessionIdBytes() {
        return ((C1806d) this.instance).f0();
    }

    public AgentStartHookData$Builder putAllContext(Map<String, String> map) {
        copyOnWrite();
        C1806d.I((C1806d) this.instance).putAll(map);
        return this;
    }

    public AgentStartHookData$Builder putContext(String str, String str2) {
        str.getClass();
        str2.getClass();
        copyOnWrite();
        C1806d.I((C1806d) this.instance).put(str, str2);
        return this;
    }

    public AgentStartHookData$Builder removeContext(String str) {
        str.getClass();
        copyOnWrite();
        C1806d.I((C1806d) this.instance).remove(str);
        return this;
    }

    public AgentStartHookData$Builder setAgentId(String str) {
        copyOnWrite();
        C1806d.J((C1806d) this.instance, str);
        return this;
    }

    public AgentStartHookData$Builder setAgentIdBytes(ByteString byteString) {
        copyOnWrite();
        C1806d.K((C1806d) this.instance, byteString);
        return this;
    }

    public AgentStartHookData$Builder setAgentName(String str) {
        copyOnWrite();
        C1806d.L((C1806d) this.instance, str);
        return this;
    }

    public AgentStartHookData$Builder setAgentNameBytes(ByteString byteString) {
        copyOnWrite();
        C1806d.M((C1806d) this.instance, byteString);
        return this;
    }

    public AgentStartHookData$Builder setInputText(String str) {
        copyOnWrite();
        C1806d.N((C1806d) this.instance, str);
        return this;
    }

    public AgentStartHookData$Builder setInputTextBytes(ByteString byteString) {
        copyOnWrite();
        C1806d.O((C1806d) this.instance, byteString);
        return this;
    }

    public AgentStartHookData$Builder setRunId(String str) {
        copyOnWrite();
        C1806d.P((C1806d) this.instance, str);
        return this;
    }

    public AgentStartHookData$Builder setRunIdBytes(ByteString byteString) {
        copyOnWrite();
        C1806d.Q((C1806d) this.instance, byteString);
        return this;
    }

    public AgentStartHookData$Builder setSessionId(String str) {
        copyOnWrite();
        C1806d.R((C1806d) this.instance, str);
        return this;
    }

    public AgentStartHookData$Builder setSessionIdBytes(ByteString byteString) {
        copyOnWrite();
        C1806d.S((C1806d) this.instance, byteString);
        return this;
    }

    private AgentStartHookData$Builder() {
        super(C1806d.DEFAULT_INSTANCE);
    }
}
