package com.zyql.protobuf.skull;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import java.util.Collections;
import java.util.Map;
import v7.C2064c;
import v7.i;

/* loaded from: classes2.dex */
public final class AskInput$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ AskInput$Builder(int i) {
        this();
    }

    public AskInput$Builder clearMessage() {
        copyOnWrite();
        C2064c.D((C2064c) this.instance);
        return this;
    }

    public AskInput$Builder clearParams() {
        copyOnWrite();
        C2064c.E((C2064c) this.instance).clear();
        return this;
    }

    public boolean containsParams(String str) {
        str.getClass();
        return ((C2064c) this.instance).K().containsKey(str);
    }

    public i getMessage() {
        return ((C2064c) this.instance).J();
    }

    @Deprecated
    public Map<String, String> getParams() {
        return getParamsMap();
    }

    public int getParamsCount() {
        return ((C2064c) this.instance).K().size();
    }

    public Map<String, String> getParamsMap() {
        return Collections.unmodifiableMap(((C2064c) this.instance).K());
    }

    public String getParamsOrDefault(String str, String str2) {
        str.getClass();
        Map mapK = ((C2064c) this.instance).K();
        return mapK.containsKey(str) ? (String) mapK.get(str) : str2;
    }

    public String getParamsOrThrow(String str) {
        str.getClass();
        Map mapK = ((C2064c) this.instance).K();
        if (mapK.containsKey(str)) {
            return (String) mapK.get(str);
        }
        throw new IllegalArgumentException();
    }

    public boolean hasMessage() {
        return ((C2064c) this.instance).L();
    }

    public AskInput$Builder mergeMessage(i iVar) {
        copyOnWrite();
        C2064c.F((C2064c) this.instance, iVar);
        return this;
    }

    public AskInput$Builder putAllParams(Map<String, String> map) {
        copyOnWrite();
        C2064c.E((C2064c) this.instance).putAll(map);
        return this;
    }

    public AskInput$Builder putParams(String str, String str2) {
        str.getClass();
        str2.getClass();
        copyOnWrite();
        C2064c.E((C2064c) this.instance).put(str, str2);
        return this;
    }

    public AskInput$Builder removeParams(String str) {
        str.getClass();
        copyOnWrite();
        C2064c.E((C2064c) this.instance).remove(str);
        return this;
    }

    public AskInput$Builder setMessage(i iVar) {
        copyOnWrite();
        C2064c.G((C2064c) this.instance, iVar);
        return this;
    }

    private AskInput$Builder() {
        super(C2064c.DEFAULT_INSTANCE);
    }

    public AskInput$Builder setMessage(Message$Builder message$Builder) {
        copyOnWrite();
        C2064c.G((C2064c) this.instance, (i) message$Builder.k());
        return this;
    }
}
