package com.zyql.protobuf.runtime;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import u7.b;

/* loaded from: classes2.dex */
public final class CancelAck$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ CancelAck$Builder(int i) {
        this();
    }

    public CancelAck$Builder clearDetails() {
        copyOnWrite();
        b.D((b) this.instance);
        return this;
    }

    public String getDetails() {
        return ((b) this.instance).I();
    }

    public ByteString getDetailsBytes() {
        return ((b) this.instance).J();
    }

    public boolean hasDetails() {
        return ((b) this.instance).K();
    }

    public CancelAck$Builder setDetails(String str) {
        copyOnWrite();
        b.E((b) this.instance, str);
        return this;
    }

    public CancelAck$Builder setDetailsBytes(ByteString byteString) {
        copyOnWrite();
        b.F((b) this.instance, byteString);
        return this;
    }

    private CancelAck$Builder() {
        super(b.DEFAULT_INSTANCE);
    }
}
