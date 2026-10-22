package com.zyql.protobuf.common;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import java.util.Collections;
import java.util.Map;
import q7.r;

/* loaded from: classes2.dex */
public final class HookInvocation$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ HookInvocation$Builder(int i) {
        this();
    }

    public HookInvocation$Builder clearAgentId() {
        copyOnWrite();
        r.D((r) this.instance);
        return this;
    }

    public HookInvocation$Builder clearHookData() {
        copyOnWrite();
        r.E((r) this.instance);
        return this;
    }

    public HookInvocation$Builder clearHookId() {
        copyOnWrite();
        r.F((r) this.instance);
        return this;
    }

    public HookInvocation$Builder clearHookPoint() {
        copyOnWrite();
        r.G((r) this.instance);
        return this;
    }

    public HookInvocation$Builder clearInvocationId() {
        copyOnWrite();
        r.H((r) this.instance);
        return this;
    }

    public HookInvocation$Builder clearMetadata() {
        copyOnWrite();
        r.L((r) this.instance).clear();
        return this;
    }

    public HookInvocation$Builder clearRunId() {
        copyOnWrite();
        r.I((r) this.instance);
        return this;
    }

    public HookInvocation$Builder clearSessionId() {
        copyOnWrite();
        r.J((r) this.instance);
        return this;
    }

    public HookInvocation$Builder clearTimestamp() {
        copyOnWrite();
        r.K((r) this.instance);
        return this;
    }

    public boolean containsMetadata(String str) {
        str.getClass();
        return ((r) this.instance).k0().containsKey(str);
    }

    public String getAgentId() {
        return ((r) this.instance).b0();
    }

    public ByteString getAgentIdBytes() {
        return ((r) this.instance).c0();
    }

    public ByteString getHookData() {
        return ((r) this.instance).d0();
    }

    public String getHookId() {
        return ((r) this.instance).e0();
    }

    public ByteString getHookIdBytes() {
        return ((r) this.instance).f0();
    }

    public HookPoint getHookPoint() {
        return ((r) this.instance).g0();
    }

    public int getHookPointValue() {
        return ((r) this.instance).h0();
    }

    public String getInvocationId() {
        return ((r) this.instance).i0();
    }

    public ByteString getInvocationIdBytes() {
        return ((r) this.instance).j0();
    }

    @Deprecated
    public Map<String, String> getMetadata() {
        return getMetadataMap();
    }

    public int getMetadataCount() {
        return ((r) this.instance).k0().size();
    }

    public Map<String, String> getMetadataMap() {
        return Collections.unmodifiableMap(((r) this.instance).k0());
    }

    public String getMetadataOrDefault(String str, String str2) {
        str.getClass();
        Map mapK0 = ((r) this.instance).k0();
        return mapK0.containsKey(str) ? (String) mapK0.get(str) : str2;
    }

    public String getMetadataOrThrow(String str) {
        str.getClass();
        Map mapK0 = ((r) this.instance).k0();
        if (mapK0.containsKey(str)) {
            return (String) mapK0.get(str);
        }
        throw new IllegalArgumentException();
    }

    public String getRunId() {
        return ((r) this.instance).l0();
    }

    public ByteString getRunIdBytes() {
        return ((r) this.instance).m0();
    }

    public String getSessionId() {
        return ((r) this.instance).n0();
    }

    public ByteString getSessionIdBytes() {
        return ((r) this.instance).o0();
    }

    public long getTimestamp() {
        return ((r) this.instance).p0();
    }

    public HookInvocation$Builder putAllMetadata(Map<String, String> map) {
        copyOnWrite();
        r.L((r) this.instance).putAll(map);
        return this;
    }

    public HookInvocation$Builder putMetadata(String str, String str2) {
        str.getClass();
        str2.getClass();
        copyOnWrite();
        r.L((r) this.instance).put(str, str2);
        return this;
    }

    public HookInvocation$Builder removeMetadata(String str) {
        str.getClass();
        copyOnWrite();
        r.L((r) this.instance).remove(str);
        return this;
    }

    public HookInvocation$Builder setAgentId(String str) {
        copyOnWrite();
        r.M((r) this.instance, str);
        return this;
    }

    public HookInvocation$Builder setAgentIdBytes(ByteString byteString) {
        copyOnWrite();
        r.N((r) this.instance, byteString);
        return this;
    }

    public HookInvocation$Builder setHookData(ByteString byteString) {
        copyOnWrite();
        r.O((r) this.instance, byteString);
        return this;
    }

    public HookInvocation$Builder setHookId(String str) {
        copyOnWrite();
        r.P((r) this.instance, str);
        return this;
    }

    public HookInvocation$Builder setHookIdBytes(ByteString byteString) {
        copyOnWrite();
        r.Q((r) this.instance, byteString);
        return this;
    }

    public HookInvocation$Builder setHookPoint(HookPoint hookPoint) {
        copyOnWrite();
        r.R((r) this.instance, hookPoint);
        return this;
    }

    public HookInvocation$Builder setHookPointValue(int i) {
        copyOnWrite();
        r.S((r) this.instance, i);
        return this;
    }

    public HookInvocation$Builder setInvocationId(String str) {
        copyOnWrite();
        r.T((r) this.instance, str);
        return this;
    }

    public HookInvocation$Builder setInvocationIdBytes(ByteString byteString) {
        copyOnWrite();
        r.U((r) this.instance, byteString);
        return this;
    }

    public HookInvocation$Builder setRunId(String str) {
        copyOnWrite();
        r.V((r) this.instance, str);
        return this;
    }

    public HookInvocation$Builder setRunIdBytes(ByteString byteString) {
        copyOnWrite();
        r.W((r) this.instance, byteString);
        return this;
    }

    public HookInvocation$Builder setSessionId(String str) {
        copyOnWrite();
        r.X((r) this.instance, str);
        return this;
    }

    public HookInvocation$Builder setSessionIdBytes(ByteString byteString) {
        copyOnWrite();
        r.Y((r) this.instance, byteString);
        return this;
    }

    public HookInvocation$Builder setTimestamp(long j5) {
        copyOnWrite();
        r.Z((r) this.instance, j5);
        return this;
    }

    private HookInvocation$Builder() {
        super(r.DEFAULT_INSTANCE);
    }
}
