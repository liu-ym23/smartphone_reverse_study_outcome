package com.zyql.protobuf.agent;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import java.util.Collections;
import java.util.Map;
import o7.C1773i;

/* loaded from: classes2.dex */
public final class Error$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ Error$Builder(int i) {
        this();
    }

    public Error$Builder clearCode() {
        copyOnWrite();
        C1773i.D((C1773i) this.instance);
        return this;
    }

    public Error$Builder clearDetails() {
        copyOnWrite();
        C1773i.F((C1773i) this.instance).clear();
        return this;
    }

    public Error$Builder clearMessage() {
        copyOnWrite();
        C1773i.E((C1773i) this.instance);
        return this;
    }

    public boolean containsDetails(String str) {
        str.getClass();
        return ((C1773i) this.instance).O().containsKey(str);
    }

    public ErrorCode getCode() {
        return ((C1773i) this.instance).L();
    }

    public int getCodeValue() {
        return ((C1773i) this.instance).M();
    }

    @Deprecated
    public Map<String, String> getDetails() {
        return getDetailsMap();
    }

    public int getDetailsCount() {
        return ((C1773i) this.instance).O().size();
    }

    public Map<String, String> getDetailsMap() {
        return Collections.unmodifiableMap(((C1773i) this.instance).O());
    }

    public String getDetailsOrDefault(String str, String str2) {
        str.getClass();
        Map mapO = ((C1773i) this.instance).O();
        return mapO.containsKey(str) ? (String) mapO.get(str) : str2;
    }

    public String getDetailsOrThrow(String str) {
        str.getClass();
        Map mapO = ((C1773i) this.instance).O();
        if (mapO.containsKey(str)) {
            return (String) mapO.get(str);
        }
        throw new IllegalArgumentException();
    }

    public String getMessage() {
        return ((C1773i) this.instance).P();
    }

    public ByteString getMessageBytes() {
        return ((C1773i) this.instance).Q();
    }

    public Error$Builder putAllDetails(Map<String, String> map) {
        copyOnWrite();
        C1773i.F((C1773i) this.instance).putAll(map);
        return this;
    }

    public Error$Builder putDetails(String str, String str2) {
        str.getClass();
        str2.getClass();
        copyOnWrite();
        C1773i.F((C1773i) this.instance).put(str, str2);
        return this;
    }

    public Error$Builder removeDetails(String str) {
        str.getClass();
        copyOnWrite();
        C1773i.F((C1773i) this.instance).remove(str);
        return this;
    }

    public Error$Builder setCode(ErrorCode errorCode) {
        copyOnWrite();
        C1773i.G((C1773i) this.instance, errorCode);
        return this;
    }

    public Error$Builder setCodeValue(int i) {
        copyOnWrite();
        C1773i.H((C1773i) this.instance, i);
        return this;
    }

    public Error$Builder setMessage(String str) {
        copyOnWrite();
        C1773i.I((C1773i) this.instance, str);
        return this;
    }

    public Error$Builder setMessageBytes(ByteString byteString) {
        copyOnWrite();
        C1773i.J((C1773i) this.instance, byteString);
        return this;
    }

    private Error$Builder() {
        super(C1773i.DEFAULT_INSTANCE);
    }
}
