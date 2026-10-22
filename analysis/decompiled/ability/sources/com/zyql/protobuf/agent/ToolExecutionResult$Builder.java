package com.zyql.protobuf.agent;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import java.util.Collections;
import java.util.Map;
import o7.C1763B;

/* loaded from: classes2.dex */
public final class ToolExecutionResult$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ ToolExecutionResult$Builder(int i) {
        this();
    }

    public ToolExecutionResult$Builder clearContentType() {
        copyOnWrite();
        C1763B.D((C1763B) this.instance);
        return this;
    }

    public ToolExecutionResult$Builder clearError() {
        copyOnWrite();
        C1763B.E((C1763B) this.instance);
        return this;
    }

    public ToolExecutionResult$Builder clearMetadata() {
        copyOnWrite();
        C1763B.J((C1763B) this.instance).clear();
        return this;
    }

    public ToolExecutionResult$Builder clearOutput() {
        copyOnWrite();
        C1763B.F((C1763B) this.instance);
        return this;
    }

    public ToolExecutionResult$Builder clearSuccess() {
        copyOnWrite();
        C1763B.G((C1763B) this.instance);
        return this;
    }

    public ToolExecutionResult$Builder clearTaskId() {
        copyOnWrite();
        C1763B.H((C1763B) this.instance);
        return this;
    }

    public ToolExecutionResult$Builder clearToolCallId() {
        copyOnWrite();
        C1763B.I((C1763B) this.instance);
        return this;
    }

    public boolean containsMetadata(String str) {
        str.getClass();
        return ((C1763B) this.instance).b0().containsKey(str);
    }

    public String getContentType() {
        return ((C1763B) this.instance).W();
    }

    public ByteString getContentTypeBytes() {
        return ((C1763B) this.instance).X();
    }

    public String getError() {
        return ((C1763B) this.instance).Z();
    }

    public ByteString getErrorBytes() {
        return ((C1763B) this.instance).a0();
    }

    @Deprecated
    public Map<String, String> getMetadata() {
        return getMetadataMap();
    }

    public int getMetadataCount() {
        return ((C1763B) this.instance).b0().size();
    }

    public Map<String, String> getMetadataMap() {
        return Collections.unmodifiableMap(((C1763B) this.instance).b0());
    }

    public String getMetadataOrDefault(String str, String str2) {
        str.getClass();
        Map mapB0 = ((C1763B) this.instance).b0();
        return mapB0.containsKey(str) ? (String) mapB0.get(str) : str2;
    }

    public String getMetadataOrThrow(String str) {
        str.getClass();
        Map mapB0 = ((C1763B) this.instance).b0();
        if (mapB0.containsKey(str)) {
            return (String) mapB0.get(str);
        }
        throw new IllegalArgumentException();
    }

    public String getOutput() {
        return ((C1763B) this.instance).c0();
    }

    public ByteString getOutputBytes() {
        return ((C1763B) this.instance).d0();
    }

    public boolean getSuccess() {
        return ((C1763B) this.instance).e0();
    }

    public String getTaskId() {
        return ((C1763B) this.instance).f0();
    }

    public ByteString getTaskIdBytes() {
        return ((C1763B) this.instance).g0();
    }

    public String getToolCallId() {
        return ((C1763B) this.instance).h0();
    }

    public ByteString getToolCallIdBytes() {
        return ((C1763B) this.instance).i0();
    }

    public ToolExecutionResult$Builder putAllMetadata(Map<String, String> map) {
        copyOnWrite();
        C1763B.J((C1763B) this.instance).putAll(map);
        return this;
    }

    public ToolExecutionResult$Builder putMetadata(String str, String str2) {
        str.getClass();
        str2.getClass();
        copyOnWrite();
        C1763B.J((C1763B) this.instance).put(str, str2);
        return this;
    }

    public ToolExecutionResult$Builder removeMetadata(String str) {
        str.getClass();
        copyOnWrite();
        C1763B.J((C1763B) this.instance).remove(str);
        return this;
    }

    public ToolExecutionResult$Builder setContentType(String str) {
        copyOnWrite();
        C1763B.K((C1763B) this.instance, str);
        return this;
    }

    public ToolExecutionResult$Builder setContentTypeBytes(ByteString byteString) {
        copyOnWrite();
        C1763B.L((C1763B) this.instance, byteString);
        return this;
    }

    public ToolExecutionResult$Builder setError(String str) {
        copyOnWrite();
        C1763B.M((C1763B) this.instance, str);
        return this;
    }

    public ToolExecutionResult$Builder setErrorBytes(ByteString byteString) {
        copyOnWrite();
        C1763B.N((C1763B) this.instance, byteString);
        return this;
    }

    public ToolExecutionResult$Builder setOutput(String str) {
        copyOnWrite();
        C1763B.O((C1763B) this.instance, str);
        return this;
    }

    public ToolExecutionResult$Builder setOutputBytes(ByteString byteString) {
        copyOnWrite();
        C1763B.P((C1763B) this.instance, byteString);
        return this;
    }

    public ToolExecutionResult$Builder setSuccess(boolean z10) {
        copyOnWrite();
        C1763B.Q((C1763B) this.instance, z10);
        return this;
    }

    public ToolExecutionResult$Builder setTaskId(String str) {
        copyOnWrite();
        C1763B.R((C1763B) this.instance, str);
        return this;
    }

    public ToolExecutionResult$Builder setTaskIdBytes(ByteString byteString) {
        copyOnWrite();
        C1763B.S((C1763B) this.instance, byteString);
        return this;
    }

    public ToolExecutionResult$Builder setToolCallId(String str) {
        copyOnWrite();
        C1763B.T((C1763B) this.instance, str);
        return this;
    }

    public ToolExecutionResult$Builder setToolCallIdBytes(ByteString byteString) {
        copyOnWrite();
        C1763B.U((C1763B) this.instance, byteString);
        return this;
    }

    private ToolExecutionResult$Builder() {
        super(C1763B.DEFAULT_INSTANCE);
    }
}
