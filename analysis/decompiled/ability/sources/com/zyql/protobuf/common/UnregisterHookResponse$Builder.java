package com.zyql.protobuf.common;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import q7.g0;

/* loaded from: classes2.dex */
public final class UnregisterHookResponse$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ UnregisterHookResponse$Builder(int i) {
        this();
    }

    public UnregisterHookResponse$Builder clearError() {
        copyOnWrite();
        g0.D((g0) this.instance);
        return this;
    }

    public UnregisterHookResponse$Builder clearSuccess() {
        copyOnWrite();
        g0.E((g0) this.instance);
        return this;
    }

    public String getError() {
        return ((g0) this.instance).J();
    }

    public ByteString getErrorBytes() {
        return ((g0) this.instance).K();
    }

    public boolean getSuccess() {
        return ((g0) this.instance).L();
    }

    public UnregisterHookResponse$Builder setError(String str) {
        copyOnWrite();
        g0.F((g0) this.instance, str);
        return this;
    }

    public UnregisterHookResponse$Builder setErrorBytes(ByteString byteString) {
        copyOnWrite();
        g0.G((g0) this.instance, byteString);
        return this;
    }

    public UnregisterHookResponse$Builder setSuccess(boolean z10) {
        copyOnWrite();
        g0.H((g0) this.instance, z10);
        return this;
    }

    private UnregisterHookResponse$Builder() {
        super(g0.DEFAULT_INSTANCE);
    }
}
