package com.zyql.protobuf.connection;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import r7.d;

/* loaded from: classes2.dex */
public final class ErrorResp$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ ErrorResp$Builder(int i) {
        this();
    }

    public ErrorResp$Builder clearCode() {
        copyOnWrite();
        d.D((d) this.instance);
        return this;
    }

    public ErrorResp$Builder clearReason() {
        copyOnWrite();
        d.E((d) this.instance);
        return this;
    }

    public int getCode() {
        return ((d) this.instance).J();
    }

    public String getReason() {
        return ((d) this.instance).K();
    }

    public ByteString getReasonBytes() {
        return ((d) this.instance).L();
    }

    public ErrorResp$Builder setCode(int i) {
        copyOnWrite();
        d.F((d) this.instance, i);
        return this;
    }

    public ErrorResp$Builder setReason(String str) {
        copyOnWrite();
        d.G((d) this.instance, str);
        return this;
    }

    public ErrorResp$Builder setReasonBytes(ByteString byteString) {
        copyOnWrite();
        d.H((d) this.instance, byteString);
        return this;
    }

    private ErrorResp$Builder() {
        super(d.DEFAULT_INSTANCE);
    }
}
