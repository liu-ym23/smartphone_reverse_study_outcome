package com.zyql.protobuf.common;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import q7.f0;

/* loaded from: classes2.dex */
public final class UnregisterHookRequest$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ UnregisterHookRequest$Builder(int i) {
        this();
    }

    public UnregisterHookRequest$Builder clearHookId() {
        copyOnWrite();
        f0.D((f0) this.instance);
        return this;
    }

    public UnregisterHookRequest$Builder clearSessionId() {
        copyOnWrite();
        f0.E((f0) this.instance);
        return this;
    }

    public String getHookId() {
        return ((f0) this.instance).K();
    }

    public ByteString getHookIdBytes() {
        return ((f0) this.instance).L();
    }

    public String getSessionId() {
        return ((f0) this.instance).M();
    }

    public ByteString getSessionIdBytes() {
        return ((f0) this.instance).N();
    }

    public UnregisterHookRequest$Builder setHookId(String str) {
        copyOnWrite();
        f0.F((f0) this.instance, str);
        return this;
    }

    public UnregisterHookRequest$Builder setHookIdBytes(ByteString byteString) {
        copyOnWrite();
        f0.G((f0) this.instance, byteString);
        return this;
    }

    public UnregisterHookRequest$Builder setSessionId(String str) {
        copyOnWrite();
        f0.H((f0) this.instance, str);
        return this;
    }

    public UnregisterHookRequest$Builder setSessionIdBytes(ByteString byteString) {
        copyOnWrite();
        f0.I((f0) this.instance, byteString);
        return this;
    }

    private UnregisterHookRequest$Builder() {
        super(f0.DEFAULT_INSTANCE);
    }
}
