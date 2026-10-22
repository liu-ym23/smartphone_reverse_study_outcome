package com.zyql.protobuf.runtime;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Y1;
import u7.k;

/* loaded from: classes2.dex */
public final class PingRequest$Builder extends GeneratedMessageLite.Builder implements Y1 {
    public /* synthetic */ PingRequest$Builder(int i) {
        this();
    }

    public PingRequest$Builder clearTimestamp() {
        copyOnWrite();
        k.D((k) this.instance);
        return this;
    }

    public long getTimestamp() {
        return ((k) this.instance).G();
    }

    public PingRequest$Builder setTimestamp(long j5) {
        copyOnWrite();
        k.E((k) this.instance, j5);
        return this;
    }

    private PingRequest$Builder() {
        super(k.DEFAULT_INSTANCE);
    }
}
