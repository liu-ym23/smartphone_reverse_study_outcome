package com.zyql.protobuf.common;

import com.google.protobuf.ByteString;
import com.google.protobuf.C1014y2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Struct;
import com.google.protobuf.Y1;
import q7.C1810h;

/* loaded from: classes2.dex */
public final class FunctionCall$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ FunctionCall$Builder(int i) {
        this();
    }

    public FunctionCall$Builder clearArgs() {
        copyOnWrite();
        C1810h.D((C1810h) this.instance);
        return this;
    }

    public FunctionCall$Builder clearId() {
        copyOnWrite();
        C1810h.E((C1810h) this.instance);
        return this;
    }

    public FunctionCall$Builder clearName() {
        copyOnWrite();
        C1810h.F((C1810h) this.instance);
        return this;
    }

    public Struct getArgs() {
        return ((C1810h) this.instance).M();
    }

    public String getId() {
        return ((C1810h) this.instance).O();
    }

    public ByteString getIdBytes() {
        return ((C1810h) this.instance).P();
    }

    public String getName() {
        return ((C1810h) this.instance).Q();
    }

    public ByteString getNameBytes() {
        return ((C1810h) this.instance).R();
    }

    public boolean hasArgs() {
        return ((C1810h) this.instance).S();
    }

    public FunctionCall$Builder mergeArgs(Struct struct) {
        copyOnWrite();
        C1810h c1810h = (C1810h) this.instance;
        int i = C1810h.ID_FIELD_NUMBER;
        c1810h.T(struct);
        return this;
    }

    public FunctionCall$Builder setArgs(Struct struct) {
        copyOnWrite();
        C1810h.G((C1810h) this.instance, struct);
        return this;
    }

    public FunctionCall$Builder setId(String str) {
        copyOnWrite();
        C1810h.H((C1810h) this.instance, str);
        return this;
    }

    public FunctionCall$Builder setIdBytes(ByteString byteString) {
        copyOnWrite();
        C1810h.I((C1810h) this.instance, byteString);
        return this;
    }

    public FunctionCall$Builder setName(String str) {
        copyOnWrite();
        C1810h.J((C1810h) this.instance, str);
        return this;
    }

    public FunctionCall$Builder setNameBytes(ByteString byteString) {
        copyOnWrite();
        C1810h.K((C1810h) this.instance, byteString);
        return this;
    }

    private FunctionCall$Builder() {
        super(C1810h.DEFAULT_INSTANCE);
    }

    public FunctionCall$Builder setArgs(C1014y2 c1014y2) {
        copyOnWrite();
        C1810h.G((C1810h) this.instance, (Struct) c1014y2.k());
        return this;
    }
}
