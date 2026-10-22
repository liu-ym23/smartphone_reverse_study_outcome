package com.zyql.protobuf.skull;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import java.util.Collections;
import java.util.Map;
import v7.q;

/* loaded from: classes2.dex */
public final class TaskContext$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ TaskContext$Builder(int i) {
        this();
    }

    public TaskContext$Builder clearContextId() {
        copyOnWrite();
        q.D((q) this.instance);
        return this;
    }

    public TaskContext$Builder clearMeta() {
        copyOnWrite();
        q.F((q) this.instance).clear();
        return this;
    }

    public TaskContext$Builder clearSessionId() {
        copyOnWrite();
        q.E((q) this.instance);
        return this;
    }

    public boolean containsMeta(String str) {
        str.getClass();
        return ((q) this.instance).O().containsKey(str);
    }

    public String getContextId() {
        return ((q) this.instance).L();
    }

    public ByteString getContextIdBytes() {
        return ((q) this.instance).M();
    }

    @Deprecated
    public Map<String, String> getMeta() {
        return getMetaMap();
    }

    public int getMetaCount() {
        return ((q) this.instance).O().size();
    }

    public Map<String, String> getMetaMap() {
        return Collections.unmodifiableMap(((q) this.instance).O());
    }

    public String getMetaOrDefault(String str, String str2) {
        str.getClass();
        Map mapO = ((q) this.instance).O();
        return mapO.containsKey(str) ? (String) mapO.get(str) : str2;
    }

    public String getMetaOrThrow(String str) {
        str.getClass();
        Map mapO = ((q) this.instance).O();
        if (mapO.containsKey(str)) {
            return (String) mapO.get(str);
        }
        throw new IllegalArgumentException();
    }

    public String getSessionId() {
        return ((q) this.instance).P();
    }

    public ByteString getSessionIdBytes() {
        return ((q) this.instance).Q();
    }

    public TaskContext$Builder putAllMeta(Map<String, String> map) {
        copyOnWrite();
        q.F((q) this.instance).putAll(map);
        return this;
    }

    public TaskContext$Builder putMeta(String str, String str2) {
        str.getClass();
        str2.getClass();
        copyOnWrite();
        q.F((q) this.instance).put(str, str2);
        return this;
    }

    public TaskContext$Builder removeMeta(String str) {
        str.getClass();
        copyOnWrite();
        q.F((q) this.instance).remove(str);
        return this;
    }

    public TaskContext$Builder setContextId(String str) {
        copyOnWrite();
        q.G((q) this.instance, str);
        return this;
    }

    public TaskContext$Builder setContextIdBytes(ByteString byteString) {
        copyOnWrite();
        q.H((q) this.instance, byteString);
        return this;
    }

    public TaskContext$Builder setSessionId(String str) {
        copyOnWrite();
        q.I((q) this.instance, str);
        return this;
    }

    public TaskContext$Builder setSessionIdBytes(ByteString byteString) {
        copyOnWrite();
        q.J((q) this.instance, byteString);
        return this;
    }

    private TaskContext$Builder() {
        super(q.DEFAULT_INSTANCE);
    }
}
