package com.zyql.protobuf.common;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import java.util.Collections;
import java.util.Map;
import q7.B;

/* loaded from: classes2.dex */
public final class MessagePreHookData$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ MessagePreHookData$Builder(int i) {
        this();
    }

    public MessagePreHookData$Builder clearAgentId() {
        copyOnWrite();
        B.D((B) this.instance);
        return this;
    }

    public MessagePreHookData$Builder clearContent() {
        copyOnWrite();
        B.E((B) this.instance);
        return this;
    }

    public MessagePreHookData$Builder clearMetadata() {
        copyOnWrite();
        B.H((B) this.instance).clear();
        return this;
    }

    public MessagePreHookData$Builder clearRole() {
        copyOnWrite();
        B.F((B) this.instance);
        return this;
    }

    public MessagePreHookData$Builder clearSessionId() {
        copyOnWrite();
        B.G((B) this.instance);
        return this;
    }

    public boolean containsMetadata(String str) {
        str.getClass();
        return ((B) this.instance).W().containsKey(str);
    }

    public String getAgentId() {
        return ((B) this.instance).R();
    }

    public ByteString getAgentIdBytes() {
        return ((B) this.instance).S();
    }

    public String getContent() {
        return ((B) this.instance).T();
    }

    public ByteString getContentBytes() {
        return ((B) this.instance).U();
    }

    @Deprecated
    public Map<String, String> getMetadata() {
        return getMetadataMap();
    }

    public int getMetadataCount() {
        return ((B) this.instance).W().size();
    }

    public Map<String, String> getMetadataMap() {
        return Collections.unmodifiableMap(((B) this.instance).W());
    }

    public String getMetadataOrDefault(String str, String str2) {
        str.getClass();
        Map mapW = ((B) this.instance).W();
        return mapW.containsKey(str) ? (String) mapW.get(str) : str2;
    }

    public String getMetadataOrThrow(String str) {
        str.getClass();
        Map mapW = ((B) this.instance).W();
        if (mapW.containsKey(str)) {
            return (String) mapW.get(str);
        }
        throw new IllegalArgumentException();
    }

    public String getRole() {
        return ((B) this.instance).X();
    }

    public ByteString getRoleBytes() {
        return ((B) this.instance).Y();
    }

    public String getSessionId() {
        return ((B) this.instance).Z();
    }

    public ByteString getSessionIdBytes() {
        return ((B) this.instance).a0();
    }

    public MessagePreHookData$Builder putAllMetadata(Map<String, String> map) {
        copyOnWrite();
        B.H((B) this.instance).putAll(map);
        return this;
    }

    public MessagePreHookData$Builder putMetadata(String str, String str2) {
        str.getClass();
        str2.getClass();
        copyOnWrite();
        B.H((B) this.instance).put(str, str2);
        return this;
    }

    public MessagePreHookData$Builder removeMetadata(String str) {
        str.getClass();
        copyOnWrite();
        B.H((B) this.instance).remove(str);
        return this;
    }

    public MessagePreHookData$Builder setAgentId(String str) {
        copyOnWrite();
        B.I((B) this.instance, str);
        return this;
    }

    public MessagePreHookData$Builder setAgentIdBytes(ByteString byteString) {
        copyOnWrite();
        B.J((B) this.instance, byteString);
        return this;
    }

    public MessagePreHookData$Builder setContent(String str) {
        copyOnWrite();
        B.K((B) this.instance, str);
        return this;
    }

    public MessagePreHookData$Builder setContentBytes(ByteString byteString) {
        copyOnWrite();
        B.L((B) this.instance, byteString);
        return this;
    }

    public MessagePreHookData$Builder setRole(String str) {
        copyOnWrite();
        B.M((B) this.instance, str);
        return this;
    }

    public MessagePreHookData$Builder setRoleBytes(ByteString byteString) {
        copyOnWrite();
        B.N((B) this.instance, byteString);
        return this;
    }

    public MessagePreHookData$Builder setSessionId(String str) {
        copyOnWrite();
        B.O((B) this.instance, str);
        return this;
    }

    public MessagePreHookData$Builder setSessionIdBytes(ByteString byteString) {
        copyOnWrite();
        B.P((B) this.instance, byteString);
        return this;
    }

    private MessagePreHookData$Builder() {
        super(B.DEFAULT_INSTANCE);
    }
}
