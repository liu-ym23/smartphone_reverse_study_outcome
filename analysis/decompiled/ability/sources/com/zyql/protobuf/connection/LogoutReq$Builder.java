package com.zyql.protobuf.connection;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import java.util.Collections;
import java.util.Map;
import r7.j;

/* loaded from: classes2.dex */
public final class LogoutReq$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ LogoutReq$Builder(int i) {
        this();
    }

    public LogoutReq$Builder clearReserved() {
        copyOnWrite();
        j.D((j) this.instance).clear();
        return this;
    }

    public boolean containsReserved(String str) {
        str.getClass();
        return ((j) this.instance).F().containsKey(str);
    }

    @Deprecated
    public Map<String, String> getReserved() {
        return getReservedMap();
    }

    public int getReservedCount() {
        return ((j) this.instance).F().size();
    }

    public Map<String, String> getReservedMap() {
        return Collections.unmodifiableMap(((j) this.instance).F());
    }

    public String getReservedOrDefault(String str, String str2) {
        str.getClass();
        Map mapF = ((j) this.instance).F();
        return mapF.containsKey(str) ? (String) mapF.get(str) : str2;
    }

    public String getReservedOrThrow(String str) {
        str.getClass();
        Map mapF = ((j) this.instance).F();
        if (mapF.containsKey(str)) {
            return (String) mapF.get(str);
        }
        throw new IllegalArgumentException();
    }

    public LogoutReq$Builder putAllReserved(Map<String, String> map) {
        copyOnWrite();
        j.D((j) this.instance).putAll(map);
        return this;
    }

    public LogoutReq$Builder putReserved(String str, String str2) {
        str.getClass();
        str2.getClass();
        copyOnWrite();
        j.D((j) this.instance).put(str, str2);
        return this;
    }

    public LogoutReq$Builder removeReserved(String str) {
        str.getClass();
        copyOnWrite();
        j.D((j) this.instance).remove(str);
        return this;
    }

    private LogoutReq$Builder() {
        super(j.DEFAULT_INSTANCE);
    }
}
