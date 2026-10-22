package com.zyql.protobuf.common;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import java.util.Collections;
import java.util.Map;
import q7.C1818p;

/* loaded from: classes2.dex */
public final class HookEvent$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ HookEvent$Builder(int i) {
        this();
    }

    public HookEvent$Builder clearAgentId() {
        copyOnWrite();
        C1818p.D((C1818p) this.instance);
        return this;
    }

    public HookEvent$Builder clearBlockedExecution() {
        copyOnWrite();
        C1818p.E((C1818p) this.instance);
        return this;
    }

    public HookEvent$Builder clearDurationMs() {
        copyOnWrite();
        C1818p.F((C1818p) this.instance);
        return this;
    }

    public HookEvent$Builder clearError() {
        copyOnWrite();
        C1818p.G((C1818p) this.instance);
        return this;
    }

    public HookEvent$Builder clearHookId() {
        copyOnWrite();
        C1818p.H((C1818p) this.instance);
        return this;
    }

    public HookEvent$Builder clearHookName() {
        copyOnWrite();
        C1818p.I((C1818p) this.instance);
        return this;
    }

    public HookEvent$Builder clearHookPoint() {
        copyOnWrite();
        C1818p.J((C1818p) this.instance);
        return this;
    }

    public HookEvent$Builder clearInvocationId() {
        copyOnWrite();
        C1818p.K((C1818p) this.instance);
        return this;
    }

    public HookEvent$Builder clearMetadata() {
        copyOnWrite();
        C1818p.P((C1818p) this.instance).clear();
        return this;
    }

    public HookEvent$Builder clearModifiedData() {
        copyOnWrite();
        C1818p.L((C1818p) this.instance);
        return this;
    }

    public HookEvent$Builder clearSessionId() {
        copyOnWrite();
        C1818p.M((C1818p) this.instance);
        return this;
    }

    public HookEvent$Builder clearSuccess() {
        copyOnWrite();
        C1818p.N((C1818p) this.instance);
        return this;
    }

    public HookEvent$Builder clearTimestamp() {
        copyOnWrite();
        C1818p.O((C1818p) this.instance);
        return this;
    }

    public boolean containsMetadata(String str) {
        str.getClass();
        return ((C1818p) this.instance).y0().containsKey(str);
    }

    public String getAgentId() {
        return ((C1818p) this.instance).k0();
    }

    public ByteString getAgentIdBytes() {
        return ((C1818p) this.instance).l0();
    }

    public boolean getBlockedExecution() {
        return ((C1818p) this.instance).m0();
    }

    public long getDurationMs() {
        return ((C1818p) this.instance).n0();
    }

    public String getError() {
        return ((C1818p) this.instance).o0();
    }

    public ByteString getErrorBytes() {
        return ((C1818p) this.instance).p0();
    }

    public String getHookId() {
        return ((C1818p) this.instance).q0();
    }

    public ByteString getHookIdBytes() {
        return ((C1818p) this.instance).r0();
    }

    public String getHookName() {
        return ((C1818p) this.instance).s0();
    }

    public ByteString getHookNameBytes() {
        return ((C1818p) this.instance).t0();
    }

    public HookPoint getHookPoint() {
        return ((C1818p) this.instance).u0();
    }

    public int getHookPointValue() {
        return ((C1818p) this.instance).v0();
    }

    public String getInvocationId() {
        return ((C1818p) this.instance).w0();
    }

    public ByteString getInvocationIdBytes() {
        return ((C1818p) this.instance).x0();
    }

    @Deprecated
    public Map<String, String> getMetadata() {
        return getMetadataMap();
    }

    public int getMetadataCount() {
        return ((C1818p) this.instance).y0().size();
    }

    public Map<String, String> getMetadataMap() {
        return Collections.unmodifiableMap(((C1818p) this.instance).y0());
    }

    public String getMetadataOrDefault(String str, String str2) {
        str.getClass();
        Map mapY0 = ((C1818p) this.instance).y0();
        return mapY0.containsKey(str) ? (String) mapY0.get(str) : str2;
    }

    public String getMetadataOrThrow(String str) {
        str.getClass();
        Map mapY0 = ((C1818p) this.instance).y0();
        if (mapY0.containsKey(str)) {
            return (String) mapY0.get(str);
        }
        throw new IllegalArgumentException();
    }

    public boolean getModifiedData() {
        return ((C1818p) this.instance).z0();
    }

    public String getSessionId() {
        return ((C1818p) this.instance).A0();
    }

    public ByteString getSessionIdBytes() {
        return ((C1818p) this.instance).B0();
    }

    public boolean getSuccess() {
        return ((C1818p) this.instance).C0();
    }

    public long getTimestamp() {
        return ((C1818p) this.instance).D0();
    }

    public HookEvent$Builder putAllMetadata(Map<String, String> map) {
        copyOnWrite();
        C1818p.P((C1818p) this.instance).putAll(map);
        return this;
    }

    public HookEvent$Builder putMetadata(String str, String str2) {
        str.getClass();
        str2.getClass();
        copyOnWrite();
        C1818p.P((C1818p) this.instance).put(str, str2);
        return this;
    }

    public HookEvent$Builder removeMetadata(String str) {
        str.getClass();
        copyOnWrite();
        C1818p.P((C1818p) this.instance).remove(str);
        return this;
    }

    public HookEvent$Builder setAgentId(String str) {
        copyOnWrite();
        C1818p.Q((C1818p) this.instance, str);
        return this;
    }

    public HookEvent$Builder setAgentIdBytes(ByteString byteString) {
        copyOnWrite();
        C1818p.R((C1818p) this.instance, byteString);
        return this;
    }

    public HookEvent$Builder setBlockedExecution(boolean z10) {
        copyOnWrite();
        C1818p.S((C1818p) this.instance, z10);
        return this;
    }

    public HookEvent$Builder setDurationMs(long j5) {
        copyOnWrite();
        C1818p.T((C1818p) this.instance, j5);
        return this;
    }

    public HookEvent$Builder setError(String str) {
        copyOnWrite();
        C1818p.U((C1818p) this.instance, str);
        return this;
    }

    public HookEvent$Builder setErrorBytes(ByteString byteString) {
        copyOnWrite();
        C1818p.V((C1818p) this.instance, byteString);
        return this;
    }

    public HookEvent$Builder setHookId(String str) {
        copyOnWrite();
        C1818p.W((C1818p) this.instance, str);
        return this;
    }

    public HookEvent$Builder setHookIdBytes(ByteString byteString) {
        copyOnWrite();
        C1818p.X((C1818p) this.instance, byteString);
        return this;
    }

    public HookEvent$Builder setHookName(String str) {
        copyOnWrite();
        C1818p.Y((C1818p) this.instance, str);
        return this;
    }

    public HookEvent$Builder setHookNameBytes(ByteString byteString) {
        copyOnWrite();
        C1818p.Z((C1818p) this.instance, byteString);
        return this;
    }

    public HookEvent$Builder setHookPoint(HookPoint hookPoint) {
        copyOnWrite();
        C1818p.a0((C1818p) this.instance, hookPoint);
        return this;
    }

    public HookEvent$Builder setHookPointValue(int i) {
        copyOnWrite();
        C1818p.b0((C1818p) this.instance, i);
        return this;
    }

    public HookEvent$Builder setInvocationId(String str) {
        copyOnWrite();
        C1818p.c0((C1818p) this.instance, str);
        return this;
    }

    public HookEvent$Builder setInvocationIdBytes(ByteString byteString) {
        copyOnWrite();
        C1818p.d0((C1818p) this.instance, byteString);
        return this;
    }

    public HookEvent$Builder setModifiedData(boolean z10) {
        copyOnWrite();
        C1818p.e0((C1818p) this.instance, z10);
        return this;
    }

    public HookEvent$Builder setSessionId(String str) {
        copyOnWrite();
        C1818p.f0((C1818p) this.instance, str);
        return this;
    }

    public HookEvent$Builder setSessionIdBytes(ByteString byteString) {
        copyOnWrite();
        C1818p.g0((C1818p) this.instance, byteString);
        return this;
    }

    public HookEvent$Builder setSuccess(boolean z10) {
        copyOnWrite();
        C1818p.h0((C1818p) this.instance, z10);
        return this;
    }

    public HookEvent$Builder setTimestamp(long j5) {
        copyOnWrite();
        C1818p.i0((C1818p) this.instance, j5);
        return this;
    }

    private HookEvent$Builder() {
        super(C1818p.DEFAULT_INSTANCE);
    }
}
