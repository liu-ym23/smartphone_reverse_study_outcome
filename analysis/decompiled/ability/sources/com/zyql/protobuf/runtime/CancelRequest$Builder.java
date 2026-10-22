package com.zyql.protobuf.runtime;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import u7.c;

/* loaded from: classes2.dex */
public final class CancelRequest$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ CancelRequest$Builder(int i) {
        this();
    }

    public CancelRequest$Builder clearReason() {
        copyOnWrite();
        c.D((c) this.instance);
        return this;
    }

    public CancelRequest$Builder clearSessionId() {
        copyOnWrite();
        c.E((c) this.instance);
        return this;
    }

    public String getReason() {
        return ((c) this.instance).L();
    }

    public ByteString getReasonBytes() {
        return ((c) this.instance).M();
    }

    public String getSessionId() {
        return ((c) this.instance).N();
    }

    public ByteString getSessionIdBytes() {
        return ((c) this.instance).O();
    }

    public CancelRequest$Builder setReason(String str) {
        copyOnWrite();
        c.F((c) this.instance, str);
        return this;
    }

    public CancelRequest$Builder setReasonBytes(ByteString byteString) {
        copyOnWrite();
        c.G((c) this.instance, byteString);
        return this;
    }

    public CancelRequest$Builder setSessionId(String str) {
        copyOnWrite();
        c.H((c) this.instance, str);
        return this;
    }

    public CancelRequest$Builder setSessionIdBytes(ByteString byteString) {
        copyOnWrite();
        c.I((c) this.instance, byteString);
        return this;
    }

    private CancelRequest$Builder() {
        super(c.DEFAULT_INSTANCE);
    }
}
