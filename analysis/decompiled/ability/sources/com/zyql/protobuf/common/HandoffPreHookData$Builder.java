package com.zyql.protobuf.common;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import java.util.Collections;
import java.util.Map;
import q7.C1815m;

/* loaded from: classes2.dex */
public final class HandoffPreHookData$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ HandoffPreHookData$Builder(int i) {
        this();
    }

    public HandoffPreHookData$Builder clearContext() {
        copyOnWrite();
        C1815m.H((C1815m) this.instance).clear();
        return this;
    }

    public HandoffPreHookData$Builder clearFromAgentId() {
        copyOnWrite();
        C1815m.D((C1815m) this.instance);
        return this;
    }

    public HandoffPreHookData$Builder clearReason() {
        copyOnWrite();
        C1815m.E((C1815m) this.instance);
        return this;
    }

    public HandoffPreHookData$Builder clearSessionId() {
        copyOnWrite();
        C1815m.F((C1815m) this.instance);
        return this;
    }

    public HandoffPreHookData$Builder clearToAgentId() {
        copyOnWrite();
        C1815m.G((C1815m) this.instance);
        return this;
    }

    public boolean containsContext(String str) {
        str.getClass();
        return ((C1815m) this.instance).R().containsKey(str);
    }

    @Deprecated
    public Map<String, String> getContext() {
        return getContextMap();
    }

    public int getContextCount() {
        return ((C1815m) this.instance).R().size();
    }

    public Map<String, String> getContextMap() {
        return Collections.unmodifiableMap(((C1815m) this.instance).R());
    }

    public String getContextOrDefault(String str, String str2) {
        str.getClass();
        Map mapR = ((C1815m) this.instance).R();
        return mapR.containsKey(str) ? (String) mapR.get(str) : str2;
    }

    public String getContextOrThrow(String str) {
        str.getClass();
        Map mapR = ((C1815m) this.instance).R();
        if (mapR.containsKey(str)) {
            return (String) mapR.get(str);
        }
        throw new IllegalArgumentException();
    }

    public String getFromAgentId() {
        return ((C1815m) this.instance).T();
    }

    public ByteString getFromAgentIdBytes() {
        return ((C1815m) this.instance).U();
    }

    public String getReason() {
        return ((C1815m) this.instance).V();
    }

    public ByteString getReasonBytes() {
        return ((C1815m) this.instance).W();
    }

    public String getSessionId() {
        return ((C1815m) this.instance).X();
    }

    public ByteString getSessionIdBytes() {
        return ((C1815m) this.instance).Y();
    }

    public String getToAgentId() {
        return ((C1815m) this.instance).Z();
    }

    public ByteString getToAgentIdBytes() {
        return ((C1815m) this.instance).a0();
    }

    public HandoffPreHookData$Builder putAllContext(Map<String, String> map) {
        copyOnWrite();
        C1815m.H((C1815m) this.instance).putAll(map);
        return this;
    }

    public HandoffPreHookData$Builder putContext(String str, String str2) {
        str.getClass();
        str2.getClass();
        copyOnWrite();
        C1815m.H((C1815m) this.instance).put(str, str2);
        return this;
    }

    public HandoffPreHookData$Builder removeContext(String str) {
        str.getClass();
        copyOnWrite();
        C1815m.H((C1815m) this.instance).remove(str);
        return this;
    }

    public HandoffPreHookData$Builder setFromAgentId(String str) {
        copyOnWrite();
        C1815m.I((C1815m) this.instance, str);
        return this;
    }

    public HandoffPreHookData$Builder setFromAgentIdBytes(ByteString byteString) {
        copyOnWrite();
        C1815m.J((C1815m) this.instance, byteString);
        return this;
    }

    public HandoffPreHookData$Builder setReason(String str) {
        copyOnWrite();
        C1815m.K((C1815m) this.instance, str);
        return this;
    }

    public HandoffPreHookData$Builder setReasonBytes(ByteString byteString) {
        copyOnWrite();
        C1815m.L((C1815m) this.instance, byteString);
        return this;
    }

    public HandoffPreHookData$Builder setSessionId(String str) {
        copyOnWrite();
        C1815m.M((C1815m) this.instance, str);
        return this;
    }

    public HandoffPreHookData$Builder setSessionIdBytes(ByteString byteString) {
        copyOnWrite();
        C1815m.N((C1815m) this.instance, byteString);
        return this;
    }

    public HandoffPreHookData$Builder setToAgentId(String str) {
        copyOnWrite();
        C1815m.O((C1815m) this.instance, str);
        return this;
    }

    public HandoffPreHookData$Builder setToAgentIdBytes(ByteString byteString) {
        copyOnWrite();
        C1815m.P((C1815m) this.instance, byteString);
        return this;
    }

    private HandoffPreHookData$Builder() {
        super(C1815m.DEFAULT_INSTANCE);
    }
}
