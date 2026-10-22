package com.zyql.protobuf.common;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import java.util.Collections;
import java.util.Map;
import q7.C1821t;

/* loaded from: classes2.dex */
public final class HookResult$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ HookResult$Builder(int i) {
        this();
    }

    public HookResult$Builder clearBlockReason() {
        copyOnWrite();
        C1821t.D((C1821t) this.instance);
        return this;
    }

    public HookResult$Builder clearContinueExecution() {
        copyOnWrite();
        C1821t.E((C1821t) this.instance);
        return this;
    }

    public HookResult$Builder clearDurationMs() {
        copyOnWrite();
        C1821t.F((C1821t) this.instance);
        return this;
    }

    public HookResult$Builder clearError() {
        copyOnWrite();
        C1821t.G((C1821t) this.instance);
        return this;
    }

    public HookResult$Builder clearHookId() {
        copyOnWrite();
        C1821t.H((C1821t) this.instance);
        return this;
    }

    public HookResult$Builder clearInvocationId() {
        copyOnWrite();
        C1821t.I((C1821t) this.instance);
        return this;
    }

    public HookResult$Builder clearMetadata() {
        copyOnWrite();
        C1821t.P((C1821t) this.instance).clear();
        return this;
    }

    public HookResult$Builder clearModified() {
        copyOnWrite();
        C1821t.J((C1821t) this.instance);
        return this;
    }

    public HookResult$Builder clearModifiedData() {
        copyOnWrite();
        C1821t.K((C1821t) this.instance);
        return this;
    }

    public HookResult$Builder clearPostMode() {
        copyOnWrite();
        C1821t.L((C1821t) this.instance);
        return this;
    }

    public HookResult$Builder clearPreMode() {
        copyOnWrite();
        C1821t.M((C1821t) this.instance);
        return this;
    }

    public HookResult$Builder clearReason() {
        copyOnWrite();
        C1821t.N((C1821t) this.instance);
        return this;
    }

    public HookResult$Builder clearSuccess() {
        copyOnWrite();
        C1821t.O((C1821t) this.instance);
        return this;
    }

    public boolean containsMetadata(String str) {
        str.getClass();
        return ((C1821t) this.instance).u0().containsKey(str);
    }

    public String getBlockReason() {
        return ((C1821t) this.instance).k0();
    }

    public ByteString getBlockReasonBytes() {
        return ((C1821t) this.instance).l0();
    }

    public boolean getContinueExecution() {
        return ((C1821t) this.instance).m0();
    }

    public long getDurationMs() {
        return ((C1821t) this.instance).n0();
    }

    public String getError() {
        return ((C1821t) this.instance).o0();
    }

    public ByteString getErrorBytes() {
        return ((C1821t) this.instance).p0();
    }

    public String getHookId() {
        return ((C1821t) this.instance).q0();
    }

    public ByteString getHookIdBytes() {
        return ((C1821t) this.instance).r0();
    }

    public String getInvocationId() {
        return ((C1821t) this.instance).s0();
    }

    public ByteString getInvocationIdBytes() {
        return ((C1821t) this.instance).t0();
    }

    @Deprecated
    public Map<String, String> getMetadata() {
        return getMetadataMap();
    }

    public int getMetadataCount() {
        return ((C1821t) this.instance).u0().size();
    }

    public Map<String, String> getMetadataMap() {
        return Collections.unmodifiableMap(((C1821t) this.instance).u0());
    }

    public String getMetadataOrDefault(String str, String str2) {
        str.getClass();
        Map mapU0 = ((C1821t) this.instance).u0();
        return mapU0.containsKey(str) ? (String) mapU0.get(str) : str2;
    }

    public String getMetadataOrThrow(String str) {
        str.getClass();
        Map mapU0 = ((C1821t) this.instance).u0();
        if (mapU0.containsKey(str)) {
            return (String) mapU0.get(str);
        }
        throw new IllegalArgumentException();
    }

    public boolean getModified() {
        return ((C1821t) this.instance).v0();
    }

    public ByteString getModifiedData() {
        return ((C1821t) this.instance).w0();
    }

    public PostToolCallMode getPostMode() {
        return ((C1821t) this.instance).x0();
    }

    public int getPostModeValue() {
        return ((C1821t) this.instance).y0();
    }

    public PreToolCallMode getPreMode() {
        return ((C1821t) this.instance).z0();
    }

    public int getPreModeValue() {
        return ((C1821t) this.instance).A0();
    }

    public String getReason() {
        return ((C1821t) this.instance).B0();
    }

    public ByteString getReasonBytes() {
        return ((C1821t) this.instance).C0();
    }

    public boolean getSuccess() {
        return ((C1821t) this.instance).D0();
    }

    public HookResult$Builder putAllMetadata(Map<String, String> map) {
        copyOnWrite();
        C1821t.P((C1821t) this.instance).putAll(map);
        return this;
    }

    public HookResult$Builder putMetadata(String str, String str2) {
        str.getClass();
        str2.getClass();
        copyOnWrite();
        C1821t.P((C1821t) this.instance).put(str, str2);
        return this;
    }

    public HookResult$Builder removeMetadata(String str) {
        str.getClass();
        copyOnWrite();
        C1821t.P((C1821t) this.instance).remove(str);
        return this;
    }

    public HookResult$Builder setBlockReason(String str) {
        copyOnWrite();
        C1821t.Q((C1821t) this.instance, str);
        return this;
    }

    public HookResult$Builder setBlockReasonBytes(ByteString byteString) {
        copyOnWrite();
        C1821t.R((C1821t) this.instance, byteString);
        return this;
    }

    public HookResult$Builder setContinueExecution(boolean z10) {
        copyOnWrite();
        C1821t.S((C1821t) this.instance, z10);
        return this;
    }

    public HookResult$Builder setDurationMs(long j5) {
        copyOnWrite();
        C1821t.T((C1821t) this.instance, j5);
        return this;
    }

    public HookResult$Builder setError(String str) {
        copyOnWrite();
        C1821t.U((C1821t) this.instance, str);
        return this;
    }

    public HookResult$Builder setErrorBytes(ByteString byteString) {
        copyOnWrite();
        C1821t.V((C1821t) this.instance, byteString);
        return this;
    }

    public HookResult$Builder setHookId(String str) {
        copyOnWrite();
        C1821t.W((C1821t) this.instance, str);
        return this;
    }

    public HookResult$Builder setHookIdBytes(ByteString byteString) {
        copyOnWrite();
        C1821t.X((C1821t) this.instance, byteString);
        return this;
    }

    public HookResult$Builder setInvocationId(String str) {
        copyOnWrite();
        C1821t.Y((C1821t) this.instance, str);
        return this;
    }

    public HookResult$Builder setInvocationIdBytes(ByteString byteString) {
        copyOnWrite();
        C1821t.Z((C1821t) this.instance, byteString);
        return this;
    }

    public HookResult$Builder setModified(boolean z10) {
        copyOnWrite();
        C1821t.a0((C1821t) this.instance, z10);
        return this;
    }

    public HookResult$Builder setModifiedData(ByteString byteString) {
        copyOnWrite();
        C1821t.b0((C1821t) this.instance, byteString);
        return this;
    }

    public HookResult$Builder setPostMode(PostToolCallMode postToolCallMode) {
        copyOnWrite();
        C1821t.c0((C1821t) this.instance, postToolCallMode);
        return this;
    }

    public HookResult$Builder setPostModeValue(int i) {
        copyOnWrite();
        C1821t.d0((C1821t) this.instance, i);
        return this;
    }

    public HookResult$Builder setPreMode(PreToolCallMode preToolCallMode) {
        copyOnWrite();
        C1821t.e0((C1821t) this.instance, preToolCallMode);
        return this;
    }

    public HookResult$Builder setPreModeValue(int i) {
        copyOnWrite();
        C1821t.f0((C1821t) this.instance, i);
        return this;
    }

    public HookResult$Builder setReason(String str) {
        copyOnWrite();
        C1821t.g0((C1821t) this.instance, str);
        return this;
    }

    public HookResult$Builder setReasonBytes(ByteString byteString) {
        copyOnWrite();
        C1821t.h0((C1821t) this.instance, byteString);
        return this;
    }

    public HookResult$Builder setSuccess(boolean z10) {
        copyOnWrite();
        C1821t.i0((C1821t) this.instance, z10);
        return this;
    }

    private HookResult$Builder() {
        super(C1821t.DEFAULT_INSTANCE);
    }
}
