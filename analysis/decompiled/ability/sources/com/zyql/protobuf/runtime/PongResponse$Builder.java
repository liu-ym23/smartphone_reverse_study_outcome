package com.zyql.protobuf.runtime;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import u7.l;

/* loaded from: classes2.dex */
public final class PongResponse$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ PongResponse$Builder(int i) {
        this();
    }

    public PongResponse$Builder clearTimestamp() {
        copyOnWrite();
        l.D((l) this.instance);
        return this;
    }

    public PongResponse$Builder clearVersion() {
        copyOnWrite();
        l.E((l) this.instance);
        return this;
    }

    public long getTimestamp() {
        return ((l) this.instance).J();
    }

    public String getVersion() {
        return ((l) this.instance).K();
    }

    public ByteString getVersionBytes() {
        return ((l) this.instance).L();
    }

    public PongResponse$Builder setTimestamp(long j5) {
        copyOnWrite();
        l.F((l) this.instance, j5);
        return this;
    }

    public PongResponse$Builder setVersion(String str) {
        copyOnWrite();
        l.G((l) this.instance, str);
        return this;
    }

    public PongResponse$Builder setVersionBytes(ByteString byteString) {
        copyOnWrite();
        l.H((l) this.instance, byteString);
        return this;
    }

    private PongResponse$Builder() {
        super(l.DEFAULT_INSTANCE);
    }
}
