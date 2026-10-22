package com.zyql.protobuf.skull;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import java.util.Collections;
import java.util.Map;
import v7.u;

/* loaded from: classes2.dex */
public final class Tool$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ Tool$Builder(int i) {
        this();
    }

    public Tool$Builder clearDescription() {
        copyOnWrite();
        u.D((u) this.instance);
        return this;
    }

    public Tool$Builder clearId() {
        copyOnWrite();
        u.E((u) this.instance);
        return this;
    }

    public Tool$Builder clearName() {
        copyOnWrite();
        u.F((u) this.instance);
        return this;
    }

    public Tool$Builder clearParameters() {
        copyOnWrite();
        u.H((u) this.instance).clear();
        return this;
    }

    public Tool$Builder clearVersion() {
        copyOnWrite();
        u.G((u) this.instance);
        return this;
    }

    public boolean containsParameters(String str) {
        str.getClass();
        return ((u) this.instance).Y().containsKey(str);
    }

    public String getDescription() {
        return ((u) this.instance).S();
    }

    public ByteString getDescriptionBytes() {
        return ((u) this.instance).T();
    }

    public String getId() {
        return ((u) this.instance).U();
    }

    public ByteString getIdBytes() {
        return ((u) this.instance).V();
    }

    public String getName() {
        return ((u) this.instance).W();
    }

    public ByteString getNameBytes() {
        return ((u) this.instance).X();
    }

    @Deprecated
    public Map<String, String> getParameters() {
        return getParametersMap();
    }

    public int getParametersCount() {
        return ((u) this.instance).Y().size();
    }

    public Map<String, String> getParametersMap() {
        return Collections.unmodifiableMap(((u) this.instance).Y());
    }

    public String getParametersOrDefault(String str, String str2) {
        str.getClass();
        Map mapY = ((u) this.instance).Y();
        return mapY.containsKey(str) ? (String) mapY.get(str) : str2;
    }

    public String getParametersOrThrow(String str) {
        str.getClass();
        Map mapY = ((u) this.instance).Y();
        if (mapY.containsKey(str)) {
            return (String) mapY.get(str);
        }
        throw new IllegalArgumentException();
    }

    public String getVersion() {
        return ((u) this.instance).Z();
    }

    public ByteString getVersionBytes() {
        return ((u) this.instance).a0();
    }

    public Tool$Builder putAllParameters(Map<String, String> map) {
        copyOnWrite();
        u.H((u) this.instance).putAll(map);
        return this;
    }

    public Tool$Builder putParameters(String str, String str2) {
        str.getClass();
        str2.getClass();
        copyOnWrite();
        u.H((u) this.instance).put(str, str2);
        return this;
    }

    public Tool$Builder removeParameters(String str) {
        str.getClass();
        copyOnWrite();
        u.H((u) this.instance).remove(str);
        return this;
    }

    public Tool$Builder setDescription(String str) {
        copyOnWrite();
        u.I((u) this.instance, str);
        return this;
    }

    public Tool$Builder setDescriptionBytes(ByteString byteString) {
        copyOnWrite();
        u.J((u) this.instance, byteString);
        return this;
    }

    public Tool$Builder setId(String str) {
        copyOnWrite();
        u.K((u) this.instance, str);
        return this;
    }

    public Tool$Builder setIdBytes(ByteString byteString) {
        copyOnWrite();
        u.L((u) this.instance, byteString);
        return this;
    }

    public Tool$Builder setName(String str) {
        copyOnWrite();
        u.M((u) this.instance, str);
        return this;
    }

    public Tool$Builder setNameBytes(ByteString byteString) {
        copyOnWrite();
        u.N((u) this.instance, byteString);
        return this;
    }

    public Tool$Builder setVersion(String str) {
        copyOnWrite();
        u.O((u) this.instance, str);
        return this;
    }

    public Tool$Builder setVersionBytes(ByteString byteString) {
        copyOnWrite();
        u.P((u) this.instance, byteString);
        return this;
    }

    private Tool$Builder() {
        super(u.DEFAULT_INSTANCE);
    }
}
