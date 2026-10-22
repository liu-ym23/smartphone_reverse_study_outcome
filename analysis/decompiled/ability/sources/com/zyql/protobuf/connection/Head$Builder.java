package com.zyql.protobuf.connection;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import java.util.Collections;
import java.util.Map;
import r7.f;

/* loaded from: classes2.dex */
public final class Head$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ Head$Builder(int i) {
        this();
    }

    public Head$Builder clearCommand() {
        copyOnWrite();
        f.D((f) this.instance);
        return this;
    }

    public Head$Builder clearFrameType() {
        copyOnWrite();
        f.E((f) this.instance);
        return this;
    }

    public Head$Builder clearMeta() {
        copyOnWrite();
        f.I((f) this.instance).clear();
        return this;
    }

    public Head$Builder clearModule() {
        copyOnWrite();
        f.F((f) this.instance);
        return this;
    }

    public Head$Builder clearMsgId() {
        copyOnWrite();
        f.G((f) this.instance);
        return this;
    }

    public Head$Builder clearMsgType() {
        copyOnWrite();
        f.H((f) this.instance);
        return this;
    }

    public boolean containsMeta(String str) {
        str.getClass();
        return ((f) this.instance).X().containsKey(str);
    }

    public String getCommand() {
        return ((f) this.instance).T();
    }

    public ByteString getCommandBytes() {
        return ((f) this.instance).U();
    }

    public int getFrameType() {
        return ((f) this.instance).W();
    }

    @Deprecated
    public Map<String, String> getMeta() {
        return getMetaMap();
    }

    public int getMetaCount() {
        return ((f) this.instance).X().size();
    }

    public Map<String, String> getMetaMap() {
        return Collections.unmodifiableMap(((f) this.instance).X());
    }

    public String getMetaOrDefault(String str, String str2) {
        str.getClass();
        Map mapX = ((f) this.instance).X();
        return mapX.containsKey(str) ? (String) mapX.get(str) : str2;
    }

    public String getMetaOrThrow(String str) {
        str.getClass();
        Map mapX = ((f) this.instance).X();
        if (mapX.containsKey(str)) {
            return (String) mapX.get(str);
        }
        throw new IllegalArgumentException();
    }

    public String getModule() {
        return ((f) this.instance).Z();
    }

    public ByteString getModuleBytes() {
        return ((f) this.instance).a0();
    }

    public String getMsgId() {
        return ((f) this.instance).b0();
    }

    public ByteString getMsgIdBytes() {
        return ((f) this.instance).c0();
    }

    public int getMsgType() {
        return ((f) this.instance).d0();
    }

    public Head$Builder putAllMeta(Map<String, String> map) {
        copyOnWrite();
        f.I((f) this.instance).putAll(map);
        return this;
    }

    public Head$Builder putMeta(String str, String str2) {
        str.getClass();
        str2.getClass();
        copyOnWrite();
        f.I((f) this.instance).put(str, str2);
        return this;
    }

    public Head$Builder removeMeta(String str) {
        str.getClass();
        copyOnWrite();
        f.I((f) this.instance).remove(str);
        return this;
    }

    public Head$Builder setCommand(String str) {
        copyOnWrite();
        f.J((f) this.instance, str);
        return this;
    }

    public Head$Builder setCommandBytes(ByteString byteString) {
        copyOnWrite();
        f.K((f) this.instance, byteString);
        return this;
    }

    public Head$Builder setFrameType(int i) {
        copyOnWrite();
        f.L((f) this.instance, i);
        return this;
    }

    public Head$Builder setModule(String str) {
        copyOnWrite();
        f.M((f) this.instance, str);
        return this;
    }

    public Head$Builder setModuleBytes(ByteString byteString) {
        copyOnWrite();
        f.N((f) this.instance, byteString);
        return this;
    }

    public Head$Builder setMsgId(String str) {
        copyOnWrite();
        f.O((f) this.instance, str);
        return this;
    }

    public Head$Builder setMsgIdBytes(ByteString byteString) {
        copyOnWrite();
        f.P((f) this.instance, byteString);
        return this;
    }

    public Head$Builder setMsgType(int i) {
        copyOnWrite();
        f.Q((f) this.instance, i);
        return this;
    }

    private Head$Builder() {
        super(f.DEFAULT_INSTANCE);
    }
}
