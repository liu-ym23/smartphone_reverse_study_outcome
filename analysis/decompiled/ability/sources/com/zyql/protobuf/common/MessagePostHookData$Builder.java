package com.zyql.protobuf.common;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import java.util.Collections;
import java.util.Map;
import q7.C1827z;

/* loaded from: classes2.dex */
public final class MessagePostHookData$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ MessagePostHookData$Builder(int i) {
        this();
    }

    public MessagePostHookData$Builder clearAgentId() {
        copyOnWrite();
        C1827z.D((C1827z) this.instance);
        return this;
    }

    public MessagePostHookData$Builder clearContent() {
        copyOnWrite();
        C1827z.E((C1827z) this.instance);
        return this;
    }

    public MessagePostHookData$Builder clearDurationMs() {
        copyOnWrite();
        C1827z.F((C1827z) this.instance);
        return this;
    }

    public MessagePostHookData$Builder clearMetadata() {
        copyOnWrite();
        C1827z.J((C1827z) this.instance).clear();
        return this;
    }

    public MessagePostHookData$Builder clearRole() {
        copyOnWrite();
        C1827z.G((C1827z) this.instance);
        return this;
    }

    public MessagePostHookData$Builder clearSessionId() {
        copyOnWrite();
        C1827z.H((C1827z) this.instance);
        return this;
    }

    public MessagePostHookData$Builder clearSuccess() {
        copyOnWrite();
        C1827z.I((C1827z) this.instance);
        return this;
    }

    public boolean containsMetadata(String str) {
        str.getClass();
        return ((C1827z) this.instance).b0().containsKey(str);
    }

    public String getAgentId() {
        return ((C1827z) this.instance).V();
    }

    public ByteString getAgentIdBytes() {
        return ((C1827z) this.instance).W();
    }

    public String getContent() {
        return ((C1827z) this.instance).X();
    }

    public ByteString getContentBytes() {
        return ((C1827z) this.instance).Y();
    }

    public long getDurationMs() {
        return ((C1827z) this.instance).a0();
    }

    @Deprecated
    public Map<String, String> getMetadata() {
        return getMetadataMap();
    }

    public int getMetadataCount() {
        return ((C1827z) this.instance).b0().size();
    }

    public Map<String, String> getMetadataMap() {
        return Collections.unmodifiableMap(((C1827z) this.instance).b0());
    }

    public String getMetadataOrDefault(String str, String str2) {
        str.getClass();
        Map mapB0 = ((C1827z) this.instance).b0();
        return mapB0.containsKey(str) ? (String) mapB0.get(str) : str2;
    }

    public String getMetadataOrThrow(String str) {
        str.getClass();
        Map mapB0 = ((C1827z) this.instance).b0();
        if (mapB0.containsKey(str)) {
            return (String) mapB0.get(str);
        }
        throw new IllegalArgumentException();
    }

    public String getRole() {
        return ((C1827z) this.instance).c0();
    }

    public ByteString getRoleBytes() {
        return ((C1827z) this.instance).d0();
    }

    public String getSessionId() {
        return ((C1827z) this.instance).e0();
    }

    public ByteString getSessionIdBytes() {
        return ((C1827z) this.instance).f0();
    }

    public boolean getSuccess() {
        return ((C1827z) this.instance).g0();
    }

    public MessagePostHookData$Builder putAllMetadata(Map<String, String> map) {
        copyOnWrite();
        C1827z.J((C1827z) this.instance).putAll(map);
        return this;
    }

    public MessagePostHookData$Builder putMetadata(String str, String str2) {
        str.getClass();
        str2.getClass();
        copyOnWrite();
        C1827z.J((C1827z) this.instance).put(str, str2);
        return this;
    }

    public MessagePostHookData$Builder removeMetadata(String str) {
        str.getClass();
        copyOnWrite();
        C1827z.J((C1827z) this.instance).remove(str);
        return this;
    }

    public MessagePostHookData$Builder setAgentId(String str) {
        copyOnWrite();
        C1827z.K((C1827z) this.instance, str);
        return this;
    }

    public MessagePostHookData$Builder setAgentIdBytes(ByteString byteString) {
        copyOnWrite();
        C1827z.L((C1827z) this.instance, byteString);
        return this;
    }

    public MessagePostHookData$Builder setContent(String str) {
        copyOnWrite();
        C1827z.M((C1827z) this.instance, str);
        return this;
    }

    public MessagePostHookData$Builder setContentBytes(ByteString byteString) {
        copyOnWrite();
        C1827z.N((C1827z) this.instance, byteString);
        return this;
    }

    public MessagePostHookData$Builder setDurationMs(long j5) {
        copyOnWrite();
        C1827z.O((C1827z) this.instance, j5);
        return this;
    }

    public MessagePostHookData$Builder setRole(String str) {
        copyOnWrite();
        C1827z.P((C1827z) this.instance, str);
        return this;
    }

    public MessagePostHookData$Builder setRoleBytes(ByteString byteString) {
        copyOnWrite();
        C1827z.Q((C1827z) this.instance, byteString);
        return this;
    }

    public MessagePostHookData$Builder setSessionId(String str) {
        copyOnWrite();
        C1827z.R((C1827z) this.instance, str);
        return this;
    }

    public MessagePostHookData$Builder setSessionIdBytes(ByteString byteString) {
        copyOnWrite();
        C1827z.S((C1827z) this.instance, byteString);
        return this;
    }

    public MessagePostHookData$Builder setSuccess(boolean z10) {
        copyOnWrite();
        C1827z.T((C1827z) this.instance, z10);
        return this;
    }

    private MessagePostHookData$Builder() {
        super(C1827z.DEFAULT_INSTANCE);
    }
}
