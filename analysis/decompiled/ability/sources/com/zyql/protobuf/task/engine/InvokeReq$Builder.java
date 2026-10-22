package com.zyql.protobuf.task.engine;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import w7.C2105a;

/* loaded from: classes2.dex */
public final class InvokeReq$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ InvokeReq$Builder(int i) {
        this();
    }

    public InvokeReq$Builder clearBody() {
        copyOnWrite();
        C2105a.D((C2105a) this.instance);
        return this;
    }

    public InvokeReq$Builder clearCommand() {
        copyOnWrite();
        C2105a.E((C2105a) this.instance);
        return this;
    }

    public InvokeReq$Builder clearModule() {
        copyOnWrite();
        C2105a.F((C2105a) this.instance);
        return this;
    }

    public InvokeReq$Builder clearMsgId() {
        copyOnWrite();
        C2105a.G((C2105a) this.instance);
        return this;
    }

    public ByteString getBody() {
        return ((C2105a) this.instance).P();
    }

    public String getCommand() {
        return ((C2105a) this.instance).Q();
    }

    public ByteString getCommandBytes() {
        return ((C2105a) this.instance).R();
    }

    public String getModule() {
        return ((C2105a) this.instance).S();
    }

    public ByteString getModuleBytes() {
        return ((C2105a) this.instance).T();
    }

    public String getMsgId() {
        return ((C2105a) this.instance).U();
    }

    public ByteString getMsgIdBytes() {
        return ((C2105a) this.instance).V();
    }

    public InvokeReq$Builder setBody(ByteString byteString) {
        copyOnWrite();
        C2105a.H((C2105a) this.instance, byteString);
        return this;
    }

    public InvokeReq$Builder setCommand(String str) {
        copyOnWrite();
        C2105a.I((C2105a) this.instance, str);
        return this;
    }

    public InvokeReq$Builder setCommandBytes(ByteString byteString) {
        copyOnWrite();
        C2105a.J((C2105a) this.instance, byteString);
        return this;
    }

    public InvokeReq$Builder setModule(String str) {
        copyOnWrite();
        C2105a.K((C2105a) this.instance, str);
        return this;
    }

    public InvokeReq$Builder setModuleBytes(ByteString byteString) {
        copyOnWrite();
        C2105a.L((C2105a) this.instance, byteString);
        return this;
    }

    public InvokeReq$Builder setMsgId(String str) {
        copyOnWrite();
        C2105a.M((C2105a) this.instance, str);
        return this;
    }

    public InvokeReq$Builder setMsgIdBytes(ByteString byteString) {
        copyOnWrite();
        C2105a.N((C2105a) this.instance, byteString);
        return this;
    }

    private InvokeReq$Builder() {
        super(C2105a.DEFAULT_INSTANCE);
    }
}
