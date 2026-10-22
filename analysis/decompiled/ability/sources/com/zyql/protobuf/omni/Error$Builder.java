package com.zyql.protobuf.omni;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import t7.i;

/* loaded from: classes2.dex */
public final class Error$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ Error$Builder(int i) {
        this();
    }

    public Error$Builder clearErrorCode() {
        copyOnWrite();
        i.D((i) this.instance);
        return this;
    }

    public Error$Builder clearErrorMsg() {
        copyOnWrite();
        i.E((i) this.instance);
        return this;
    }

    public long getErrorCode() {
        return ((i) this.instance).K();
    }

    public String getErrorMsg() {
        return ((i) this.instance).L();
    }

    public ByteString getErrorMsgBytes() {
        return ((i) this.instance).M();
    }

    public Error$Builder setErrorCode(long j5) {
        copyOnWrite();
        i.F((i) this.instance, j5);
        return this;
    }

    public Error$Builder setErrorMsg(String str) {
        copyOnWrite();
        i.G((i) this.instance, str);
        return this;
    }

    public Error$Builder setErrorMsgBytes(ByteString byteString) {
        copyOnWrite();
        i.H((i) this.instance, byteString);
        return this;
    }

    private Error$Builder() {
        super(i.DEFAULT_INSTANCE);
    }
}
