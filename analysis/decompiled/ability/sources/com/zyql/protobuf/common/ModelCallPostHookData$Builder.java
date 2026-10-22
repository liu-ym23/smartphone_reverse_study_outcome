package com.zyql.protobuf.common;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import java.util.Collections;
import java.util.Map;
import q7.D;

/* loaded from: classes2.dex */
public final class ModelCallPostHookData$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ ModelCallPostHookData$Builder(int i) {
        this();
    }

    public ModelCallPostHookData$Builder clearAgentId() {
        copyOnWrite();
        D.D((D) this.instance);
        return this;
    }

    public ModelCallPostHookData$Builder clearDurationMs() {
        copyOnWrite();
        D.E((D) this.instance);
        return this;
    }

    public ModelCallPostHookData$Builder clearInputTokens() {
        copyOnWrite();
        D.F((D) this.instance);
        return this;
    }

    public ModelCallPostHookData$Builder clearMetadata() {
        copyOnWrite();
        D.M((D) this.instance).clear();
        return this;
    }

    public ModelCallPostHookData$Builder clearModelName() {
        copyOnWrite();
        D.G((D) this.instance);
        return this;
    }

    public ModelCallPostHookData$Builder clearOutputTokens() {
        copyOnWrite();
        D.H((D) this.instance);
        return this;
    }

    public ModelCallPostHookData$Builder clearProvider() {
        copyOnWrite();
        D.I((D) this.instance);
        return this;
    }

    public ModelCallPostHookData$Builder clearResponseText() {
        copyOnWrite();
        D.J((D) this.instance);
        return this;
    }

    public ModelCallPostHookData$Builder clearSessionId() {
        copyOnWrite();
        D.K((D) this.instance);
        return this;
    }

    public ModelCallPostHookData$Builder clearSuccess() {
        copyOnWrite();
        D.L((D) this.instance);
        return this;
    }

    public boolean containsMetadata(String str) {
        str.getClass();
        return ((D) this.instance).h0().containsKey(str);
    }

    public String getAgentId() {
        return ((D) this.instance).c0();
    }

    public ByteString getAgentIdBytes() {
        return ((D) this.instance).d0();
    }

    public long getDurationMs() {
        return ((D) this.instance).f0();
    }

    public int getInputTokens() {
        return ((D) this.instance).g0();
    }

    @Deprecated
    public Map<String, String> getMetadata() {
        return getMetadataMap();
    }

    public int getMetadataCount() {
        return ((D) this.instance).h0().size();
    }

    public Map<String, String> getMetadataMap() {
        return Collections.unmodifiableMap(((D) this.instance).h0());
    }

    public String getMetadataOrDefault(String str, String str2) {
        str.getClass();
        Map mapH0 = ((D) this.instance).h0();
        return mapH0.containsKey(str) ? (String) mapH0.get(str) : str2;
    }

    public String getMetadataOrThrow(String str) {
        str.getClass();
        Map mapH0 = ((D) this.instance).h0();
        if (mapH0.containsKey(str)) {
            return (String) mapH0.get(str);
        }
        throw new IllegalArgumentException();
    }

    public String getModelName() {
        return ((D) this.instance).i0();
    }

    public ByteString getModelNameBytes() {
        return ((D) this.instance).j0();
    }

    public int getOutputTokens() {
        return ((D) this.instance).k0();
    }

    public String getProvider() {
        return ((D) this.instance).l0();
    }

    public ByteString getProviderBytes() {
        return ((D) this.instance).m0();
    }

    public String getResponseText() {
        return ((D) this.instance).n0();
    }

    public ByteString getResponseTextBytes() {
        return ((D) this.instance).o0();
    }

    public String getSessionId() {
        return ((D) this.instance).p0();
    }

    public ByteString getSessionIdBytes() {
        return ((D) this.instance).q0();
    }

    public boolean getSuccess() {
        return ((D) this.instance).r0();
    }

    public ModelCallPostHookData$Builder putAllMetadata(Map<String, String> map) {
        copyOnWrite();
        D.M((D) this.instance).putAll(map);
        return this;
    }

    public ModelCallPostHookData$Builder putMetadata(String str, String str2) {
        str.getClass();
        str2.getClass();
        copyOnWrite();
        D.M((D) this.instance).put(str, str2);
        return this;
    }

    public ModelCallPostHookData$Builder removeMetadata(String str) {
        str.getClass();
        copyOnWrite();
        D.M((D) this.instance).remove(str);
        return this;
    }

    public ModelCallPostHookData$Builder setAgentId(String str) {
        copyOnWrite();
        D.N((D) this.instance, str);
        return this;
    }

    public ModelCallPostHookData$Builder setAgentIdBytes(ByteString byteString) {
        copyOnWrite();
        D.O((D) this.instance, byteString);
        return this;
    }

    public ModelCallPostHookData$Builder setDurationMs(long j5) {
        copyOnWrite();
        D.P((D) this.instance, j5);
        return this;
    }

    public ModelCallPostHookData$Builder setInputTokens(int i) {
        copyOnWrite();
        D.Q((D) this.instance, i);
        return this;
    }

    public ModelCallPostHookData$Builder setModelName(String str) {
        copyOnWrite();
        D.R((D) this.instance, str);
        return this;
    }

    public ModelCallPostHookData$Builder setModelNameBytes(ByteString byteString) {
        copyOnWrite();
        D.S((D) this.instance, byteString);
        return this;
    }

    public ModelCallPostHookData$Builder setOutputTokens(int i) {
        copyOnWrite();
        D.T((D) this.instance, i);
        return this;
    }

    public ModelCallPostHookData$Builder setProvider(String str) {
        copyOnWrite();
        D.U((D) this.instance, str);
        return this;
    }

    public ModelCallPostHookData$Builder setProviderBytes(ByteString byteString) {
        copyOnWrite();
        D.V((D) this.instance, byteString);
        return this;
    }

    public ModelCallPostHookData$Builder setResponseText(String str) {
        copyOnWrite();
        D.W((D) this.instance, str);
        return this;
    }

    public ModelCallPostHookData$Builder setResponseTextBytes(ByteString byteString) {
        copyOnWrite();
        D.X((D) this.instance, byteString);
        return this;
    }

    public ModelCallPostHookData$Builder setSessionId(String str) {
        copyOnWrite();
        D.Y((D) this.instance, str);
        return this;
    }

    public ModelCallPostHookData$Builder setSessionIdBytes(ByteString byteString) {
        copyOnWrite();
        D.Z((D) this.instance, byteString);
        return this;
    }

    public ModelCallPostHookData$Builder setSuccess(boolean z10) {
        copyOnWrite();
        D.a0((D) this.instance, z10);
        return this;
    }

    private ModelCallPostHookData$Builder() {
        super(D.DEFAULT_INSTANCE);
    }
}
