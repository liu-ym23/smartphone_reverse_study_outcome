package com.zyql.protobuf.common;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import java.util.Collections;
import java.util.Map;
import q7.K;

/* loaded from: classes2.dex */
public final class SessionEndHookData$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ SessionEndHookData$Builder(int i) {
        this();
    }

    public SessionEndHookData$Builder clearDurationMs() {
        copyOnWrite();
        K.D((K) this.instance);
        return this;
    }

    public SessionEndHookData$Builder clearMessageCount() {
        copyOnWrite();
        K.E((K) this.instance);
        return this;
    }

    public SessionEndHookData$Builder clearMetadata() {
        copyOnWrite();
        K.H((K) this.instance).clear();
        return this;
    }

    public SessionEndHookData$Builder clearReason() {
        copyOnWrite();
        K.F((K) this.instance);
        return this;
    }

    public SessionEndHookData$Builder clearSessionId() {
        copyOnWrite();
        K.G((K) this.instance);
        return this;
    }

    public boolean containsMetadata(String str) {
        str.getClass();
        return ((K) this.instance).S().containsKey(str);
    }

    public long getDurationMs() {
        return ((K) this.instance).Q();
    }

    public int getMessageCount() {
        return ((K) this.instance).R();
    }

    @Deprecated
    public Map<String, String> getMetadata() {
        return getMetadataMap();
    }

    public int getMetadataCount() {
        return ((K) this.instance).S().size();
    }

    public Map<String, String> getMetadataMap() {
        return Collections.unmodifiableMap(((K) this.instance).S());
    }

    public String getMetadataOrDefault(String str, String str2) {
        str.getClass();
        Map mapS = ((K) this.instance).S();
        return mapS.containsKey(str) ? (String) mapS.get(str) : str2;
    }

    public String getMetadataOrThrow(String str) {
        str.getClass();
        Map mapS = ((K) this.instance).S();
        if (mapS.containsKey(str)) {
            return (String) mapS.get(str);
        }
        throw new IllegalArgumentException();
    }

    public String getReason() {
        return ((K) this.instance).T();
    }

    public ByteString getReasonBytes() {
        return ((K) this.instance).U();
    }

    public String getSessionId() {
        return ((K) this.instance).V();
    }

    public ByteString getSessionIdBytes() {
        return ((K) this.instance).W();
    }

    public SessionEndHookData$Builder putAllMetadata(Map<String, String> map) {
        copyOnWrite();
        K.H((K) this.instance).putAll(map);
        return this;
    }

    public SessionEndHookData$Builder putMetadata(String str, String str2) {
        str.getClass();
        str2.getClass();
        copyOnWrite();
        K.H((K) this.instance).put(str, str2);
        return this;
    }

    public SessionEndHookData$Builder removeMetadata(String str) {
        str.getClass();
        copyOnWrite();
        K.H((K) this.instance).remove(str);
        return this;
    }

    public SessionEndHookData$Builder setDurationMs(long j5) {
        copyOnWrite();
        K.I((K) this.instance, j5);
        return this;
    }

    public SessionEndHookData$Builder setMessageCount(int i) {
        copyOnWrite();
        K.J((K) this.instance, i);
        return this;
    }

    public SessionEndHookData$Builder setReason(String str) {
        copyOnWrite();
        K.K((K) this.instance, str);
        return this;
    }

    public SessionEndHookData$Builder setReasonBytes(ByteString byteString) {
        copyOnWrite();
        K.L((K) this.instance, byteString);
        return this;
    }

    public SessionEndHookData$Builder setSessionId(String str) {
        copyOnWrite();
        K.M((K) this.instance, str);
        return this;
    }

    public SessionEndHookData$Builder setSessionIdBytes(ByteString byteString) {
        copyOnWrite();
        K.N((K) this.instance, byteString);
        return this;
    }

    private SessionEndHookData$Builder() {
        super(K.DEFAULT_INSTANCE);
    }
}
