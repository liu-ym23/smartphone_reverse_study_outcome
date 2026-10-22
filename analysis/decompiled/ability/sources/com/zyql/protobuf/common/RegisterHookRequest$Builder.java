package com.zyql.protobuf.common;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import q7.C1816n;
import q7.H;

/* loaded from: classes2.dex */
public final class RegisterHookRequest$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ RegisterHookRequest$Builder(int i) {
        this();
    }

    public RegisterHookRequest$Builder clearHook() {
        copyOnWrite();
        H.D((H) this.instance);
        return this;
    }

    public RegisterHookRequest$Builder clearSessionId() {
        copyOnWrite();
        H.E((H) this.instance);
        return this;
    }

    public C1816n getHook() {
        return ((H) this.instance).K();
    }

    public String getSessionId() {
        return ((H) this.instance).L();
    }

    public ByteString getSessionIdBytes() {
        return ((H) this.instance).M();
    }

    public boolean hasHook() {
        return ((H) this.instance).N();
    }

    public RegisterHookRequest$Builder mergeHook(C1816n c1816n) {
        copyOnWrite();
        H.F((H) this.instance, c1816n);
        return this;
    }

    public RegisterHookRequest$Builder setHook(C1816n c1816n) {
        copyOnWrite();
        H.G((H) this.instance, c1816n);
        return this;
    }

    public RegisterHookRequest$Builder setSessionId(String str) {
        copyOnWrite();
        H.H((H) this.instance, str);
        return this;
    }

    public RegisterHookRequest$Builder setSessionIdBytes(ByteString byteString) {
        copyOnWrite();
        H.I((H) this.instance, byteString);
        return this;
    }

    private RegisterHookRequest$Builder() {
        super(H.DEFAULT_INSTANCE);
    }

    public RegisterHookRequest$Builder setHook(HookDefinition$Builder hookDefinition$Builder) {
        copyOnWrite();
        H.G((H) this.instance, (C1816n) hookDefinition$Builder.k());
        return this;
    }
}
