package com.zyql.protobuf.common;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import q7.I;

/* loaded from: classes2.dex */
public final class RegisterHookResponse$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ RegisterHookResponse$Builder(int i) {
        this();
    }

    public RegisterHookResponse$Builder clearError() {
        copyOnWrite();
        I.D((I) this.instance);
        return this;
    }

    public RegisterHookResponse$Builder clearHookId() {
        copyOnWrite();
        I.E((I) this.instance);
        return this;
    }

    public RegisterHookResponse$Builder clearSuccess() {
        copyOnWrite();
        I.F((I) this.instance);
        return this;
    }

    public String getError() {
        return ((I) this.instance).M();
    }

    public ByteString getErrorBytes() {
        return ((I) this.instance).N();
    }

    public String getHookId() {
        return ((I) this.instance).O();
    }

    public ByteString getHookIdBytes() {
        return ((I) this.instance).P();
    }

    public boolean getSuccess() {
        return ((I) this.instance).Q();
    }

    public RegisterHookResponse$Builder setError(String str) {
        copyOnWrite();
        I.G((I) this.instance, str);
        return this;
    }

    public RegisterHookResponse$Builder setErrorBytes(ByteString byteString) {
        copyOnWrite();
        I.H((I) this.instance, byteString);
        return this;
    }

    public RegisterHookResponse$Builder setHookId(String str) {
        copyOnWrite();
        I.I((I) this.instance, str);
        return this;
    }

    public RegisterHookResponse$Builder setHookIdBytes(ByteString byteString) {
        copyOnWrite();
        I.J((I) this.instance, byteString);
        return this;
    }

    public RegisterHookResponse$Builder setSuccess(boolean z10) {
        copyOnWrite();
        I.K((I) this.instance, z10);
        return this;
    }

    private RegisterHookResponse$Builder() {
        super(I.DEFAULT_INSTANCE);
    }
}
