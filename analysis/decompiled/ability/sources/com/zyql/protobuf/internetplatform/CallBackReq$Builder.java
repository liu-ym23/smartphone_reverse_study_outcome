package com.zyql.protobuf.internetplatform;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import s7.C1918a;

/* loaded from: classes2.dex */
public final class CallBackReq$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ CallBackReq$Builder(int i) {
        this();
    }

    public CallBackReq$Builder clearBody() {
        copyOnWrite();
        C1918a.D((C1918a) this.instance);
        return this;
    }

    public CallBackReq$Builder clearRequestId() {
        copyOnWrite();
        C1918a.E((C1918a) this.instance);
        return this;
    }

    public String getBody() {
        return ((C1918a) this.instance).K();
    }

    public ByteString getBodyBytes() {
        return ((C1918a) this.instance).L();
    }

    public String getRequestId() {
        return ((C1918a) this.instance).M();
    }

    public ByteString getRequestIdBytes() {
        return ((C1918a) this.instance).N();
    }

    public CallBackReq$Builder setBody(String str) {
        copyOnWrite();
        C1918a.F((C1918a) this.instance, str);
        return this;
    }

    public CallBackReq$Builder setBodyBytes(ByteString byteString) {
        copyOnWrite();
        C1918a.G((C1918a) this.instance, byteString);
        return this;
    }

    public CallBackReq$Builder setRequestId(String str) {
        copyOnWrite();
        C1918a.H((C1918a) this.instance, str);
        return this;
    }

    public CallBackReq$Builder setRequestIdBytes(ByteString byteString) {
        copyOnWrite();
        C1918a.I((C1918a) this.instance, byteString);
        return this;
    }

    private CallBackReq$Builder() {
        super(C1918a.DEFAULT_INSTANCE);
    }
}
