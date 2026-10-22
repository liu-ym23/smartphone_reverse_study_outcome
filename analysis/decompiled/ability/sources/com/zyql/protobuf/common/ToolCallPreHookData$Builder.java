package com.zyql.protobuf.common;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import java.util.Collections;
import java.util.Map;
import q7.e0;

/* loaded from: classes2.dex */
public final class ToolCallPreHookData$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ ToolCallPreHookData$Builder(int i) {
        this();
    }

    public ToolCallPreHookData$Builder clearAgentId() {
        copyOnWrite();
        e0.D((e0) this.instance);
        return this;
    }

    public ToolCallPreHookData$Builder clearArgumentsJson() {
        copyOnWrite();
        e0.E((e0) this.instance);
        return this;
    }

    public ToolCallPreHookData$Builder clearContext() {
        copyOnWrite();
        e0.I((e0) this.instance).clear();
        return this;
    }

    public ToolCallPreHookData$Builder clearSessionId() {
        copyOnWrite();
        e0.F((e0) this.instance);
        return this;
    }

    public ToolCallPreHookData$Builder clearToolCallId() {
        copyOnWrite();
        e0.G((e0) this.instance);
        return this;
    }

    public ToolCallPreHookData$Builder clearToolName() {
        copyOnWrite();
        e0.H((e0) this.instance);
        return this;
    }

    public boolean containsContext(String str) {
        str.getClass();
        return ((e0) this.instance).Y().containsKey(str);
    }

    public String getAgentId() {
        return ((e0) this.instance).U();
    }

    public ByteString getAgentIdBytes() {
        return ((e0) this.instance).V();
    }

    public String getArgumentsJson() {
        return ((e0) this.instance).W();
    }

    public ByteString getArgumentsJsonBytes() {
        return ((e0) this.instance).X();
    }

    @Deprecated
    public Map<String, String> getContext() {
        return getContextMap();
    }

    public int getContextCount() {
        return ((e0) this.instance).Y().size();
    }

    public Map<String, String> getContextMap() {
        return Collections.unmodifiableMap(((e0) this.instance).Y());
    }

    public String getContextOrDefault(String str, String str2) {
        str.getClass();
        Map mapY = ((e0) this.instance).Y();
        return mapY.containsKey(str) ? (String) mapY.get(str) : str2;
    }

    public String getContextOrThrow(String str) {
        str.getClass();
        Map mapY = ((e0) this.instance).Y();
        if (mapY.containsKey(str)) {
            return (String) mapY.get(str);
        }
        throw new IllegalArgumentException();
    }

    public String getSessionId() {
        return ((e0) this.instance).a0();
    }

    public ByteString getSessionIdBytes() {
        return ((e0) this.instance).b0();
    }

    public String getToolCallId() {
        return ((e0) this.instance).c0();
    }

    public ByteString getToolCallIdBytes() {
        return ((e0) this.instance).d0();
    }

    public String getToolName() {
        return ((e0) this.instance).e0();
    }

    public ByteString getToolNameBytes() {
        return ((e0) this.instance).f0();
    }

    public ToolCallPreHookData$Builder putAllContext(Map<String, String> map) {
        copyOnWrite();
        e0.I((e0) this.instance).putAll(map);
        return this;
    }

    public ToolCallPreHookData$Builder putContext(String str, String str2) {
        str.getClass();
        str2.getClass();
        copyOnWrite();
        e0.I((e0) this.instance).put(str, str2);
        return this;
    }

    public ToolCallPreHookData$Builder removeContext(String str) {
        str.getClass();
        copyOnWrite();
        e0.I((e0) this.instance).remove(str);
        return this;
    }

    public ToolCallPreHookData$Builder setAgentId(String str) {
        copyOnWrite();
        e0.J((e0) this.instance, str);
        return this;
    }

    public ToolCallPreHookData$Builder setAgentIdBytes(ByteString byteString) {
        copyOnWrite();
        e0.K((e0) this.instance, byteString);
        return this;
    }

    public ToolCallPreHookData$Builder setArgumentsJson(String str) {
        copyOnWrite();
        e0.L((e0) this.instance, str);
        return this;
    }

    public ToolCallPreHookData$Builder setArgumentsJsonBytes(ByteString byteString) {
        copyOnWrite();
        e0.M((e0) this.instance, byteString);
        return this;
    }

    public ToolCallPreHookData$Builder setSessionId(String str) {
        copyOnWrite();
        e0.N((e0) this.instance, str);
        return this;
    }

    public ToolCallPreHookData$Builder setSessionIdBytes(ByteString byteString) {
        copyOnWrite();
        e0.O((e0) this.instance, byteString);
        return this;
    }

    public ToolCallPreHookData$Builder setToolCallId(String str) {
        copyOnWrite();
        e0.P((e0) this.instance, str);
        return this;
    }

    public ToolCallPreHookData$Builder setToolCallIdBytes(ByteString byteString) {
        copyOnWrite();
        e0.Q((e0) this.instance, byteString);
        return this;
    }

    public ToolCallPreHookData$Builder setToolName(String str) {
        copyOnWrite();
        e0.R((e0) this.instance, str);
        return this;
    }

    public ToolCallPreHookData$Builder setToolNameBytes(ByteString byteString) {
        copyOnWrite();
        e0.S((e0) this.instance, byteString);
        return this;
    }

    private ToolCallPreHookData$Builder() {
        super(e0.DEFAULT_INSTANCE);
    }
}
