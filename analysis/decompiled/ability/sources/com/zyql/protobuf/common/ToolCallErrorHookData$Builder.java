package com.zyql.protobuf.common;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import java.util.Collections;
import java.util.Map;
import q7.a0;

/* loaded from: classes2.dex */
public final class ToolCallErrorHookData$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ ToolCallErrorHookData$Builder(int i) {
        this();
    }

    public ToolCallErrorHookData$Builder clearAgentId() {
        copyOnWrite();
        a0.D((a0) this.instance);
        return this;
    }

    public ToolCallErrorHookData$Builder clearArgumentsJson() {
        copyOnWrite();
        a0.E((a0) this.instance);
        return this;
    }

    public ToolCallErrorHookData$Builder clearContext() {
        copyOnWrite();
        a0.L((a0) this.instance).clear();
        return this;
    }

    public ToolCallErrorHookData$Builder clearDurationMs() {
        copyOnWrite();
        a0.F((a0) this.instance);
        return this;
    }

    public ToolCallErrorHookData$Builder clearError() {
        copyOnWrite();
        a0.G((a0) this.instance);
        return this;
    }

    public ToolCallErrorHookData$Builder clearErrorCode() {
        copyOnWrite();
        a0.H((a0) this.instance);
        return this;
    }

    public ToolCallErrorHookData$Builder clearSessionId() {
        copyOnWrite();
        a0.I((a0) this.instance);
        return this;
    }

    public ToolCallErrorHookData$Builder clearToolCallId() {
        copyOnWrite();
        a0.J((a0) this.instance);
        return this;
    }

    public ToolCallErrorHookData$Builder clearToolName() {
        copyOnWrite();
        a0.K((a0) this.instance);
        return this;
    }

    public boolean containsContext(String str) {
        str.getClass();
        return ((a0) this.instance).g0().containsKey(str);
    }

    public String getAgentId() {
        return ((a0) this.instance).c0();
    }

    public ByteString getAgentIdBytes() {
        return ((a0) this.instance).d0();
    }

    public String getArgumentsJson() {
        return ((a0) this.instance).e0();
    }

    public ByteString getArgumentsJsonBytes() {
        return ((a0) this.instance).f0();
    }

    @Deprecated
    public Map<String, String> getContext() {
        return getContextMap();
    }

    public int getContextCount() {
        return ((a0) this.instance).g0().size();
    }

    public Map<String, String> getContextMap() {
        return Collections.unmodifiableMap(((a0) this.instance).g0());
    }

    public String getContextOrDefault(String str, String str2) {
        str.getClass();
        Map mapG0 = ((a0) this.instance).g0();
        return mapG0.containsKey(str) ? (String) mapG0.get(str) : str2;
    }

    public String getContextOrThrow(String str) {
        str.getClass();
        Map mapG0 = ((a0) this.instance).g0();
        if (mapG0.containsKey(str)) {
            return (String) mapG0.get(str);
        }
        throw new IllegalArgumentException();
    }

    public long getDurationMs() {
        return ((a0) this.instance).i0();
    }

    public String getError() {
        return ((a0) this.instance).j0();
    }

    public ByteString getErrorBytes() {
        return ((a0) this.instance).k0();
    }

    public String getErrorCode() {
        return ((a0) this.instance).l0();
    }

    public ByteString getErrorCodeBytes() {
        return ((a0) this.instance).m0();
    }

    public String getSessionId() {
        return ((a0) this.instance).n0();
    }

    public ByteString getSessionIdBytes() {
        return ((a0) this.instance).o0();
    }

    public String getToolCallId() {
        return ((a0) this.instance).p0();
    }

    public ByteString getToolCallIdBytes() {
        return ((a0) this.instance).q0();
    }

    public String getToolName() {
        return ((a0) this.instance).r0();
    }

    public ByteString getToolNameBytes() {
        return ((a0) this.instance).s0();
    }

    public ToolCallErrorHookData$Builder putAllContext(Map<String, String> map) {
        copyOnWrite();
        a0.L((a0) this.instance).putAll(map);
        return this;
    }

    public ToolCallErrorHookData$Builder putContext(String str, String str2) {
        str.getClass();
        str2.getClass();
        copyOnWrite();
        a0.L((a0) this.instance).put(str, str2);
        return this;
    }

    public ToolCallErrorHookData$Builder removeContext(String str) {
        str.getClass();
        copyOnWrite();
        a0.L((a0) this.instance).remove(str);
        return this;
    }

    public ToolCallErrorHookData$Builder setAgentId(String str) {
        copyOnWrite();
        a0.M((a0) this.instance, str);
        return this;
    }

    public ToolCallErrorHookData$Builder setAgentIdBytes(ByteString byteString) {
        copyOnWrite();
        a0.N((a0) this.instance, byteString);
        return this;
    }

    public ToolCallErrorHookData$Builder setArgumentsJson(String str) {
        copyOnWrite();
        a0.O((a0) this.instance, str);
        return this;
    }

    public ToolCallErrorHookData$Builder setArgumentsJsonBytes(ByteString byteString) {
        copyOnWrite();
        a0.P((a0) this.instance, byteString);
        return this;
    }

    public ToolCallErrorHookData$Builder setDurationMs(long j5) {
        copyOnWrite();
        a0.Q((a0) this.instance, j5);
        return this;
    }

    public ToolCallErrorHookData$Builder setError(String str) {
        copyOnWrite();
        a0.R((a0) this.instance, str);
        return this;
    }

    public ToolCallErrorHookData$Builder setErrorBytes(ByteString byteString) {
        copyOnWrite();
        a0.S((a0) this.instance, byteString);
        return this;
    }

    public ToolCallErrorHookData$Builder setErrorCode(String str) {
        copyOnWrite();
        a0.T((a0) this.instance, str);
        return this;
    }

    public ToolCallErrorHookData$Builder setErrorCodeBytes(ByteString byteString) {
        copyOnWrite();
        a0.U((a0) this.instance, byteString);
        return this;
    }

    public ToolCallErrorHookData$Builder setSessionId(String str) {
        copyOnWrite();
        a0.V((a0) this.instance, str);
        return this;
    }

    public ToolCallErrorHookData$Builder setSessionIdBytes(ByteString byteString) {
        copyOnWrite();
        a0.W((a0) this.instance, byteString);
        return this;
    }

    public ToolCallErrorHookData$Builder setToolCallId(String str) {
        copyOnWrite();
        a0.X((a0) this.instance, str);
        return this;
    }

    public ToolCallErrorHookData$Builder setToolCallIdBytes(ByteString byteString) {
        copyOnWrite();
        a0.Y((a0) this.instance, byteString);
        return this;
    }

    public ToolCallErrorHookData$Builder setToolName(String str) {
        copyOnWrite();
        a0.Z((a0) this.instance, str);
        return this;
    }

    public ToolCallErrorHookData$Builder setToolNameBytes(ByteString byteString) {
        copyOnWrite();
        a0.a0((a0) this.instance, byteString);
        return this;
    }

    private ToolCallErrorHookData$Builder() {
        super(a0.DEFAULT_INSTANCE);
    }
}
