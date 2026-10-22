package com.zyql.protobuf.agent;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import java.util.Collections;
import java.util.Map;
import o7.q;

/* loaded from: classes2.dex */
public final class HookExecutionResult$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ HookExecutionResult$Builder(int i) {
        this();
    }

    public HookExecutionResult$Builder clearContinueExecution() {
        copyOnWrite();
        q.D((q) this.instance);
        return this;
    }

    public HookExecutionResult$Builder clearDurationMs() {
        copyOnWrite();
        q.E((q) this.instance);
        return this;
    }

    public HookExecutionResult$Builder clearError() {
        copyOnWrite();
        q.F((q) this.instance);
        return this;
    }

    public HookExecutionResult$Builder clearMetadata() {
        copyOnWrite();
        q.K((q) this.instance).clear();
        return this;
    }

    public HookExecutionResult$Builder clearModified() {
        copyOnWrite();
        q.G((q) this.instance);
        return this;
    }

    public HookExecutionResult$Builder clearModifiedData() {
        copyOnWrite();
        q.H((q) this.instance);
        return this;
    }

    public HookExecutionResult$Builder clearSuccess() {
        copyOnWrite();
        q.I((q) this.instance);
        return this;
    }

    public HookExecutionResult$Builder clearTaskId() {
        copyOnWrite();
        q.J((q) this.instance);
        return this;
    }

    public boolean containsMetadata(String str) {
        str.getClass();
        return ((q) this.instance).a0().containsKey(str);
    }

    public boolean getContinueExecution() {
        return ((q) this.instance).V();
    }

    public long getDurationMs() {
        return ((q) this.instance).X();
    }

    public String getError() {
        return ((q) this.instance).Y();
    }

    public ByteString getErrorBytes() {
        return ((q) this.instance).Z();
    }

    @Deprecated
    public Map<String, String> getMetadata() {
        return getMetadataMap();
    }

    public int getMetadataCount() {
        return ((q) this.instance).a0().size();
    }

    public Map<String, String> getMetadataMap() {
        return Collections.unmodifiableMap(((q) this.instance).a0());
    }

    public String getMetadataOrDefault(String str, String str2) {
        str.getClass();
        Map mapA0 = ((q) this.instance).a0();
        return mapA0.containsKey(str) ? (String) mapA0.get(str) : str2;
    }

    public String getMetadataOrThrow(String str) {
        str.getClass();
        Map mapA0 = ((q) this.instance).a0();
        if (mapA0.containsKey(str)) {
            return (String) mapA0.get(str);
        }
        throw new IllegalArgumentException();
    }

    public boolean getModified() {
        return ((q) this.instance).b0();
    }

    public ByteString getModifiedData() {
        return ((q) this.instance).c0();
    }

    public boolean getSuccess() {
        return ((q) this.instance).d0();
    }

    public String getTaskId() {
        return ((q) this.instance).e0();
    }

    public ByteString getTaskIdBytes() {
        return ((q) this.instance).f0();
    }

    public HookExecutionResult$Builder putAllMetadata(Map<String, String> map) {
        copyOnWrite();
        q.K((q) this.instance).putAll(map);
        return this;
    }

    public HookExecutionResult$Builder putMetadata(String str, String str2) {
        str.getClass();
        str2.getClass();
        copyOnWrite();
        q.K((q) this.instance).put(str, str2);
        return this;
    }

    public HookExecutionResult$Builder removeMetadata(String str) {
        str.getClass();
        copyOnWrite();
        q.K((q) this.instance).remove(str);
        return this;
    }

    public HookExecutionResult$Builder setContinueExecution(boolean z10) {
        copyOnWrite();
        q.L((q) this.instance, z10);
        return this;
    }

    public HookExecutionResult$Builder setDurationMs(long j5) {
        copyOnWrite();
        q.M((q) this.instance, j5);
        return this;
    }

    public HookExecutionResult$Builder setError(String str) {
        copyOnWrite();
        q.N((q) this.instance, str);
        return this;
    }

    public HookExecutionResult$Builder setErrorBytes(ByteString byteString) {
        copyOnWrite();
        q.O((q) this.instance, byteString);
        return this;
    }

    public HookExecutionResult$Builder setModified(boolean z10) {
        copyOnWrite();
        q.P((q) this.instance, z10);
        return this;
    }

    public HookExecutionResult$Builder setModifiedData(ByteString byteString) {
        copyOnWrite();
        q.Q((q) this.instance, byteString);
        return this;
    }

    public HookExecutionResult$Builder setSuccess(boolean z10) {
        copyOnWrite();
        q.R((q) this.instance, z10);
        return this;
    }

    public HookExecutionResult$Builder setTaskId(String str) {
        copyOnWrite();
        q.S((q) this.instance, str);
        return this;
    }

    public HookExecutionResult$Builder setTaskIdBytes(ByteString byteString) {
        copyOnWrite();
        q.T((q) this.instance, byteString);
        return this;
    }

    private HookExecutionResult$Builder() {
        super(q.DEFAULT_INSTANCE);
    }
}
