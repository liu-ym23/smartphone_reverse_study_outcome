package com.zyql.protobuf.omni;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import com.zyql.protobuf.skull.Message$Builder;
import java.util.Collections;
import java.util.Map;
import t7.C2020c;
import t7.h;
import v7.i;

/* loaded from: classes2.dex */
public final class ChatRequest$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ ChatRequest$Builder(int i) {
        this();
    }

    public ChatRequest$Builder clearAudio() {
        copyOnWrite();
        h.D((h) this.instance);
        return this;
    }

    public ChatRequest$Builder clearChatId() {
        copyOnWrite();
        h.E((h) this.instance);
        return this;
    }

    public ChatRequest$Builder clearEventId() {
        copyOnWrite();
        h.F((h) this.instance);
        return this;
    }

    public ChatRequest$Builder clearIsMock() {
        copyOnWrite();
        h.G((h) this.instance);
        return this;
    }

    public ChatRequest$Builder clearMessage() {
        copyOnWrite();
        h.H((h) this.instance);
        return this;
    }

    public ChatRequest$Builder clearMeta() {
        copyOnWrite();
        h.K((h) this.instance).clear();
        return this;
    }

    public ChatRequest$Builder clearNeedTts() {
        copyOnWrite();
        h.I((h) this.instance);
        return this;
    }

    public ChatRequest$Builder clearTaskId() {
        copyOnWrite();
        h.J((h) this.instance);
        return this;
    }

    public boolean containsMeta(String str) {
        str.getClass();
        return ((h) this.instance).f0().containsKey(str);
    }

    public C2020c getAudio() {
        return ((h) this.instance).Y();
    }

    public String getChatId() {
        return ((h) this.instance).Z();
    }

    public ByteString getChatIdBytes() {
        return ((h) this.instance).a0();
    }

    public String getEventId() {
        return ((h) this.instance).b0();
    }

    public ByteString getEventIdBytes() {
        return ((h) this.instance).c0();
    }

    public boolean getIsMock() {
        return ((h) this.instance).d0();
    }

    public i getMessage() {
        return ((h) this.instance).e0();
    }

    @Deprecated
    public Map<String, String> getMeta() {
        return getMetaMap();
    }

    public int getMetaCount() {
        return ((h) this.instance).f0().size();
    }

    public Map<String, String> getMetaMap() {
        return Collections.unmodifiableMap(((h) this.instance).f0());
    }

    public String getMetaOrDefault(String str, String str2) {
        str.getClass();
        Map mapF0 = ((h) this.instance).f0();
        return mapF0.containsKey(str) ? (String) mapF0.get(str) : str2;
    }

    public String getMetaOrThrow(String str) {
        str.getClass();
        Map mapF0 = ((h) this.instance).f0();
        if (mapF0.containsKey(str)) {
            return (String) mapF0.get(str);
        }
        throw new IllegalArgumentException();
    }

    public boolean getNeedTts() {
        return ((h) this.instance).g0();
    }

    public String getTaskId() {
        return ((h) this.instance).h0();
    }

    public ByteString getTaskIdBytes() {
        return ((h) this.instance).i0();
    }

    public boolean hasAudio() {
        return ((h) this.instance).j0();
    }

    public boolean hasMessage() {
        return ((h) this.instance).k0();
    }

    public ChatRequest$Builder mergeAudio(C2020c c2020c) {
        copyOnWrite();
        h.L((h) this.instance, c2020c);
        return this;
    }

    public ChatRequest$Builder mergeMessage(i iVar) {
        copyOnWrite();
        h.M((h) this.instance, iVar);
        return this;
    }

    public ChatRequest$Builder putAllMeta(Map<String, String> map) {
        copyOnWrite();
        h.K((h) this.instance).putAll(map);
        return this;
    }

    public ChatRequest$Builder putMeta(String str, String str2) {
        str.getClass();
        str2.getClass();
        copyOnWrite();
        h.K((h) this.instance).put(str, str2);
        return this;
    }

    public ChatRequest$Builder removeMeta(String str) {
        str.getClass();
        copyOnWrite();
        h.K((h) this.instance).remove(str);
        return this;
    }

    public ChatRequest$Builder setAudio(C2020c c2020c) {
        copyOnWrite();
        h.N((h) this.instance, c2020c);
        return this;
    }

    public ChatRequest$Builder setChatId(String str) {
        copyOnWrite();
        h.O((h) this.instance, str);
        return this;
    }

    public ChatRequest$Builder setChatIdBytes(ByteString byteString) {
        copyOnWrite();
        h.P((h) this.instance, byteString);
        return this;
    }

    public ChatRequest$Builder setEventId(String str) {
        copyOnWrite();
        h.Q((h) this.instance, str);
        return this;
    }

    public ChatRequest$Builder setEventIdBytes(ByteString byteString) {
        copyOnWrite();
        h.R((h) this.instance, byteString);
        return this;
    }

    public ChatRequest$Builder setIsMock(boolean z10) {
        copyOnWrite();
        h.S((h) this.instance, z10);
        return this;
    }

    public ChatRequest$Builder setMessage(i iVar) {
        copyOnWrite();
        h.T((h) this.instance, iVar);
        return this;
    }

    public ChatRequest$Builder setNeedTts(boolean z10) {
        copyOnWrite();
        h.U((h) this.instance, z10);
        return this;
    }

    public ChatRequest$Builder setTaskId(String str) {
        copyOnWrite();
        h.V((h) this.instance, str);
        return this;
    }

    public ChatRequest$Builder setTaskIdBytes(ByteString byteString) {
        copyOnWrite();
        h.W((h) this.instance, byteString);
        return this;
    }

    private ChatRequest$Builder() {
        super(h.DEFAULT_INSTANCE);
    }

    public ChatRequest$Builder setAudio(Audio$Builder audio$Builder) {
        copyOnWrite();
        h.N((h) this.instance, (C2020c) audio$Builder.k());
        return this;
    }

    public ChatRequest$Builder setMessage(Message$Builder message$Builder) {
        copyOnWrite();
        h.T((h) this.instance, (i) message$Builder.k());
        return this;
    }
}
