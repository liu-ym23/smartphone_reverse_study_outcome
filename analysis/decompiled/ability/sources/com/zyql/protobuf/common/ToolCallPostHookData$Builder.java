package com.zyql.protobuf.common;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import java.util.Collections;
import java.util.Map;
import q7.c0;

/* loaded from: classes2.dex */
public final class ToolCallPostHookData$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ ToolCallPostHookData$Builder(int i) {
        this();
    }

    public ToolCallPostHookData$Builder clearAgentId() {
        copyOnWrite();
        c0.D((c0) this.instance);
        return this;
    }

    public ToolCallPostHookData$Builder clearArgumentsJson() {
        copyOnWrite();
        c0.E((c0) this.instance);
        return this;
    }

    public ToolCallPostHookData$Builder clearContentType() {
        copyOnWrite();
        c0.F((c0) this.instance);
        return this;
    }

    public ToolCallPostHookData$Builder clearContext() {
        copyOnWrite();
        c0.M((c0) this.instance).clear();
        return this;
    }

    public ToolCallPostHookData$Builder clearDurationMs() {
        copyOnWrite();
        c0.G((c0) this.instance);
        return this;
    }

    public ToolCallPostHookData$Builder clearOutput() {
        copyOnWrite();
        c0.H((c0) this.instance);
        return this;
    }

    public ToolCallPostHookData$Builder clearSessionId() {
        copyOnWrite();
        c0.I((c0) this.instance);
        return this;
    }

    public ToolCallPostHookData$Builder clearSuccess() {
        copyOnWrite();
        c0.J((c0) this.instance);
        return this;
    }

    public ToolCallPostHookData$Builder clearToolCallId() {
        copyOnWrite();
        c0.K((c0) this.instance);
        return this;
    }

    public ToolCallPostHookData$Builder clearToolName() {
        copyOnWrite();
        c0.L((c0) this.instance);
        return this;
    }

    public boolean containsContext(String str) {
        str.getClass();
        return ((c0) this.instance).k0().containsKey(str);
    }

    public String getAgentId() {
        return ((c0) this.instance).e0();
    }

    public ByteString getAgentIdBytes() {
        return ((c0) this.instance).f0();
    }

    public String getArgumentsJson() {
        return ((c0) this.instance).g0();
    }

    public ByteString getArgumentsJsonBytes() {
        return ((c0) this.instance).h0();
    }

    public String getContentType() {
        return ((c0) this.instance).i0();
    }

    public ByteString getContentTypeBytes() {
        return ((c0) this.instance).j0();
    }

    @Deprecated
    public Map<String, String> getContext() {
        return getContextMap();
    }

    public int getContextCount() {
        return ((c0) this.instance).k0().size();
    }

    public Map<String, String> getContextMap() {
        return Collections.unmodifiableMap(((c0) this.instance).k0());
    }

    public String getContextOrDefault(String str, String str2) {
        str.getClass();
        Map mapK0 = ((c0) this.instance).k0();
        return mapK0.containsKey(str) ? (String) mapK0.get(str) : str2;
    }

    public String getContextOrThrow(String str) {
        str.getClass();
        Map mapK0 = ((c0) this.instance).k0();
        if (mapK0.containsKey(str)) {
            return (String) mapK0.get(str);
        }
        throw new IllegalArgumentException();
    }

    public long getDurationMs() {
        return ((c0) this.instance).m0();
    }

    public String getOutput() {
        return ((c0) this.instance).n0();
    }

    public ByteString getOutputBytes() {
        return ((c0) this.instance).o0();
    }

    public String getSessionId() {
        return ((c0) this.instance).p0();
    }

    public ByteString getSessionIdBytes() {
        return ((c0) this.instance).q0();
    }

    public boolean getSuccess() {
        return ((c0) this.instance).r0();
    }

    public String getToolCallId() {
        return ((c0) this.instance).s0();
    }

    public ByteString getToolCallIdBytes() {
        return ((c0) this.instance).t0();
    }

    public String getToolName() {
        return ((c0) this.instance).u0();
    }

    public ByteString getToolNameBytes() {
        return ((c0) this.instance).v0();
    }

    public ToolCallPostHookData$Builder putAllContext(Map<String, String> map) {
        copyOnWrite();
        c0.M((c0) this.instance).putAll(map);
        return this;
    }

    public ToolCallPostHookData$Builder putContext(String str, String str2) {
        str.getClass();
        str2.getClass();
        copyOnWrite();
        c0.M((c0) this.instance).put(str, str2);
        return this;
    }

    public ToolCallPostHookData$Builder removeContext(String str) {
        str.getClass();
        copyOnWrite();
        c0.M((c0) this.instance).remove(str);
        return this;
    }

    public ToolCallPostHookData$Builder setAgentId(String str) {
        copyOnWrite();
        c0.N((c0) this.instance, str);
        return this;
    }

    public ToolCallPostHookData$Builder setAgentIdBytes(ByteString byteString) {
        copyOnWrite();
        c0.O((c0) this.instance, byteString);
        return this;
    }

    public ToolCallPostHookData$Builder setArgumentsJson(String str) {
        copyOnWrite();
        c0.P((c0) this.instance, str);
        return this;
    }

    public ToolCallPostHookData$Builder setArgumentsJsonBytes(ByteString byteString) {
        copyOnWrite();
        c0.Q((c0) this.instance, byteString);
        return this;
    }

    public ToolCallPostHookData$Builder setContentType(String str) {
        copyOnWrite();
        c0.R((c0) this.instance, str);
        return this;
    }

    public ToolCallPostHookData$Builder setContentTypeBytes(ByteString byteString) {
        copyOnWrite();
        c0.S((c0) this.instance, byteString);
        return this;
    }

    public ToolCallPostHookData$Builder setDurationMs(long j5) {
        copyOnWrite();
        c0.T((c0) this.instance, j5);
        return this;
    }

    public ToolCallPostHookData$Builder setOutput(String str) {
        copyOnWrite();
        c0.U((c0) this.instance, str);
        return this;
    }

    public ToolCallPostHookData$Builder setOutputBytes(ByteString byteString) {
        copyOnWrite();
        c0.V((c0) this.instance, byteString);
        return this;
    }

    public ToolCallPostHookData$Builder setSessionId(String str) {
        copyOnWrite();
        c0.W((c0) this.instance, str);
        return this;
    }

    public ToolCallPostHookData$Builder setSessionIdBytes(ByteString byteString) {
        copyOnWrite();
        c0.X((c0) this.instance, byteString);
        return this;
    }

    public ToolCallPostHookData$Builder setSuccess(boolean z10) {
        copyOnWrite();
        c0.Y((c0) this.instance, z10);
        return this;
    }

    public ToolCallPostHookData$Builder setToolCallId(String str) {
        copyOnWrite();
        c0.Z((c0) this.instance, str);
        return this;
    }

    public ToolCallPostHookData$Builder setToolCallIdBytes(ByteString byteString) {
        copyOnWrite();
        c0.a0((c0) this.instance, byteString);
        return this;
    }

    public ToolCallPostHookData$Builder setToolName(String str) {
        copyOnWrite();
        c0.b0((c0) this.instance, str);
        return this;
    }

    public ToolCallPostHookData$Builder setToolNameBytes(ByteString byteString) {
        copyOnWrite();
        c0.c0((c0) this.instance, byteString);
        return this;
    }

    private ToolCallPostHookData$Builder() {
        super(c0.DEFAULT_INSTANCE);
    }
}
