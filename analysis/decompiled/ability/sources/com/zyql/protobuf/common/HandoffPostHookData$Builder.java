package com.zyql.protobuf.common;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import java.util.Collections;
import java.util.Map;
import q7.C1813k;

/* loaded from: classes2.dex */
public final class HandoffPostHookData$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ HandoffPostHookData$Builder(int i) {
        this();
    }

    public HandoffPostHookData$Builder clearDurationMs() {
        copyOnWrite();
        C1813k.D((C1813k) this.instance);
        return this;
    }

    public HandoffPostHookData$Builder clearFromAgentId() {
        copyOnWrite();
        C1813k.E((C1813k) this.instance);
        return this;
    }

    public HandoffPostHookData$Builder clearMetadata() {
        copyOnWrite();
        C1813k.I((C1813k) this.instance).clear();
        return this;
    }

    public HandoffPostHookData$Builder clearSessionId() {
        copyOnWrite();
        C1813k.F((C1813k) this.instance);
        return this;
    }

    public HandoffPostHookData$Builder clearSuccess() {
        copyOnWrite();
        C1813k.G((C1813k) this.instance);
        return this;
    }

    public HandoffPostHookData$Builder clearToAgentId() {
        copyOnWrite();
        C1813k.H((C1813k) this.instance);
        return this;
    }

    public boolean containsMetadata(String str) {
        str.getClass();
        return ((C1813k) this.instance).W().containsKey(str);
    }

    public long getDurationMs() {
        return ((C1813k) this.instance).T();
    }

    public String getFromAgentId() {
        return ((C1813k) this.instance).U();
    }

    public ByteString getFromAgentIdBytes() {
        return ((C1813k) this.instance).V();
    }

    @Deprecated
    public Map<String, String> getMetadata() {
        return getMetadataMap();
    }

    public int getMetadataCount() {
        return ((C1813k) this.instance).W().size();
    }

    public Map<String, String> getMetadataMap() {
        return Collections.unmodifiableMap(((C1813k) this.instance).W());
    }

    public String getMetadataOrDefault(String str, String str2) {
        str.getClass();
        Map mapW = ((C1813k) this.instance).W();
        return mapW.containsKey(str) ? (String) mapW.get(str) : str2;
    }

    public String getMetadataOrThrow(String str) {
        str.getClass();
        Map mapW = ((C1813k) this.instance).W();
        if (mapW.containsKey(str)) {
            return (String) mapW.get(str);
        }
        throw new IllegalArgumentException();
    }

    public String getSessionId() {
        return ((C1813k) this.instance).X();
    }

    public ByteString getSessionIdBytes() {
        return ((C1813k) this.instance).Y();
    }

    public boolean getSuccess() {
        return ((C1813k) this.instance).Z();
    }

    public String getToAgentId() {
        return ((C1813k) this.instance).a0();
    }

    public ByteString getToAgentIdBytes() {
        return ((C1813k) this.instance).b0();
    }

    public HandoffPostHookData$Builder putAllMetadata(Map<String, String> map) {
        copyOnWrite();
        C1813k.I((C1813k) this.instance).putAll(map);
        return this;
    }

    public HandoffPostHookData$Builder putMetadata(String str, String str2) {
        str.getClass();
        str2.getClass();
        copyOnWrite();
        C1813k.I((C1813k) this.instance).put(str, str2);
        return this;
    }

    public HandoffPostHookData$Builder removeMetadata(String str) {
        str.getClass();
        copyOnWrite();
        C1813k.I((C1813k) this.instance).remove(str);
        return this;
    }

    public HandoffPostHookData$Builder setDurationMs(long j5) {
        copyOnWrite();
        C1813k.J((C1813k) this.instance, j5);
        return this;
    }

    public HandoffPostHookData$Builder setFromAgentId(String str) {
        copyOnWrite();
        C1813k.K((C1813k) this.instance, str);
        return this;
    }

    public HandoffPostHookData$Builder setFromAgentIdBytes(ByteString byteString) {
        copyOnWrite();
        C1813k.L((C1813k) this.instance, byteString);
        return this;
    }

    public HandoffPostHookData$Builder setSessionId(String str) {
        copyOnWrite();
        C1813k.M((C1813k) this.instance, str);
        return this;
    }

    public HandoffPostHookData$Builder setSessionIdBytes(ByteString byteString) {
        copyOnWrite();
        C1813k.N((C1813k) this.instance, byteString);
        return this;
    }

    public HandoffPostHookData$Builder setSuccess(boolean z10) {
        copyOnWrite();
        C1813k.O((C1813k) this.instance, z10);
        return this;
    }

    public HandoffPostHookData$Builder setToAgentId(String str) {
        copyOnWrite();
        C1813k.P((C1813k) this.instance, str);
        return this;
    }

    public HandoffPostHookData$Builder setToAgentIdBytes(ByteString byteString) {
        copyOnWrite();
        C1813k.Q((C1813k) this.instance, byteString);
        return this;
    }

    private HandoffPostHookData$Builder() {
        super(C1813k.DEFAULT_INSTANCE);
    }
}
