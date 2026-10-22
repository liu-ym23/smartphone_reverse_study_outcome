package com.zyql.protobuf.common;

import com.google.protobuf.ByteString;
import com.google.protobuf.C1014y2;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Struct;
import com.google.protobuf.Y1;
import q7.C1811i;

/* loaded from: classes2.dex */
public final class FunctionResponse$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ FunctionResponse$Builder(int i) {
        this();
    }

    public FunctionResponse$Builder clearId() {
        copyOnWrite();
        C1811i.D((C1811i) this.instance);
        return this;
    }

    public FunctionResponse$Builder clearName() {
        copyOnWrite();
        C1811i.E((C1811i) this.instance);
        return this;
    }

    public FunctionResponse$Builder clearResponse() {
        copyOnWrite();
        C1811i.F((C1811i) this.instance);
        return this;
    }

    public String getId() {
        return ((C1811i) this.instance).N();
    }

    public ByteString getIdBytes() {
        return ((C1811i) this.instance).O();
    }

    public String getName() {
        return ((C1811i) this.instance).P();
    }

    public ByteString getNameBytes() {
        return ((C1811i) this.instance).Q();
    }

    public Struct getResponse() {
        return ((C1811i) this.instance).R();
    }

    public boolean hasResponse() {
        return ((C1811i) this.instance).S();
    }

    public FunctionResponse$Builder mergeResponse(Struct struct) {
        copyOnWrite();
        C1811i c1811i = (C1811i) this.instance;
        int i = C1811i.ID_FIELD_NUMBER;
        c1811i.T(struct);
        return this;
    }

    public FunctionResponse$Builder setId(String str) {
        copyOnWrite();
        C1811i.G((C1811i) this.instance, str);
        return this;
    }

    public FunctionResponse$Builder setIdBytes(ByteString byteString) {
        copyOnWrite();
        C1811i.H((C1811i) this.instance, byteString);
        return this;
    }

    public FunctionResponse$Builder setName(String str) {
        copyOnWrite();
        C1811i.I((C1811i) this.instance, str);
        return this;
    }

    public FunctionResponse$Builder setNameBytes(ByteString byteString) {
        copyOnWrite();
        C1811i.J((C1811i) this.instance, byteString);
        return this;
    }

    public FunctionResponse$Builder setResponse(Struct struct) {
        copyOnWrite();
        C1811i.K((C1811i) this.instance, struct);
        return this;
    }

    private FunctionResponse$Builder() {
        super(C1811i.DEFAULT_INSTANCE);
    }

    public FunctionResponse$Builder setResponse(C1014y2 c1014y2) {
        copyOnWrite();
        C1811i.K((C1811i) this.instance, (Struct) c1014y2.k());
        return this;
    }
}
