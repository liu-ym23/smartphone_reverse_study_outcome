package com.zyql.protobuf.common;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import java.util.Collections;
import java.util.Map;
import q7.M;

/* loaded from: classes2.dex */
public final class SessionStartHookData$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ SessionStartHookData$Builder(int i) {
        this();
    }

    public SessionStartHookData$Builder clearAgentId() {
        copyOnWrite();
        M.D((M) this.instance);
        return this;
    }

    public SessionStartHookData$Builder clearAppId() {
        copyOnWrite();
        M.E((M) this.instance);
        return this;
    }

    public SessionStartHookData$Builder clearCreatedAt() {
        copyOnWrite();
        M.F((M) this.instance);
        return this;
    }

    public SessionStartHookData$Builder clearMetadata() {
        copyOnWrite();
        M.I((M) this.instance).clear();
        return this;
    }

    public SessionStartHookData$Builder clearSessionId() {
        copyOnWrite();
        M.G((M) this.instance);
        return this;
    }

    public SessionStartHookData$Builder clearUserId() {
        copyOnWrite();
        M.H((M) this.instance);
        return this;
    }

    public boolean containsMetadata(String str) {
        str.getClass();
        return ((M) this.instance).Z().containsKey(str);
    }

    public String getAgentId() {
        return ((M) this.instance).T();
    }

    public ByteString getAgentIdBytes() {
        return ((M) this.instance).U();
    }

    public String getAppId() {
        return ((M) this.instance).V();
    }

    public ByteString getAppIdBytes() {
        return ((M) this.instance).W();
    }

    public long getCreatedAt() {
        return ((M) this.instance).X();
    }

    @Deprecated
    public Map<String, String> getMetadata() {
        return getMetadataMap();
    }

    public int getMetadataCount() {
        return ((M) this.instance).Z().size();
    }

    public Map<String, String> getMetadataMap() {
        return Collections.unmodifiableMap(((M) this.instance).Z());
    }

    public String getMetadataOrDefault(String str, String str2) {
        str.getClass();
        Map mapZ = ((M) this.instance).Z();
        return mapZ.containsKey(str) ? (String) mapZ.get(str) : str2;
    }

    public String getMetadataOrThrow(String str) {
        str.getClass();
        Map mapZ = ((M) this.instance).Z();
        if (mapZ.containsKey(str)) {
            return (String) mapZ.get(str);
        }
        throw new IllegalArgumentException();
    }

    public String getSessionId() {
        return ((M) this.instance).a0();
    }

    public ByteString getSessionIdBytes() {
        return ((M) this.instance).b0();
    }

    public String getUserId() {
        return ((M) this.instance).c0();
    }

    public ByteString getUserIdBytes() {
        return ((M) this.instance).d0();
    }

    public SessionStartHookData$Builder putAllMetadata(Map<String, String> map) {
        copyOnWrite();
        M.I((M) this.instance).putAll(map);
        return this;
    }

    public SessionStartHookData$Builder putMetadata(String str, String str2) {
        str.getClass();
        str2.getClass();
        copyOnWrite();
        M.I((M) this.instance).put(str, str2);
        return this;
    }

    public SessionStartHookData$Builder removeMetadata(String str) {
        str.getClass();
        copyOnWrite();
        M.I((M) this.instance).remove(str);
        return this;
    }

    public SessionStartHookData$Builder setAgentId(String str) {
        copyOnWrite();
        M.J((M) this.instance, str);
        return this;
    }

    public SessionStartHookData$Builder setAgentIdBytes(ByteString byteString) {
        copyOnWrite();
        M.K((M) this.instance, byteString);
        return this;
    }

    public SessionStartHookData$Builder setAppId(String str) {
        copyOnWrite();
        M.L((M) this.instance, str);
        return this;
    }

    public SessionStartHookData$Builder setAppIdBytes(ByteString byteString) {
        copyOnWrite();
        M.M((M) this.instance, byteString);
        return this;
    }

    public SessionStartHookData$Builder setCreatedAt(long j5) {
        copyOnWrite();
        M.N((M) this.instance, j5);
        return this;
    }

    public SessionStartHookData$Builder setSessionId(String str) {
        copyOnWrite();
        M.O((M) this.instance, str);
        return this;
    }

    public SessionStartHookData$Builder setSessionIdBytes(ByteString byteString) {
        copyOnWrite();
        M.P((M) this.instance, byteString);
        return this;
    }

    public SessionStartHookData$Builder setUserId(String str) {
        copyOnWrite();
        M.Q((M) this.instance, str);
        return this;
    }

    public SessionStartHookData$Builder setUserIdBytes(ByteString byteString) {
        copyOnWrite();
        M.R((M) this.instance, byteString);
        return this;
    }

    private SessionStartHookData$Builder() {
        super(M.DEFAULT_INSTANCE);
    }
}
